package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.PagedResultsApiPolicySummary;
import io.kestra.sdk.model.Policy;
import io.kestra.sdk.model.PolicyEvaluation;
import io.kestra.sdk.model.PolicyImportResult;
import io.kestra.sdk.model.PolicyPreviewRequest;
import io.kestra.sdk.model.PolicyPreviewResponse;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.ValidateConstraintViolation;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Governance Policies.
 *
 * <p>A policy is authored as YAML and sent as the raw source: the API parses it, stamps the
 * scope, tenant and namespace from the URL, and stores the source alongside the parsed model,
 * so create/update/validate take a {@code String} rather than a {@link Policy}.
 *
 * <p>The same ten operations exist at each of the three scopes — INSTANCE (super-admin,
 * not tenant-scoped), TENANT and NAMESPACE. {@code STATIC} policies are declared in the Kestra
 * configuration and are read-only through the API.
 */
public class PoliciesApi extends BaseApi {

    private static final String YAML = "application/x-yaml";
    private static final String OCTET_STREAM = "application/octet-stream";
    private static final String MULTIPART = "multipart/form-data";

    public PoliciesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public PoliciesApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- Path builders ----

    /** INSTANCE-scope policies are not tenant-scoped: the tenant segment is the literal "instance". */
    private String instanceBase(String... segments) {
        return tenantPath("instance", prepend("policies", segments));
    }

    private String tenantBase(String tenant, String... segments) {
        return tenantPath(tenant, prepend("policies", segments));
    }

    private String namespaceBase(String tenant, String namespace, String... segments) {
        String[] head = {"namespaces", namespace, "policies"};
        String[] all = new String[head.length + segments.length];
        System.arraycopy(head, 0, all, 0, head.length);
        System.arraycopy(segments, 0, all, head.length, segments.length);
        return tenantPath(tenant, all);
    }

    private static String[] prepend(String first, String[] rest) {
        String[] all = new String[rest.length + 1];
        all[0] = first;
        System.arraycopy(rest, 0, all, 1, rest.length);
        return all;
    }

    // ---- HTTP helpers ----

    private <T> T get(String path, List<Pair> queryParams, List<Pair> collectionQueryParams,
                      TypeReference<T> returnType) throws ApiException {
        return invoke("GET", path, null, queryParams, collectionQueryParams,
                JSON, null, new HashMap<>(), returnType);
    }

    private <T> T postYaml(String path, String source, TypeReference<T> returnType) throws ApiException {
        return invoke("POST", path, source, Collections.emptyList(), Collections.emptyList(),
                JSON, YAML, new HashMap<>(), returnType);
    }

    private <T> T putYaml(String path, String source, TypeReference<T> returnType) throws ApiException {
        return invoke("PUT", path, source, Collections.emptyList(), Collections.emptyList(),
                JSON, YAML, new HashMap<>(), returnType);
    }

    private <T> T postJson(String path, Object body, TypeReference<T> returnType) throws ApiException {
        return invoke("POST", path, body, Collections.emptyList(), Collections.emptyList(),
                JSON, JSON, new HashMap<>(), returnType);
    }

    private <T> T deleteJson(String path, Object body, TypeReference<T> returnType) throws ApiException {
        return invoke("DELETE", path, body, Collections.emptyList(), Collections.emptyList(),
                JSON, JSON, new HashMap<>(), returnType);
    }

    private void delete(String path) throws ApiException {
        invoke("DELETE", path, null, Collections.emptyList(), Collections.emptyList(),
                null, null, new HashMap<>(), null);
    }

    private byte[] download(String path, Object body) throws ApiException {
        return invoke("POST", path, body, Collections.emptyList(), Collections.emptyList(),
                OCTET_STREAM, body == null ? null : JSON, new HashMap<>(),
                new TypeReference<>() {});
    }

    private List<Pair> searchParams(Integer page, Integer size, List<String> sort, List<QueryFilter> filters,
                                    List<Pair> collectionParams) {
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return queryParams("page", page, "size", size);
    }

    // ========================================================================
    // INSTANCE scope
    // ========================================================================

    public Policy createInstancePolicy(@Nonnull String source) throws ApiException {
        return postYaml(instanceBase(), source, new TypeReference<>() {});
    }

    public Policy getInstancePolicy(@Nonnull String id) throws ApiException {
        return get(instanceBase(id), Collections.emptyList(), Collections.emptyList(), new TypeReference<>() {});
    }

    public Policy updateInstancePolicy(@Nonnull String id,
            @Nonnull String source) throws ApiException {
        return putYaml(instanceBase(id), source, new TypeReference<>() {});
    }

    public void deleteInstancePolicy(@Nonnull String id) throws ApiException {
        delete(instanceBase(id));
    }

    public BulkResponse deleteInstancePoliciesByIds(@Nonnull List<String> ids) throws ApiException {
        return deleteJson(instanceBase("delete", "by-ids"), ids, new TypeReference<>() {});
    }

    public PagedResultsApiPolicySummary searchInstancePolicies(@Nullable Integer page,
            @Nullable Integer size,
            @Nullable List<String> sort,
            @Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        List<Pair> params = searchParams(page, size, sort, filters, collectionParams);
        return get(instanceBase("search"), params, collectionParams, new TypeReference<>() {});
    }

    public ValidateConstraintViolation validateInstancePolicy(@Nonnull String source) throws ApiException {
        return postYaml(instanceBase("validate"), source, new TypeReference<>() {});
    }

    public PolicyEvaluation evaluateInstancePolicy(@Nonnull String id,
            @Nullable Integer page,
            @Nullable Integer size) throws ApiException {
        return get(instanceBase(id, "evaluate"), queryParams("page", page, "size", size),
                Collections.emptyList(), new TypeReference<>() {});
    }

    public byte[] exportInstancePolicies() throws ApiException {
        return download(instanceBase("export"), null);
    }

    public byte[] exportInstancePoliciesByIds(@Nonnull List<String> ids) throws ApiException {
        return download(instanceBase("export", "by-ids"), ids);
    }

    // ========================================================================
    // TENANT scope
    // ========================================================================

    public Policy createTenantPolicy(@Nonnull String tenant, @Nonnull String source) throws ApiException {
        return postYaml(tenantBase(tenant), source, new TypeReference<>() {});
    }

    public Policy getTenantPolicy(@Nonnull String tenant, @Nonnull String id) throws ApiException {
        return get(tenantBase(tenant, id), Collections.emptyList(), Collections.emptyList(), new TypeReference<>() {});
    }

    public Policy updateTenantPolicy(@Nonnull String tenant, @Nonnull String id,
            @Nonnull String source) throws ApiException {
        return putYaml(tenantBase(tenant, id), source, new TypeReference<>() {});
    }

    public void deleteTenantPolicy(@Nonnull String tenant, @Nonnull String id) throws ApiException {
        delete(tenantBase(tenant, id));
    }

    public BulkResponse deleteTenantPoliciesByIds(@Nonnull String tenant, @Nonnull List<String> ids) throws ApiException {
        return deleteJson(tenantBase(tenant, "delete", "by-ids"), ids, new TypeReference<>() {});
    }

    public PagedResultsApiPolicySummary searchPolicies(@Nonnull String tenant, @Nullable Integer page,
            @Nullable Integer size,
            @Nullable List<String> sort,
            @Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        List<Pair> params = searchParams(page, size, sort, filters, collectionParams);
        return get(tenantBase(tenant, "search"), params, collectionParams, new TypeReference<>() {});
    }

    public ValidateConstraintViolation validateTenantPolicy(@Nonnull String tenant, @Nonnull String source) throws ApiException {
        return postYaml(tenantBase(tenant, "validate"), source, new TypeReference<>() {});
    }

    public PolicyEvaluation evaluateTenantPolicy(@Nonnull String tenant, @Nonnull String id,
            @Nullable Integer page,
            @Nullable Integer size) throws ApiException {
        return get(tenantBase(tenant, id, "evaluate"), queryParams("page", page, "size", size),
                Collections.emptyList(), new TypeReference<>() {});
    }

    public byte[] exportTenantPolicies(@Nonnull String tenant) throws ApiException {
        return download(tenantBase(tenant, "export"), null);
    }

    public byte[] exportTenantPoliciesByIds(@Nonnull String tenant, @Nonnull List<String> ids) throws ApiException {
        return download(tenantBase(tenant, "export", "by-ids"), ids);
    }

    // ========================================================================
    // NAMESPACE scope
    // ========================================================================

    public Policy createNamespacePolicy(@Nonnull String tenant, @Nonnull String namespace, @Nonnull String source) throws ApiException {
        return postYaml(namespaceBase(tenant, namespace), source, new TypeReference<>() {});
    }

    public Policy getNamespacePolicy(@Nonnull String tenant, @Nonnull String namespace, @Nonnull String id) throws ApiException {
        return get(namespaceBase(tenant, namespace, id), Collections.emptyList(), Collections.emptyList(), new TypeReference<>() {});
    }

    public Policy updateNamespacePolicy(@Nonnull String tenant, @Nonnull String namespace, @Nonnull String id,
            @Nonnull String source) throws ApiException {
        return putYaml(namespaceBase(tenant, namespace, id), source, new TypeReference<>() {});
    }

    public void deleteNamespacePolicy(@Nonnull String tenant, @Nonnull String namespace, @Nonnull String id) throws ApiException {
        delete(namespaceBase(tenant, namespace, id));
    }

    public BulkResponse deleteNamespacePoliciesByIds(@Nonnull String tenant, @Nonnull String namespace, @Nonnull List<String> ids) throws ApiException {
        return deleteJson(namespaceBase(tenant, namespace, "delete", "by-ids"), ids, new TypeReference<>() {});
    }

    public PagedResultsApiPolicySummary searchNamespacePolicies(@Nonnull String tenant, @Nonnull String namespace, @Nullable Integer page,
            @Nullable Integer size,
            @Nullable List<String> sort,
            @Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        List<Pair> params = searchParams(page, size, sort, filters, collectionParams);
        return get(namespaceBase(tenant, namespace, "search"), params, collectionParams, new TypeReference<>() {});
    }

    public ValidateConstraintViolation validateNamespacePolicy(@Nonnull String tenant, @Nonnull String namespace, @Nonnull String source) throws ApiException {
        return postYaml(namespaceBase(tenant, namespace, "validate"), source, new TypeReference<>() {});
    }

    public PolicyEvaluation evaluateNamespacePolicy(@Nonnull String tenant, @Nonnull String namespace, @Nonnull String id,
            @Nullable Integer page,
            @Nullable Integer size) throws ApiException {
        return get(namespaceBase(tenant, namespace, id, "evaluate"), queryParams("page", page, "size", size),
                Collections.emptyList(), new TypeReference<>() {});
    }

    public byte[] exportNamespacePolicies(@Nonnull String tenant, @Nonnull String namespace) throws ApiException {
        return download(namespaceBase(tenant, namespace, "export"), null);
    }

    public byte[] exportNamespacePoliciesByIds(@Nonnull String tenant, @Nonnull String namespace, @Nonnull List<String> ids) throws ApiException {
        return download(namespaceBase(tenant, namespace, "export", "by-ids"), ids);
    }

    // ========================================================================
    // Import & Preview (tenant scope only)
    // ========================================================================

    public PolicyImportResult importPolicies(@Nonnull String tenant,
            @Nullable File fileUpload) throws ApiException {
        Map<String, Object> formParams = new HashMap<>();
        if (fileUpload != null) {
            formParams.put("fileUpload", fileUpload);
        }
        return invoke("POST", tenantBase(tenant, "import"),
                null, Collections.emptyList(), Collections.emptyList(),
                JSON, MULTIPART, formParams,
                new TypeReference<>() {});
    }

    /** Previews the policies that would apply to a flow, without persisting anything. */
    public PolicyPreviewResponse previewPolicies(@Nonnull String tenant,
            @Nonnull PolicyPreviewRequest request) throws ApiException {
        return postJson(tenantPath(tenant, "flows", "policies", "preview"), request,
                new TypeReference<>() {});
    }

}
