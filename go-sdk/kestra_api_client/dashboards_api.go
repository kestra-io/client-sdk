package kestra_api_client

import "context"

type DashboardsAPI struct {
	baseAPI
}

func (a *DashboardsAPI) CreateDashboard(ctx context.Context, tenant, yamlBody string) (*DashboardControllerDashboardResponse, error) {
	return doJSONWithYAMLBody[*DashboardControllerDashboardResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "dashboards"), yamlBody, nil)
}

func (a *DashboardsAPI) Dashboard(ctx context.Context, id, tenant string) (*DashboardControllerDashboardResponse, error) {
	return doJSON[*DashboardControllerDashboardResponse](&a.baseAPI, ctx, "GET", tenantPath(tenant, "dashboards", id), nil, nil)
}

func (a *DashboardsAPI) UpdateDashboard(ctx context.Context, id, tenant, yamlBody string) (*DashboardControllerDashboardResponse, error) {
	return doJSONWithYAMLBody[*DashboardControllerDashboardResponse](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "dashboards", id), yamlBody, nil)
}

func (a *DashboardsAPI) DeleteDashboard(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "dashboards", id), nil, nil)
}

func (a *DashboardsAPI) SearchDashboards(ctx context.Context, tenant string, page, size *int, q *string, sort []string) (*PagedResultsDashboardControllerDashboardResponse, error) {
	params := buildQueryParams("page", page, "size", size, "q", q)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[*PagedResultsDashboardControllerDashboardResponse](&a.baseAPI, ctx, "GET", tenantPath(tenant, "dashboards"), nil, params)
}

func (a *DashboardsAPI) DashboardChartData(ctx context.Context, id, chartId, tenant string, filters interface{}) (*PagedResultsMapStringObject, error) {
	return doJSON[*PagedResultsMapStringObject](&a.baseAPI, ctx, "POST", tenantPath(tenant, "dashboards", id, "charts", chartId), filters, nil)
}

func (a *DashboardsAPI) PreviewChart(ctx context.Context, tenant string, request interface{}) (*PagedResultsMapStringObject, error) {
	return doJSON[*PagedResultsMapStringObject](&a.baseAPI, ctx, "POST", tenantPath(tenant, "dashboards", "charts", "preview"), request, nil)
}

func (a *DashboardsAPI) ExportChartToCsv(ctx context.Context, tenant string, request interface{}) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "dashboards", "charts", "export", "to-csv"), request, nil)
}

func (a *DashboardsAPI) ExportDashboardChartDataToCSV(ctx context.Context, id, chartId, tenant string, filters interface{}) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "dashboards", id, "charts", chartId, "export", "to-csv"), filters, nil)
}

func (a *DashboardsAPI) DefaultDashboards(ctx context.Context, tenant string) (*DashboardSettings, error) {
	return doJSON[*DashboardSettings](&a.baseAPI, ctx, "GET", tenantPath(tenant, "dashboards", "settings", "default-dashboards"), nil, nil)
}

func (a *DashboardsAPI) ValidateDashboard(ctx context.Context, tenant, yamlBody string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", tenantPath(tenant, "dashboards", "validate"), yamlBody, nil)
}

func (a *DashboardsAPI) ValidateChart(ctx context.Context, tenant, yamlBody string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", tenantPath(tenant, "dashboards", "validate", "chart"), yamlBody, nil)
}
