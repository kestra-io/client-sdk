package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.AssetsControllerApiAsset;
import io.kestra.sdk.model.AssetsControllerApiAssetLock;
import io.kestra.sdk.model.AssetsControllerAssetLockRequest;
import io.kestra.sdk.model.AssetTopologyGraph;
import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.PagedResultsAssetsControllerApiAsset;
import io.kestra.sdk.model.PagedResultsAssetsControllerApiAssetLineageEvent;
import io.kestra.sdk.model.PagedResultsAssetsControllerApiAssetUsage;
import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.List;

public class AssetsApi extends BaseApi {

    private static final String YAML = "application/x-yaml";

    public AssetsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public AssetsApi(ApiClient apiClient) {
        super(apiClient);
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
    // Lock
    // ========================================================================

    public AssetsControllerApiAssetLock lockAsset(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable AssetsControllerAssetLockRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "assets", id, "lock"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void unlockAsset(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String executionId) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "assets", id, "lock"),
                null, queryParams("executionId", executionId), null,
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

}
