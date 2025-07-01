# \LogsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DeleteLogsFromExecution**](LogsAPI.md#DeleteLogsFromExecution) | **Delete** /api/v1/{tenant}/logs/{executionId} | Delete logs for a specific execution, taskrun or task
[**DeleteLogsFromFlow**](LogsAPI.md#DeleteLogsFromFlow) | **Delete** /api/v1/{tenant}/logs/{namespace}/{flowId} | Delete logs for a specific execution, taskrun or task
[**DownloadLogsFromExecution**](LogsAPI.md#DownloadLogsFromExecution) | **Get** /api/v1/{tenant}/logs/{executionId}/download | Download logs for a specific execution, taskrun or task
[**FollowLogsFromExecution**](LogsAPI.md#FollowLogsFromExecution) | **Get** /api/v1/{tenant}/logs/{executionId}/follow | Follow logs for a specific execution
[**ListLogsFromExecution**](LogsAPI.md#ListLogsFromExecution) | **Get** /api/v1/{tenant}/logs/{executionId} | Get logs for a specific execution, taskrun or task
[**SearchLogs**](LogsAPI.md#SearchLogs) | **Get** /api/v1/{tenant}/logs/search | Search for logs



## DeleteLogsFromExecution

> DeleteLogsFromExecution(ctx, executionId, tenant).MinLevel(minLevel).TaskRunId(taskRunId).TaskId(taskId).Attempt(attempt).Execute()

Delete logs for a specific execution, taskrun or task

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
	minLevel := openapiclient.Level("ERROR") // Level | The min log level filter (optional)
	taskRunId := "taskRunId_example" // string | The taskrun id (optional)
	taskId := "taskId_example" // string | The task id (optional)
	attempt := int32(56) // int32 | The attempt number (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.LogsAPI.DeleteLogsFromExecution(context.Background(), executionId, tenant).MinLevel(minLevel).TaskRunId(taskRunId).TaskId(taskId).Attempt(attempt).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `LogsAPI.DeleteLogsFromExecution``: %v\n", err)
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

Other parameters are passed through a pointer to a apiDeleteLogsFromExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **minLevel** | [**Level**](Level.md) | The min log level filter | 
 **taskRunId** | **string** | The taskrun id | 
 **taskId** | **string** | The task id | 
 **attempt** | **int32** | The attempt number | 

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


## DeleteLogsFromFlow

> DeleteLogsFromFlow(ctx, namespace, flowId, tenant).TriggerId(triggerId).Execute()

Delete logs for a specific execution, taskrun or task

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
	flowId := "flowId_example" // string | The flow identifier
	triggerId := "triggerId_example" // string | The trigger id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.LogsAPI.DeleteLogsFromFlow(context.Background(), namespace, flowId, tenant).TriggerId(triggerId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `LogsAPI.DeleteLogsFromFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow identifier | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteLogsFromFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **triggerId** | **string** | The trigger id | 


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


## DownloadLogsFromExecution

> *os.File DownloadLogsFromExecution(ctx, executionId, tenant).MinLevel(minLevel).TaskRunId(taskRunId).TaskId(taskId).Attempt(attempt).Execute()

Download logs for a specific execution, taskrun or task

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
	minLevel := openapiclient.Level("ERROR") // Level | The min log level filter (optional)
	taskRunId := "taskRunId_example" // string | The taskrun id (optional)
	taskId := "taskId_example" // string | The task id (optional)
	attempt := int32(56) // int32 | The attempt number (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.LogsAPI.DownloadLogsFromExecution(context.Background(), executionId, tenant).MinLevel(minLevel).TaskRunId(taskRunId).TaskId(taskId).Attempt(attempt).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `LogsAPI.DownloadLogsFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DownloadLogsFromExecution`: *os.File
	fmt.Fprintf(os.Stdout, "Response from `LogsAPI.DownloadLogsFromExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDownloadLogsFromExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **minLevel** | [**Level**](Level.md) | The min log level filter | 
 **taskRunId** | **string** | The taskrun id | 
 **taskId** | **string** | The task id | 
 **attempt** | **int32** | The attempt number | 

### Return type

[***os.File**](*os.File.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## FollowLogsFromExecution

> EventLogEntry FollowLogsFromExecution(ctx, executionId, tenant).MinLevel(minLevel).Execute()

Follow logs for a specific execution

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
	minLevel := openapiclient.Level("ERROR") // Level | The min log level filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.LogsAPI.FollowLogsFromExecution(context.Background(), executionId, tenant).MinLevel(minLevel).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `LogsAPI.FollowLogsFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FollowLogsFromExecution`: EventLogEntry
	fmt.Fprintf(os.Stdout, "Response from `LogsAPI.FollowLogsFromExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFollowLogsFromExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **minLevel** | [**Level**](Level.md) | The min log level filter | 

### Return type

[**EventLogEntry**](EventLogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListLogsFromExecution

> []LogEntry ListLogsFromExecution(ctx, executionId, tenant).MinLevel(minLevel).TaskRunId(taskRunId).TaskId(taskId).Attempt(attempt).Execute()

Get logs for a specific execution, taskrun or task

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
	minLevel := openapiclient.Level("ERROR") // Level | The min log level filter (optional)
	taskRunId := "taskRunId_example" // string | The taskrun id (optional)
	taskId := "taskId_example" // string | The task id (optional)
	attempt := int32(56) // int32 | The attempt number (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.LogsAPI.ListLogsFromExecution(context.Background(), executionId, tenant).MinLevel(minLevel).TaskRunId(taskRunId).TaskId(taskId).Attempt(attempt).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `LogsAPI.ListLogsFromExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListLogsFromExecution`: []LogEntry
	fmt.Fprintf(os.Stdout, "Response from `LogsAPI.ListLogsFromExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListLogsFromExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **minLevel** | [**Level**](Level.md) | The min log level filter | 
 **taskRunId** | **string** | The taskrun id | 
 **taskId** | **string** | The task id | 
 **attempt** | **int32** | The attempt number | 

### Return type

[**[]LogEntry**](LogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchLogs

> PagedResultsLogEntry SearchLogs(ctx, tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Namespace(namespace).FlowId(flowId).TriggerId(triggerId).MinLevel(minLevel).StartDate(startDate).EndDate(endDate).Execute()

Search for logs

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
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter(openapiclient.QueryFilter.Field("QUERY"), openapiclient.QueryFilter.Op("EQUALS"), interface{}(123))} // []QueryFilter | Filters (optional)
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	triggerId := "triggerId_example" // string | A trigger id filter (optional)
	minLevel := openapiclient.Level("ERROR") // Level | The min log level filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.LogsAPI.SearchLogs(context.Background(), tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Namespace(namespace).FlowId(flowId).TriggerId(triggerId).MinLevel(minLevel).StartDate(startDate).EndDate(endDate).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `LogsAPI.SearchLogs``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchLogs`: PagedResultsLogEntry
	fmt.Fprintf(os.Stdout, "Response from `LogsAPI.SearchLogs`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchLogsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 
 **triggerId** | **string** | A trigger id filter | 
 **minLevel** | [**Level**](Level.md) | The min log level filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 

### Return type

[**PagedResultsLogEntry**](PagedResultsLogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

