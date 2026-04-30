package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.KVControllerApiDeleteBulkRequest;
import io.kestra.sdk.model.KVControllerApiDeleteBulkResponse;
import io.kestra.sdk.model.KVControllerKvDetail;
import io.kestra.sdk.model.KVEntry;
import io.kestra.sdk.model.PagedResultsKVEntry;
import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KvApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String TEXT_PLAIN = "text/plain";

    public KvApi() {
        super(Configuration.getDefaultApiClient());
    }

    public KvApi(ApiClient apiClient) {
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

    private <T> T deleteWithBody(String path, Object body, TypeReference<T> returnType) throws ApiException {
        return invoke("DELETE", path, body, Collections.emptyList(), Collections.emptyList(),
                JSON, JSON, returnType);
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
    // Key-Value CRUD
    // ========================================================================

    public void setKeyValue(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String key,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body) throws ApiException {
        invoke("PUT",
                tenantPath(tenant, "namespaces", namespace, "kv", key),
                body, Collections.emptyList(), Collections.emptyList(),
                null, TEXT_PLAIN, null);
    }

    public KVControllerKvDetail keyValue(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String key,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "kv", key),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public Boolean deleteKeyValue(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String key,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "namespaces", namespace, "kv", key),
                null, Collections.emptyList(), Collections.emptyList(),
                JSON, null, new TypeReference<>() {});
    }

    public KVControllerApiDeleteBulkResponse deleteKeyValues(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull KVControllerApiDeleteBulkRequest request) throws ApiException {
        return deleteWithBody(
                tenantPath(tenant, "namespaces", namespace, "kv"),
                request,
                new TypeReference<>() {});
    }

    // ========================================================================
    // List & Search
    // ========================================================================

    public PagedResultsKVEntry listAllKeys(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "kv"),
                queryParams("page", page, "size", size),
                collectionParams,
                new TypeReference<>() {});
    }

    public List<KVEntry> listKeysWithInheritance(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "kv", "inheritance"),
                Collections.emptyList(), Collections.emptyList(),
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
                JSON, TEXT_PLAIN, AUTH, returnType
        );
    }
}
