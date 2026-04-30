package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.ApiAutocomplete;
import io.kestra.sdk.model.ApiSecretMetaEE;
import io.kestra.sdk.model.ApiSecretValue;
import io.kestra.sdk.model.Namespace;
import io.kestra.sdk.model.NamespaceControllerApiInheritedPluginDefaultFromNamespace;
import io.kestra.sdk.model.PagedResultsNamespace;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamespacesApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String OCTET_STREAM = "application/octet-stream";
    private static final String MULTIPART = "multipart/form-data";

    public NamespacesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public NamespacesApi(ApiClient apiClient) {
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
                JSON, null, new HashMap<>(), returnType);
    }

    private <T> T postJson(String path, Object body,
                           TypeReference<T> returnType) throws ApiException {
        return invoke("POST", path, body, Collections.emptyList(), Collections.emptyList(),
                JSON, JSON, new HashMap<>(), returnType);
    }

    private <T> T putJson(String path, Object body,
                          TypeReference<T> returnType) throws ApiException {
        return invoke("PUT", path, body, Collections.emptyList(), Collections.emptyList(),
                JSON, JSON, new HashMap<>(), returnType);
    }

    private void delete(String path) throws ApiException {
        invoke("DELETE", path, null, Collections.emptyList(), Collections.emptyList(),
                null, null, new HashMap<>(), null);
    }

    private <T> T patchJson(String path, Object body,
                            TypeReference<T> returnType) throws ApiException {
        return invoke("PATCH", path, body, Collections.emptyList(), Collections.emptyList(),
                JSON, JSON, new HashMap<>(), returnType);
    }

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         Map<String, Object> formParams,
                         TypeReference<T> returnType) throws ApiException {
        return apiClient.invokeAPI(
                path, method,
                queryParams != null ? queryParams : Collections.emptyList(),
                collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
                "",
                body,
                new HashMap<>(),
                new HashMap<>(),
                formParams != null ? formParams : new HashMap<>(),
                accept, contentType, AUTH, returnType
        );
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    public Namespace createNamespace(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Namespace namespace) throws ApiException {
        return postJson(
                tenantPath(tenant, "namespaces"),
                namespace,
                new TypeReference<>() {});
    }

    public Namespace namespace(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", id),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public Namespace updateNamespace(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Namespace namespace) throws ApiException {
        return putJson(
                tenantPath(tenant, "namespaces", id),
                namespace,
                new TypeReference<>() {});
    }

    public void deleteNamespace(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "namespaces", id));
    }

    // ========================================================================
    // Search & Autocomplete
    // ========================================================================

    public PagedResultsNamespace searchNamespaces(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String q,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable Boolean existing) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        return get(
                tenantPath(tenant, "namespaces", "search"),
                queryParams("q", q, "page", page, "size", size, "existing", existing),
                collectionParams,
                new TypeReference<>() {});
    }

    public List<String> autocompleteNamespaces(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ApiAutocomplete request) throws ApiException {
        return postJson(
                tenantPath(tenant, "namespaces", "autocomplete"),
                request,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Secrets
    // ========================================================================

    public List<ApiSecretMetaEE> putSecrets(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ApiSecretValue secretValue) throws ApiException {
        return putJson(
                tenantPath(tenant, "namespaces", namespace, "secrets"),
                secretValue,
                new TypeReference<>() {});
    }

    public List<ApiSecretMetaEE> patchSecret(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String key,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ApiSecretMetaEE meta) throws ApiException {
        return patchJson(
                tenantPath(tenant, "namespaces", namespace, "secrets", key),
                meta,
                new TypeReference<>() {});
    }

    public void deleteSecret(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String key,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "namespaces", namespace, "secrets", key));
    }

    public Map<String, List<String>> inheritedSecrets(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "inherited-secrets"),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    // ========================================================================
    // Variables
    // ========================================================================

    public Map<String, Object> inheritedVariables(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", id, "inherited-variables"),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    // ========================================================================
    // Plugin Defaults
    // ========================================================================

    public List<NamespaceControllerApiInheritedPluginDefaultFromNamespace> inheritedPluginDefaults(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", id, "inherited-plugindefaults"),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public byte[] exportPluginDefaults(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "namespaces", id, "plugindefaults", "export"),
                null, Collections.emptyList(), Collections.emptyList(),
                OCTET_STREAM, null, new HashMap<>(),
                new TypeReference<>() {});
    }

    public List<String> importPluginDefaults(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable File fileUpload) throws ApiException {
        Map<String, Object> formParams = new HashMap<>();
        if (fileUpload != null) {
            formParams.put("fileUpload", fileUpload);
        }
        return invoke("POST",
                tenantPath(tenant, "namespaces", id, "plugindefaults", "import"),
                null, Collections.emptyList(), Collections.emptyList(),
                JSON, MULTIPART, formParams,
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
