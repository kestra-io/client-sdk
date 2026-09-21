package kestra_api_client

import (
	"context"
	"encoding/json"
	"os"
)

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

// ---- search / counts ----

// SearchCases returns a page of cases matching the given filters.
func (a *CasesAPI) SearchCases(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter, dateFilter *string) (*PagedResultsCase, error) {
	params := buildQueryParams("page", page, "size", size, "dateFilter", dateFilter)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsCase](&a.baseAPI, ctx, "GET", tenantPath(tenant, "cases", "search"), nil, params)
}

// CaseCounts returns the number of cases per status matching the given filters.
func (a *CasesAPI) CaseCounts(ctx context.Context, tenant string, filters []SearchFilter, dateFilter *string) (map[string]int64, error) {
	params := buildQueryParams("dateFilter", dateFilter)
	appendFilterParams(params, filters)
	return doJSON[map[string]int64](&a.baseAPI, ctx, "GET", tenantPath(tenant, "cases", "counts"), nil, params)
}

// CaseAssignees lists the distinct assignees among cases matching the given filters.
func (a *CasesAPI) CaseAssignees(ctx context.Context, tenant string, filters []SearchFilter, dateFilter *string) (*PagedResultsCaseSubjectRef, error) {
	params := buildQueryParams("dateFilter", dateFilter)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsCaseSubjectRef](&a.baseAPI, ctx, "GET", tenantPath(tenant, "cases", "assignees"), nil, params)
}

// ---- CRUD ----

// CreateCase creates a new case.
func (a *CasesAPI) CreateCase(ctx context.Context, tenant string, request CaseCreateRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases"), request, nil)
}

// GetCase retrieves a case by id. Set allowDeleted to also return a soft-deleted case.
func (a *CasesAPI) GetCase(ctx context.Context, tenant, id string, allowDeleted *bool) (*Case, error) {
	params := buildQueryParams("allowDeleted", allowDeleted)
	return doJSON[*Case](&a.baseAPI, ctx, "GET", tenantPath(tenant, "cases", id), nil, params)
}

// UpdateCase updates a case's mutable fields.
func (a *CasesAPI) UpdateCase(ctx context.Context, tenant, id string, request CaseUpdateRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "cases", id), request, nil)
}

// DeleteCase soft-deletes a case.
func (a *CasesAPI) DeleteCase(ctx context.Context, tenant, id string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "cases", id), nil, nil)
}

// DeleteCasesByIds deletes several cases at once, returning the number deleted.
func (a *CasesAPI) DeleteCasesByIds(ctx context.Context, tenant string, caseIds []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", "by-ids", "delete"), caseIds, nil)
}

// DeleteCasesByQuery deletes every case matching the given filters, returning the number deleted.
func (a *CasesAPI) DeleteCasesByQuery(ctx context.Context, tenant string, filters []SearchFilter, dateFilter *string) (*BulkResponse, error) {
	params := buildQueryParams("dateFilter", dateFilter)
	appendFilterParams(params, filters)
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "cases", "by-query"), nil, params)
}

// ---- lifecycle ----

// AcknowledgeCasesByIds acknowledges several cases at once, returning the number acknowledged.
func (a *CasesAPI) AcknowledgeCasesByIds(ctx context.Context, tenant string, caseIds []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", "by-ids", "acknowledge"), caseIds, nil)
}

// AcknowledgeCase acknowledges a single case.
func (a *CasesAPI) AcknowledgeCase(ctx context.Context, tenant, id string) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "acknowledge"), nil, nil)
}

// ResolveCase resolves a case with a reason and optional note.
func (a *CasesAPI) ResolveCase(ctx context.Context, tenant, id string, request CaseResolveRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "resolve"), request, nil)
}

// CancelCase cancels a case. The request body is optional.
func (a *CasesAPI) CancelCase(ctx context.Context, tenant, id string, request *CaseCancelRequest) (*Case, error) {
	var body interface{}
	if request != nil {
		body = request
	}
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "cancel"), body, nil)
}

// ChangeCaseStatus sets a case's status, optionally with a resolution.
func (a *CasesAPI) ChangeCaseStatus(ctx context.Context, tenant, id string, request CaseStatusRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "status"), request, nil)
}

// AssignCase sets a case's assignees and/or watchers.
func (a *CasesAPI) AssignCase(ctx context.Context, tenant, id string, request CaseAssignRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "assign"), request, nil)
}

// FollowCase adds the current user as a watcher of a case.
func (a *CasesAPI) FollowCase(ctx context.Context, tenant, id string) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "follow"), nil, nil)
}

// UnfollowCase removes the current user as a watcher of a case.
func (a *CasesAPI) UnfollowCase(ctx context.Context, tenant, id string) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "unfollow"), nil, nil)
}

// ---- events / comments / attachments ----

// CaseEvents returns a page of a case's events (comments and lifecycle events).
func (a *CasesAPI) CaseEvents(ctx context.Context, tenant, id string, page, size *int) (*PagedResultsCaseEvent, error) {
	params := buildQueryParams("page", page, "size", size)
	return doJSON[*PagedResultsCaseEvent](&a.baseAPI, ctx, "GET", tenantPath(tenant, "cases", id, "events"), nil, params)
}

// AddCaseComment posts a comment on a case, with an optional markdown body and an
// optional file attachment. Pass a nil filePath to comment without an attachment.
func (a *CasesAPI) AddCaseComment(ctx context.Context, tenant, id, body string, filePath *string) (*CaseEvent, error) {
	formParams := map[string]interface{}{}
	if body != "" {
		formParams["body"] = body
	}
	if filePath != nil {
		f, err := os.Open(*filePath)
		if err != nil {
			return nil, err
		}
		defer f.Close()
		formParams["files"] = f
	}

	resp, err := a.doMultipartJSON(ctx, "POST", tenantPath(tenant, "cases", id, "comments"), nil, formParams)
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()

	var event CaseEvent
	if err := json.NewDecoder(resp.Body).Decode(&event); err != nil {
		return nil, err
	}
	return &event, nil
}

// DownloadCaseAttachment downloads a comment attachment's raw bytes.
func (a *CasesAPI) DownloadCaseAttachment(ctx context.Context, tenant, id, attachmentId string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "GET", tenantPath(tenant, "cases", id, "attachments", attachmentId), nil, nil)
}

// ---- linked executions ----

// CaseExecutions returns a page of a case's linked executions.
func (a *CasesAPI) CaseExecutions(ctx context.Context, tenant, id string, page, size *int) (*PagedResultsCaseExecution, error) {
	params := buildQueryParams("page", page, "size", size)
	return doJSON[*PagedResultsCaseExecution](&a.baseAPI, ctx, "GET", tenantPath(tenant, "cases", id, "executions"), nil, params)
}

// LinkCaseExecutions links executions to a case by id.
func (a *CasesAPI) LinkCaseExecutions(ctx context.Context, tenant, id string, request CaseLinkExecutionsRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "executions"), request, nil)
}

// LinkCaseExecutionsByQuery links every execution matching the given filters to a case.
func (a *CasesAPI) LinkCaseExecutionsByQuery(ctx context.Context, tenant, id string, request CaseLinkExecutionsByQueryRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "executions", "by-query"), request, nil)
}

// UnlinkCaseExecution removes a linked execution from a case.
func (a *CasesAPI) UnlinkCaseExecution(ctx context.Context, tenant, id, executionId string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "cases", id, "executions", executionId), nil, nil)
}

// ---- auto-attach ----

// EnableCaseAutoAttach enables auto-attaching future matching executions to a case.
func (a *CasesAPI) EnableCaseAutoAttach(ctx context.Context, tenant, id string, request CaseAutoAttachRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "auto-attach"), request, nil)
}

// DisableCaseAutoAttach disables auto-attaching future executions to a case.
func (a *CasesAPI) DisableCaseAutoAttach(ctx context.Context, tenant, id string) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "cases", id, "auto-attach"), nil, nil)
}

// ---- creation from executions ----

// CreateCaseFromExecutions creates a case and links the given executions to it.
func (a *CasesAPI) CreateCaseFromExecutions(ctx context.Context, tenant string, request CaseFromExecutionsRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", "from-executions"), request, nil)
}

// CreateCaseFromExecutionsByQuery creates a case and links every execution matching the filters.
func (a *CasesAPI) CreateCaseFromExecutionsByQuery(ctx context.Context, tenant string, request CaseFromExecutionsByQueryRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", "from-executions", "by-query"), request, nil)
}

// CasesByExecutions returns, per execution id, the summaries of cases linked to it.
func (a *CasesAPI) CasesByExecutions(ctx context.Context, tenant string, executionIds []string) (map[string][]CaseSummary, error) {
	return doJSON[map[string][]CaseSummary](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", "by-executions"), executionIds, nil)
}

// ---- assets ----

// CaseAssets lists a case's linked assets (explicit and auto-detected).
func (a *CasesAPI) CaseAssets(ctx context.Context, tenant, id string) (*PagedResultsCaseAsset, error) {
	return doJSON[*PagedResultsCaseAsset](&a.baseAPI, ctx, "GET", tenantPath(tenant, "cases", id, "assets"), nil, nil)
}

// AttachCaseAsset explicitly links an asset to a case.
func (a *CasesAPI) AttachCaseAsset(ctx context.Context, tenant, id string, request CaseAttachAssetRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "assets"), request, nil)
}

// DetachCaseAsset unlinks an asset from a case.
func (a *CasesAPI) DetachCaseAsset(ctx context.Context, tenant, id, assetId string) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "cases", id, "assets", assetId), nil, nil)
}

// CasesByAsset lists the cases linked to an asset (explicit and auto-detected).
func (a *CasesAPI) CasesByAsset(ctx context.Context, tenant, assetId string) (*PagedResultsCaseSummary, error) {
	return doJSON[*PagedResultsCaseSummary](&a.baseAPI, ctx, "GET", tenantPath(tenant, "cases", "by-asset", assetId), nil, nil)
}

// ---- actions ----

// AttachCaseAction attaches a flow as a runnable action on a case.
func (a *CasesAPI) AttachCaseAction(ctx context.Context, tenant, id string, request CaseAttachActionRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "actions"), request, nil)
}

// UpdateCaseAction replaces an attached action's label or target flow.
func (a *CasesAPI) UpdateCaseAction(ctx context.Context, tenant, id, namespace, flowId string, request CaseAttachActionRequest) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "cases", id, "actions", namespace, flowId), request, nil)
}

// DetachCaseAction detaches a flow action from a case.
func (a *CasesAPI) DetachCaseAction(ctx context.Context, tenant, id, namespace, flowId string) (*Case, error) {
	return doJSON[*Case](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "cases", id, "actions", namespace, flowId), nil, nil)
}

// RunCaseAction runs one of a case's attached flow actions, returning the created execution id.
func (a *CasesAPI) RunCaseAction(ctx context.Context, tenant, id string, request CaseRunActionRequest) (map[string]string, error) {
	return doJSON[map[string]string](&a.baseAPI, ctx, "POST", tenantPath(tenant, "cases", id, "actions", "run"), request, nil)
}
