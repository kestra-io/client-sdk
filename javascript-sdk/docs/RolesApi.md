# KestraApi.RolesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocompleteRoles**](RolesApi.md#autocompleteRoles) | **POST** /api/v1/{tenant}/roles/autocomplete | List roles for autocomplete
[**autocompleteRolesWithResourceTenantasSuperAdmin**](RolesApi.md#autocompleteRolesWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/roles/autocomplete | List roles for autocomplete
[**autocompleteRolesasSuperAdmin**](RolesApi.md#autocompleteRolesasSuperAdmin) | **POST** /api/v1/tenants/roles/autocomplete | List roles for autocomplete
[**createRole**](RolesApi.md#createRole) | **POST** /api/v1/{tenant}/roles | Create a role
[**createRoleWithResourceTenantasSuperAdmin**](RolesApi.md#createRoleWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/roles | Create a role
[**createRoleasSuperAdmin**](RolesApi.md#createRoleasSuperAdmin) | **POST** /api/v1/tenants/roles | Create a role
[**deleteRole**](RolesApi.md#deleteRole) | **DELETE** /api/v1/{tenant}/roles/{id} | Delete a role
[**deleteRoleWithResourceTenantasSuperAdmin**](RolesApi.md#deleteRoleWithResourceTenantasSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/roles/{id} | Delete a role
[**deleteRoleasSuperAdmin**](RolesApi.md#deleteRoleasSuperAdmin) | **DELETE** /api/v1/tenants/roles/{id} | Delete a role
[**getRole**](RolesApi.md#getRole) | **GET** /api/v1/{tenant}/roles/{id} | Get a role
[**getRoleWithResourceTenantasSuperAdmin**](RolesApi.md#getRoleWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/roles/{id} | Get a role
[**getRoleasSuperAdmin**](RolesApi.md#getRoleasSuperAdmin) | **GET** /api/v1/tenants/roles/{id} | Get a role
[**listRolesFromGivenIds**](RolesApi.md#listRolesFromGivenIds) | **POST** /api/v1/{tenant}/roles/ids | 
[**listRolesFromGivenIdsWithResourceTenantasSuperAdmin**](RolesApi.md#listRolesFromGivenIdsWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/roles/ids | 
[**listRolesFromGivenIdsasSuperAdmin**](RolesApi.md#listRolesFromGivenIdsasSuperAdmin) | **POST** /api/v1/tenants/roles/ids | 
[**searchRoles**](RolesApi.md#searchRoles) | **GET** /api/v1/{tenant}/roles/search | Search for roles
[**searchRolesWithResourceTenantasSuperAdmin**](RolesApi.md#searchRolesWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/roles/search | Search for roles
[**searchRolesasSuperAdmin**](RolesApi.md#searchRolesasSuperAdmin) | **GET** /api/v1/tenants/roles/search | Search for roles
[**updateRole**](RolesApi.md#updateRole) | **PUT** /api/v1/{tenant}/roles/{id} | Update a role
[**updateRoleWithResourceTenantasSuperAdmin**](RolesApi.md#updateRoleWithResourceTenantasSuperAdmin) | **PUT** /api/v1/tenants/{resourceTenant}/roles/{id} | Update a role
[**updateRoleasSuperAdmin**](RolesApi.md#updateRoleasSuperAdmin) | **PUT** /api/v1/tenants/roles/{id} | Update a role



## autocompleteRoles

> [Role] autocompleteRoles(tenant, apiAutocomplete)

List roles for autocomplete

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

let apiInstance = new KestraApi.RolesApi();
let tenant = "tenant_example"; // String | 
let apiAutocomplete = new KestraApi.ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
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

[**[Role]**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## autocompleteRolesWithResourceTenantasSuperAdmin

> [Role] autocompleteRolesWithResourceTenantasSuperAdmin(resourceTenant, apiAutocomplete)

List roles for autocomplete

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

let apiInstance = new KestraApi.RolesApi();
let resourceTenant = "resourceTenant_example"; // String | 
let apiAutocomplete = new KestraApi.ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
apiInstance.autocompleteRolesWithResourceTenantasSuperAdmin(resourceTenant, apiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[Role]**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## autocompleteRolesasSuperAdmin

> [Role] autocompleteRolesasSuperAdmin(apiAutocomplete)

List roles for autocomplete

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

let apiInstance = new KestraApi.RolesApi();
let apiAutocomplete = new KestraApi.ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
apiInstance.autocompleteRolesasSuperAdmin(apiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[Role]**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createRole

> Role createRole(tenant, role)

Create a role

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

let apiInstance = new KestraApi.RolesApi();
let tenant = "tenant_example"; // String | 
let role = new KestraApi.Role(); // Role | 
apiInstance.createRole(tenant, role).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **role** | [**Role**](Role.md)|  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createRoleWithResourceTenantasSuperAdmin

> Role createRoleWithResourceTenantasSuperAdmin(resourceTenant, role)

Create a role

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

let apiInstance = new KestraApi.RolesApi();
let resourceTenant = "resourceTenant_example"; // String | 
let role = new KestraApi.Role(); // Role | 
apiInstance.createRoleWithResourceTenantasSuperAdmin(resourceTenant, role).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **role** | [**Role**](Role.md)|  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createRoleasSuperAdmin

> Role createRoleasSuperAdmin(role)

Create a role

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

let apiInstance = new KestraApi.RolesApi();
let role = new KestraApi.Role(); // Role | 
apiInstance.createRoleasSuperAdmin(role).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **role** | [**Role**](Role.md)|  | 

### Return type

[**Role**](Role.md)

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
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.RolesApi();
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


## deleteRoleWithResourceTenantasSuperAdmin

> deleteRoleWithResourceTenantasSuperAdmin(id, resourceTenant)

Delete a role

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

let apiInstance = new KestraApi.RolesApi();
let id = "id_example"; // String | The role id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteRoleWithResourceTenantasSuperAdmin(id, resourceTenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 
 **resourceTenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteRoleasSuperAdmin

> deleteRoleasSuperAdmin(id)

Delete a role

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

let apiInstance = new KestraApi.RolesApi();
let id = "id_example"; // String | The role id
apiInstance.deleteRoleasSuperAdmin(id).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## getRole

> Role getRole(id, tenant)

Get a role

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

let apiInstance = new KestraApi.RolesApi();
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

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getRoleWithResourceTenantasSuperAdmin

> Role getRoleWithResourceTenantasSuperAdmin(id, resourceTenant)

Get a role

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

let apiInstance = new KestraApi.RolesApi();
let id = "id_example"; // String | The role id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.getRoleWithResourceTenantasSuperAdmin(id, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 
 **resourceTenant** | **String**|  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getRoleasSuperAdmin

> Role getRoleasSuperAdmin(id)

Get a role

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

let apiInstance = new KestraApi.RolesApi();
let id = "id_example"; // String | The role id
apiInstance.getRoleasSuperAdmin(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 

### Return type

[**Role**](Role.md)

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
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.RolesApi();
let tenant = "tenant_example"; // String | 
let apiIds = new KestraApi.ApiIds(); // ApiIds | The ids that must be present on results
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


## listRolesFromGivenIdsWithResourceTenantasSuperAdmin

> [Role] listRolesFromGivenIdsWithResourceTenantasSuperAdmin(resourceTenant, apiIds)



List roles by ids

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

let apiInstance = new KestraApi.RolesApi();
let resourceTenant = "resourceTenant_example"; // String | 
let apiIds = new KestraApi.ApiIds(); // ApiIds | The ids that must be present on results
apiInstance.listRolesFromGivenIdsWithResourceTenantasSuperAdmin(resourceTenant, apiIds).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **apiIds** | [**ApiIds**](ApiIds.md)| The ids that must be present on results | 

### Return type

[**[Role]**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## listRolesFromGivenIdsasSuperAdmin

> [Role] listRolesFromGivenIdsasSuperAdmin(apiIds)



List roles by ids

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

let apiInstance = new KestraApi.RolesApi();
let apiIds = new KestraApi.ApiIds(); // ApiIds | The ids that must be present on results
apiInstance.listRolesFromGivenIdsasSuperAdmin(apiIds).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiIds** | [**ApiIds**](ApiIds.md)| The ids that must be present on results | 

### Return type

[**[Role]**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## searchRoles

> PagedResultsRole searchRoles(page, size, tenant, opts)

Search for roles

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

let apiInstance = new KestraApi.RolesApi();
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

[**PagedResultsRole**](PagedResultsRole.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchRolesWithResourceTenantasSuperAdmin

> PagedResultsRole searchRolesWithResourceTenantasSuperAdmin(page, size, resourceTenant, opts)

Search for roles

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

let apiInstance = new KestraApi.RolesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let resourceTenant = "resourceTenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchRolesWithResourceTenantasSuperAdmin(page, size, resourceTenant, opts).then((data) => {
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

### Return type

[**PagedResultsRole**](PagedResultsRole.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchRolesasSuperAdmin

> PagedResultsRole searchRolesasSuperAdmin(page, size, opts)

Search for roles

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

let apiInstance = new KestraApi.RolesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchRolesasSuperAdmin(page, size, opts).then((data) => {
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

[**PagedResultsRole**](PagedResultsRole.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateRole

> Role updateRole(id, tenant, role)

Update a role

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

let apiInstance = new KestraApi.RolesApi();
let id = "id_example"; // String | The role id
let tenant = "tenant_example"; // String | 
let role = new KestraApi.Role(); // Role | 
apiInstance.updateRole(id, tenant, role).then((data) => {
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
 **role** | [**Role**](Role.md)|  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateRoleWithResourceTenantasSuperAdmin

> Role updateRoleWithResourceTenantasSuperAdmin(id, resourceTenant, role)

Update a role

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

let apiInstance = new KestraApi.RolesApi();
let id = "id_example"; // String | The role id
let resourceTenant = "resourceTenant_example"; // String | 
let role = new KestraApi.Role(); // Role | 
apiInstance.updateRoleWithResourceTenantasSuperAdmin(id, resourceTenant, role).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 
 **resourceTenant** | **String**|  | 
 **role** | [**Role**](Role.md)|  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateRoleasSuperAdmin

> Role updateRoleasSuperAdmin(id, role)

Update a role

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

let apiInstance = new KestraApi.RolesApi();
let id = "id_example"; // String | The role id
let role = new KestraApi.Role(); // Role | 
apiInstance.updateRoleasSuperAdmin(id, role).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The role id | 
 **role** | [**Role**](Role.md)|  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

