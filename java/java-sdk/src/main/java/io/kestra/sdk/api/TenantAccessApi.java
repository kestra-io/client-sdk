package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.IAMTenantAccessControllerApiCreateTenantAccessRequest;
import io.kestra.sdk.model.IAMTenantAccessControllerApiUserTenantAccess;
import io.kestra.sdk.model.PagedResultsIAMTenantAccessControllerApiUserTenantAccess;

import java.util.Collections;
import java.util.List;

public class TenantAccessApi extends BaseApi {

    public TenantAccessApi() {
        super(Configuration.getDefaultApiClient());
    }

    public TenantAccessApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- HTTP helpers ----

    private <T> T get(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                      TypeReference<T> returnType) throws ApiException {
        return invoke("GET", path, null, queryParams, collectionQueryParams,
                JSON, null, returnType);
    }

    private <T> T postJson(String path, Object body, List<Pair> queryParams,
                           List<Pair> collectionQueryParams,
                           TypeReference<T> returnType) throws ApiException {
        return invoke("POST", path, body, queryParams, collectionQueryParams,
                JSON, JSON, returnType);
    }

    private void delete(String path) throws ApiException {
        invoke("DELETE", path, null, Collections.emptyList(), Collections.emptyList(),
                null, null, null);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    public IAMTenantAccessControllerApiUserTenantAccess createTenantAccess(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMTenantAccessControllerApiCreateTenantAccessRequest request) throws ApiException {
        return postJson(
                tenantPath(tenant, "tenant-access"),
                request, Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public void deleteTenantAccess(
            @jakarta.annotation.Nonnull String userId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "tenant-access", userId));
    }

    // ========================================================================
    // List
    // ========================================================================

    public PagedResultsIAMTenantAccessControllerApiUserTenantAccess listTenantAccess(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return get(
                tenantPath(tenant, "tenant-access"),
                queryParams("page", page, "size", size),
                Collections.emptyList(),
                new TypeReference<>() {});
    }

}
