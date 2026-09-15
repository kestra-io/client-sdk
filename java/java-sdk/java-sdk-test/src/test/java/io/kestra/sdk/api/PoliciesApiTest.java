package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the policy endpoints under {@code /api/v1/{tenant}/policies/**} and
 * {@code /api/v1/instance/policies/**}. Search returns a paged envelope; an unknown id is a
 * plain 404 (not the EE catch-all 403 a mis-routed path would give), which guards the binding.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PoliciesApiTest {

    static PoliciesApi api() {
        return client().policies();
    }

    @Test
    void searchPolicies_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().searchPolicies(TENANT, 1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void searchInstancePolicies_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().searchInstancePolicies(1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void getPolicy_unknownId_isNotFound() {
        assertThatThrownBy(() -> api().getPolicy(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }

    @Test
    void getInstancePolicy_unknownId_isNotFound() {
        assertThatThrownBy(() -> api().getInstancePolicy("does-not-exist-" + randomId(), null))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }
}
