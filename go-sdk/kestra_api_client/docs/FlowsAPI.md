# \FlowsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**FlowDependenciesFromNamespace**](FlowsAPI.md#FlowDependenciesFromNamespace) | **Get** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**GenerateFlowGraph**](FlowsAPI.md#GenerateFlowGraph) | **Get** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow
[**GenerateFlowGraphFromSource**](FlowsAPI.md#GenerateFlowGraphFromSource) | **Post** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source
[**ListDistinctNamespaces**](FlowsAPI.md#ListDistinctNamespaces) | **Get** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces
[**SearchConcurrencyLimits**](FlowsAPI.md#SearchConcurrencyLimits) | **Get** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits
[**UpdateConcurrencyLimit**](FlowsAPI.md#UpdateConcurrencyLimit) | **Put** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit
[**UpdateFlowsInNamespace**](FlowsAPI.md#UpdateFlowsInNamespace) | **Post** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from yaml source
[**ValidateFlows**](FlowsAPI.md#ValidateFlows) | **Post** /api/v1/{tenant}/flows/validate | Validate a list of flows
[**ValidateTask**](FlowsAPI.md#ValidateTask) | **Post** /api/v1/{tenant}/flows/validate/task | Validate a task
[**ValidateTrigger**](FlowsAPI.md#ValidateTrigger) | **Post** /api/v1/{tenant}/flows/validate/trigger | Validate trigger



## FlowDependenciesFromNamespace

> FlowTopologyGraph FlowDependenciesFromNamespace(ctx, namespace, tenant).DestinationOnly(destinationOnly).Execute()

Retrieve flow dependencies

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
	namespace := "namespace_example" // string | The flow namespace
	tenant := "tenant_example" // string | 
	destinationOnly := openapiclient.schemasFromType_arrayOf_parameter{Bool: new(bool)} // SchemasFromTypeArrayOfParameter | if true, list only destination dependencies, otherwise list also source dependencies (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.FlowDependenciesFromNamespace(context.Background(), namespace, tenant).DestinationOnly(destinationOnly).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.FlowDependenciesFromNamespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FlowDependenciesFromNamespace`: FlowTopologyGraph
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.FlowDependenciesFromNamespace`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFlowDependenciesFromNamespaceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **destinationOnly** | [**SchemasFromTypeArrayOfParameter**](SchemasFromTypeArrayOfParameter.md) | if true, list only destination dependencies, otherwise list also source dependencies | 

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


## GenerateFlowGraph

> FlowGraph GenerateFlowGraph(ctx, id, namespace, tenant).Revision(revision).Subflows(subflows).Execute()

Generate a graph for a flow

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
	id := "id_example" // string | The flow id
	namespace := "namespace_example" // string | The flow namespace
	tenant := "tenant_example" // string | 
	revision := openapiclient.generateFlowGraph_revision_parameter{Int32: new(int32)} // GenerateFlowGraphRevisionParameter | The flow revision (optional)
	subflows := []string{"Inner_example"} // []string | The subflow tasks to display (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.GenerateFlowGraph(context.Background(), id, namespace, tenant).Revision(revision).Subflows(subflows).Execute()
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
**id** | **string** | The flow id | 
**namespace** | **string** | The flow namespace | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGenerateFlowGraphRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **revision** | [**GenerateFlowGraphRevisionParameter**](GenerateFlowGraphRevisionParameter.md) | The flow revision | 
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	body := "body_example" // string | The flow source code
	subflows := openapiclient.generateFlowGraphFromSource_subflows_parameter{Array: new(Array)} // GenerateFlowGraphFromSourceSubflowsParameter | The subflow tasks to display (optional)

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
 **subflows** | [**GenerateFlowGraphFromSourceSubflowsParameter**](GenerateFlowGraphFromSourceSubflowsParameter.md) | The subflow tasks to display | 

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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


## SearchConcurrencyLimits

> PagedResultsConcurrencyLimit SearchConcurrencyLimits(ctx, tenant).Execute()

Search for flow concurrency limits

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
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.SearchConcurrencyLimits(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.SearchConcurrencyLimits``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchConcurrencyLimits`: PagedResultsConcurrencyLimit
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.SearchConcurrencyLimits`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchConcurrencyLimitsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**PagedResultsConcurrencyLimit**](PagedResultsConcurrencyLimit.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateConcurrencyLimit

> ConcurrencyLimit UpdateConcurrencyLimit(ctx, namespace, flowId, tenant).ConcurrencyLimit(concurrencyLimit).Execute()

Update a flow concurrency limit

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
	namespace := "namespace_example" // string | 
	flowId := "flowId_example" // string | 
	tenant := "tenant_example" // string | 
	concurrencyLimit := *openapiclient.NewConcurrencyLimit("TenantId_example", "Namespace_example", "FlowId_example") // ConcurrencyLimit | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.UpdateConcurrencyLimit(context.Background(), namespace, flowId, tenant).ConcurrencyLimit(concurrencyLimit).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.UpdateConcurrencyLimit``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateConcurrencyLimit`: ConcurrencyLimit
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.UpdateConcurrencyLimit`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** |  | 
**flowId** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateConcurrencyLimitRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **concurrencyLimit** | [**ConcurrencyLimit**](ConcurrencyLimit.md) |  | 

### Return type

[**ConcurrencyLimit**](ConcurrencyLimit.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateFlowsInNamespace

> []FlowInterface UpdateFlowsInNamespace(ctx, namespace, tenant).Override(override).Delete(delete).Execute()

Update a complete namespace from yaml source



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
	namespace := "namespace_example" // string | The flow namespace
	tenant := "tenant_example" // string | 
	override := openapiclient.updateFlowsInNamespace_override_parameter{Bool: new(bool)} // UpdateFlowsInNamespaceOverrideParameter | If namespace of all provided flows should be overridden (optional)
	delete := true // bool | If missing flows should be deleted (optional) (default to true)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.FlowsAPI.UpdateFlowsInNamespace(context.Background(), namespace, tenant).Override(override).Delete(delete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `FlowsAPI.UpdateFlowsInNamespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateFlowsInNamespace`: []FlowInterface
	fmt.Fprintf(os.Stdout, "Response from `FlowsAPI.UpdateFlowsInNamespace`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The flow namespace | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateFlowsInNamespaceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **override** | [**UpdateFlowsInNamespaceOverrideParameter**](UpdateFlowsInNamespaceOverrideParameter.md) | If namespace of all provided flows should be overridden | 
 **delete** | **bool** | If missing flows should be deleted | [default to true]

### Return type

[**[]FlowInterface**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	body := "body_example" // string | Flows as YAML string or multipart files

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

 **body** | **string** | Flows as YAML string or multipart files | 

### Return type

[**[]ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml, multipart/form-data
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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	section := openapiclient.FlowController.TaskValidationType("TASKS") // FlowControllerTaskValidationType | The type of task
	tenant := "tenant_example" // string | 
	body := map[string]interface{}{ ... } // map[string]interface{} | A task definition that can be from tasks or triggers

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

 **body** | **map[string]interface{}** | A task definition that can be from tasks or triggers | 

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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

