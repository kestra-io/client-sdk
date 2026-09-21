package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.CaseAction;
import io.kestra.sdk.model.CaseStatus;
import io.kestra.sdk.model.CasesControllerCaseFromTaskRequest;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.StateType;
import io.kestra.sdk.model.Subjects;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasesApi extends BaseApi {

    private static final String MULTIPART = "multipart/form-data";
    private static final String OCTET_STREAM = "application/octet-stream";

    public CasesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public CasesApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Builds a JSON body map from the given key/value pairs, skipping any {@code null} value
     * (mirrors {@link #queryParams} but for a request body rather than the query string).
     */
    private static Map<String, Object> bodyMap(Object... keyValues) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            String key = (String) keyValues[i];
            Object value = keyValues[i + 1];
            if (value != null) {
                map.put(key, value);
            }
        }
        return map;
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

    // ========================================================================
    // CRUD
    // ========================================================================

    public Map<String, Object> createCase(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> caseRequest) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases"),
                caseRequest, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> getCase(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean allowDeleted) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "cases", id),
                null, queryParams("allowDeleted", allowDeleted), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> updateCase(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> caseUpdate) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "cases", id),
                caseUpdate, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteCase(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "cases", id),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // Search & bulk
    // ========================================================================

    public Map<String, Object> searchCases(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "cases", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Object counts(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "cases", "counts"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> assignees(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "cases", "assignees"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> byAsset(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String assetId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "cases", "by-asset", assetId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Object byExecutions(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> executionIds) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", "by-executions"),
                executionIds, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public BulkResponse acknowledgeCasesByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", "by-ids", "acknowledge"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public BulkResponse deleteCasesByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", "by-ids", "delete"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public BulkResponse deleteCasesByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "cases", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Create from executions
    // ========================================================================

    public Map<String, Object> createFromExecutions(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> caseRequest,
            @jakarta.annotation.Nonnull List<String> executionIds) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", "from-executions"),
                bodyMap("case", caseRequest, "executionIds", executionIds), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> createFromExecutionsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> caseRequest,
            @jakarta.annotation.Nonnull List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", "from-executions", "by-query"),
                bodyMap("case", caseRequest, "filters", filters), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Acknowledge / cancel / resolve / status
    // ========================================================================

    public Map<String, Object> acknowledge(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "acknowledge"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> cancel(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String reason,
            @jakarta.annotation.Nullable String note) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "cancel"),
                bodyMap("reason", reason, "note", note), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> resolve(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String reason,
            @jakarta.annotation.Nullable String note) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "resolve"),
                bodyMap("reason", reason, "note", note), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> changeStatus(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull CaseStatus status) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "status"),
                bodyMap("status", status), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Actions
    // ========================================================================

    public Map<String, Object> attachAction(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull CaseAction action) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "actions"),
                action, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object runAction(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "actions", "run"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> updateAction(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull CaseAction action) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "cases", id, "actions", namespace, flowId),
                action, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> detachAction(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "cases", id, "actions", namespace, flowId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Assets & attachments
    // ========================================================================

    public Map<String, Object> assets(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "cases", id, "assets"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> attachAsset(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String assetId) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "assets"),
                bodyMap("assetId", assetId), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> detachAsset(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String assetId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "cases", id, "assets", assetId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public byte[] downloadAttachment(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String attachmentId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "cases", id, "attachments", attachmentId),
                null, null, null,
                OCTET_STREAM, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Assignment & auto-attach
    // ========================================================================

    public Map<String, Object> assign(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Subjects assignees,
            @jakarta.annotation.Nullable Subjects watchers,
            @jakarta.annotation.Nullable String note) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "assign"),
                bodyMap("assignees", assignees, "watchers", watchers, "note", note), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> enableAutoAttach(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull List<StateType> states) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "auto-attach"),
                bodyMap("namespace", namespace, "flowId", flowId, "states", states), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> disableAutoAttach(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "cases", id, "auto-attach"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Comments & events
    // ========================================================================

    public Map<String, Object> addComment(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String body,
            @jakarta.annotation.Nullable File file) throws ApiException {
        Map<String, Object> formParams = new HashMap<>();
        if (body != null) {
            formParams.put("body", body);
        }
        if (file != null) {
            formParams.put("files", file);
        }
        return invoke("POST",
                tenantPath(tenant, "cases", id, "comments"),
                null, null, null,
                JSON, MULTIPART, formParams,
                new TypeReference<>() {});
    }

    public Map<String, Object> events(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "cases", id, "events"),
                null, queryParams("page", page, "size", size), null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Follow / unfollow
    // ========================================================================

    public Map<String, Object> follow(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "follow"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void unfollow(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("POST",
                tenantPath(tenant, "cases", id, "unfollow"),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // Linked executions
    // ========================================================================

    public Map<String, Object> executions(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "cases", id, "executions"),
                null, queryParams("page", page, "size", size), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> linkExecutions(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> executionIds) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "executions"),
                bodyMap("executionIds", executionIds), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> linkExecutionsByQuery(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "cases", id, "executions", "by-query"),
                bodyMap("filters", filters), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void unlinkExecution(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "cases", id, "executions", executionId),
                null, null, null,
                null, null, null);
    }

}
