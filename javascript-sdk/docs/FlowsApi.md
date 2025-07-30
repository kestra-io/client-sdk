# KestraIoKestraApi.FlowsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkImportApps**](FlowsApi.md#bulkImportApps) | **POST** /api/v1/{tenant}/apps/import |     Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 
[**bulkUpdateFlows**](FlowsApi.md#bulkUpdateFlows) | **POST** /api/v1/{tenant}/flows/bulk | Update from multiples yaml sources
[**createFlow**](FlowsApi.md#createFlow) | **POST** /api/v1/{tenant}/flows | Create a flow from yaml source
[**deleteFlow**](FlowsApi.md#deleteFlow) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id} | Delete a flow
[**deleteFlowsByIds**](FlowsApi.md#deleteFlowsByIds) | **DELETE** /api/v1/{tenant}/flows/delete/by-ids | Delete flows by their IDs.
[**deleteFlowsByQuery**](FlowsApi.md#deleteFlowsByQuery) | **DELETE** /api/v1/{tenant}/flows/delete/by-query | Delete flows returned by the query parameters.
[**disableFlowsByIds**](FlowsApi.md#disableFlowsByIds) | **POST** /api/v1/{tenant}/flows/disable/by-ids | Disable flows by their IDs.
[**disableFlowsByQuery**](FlowsApi.md#disableFlowsByQuery) | **POST** /api/v1/{tenant}/flows/disable/by-query | Disable flows returned by the query parameters.
[**enableFlowsByIds**](FlowsApi.md#enableFlowsByIds) | **POST** /api/v1/{tenant}/flows/enable/by-ids | Enable flows by their IDs.
[**enableFlowsByQuery**](FlowsApi.md#enableFlowsByQuery) | **POST** /api/v1/{tenant}/flows/enable/by-query | Enable flows returned by the query parameters.
[**exportFlowsByIds**](FlowsApi.md#exportFlowsByIds) | **POST** /api/v1/{tenant}/flows/export/by-ids | Export flows as a ZIP archive of yaml sources.
[**exportFlowsByQuery**](FlowsApi.md#exportFlowsByQuery) | **GET** /api/v1/{tenant}/flows/export/by-query | Export flows as a ZIP archive of yaml sources.
[**generateFlowGraph**](FlowsApi.md#generateFlowGraph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow
[**generateFlowGraphFromSource**](FlowsApi.md#generateFlowGraphFromSource) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source
[**getFlow**](FlowsApi.md#getFlow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id} | Get a flow
[**getFlowDependencies**](FlowsApi.md#getFlowDependencies) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/dependencies | Get flow dependencies
[**getFlowDependenciesFromNamespace**](FlowsApi.md#getFlowDependenciesFromNamespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**getTaskFromFlow**](FlowsApi.md#getTaskFromFlow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/tasks/{taskId} | Get a flow task
[**importFlows**](FlowsApi.md#importFlows) | **POST** /api/v1/{tenant}/flows/import |     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 
[**listDistinctNamespaces**](FlowsApi.md#listDistinctNamespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces
[**listFlowRevisions**](FlowsApi.md#listFlowRevisions) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Get revisions for a flow
[**listFlowsByNamespace**](FlowsApi.md#listFlowsByNamespace) | **GET** /api/v1/{tenant}/flows/{namespace} | Retrieve all flows from a given namespace
[**searchFlows**](FlowsApi.md#searchFlows) | **GET** /api/v1/{tenant}/flows/search | Search for flows
[**searchFlowsBySourceCode**](FlowsApi.md#searchFlowsBySourceCode) | **GET** /api/v1/{tenant}/flows/source | Search for flows source code
[**updateFlow**](FlowsApi.md#updateFlow) | **PUT** /api/v1/{tenant}/flows/{namespace}/{id} | Update a flow
[**updateFlowsInNamespaceFromJson**](FlowsApi.md#updateFlowsInNamespaceFromJson) | **POST** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from json object
[**updateTask**](FlowsApi.md#updateTask) | **PATCH** /api/v1/{tenant}/flows/{namespace}/{id}/{taskId} | Update a single task on a flow
[**validateFlows**](FlowsApi.md#validateFlows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows
[**validateTask**](FlowsApi.md#validateTask) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task
[**validateTrigger**](FlowsApi.md#validateTrigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger



## bulkImportApps

> AppsControllerApiBulkImportResponse bulkImportApps(tenant, opts)

    Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'fileUpload': "/path/to/file" // File | The file to import, can be a ZIP archive or a multi-objects YAML file
};
apiInstance.bulkImportApps(tenant, opts, (error, data, response) => {
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
 **fileUpload** | **File**| The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] 

### Return type

[**AppsControllerApiBulkImportResponse**](AppsControllerApiBulkImportResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## bulkUpdateFlows

> [FlowInterface] bulkUpdateFlows(_delete, allowNamespaceChild, tenant, opts)

Update from multiples yaml sources

All flow will be created / updated for this namespace. Flow that already created but not in &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let _delete = true; // Boolean | If missing flow should be deleted
let allowNamespaceChild = false; // Boolean | If namespace child should are allowed to be updated
let tenant = "tenant_example"; // String | 
let opts = {
  'namespace': "namespace_example", // String | The namespace where to update flows
  'body': "body_example" // String | A list of flows source code splitted with \"---\"
};
apiInstance.bulkUpdateFlows(_delete, allowNamespaceChild, tenant, opts, (error, data, response) => {
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
 **_delete** | **Boolean**| If missing flow should be deleted | [default to true]
 **allowNamespaceChild** | **Boolean**| If namespace child should are allowed to be updated | [default to false]
 **tenant** | **String**|  | 
 **namespace** | **String**| The namespace where to update flows | [optional] 
 **body** | **String**| A list of flows source code splitted with \&quot;---\&quot; | [optional] 

### Return type

[**[FlowInterface]**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## createFlow

> FlowWithSource createFlow(tenant, body)

Create a flow from yaml source

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The flow source code
apiInstance.createFlow(tenant, body, (error, data, response) => {
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
 **body** | **String**| The flow source code | 

### Return type

[**FlowWithSource**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## deleteFlow

> deleteFlow(namespace, id, tenant)

Delete a flow

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
apiInstance.deleteFlow(namespace, id, tenant, (error, data, response) => {
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
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteFlowsByIds

> BulkResponse deleteFlowsByIds(tenant, idWithNamespace)

Delete flows by their IDs.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let idWithNamespace = [new KestraIoKestraApi.IdWithNamespace()]; // [IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers
apiInstance.deleteFlowsByIds(tenant, idWithNamespace, (error, data, response) => {
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
 **idWithNamespace** | [**[IdWithNamespace]**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteFlowsByQuery

> BulkResponse deleteFlowsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Delete flows returned by the query parameters.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the flows to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'labels': ["null"] // [String] | A labels filter as a list of 'key:value'
};
apiInstance.deleteFlowsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **String**| A string filter | [optional] 
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the flows to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## disableFlowsByIds

> BulkResponse disableFlowsByIds(tenant, idWithNamespace)

Disable flows by their IDs.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let idWithNamespace = [new KestraIoKestraApi.IdWithNamespace()]; // [IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers
apiInstance.disableFlowsByIds(tenant, idWithNamespace, (error, data, response) => {
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
 **idWithNamespace** | [**[IdWithNamespace]**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## disableFlowsByQuery

> BulkResponse disableFlowsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Disable flows returned by the query parameters.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the flows to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'labels': ["null"] // [String] | A labels filter as a list of 'key:value'
};
apiInstance.disableFlowsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **String**| A string filter | [optional] 
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the flows to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## enableFlowsByIds

> BulkResponse enableFlowsByIds(tenant, idWithNamespace)

Enable flows by their IDs.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let idWithNamespace = [new KestraIoKestraApi.IdWithNamespace()]; // [IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers
apiInstance.enableFlowsByIds(tenant, idWithNamespace, (error, data, response) => {
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
 **idWithNamespace** | [**[IdWithNamespace]**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## enableFlowsByQuery

> BulkResponse enableFlowsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Enable flows returned by the query parameters.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the flows to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'labels': ["null"] // [String] | A labels filter as a list of 'key:value'
};
apiInstance.enableFlowsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **String**| A string filter | [optional] 
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the flows to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## exportFlowsByIds

> Blob exportFlowsByIds(tenant, idWithNamespace)

Export flows as a ZIP archive of yaml sources.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let idWithNamespace = [new KestraIoKestraApi.IdWithNamespace()]; // [IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers
apiInstance.exportFlowsByIds(tenant, idWithNamespace, (error, data, response) => {
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
 **idWithNamespace** | [**[IdWithNamespace]**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | 

### Return type

**Blob**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream


## exportFlowsByQuery

> Blob exportFlowsByQuery(tenant, opts)

Export flows as a ZIP archive of yaml sources.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraApi.QueryFilter()], // [QueryFilter] | Filters
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the flows to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'labels': ["null"] // [String] | A labels filter as a list of 'key:value'
};
apiInstance.exportFlowsByQuery(tenant, opts, (error, data, response) => {
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
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 
 **q** | **String**| A string filter | [optional] 
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the flows to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 

### Return type

**Blob**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


## generateFlowGraph

> FlowGraph generateFlowGraph(namespace, id, tenant, opts)

Generate a graph for a flow

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56, // Number | The flow revision
  'subflows': ["null"] // [String] | The subflow tasks to display
};
apiInstance.generateFlowGraph(namespace, id, tenant, opts, (error, data, response) => {
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
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **tenant** | **String**|  | 
 **revision** | **Number**| The flow revision | [optional] 
 **subflows** | [**[String]**](String.md)| The subflow tasks to display | [optional] 

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## generateFlowGraphFromSource

> FlowGraph generateFlowGraphFromSource(tenant, body, opts)

Generate a graph for a flow source

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The flow source code
let opts = {
  'subflows': ["null"] // [String] | The subflow tasks to display
};
apiInstance.generateFlowGraphFromSource(tenant, body, opts, (error, data, response) => {
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
 **body** | **String**| The flow source code | 
 **subflows** | [**[String]**](String.md)| The subflow tasks to display | [optional] 

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## getFlow

> Object getFlow(namespace, id, source, allowDeleted, tenant, opts)

Get a flow

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let source = false; // Boolean | Include the source code
let allowDeleted = false; // Boolean | Get flow even if deleted
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56 // Number | Get latest revision by default
};
apiInstance.getFlow(namespace, id, source, allowDeleted, tenant, opts, (error, data, response) => {
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
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **source** | **Boolean**| Include the source code | [default to false]
 **allowDeleted** | **Boolean**| Get flow even if deleted | [default to false]
 **tenant** | **String**|  | 
 **revision** | **Number**| Get latest revision by default | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getFlowDependencies

> FlowTopologyGraph getFlowDependencies(namespace, id, destinationOnly, expandAll, tenant)

Get flow dependencies

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let destinationOnly = false; // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
let expandAll = false; // Boolean | If true, expand all dependencies recursively
let tenant = "tenant_example"; // String | 
apiInstance.getFlowDependencies(namespace, id, destinationOnly, expandAll, tenant, (error, data, response) => {
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
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **destinationOnly** | **Boolean**| If true, list only destination dependencies, otherwise list also source dependencies | [default to false]
 **expandAll** | **Boolean**| If true, expand all dependencies recursively | [default to false]
 **tenant** | **String**|  | 

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getFlowDependenciesFromNamespace

> FlowTopologyGraph getFlowDependenciesFromNamespace(namespace, destinationOnly, tenant)

Retrieve flow dependencies

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let destinationOnly = false; // Boolean | if true, list only destination dependencies, otherwise list also source dependencies
let tenant = "tenant_example"; // String | 
apiInstance.getFlowDependenciesFromNamespace(namespace, destinationOnly, tenant, (error, data, response) => {
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
 **namespace** | **String**| The flow namespace | 
 **destinationOnly** | **Boolean**| if true, list only destination dependencies, otherwise list also source dependencies | [default to false]
 **tenant** | **String**|  | 

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getTaskFromFlow

> Task getTaskFromFlow(namespace, id, taskId, tenant, opts)

Get a flow task

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let taskId = "taskId_example"; // String | The task id
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56 // Number | The flow revision
};
apiInstance.getTaskFromFlow(namespace, id, taskId, tenant, opts, (error, data, response) => {
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
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **taskId** | **String**| The task id | 
 **tenant** | **String**|  | 
 **revision** | **Number**| The flow revision | [optional] 

### Return type

[**Task**](Task.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## importFlows

> [String] importFlows(tenant, opts)

    Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'fileUpload': "/path/to/file" // File | The file to import, can be a ZIP archive or a multi-objects YAML file
};
apiInstance.importFlows(tenant, opts, (error, data, response) => {
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
 **fileUpload** | **File**| The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## listDistinctNamespaces

> [String] listDistinctNamespaces(tenant, opts)

List all distinct namespaces

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example" // String | A string filter
};
apiInstance.listDistinctNamespaces(tenant, opts, (error, data, response) => {
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
 **q** | **String**| A string filter | [optional] 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listFlowRevisions

> [FlowWithSource] listFlowRevisions(namespace, id, tenant)

Get revisions for a flow

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
apiInstance.listFlowRevisions(namespace, id, tenant, (error, data, response) => {
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
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **tenant** | **String**|  | 

### Return type

[**[FlowWithSource]**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listFlowsByNamespace

> [Flow] listFlowsByNamespace(namespace, tenant)

Retrieve all flows from a given namespace

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | Namespace to filter flows
let tenant = "tenant_example"; // String | 
apiInstance.listFlowsByNamespace(namespace, tenant, (error, data, response) => {
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
 **namespace** | **String**| Namespace to filter flows | 
 **tenant** | **String**|  | 

### Return type

[**[Flow]**](Flow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchFlows

> PagedResultsFlow searchFlows(page, size, tenant, opts)

Search for flows

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'filters': [new KestraIoKestraApi.QueryFilter()], // [QueryFilter] | Filters
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the flows to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'labels': ["null"] // [String] | A labels filter as a list of 'key:value'
};
apiInstance.searchFlows(page, size, tenant, opts, (error, data, response) => {
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
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 
 **q** | **String**| A string filter | [optional] 
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the flows to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 

### Return type

[**PagedResultsFlow**](PagedResultsFlow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchFlowsBySourceCode

> PagedResultsSearchResultFlow searchFlowsBySourceCode(page, size, tenant, opts)

Search for flows source code

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'q': "q_example", // String | A string filter
  'namespace': "namespace_example" // String | A namespace filter prefix
};
apiInstance.searchFlowsBySourceCode(page, size, tenant, opts, (error, data, response) => {
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
 **q** | **String**| A string filter | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 

### Return type

[**PagedResultsSearchResultFlow**](PagedResultsSearchResultFlow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateFlow

> UpdateFlow200Response updateFlow(id, namespace, tenant, body)

Update a flow

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let id = "id_example"; // String | The flow id
let namespace = "namespace_example"; // String | The flow namespace
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The flow source code
apiInstance.updateFlow(id, namespace, tenant, body, (error, data, response) => {
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
 **id** | **String**| The flow id | 
 **namespace** | **String**| The flow namespace | 
 **tenant** | **String**|  | 
 **body** | **String**| The flow source code | 

### Return type

[**UpdateFlow200Response**](UpdateFlow200Response.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## updateFlowsInNamespaceFromJson

> UpdateFlowsInNamespaceFromJson200Response updateFlowsInNamespaceFromJson(_delete, namespace, tenant, flow)

Update a complete namespace from json object

All flow will be created / updated for this namespace. Flow that already created but not in &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let _delete = true; // Boolean | If missing flow should be deleted
let namespace = "namespace_example"; // String | The flow namespace
let tenant = "tenant_example"; // String | 
let flow = [new KestraIoKestraApi.Flow()]; // [Flow] | A list of flows
apiInstance.updateFlowsInNamespaceFromJson(_delete, namespace, tenant, flow, (error, data, response) => {
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
 **_delete** | **Boolean**| If missing flow should be deleted | [default to true]
 **namespace** | **String**| The flow namespace | 
 **tenant** | **String**|  | 
 **flow** | [**[Flow]**](Flow.md)| A list of flows | 

### Return type

[**UpdateFlowsInNamespaceFromJson200Response**](UpdateFlowsInNamespaceFromJson200Response.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-yaml
- **Accept**: application/json


## updateTask

> Flow updateTask(namespace, id, taskId, tenant, task)

Update a single task on a flow

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let taskId = "taskId_example"; // String | The task id
let tenant = "tenant_example"; // String | 
let task = new KestraIoKestraApi.Task(); // Task | The task
apiInstance.updateTask(namespace, id, taskId, tenant, task, (error, data, response) => {
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
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **taskId** | **String**| The task id | 
 **tenant** | **String**|  | 
 **task** | [**Task**](Task.md)| The task | 

### Return type

[**Flow**](Flow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## validateFlows

> [ValidateConstraintViolation] validateFlows(tenant, body)

Validate a list of flows

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | A list of flows source code in a single string
apiInstance.validateFlows(tenant, body, (error, data, response) => {
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
 **body** | **String**| A list of flows source code in a single string | 

### Return type

[**[ValidateConstraintViolation]**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## validateTask

> ValidateConstraintViolation validateTask(section, tenant, body)

Validate a task

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let section = new KestraIoKestraApi.FlowControllerTaskValidationType(); // FlowControllerTaskValidationType | The type of task
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | A task definition that can be from tasks or triggers
apiInstance.validateTask(section, tenant, body, (error, data, response) => {
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
 **section** | [**FlowControllerTaskValidationType**](.md)| The type of task | 
 **tenant** | **String**|  | 
 **body** | **String**| A task definition that can be from tasks or triggers | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml, application/json
- **Accept**: application/json


## validateTrigger

> ValidateConstraintViolation validateTrigger(tenant, body)

Validate trigger

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.FlowsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The trigger
apiInstance.validateTrigger(tenant, body, (error, data, response) => {
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
 **body** | **String**| The trigger | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

