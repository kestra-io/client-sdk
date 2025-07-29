# KestraApi.TenantsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**callDelete**](TenantsApi.md#callDelete) | **DELETE** /api/v1/tenants/{id} | Delete a tenant and all its resources
[**create**](TenantsApi.md#create) | **POST** /api/v1/tenants | Create a tenant
[**find**](TenantsApi.md#find) | **GET** /api/v1/tenants/search | Search for tenants
[**get**](TenantsApi.md#get) | **GET** /api/v1/tenants/{id} | Retrieve a tenant
[**getFlowDependenciesFromTenant**](TenantsApi.md#getFlowDependenciesFromTenant) | **GET** /api/v1/{tenant}/dependencies | Get tenant dependencies
[**setLogo**](TenantsApi.md#setLogo) | **POST** /api/v1/tenants/{id}/logo | Set a tenant logo
[**update**](TenantsApi.md#update) | **PUT** /api/v1/tenants/{id} | Update a tenant



## callDelete

> callDelete(id)

Delete a tenant and all its resources

Superadmin-only. Deletes all resources linked to the tenant, including flows, namespaces, apps, etc.

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let id = "id_example"; // String | The tenant id
apiInstance.callDelete(id, (error, data, response) => {
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
 **id** | **String**| The tenant id | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## create

> Tenant create(tenant)

Create a tenant

Superadmin-only.

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let tenant = new KestraApi.Tenant(); // Tenant | 
apiInstance.create(tenant, (error, data, response) => {
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
 **tenant** | [**Tenant**](Tenant.md)|  | 

### Return type

[**Tenant**](Tenant.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## find

> PagedResultsTenant find(page, size, opts)

Search for tenants

Superadmin-only.

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.find(page, size, opts, (error, data, response) => {
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

[**PagedResultsTenant**](PagedResultsTenant.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## get

> Tenant get(id)

Retrieve a tenant

Superadmin-only.

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let id = "id_example"; // String | The tenant id
apiInstance.get(id, (error, data, response) => {
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
 **id** | **String**| The tenant id | 

### Return type

[**Tenant**](Tenant.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getFlowDependenciesFromTenant

> FlowTopologyGraph getFlowDependenciesFromTenant(destinationOnly, tenant)

Get tenant dependencies

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let destinationOnly = false; // Boolean | if true, list only destination dependencies, otherwise list also source dependencies
let tenant = "tenant_example"; // String | 
apiInstance.getFlowDependenciesFromTenant(destinationOnly, tenant, (error, data, response) => {
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
 **destinationOnly** | **Boolean**| if true, list only destination dependencies, otherwise list also source dependencies | [default to false]
 **tenant** | **String**|  | 

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## setLogo

> ApiTenant setLogo(id, opts)

Set a tenant logo

Superadmin-only.

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let id = "id_example"; // String | The tenant id
let opts = {
  'logo': "/path/to/file" // File | The logo file
};
apiInstance.setLogo(id, opts, (error, data, response) => {
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
 **id** | **String**| The tenant id | 
 **logo** | **File**| The logo file | [optional] 

### Return type

[**ApiTenant**](ApiTenant.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## update

> Tenant update(id, tenant)

Update a tenant

Superadmin-only.

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let id = "id_example"; // String | The tenant id
let tenant = new KestraApi.Tenant(); // Tenant | 
apiInstance.update(id, tenant, (error, data, response) => {
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
 **id** | **String**| The tenant id | 
 **tenant** | [**Tenant**](Tenant.md)|  | 

### Return type

[**Tenant**](Tenant.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

