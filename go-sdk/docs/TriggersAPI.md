# \TriggersAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DeleteBackfill**](TriggersAPI.md#DeleteBackfill) | **Post** /api/v1/{tenant}/triggers/backfill/delete | Delete a backfill
[**DeleteBackfillByIds**](TriggersAPI.md#DeleteBackfillByIds) | **Post** /api/v1/{tenant}/triggers/backfill/delete/by-triggers | Delete backfill for given triggers
[**DeleteBackfillByQuery**](TriggersAPI.md#DeleteBackfillByQuery) | **Post** /api/v1/{tenant}/triggers/backfill/delete/by-query | Delete backfill for given triggers
[**DisabledTriggersByIds**](TriggersAPI.md#DisabledTriggersByIds) | **Post** /api/v1/{tenant}/triggers/set-disabled/by-triggers | Disable/enable given triggers
[**DisabledTriggersByQuery**](TriggersAPI.md#DisabledTriggersByQuery) | **Post** /api/v1/{tenant}/triggers/set-disabled/by-query | Disable/enable triggers by query parameters
[**PauseBackfill**](TriggersAPI.md#PauseBackfill) | **Put** /api/v1/{tenant}/triggers/backfill/pause | Pause a backfill
[**PauseBackfillByIds**](TriggersAPI.md#PauseBackfillByIds) | **Post** /api/v1/{tenant}/triggers/backfill/pause/by-triggers | Pause backfill for given triggers
[**PauseBackfillByQuery**](TriggersAPI.md#PauseBackfillByQuery) | **Post** /api/v1/{tenant}/triggers/backfill/pause/by-query | Pause backfill for given triggers
[**RestartTrigger**](TriggersAPI.md#RestartTrigger) | **Post** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/restart | Restart a trigger
[**SearchTriggers**](TriggersAPI.md#SearchTriggers) | **Get** /api/v1/{tenant}/triggers/search | Search for triggers
[**SearchTriggersForFlow**](TriggersAPI.md#SearchTriggersForFlow) | **Get** /api/v1/{tenant}/triggers/{namespace}/{flowId} | Get all triggers for a flow
[**UnlockTrigger**](TriggersAPI.md#UnlockTrigger) | **Post** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/unlock | Unlock a trigger
[**UnlockTriggersByIds**](TriggersAPI.md#UnlockTriggersByIds) | **Post** /api/v1/{tenant}/triggers/unlock/by-triggers | Unlock given triggers
[**UnlockTriggersByQuery**](TriggersAPI.md#UnlockTriggersByQuery) | **Post** /api/v1/{tenant}/triggers/unlock/by-query | Unlock triggers by query parameters
[**UnpauseBackfill**](TriggersAPI.md#UnpauseBackfill) | **Put** /api/v1/{tenant}/triggers/backfill/unpause | Unpause a backfill
[**UnpauseBackfillByIds**](TriggersAPI.md#UnpauseBackfillByIds) | **Post** /api/v1/{tenant}/triggers/backfill/unpause/by-triggers | Unpause backfill for given triggers
[**UnpauseBackfillByQuery**](TriggersAPI.md#UnpauseBackfillByQuery) | **Post** /api/v1/{tenant}/triggers/backfill/unpause/by-query | Unpause backfill for given triggers
[**UpdateTrigger**](TriggersAPI.md#UpdateTrigger) | **Put** /api/v1/{tenant}/triggers | Update a trigger



## DeleteBackfill

> Trigger DeleteBackfill(ctx, tenant).Trigger(trigger).Execute()

Delete a backfill

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
	trigger := *openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now()) // Trigger | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.DeleteBackfill(context.Background(), tenant).Trigger(trigger).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.DeleteBackfill``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteBackfill`: Trigger
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.DeleteBackfill`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteBackfillRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **trigger** | [**Trigger**](Trigger.md) |  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteBackfillByIds

> map[string]interface{} DeleteBackfillByIds(ctx, tenant).Trigger(trigger).Execute()

Delete backfill for given triggers

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
	trigger := []openapiclient.Trigger{*openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now())} // []Trigger | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.DeleteBackfillByIds(context.Background(), tenant).Trigger(trigger).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.DeleteBackfillByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteBackfillByIds`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.DeleteBackfillByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteBackfillByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **trigger** | [**[]Trigger**](Trigger.md) |  | 

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


## DeleteBackfillByQuery

> map[string]interface{} DeleteBackfillByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()

Delete backfill for given triggers

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
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.DeleteBackfillByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.DeleteBackfillByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteBackfillByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.DeleteBackfillByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteBackfillByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 

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


## DisabledTriggersByIds

> map[string]interface{} DisabledTriggersByIds(ctx, tenant).TriggerControllerSetDisabledRequest(triggerControllerSetDisabledRequest).Execute()

Disable/enable given triggers

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
	triggerControllerSetDisabledRequest := *openapiclient.NewTriggerControllerSetDisabledRequest([]openapiclient.Trigger{*openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now())}, false) // TriggerControllerSetDisabledRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.DisabledTriggersByIds(context.Background(), tenant).TriggerControllerSetDisabledRequest(triggerControllerSetDisabledRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.DisabledTriggersByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DisabledTriggersByIds`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.DisabledTriggersByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDisabledTriggersByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **triggerControllerSetDisabledRequest** | [**TriggerControllerSetDisabledRequest**](TriggerControllerSetDisabledRequest.md) |  | 

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


## DisabledTriggersByQuery

> map[string]interface{} DisabledTriggersByQuery(ctx, tenant).Disabled(disabled).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()

Disable/enable triggers by query parameters

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
	disabled := true // bool | The disabled state (default to true)
	tenant := "tenant_example" // string | 
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.DisabledTriggersByQuery(context.Background(), tenant).Disabled(disabled).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.DisabledTriggersByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DisabledTriggersByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.DisabledTriggersByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDisabledTriggersByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **disabled** | **bool** | The disabled state | [default to true]

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 

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


## PauseBackfill

> Trigger PauseBackfill(ctx, tenant).Trigger(trigger).Execute()

Pause a backfill

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
	trigger := *openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now()) // Trigger | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.PauseBackfill(context.Background(), tenant).Trigger(trigger).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.PauseBackfill``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PauseBackfill`: Trigger
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.PauseBackfill`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPauseBackfillRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **trigger** | [**Trigger**](Trigger.md) |  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PauseBackfillByIds

> map[string]interface{} PauseBackfillByIds(ctx, tenant).Trigger(trigger).Execute()

Pause backfill for given triggers

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
	trigger := []openapiclient.Trigger{*openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now())} // []Trigger | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.PauseBackfillByIds(context.Background(), tenant).Trigger(trigger).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.PauseBackfillByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PauseBackfillByIds`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.PauseBackfillByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPauseBackfillByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **trigger** | [**[]Trigger**](Trigger.md) |  | 

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


## PauseBackfillByQuery

> map[string]interface{} PauseBackfillByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()

Pause backfill for given triggers

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
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.PauseBackfillByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.PauseBackfillByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PauseBackfillByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.PauseBackfillByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPauseBackfillByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 

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


## RestartTrigger

> map[string]interface{} RestartTrigger(ctx, namespace, flowId, triggerId, tenant).Execute()

Restart a trigger

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
	flowId := "flowId_example" // string | The flow id
	triggerId := "triggerId_example" // string | The trigger id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.RestartTrigger(context.Background(), namespace, flowId, triggerId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.RestartTrigger``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `RestartTrigger`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.RestartTrigger`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow id | 
**triggerId** | **string** | The trigger id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiRestartTriggerRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------





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


## SearchTriggers

> PagedResultsTriggerControllerTriggers SearchTriggers(ctx, tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Namespace(namespace).WorkerId(workerId).FlowId(flowId).Execute()

Search for triggers

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
	tenant := "tenant_example" // string | 
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	workerId := "workerId_example" // string | The identifier of the worker currently evaluating the trigger (optional)
	flowId := "flowId_example" // string | The flow identifier (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.SearchTriggers(context.Background(), tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Namespace(namespace).WorkerId(workerId).FlowId(flowId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.SearchTriggers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchTriggers`: PagedResultsTriggerControllerTriggers
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.SearchTriggers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchTriggersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 
 **workerId** | **string** | The identifier of the worker currently evaluating the trigger | 
 **flowId** | **string** | The flow identifier | 

### Return type

[**PagedResultsTriggerControllerTriggers**](PagedResultsTriggerControllerTriggers.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchTriggersForFlow

> PagedResultsTrigger SearchTriggersForFlow(ctx, namespace, flowId, tenant).Page(page).Size(size).Sort(sort).Q(q).Execute()

Get all triggers for a flow

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
	namespace := "namespace_example" // string | The namespace
	flowId := "flowId_example" // string | The flow id
	tenant := "tenant_example" // string | 
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	q := "q_example" // string | A string filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.SearchTriggersForFlow(context.Background(), namespace, flowId, tenant).Page(page).Size(size).Sort(sort).Q(q).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.SearchTriggersForFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchTriggersForFlow`: PagedResultsTrigger
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.SearchTriggersForFlow`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchTriggersForFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]



 **sort** | **[]string** | The sort of current page | 
 **q** | **string** | A string filter | 

### Return type

[**PagedResultsTrigger**](PagedResultsTrigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UnlockTrigger

> Trigger UnlockTrigger(ctx, namespace, flowId, triggerId, tenant).Execute()

Unlock a trigger

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
	flowId := "flowId_example" // string | The flow id
	triggerId := "triggerId_example" // string | The trigger id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.UnlockTrigger(context.Background(), namespace, flowId, triggerId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.UnlockTrigger``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnlockTrigger`: Trigger
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.UnlockTrigger`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace | 
**flowId** | **string** | The flow id | 
**triggerId** | **string** | The trigger id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnlockTriggerRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------





### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UnlockTriggersByIds

> map[string]interface{} UnlockTriggersByIds(ctx, tenant).Trigger(trigger).Execute()

Unlock given triggers

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
	trigger := []openapiclient.Trigger{*openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now())} // []Trigger | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.UnlockTriggersByIds(context.Background(), tenant).Trigger(trigger).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.UnlockTriggersByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnlockTriggersByIds`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.UnlockTriggersByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnlockTriggersByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **trigger** | [**[]Trigger**](Trigger.md) |  | 

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


## UnlockTriggersByQuery

> map[string]interface{} UnlockTriggersByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()

Unlock triggers by query parameters

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
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.UnlockTriggersByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.UnlockTriggersByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnlockTriggersByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.UnlockTriggersByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnlockTriggersByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 

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


## UnpauseBackfill

> Trigger UnpauseBackfill(ctx, tenant).Trigger(trigger).Execute()

Unpause a backfill

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
	trigger := *openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now()) // Trigger | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.UnpauseBackfill(context.Background(), tenant).Trigger(trigger).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.UnpauseBackfill``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnpauseBackfill`: Trigger
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.UnpauseBackfill`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnpauseBackfillRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **trigger** | [**Trigger**](Trigger.md) |  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UnpauseBackfillByIds

> map[string]interface{} UnpauseBackfillByIds(ctx, tenant).Trigger(trigger).Execute()

Unpause backfill for given triggers

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
	trigger := []openapiclient.Trigger{*openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now())} // []Trigger | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.UnpauseBackfillByIds(context.Background(), tenant).Trigger(trigger).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.UnpauseBackfillByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnpauseBackfillByIds`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.UnpauseBackfillByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnpauseBackfillByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **trigger** | [**[]Trigger**](Trigger.md) |  | 

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


## UnpauseBackfillByQuery

> map[string]interface{} UnpauseBackfillByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()

Unpause backfill for given triggers

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
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.UnpauseBackfillByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.UnpauseBackfillByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UnpauseBackfillByQuery`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.UnpauseBackfillByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnpauseBackfillByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 

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


## UpdateTrigger

> Trigger UpdateTrigger(ctx, tenant).Trigger(trigger).Execute()

Update a trigger

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
	trigger := *openapiclient.NewTrigger("Namespace_example", "FlowId_example", "TriggerId_example", time.Now()) // Trigger | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TriggersAPI.UpdateTrigger(context.Background(), tenant).Trigger(trigger).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TriggersAPI.UpdateTrigger``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateTrigger`: Trigger
	fmt.Fprintf(os.Stdout, "Response from `TriggersAPI.UpdateTrigger`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateTriggerRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **trigger** | [**Trigger**](Trigger.md) |  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

