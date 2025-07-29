# KestraApi.ServiceAccountApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createServiceAccount**](ServiceAccountApi.md#createServiceAccount) | **POST** /api/v1/{tenant}/service-accounts | Create a user service account
[**deleteServiceAccount**](ServiceAccountApi.md#deleteServiceAccount) | **DELETE** /api/v1/{tenant}/service-accounts/{id} | Delete a service account
[**getServiceAccount**](ServiceAccountApi.md#getServiceAccount) | **GET** /api/v1/{tenant}/service-accounts/{id} | Retrieve a service account
[**updateServiceAccount**](ServiceAccountApi.md#updateServiceAccount) | **PUT** /api/v1/{tenant}/service-accounts/{id} | Update a user service account



## createServiceAccount

> IAMServiceAccountControllerApiServiceAccountResponse createServiceAccount(tenant, iAMServiceAccountControllerApiServiceAccountRequest)

Create a user service account

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

let apiInstance = new KestraApi.ServiceAccountApi();
let tenant = "tenant_example"; // String | 
let iAMServiceAccountControllerApiServiceAccountRequest = new KestraApi.IAMServiceAccountControllerApiServiceAccountRequest(); // IAMServiceAccountControllerApiServiceAccountRequest | The service account
apiInstance.createServiceAccount(tenant, iAMServiceAccountControllerApiServiceAccountRequest, (error, data, response) => {
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
 **tenant** | **String**|  | 
 **iAMServiceAccountControllerApiServiceAccountRequest** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md)| The service account | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteServiceAccount

> deleteServiceAccount(id, tenant)

Delete a service account

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

let apiInstance = new KestraApi.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.deleteServiceAccount(id, tenant, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## getServiceAccount

> IAMServiceAccountControllerApiServiceAccountResponse getServiceAccount(id, tenant)

Retrieve a service account

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

let apiInstance = new KestraApi.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.getServiceAccount(id, tenant, (error, data, response) => {
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
 **id** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateServiceAccount

> IAMServiceAccountControllerApiServiceAccountResponse updateServiceAccount(id, tenant, iAMServiceAccountControllerApiServiceAccountRequest)

Update a user service account

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

let apiInstance = new KestraApi.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
let iAMServiceAccountControllerApiServiceAccountRequest = new KestraApi.IAMServiceAccountControllerApiServiceAccountRequest(); // IAMServiceAccountControllerApiServiceAccountRequest | The user
apiInstance.updateServiceAccount(id, tenant, iAMServiceAccountControllerApiServiceAccountRequest, (error, data, response) => {
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
 **id** | **String**| The user id | 
 **tenant** | **String**|  | 
 **iAMServiceAccountControllerApiServiceAccountRequest** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md)| The user | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

