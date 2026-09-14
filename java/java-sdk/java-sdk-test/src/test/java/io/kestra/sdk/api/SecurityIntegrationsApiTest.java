package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the security-integration (SCIM) endpoints under
 * {@code /api/v1/{tenant}/security-integrations/**}. They require the EE
 * {@code FEATURE_SCIM} license feature and instance-owner rights; on a CI image without
 * it the resource is gated (403), so the read-only tests accept either outcome.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecurityIntegrationsApiTest {

    static SecurityIntegrationsApi api() {
        return client().securityIntegrations();
    }

    @Test
    void searchSecurityIntegrations_isPagedOrGated() throws ApiException {
        try {
            Map<String, Object> result = api().searchSecurityIntegrations(TENANT, 1, 10, null, null);
            assertThat(result).containsKey("results");
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(403, 404);
        }
    }

    @Test
    void getSecurityIntegration_unknownId_throws() {
        assertThatThrownBy(() -> api().getSecurityIntegration(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isIn(403, 404));
    }
}
