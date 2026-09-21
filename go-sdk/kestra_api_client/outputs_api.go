package kestra_api_client

import (
	"context"
)

type OutputsAPI struct {
	baseAPI
}

// ExecutionOutputs returns the flow-level outputs of an execution. Kestra 2.0
// dropped the `outputs` property from the execution payload itself, so this is
// the only way to read them.
func (a *OutputsAPI) ExecutionOutputs(ctx context.Context, executionId, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "outputs", "executions", executionId), nil, nil)
}

// TaskOutputsInformation lists the task runs of an execution that have outputs.
func (a *OutputsAPI) TaskOutputsInformation(ctx context.Context, executionId, tenant string) ([]OutputControllerTaskOutputInformation, error) {
	return doJSON[[]OutputControllerTaskOutputInformation](&a.baseAPI, ctx, "GET", tenantPath(tenant, "outputs", "tasks", executionId), nil, nil)
}

// TaskRunOutputs returns the outputs of a single task run.
func (a *OutputsAPI) TaskRunOutputs(ctx context.Context, executionId, taskRunId, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "outputs", "tasks", executionId, taskRunId), nil, nil)
}
