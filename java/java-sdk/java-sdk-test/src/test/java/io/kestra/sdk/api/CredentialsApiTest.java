package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the tenant-level credential endpoints under
 * {@code /api/v1/{tenant}/credentials/**}. The CI image licenses the {@code CREDENTIAL}
 * resource, so the list returns a real paged envelope.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CredentialsApiTest {

    static CredentialsApi api() {
        return client().credentials();
    }

    @Test
    void listCredentials_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().listCredentials(TENANT, 1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void getCredential_unknownId_isNotFound() {
        // A correctly-routed endpoint answers 404 for an unknown id; a mis-routed path
        // would instead hit the EE catch-all 403 — so asserting exactly 404 guards the
        // binding, not just that *some* error is thrown.
        assertThatThrownBy(() -> api().getCredential(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }
}
