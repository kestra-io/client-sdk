# KestraIoKestraSdk.AppsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkDeleteApps**](AppsApi.md#bulkDeleteApps) | **DELETE** /api/v1/{tenant}/apps | Delete existing apps
[**bulkDisableApps**](AppsApi.md#bulkDisableApps) | **POST** /api/v1/{tenant}/apps/disable | Disable existing apps
[**bulkEnableApps**](AppsApi.md#bulkEnableApps) | **POST** /api/v1/{tenant}/apps/enable | Enable existing apps
[**bulkExportApps**](AppsApi.md#bulkExportApps) | **POST** /api/v1/{tenant}/apps/export | Export apps as a ZIP archive of YAML sources.
[**createApp**](AppsApi.md#createApp) | **POST** /api/v1/{tenant}/apps | Create a new app
[**deleteApp**](AppsApi.md#deleteApp) | **DELETE** /api/v1/{tenant}/apps/{uid} | Delete an existing app
[**disableApp**](AppsApi.md#disableApp) | **POST** /api/v1/{tenant}/apps/{uid}/disable | Disable the app.
[**dispatchApp**](AppsApi.md#dispatchApp) | **POST** /api/v1/{tenant}/apps/view/{id}/dispatch/{dispatch} | Dispatch for a given app.
[**downloadFileFromAppExecution**](AppsApi.md#downloadFileFromAppExecution) | **GET** /api/v1/{tenant}/apps/view/{id}/file/download | Download file from an app execution
[**enableApp**](AppsApi.md#enableApp) | **POST** /api/v1/{tenant}/apps/{uid}/enable | Enable the app.
[**getApp**](AppsApi.md#getApp) | **GET** /api/v1/{tenant}/apps/{uid} | Retrieve an app
[**getFileMetaFromAppExecution**](AppsApi.md#getFileMetaFromAppExecution) | **GET** /api/v1/{tenant}/apps/view/{id}/file/meta | Get file meta information from an app execution
[**getFilePreviewFromAppExecution**](AppsApi.md#getFilePreviewFromAppExecution) | **GET** /api/v1/{tenant}/apps/view/{id}/file/preview | Get file preview from an app execution
[**getLogsFromAppExecution**](AppsApi.md#getLogsFromAppExecution) | **GET** /api/v1/{tenant}/apps/view/{uid}/logs/download | Download logs for an app execution
[**getStreamEventsFromApp**](AppsApi.md#getStreamEventsFromApp) | **GET** /api/v1/{tenant}/apps/view/{id}/streams/{stream} | Get an event stream from a given app.
[**listTags**](AppsApi.md#listTags) | **GET** /api/v1/{tenant}/apps/tags | Get all the app tags
[**openApp**](AppsApi.md#openApp) | **GET** /api/v1/{tenant}/apps/view/{uid} | Open an app
[**previewApp**](AppsApi.md#previewApp) | **POST** /api/v1/{tenant}/apps/preview | Open the app for the given source
[**searchApps**](AppsApi.md#searchApps) | **GET** /api/v1/{tenant}/apps/search | Search for apps
[**searchAppsFromCatalog**](AppsApi.md#searchAppsFromCatalog) | **GET** /api/v1/{tenant}/apps/catalog | Search for apps from catalog
[**updateApp**](AppsApi.md#updateApp) | **PUT** /api/v1/{tenant}/apps/{uid} | Update an existing app



## bulkDeleteApps

> Object bulkDeleteApps(tenant, appsControllerApiBulkOperationRequest)

Delete existing apps

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let tenant = "tenant_example"; // String | 
let appsControllerApiBulkOperationRequest = new KestraIoKestraSdk.AppsControllerApiBulkOperationRequest(); // AppsControllerApiBulkOperationRequest | The list of Apps UID
apiInstance.bulkDeleteApps(tenant, appsControllerApiBulkOperationRequest, (error, data, response) => {
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
 **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## bulkDisableApps

> Object bulkDisableApps(tenant, appsControllerApiBulkOperationRequest)

Disable existing apps

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let tenant = "tenant_example"; // String | 
let appsControllerApiBulkOperationRequest = new KestraIoKestraSdk.AppsControllerApiBulkOperationRequest(); // AppsControllerApiBulkOperationRequest | The list of Apps UID
apiInstance.bulkDisableApps(tenant, appsControllerApiBulkOperationRequest, (error, data, response) => {
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
 **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## bulkEnableApps

> Object bulkEnableApps(tenant, appsControllerApiBulkOperationRequest)

Enable existing apps

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let tenant = "tenant_example"; // String | 
let appsControllerApiBulkOperationRequest = new KestraIoKestraSdk.AppsControllerApiBulkOperationRequest(); // AppsControllerApiBulkOperationRequest | The list of Apps UID
apiInstance.bulkEnableApps(tenant, appsControllerApiBulkOperationRequest, (error, data, response) => {
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
 **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## bulkExportApps

> Blob bulkExportApps(tenant, appsControllerApiBulkOperationRequest)

Export apps as a ZIP archive of YAML sources.

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let tenant = "tenant_example"; // String | 
let appsControllerApiBulkOperationRequest = new KestraIoKestraSdk.AppsControllerApiBulkOperationRequest(); // AppsControllerApiBulkOperationRequest | The list of Apps UID
apiInstance.bulkExportApps(tenant, appsControllerApiBulkOperationRequest, (error, data, response) => {
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
 **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | 

### Return type

**Blob**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream


## createApp

> AppsControllerApiAppSource createApp(tenant, body)

Create a new app

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The app
apiInstance.createApp(tenant, body, (error, data, response) => {
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
 **body** | **String**| The app | 

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## deleteApp

> Object deleteApp(uid, tenant)

Delete an existing app

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let uid = "uid_example"; // String | The ID of the app
let tenant = "tenant_example"; // String | 
apiInstance.deleteApp(uid, tenant, (error, data, response) => {
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
 **uid** | **String**| The ID of the app | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## disableApp

> AppsControllerApiApp disableApp(uid, tenant)

Disable the app.

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let uid = "uid_example"; // String | The ID of app
let tenant = "tenant_example"; // String | 
apiInstance.disableApp(uid, tenant, (error, data, response) => {
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
 **uid** | **String**| The ID of app | 
 **tenant** | **String**|  | 

### Return type

[**AppsControllerApiApp**](AppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## dispatchApp

> AppResponse dispatchApp(id, dispatch, tenant, opts)

Dispatch for a given app.

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let id = "id_example"; // String | The ID of the app.
let dispatch = "dispatch_example"; // String | The ID to dispatch
let tenant = "tenant_example"; // String | 
let opts = {
  'parameters': new KestraIoKestraSdk.HttpParameters() // HttpParameters | 
};
apiInstance.dispatchApp(id, dispatch, tenant, opts, (error, data, response) => {
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
 **id** | **String**| The ID of the app. | 
 **dispatch** | **String**| The ID to dispatch | 
 **tenant** | **String**|  | 
 **parameters** | [**HttpParameters**](HttpParameters.md)|  | [optional] 

### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## downloadFileFromAppExecution

> File downloadFileFromAppExecution(id, path, tenant)

Download file from an app execution

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let id = "id_example"; // String | The ID of the app.
let path = "path_example"; // String | The internal storage uri
let tenant = "tenant_example"; // String | 
apiInstance.downloadFileFromAppExecution(id, path, tenant, (error, data, response) => {
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
 **id** | **String**| The ID of the app. | 
 **path** | **String**| The internal storage uri | 
 **tenant** | **String**|  | 

### Return type

**File**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## enableApp

> AppsControllerApiApp enableApp(uid, tenant)

Enable the app.

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let uid = "uid_example"; // String | The ID of app
let tenant = "tenant_example"; // String | 
apiInstance.enableApp(uid, tenant, (error, data, response) => {
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
 **uid** | **String**| The ID of app | 
 **tenant** | **String**|  | 

### Return type

[**AppsControllerApiApp**](AppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getApp

> AppsControllerApiAppSource getApp(uid, tenant)

Retrieve an app

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let uid = "uid_example"; // String | The ID of the app
let tenant = "tenant_example"; // String | 
apiInstance.getApp(uid, tenant, (error, data, response) => {
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
 **uid** | **String**| The ID of the app | 
 **tenant** | **String**|  | 

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getFileMetaFromAppExecution

> FileMetas getFileMetaFromAppExecution(id, path, tenant)

Get file meta information from an app execution

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let id = "id_example"; // String | The ID of the app.
let path = "path_example"; // String | The internal storage uri
let tenant = "tenant_example"; // String | 
apiInstance.getFileMetaFromAppExecution(id, path, tenant, (error, data, response) => {
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
 **id** | **String**| The ID of the app. | 
 **path** | **String**| The internal storage uri | 
 **tenant** | **String**|  | 

### Return type

[**FileMetas**](FileMetas.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getFilePreviewFromAppExecution

> Object getFilePreviewFromAppExecution(id, path, encoding, tenant, opts)

Get file preview from an app execution

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let id = "id_example"; // String | The ID of the app.
let path = "path_example"; // String | The internal storage uri
let encoding = "ISO-8859-1"; // String | The file encoding as Java charset name. Defaults to UTF-8
let tenant = "tenant_example"; // String | 
let opts = {
  'maxRows': 56 // Number | The max row returns
};
apiInstance.getFilePreviewFromAppExecution(id, path, encoding, tenant, opts, (error, data, response) => {
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
 **id** | **String**| The ID of the app. | 
 **path** | **String**| The internal storage uri | 
 **encoding** | **String**| The file encoding as Java charset name. Defaults to UTF-8 | [default to &#39;UTF-8&#39;]
 **tenant** | **String**|  | 
 **maxRows** | **Number**| The max row returns | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getLogsFromAppExecution

> File getLogsFromAppExecution(uid, executionId, tenant, opts)

Download logs for an app execution

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let uid = "uid_example"; // String | The ID of the app.
let executionId = "executionId_example"; // String | The ID of the execution.
let tenant = "tenant_example"; // String | 
let opts = {
  'minLevel': new KestraIoKestraSdk.Level(), // Level | The min log level filter
  'taskIds': ["null"] // [String] | The tasks' IDs
};
apiInstance.getLogsFromAppExecution(uid, executionId, tenant, opts, (error, data, response) => {
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
 **uid** | **String**| The ID of the app. | 
 **executionId** | **String**| The ID of the execution. | 
 **tenant** | **String**|  | 
 **minLevel** | [**Level**](.md)| The min log level filter | [optional] 
 **taskIds** | [**[String]**](String.md)| The tasks&#39; IDs | [optional] 

### Return type

**File**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


## getStreamEventsFromApp

> EventAppResponse getStreamEventsFromApp(id, stream, parameters, tenant)

Get an event stream from a given app.

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let id = "id_example"; // String | The ID of the app.
let stream = "stream_example"; // String | The ID of the stream to get
let parameters = {key: null}; // HttpParameters | 
let tenant = "tenant_example"; // String | 
apiInstance.getStreamEventsFromApp(id, stream, parameters, tenant, (error, data, response) => {
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
 **id** | **String**| The ID of the app. | 
 **stream** | **String**| The ID of the stream to get | 
 **parameters** | [**HttpParameters**](.md)|  | 
 **tenant** | **String**|  | 

### Return type

[**EventAppResponse**](EventAppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream


## listTags

> AppsControllerApiAppTags listTags(tenant)

Get all the app tags

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let tenant = "tenant_example"; // String | 
apiInstance.listTags(tenant, (error, data, response) => {
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

### Return type

[**AppsControllerApiAppTags**](AppsControllerApiAppTags.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## openApp

> AppResponse openApp(uid, parameters, tenant)

Open an app

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let uid = "uid_example"; // String | The ID of the app
let parameters = {key: null}; // HttpParameters | 
let tenant = "tenant_example"; // String | 
apiInstance.openApp(uid, parameters, tenant, (error, data, response) => {
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
 **uid** | **String**| The ID of the app | 
 **parameters** | [**HttpParameters**](.md)|  | 
 **tenant** | **String**|  | 

### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## previewApp

> AppResponse previewApp(tenant, previewAppRequest)

Open the app for the given source

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let tenant = "tenant_example"; // String | 
let previewAppRequest = new KestraIoKestraSdk.PreviewAppRequest(); // PreviewAppRequest | The app
apiInstance.previewApp(tenant, previewAppRequest, (error, data, response) => {
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
 **previewAppRequest** | [**PreviewAppRequest**](PreviewAppRequest.md)| The app | 

### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## searchApps

> PagedResultsAppsControllerApiApp searchApps(page, size, tenant, opts)

Search for apps

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'tags': ["null"], // [String] | A tags filter
  'q': "q_example", // String | A string filter
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example" // String | A flow id filter
};
apiInstance.searchApps(page, size, tenant, opts, (error, data, response) => {
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
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **tags** | [**[String]**](String.md)| A tags filter | [optional] 
 **q** | **String**| A string filter | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 

### Return type

[**PagedResultsAppsControllerApiApp**](PagedResultsAppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchAppsFromCatalog

> PagedResultsAppsControllerApiAppCatalogItem searchAppsFromCatalog(page, size, tenant, opts)

Search for apps from catalog

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'tags': ["null"], // [String] | Tags filter
  'q': "q_example" // String | String filter
};
apiInstance.searchAppsFromCatalog(page, size, tenant, opts, (error, data, response) => {
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
 **tags** | [**[String]**](String.md)| Tags filter | [optional] 
 **q** | **String**| String filter | [optional] 

### Return type

[**PagedResultsAppsControllerApiAppCatalogItem**](PagedResultsAppsControllerApiAppCatalogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateApp

> AppsControllerApiAppSource updateApp(uid, tenant, body)

Update an existing app

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

let apiInstance = new KestraIoKestraSdk.AppsApi();
let uid = "uid_example"; // String | The ID of the app
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The app
apiInstance.updateApp(uid, tenant, body, (error, data, response) => {
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
 **uid** | **String**| The ID of the app | 
 **tenant** | **String**|  | 
 **body** | **String**| The app | 

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

