# \MetricsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AggregateMetricsFromFlow**](MetricsAPI.md#AggregateMetricsFromFlow) | **Get** /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{metric} | Get metrics aggregations for a specific flow
[**AggregateMetricsFromTask**](MetricsAPI.md#AggregateMetricsFromTask) | **Get** /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{taskId}/{metric} | Get metrics aggregations for a specific flow
[**ListFlowMetrics**](MetricsAPI.md#ListFlowMetrics) | **Get** /api/v1/{tenant}/metrics/names/{namespace}/{flowId} | Get metrics names for a specific flow
[**ListTaskMetrics**](MetricsAPI.md#ListTaskMetrics) | **Get** /api/v1/{tenant}/metrics/names/{namespace}/{flowId}/{taskId} | Get metrics names for a specific task in a flow
[**ListTasksWithMetrics**](MetricsAPI.md#ListTasksWithMetrics) | **Get** /api/v1/{tenant}/metrics/tasks/{namespace}/{flowId} | Get tasks id that have metrics for a specific flow, include deleted or renamed tasks
[**SearchByExecution**](MetricsAPI.md#SearchByExecution) | **Get** /api/v1/{tenant}/metrics/{executionId} | Get metrics for a specific execution



## AggregateMetricsFromFlow

> MetricAggregations AggregateMetricsFromFlow(ctx, namespace, flowId, metric, tenant).Aggregation(aggregation).StartDate(startDate).EndDate(endDate).Execute()

Get metrics aggregations for a specific flow

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
	namespace := "namespace_example" // string | The namespace
	flowId := "flowId_example" // string | The flow Id
	metric := "metric_example" // string | The metric name
	aggregation := "aggregation_example" // string | The type of aggregation: avg, sum, min or max (default to "sum")
	tenant := "tenant_example" // string | 
	startDate := time.Now() // time.Time | The start datetime, default to now - 30 days (optional)
	endDate := time.Now() // time.Time | The end datetime, default to now (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MetricsAPI.AggregateMetricsFromFlow(context.Background(), namespace, flowId, metric, tenant).Aggregation(aggregation).StartDate(startDate).EndDate(endDate).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MetricsAPI.AggregateMetricsFromFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AggregateMetricsFromFlow`: MetricAggregations
	fmt.Fprintf(os.Stdout, "Response from `MetricsAPI.AggregateMetricsFromFlow`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow Id | 
**metric** | **string** | The metric name | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAggregateMetricsFromFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **aggregation** | **string** | The type of aggregation: avg, sum, min or max | [default to &quot;sum&quot;]

 **startDate** | **time.Time** | The start datetime, default to now - 30 days | 
 **endDate** | **time.Time** | The end datetime, default to now | 

### Return type

[**MetricAggregations**](MetricAggregations.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AggregateMetricsFromTask

> MetricAggregations AggregateMetricsFromTask(ctx, namespace, flowId, taskId, metric, tenant).Aggregation(aggregation).StartDate(startDate).EndDate(endDate).Execute()

Get metrics aggregations for a specific flow

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
	namespace := "namespace_example" // string | The namespace
	flowId := "flowId_example" // string | The flow Id
	taskId := "taskId_example" // string | The task Id
	metric := "metric_example" // string | The metric name
	aggregation := "aggregation_example" // string | The type of aggregation: avg, sum, min or max (default to "sum")
	tenant := "tenant_example" // string | 
	startDate := time.Now() // time.Time | The start datetime, default to now - 30 days (optional)
	endDate := time.Now() // time.Time | The end datetime, default to now (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MetricsAPI.AggregateMetricsFromTask(context.Background(), namespace, flowId, taskId, metric, tenant).Aggregation(aggregation).StartDate(startDate).EndDate(endDate).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MetricsAPI.AggregateMetricsFromTask``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AggregateMetricsFromTask`: MetricAggregations
	fmt.Fprintf(os.Stdout, "Response from `MetricsAPI.AggregateMetricsFromTask`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow Id | 
**taskId** | **string** | The task Id | 
**metric** | **string** | The metric name | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAggregateMetricsFromTaskRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




 **aggregation** | **string** | The type of aggregation: avg, sum, min or max | [default to &quot;sum&quot;]

 **startDate** | **time.Time** | The start datetime, default to now - 30 days | 
 **endDate** | **time.Time** | The end datetime, default to now | 

### Return type

[**MetricAggregations**](MetricAggregations.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListFlowMetrics

> []string ListFlowMetrics(ctx, namespace, flowId, tenant).Execute()

Get metrics names for a specific flow

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
	flowId := "flowId_example" // string | The flow Id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MetricsAPI.ListFlowMetrics(context.Background(), namespace, flowId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MetricsAPI.ListFlowMetrics``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListFlowMetrics`: []string
	fmt.Fprintf(os.Stdout, "Response from `MetricsAPI.ListFlowMetrics`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow Id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListFlowMetricsRequest struct via the builder pattern


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


## ListTaskMetrics

> []string ListTaskMetrics(ctx, namespace, flowId, taskId, tenant).Execute()

Get metrics names for a specific task in a flow

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
	flowId := "flowId_example" // string | The flow Id
	taskId := "taskId_example" // string | The task Id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MetricsAPI.ListTaskMetrics(context.Background(), namespace, flowId, taskId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MetricsAPI.ListTaskMetrics``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListTaskMetrics`: []string
	fmt.Fprintf(os.Stdout, "Response from `MetricsAPI.ListTaskMetrics`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow Id | 
**taskId** | **string** | The task Id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListTaskMetricsRequest struct via the builder pattern


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


## ListTasksWithMetrics

> []string ListTasksWithMetrics(ctx, namespace, flowId, tenant).Execute()

Get tasks id that have metrics for a specific flow, include deleted or renamed tasks

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
	flowId := "flowId_example" // string | The flow Id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MetricsAPI.ListTasksWithMetrics(context.Background(), namespace, flowId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MetricsAPI.ListTasksWithMetrics``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListTasksWithMetrics`: []string
	fmt.Fprintf(os.Stdout, "Response from `MetricsAPI.ListTasksWithMetrics`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow Id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListTasksWithMetricsRequest struct via the builder pattern


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


## SearchByExecution

> PagedResultsMetricEntry SearchByExecution(ctx, executionId, tenant).Page(page).Size(size).Sort(sort).TaskRunId(taskRunId).TaskId(taskId).Execute()

Get metrics for a specific execution

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
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	executionId := "executionId_example" // string | The execution id
	tenant := "tenant_example" // string | 
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	taskRunId := "taskRunId_example" // string | The taskrun id (optional)
	taskId := "taskId_example" // string | The task id (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MetricsAPI.SearchByExecution(context.Background(), executionId, tenant).Page(page).Size(size).Sort(sort).TaskRunId(taskRunId).TaskId(taskId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MetricsAPI.SearchByExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchByExecution`: PagedResultsMetricEntry
	fmt.Fprintf(os.Stdout, "Response from `MetricsAPI.SearchByExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**executionId** | **string** | The execution id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchByExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]


 **sort** | **[]string** | The sort of current page | 
 **taskRunId** | **string** | The taskrun id | 
 **taskId** | **string** | The task id | 

### Return type

[**PagedResultsMetricEntry**](PagedResultsMetricEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

