# \TenantAccessAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateTenantAccess**](TenantAccessAPI.md#CreateTenantAccess) | **Post** /api/v1/{tenant}/tenant-access | Create tenant access for a user
[**CreateTenantAccess1**](TenantAccessAPI.md#CreateTenantAccess1) | **Put** /api/v1/{tenant}/tenant-access/{userId} | Create tenant access for a user
[**DeleteTenantAccess**](TenantAccessAPI.md#DeleteTenantAccess) | **Delete** /api/v1/{tenant}/tenant-access/{userId} | Delete tenant access for a user
[**GetTenantAccess**](TenantAccessAPI.md#GetTenantAccess) | **Get** /api/v1/{tenant}/tenant-access/{userId} | Retrieve tenant access for a user
[**ListTenantAccess**](TenantAccessAPI.md#ListTenantAccess) | **Get** /api/v1/{tenant}/tenant-access | Retrieve users belonging to the tenant



## CreateTenantAccess

> CreateTenantAccess(ctx, tenant).IAMTenantAccessControllerApiCreateTenantAccessRequest(iAMTenantAccessControllerApiCreateTenantAccessRequest).Execute()

Create tenant access for a user



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
	iAMTenantAccessControllerApiCreateTenantAccessRequest := *openapiclient.NewIAMTenantAccessControllerApiCreateTenantAccessRequest("Email_example") // IAMTenantAccessControllerApiCreateTenantAccessRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.TenantAccessAPI.CreateTenantAccess(context.Background(), tenant).IAMTenantAccessControllerApiCreateTenantAccessRequest(iAMTenantAccessControllerApiCreateTenantAccessRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TenantAccessAPI.CreateTenantAccess``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateTenantAccessRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMTenantAccessControllerApiCreateTenantAccessRequest** | [**IAMTenantAccessControllerApiCreateTenantAccessRequest**](IAMTenantAccessControllerApiCreateTenantAccessRequest.md) |  | 

### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateTenantAccess1

> CreateTenantAccess1(ctx, userId, tenant).Execute()

Create tenant access for a user



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
	userId := "userId_example" // string | The user id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.TenantAccessAPI.CreateTenantAccess1(context.Background(), userId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TenantAccessAPI.CreateTenantAccess1``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**userId** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateTenantAccess1Request struct via the builder pattern


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


## DeleteTenantAccess

> DeleteTenantAccess(ctx, userId, tenant).Execute()

Delete tenant access for a user



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
	userId := "userId_example" // string | The user id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.TenantAccessAPI.DeleteTenantAccess(context.Background(), userId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TenantAccessAPI.DeleteTenantAccess``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**userId** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteTenantAccessRequest struct via the builder pattern


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


## GetTenantAccess

> IAMTenantAccessControllerApiTenantAccess GetTenantAccess(ctx, userId, tenant).Execute()

Retrieve tenant access for a user



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
	userId := "userId_example" // string | The user id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TenantAccessAPI.GetTenantAccess(context.Background(), userId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TenantAccessAPI.GetTenantAccess``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetTenantAccess`: IAMTenantAccessControllerApiTenantAccess
	fmt.Fprintf(os.Stdout, "Response from `TenantAccessAPI.GetTenantAccess`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**userId** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetTenantAccessRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**IAMTenantAccessControllerApiTenantAccess**](IAMTenantAccessControllerApiTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListTenantAccess

> PagedResultsIAMTenantAccessControllerApiUserTenantAccess ListTenantAccess(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Execute()

Retrieve users belonging to the tenant

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
	type_ := openapiclient.UserType("STANDARD") // UserType | The type of user (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TenantAccessAPI.ListTenantAccess(context.Background(), tenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TenantAccessAPI.ListTenantAccess``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListTenantAccess`: PagedResultsIAMTenantAccessControllerApiUserTenantAccess
	fmt.Fprintf(os.Stdout, "Response from `TenantAccessAPI.ListTenantAccess`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListTenantAccessRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 
 **type_** | [**UserType**](UserType.md) | The type of user | 

### Return type

[**PagedResultsIAMTenantAccessControllerApiUserTenantAccess**](PagedResultsIAMTenantAccessControllerApiUserTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

