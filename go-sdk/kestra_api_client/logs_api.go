package kestra_api_client

import (
	"context"
	"net/url"
	"os"
)

type LogsAPI struct {
	baseAPI
}

// logExecutionFilters translates the legacy per-request log filter params into
// the unified `filters` array Kestra 2.0 expects on the per-execution log read
// endpoints (the DELETE endpoint still takes the legacy params).
func logExecutionFilters(minLevel, taskRunId, taskId *string, attempt *int) url.Values {
	var filters []SearchFilter
	filters = appendStringFilterOp(filters, FilterMinLevel, OpGreaterThanOrEqualTo, minLevel)
	filters = appendStringFilter(filters, FilterTaskRunId, taskRunId)
	filters = appendStringFilter(filters, FilterTaskId, taskId)
	filters = appendIntFilter(filters, FilterAttemptNumber, attempt)
	params := url.Values{}
	appendFilterParams(params, filters)
	return params
}

func (a *LogsAPI) ListLogsFromExecution(ctx context.Context, executionId, tenant string, minLevel, taskRunId, taskId *string, attempt *int) ([]LogEntry, error) {
	params := logExecutionFilters(minLevel, taskRunId, taskId, attempt)
	return doJSON[[]LogEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "logs", executionId), nil, params)
}

func (a *LogsAPI) DownloadLogsFromExecution(ctx context.Context, executionId, tenant string, minLevel, taskRunId, taskId *string, attempt *int) (*os.File, error) {
	params := logExecutionFilters(minLevel, taskRunId, taskId, attempt)
	return a.doDownload(ctx, "GET", tenantPath(tenant, "logs", executionId, "download"), nil, params, contentPlainText)
}

func (a *LogsAPI) DeleteLogsFromExecution(ctx context.Context, executionId, tenant string, minLevel, taskRunId, taskId *string, attempt *int) error {
	params := buildQueryParams("minLevel", minLevel, "taskRunId", taskRunId, "taskId", taskId, "attempt", attempt)
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "logs", executionId), nil, params)
}

func (a *LogsAPI) DeleteLogsFromFlow(ctx context.Context, namespace, flowId, tenant string, triggerId *string) error {
	params := buildQueryParams("triggerId", triggerId)
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "logs", namespace, flowId), nil, params)
}

func (a *LogsAPI) SearchLogs(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsLogEntry, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsLogEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "logs", "search"), nil, params)
}
