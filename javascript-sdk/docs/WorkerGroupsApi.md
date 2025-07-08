# KestraApi.WorkerGroupsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createWorkerGroup**](WorkerGroupsApi.md#createWorkerGroup) | **POST** /api/v1/cluster/workergroups | Create a new worker group.
[**deleteWorkerGroupById**](WorkerGroupsApi.md#deleteWorkerGroupById) | **DELETE** /api/v1/cluster/workergroups/{id} | Delete an existing worker group.
[**getWorkerGroupById**](WorkerGroupsApi.md#getWorkerGroupById) | **GET** /api/v1/cluster/workergroups/{id} | Get details about a worker group.
[**listWorkerGroups**](WorkerGroupsApi.md#listWorkerGroups) | **GET** /api/v1/cluster/workergroups | List all Worker Groups
[**updateWorkerGroupById**](WorkerGroupsApi.md#updateWorkerGroupById) | **PUT** /api/v1/cluster/workergroups/{id} | Update an existing worker group.



## createWorkerGroup

> ClusterControllerApiWorkerGroup createWorkerGroup(clusterControllerApiCreateOrUpdateWorkerGroupRequest)

Create a new worker group.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.WorkerGroupsApi();
let clusterControllerApiCreateOrUpdateWorkerGroupRequest = new KestraApi.ClusterControllerApiCreateOrUpdateWorkerGroupRequest(); // ClusterControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition
apiInstance.createWorkerGroup(clusterControllerApiCreateOrUpdateWorkerGroupRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clusterControllerApiCreateOrUpdateWorkerGroupRequest** | [**ClusterControllerApiCreateOrUpdateWorkerGroupRequest**](ClusterControllerApiCreateOrUpdateWorkerGroupRequest.md)| The worker group definition | 

### Return type

[**ClusterControllerApiWorkerGroup**](ClusterControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteWorkerGroupById

> Object deleteWorkerGroupById(id)

Delete an existing worker group.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.WorkerGroupsApi();
let id = "id_example"; // String | 
apiInstance.deleteWorkerGroupById(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getWorkerGroupById

> ClusterControllerApiWorkerGroupDetails getWorkerGroupById(id)

Get details about a worker group.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.WorkerGroupsApi();
let id = "id_example"; // String | 
apiInstance.getWorkerGroupById(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 

### Return type

[**ClusterControllerApiWorkerGroupDetails**](ClusterControllerApiWorkerGroupDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listWorkerGroups

> ClusterControllerApiWorkerGroupList listWorkerGroups()

List all Worker Groups

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.WorkerGroupsApi();
apiInstance.listWorkerGroups().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ClusterControllerApiWorkerGroupList**](ClusterControllerApiWorkerGroupList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateWorkerGroupById

> ClusterControllerApiWorkerGroup updateWorkerGroupById(id, clusterControllerApiCreateOrUpdateWorkerGroupRequest)

Update an existing worker group.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.WorkerGroupsApi();
let id = "id_example"; // String | 
let clusterControllerApiCreateOrUpdateWorkerGroupRequest = new KestraApi.ClusterControllerApiCreateOrUpdateWorkerGroupRequest(); // ClusterControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition
apiInstance.updateWorkerGroupById(id, clusterControllerApiCreateOrUpdateWorkerGroupRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 
 **clusterControllerApiCreateOrUpdateWorkerGroupRequest** | [**ClusterControllerApiCreateOrUpdateWorkerGroupRequest**](ClusterControllerApiCreateOrUpdateWorkerGroupRequest.md)| The worker group definition | 

### Return type

[**ClusterControllerApiWorkerGroup**](ClusterControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

