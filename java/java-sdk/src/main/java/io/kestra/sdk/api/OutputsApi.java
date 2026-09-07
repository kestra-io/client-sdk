package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;
import io.kestra.sdk.model.OutputControllerTaskOutputInformation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Outputs of an execution and of its individual task runs.
 *
 * <p>Since Kestra 2.0 an execution's outputs are no longer inlined on the Execution
 * payload; they are fetched from these endpoints instead.
 */
public class OutputsApi extends BaseApi {

    public OutputsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public OutputsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- HTTP helpers ----

    private <T> T get(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                      TypeReference<T> returnType) throws ApiException {
        return invoke("GET", path, null, queryParams, collectionQueryParams,
                JSON, null, new HashMap<>(), returnType);
    }

    /**
     * The outputs declared by the flow, for a terminated execution.
     */
    public Map<String, Object> getExecutionOutputs(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "outputs", "executions", executionId),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    /**
     * Where each task run's outputs live for an execution: inline, or held in internal
     * storage and retrievable through {@link #getTaskRunOutputs}.
     */
    public List<OutputControllerTaskOutputInformation> getTaskOutputsInformation(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "outputs", "tasks", executionId),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    /**
     * The outputs of a single task run.
     */
    public Map<String, Object> getTaskRunOutputs(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String taskRunId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "outputs", "tasks", executionId, taskRunId),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }
}
