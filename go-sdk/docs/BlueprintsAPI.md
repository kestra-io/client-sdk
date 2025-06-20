# \BlueprintsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateInternalBlueprints**](BlueprintsAPI.md#CreateInternalBlueprints) | **Post** /api/v1/{tenant}/blueprints/custom | Create a new internal blueprint
[**DeleteInternalBlueprints**](BlueprintsAPI.md#DeleteInternalBlueprints) | **Delete** /api/v1/{tenant}/blueprints/custom/{id} | Delete an internal blueprint
[**GetBlueprint**](BlueprintsAPI.md#GetBlueprint) | **Get** /api/v1/{tenant}/blueprints/community/{kind}/{id} | Get a blueprint
[**GetBlueprintGraph**](BlueprintsAPI.md#GetBlueprintGraph) | **Get** /api/v1/{tenant}/blueprints/community/{kind}/{id}/graph | Get a blueprint graph
[**GetBlueprintSource**](BlueprintsAPI.md#GetBlueprintSource) | **Get** /api/v1/{tenant}/blueprints/community/{kind}/{id}/source | Get a blueprint source code
[**InternalBlueprint**](BlueprintsAPI.md#InternalBlueprint) | **Get** /api/v1/{tenant}/blueprints/custom/{id} | Get an internal blueprint
[**InternalBlueprintFlow**](BlueprintsAPI.md#InternalBlueprintFlow) | **Get** /api/v1/{tenant}/blueprints/custom/{id}/source | Get an internal blueprint source code
[**SearchBlueprints**](BlueprintsAPI.md#SearchBlueprints) | **Get** /api/v1/{tenant}/blueprints/community/{kind} | List all blueprints
[**SearchInternalBlueprints**](BlueprintsAPI.md#SearchInternalBlueprints) | **Get** /api/v1/{tenant}/blueprints/custom | List all internal blueprints
[**UpdateInternalBlueprints**](BlueprintsAPI.md#UpdateInternalBlueprints) | **Put** /api/v1/{tenant}/blueprints/custom/{id} | Update an internal blueprint



## CreateInternalBlueprints

> BlueprintControllerApiBlueprintItemWithSource CreateInternalBlueprints(ctx, tenant).BlueprintControllerApiBlueprintItemWithSource(blueprintControllerApiBlueprintItemWithSource).Execute()

Create a new internal blueprint

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
	blueprintControllerApiBlueprintItemWithSource := *openapiclient.NewBlueprintControllerApiBlueprintItemWithSource() // BlueprintControllerApiBlueprintItemWithSource | The internal blueprint to create

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.CreateInternalBlueprints(context.Background(), tenant).BlueprintControllerApiBlueprintItemWithSource(blueprintControllerApiBlueprintItemWithSource).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.CreateInternalBlueprints``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateInternalBlueprints`: BlueprintControllerApiBlueprintItemWithSource
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.CreateInternalBlueprints`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateInternalBlueprintsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **blueprintControllerApiBlueprintItemWithSource** | [**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md) | The internal blueprint to create | 

### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteInternalBlueprints

> DeleteInternalBlueprints(ctx, id, tenant).Execute()

Delete an internal blueprint

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
	id := "id_example" // string | The internal blueprint id to delete
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.BlueprintsAPI.DeleteInternalBlueprints(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.DeleteInternalBlueprints``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The internal blueprint id to delete | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteInternalBlueprintsRequest struct via the builder pattern


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


## GetBlueprint

> BlueprintControllerApiBlueprintItemWithSource GetBlueprint(ctx, id, kind, tenant).Execute()

Get a blueprint

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
	id := "id_example" // string | The blueprint id
	kind := openapiclient.BlueprintController.Kind("APP") // BlueprintControllerKind | The blueprint kind
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.GetBlueprint(context.Background(), id, kind, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.GetBlueprint``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetBlueprint`: BlueprintControllerApiBlueprintItemWithSource
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.GetBlueprint`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The blueprint id | 
**kind** | [**BlueprintControllerKind**](.md) | The blueprint kind | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetBlueprintRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetBlueprintGraph

> map[string]map[string]interface{} GetBlueprintGraph(ctx, id, kind, tenant).Execute()

Get a blueprint graph

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
	id := "id_example" // string | The blueprint id
	kind := openapiclient.BlueprintController.Kind("APP") // BlueprintControllerKind | The blueprint kind
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.GetBlueprintGraph(context.Background(), id, kind, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.GetBlueprintGraph``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetBlueprintGraph`: map[string]map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.GetBlueprintGraph`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The blueprint id | 
**kind** | [**BlueprintControllerKind**](.md) | The blueprint kind | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetBlueprintGraphRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

**map[string]map[string]interface{}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetBlueprintSource

> string GetBlueprintSource(ctx, id, kind, tenant).Execute()

Get a blueprint source code

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
	id := "id_example" // string | The blueprint id
	kind := openapiclient.BlueprintController.Kind("APP") // BlueprintControllerKind | The blueprint kind
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.GetBlueprintSource(context.Background(), id, kind, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.GetBlueprintSource``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetBlueprintSource`: string
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.GetBlueprintSource`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The blueprint id | 
**kind** | [**BlueprintControllerKind**](.md) | The blueprint kind | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetBlueprintSourceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/yaml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## InternalBlueprint

> BlueprintControllerApiBlueprintItemWithSource InternalBlueprint(ctx, id, tenant).Execute()

Get an internal blueprint

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
	id := "id_example" // string | The blueprint id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.InternalBlueprint(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.InternalBlueprint``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `InternalBlueprint`: BlueprintControllerApiBlueprintItemWithSource
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.InternalBlueprint`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The blueprint id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiInternalBlueprintRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## InternalBlueprintFlow

> string InternalBlueprintFlow(ctx, id, tenant).Execute()

Get an internal blueprint source code

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
	id := "id_example" // string | The blueprint id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.InternalBlueprintFlow(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.InternalBlueprintFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `InternalBlueprintFlow`: string
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.InternalBlueprintFlow`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The blueprint id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiInternalBlueprintFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/yaml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchBlueprints

> PagedResultsBlueprintControllerApiBlueprintItem SearchBlueprints(ctx, kind, tenant).Page(page).Size(size).Q(q).Sort(sort).Tags(tags).Execute()

List all blueprints

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
	size := int32(56) // int32 | The current page size (default to 1)
	kind := openapiclient.BlueprintController.Kind("APP") // BlueprintControllerKind | The blueprint kind
	tenant := "tenant_example" // string | 
	q := "q_example" // string | A string filter (optional)
	sort := "sort_example" // string | The sort of current page (optional)
	tags := []string{"Inner_example"} // []string | A tags filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.SearchBlueprints(context.Background(), kind, tenant).Page(page).Size(size).Q(q).Sort(sort).Tags(tags).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.SearchBlueprints``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchBlueprints`: PagedResultsBlueprintControllerApiBlueprintItem
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.SearchBlueprints`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**kind** | [**BlueprintControllerKind**](.md) | The blueprint kind | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchBlueprintsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 1]


 **q** | **string** | A string filter | 
 **sort** | **string** | The sort of current page | 
 **tags** | **[]string** | A tags filter | 

### Return type

[**PagedResultsBlueprintControllerApiBlueprintItem**](PagedResultsBlueprintControllerApiBlueprintItem.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchInternalBlueprints

> PagedResultsBlueprint SearchInternalBlueprints(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Tags(tags).Execute()

List all internal blueprints

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
	size := int32(56) // int32 | The current page size (default to 1)
	tenant := "tenant_example" // string | 
	q := "q_example" // string | A string filter (optional)
	sort := "sort_example" // string | The sort of current page (optional)
	tags := []string{"Inner_example"} // []string | A tags filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.SearchInternalBlueprints(context.Background(), tenant).Page(page).Size(size).Q(q).Sort(sort).Tags(tags).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.SearchInternalBlueprints``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchInternalBlueprints`: PagedResultsBlueprint
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.SearchInternalBlueprints`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchInternalBlueprintsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 1]

 **q** | **string** | A string filter | 
 **sort** | **string** | The sort of current page | 
 **tags** | **[]string** | A tags filter | 

### Return type

[**PagedResultsBlueprint**](PagedResultsBlueprint.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateInternalBlueprints

> BlueprintWithFlow UpdateInternalBlueprints(ctx, id, tenant).BlueprintControllerApiBlueprintItemWithSource(blueprintControllerApiBlueprintItemWithSource).Execute()

Update an internal blueprint

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
	id := "id_example" // string | The id of the internal blueprint to update
	tenant := "tenant_example" // string | 
	blueprintControllerApiBlueprintItemWithSource := *openapiclient.NewBlueprintControllerApiBlueprintItemWithSource() // BlueprintControllerApiBlueprintItemWithSource | The new internal blueprint for update

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BlueprintsAPI.UpdateInternalBlueprints(context.Background(), id, tenant).BlueprintControllerApiBlueprintItemWithSource(blueprintControllerApiBlueprintItemWithSource).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BlueprintsAPI.UpdateInternalBlueprints``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateInternalBlueprints`: BlueprintWithFlow
	fmt.Fprintf(os.Stdout, "Response from `BlueprintsAPI.UpdateInternalBlueprints`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The id of the internal blueprint to update | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateInternalBlueprintsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **blueprintControllerApiBlueprintItemWithSource** | [**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md) | The new internal blueprint for update | 

### Return type

[**BlueprintWithFlow**](BlueprintWithFlow.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

