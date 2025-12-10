# KestraIoKestraSdk.ExecutionsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createExecution**](ExecutionsApi.md#createExecution) | **POST** /api/v1/{tenant}/executions/{namespace}/{id} | Create a new execution for a flow
[**deleteExecution**](ExecutionsApi.md#deleteExecution) | **DELETE** /api/v1/{tenant}/executions/{executionId} | Delete an execution
[**deleteExecutionsByIds**](ExecutionsApi.md#deleteExecutionsByIds) | **DELETE** /api/v1/{tenant}/executions/by-ids | Delete a list of executions
[**deleteExecutionsByQuery**](ExecutionsApi.md#deleteExecutionsByQuery) | **DELETE** /api/v1/{tenant}/executions/by-query | Delete executions filter by query parameters
[**downloadFileFromExecution**](ExecutionsApi.md#downloadFileFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file | Download file for an execution
[**execution**](ExecutionsApi.md#execution) | **GET** /api/v1/{tenant}/executions/{executionId} | Get an execution
[**executionFlowGraph**](ExecutionsApi.md#executionFlowGraph) | **GET** /api/v1/{tenant}/executions/{executionId}/graph | Generate a graph for an execution
[**fileMetadatasFromExecution**](ExecutionsApi.md#fileMetadatasFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/metas | Get file meta information for an execution
[**flowFromExecution**](ExecutionsApi.md#flowFromExecution) | **GET** /api/v1/{tenant}/executions/flows/{namespace}/{flowId} | Get flow information&#39;s for an execution
[**flowFromExecutionById**](ExecutionsApi.md#flowFromExecutionById) | **GET** /api/v1/{tenant}/executions/{executionId}/flow | Get flow information&#39;s for an execution
[**followDependenciesExecutions**](ExecutionsApi.md#followDependenciesExecutions) | **GET** /api/v1/{tenant}/executions/{executionId}/follow-dependencies | Follow all execution dependencies executions
[**followExecution**](ExecutionsApi.md#followExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/follow | Follow an execution
[**forceRunByIds**](ExecutionsApi.md#forceRunByIds) | **POST** /api/v1/{tenant}/executions/force-run/by-ids | Force run a list of executions
[**forceRunExecution**](ExecutionsApi.md#forceRunExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/force-run | Force run an execution
[**forceRunExecutionsByQuery**](ExecutionsApi.md#forceRunExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/force-run/by-query | Force run executions filter by query parameters
[**killExecution**](ExecutionsApi.md#killExecution) | **DELETE** /api/v1/{tenant}/executions/{executionId}/kill | Kill an execution
[**killExecutionsByIds**](ExecutionsApi.md#killExecutionsByIds) | **DELETE** /api/v1/{tenant}/executions/kill/by-ids | Kill a list of executions
[**killExecutionsByQuery**](ExecutionsApi.md#killExecutionsByQuery) | **DELETE** /api/v1/{tenant}/executions/kill/by-query | Kill executions filter by query parameters
[**latestExecutions**](ExecutionsApi.md#latestExecutions) | **POST** /api/v1/{tenant}/executions/latest | Get the latest execution for given flows
[**pauseExecution**](ExecutionsApi.md#pauseExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/pause | Pause a running execution.
[**pauseExecutionsByIds**](ExecutionsApi.md#pauseExecutionsByIds) | **POST** /api/v1/{tenant}/executions/pause/by-ids | Pause a list of running executions
[**pauseExecutionsByQuery**](ExecutionsApi.md#pauseExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/pause/by-query | Pause executions filter by query parameters
[**replayExecution**](ExecutionsApi.md#replayExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/replay | Create a new execution from an old one and start it from a specified task run id
[**replayExecutionWithinputs**](ExecutionsApi.md#replayExecutionWithinputs) | **POST** /api/v1/{tenant}/executions/{executionId}/replay-with-inputs | Create a new execution from an old one and start it from a specified task run id
[**replayExecutionsByIds**](ExecutionsApi.md#replayExecutionsByIds) | **POST** /api/v1/{tenant}/executions/replay/by-ids | Create new executions from old ones. Keep the flow revision
[**replayExecutionsByQuery**](ExecutionsApi.md#replayExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/replay/by-query | Create new executions from old ones filter by query parameters. Keep the flow revision
[**restartExecution**](ExecutionsApi.md#restartExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/restart | Restart a new execution from an old one
[**restartExecutionsByIds**](ExecutionsApi.md#restartExecutionsByIds) | **POST** /api/v1/{tenant}/executions/restart/by-ids | Restart a list of executions
[**restartExecutionsByQuery**](ExecutionsApi.md#restartExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/restart/by-query | Restart executions filter by query parameters
[**resumeExecution**](ExecutionsApi.md#resumeExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/resume | Resume a paused execution.
[**resumeExecutionsByIds**](ExecutionsApi.md#resumeExecutionsByIds) | **POST** /api/v1/{tenant}/executions/resume/by-ids | Resume a list of paused executions
[**resumeExecutionsByQuery**](ExecutionsApi.md#resumeExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/resume/by-query | Resume executions filter by query parameters
[**searchConcurrencyLimits**](ExecutionsApi.md#searchConcurrencyLimits) | **GET** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits
[**searchExecutions**](ExecutionsApi.md#searchExecutions) | **GET** /api/v1/{tenant}/executions/search | Search for executions
[**searchExecutionsByFlowId**](ExecutionsApi.md#searchExecutionsByFlowId) | **GET** /api/v1/{tenant}/executions | Search for executions for a flow
[**setLabelsOnTerminatedExecution**](ExecutionsApi.md#setLabelsOnTerminatedExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/labels | Add or update labels of a terminated execution
[**setLabelsOnTerminatedExecutionsByIds**](ExecutionsApi.md#setLabelsOnTerminatedExecutionsByIds) | **POST** /api/v1/{tenant}/executions/labels/by-ids | Set labels on a list of executions
[**setLabelsOnTerminatedExecutionsByQuery**](ExecutionsApi.md#setLabelsOnTerminatedExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/labels/by-query | Set label on executions filter by query parameters
[**triggerExecutionByGetWebhook**](ExecutionsApi.md#triggerExecutionByGetWebhook) | **GET** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by GET webhook trigger
[**unqueueExecution**](ExecutionsApi.md#unqueueExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/unqueue | Unqueue an execution
[**unqueueExecutionsByIds**](ExecutionsApi.md#unqueueExecutionsByIds) | **POST** /api/v1/{tenant}/executions/unqueue/by-ids | Unqueue a list of executions
[**unqueueExecutionsByQuery**](ExecutionsApi.md#unqueueExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/unqueue/by-query | Unqueue executions filter by query parameters
[**updateConcurrencyLimit**](ExecutionsApi.md#updateConcurrencyLimit) | **PUT** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit
[**updateExecutionStatus**](ExecutionsApi.md#updateExecutionStatus) | **POST** /api/v1/{tenant}/executions/{executionId}/change-status | Change the state of an execution
[**updateExecutionsStatusByIds**](ExecutionsApi.md#updateExecutionsStatusByIds) | **POST** /api/v1/{tenant}/executions/change-status/by-ids | Change executions state by id
[**updateExecutionsStatusByQuery**](ExecutionsApi.md#updateExecutionsStatusByQuery) | **POST** /api/v1/{tenant}/executions/change-status/by-query | Change executions state by query parameters



## createExecution

> ExecutionControllerExecutionResponse createExecution(namespace, id, wait, tenant, opts)

Create a new execution for a flow

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let wait = false; // Boolean | If the server will wait the end of the execution
let tenant = "tenant_example"; // String | 
let opts = {
  'labels': ["null"], // [String] | The labels as a list of 'key:value'
  'revision': 56, // Number | The flow revision or latest if null
  'scheduleDate': new Date("2013-10-20T19:20:30+01:00"), // Date | Schedule the flow on a specific date
  'breakpoints': "breakpoints_example", // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
  'kind': new KestraIoKestraSdk.ExecutionKind() // ExecutionKind | Specific execution kind
};
apiInstance.createExecution(namespace, id, wait, tenant, opts).then((data) => {
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
 **wait** | **Boolean**| If the server will wait the end of the execution | [default to false]
 **tenant** | **String**|  | 
 **labels** | [**[String]**](String.md)| The labels as a list of &#39;key:value&#39; | [optional] 
 **revision** | **Number**| The flow revision or latest if null | [optional] 
 **scheduleDate** | **Date**| Schedule the flow on a specific date | [optional] 
 **breakpoints** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 
 **kind** | [**ExecutionKind**](.md)| Specific execution kind | [optional] 

### Return type

[**ExecutionControllerExecutionResponse**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## deleteExecution

> deleteExecution(executionId, tenant, opts)

Delete an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'deleteLogs': true, // Boolean | Whether to delete execution logs
  'deleteMetrics': true, // Boolean | Whether to delete execution metrics
  'deleteStorage': true // Boolean | Whether to delete execution files in the internal storage
};
apiInstance.deleteExecution(executionId, tenant, opts).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 
 **deleteLogs** | **Boolean**| Whether to delete execution logs | [optional] [default to true]
 **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [optional] [default to true]
 **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [optional] [default to true]

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteExecutionsByIds

> BulkResponse deleteExecutionsByIds(tenant, requestBody, opts)

Delete a list of executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The execution id
let opts = {
  'includeNonTerminated': false, // Boolean | Whether to delete non-terminated executions
  'deleteLogs': true, // Boolean | Whether to delete execution logs
  'deleteMetrics': true, // Boolean | Whether to delete execution metrics
  'deleteStorage': true // Boolean | Whether to delete execution files in the internal storage
};
apiInstance.deleteExecutionsByIds(tenant, requestBody, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The execution id | 
 **includeNonTerminated** | **Boolean**| Whether to delete non-terminated executions | [optional] [default to false]
 **deleteLogs** | **Boolean**| Whether to delete execution logs | [optional] [default to true]
 **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [optional] [default to true]
 **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [optional] [default to true]

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteExecutionsByQuery

> Object deleteExecutionsByQuery(tenant, opts)

Delete executions filter by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()], // [QueryFilter] | Filters
  'includeNonTerminated': false, // Boolean | Whether to delete non-terminated executions
  'deleteLogs': true, // Boolean | Whether to delete execution logs
  'deleteMetrics': true, // Boolean | Whether to delete execution metrics
  'deleteStorage': true // Boolean | Whether to delete execution files in the internal storage
};
apiInstance.deleteExecutionsByQuery(tenant, opts).then((data) => {
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
 **includeNonTerminated** | **Boolean**| Whether to delete non-terminated executions | [optional] [default to false]
 **deleteLogs** | **Boolean**| Whether to delete execution logs | [optional] [default to true]
 **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [optional] [default to true]
 **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [optional] [default to true]

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## downloadFileFromExecution

> File downloadFileFromExecution(executionId, path, tenant)

Download file for an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let path = "path_example"; // String | The internal storage uri
let tenant = "tenant_example"; // String | 
apiInstance.downloadFileFromExecution(executionId, path, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **path** | **String**| The internal storage uri | 
 **tenant** | **String**|  | 

### Return type

**File**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


## execution

> Execution execution(executionId, tenant)

Get an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.execution(executionId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## executionFlowGraph

> FlowGraph executionFlowGraph(executionId, tenant, opts)

Generate a graph for an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'subflows': ["null"] // [String] | The subflow tasks to display
};
apiInstance.executionFlowGraph(executionId, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 
 **subflows** | [**[String]**](String.md)| The subflow tasks to display | [optional] 

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## fileMetadatasFromExecution

> FileMetas fileMetadatasFromExecution(executionId, path, tenant)

Get file meta information for an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let path = "path_example"; // String | The internal storage uri
let tenant = "tenant_example"; // String | 
apiInstance.fileMetadatasFromExecution(executionId, path, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **path** | **String**| The internal storage uri | 
 **tenant** | **String**|  | 

### Return type

[**FileMetas**](FileMetas.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## flowFromExecution

> FlowForExecution flowFromExecution(namespace, flowId, tenant, opts)

Get flow information&#39;s for an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let namespace = "namespace_example"; // String | The namespace of the flow
let flowId = "flowId_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56 // Number | The flow revision
};
apiInstance.flowFromExecution(namespace, flowId, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace of the flow | 
 **flowId** | **String**| The flow id | 
 **tenant** | **String**|  | 
 **revision** | **Number**| The flow revision | [optional] 

### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## flowFromExecutionById

> FlowForExecution flowFromExecutionById(executionId, tenant)

Get flow information&#39;s for an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution that you want flow informations
let tenant = "tenant_example"; // String | 
apiInstance.flowFromExecutionById(executionId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution that you want flow informations | 
 **tenant** | **String**|  | 

### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## followDependenciesExecutions

> EventExecutionStatusEvent followDependenciesExecutions(executionId, destinationOnly, expandAll, tenant)

Follow all execution dependencies executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let destinationOnly = false; // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
let expandAll = false; // Boolean | If true, expand all dependencies recursively
let tenant = "tenant_example"; // String | 
apiInstance.followDependenciesExecutions(executionId, destinationOnly, expandAll, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **destinationOnly** | **Boolean**| If true, list only destination dependencies, otherwise list also source dependencies | [default to false]
 **expandAll** | **Boolean**| If true, expand all dependencies recursively | [default to false]
 **tenant** | **String**|  | 

### Return type

[**EventExecutionStatusEvent**](EventExecutionStatusEvent.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream


## followExecution

> EventExecution followExecution(executionId, tenant)

Follow an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.followExecution(executionId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 

### Return type

[**EventExecution**](EventExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream


## forceRunByIds

> BulkResponse forceRunByIds(tenant, requestBody)

Force run a list of executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.forceRunByIds(tenant, requestBody).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## forceRunExecution

> Execution forceRunExecution(executionId, tenant)

Force run an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.forceRunExecution(executionId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## forceRunExecutionsByQuery

> Object forceRunExecutionsByQuery(tenant, opts)

Force run executions filter by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.forceRunExecutionsByQuery(tenant, opts).then((data) => {
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## killExecution

> Object killExecution(executionId, isOnKillCascade, tenant)

Kill an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let isOnKillCascade = true; // Boolean | Specifies whether killing the execution also kill all subflow executions.
let tenant = "tenant_example"; // String | 
apiInstance.killExecution(executionId, isOnKillCascade, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **isOnKillCascade** | **Boolean**| Specifies whether killing the execution also kill all subflow executions. | [default to true]
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/json


## killExecutionsByIds

> BulkResponse killExecutionsByIds(tenant, requestBody)

Kill a list of executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.killExecutionsByIds(tenant, requestBody).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## killExecutionsByQuery

> Object killExecutionsByQuery(tenant, opts)

Kill executions filter by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.killExecutionsByQuery(tenant, opts).then((data) => {
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## latestExecutions

> [ExecutionControllerLastExecutionResponse] latestExecutions(tenant, executionRepositoryInterfaceFlowFilter)

Get the latest execution for given flows

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let executionRepositoryInterfaceFlowFilter = [new KestraIoKestraSdk.ExecutionRepositoryInterfaceFlowFilter()]; // [ExecutionRepositoryInterfaceFlowFilter] | 
apiInstance.latestExecutions(tenant, executionRepositoryInterfaceFlowFilter).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **executionRepositoryInterfaceFlowFilter** | [**[ExecutionRepositoryInterfaceFlowFilter]**](ExecutionRepositoryInterfaceFlowFilter.md)|  | 

### Return type

[**[ExecutionControllerLastExecutionResponse]**](ExecutionControllerLastExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## pauseExecution

> pauseExecution(executionId, tenant)

Pause a running execution.

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.pauseExecution(executionId, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## pauseExecutionsByIds

> BulkResponse pauseExecutionsByIds(tenant, requestBody)

Pause a list of running executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.pauseExecutionsByIds(tenant, requestBody).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## pauseExecutionsByQuery

> Object pauseExecutionsByQuery(tenant, opts)

Pause executions filter by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.pauseExecutionsByQuery(tenant, opts).then((data) => {
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## replayExecution

> Execution replayExecution(executionId, tenant, opts)

Create a new execution from an old one and start it from a specified task run id

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | the original execution id to clone
let tenant = "tenant_example"; // String | 
let opts = {
  'taskRunId': "taskRunId_example", // String | The taskrun id
  'revision': 56, // Number | The flow revision to use for new execution
  'breakpoints': "breakpoints_example" // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
};
apiInstance.replayExecution(executionId, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| the original execution id to clone | 
 **tenant** | **String**|  | 
 **taskRunId** | **String**| The taskrun id | [optional] 
 **revision** | **Number**| The flow revision to use for new execution | [optional] 
 **breakpoints** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## replayExecutionWithinputs

> Execution replayExecutionWithinputs(executionId, tenant, opts)

Create a new execution from an old one and start it from a specified task run id

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | the original execution id to clone
let tenant = "tenant_example"; // String | 
let opts = {
  'taskRunId': "taskRunId_example", // String | The taskrun id
  'revision': 56, // Number | The flow revision to use for new execution
  'breakpoints': "breakpoints_example" // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
};
apiInstance.replayExecutionWithinputs(executionId, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| the original execution id to clone | 
 **tenant** | **String**|  | 
 **taskRunId** | **String**| The taskrun id | [optional] 
 **revision** | **Number**| The flow revision to use for new execution | [optional] 
 **breakpoints** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## replayExecutionsByIds

> BulkResponse replayExecutionsByIds(tenant, requestBody, opts)

Create new executions from old ones. Keep the flow revision

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
let opts = {
  'latestRevision': false // Boolean | If latest revision should be used
};
apiInstance.replayExecutionsByIds(tenant, requestBody, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The list of executions id | 
 **latestRevision** | **Boolean**| If latest revision should be used | [optional] [default to false]

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## replayExecutionsByQuery

> Object replayExecutionsByQuery(tenant, opts)

Create new executions from old ones filter by query parameters. Keep the flow revision

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()], // [QueryFilter] | Filters
  'latestRevision': false // Boolean | If latest revision should be used
};
apiInstance.replayExecutionsByQuery(tenant, opts).then((data) => {
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
 **latestRevision** | **Boolean**| If latest revision should be used | [optional] [default to false]

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## restartExecution

> Execution restartExecution(executionId, tenant, opts)

Restart a new execution from an old one

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56 // Number | The flow revision to use for new execution
};
apiInstance.restartExecution(executionId, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 
 **revision** | **Number**| The flow revision to use for new execution | [optional] 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## restartExecutionsByIds

> BulkResponse restartExecutionsByIds(tenant, requestBody)

Restart a list of executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.restartExecutionsByIds(tenant, requestBody).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## restartExecutionsByQuery

> Object restartExecutionsByQuery(tenant, opts)

Restart executions filter by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.restartExecutionsByQuery(tenant, opts).then((data) => {
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## resumeExecution

> Object resumeExecution(executionId, tenant)

Resume a paused execution.

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.resumeExecution(executionId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## resumeExecutionsByIds

> BulkResponse resumeExecutionsByIds(tenant, requestBody)

Resume a list of paused executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.resumeExecutionsByIds(tenant, requestBody).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## resumeExecutionsByQuery

> Object resumeExecutionsByQuery(tenant, opts)

Resume executions filter by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.resumeExecutionsByQuery(tenant, opts).then((data) => {
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

**Object**

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
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


## searchExecutions

> PagedResultsExecution searchExecutions(page, size, tenant, opts)

Search for executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.searchExecutions(page, size, tenant, opts).then((data) => {
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
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**PagedResultsExecution**](PagedResultsExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchExecutionsByFlowId

> PagedResultsExecution searchExecutionsByFlowId(namespace, flowId, page, size, tenant)

Search for executions for a flow

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let flowId = "flowId_example"; // String | The flow id
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
apiInstance.searchExecutionsByFlowId(namespace, flowId, page, size, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The flow namespace | 
 **flowId** | **String**| The flow id | 
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **tenant** | **String**|  | 

### Return type

[**PagedResultsExecution**](PagedResultsExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## setLabelsOnTerminatedExecution

> Object setLabelsOnTerminatedExecution(executionId, tenant, label)

Add or update labels of a terminated execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let label = [new KestraIoKestraSdk.Label()]; // [Label] | The labels to add to the execution
apiInstance.setLabelsOnTerminatedExecution(executionId, tenant, label).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 
 **label** | [**[Label]**](Label.md)| The labels to add to the execution | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## setLabelsOnTerminatedExecutionsByIds

> BulkResponse setLabelsOnTerminatedExecutionsByIds(tenant, executionControllerSetLabelsByIdsRequest)

Set labels on a list of executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let executionControllerSetLabelsByIdsRequest = new KestraIoKestraSdk.ExecutionControllerSetLabelsByIdsRequest(); // ExecutionControllerSetLabelsByIdsRequest | The request containing a list of labels and a list of executions
apiInstance.setLabelsOnTerminatedExecutionsByIds(tenant, executionControllerSetLabelsByIdsRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **executionControllerSetLabelsByIdsRequest** | [**ExecutionControllerSetLabelsByIdsRequest**](ExecutionControllerSetLabelsByIdsRequest.md)| The request containing a list of labels and a list of executions | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## setLabelsOnTerminatedExecutionsByQuery

> Object setLabelsOnTerminatedExecutionsByQuery(tenant, label, opts)

Set label on executions filter by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let label = [new KestraIoKestraSdk.Label()]; // [Label] | The labels to add to the execution
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.setLabelsOnTerminatedExecutionsByQuery(tenant, label, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **label** | [**[Label]**](Label.md)| The labels to add to the execution | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## triggerExecutionByGetWebhook

> ExecutionControllerWebhookResponse triggerExecutionByGetWebhook(namespace, id, key, tenant)

Trigger a new execution by GET webhook trigger

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let key = "key_example"; // String | The webhook trigger uid
let tenant = "tenant_example"; // String | 
apiInstance.triggerExecutionByGetWebhook(namespace, id, key, tenant).then((data) => {
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
 **key** | **String**| The webhook trigger uid | 
 **tenant** | **String**|  | 

### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## unqueueExecution

> Execution unqueueExecution(executionId, state, tenant)

Unqueue an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let state = new KestraIoKestraSdk.StateType(); // StateType | The new state of the execution
let tenant = "tenant_example"; // String | 
apiInstance.unqueueExecution(executionId, state, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **state** | [**StateType**](.md)| The new state of the execution | 
 **tenant** | **String**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## unqueueExecutionsByIds

> BulkResponse unqueueExecutionsByIds(state, tenant, requestBody)

Unqueue a list of executions

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let state = new KestraIoKestraSdk.StateType(); // StateType | The new state of the unqueued executions
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.unqueueExecutionsByIds(state, tenant, requestBody).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **state** | [**StateType**](.md)| The new state of the unqueued executions | 
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## unqueueExecutionsByQuery

> Object unqueueExecutionsByQuery(tenant, opts)

Unqueue executions filter by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()], // [QueryFilter] | Filters
  'newState': new KestraIoKestraSdk.StateType() // StateType | The new state of the unqueued executions
};
apiInstance.unqueueExecutionsByQuery(tenant, opts).then((data) => {
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
 **newState** | [**StateType**](.md)| The new state of the unqueued executions | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateConcurrencyLimit

> ConcurrencyLimit updateConcurrencyLimit(flowId, namespace, tenant, concurrencyLimit)

Update a flow concurrency limit

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let flowId = "flowId_example"; // String | 
let namespace = "namespace_example"; // String | 
let tenant = "tenant_example"; // String | 
let concurrencyLimit = new KestraIoKestraSdk.ConcurrencyLimit(); // ConcurrencyLimit | 
apiInstance.updateConcurrencyLimit(flowId, namespace, tenant, concurrencyLimit).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **flowId** | **String**|  | 
 **namespace** | **String**|  | 
 **tenant** | **String**|  | 
 **concurrencyLimit** | [**ConcurrencyLimit**](ConcurrencyLimit.md)|  | 

### Return type

[**ConcurrencyLimit**](ConcurrencyLimit.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateExecutionStatus

> Execution updateExecutionStatus(executionId, status, tenant)

Change the state of an execution

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let status = new KestraIoKestraSdk.StateType(); // StateType | The new state of the execution
let tenant = "tenant_example"; // String | 
apiInstance.updateExecutionStatus(executionId, status, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executionId** | **String**| The execution id | 
 **status** | [**StateType**](.md)| The new state of the execution | 
 **tenant** | **String**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateExecutionsStatusByIds

> BulkResponse updateExecutionsStatusByIds(newStatus, tenant, requestBody)

Change executions state by id

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let newStatus = new KestraIoKestraSdk.StateType(); // StateType | The new state of the executions
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.updateExecutionsStatusByIds(newStatus, tenant, requestBody).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newStatus** | [**StateType**](.md)| The new state of the executions | 
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateExecutionsStatusByQuery

> BulkResponse updateExecutionsStatusByQuery(newStatus, tenant, opts)

Change executions state by query parameters

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

let apiInstance = new KestraIoKestraSdk.ExecutionsApi();
let newStatus = new KestraIoKestraSdk.StateType(); // StateType | The new state of the executions
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.updateExecutionsStatusByQuery(newStatus, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newStatus** | [**StateType**](.md)| The new state of the executions | 
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

