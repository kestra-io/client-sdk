package kestra_api_client

import (
	"bufio"
	"bytes"
	"context"
	"encoding/json"
	"mime/multipart"
	"net/url"
	"os"
	"strings"
)

// ExecutionsAPI provides methods for managing Kestra executions.
type ExecutionsAPI struct {
	baseAPI
}

// ========================================================================
// Create execution
// ========================================================================

// CreateExecution creates a new execution for the given flow.
// Labels are sent as individual multipart form fields with key "labels".
func (a *ExecutionsAPI) CreateExecution(
	ctx context.Context,
	tenant, namespace, id string,
	labels []string,
	wait *bool,
	revision *int,
	scheduleDate *string,
	breakpoints *bool,
	kind *string,
) (*ExecutionControllerExecutionResponse, error) {
	path := tenantPath(tenant, "executions", namespace, id)
	params := buildQueryParams(
		"wait", wait,
		"revision", revision,
		"scheduleDate", scheduleDate,
		"breakpoints", breakpoints,
		"kind", kind,
	)

	var buf bytes.Buffer
	writer := multipart.NewWriter(&buf)
	for _, l := range labels {
		_ = writer.WriteField("labels", l)
	}
	writer.Close()

	resp, err := a.doRequest(ctx, "POST", path, &buf, params, contentJSON, writer.FormDataContentType())
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()

	var result ExecutionControllerExecutionResponse
	if err := json.NewDecoder(resp.Body).Decode(&result); err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Get execution
// ========================================================================

// Execution retrieves a single execution by ID.
func (a *ExecutionsAPI) Execution(ctx context.Context, executionId, tenant string) (*ApiExecution, error) {
	path := tenantPath(tenant, "executions", executionId)
	result, err := doJSON[ApiExecution](&a.baseAPI, ctx, "GET", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Search
// ========================================================================

// SearchExecutions searches executions with pagination, sorting, and filters.
func (a *ExecutionsAPI) SearchExecutions(
	ctx context.Context,
	tenant string,
	page, size *int,
	sort []string,
	filters []SearchFilter,
) (*PagedResultsApiLightExecution, error) {
	path := tenantPath(tenant, "executions", "search")
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)

	result, err := doJSON[PagedResultsApiLightExecution](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// SearchExecutionsByFlowId searches executions for a specific flow.
func (a *ExecutionsAPI) SearchExecutionsByFlowId(
	ctx context.Context,
	tenant, namespace, flowId string,
	page, size *int,
) (*PagedResultsApiLightExecution, error) {
	path := tenantPath(tenant, "executions")
	params := buildQueryParams("namespace", namespace, "flowId", flowId, "page", page, "size", size)

	result, err := doJSON[PagedResultsApiLightExecution](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// LatestExecutions retrieves the latest execution for each flow matching the given filters.
func (a *ExecutionsAPI) LatestExecutions(
	ctx context.Context,
	tenant string,
	filters []ExecutionRepositoryInterfaceFlowFilter,
) ([]ExecutionControllerLastExecutionResponse, error) {
	path := tenantPath(tenant, "executions", "latest")
	result, err := doJSON[[]ExecutionControllerLastExecutionResponse](&a.baseAPI, ctx, "POST", path, filters, nil)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// ========================================================================
// Graph & flow
// ========================================================================

// ExecutionFlowGraph retrieves the flow graph for an execution.
func (a *ExecutionsAPI) ExecutionFlowGraph(
	ctx context.Context,
	executionId, tenant string,
	subflows []string,
) (*FlowGraph, error) {
	path := tenantPath(tenant, "executions", executionId, "graph")
	params := url.Values{}
	appendRepeatedParam(params, "subflows", subflows)

	result, err := doJSON[FlowGraph](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// FlowFromExecution retrieves the flow definition used by an execution.
func (a *ExecutionsAPI) FlowFromExecution(
	ctx context.Context,
	tenant, namespace, flowId string,
	revision *int,
) (*FlowForExecution, error) {
	path := tenantPath(tenant, "executions", "flows", namespace, flowId)
	params := buildQueryParams("revision", revision)

	result, err := doJSON[FlowForExecution](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// FlowFromExecutionById retrieves the flow definition from an execution ID.
func (a *ExecutionsAPI) FlowFromExecutionById(
	ctx context.Context,
	executionId, tenant string,
) (*FlowForExecution, error) {
	path := tenantPath(tenant, "executions", executionId, "flow")

	result, err := doJSON[FlowForExecution](&a.baseAPI, ctx, "GET", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// File operations
// ========================================================================

// DownloadFileFromExecution downloads a file from an execution's internal storage.
func (a *ExecutionsAPI) DownloadFileFromExecution(
	ctx context.Context,
	executionId, path, tenant string,
) (*os.File, error) {
	apiPath := tenantPath(tenant, "executions", executionId, "file")
	params := buildQueryParams("path", path)

	return a.doDownload(ctx, "GET", apiPath, nil, params)
}

// FileMetadatasFromExecution retrieves file metadata from an execution's internal storage.
func (a *ExecutionsAPI) FileMetadatasFromExecution(
	ctx context.Context,
	executionId, path, tenant string,
) (*FileMetas, error) {
	apiPath := tenantPath(tenant, "executions", executionId, "file", "metas")
	params := buildQueryParams("path", path)

	result, err := doJSON[FileMetas](&a.baseAPI, ctx, "GET", apiPath, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Eval expression
// ========================================================================

// EvalExpression evaluates a Pebble expression in the context of an execution.
func (a *ExecutionsAPI) EvalExpression(
	ctx context.Context,
	executionId, tenant, expression string,
) (*ExecutionControllerEvalResult, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "eval")

	result, err := doJSONWithTextBody[ExecutionControllerEvalResult](&a.baseAPI, ctx, "POST", path, expression, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Kill
// ========================================================================

// KillExecution kills a running execution.
func (a *ExecutionsAPI) KillExecution(
	ctx context.Context,
	executionId, tenant string,
	isOnKillCascade *bool,
) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "kill")
	params := buildQueryParams("isOnKillCascade", isOnKillCascade)

	// Kill endpoint returns text/json, use doRequest directly
	resp, err := a.doRequest(ctx, "DELETE", path, nil, params, "text/json", "")
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()

	var result Execution
	if err := json.NewDecoder(resp.Body).Decode(&result); err != nil {
		return nil, err
	}
	return &result, nil
}

// KillExecutionsByIds kills multiple executions by their IDs.
func (a *ExecutionsAPI) KillExecutionsByIds(
	ctx context.Context,
	tenant string,
	ids []string,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "kill", "by-ids")
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "DELETE", path, ids, nil)
}

// KillExecutionsByQuery kills executions matching the given filters.
func (a *ExecutionsAPI) KillExecutionsByQuery(
	ctx context.Context,
	tenant string,
	filters []SearchFilter,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "kill", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "DELETE", path, nil, params)
}

// ========================================================================
// Delete
// ========================================================================

// DeleteExecution deletes a single execution.
func (a *ExecutionsAPI) DeleteExecution(
	ctx context.Context,
	executionId, tenant string,
	deleteLogs, deleteMetrics, deleteStorage *bool,
) error {
	path := tenantPath(tenant, "executions", executionId)
	params := buildQueryParams(
		"deleteLogs", deleteLogs,
		"deleteMetrics", deleteMetrics,
		"deleteStorage", deleteStorage,
	)

	return a.doVoid(ctx, "DELETE", path, nil, params)
}

// DeleteExecutionsByIds deletes multiple executions by their IDs.
func (a *ExecutionsAPI) DeleteExecutionsByIds(
	ctx context.Context,
	tenant string,
	ids []string,
	includeNonTerminated, deleteLogs, deleteMetrics, deleteStorage *bool,
) (*BulkResponse, error) {
	path := tenantPath(tenant, "executions", "by-ids")
	params := buildQueryParams(
		"includeNonTerminated", includeNonTerminated,
		"deleteLogs", deleteLogs,
		"deleteMetrics", deleteMetrics,
		"deleteStorage", deleteStorage,
	)

	result, err := doJSON[BulkResponse](&a.baseAPI, ctx, "DELETE", path, ids, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// DeleteExecutionsByQuery deletes executions matching the given filters.
func (a *ExecutionsAPI) DeleteExecutionsByQuery(
	ctx context.Context,
	tenant string,
	filters []SearchFilter,
	includeNonTerminated, deleteLogs, deleteMetrics, deleteStorage *bool,
) (map[string]interface{}, error) {
	path := tenantPath(tenant, "executions", "by-query")
	params := buildQueryParams(
		"includeNonTerminated", includeNonTerminated,
		"deleteLogs", deleteLogs,
		"deleteMetrics", deleteMetrics,
		"deleteStorage", deleteStorage,
	)
	appendFilterParams(params, filters)

	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "DELETE", path, nil, params)
}

// ========================================================================
// Pause / Resume
// ========================================================================

// PauseExecution pauses a running execution.
func (a *ExecutionsAPI) PauseExecution(ctx context.Context, executionId, tenant string) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "pause")

	result, err := doJSON[Execution](&a.baseAPI, ctx, "POST", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// PauseExecutionsByIds pauses multiple executions by their IDs.
func (a *ExecutionsAPI) PauseExecutionsByIds(
	ctx context.Context,
	tenant string,
	ids []string,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "pause", "by-ids")
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, ids, nil)
}

// PauseExecutionsByQuery pauses executions matching the given filters.
func (a *ExecutionsAPI) PauseExecutionsByQuery(
	ctx context.Context,
	tenant string,
	filters []SearchFilter,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "pause", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, nil, params)
}

// ResumeExecution resumes a paused execution.
func (a *ExecutionsAPI) ResumeExecution(ctx context.Context, executionId, tenant string) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "resume")

	// Resume uses multipart content type (matching Java SDK)
	var buf bytes.Buffer
	writer := multipart.NewWriter(&buf)
	writer.Close()

	resp, err := a.doRequest(ctx, "POST", path, &buf, nil, contentJSON, writer.FormDataContentType())
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()

	var result Execution
	if err := json.NewDecoder(resp.Body).Decode(&result); err != nil {
		return nil, err
	}
	return &result, nil
}

// ResumeExecutionsByIds resumes multiple executions by their IDs.
func (a *ExecutionsAPI) ResumeExecutionsByIds(
	ctx context.Context,
	tenant string,
	ids []string,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "resume", "by-ids")
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, ids, nil)
}

// ResumeExecutionsByQuery resumes executions matching the given filters.
func (a *ExecutionsAPI) ResumeExecutionsByQuery(
	ctx context.Context,
	tenant string,
	filters []SearchFilter,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "resume", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, nil, params)
}

// ========================================================================
// Restart
// ========================================================================

// RestartExecution restarts a terminated execution.
func (a *ExecutionsAPI) RestartExecution(
	ctx context.Context,
	executionId, tenant string,
	revision *int,
) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "restart")
	params := buildQueryParams("revision", revision)

	result, err := doJSON[Execution](&a.baseAPI, ctx, "POST", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// RestartExecutionsByIds restarts multiple executions by their IDs.
func (a *ExecutionsAPI) RestartExecutionsByIds(
	ctx context.Context,
	tenant string,
	ids []string,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "restart", "by-ids")
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, ids, nil)
}

// RestartExecutionsByQuery restarts executions matching the given filters.
func (a *ExecutionsAPI) RestartExecutionsByQuery(
	ctx context.Context,
	tenant string,
	filters []SearchFilter,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "restart", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, nil, params)
}

// ========================================================================
// Replay
// ========================================================================

// ReplayExecution replays an execution from a specific task run.
func (a *ExecutionsAPI) ReplayExecution(
	ctx context.Context,
	executionId, tenant string,
	taskRunId *string,
	revision *int,
	breakpoints *bool,
) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "replay")
	params := buildQueryParams("taskRunId", taskRunId, "revision", revision, "breakpoints", breakpoints)

	result, err := doJSON[Execution](&a.baseAPI, ctx, "POST", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ReplayExecutionsByIds replays multiple executions by their IDs.
func (a *ExecutionsAPI) ReplayExecutionsByIds(
	ctx context.Context,
	tenant string,
	ids []string,
	latestRevision *bool,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "replay", "by-ids")
	params := buildQueryParams("latestRevision", latestRevision)
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, ids, params)
}

// ReplayExecutionsByQuery replays executions matching the given filters.
func (a *ExecutionsAPI) ReplayExecutionsByQuery(
	ctx context.Context,
	tenant string,
	filters []SearchFilter,
	latestRevision *bool,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "replay", "by-query")
	params := buildQueryParams("latestRevision", latestRevision)
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, nil, params)
}

// ========================================================================
// Force run
// ========================================================================

// ForceRunExecution forces a queued execution to run immediately.
func (a *ExecutionsAPI) ForceRunExecution(ctx context.Context, executionId, tenant string) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "force-run")

	result, err := doJSON[Execution](&a.baseAPI, ctx, "POST", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ForceRunByIds forces multiple queued executions to run by their IDs.
func (a *ExecutionsAPI) ForceRunByIds(
	ctx context.Context,
	tenant string,
	ids []string,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "force-run", "by-ids")
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, ids, nil)
}

// ForceRunExecutionsByQuery forces queued executions matching the given filters to run.
func (a *ExecutionsAPI) ForceRunExecutionsByQuery(
	ctx context.Context,
	tenant string,
	filters []SearchFilter,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "force-run", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, nil, params)
}

// ========================================================================
// Unqueue
// ========================================================================

// UnqueueExecution moves an execution out of the queue to a given state.
func (a *ExecutionsAPI) UnqueueExecution(
	ctx context.Context,
	executionId, tenant string,
	state *string,
) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "unqueue")
	params := buildQueryParams("state", state)

	result, err := doJSON[Execution](&a.baseAPI, ctx, "POST", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// UnqueueExecutionsByIds unqueues multiple executions by their IDs.
func (a *ExecutionsAPI) UnqueueExecutionsByIds(
	ctx context.Context,
	tenant string,
	state *string,
	ids []string,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "unqueue", "by-ids")
	params := buildQueryParams("state", state)
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, ids, params)
}

// UnqueueExecutionsByQuery unqueues executions matching the given filters.
func (a *ExecutionsAPI) UnqueueExecutionsByQuery(
	ctx context.Context,
	tenant string,
	newState *string,
	filters []SearchFilter,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "unqueue", "by-query")
	params := buildQueryParams("newState", newState)
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, nil, params)
}

// ========================================================================
// Labels
// ========================================================================

// SetLabelsOnTerminatedExecution sets labels on a terminated execution.
func (a *ExecutionsAPI) SetLabelsOnTerminatedExecution(
	ctx context.Context,
	executionId, tenant string,
	labels []Label,
) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "labels")

	result, err := doJSON[Execution](&a.baseAPI, ctx, "POST", path, labels, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// SetLabelsOnTerminatedExecutionsByIds sets labels on multiple terminated executions by their IDs.
func (a *ExecutionsAPI) SetLabelsOnTerminatedExecutionsByIds(
	ctx context.Context,
	tenant string,
	request ExecutionControllerSetLabelsByIdsRequest,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "labels", "by-ids")
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, request, nil)
}

// SetLabelsOnTerminatedExecutionsByQuery sets labels on terminated executions matching the given filters.
func (a *ExecutionsAPI) SetLabelsOnTerminatedExecutionsByQuery(
	ctx context.Context,
	tenant string,
	labels []Label,
	filters []SearchFilter,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "labels", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, labels, params)
}

// ========================================================================
// Change status
// ========================================================================

// UpdateExecutionStatus changes the status of a single execution.
func (a *ExecutionsAPI) UpdateExecutionStatus(
	ctx context.Context,
	executionId, status, tenant string,
) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "change-status")
	params := buildQueryParams("status", status)

	result, err := doJSON[Execution](&a.baseAPI, ctx, "POST", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// UpdateExecutionsStatusByIds changes the status of multiple executions by their IDs.
func (a *ExecutionsAPI) UpdateExecutionsStatusByIds(
	ctx context.Context,
	tenant, newStatus string,
	ids []string,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "change-status", "by-ids")
	params := buildQueryParams("newStatus", newStatus)
	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, ids, params)
}

// UpdateExecutionsStatusByQuery changes the status of executions matching the given filters.
func (a *ExecutionsAPI) UpdateExecutionsStatusByQuery(
	ctx context.Context,
	tenant, newStatus string,
	filters []SearchFilter,
) (*ApiAsyncOperationResponse, error) {
	path := tenantPath(tenant, "executions", "change-status", "by-query")
	params := buildQueryParams("newStatus", newStatus)
	appendFilterParams(params, filters)

	return doJSON[*ApiAsyncOperationResponse](&a.baseAPI, ctx, "POST", path, nil, params)
}

// ========================================================================
// Update task run state
// ========================================================================

// UpdateTaskRunState updates the state of a task run within an execution.
func (a *ExecutionsAPI) UpdateTaskRunState(
	ctx context.Context,
	executionId, tenant string,
	request interface{},
) (*Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "actions", "state")

	result, err := doJSON[Execution](&a.baseAPI, ctx, "POST", path, request, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Webhooks
// ========================================================================

// TriggerExecutionByGetWebhook triggers an execution via a GET webhook.
func (a *ExecutionsAPI) TriggerExecutionByGetWebhook(
	ctx context.Context,
	tenant, namespace, id, key string,
) (*WebhookResponse, error) {
	path := tenantPath(tenant, "executions", "webhook", namespace, id, key)

	result, err := doJSON[WebhookResponse](&a.baseAPI, ctx, "GET", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// TriggerExecutionByGetWebhookWithPath triggers an execution via a GET webhook with a path suffix.
func (a *ExecutionsAPI) TriggerExecutionByGetWebhookWithPath(
	ctx context.Context,
	tenant, namespace, id, key, path string,
) (*WebhookResponse, error) {
	apiPath := tenantPath(tenant, "executions", "webhook", namespace, id, key, path)

	result, err := doJSON[WebhookResponse](&a.baseAPI, ctx, "GET", apiPath, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// TriggerExecutionByPostWebhookWithPath triggers an execution via a POST webhook with a path suffix.
func (a *ExecutionsAPI) TriggerExecutionByPostWebhookWithPath(
	ctx context.Context,
	tenant, namespace, id, key, path string,
) (*WebhookResponse, error) {
	apiPath := tenantPath(tenant, "executions", "webhook", namespace, id, key, path)

	result, err := doJSON[WebhookResponse](&a.baseAPI, ctx, "POST", apiPath, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// TriggerExecutionByPutWebhookWithPath triggers an execution via a PUT webhook with a path suffix.
func (a *ExecutionsAPI) TriggerExecutionByPutWebhookWithPath(
	ctx context.Context,
	tenant, namespace, id, key, path string,
) (*WebhookResponse, error) {
	apiPath := tenantPath(tenant, "executions", "webhook", namespace, id, key, path)

	result, err := doJSON[WebhookResponse](&a.baseAPI, ctx, "PUT", apiPath, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Streaming (SSE)
// ========================================================================

// FollowExecution opens an SSE stream that emits execution updates.
// The returned channel is closed when the stream ends or the context is cancelled.
func (a *ExecutionsAPI) FollowExecution(
	ctx context.Context,
	executionId, tenant string,
) (<-chan *Execution, error) {
	path := tenantPath(tenant, "executions", executionId, "follow")

	resp, err := a.openSSEStream(ctx, path, nil)
	if err != nil {
		return nil, err
	}

	ch := make(chan *Execution)
	go func() {
		defer close(ch)
		defer resp.Body.Close()

		scanner := bufio.NewScanner(resp.Body)
		var dataBuffer strings.Builder

		for scanner.Scan() {
			line := scanner.Text()

			if line == "" {
				if dataBuffer.Len() > 0 {
					var ev Execution
					if err := json.Unmarshal([]byte(dataBuffer.String()), &ev); err == nil {
						select {
						case ch <- &ev:
						case <-ctx.Done():
							return
						}
					}
					dataBuffer.Reset()
				}
				continue
			}

			if strings.HasPrefix(line, "data:") {
				payload := line[5:]
				if strings.HasPrefix(payload, " ") {
					payload = payload[1:]
				}
				dataBuffer.WriteString(payload)
				dataBuffer.WriteByte('\n')
			}
		}

		// Flush any remaining data
		if dataBuffer.Len() > 0 {
			var ev Execution
			if err := json.Unmarshal([]byte(dataBuffer.String()), &ev); err == nil {
				select {
				case ch <- &ev:
				case <-ctx.Done():
				}
			}
		}
	}()

	return ch, nil
}

// FollowDependenciesExecution opens an SSE stream that emits execution status events
// for an execution and its dependencies.
func (a *ExecutionsAPI) FollowDependenciesExecution(
	ctx context.Context,
	executionId, tenant string,
	destinationOnly, expandAll *bool,
) (<-chan *ExecutionStatusEvent, error) {
	path := tenantPath(tenant, "executions", executionId, "follow-dependencies")
	params := buildQueryParams("destinationOnly", destinationOnly, "expandAll", expandAll)

	resp, err := a.openSSEStream(ctx, path, params)
	if err != nil {
		return nil, err
	}

	ch := make(chan *ExecutionStatusEvent)
	go func() {
		defer close(ch)
		defer resp.Body.Close()

		scanner := bufio.NewScanner(resp.Body)
		var dataBuffer strings.Builder

		for scanner.Scan() {
			line := scanner.Text()

			if line == "" {
				if dataBuffer.Len() > 0 {
					var ev ExecutionStatusEvent
					if err := json.Unmarshal([]byte(dataBuffer.String()), &ev); err == nil {
						select {
						case ch <- &ev:
						case <-ctx.Done():
							return
						}
					}
					dataBuffer.Reset()
				}
				continue
			}

			if strings.HasPrefix(line, "data:") {
				payload := line[5:]
				if strings.HasPrefix(payload, " ") {
					payload = payload[1:]
				}
				dataBuffer.WriteString(payload)
				dataBuffer.WriteByte('\n')
			}
		}

		// Flush any remaining data
		if dataBuffer.Len() > 0 {
			var ev ExecutionStatusEvent
			if err := json.Unmarshal([]byte(dataBuffer.String()), &ev); err == nil {
				select {
				case ch <- &ev:
				case <-ctx.Done():
				}
			}
		}
	}()

	return ch, nil
}
