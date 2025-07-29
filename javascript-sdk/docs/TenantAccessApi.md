# KestraApi.TenantAccessApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTenantAccess**](TenantAccessApi.md#createTenantAccess) | **POST** /api/v1/{tenant}/tenant-access | Create tenant access for a user
[**createTenantAccess1**](TenantAccessApi.md#createTenantAccess1) | **PUT** /api/v1/{tenant}/tenant-access/{userId} | Create tenant access for a user
[**deleteTenantAccess**](TenantAccessApi.md#deleteTenantAccess) | **DELETE** /api/v1/{tenant}/tenant-access/{userId} | Delete tenant access for a user
[**getTenantAccess**](TenantAccessApi.md#getTenantAccess) | **GET** /api/v1/{tenant}/tenant-access/{userId} | Retrieve tenant access for a user
[**listTenantAccess**](TenantAccessApi.md#listTenantAccess) | **GET** /api/v1/{tenant}/tenant-access | Retrieve users belonging to the tenant



## createTenantAccess

> createTenantAccess(tenant, iAMTenantAccessControllerApiCreateTenantAccessRequest)

Create tenant access for a user

Grants tenant access permissions to a user identified by email

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

let apiInstance = new KestraApi.TenantAccessApi();
let tenant = "tenant_example"; // String | 
let iAMTenantAccessControllerApiCreateTenantAccessRequest = new KestraApi.IAMTenantAccessControllerApiCreateTenantAccessRequest(); // IAMTenantAccessControllerApiCreateTenantAccessRequest | 
apiInstance.createTenantAccess(tenant, iAMTenantAccessControllerApiCreateTenantAccessRequest, (error, data, response) => {
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
 **tenant** | **String**|  | 
 **iAMTenantAccessControllerApiCreateTenantAccessRequest** | [**IAMTenantAccessControllerApiCreateTenantAccessRequest**](IAMTenantAccessControllerApiCreateTenantAccessRequest.md)|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## createTenantAccess1

> createTenantAccess1(userId, tenant)

Create tenant access for a user

Grants tenant access permissions to a user identified by userId

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

let apiInstance = new KestraApi.TenantAccessApi();
let userId = "userId_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.createTenantAccess1(userId, tenant, (error, data, response) => {
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
 **userId** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteTenantAccess

> deleteTenantAccess(userId, tenant)

Delete tenant access for a user

Removes tenant access permissions for the specified user

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

let apiInstance = new KestraApi.TenantAccessApi();
let userId = "userId_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.deleteTenantAccess(userId, tenant, (error, data, response) => {
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
 **userId** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## getTenantAccess

> IAMTenantAccessControllerApiTenantAccess getTenantAccess(userId, tenant)

Retrieve tenant access for a user

Fetches the tenant access configuration for a given user

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

let apiInstance = new KestraApi.TenantAccessApi();
let userId = "userId_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.getTenantAccess(userId, tenant, (error, data, response) => {
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
 **userId** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

[**IAMTenantAccessControllerApiTenantAccess**](IAMTenantAccessControllerApiTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listTenantAccess

> PagedResultsIAMTenantAccessControllerApiUserTenantAccess listTenantAccess(page, size, tenant, opts)

Retrieve users belonging to the tenant

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

let apiInstance = new KestraApi.TenantAccessApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"], // [String] | The sort of current page
  'type': new KestraApi.UserType() // UserType | The type of user
};
apiInstance.listTenantAccess(page, size, tenant, opts, (error, data, response) => {
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
 **tenant** | **String**|  | 
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **type** | [**UserType**](.md)| The type of user | [optional] 

### Return type

[**PagedResultsIAMTenantAccessControllerApiUserTenantAccess**](PagedResultsIAMTenantAccessControllerApiUserTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

