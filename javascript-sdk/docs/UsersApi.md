# KestraApi.UsersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocompleteUsers**](UsersApi.md#autocompleteUsers) | **POST** /api/v1/{tenant}/users/autocomplete | List users for autocomplete
[**autocompleteUsersWithResourceTenantasSuperAdmin**](UsersApi.md#autocompleteUsersWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/users/autocomplete | List users for autocomplete
[**autocompleteUsersasSuperAdmin**](UsersApi.md#autocompleteUsersasSuperAdmin) | **POST** /api/v1/tenants/users/autocomplete | List users for autocomplete
[**createApiTokensForUser**](UsersApi.md#createApiTokensForUser) | **POST** /api/v1/{tenant}/users/{id}/api-tokens | Create new API Token for a specific user
[**createApiTokensForUserWithResourceTenantasSuperAdmin**](UsersApi.md#createApiTokensForUserWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/users/{id}/api-tokens | Create new API Token for a specific user
[**createApiTokensForUserasSuperAdmin**](UsersApi.md#createApiTokensForUserasSuperAdmin) | **POST** /api/v1/tenants/users/{id}/api-tokens | Create new API Token for a specific user
[**createServiceAccount**](UsersApi.md#createServiceAccount) | **POST** /api/v1/{tenant}/users/service-accounts | Create a user service account
[**createServiceAccountWithResourceTenantasSuperAdmin**](UsersApi.md#createServiceAccountWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/users/service-accounts | Create a user service account
[**createServiceAccountasSuperAdmin**](UsersApi.md#createServiceAccountasSuperAdmin) | **POST** /api/v1/tenants/users/service-accounts | Create a user service account
[**createUser**](UsersApi.md#createUser) | **POST** /api/v1/{tenant}/users | Create a standard user
[**createUserBasicAuth**](UsersApi.md#createUserBasicAuth) | **PUT** /api/v1/{tenant}/users/{id}/password | Create a basic auth password for a standard user
[**createUserBasicAuthWithResourceTenantasSuperAdmin**](UsersApi.md#createUserBasicAuthWithResourceTenantasSuperAdmin) | **PUT** /api/v1/tenants/{resourceTenant}/users/{id}/password | Create a basic auth password for a standard user
[**createUserBasicAuthasSuperAdmin**](UsersApi.md#createUserBasicAuthasSuperAdmin) | **PUT** /api/v1/tenants/users/{id}/password | Create a basic auth password for a standard user
[**createUserWithResourceTenantasSuperAdmin**](UsersApi.md#createUserWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/users | Create a standard user
[**createUserasSuperAdmin**](UsersApi.md#createUserasSuperAdmin) | **POST** /api/v1/tenants/users | Create a standard user
[**deleteApiToken**](UsersApi.md#deleteApiToken) | **DELETE** /api/v1/{tenant}/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**deleteApiTokenWithResourceTenantasSuperAdmin**](UsersApi.md#deleteApiTokenWithResourceTenantasSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**deleteApiTokenasSuperAdmin**](UsersApi.md#deleteApiTokenasSuperAdmin) | **DELETE** /api/v1/tenants/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**deleteAuth**](UsersApi.md#deleteAuth) | **DELETE** /api/v1/{tenant}/users/{id}/auths/{uid} | Delete an Auth for a user
[**deleteAuthWithResourceTenantasSuperAdmin**](UsersApi.md#deleteAuthWithResourceTenantasSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/users/{id}/auths/{uid} | Delete an Auth for a user
[**deleteAuthasSuperAdmin**](UsersApi.md#deleteAuthasSuperAdmin) | **DELETE** /api/v1/tenants/users/{id}/auths/{uid} | Delete an Auth for a user
[**deleteRefreshToken**](UsersApi.md#deleteRefreshToken) | **DELETE** /api/v1/{tenant}/users/{id}/refresh-token | Delete a user refresh token
[**deleteRefreshTokenWithResourceTenantasSuperAdmin**](UsersApi.md#deleteRefreshTokenWithResourceTenantasSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/users/{id}/refresh-token | Delete a user refresh token
[**deleteRefreshTokenasSuperAdmin**](UsersApi.md#deleteRefreshTokenasSuperAdmin) | **DELETE** /api/v1/tenants/users/{id}/refresh-token | Delete a user refresh token
[**deleteUser**](UsersApi.md#deleteUser) | **DELETE** /api/v1/{tenant}/users/{id} | Delete a user
[**deleteUserWithResourceTenantasSuperAdmin**](UsersApi.md#deleteUserWithResourceTenantasSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/users/{id} | Delete a user
[**deleteUserasSuperAdmin**](UsersApi.md#deleteUserasSuperAdmin) | **DELETE** /api/v1/tenants/users/{id} | Delete a user
[**findAllForAllTenants**](UsersApi.md#findAllForAllTenants) | **GET** /api/v1/tenants/users/instance | Get all users in the instance across all tenantd
[**findAllForAllTenantsWithResourceTenant**](UsersApi.md#findAllForAllTenantsWithResourceTenant) | **GET** /api/v1/tenants/{resourceTenant}/users/instance | Get all users in the instance across all tenantd
[**getUser**](UsersApi.md#getUser) | **GET** /api/v1/{tenant}/users/{id} | Get a user
[**getUserWithResourceTenantasSuperAdmin**](UsersApi.md#getUserWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/users/{id} | Get a user
[**getUserasSuperAdmin**](UsersApi.md#getUserasSuperAdmin) | **GET** /api/v1/tenants/users/{id} | Get a user
[**impersonate**](UsersApi.md#impersonate) | **POST** /api/v1/tenants/users/{id}/impersonate | Impersonate a user
[**impersonateWithResourceTenant**](UsersApi.md#impersonateWithResourceTenant) | **POST** /api/v1/tenants/{resourceTenant}/users/{id}/impersonate | Impersonate a user
[**listApiTokens**](UsersApi.md#listApiTokens) | **GET** /api/v1/{tenant}/users/{id}/api-tokens | List all API Tokens for specific user
[**listApiTokensWithResourceTenantasSuperAdmin**](UsersApi.md#listApiTokensWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/users/{id}/api-tokens | List all API Tokens for specific user
[**listApiTokensasSuperAdmin**](UsersApi.md#listApiTokensasSuperAdmin) | **GET** /api/v1/tenants/users/{id}/api-tokens | List all API Tokens for specific user
[**searchUsers**](UsersApi.md#searchUsers) | **GET** /api/v1/{tenant}/users/search | Search for users
[**searchUsersWithResourceTenantasSuperAdmin**](UsersApi.md#searchUsersWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/users/search | Search for users
[**searchUsersasSuperAdmin**](UsersApi.md#searchUsersasSuperAdmin) | **GET** /api/v1/tenants/users/search | Search for users
[**setSuperAdmin**](UsersApi.md#setSuperAdmin) | **PUT** /api/v1/tenants/users/{id}/set-superadmin | Update a user service account
[**setSuperAdminWithResourceTenant**](UsersApi.md#setSuperAdminWithResourceTenant) | **PUT** /api/v1/tenants/{resourceTenant}/users/{id}/set-superadmin | Update a user service account
[**updateCurrentUserPassword**](UsersApi.md#updateCurrentUserPassword) | **PUT** /api/v1/me/password | Update login password for the current user.
[**updateCurrentUserPasswordWithTenant**](UsersApi.md#updateCurrentUserPasswordWithTenant) | **PUT** /api/v1/{tenant}/me/password | Update login password for the current user.
[**updateServiceAccount**](UsersApi.md#updateServiceAccount) | **PUT** /api/v1/{tenant}/users/service-accounts/{id} | Update a user service account
[**updateServiceAccountWithResourceTenantasSuperAdmin**](UsersApi.md#updateServiceAccountWithResourceTenantasSuperAdmin) | **PUT** /api/v1/tenants/{resourceTenant}/users/service-accounts/{id} | Update a user service account
[**updateServiceAccountasSuperAdmin**](UsersApi.md#updateServiceAccountasSuperAdmin) | **PUT** /api/v1/tenants/users/service-accounts/{id} | Update a user service account
[**updateUser**](UsersApi.md#updateUser) | **PUT** /api/v1/{tenant}/users/{id} | Update a standard user
[**updateUserWithResourceTenantasSuperAdmin**](UsersApi.md#updateUserWithResourceTenantasSuperAdmin) | **PUT** /api/v1/tenants/{resourceTenant}/users/{id} | Update a standard user
[**updateUserasSuperAdmin**](UsersApi.md#updateUserasSuperAdmin) | **PUT** /api/v1/tenants/users/{id} | Update a standard user



## autocompleteUsers

> [ApiUser] autocompleteUsers(tenant, abstractUserControllerUserApiAutocomplete)

List users for autocomplete

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

let apiInstance = new KestraApi.UsersApi();
let tenant = "tenant_example"; // String | 
let abstractUserControllerUserApiAutocomplete = new KestraApi.AbstractUserControllerUserApiAutocomplete(); // AbstractUserControllerUserApiAutocomplete | Autocomplete request
apiInstance.autocompleteUsers(tenant, abstractUserControllerUserApiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **abstractUserControllerUserApiAutocomplete** | [**AbstractUserControllerUserApiAutocomplete**](AbstractUserControllerUserApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[ApiUser]**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## autocompleteUsersWithResourceTenantasSuperAdmin

> [ApiUser] autocompleteUsersWithResourceTenantasSuperAdmin(resourceTenant, abstractUserControllerUserApiAutocomplete)

List users for autocomplete

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

let apiInstance = new KestraApi.UsersApi();
let resourceTenant = "resourceTenant_example"; // String | 
let abstractUserControllerUserApiAutocomplete = new KestraApi.AbstractUserControllerUserApiAutocomplete(); // AbstractUserControllerUserApiAutocomplete | Autocomplete request
apiInstance.autocompleteUsersWithResourceTenantasSuperAdmin(resourceTenant, abstractUserControllerUserApiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **abstractUserControllerUserApiAutocomplete** | [**AbstractUserControllerUserApiAutocomplete**](AbstractUserControllerUserApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[ApiUser]**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## autocompleteUsersasSuperAdmin

> [ApiUser] autocompleteUsersasSuperAdmin(abstractUserControllerUserApiAutocomplete)

List users for autocomplete

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

let apiInstance = new KestraApi.UsersApi();
let abstractUserControllerUserApiAutocomplete = new KestraApi.AbstractUserControllerUserApiAutocomplete(); // AbstractUserControllerUserApiAutocomplete | Autocomplete request
apiInstance.autocompleteUsersasSuperAdmin(abstractUserControllerUserApiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **abstractUserControllerUserApiAutocomplete** | [**AbstractUserControllerUserApiAutocomplete**](AbstractUserControllerUserApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[ApiUser]**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createApiTokensForUser

> Object createApiTokensForUser(id, tenant, createApiTokenRequest)

Create new API Token for a specific user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
let createApiTokenRequest = new KestraApi.CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
apiInstance.createApiTokensForUser(id, tenant, createApiTokenRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## createApiTokensForUserWithResourceTenantasSuperAdmin

> Object createApiTokensForUserWithResourceTenantasSuperAdmin(id, resourceTenant, createApiTokenRequest)

Create new API Token for a specific user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
let createApiTokenRequest = new KestraApi.CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
apiInstance.createApiTokensForUserWithResourceTenantasSuperAdmin(id, resourceTenant, createApiTokenRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **resourceTenant** | **String**|  | 
 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createApiTokensForUserasSuperAdmin

> Object createApiTokensForUserasSuperAdmin(id, createApiTokenRequest)

Create new API Token for a specific user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let createApiTokenRequest = new KestraApi.CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
apiInstance.createApiTokensForUserasSuperAdmin(id, createApiTokenRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## createServiceAccount

> ApiServiceAccount createServiceAccount(tenant, apiServiceAccount)

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

let apiInstance = new KestraApi.UsersApi();
let tenant = "tenant_example"; // String | 
let apiServiceAccount = new KestraApi.ApiServiceAccount(); // ApiServiceAccount | The service account
apiInstance.createServiceAccount(tenant, apiServiceAccount).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md)| The service account | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createServiceAccountWithResourceTenantasSuperAdmin

> ApiServiceAccount createServiceAccountWithResourceTenantasSuperAdmin(resourceTenant, apiServiceAccount)

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

let apiInstance = new KestraApi.UsersApi();
let resourceTenant = "resourceTenant_example"; // String | 
let apiServiceAccount = new KestraApi.ApiServiceAccount(); // ApiServiceAccount | The service account
apiInstance.createServiceAccountWithResourceTenantasSuperAdmin(resourceTenant, apiServiceAccount).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md)| The service account | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createServiceAccountasSuperAdmin

> ApiServiceAccount createServiceAccountasSuperAdmin(apiServiceAccount)

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

let apiInstance = new KestraApi.UsersApi();
let apiServiceAccount = new KestraApi.ApiServiceAccount(); // ApiServiceAccount | The service account
apiInstance.createServiceAccountasSuperAdmin(apiServiceAccount).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md)| The service account | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createUser

> ApiUser createUser(tenant, apiUser)

Create a standard user

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

let apiInstance = new KestraApi.UsersApi();
let tenant = "tenant_example"; // String | 
let apiUser = new KestraApi.ApiUser(); // ApiUser | The user
apiInstance.createUser(tenant, apiUser).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **apiUser** | [**ApiUser**](ApiUser.md)| The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createUserBasicAuth

> ApiUser createUserBasicAuth(id, tenant, abstractUserControllerPasswordRequest)

Create a basic auth password for a standard user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
let abstractUserControllerPasswordRequest = new KestraApi.AbstractUserControllerPasswordRequest(); // AbstractUserControllerPasswordRequest | The password
apiInstance.createUserBasicAuth(id, tenant, abstractUserControllerPasswordRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **tenant** | **String**|  | 
 **abstractUserControllerPasswordRequest** | [**AbstractUserControllerPasswordRequest**](AbstractUserControllerPasswordRequest.md)| The password | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createUserBasicAuthWithResourceTenantasSuperAdmin

> ApiUser createUserBasicAuthWithResourceTenantasSuperAdmin(id, resourceTenant, abstractUserControllerPasswordRequest)

Create a basic auth password for a standard user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
let abstractUserControllerPasswordRequest = new KestraApi.AbstractUserControllerPasswordRequest(); // AbstractUserControllerPasswordRequest | The password
apiInstance.createUserBasicAuthWithResourceTenantasSuperAdmin(id, resourceTenant, abstractUserControllerPasswordRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **resourceTenant** | **String**|  | 
 **abstractUserControllerPasswordRequest** | [**AbstractUserControllerPasswordRequest**](AbstractUserControllerPasswordRequest.md)| The password | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createUserBasicAuthasSuperAdmin

> ApiUser createUserBasicAuthasSuperAdmin(id, abstractUserControllerPasswordRequest)

Create a basic auth password for a standard user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let abstractUserControllerPasswordRequest = new KestraApi.AbstractUserControllerPasswordRequest(); // AbstractUserControllerPasswordRequest | The password
apiInstance.createUserBasicAuthasSuperAdmin(id, abstractUserControllerPasswordRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **abstractUserControllerPasswordRequest** | [**AbstractUserControllerPasswordRequest**](AbstractUserControllerPasswordRequest.md)| The password | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createUserWithResourceTenantasSuperAdmin

> ApiUser createUserWithResourceTenantasSuperAdmin(resourceTenant, apiUser)

Create a standard user

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

let apiInstance = new KestraApi.UsersApi();
let resourceTenant = "resourceTenant_example"; // String | 
let apiUser = new KestraApi.ApiUser(); // ApiUser | The user
apiInstance.createUserWithResourceTenantasSuperAdmin(resourceTenant, apiUser).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **apiUser** | [**ApiUser**](ApiUser.md)| The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createUserasSuperAdmin

> ApiUser createUserasSuperAdmin(apiUser)

Create a standard user

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

let apiInstance = new KestraApi.UsersApi();
let apiUser = new KestraApi.ApiUser(); // ApiUser | The user
apiInstance.createUserasSuperAdmin(apiUser).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiUser** | [**ApiUser**](ApiUser.md)| The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteApiToken

> Object deleteApiToken(id, tokenId, tenant)

Delete an API Token for specific user and token id

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tokenId = "tokenId_example"; // String | The token id
let tenant = "tenant_example"; // String | 
apiInstance.deleteApiToken(id, tokenId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## deleteApiTokenWithResourceTenantasSuperAdmin

> Object deleteApiTokenWithResourceTenantasSuperAdmin(id, tokenId, resourceTenant)

Delete an API Token for specific user and token id

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tokenId = "tokenId_example"; // String | The token id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteApiTokenWithResourceTenantasSuperAdmin(id, tokenId, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **tokenId** | **String**| The token id | 
 **resourceTenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteApiTokenasSuperAdmin

> Object deleteApiTokenasSuperAdmin(id, tokenId)

Delete an API Token for specific user and token id

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tokenId = "tokenId_example"; // String | The token id
apiInstance.deleteApiTokenasSuperAdmin(id, tokenId).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## deleteAuth

> ApiUser deleteAuth(id, uid, tenant)

Delete an Auth for a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let uid = "uid_example"; // String | The auth id
let tenant = "tenant_example"; // String | 
apiInstance.deleteAuth(id, uid, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **uid** | **String**| The auth id | 
 **tenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteAuthWithResourceTenantasSuperAdmin

> ApiUser deleteAuthWithResourceTenantasSuperAdmin(id, uid, resourceTenant)

Delete an Auth for a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let uid = "uid_example"; // String | The auth id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteAuthWithResourceTenantasSuperAdmin(id, uid, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **uid** | **String**| The auth id | 
 **resourceTenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteAuthasSuperAdmin

> ApiUser deleteAuthasSuperAdmin(id, uid)

Delete an Auth for a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let uid = "uid_example"; // String | The auth id
apiInstance.deleteAuthasSuperAdmin(id, uid).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **uid** | **String**| The auth id | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteRefreshToken

> ApiUser deleteRefreshToken(id, tenant)

Delete a user refresh token

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.deleteRefreshToken(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteRefreshTokenWithResourceTenantasSuperAdmin

> ApiUser deleteRefreshTokenWithResourceTenantasSuperAdmin(id, resourceTenant)

Delete a user refresh token

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteRefreshTokenWithResourceTenantasSuperAdmin(id, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **resourceTenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteRefreshTokenasSuperAdmin

> ApiUser deleteRefreshTokenasSuperAdmin(id)

Delete a user refresh token

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.deleteRefreshTokenasSuperAdmin(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteUser

> deleteUser(id, tenant)

Delete a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.deleteUser(id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
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


## deleteUserWithResourceTenantasSuperAdmin

> deleteUserWithResourceTenantasSuperAdmin(id, resourceTenant)

Delete a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteUserWithResourceTenantasSuperAdmin(id, resourceTenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **resourceTenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteUserasSuperAdmin

> deleteUserasSuperAdmin(id)

Delete a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.deleteUserasSuperAdmin(id).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
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


## findAllForAllTenants

> PagedResultsApiUser findAllForAllTenants(page, size, opts)

Get all users in the instance across all tenantd

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

let apiInstance = new KestraApi.UsersApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'q': "q_example", // String | A string filter
  'type': new KestraApi.UserType() // UserType | The type of user
};
apiInstance.findAllForAllTenants(page, size, opts).then((data) => {
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
 **q** | **String**| A string filter | [optional] 
 **type** | [**UserType**](.md)| The type of user | [optional] 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## findAllForAllTenantsWithResourceTenant

> PagedResultsApiUser findAllForAllTenantsWithResourceTenant(page, size, resourceTenant, opts)

Get all users in the instance across all tenantd

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

let apiInstance = new KestraApi.UsersApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let resourceTenant = "resourceTenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'q': "q_example", // String | A string filter
  'type': new KestraApi.UserType() // UserType | The type of user
};
apiInstance.findAllForAllTenantsWithResourceTenant(page, size, resourceTenant, opts).then((data) => {
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
 **resourceTenant** | **String**|  | 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **q** | **String**| A string filter | [optional] 
 **type** | [**UserType**](.md)| The type of user | [optional] 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getUser

> ApiUser getUser(id, tenant)

Get a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.getUser(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getUserWithResourceTenantasSuperAdmin

> ApiUser getUserWithResourceTenantasSuperAdmin(id, resourceTenant)

Get a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.getUserWithResourceTenantasSuperAdmin(id, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **resourceTenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getUserasSuperAdmin

> ApiUser getUserasSuperAdmin(id)

Get a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.getUserasSuperAdmin(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## impersonate

> Object impersonate(id)

Impersonate a user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.impersonate(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## impersonateWithResourceTenant

> Object impersonateWithResourceTenant(resourceTenant, id)

Impersonate a user

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

let apiInstance = new KestraApi.UsersApi();
let resourceTenant = "resourceTenant_example"; // String | 
let id = "id_example"; // String | The user id
apiInstance.impersonateWithResourceTenant(resourceTenant, id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **id** | **String**| The user id | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listApiTokens

> Object listApiTokens(id, tenant)

List all API Tokens for specific user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.listApiTokens(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## listApiTokensWithResourceTenantasSuperAdmin

> Object listApiTokensWithResourceTenantasSuperAdmin(id, resourceTenant)

List all API Tokens for specific user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.listApiTokensWithResourceTenantasSuperAdmin(id, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **resourceTenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listApiTokensasSuperAdmin

> Object listApiTokensasSuperAdmin(id)

List all API Tokens for specific user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
apiInstance.listApiTokensasSuperAdmin(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## searchUsers

> PagedResultsApiUser searchUsers(page, size, tenant, opts)

Search for users

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

let apiInstance = new KestraApi.UsersApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"], // [String] | The sort of current page
  'type': new KestraApi.UserType() // UserType | The type of user
};
apiInstance.searchUsers(page, size, tenant, opts).then((data) => {
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
 **tenant** | **String**|  | 
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **type** | [**UserType**](.md)| The type of user | [optional] 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchUsersWithResourceTenantasSuperAdmin

> PagedResultsApiUser searchUsersWithResourceTenantasSuperAdmin(page, size, resourceTenant, opts)

Search for users

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

let apiInstance = new KestraApi.UsersApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let resourceTenant = "resourceTenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"], // [String] | The sort of current page
  'type': new KestraApi.UserType() // UserType | The type of user
};
apiInstance.searchUsersWithResourceTenantasSuperAdmin(page, size, resourceTenant, opts).then((data) => {
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
 **resourceTenant** | **String**|  | 
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **type** | [**UserType**](.md)| The type of user | [optional] 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchUsersasSuperAdmin

> PagedResultsApiUser searchUsersasSuperAdmin(page, size, opts)

Search for users

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

let apiInstance = new KestraApi.UsersApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"], // [String] | The sort of current page
  'type': new KestraApi.UserType() // UserType | The type of user
};
apiInstance.searchUsersasSuperAdmin(page, size, opts).then((data) => {
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
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **type** | [**UserType**](.md)| The type of user | [optional] 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## setSuperAdmin

> ApiUser setSuperAdmin(id, body)

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let body = true; // Boolean | 
apiInstance.setSuperAdmin(id, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **body** | **Boolean**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## setSuperAdminWithResourceTenant

> ApiUser setSuperAdminWithResourceTenant(resourceTenant, id, body)

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

let apiInstance = new KestraApi.UsersApi();
let resourceTenant = "resourceTenant_example"; // String | 
let id = "id_example"; // String | The user id
let body = true; // Boolean | 
apiInstance.setSuperAdminWithResourceTenant(resourceTenant, id, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **id** | **String**| The user id | 
 **body** | **Boolean**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateCurrentUserPassword

> Object updateCurrentUserPassword(meControllerUpdatePasswordRequest)

Update login password for the current user.

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

let apiInstance = new KestraApi.UsersApi();
let meControllerUpdatePasswordRequest = new KestraApi.MeControllerUpdatePasswordRequest(); // MeControllerUpdatePasswordRequest | 
apiInstance.updateCurrentUserPassword(meControllerUpdatePasswordRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **meControllerUpdatePasswordRequest** | [**MeControllerUpdatePasswordRequest**](MeControllerUpdatePasswordRequest.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateCurrentUserPasswordWithTenant

> Object updateCurrentUserPasswordWithTenant(tenant, meControllerUpdatePasswordRequest)

Update login password for the current user.

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

let apiInstance = new KestraApi.UsersApi();
let tenant = "tenant_example"; // String | 
let meControllerUpdatePasswordRequest = new KestraApi.MeControllerUpdatePasswordRequest(); // MeControllerUpdatePasswordRequest | 
apiInstance.updateCurrentUserPasswordWithTenant(tenant, meControllerUpdatePasswordRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **meControllerUpdatePasswordRequest** | [**MeControllerUpdatePasswordRequest**](MeControllerUpdatePasswordRequest.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateServiceAccount

> ApiServiceAccount updateServiceAccount(id, tenant, apiServiceAccount)

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
let apiServiceAccount = new KestraApi.ApiServiceAccount(); // ApiServiceAccount | The user
apiInstance.updateServiceAccount(id, tenant, apiServiceAccount).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **tenant** | **String**|  | 
 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md)| The user | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateServiceAccountWithResourceTenantasSuperAdmin

> ApiServiceAccount updateServiceAccountWithResourceTenantasSuperAdmin(id, resourceTenant, apiServiceAccount)

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
let apiServiceAccount = new KestraApi.ApiServiceAccount(); // ApiServiceAccount | The user
apiInstance.updateServiceAccountWithResourceTenantasSuperAdmin(id, resourceTenant, apiServiceAccount).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **resourceTenant** | **String**|  | 
 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md)| The user | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateServiceAccountasSuperAdmin

> ApiServiceAccount updateServiceAccountasSuperAdmin(id, apiServiceAccount)

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let apiServiceAccount = new KestraApi.ApiServiceAccount(); // ApiServiceAccount | The user
apiInstance.updateServiceAccountasSuperAdmin(id, apiServiceAccount).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md)| The user | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateUser

> ApiUser updateUser(id, tenant, apiUser)

Update a standard user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
let apiUser = new KestraApi.ApiUser(); // ApiUser | The user
apiInstance.updateUser(id, tenant, apiUser).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **tenant** | **String**|  | 
 **apiUser** | [**ApiUser**](ApiUser.md)| The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateUserWithResourceTenantasSuperAdmin

> ApiUser updateUserWithResourceTenantasSuperAdmin(id, resourceTenant, apiUser)

Update a standard user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
let apiUser = new KestraApi.ApiUser(); // ApiUser | The user
apiInstance.updateUserWithResourceTenantasSuperAdmin(id, resourceTenant, apiUser).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **resourceTenant** | **String**|  | 
 **apiUser** | [**ApiUser**](ApiUser.md)| The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateUserasSuperAdmin

> ApiUser updateUserasSuperAdmin(id, apiUser)

Update a standard user

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

let apiInstance = new KestraApi.UsersApi();
let id = "id_example"; // String | The user id
let apiUser = new KestraApi.ApiUser(); // ApiUser | The user
apiInstance.updateUserasSuperAdmin(id, apiUser).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user id | 
 **apiUser** | [**ApiUser**](ApiUser.md)| The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

