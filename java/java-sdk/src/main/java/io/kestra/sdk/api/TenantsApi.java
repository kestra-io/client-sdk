package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.PagedResultsTenant;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.Tenant;

import java.util.ArrayList;
import java.util.List;

public class TenantsApi extends BaseApi {

    public TenantsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public TenantsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- Path builders ----

    private String path(String... segments) {
        StringBuilder sb = new StringBuilder("/api/v1");
        for (String s : segments) {
            sb.append("/").append(esc(s));
        }
        return sb.toString();
    }

    // ========================================================================
    // CRUD (Instance-owner-only, no tenant)
    // ========================================================================

    public Tenant createTenant(
            @jakarta.annotation.Nonnull Tenant tenant) throws ApiException {
        return invoke("POST",
                path("tenants"),
                tenant, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Tenant tenant(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                path("tenants", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Tenant updateTenant(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Tenant tenant) throws ApiException {
        return invoke("PUT",
                path("tenants", id),
                tenant, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteTenant(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                path("tenants", id),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsTenant searchTenants(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                path("tenants", "search"),
                null,
                queryParams("page", page, "size", size),
                collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

}
