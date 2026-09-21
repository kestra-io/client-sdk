package kestra_api_client

import "context"

// MetricsAPI covers /api/v1/{tenant}/metrics — task/flow metric lookups. The EE
// controller is gated by the EXECUTION resource.
type MetricsAPI struct {
	baseAPI
}

// ExecutionMetrics returns a page of the metrics emitted by one execution,
// optionally narrowed to a task run or task id. Backs GET
// /api/v1/{tenant}/metrics/{executionId}.
func (a *MetricsAPI) ExecutionMetrics(ctx context.Context, executionId, tenant string, page, size *int, sort []string, taskRunId, taskId *string) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size, "taskRunId", taskRunId, "taskId", taskId)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "metrics", executionId), nil, params)
}

// FlowMetricNames lists the distinct metric names emitted by a flow. Backs GET
// /api/v1/{tenant}/metrics/names/{namespace}/{flowId}.
func (a *MetricsAPI) FlowMetricNames(ctx context.Context, namespace, flowId, tenant string) ([]string, error) {
	return doJSON[[]string](&a.baseAPI, ctx, "GET", tenantPath(tenant, "metrics", "names", namespace, flowId), nil, nil)
}

// TaskMetricNames lists the distinct metric names emitted by one task of a flow.
// Backs GET /api/v1/{tenant}/metrics/names/{namespace}/{flowId}/{taskId}.
func (a *MetricsAPI) TaskMetricNames(ctx context.Context, namespace, flowId, taskId, tenant string) ([]string, error) {
	return doJSON[[]string](&a.baseAPI, ctx, "GET", tenantPath(tenant, "metrics", "names", namespace, flowId, taskId), nil, nil)
}

// TasksWithMetrics lists the task ids of a flow that have emitted metrics. Backs
// GET /api/v1/{tenant}/metrics/tasks/{namespace}/{flowId}.
func (a *MetricsAPI) TasksWithMetrics(ctx context.Context, namespace, flowId, tenant string) ([]string, error) {
	return doJSON[[]string](&a.baseAPI, ctx, "GET", tenantPath(tenant, "metrics", "tasks", namespace, flowId), nil, nil)
}

// AggregateFlowMetric returns the time-bucketed aggregation of one metric across
// a flow's executions. `aggregation` is one of avg/sum/min/max (default sum);
// startDate/endDate are ISO-8601 timestamps (optional). Backs GET
// /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{metric}.
func (a *MetricsAPI) AggregateFlowMetric(ctx context.Context, namespace, flowId, metric, tenant string, startDate, endDate, aggregation *string) (map[string]interface{}, error) {
	params := buildQueryParams("startDate", startDate, "endDate", endDate, "aggregation", aggregation)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "metrics", "aggregates", namespace, flowId, metric), nil, params)
}

// AggregateTaskMetric returns the time-bucketed aggregation of one metric for a
// single task across a flow's executions. Backs GET
// /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{taskId}/{metric}.
func (a *MetricsAPI) AggregateTaskMetric(ctx context.Context, namespace, flowId, taskId, metric, tenant string, startDate, endDate, aggregation *string) (map[string]interface{}, error) {
	params := buildQueryParams("startDate", startDate, "endDate", endDate, "aggregation", aggregation)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "metrics", "aggregates", namespace, flowId, taskId, metric), nil, params)
}
