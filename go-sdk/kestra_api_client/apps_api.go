package kestra_api_client

import (
	"context"
	"net/http"
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
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsAppsControllerApiApp](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "search"), nil, params)
}

func (a *AppsAPI) SearchAppsFromCatalog(ctx context.Context, tenant string, page, size *int, filters []SearchFilter) (*PagedResultsAppsControllerApiAppCatalogItem, error) {
	params := buildQueryParams("page", page, "size", size)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
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

// StreamAppEventsFromApp follows an app's event stream. The channel is closed when
// the stream ends or ctx is cancelled.
func (a *AppsAPI) StreamAppEvents(ctx context.Context, id, stream, tenant string) (<-chan *EventAppResponse, error) {
	return followSSE[EventAppResponse](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "view", id, "streams", stream), nil)
}

// AppStates lists the possible app execution-layout state names. Backs GET
// /api/v1/{tenant}/apps/states.
func (a *AppsAPI) AppStates(ctx context.Context, tenant string) ([]string, error) {
	return doJSON[[]string](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "states"), nil, nil)
}

// OpenAppView renders a published app's current layout. Backs GET
// /api/v1/{tenant}/apps/view/{uid}.
func (a *AppsAPI) OpenAppView(ctx context.Context, uid, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "apps", "view", uid), nil, nil)
}

// DownloadFileFromAppExecution downloads a file produced by an app execution.
// Backs GET /api/v1/{tenant}/apps/view/{id}/file/download.
func (a *AppsAPI) DownloadFileFromAppExecution(ctx context.Context, id, tenant, path string) (*os.File, error) {
	params := buildQueryParams("path", path)
	return a.doDownload(ctx, "GET", tenantPath(tenant, "apps", "view", id, "file", "download"), nil, params)
}

// PreviewApp renders an app layout from its YAML source without persisting it.
// `state` is an optional execution-layout state. Backs POST /api/v1/{tenant}/apps/preview.
func (a *AppsAPI) PreviewApp(ctx context.Context, tenant, yamlSource string, state *string) (map[string]interface{}, error) {
	params := buildQueryParams("state", state)
	return doJSONWithYAMLBody[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "apps", "preview"), yamlSource, params)
}

// PreviewDispatchApp dispatches an app preview with multipart input data. The
// YAML source goes in the `__kestra_app_source__` form field; every app input is
// an additional form field. Returns the raw response for the caller to read.
// Backs POST /api/v1/{tenant}/apps/preview/dispatch/{dispatch}.
func (a *AppsAPI) PreviewDispatchApp(ctx context.Context, dispatch, tenant string, formParams map[string]interface{}) (*http.Response, error) {
	return a.doMultipartJSON(ctx, "POST", tenantPath(tenant, "apps", "preview", "dispatch", dispatch), nil, formParams)
}

// DispatchApp dispatches a published app with multipart input data. Returns the
// raw response for the caller to read. Backs POST
// /api/v1/{tenant}/apps/view/{id}/dispatch/{dispatch}.
func (a *AppsAPI) DispatchApp(ctx context.Context, id, dispatch, tenant string, formParams map[string]interface{}) (*http.Response, error) {
	return a.doMultipartJSON(ctx, "POST", tenantPath(tenant, "apps", "view", id, "dispatch", dispatch), nil, formParams)
}
