package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.model.CasesControllerCaseFromTaskRequest;

import java.util.Map;

public class CasesApi extends BaseApi {

    public CasesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public CasesApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Creates a case from a task run, or attaches the triggering execution to a matching already-open case.
     */
    public Map<String, Object> createFromTask(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull CasesControllerCaseFromTaskRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", "from-task"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

}
