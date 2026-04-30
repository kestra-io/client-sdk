package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.ConcurrencyLimit;
import io.kestra.sdk.model.ExpressionContext;
import io.kestra.sdk.model.Flow;
import io.kestra.sdk.model.FlowControllerFlowWithDeprecatedTasks;
import io.kestra.sdk.model.FlowControllerTaskValidationType;
import io.kestra.sdk.model.FlowGraph;
import io.kestra.sdk.model.FlowInterface;
import io.kestra.sdk.model.FlowTopologyGraph;
import io.kestra.sdk.model.FlowWithSource;
import io.kestra.sdk.model.IdWithNamespace;
import io.kestra.sdk.model.PagedResultsConcurrencyLimit;
import io.kestra.sdk.model.PagedResultsFlow;
import io.kestra.sdk.model.PagedResultsSearchResultFlow;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.Task;
import io.kestra.sdk.model.ValidateConstraintViolation;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowsApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String YAML = "application/x-yaml";
    private static final String OCTET_STREAM = "application/octet-stream";
    private static final String MULTIPART = "multipart/form-data";

    public FlowsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public FlowsApi(ApiClient apiClient) {
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

    // ---- HTTP helpers ----

    private <T> T get(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                      TypeReference<T> returnType) throws ApiException {
        return invoke("GET", path, null, queryParams, collectionQueryParams,
                null, JSON, null, returnType);
    }

    private <T> T get(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                      String accept, TypeReference<T> returnType) throws ApiException {
        return invoke("GET", path, null, queryParams, collectionQueryParams,
                null, accept, null, returnType);
    }

    private <T> T postYaml(String path, String body, List<Pair> queryParams,
                           TypeReference<T> returnType) throws ApiException {
        return invoke("POST", path, body, queryParams, Collections.emptyList(),
                null, JSON, YAML, returnType);
    }

    private <T> T postJson(String path, Object body, List<Pair> queryParams,
                           TypeReference<T> returnType) throws ApiException {
        return invoke("POST", path, body, queryParams, Collections.emptyList(),
                null, JSON, JSON, returnType);
    }

    private <T> T putYaml(String path, String body, TypeReference<T> returnType) throws ApiException {
        return invoke("PUT", path, body, Collections.emptyList(), Collections.emptyList(),
                null, JSON, YAML, returnType);
    }

    private <T> T putJson(String path, Object body, TypeReference<T> returnType) throws ApiException {
        return invoke("PUT", path, body, Collections.emptyList(), Collections.emptyList(),
                null, JSON, JSON, returnType);
    }

    private void delete(String path, List<Pair> queryParams) throws ApiException {
        invoke("DELETE", path, null, queryParams, Collections.emptyList(),
                null, null, null, null);
    }

    private <T> T deleteWithBody(String path, Object body, String contentType,
                                 TypeReference<T> returnType) throws ApiException {
        return invoke("DELETE", path, body, Collections.emptyList(), Collections.emptyList(),
                null, JSON, contentType, returnType);
    }

    private <T> T deleteWithQuery(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                                  TypeReference<T> returnType) throws ApiException {
        return invoke("DELETE", path, null, queryParams, collectionQueryParams,
                null, JSON, null, returnType);
    }

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         Map<String, Object> formParams,
                         String accept, String contentType,
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
    // CRUD
    // ========================================================================

    public FlowWithSource createFlow(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body) throws ApiException {
        return postYaml(
                tenantPath(tenant, "flows"),
                body, Collections.emptyList(),
                new TypeReference<>() {});
    }

    public FlowWithSource flow(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean source,
            @jakarta.annotation.Nullable Integer revision,
            @jakarta.annotation.Nullable Boolean allowDeleted) throws ApiException {
        return get(
                tenantPath(tenant, "flows", namespace, id),
                queryParams("source", source, "revision", revision, "allowDeleted", allowDeleted),
                Collections.emptyList(),
                new TypeReference<>() {});
    }

    public FlowWithSource updateFlow(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body) throws ApiException {
        return putYaml(
                tenantPath(tenant, "flows", namespace, id),
                body,
                new TypeReference<>() {});
    }

    public void deleteFlow(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "flows", namespace, id), Collections.emptyList());
    }

    // ========================================================================
    // Bulk CRUD
    // ========================================================================

    public List<FlowInterface> bulkUpdateFlows(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean delete,
            @jakarta.annotation.Nullable String namespace,
            @jakarta.annotation.Nullable Boolean allowNamespaceChild,
            @jakarta.annotation.Nullable String body) throws ApiException {
        return postYaml(
                tenantPath(tenant, "flows", "bulk"),
                body,
                queryParams("delete", delete, "namespace", namespace,
                        "allowNamespaceChild", allowNamespaceChild),
                new TypeReference<>() {});
    }

    public BulkResponse deleteFlowsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<IdWithNamespace> ids) throws ApiException {
        return deleteWithBody(
                tenantPath(tenant, "flows", "delete", "by-ids"),
                ids, JSON,
                new TypeReference<>() {});
    }

    public BulkResponse deleteFlowsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return deleteWithQuery(
                tenantPath(tenant, "flows", "delete", "by-query"),
                Collections.emptyList(), filterParams(filters),
                new TypeReference<>() {});
    }

    public BulkResponse disableFlowsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<IdWithNamespace> ids) throws ApiException {
        return postJson(
                tenantPath(tenant, "flows", "disable", "by-ids"),
                ids, Collections.emptyList(),
                new TypeReference<>() {});
    }

    public BulkResponse disableFlowsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = filterParams(filters);
        return invoke("POST",
                tenantPath(tenant, "flows", "disable", "by-query"),
                null, Collections.emptyList(), collectionParams,
                null, JSON, null,
                new TypeReference<>() {});
    }

    public BulkResponse enableFlowsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<IdWithNamespace> ids) throws ApiException {
        return postJson(
                tenantPath(tenant, "flows", "enable", "by-ids"),
                ids, Collections.emptyList(),
                new TypeReference<>() {});
    }

    public BulkResponse enableFlowsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = filterParams(filters);
        return invoke("POST",
                tenantPath(tenant, "flows", "enable", "by-query"),
                null, Collections.emptyList(), collectionParams,
                null, JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Search & List
    // ========================================================================

    public PagedResultsFlow searchFlows(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "flows", "search"),
                queryParams("page", page, "size", size),
                collectionParams,
                new TypeReference<>() {});
    }

    public PagedResultsSearchResultFlow searchFlowsBySourceCode(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable String q,
            @jakarta.annotation.Nullable String namespace) throws ApiException {
        return get(
                tenantPath(tenant, "flows", "source"),
                queryParams("page", page, "size", size, "q", q, "namespace", namespace),
                csvParams("sort", sort),
                new TypeReference<>() {});
    }

    public List<Flow> listFlowsByNamespace(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "flows", namespace),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public List<String> listDistinctNamespaces(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String q) throws ApiException {
        return get(
                tenantPath(tenant, "flows", "distinct-namespaces"),
                queryParams("q", q), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public List<FlowControllerFlowWithDeprecatedTasks> listDeprecated(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String namespace) throws ApiException {
        return get(
                tenantPath(tenant, "flows", "deprecated"),
                queryParams("namespace", namespace), Collections.emptyList(),
                new TypeReference<>() {});
    }

    // ========================================================================
    // Revisions
    // ========================================================================

    public List<FlowWithSource> listFlowRevisions(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean allowDelete) throws ApiException {
        return get(
                tenantPath(tenant, "flows", namespace, id, "revisions"),
                queryParams("allowDelete", allowDelete), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public void deleteRevisions(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<Integer> revisions) throws ApiException {
        delete(tenantPath(tenant, "flows", namespace, id, "revisions"),
                apiClient.parameterToPairs("csv", "revisions", revisions));
    }

    // ========================================================================
    // Namespace operations
    // ========================================================================

    public List<FlowInterface> updateFlowsInNamespace(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body,
            @jakarta.annotation.Nullable Boolean delete,
            @jakarta.annotation.Nullable Boolean override) throws ApiException {
        return postYaml(
                tenantPath(tenant, "flows", namespace),
                body,
                queryParams("delete", delete, "override", override),
                new TypeReference<>() {});
    }

    // ========================================================================
    // Export & Import
    // ========================================================================

    public byte[] exportFlowsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<IdWithNamespace> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "flows", "export", "by-ids"),
                ids, Collections.emptyList(), Collections.emptyList(),
                null, OCTET_STREAM, JSON,
                new TypeReference<>() {});
    }

    public byte[] exportFlowsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return get(
                tenantPath(tenant, "flows", "export", "by-query"),
                Collections.emptyList(), filterParams(filters),
                OCTET_STREAM,
                new TypeReference<>() {});
    }

    public List<String> importFlows(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean failOnError,
            @jakarta.annotation.Nullable File fileUpload) throws ApiException {
        Map<String, Object> formParams = new HashMap<>();
        if (fileUpload != null) {
            formParams.put("fileUpload", fileUpload);
        }
        return invoke("POST",
                tenantPath(tenant, "flows", "import"),
                null,
                queryParams("failOnError", failOnError), Collections.emptyList(),
                formParams, JSON, MULTIPART,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Graph & Dependencies
    // ========================================================================

    public FlowGraph generateFlowGraph(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer revision,
            @jakarta.annotation.Nullable List<String> subflows) throws ApiException {
        return get(
                tenantPath(tenant, "flows", namespace, id, "graph"),
                queryParams("revision", revision),
                csvParams("subflows", subflows),
                new TypeReference<>() {});
    }

    public FlowGraph generateFlowGraphFromSource(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body,
            @jakarta.annotation.Nullable List<String> subflows) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "flows", "graph"),
                body, Collections.emptyList(), csvParams("subflows", subflows),
                null, JSON, YAML,
                new TypeReference<>() {});
    }

    public FlowTopologyGraph flowDependencies(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean destinationOnly,
            @jakarta.annotation.Nullable Boolean expandAll) throws ApiException {
        return get(
                tenantPath(tenant, "flows", namespace, id, "dependencies"),
                queryParams("destinationOnly", destinationOnly, "expandAll", expandAll),
                Collections.emptyList(),
                new TypeReference<>() {});
    }

    public FlowTopologyGraph flowDependenciesFromNamespace(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean destinationOnly) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "dependencies"),
                queryParams("destinationOnly", destinationOnly), Collections.emptyList(),
                new TypeReference<>() {});
    }

    // ========================================================================
    // Tasks
    // ========================================================================

    public Task taskFromFlow(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String taskId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer revision) throws ApiException {
        return get(
                tenantPath(tenant, "flows", namespace, id, "tasks", taskId),
                queryParams("revision", revision), Collections.emptyList(),
                new TypeReference<>() {});
    }

    // ========================================================================
    // Concurrency
    // ========================================================================

    public PagedResultsConcurrencyLimit searchConcurrencyLimits(
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "concurrency-limit", "search"),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public ConcurrencyLimit updateConcurrencyLimit(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ConcurrencyLimit concurrencyLimit) throws ApiException {
        return putJson(
                tenantPath(tenant, "concurrency-limit", namespace, flowId),
                concurrencyLimit,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Validation
    // ========================================================================

    public List<ValidateConstraintViolation> validateFlows(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body) throws ApiException {
        return postYaml(
                tenantPath(tenant, "flows", "validate"),
                body, Collections.emptyList(),
                new TypeReference<>() {});
    }

    public ValidateConstraintViolation validateTask(
            @jakarta.annotation.Nonnull FlowControllerTaskValidationType section,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Object body) throws ApiException {
        return postJson(
                tenantPath(tenant, "flows", "validate", "task"),
                body,
                queryParams("section", section),
                new TypeReference<>() {});
    }

    public ValidateConstraintViolation validateTrigger(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Object body) throws ApiException {
        return postJson(
                tenantPath(tenant, "flows", "validate", "trigger"),
                body, Collections.emptyList(),
                new TypeReference<>() {});
    }

    // ========================================================================
    // Expressions
    // ========================================================================

    public ExpressionContext expressions(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body,
            @jakarta.annotation.Nullable String taskId) throws ApiException {
        return postYaml(
                tenantPath(tenant, "flows", "expressions"),
                body,
                queryParams("taskId", taskId),
                new TypeReference<>() {});
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
