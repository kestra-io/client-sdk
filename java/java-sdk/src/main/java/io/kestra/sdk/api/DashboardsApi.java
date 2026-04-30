package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.ChartFiltersOverrides;
import io.kestra.sdk.model.DashboardControllerDashboardResponse;
import io.kestra.sdk.model.DashboardControllerPreviewRequest;
import io.kestra.sdk.model.DashboardSettings;
import io.kestra.sdk.model.PagedResultsDashboardControllerDashboardResponse;
import io.kestra.sdk.model.PagedResultsMapStringObject;
import io.kestra.sdk.model.ValidateConstraintViolation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardsApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String YAML = "application/x-yaml";
    private static final String OCTET_STREAM = "application/octet-stream";

    public DashboardsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public DashboardsApi(ApiClient apiClient) {
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

    public DashboardSettings defaultDashboards1(
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

    // ========================================================================
    // BaseApi override
    // ========================================================================

    @Override
    public <T> T invokeAPI(String url, String method, Object request,
                           TypeReference<T> returnType,
                           Map<String, String> additionalHeaders) throws ApiException {
        String path = url.replace(apiClient.getBaseURL(), "");
        return apiClient.invokeAPI(
                path, method,
                Collections.emptyList(), Collections.emptyList(), "",
                request,
                additionalHeaders != null ? additionalHeaders : new HashMap<>(),
                new HashMap<>(), new HashMap<>(),
                JSON, YAML, AUTH, returnType
        );
    }
}
