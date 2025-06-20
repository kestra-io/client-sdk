# \SCIMAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateSCIMResourceByIdGroups**](SCIMAPI.md#CreateSCIMResourceByIdGroups) | **Post** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | {@inheritDoc}
[**CreateSCIMResourceByIdUsers**](SCIMAPI.md#CreateSCIMResourceByIdUsers) | **Post** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users | {@inheritDoc}
[**DeleteGroups**](SCIMAPI.md#DeleteGroups) | **Delete** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | {@inheritDoc}
[**DeleteUsers**](SCIMAPI.md#DeleteUsers) | **Delete** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | {@inheritDoc}
[**FindGroups**](SCIMAPI.md#FindGroups) | **Post** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/.search | {@inheritDoc}
[**FindUsers**](SCIMAPI.md#FindUsers) | **Post** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/.search | {@inheritDoc}
[**GetSCIMResourceByIdGroups**](SCIMAPI.md#GetSCIMResourceByIdGroups) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | {@inheritDoc}
[**GetSCIMResourceByIdUsers**](SCIMAPI.md#GetSCIMResourceByIdUsers) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | {@inheritDoc}
[**PatchGroups**](SCIMAPI.md#PatchGroups) | **Patch** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | {@inheritDoc}
[**PatchUsers**](SCIMAPI.md#PatchUsers) | **Patch** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | {@inheritDoc}
[**QueryGroups**](SCIMAPI.md#QueryGroups) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | {@inheritDoc}
[**QueryUsers**](SCIMAPI.md#QueryUsers) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users | {@inheritDoc}
[**UpdateGroups**](SCIMAPI.md#UpdateGroups) | **Put** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | {@inheritDoc}
[**UpdateUsers**](SCIMAPI.md#UpdateUsers) | **Put** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | {@inheritDoc}



## CreateSCIMResourceByIdGroups

> map[string]interface{} CreateSCIMResourceByIdGroups(ctx, integration, tenant).ScimUser(scimUser).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()

{@inheritDoc}



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
	scimUser := *openapiclient.NewScimUser(*openapiclient.NewMeta()) // ScimUser | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMAPI.CreateSCIMResourceByIdGroups(context.Background(), integration, tenant).ScimUser(scimUser).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.CreateSCIMResourceByIdGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateSCIMResourceByIdGroups`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.CreateSCIMResourceByIdGroups`: %v\n", resp)
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

**map[string]interface{}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateSCIMResourceByIdUsers

> map[string]interface{} CreateSCIMResourceByIdUsers(ctx, integration, tenant).ScimUser(scimUser).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()

{@inheritDoc}



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
	scimUser := *openapiclient.NewScimUser(*openapiclient.NewMeta()) // ScimUser | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMAPI.CreateSCIMResourceByIdUsers(context.Background(), integration, tenant).ScimUser(scimUser).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.CreateSCIMResourceByIdUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateSCIMResourceByIdUsers`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.CreateSCIMResourceByIdUsers`: %v\n", resp)
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

**map[string]interface{}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteGroups

> map[string]interface{} DeleteGroups(ctx, id, integration, tenant).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.DeleteGroups(context.Background(), id, integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.DeleteGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteGroups`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.DeleteGroups`: %v\n", resp)
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

**map[string]interface{}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteUsers

> map[string]interface{} DeleteUsers(ctx, id, integration, tenant).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.DeleteUsers(context.Background(), id, integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.DeleteUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteUsers`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.DeleteUsers`: %v\n", resp)
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

**map[string]interface{}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## FindGroups

> ScimResource FindGroups(ctx, integration, tenant).SearchRequest(searchRequest).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.FindGroups(context.Background(), integration, tenant).SearchRequest(searchRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.FindGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.FindGroups`: %v\n", resp)
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


## FindUsers

> ScimResource FindUsers(ctx, integration, tenant).SearchRequest(searchRequest).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.FindUsers(context.Background(), integration, tenant).SearchRequest(searchRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.FindUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.FindUsers`: %v\n", resp)
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


## GetSCIMResourceByIdGroups

> ScimResource GetSCIMResourceByIdGroups(ctx, id, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.GetSCIMResourceByIdGroups(context.Background(), id, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.GetSCIMResourceByIdGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetSCIMResourceByIdGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.GetSCIMResourceByIdGroups`: %v\n", resp)
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


## GetSCIMResourceByIdUsers

> ScimResource GetSCIMResourceByIdUsers(ctx, id, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.GetSCIMResourceByIdUsers(context.Background(), id, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.GetSCIMResourceByIdUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetSCIMResourceByIdUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.GetSCIMResourceByIdUsers`: %v\n", resp)
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


## PatchGroups

> map[string]interface{} PatchGroups(ctx, id, integration, tenant).PatchRequest(patchRequest).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.PatchGroups(context.Background(), id, integration, tenant).PatchRequest(patchRequest).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.PatchGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PatchGroups`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.PatchGroups`: %v\n", resp)
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

**map[string]interface{}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchUsers

> map[string]interface{} PatchUsers(ctx, id, integration, tenant).PatchRequest(patchRequest).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.PatchUsers(context.Background(), id, integration, tenant).PatchRequest(patchRequest).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.PatchUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PatchUsers`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.PatchUsers`: %v\n", resp)
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

**map[string]interface{}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## QueryGroups

> ScimResource QueryGroups(ctx, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Filter(filter).SortBy(sortBy).SortOrder(sortOrder).StartIndex(startIndex).Count(count).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.QueryGroups(context.Background(), integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Filter(filter).SortBy(sortBy).SortOrder(sortOrder).StartIndex(startIndex).Count(count).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.QueryGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `QueryGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.QueryGroups`: %v\n", resp)
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


## QueryUsers

> ScimResource QueryUsers(ctx, integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Filter(filter).SortBy(sortBy).SortOrder(sortOrder).StartIndex(startIndex).Count(count).Execute()

{@inheritDoc}



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
	resp, r, err := apiClient.SCIMAPI.QueryUsers(context.Background(), integration, tenant).Attributes(attributes).ExcludedAttributes(excludedAttributes).Filter(filter).SortBy(sortBy).SortOrder(sortOrder).StartIndex(startIndex).Count(count).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.QueryUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `QueryUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.QueryUsers`: %v\n", resp)
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


## UpdateGroups

> ScimResource UpdateGroups(ctx, id, integration, tenant).ScimResource(scimResource).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()

{@inheritDoc}



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
	scimResource := *openapiclient.NewScimResource(*openapiclient.NewMeta()) // ScimResource | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMAPI.UpdateGroups(context.Background(), id, integration, tenant).ScimResource(scimResource).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.UpdateGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateGroups`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.UpdateGroups`: %v\n", resp)
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


## UpdateUsers

> ScimResource UpdateUsers(ctx, id, integration, tenant).ScimResource(scimResource).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()

{@inheritDoc}



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
	scimResource := *openapiclient.NewScimResource(*openapiclient.NewMeta()) // ScimResource | 
	attributes := "attributes_example" // string |  (optional)
	excludedAttributes := "excludedAttributes_example" // string |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMAPI.UpdateUsers(context.Background(), id, integration, tenant).ScimResource(scimResource).Attributes(attributes).ExcludedAttributes(excludedAttributes).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMAPI.UpdateUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateUsers`: ScimResource
	fmt.Fprintf(os.Stdout, "Response from `SCIMAPI.UpdateUsers`: %v\n", resp)
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

