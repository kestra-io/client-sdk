# KestraApi.ServicesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getActiveServices**](ServicesApi.md#getActiveServices) | **GET** /api/v1/cluster/services/active | Get details about active services
[**getService**](ServicesApi.md#getService) | **GET** /api/v1/cluster/services/{id} | Get details about a service
[**searchServices**](ServicesApi.md#searchServices) | **GET** /api/v1/cluster/services/search | Search for service



## getActiveServices

> ClusterControllerApiActiveServiceList getActiveServices()

Get details about active services

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

let apiInstance = new KestraApi.ServicesApi();
apiInstance.getActiveServices().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ClusterControllerApiActiveServiceList**](ClusterControllerApiActiveServiceList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getService

> ServiceInstance getService(id)

Get details about a service

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

let apiInstance = new KestraApi.ServicesApi();
let id = "id_example"; // String | 
apiInstance.getService(id).then((data) => {
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

[**ServiceInstance**](ServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchServices

> PagedResultsClusterControllerApiServiceInstance searchServices(page, size, opts)

Search for service

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

let apiInstance = new KestraApi.ServicesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'state': [new KestraApi.ServiceServiceState()], // [ServiceServiceState] | The state filter
  'type': [new KestraApi.ServiceType()] // [ServiceType] | The server type filter
};
apiInstance.searchServices(page, size, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **state** | [**[ServiceServiceState]**](ServiceServiceState.md)| The state filter | [optional] 
 **type** | [**[ServiceType]**](ServiceType.md)| The server type filter | [optional] 

### Return type

[**PagedResultsClusterControllerApiServiceInstance**](PagedResultsClusterControllerApiServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

