package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.IAMInvitationControllerApiInvitationCreateRequest;
import io.kestra.sdk.model.IAMInvitationControllerApiInvitationDetail;
import io.kestra.sdk.model.PagedResultsIAMInvitationControllerApiInvitationDetail;
import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvitationsApi extends BaseApi {

    public InvitationsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public InvitationsApi(ApiClient apiClient) {
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

    public IAMInvitationControllerApiInvitationDetail createInvitation(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMInvitationControllerApiInvitationCreateRequest request) throws ApiException {
        return postJson(
                tenantPath(tenant, "invitations"),
                request, Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public void deleteInvitation(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "invitations", id));
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsIAMInvitationControllerApiInvitationDetail searchInvitations(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "invitations", "search"),
                queryParams("page", page, "size", size),
                collectionParams,
                new TypeReference<>() {});
    }

}
