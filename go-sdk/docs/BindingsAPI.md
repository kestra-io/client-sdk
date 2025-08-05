# \BindingsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**BulkCreateBinding**](BindingsAPI.md#BulkCreateBinding) | **Post** /api/v1/{tenant}/bindings/bulk | Create multiple bindings
[**CreateBinding**](BindingsAPI.md#CreateBinding) | **Post** /api/v1/{tenant}/bindings | Create a binding
[**DeleteBinding**](BindingsAPI.md#DeleteBinding) | **Delete** /api/v1/{tenant}/bindings/{id} | Delete a binding
[**GetBinding**](BindingsAPI.md#GetBinding) | **Get** /api/v1/{tenant}/bindings/{id} | Retrieve a binding
[**SearchBindings**](BindingsAPI.md#SearchBindings) | **Get** /api/v1/{tenant}/bindings/search | Search for bindings



## BulkCreateBinding

> []IAMBindingControllerApiBindingDetail BulkCreateBinding(ctx, tenant).IAMBindingControllerApiCreateBindingRequest(iAMBindingControllerApiCreateBindingRequest).Execute()

Create multiple bindings

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
	iAMBindingControllerApiCreateBindingRequest := []openapiclient.IAMBindingControllerApiCreateBindingRequest{*openapiclient.NewIAMBindingControllerApiCreateBindingRequest(openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example")} // []IAMBindingControllerApiCreateBindingRequest | The bindings

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.BulkCreateBinding(context.Background(), tenant).IAMBindingControllerApiCreateBindingRequest(iAMBindingControllerApiCreateBindingRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.BulkCreateBinding``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkCreateBinding`: []IAMBindingControllerApiBindingDetail
	fmt.Fprintf(os.Stdout, "Response from `BindingsAPI.BulkCreateBinding`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiBulkCreateBindingRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMBindingControllerApiCreateBindingRequest** | [**[]IAMBindingControllerApiCreateBindingRequest**](IAMBindingControllerApiCreateBindingRequest.md) | The bindings | 

### Return type

[**[]IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateBinding

> IAMBindingControllerApiBindingDetail CreateBinding(ctx, tenant).IAMBindingControllerApiCreateBindingRequest(iAMBindingControllerApiCreateBindingRequest).Execute()

Create a binding

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
	iAMBindingControllerApiCreateBindingRequest := *openapiclient.NewIAMBindingControllerApiCreateBindingRequest(openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example") // IAMBindingControllerApiCreateBindingRequest | The binding

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.CreateBinding(context.Background(), tenant).IAMBindingControllerApiCreateBindingRequest(iAMBindingControllerApiCreateBindingRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.CreateBinding``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateBinding`: IAMBindingControllerApiBindingDetail
	fmt.Fprintf(os.Stdout, "Response from `BindingsAPI.CreateBinding`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateBindingRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMBindingControllerApiCreateBindingRequest** | [**IAMBindingControllerApiCreateBindingRequest**](IAMBindingControllerApiCreateBindingRequest.md) | The binding | 

### Return type

[**IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteBinding

> DeleteBinding(ctx, id, tenant).Execute()

Delete a binding

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
	id := "id_example" // string | The binding id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.BindingsAPI.DeleteBinding(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.DeleteBinding``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The binding id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteBindingRequest struct via the builder pattern


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


## GetBinding

> IAMBindingControllerApiBindingDetail GetBinding(ctx, id, tenant).Execute()

Retrieve a binding

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
	id := "id_example" // string | The binding id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.GetBinding(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.GetBinding``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetBinding`: IAMBindingControllerApiBindingDetail
	fmt.Fprintf(os.Stdout, "Response from `BindingsAPI.GetBinding`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The binding id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetBindingRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchBindings

> PagedResultsIAMBindingControllerApiBindingDetail SearchBindings(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Id(id).Namespace(namespace).Execute()

Search for bindings

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
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	type_ := openapiclient.Binding.Type("USER") // BindingType | Binding type filter (optional)
	id := "id_example" // string | External id filter (optional)
	namespace := "namespace_example" // string | A namespace filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.SearchBindings(context.Background(), tenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Id(id).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.SearchBindings``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchBindings`: PagedResultsIAMBindingControllerApiBindingDetail
	fmt.Fprintf(os.Stdout, "Response from `BindingsAPI.SearchBindings`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchBindingsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 
 **type_** | [**BindingType**](BindingType.md) | Binding type filter | 
 **id** | **string** | External id filter | 
 **namespace** | **string** | A namespace filter | 

### Return type

[**PagedResultsIAMBindingControllerApiBindingDetail**](PagedResultsIAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

