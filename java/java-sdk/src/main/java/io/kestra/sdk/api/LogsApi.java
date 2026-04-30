package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.Level;
import io.kestra.sdk.model.LogEntry;
import io.kestra.sdk.model.PagedResultsLogEntry;
import io.kestra.sdk.model.QueryFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogsApi extends BaseApi {

    private static final String TEXT_PLAIN = "text/plain";

    public LogsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public LogsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- HTTP helpers ----

    private <T> T get(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                      String accept, TypeReference<T> returnType) throws ApiException {
        return invoke("GET", path, null, queryParams, collectionQueryParams,
                accept, null, returnType);
    }

    private <T> T get(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                      TypeReference<T> returnType) throws ApiException {
        return get(path, queryParams, collectionQueryParams, JSON, returnType);
    }

    private void delete(String path, List<Pair> queryParams) throws ApiException {
        invoke("DELETE", path, null, queryParams, Collections.emptyList(),
                null, null, null);
    }

    // ========================================================================
    // Execution Logs
    // ========================================================================

    public List<LogEntry> listLogsFromExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Level minLevel,
            @jakarta.annotation.Nullable String taskRunId,
            @jakarta.annotation.Nullable String taskId,
            @jakarta.annotation.Nullable Integer attempt) throws ApiException {
        return get(
                tenantPath(tenant, "logs", executionId),
                queryParams("minLevel", minLevel, "taskRunId", taskRunId,
                        "taskId", taskId, "attempt", attempt),
                Collections.emptyList(),
                new TypeReference<>() {});
    }

    public File downloadLogsFromExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Level minLevel,
            @jakarta.annotation.Nullable String taskRunId,
            @jakarta.annotation.Nullable String taskId,
            @jakarta.annotation.Nullable Integer attempt) throws ApiException {
        return get(
                tenantPath(tenant, "logs", executionId, "download"),
                queryParams("minLevel", minLevel, "taskRunId", taskRunId,
                        "taskId", taskId, "attempt", attempt),
                Collections.emptyList(),
                TEXT_PLAIN,
                new TypeReference<>() {});
    }

    public void deleteLogsFromExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Level minLevel,
            @jakarta.annotation.Nullable String taskRunId,
            @jakarta.annotation.Nullable String taskId,
            @jakarta.annotation.Nullable Integer attempt) throws ApiException {
        delete(tenantPath(tenant, "logs", executionId),
                queryParams("minLevel", minLevel, "taskRunId", taskRunId,
                        "taskId", taskId, "attempt", attempt));
    }

    public void deleteLogsFromFlow(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String triggerId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "logs", namespace, flowId),
                queryParams("triggerId", triggerId));
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsLogEntry searchLogs(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "logs", "search"),
                queryParams("page", page, "size", size),
                collectionParams,
                new TypeReference<>() {});
    }

}
