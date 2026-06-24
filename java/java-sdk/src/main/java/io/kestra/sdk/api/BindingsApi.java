package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.IAMBindingControllerApiBindingDetail;
import io.kestra.sdk.model.IAMBindingControllerApiCreateBindingRequest;
import io.kestra.sdk.model.PagedResultsIAMBindingControllerApiBindingDetail;
import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BindingsApi extends BaseApi {

    public BindingsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public BindingsApi(ApiClient apiClient) {
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

    public IAMBindingControllerApiBindingDetail createBinding(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull IAMBindingControllerApiCreateBindingRequest request) throws ApiException {
        return postJson(
                tenantPath(tenant, "bindings"),
                request, Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public void deleteBinding(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "bindings", id));
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsIAMBindingControllerApiBindingDetail searchBindings(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "bindings", "search"),
                queryParams("page", page, "size", size),
                collectionParams,
                new TypeReference<>() {});
    }

}
