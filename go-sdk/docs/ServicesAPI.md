# \ServicesAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetActiveServices**](ServicesAPI.md#GetActiveServices) | **Get** /api/v1/cluster/services/active | List all active services
[**GetService**](ServicesAPI.md#GetService) | **Get** /api/v1/cluster/services/{id} | Retrieve details of a specific service
[**SearchServices**](ServicesAPI.md#SearchServices) | **Get** /api/v1/cluster/services/search | Search for a service (e.g. Worker, Executor, etc)



## GetActiveServices

> ClusterControllerApiActiveServiceList GetActiveServices(ctx).Execute()

List all active services



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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServicesAPI.GetActiveServices(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServicesAPI.GetActiveServices``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetActiveServices`: ClusterControllerApiActiveServiceList
	fmt.Fprintf(os.Stdout, "Response from `ServicesAPI.GetActiveServices`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiGetActiveServicesRequest struct via the builder pattern


### Return type

[**ClusterControllerApiActiveServiceList**](ClusterControllerApiActiveServiceList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetService

> ServiceInstance GetService(ctx, id).Execute()

Retrieve details of a specific service



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
	id := "id_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServicesAPI.GetService(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServicesAPI.GetService``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetService`: ServiceInstance
	fmt.Fprintf(os.Stdout, "Response from `ServicesAPI.GetService`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetServiceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**ServiceInstance**](ServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchServices

> PagedResultsClusterControllerApiServiceInstance SearchServices(ctx).Page(page).Size(size).Sort(sort).State(state).Type_(type_).Execute()

Search for a service (e.g. Worker, Executor, etc)



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
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	state := []openapiclient.ServiceServiceState{openapiclient.Service.ServiceState("CREATED")} // []ServiceServiceState | The state filter (optional)
	type_ := []openapiclient.ServiceType{openapiclient.ServiceType("EXECUTOR")} // []ServiceType | The server type filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServicesAPI.SearchServices(context.Background()).Page(page).Size(size).Sort(sort).State(state).Type_(type_).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServicesAPI.SearchServices``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchServices`: PagedResultsClusterControllerApiServiceInstance
	fmt.Fprintf(os.Stdout, "Response from `ServicesAPI.SearchServices`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSearchServicesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **sort** | **[]string** | The sort of current page | 
 **state** | [**[]ServiceServiceState**](ServiceServiceState.md) | The state filter | 
 **type_** | [**[]ServiceType**](ServiceType.md) | The server type filter | 

### Return type

[**PagedResultsClusterControllerApiServiceInstance**](PagedResultsClusterControllerApiServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

