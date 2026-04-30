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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RolesApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";

    public RolesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public RolesApi(ApiClient apiClient) {
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
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "roles", "search"),
                queryParams("page", page, "size", size),
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
