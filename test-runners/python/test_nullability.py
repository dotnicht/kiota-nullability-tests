"""
Kiota nullability fix — Python test runner.

Verifies that the generator emits correct Python type annotations:
  - required + non-nullable  →  plain type (e.g. str, not Optional[str])
  - required + nullable      →  Optional[type]
  - optional fields          →  Optional[type]

Also verifies runtime values returned by each service's GET /model endpoint.
"""
from __future__ import annotations

import asyncio
import dataclasses
import importlib
import importlib.machinery
import importlib.util
import os
import subprocess
import sys
import time
import typing
from pathlib import Path
from typing import Optional

import httpx
import pytest

GENERATED = Path(__file__).parent / "generated"
BINDIR = Path.home() / "kiota-nullability-fix" / "rust-test-services" / "target" / "debug"
BASE_URL = "http://localhost:8080"


def _start(svc: str) -> subprocess.Popen:
    proc = subprocess.Popen(
        [str(BINDIR / svc)],
        env={**os.environ, "PORT": "8080"},
        stdout=subprocess.DEVNULL,
        stderr=subprocess.DEVNULL,
    )
    time.sleep(1)
    return proc


def _stop(proc: subprocess.Popen) -> None:
    proc.terminate()
    try:
        proc.wait(timeout=3)
    except subprocess.TimeoutExpired:
        proc.kill()


def _register_package(svc: str, alias: str) -> None:
    """Register the generated service directory as a Python package under `alias`.

    The generated dirs contain hyphens (invalid Python identifiers), so we
    register them manually via importlib under a valid alias name.
    All sub-modules are registered under `alias.*` so relative imports work.
    """
    svc_dir = GENERATED / svc
    if alias in sys.modules:
        return

    def _register(rel: str, search_locations: list[str] | None = None) -> None:
        full_name = f"{alias}.{rel}" if rel else alias
        if full_name in sys.modules:
            return
        if rel:
            parts = rel.replace(".", os.sep)
            init = svc_dir / parts / "__init__.py"
            py = svc_dir / f"{parts}.py"
            path = init if init.exists() else py
        else:
            path = svc_dir / "__init__.py"

        loader = importlib.machinery.SourceFileLoader(full_name, str(path))
        spec = importlib.util.spec_from_loader(full_name, loader, origin=str(path))
        assert spec is not None
        if search_locations is not None:
            spec.submodule_search_locations = search_locations
        elif (svc_dir / (rel.replace(".", os.sep) if rel else "")).is_dir():
            spec.submodule_search_locations = [
                str(svc_dir / (rel.replace(".", os.sep) if rel else ""))
            ]
        mod = importlib.util.module_from_spec(spec)
        parent_pkg = full_name.rsplit(".", 1)[0] if "." in full_name else ""
        mod.__package__ = parent_pkg or alias
        sys.modules[full_name] = mod
        loader.exec_module(mod)

    # Register the root package
    _register("", search_locations=[str(svc_dir)])

    # Register all subdirectory packages and .py modules found
    for item in sorted(svc_dir.rglob("*.py")):
        if item.name == "__init__.py":
            rel_dir = item.parent.relative_to(svc_dir)
            rel_pkg = str(rel_dir).replace(os.sep, ".")
            if rel_pkg and rel_pkg != ".":
                _register(rel_pkg)
        else:
            rel_dir = item.parent.relative_to(svc_dir)
            rel_mod_dir = str(rel_dir).replace(os.sep, ".").lstrip(".")
            stem = item.stem
            rel_mod = f"{rel_mod_dir}.{stem}" if rel_mod_dir else stem
            _register(rel_mod)


def _adapter(base_url: str = BASE_URL) -> "HttpxRequestAdapter":
    from kiota_abstractions.authentication.anonymous_authentication_provider import (
        AnonymousAuthenticationProvider,
    )
    from kiota_http.httpx_request_adapter import HttpxRequestAdapter
    from kiota_http.kiota_client_factory import KiotaClientFactory

    http_client = KiotaClientFactory.create_with_default_middleware(
        client=httpx.AsyncClient(base_url=base_url)
    )
    return HttpxRequestAdapter(
        authentication_provider=AnonymousAuthenticationProvider(),
        http_client=http_client,
    )


# ---------------------------------------------------------------------------
# service-primitives
# ---------------------------------------------------------------------------

class TestPrimitives:
    """Tests for service-primitives."""

    def test_type_annotations(self) -> None:
        """required non-nullable → plain type; required nullable → Optional."""
        alias = "svc_primitives"
        _register_package("service-primitives", alias)
        Primitives = sys.modules[f"{alias}.models.primitives"].Primitives
        hints = typing.get_type_hints(Primitives)

        # required, non-nullable → plain str (no Optional wrapper)
        assert hints["required_non_nullable_string"] is str, (
            f"expected str, got {hints['required_non_nullable_string']}"
        )
        assert hints["required_non_nullable_int"] is int
        assert hints["required_non_nullable_bool"] is bool

        # required, nullable → Optional[str] i.e. str | None
        rns = hints["required_nullable_string"]
        assert rns == Optional[str], f"expected Optional[str], got {rns}"

        # optional fields are Optional regardless of nullable flag
        assert hints["optional_non_nullable_string"] == Optional[str]
        assert hints["optional_nullable_string"] == Optional[str]

    @pytest.mark.asyncio
    async def test_runtime_values(self) -> None:
        """GET /model returns correct values stored on the model."""
        alias = "svc_primitives"
        _register_package("service-primitives", alias)

        proc = _start("service-primitives")
        adapter = _adapter()
        try:
            Client = sys.modules[f"{alias}.uservice_uprimitives_client"].UserviceUprimitivesClient
            client = Client(adapter)
            model = await client.model.get()
            assert model is not None, "response was None"

            assert model.required_non_nullable_string == "hello"
            assert model.required_non_nullable_int == 42
            assert model.required_non_nullable_bool is True
            assert model.required_nullable_string == "world"
            assert model.optional_nullable_string is None
            assert isinstance(model.required_non_nullable_string, str)
        finally:
            _stop(proc)
            await adapter._http_client.aclose()


# ---------------------------------------------------------------------------
# service-enums
# ---------------------------------------------------------------------------

class TestEnums:
    """Tests for service-enums."""

    def test_type_annotations(self) -> None:
        alias = "svc_enums"
        _register_package("service-enums", alias)
        EnumContainer = sys.modules[f"{alias}.models.enum_container"].EnumContainer

        fields = {f.name: f.type for f in dataclasses.fields(EnumContainer)}

        # required + non-nullable enum → plain type name
        assert fields["required_non_nullable_status"] == "Status", (
            f"expected 'Status', got {fields['required_non_nullable_status']!r}"
        )
        assert fields["code"] == "Code"
        assert fields["statuses"] == "list[Status]"

        # required + nullable enum → Optional
        assert fields["required_nullable_status"] == "Optional[Status]", (
            f"expected 'Optional[Status]', got {fields['required_nullable_status']!r}"
        )

        # optional fields → Optional
        assert fields["optional_non_nullable_priority"] == "Optional[Priority]"
        assert fields["optional_nullable_priority"] == "Optional[Priority]"

    @pytest.mark.asyncio
    async def test_runtime_values(self) -> None:
        alias = "svc_enums"
        _register_package("service-enums", alias)

        proc = _start("service-enums")
        adapter = _adapter()
        try:
            Client = sys.modules[f"{alias}.service_enums_client"].ServiceEnumsClient
            client = Client(adapter)
            model = await client.model.get()
            assert model is not None

            Status = sys.modules[f"{alias}.models.status"].Status
            Priority = sys.modules[f"{alias}.models.priority"].Priority

            assert model.required_non_nullable_status == Status.Active
            assert model.required_nullable_status == Status.Inactive
            assert model.optional_non_nullable_priority == Priority.HIGH
            assert model.optional_nullable_priority is None
        finally:
            _stop(proc)
            await adapter._http_client.aclose()


# ---------------------------------------------------------------------------
# service-objects
# ---------------------------------------------------------------------------

class TestObjects:
    """Tests for service-objects."""

    def test_type_annotations(self) -> None:
        alias = "svc_objects"
        _register_package("service-objects", alias)
        Container = sys.modules[f"{alias}.models.container"].Container

        fields = {f.name: f.type for f in dataclasses.fields(Container)}

        # required + non-nullable object → plain type
        assert fields["required_non_nullable_address"] == "Address", (
            f"expected 'Address', got {fields['required_non_nullable_address']!r}"
        )
        assert fields["required_non_nullable_tags"] == "list[Tag]"

        # required + nullable object → Optional
        assert fields["required_nullable_address"] == "Optional[Address]", (
            f"expected 'Optional[Address]', got {fields['required_nullable_address']!r}"
        )

        # optional → Optional
        assert fields["optional_nullable_address"] == "Optional[Address]"
        assert fields["optional_nullable_tags"] == "Optional[list[Tag]]"

    @pytest.mark.asyncio
    async def test_runtime_values(self) -> None:
        alias = "svc_objects"
        _register_package("service-objects", alias)

        proc = _start("service-objects")
        adapter = _adapter()
        try:
            Client = sys.modules[f"{alias}.uservice_uobjects_client"].UserviceUobjectsClient
            client = Client(adapter)
            model = await client.container.get()
            assert model is not None

            assert model.required_non_nullable_address is not None
            assert model.required_non_nullable_address.street == "123 Main St"
            assert model.required_non_nullable_address.city == "Springfield"

            assert model.required_nullable_address is not None
            assert model.required_nullable_address.street == "456 Elm St"

            assert model.optional_nullable_address is None
            assert model.optional_nullable_tags is None
        finally:
            _stop(proc)
            await adapter._http_client.aclose()
