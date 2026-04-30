package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.ApiExecution;
import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.Execution;
import io.kestra.sdk.model.ExecutionControllerEvalResult;
import io.kestra.sdk.model.ExecutionControllerExecutionResponse;
import io.kestra.sdk.model.ExecutionControllerLastExecutionResponse;
import io.kestra.sdk.model.ExecutionControllerSetLabelsByIdsRequest;
import io.kestra.sdk.model.ExecutionControllerStateRequest;
import io.kestra.sdk.model.ExecutionKind;
import io.kestra.sdk.model.ExecutionRepositoryInterfaceFlowFilter;
import io.kestra.sdk.model.FileMetas;
import io.kestra.sdk.model.FlowForExecution;
import io.kestra.sdk.model.FlowGraph;
import io.kestra.sdk.model.Label;
import io.kestra.sdk.model.PagedResultsApiLightExecution;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.StateType;
import io.kestra.sdk.model.ExecutionStatusEvent;
import io.kestra.sdk.model.WebhookResponse;

import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecutionsApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String TEXT_JSON = "text/json";
    private static final String TEXT_PLAIN = "text/plain";
    private static final String OCTET_STREAM = "application/octet-stream";
    private static final String MULTIPART = "multipart/form-data";

    public ExecutionsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public ExecutionsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- Path builders ----

    private String tenantPath(String tenant, String... segments) {
        StringBuilder sb = new StringBuilder("/api/v1/");
        sb.append(esc(tenant));
        for (String s : segments) {
            sb.append("/").append(esc(s));
        }
        return sb.toString();
    }

    private String esc(String value) {
        return apiClient.escapeString(apiClient.parameterToString(value));
    }

    // ---- Query param builders ----

    private List<Pair> queryParams(Object... keyValues) {
        List<Pair> params = new ArrayList<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            String key = (String) keyValues[i];
            Object value = keyValues[i + 1];
            if (value != null) {
                params.addAll(apiClient.parameterToPair(key, value));
            }
        }
        return params;
    }

    private List<Pair> filterParams(@jakarta.annotation.Nullable List<QueryFilter> filters) {
        if (filters == null || filters.isEmpty()) {
            return Collections.emptyList();
        }
        return apiClient.parameterToPairs("csv", "filters", filters);
    }

    private List<Pair> csvParams(String name, @jakarta.annotation.Nullable List<String> values) {
        if (values == null || values.isEmpty()) {
            return Collections.emptyList();
        }
        return apiClient.parameterToPairs("csv", name, values);
    }

    private List<Pair> multiParams(String name, @jakarta.annotation.Nullable List<String> values) {
        if (values == null || values.isEmpty()) {
            return Collections.emptyList();
        }
        return apiClient.parameterToPairs("multi", name, values);
    }

    // ---- HTTP helpers ----

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         TypeReference<T> returnType) throws ApiException {
        return invoke(method, path, body, queryParams, collectionQueryParams,
                accept, contentType, new HashMap<>(), returnType);
    }

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         Map<String, Object> formParams,
                         TypeReference<T> returnType) throws ApiException {
        return apiClient.invokeAPI(
                path, method,
                queryParams != null ? queryParams : Collections.emptyList(),
                collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
                "",
                body,
                new HashMap<>(),
                new HashMap<>(),
                formParams != null ? formParams : new HashMap<>(),
                accept, contentType, AUTH, returnType
        );
    }

    // ========================================================================
    // Create execution
    // ========================================================================

    public ExecutionControllerExecutionResponse createExecution(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable List<String> labels,
            @jakarta.annotation.Nullable Boolean wait,
            @jakarta.annotation.Nullable Integer revision,
            @jakarta.annotation.Nullable OffsetDateTime scheduleDate,
            @jakarta.annotation.Nullable String breakpoints,
            @jakarta.annotation.Nullable ExecutionKind kind) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", namespace, id),
                null,
                queryParams("wait", wait, "revision", revision,
                        "scheduleDate", scheduleDate, "breakpoints", breakpoints, "kind", kind),
                multiParams("labels", labels),
                JSON, MULTIPART,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Get execution
    // ========================================================================

    public ApiExecution execution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions", executionId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsApiLightExecution searchExecutions(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "executions", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public PagedResultsApiLightExecution searchExecutionsByFlowId(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions"),
                null, queryParams("namespace", namespace, "flowId", flowId, "page", page, "size", size), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public List<ExecutionControllerLastExecutionResponse> latestExecutions(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<ExecutionRepositoryInterfaceFlowFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "latest"),
                filters, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Graph & flow
    // ========================================================================

    public FlowGraph executionFlowGraph(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<String> subflows) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions", executionId, "graph"),
                null, null, csvParams("subflows", subflows),
                JSON, null,
                new TypeReference<>() {});
    }

    public FlowForExecution flowFromExecution(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nullable Integer revision) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions", "flows", namespace, flowId),
                null, queryParams("revision", revision), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public FlowForExecution flowFromExecutionById(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions", executionId, "flow"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // File operations
    // ========================================================================

    public File downloadFileFromExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull URI path,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions", executionId, "file"),
                null, queryParams("path", path), null,
                OCTET_STREAM, null,
                new TypeReference<>() {});
    }

    public FileMetas fileMetadatasFromExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull URI path,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions", executionId, "file", "metas"),
                null, queryParams("path", path), null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Eval expression
    // ========================================================================

    public ExecutionControllerEvalResult evalExpression(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String expression) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "eval"),
                expression, null, null,
                JSON, TEXT_PLAIN,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Kill
    // ========================================================================

    public Execution killExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean isOnKillCascade) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "executions", executionId, "kill"),
                null, queryParams("isOnKillCascade", isOnKillCascade), null,
                TEXT_JSON, null,
                new TypeReference<>() {});
    }

    public Object killExecutionsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "executions", "kill", "by-ids"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object killExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "executions", "kill", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Delete
    // ========================================================================

    public void deleteExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean deleteLogs,
            @jakarta.annotation.Nullable Boolean deleteMetrics,
            @jakarta.annotation.Nullable Boolean deleteStorage) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "executions", executionId),
                null,
                queryParams("deleteLogs", deleteLogs, "deleteMetrics", deleteMetrics,
                        "deleteStorage", deleteStorage),
                null, null, null, null);
    }

    public BulkResponse deleteExecutionsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids,
            @jakarta.annotation.Nullable Boolean includeNonTerminated,
            @jakarta.annotation.Nullable Boolean deleteLogs,
            @jakarta.annotation.Nullable Boolean deleteMetrics,
            @jakarta.annotation.Nullable Boolean deleteStorage) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "executions", "by-ids"),
                ids,
                queryParams("includeNonTerminated", includeNonTerminated,
                        "deleteLogs", deleteLogs, "deleteMetrics", deleteMetrics,
                        "deleteStorage", deleteStorage),
                null, JSON, JSON,
                new TypeReference<>() {});
    }

    public Object deleteExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters,
            @jakarta.annotation.Nullable Boolean includeNonTerminated,
            @jakarta.annotation.Nullable Boolean deleteLogs,
            @jakarta.annotation.Nullable Boolean deleteMetrics,
            @jakarta.annotation.Nullable Boolean deleteStorage) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "executions", "by-query"),
                null,
                queryParams("includeNonTerminated", includeNonTerminated,
                        "deleteLogs", deleteLogs, "deleteMetrics", deleteMetrics,
                        "deleteStorage", deleteStorage),
                filterParams(filters), JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Pause / Resume
    // ========================================================================

    public Execution pauseExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "pause"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Object pauseExecutionsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "pause", "by-ids"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object pauseExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "pause", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    public Execution resumeExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "resume"),
                null, null, null,
                JSON, MULTIPART,
                new TypeReference<>() {});
    }

    public Object resumeExecutionsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "resume", "by-ids"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object resumeExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "resume", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Restart
    // ========================================================================

    public Execution restartExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer revision) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "restart"),
                null, queryParams("revision", revision), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Object restartExecutionsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "restart", "by-ids"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object restartExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "restart", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Replay
    // ========================================================================

    public Execution replayExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String taskRunId,
            @jakarta.annotation.Nullable Integer revision,
            @jakarta.annotation.Nullable String breakpoints) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "replay"),
                null, queryParams("taskRunId", taskRunId, "revision", revision, "breakpoints", breakpoints), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Execution replayExecutionWithInputs(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String taskRunId,
            @jakarta.annotation.Nullable Integer revision,
            @jakarta.annotation.Nullable String breakpoints) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "replay-with-inputs"),
                null, queryParams("taskRunId", taskRunId, "revision", revision, "breakpoints", breakpoints), null,
                JSON, MULTIPART,
                new TypeReference<>() {});
    }

    public Object replayExecutionsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids,
            @jakarta.annotation.Nullable Boolean latestRevision) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "replay", "by-ids"),
                ids, queryParams("latestRevision", latestRevision), null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object replayExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters,
            @jakarta.annotation.Nullable Boolean latestRevision) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "replay", "by-query"),
                null, queryParams("latestRevision", latestRevision), filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Force run
    // ========================================================================

    public Execution forceRunExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "force-run"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Object forceRunByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "force-run", "by-ids"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object forceRunExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "force-run", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Unqueue
    // ========================================================================

    public Execution unqueueExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable StateType state) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "unqueue"),
                null, queryParams("state", state), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Object unqueueExecutionsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull StateType state,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "unqueue", "by-ids"),
                ids, queryParams("state", state), null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object unqueueExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable StateType newState,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "unqueue", "by-query"),
                null, queryParams("newState", newState), filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Labels
    // ========================================================================

    public Execution setLabelsOnTerminatedExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<Label> labels) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "labels"),
                labels, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object setLabelsOnTerminatedExecutionsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ExecutionControllerSetLabelsByIdsRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "labels", "by-ids"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object setLabelsOnTerminatedExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<Label> labels,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "labels", "by-query"),
                labels, null, filterParams(filters),
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Change status
    // ========================================================================

    public Execution updateExecutionStatus(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull StateType status,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "change-status"),
                null, queryParams("status", status), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Object updateExecutionsStatusByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull StateType newStatus,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "change-status", "by-ids"),
                ids, queryParams("newStatus", newStatus), null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object updateExecutionsStatusByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull StateType newStatus,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "change-status", "by-query"),
                null, queryParams("newStatus", newStatus), filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Update task run state
    // ========================================================================

    public Execution updateTaskRunState(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ExecutionControllerStateRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", executionId, "state"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Webhooks
    // ========================================================================

    public WebhookResponse triggerExecutionByGetWebhook(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String key) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions", "webhook", namespace, id, key),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public WebhookResponse triggerExecutionByGetWebhookWithPath(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String key,
            @jakarta.annotation.Nullable String path) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "executions", "webhook", namespace, id, key, path),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public WebhookResponse triggerExecutionByPostWebhookWithPath(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String key,
            @jakarta.annotation.Nullable String path) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "executions", "webhook", namespace, id, key, path),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public WebhookResponse triggerExecutionByPutWebhookWithPath(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String key,
            @jakarta.annotation.Nullable String path) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "executions", "webhook", namespace, id, key, path),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Streaming (SSE)
    // ========================================================================

    private CloseableHttpResponse openStream(String path, List<Pair> queryParams) throws ApiException {
        return apiClient.openEventStream(
                path,
                queryParams != null ? queryParams : Collections.emptyList(),
                Collections.emptyList(),
                "",
                new HashMap<>(),
                new HashMap<>(),
                AUTH
        );
    }

    private <T> Flux<T> sseFlux(String path, List<Pair> queryParams, Class<T> eventType) {
        return Flux.create(sink -> {
            CloseableHttpResponse response = null;
            BufferedReader reader = null;
            try {
                response = openStream(path, queryParams);
                reader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));

                String line;
                StringBuilder dataBuffer = new StringBuilder();

                while (!sink.isCancelled() && (line = reader.readLine()) != null) {
                    if (line.isEmpty()) {
                        if (dataBuffer.length() > 0) {
                            T ev = apiClient.getObjectMapper().readValue(dataBuffer.toString(), eventType);
                            dataBuffer.setLength(0);
                            sink.next(ev);
                        }
                        continue;
                    }
                    if (line.startsWith("data:")) {
                        String payload = line.substring(5);
                        if (payload.startsWith(" ")) payload = payload.substring(1);
                        dataBuffer.append(payload).append('\n');
                    }
                }

                if (dataBuffer.length() > 0) {
                    T ev = apiClient.getObjectMapper().readValue(dataBuffer.toString(), eventType);
                    sink.next(ev);
                }
                sink.complete();
            } catch (IOException e) {
                if (!sink.isCancelled()) {
                    sink.error(new ApiException(e));
                }
            } catch (ApiException e) {
                sink.error(e);
            } finally {
                try {
                    if (reader != null) reader.close();
                    if (response != null) response.close();
                } catch (IOException ignored) {
                }
            }
        });
    }

    public Flux<Execution> followExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return sseFlux(
                tenantPath(tenant, "executions", executionId, "follow"),
                null,
                Execution.class
        );
    }

    public Flux<ExecutionStatusEvent> followDependenciesExecution(
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean destinationOnly,
            @jakarta.annotation.Nullable Boolean expandAll) throws ApiException {
        return sseFlux(
                tenantPath(tenant, "executions", executionId, "follow-dependencies"),
                queryParams("destinationOnly", destinationOnly, "expandAll", expandAll),
                ExecutionStatusEvent.class
        );
    }

    // ========================================================================
    // BaseApi override
    // ========================================================================

    @Override
    public <T> T invokeAPI(String url, String method, Object request,
                           TypeReference<T> returnType,
                           Map<String, String> additionalHeaders) throws ApiException {
        String path = url.replace(apiClient.getBaseURL(), "");
        return apiClient.invokeAPI(
                path, method,
                Collections.emptyList(), Collections.emptyList(), "",
                request,
                additionalHeaders != null ? additionalHeaders : new HashMap<>(),
                new HashMap<>(), new HashMap<>(),
                JSON, JSON, AUTH, returnType
        );
    }
}
