# \ExecutionsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateExecution**](ExecutionsAPI.md#CreateExecution) | **Post** /api/v1/{tenant}/executions/{namespace}/{id} | Create a new execution for a flow
[**DeleteExecution**](ExecutionsAPI.md#DeleteExecution) | **Delete** /api/v1/{tenant}/executions/{executionId} | Delete an execution
[**DeleteExecutionsByIds**](ExecutionsAPI.md#DeleteExecutionsByIds) | **Delete** /api/v1/{tenant}/executions/by-ids | Delete a list of executions
[**DeleteExecutionsByQuery**](ExecutionsAPI.md#DeleteExecutionsByQuery) | **Delete** /api/v1/{tenant}/executions/by-query | Delete executions filter by query parameters
[**DownloadFileFromExecution**](ExecutionsAPI.md#DownloadFileFromExecution) | **Get** /api/v1/{tenant}/executions/{executionId}/file | Download file for an execution
[**EvalTaskRunExpression**](ExecutionsAPI.md#EvalTaskRunExpression) | **Post** /api/v1/{tenant}/executions/{executionId}/eval/{taskRunId} | Evaluate a variable expression for this taskrun
[**FollowDependenciesExecutions**](ExecutionsAPI.md#FollowDependenciesExecutions) | **Get** /api/v1/{tenant}/executions/{executionId}/follow-dependencies | Follow all execution dependencies executions
[**FollowExecution**](ExecutionsAPI.md#FollowExecution) | **Get** /api/v1/{tenant}/executions/{executionId}/follow | Follow an execution
[**ForceRunByIds**](ExecutionsAPI.md#ForceRunByIds) | **Post** /api/v1/{tenant}/executions/force-run/by-ids | Force run a list of executions
[**ForceRunExecution**](ExecutionsAPI.md#ForceRunExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/force-run | Force run an execution
[**ForceRunExecutionsByQuery**](ExecutionsAPI.md#ForceRunExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/force-run/by-query | Force run executions filter by query parameters
[**GetExecution**](ExecutionsAPI.md#GetExecution) | **Get** /api/v1/{tenant}/executions/{executionId} | Get an execution
[**GetExecutionFlowGraph**](ExecutionsAPI.md#GetExecutionFlowGraph) | **Get** /api/v1/{tenant}/executions/{executionId}/graph | Generate a graph for an execution
[**GetFileMetadatasFromExecution**](ExecutionsAPI.md#GetFileMetadatasFromExecution) | **Get** /api/v1/{tenant}/executions/{executionId}/file/metas | Get file meta information for an execution
[**GetFlowFromExecution**](ExecutionsAPI.md#GetFlowFromExecution) | **Get** /api/v1/{tenant}/executions/flows/{namespace}/{flowId} | Get flow information&#39;s for an execution
[**GetFlowFromExecutionById**](ExecutionsAPI.md#GetFlowFromExecutionById) | **Get** /api/v1/{tenant}/executions/{executionId}/flow | Get flow information&#39;s for an execution
[**GetLatestExecutions**](ExecutionsAPI.md#GetLatestExecutions) | **Post** /api/v1/{tenant}/executions/latest | Get the latest execution for given flows
[**KillExecution**](ExecutionsAPI.md#KillExecution) | **Delete** /api/v1/{tenant}/executions/{executionId}/kill | Kill an execution
[**KillExecutionsByIds**](ExecutionsAPI.md#KillExecutionsByIds) | **Delete** /api/v1/{tenant}/executions/kill/by-ids | Kill a list of executions
[**KillExecutionsByQuery**](ExecutionsAPI.md#KillExecutionsByQuery) | **Delete** /api/v1/{tenant}/executions/kill/by-query | Kill executions filter by query parameters
[**ListExecutableDistinctNamespaces**](ExecutionsAPI.md#ListExecutableDistinctNamespaces) | **Get** /api/v1/{tenant}/executions/namespaces | Get all namespaces that have executable flows
[**ListFlowExecutionsByNamespace**](ExecutionsAPI.md#ListFlowExecutionsByNamespace) | **Get** /api/v1/{tenant}/executions/namespaces/{namespace}/flows | Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.
[**PauseExecution**](ExecutionsAPI.md#PauseExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/pause | Pause a running execution.
[**PauseExecutionsByIds**](ExecutionsAPI.md#PauseExecutionsByIds) | **Post** /api/v1/{tenant}/executions/pause/by-ids | Pause a list of running executions
[**PauseExecutionsByQuery**](ExecutionsAPI.md#PauseExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/pause/by-query | Pause executions filter by query parameters
[**PreviewFileFromExecution**](ExecutionsAPI.md#PreviewFileFromExecution) | **Get** /api/v1/{tenant}/executions/{executionId}/file/preview | Get file preview for an execution
[**ReplayExecution**](ExecutionsAPI.md#ReplayExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/replay | Create a new execution from an old one and start it from a specified task run id
[**ReplayExecutionWithinputs**](ExecutionsAPI.md#ReplayExecutionWithinputs) | **Post** /api/v1/{tenant}/executions/{executionId}/replay-with-inputs | Create a new execution from an old one and start it from a specified task run id
[**ReplayExecutionsByIds**](ExecutionsAPI.md#ReplayExecutionsByIds) | **Post** /api/v1/{tenant}/executions/replay/by-ids | Create new executions from old ones. Keep the flow revision
[**ReplayExecutionsByQuery**](ExecutionsAPI.md#ReplayExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/replay/by-query | Create new executions from old ones filter by query parameters. Keep the flow revision
[**RestartExecution**](ExecutionsAPI.md#RestartExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/restart | Restart a new execution from an old one
[**RestartExecutionsByIds**](ExecutionsAPI.md#RestartExecutionsByIds) | **Post** /api/v1/{tenant}/executions/restart/by-ids | Restart a list of executions
[**RestartExecutionsByQuery**](ExecutionsAPI.md#RestartExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/restart/by-query | Restart executions filter by query parameters
[**ResumeExecution**](ExecutionsAPI.md#ResumeExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/resume | Resume a paused execution.
[**ResumeExecutionFromBreakpoint**](ExecutionsAPI.md#ResumeExecutionFromBreakpoint) | **Post** /api/v1/{tenant}/executions/{executionId}/resume-from-breakpoint | Resume an execution from a breakpoint (in the &#39;BREAKPOINT&#39; state).
[**ResumeExecutionsByIds**](ExecutionsAPI.md#ResumeExecutionsByIds) | **Post** /api/v1/{tenant}/executions/resume/by-ids | Resume a list of paused executions
[**ResumeExecutionsByQuery**](ExecutionsAPI.md#ResumeExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/resume/by-query | Resume executions filter by query parameters
[**SearchExecutions**](ExecutionsAPI.md#SearchExecutions) | **Get** /api/v1/{tenant}/executions/search | Search for executions
[**SearchExecutionsByFlowId**](ExecutionsAPI.md#SearchExecutionsByFlowId) | **Get** /api/v1/{tenant}/executions | Search for executions for a flow
[**SearchTaskRun**](ExecutionsAPI.md#SearchTaskRun) | **Get** /api/v1/{tenant}/taskruns/search | Search for taskruns, only available with the Elasticsearch repository
[**SetLabelsOnTerminatedExecution**](ExecutionsAPI.md#SetLabelsOnTerminatedExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/labels | Add or update labels of a terminated execution
[**SetLabelsOnTerminatedExecutionsByIds**](ExecutionsAPI.md#SetLabelsOnTerminatedExecutionsByIds) | **Post** /api/v1/{tenant}/executions/labels/by-ids | Set labels on a list of executions
[**SetLabelsOnTerminatedExecutionsByQuery**](ExecutionsAPI.md#SetLabelsOnTerminatedExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/labels/by-query | Set label on executions filter by query parameters
[**TriggerExecution**](ExecutionsAPI.md#TriggerExecution) | **Post** /api/v1/{tenant}/executions/trigger/{namespace}/{id} | Trigger a new execution for a flow
[**TriggerExecutionByGetWebhook**](ExecutionsAPI.md#TriggerExecutionByGetWebhook) | **Get** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by GET webhook trigger
[**TriggerExecutionByPostWebhook**](ExecutionsAPI.md#TriggerExecutionByPostWebhook) | **Post** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by POST webhook trigger
[**TriggerExecutionByPutWebhook**](ExecutionsAPI.md#TriggerExecutionByPutWebhook) | **Put** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by PUT webhook trigger
[**UnqueueExecution**](ExecutionsAPI.md#UnqueueExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/unqueue | Unqueue an execution
[**UnqueueExecutionsByIds**](ExecutionsAPI.md#UnqueueExecutionsByIds) | **Post** /api/v1/{tenant}/executions/unqueue/by-ids | Unqueue a list of executions
[**UnqueueExecutionsByQuery**](ExecutionsAPI.md#UnqueueExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/unqueue/by-query | Unqueue executions filter by query parameters
[**UpdateExecutionStatus**](ExecutionsAPI.md#UpdateExecutionStatus) | **Post** /api/v1/{tenant}/executions/{executionId}/change-status | Change the state of an execution
[**UpdateExecutionsStatusByIds**](ExecutionsAPI.md#UpdateExecutionsStatusByIds) | **Post** /api/v1/{tenant}/executions/change-status/by-ids | Change executions state by id
[**UpdateExecutionsStatusByQuery**](ExecutionsAPI.md#UpdateExecutionsStatusByQuery) | **Post** /api/v1/{tenant}/executions/change-status/by-query | Change executions state by query parameters
[**UpdateTaskRunState**](ExecutionsAPI.md#UpdateTaskRunState) | **Post** /api/v1/{tenant}/executions/{executionId}/state | Change state for a taskrun in an execution
[**ValidateNewExecutionInputs**](ExecutionsAPI.md#ValidateNewExecutionInputs) | **Post** /api/v1/{tenant}/executions/{namespace}/{id}/validate | Validate the creation of a new execution for a flow
[**ValidateResumeExecutionInputs**](ExecutionsAPI.md#ValidateResumeExecutionInputs) | **Post** /api/v1/{tenant}/executions/{executionId}/resume/validate | Validate inputs to resume a paused execution.



## CreateExecution

> ExecutionControllerExecutionResponse CreateExecution(ctx, namespace, id, tenant).Wait(wait).Labels(labels).Revision(revision).ScheduleDate(scheduleDate).Breakpoints(breakpoints).Kind(kind).Execute()

Create a new execution for a flow

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	wait := true // bool | If the server will wait the end of the execution (default to false)
	tenant := "tenant_example" // string | 
	labels := []string{"Inner_example"} // []string | The labels as a list of 'key:value' (optional)
	revision := int32(56) // int32 | The flow revision or latest if null (optional)
	scheduleDate := time.Now() // time.Time | Schedule the flow on a specific date (optional)
	breakpoints := "breakpoints_example" // string | Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)
	kind := openapiclient.ExecutionKind("NORMAL") // ExecutionKind | Specific execution kind (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.CreateExecution(context.Background(), namespace, id, tenant).Wait(wait).Labels(labels).Revision(revision).ScheduleDate(scheduleDate).Breakpoints(breakpoints).Kind(kind).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.CreateExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateExecution`: ExecutionControllerExecutionResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.CreateExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **wait** | **bool** | If the server will wait the end of the execution | [default to false]

 **labels** | **[]string** | The labels as a list of &#39;key:value&#39; | 
 **revision** | **int32** | The flow revision or latest if null | 
 **scheduleDate** | **time.Time** | Schedule the flow on a specific date | 
 **breakpoints** | **string** | Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | 
 **kind** | [**ExecutionKind**](ExecutionKind.md) | Specific execution kind | 

### Return type

[**ExecutionControllerExecutionResponse**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteExecution

> DeleteExecution(ctx, executionId, tenant).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).Execute()

Delete an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	deleteLogs := true // bool | Whether to delete execution logs (default to true)
	deleteMetrics := true // bool | Whether to delete execution metrics (default to true)
	deleteStorage := true // bool | Whether to delete execution files in the internal storage (default to true)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.ExecutionsAPI.DeleteExecution(context.Background(), executionId, tenant).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.DeleteExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteLogs** | **bool** | Whether to delete execution logs | [default to true]
 **deleteMetrics** | **bool** | Whether to delete execution metrics | [default to true]
 **deleteStorage** | **bool** | Whether to delete execution files in the internal storage | [default to true]


### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteExecutionsByIds

> BulkResponse DeleteExecutionsByIds(ctx, tenant).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).RequestBody(requestBody).IncludeNonTerminated(includeNonTerminated).Execute()

Delete a list of executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	deleteLogs := true // bool | Whether to delete execution logs (default to true)
	deleteMetrics := true // bool | Whether to delete execution metrics (default to true)
	deleteStorage := true // bool | Whether to delete execution files in the internal storage (default to true)
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The execution id
	includeNonTerminated := true // bool | Whether to delete non-terminated executions (optional) (default to false)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.DeleteExecutionsByIds(context.Background(), tenant).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).RequestBody(requestBody).IncludeNonTerminated(includeNonTerminated).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.DeleteExecutionsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteExecutionsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.DeleteExecutionsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteExecutionsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deleteLogs** | **bool** | Whether to delete execution logs | [default to true]
 **deleteMetrics** | **bool** | Whether to delete execution metrics | [default to true]
 **deleteStorage** | **bool** | Whether to delete execution files in the internal storage | [default to true]

 **requestBody** | **[]string** | The execution id | 
 **includeNonTerminated** | **bool** | Whether to delete non-terminated executions | [default to false]

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteExecutionsByQuery

> map[string]interface{} DeleteExecutionsByQuery(ctx, tenant).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).IncludeNonTerminated(includeNonTerminated).Execute()

Delete executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	deleteLogs := true // bool | Whether to delete execution logs (default to true)
	deleteMetrics := true // bool | Whether to delete execution metrics (default to true)
	deleteStorage := true // bool | Whether to delete execution files in the internal storage (default to true)
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)
	includeNonTerminated := true // bool | Whether to delete non-terminated executions (optional) (default to false)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.DeleteExecutionsByQuery(context.Background(), tenant).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).IncludeNonTerminated(includeNonTerminated).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.DeleteExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.DeleteExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deleteLogs** | **bool** | Whether to delete execution logs | [default to true]
 **deleteMetrics** | **bool** | Whether to delete execution metrics | [default to true]
 **deleteStorage** | **bool** | Whether to delete execution files in the internal storage | [default to true]

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 
 **includeNonTerminated** | **bool** | Whether to delete non-terminated executions | [default to false]

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DownloadFileFromExecution

> *os.File DownloadFileFromExecution(ctx, executionId, tenant).Path(path).Execute()

Download file for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	path := "path_example" // string | The internal storage uri
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.DownloadFileFromExecution(context.Background(), executionId, tenant).Path(path).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.DownloadFileFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DownloadFileFromExecution`: *os.File
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.DownloadFileFromExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDownloadFileFromExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **path** | **string** | The internal storage uri | 


### Return type

[***os.File**](*os.File.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## EvalTaskRunExpression

> ExecutionControllerEvalResult EvalTaskRunExpression(ctx, executionId, taskRunId, tenant).Body(body).Execute()

Evaluate a variable expression for this taskrun

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	taskRunId := "taskRunId_example" // string | The taskrun id
	tenant := "tenant_example" // string | 
	body := "body_example" // string | The Pebble expression that should be evaluated

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.EvalTaskRunExpression(context.Background(), executionId, taskRunId, tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.EvalTaskRunExpression``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `EvalTaskRunExpression`: ExecutionControllerEvalResult
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.EvalTaskRunExpression`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**taskRunId** | **string** | The taskrun id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiEvalTaskRunExpressionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **body** | **string** | The Pebble expression that should be evaluated | 

### Return type

[**ExecutionControllerEvalResult**](ExecutionControllerEvalResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## FollowDependenciesExecutions

> EventExecutionStatusEvent FollowDependenciesExecutions(ctx, executionId, tenant).DestinationOnly(destinationOnly).ExpandAll(expandAll).Execute()

Follow all execution dependencies executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	destinationOnly := true // bool | If true, list only destination dependencies, otherwise list also source dependencies (default to false)
	expandAll := true // bool | If true, expand all dependencies recursively (default to false)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.FollowDependenciesExecutions(context.Background(), executionId, tenant).DestinationOnly(destinationOnly).ExpandAll(expandAll).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.FollowDependenciesExecutions``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FollowDependenciesExecutions`: EventExecutionStatusEvent
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.FollowDependenciesExecutions`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFollowDependenciesExecutionsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **destinationOnly** | **bool** | If true, list only destination dependencies, otherwise list also source dependencies | [default to false]
 **expandAll** | **bool** | If true, expand all dependencies recursively | [default to false]


### Return type

[**EventExecutionStatusEvent**](EventExecutionStatusEvent.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## FollowExecution

> EventExecution FollowExecution(ctx, executionId, tenant).Execute()

Follow an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.FollowExecution(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.FollowExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FollowExecution`: EventExecution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.FollowExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFollowExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**EventExecution**](EventExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ForceRunByIds

> BulkResponse ForceRunByIds(ctx, tenant).RequestBody(requestBody).Execute()

Force run a list of executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The list of executions id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ForceRunByIds(context.Background(), tenant).RequestBody(requestBody).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ForceRunByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ForceRunByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ForceRunByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiForceRunByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **requestBody** | **[]string** | The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ForceRunExecution

> Execution ForceRunExecution(ctx, executionId, tenant).Execute()

Force run an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ForceRunExecution(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ForceRunExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ForceRunExecution`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ForceRunExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiForceRunExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ForceRunExecutionsByQuery

> map[string]interface{} ForceRunExecutionsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Force run executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ForceRunExecutionsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ForceRunExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ForceRunExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ForceRunExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiForceRunExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetExecution

> Execution GetExecution(ctx, executionId, tenant).Execute()

Get an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.GetExecution(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.GetExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetExecution`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.GetExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetExecutionFlowGraph

> FlowGraph GetExecutionFlowGraph(ctx, executionId, tenant).Subflows(subflows).Execute()

Generate a graph for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 
	subflows := []string{"Inner_example"} // []string | The subflow tasks to display (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.GetExecutionFlowGraph(context.Background(), executionId, tenant).Subflows(subflows).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.GetExecutionFlowGraph``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetExecutionFlowGraph`: FlowGraph
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.GetExecutionFlowGraph`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetExecutionFlowGraphRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **subflows** | **[]string** | The subflow tasks to display | 

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetFileMetadatasFromExecution

> FileMetas GetFileMetadatasFromExecution(ctx, executionId, tenant).Path(path).Execute()

Get file meta information for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	path := "path_example" // string | The internal storage uri
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.GetFileMetadatasFromExecution(context.Background(), executionId, tenant).Path(path).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.GetFileMetadatasFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetFileMetadatasFromExecution`: FileMetas
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.GetFileMetadatasFromExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetFileMetadatasFromExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **path** | **string** | The internal storage uri | 


### Return type

[**FileMetas**](FileMetas.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetFlowFromExecution

> FlowForExecution GetFlowFromExecution(ctx, namespace, flowId, tenant).Revision(revision).Execute()

Get flow information's for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The namespace of the flow
	flowId := "flowId_example" // string | The flow id
	tenant := "tenant_example" // string | 
	revision := int32(56) // int32 | The flow revision (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.GetFlowFromExecution(context.Background(), namespace, flowId, tenant).Revision(revision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.GetFlowFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetFlowFromExecution`: FlowForExecution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.GetFlowFromExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace of the flow | 
**flowId** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetFlowFromExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **revision** | **int32** | The flow revision | 

### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetFlowFromExecutionById

> FlowForExecution GetFlowFromExecutionById(ctx, executionId, tenant).Execute()

Get flow information's for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution that you want flow informations
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.GetFlowFromExecutionById(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.GetFlowFromExecutionById``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetFlowFromExecutionById`: FlowForExecution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.GetFlowFromExecutionById`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution that you want flow informations | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetFlowFromExecutionByIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetLatestExecutions

> []ExecutionControllerLastExecutionResponse GetLatestExecutions(ctx, tenant).ExecutionRepositoryInterfaceFlowFilter(executionRepositoryInterfaceFlowFilter).Execute()

Get the latest execution for given flows

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	executionRepositoryInterfaceFlowFilter := []openapiclient.ExecutionRepositoryInterfaceFlowFilter{*openapiclient.NewExecutionRepositoryInterfaceFlowFilter("Namespace_example", "Id_example")} // []ExecutionRepositoryInterfaceFlowFilter | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.GetLatestExecutions(context.Background(), tenant).ExecutionRepositoryInterfaceFlowFilter(executionRepositoryInterfaceFlowFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.GetLatestExecutions``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetLatestExecutions`: []ExecutionControllerLastExecutionResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.GetLatestExecutions`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetLatestExecutionsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **executionRepositoryInterfaceFlowFilter** | [**[]ExecutionRepositoryInterfaceFlowFilter**](ExecutionRepositoryInterfaceFlowFilter.md) |  | 

### Return type

[**[]ExecutionControllerLastExecutionResponse**](ExecutionControllerLastExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## KillExecution

> map[string]interface{} KillExecution(ctx, executionId, tenant).IsOnKillCascade(isOnKillCascade).Execute()

Kill an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	isOnKillCascade := true // bool | Specifies whether killing the execution also kill all subflow executions. (default to true)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.KillExecution(context.Background(), executionId, tenant).IsOnKillCascade(isOnKillCascade).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.KillExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `KillExecution`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.KillExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiKillExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **isOnKillCascade** | **bool** | Specifies whether killing the execution also kill all subflow executions. | [default to true]


### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## KillExecutionsByIds

> BulkResponse KillExecutionsByIds(ctx, tenant).RequestBody(requestBody).Execute()

Kill a list of executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The list of executions id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.KillExecutionsByIds(context.Background(), tenant).RequestBody(requestBody).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.KillExecutionsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `KillExecutionsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.KillExecutionsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiKillExecutionsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **requestBody** | **[]string** | The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## KillExecutionsByQuery

> map[string]interface{} KillExecutionsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Kill executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.KillExecutionsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.KillExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `KillExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.KillExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiKillExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListExecutableDistinctNamespaces

> []string ListExecutableDistinctNamespaces(ctx, tenant).Execute()

Get all namespaces that have executable flows

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ListExecutableDistinctNamespaces(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ListExecutableDistinctNamespaces``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListExecutableDistinctNamespaces`: []string
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ListExecutableDistinctNamespaces`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListExecutableDistinctNamespacesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

**[]string**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListFlowExecutionsByNamespace

> []FlowForExecution ListFlowExecutionsByNamespace(ctx, namespace, tenant).Execute()

Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The namespace
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ListFlowExecutionsByNamespace(context.Background(), namespace, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ListFlowExecutionsByNamespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListFlowExecutionsByNamespace`: []FlowForExecution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ListFlowExecutionsByNamespace`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListFlowExecutionsByNamespaceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PauseExecution

> PauseExecution(ctx, executionId, tenant).Execute()

Pause a running execution.

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.ExecutionsAPI.PauseExecution(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.PauseExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPauseExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PauseExecutionsByIds

> BulkResponse PauseExecutionsByIds(ctx, tenant).RequestBody(requestBody).Execute()

Pause a list of running executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The list of executions id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.PauseExecutionsByIds(context.Background(), tenant).RequestBody(requestBody).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.PauseExecutionsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PauseExecutionsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.PauseExecutionsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPauseExecutionsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **requestBody** | **[]string** | The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PauseExecutionsByQuery

> map[string]interface{} PauseExecutionsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Pause executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.PauseExecutionsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.PauseExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PauseExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.PauseExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPauseExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PreviewFileFromExecution

> map[string]interface{} PreviewFileFromExecution(ctx, executionId, tenant).Path(path).MaxRows(maxRows).Encoding(encoding).Execute()

Get file preview for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	path := "path_example" // string | The internal storage uri
	maxRows := int32(56) // int32 | The max row returns
	encoding := "ISO-8859-1" // string | The file encoding as Java charset name. Defaults to UTF-8 (default to "UTF-8")
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.PreviewFileFromExecution(context.Background(), executionId, tenant).Path(path).MaxRows(maxRows).Encoding(encoding).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.PreviewFileFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PreviewFileFromExecution`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.PreviewFileFromExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPreviewFileFromExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **path** | **string** | The internal storage uri | 
 **maxRows** | **int32** | The max row returns | 
 **encoding** | **string** | The file encoding as Java charset name. Defaults to UTF-8 | [default to &quot;UTF-8&quot;]


### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ReplayExecution

> Execution ReplayExecution(ctx, executionId, tenant).TaskRunId(taskRunId).Revision(revision).Breakpoints(breakpoints).Execute()

Create a new execution from an old one and start it from a specified task run id

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | the original execution id to clone
	tenant := "tenant_example" // string | 
	taskRunId := "taskRunId_example" // string | The taskrun id (optional)
	revision := int32(56) // int32 | The flow revision to use for new execution (optional)
	breakpoints := "breakpoints_example" // string | Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ReplayExecution(context.Background(), executionId, tenant).TaskRunId(taskRunId).Revision(revision).Breakpoints(breakpoints).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ReplayExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ReplayExecution`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ReplayExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | the original execution id to clone | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiReplayExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **taskRunId** | **string** | The taskrun id | 
 **revision** | **int32** | The flow revision to use for new execution | 
 **breakpoints** | **string** | Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ReplayExecutionWithinputs

> Execution ReplayExecutionWithinputs(ctx, executionId, tenant).TaskRunId(taskRunId).Revision(revision).Breakpoints(breakpoints).Execute()

Create a new execution from an old one and start it from a specified task run id

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | the original execution id to clone
	tenant := "tenant_example" // string | 
	taskRunId := "taskRunId_example" // string | The taskrun id (optional)
	revision := int32(56) // int32 | The flow revision to use for new execution (optional)
	breakpoints := "breakpoints_example" // string | Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ReplayExecutionWithinputs(context.Background(), executionId, tenant).TaskRunId(taskRunId).Revision(revision).Breakpoints(breakpoints).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ReplayExecutionWithinputs``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ReplayExecutionWithinputs`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ReplayExecutionWithinputs`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | the original execution id to clone | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiReplayExecutionWithinputsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **taskRunId** | **string** | The taskrun id | 
 **revision** | **int32** | The flow revision to use for new execution | 
 **breakpoints** | **string** | Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ReplayExecutionsByIds

> BulkResponse ReplayExecutionsByIds(ctx, tenant).RequestBody(requestBody).LatestRevision(latestRevision).Execute()

Create new executions from old ones. Keep the flow revision

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The list of executions id
	latestRevision := true // bool | If latest revision should be used (optional) (default to false)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ReplayExecutionsByIds(context.Background(), tenant).RequestBody(requestBody).LatestRevision(latestRevision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ReplayExecutionsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ReplayExecutionsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ReplayExecutionsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiReplayExecutionsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **requestBody** | **[]string** | The list of executions id | 
 **latestRevision** | **bool** | If latest revision should be used | [default to false]

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ReplayExecutionsByQuery

> map[string]interface{} ReplayExecutionsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).LatestRevision(latestRevision).Execute()

Create new executions from old ones filter by query parameters. Keep the flow revision

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)
	latestRevision := true // bool | If latest revision should be used (optional) (default to false)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ReplayExecutionsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).LatestRevision(latestRevision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ReplayExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ReplayExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ReplayExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiReplayExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 
 **latestRevision** | **bool** | If latest revision should be used | [default to false]

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## RestartExecution

> Execution RestartExecution(ctx, executionId, tenant).Revision(revision).Execute()

Restart a new execution from an old one

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 
	revision := int32(56) // int32 | The flow revision to use for new execution (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.RestartExecution(context.Background(), executionId, tenant).Revision(revision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.RestartExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `RestartExecution`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.RestartExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiRestartExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **revision** | **int32** | The flow revision to use for new execution | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## RestartExecutionsByIds

> BulkResponse RestartExecutionsByIds(ctx, tenant).RequestBody(requestBody).Execute()

Restart a list of executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The list of executions id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.RestartExecutionsByIds(context.Background(), tenant).RequestBody(requestBody).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.RestartExecutionsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `RestartExecutionsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.RestartExecutionsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiRestartExecutionsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **requestBody** | **[]string** | The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## RestartExecutionsByQuery

> map[string]interface{} RestartExecutionsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Restart executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.RestartExecutionsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.RestartExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `RestartExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.RestartExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiRestartExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ResumeExecution

> map[string]interface{} ResumeExecution(ctx, executionId, tenant).Execute()

Resume a paused execution.

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ResumeExecution(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ResumeExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ResumeExecution`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ResumeExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiResumeExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ResumeExecutionFromBreakpoint

> ResumeExecutionFromBreakpoint(ctx, executionId, tenant).Breakpoints(breakpoints).Execute()

Resume an execution from a breakpoint (in the 'BREAKPOINT' state).

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 
	breakpoints := "breakpoints_example" // string | \"Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.ExecutionsAPI.ResumeExecutionFromBreakpoint(context.Background(), executionId, tenant).Breakpoints(breakpoints).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ResumeExecutionFromBreakpoint``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiResumeExecutionFromBreakpointRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **breakpoints** | **string** | \&quot;Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | 

### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ResumeExecutionsByIds

> BulkResponse ResumeExecutionsByIds(ctx, tenant).RequestBody(requestBody).Execute()

Resume a list of paused executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The list of executions id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ResumeExecutionsByIds(context.Background(), tenant).RequestBody(requestBody).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ResumeExecutionsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ResumeExecutionsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ResumeExecutionsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiResumeExecutionsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **requestBody** | **[]string** | The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ResumeExecutionsByQuery

> map[string]interface{} ResumeExecutionsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Resume executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ResumeExecutionsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ResumeExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ResumeExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ResumeExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiResumeExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchExecutions

> PagedResultsExecution SearchExecutions(ctx, tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Search for executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	tenant := "tenant_example" // string | 
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.SearchExecutions(context.Background(), tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.SearchExecutions``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchExecutions`: PagedResultsExecution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.SearchExecutions`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchExecutionsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

[**PagedResultsExecution**](PagedResultsExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchExecutionsByFlowId

> PagedResultsExecution SearchExecutionsByFlowId(ctx, tenant).Namespace(namespace).FlowId(flowId).Page(page).Size(size).Execute()

Search for executions for a flow

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The flow namespace
	flowId := "flowId_example" // string | The flow id
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.SearchExecutionsByFlowId(context.Background(), tenant).Namespace(namespace).FlowId(flowId).Page(page).Size(size).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.SearchExecutionsByFlowId``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchExecutionsByFlowId`: PagedResultsExecution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.SearchExecutionsByFlowId`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchExecutionsByFlowIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **string** | The flow namespace | 
 **flowId** | **string** | The flow id | 
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]


### Return type

[**PagedResultsExecution**](PagedResultsExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchTaskRun

> PagedResultsTaskRun SearchTaskRun(ctx, tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Search for taskruns, only available with the Elasticsearch repository

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	tenant := "tenant_example" // string | 
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.SearchTaskRun(context.Background(), tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.SearchTaskRun``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchTaskRun`: PagedResultsTaskRun
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.SearchTaskRun`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchTaskRunRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

[**PagedResultsTaskRun**](PagedResultsTaskRun.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetLabelsOnTerminatedExecution

> map[string]interface{} SetLabelsOnTerminatedExecution(ctx, executionId, tenant).Label(label).Execute()

Add or update labels of a terminated execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 
	label := []openapiclient.Label{*openapiclient.NewLabel("Key_example", "Value_example")} // []Label | The labels to add to the execution

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.SetLabelsOnTerminatedExecution(context.Background(), executionId, tenant).Label(label).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.SetLabelsOnTerminatedExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetLabelsOnTerminatedExecution`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.SetLabelsOnTerminatedExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetLabelsOnTerminatedExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **label** | [**[]Label**](Label.md) | The labels to add to the execution | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetLabelsOnTerminatedExecutionsByIds

> BulkResponse SetLabelsOnTerminatedExecutionsByIds(ctx, tenant).ExecutionControllerSetLabelsByIdsRequest(executionControllerSetLabelsByIdsRequest).Execute()

Set labels on a list of executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	executionControllerSetLabelsByIdsRequest := *openapiclient.NewExecutionControllerSetLabelsByIdsRequest() // ExecutionControllerSetLabelsByIdsRequest | The request containing a list of labels and a list of executions

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.SetLabelsOnTerminatedExecutionsByIds(context.Background(), tenant).ExecutionControllerSetLabelsByIdsRequest(executionControllerSetLabelsByIdsRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.SetLabelsOnTerminatedExecutionsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetLabelsOnTerminatedExecutionsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.SetLabelsOnTerminatedExecutionsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetLabelsOnTerminatedExecutionsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **executionControllerSetLabelsByIdsRequest** | [**ExecutionControllerSetLabelsByIdsRequest**](ExecutionControllerSetLabelsByIdsRequest.md) | The request containing a list of labels and a list of executions | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetLabelsOnTerminatedExecutionsByQuery

> map[string]interface{} SetLabelsOnTerminatedExecutionsByQuery(ctx, tenant).Label(label).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Set label on executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	label := TODO // []Label | The labels to add to the execution
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.SetLabelsOnTerminatedExecutionsByQuery(context.Background(), tenant).Label(label).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.SetLabelsOnTerminatedExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetLabelsOnTerminatedExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.SetLabelsOnTerminatedExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetLabelsOnTerminatedExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **label** |  | The labels to add to the execution | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## TriggerExecution

> []ExecutionControllerExecutionResponse TriggerExecution(ctx, namespace, id, tenant).Wait(wait).Labels(labels).Revision(revision).Execute()

Trigger a new execution for a flow

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	wait := true // bool | If the server will wait the end of the execution (default to false)
	tenant := "tenant_example" // string | 
	labels := []string{"Inner_example"} // []string | The labels as a list of 'key:value' (optional)
	revision := int32(56) // int32 | The flow revision or latest if null (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.TriggerExecution(context.Background(), namespace, id, tenant).Wait(wait).Labels(labels).Revision(revision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.TriggerExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `TriggerExecution`: []ExecutionControllerExecutionResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.TriggerExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiTriggerExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **wait** | **bool** | If the server will wait the end of the execution | [default to false]

 **labels** | **[]string** | The labels as a list of &#39;key:value&#39; | 
 **revision** | **int32** | The flow revision or latest if null | 

### Return type

[**[]ExecutionControllerExecutionResponse**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## TriggerExecutionByGetWebhook

> ExecutionControllerWebhookResponse TriggerExecutionByGetWebhook(ctx, namespace, id, key, tenant).Execute()

Trigger a new execution by GET webhook trigger

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	key := "key_example" // string | The webhook trigger uid
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.TriggerExecutionByGetWebhook(context.Background(), namespace, id, key, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.TriggerExecutionByGetWebhook``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `TriggerExecutionByGetWebhook`: ExecutionControllerWebhookResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.TriggerExecutionByGetWebhook`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**key** | **string** | The webhook trigger uid | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiTriggerExecutionByGetWebhookRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------





### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## TriggerExecutionByPostWebhook

> ExecutionControllerWebhookResponse TriggerExecutionByPostWebhook(ctx, namespace, id, key, tenant).Execute()

Trigger a new execution by POST webhook trigger

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	key := "key_example" // string | The webhook trigger uid
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.TriggerExecutionByPostWebhook(context.Background(), namespace, id, key, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.TriggerExecutionByPostWebhook``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `TriggerExecutionByPostWebhook`: ExecutionControllerWebhookResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.TriggerExecutionByPostWebhook`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**key** | **string** | The webhook trigger uid | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiTriggerExecutionByPostWebhookRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------





### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## TriggerExecutionByPutWebhook

> ExecutionControllerWebhookResponse TriggerExecutionByPutWebhook(ctx, namespace, id, key, tenant).Execute()

Trigger a new execution by PUT webhook trigger

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	key := "key_example" // string | The webhook trigger uid
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.TriggerExecutionByPutWebhook(context.Background(), namespace, id, key, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.TriggerExecutionByPutWebhook``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `TriggerExecutionByPutWebhook`: ExecutionControllerWebhookResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.TriggerExecutionByPutWebhook`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**key** | **string** | The webhook trigger uid | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiTriggerExecutionByPutWebhookRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------





### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UnqueueExecution

> Execution UnqueueExecution(ctx, executionId, tenant).State(state).Execute()

Unqueue an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	state := openapiclient.State.Type("CREATED") // StateType | The new state of the execution
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UnqueueExecution(context.Background(), executionId, tenant).State(state).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.UnqueueExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnqueueExecution`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.UnqueueExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnqueueExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **state** | [**StateType**](StateType.md) | The new state of the execution | 


### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UnqueueExecutionsByIds

> BulkResponse UnqueueExecutionsByIds(ctx, tenant).State(state).RequestBody(requestBody).Execute()

Unqueue a list of executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	state := openapiclient.State.Type("CREATED") // StateType | The new state of the unqueued executions
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The list of executions id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UnqueueExecutionsByIds(context.Background(), tenant).State(state).RequestBody(requestBody).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.UnqueueExecutionsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnqueueExecutionsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.UnqueueExecutionsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnqueueExecutionsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **state** | [**StateType**](StateType.md) | The new state of the unqueued executions | 

 **requestBody** | **[]string** | The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UnqueueExecutionsByQuery

> map[string]interface{} UnqueueExecutionsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).NewState(newState).Execute()

Unqueue executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)
	newState := openapiclient.State.Type("CREATED") // StateType | The new state of the unqueued executions (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UnqueueExecutionsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).NewState(newState).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.UnqueueExecutionsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnqueueExecutionsByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.UnqueueExecutionsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnqueueExecutionsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 
 **newState** | [**StateType**](StateType.md) | The new state of the unqueued executions | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateExecutionStatus

> Execution UpdateExecutionStatus(ctx, executionId, tenant).Status(status).Execute()

Change the state of an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	status := openapiclient.State.Type("CREATED") // StateType | The new state of the execution
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UpdateExecutionStatus(context.Background(), executionId, tenant).Status(status).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.UpdateExecutionStatus``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateExecutionStatus`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.UpdateExecutionStatus`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateExecutionStatusRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **status** | [**StateType**](StateType.md) | The new state of the execution | 


### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateExecutionsStatusByIds

> BulkResponse UpdateExecutionsStatusByIds(ctx, tenant).NewStatus(newStatus).RequestBody(requestBody).Execute()

Change executions state by id

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	newStatus := openapiclient.State.Type("CREATED") // StateType | The new state of the executions
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The list of executions id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UpdateExecutionsStatusByIds(context.Background(), tenant).NewStatus(newStatus).RequestBody(requestBody).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.UpdateExecutionsStatusByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateExecutionsStatusByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.UpdateExecutionsStatusByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateExecutionsStatusByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newStatus** | [**StateType**](StateType.md) | The new state of the executions | 

 **requestBody** | **[]string** | The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateExecutionsStatusByQuery

> BulkResponse UpdateExecutionsStatusByQuery(ctx, tenant).NewStatus(newStatus).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()

Change executions state by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	newStatus := openapiclient.State.Type("CREATED") // StateType | The new state of the executions
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the executions to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	timeRange := "PT5M" // string | A time range filter relative to the current time (optional)
	state := []openapiclient.StateType{openapiclient.State.Type("CREATED")} // []StateType | A state filter (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)
	triggerExecutionId := "triggerExecutionId_example" // string | The trigger execution id (optional)
	childFilter := openapiclient.ExecutionRepositoryInterface.ChildFilter("CHILD") // ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UpdateExecutionsStatusByQuery(context.Background(), tenant).NewStatus(newStatus).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).FlowId(flowId).StartDate(startDate).EndDate(endDate).TimeRange(timeRange).State(state).Labels(labels).TriggerExecutionId(triggerExecutionId).ChildFilter(childFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.UpdateExecutionsStatusByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateExecutionsStatusByQuery`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.UpdateExecutionsStatusByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateExecutionsStatusByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newStatus** | [**StateType**](StateType.md) | The new state of the executions | 

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the executions to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **timeRange** | **string** | A time range filter relative to the current time | 
 **state** | [**[]StateType**](StateType.md) | A state filter | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 
 **triggerExecutionId** | **string** | The trigger execution id | 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](ExecutionRepositoryInterfaceChildFilter.md) | A execution child filter | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateTaskRunState

> Execution UpdateTaskRunState(ctx, executionId, tenant).ExecutionControllerStateRequest(executionControllerStateRequest).Execute()

Change state for a taskrun in an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 
	executionControllerStateRequest := *openapiclient.NewExecutionControllerStateRequest() // ExecutionControllerStateRequest | the taskRun id and state to apply

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UpdateTaskRunState(context.Background(), executionId, tenant).ExecutionControllerStateRequest(executionControllerStateRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.UpdateTaskRunState``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateTaskRunState`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.UpdateTaskRunState`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateTaskRunStateRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **executionControllerStateRequest** | [**ExecutionControllerStateRequest**](ExecutionControllerStateRequest.md) | the taskRun id and state to apply | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ValidateNewExecutionInputs

> []ExecutionControllerApiValidateExecutionInputsResponse ValidateNewExecutionInputs(ctx, namespace, id, tenant).Labels(labels).Revision(revision).Execute()

Validate the creation of a new execution for a flow

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	labels := []string{"Inner_example"} // []string | The labels as a list of 'key:value'
	tenant := "tenant_example" // string | 
	revision := int32(56) // int32 | The flow revision or latest if null (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ValidateNewExecutionInputs(context.Background(), namespace, id, tenant).Labels(labels).Revision(revision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ValidateNewExecutionInputs``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ValidateNewExecutionInputs`: []ExecutionControllerApiValidateExecutionInputsResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ValidateNewExecutionInputs`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiValidateNewExecutionInputsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **labels** | **[]string** | The labels as a list of &#39;key:value&#39; | 

 **revision** | **int32** | The flow revision or latest if null | 

### Return type

[**[]ExecutionControllerApiValidateExecutionInputsResponse**](ExecutionControllerApiValidateExecutionInputsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ValidateResumeExecutionInputs

> []ExecutionControllerApiValidateExecutionInputsResponse ValidateResumeExecutionInputs(ctx, executionId, tenant).Execute()

Validate inputs to resume a paused execution.

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ValidateResumeExecutionInputs(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ValidateResumeExecutionInputs``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ValidateResumeExecutionInputs`: []ExecutionControllerApiValidateExecutionInputsResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ValidateResumeExecutionInputs`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiValidateResumeExecutionInputsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]ExecutionControllerApiValidateExecutionInputsResponse**](ExecutionControllerApiValidateExecutionInputsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

