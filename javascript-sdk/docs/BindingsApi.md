# KestraApi.BindingsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkCreateBinding**](BindingsApi.md#bulkCreateBinding) | **POST** /api/v1/{tenant}/bindings/bulk | Create multiple bindings
[**bulkCreateBindingapsSuperAdmin**](BindingsApi.md#bulkCreateBindingapsSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/bindings/bulk | Create multiple bindings
[**createBinding**](BindingsApi.md#createBinding) | **POST** /api/v1/{tenant}/bindings | Create a binding
[**createBindingapsSuperAdmin**](BindingsApi.md#createBindingapsSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/bindings | Create a binding
[**deleteBinding**](BindingsApi.md#deleteBinding) | **DELETE** /api/v1/{tenant}/bindings/{id} | Delete a binding
[**deleteBindingapsSuperAdmin**](BindingsApi.md#deleteBindingapsSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/bindings/{id} | Delete a binding
[**getBinding**](BindingsApi.md#getBinding) | **GET** /api/v1/{tenant}/bindings/{id} | Get a binding
[**getBindingapsSuperAdmin**](BindingsApi.md#getBindingapsSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/bindings/{id} | Get a binding
[**searchBindings**](BindingsApi.md#searchBindings) | **GET** /api/v1/{tenant}/bindings/search | Search for bindings
[**searchBindingsapsSuperAdmin**](BindingsApi.md#searchBindingsapsSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/bindings/search | Search for bindings



## bulkCreateBinding

> [AbstractBindingControllerBindingDetail] bulkCreateBinding(tenant, binding)

Create multiple bindings

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

let apiInstance = new KestraApi.BindingsApi();
let tenant = "tenant_example"; // String | 
let binding = [new KestraApi.Binding()]; // [Binding] | The bindings
apiInstance.bulkCreateBinding(tenant, binding).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **binding** | [**[Binding]**](Binding.md)| The bindings | 

### Return type

[**[AbstractBindingControllerBindingDetail]**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## bulkCreateBindingapsSuperAdmin

> [AbstractBindingControllerBindingDetail] bulkCreateBindingapsSuperAdmin(resourceTenant, binding)

Create multiple bindings

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

let apiInstance = new KestraApi.BindingsApi();
let resourceTenant = "resourceTenant_example"; // String | 
let binding = [new KestraApi.Binding()]; // [Binding] | The bindings
apiInstance.bulkCreateBindingapsSuperAdmin(resourceTenant, binding).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **binding** | [**[Binding]**](Binding.md)| The bindings | 

### Return type

[**[AbstractBindingControllerBindingDetail]**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createBinding

> AbstractBindingControllerBindingDetail createBinding(tenant, binding)

Create a binding

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

let apiInstance = new KestraApi.BindingsApi();
let tenant = "tenant_example"; // String | 
let binding = new KestraApi.Binding(); // Binding | The binding
apiInstance.createBinding(tenant, binding).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **binding** | [**Binding**](Binding.md)| The binding | 

### Return type

[**AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createBindingapsSuperAdmin

> AbstractBindingControllerBindingDetail createBindingapsSuperAdmin(resourceTenant, binding)

Create a binding

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

let apiInstance = new KestraApi.BindingsApi();
let resourceTenant = "resourceTenant_example"; // String | 
let binding = new KestraApi.Binding(); // Binding | The binding
apiInstance.createBindingapsSuperAdmin(resourceTenant, binding).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **binding** | [**Binding**](Binding.md)| The binding | 

### Return type

[**AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteBinding

> deleteBinding(id, tenant)

Delete a binding

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

let apiInstance = new KestraApi.BindingsApi();
let id = "id_example"; // String | The binding id
let tenant = "tenant_example"; // String | 
apiInstance.deleteBinding(id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The binding id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteBindingapsSuperAdmin

> deleteBindingapsSuperAdmin(id, resourceTenant)

Delete a binding

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

let apiInstance = new KestraApi.BindingsApi();
let id = "id_example"; // String | The binding id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteBindingapsSuperAdmin(id, resourceTenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The binding id | 
 **resourceTenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## getBinding

> AbstractBindingControllerBindingDetail getBinding(id, tenant)

Get a binding

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

let apiInstance = new KestraApi.BindingsApi();
let id = "id_example"; // String | The binding id
let tenant = "tenant_example"; // String | 
apiInstance.getBinding(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The binding id | 
 **tenant** | **String**|  | 

### Return type

[**AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getBindingapsSuperAdmin

> AbstractBindingControllerBindingDetail getBindingapsSuperAdmin(id, resourceTenant)

Get a binding

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

let apiInstance = new KestraApi.BindingsApi();
let id = "id_example"; // String | The binding id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.getBindingapsSuperAdmin(id, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The binding id | 
 **resourceTenant** | **String**|  | 

### Return type

[**AbstractBindingControllerBindingDetail**](AbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchBindings

> PagedResultsAbstractBindingControllerBindingDetail searchBindings(page, size, tenant, opts)

Search for bindings

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

let apiInstance = new KestraApi.BindingsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"], // [String] | The sort of current page
  'type': new KestraApi.BindingType(), // BindingType | Binding type filter
  'id': "id_example", // String | External id filter
  'namespace': "namespace_example" // String | A namespace filter
};
apiInstance.searchBindings(page, size, tenant, opts).then((data) => {
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
 **type** | [**BindingType**](.md)| Binding type filter | [optional] 
 **id** | **String**| External id filter | [optional] 
 **namespace** | **String**| A namespace filter | [optional] 

### Return type

[**PagedResultsAbstractBindingControllerBindingDetail**](PagedResultsAbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchBindingsapsSuperAdmin

> PagedResultsAbstractBindingControllerBindingDetail searchBindingsapsSuperAdmin(page, size, resourceTenant, opts)

Search for bindings

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

let apiInstance = new KestraApi.BindingsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let resourceTenant = "resourceTenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"], // [String] | The sort of current page
  'type': new KestraApi.BindingType(), // BindingType | Binding type filter
  'id': "id_example", // String | External id filter
  'namespace': "namespace_example" // String | A namespace filter
};
apiInstance.searchBindingsapsSuperAdmin(page, size, resourceTenant, opts).then((data) => {
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
 **type** | [**BindingType**](.md)| Binding type filter | [optional] 
 **id** | **String**| External id filter | [optional] 
 **namespace** | **String**| A namespace filter | [optional] 

### Return type

[**PagedResultsAbstractBindingControllerBindingDetail**](PagedResultsAbstractBindingControllerBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

