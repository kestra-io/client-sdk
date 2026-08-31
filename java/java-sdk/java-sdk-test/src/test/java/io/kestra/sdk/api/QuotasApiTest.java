package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

public class QuotasApiTest {

    static QuotasApi api() {
        return client().quotas();
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchQuotaLimits_basic() throws ApiException {
        List<QuotaLimit> limits = api().searchQuotaLimits(TENANT);

        assertThat(limits).isNotNull();
        assertThat(limits).allSatisfy(limit -> assertThat(limit.getId()).isNotNull());
    }

    // ========================================================================
    // Reset
    // ========================================================================

    @Test
    void resetQuotaLimit_unknownId() {
        QuotaLimitControllerApiQuotaLimitResetRequest request =
                new QuotaLimitControllerApiQuotaLimitResetRequest()
                        .id(randomId());

        assertThatThrownBy(() -> api().resetQuotaLimit(TENANT, request))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> {
                    assertThat(((ApiException) e).getCode()).isEqualTo(404);
                    assertThat(((ApiException) e).getResponseBody()).contains("Quota limit not found");
                });
    }
}
