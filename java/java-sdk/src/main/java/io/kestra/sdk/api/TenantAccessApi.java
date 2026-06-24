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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TenantAccessApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";

    public TenantAccessApi() {
        super(Configuration.getDefaultApiClient());
    }

    public TenantAccessApi(ApiClient apiClient) {
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

    // ========================================================================
    // CRUD
    // ========================================================================

    public void createTenantAccess(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMTenantAccessControllerApiCreateTenantAccessRequest request) throws ApiException {
        callApi("POST", tenantPath(tenant, "tenant-access"), request,
                Collections.emptyList(), Collections.emptyList(), JSON, JSON, null);
    }

    public void deleteTenantAccess(
            @jakarta.annotation.Nonnull String userId,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        callApi("DELETE", tenantPath(tenant, "tenant-access", userId),
                null, Collections.emptyList(), Collections.emptyList(), null, null, null);
    }

    // ========================================================================
    // List
    // ========================================================================

    public PagedResultsIAMTenantAccessControllerApiUserTenantAccess listTenantAccess(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return callApi("GET", tenantPath(tenant, "tenant-access"),
                null, queryParams("page", page, "size", size), Collections.emptyList(),
                JSON, null, new TypeReference<>() {});
    }
}
