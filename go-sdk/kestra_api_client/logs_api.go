package kestra_api_client

import (
	"context"
	"os"
)

type LogsAPI struct {
	baseAPI
}

func (a *LogsAPI) ListLogsFromExecution(ctx context.Context, executionId, tenant string, minLevel, taskRunId, taskId *string, attempt *int) ([]LogEntry, error) {
	params := buildQueryParams("minLevel", minLevel, "taskRunId", taskRunId, "taskId", taskId, "attempt", attempt)
	return doJSON[[]LogEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "logs", executionId), nil, params)
}

func (a *LogsAPI) DownloadLogsFromExecution(ctx context.Context, executionId, tenant string, minLevel, taskRunId, taskId *string, attempt *int) (*os.File, error) {
	params := buildQueryParams("minLevel", minLevel, "taskRunId", taskRunId, "taskId", taskId, "attempt", attempt)
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

func (a *LogsAPI) SearchLogs(ctx context.Context, tenant string, page, size *int, sort []string, filters []QueryFilter) (*PagedResultsLogEntry, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsLogEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "logs", "search"), nil, params)
}
