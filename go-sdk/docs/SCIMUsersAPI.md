# \SCIMUsersAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateSCIMResourceByIdUsers**](SCIMUsersAPI.md#CreateSCIMResourceByIdUsers) | **Post** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users | 
[**DeleteUsers**](SCIMUsersAPI.md#DeleteUsers) | **Delete** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | 
[**FindUsers**](SCIMUsersAPI.md#FindUsers) | **Post** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/.search | 
[**GetSCIMResourceByIdUsers**](SCIMUsersAPI.md#GetSCIMResourceByIdUsers) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | 
[**PatchUsers**](SCIMUsersAPI.md#PatchUsers) | **Patch** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | 
[**QueryUsers**](SCIMUsersAPI.md#QueryUsers) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users | 
[**UpdateUsers**](SCIMUsersAPI.md#UpdateUsers) | **Put** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | 



## CreateSCIMResourceByIdUsers

> ScimResource CreateSCIMResourceByIdUsers(ctx, integration, tenant).ScimUser(scimUser).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 
	scimUser := *openapiclient.NewScimUser(*openapiclient.NewMeta(), "ResourceType_example") // ScimUser | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMUsersAPI.CreateSCIMResourceByIdUsers(context.Background(), integration, tenant).ScimUser(scimUser).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMUsersAPI.CreateSCIMResourceByIdUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateSCIMResourceByIdUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMUsersAPI.CreateSCIMResourceByIdUsers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateSCIMResourceByIdUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **scimUser** | [**ScimUser**](ScimUser.md) |  | 
 **attributes** | **string** |  | 
 **excludedAttributes** | **string** |  | 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteUsers

> DeleteUsers(ctx, id, integration, tenant).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.SCIMUsersAPI.DeleteUsers(context.Background(), id, integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMUsersAPI.DeleteUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** |  | 
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

 (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## FindUsers

> ScimResource FindUsers(ctx, integration, tenant).SearchRequest(searchRequest).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 
	searchRequest := *openapiclient.NewSearchRequest() // SearchRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMUsersAPI.FindUsers(context.Background(), integration, tenant).SearchRequest(searchRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMUsersAPI.FindUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMUsersAPI.FindUsers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFindUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **searchRequest** | [**SearchRequest**](SearchRequest.md) |  | 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetSCIMResourceByIdUsers

> ScimResource GetSCIMResourceByIdUsers(ctx, id, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMUsersAPI.GetSCIMResourceByIdUsers(context.Background(), id, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMUsersAPI.GetSCIMResourceByIdUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetSCIMResourceByIdUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMUsersAPI.GetSCIMResourceByIdUsers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** |  | 
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetSCIMResourceByIdUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **attributes** | **string** |  | 
 **excludedAttributes** | **string** |  | 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchUsers

> PatchUsers(ctx, id, integration, tenant).PatchRequest(patchRequest).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 
	patchRequest := *openapiclient.NewPatchRequest() // PatchRequest | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.SCIMUsersAPI.PatchUsers(context.Background(), id, integration, tenant).PatchRequest(patchRequest).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMUsersAPI.PatchUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** |  | 
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPatchUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **patchRequest** | [**PatchRequest**](PatchRequest.md) |  | 
 **attributes** | **string** |  | 
 **excludedAttributes** | **string** |  | 

### Return type

 (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## QueryUsers

> ScimResource QueryUsers(ctx, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Filter(filter).SortBy(sortBy).SortOrder(sortOrder).StartIndex(startIndex).Count(count).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)
	filter := "filter_example" // string |  (optional)
	sortBy := "sortBy_example" // string |  (optional)
	sortOrder := openapiclient.SortOrder("ASCENDING") // SortOrder |  (optional)
	startIndex := int32(56) // int32 |  (optional)
	count := int32(56) // int32 |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMUsersAPI.QueryUsers(context.Background(), integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Filter(filter).SortBy(sortBy).SortOrder(sortOrder).StartIndex(startIndex).Count(count).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMUsersAPI.QueryUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `QueryUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMUsersAPI.QueryUsers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiQueryUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **attributes** | **string** |  | 
 **excludedAttributes** | **string** |  | 
 **filter** | **string** |  | 
 **sortBy** | **string** |  | 
 **sortOrder** | [**SortOrder**](SortOrder.md) |  | 
 **startIndex** | **int32** |  | 
 **count** | **int32** |  | 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateUsers

> ScimResource UpdateUsers(ctx, id, integration, tenant).ScimResource(scimResource).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 
	scimResource := *openapiclient.NewScimResource(*openapiclient.NewMeta(), "ResourceType_example") // ScimResource | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMUsersAPI.UpdateUsers(context.Background(), id, integration, tenant).ScimResource(scimResource).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMUsersAPI.UpdateUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMUsersAPI.UpdateUsers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** |  | 
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **scimResource** | [**ScimResource**](ScimResource.md) |  | 
 **attributes** | **string** |  | 
 **excludedAttributes** | **string** |  | 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

