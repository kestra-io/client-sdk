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
import java.util.List;

public class UsersApi extends BaseApi {

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

}
