package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the promotion-target endpoints under
 * {@code /api/v1/{tenant}/promotion-targets/**}. The CI image licenses
 * {@code FEATURE_PROMOTE}, so the list returns a real paged envelope.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PromotionTargetsApiTest {

    static PromotionTargetsApi api() {
        return client().promotionTargets();
    }

    @Test
    void listPromotionTargets_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().listPromotionTargets(TENANT, 1, 100, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void getPromotionTarget_unknownId_isNotFound() {
        // Exactly 404 (not the EE catch-all 403 a mis-routed path would give) guards the binding.
        assertThatThrownBy(() -> api().getPromotionTarget(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }
}
