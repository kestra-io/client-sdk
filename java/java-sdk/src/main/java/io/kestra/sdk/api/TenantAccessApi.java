package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.IAMTenantAccessControllerApiCreateTenantAccessRequest;
import io.kestra.sdk.model.IAMTenantAccessControllerApiTenantAccess;
import io.kestra.sdk.model.PagedResultsIAMTenantAccessControllerApiUserTenantAccess;
import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Covers {@code /api/v1/{tenant}/tenant-access}.
 *
 * <p>Since Kestra 2.0 tenant access is a prerequisite rather than something granted
 * as a side effect: adding a user to a group resolves the user through a
 * {@code hasTenantAccess} filter and rejects it otherwise, so the access has to be
 * granted first through one of the create calls here.
 *
 * <p>There are two of those, mirroring the two server routes: {@link #createTenantAccess}
 * identifies the user by email, {@link #createTenantAccessById} by user id.
 */
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

    private void putNoBody(String path) throws ApiException {
        invoke("PUT", path, null, Collections.emptyList(), Collections.emptyList(),
                null, null, null);
    }

    private void delete(String path) throws ApiException {
        invoke("DELETE", path, null, Collections.emptyList(), Collections.emptyList(),
                null, null, null);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    public void createTenantAccess(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMTenantAccessControllerApiCreateTenantAccessRequest request) throws ApiException {
        invoke("POST", tenantPath(tenant, "tenant-access"), request,
                Collections.emptyList(), Collections.emptyList(), JSON, JSON, null);
    }

    public void createTenantAccessById(
            @jakarta.annotation.Nonnull String userId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        putNoBody(tenantPath(tenant, "tenant-access", userId));
    }

    public IAMTenantAccessControllerApiTenantAccess tenantAccess(
            @jakarta.annotation.Nonnull String userId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "tenant-access", userId),
                Collections.emptyList(),
                Collections.emptyList(),
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
        return listTenantAccess(tenant, page, size, null, null);
    }

    public PagedResultsIAMTenantAccessControllerApiUserTenantAccess listTenantAccess(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "tenant-access"),
                queryParams("page", page, "size", size),
                collectionParams,
                new TypeReference<>() {});
    }

}
