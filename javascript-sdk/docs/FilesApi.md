# KestraIoKestraSdk.FilesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createNamespaceDirectory**](FilesApi.md#createNamespaceDirectory) | **POST** /api/v1/{tenant}/namespaces/{namespace}/files/directory | Create a directory
[**createNamespaceFile**](FilesApi.md#createNamespaceFile) | **POST** /api/v1/{tenant}/namespaces/{namespace}/files | Create a file
[**deleteFileDirectory**](FilesApi.md#deleteFileDirectory) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/files | Delete a file or directory
[**exportNamespaceFiles**](FilesApi.md#exportNamespaceFiles) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/export | Export namespace files as a ZIP
[**getFileContent**](FilesApi.md#getFileContent) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files | Get namespace file content
[**getFileMetadatas**](FilesApi.md#getFileMetadatas) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/stats | Get namespace file stats such as size, creation &amp; modification dates and type
[**listNamespaceDirectoryFiles**](FilesApi.md#listNamespaceDirectoryFiles) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/directory | List directory content
[**moveFileDirectory**](FilesApi.md#moveFileDirectory) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/files | Move a file or directory
[**searchNamespaceFiles**](FilesApi.md#searchNamespaceFiles) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/search | Find files which path contain the given string in their URI



## createNamespaceDirectory

> createNamespaceDirectory(namespace, tenant, opts)

Create a directory

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
let opts = {
  'path': "path_example" // String | The internal storage uri
};
apiInstance.createNamespaceDirectory(namespace, tenant, opts, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 
 **path** | **String**| The internal storage uri | [optional] 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## createNamespaceFile

> createNamespaceFile(namespace, path, tenant, opts)

Create a file

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let path = "path_example"; // String | The internal storage uri
let tenant = "tenant_example"; // String | 
let opts = {
  'fileContent': "/path/to/file" // File | The file to upload
};
apiInstance.createNamespaceFile(namespace, path, tenant, opts, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **path** | **String**| The internal storage uri | 
 **tenant** | **String**|  | 
 **fileContent** | **File**| The file to upload | [optional] 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: Not defined


## deleteFileDirectory

> deleteFileDirectory(namespace, path, tenant)

Delete a file or directory

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let path = "path_example"; // String | The internal storage uri of the file / directory to delete
let tenant = "tenant_example"; // String | 
apiInstance.deleteFileDirectory(namespace, path, tenant, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **path** | **String**| The internal storage uri of the file / directory to delete | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## exportNamespaceFiles

> Blob exportNamespaceFiles(namespace, tenant)

Export namespace files as a ZIP

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
apiInstance.exportNamespaceFiles(namespace, tenant, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 

### Return type

**Blob**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


## getFileContent

> File getFileContent(namespace, path, tenant)

Get namespace file content

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let path = "path_example"; // String | The internal storage uri
let tenant = "tenant_example"; // String | 
apiInstance.getFileContent(namespace, path, tenant, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **path** | **String**| The internal storage uri | 
 **tenant** | **String**|  | 

### Return type

**File**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


## getFileMetadatas

> FileAttributes getFileMetadatas(namespace, tenant, opts)

Get namespace file stats such as size, creation &amp; modification dates and type

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
let opts = {
  'path': "path_example" // String | The internal storage uri
};
apiInstance.getFileMetadatas(namespace, tenant, opts, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 
 **path** | **String**| The internal storage uri | [optional] 

### Return type

[**FileAttributes**](FileAttributes.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listNamespaceDirectoryFiles

> [FileAttributes] listNamespaceDirectoryFiles(namespace, tenant, opts)

List directory content

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
let opts = {
  'path': "path_example" // String | The internal storage uri
};
apiInstance.listNamespaceDirectoryFiles(namespace, tenant, opts, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 
 **path** | **String**| The internal storage uri | [optional] 

### Return type

[**[FileAttributes]**](FileAttributes.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## moveFileDirectory

> moveFileDirectory(namespace, from, to, tenant)

Move a file or directory

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let from = "from_example"; // String | The internal storage uri to move from
let to = "to_example"; // String | The internal storage uri to move to
let tenant = "tenant_example"; // String | 
apiInstance.moveFileDirectory(namespace, from, to, tenant, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **from** | **String**| The internal storage uri to move from | 
 **to** | **String**| The internal storage uri to move to | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## searchNamespaceFiles

> [String] searchNamespaceFiles(namespace, q, tenant)

Find files which path contain the given string in their URI

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

let apiInstance = new KestraIoKestraSdk.FilesApi();
let namespace = "namespace_example"; // String | The namespace id
let q = "q_example"; // String | The string the file path should contain
let tenant = "tenant_example"; // String | 
apiInstance.searchNamespaceFiles(namespace, q, tenant, (error, data, response) => {
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
 **namespace** | **String**| The namespace id | 
 **q** | **String**| The string the file path should contain | 
 **tenant** | **String**|  | 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

