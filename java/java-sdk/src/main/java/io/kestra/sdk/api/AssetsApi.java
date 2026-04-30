package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.AssetsControllerApiAsset;
import io.kestra.sdk.model.AssetTopologyGraph;
import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.PagedResultsAssetsControllerApiAsset;
import io.kestra.sdk.model.PagedResultsAssetsControllerApiAssetLineageEvent;
import io.kestra.sdk.model.PagedResultsAssetsControllerApiAssetUsage;
import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetsApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String YAML = "application/x-yaml";

    public AssetsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public AssetsApi(ApiClient apiClient) {
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
    // CRUD
    // ========================================================================

    public AssetsControllerApiAsset createAsset(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "assets"),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public AssetsControllerApiAsset asset(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean allowDeleted) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "assets", id),
                null, queryParams("allowDeleted", allowDeleted), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void deleteAsset(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "assets", id),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // Dependencies
    // ========================================================================

    public AssetTopologyGraph assetDependencies(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Boolean destinationOnly,
            @jakarta.annotation.Nullable Boolean expandAll) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "assets", id, "dependencies"),
                null, queryParams("destinationOnly", destinationOnly, "expandAll", expandAll), null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Bulk delete
    // ========================================================================

    public BulkResponse deleteAssetsByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "assets", "by-ids"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public BulkResponse deleteAssetsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<QueryFilter> filters,
            @jakarta.annotation.Nullable Boolean purge) throws ApiException {
        List<Pair> collectionParams = filterParams(filters);
        return invoke("DELETE",
                tenantPath(tenant, "assets", "by-query"),
                null, queryParams("purge", purge), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public BulkResponse deleteAssetLineageEventsByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<QueryFilter> filters) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "assets", "lineage-events", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    public BulkResponse deleteAssetUsagesByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<QueryFilter> filters) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "assets", "usages", "by-query"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsAssetsControllerApiAsset searchAssets(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "assets", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public PagedResultsAssetsControllerApiAssetLineageEvent searchAssetLineageEvents(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "assets", "lineage-events", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public PagedResultsAssetsControllerApiAssetUsage searchAssetUsages(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "assets", "usages", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
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
