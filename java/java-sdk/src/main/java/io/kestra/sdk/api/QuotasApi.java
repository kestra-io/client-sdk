package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import io.kestra.sdk.model.QuotaLimit;
import io.kestra.sdk.model.QuotaLimitControllerApiQuotaLimitResetRequest;

import java.util.List;

public class QuotasApi extends BaseApi {

    public QuotasApi() {
        super(Configuration.getDefaultApiClient());
    }

    public QuotasApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ========================================================================
    // Quota limits
    // ========================================================================

    public List<QuotaLimit> searchQuotaLimits(
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "quota-limits"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void resetQuotaLimit(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull QuotaLimitControllerApiQuotaLimitResetRequest request) throws ApiException {
        invoke("POST",
                tenantPath(tenant, "quota-limits", "reset"),
                request, null, null,
                JSON, JSON, null);
    }

}
