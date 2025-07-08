# KestraApi.KVApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteKeyValue**](KVApi.md#deleteKeyValue) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Delete a key-value pair
[**deleteKeyValues**](KVApi.md#deleteKeyValues) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv | Bulk-delete multiple key/value pairs from the given namespace.
[**getKeyValue**](KVApi.md#getKeyValue) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Get value for a key
[**listKeys**](KVApi.md#listKeys) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv | List all keys for a namespace
[**setKeyValue**](KVApi.md#setKeyValue) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Puts a key-value pair in store



## deleteKeyValue

> Boolean deleteKeyValue(namespace, key, tenant)

Delete a key-value pair

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

let apiInstance = new KestraApi.KVApi();
let namespace = "namespace_example"; // String | The namespace id
let key = "key_example"; // String | The key
let tenant = "tenant_example"; // String | 
apiInstance.deleteKeyValue(namespace, key, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **key** | **String**| The key | 
 **tenant** | **String**|  | 

### Return type

**Boolean**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteKeyValues

> KVControllerApiDeleteBulkResponse deleteKeyValues(namespace, tenant, kVControllerApiDeleteBulkRequest)

Bulk-delete multiple key/value pairs from the given namespace.

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

let apiInstance = new KestraApi.KVApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
let kVControllerApiDeleteBulkRequest = new KestraApi.KVControllerApiDeleteBulkRequest(); // KVControllerApiDeleteBulkRequest | The keys
apiInstance.deleteKeyValues(namespace, tenant, kVControllerApiDeleteBulkRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 
 **kVControllerApiDeleteBulkRequest** | [**KVControllerApiDeleteBulkRequest**](KVControllerApiDeleteBulkRequest.md)| The keys | 

### Return type

[**KVControllerApiDeleteBulkResponse**](KVControllerApiDeleteBulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## getKeyValue

> KVControllerTypedValue getKeyValue(namespace, key, tenant)

Get value for a key

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

let apiInstance = new KestraApi.KVApi();
let namespace = "namespace_example"; // String | The namespace id
let key = "key_example"; // String | The key
let tenant = "tenant_example"; // String | 
apiInstance.getKeyValue(namespace, key, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **key** | **String**| The key | 
 **tenant** | **String**|  | 

### Return type

[**KVControllerTypedValue**](KVControllerTypedValue.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listKeys

> [KVEntry] listKeys(namespace, tenant)

List all keys for a namespace

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

let apiInstance = new KestraApi.KVApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
apiInstance.listKeys(namespace, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 

### Return type

[**[KVEntry]**](KVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## setKeyValue

> setKeyValue(namespace, key, tenant, body)

Puts a key-value pair in store

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

let apiInstance = new KestraApi.KVApi();
let namespace = "namespace_example"; // String | The namespace id
let key = "key_example"; // String | The key
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The value of the key
apiInstance.setKeyValue(namespace, key, tenant, body).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **key** | **String**| The key | 
 **tenant** | **String**|  | 
 **body** | **String**| The value of the key | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json, text/plain
- **Accept**: Not defined

