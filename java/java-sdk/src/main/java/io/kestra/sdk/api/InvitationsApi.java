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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvitationsApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";

    public InvitationsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public InvitationsApi(ApiClient apiClient) {
        super(apiClient);
    }

    @Override
    public <T> T invokeAPI(String url, String method, Object request,
                           TypeReference<T> returnType, Map<String, String> additionalHeaders) throws ApiException {
        return apiClient.invokeAPI(url, method,
                Collections.emptyList(), Collections.emptyList(), "",
                request, additionalHeaders, new HashMap<>(), new HashMap<>(),
                JSON, JSON, AUTH, returnType);
    }

    private String tenantPath(String tenant, String... segments) {
        StringBuilder sb = new StringBuilder("/api/v1/");
        sb.append(apiClient.escapeString(apiClient.parameterToString(tenant)));
        for (String s : segments) {
            sb.append("/").append(apiClient.escapeString(apiClient.parameterToString(s)));
        }
        return sb.toString();
    }

    private <T> T callApi(String method, String path, Object body,
                          List<Pair> queryParams, List<Pair> collectionQueryParams,
                          String accept, String contentType,
                          TypeReference<T> returnType) throws ApiException {
        return apiClient.invokeAPI(path, method,
                queryParams != null ? queryParams : Collections.emptyList(),
                collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
                "", body, new HashMap<>(), new HashMap<>(), new HashMap<>(),
                accept, contentType, AUTH, returnType);
    }

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

    private List<Pair> csvParams(String name, List<String> values) {
        if (values == null || values.isEmpty()) return Collections.emptyList();
        return apiClient.parameterToPairs("csv", name, values);
    }

    private List<Pair> filterParams(List<QueryFilter> filters) {
        if (filters == null || filters.isEmpty()) return Collections.emptyList();
        return apiClient.parameterToPairs("csv", "filters", filters);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    public void createInvitation(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMInvitationControllerApiInvitationCreateRequest request) throws ApiException {
        callApi("POST", tenantPath(tenant, "invitations"), request,
                Collections.emptyList(), Collections.emptyList(), JSON, JSON, null);
    }

    public List<IAMInvitationControllerApiInvitationDetail> listInvitationsByEmail(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String email) throws ApiException {
        return callApi("GET", tenantPath(tenant, "invitations", "email", email),
                null, Collections.emptyList(), Collections.emptyList(),
                JSON, null, new TypeReference<>() {});
    }

    public void deleteInvitation(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        callApi("DELETE", tenantPath(tenant, "invitations", id),
                null, Collections.emptyList(), Collections.emptyList(), null, null, null);
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
        return callApi("GET", tenantPath(tenant, "invitations", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null, new TypeReference<>() {});
    }
}
