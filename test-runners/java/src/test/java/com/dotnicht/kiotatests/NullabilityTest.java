package com.dotnicht.kiotatests;

import com.dotnicht.kiotatests.serviceprimitives.ServicePrimitivesClient;
import com.dotnicht.kiotatests.serviceprimitives.models.Primitives;
import com.microsoft.kiota.authentication.AnonymousAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class NullabilityTest {

    private Process svc;

    @BeforeEach
    void start() throws IOException, InterruptedException {
        svc = new ProcessBuilder(
            "/Users/m.postoiko/kiota-nullability-fix/rust-test-services/target/debug/service-primitives"
        )
        .environment().entrySet().stream()
        .reduce(
            new ProcessBuilder("/Users/m.postoiko/kiota-nullability-fix/rust-test-services/target/debug/service-primitives"),
            (pb, e) -> pb,
            (a, b) -> a
        )
        .redirectErrorStream(true)
        .start();
        // simpler: use runtime
        svc.destroyForcibly();

        ProcessBuilder pb = new ProcessBuilder(
            "/Users/m.postoiko/kiota-nullability-fix/rust-test-services/target/debug/service-primitives"
        );
        pb.environment().put("PORT", "8080");
        svc = pb.start();
        Thread.sleep(600);
    }

    @AfterEach
    void stop() {
        if (svc != null) {
            svc.destroyForcibly();
        }
    }

    @Test
    void requiredNonNullableFieldsHaveNonnullAnnotation() throws Exception {
        var auth = new AnonymousAuthenticationProvider();
        var adapter = new OkHttpRequestAdapter(auth);
        adapter.setBaseUrl("http://localhost:8080");

        var client = new ServicePrimitivesClient(adapter);
        Primitives result = client.model().get();

        assertNotNull(result, "GET /model returned null");

        // Assert required non-nullable string is non-null
        String s = result.getRequiredNonNullableString();
        assertNotNull(s, "required_non_nullable_string should not be null");

        // Assert required nullable string getter has @Nullable annotation
        Method getNonNull = Primitives.class.getMethod("getRequiredNonNullableString");
        assertNotNull(getNonNull.getAnnotation(jakarta.annotation.Nonnull.class),
            "getRequiredNonNullableString should be @Nonnull");

        // Assert required nullable string getter has @Nullable annotation
        Method getNullable = Primitives.class.getMethod("getRequiredNullableString");
        assertNotNull(getNullable.getAnnotation(jakarta.annotation.Nullable.class),
            "getRequiredNullableString should be @Nullable");

        // Check a few more required non-nullable fields
        Method getBool = Primitives.class.getMethod("getRequiredNonNullableBool");
        assertNotNull(getBool.getAnnotation(jakarta.annotation.Nonnull.class),
            "getRequiredNonNullableBool should be @Nonnull");

        Method getInt = Primitives.class.getMethod("getRequiredNonNullableInt");
        assertNotNull(getInt.getAnnotation(jakarta.annotation.Nonnull.class),
            "getRequiredNonNullableInt should be @Nonnull");
    }
}
