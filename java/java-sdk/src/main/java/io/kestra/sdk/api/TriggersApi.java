package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.ApiAsyncOperationResponse;
import io.kestra.sdk.model.ApiTriggerAndState;
import io.kestra.sdk.model.ApiTriggerState;
import io.kestra.sdk.model.DeleteTriggersByQueryRequest;
import io.kestra.sdk.model.PagedResultsApiTriggerAndState;
import io.kestra.sdk.model.PagedResultsApiTriggerState;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.TriggerControllerApiCreateBackfillRequest;
import io.kestra.sdk.model.TriggerControllerApiDisableTriggerRequest;
import io.kestra.sdk.model.TriggerControllerApiTriggerId;
import io.kestra.sdk.model.TriggerControllerSetDisabledRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriggersApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String CSV = "text/csv";

    public TriggersApi() {
        super(Configuration.getDefaultApiClient());
    }

    public TriggersApi(ApiClient apiClient) {
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

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
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
                new HashMap<>(),
                accept, contentType, AUTH, returnType
        );
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsApiTriggerAndState searchTriggers(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "triggers", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public PagedResultsApiTriggerState searchTriggersForFlow(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable String q,
            @jakarta.annotation.Nullable List<String> sort) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "triggers", namespace, flowId),
                null,
                queryParams("page", page, "size", size, "q", q),
                csvParams("sort", sort),
                JSON, null,
                new TypeReference<>() {});
    }

    public String exportTriggers(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "triggers", "export", "by-query", "csv"),
                null, null, filterParams(filters),
                CSV, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Enable / Disable
    // ========================================================================

    public ApiTriggerState disableTriggerById(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TriggerControllerApiDisableTriggerRequest request) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "triggers", "set-disabled"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse disabledTriggersByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TriggerControllerSetDisabledRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "set-disabled", "by-triggers"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse disabledTriggersByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean disabled,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "set-disabled", "by-query"),
                null, queryParams("disabled", disabled), filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Restart / Unlock
    // ========================================================================

    public ApiTriggerState restartTrigger(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String triggerId) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", namespace, flowId, triggerId, "restart"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public ApiTriggerState unlockTrigger(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String triggerId) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", namespace, flowId, triggerId, "unlock"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse unlockTriggersByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<TriggerControllerApiTriggerId> triggerIds) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "unlock", "by-triggers"),
                triggerIds, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse unlockTriggersByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "unlock", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Delete
    // ========================================================================

    public void deleteTrigger(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nonnull String triggerId) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "triggers", namespace, flowId, triggerId),
                null, null, null,
                null, null, null);
    }

    public ApiAsyncOperationResponse deleteTriggersByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<TriggerControllerApiTriggerId> triggerIds) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "triggers", "delete", "by-triggers"),
                triggerIds, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse deleteTriggersByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull DeleteTriggersByQueryRequest request) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "triggers", "delete", "by-query"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Backfill
    // ========================================================================

    public ApiTriggerState createBackfill(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TriggerControllerApiCreateBackfillRequest request) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "triggers", "backfill", "create"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiTriggerState deleteBackfill(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TriggerControllerApiTriggerId triggerId) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "backfill", "delete"),
                triggerId, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse deleteBackfillByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<TriggerControllerApiTriggerId> triggerIds) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "backfill", "delete", "by-triggers"),
                triggerIds, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse deleteBackfillByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "backfill", "delete", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Backfill pause/unpause
    // ========================================================================

    public ApiTriggerState pauseBackfill(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TriggerControllerApiTriggerId triggerId) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "triggers", "backfill", "pause"),
                triggerId, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse pauseBackfillByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<TriggerControllerApiTriggerId> triggerIds) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "backfill", "pause", "by-triggers"),
                triggerIds, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse pauseBackfillByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "backfill", "pause", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    public ApiTriggerState unpauseBackfill(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TriggerControllerApiTriggerId triggerId) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "triggers", "backfill", "unpause"),
                triggerId, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse unpauseBackfillByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<TriggerControllerApiTriggerId> triggerIds) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "backfill", "unpause", "by-triggers"),
                triggerIds, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiAsyncOperationResponse unpauseBackfillByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "triggers", "backfill", "unpause", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // BaseApi override
    // ========================================================================

    @Override
    public <T> T invokeAPI(String url, String method, Object request,
                           TypeReference<T> returnType,
                           Map<String, String> additionalHeaders) throws ApiException {
        String baseUrl = apiClient.getBaseURL(); String path = url.startsWith(baseUrl) ? url.substring(baseUrl.length()) : url;
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
