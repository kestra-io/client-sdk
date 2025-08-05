# KestraIoKestraSdk.ServicesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getActiveServices**](ServicesApi.md#getActiveServices) | **GET** /api/v1/instance/services/active | List all active services
[**getService**](ServicesApi.md#getService) | **GET** /api/v1/instance/services/{id} | Retrieve details of a specific service
[**searchServices**](ServicesApi.md#searchServices) | **GET** /api/v1/instance/services/search | Search for a service (e.g. Worker, Executor, etc)



## getActiveServices

> InstanceControllerApiActiveServiceList getActiveServices()

List all active services

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.ServicesApi();
apiInstance.getActiveServices((error, data, response) => {
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

[**InstanceControllerApiActiveServiceList**](InstanceControllerApiActiveServiceList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getService

> ServiceInstance getService(id)

Retrieve details of a specific service

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.ServicesApi();
let id = "id_example"; // String | 
apiInstance.getService(id, (error, data, response) => {
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

[**ServiceInstance**](ServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchServices

> PagedResultsInstanceControllerApiServiceInstance searchServices(page, size, opts)

Search for a service (e.g. Worker, Executor, etc)

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.ServicesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'state': [new KestraIoKestraSdk.ServiceServiceState()], // [ServiceServiceState] | The state filter
  'type': [new KestraIoKestraSdk.ServiceType()] // [ServiceType] | The server type filter
};
apiInstance.searchServices(page, size, opts, (error, data, response) => {
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
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **state** | [**[ServiceServiceState]**](ServiceServiceState.md)| The state filter | [optional] 
 **type** | [**[ServiceType]**](ServiceType.md)| The server type filter | [optional] 

### Return type

[**PagedResultsInstanceControllerApiServiceInstance**](PagedResultsInstanceControllerApiServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

