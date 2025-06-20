# \BlueprintTagsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**InternalBlueprintTags**](BlueprintTagsAPI.md#InternalBlueprintTags) | **Get** /api/v1/{tenant}/blueprints/custom/tags | List all internal blueprint tags
[**ListBlueprintTags**](BlueprintTagsAPI.md#ListBlueprintTags) | **Get** /api/v1/{tenant}/blueprints/community/{kind}/tags | List blueprint tags matching the filter



## InternalBlueprintTags

> []string InternalBlueprintTags(ctx, tenant).Q(q).Execute()

List all internal blueprint tags

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
	q := "q_example" // string | A string filter to get tags with matching blueprints only (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintTagsAPI.InternalBlueprintTags(context.Background(), tenant).Q(q).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintTagsAPI.InternalBlueprintTags``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `InternalBlueprintTags`: []string
	fmt.Fprintf(os.Stdout, "Response from `BlueprintTagsAPI.InternalBlueprintTags`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiInternalBlueprintTagsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **q** | **string** | A string filter to get tags with matching blueprints only | 

### Return type

**[]string**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListBlueprintTags

> []BlueprintControllerApiBlueprintTagItem ListBlueprintTags(ctx, kind, tenant).Q(q).Execute()

List blueprint tags matching the filter

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
	kind := openapiclient.BlueprintController.Kind("APP") // BlueprintControllerKind | The blueprint kind
	tenant := "tenant_example" // string | 
	q := "q_example" // string | A string filter to get tags with matching blueprints only (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintTagsAPI.ListBlueprintTags(context.Background(), kind, tenant).Q(q).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintTagsAPI.ListBlueprintTags``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListBlueprintTags`: []BlueprintControllerApiBlueprintTagItem
	fmt.Fprintf(os.Stdout, "Response from `BlueprintTagsAPI.ListBlueprintTags`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**kind** | [**BlueprintControllerKind**](.md) | The blueprint kind | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListBlueprintTagsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **q** | **string** | A string filter to get tags with matching blueprints only | 

### Return type

[**[]BlueprintControllerApiBlueprintTagItem**](BlueprintControllerApiBlueprintTagItem.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

