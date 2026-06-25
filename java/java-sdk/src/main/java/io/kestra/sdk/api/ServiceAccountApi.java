package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.ApiPatchSuperAdminRequest;
import io.kestra.sdk.model.CreateApiTokenRequest;
import io.kestra.sdk.model.IAMServiceAccountControllerApiCreateServiceAccountRequest;
import io.kestra.sdk.model.IAMServiceAccountControllerApiPatchServiceAccountRequest;
import io.kestra.sdk.model.IAMServiceAccountControllerApiServiceAccountDetail;
import io.kestra.sdk.model.IAMServiceAccountControllerApiServiceAccountRequest;
import io.kestra.sdk.model.IAMServiceAccountControllerApiServiceAccountResponse;
import io.kestra.sdk.model.PagedResultsIAMServiceAccountControllerApiServiceAccountDetail;
import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.List;

public class ServiceAccountApi extends BaseApi {

    public ServiceAccountApi() {
        super(Configuration.getDefaultApiClient());
    }

    public ServiceAccountApi(ApiClient apiClient) {
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

    public IAMServiceAccountControllerApiServiceAccountDetail createServiceAccount(
            @jakarta.annotation.Nonnull IAMServiceAccountControllerApiCreateServiceAccountRequest request) throws ApiException {
        return invoke("POST",
                path("service-accounts"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public IAMServiceAccountControllerApiServiceAccountDetail serviceAccount(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                path("service-accounts", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public IAMServiceAccountControllerApiServiceAccountDetail patchServiceAccountDetails(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull IAMServiceAccountControllerApiPatchServiceAccountRequest request) throws ApiException {
        return invoke("PATCH",
                path("service-accounts", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteServiceAccount(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                path("service-accounts", id),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // Superadmin patch
    // ========================================================================

    public void patchServiceAccountSuperAdmin(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull ApiPatchSuperAdminRequest request) throws ApiException {
        invoke("PATCH",
                path("service-accounts", id, "superadmin"),
                request, null, null,
                null, JSON, null);
    }

    // ========================================================================
    // Listing (Superadmin-scoped)
    // ========================================================================

    public PagedResultsIAMServiceAccountControllerApiServiceAccountDetail listServiceAccounts(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                path("service-accounts"),
                null,
                queryParams("page", page, "size", size),
                collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // API tokens (Superadmin-scoped, no tenant)
    // ========================================================================

    public Object createApiTokensForServiceAccount(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull CreateApiTokenRequest request) throws ApiException {
        return invoke("POST",
                path("service-accounts", id, "api-tokens"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object listApiTokensForServiceAccount(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                path("service-accounts", id, "api-tokens"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void deleteApiTokenForServiceAccount(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tokenId) throws ApiException {
        invoke("DELETE",
                path("service-accounts", id, "api-tokens", tokenId),
                null, null, null,
                JSON, null, null);
    }

    // ========================================================================
    // Tenant-scoped operations
    // ========================================================================

    public IAMServiceAccountControllerApiServiceAccountResponse createServiceAccountForTenant(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMServiceAccountControllerApiServiceAccountRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "service-accounts"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public IAMServiceAccountControllerApiServiceAccountResponse serviceAccountForTenant(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "service-accounts", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public IAMServiceAccountControllerApiServiceAccountResponse updateServiceAccount(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMServiceAccountControllerApiServiceAccountRequest request) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "service-accounts", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteServiceAccountForTenant(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "service-accounts", id),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // API tokens (Tenant-scoped)
    // ========================================================================

    public Object createApiTokensForServiceAccountWithTenant(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull CreateApiTokenRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "service-accounts", id, "api-tokens"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object listApiTokensForServiceAccountWithTenant(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "service-accounts", id, "api-tokens"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void deleteApiTokenForServiceAccountWithTenant(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tokenId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "service-accounts", id, "api-tokens", tokenId),
                null, null, null,
                JSON, null, null);
    }

}
