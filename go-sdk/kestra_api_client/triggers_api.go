package kestra_api_client

import "context"

type TriggersAPI struct {
	baseAPI
}

// ========================================================================
// Search
// ========================================================================

func (a *TriggersAPI) SearchTriggers(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsApiTriggerAndState, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsApiTriggerAndState](&a.baseAPI, ctx, "GET", tenantPath(tenant, "triggers", "search"), nil, params)
}

func (a *TriggersAPI) SearchTriggersForFlow(ctx context.Context, tenant, namespace, flowId string, page, size *int, q *string, sort []string) (*PagedResultsApiTriggerState, error) {
	params := buildQueryParams("page", page, "size", size, "q", q)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[*PagedResultsApiTriggerState](&a.baseAPI, ctx, "GET", tenantPath(tenant, "triggers", namespace, flowId), nil, params)
}

func (a *TriggersAPI) ExportTriggers(ctx context.Context, tenant string, filters []SearchFilter) (string, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return a.doCSV(ctx, tenantPath(tenant, "triggers", "export", "by-query", "csv"), params)
}

// ========================================================================
// Enable / Disable
// ========================================================================

func (a *TriggersAPI) DisabledTriggersByIds(ctx context.Context, tenant string, request TriggerControllerSetDisabledRequest) (*ApiAsyncOperationResponse, error) {
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "set-disabled", "by-triggers"), request, nil)
}

func (a *TriggersAPI) DisabledTriggersByQuery(ctx context.Context, tenant string, disabled *bool, filters []SearchFilter) (*ApiAsyncOperationResponse, error) {
	params := buildQueryParams("disabled", disabled)
	appendFilterParams(params, filters)
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "set-disabled", "by-query"), nil, params)
}

// ========================================================================
// Restart / Unlock
// ========================================================================

func (a *TriggersAPI) RestartTrigger(ctx context.Context, tenant, namespace, flowId, triggerId string) (*ApiTriggerState, error) {
	return doJSON[*ApiTriggerState](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", namespace, flowId, triggerId, "restart"), nil, nil)
}

func (a *TriggersAPI) UnlockTrigger(ctx context.Context, tenant, namespace, flowId, triggerId string) (*ApiTriggerState, error) {
	return doJSON[*ApiTriggerState](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", namespace, flowId, triggerId, "unlock"), nil, nil)
}

func (a *TriggersAPI) UnlockTriggersByIds(ctx context.Context, tenant string, triggerIds []TriggerControllerApiTriggerId) (*ApiAsyncOperationResponse, error) {
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "unlock", "by-triggers"), triggerIds, nil)
}

func (a *TriggersAPI) UnlockTriggersByQuery(ctx context.Context, tenant string, filters []SearchFilter) (*ApiAsyncOperationResponse, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "unlock", "by-query"), nil, params)
}

// ========================================================================
// Delete
// ========================================================================

func (a *TriggersAPI) DeleteTrigger(ctx context.Context, tenant, namespace, flowId, triggerId string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "triggers", namespace, flowId, triggerId), nil, nil)
}

func (a *TriggersAPI) DeleteTriggersByIds(ctx context.Context, tenant string, triggerIds []TriggerControllerApiTriggerId) (*ApiAsyncOperationResponse, error) {
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "triggers", "delete", "by-triggers"), triggerIds, nil)
}

func (a *TriggersAPI) DeleteTriggersByQuery(ctx context.Context, tenant string, request DeleteTriggersByQueryRequest) (*ApiAsyncOperationResponse, error) {
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "triggers", "delete", "by-query"), request, nil)
}

// ========================================================================
// Backfill
// ========================================================================

func (a *TriggersAPI) DeleteBackfill(ctx context.Context, tenant string, triggerId TriggerControllerApiTriggerId) (*ApiTriggerState, error) {
	return doJSON[*ApiTriggerState](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "backfill", "delete"), triggerId, nil)
}

func (a *TriggersAPI) DeleteBackfillByIds(ctx context.Context, tenant string, triggerIds []TriggerControllerApiTriggerId) (*ApiAsyncOperationResponse, error) {
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "backfill", "delete", "by-triggers"), triggerIds, nil)
}

func (a *TriggersAPI) DeleteBackfillByQuery(ctx context.Context, tenant string, filters []SearchFilter) (*ApiAsyncOperationResponse, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "backfill", "delete", "by-query"), nil, params)
}

// ========================================================================
// Backfill pause / unpause
// ========================================================================

func (a *TriggersAPI) PauseBackfill(ctx context.Context, tenant string, triggerId TriggerControllerApiTriggerId) (*ApiTriggerState, error) {
	return doJSON[*ApiTriggerState](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "triggers", "backfill", "pause"), triggerId, nil)
}

func (a *TriggersAPI) PauseBackfillByIds(ctx context.Context, tenant string, triggerIds []TriggerControllerApiTriggerId) (*ApiAsyncOperationResponse, error) {
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "backfill", "pause", "by-triggers"), triggerIds, nil)
}

func (a *TriggersAPI) PauseBackfillByQuery(ctx context.Context, tenant string, filters []SearchFilter) (*ApiAsyncOperationResponse, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "backfill", "pause", "by-query"), nil, params)
}

func (a *TriggersAPI) UnpauseBackfill(ctx context.Context, tenant string, triggerId TriggerControllerApiTriggerId) (*ApiTriggerState, error) {
	return doJSON[*ApiTriggerState](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "triggers", "backfill", "unpause"), triggerId, nil)
}

func (a *TriggersAPI) UnpauseBackfillByIds(ctx context.Context, tenant string, triggerIds []TriggerControllerApiTriggerId) (*ApiAsyncOperationResponse, error) {
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "backfill", "unpause", "by-triggers"), triggerIds, nil)
}

func (a *TriggersAPI) UnpauseBackfillByQuery(ctx context.Context, tenant string, filters []SearchFilter) (*ApiAsyncOperationResponse, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "triggers", "backfill", "unpause", "by-query"), nil, params)
}
