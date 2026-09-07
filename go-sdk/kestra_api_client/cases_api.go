package kestra_api_client

import "context"

// CasesAPI covers /api/v1/{tenant}/cases.
type CasesAPI struct {
	baseAPI
}

// CreateCaseFromTask creates a case from a task run, or attaches the triggering
// execution to a matching already-open case. It backs the CreateCase plugin task,
// and is a check-then-act rather than an atomic operation: concurrent runs of the
// same task can each create their own case.
func (a *CasesAPI) CreateCaseFromTask(ctx context.Context, tenant string, request interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", "from-task"), request, nil)
}
