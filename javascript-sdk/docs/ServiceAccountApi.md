# KestraIoKestraSdk.ServiceAccountApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createApiTokensForServiceAccount**](ServiceAccountApi.md#createApiTokensForServiceAccount) | **POST** /api/v1/service-accounts/{id}/api-tokens | Create new API Token for a specific service account
[**createApiTokensForServiceAccountWithTenant**](ServiceAccountApi.md#createApiTokensForServiceAccountWithTenant) | **POST** /api/v1/{tenant}/service-accounts/{id}/api-tokens | Create new API Token for a specific service account
[**createServiceAccount**](ServiceAccountApi.md#createServiceAccount) | **POST** /api/v1/service-accounts | Create a service account
[**createServiceAccountForTenant**](ServiceAccountApi.md#createServiceAccountForTenant) | **POST** /api/v1/{tenant}/service-accounts | Create a service account for the given tenant
[**deleteApiTokenForServiceAccount**](ServiceAccountApi.md#deleteApiTokenForServiceAccount) | **DELETE** /api/v1/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific service account and token id
[**deleteApiTokenForServiceAccountWithTenant**](ServiceAccountApi.md#deleteApiTokenForServiceAccountWithTenant) | **DELETE** /api/v1/{tenant}/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific service account and token id
[**deleteServiceAccount**](ServiceAccountApi.md#deleteServiceAccount) | **DELETE** /api/v1/service-accounts/{id} | Delete a service account
[**deleteServiceAccountForTenant**](ServiceAccountApi.md#deleteServiceAccountForTenant) | **DELETE** /api/v1/{tenant}/service-accounts/{id} | Delete a service account
[**getServiceAccount**](ServiceAccountApi.md#getServiceAccount) | **GET** /api/v1/service-accounts/{id} | Get a service account
[**getServiceAccountForTenant**](ServiceAccountApi.md#getServiceAccountForTenant) | **GET** /api/v1/{tenant}/service-accounts/{id} | Retrieve a service account
[**listApiTokensForServiceAccount**](ServiceAccountApi.md#listApiTokensForServiceAccount) | **GET** /api/v1/service-accounts/{id}/api-tokens | List API tokens for a specific service account
[**listApiTokensForServiceAccountWithTenant**](ServiceAccountApi.md#listApiTokensForServiceAccountWithTenant) | **GET** /api/v1/{tenant}/service-accounts/{id}/api-tokens | List API tokens for a specific service account
[**listServiceAccounts**](ServiceAccountApi.md#listServiceAccounts) | **GET** /api/v1/service-accounts | List service accounts. Superadmin-only. 
[**patchServiceAccountDetails**](ServiceAccountApi.md#patchServiceAccountDetails) | **PATCH** /api/v1/service-accounts/{id} | Update service account details
[**patchServiceAccountSuperAdmin**](ServiceAccountApi.md#patchServiceAccountSuperAdmin) | **PATCH** /api/v1/service-accounts/{id}/superadmin | Update service account superadmin privileges
[**updateServiceAccount**](ServiceAccountApi.md#updateServiceAccount) | **PUT** /api/v1/{tenant}/service-accounts/{id} | Update a user service account



## createApiTokensForServiceAccount

> Object createApiTokensForServiceAccount(id, createApiTokenRequest)

Create new API Token for a specific service account

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
let createApiTokenRequest = new KestraIoKestraSdk.CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
apiInstance.createApiTokensForServiceAccount(id, createApiTokenRequest).then((data) => {
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


## createApiTokensForServiceAccountWithTenant

> Object createApiTokensForServiceAccountWithTenant(id, tenant, createApiTokenRequest)

Create new API Token for a specific service account

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
let createApiTokenRequest = new KestraIoKestraSdk.CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
apiInstance.createApiTokensForServiceAccountWithTenant(id, tenant, createApiTokenRequest).then((data) => {
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


## createServiceAccount

> IAMServiceAccountControllerApiServiceAccountDetail createServiceAccount(iAMServiceAccountControllerApiCreateServiceAccountRequest)

Create a service account

Superadmin-only. CReate service account with access to multiple tenants.

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let iAMServiceAccountControllerApiCreateServiceAccountRequest = new KestraIoKestraSdk.IAMServiceAccountControllerApiCreateServiceAccountRequest(); // IAMServiceAccountControllerApiCreateServiceAccountRequest | The service account
apiInstance.createServiceAccount(iAMServiceAccountControllerApiCreateServiceAccountRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **iAMServiceAccountControllerApiCreateServiceAccountRequest** | [**IAMServiceAccountControllerApiCreateServiceAccountRequest**](IAMServiceAccountControllerApiCreateServiceAccountRequest.md)| The service account | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createServiceAccountForTenant

> IAMServiceAccountControllerApiServiceAccountResponse createServiceAccountForTenant(tenant, iAMServiceAccountControllerApiServiceAccountRequest)

Create a service account for the given tenant

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let tenant = "tenant_example"; // String | 
let iAMServiceAccountControllerApiServiceAccountRequest = new KestraIoKestraSdk.IAMServiceAccountControllerApiServiceAccountRequest(); // IAMServiceAccountControllerApiServiceAccountRequest | The service account
apiInstance.createServiceAccountForTenant(tenant, iAMServiceAccountControllerApiServiceAccountRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## deleteApiTokenForServiceAccount

> Object deleteApiTokenForServiceAccount(id, tokenId)

Delete an API Token for specific service account and token id

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tokenId = "tokenId_example"; // String | The token id
apiInstance.deleteApiTokenForServiceAccount(id, tokenId).then((data) => {
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


## deleteApiTokenForServiceAccountWithTenant

> Object deleteApiTokenForServiceAccountWithTenant(id, tokenId, tenant)

Delete an API Token for specific service account and token id

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tokenId = "tokenId_example"; // String | The token id
let tenant = "tenant_example"; // String | 
apiInstance.deleteApiTokenForServiceAccountWithTenant(id, tokenId, tenant).then((data) => {
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


## deleteServiceAccount

> deleteServiceAccount(id)

Delete a service account

Superadmin-only. Delete a service account including all its access.

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The service account id
apiInstance.deleteServiceAccount(id).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The service account id | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteServiceAccountForTenant

> deleteServiceAccountForTenant(id, tenant)

Delete a service account

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The service account id
let tenant = "tenant_example"; // String | 
apiInstance.deleteServiceAccountForTenant(id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The service account id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## getServiceAccount

> IAMServiceAccountControllerApiServiceAccountDetail getServiceAccount(id)

Get a service account

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The service account id
apiInstance.getServiceAccount(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The service account id | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getServiceAccountForTenant

> IAMServiceAccountControllerApiServiceAccountResponse getServiceAccountForTenant(id, tenant)

Retrieve a service account

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.getServiceAccountForTenant(id, tenant).then((data) => {
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

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listApiTokensForServiceAccount

> Object listApiTokensForServiceAccount(id)

List API tokens for a specific service account

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
apiInstance.listApiTokensForServiceAccount(id).then((data) => {
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


## listApiTokensForServiceAccountWithTenant

> Object listApiTokensForServiceAccountWithTenant(id, tenant)

List API tokens for a specific service account

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.listApiTokensForServiceAccountWithTenant(id, tenant).then((data) => {
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


## listServiceAccounts

> PagedResultsIAMServiceAccountControllerApiServiceAccountDetail listServiceAccounts(page, size, opts)

List service accounts. Superadmin-only. 

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.listServiceAccounts(page, size, opts).then((data) => {
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

### Return type

[**PagedResultsIAMServiceAccountControllerApiServiceAccountDetail**](PagedResultsIAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## patchServiceAccountDetails

> IAMServiceAccountControllerApiServiceAccountDetail patchServiceAccountDetails(id, iAMServiceAccountControllerApiPatchServiceAccountRequest)

Update service account details

Superadmin-only. Updates the details of a service account.

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The service account id
let iAMServiceAccountControllerApiPatchServiceAccountRequest = new KestraIoKestraSdk.IAMServiceAccountControllerApiPatchServiceAccountRequest(); // IAMServiceAccountControllerApiPatchServiceAccountRequest | The service account details
apiInstance.patchServiceAccountDetails(id, iAMServiceAccountControllerApiPatchServiceAccountRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The service account id | 
 **iAMServiceAccountControllerApiPatchServiceAccountRequest** | [**IAMServiceAccountControllerApiPatchServiceAccountRequest**](IAMServiceAccountControllerApiPatchServiceAccountRequest.md)| The service account details | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## patchServiceAccountSuperAdmin

> patchServiceAccountSuperAdmin(id, apiPatchSuperAdminRequest)

Update service account superadmin privileges

Superadmin-only. Updates whether a service account is a superadmin.

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
let apiPatchSuperAdminRequest = new KestraIoKestraSdk.ApiPatchSuperAdminRequest(); // ApiPatchSuperAdminRequest | 
apiInstance.patchServiceAccountSuperAdmin(id, apiPatchSuperAdminRequest).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
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


## updateServiceAccount

> IAMServiceAccountControllerApiServiceAccountResponse updateServiceAccount(id, tenant, iAMServiceAccountControllerApiServiceAccountRequest)

Update a user service account

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

let apiInstance = new KestraIoKestraSdk.ServiceAccountApi();
let id = "id_example"; // String | The user id
let tenant = "tenant_example"; // String | 
let iAMServiceAccountControllerApiServiceAccountRequest = new KestraIoKestraSdk.IAMServiceAccountControllerApiServiceAccountRequest(); // IAMServiceAccountControllerApiServiceAccountRequest | The user
apiInstance.updateServiceAccount(id, tenant, iAMServiceAccountControllerApiServiceAccountRequest).then((data) => {
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
 **iAMServiceAccountControllerApiServiceAccountRequest** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md)| The user | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

