package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the tenant-level credential endpoints under
 * {@code /api/v1/{tenant}/credentials/**}. Credentials require the {@code CREDENTIAL}
 * resource (an EE feature); on a CI image without it the resource is gated (403), so the
 * read-only tests accept either the real payload or that gate.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CredentialsApiTest {

    static CredentialsApi api() {
        return client().credentials();
    }

    @Test
    void listCredentials_isPagedOrGated() throws ApiException {
        try {
            Map<String, Object> result = api().listCredentials(TENANT, 1, 10, null, null);
            assertThat(result).containsKey("results");
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(403, 404);
        }
    }

    @Test
    void getCredential_unknownId_throws() {
        assertThatThrownBy(() -> api().getCredential(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isIn(403, 404));
    }
}
