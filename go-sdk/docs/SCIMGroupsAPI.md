# \SCIMGroupsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateSCIMResourceByIdGroups**](SCIMGroupsAPI.md#CreateSCIMResourceByIdGroups) | **Post** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | 
[**DeleteGroups**](SCIMGroupsAPI.md#DeleteGroups) | **Delete** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**FindGroups**](SCIMGroupsAPI.md#FindGroups) | **Post** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/.search | 
[**GetSCIMResourceByIdGroups**](SCIMGroupsAPI.md#GetSCIMResourceByIdGroups) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**PatchGroups**](SCIMGroupsAPI.md#PatchGroups) | **Patch** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**QueryGroups**](SCIMGroupsAPI.md#QueryGroups) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | 
[**UpdateGroups**](SCIMGroupsAPI.md#UpdateGroups) | **Put** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 



## CreateSCIMResourceByIdGroups

> ScimResource CreateSCIMResourceByIdGroups(ctx, integration, tenant).ScimUser(scimUser).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()





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
	resp, r, err := apiClient.SCIMGroupsAPI.CreateSCIMResourceByIdGroups(context.Background(), integration, tenant).ScimUser(scimUser).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMGroupsAPI.CreateSCIMResourceByIdGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateSCIMResourceByIdGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMGroupsAPI.CreateSCIMResourceByIdGroups`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateSCIMResourceByIdGroupsRequest struct via the builder pattern


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


## DeleteGroups

> DeleteGroups(ctx, id, integration, tenant).Execute()





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
	r, err := apiClient.SCIMGroupsAPI.DeleteGroups(context.Background(), id, integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMGroupsAPI.DeleteGroups``: %v\n", err)
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

Other parameters are passed through a pointer to a apiDeleteGroupsRequest struct via the builder pattern


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


## FindGroups

> ScimResource FindGroups(ctx, integration, tenant).SearchRequest(searchRequest).Execute()





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
	resp, r, err := apiClient.SCIMGroupsAPI.FindGroups(context.Background(), integration, tenant).SearchRequest(searchRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMGroupsAPI.FindGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMGroupsAPI.FindGroups`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFindGroupsRequest struct via the builder pattern


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


## GetSCIMResourceByIdGroups

> ScimResource GetSCIMResourceByIdGroups(ctx, id, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()





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
	resp, r, err := apiClient.SCIMGroupsAPI.GetSCIMResourceByIdGroups(context.Background(), id, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMGroupsAPI.GetSCIMResourceByIdGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetSCIMResourceByIdGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMGroupsAPI.GetSCIMResourceByIdGroups`: %v\n", resp)
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

Other parameters are passed through a pointer to a apiGetSCIMResourceByIdGroupsRequest struct via the builder pattern


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


## PatchGroups

> PatchGroups(ctx, id, integration, tenant).PatchRequest(patchRequest).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()





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
	r, err := apiClient.SCIMGroupsAPI.PatchGroups(context.Background(), id, integration, tenant).PatchRequest(patchRequest).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMGroupsAPI.PatchGroups``: %v\n", err)
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

Other parameters are passed through a pointer to a apiPatchGroupsRequest struct via the builder pattern


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


## QueryGroups

> ScimResource QueryGroups(ctx, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Filter(filter).SortBy(sortBy).SortOrder(sortOrder).StartIndex(startIndex).Count(count).Execute()





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
	resp, r, err := apiClient.SCIMGroupsAPI.QueryGroups(context.Background(), integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Filter(filter).SortBy(sortBy).SortOrder(sortOrder).StartIndex(startIndex).Count(count).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMGroupsAPI.QueryGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `QueryGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMGroupsAPI.QueryGroups`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiQueryGroupsRequest struct via the builder pattern


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


## UpdateGroups

> ScimResource UpdateGroups(ctx, id, integration, tenant).ScimResource(scimResource).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()





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
	resp, r, err := apiClient.SCIMGroupsAPI.UpdateGroups(context.Background(), id, integration, tenant).ScimResource(scimResource).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMGroupsAPI.UpdateGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMGroupsAPI.UpdateGroups`: %v\n", resp)
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

Other parameters are passed through a pointer to a apiUpdateGroupsRequest struct via the builder pattern


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

