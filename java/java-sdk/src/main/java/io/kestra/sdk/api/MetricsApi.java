package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import java.util.List;
import java.util.Map;

/**
 * Metric endpoints under {@code /api/v1/{tenant}/metrics/**}: the metric entries an execution
 * emits, the metric names declared by a flow/task, and time-bucketed aggregations. Requires
 * {@code EXECUTION.VIEW} on the target namespace.
 */
public class MetricsApi extends BaseApi {

    public MetricsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public MetricsApi(ApiClient apiClient) {
        super(apiClient);
    }

    public Map<String, Object> searchMetricsByExecution(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable String taskRunId,
            @jakarta.annotation.Nullable String taskId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "metrics", executionId),
                null, queryParams("page", page, "size", size, "taskRunId", taskRunId, "taskId", taskId),
                csvParams("sort", sort),
                JSON, null,
                new TypeReference<>() {});
    }

    public List<String> listFlowMetrics(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "metrics", "names", namespace, flowId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public List<String> listTaskMetrics(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String taskId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "metrics", "names", namespace, flowId, taskId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public List<String> listTasksWithMetrics(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "metrics", "tasks", namespace, flowId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> aggregateMetricsFromFlow(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String metric,
            @jakarta.annotation.Nonnull String aggregation,
            @jakarta.annotation.Nullable String startDate,
            @jakarta.annotation.Nullable String endDate) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "metrics", "aggregates", namespace, flowId, metric),
                null, queryParams("aggregation", aggregation, "startDate", startDate, "endDate", endDate), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> aggregateMetricsFromTask(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String taskId,
            @jakarta.annotation.Nonnull String metric,
            @jakarta.annotation.Nonnull String aggregation,
            @jakarta.annotation.Nullable String startDate,
            @jakarta.annotation.Nullable String endDate) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "metrics", "aggregates", namespace, flowId, taskId, metric),
                null, queryParams("aggregation", aggregation, "startDate", startDate, "endDate", endDate), null,
                JSON, null,
                new TypeReference<>() {});
    }

}
