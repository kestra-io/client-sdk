package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the security-integration (SCIM) endpoints under
 * {@code /api/v1/{tenant}/security-integrations/**}. The CI image licenses
 * {@code FEATURE_SCIM}, so the search returns a real paged envelope.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecurityIntegrationsApiTest {

    static SecurityIntegrationsApi api() {
        return client().securityIntegrations();
    }

    @Test
    void searchSecurityIntegrations_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().searchSecurityIntegrations(TENANT, 1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void getSecurityIntegration_unknownId_isNotFound() {
        // Exactly 404 (not the EE catch-all 403 a mis-routed path would give) guards the binding.
        assertThatThrownBy(() -> api().getSecurityIntegration(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }
}
