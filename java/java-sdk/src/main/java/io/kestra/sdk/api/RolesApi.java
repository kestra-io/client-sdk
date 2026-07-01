package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.ApiAutocomplete;
import io.kestra.sdk.model.ApiIds;
import io.kestra.sdk.model.ApiRoleSummary;
import io.kestra.sdk.model.IAMRoleControllerApiRoleCreateOrUpdateRequest;
import io.kestra.sdk.model.IAMRoleControllerApiRoleDetail;
import io.kestra.sdk.model.PagedResultsApiRoleSummary;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RolesApi extends BaseApi {

    public RolesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public RolesApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- HTTP helpers ----

    private <T> T get(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                      TypeReference<T> returnType) throws ApiException {
        return invoke("GET", path, null, queryParams, collectionQueryParams,
                JSON, null, returnType);
    }

    private <T> T postJson(String path, Object body, List<Pair> queryParams,
                           TypeReference<T> returnType) throws ApiException {
        return invoke("POST", path, body, queryParams, Collections.emptyList(),
                JSON, JSON, returnType);
    }

    private <T> T putJson(String path, Object body, TypeReference<T> returnType) throws ApiException {
        return invoke("PUT", path, body, Collections.emptyList(), Collections.emptyList(),
                JSON, JSON, returnType);
    }

    private void delete(String path) throws ApiException {
        invoke("DELETE", path, null, Collections.emptyList(), Collections.emptyList(),
                null, null, null);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    public IAMRoleControllerApiRoleDetail createRole(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMRoleControllerApiRoleCreateOrUpdateRequest request) throws ApiException {
        return postJson(
                tenantPath(tenant, "roles"),
                request, Collections.emptyList(),
                new TypeReference<>() {});
    }

    public IAMRoleControllerApiRoleDetail role(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "roles", id),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public IAMRoleControllerApiRoleDetail updateRole(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMRoleControllerApiRoleCreateOrUpdateRequest request) throws ApiException {
        return putJson(
                tenantPath(tenant, "roles", id),
                request,
                new TypeReference<>() {});
    }

    public void deleteRole(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "roles", id));
    }

    // ========================================================================
    // Search & List
    // ========================================================================

    public PagedResultsApiRoleSummary searchRoles(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable String q,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "roles", "search"),
                queryParams("page", page, "size", size, "q", q),
                collectionParams,
                new TypeReference<>() {});
    }

    public List<ApiRoleSummary> autocompleteRoles(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ApiAutocomplete request) throws ApiException {
        return postJson(
                tenantPath(tenant, "roles", "autocomplete"),
                request, Collections.emptyList(),
                new TypeReference<>() {});
    }

    public List<Role> listRolesFromGivenIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ApiIds ids) throws ApiException {
        return postJson(
                tenantPath(tenant, "roles", "ids"),
                ids, Collections.emptyList(),
                new TypeReference<>() {});
    }

}
