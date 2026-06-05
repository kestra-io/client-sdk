package kestra_api_client

import (
	"context"
	"os"
)

type AppsAPI struct {
	baseAPI
}

func (a *AppsAPI) CreateApp(ctx context.Context, tenant, yamlBody string) (*AppsControllerApiAppSource, error) {
	return doJSONWithYAMLBody[*AppsControllerApiAppSource](&a.baseAPI, ctx, "POST", tenantPath(tenant, "apps"), yamlBody, nil)
}

func (a *AppsAPI) App(ctx context.Context, uid, tenant string) (*AppsControllerApiAppSource, error) {
	return doJSON[*AppsControllerApiAppSource](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", uid), nil, nil)
}

func (a *AppsAPI) UpdateApp(ctx context.Context, uid, tenant, yamlBody string) error {
	return a.doVoidYAML(ctx, "PUT", tenantPath(tenant, "apps", uid), yamlBody, nil)
}

func (a *AppsAPI) DeleteApp(ctx context.Context, uid, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "apps", uid), nil, nil)
}

func (a *AppsAPI) EnableApp(ctx context.Context, uid, tenant string) (*AppsControllerApiApp, error) {
	return doJSON[*AppsControllerApiApp](&a.baseAPI, ctx, "POST", tenantPath(tenant, "apps", uid, "enable"), nil, nil)
}

func (a *AppsAPI) DisableApp(ctx context.Context, uid, tenant string) (*AppsControllerApiApp, error) {
	return doJSON[*AppsControllerApiApp](&a.baseAPI, ctx, "POST", tenantPath(tenant, "apps", uid, "disable"), nil, nil)
}

func (a *AppsAPI) BulkDeleteApps(ctx context.Context, tenant string, request interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "apps"), request, nil)
}

func (a *AppsAPI) BulkEnableApps(ctx context.Context, tenant string, request interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "apps", "enable"), request, nil)
}

func (a *AppsAPI) BulkDisableApps(ctx context.Context, tenant string, request interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "apps", "disable"), request, nil)
}

func (a *AppsAPI) BulkExportApps(ctx context.Context, tenant string, request interface{}) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "apps", "export"), request, nil)
}

func (a *AppsAPI) BulkImportApps(ctx context.Context, tenant, filePath string) (*AppsControllerApiBulkImportResponse, error) {
	return doMultipartUpload[*AppsControllerApiBulkImportResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "apps", "import"), nil, "fileUpload", filePath)
}

func (a *AppsAPI) SearchApps(ctx context.Context, tenant string, page, size *int, q, namespace, flowId *string, sort, tags []string, filters []SearchFilter) (*PagedResultsAppsControllerApiApp, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	filters = appendStringFilter(filters, FilterQuery, q)
	filters = appendStringFilter(filters, FilterNamespace, namespace)
	filters = appendStringFilter(filters, FilterFlowId, flowId)
	filters = appendSliceFilter(filters, FilterTags, tags)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsAppsControllerApiApp](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "search"), nil, params)
}

func (a *AppsAPI) SearchAppsFromCatalog(ctx context.Context, tenant string, page, size *int, filters []SearchFilter) (*PagedResultsAppsControllerApiAppCatalogItem, error) {
	params := buildQueryParams("page", page, "size", size)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsAppsControllerApiAppCatalogItem](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "catalog"), nil, params)
}

func (a *AppsAPI) ListTags(ctx context.Context, tenant string) (*AppsControllerApiAppTags, error) {
	return doJSON[*AppsControllerApiAppTags](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "tags"), nil, nil)
}

func (a *AppsAPI) FileMetaFromAppExecution(ctx context.Context, id, tenant string, path string) (*FileMetas, error) {
	params := buildQueryParams("path", path)
	return doJSON[*FileMetas](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "view", id, "file", "meta"), nil, params)
}

func (a *AppsAPI) FilePreviewFromAppExecution(ctx context.Context, id, tenant string, path string, maxRows *int, encoding *string) (map[string]interface{}, error) {
	params := buildQueryParams("path", path, "maxRows", maxRows, "encoding", encoding)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "view", id, "file", "preview"), nil, params)
}

func (a *AppsAPI) LogsFromAppExecution(ctx context.Context, uid, tenant string, executionId *string, minLevel *string, taskIds []string) (*os.File, error) {
	params := buildQueryParams("executionId", executionId, "minLevel", minLevel)
	appendRepeatedParam(params, "taskIds", taskIds)
	return a.doDownload(ctx, "GET", tenantPath(tenant, "apps", "view", uid, "logs", "download"), nil, params)
}
