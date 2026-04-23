# KestraIoKestraSdk.FlowsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**flowDependenciesFromNamespace**](FlowsApi.md#flowDependenciesFromNamespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**generateFlowGraph**](FlowsApi.md#generateFlowGraph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow
[**generateFlowGraphFromSource**](FlowsApi.md#generateFlowGraphFromSource) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source
[**listDistinctNamespaces**](FlowsApi.md#listDistinctNamespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces
[**searchConcurrencyLimits**](FlowsApi.md#searchConcurrencyLimits) | **GET** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits
[**updateConcurrencyLimit**](FlowsApi.md#updateConcurrencyLimit) | **PUT** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit
[**updateFlowsInNamespace**](FlowsApi.md#updateFlowsInNamespace) | **POST** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from yaml source
[**validateFlows**](FlowsApi.md#validateFlows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows
[**validateTask**](FlowsApi.md#validateTask) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task
[**validateTrigger**](FlowsApi.md#validateTrigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger



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
  'destinationOnly': new KestraIoKestraSdk.SchemasFromTypeArrayOfParameter() // SchemasFromTypeArrayOfParameter | if true, list only destination dependencies, otherwise list also source dependencies
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
 **destinationOnly** | [**SchemasFromTypeArrayOfParameter**](.md)| if true, list only destination dependencies, otherwise list also source dependencies | [optional] 

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## generateFlowGraph

> FlowGraph generateFlowGraph(id, namespace, tenant, opts)

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
let id = "id_example"; // String | The flow id
let namespace = "namespace_example"; // String | The flow namespace
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': new KestraIoKestraSdk.GenerateFlowGraphRevisionParameter(), // GenerateFlowGraphRevisionParameter | The flow revision
  'subflows': ["null"] // [String] | The subflow tasks to display
};
apiInstance.generateFlowGraph(id, namespace, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The flow id | 
 **namespace** | **String**| The flow namespace | 
 **tenant** | **String**|  | 
 **revision** | [**GenerateFlowGraphRevisionParameter**](.md)| The flow revision | [optional] 
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
  'subflows': new KestraIoKestraSdk.GenerateFlowGraphFromSourceSubflowsParameter() // GenerateFlowGraphFromSourceSubflowsParameter | The subflow tasks to display
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
 **subflows** | [**GenerateFlowGraphFromSourceSubflowsParameter**](.md)| The subflow tasks to display | [optional] 

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
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


## updateFlowsInNamespace

> [FlowInterface] updateFlowsInNamespace(namespace, tenant, opts)

Update a complete namespace from yaml source

All flows will be created / updated for this namespace. Existing flows missing from &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;

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
  'override': new KestraIoKestraSdk.UpdateFlowsInNamespaceOverrideParameter(), // UpdateFlowsInNamespaceOverrideParameter | If namespace of all provided flows should be overridden
  '_delete': true // Boolean | If missing flows should be deleted
};
apiInstance.updateFlowsInNamespace(namespace, tenant, opts).then((data) => {
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
 **override** | [**UpdateFlowsInNamespaceOverrideParameter**](.md)| If namespace of all provided flows should be overridden | [optional] 
 **_delete** | **Boolean**| If missing flows should be deleted | [optional] [default to true]

### Return type

[**[FlowInterface]**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
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

