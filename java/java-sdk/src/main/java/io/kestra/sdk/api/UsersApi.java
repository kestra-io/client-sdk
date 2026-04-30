package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.ApiPatchSuperAdminRequest;
import io.kestra.sdk.model.ApiTokenList;
import io.kestra.sdk.model.CreateApiTokenRequest;
import io.kestra.sdk.model.CreateApiTokenResponse;
import io.kestra.sdk.model.IAMTenantAccessControllerApiUserTenantAccess;
import io.kestra.sdk.model.IAMTenantAccessControllerUserApiAutocomplete;
import io.kestra.sdk.model.IAMUserControllerApiCreateOrUpdateUserRequest;
import io.kestra.sdk.model.IAMUserControllerApiPatchRestrictedRequest;
import io.kestra.sdk.model.IAMUserControllerApiPatchUserPasswordRequest;
import io.kestra.sdk.model.IAMUserControllerApiUser;
import io.kestra.sdk.model.IAMUserGroupControllerApiUpdateUserGroupsRequest;
import io.kestra.sdk.model.MeControllerApiUpdatePasswordRequest;
import io.kestra.sdk.model.MeControllerApiUserDetailsRequest;
import io.kestra.sdk.model.PagedResultsIAMUserControllerApiUserSummary;
import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";

    public UsersApi() {
        super(Configuration.getDefaultApiClient());
    }

    public UsersApi(ApiClient apiClient) {
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
    // CRUD (Superadmin-scoped, no tenant)
    // ========================================================================

    public IAMUserControllerApiUser createUser(
            @jakarta.annotation.Nonnull IAMUserControllerApiCreateOrUpdateUserRequest request) throws ApiException {
        return invoke("POST",
                path("users"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public IAMUserControllerApiUser user(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                path("users", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public IAMUserControllerApiUser updateUser(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull IAMUserControllerApiCreateOrUpdateUserRequest request) throws ApiException {
        return invoke("PUT",
                path("users", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteUser(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                path("users", id),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // User listing & search (Superadmin-scoped)
    // ========================================================================

    public PagedResultsIAMUserControllerApiUserSummary listUsers(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                path("users"),
                null,
                queryParams("page", page, "size", size),
                collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Patch operations (Superadmin-scoped)
    // ========================================================================

    public IAMUserControllerApiUser patchUser(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull MeControllerApiUserDetailsRequest request) throws ApiException {
        return invoke("PATCH",
                path("users", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void patchUserDemo(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull IAMUserControllerApiPatchRestrictedRequest request) throws ApiException {
        invoke("PATCH",
                path("users", id, "restricted"),
                request, null, null,
                null, JSON, null);
    }

    public IAMUserControllerApiUser patchUserPassword(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull IAMUserControllerApiPatchUserPasswordRequest request) throws ApiException {
        return invoke("PATCH",
                path("users", id, "password"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void patchUserSuperAdmin(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull ApiPatchSuperAdminRequest request) throws ApiException {
        invoke("PATCH",
                path("users", id, "superadmin"),
                request, null, null,
                null, JSON, null);
    }

    // ========================================================================
    // Auth methods
    // ========================================================================

    public IAMUserControllerApiUser deleteUserAuthMethod(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String auth) throws ApiException {
        return invoke("DELETE",
                path("users", id, "auths", auth),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void deleteRefreshToken(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                path("users", id, "refresh-token"),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // API tokens (Superadmin-scoped)
    // ========================================================================

    public CreateApiTokenResponse createApiTokensForUser(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull CreateApiTokenRequest request) throws ApiException {
        return invoke("POST",
                path("users", id, "api-tokens"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public ApiTokenList listApiTokensForUser(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                path("users", id, "api-tokens"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void deleteApiTokenForUser(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tokenId) throws ApiException {
        invoke("DELETE",
                path("users", id, "api-tokens", tokenId),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // Impersonation
    // ========================================================================

    public Object impersonate(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("POST",
                path("users", id, "impersonate"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Current user (me)
    // ========================================================================

    public Object updateCurrentUserPassword(
            @jakarta.annotation.Nonnull MeControllerApiUpdatePasswordRequest request) throws ApiException {
        return invoke("PUT",
                path("me", "password"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Tenant-scoped operations
    // ========================================================================

    public List<IAMTenantAccessControllerApiUserTenantAccess> autocompleteUsers(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMTenantAccessControllerUserApiAutocomplete request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "tenant-access", "autocomplete"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void updateUserGroups(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMUserGroupControllerApiUpdateUserGroupsRequest request) throws ApiException {
        invoke("PUT",
                tenantPath(tenant, "users", id, "groups"),
                request, null, null,
                null, JSON, null);
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
