package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.model.ChartFiltersOverrides;
import io.kestra.sdk.model.DashboardControllerDashboardResponse;
import io.kestra.sdk.model.DashboardControllerPreviewRequest;
import io.kestra.sdk.model.DashboardSettings;
import io.kestra.sdk.model.PagedResultsDashboardControllerDashboardResponse;
import io.kestra.sdk.model.PagedResultsMapStringObject;
import io.kestra.sdk.model.ValidateConstraintViolation;

import java.util.List;

public class DashboardsApi extends BaseApi {

    private static final String YAML = "application/x-yaml";
    private static final String OCTET_STREAM = "application/octet-stream";

    public DashboardsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public DashboardsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    public DashboardControllerDashboardResponse createDashboard(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "dashboards"),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public DashboardControllerDashboardResponse dashboard(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "dashboards", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public DashboardControllerDashboardResponse updateDashboard(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "dashboards", id),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public void deleteDashboard(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "dashboards", id),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsDashboardControllerDashboardResponse searchDashboards(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable String q,
            @jakarta.annotation.Nullable List<String> sort) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "dashboards"),
                null,
                queryParams("page", page, "size", size, "q", q),
                csvParams("sort", sort),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Charts
    // ========================================================================

    public PagedResultsMapStringObject dashboardChartData(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String chartId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ChartFiltersOverrides filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "dashboards", id, "charts", chartId),
                filters, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public PagedResultsMapStringObject previewChart(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull DashboardControllerPreviewRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "dashboards", "charts", "preview"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public byte[] exportChartToCsv(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull DashboardControllerPreviewRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "dashboards", "charts", "export", "to-csv"),
                request, null, null,
                OCTET_STREAM, JSON,
                new TypeReference<>() {});
    }

    public byte[] exportDashboardChartDataToCSV(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String chartId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull ChartFiltersOverrides filters) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "dashboards", id, "charts", chartId, "export", "to-csv"),
                filters, null, null,
                OCTET_STREAM, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Settings
    // ========================================================================

    public DashboardSettings defaultDashboards(
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "dashboards", "settings", "default-dashboards"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Validation
    // ========================================================================

    public ValidateConstraintViolation validateDashboard(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "dashboards", "validate"),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public ValidateConstraintViolation validateChart(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "dashboards", "validate", "chart"),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

}
