# KestraIoKestraSdk.RolesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocompleteRoles**](RolesApi.md#autocompleteRoles) | **POST** /api/v1/{tenant}/roles/autocomplete | List roles for autocomplete
[**createRole**](RolesApi.md#createRole) | **POST** /api/v1/{tenant}/roles | Create a role
[**deleteRole**](RolesApi.md#deleteRole) | **DELETE** /api/v1/{tenant}/roles/{id} | Delete a role
[**getRole**](RolesApi.md#getRole) | **GET** /api/v1/{tenant}/roles/{id} | Retrieve a role
[**listRolesFromGivenIds**](RolesApi.md#listRolesFromGivenIds) | **POST** /api/v1/{tenant}/roles/ids | List roles by ids
[**searchRoles**](RolesApi.md#searchRoles) | **GET** /api/v1/{tenant}/roles/search | Search for roles
[**updateRole**](RolesApi.md#updateRole) | **PUT** /api/v1/{tenant}/roles/{id} | Update a role



## autocompleteRoles

> [ApiRoleSummary] autocompleteRoles(tenant, apiAutocomplete)

List roles for autocomplete

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

let apiInstance = new KestraIoKestraSdk.RolesApi();
let tenant = "tenant_example"; // String | 
let apiAutocomplete = new KestraIoKestraSdk.ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
apiInstance.autocompleteRoles(tenant, apiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[ApiRoleSummary]**](ApiRoleSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createRole

> IAMRoleControllerApiRoleDetail createRole(tenant, iAMRoleControllerApiRoleCreateOrUpdateRequest)

Create a role

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

let apiInstance = new KestraIoKestraSdk.RolesApi();
let tenant = "tenant_example"; // String | 
let iAMRoleControllerApiRoleCreateOrUpdateRequest = new KestraIoKestraSdk.IAMRoleControllerApiRoleCreateOrUpdateRequest(); // IAMRoleControllerApiRoleCreateOrUpdateRequest | 
apiInstance.createRole(tenant, iAMRoleControllerApiRoleCreateOrUpdateRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **iAMRoleControllerApiRoleCreateOrUpdateRequest** | [**IAMRoleControllerApiRoleCreateOrUpdateRequest**](IAMRoleControllerApiRoleCreateOrUpdateRequest.md)|  | 

### Return type

[**IAMRoleControllerApiRoleDetail**](IAMRoleControllerApiRoleDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteRole

> deleteRole(id, tenant)

Delete a role

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

let apiInstance = new KestraIoKestraSdk.RolesApi();
let id = "id_example"; // String | The role id
let tenant = "tenant_example"; // String | 
apiInstance.deleteRole(id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## getRole

> IAMRoleControllerApiRoleDetail getRole(id, tenant)

Retrieve a role

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

let apiInstance = new KestraIoKestraSdk.RolesApi();
let id = "id_example"; // String | The role id
let tenant = "tenant_example"; // String | 
apiInstance.getRole(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 
 **tenant** | **String**|  | 

### Return type

[**IAMRoleControllerApiRoleDetail**](IAMRoleControllerApiRoleDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listRolesFromGivenIds

> [Role] listRolesFromGivenIds(tenant, apiIds)

List roles by ids

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

let apiInstance = new KestraIoKestraSdk.RolesApi();
let tenant = "tenant_example"; // String | 
let apiIds = new KestraIoKestraSdk.ApiIds(); // ApiIds | The ids that must be present on results
apiInstance.listRolesFromGivenIds(tenant, apiIds).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **apiIds** | [**ApiIds**](ApiIds.md)| The ids that must be present on results | 

### Return type

[**[Role]**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## searchRoles

> PagedResultsApiRoleSummary searchRoles(page, size, tenant, opts)

Search for roles

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

let apiInstance = new KestraIoKestraSdk.RolesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchRoles(page, size, tenant, opts).then((data) => {
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

### Return type

[**PagedResultsApiRoleSummary**](PagedResultsApiRoleSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateRole

> IAMRoleControllerApiRoleDetail updateRole(id, tenant, iAMRoleControllerApiRoleCreateOrUpdateRequest)

Update a role

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

let apiInstance = new KestraIoKestraSdk.RolesApi();
let id = "id_example"; // String | The role id
let tenant = "tenant_example"; // String | 
let iAMRoleControllerApiRoleCreateOrUpdateRequest = new KestraIoKestraSdk.IAMRoleControllerApiRoleCreateOrUpdateRequest(); // IAMRoleControllerApiRoleCreateOrUpdateRequest | 
apiInstance.updateRole(id, tenant, iAMRoleControllerApiRoleCreateOrUpdateRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 
 **tenant** | **String**|  | 
 **iAMRoleControllerApiRoleCreateOrUpdateRequest** | [**IAMRoleControllerApiRoleCreateOrUpdateRequest**](IAMRoleControllerApiRoleCreateOrUpdateRequest.md)|  | 

### Return type

[**IAMRoleControllerApiRoleDetail**](IAMRoleControllerApiRoleDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

