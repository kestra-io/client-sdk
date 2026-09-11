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
import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.Namespace;
import io.kestra.sdk.model.PagedResultsNamespace;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.ValidateConstraintViolation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamespacesApi extends BaseApi {

    private static final String OCTET_STREAM = "application/octet-stream";
    private static final String MULTIPART = "multipart/form-data";
    private static final String YAML = "application/x-yaml";

    public NamespacesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public NamespacesApi(ApiClient apiClient) {
        super(apiClient);
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

    private <T> T postYaml(String path, String body, List<Pair> queryParams,
                           TypeReference<T> returnType) throws ApiException {
        return invoke("POST", path, body, queryParams, Collections.emptyList(),
                JSON, YAML, returnType);
    }

    private <T> T putYaml(String path, String body,
                          TypeReference<T> returnType) throws ApiException {
        return invoke("PUT", path, body, Collections.emptyList(), Collections.emptyList(),
                JSON, YAML, returnType);
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
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable Boolean existing,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return get(
                tenantPath(tenant, "namespaces", "search"),
                queryParams("page", page, "size", size, "existing", existing),
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
    // Policies (EE)
    // ========================================================================

    public Map<String, Object> createNamespacePolicy(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String policy) throws ApiException {
        return postYaml(
                tenantPath(tenant, "namespaces", namespace, "policies"),
                policy, Collections.emptyList(),
                new TypeReference<>() {});
    }

    public Map<String, Object> getNamespacePolicy(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "policies", id),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public Map<String, Object> updateNamespacePolicy(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String policy) throws ApiException {
        return putYaml(
                tenantPath(tenant, "namespaces", namespace, "policies", id),
                policy,
                new TypeReference<>() {});
    }

    public void deleteNamespacePolicy(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "namespaces", namespace, "policies", id));
    }

    public BulkResponse deleteNamespacePoliciesByIds(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "namespaces", namespace, "policies", "delete", "by-ids"),
                ids, Collections.emptyList(), Collections.emptyList(),
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> searchNamespacePolicies(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "policies", "search"),
                queryParams("page", page, "size", size), filterParams(filters),
                new TypeReference<>() {});
    }

    public ValidateConstraintViolation validateNamespacePolicy(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String policy) throws ApiException {
        return postYaml(
                tenantPath(tenant, "namespaces", namespace, "policies", "validate"),
                policy, Collections.emptyList(),
                new TypeReference<>() {});
    }

    public byte[] exportNamespacePolicies(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "namespaces", namespace, "policies", "export"),
                null, Collections.emptyList(), Collections.emptyList(),
                OCTET_STREAM, null,
                new TypeReference<>() {});
    }

    public byte[] exportNamespacePoliciesByIds(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "namespaces", namespace, "policies", "export", "by-ids"),
                ids, Collections.emptyList(), Collections.emptyList(),
                OCTET_STREAM, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> evaluateNamespacePolicy(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "policies", id, "evaluate"),
                queryParams("page", page, "size", size), Collections.emptyList(),
                new TypeReference<>() {});
    }

    // ========================================================================
    // Reusable inputs (EE)
    // ========================================================================

    public Map<String, Object> listReusableInputs(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs"),
                queryParams("page", page, "size", size), Collections.emptyList(),
                new TypeReference<>() {});
    }

    public Map<String, Object> getReusableInputs(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer revision) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id),
                queryParams("revision", revision), Collections.emptyList(),
                new TypeReference<>() {});
    }

    /**
     * The server accepts the reusable-inputs source as YAML, JSON or plain text (all
     * declared as a raw {@code string} body); {@code body} is sent as-is as YAML, matching
     * the same raw-string convention as {@link #createNamespacePolicy}.
     */
    public Map<String, Object> createOrUpdateReusableInputs(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body,
            @jakarta.annotation.Nullable Boolean failIfExists) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id),
                body, queryParams("failIfExists", failIfExists), Collections.emptyList(),
                JSON, YAML,
                new TypeReference<>() {});
    }

    public void deleteReusableInputs(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        delete(tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id));
    }

    public List<Object> listReusableInputsRevisions(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return get(
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id, "revisions"),
                Collections.emptyList(), Collections.emptyList(),
                new TypeReference<>() {});
    }

}
