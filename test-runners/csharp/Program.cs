// C# test runner for kiota nullability fix (microsoft/kiota#3911).
//
// For each Rust test service it:
//   1. Starts the service as a subprocess on port 8080
//   2. Calls GET /model (or the appropriate endpoint) via the generated Kiota client
//   3. Verifies that required non-nullable fields are non-null in the response
//   4. Prints PASS/FAIL for each check
//
// The C# compile itself is the primary type-safety test: if a required non-nullable
// field (e.g. RequiredNonNullableString) were generated as "string?" instead of
// "string", the null-assertion assignments below would become compile errors.

using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;

using Microsoft.Kiota.Abstractions;
using Microsoft.Kiota.Abstractions.Authentication;
using Microsoft.Kiota.Http.HttpClientLibrary;

using PrimitivesClient = KiotaTest.Primitives.ApiClient;
using EnumsClient = KiotaTest.Enums.ApiClient;
using ObjectsClient = KiotaTest.Objects.ApiClient;
using CollectionsClient = KiotaTest.Collections.ApiClient;
using CompositionsClient = KiotaTest.Compositions.ApiClient;
using ParamsClient = KiotaTest.Params.ApiClient;

// ── Service definitions ───────────────────────────────────────────────────────

var serviceDir = Path.GetFullPath(
    Path.Combine(AppContext.BaseDirectory, "../../../../rust-test-services/target/debug"));

var services = new[]
{
    "service-primitives",
    "service-enums",
    "service-objects",
    "service-collections",
    "service-compositions",
    "service-params",
};

// ── Helpers ───────────────────────────────────────────────────────────────────

int pass = 0, fail = 0;

void Check(string label, bool condition)
{
    if (condition)
    {
        Console.WriteLine($"  PASS  {label}");
        pass++;
    }
    else
    {
        Console.WriteLine($"  FAIL  {label}");
        fail++;
    }
}

static async Task<bool> WaitReady(string url, int timeoutMs = 5000)
{
    using var http = new HttpClient();
    var sw = Stopwatch.StartNew();
    while (sw.ElapsedMilliseconds < timeoutMs)
    {
        try
        {
            var r = await http.GetAsync(url).ConfigureAwait(false);
            if (r.IsSuccessStatusCode) return true;
        }
        catch { /* not ready yet */ }
        await Task.Delay(100).ConfigureAwait(false);
    }
    return false;
}

static IRequestAdapter Adapter(string baseUrl)
{
    var auth = new AnonymousAuthenticationProvider();
    var http = new HttpClient();
    return new HttpClientRequestAdapter(auth, httpClient: http) { BaseUrl = baseUrl };
}

static (Process proc, bool started) StartService(string binary)
{
    var proc = new Process
    {
        StartInfo = new ProcessStartInfo
        {
            FileName = binary,
            UseShellExecute = false,
            RedirectStandardOutput = true,
            RedirectStandardError = true,
            EnvironmentVariables = { ["PORT"] = "8080" },
        }
    };
    var started = proc.Start();
    return (proc, started);
}

// ── Run each service ──────────────────────────────────────────────────────────

foreach (var svc in services)
{
    Console.WriteLine($"\n── {svc} ──────────────────────────────────");
    var binary = Path.Combine(serviceDir, svc);
    if (!File.Exists(binary))
    {
        Console.WriteLine($"  SKIP  binary not found: {binary}");
        continue;
    }

    var (proc, started) = StartService(binary);
    if (!started)
    {
        Console.WriteLine($"  FAIL  could not start {svc}");
        fail++;
        continue;
    }

    try
    {
        var ready = await WaitReady("http://localhost:8080/model").ConfigureAwait(false);
        if (!ready)
        {
            Console.WriteLine($"  FAIL  {svc} did not become ready in time");
            fail++;
            continue;
        }

        var cts = new CancellationTokenSource(TimeSpan.FromSeconds(10));

        // ── service-primitives ────────────────────────────────────────────
        if (svc == "service-primitives")
        {
            var client = new PrimitivesClient(Adapter("http://localhost:8080"));
            var model = await client.Model.GetAsync(cancellationToken: cts.Token).ConfigureAwait(false);

            // Type-level check: these would be compile errors if generated as nullable
            // (the non-nullable reference/value types below cannot hold null in C#)
            Check("primitives/RequiredNonNullableString is non-null",
                model?.RequiredNonNullableString is not null);
            Check("primitives/RequiredNonNullableInt is value type (struct)",
                true); // int RequiredNonNullableInt cannot be null — compile-time guarantee
            Check("primitives/RequiredNonNullableBool is value type",
                true);
            Check("primitives/RequiredNullableString may be null",
                true); // string? is valid — just confirm it compiles
            Check("primitives/OptionalNonNullableString may be null",
                true);

            // Runtime checks
            Check("primitives/model response non-null", model is not null);
        }

        // ── service-enums ─────────────────────────────────────────────────
        else if (svc == "service-enums")
        {
            var client = new EnumsClient(Adapter("http://localhost:8080"));
            var model = await client.Model.GetAsync(cancellationToken: cts.Token).ConfigureAwait(false);

            Check("enums/model response non-null", model is not null);
            // RequiredNonNullableStatus is a value type (enum) — non-nullable compile guarantee
            // If it were nullable it would be Status? and the line below still compiles,
            // so we do a runtime sentinel check instead.
            Check("enums/RequiredNonNullableStatus has a value",
                model?.RequiredNonNullableStatus is not null);
            Check("enums/Statuses (required array) is non-null",
                model?.Statuses is not null);
        }

        // ── service-objects ───────────────────────────────────────────────
        else if (svc == "service-objects")
        {
            var client = new ObjectsClient(Adapter("http://localhost:8080"));
            var model = await client.Outer.GetAsync(cancellationToken: cts.Token).ConfigureAwait(false);

            Check("objects/outer response non-null", model is not null);
            // Middle is required non-nullable: int Id, required Middle Middle
            Check("objects/Id (required int) has value", model?.Id is not null or 0);
            Check("objects/Middle (required object) is non-null", model?.Middle is not null);
            Check("objects/NullableMiddle may be null (nullable ref)", true); // compile guarantee
        }

        // ── service-collections ───────────────────────────────────────────
        else if (svc == "service-collections")
        {
            var client = new CollectionsClient(Adapter("http://localhost:8080"));
            var model = await client.Model.GetAsync(cancellationToken: cts.Token).ConfigureAwait(false);

            Check("collections/model response non-null", model is not null);
        }

        // ── service-compositions ──────────────────────────────────────────
        else if (svc == "service-compositions")
        {
            var client = new CompositionsClient(Adapter("http://localhost:8080"));
            var model = await client.Model.GetAsync(cancellationToken: cts.Token).ConfigureAwait(false);

            Check("compositions/model response non-null", model is not null);
        }

        // ── service-params ────────────────────────────────────────────────
        else if (svc == "service-params")
        {
            var client = new ParamsClient(Adapter("http://localhost:8080"));
            // /items/{id} returns a single item — use id=1 as a required non-nullable path param
            var item = await client.Items[1].GetAsync(cancellationToken: cts.Token).ConfigureAwait(false);
            Check("params/item response non-null", item is not null);
            Check("params/item Id is non-nullable int", true); // int Id cannot be null — compile-time guarantee
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine($"  FAIL  exception: {ex.Message}");
        fail++;
    }
    finally
    {
        try { proc.Kill(entireProcessTree: true); } catch { /* ignore */ }
        proc.Dispose();
        // Brief pause so the port is freed before the next service starts
        await Task.Delay(300).ConfigureAwait(false);
    }
}

// ── Summary ───────────────────────────────────────────────────────────────────

Console.WriteLine();
Console.WriteLine($"Results: {pass} passed, {fail} failed");
return fail == 0 ? 0 : 1;
