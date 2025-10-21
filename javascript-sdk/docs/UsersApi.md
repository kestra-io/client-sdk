# KestraIoKestraSdk.UsersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocompleteUsers**](UsersApi.md#autocompleteUsers) | **POST** /api/v1/{tenant}/tenant-access/autocomplete | List users for autocomplete
[**createApiTokensForUser**](UsersApi.md#createApiTokensForUser) | **POST** /api/v1/service-accounts/{id}/api-tokens | Create new API Token for a specific user
[**createApiTokensForUser1**](UsersApi.md#createApiTokensForUser1) | **POST** /api/v1/users/{id}/api-tokens | Create new API Token for a specific user
[**createApiTokensForUserWithTenant**](UsersApi.md#createApiTokensForUserWithTenant) | **POST** /api/v1/{tenant}/service-accounts/{id}/api-tokens | Create new API Token for a specific user
[**createUser**](UsersApi.md#createUser) | **POST** /api/v1/users | Create a new user account
[**deleteApiToken**](UsersApi.md#deleteApiToken) | **DELETE** /api/v1/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**deleteApiToken1**](UsersApi.md#deleteApiToken1) | **DELETE** /api/v1/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**deleteApiTokenWithTenant**](UsersApi.md#deleteApiTokenWithTenant) | **DELETE** /api/v1/{tenant}/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**deleteRefreshToken**](UsersApi.md#deleteRefreshToken) | **DELETE** /api/v1/users/{id}/refresh-token | Delete a user refresh token
[**deleteUser**](UsersApi.md#deleteUser) | **DELETE** /api/v1/users/{id} | Delete a user
[**deleteUserAuthMethod**](UsersApi.md#deleteUserAuthMethod) | **DELETE** /api/v1/users/{id}/auths/{auth} | Update user password
[**getUser**](UsersApi.md#getUser) | **GET** /api/v1/users/{id} | Get a user
[**impersonate**](UsersApi.md#impersonate) | **POST** /api/v1/users/{id}/impersonate | Impersonate a user
[**listApiTokens**](UsersApi.md#listApiTokens) | **GET** /api/v1/service-accounts/{id}/api-tokens | List API tokens for a specific user
[**listApiTokens1**](UsersApi.md#listApiTokens1) | **GET** /api/v1/users/{id}/api-tokens | List API tokens for a specific user
[**listApiTokensWithTenant**](UsersApi.md#listApiTokensWithTenant) | **GET** /api/v1/{tenant}/service-accounts/{id}/api-tokens | List API tokens for a specific user
[**listUsers**](UsersApi.md#listUsers) | **GET** /api/v1/users | Retrieve users
[**patchUser**](UsersApi.md#patchUser) | **PATCH** /api/v1/users/{id} | Update user details
[**patchUserDemo**](UsersApi.md#patchUserDemo) | **PATCH** /api/v1/users/{id}/restricted | Update user demo
[**patchUserPassword**](UsersApi.md#patchUserPassword) | **PATCH** /api/v1/users/{id}/password | Update user password
[**patchUserSuperAdmin**](UsersApi.md#patchUserSuperAdmin) | **PATCH** /api/v1/users/{id}/superadmin | Update user superadmin privileges
[**updateCurrentUserPassword**](UsersApi.md#updateCurrentUserPassword) | **PUT** /api/v1/me/password | Update authenticated user password
[**updateUser**](UsersApi.md#updateUser) | **PUT** /api/v1/users/{id} | Update a user account
[**updateUserGroups**](UsersApi.md#updateUserGroups) | **PUT** /api/v1/{tenant}/users/{id}/groups | Update the list of groups a user belongs to for the given tenant



## autocompleteUsers

> [IAMTenantAccessControllerApiUserTenantAccess] autocompleteUsers(tenant, iAMTenantAccessControllerUserApiAutocomplete)

List users for autocomplete

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let tenant = "tenant_example"; // String | 
let iAMTenantAccessControllerUserApiAutocomplete = new KestraIoKestraSdk.IAMTenantAccessControllerUserApiAutocomplete(); // IAMTenantAccessControllerUserApiAutocomplete | Autocomplete request
apiInstance.autocompleteUsers(tenant, iAMTenantAccessControllerUserApiAutocomplete, (error, data, response) => {
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
 **iAMTenantAccessControllerUserApiAutocomplete** | [**IAMTenantAccessControllerUserApiAutocomplete**](IAMTenantAccessControllerUserApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[IAMTenantAccessControllerApiUserTenantAccess]**](IAMTenantAccessControllerApiUserTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createApiTokensForUser

> Object createApiTokensForUser(id, createApiTokenRequest)

Create new API Token for a specific user

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let createApiTokenRequest = new KestraIoKestraSdk.CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
apiInstance.createApiTokensForUser(id, createApiTokenRequest, (error, data, response) => {
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
 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createApiTokensForUser1

> CreateApiTokenResponse createApiTokensForUser1(id, createApiTokenRequest)

Create new API Token for a specific user

Superadmin-only. Create a new API token for a user.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let createApiTokenRequest = new KestraIoKestraSdk.CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
apiInstance.createApiTokensForUser1(id, createApiTokenRequest, (error, data, response) => {
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
 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | 

### Return type

[**CreateApiTokenResponse**](CreateApiTokenResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createApiTokensForUserWithTenant

> Object createApiTokensForUserWithTenant(id, tenant, createApiTokenRequest)

Create new API Token for a specific user

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
let createApiTokenRequest = new KestraIoKestraSdk.CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
apiInstance.createApiTokensForUserWithTenant(id, tenant, createApiTokenRequest, (error, data, response) => {
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
 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createUser

> createUser(iAMUserControllerApiCreateOrUpdateUserRequest)

Create a new user account

Superadmin-only. Create a new user account with an optional password based authentication method.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let iAMUserControllerApiCreateOrUpdateUserRequest = new KestraIoKestraSdk.IAMUserControllerApiCreateOrUpdateUserRequest(); // IAMUserControllerApiCreateOrUpdateUserRequest | 
apiInstance.createUser(iAMUserControllerApiCreateOrUpdateUserRequest, (error, data, response) => {
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
 **iAMUserControllerApiCreateOrUpdateUserRequest** | [**IAMUserControllerApiCreateOrUpdateUserRequest**](IAMUserControllerApiCreateOrUpdateUserRequest.md)|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## deleteApiToken

> Object deleteApiToken(id, tokenId)

Delete an API Token for specific user and token id

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let tokenId = "tokenId_example"; // String | The token id
apiInstance.deleteApiToken(id, tokenId, (error, data, response) => {
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
 **tokenId** | **String**| The token id | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteApiToken1

> deleteApiToken1(id, tokenId)

Delete an API Token for specific user and token id

Superadmin-only. Delete an API token for a user.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let tokenId = "tokenId_example"; // String | The token id
apiInstance.deleteApiToken1(id, tokenId, (error, data, response) => {
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
 **tokenId** | **String**| The token id | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteApiTokenWithTenant

> Object deleteApiTokenWithTenant(id, tokenId, tenant)

Delete an API Token for specific user and token id

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let tokenId = "tokenId_example"; // String | The token id
let tenant = "tenant_example"; // String | 
apiInstance.deleteApiTokenWithTenant(id, tokenId, tenant, (error, data, response) => {
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
 **tokenId** | **String**| The token id | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteRefreshToken

> deleteRefreshToken(id)

Delete a user refresh token

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.deleteRefreshToken(id, (error, data, response) => {
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

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteUser

> deleteUser(id)

Delete a user

Superadmin-only. Delete a user including all its access.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.deleteUser(id, (error, data, response) => {
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

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteUserAuthMethod

> IAMUserControllerApiUser deleteUserAuthMethod(id, auth)

Update user password

Superadmin-only. Updates whether a user is a superadmin.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let auth = "auth_example"; // String | The user auth method id
apiInstance.deleteUserAuthMethod(id, auth, (error, data, response) => {
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
 **auth** | **String**| The user auth method id | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getUser

> IAMUserControllerApiUser getUser(id)

Get a user

Superadmin-only. Get user account details.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.getUser(id, (error, data, response) => {
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

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## impersonate

> Object impersonate(id)

Impersonate a user

Superadmin-only. Allows an admin to impersonate another user.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.impersonate(id, (error, data, response) => {
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

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listApiTokens

> Object listApiTokens(id)

List API tokens for a specific user

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.listApiTokens(id, (error, data, response) => {
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

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listApiTokens1

> Object listApiTokens1(id)

List API tokens for a specific user

Superadmin-only. Get all API token existing for a user.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.listApiTokens1(id, (error, data, response) => {
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

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listApiTokensWithTenant

> Object listApiTokensWithTenant(id, tenant)

List API tokens for a specific user

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.listApiTokensWithTenant(id, tenant, (error, data, response) => {
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listUsers

> PagedResultsIAMUserControllerApiUserSummary listUsers(page, size, opts)

Retrieve users

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.listUsers(page, size, opts, (error, data, response) => {
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
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsIAMUserControllerApiUserSummary**](PagedResultsIAMUserControllerApiUserSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## patchUser

> IAMUserControllerApiUser patchUser(id, meControllerApiUserDetailsRequest)

Update user details

Superadmin-only. Updates the the details of a user.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let meControllerApiUserDetailsRequest = new KestraIoKestraSdk.MeControllerApiUserDetailsRequest(); // MeControllerApiUserDetailsRequest | The user details
apiInstance.patchUser(id, meControllerApiUserDetailsRequest, (error, data, response) => {
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
 **meControllerApiUserDetailsRequest** | [**MeControllerApiUserDetailsRequest**](MeControllerApiUserDetailsRequest.md)| The user details | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## patchUserDemo

> patchUserDemo(id, iAMUserControllerApiPatchRestrictedRequest)

Update user demo

Superadmin-only. Updates whether a user is for demo.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let iAMUserControllerApiPatchRestrictedRequest = new KestraIoKestraSdk.IAMUserControllerApiPatchRestrictedRequest(); // IAMUserControllerApiPatchRestrictedRequest | 
apiInstance.patchUserDemo(id, iAMUserControllerApiPatchRestrictedRequest, (error, data, response) => {
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
 **iAMUserControllerApiPatchRestrictedRequest** | [**IAMUserControllerApiPatchRestrictedRequest**](IAMUserControllerApiPatchRestrictedRequest.md)|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## patchUserPassword

> Object patchUserPassword(id, iAMUserControllerApiPatchUserPasswordRequest)

Update user password

Superadmin-only. Updates whether a user is a superadmin.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let iAMUserControllerApiPatchUserPasswordRequest = new KestraIoKestraSdk.IAMUserControllerApiPatchUserPasswordRequest(); // IAMUserControllerApiPatchUserPasswordRequest | 
apiInstance.patchUserPassword(id, iAMUserControllerApiPatchUserPasswordRequest, (error, data, response) => {
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
 **iAMUserControllerApiPatchUserPasswordRequest** | [**IAMUserControllerApiPatchUserPasswordRequest**](IAMUserControllerApiPatchUserPasswordRequest.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## patchUserSuperAdmin

> patchUserSuperAdmin(id, apiPatchSuperAdminRequest)

Update user superadmin privileges

Superadmin-only. Updates whether a user is a superadmin.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let apiPatchSuperAdminRequest = new KestraIoKestraSdk.ApiPatchSuperAdminRequest(); // ApiPatchSuperAdminRequest | 
apiInstance.patchUserSuperAdmin(id, apiPatchSuperAdminRequest, (error, data, response) => {
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
 **apiPatchSuperAdminRequest** | [**ApiPatchSuperAdminRequest**](ApiPatchSuperAdminRequest.md)|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## updateCurrentUserPassword

> Object updateCurrentUserPassword(meControllerApiUpdatePasswordRequest)

Update authenticated user password

Changes the login password for the authenticated user.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let meControllerApiUpdatePasswordRequest = new KestraIoKestraSdk.MeControllerApiUpdatePasswordRequest(); // MeControllerApiUpdatePasswordRequest | 
apiInstance.updateCurrentUserPassword(meControllerApiUpdatePasswordRequest, (error, data, response) => {
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
 **meControllerApiUpdatePasswordRequest** | [**MeControllerApiUpdatePasswordRequest**](MeControllerApiUpdatePasswordRequest.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateUser

> IAMUserControllerApiUser updateUser(id, iAMUserControllerApiCreateOrUpdateUserRequest)

Update a user account

Superadmin-only. Update an existing user account with an optional password based authentication method.

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user id
let iAMUserControllerApiCreateOrUpdateUserRequest = new KestraIoKestraSdk.IAMUserControllerApiCreateOrUpdateUserRequest(); // IAMUserControllerApiCreateOrUpdateUserRequest | 
apiInstance.updateUser(id, iAMUserControllerApiCreateOrUpdateUserRequest, (error, data, response) => {
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
 **iAMUserControllerApiCreateOrUpdateUserRequest** | [**IAMUserControllerApiCreateOrUpdateUserRequest**](IAMUserControllerApiCreateOrUpdateUserRequest.md)|  | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateUserGroups

> updateUserGroups(id, tenant, iAMUserGroupControllerApiUpdateUserGroupsRequest)

Update the list of groups a user belongs to for the given tenant

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

let apiInstance = new KestraIoKestraSdk.UsersApi();
let id = "id_example"; // String | The user ID
let tenant = "tenant_example"; // String | 
let iAMUserGroupControllerApiUpdateUserGroupsRequest = new KestraIoKestraSdk.IAMUserGroupControllerApiUpdateUserGroupsRequest(); // IAMUserGroupControllerApiUpdateUserGroupsRequest | 
apiInstance.updateUserGroups(id, tenant, iAMUserGroupControllerApiUpdateUserGroupsRequest, (error, data, response) => {
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
 **id** | **String**| The user ID | 
 **tenant** | **String**|  | 
 **iAMUserGroupControllerApiUpdateUserGroupsRequest** | [**IAMUserGroupControllerApiUpdateUserGroupsRequest**](IAMUserGroupControllerApiUpdateUserGroupsRequest.md)|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined

