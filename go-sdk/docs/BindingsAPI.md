# \BindingsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**BulkCreateBinding**](BindingsAPI.md#BulkCreateBinding) | **Post** /api/v1/{tenant}/bindings/bulk | Create multiple bindings
[**BulkCreateBindingapsSuperAdmin**](BindingsAPI.md#BulkCreateBindingapsSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/bindings/bulk | Create multiple bindings
[**CreateBinding**](BindingsAPI.md#CreateBinding) | **Post** /api/v1/{tenant}/bindings | Create a binding
[**CreateBindingapsSuperAdmin**](BindingsAPI.md#CreateBindingapsSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/bindings | Create a binding
[**DeleteBinding**](BindingsAPI.md#DeleteBinding) | **Delete** /api/v1/{tenant}/bindings/{id} | Delete a binding
[**DeleteBindingapsSuperAdmin**](BindingsAPI.md#DeleteBindingapsSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/bindings/{id} | Delete a binding
[**GetBinding**](BindingsAPI.md#GetBinding) | **Get** /api/v1/{tenant}/bindings/{id} | Get a binding
[**GetBindingapsSuperAdmin**](BindingsAPI.md#GetBindingapsSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/bindings/{id} | Get a binding
[**SearchBindings**](BindingsAPI.md#SearchBindings) | **Get** /api/v1/{tenant}/bindings/search | Search for bindings
[**SearchBindingsapsSuperAdmin**](BindingsAPI.md#SearchBindingsapsSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/bindings/search | Search for bindings



## BulkCreateBinding

> []AbstractBindingControllerBindingDetail BulkCreateBinding(ctx, tenant).Binding(binding).Execute()

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
	binding := []openapiclient.Binding{*openapiclient.NewBinding(openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example", false)} // []Binding | The bindings

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.BulkCreateBinding(context.Background(), tenant).Binding(binding).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.BulkCreateBinding``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkCreateBinding`: []AbstractBindingControllerBindingDetail
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

 **binding** | [**[]Binding**](Binding.md) | The bindings | 

### Return type

[**[]AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## BulkCreateBindingapsSuperAdmin

> []AbstractBindingControllerBindingDetail BulkCreateBindingapsSuperAdmin(ctx, resourceTenant).Binding(binding).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 
	binding := []openapiclient.Binding{*openapiclient.NewBinding(openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example", false)} // []Binding | The bindings

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.BulkCreateBindingapsSuperAdmin(context.Background(), resourceTenant).Binding(binding).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.BulkCreateBindingapsSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkCreateBindingapsSuperAdmin`: []AbstractBindingControllerBindingDetail
	fmt.Fprintf(os.Stdout, "Response from `BindingsAPI.BulkCreateBindingapsSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiBulkCreateBindingapsSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **binding** | [**[]Binding**](Binding.md) | The bindings | 

### Return type

[**[]AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateBinding

> AbstractBindingControllerBindingDetail CreateBinding(ctx, tenant).Binding(binding).Execute()

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
	binding := *openapiclient.NewBinding(openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example", false) // Binding | The binding

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.CreateBinding(context.Background(), tenant).Binding(binding).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.CreateBinding``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateBinding`: AbstractBindingControllerBindingDetail
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

 **binding** | [**Binding**](Binding.md) | The binding | 

### Return type

[**AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateBindingapsSuperAdmin

> AbstractBindingControllerBindingDetail CreateBindingapsSuperAdmin(ctx, resourceTenant).Binding(binding).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 
	binding := *openapiclient.NewBinding(openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example", false) // Binding | The binding

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.CreateBindingapsSuperAdmin(context.Background(), resourceTenant).Binding(binding).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.CreateBindingapsSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateBindingapsSuperAdmin`: AbstractBindingControllerBindingDetail
	fmt.Fprintf(os.Stdout, "Response from `BindingsAPI.CreateBindingapsSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateBindingapsSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **binding** | [**Binding**](Binding.md) | The binding | 

### Return type

[**AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

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


## DeleteBindingapsSuperAdmin

> DeleteBindingapsSuperAdmin(ctx, id, resourceTenant).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.BindingsAPI.DeleteBindingapsSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.DeleteBindingapsSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The binding id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteBindingapsSuperAdminRequest struct via the builder pattern


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

> AbstractBindingControllerBindingDetail GetBinding(ctx, id, tenant).Execute()

Get a binding

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
	// response from `GetBinding`: AbstractBindingControllerBindingDetail
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

[**AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetBindingapsSuperAdmin

> AbstractBindingControllerBindingDetail GetBindingapsSuperAdmin(ctx, id, resourceTenant).Execute()

Get a binding

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
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.GetBindingapsSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.GetBindingapsSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetBindingapsSuperAdmin`: AbstractBindingControllerBindingDetail
	fmt.Fprintf(os.Stdout, "Response from `BindingsAPI.GetBindingapsSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The binding id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetBindingapsSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchBindings

> PagedResultsAbstractBindingControllerBindingDetail SearchBindings(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Id(id).Namespace(namespace).Execute()

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
	// response from `SearchBindings`: PagedResultsAbstractBindingControllerBindingDetail
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

[**PagedResultsAbstractBindingControllerBindingDetail**](PagedResultsAbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchBindingsapsSuperAdmin

> PagedResultsAbstractBindingControllerBindingDetail SearchBindingsapsSuperAdmin(ctx, resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Id(id).Namespace(namespace).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	type_ := openapiclient.Binding.Type("USER") // BindingType | Binding type filter (optional)
	id := "id_example" // string | External id filter (optional)
	namespace := "namespace_example" // string | A namespace filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BindingsAPI.SearchBindingsapsSuperAdmin(context.Background(), resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Id(id).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BindingsAPI.SearchBindingsapsSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchBindingsapsSuperAdmin`: PagedResultsAbstractBindingControllerBindingDetail
	fmt.Fprintf(os.Stdout, "Response from `BindingsAPI.SearchBindingsapsSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchBindingsapsSuperAdminRequest struct via the builder pattern


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

[**PagedResultsAbstractBindingControllerBindingDetail**](PagedResultsAbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

