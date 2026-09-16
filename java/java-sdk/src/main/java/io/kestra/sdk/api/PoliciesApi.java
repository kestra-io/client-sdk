package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.ValidateConstraintViolation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Policy endpoints under {@code /api/v1/{tenant}/policies/**} (tenant scope) and
 * {@code /api/v1/instance/policies/**} (instance scope). A policy is authored as YAML,
 * so create/update/validate take a raw YAML {@code source} string; exports return the
 * raw octet-stream bytes.
 * <p>
 * Namespace-scoped policies ({@code /api/v1/{tenant}/namespaces/{namespace}/policies/**})
 * live on {@code NamespacesApi} alongside the other namespace endpoints. Instance-scoped
 * policies require the {@code IsInstanceOwner} role.
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

    // ========================================================================
    // Tenant-scoped policies
    // ========================================================================

    public Map<String, Object> searchPolicies(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "policies", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getPolicy(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "policies", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createPolicy(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String source) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "policies"),
                source, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public Map<String, Object> updatePolicy(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String source) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "policies", id),
                source, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public ValidateConstraintViolation validatePolicy(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String source) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "policies", "validate"),
                source, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public void deletePolicy(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "policies", id),
                null, null, null,
                JSON, null,
                null);
    }

    public BulkResponse deletePoliciesByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "policies", "delete", "by-ids"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> evaluatePolicy(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "policies", id, "evaluate"),
                null, queryParams("page", page, "size", size), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public byte[] exportPolicies(
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "policies", "export"),
                null, null, null,
                OCTET_STREAM, null,
                new TypeReference<>() {});
    }

    public byte[] exportPoliciesByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "policies", "export", "by-ids"),
                ids, null, null,
                OCTET_STREAM, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> importPolicies(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull File fileUpload) throws ApiException {
        Map<String, Object> formParams = new HashMap<>();
        formParams.put("fileUpload", fileUpload);
        return invoke("POST",
                tenantPath(tenant, "policies", "import"),
                null, null, null,
                JSON, MULTIPART, formParams,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Instance-scoped policies (IsInstanceOwner)
    // ========================================================================

    public Map<String, Object> searchInstancePolicies(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                apiPath("instance", "policies", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getInstancePolicy(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable String scope) throws ApiException {
        return invoke("GET",
                apiPath("instance", "policies", id),
                null, queryParams("scope", scope), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createInstancePolicy(
            @jakarta.annotation.Nonnull String source) throws ApiException {
        return invoke("POST",
                apiPath("instance", "policies"),
                source, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public Map<String, Object> updateInstancePolicy(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String source) throws ApiException {
        return invoke("PUT",
                apiPath("instance", "policies", id),
                source, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public ValidateConstraintViolation validateInstancePolicy(
            @jakarta.annotation.Nonnull String source) throws ApiException {
        return invoke("POST",
                apiPath("instance", "policies", "validate"),
                source, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public void deleteInstancePolicy(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                apiPath("instance", "policies", id),
                null, null, null,
                JSON, null,
                null);
    }

    public BulkResponse deleteInstancePoliciesByIds(
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("DELETE",
                apiPath("instance", "policies", "delete", "by-ids"),
                ids, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> evaluateInstancePolicy(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable String scope) throws ApiException {
        return invoke("GET",
                apiPath("instance", "policies", id, "evaluate"),
                null, queryParams("page", page, "size", size, "scope", scope), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public byte[] exportInstancePolicies() throws ApiException {
        return invoke("POST",
                apiPath("instance", "policies", "export"),
                null, null, null,
                OCTET_STREAM, null,
                new TypeReference<>() {});
    }

    public byte[] exportInstancePoliciesByIds(
            @jakarta.annotation.Nonnull List<String> ids) throws ApiException {
        return invoke("POST",
                apiPath("instance", "policies", "export", "by-ids"),
                ids, null, null,
                OCTET_STREAM, JSON,
                new TypeReference<>() {});
    }

}
