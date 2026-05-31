package main

import (
	"context"
	"os/exec"
	"testing"
	"time"

	absauth "github.com/microsoft/kiota-abstractions-go/authentication"
	khttp "github.com/microsoft/kiota-http-go"

	primitives "github.com/dotnicht/kiota-tests/service-primitives"
	primmodels "github.com/dotnicht/kiota-tests/service-primitives/models"
)

// Compile-time assertions: required non-nullable fields must be value types, not pointers.
// If the kiota fix regresses, these will fail to compile.
var _ string = (primmodels.NewPrimitives()).GetRequiredNonNullableString()
var _ bool = (primmodels.NewPrimitives()).GetRequiredNonNullableBool()
var _ int32 = (primmodels.NewPrimitives()).GetRequiredNonNullableInt()
var _ int64 = (primmodels.NewPrimitives()).GetRequiredNonNullableInt64()
var _ float32 = (primmodels.NewPrimitives()).GetRequiredNonNullableFloat()
var _ float64 = (primmodels.NewPrimitives()).GetRequiredNonNullableDouble()

// Compile-time assertions: required nullable fields must be pointer types.
var _ *string = (primmodels.NewPrimitives()).GetRequiredNullableString()
var _ *bool = (primmodels.NewPrimitives()).GetRequiredNullableBool()
var _ *int32 = (primmodels.NewPrimitives()).GetRequiredNullableInt()

func TestPrimitivesNullability(t *testing.T) {
	cmd := exec.Command("/Users/m.postoiko/kiota-nullability-fix/rust-test-services/target/debug/service-primitives")
	cmd.Env = []string{"PORT=8080"}
	if err := cmd.Start(); err != nil {
		t.Fatalf("start service-primitives: %v", err)
	}
	defer cmd.Process.Kill()
	time.Sleep(500 * time.Millisecond)

	auth := &absauth.AnonymousAuthenticationProvider{}
	adapter, err := khttp.NewNetHttpRequestAdapter(auth)
	if err != nil {
		t.Fatalf("create adapter: %v", err)
	}
	adapter.SetBaseUrl("http://localhost:8080")

	client := primitives.NewApiClient(adapter)
	result, err := client.Model().Get(context.Background(), nil)
	if err != nil {
		t.Fatalf("GET /model: %v", err)
	}
	if result == nil {
		t.Fatal("expected non-nil result")
	}

	// Value types: required non-nullable fields — no nil check needed, they are value types.
	t.Logf("required_non_nullable_string = %q", result.GetRequiredNonNullableString())
	t.Logf("required_non_nullable_bool = %v", result.GetRequiredNonNullableBool())
	t.Logf("required_non_nullable_int = %v", result.GetRequiredNonNullableInt())

	// Pointer types: required nullable fields — may legitimately be nil or set.
	t.Logf("required_nullable_string = %v", result.GetRequiredNullableString())
}
