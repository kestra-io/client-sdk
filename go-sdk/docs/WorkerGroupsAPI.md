# \WorkerGroupsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateWorkerGroup**](WorkerGroupsAPI.md#CreateWorkerGroup) | **Post** /api/v1/cluster/workergroups | Create a new worker group.
[**DeleteWorkerGroupById**](WorkerGroupsAPI.md#DeleteWorkerGroupById) | **Delete** /api/v1/cluster/workergroups/{id} | Delete an existing worker group.
[**GetWorkerGroupById**](WorkerGroupsAPI.md#GetWorkerGroupById) | **Get** /api/v1/cluster/workergroups/{id} | Get details about a worker group.
[**ListWorkerGroups**](WorkerGroupsAPI.md#ListWorkerGroups) | **Get** /api/v1/cluster/workergroups | List all Worker Groups
[**UpdateWorkerGroupById**](WorkerGroupsAPI.md#UpdateWorkerGroupById) | **Put** /api/v1/cluster/workergroups/{id} | Update an existing worker group.



## CreateWorkerGroup

> ClusterControllerApiWorkerGroup CreateWorkerGroup(ctx).ClusterControllerApiCreateOrUpdateWorkerGroupRequest(clusterControllerApiCreateOrUpdateWorkerGroupRequest).Execute()

Create a new worker group.

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {
	clusterControllerApiCreateOrUpdateWorkerGroupRequest := *openapiclient.NewClusterControllerApiCreateOrUpdateWorkerGroupRequest("Key_example") // ClusterControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.WorkerGroupsAPI.CreateWorkerGroup(context.Background()).ClusterControllerApiCreateOrUpdateWorkerGroupRequest(clusterControllerApiCreateOrUpdateWorkerGroupRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `WorkerGroupsAPI.CreateWorkerGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateWorkerGroup`: ClusterControllerApiWorkerGroup
	fmt.Fprintf(os.Stdout, "Response from `WorkerGroupsAPI.CreateWorkerGroup`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateWorkerGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clusterControllerApiCreateOrUpdateWorkerGroupRequest** | [**ClusterControllerApiCreateOrUpdateWorkerGroupRequest**](ClusterControllerApiCreateOrUpdateWorkerGroupRequest.md) | The worker group definition | 

### Return type

[**ClusterControllerApiWorkerGroup**](ClusterControllerApiWorkerGroup.md)

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

Delete an existing worker group.

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
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

> ClusterControllerApiWorkerGroupDetails GetWorkerGroupById(ctx, id).Execute()

Get details about a worker group.

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
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
	// response from `GetWorkerGroupById`: ClusterControllerApiWorkerGroupDetails
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

[**ClusterControllerApiWorkerGroupDetails**](ClusterControllerApiWorkerGroupDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListWorkerGroups

> ClusterControllerApiWorkerGroupList ListWorkerGroups(ctx).Execute()

List all Worker Groups

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.WorkerGroupsAPI.ListWorkerGroups(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `WorkerGroupsAPI.ListWorkerGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListWorkerGroups`: ClusterControllerApiWorkerGroupList
	fmt.Fprintf(os.Stdout, "Response from `WorkerGroupsAPI.ListWorkerGroups`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiListWorkerGroupsRequest struct via the builder pattern


### Return type

[**ClusterControllerApiWorkerGroupList**](ClusterControllerApiWorkerGroupList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateWorkerGroupById

> ClusterControllerApiWorkerGroup UpdateWorkerGroupById(ctx, id).ClusterControllerApiCreateOrUpdateWorkerGroupRequest(clusterControllerApiCreateOrUpdateWorkerGroupRequest).Execute()

Update an existing worker group.

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {
	id := "id_example" // string | 
	clusterControllerApiCreateOrUpdateWorkerGroupRequest := *openapiclient.NewClusterControllerApiCreateOrUpdateWorkerGroupRequest("Key_example") // ClusterControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.WorkerGroupsAPI.UpdateWorkerGroupById(context.Background(), id).ClusterControllerApiCreateOrUpdateWorkerGroupRequest(clusterControllerApiCreateOrUpdateWorkerGroupRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `WorkerGroupsAPI.UpdateWorkerGroupById``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateWorkerGroupById`: ClusterControllerApiWorkerGroup
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

 **clusterControllerApiCreateOrUpdateWorkerGroupRequest** | [**ClusterControllerApiCreateOrUpdateWorkerGroupRequest**](ClusterControllerApiCreateOrUpdateWorkerGroupRequest.md) | The worker group definition | 

### Return type

[**ClusterControllerApiWorkerGroup**](ClusterControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

