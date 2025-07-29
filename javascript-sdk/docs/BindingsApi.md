# KestraApi.BindingsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkCreateBinding**](BindingsApi.md#bulkCreateBinding) | **POST** /api/v1/{tenant}/bindings/bulk | Create multiple bindings
[**createBinding**](BindingsApi.md#createBinding) | **POST** /api/v1/{tenant}/bindings | Create a binding
[**deleteBinding**](BindingsApi.md#deleteBinding) | **DELETE** /api/v1/{tenant}/bindings/{id} | Delete a binding
[**getBinding**](BindingsApi.md#getBinding) | **GET** /api/v1/{tenant}/bindings/{id} | Retrieve a binding
[**searchBindings**](BindingsApi.md#searchBindings) | **GET** /api/v1/{tenant}/bindings/search | Search for bindings



## bulkCreateBinding

> [IAMBindingControllerApiBindingDetail] bulkCreateBinding(tenant, iAMBindingControllerApiCreateBindingRequest)

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
let iAMBindingControllerApiCreateBindingRequest = [new KestraApi.IAMBindingControllerApiCreateBindingRequest()]; // [IAMBindingControllerApiCreateBindingRequest] | The bindings
apiInstance.bulkCreateBinding(tenant, iAMBindingControllerApiCreateBindingRequest, (error, data, response) => {
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
 **iAMBindingControllerApiCreateBindingRequest** | [**[IAMBindingControllerApiCreateBindingRequest]**](IAMBindingControllerApiCreateBindingRequest.md)| The bindings | 

### Return type

[**[IAMBindingControllerApiBindingDetail]**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createBinding

> IAMBindingControllerApiBindingDetail createBinding(tenant, iAMBindingControllerApiCreateBindingRequest)

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
let iAMBindingControllerApiCreateBindingRequest = new KestraApi.IAMBindingControllerApiCreateBindingRequest(); // IAMBindingControllerApiCreateBindingRequest | The binding
apiInstance.createBinding(tenant, iAMBindingControllerApiCreateBindingRequest, (error, data, response) => {
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
 **iAMBindingControllerApiCreateBindingRequest** | [**IAMBindingControllerApiCreateBindingRequest**](IAMBindingControllerApiCreateBindingRequest.md)| The binding | 

### Return type

[**IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

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
apiInstance.deleteBinding(id, tenant, (error, data, response) => {
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
 **id** | **String**| The binding id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## getBinding

> IAMBindingControllerApiBindingDetail getBinding(id, tenant)

Retrieve a binding

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
apiInstance.getBinding(id, tenant, (error, data, response) => {
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
 **id** | **String**| The binding id | 
 **tenant** | **String**|  | 

### Return type

[**IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchBindings

> PagedResultsIAMBindingControllerApiBindingSummary searchBindings(page, size, tenant, opts)

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
apiInstance.searchBindings(page, size, tenant, opts, (error, data, response) => {
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
 **type** | [**BindingType**](.md)| Binding type filter | [optional] 
 **id** | **String**| External id filter | [optional] 
 **namespace** | **String**| A namespace filter | [optional] 

### Return type

[**PagedResultsIAMBindingControllerApiBindingSummary**](PagedResultsIAMBindingControllerApiBindingSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

