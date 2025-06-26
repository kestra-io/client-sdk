# KestraApi.TenantsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**callDelete**](TenantsApi.md#callDelete) | **DELETE** /api/v1/tenants/{id} | Delete a tenant and all its resources (flows, namespaces, apps, ...
[**create**](TenantsApi.md#create) | **POST** /api/v1/tenants | Create a tenant
[**find**](TenantsApi.md#find) | **GET** /api/v1/tenants/search | Search for tenants
[**get**](TenantsApi.md#get) | **GET** /api/v1/tenants/{id} | Get a tenant
[**setLogo**](TenantsApi.md#setLogo) | **POST** /api/v1/tenants/{id}/logo | Set a tenant logo
[**update**](TenantsApi.md#update) | **PUT** /api/v1/tenants/{id} | Update a tenant



## callDelete

> callDelete(id)

Delete a tenant and all its resources (flows, namespaces, apps, ...

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let id = "id_example"; // String | The tenant id
apiInstance.callDelete(id).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
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

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let tenant = new KestraApi.Tenant(); // Tenant | 
apiInstance.create(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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
apiInstance.find(page, size, opts).then((data) => {
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

[**PagedResultsTenant**](PagedResultsTenant.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## get

> Tenant get(id)

Get a tenant

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let id = "id_example"; // String | The tenant id
apiInstance.get(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## setLogo

> ApiTenant setLogo(id, opts)

Set a tenant logo

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let id = "id_example"; // String | The tenant id
let opts = {
  'logo': "/path/to/file" // File | The logo file
};
apiInstance.setLogo(id, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TenantsApi();
let id = "id_example"; // String | The tenant id
let tenant = new KestraApi.Tenant(); // Tenant | 
apiInstance.update(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

