# \KVAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DeleteKeyValue**](KVAPI.md#DeleteKeyValue) | **Delete** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Delete a key-value pair
[**DeleteKeyValues**](KVAPI.md#DeleteKeyValues) | **Delete** /api/v1/{tenant}/namespaces/{namespace}/kv | Bulk-delete multiple key/value pairs from the given namespace.
[**KeyValue**](KVAPI.md#KeyValue) | **Get** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Get value for a key
[**ListAllKeys**](KVAPI.md#ListAllKeys) | **Get** /api/v1/{tenant}/kv | List all keys
[**ListKeys**](KVAPI.md#ListKeys) | **Get** /api/v1/{tenant}/namespaces/{namespace}/kv | List all keys for a namespace
[**ListKeysWithInheritence**](KVAPI.md#ListKeysWithInheritence) | **Get** /api/v1/{tenant}/namespaces/{namespace}/kv/inheritance | List all keys for inherited namespaces
[**SetKeyValue**](KVAPI.md#SetKeyValue) | **Put** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Puts a key-value pair in store



## DeleteKeyValue

> bool DeleteKeyValue(ctx, namespace, key, tenant).Execute()

Delete a key-value pair

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
	namespace := "namespace_example" // string | The namespace id
	key := "key_example" // string | The key
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.KVAPI.DeleteKeyValue(context.Background(), namespace, key, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `KVAPI.DeleteKeyValue``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteKeyValue`: bool
	fmt.Fprintf(os.Stdout, "Response from `KVAPI.DeleteKeyValue`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**key** | **string** | The key | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteKeyValueRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

**bool**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteKeyValues

> KVControllerApiDeleteBulkResponse DeleteKeyValues(ctx, namespace, tenant).KVControllerApiDeleteBulkRequest(kVControllerApiDeleteBulkRequest).Execute()

Bulk-delete multiple key/value pairs from the given namespace.

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
	namespace := "namespace_example" // string | The namespace id
	tenant := "tenant_example" // string | 
	kVControllerApiDeleteBulkRequest := *openapiclient.NewKVControllerApiDeleteBulkRequest() // KVControllerApiDeleteBulkRequest | The keys

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.KVAPI.DeleteKeyValues(context.Background(), namespace, tenant).KVControllerApiDeleteBulkRequest(kVControllerApiDeleteBulkRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `KVAPI.DeleteKeyValues``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteKeyValues`: KVControllerApiDeleteBulkResponse
	fmt.Fprintf(os.Stdout, "Response from `KVAPI.DeleteKeyValues`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteKeyValuesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **kVControllerApiDeleteBulkRequest** | [**KVControllerApiDeleteBulkRequest**](KVControllerApiDeleteBulkRequest.md) | The keys | 

### Return type

[**KVControllerApiDeleteBulkResponse**](KVControllerApiDeleteBulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## KeyValue

> KVControllerKvDetail KeyValue(ctx, namespace, key, tenant).Execute()

Get value for a key

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
	namespace := "namespace_example" // string | The namespace id
	key := "key_example" // string | The key
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.KVAPI.KeyValue(context.Background(), namespace, key, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `KVAPI.KeyValue``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `KeyValue`: KVControllerKvDetail
	fmt.Fprintf(os.Stdout, "Response from `KVAPI.KeyValue`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**key** | **string** | The key | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiKeyValueRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**KVControllerKvDetail**](KVControllerKvDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListAllKeys

> PagedResultsKVEntry ListAllKeys(ctx, tenant).Page(page).Size(size).Sort(sort).Filters(filters).Execute()

List all keys

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
	resp, r, err := apiClient.KVAPI.ListAllKeys(context.Background(), tenant).Page(page).Size(size).Sort(sort).Filters(filters).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `KVAPI.ListAllKeys``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListAllKeys`: PagedResultsKVEntry
	fmt.Fprintf(os.Stdout, "Response from `KVAPI.ListAllKeys`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListAllKeysRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

### Return type

[**PagedResultsKVEntry**](PagedResultsKVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListKeys

> []KVEntry ListKeys(ctx, namespace, tenant).Execute()

List all keys for a namespace

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
	namespace := "namespace_example" // string | The namespace id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.KVAPI.ListKeys(context.Background(), namespace, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `KVAPI.ListKeys``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListKeys`: []KVEntry
	fmt.Fprintf(os.Stdout, "Response from `KVAPI.ListKeys`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListKeysRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]KVEntry**](KVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListKeysWithInheritence

> []KVEntry ListKeysWithInheritence(ctx, namespace, tenant).Execute()

List all keys for inherited namespaces

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
	namespace := "namespace_example" // string | The namespace id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.KVAPI.ListKeysWithInheritence(context.Background(), namespace, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `KVAPI.ListKeysWithInheritence``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListKeysWithInheritence`: []KVEntry
	fmt.Fprintf(os.Stdout, "Response from `KVAPI.ListKeysWithInheritence`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListKeysWithInheritenceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]KVEntry**](KVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetKeyValue

> SetKeyValue(ctx, namespace, key, tenant).Body(body).Execute()

Puts a key-value pair in store

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
	namespace := "namespace_example" // string | The namespace id
	key := "key_example" // string | The key
	tenant := "tenant_example" // string | 
	body := "body_example" // string | The value of the key

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.KVAPI.SetKeyValue(context.Background(), namespace, key, tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `KVAPI.SetKeyValue``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**key** | **string** | The key | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetKeyValueRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **body** | **string** | The value of the key | 

### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

