# \AuditLogsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**FindAuditLog**](AuditLogsAPI.md#FindAuditLog) | **Post** /api/v1/{tenant}/auditlogs/find | Find a specific audit log
[**GetResourceDiffFromAuditLog**](AuditLogsAPI.md#GetResourceDiffFromAuditLog) | **Get** /api/v1/{tenant}/auditlogs/{id}/diff | Retrieve the diff between audit logs
[**ListAuditLogFromResourceId**](AuditLogsAPI.md#ListAuditLogFromResourceId) | **Get** /api/v1/{tenant}/auditlogs/history/{detailId} | Find all audit logs about a specific resource.
[**SearchAuditLogs**](AuditLogsAPI.md#SearchAuditLogs) | **Get** /api/v1/{tenant}/auditlogs/search | Search for audit logs



## FindAuditLog

> AuditLogControllerAuditLogWithUser FindAuditLog(ctx, tenant).AuditLogControllerFindRequest(auditLogControllerFindRequest).Execute()

Find a specific audit log

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
	auditLogControllerFindRequest := *openapiclient.NewAuditLogControllerFindRequest(openapiclient.Permission("FLOW"), "TODO", map[string]interface{}{"key": interface{}(123)}) // AuditLogControllerFindRequest | The find request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuditLogsAPI.FindAuditLog(context.Background(), tenant).AuditLogControllerFindRequest(auditLogControllerFindRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuditLogsAPI.FindAuditLog``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindAuditLog`: AuditLogControllerAuditLogWithUser
	fmt.Fprintf(os.Stdout, "Response from `AuditLogsAPI.FindAuditLog`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFindAuditLogRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **auditLogControllerFindRequest** | [**AuditLogControllerFindRequest**](AuditLogControllerFindRequest.md) | The find request | 

### Return type

[**AuditLogControllerAuditLogWithUser**](AuditLogControllerAuditLogWithUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetResourceDiffFromAuditLog

> AuditLogControllerAuditLogDiff GetResourceDiffFromAuditLog(ctx, id, tenant).PreviousId(previousId).Execute()

Retrieve the diff between audit logs



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
	id := "id_example" // string | The id of the audit log
	tenant := "tenant_example" // string | 
	previousId := "previousId_example" // string | The id of a previous audit log to compare with (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuditLogsAPI.GetResourceDiffFromAuditLog(context.Background(), id, tenant).PreviousId(previousId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuditLogsAPI.GetResourceDiffFromAuditLog``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetResourceDiffFromAuditLog`: AuditLogControllerAuditLogDiff
	fmt.Fprintf(os.Stdout, "Response from `AuditLogsAPI.GetResourceDiffFromAuditLog`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The id of the audit log | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetResourceDiffFromAuditLogRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **previousId** | **string** | The id of a previous audit log to compare with | 

### Return type

[**AuditLogControllerAuditLogDiff**](AuditLogControllerAuditLogDiff.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListAuditLogFromResourceId

> []AuditLogControllerAuditLogOption ListAuditLogFromResourceId(ctx, detailId, tenant).Execute()

Find all audit logs about a specific resource.

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
	detailId := "detailId_example" // string | The resource Id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuditLogsAPI.ListAuditLogFromResourceId(context.Background(), detailId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuditLogsAPI.ListAuditLogFromResourceId``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListAuditLogFromResourceId`: []AuditLogControllerAuditLogOption
	fmt.Fprintf(os.Stdout, "Response from `AuditLogsAPI.ListAuditLogFromResourceId`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**detailId** | **string** | The resource Id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListAuditLogFromResourceIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]AuditLogControllerAuditLogOption**](AuditLogControllerAuditLogOption.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchAuditLogs

> PagedResultsAuditLogControllerAuditLogWithUser SearchAuditLogs(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Namespace(namespace).FlowId(flowId).ExecutionId(executionId).UserId(userId).Id(id).Permission(permission).StartDate(startDate).EndDate(endDate).Details(details).Type_(type_).Execute()

Search for audit logs

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
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	namespace := "namespace_example" // string | A namespace filter (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)
	executionId := "executionId_example" // string | An execution filter (optional)
	userId := "userId_example" // string | A user id filter (optional)
	id := "id_example" // string | A id filter (optional)
	permission := openapiclient.Permission("FLOW") // Permission | A permission filter (optional)
	startDate := time.Now() // time.Time | The start datetime (optional)
	endDate := time.Now() // time.Time | The end datetime (optional)
	details := map[string]string{"key": "Inner_example"} // map[string]string | A list of auditLog details (optional)
	type_ := openapiclient.CrudEventType("READ") // CrudEventType | The event that create the audit log (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuditLogsAPI.SearchAuditLogs(context.Background(), tenant).Page(page).Size(size).Q(q).Sort(sort).Namespace(namespace).FlowId(flowId).ExecutionId(executionId).UserId(userId).Id(id).Permission(permission).StartDate(startDate).EndDate(endDate).Details(details).Type_(type_).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuditLogsAPI.SearchAuditLogs``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchAuditLogs`: PagedResultsAuditLogControllerAuditLogWithUser
	fmt.Fprintf(os.Stdout, "Response from `AuditLogsAPI.SearchAuditLogs`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchAuditLogsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 
 **namespace** | **string** | A namespace filter | 
 **flowId** | **string** | A flow id filter | 
 **executionId** | **string** | An execution filter | 
 **userId** | **string** | A user id filter | 
 **id** | **string** | A id filter | 
 **permission** | [**Permission**](Permission.md) | A permission filter | 
 **startDate** | **time.Time** | The start datetime | 
 **endDate** | **time.Time** | The end datetime | 
 **details** | **map[string]string** | A list of auditLog details | 
 **type_** | [**CrudEventType**](CrudEventType.md) | The event that create the audit log | 

### Return type

[**PagedResultsAuditLogControllerAuditLogWithUser**](PagedResultsAuditLogControllerAuditLogWithUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

