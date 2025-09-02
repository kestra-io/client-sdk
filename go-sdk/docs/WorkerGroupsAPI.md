# \WorkerGroupsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateWorkerGroup**](WorkerGroupsAPI.md#CreateWorkerGroup) | **Post** /api/v1/instance/workergroups | Create a worker group
[**DeleteWorkerGroupById**](WorkerGroupsAPI.md#DeleteWorkerGroupById) | **Delete** /api/v1/instance/workergroups/{id} | Delete a worker group
[**GetWorkerGroupById**](WorkerGroupsAPI.md#GetWorkerGroupById) | **Get** /api/v1/instance/workergroups/{id} | Retrieve details of a specific worker group
[**ListWorkerGroups**](WorkerGroupsAPI.md#ListWorkerGroups) | **Get** /api/v1/instance/workergroups | List all worker groups
[**UpdateWorkerGroupById**](WorkerGroupsAPI.md#UpdateWorkerGroupById) | **Put** /api/v1/instance/workergroups/{id} | Update a worker group



## CreateWorkerGroup

> InstanceControllerApiWorkerGroup CreateWorkerGroup(ctx).InstanceControllerApiCreateOrUpdateWorkerGroupRequest(instanceControllerApiCreateOrUpdateWorkerGroupRequest).Execute()

Create a worker group



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
	instanceControllerApiCreateOrUpdateWorkerGroupRequest := *openapiclient.NewInstanceControllerApiCreateOrUpdateWorkerGroupRequest("Key_example", "Description_example", []string{"AllowedTenants_example"}) // InstanceControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.WorkerGroupsAPI.CreateWorkerGroup(context.Background()).InstanceControllerApiCreateOrUpdateWorkerGroupRequest(instanceControllerApiCreateOrUpdateWorkerGroupRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `WorkerGroupsAPI.CreateWorkerGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateWorkerGroup`: InstanceControllerApiWorkerGroup
	fmt.Fprintf(os.Stdout, "Response from `WorkerGroupsAPI.CreateWorkerGroup`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateWorkerGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instanceControllerApiCreateOrUpdateWorkerGroupRequest** | [**InstanceControllerApiCreateOrUpdateWorkerGroupRequest**](InstanceControllerApiCreateOrUpdateWorkerGroupRequest.md) | The worker group definition | 

### Return type

[**InstanceControllerApiWorkerGroup**](InstanceControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteWorkerGroupById

> map[string]interface{} DeleteWorkerGroupById(ctx, id).Execute()

Delete a worker group



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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.WorkerGroupsAPI.DeleteWorkerGroupById(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `WorkerGroupsAPI.DeleteWorkerGroupById``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteWorkerGroupById`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `WorkerGroupsAPI.DeleteWorkerGroupById`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteWorkerGroupByIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


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


## GetWorkerGroupById

> InstanceControllerApiWorkerGroupDetails GetWorkerGroupById(ctx, id).Execute()

Retrieve details of a specific worker group



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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.WorkerGroupsAPI.GetWorkerGroupById(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `WorkerGroupsAPI.GetWorkerGroupById``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetWorkerGroupById`: InstanceControllerApiWorkerGroupDetails
	fmt.Fprintf(os.Stdout, "Response from `WorkerGroupsAPI.GetWorkerGroupById`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetWorkerGroupByIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**InstanceControllerApiWorkerGroupDetails**](InstanceControllerApiWorkerGroupDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListWorkerGroups

> InstanceControllerApiWorkerGroupList ListWorkerGroups(ctx).Execute()

List all worker groups



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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.WorkerGroupsAPI.ListWorkerGroups(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `WorkerGroupsAPI.ListWorkerGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListWorkerGroups`: InstanceControllerApiWorkerGroupList
	fmt.Fprintf(os.Stdout, "Response from `WorkerGroupsAPI.ListWorkerGroups`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiListWorkerGroupsRequest struct via the builder pattern


### Return type

[**InstanceControllerApiWorkerGroupList**](InstanceControllerApiWorkerGroupList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateWorkerGroupById

> InstanceControllerApiWorkerGroup UpdateWorkerGroupById(ctx, id).InstanceControllerApiCreateOrUpdateWorkerGroupRequest(instanceControllerApiCreateOrUpdateWorkerGroupRequest).Execute()

Update a worker group



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
	instanceControllerApiCreateOrUpdateWorkerGroupRequest := *openapiclient.NewInstanceControllerApiCreateOrUpdateWorkerGroupRequest("Key_example", "Description_example", []string{"AllowedTenants_example"}) // InstanceControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.WorkerGroupsAPI.UpdateWorkerGroupById(context.Background(), id).InstanceControllerApiCreateOrUpdateWorkerGroupRequest(instanceControllerApiCreateOrUpdateWorkerGroupRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `WorkerGroupsAPI.UpdateWorkerGroupById``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateWorkerGroupById`: InstanceControllerApiWorkerGroup
	fmt.Fprintf(os.Stdout, "Response from `WorkerGroupsAPI.UpdateWorkerGroupById`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateWorkerGroupByIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **instanceControllerApiCreateOrUpdateWorkerGroupRequest** | [**InstanceControllerApiCreateOrUpdateWorkerGroupRequest**](InstanceControllerApiCreateOrUpdateWorkerGroupRequest.md) | The worker group definition | 

### Return type

[**InstanceControllerApiWorkerGroup**](InstanceControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

