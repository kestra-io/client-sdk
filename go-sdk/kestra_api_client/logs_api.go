package kestra_api_client

import (
	"context"
	"net/url"
	"os"
)

type LogsAPI struct {
	baseAPI
}

// logExecutionFilters builds the flat query params the per-execution log
// read/follow/download endpoints expect (minLevel, taskRunId, taskId, attempt).
func logExecutionFilters(minLevel, taskRunId, taskId *string, attempt *int) url.Values {
	return buildQueryParams("minLevel", minLevel, "taskRunId", taskRunId, "taskId", taskId, "attempt", attempt)
}

func (a *LogsAPI) ListLogsFromExecution(ctx context.Context, executionId, tenant string, minLevel, taskRunId, taskId *string, attempt *int) ([]LogEntry, error) {
	params := logExecutionFilters(minLevel, taskRunId, taskId, attempt)
	return doJSON[[]LogEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "logs", executionId), nil, params)
}

// FollowLogsFromExecution opens an SSE stream that emits log entries for an execution.
// The returned channel is closed when the stream ends or the context is cancelled.
// The server opens the stream with a synthetic empty entry (id "start") so the SSE
// initializes even when there are no logs yet; callers filtering on entry fields
// should skip entries without an execution id.
func (a *LogsAPI) FollowLogsFromExecution(ctx context.Context, executionId, tenant string, minLevel *string) (<-chan *LogEntry, error) {
	path := tenantPath(tenant, "logs", executionId, "follow")
	params := logExecutionFilters(minLevel, nil, nil, nil)
	return followSSE[LogEntry](&a.baseAPI, ctx, path, params)
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
