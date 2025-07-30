# KestraIoKestraApi.WorkerGroupsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createWorkerGroup**](WorkerGroupsApi.md#createWorkerGroup) | **POST** /api/v1/instance/workergroups | Create a worker group
[**deleteWorkerGroupById**](WorkerGroupsApi.md#deleteWorkerGroupById) | **DELETE** /api/v1/instance/workergroups/{id} | Delete a worker group
[**getWorkerGroupById**](WorkerGroupsApi.md#getWorkerGroupById) | **GET** /api/v1/instance/workergroups/{id} | Retrieve details of a specific worker group
[**listWorkerGroups**](WorkerGroupsApi.md#listWorkerGroups) | **GET** /api/v1/instance/workergroups | List all worker groups
[**updateWorkerGroupById**](WorkerGroupsApi.md#updateWorkerGroupById) | **PUT** /api/v1/instance/workergroups/{id} | Update a worker group



## createWorkerGroup

> InstanceControllerApiWorkerGroup createWorkerGroup(instanceControllerApiCreateOrUpdateWorkerGroupRequest)

Create a worker group

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.WorkerGroupsApi();
let instanceControllerApiCreateOrUpdateWorkerGroupRequest = new KestraIoKestraApi.InstanceControllerApiCreateOrUpdateWorkerGroupRequest(); // InstanceControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition
apiInstance.createWorkerGroup(instanceControllerApiCreateOrUpdateWorkerGroupRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instanceControllerApiCreateOrUpdateWorkerGroupRequest** | [**InstanceControllerApiCreateOrUpdateWorkerGroupRequest**](InstanceControllerApiCreateOrUpdateWorkerGroupRequest.md)| The worker group definition | 

### Return type

[**InstanceControllerApiWorkerGroup**](InstanceControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteWorkerGroupById

> Object deleteWorkerGroupById(id)

Delete a worker group

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.WorkerGroupsApi();
let id = "id_example"; // String | 
apiInstance.deleteWorkerGroupById(id, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
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

> InstanceControllerApiWorkerGroupDetails getWorkerGroupById(id)

Retrieve details of a specific worker group

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.WorkerGroupsApi();
let id = "id_example"; // String | 
apiInstance.getWorkerGroupById(id, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 

### Return type

[**InstanceControllerApiWorkerGroupDetails**](InstanceControllerApiWorkerGroupDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listWorkerGroups

> InstanceControllerApiWorkerGroupList listWorkerGroups()

List all worker groups

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.WorkerGroupsApi();
apiInstance.listWorkerGroups((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**InstanceControllerApiWorkerGroupList**](InstanceControllerApiWorkerGroupList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateWorkerGroupById

> InstanceControllerApiWorkerGroup updateWorkerGroupById(id, instanceControllerApiCreateOrUpdateWorkerGroupRequest)

Update a worker group

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.WorkerGroupsApi();
let id = "id_example"; // String | 
let instanceControllerApiCreateOrUpdateWorkerGroupRequest = new KestraIoKestraApi.InstanceControllerApiCreateOrUpdateWorkerGroupRequest(); // InstanceControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition
apiInstance.updateWorkerGroupById(id, instanceControllerApiCreateOrUpdateWorkerGroupRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 
 **instanceControllerApiCreateOrUpdateWorkerGroupRequest** | [**InstanceControllerApiCreateOrUpdateWorkerGroupRequest**](InstanceControllerApiCreateOrUpdateWorkerGroupRequest.md)| The worker group definition | 

### Return type

[**InstanceControllerApiWorkerGroup**](InstanceControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

