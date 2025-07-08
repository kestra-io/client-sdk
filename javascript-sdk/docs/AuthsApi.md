# KestraApi.AuthsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createApiTokenForCurrentUser**](AuthsApi.md#createApiTokenForCurrentUser) | **POST** /api/v1/me/api-tokens | Create new API Token for authenticated user
[**createApiTokenForCurrentUserWithTenant**](AuthsApi.md#createApiTokenForCurrentUserWithTenant) | **POST** /api/v1/{tenant}/me/api-tokens | Create new API Token for authenticated user
[**deleteApiTokenForCurrentUser**](AuthsApi.md#deleteApiTokenForCurrentUser) | **DELETE** /api/v1/me/api-tokens/{tokenId} | Delete an API Token for authenticated user
[**deleteApiTokenForCurrentUserWithTenant**](AuthsApi.md#deleteApiTokenForCurrentUserWithTenant) | **DELETE** /api/v1/{tenant}/me/api-tokens/{tokenId} | Delete an API Token for authenticated user
[**getCurrentUser**](AuthsApi.md#getCurrentUser) | **GET** /api/v1/me | Get current user
[**getCurrentUserWithTenant**](AuthsApi.md#getCurrentUserWithTenant) | **GET** /api/v1/{tenant}/me | Get current user
[**index**](AuthsApi.md#index) | **GET** /api/v1/auths | Get list of authentication methods
[**listApiTokensForCurrentUser**](AuthsApi.md#listApiTokensForCurrentUser) | **GET** /api/v1/me/api-tokens | List all API Tokens for the authenticated user
[**listApiTokensForCurrentUserWithTenant**](AuthsApi.md#listApiTokensForCurrentUserWithTenant) | **GET** /api/v1/{tenant}/me/api-tokens | List all API Tokens for the authenticated user
[**patchCurrentUser**](AuthsApi.md#patchCurrentUser) | **PATCH** /api/v1/me | Updates details for the current user. Returns user&#39;s updated information upon success.
[**patchCurrentUserWithTenant**](AuthsApi.md#patchCurrentUserWithTenant) | **PATCH** /api/v1/{tenant}/me | Updates details for the current user. Returns user&#39;s updated information upon success.



## createApiTokenForCurrentUser

> Object createApiTokenForCurrentUser(createApiTokenRequest)

Create new API Token for authenticated user

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

let apiInstance = new KestraApi.AuthsApi();
let createApiTokenRequest = new KestraApi.CreateApiTokenRequest(); // CreateApiTokenRequest | 
apiInstance.createApiTokenForCurrentUser(createApiTokenRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createApiTokenForCurrentUserWithTenant

> Object createApiTokenForCurrentUserWithTenant(tenant, createApiTokenRequest)

Create new API Token for authenticated user

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

let apiInstance = new KestraApi.AuthsApi();
let tenant = "tenant_example"; // String | 
let createApiTokenRequest = new KestraApi.CreateApiTokenRequest(); // CreateApiTokenRequest | 
apiInstance.createApiTokenForCurrentUserWithTenant(tenant, createApiTokenRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteApiTokenForCurrentUser

> Object deleteApiTokenForCurrentUser(tokenId)

Delete an API Token for authenticated user

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

let apiInstance = new KestraApi.AuthsApi();
let tokenId = "tokenId_example"; // String | The token id
apiInstance.deleteApiTokenForCurrentUser(tokenId).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tokenId** | **String**| The token id | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteApiTokenForCurrentUserWithTenant

> Object deleteApiTokenForCurrentUserWithTenant(tokenId, tenant)

Delete an API Token for authenticated user

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

let apiInstance = new KestraApi.AuthsApi();
let tokenId = "tokenId_example"; // String | The token id
let tenant = "tenant_example"; // String | 
apiInstance.deleteApiTokenForCurrentUserWithTenant(tokenId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tokenId** | **String**| The token id | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getCurrentUser

> MeControllerMe getCurrentUser()

Get current user

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

let apiInstance = new KestraApi.AuthsApi();
apiInstance.getCurrentUser().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

[**MeControllerMe**](MeControllerMe.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getCurrentUserWithTenant

> MeControllerMe getCurrentUserWithTenant(tenant)

Get current user

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

let apiInstance = new KestraApi.AuthsApi();
let tenant = "tenant_example"; // String | 
apiInstance.getCurrentUserWithTenant(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 

### Return type

[**MeControllerMe**](MeControllerMe.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## index

> AuthControllerAuth index()

Get list of authentication methods

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.AuthsApi();
apiInstance.index().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

[**AuthControllerAuth**](AuthControllerAuth.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listApiTokensForCurrentUser

> Object listApiTokensForCurrentUser()

List all API Tokens for the authenticated user

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

let apiInstance = new KestraApi.AuthsApi();
apiInstance.listApiTokensForCurrentUser().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listApiTokensForCurrentUserWithTenant

> Object listApiTokensForCurrentUserWithTenant(tenant)

List all API Tokens for the authenticated user

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

let apiInstance = new KestraApi.AuthsApi();
let tenant = "tenant_example"; // String | 
apiInstance.listApiTokensForCurrentUserWithTenant(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## patchCurrentUser

> Object patchCurrentUser(meControllerUserDetailsRequest)

Updates details for the current user. Returns user&#39;s updated information upon success.

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

let apiInstance = new KestraApi.AuthsApi();
let meControllerUserDetailsRequest = new KestraApi.MeControllerUserDetailsRequest(); // MeControllerUserDetailsRequest | The user details
apiInstance.patchCurrentUser(meControllerUserDetailsRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **meControllerUserDetailsRequest** | [**MeControllerUserDetailsRequest**](MeControllerUserDetailsRequest.md)| The user details | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## patchCurrentUserWithTenant

> Object patchCurrentUserWithTenant(tenant, meControllerUserDetailsRequest)

Updates details for the current user. Returns user&#39;s updated information upon success.

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

let apiInstance = new KestraApi.AuthsApi();
let tenant = "tenant_example"; // String | 
let meControllerUserDetailsRequest = new KestraApi.MeControllerUserDetailsRequest(); // MeControllerUserDetailsRequest | The user details
apiInstance.patchCurrentUserWithTenant(tenant, meControllerUserDetailsRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **meControllerUserDetailsRequest** | [**MeControllerUserDetailsRequest**](MeControllerUserDetailsRequest.md)| The user details | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

