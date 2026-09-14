package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the promotion-target endpoints under
 * {@code /api/v1/{tenant}/promotion-targets/**}.
 * <p>
 * Promotion targets require the EE {@code FEATURE_PROMOTE} license feature and the
 * {@code PROMOTION_TARGET} resource. On a CI image without that feature the resource is
 * gated (403); the read-only tests accept either the real payload or that gate.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PromotionTargetsApiTest {

    static PromotionTargetsApi api() {
        return client().promotionTargets();
    }

    @Test
    void listPromotionTargets_isPagedOrGated() throws ApiException {
        try {
            Map<String, Object> result = api().listPromotionTargets(TENANT, 1, 100, null, null);
            // the paged envelope always carries a results array when the feature is on.
            assertThat(result).containsKey("results");
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(403, 404);
        }
    }

    @Test
    void getPromotionTarget_unknownId_throws() {
        assertThatThrownBy(() -> api().getPromotionTarget(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isIn(403, 404));
    }
}
