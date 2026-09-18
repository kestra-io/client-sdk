package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Audit-log endpoints. These come in two scopes: instance-wide (across every tenant,
 * {@code /api/v1/auditlogs/**}, instance-owner only) and tenant-scoped
 * ({@code /api/v1/{tenant}/auditlogs/**}). All of them require the EE
 * {@code FEATURE_AUDIT_LOGS} license feature; the export endpoints stream CSV.
 */
public class AuditLogsApi extends BaseApi {

    private static final String CSV = "text/csv";

    public AuditLogsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public AuditLogsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ========================================================================
    // Instance-wide (all tenants)
    // ========================================================================

    /** Streams every tenant's audit log as CSV; returns the full CSV document. */
    public String exportAllAuditLogs(
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                apiPath("auditlogs", "export"),
                null, null, filterParams(filters),
                CSV, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> searchAllAuditLogs(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                apiPath("auditlogs", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getGlobalAuditLogDiff(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable String previousId) throws ApiException {
        return invoke("GET",
                apiPath("auditlogs", id, "diff"),
                null, queryParams("previousId", previousId), null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Tenant-scoped
    // ========================================================================

    /** Streams the tenant's audit log as CSV; returns the full CSV document. */
    public String exportAuditLogs(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "auditlogs", "export"),
                null, null, filterParams(filters),
                CSV, null,
                new TypeReference<>() {});
    }

    public List<Map<String, Object>> getAuditLogHistory(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String detailId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "auditlogs", "history", detailId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> searchAuditLogs(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "auditlogs", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getAuditLogDiff(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable String previousId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "auditlogs", id, "diff"),
                null, queryParams("previousId", previousId), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> findAuditLog(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "auditlogs", "find"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

}
