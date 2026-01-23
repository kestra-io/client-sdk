# \ExecutionsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateExecution**](ExecutionsAPI.md#CreateExecution) | **Post** /api/v1/{tenant}/executions/{namespace}/{id} | Create a new execution for a flow
[**DeleteExecution**](ExecutionsAPI.md#DeleteExecution) | **Delete** /api/v1/{tenant}/executions/{executionId} | Delete an execution
[**DeleteExecutionsByIds**](ExecutionsAPI.md#DeleteExecutionsByIds) | **Delete** /api/v1/{tenant}/executions/by-ids | Delete a list of executions
[**DeleteExecutionsByQuery**](ExecutionsAPI.md#DeleteExecutionsByQuery) | **Delete** /api/v1/{tenant}/executions/by-query | Delete executions filter by query parameters
[**DownloadFileFromExecution**](ExecutionsAPI.md#DownloadFileFromExecution) | **Get** /api/v1/{tenant}/executions/{executionId}/file | Download file for an execution
[**Execution**](ExecutionsAPI.md#Execution) | **Get** /api/v1/{tenant}/executions/{executionId} | Get an execution
[**ExecutionFlowGraph**](ExecutionsAPI.md#ExecutionFlowGraph) | **Get** /api/v1/{tenant}/executions/{executionId}/graph | Generate a graph for an execution
[**ExportExecutions**](ExecutionsAPI.md#ExportExecutions) | **Get** /api/v1/{tenant}/executions/export/by-query/csv | Export all executions as a streamed CSV file
[**FileMetadatasFromExecution**](ExecutionsAPI.md#FileMetadatasFromExecution) | **Get** /api/v1/{tenant}/executions/{executionId}/file/metas | Get file meta information for an execution
[**FlowFromExecution**](ExecutionsAPI.md#FlowFromExecution) | **Get** /api/v1/{tenant}/executions/flows/{namespace}/{flowId} | Get flow information&#39;s for an execution
[**FlowFromExecutionById**](ExecutionsAPI.md#FlowFromExecutionById) | **Get** /api/v1/{tenant}/executions/{executionId}/flow | Get flow information&#39;s for an execution
[**FollowDependenciesExecutions**](ExecutionsAPI.md#FollowDependenciesExecutions) | **Get** /api/v1/{tenant}/executions/{executionId}/follow-dependencies | Follow all execution dependencies executions
[**FollowExecution**](ExecutionsAPI.md#FollowExecution) | **Get** /api/v1/{tenant}/executions/{executionId}/follow | Follow an execution
[**ForceRunByIds**](ExecutionsAPI.md#ForceRunByIds) | **Post** /api/v1/{tenant}/executions/force-run/by-ids | Force run a list of executions
[**ForceRunExecution**](ExecutionsAPI.md#ForceRunExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/force-run | Force run an execution
[**ForceRunExecutionsByQuery**](ExecutionsAPI.md#ForceRunExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/force-run/by-query | Force run executions filter by query parameters
[**KillExecution**](ExecutionsAPI.md#KillExecution) | **Delete** /api/v1/{tenant}/executions/{executionId}/kill | Kill an execution
[**KillExecutionsByIds**](ExecutionsAPI.md#KillExecutionsByIds) | **Delete** /api/v1/{tenant}/executions/kill/by-ids | Kill a list of executions
[**KillExecutionsByQuery**](ExecutionsAPI.md#KillExecutionsByQuery) | **Delete** /api/v1/{tenant}/executions/kill/by-query | Kill executions filter by query parameters
[**LatestExecutions**](ExecutionsAPI.md#LatestExecutions) | **Post** /api/v1/{tenant}/executions/latest | Get the latest execution for given flows
[**PauseExecution**](ExecutionsAPI.md#PauseExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/pause | Pause a running execution.
[**PauseExecutionsByIds**](ExecutionsAPI.md#PauseExecutionsByIds) | **Post** /api/v1/{tenant}/executions/pause/by-ids | Pause a list of running executions
[**PauseExecutionsByQuery**](ExecutionsAPI.md#PauseExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/pause/by-query | Pause executions filter by query parameters
[**ReplayExecution**](ExecutionsAPI.md#ReplayExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/replay | Create a new execution from an old one and start it from a specified task run id
[**ReplayExecutionWithinputs**](ExecutionsAPI.md#ReplayExecutionWithinputs) | **Post** /api/v1/{tenant}/executions/{executionId}/replay-with-inputs | Create a new execution from an old one and start it from a specified task run id
[**ReplayExecutionsByIds**](ExecutionsAPI.md#ReplayExecutionsByIds) | **Post** /api/v1/{tenant}/executions/replay/by-ids | Create new executions from old ones. Keep the flow revision
[**ReplayExecutionsByQuery**](ExecutionsAPI.md#ReplayExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/replay/by-query | Create new executions from old ones filter by query parameters. Keep the flow revision
[**RestartExecution**](ExecutionsAPI.md#RestartExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/restart | Restart a new execution from an old one
[**RestartExecutionsByIds**](ExecutionsAPI.md#RestartExecutionsByIds) | **Post** /api/v1/{tenant}/executions/restart/by-ids | Restart a list of executions
[**RestartExecutionsByQuery**](ExecutionsAPI.md#RestartExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/restart/by-query | Restart executions filter by query parameters
[**ResumeExecution**](ExecutionsAPI.md#ResumeExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/resume | Resume a paused execution.
[**ResumeExecutionsByIds**](ExecutionsAPI.md#ResumeExecutionsByIds) | **Post** /api/v1/{tenant}/executions/resume/by-ids | Resume a list of paused executions
[**ResumeExecutionsByQuery**](ExecutionsAPI.md#ResumeExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/resume/by-query | Resume executions filter by query parameters
[**SearchExecutions**](ExecutionsAPI.md#SearchExecutions) | **Get** /api/v1/{tenant}/executions/search | Search for executions
[**SearchExecutionsByFlowId**](ExecutionsAPI.md#SearchExecutionsByFlowId) | **Get** /api/v1/{tenant}/executions | Search for executions for a flow
[**SetLabelsOnTerminatedExecution**](ExecutionsAPI.md#SetLabelsOnTerminatedExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/labels | Add or update labels of a terminated execution
[**SetLabelsOnTerminatedExecutionsByIds**](ExecutionsAPI.md#SetLabelsOnTerminatedExecutionsByIds) | **Post** /api/v1/{tenant}/executions/labels/by-ids | Set labels on a list of executions
[**SetLabelsOnTerminatedExecutionsByQuery**](ExecutionsAPI.md#SetLabelsOnTerminatedExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/labels/by-query | Set label on executions filter by query parameters
[**TriggerExecutionByGetWebhook**](ExecutionsAPI.md#TriggerExecutionByGetWebhook) | **Get** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by GET webhook trigger
[**UnqueueExecution**](ExecutionsAPI.md#UnqueueExecution) | **Post** /api/v1/{tenant}/executions/{executionId}/unqueue | Unqueue an execution
[**UnqueueExecutionsByIds**](ExecutionsAPI.md#UnqueueExecutionsByIds) | **Post** /api/v1/{tenant}/executions/unqueue/by-ids | Unqueue a list of executions
[**UnqueueExecutionsByQuery**](ExecutionsAPI.md#UnqueueExecutionsByQuery) | **Post** /api/v1/{tenant}/executions/unqueue/by-query | Unqueue executions filter by query parameters
[**UpdateExecutionStatus**](ExecutionsAPI.md#UpdateExecutionStatus) | **Post** /api/v1/{tenant}/executions/{executionId}/change-status | Change the state of an execution
[**UpdateExecutionsStatusByIds**](ExecutionsAPI.md#UpdateExecutionsStatusByIds) | **Post** /api/v1/{tenant}/executions/change-status/by-ids | Change executions state by id
[**UpdateExecutionsStatusByQuery**](ExecutionsAPI.md#UpdateExecutionsStatusByQuery) | **Post** /api/v1/{tenant}/executions/change-status/by-query | Change executions state by query parameters
[**UpdateTaskRunState**](ExecutionsAPI.md#UpdateTaskRunState) | **Post** /api/v1/{tenant}/executions/{executionId}/state | Change state for a taskrun in an execution



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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 
	deleteLogs := true // bool | Whether to delete execution logs (optional) (default to true)
	deleteMetrics := true // bool | Whether to delete execution metrics (optional) (default to true)
	deleteStorage := true // bool | Whether to delete execution files in the internal storage (optional) (default to true)

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

> BulkResponse DeleteExecutionsByIds(ctx, tenant).RequestBody(requestBody).IncludeNonTerminated(includeNonTerminated).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).Execute()

Delete a list of executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	requestBody := []string{"Property_example"} // []string | The execution id
	includeNonTerminated := true // bool | Whether to delete non-terminated executions (optional) (default to false)
	deleteLogs := true // bool | Whether to delete execution logs (optional) (default to true)
	deleteMetrics := true // bool | Whether to delete execution metrics (optional) (default to true)
	deleteStorage := true // bool | Whether to delete execution files in the internal storage (optional) (default to true)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.DeleteExecutionsByIds(context.Background(), tenant).RequestBody(requestBody).IncludeNonTerminated(includeNonTerminated).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).Execute()
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

 **requestBody** | **[]string** | The execution id | 
 **includeNonTerminated** | **bool** | Whether to delete non-terminated executions | [default to false]
 **deleteLogs** | **bool** | Whether to delete execution logs | [default to true]
 **deleteMetrics** | **bool** | Whether to delete execution metrics | [default to true]
 **deleteStorage** | **bool** | Whether to delete execution files in the internal storage | [default to true]

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

> map[string]interface{} DeleteExecutionsByQuery(ctx, tenant).Filters(filters).IncludeNonTerminated(includeNonTerminated).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).Execute()

Delete executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)
	includeNonTerminated := true // bool | Whether to delete non-terminated executions (optional) (default to false)
	deleteLogs := true // bool | Whether to delete execution logs (optional) (default to true)
	deleteMetrics := true // bool | Whether to delete execution metrics (optional) (default to true)
	deleteStorage := true // bool | Whether to delete execution files in the internal storage (optional) (default to true)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.DeleteExecutionsByQuery(context.Background(), tenant).Filters(filters).IncludeNonTerminated(includeNonTerminated).DeleteLogs(deleteLogs).DeleteMetrics(deleteMetrics).DeleteStorage(deleteStorage).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **includeNonTerminated** | **bool** | Whether to delete non-terminated executions | [default to false]
 **deleteLogs** | **bool** | Whether to delete execution logs | [default to true]
 **deleteMetrics** | **bool** | Whether to delete execution metrics | [default to true]
 **deleteStorage** | **bool** | Whether to delete execution files in the internal storage | [default to true]

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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


## Execution

> Execution Execution(ctx, executionId, tenant).Execute()

Get an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.Execution(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.Execution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `Execution`: Execution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.Execution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiExecutionRequest struct via the builder pattern


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


## ExecutionFlowGraph

> FlowGraph ExecutionFlowGraph(ctx, executionId, tenant).Subflows(subflows).Execute()

Generate a graph for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 
	subflows := []string{"Inner_example"} // []string | The subflow tasks to display (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ExecutionFlowGraph(context.Background(), executionId, tenant).Subflows(subflows).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ExecutionFlowGraph``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ExecutionFlowGraph`: FlowGraph
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ExecutionFlowGraph`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiExecutionFlowGraphRequest struct via the builder pattern


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


## ExportExecutions

> []map[string]interface{} ExportExecutions(ctx, tenant).Filters(filters).Execute()

Export all executions as a streamed CSV file

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | A list of filters
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ExportExecutions(context.Background(), tenant).Filters(filters).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.ExportExecutions``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ExportExecutions`: []map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.ExportExecutions`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiExportExecutionsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | [**[]QueryFilter**](QueryFilter.md) | A list of filters | 


### Return type

**[]map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/csv

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## FileMetadatasFromExecution

> FileMetas FileMetadatasFromExecution(ctx, executionId, tenant).Path(path).Execute()

Get file meta information for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	executionId := "executionId_example" // string | The execution id
	path := "path_example" // string | The internal storage uri
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.FileMetadatasFromExecution(context.Background(), executionId, tenant).Path(path).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.FileMetadatasFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FileMetadatasFromExecution`: FileMetas
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.FileMetadatasFromExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFileMetadatasFromExecutionRequest struct via the builder pattern


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


## FlowFromExecution

> FlowForExecution FlowFromExecution(ctx, namespace, flowId, tenant).Revision(revision).Execute()

Get flow information's for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	namespace := "namespace_example" // string | The namespace of the flow
	flowId := "flowId_example" // string | The flow id
	tenant := "tenant_example" // string | 
	revision := int32(56) // int32 | The flow revision (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.FlowFromExecution(context.Background(), namespace, flowId, tenant).Revision(revision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.FlowFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FlowFromExecution`: FlowForExecution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.FlowFromExecution`: %v\n", resp)
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

Other parameters are passed through a pointer to a apiFlowFromExecutionRequest struct via the builder pattern


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


## FlowFromExecutionById

> FlowForExecution FlowFromExecutionById(ctx, executionId, tenant).Execute()

Get flow information's for an execution

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	executionId := "executionId_example" // string | The execution that you want flow informations
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.FlowFromExecutionById(context.Background(), executionId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.FlowFromExecutionById``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FlowFromExecutionById`: FlowForExecution
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.FlowFromExecutionById`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution that you want flow informations | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFlowFromExecutionByIdRequest struct via the builder pattern


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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> map[string]interface{} ForceRunExecutionsByQuery(ctx, tenant).Filters(filters).Execute()

Force run executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ForceRunExecutionsByQuery(context.Background(), tenant).Filters(filters).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> map[string]interface{} KillExecutionsByQuery(ctx, tenant).Filters(filters).Execute()

Kill executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.KillExecutionsByQuery(context.Background(), tenant).Filters(filters).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

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


## LatestExecutions

> []ExecutionControllerLastExecutionResponse LatestExecutions(ctx, tenant).ExecutionRepositoryInterfaceFlowFilter(executionRepositoryInterfaceFlowFilter).Execute()

Get the latest execution for given flows

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	executionRepositoryInterfaceFlowFilter := []openapiclient.ExecutionRepositoryInterfaceFlowFilter{*openapiclient.NewExecutionRepositoryInterfaceFlowFilter("Namespace_example", "Id_example")} // []ExecutionRepositoryInterfaceFlowFilter | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.LatestExecutions(context.Background(), tenant).ExecutionRepositoryInterfaceFlowFilter(executionRepositoryInterfaceFlowFilter).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ExecutionsAPI.LatestExecutions``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `LatestExecutions`: []ExecutionControllerLastExecutionResponse
	fmt.Fprintf(os.Stdout, "Response from `ExecutionsAPI.LatestExecutions`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiLatestExecutionsRequest struct via the builder pattern


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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> map[string]interface{} PauseExecutionsByQuery(ctx, tenant).Filters(filters).Execute()

Pause executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.PauseExecutionsByQuery(context.Background(), tenant).Filters(filters).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> map[string]interface{} ReplayExecutionsByQuery(ctx, tenant).Filters(filters).LatestRevision(latestRevision).Execute()

Create new executions from old ones filter by query parameters. Keep the flow revision

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)
	latestRevision := true // bool | If latest revision should be used (optional) (default to false)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ReplayExecutionsByQuery(context.Background(), tenant).Filters(filters).LatestRevision(latestRevision).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **latestRevision** | **bool** | If latest revision should be used | [default to false]

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> map[string]interface{} RestartExecutionsByQuery(ctx, tenant).Filters(filters).Execute()

Restart executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.RestartExecutionsByQuery(context.Background(), tenant).Filters(filters).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> map[string]interface{} ResumeExecutionsByQuery(ctx, tenant).Filters(filters).Execute()

Resume executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.ResumeExecutionsByQuery(context.Background(), tenant).Filters(filters).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

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


## SearchExecutions

> PagedResultsExecution SearchExecutions(ctx, tenant).Page(page).Size(size).Sort(sort).Filters(filters).Execute()

Search for executions

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	tenant := "tenant_example" // string | 
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.SearchExecutions(context.Background(), tenant).Page(page).Size(size).Sort(sort).Filters(filters).Execute()
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> map[string]interface{} SetLabelsOnTerminatedExecutionsByQuery(ctx, tenant).Label(label).Filters(filters).Execute()

Set label on executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	label := []openapiclient.Label{*openapiclient.NewLabel("Key_example", "Value_example")} // []Label | The labels to add to the execution
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.SetLabelsOnTerminatedExecutionsByQuery(context.Background(), tenant).Label(label).Filters(filters).Execute()
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

 **label** | [**[]Label**](Label.md) | The labels to add to the execution | 
 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> map[string]interface{} UnqueueExecutionsByQuery(ctx, tenant).Filters(filters).NewState(newState).Execute()

Unqueue executions filter by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)
	newState := openapiclient.State.Type("CREATED") // StateType | The new state of the unqueued executions (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UnqueueExecutionsByQuery(context.Background(), tenant).Filters(filters).NewState(newState).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **newState** | [**StateType**](StateType.md) | The new state of the unqueued executions | 

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

> BulkResponse UpdateExecutionsStatusByQuery(ctx, tenant).NewStatus(newStatus).Filters(filters).Execute()

Change executions state by query parameters

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	newStatus := openapiclient.State.Type("CREATED") // StateType | The new state of the executions
	tenant := "tenant_example" // string | 
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ExecutionsAPI.UpdateExecutionsStatusByQuery(context.Background(), tenant).NewStatus(newStatus).Filters(filters).Execute()
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

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

