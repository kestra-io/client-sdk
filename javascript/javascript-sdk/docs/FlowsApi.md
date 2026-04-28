# KestraIoKestraSdk.FlowsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkUpdateFlows**](FlowsApi.md#bulkUpdateFlows) | **POST** /api/v1/{tenant}/flows/bulk | Update from multiples yaml sources
[**createFlow**](FlowsApi.md#createFlow) | **POST** /api/v1/{tenant}/flows | Create a flow from yaml source
[**deleteFlow**](FlowsApi.md#deleteFlow) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id} | Delete a flow
[**deleteFlowsByIds**](FlowsApi.md#deleteFlowsByIds) | **DELETE** /api/v1/{tenant}/flows/delete/by-ids | Delete flows by their IDs.
[**deleteFlowsByQuery**](FlowsApi.md#deleteFlowsByQuery) | **DELETE** /api/v1/{tenant}/flows/delete/by-query | Delete flows returned by the query parameters.
[**deleteRevisions**](FlowsApi.md#deleteRevisions) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Delete revisions for a flow
[**disableFlowsByIds**](FlowsApi.md#disableFlowsByIds) | **POST** /api/v1/{tenant}/flows/disable/by-ids | Disable flows by their IDs.
[**disableFlowsByQuery**](FlowsApi.md#disableFlowsByQuery) | **POST** /api/v1/{tenant}/flows/disable/by-query | Disable flows returned by the query parameters.
[**enableFlowsByIds**](FlowsApi.md#enableFlowsByIds) | **POST** /api/v1/{tenant}/flows/enable/by-ids | Enable flows by their IDs.
[**enableFlowsByQuery**](FlowsApi.md#enableFlowsByQuery) | **POST** /api/v1/{tenant}/flows/enable/by-query | Enable flows returned by the query parameters.
[**exportFlowsByIds**](FlowsApi.md#exportFlowsByIds) | **POST** /api/v1/{tenant}/flows/export/by-ids | Export flows as a ZIP archive of yaml sources.
[**exportFlowsByQuery**](FlowsApi.md#exportFlowsByQuery) | **GET** /api/v1/{tenant}/flows/export/by-query | Export flows as a ZIP archive of yaml sources.
[**flow**](FlowsApi.md#flow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id} | Get a flow
[**flowDependencies**](FlowsApi.md#flowDependencies) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/dependencies | Get flow dependencies
[**flowDependenciesFromNamespace**](FlowsApi.md#flowDependenciesFromNamespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**generateFlowGraph**](FlowsApi.md#generateFlowGraph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow
[**generateFlowGraphFromSource**](FlowsApi.md#generateFlowGraphFromSource) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source
[**importFlows**](FlowsApi.md#importFlows) | **POST** /api/v1/{tenant}/flows/import |     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 
[**listDeprecated**](FlowsApi.md#listDeprecated) | **GET** /api/v1/{tenant}/flows/deprecated | List flows containing deprecated tasks
[**listDistinctNamespaces**](FlowsApi.md#listDistinctNamespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces
[**listFlowRevisions**](FlowsApi.md#listFlowRevisions) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Get revisions for a flow
[**listFlowsByNamespace**](FlowsApi.md#listFlowsByNamespace) | **GET** /api/v1/{tenant}/flows/{namespace} | Retrieve all flows from a given namespace
[**searchConcurrencyLimits**](FlowsApi.md#searchConcurrencyLimits) | **GET** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits
[**searchFlows**](FlowsApi.md#searchFlows) | **GET** /api/v1/{tenant}/flows/search | Search for flows
[**searchFlowsBySourceCode**](FlowsApi.md#searchFlowsBySourceCode) | **GET** /api/v1/{tenant}/flows/source | Search for flows source code
[**taskFromFlow**](FlowsApi.md#taskFromFlow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/tasks/{taskId} | Get a flow task
[**updateConcurrencyLimit**](FlowsApi.md#updateConcurrencyLimit) | **PUT** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit
[**updateFlow**](FlowsApi.md#updateFlow) | **PUT** /api/v1/{tenant}/flows/{namespace}/{id} | Update a flow
[**updateFlowsInNamespace**](FlowsApi.md#updateFlowsInNamespace) | **POST** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from yaml source
[**updateTask**](FlowsApi.md#updateTask) | **PATCH** /api/v1/{tenant}/flows/{namespace}/{id}/{taskId} | Update a single task on a flow
[**validateFlows**](FlowsApi.md#validateFlows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows
[**validateTask**](FlowsApi.md#validateTask) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task
[**validateTrigger**](FlowsApi.md#validateTrigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger



## bulkUpdateFlows

> [FlowInterface] bulkUpdateFlows(tenant, opts)

Update from multiples yaml sources

All flow will be created / updated for this namespace. Flow that already created but not in &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  '_delete': true, // Boolean | If missing flow should be deleted
  'namespace': "namespace_example", // String | The namespace where to update flows
  'allowNamespaceChild': false, // Boolean | If namespace child should are allowed to be updated
  'body': "body_example" // String | A list of flows source code split with \"---\"
};
apiInstance.bulkUpdateFlows(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **_delete** | **Boolean**| If missing flow should be deleted | [optional] [default to true]
 **namespace** | **String**| The namespace where to update flows | [optional] 
 **allowNamespaceChild** | **Boolean**| If namespace child should are allowed to be updated | [optional] [default to false]
 **body** | **String**| A list of flows source code split with \&quot;---\&quot; | [optional] 

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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The flow source code
apiInstance.createFlow(tenant, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
apiInstance.deleteFlow(namespace, id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let idWithNamespace = [new KestraIoKestraSdk.IdWithNamespace()]; // [IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers
apiInstance.deleteFlowsByIds(tenant, idWithNamespace).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

> BulkResponse deleteFlowsByQuery(tenant, opts)

Delete flows returned by the query parameters.

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.deleteFlowsByQuery(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteRevisions

> deleteRevisions(namespace, id, revisions, tenant)

Delete revisions for a flow

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let revisions = [null]; // [Number] | 
let tenant = "tenant_example"; // String | 
apiInstance.deleteRevisions(namespace, id, revisions, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **revisions** | [**[Number]**](Number.md)|  | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## disableFlowsByIds

> BulkResponse disableFlowsByIds(tenant, idWithNamespace)

Disable flows by their IDs.

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let idWithNamespace = [new KestraIoKestraSdk.IdWithNamespace()]; // [IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers
apiInstance.disableFlowsByIds(tenant, idWithNamespace).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

> BulkResponse disableFlowsByQuery(tenant, opts)

Disable flows returned by the query parameters.

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.disableFlowsByQuery(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## enableFlowsByIds

> BulkResponse enableFlowsByIds(tenant, idWithNamespace)

Enable flows by their IDs.

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let idWithNamespace = [new KestraIoKestraSdk.IdWithNamespace()]; // [IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers
apiInstance.enableFlowsByIds(tenant, idWithNamespace).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

> BulkResponse enableFlowsByQuery(tenant, opts)

Enable flows returned by the query parameters.

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.enableFlowsByQuery(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## exportFlowsByIds

> Blob exportFlowsByIds(tenant, idWithNamespace)

Export flows as a ZIP archive of yaml sources.

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let idWithNamespace = [new KestraIoKestraSdk.IdWithNamespace()]; // [IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers
apiInstance.exportFlowsByIds(tenant, idWithNamespace).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.exportFlowsByQuery(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**Blob**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


## flow

> FlowWithSource flow(namespace, id, tenant, opts)

Get a flow

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let opts = {
  'source': false, // Boolean | Include the source code
  'revision': 56, // Number | Get latest revision by default
  'allowDeleted': false // Boolean | Get flow even if deleted
};
apiInstance.flow(namespace, id, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **tenant** | **String**|  | 
 **source** | **Boolean**| Include the source code | [optional] [default to false]
 **revision** | **Number**| Get latest revision by default | [optional] 
 **allowDeleted** | **Boolean**| Get flow even if deleted | [optional] [default to false]

### Return type

[**FlowWithSource**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## flowDependencies

> FlowTopologyGraph flowDependencies(namespace, id, tenant, opts)

Get flow dependencies

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let opts = {
  'destinationOnly': false, // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
  'expandAll': false // Boolean | If true, expand all dependencies recursively
};
apiInstance.flowDependencies(namespace, id, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **tenant** | **String**|  | 
 **destinationOnly** | **Boolean**| If true, list only destination dependencies, otherwise list also source dependencies | [optional] [default to false]
 **expandAll** | **Boolean**| If true, expand all dependencies recursively | [optional] [default to false]

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## flowDependenciesFromNamespace

> FlowTopologyGraph flowDependenciesFromNamespace(namespace, tenant, opts)

Retrieve flow dependencies

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let tenant = "tenant_example"; // String | 
let opts = {
  'destinationOnly': false // Boolean | if true, list only destination dependencies, otherwise list also source dependencies
};
apiInstance.flowDependenciesFromNamespace(namespace, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The flow namespace | 
 **tenant** | **String**|  | 
 **destinationOnly** | **Boolean**| if true, list only destination dependencies, otherwise list also source dependencies | [optional] [default to false]

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## generateFlowGraph

> FlowGraph generateFlowGraph(namespace, id, tenant, opts)

Generate a graph for a flow

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56, // Number | The flow revision
  'subflows': ["null"] // [String] | The subflow tasks to display
};
apiInstance.generateFlowGraph(namespace, id, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The flow source code
let opts = {
  'subflows': ["null"] // [String] | The subflow tasks to display
};
apiInstance.generateFlowGraphFromSource(tenant, body, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## importFlows

> [String] importFlows(tenant, opts)

    Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'failOnError': false, // Boolean | If should fail on invalid flows
  'fileUpload': "/path/to/file" // File | The file to import, can be a ZIP archive or a multi-objects YAML file
};
apiInstance.importFlows(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **failOnError** | **Boolean**| If should fail on invalid flows | [optional] [default to false]
 **fileUpload** | **File**| The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## listDeprecated

> [FlowControllerFlowWithDeprecatedTasks] listDeprecated(tenant, opts)

List flows containing deprecated tasks

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'namespace': "namespace_example" // String | A namespace filter prefix
};
apiInstance.listDeprecated(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **namespace** | **String**| A namespace filter prefix | [optional] 

### Return type

[**[FlowControllerFlowWithDeprecatedTasks]**](FlowControllerFlowWithDeprecatedTasks.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listDistinctNamespaces

> [String] listDistinctNamespaces(tenant, opts)

List all distinct namespaces

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example" // String | A string filter
};
apiInstance.listDistinctNamespaces(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

> [FlowWithSource] listFlowRevisions(namespace, id, tenant, opts)

Get revisions for a flow

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let opts = {
  'allowDelete': false // Boolean | 
};
apiInstance.listFlowRevisions(namespace, id, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **tenant** | **String**|  | 
 **allowDelete** | **Boolean**|  | [optional] [default to false]

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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | Namespace to filter flows
let tenant = "tenant_example"; // String | 
apiInstance.listFlowsByNamespace(namespace, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## searchConcurrencyLimits

> PagedResultsConcurrencyLimit searchConcurrencyLimits(tenant)

Search for flow concurrency limits

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
apiInstance.searchConcurrencyLimits(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 

### Return type

[**PagedResultsConcurrencyLimit**](PagedResultsConcurrencyLimit.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchFlows

> PagedResultsFlow searchFlows(tenant, opts)

Search for flows

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'page': 1, // Number | The current page
  'size': 10, // Number | The current page size
  'sort': ["null"], // [String] | The sort of current page
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.searchFlows(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **page** | **Number**| The current page | [optional] [default to 1]
 **size** | **Number**| The current page size | [optional] [default to 10]
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**PagedResultsFlow**](PagedResultsFlow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchFlowsBySourceCode

> PagedResultsSearchResultFlow searchFlowsBySourceCode(tenant, opts)

Search for flows source code

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'page': 1, // Number | The current page
  'size': 10, // Number | The current page size
  'sort': ["null"], // [String] | The sort of current page
  'q': "q_example", // String | A string filter
  'namespace': "namespace_example" // String | A namespace filter prefix
};
apiInstance.searchFlowsBySourceCode(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **page** | **Number**| The current page | [optional] [default to 1]
 **size** | **Number**| The current page size | [optional] [default to 10]
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


## taskFromFlow

> Task taskFromFlow(namespace, id, taskId, tenant, opts)

Get a flow task

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let taskId = "taskId_example"; // String | The task id
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56 // Number | The flow revision
};
apiInstance.taskFromFlow(namespace, id, taskId, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## updateConcurrencyLimit

> ConcurrencyLimit updateConcurrencyLimit(namespace, flowId, tenant, concurrencyLimit)

Update a flow concurrency limit

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | 
let flowId = "flowId_example"; // String | 
let tenant = "tenant_example"; // String | 
let concurrencyLimit = new KestraIoKestraSdk.ConcurrencyLimit(); // ConcurrencyLimit | 
apiInstance.updateConcurrencyLimit(namespace, flowId, tenant, concurrencyLimit).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**|  | 
 **flowId** | **String**|  | 
 **tenant** | **String**|  | 
 **concurrencyLimit** | [**ConcurrencyLimit**](ConcurrencyLimit.md)|  | 

### Return type

[**ConcurrencyLimit**](ConcurrencyLimit.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateFlow

> FlowWithSource updateFlow(namespace, id, tenant, body)

Update a flow

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The flow source code
apiInstance.updateFlow(namespace, id, tenant, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The flow namespace | 
 **id** | **String**| The flow id | 
 **tenant** | **String**|  | 
 **body** | **String**| The flow source code | 

### Return type

[**FlowWithSource**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## updateFlowsInNamespace

> [FlowInterface] updateFlowsInNamespace(namespace, tenant, body, opts)

Update a complete namespace from yaml source

All flow will be created / updated for this namespace. Flow that already created but not in &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | A list of flows source code
let opts = {
  '_delete': true, // Boolean | If missing flows should be deleted
  'override': false // Boolean | If namespace of all provided flows should be overridden
};
apiInstance.updateFlowsInNamespace(namespace, tenant, body, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The flow namespace | 
 **tenant** | **String**|  | 
 **body** | **String**| A list of flows source code | 
 **_delete** | **Boolean**| If missing flows should be deleted | [optional] [default to true]
 **override** | **Boolean**| If namespace of all provided flows should be overridden | [optional] [default to false]

### Return type

[**[FlowInterface]**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## updateTask

> Flow updateTask(namespace, id, taskId, tenant, task)

Update a single task on a flow

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let taskId = "taskId_example"; // String | The task id
let tenant = "tenant_example"; // String | 
let task = new KestraIoKestraSdk.Task(); // Task | The task
apiInstance.updateTask(namespace, id, taskId, tenant, task).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | Flows as YAML string or multipart files
apiInstance.validateFlows(tenant, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **body** | **String**| Flows as YAML string or multipart files | 

### Return type

[**[ValidateConstraintViolation]**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml, multipart/form-data
- **Accept**: application/json


## validateTask

> ValidateConstraintViolation validateTask(section, tenant, body)

Validate a task

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

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let section = new KestraIoKestraSdk.FlowControllerTaskValidationType(); // FlowControllerTaskValidationType | The type of task
let tenant = "tenant_example"; // String | 
let body = {key: null}; // Object | A task definition that can be from tasks or triggers
apiInstance.validateTask(section, tenant, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **section** | [**FlowControllerTaskValidationType**](.md)| The type of task | 
 **tenant** | **String**|  | 
 **body** | **Object**| A task definition that can be from tasks or triggers | 

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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.FlowsApi();
let tenant = "tenant_example"; // String | 
let body = {key: null}; // Object | The trigger
apiInstance.validateTrigger(tenant, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **body** | **Object**| The trigger | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

