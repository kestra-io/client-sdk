# \FlowsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**BulkImportApps**](FlowsAPI.md#BulkImportApps) | **Post** /api/v1/{tenant}/apps/import |     Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 
[**BulkUpdateFlows**](FlowsAPI.md#BulkUpdateFlows) | **Post** /api/v1/{tenant}/flows/bulk | Update from multiples yaml sources
[**CreateFlow**](FlowsAPI.md#CreateFlow) | **Post** /api/v1/{tenant}/flows | Create a flow from yaml source
[**DeleteFlow**](FlowsAPI.md#DeleteFlow) | **Delete** /api/v1/{tenant}/flows/{namespace}/{id} | Delete a flow
[**DeleteFlowsByIds**](FlowsAPI.md#DeleteFlowsByIds) | **Delete** /api/v1/{tenant}/flows/delete/by-ids | Delete flows by their IDs.
[**DeleteFlowsByQuery**](FlowsAPI.md#DeleteFlowsByQuery) | **Delete** /api/v1/{tenant}/flows/delete/by-query | Delete flows returned by the query parameters.
[**DisableFlowsByIds**](FlowsAPI.md#DisableFlowsByIds) | **Post** /api/v1/{tenant}/flows/disable/by-ids | Disable flows by their IDs.
[**DisableFlowsByQuery**](FlowsAPI.md#DisableFlowsByQuery) | **Post** /api/v1/{tenant}/flows/disable/by-query | Disable flows returned by the query parameters.
[**EnableFlowsByIds**](FlowsAPI.md#EnableFlowsByIds) | **Post** /api/v1/{tenant}/flows/enable/by-ids | Enable flows by their IDs.
[**EnableFlowsByQuery**](FlowsAPI.md#EnableFlowsByQuery) | **Post** /api/v1/{tenant}/flows/enable/by-query | Enable flows returned by the query parameters.
[**ExportFlowsByIds**](FlowsAPI.md#ExportFlowsByIds) | **Post** /api/v1/{tenant}/flows/export/by-ids | Export flows as a ZIP archive of yaml sources.
[**ExportFlowsByQuery**](FlowsAPI.md#ExportFlowsByQuery) | **Get** /api/v1/{tenant}/flows/export/by-query | Export flows as a ZIP archive of yaml sources.
[**GenerateFlowGraph**](FlowsAPI.md#GenerateFlowGraph) | **Get** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow
[**GenerateFlowGraphFromSource**](FlowsAPI.md#GenerateFlowGraphFromSource) | **Post** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source
[**GetFlow**](FlowsAPI.md#GetFlow) | **Get** /api/v1/{tenant}/flows/{namespace}/{id} | Get a flow
[**GetFlowDependencies**](FlowsAPI.md#GetFlowDependencies) | **Get** /api/v1/{tenant}/flows/{namespace}/{id}/dependencies | Get flow dependencies
[**GetFlowDependenciesFromNamespace**](FlowsAPI.md#GetFlowDependenciesFromNamespace) | **Get** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**GetTaskFromFlow**](FlowsAPI.md#GetTaskFromFlow) | **Get** /api/v1/{tenant}/flows/{namespace}/{id}/tasks/{taskId} | Get a flow task
[**ImportFlows**](FlowsAPI.md#ImportFlows) | **Post** /api/v1/{tenant}/flows/import |     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 
[**ListDistinctNamespaces**](FlowsAPI.md#ListDistinctNamespaces) | **Get** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces
[**ListFlowRevisions**](FlowsAPI.md#ListFlowRevisions) | **Get** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Get revisions for a flow
[**ListFlowsByNamespace**](FlowsAPI.md#ListFlowsByNamespace) | **Get** /api/v1/{tenant}/flows/{namespace} | Retrieve all flows from a given namespace
[**SearchFlows**](FlowsAPI.md#SearchFlows) | **Get** /api/v1/{tenant}/flows/search | Search for flows
[**SearchFlowsBySourceCode**](FlowsAPI.md#SearchFlowsBySourceCode) | **Get** /api/v1/{tenant}/flows/source | Search for flows source code
[**UpdateFlow**](FlowsAPI.md#UpdateFlow) | **Put** /api/v1/{tenant}/flows/{namespace}/{id} | Update a flow
[**UpdateFlowsInNamespaceFromJson**](FlowsAPI.md#UpdateFlowsInNamespaceFromJson) | **Post** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from json object
[**UpdateTask**](FlowsAPI.md#UpdateTask) | **Patch** /api/v1/{tenant}/flows/{namespace}/{id}/{taskId} | Update a single task on a flow
[**ValidateFlows**](FlowsAPI.md#ValidateFlows) | **Post** /api/v1/{tenant}/flows/validate | Validate a list of flows
[**ValidateTask**](FlowsAPI.md#ValidateTask) | **Post** /api/v1/{tenant}/flows/validate/task | Validate a task
[**ValidateTrigger**](FlowsAPI.md#ValidateTrigger) | **Post** /api/v1/{tenant}/flows/validate/trigger | Validate trigger



## BulkImportApps

> AppsControllerApiBulkImportResponse BulkImportApps(ctx, tenant).FileUpload(fileUpload).Execute()

    Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn't be imported is returned. 

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
	fileUpload := os.NewFile(1234, "some_file") // *os.File | The file to import, can be a ZIP archive or a multi-objects YAML file (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.BulkImportApps(context.Background(), tenant).FileUpload(fileUpload).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.BulkImportApps``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkImportApps`: AppsControllerApiBulkImportResponse
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.BulkImportApps`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiBulkImportAppsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **fileUpload** | ***os.File** | The file to import, can be a ZIP archive or a multi-objects YAML file | 

### Return type

[**AppsControllerApiBulkImportResponse**](AppsControllerApiBulkImportResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## BulkUpdateFlows

> []FlowInterface BulkUpdateFlows(ctx, tenant).Delete(delete).AllowNamespaceChild(allowNamespaceChild).Namespace(namespace).Body(body).Execute()

Update from multiples yaml sources



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
	delete := true // bool | If missing flow should be deleted (default to true)
	allowNamespaceChild := true // bool | If namespace child should are allowed to be updated (default to false)
	tenant := "tenant_example" // string | 
	namespace := "namespace_example" // string | The namespace where to update flows (optional)
	body := "body_example" // string | A list of flows source code splitted with \"---\" (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.BulkUpdateFlows(context.Background(), tenant).Delete(delete).AllowNamespaceChild(allowNamespaceChild).Namespace(namespace).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.BulkUpdateFlows``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkUpdateFlows`: []FlowInterface
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.BulkUpdateFlows`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiBulkUpdateFlowsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **delete** | **bool** | If missing flow should be deleted | [default to true]
 **allowNamespaceChild** | **bool** | If namespace child should are allowed to be updated | [default to false]

 **namespace** | **string** | The namespace where to update flows | 
 **body** | **string** | A list of flows source code splitted with \&quot;---\&quot; | 

### Return type

[**[]FlowInterface**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateFlow

> FlowWithSource CreateFlow(ctx, tenant).Body(body).Execute()

Create a flow from yaml source

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
	body := "body_example" // string | The flow source code

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.CreateFlow(context.Background(), tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.CreateFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateFlow`: FlowWithSource
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.CreateFlow`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | **string** | The flow source code | 

### Return type

[**FlowWithSource**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteFlow

> DeleteFlow(ctx, namespace, id, tenant).Execute()

Delete a flow

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
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.FlowsAPI.DeleteFlow(context.Background(), namespace, id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.DeleteFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteFlowRequest struct via the builder pattern


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


## DeleteFlowsByIds

> BulkResponse DeleteFlowsByIds(ctx, tenant).IdWithNamespace(idWithNamespace).Execute()

Delete flows by their IDs.

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
	idWithNamespace := []openapiclient.IdWithNamespace{*openapiclient.NewIdWithNamespace()} // []IdWithNamespace | A list of tuple flow ID and namespace as flow identifiers

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.DeleteFlowsByIds(context.Background(), tenant).IdWithNamespace(idWithNamespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.DeleteFlowsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteFlowsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.DeleteFlowsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteFlowsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **idWithNamespace** | [**[]IdWithNamespace**](IdWithNamespace.md) | A list of tuple flow ID and namespace as flow identifiers | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteFlowsByQuery

> BulkResponse DeleteFlowsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()

Delete flows returned by the query parameters.

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
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the flows to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.DeleteFlowsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.DeleteFlowsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteFlowsByQuery`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.DeleteFlowsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteFlowsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the flows to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DisableFlowsByIds

> BulkResponse DisableFlowsByIds(ctx, tenant).IdWithNamespace(idWithNamespace).Execute()

Disable flows by their IDs.

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
	idWithNamespace := []openapiclient.IdWithNamespace{*openapiclient.NewIdWithNamespace()} // []IdWithNamespace | A list of tuple flow ID and namespace as flow identifiers

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.DisableFlowsByIds(context.Background(), tenant).IdWithNamespace(idWithNamespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.DisableFlowsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DisableFlowsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.DisableFlowsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDisableFlowsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **idWithNamespace** | [**[]IdWithNamespace**](IdWithNamespace.md) | A list of tuple flow ID and namespace as flow identifiers | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DisableFlowsByQuery

> BulkResponse DisableFlowsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()

Disable flows returned by the query parameters.

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
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the flows to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.DisableFlowsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.DisableFlowsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DisableFlowsByQuery`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.DisableFlowsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDisableFlowsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the flows to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## EnableFlowsByIds

> BulkResponse EnableFlowsByIds(ctx, tenant).IdWithNamespace(idWithNamespace).Execute()

Enable flows by their IDs.

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
	idWithNamespace := []openapiclient.IdWithNamespace{*openapiclient.NewIdWithNamespace()} // []IdWithNamespace | A list of tuple flow ID and namespace as flow identifiers

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.EnableFlowsByIds(context.Background(), tenant).IdWithNamespace(idWithNamespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.EnableFlowsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `EnableFlowsByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.EnableFlowsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiEnableFlowsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **idWithNamespace** | [**[]IdWithNamespace**](IdWithNamespace.md) | A list of tuple flow ID and namespace as flow identifiers | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## EnableFlowsByQuery

> BulkResponse EnableFlowsByQuery(ctx, tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()

Enable flows returned by the query parameters.

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
	deleteExecutionsByQueryRequest := *openapiclient.NewDeleteExecutionsByQueryRequest() // DeleteExecutionsByQueryRequest | 
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the flows to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.EnableFlowsByQuery(context.Background(), tenant).DeleteExecutionsByQueryRequest(deleteExecutionsByQueryRequest).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.EnableFlowsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `EnableFlowsByQuery`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.EnableFlowsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiEnableFlowsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md) |  | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the flows to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ExportFlowsByIds

> string ExportFlowsByIds(ctx, tenant).IdWithNamespace(idWithNamespace).Execute()

Export flows as a ZIP archive of yaml sources.

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
	idWithNamespace := []openapiclient.IdWithNamespace{*openapiclient.NewIdWithNamespace()} // []IdWithNamespace | A list of tuple flow ID and namespace as flow identifiers

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ExportFlowsByIds(context.Background(), tenant).IdWithNamespace(idWithNamespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ExportFlowsByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ExportFlowsByIds`: string
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ExportFlowsByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiExportFlowsByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **idWithNamespace** | [**[]IdWithNamespace**](IdWithNamespace.md) | A list of tuple flow ID and namespace as flow identifiers | 

### Return type

**string**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ExportFlowsByQuery

> string ExportFlowsByQuery(ctx, tenant).Filters(filters).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()

Export flows as a ZIP archive of yaml sources.

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
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the flows to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ExportFlowsByQuery(context.Background(), tenant).Filters(filters).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ExportFlowsByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ExportFlowsByQuery`: string
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ExportFlowsByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiExportFlowsByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the flows to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 

### Return type

**string**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GenerateFlowGraph

> FlowGraph GenerateFlowGraph(ctx, namespace, id, tenant).Revision(revision).Subflows(subflows).Execute()

Generate a graph for a flow

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
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	tenant := "tenant_example" // string | 
	revision := int32(56) // int32 | The flow revision (optional)
	subflows := []string{"Inner_example"} // []string | The subflow tasks to display (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.GenerateFlowGraph(context.Background(), namespace, id, tenant).Revision(revision).Subflows(subflows).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.GenerateFlowGraph``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GenerateFlowGraph`: FlowGraph
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.GenerateFlowGraph`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGenerateFlowGraphRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **revision** | **int32** | The flow revision | 
 **subflows** | **[]string** | The subflow tasks to display | 

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GenerateFlowGraphFromSource

> FlowGraph GenerateFlowGraphFromSource(ctx, tenant).Body(body).Subflows(subflows).Execute()

Generate a graph for a flow source

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
	body := "body_example" // string | The flow source code
	subflows := []string{"Inner_example"} // []string | The subflow tasks to display (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.GenerateFlowGraphFromSource(context.Background(), tenant).Body(body).Subflows(subflows).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.GenerateFlowGraphFromSource``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GenerateFlowGraphFromSource`: FlowGraph
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.GenerateFlowGraphFromSource`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGenerateFlowGraphFromSourceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | **string** | The flow source code | 
 **subflows** | **[]string** | The subflow tasks to display | 

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetFlow

> map[string]interface{} GetFlow(ctx, namespace, id, tenant).Source(source).AllowDeleted(allowDeleted).Revision(revision).Execute()

Get a flow

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
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	source := true // bool | Include the source code (default to false)
	allowDeleted := true // bool | Get flow even if deleted (default to false)
	tenant := "tenant_example" // string | 
	revision := int32(56) // int32 | Get latest revision by default (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.GetFlow(context.Background(), namespace, id, tenant).Source(source).AllowDeleted(allowDeleted).Revision(revision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.GetFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetFlow`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.GetFlow`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **source** | **bool** | Include the source code | [default to false]
 **allowDeleted** | **bool** | Get flow even if deleted | [default to false]

 **revision** | **int32** | Get latest revision by default | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetFlowDependencies

> FlowTopologyGraph GetFlowDependencies(ctx, namespace, id, tenant).DestinationOnly(destinationOnly).ExpandAll(expandAll).Execute()

Get flow dependencies

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
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	destinationOnly := true // bool | If true, list only destination dependencies, otherwise list also source dependencies (default to false)
	expandAll := true // bool | If true, expand all dependencies recursively (default to false)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.GetFlowDependencies(context.Background(), namespace, id, tenant).DestinationOnly(destinationOnly).ExpandAll(expandAll).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.GetFlowDependencies``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetFlowDependencies`: FlowTopologyGraph
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.GetFlowDependencies`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetFlowDependenciesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **destinationOnly** | **bool** | If true, list only destination dependencies, otherwise list also source dependencies | [default to false]
 **expandAll** | **bool** | If true, expand all dependencies recursively | [default to false]


### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetFlowDependenciesFromNamespace

> FlowTopologyGraph GetFlowDependenciesFromNamespace(ctx, namespace, tenant).DestinationOnly(destinationOnly).Execute()

Retrieve flow dependencies

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
	namespace := "namespace_example" // string | The flow namespace
	destinationOnly := true // bool | if true, list only destination dependencies, otherwise list also source dependencies (default to false)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.GetFlowDependenciesFromNamespace(context.Background(), namespace, tenant).DestinationOnly(destinationOnly).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.GetFlowDependenciesFromNamespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetFlowDependenciesFromNamespace`: FlowTopologyGraph
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.GetFlowDependenciesFromNamespace`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetFlowDependenciesFromNamespaceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **destinationOnly** | **bool** | if true, list only destination dependencies, otherwise list also source dependencies | [default to false]


### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetTaskFromFlow

> Task GetTaskFromFlow(ctx, namespace, id, taskId, tenant).Revision(revision).Execute()

Get a flow task

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
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	taskId := "taskId_example" // string | The task id
	tenant := "tenant_example" // string | 
	revision := int32(56) // int32 | The flow revision (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.GetTaskFromFlow(context.Background(), namespace, id, taskId, tenant).Revision(revision).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.GetTaskFromFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetTaskFromFlow`: Task
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.GetTaskFromFlow`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**taskId** | **string** | The task id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetTaskFromFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




 **revision** | **int32** | The flow revision | 

### Return type

[**Task**](Task.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ImportFlows

> []string ImportFlows(ctx, tenant).FileUpload(fileUpload).Execute()

    Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn't be imported is returned. 

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
	fileUpload := os.NewFile(1234, "some_file") // *os.File | The file to import, can be a ZIP archive or a multi-objects YAML file (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ImportFlows(context.Background(), tenant).FileUpload(fileUpload).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ImportFlows``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ImportFlows`: []string
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ImportFlows`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiImportFlowsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **fileUpload** | ***os.File** | The file to import, can be a ZIP archive or a multi-objects YAML file | 

### Return type

**[]string**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListDistinctNamespaces

> []string ListDistinctNamespaces(ctx, tenant).Q(q).Execute()

List all distinct namespaces

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
	q := "q_example" // string | A string filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ListDistinctNamespaces(context.Background(), tenant).Q(q).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ListDistinctNamespaces``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListDistinctNamespaces`: []string
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ListDistinctNamespaces`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListDistinctNamespacesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **q** | **string** | A string filter | 

### Return type

**[]string**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListFlowRevisions

> []FlowWithSource ListFlowRevisions(ctx, namespace, id, tenant).Execute()

Get revisions for a flow

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
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ListFlowRevisions(context.Background(), namespace, id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ListFlowRevisions``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListFlowRevisions`: []FlowWithSource
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ListFlowRevisions`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListFlowRevisionsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**[]FlowWithSource**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListFlowsByNamespace

> []Flow ListFlowsByNamespace(ctx, namespace, tenant).Execute()

Retrieve all flows from a given namespace

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
	namespace := "namespace_example" // string | Namespace to filter flows
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ListFlowsByNamespace(context.Background(), namespace, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ListFlowsByNamespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListFlowsByNamespace`: []Flow
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ListFlowsByNamespace`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | Namespace to filter flows | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListFlowsByNamespaceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]Flow**](Flow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchFlows

> PagedResultsFlow SearchFlows(ctx, tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()

Search for flows

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
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters (optional)
	q := "q_example" // string | A string filter (optional)
	scope := []openapiclient.FlowScope{openapiclient.FlowScope("USER")} // []FlowScope | The scope of the flows to include (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	labels := []string{"Inner_example"} // []string | A labels filter as a list of 'key:value' (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.SearchFlows(context.Background(), tenant).Page(page).Size(size).Sort(sort).Filters(filters).Q(q).Scope(scope).Namespace(namespace).Labels(labels).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.SearchFlows``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchFlows`: PagedResultsFlow
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.SearchFlows`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchFlowsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 
 **q** | **string** | A string filter | 
 **scope** | [**[]FlowScope**](FlowScope.md) | The scope of the flows to include | 
 **namespace** | **string** | A namespace filter prefix | 
 **labels** | **[]string** | A labels filter as a list of &#39;key:value&#39; | 

### Return type

[**PagedResultsFlow**](PagedResultsFlow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchFlowsBySourceCode

> PagedResultsSearchResultFlow SearchFlowsBySourceCode(ctx, tenant).Page(page).Size(size).Sort(sort).Q(q).Namespace(namespace).Execute()

Search for flows source code

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
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.SearchFlowsBySourceCode(context.Background(), tenant).Page(page).Size(size).Sort(sort).Q(q).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.SearchFlowsBySourceCode``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchFlowsBySourceCode`: PagedResultsSearchResultFlow
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.SearchFlowsBySourceCode`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchFlowsBySourceCodeRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 

### Return type

[**PagedResultsSearchResultFlow**](PagedResultsSearchResultFlow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateFlow

> UpdateFlow200Response UpdateFlow(ctx, id, namespace, tenant).Body(body).Execute()

Update a flow

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
	id := "id_example" // string | The flow id
	namespace := "namespace_example" // string | The flow namespace
	tenant := "tenant_example" // string | 
	body := "body_example" // string | The flow source code

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.UpdateFlow(context.Background(), id, namespace, tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.UpdateFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateFlow`: UpdateFlow200Response
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.UpdateFlow`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The flow id | 
**namespace** | **string** | The flow namespace | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **body** | **string** | The flow source code | 

### Return type

[**UpdateFlow200Response**](UpdateFlow200Response.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateFlowsInNamespaceFromJson

> UpdateFlowsInNamespaceFromJson200Response UpdateFlowsInNamespaceFromJson(ctx, namespace, tenant).Delete(delete).Flow(flow).Execute()

Update a complete namespace from json object



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
	delete := true // bool | If missing flow should be deleted (default to true)
	namespace := "namespace_example" // string | The flow namespace
	tenant := "tenant_example" // string | 
	flow := []openapiclient.Flow{*openapiclient.NewFlow("Id_example", "Namespace_example", false, false, []openapiclient.Task{*openapiclient.NewTask("Id_example", "Type_example")})} // []Flow | A list of flows

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.UpdateFlowsInNamespaceFromJson(context.Background(), namespace, tenant).Delete(delete).Flow(flow).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.UpdateFlowsInNamespaceFromJson``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateFlowsInNamespaceFromJson`: UpdateFlowsInNamespaceFromJson200Response
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.UpdateFlowsInNamespaceFromJson`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateFlowsInNamespaceFromJsonRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **delete** | **bool** | If missing flow should be deleted | [default to true]


 **flow** | [**[]Flow**](Flow.md) | A list of flows | 

### Return type

[**UpdateFlowsInNamespaceFromJson200Response**](UpdateFlowsInNamespaceFromJson200Response.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateTask

> Flow UpdateTask(ctx, namespace, id, taskId, tenant).Task(task).Execute()

Update a single task on a flow

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
	namespace := "namespace_example" // string | The flow namespace
	id := "id_example" // string | The flow id
	taskId := "taskId_example" // string | The task id
	tenant := "tenant_example" // string | 
	task := *openapiclient.NewTask("Id_example", "Type_example") // Task | The task

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.UpdateTask(context.Background(), namespace, id, taskId, tenant).Task(task).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.UpdateTask``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateTask`: Flow
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.UpdateTask`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**id** | **string** | The flow id | 
**taskId** | **string** | The task id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateTaskRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




 **task** | [**Task**](Task.md) | The task | 

### Return type

[**Flow**](Flow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ValidateFlows

> []ValidateConstraintViolation ValidateFlows(ctx, tenant).Body(body).Execute()

Validate a list of flows

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
	body := "body_example" // string | A list of flows source code in a single string

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ValidateFlows(context.Background(), tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ValidateFlows``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ValidateFlows`: []ValidateConstraintViolation
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ValidateFlows`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiValidateFlowsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | **string** | A list of flows source code in a single string | 

### Return type

[**[]ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ValidateTask

> ValidateConstraintViolation ValidateTask(ctx, tenant).Section(section).Body(body).Execute()

Validate a task

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
	section := openapiclient.FlowController.TaskValidationType("TASKS") // FlowControllerTaskValidationType | The type of task
	tenant := "tenant_example" // string | 
	body := "body_example" // string | A task definition that can be from tasks or triggers

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ValidateTask(context.Background(), tenant).Section(section).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ValidateTask``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ValidateTask`: ValidateConstraintViolation
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ValidateTask`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiValidateTaskRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **section** | [**FlowControllerTaskValidationType**](FlowControllerTaskValidationType.md) | The type of task | 

 **body** | **string** | A task definition that can be from tasks or triggers | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml, application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ValidateTrigger

> ValidateConstraintViolation ValidateTrigger(ctx, tenant).Body(body).Execute()

Validate trigger

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
	body := map[string]interface{}{ ... } // map[string]interface{} | The trigger

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.ValidateTrigger(context.Background(), tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.ValidateTrigger``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ValidateTrigger`: ValidateConstraintViolation
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.ValidateTrigger`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiValidateTriggerRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | **map[string]interface{}** | The trigger | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

