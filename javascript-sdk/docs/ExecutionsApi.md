# KestraIoKestraApi.ExecutionsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createExecution**](ExecutionsApi.md#createExecution) | **POST** /api/v1/{tenant}/executions/{namespace}/{id} | Create a new execution for a flow
[**deleteExecution**](ExecutionsApi.md#deleteExecution) | **DELETE** /api/v1/{tenant}/executions/{executionId} | Delete an execution
[**deleteExecutionsByIds**](ExecutionsApi.md#deleteExecutionsByIds) | **DELETE** /api/v1/{tenant}/executions/by-ids | Delete a list of executions
[**deleteExecutionsByQuery**](ExecutionsApi.md#deleteExecutionsByQuery) | **DELETE** /api/v1/{tenant}/executions/by-query | Delete executions filter by query parameters
[**downloadFileFromExecution**](ExecutionsApi.md#downloadFileFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file | Download file for an execution
[**evalTaskRunExpression**](ExecutionsApi.md#evalTaskRunExpression) | **POST** /api/v1/{tenant}/executions/{executionId}/eval/{taskRunId} | Evaluate a variable expression for this taskrun
[**followDependenciesExecutions**](ExecutionsApi.md#followDependenciesExecutions) | **GET** /api/v1/{tenant}/executions/{executionId}/follow-dependencies | Follow all execution dependencies executions
[**followExecution**](ExecutionsApi.md#followExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/follow | Follow an execution
[**forceRunByIds**](ExecutionsApi.md#forceRunByIds) | **POST** /api/v1/{tenant}/executions/force-run/by-ids | Force run a list of executions
[**forceRunExecution**](ExecutionsApi.md#forceRunExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/force-run | Force run an execution
[**forceRunExecutionsByQuery**](ExecutionsApi.md#forceRunExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/force-run/by-query | Force run executions filter by query parameters
[**getExecution**](ExecutionsApi.md#getExecution) | **GET** /api/v1/{tenant}/executions/{executionId} | Get an execution
[**getExecutionFlowGraph**](ExecutionsApi.md#getExecutionFlowGraph) | **GET** /api/v1/{tenant}/executions/{executionId}/graph | Generate a graph for an execution
[**getFileMetadatasFromExecution**](ExecutionsApi.md#getFileMetadatasFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/metas | Get file meta information for an execution
[**getFlowFromExecution**](ExecutionsApi.md#getFlowFromExecution) | **GET** /api/v1/{tenant}/executions/flows/{namespace}/{flowId} | Get flow information&#39;s for an execution
[**getFlowFromExecutionById**](ExecutionsApi.md#getFlowFromExecutionById) | **GET** /api/v1/{tenant}/executions/{executionId}/flow | Get flow information&#39;s for an execution
[**getLatestExecutions**](ExecutionsApi.md#getLatestExecutions) | **POST** /api/v1/{tenant}/executions/latest | Get the latest execution for given flows
[**killExecution**](ExecutionsApi.md#killExecution) | **DELETE** /api/v1/{tenant}/executions/{executionId}/kill | Kill an execution
[**killExecutionsByIds**](ExecutionsApi.md#killExecutionsByIds) | **DELETE** /api/v1/{tenant}/executions/kill/by-ids | Kill a list of executions
[**killExecutionsByQuery**](ExecutionsApi.md#killExecutionsByQuery) | **DELETE** /api/v1/{tenant}/executions/kill/by-query | Kill executions filter by query parameters
[**listExecutableDistinctNamespaces**](ExecutionsApi.md#listExecutableDistinctNamespaces) | **GET** /api/v1/{tenant}/executions/namespaces | Get all namespaces that have executable flows
[**listFlowExecutionsByNamespace**](ExecutionsApi.md#listFlowExecutionsByNamespace) | **GET** /api/v1/{tenant}/executions/namespaces/{namespace}/flows | Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.
[**pauseExecution**](ExecutionsApi.md#pauseExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/pause | Pause a running execution.
[**pauseExecutionsByIds**](ExecutionsApi.md#pauseExecutionsByIds) | **POST** /api/v1/{tenant}/executions/pause/by-ids | Pause a list of running executions
[**pauseExecutionsByQuery**](ExecutionsApi.md#pauseExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/pause/by-query | Pause executions filter by query parameters
[**previewFileFromExecution**](ExecutionsApi.md#previewFileFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/preview | Get file preview for an execution
[**replayExecution**](ExecutionsApi.md#replayExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/replay | Create a new execution from an old one and start it from a specified task run id
[**replayExecutionsByIds**](ExecutionsApi.md#replayExecutionsByIds) | **POST** /api/v1/{tenant}/executions/replay/by-ids | Create new executions from old ones. Keep the flow revision
[**replayExecutionsByQuery**](ExecutionsApi.md#replayExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/replay/by-query | Create new executions from old ones filter by query parameters. Keep the flow revision
[**restartExecution**](ExecutionsApi.md#restartExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/restart | Restart a new execution from an old one
[**restartExecutionsByIds**](ExecutionsApi.md#restartExecutionsByIds) | **POST** /api/v1/{tenant}/executions/restart/by-ids | Restart a list of executions
[**restartExecutionsByQuery**](ExecutionsApi.md#restartExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/restart/by-query | Restart executions filter by query parameters
[**resumeExecution**](ExecutionsApi.md#resumeExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/resume | Resume a paused execution.
[**resumeExecutionFromBreakpoint**](ExecutionsApi.md#resumeExecutionFromBreakpoint) | **POST** /api/v1/{tenant}/executions/{executionId}/resume-from-breakpoint | Resume an execution from a breakpoint (in the &#39;BREAKPOINT&#39; state).
[**resumeExecutionsByIds**](ExecutionsApi.md#resumeExecutionsByIds) | **POST** /api/v1/{tenant}/executions/resume/by-ids | Resume a list of paused executions
[**resumeExecutionsByQuery**](ExecutionsApi.md#resumeExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/resume/by-query | Resume executions filter by query parameters
[**searchExecutions**](ExecutionsApi.md#searchExecutions) | **GET** /api/v1/{tenant}/executions/search | Search for executions
[**searchExecutionsByFlowId**](ExecutionsApi.md#searchExecutionsByFlowId) | **GET** /api/v1/{tenant}/executions | Search for executions for a flow
[**searchTaskRun**](ExecutionsApi.md#searchTaskRun) | **GET** /api/v1/{tenant}/taskruns/search | Search for taskruns, only available with the Elasticsearch repository
[**setLabelsOnTerminatedExecution**](ExecutionsApi.md#setLabelsOnTerminatedExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/labels | Add or update labels of a terminated execution
[**setLabelsOnTerminatedExecutionsByIds**](ExecutionsApi.md#setLabelsOnTerminatedExecutionsByIds) | **POST** /api/v1/{tenant}/executions/labels/by-ids | Set labels on a list of executions
[**setLabelsOnTerminatedExecutionsByQuery**](ExecutionsApi.md#setLabelsOnTerminatedExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/labels/by-query | Set label on executions filter by query parameters
[**triggerExecution**](ExecutionsApi.md#triggerExecution) | **POST** /api/v1/{tenant}/executions/trigger/{namespace}/{id} | Trigger a new execution for a flow
[**triggerExecutionByGetWebhook**](ExecutionsApi.md#triggerExecutionByGetWebhook) | **GET** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by GET webhook trigger
[**triggerExecutionByPostWebhook**](ExecutionsApi.md#triggerExecutionByPostWebhook) | **POST** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by POST webhook trigger
[**triggerExecutionByPutWebhook**](ExecutionsApi.md#triggerExecutionByPutWebhook) | **PUT** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by PUT webhook trigger
[**unqueueExecution**](ExecutionsApi.md#unqueueExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/unqueue | Unqueue an execution
[**unqueueExecutionsByIds**](ExecutionsApi.md#unqueueExecutionsByIds) | **POST** /api/v1/{tenant}/executions/unqueue/by-ids | Unqueue a list of executions
[**unqueueExecutionsByQuery**](ExecutionsApi.md#unqueueExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/unqueue/by-query | Unqueue executions filter by query parameters
[**updateExecutionStatus**](ExecutionsApi.md#updateExecutionStatus) | **POST** /api/v1/{tenant}/executions/{executionId}/change-status | Change the state of an execution
[**updateExecutionsStatusByIds**](ExecutionsApi.md#updateExecutionsStatusByIds) | **POST** /api/v1/{tenant}/executions/change-status/by-ids | Change executions state by id
[**updateExecutionsStatusByQuery**](ExecutionsApi.md#updateExecutionsStatusByQuery) | **POST** /api/v1/{tenant}/executions/change-status/by-query | Change executions state by query parameters
[**updateTaskRunState**](ExecutionsApi.md#updateTaskRunState) | **POST** /api/v1/{tenant}/executions/{executionId}/state | Change state for a taskrun in an execution
[**validateNewExecutionInputs**](ExecutionsApi.md#validateNewExecutionInputs) | **POST** /api/v1/{tenant}/executions/{namespace}/{id}/validate | Validate the creation of a new execution for a flow
[**validateResumeExecutionInputs**](ExecutionsApi.md#validateResumeExecutionInputs) | **POST** /api/v1/{tenant}/executions/{executionId}/resume/validate | Validate inputs to resume a paused execution.



## createExecution

> [ExecutionControllerExecutionResponse] createExecution(namespace, id, wait, tenant, opts)

Create a new execution for a flow

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let wait = false; // Boolean | If the server will wait the end of the execution
let tenant = "tenant_example"; // String | 
let opts = {
  'labels': ["null"], // [String] | The labels as a list of 'key:value'
  'revision': 56, // Number | The flow revision or latest if null
  'scheduleDate': new Date("2013-10-20T19:20:30+01:00"), // Date | Schedule the flow on a specific date
  'breakpoint': "breakpoint_example", // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
  'kind': new KestraIoKestraApi.ExecutionKind() // ExecutionKind | Specific execution kind
};
apiInstance.createExecution(namespace, id, wait, tenant, opts, (error, data, response) => {
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
 **wait** | **Boolean**| If the server will wait the end of the execution | [default to false]
 **tenant** | **String**|  | 
 **labels** | [**[String]**](String.md)| The labels as a list of &#39;key:value&#39; | [optional] 
 **revision** | **Number**| The flow revision or latest if null | [optional] 
 **scheduleDate** | **Date**| Schedule the flow on a specific date | [optional] 
 **breakpoint** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 
 **kind** | [**ExecutionKind**](.md)| Specific execution kind | [optional] 

### Return type

[**[ExecutionControllerExecutionResponse]**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## deleteExecution

> deleteExecution(executionId, deleteLogs, deleteMetrics, deleteStorage, tenant)

Delete an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let deleteLogs = true; // Boolean | Whether to delete execution logs
let deleteMetrics = true; // Boolean | Whether to delete execution metrics
let deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
let tenant = "tenant_example"; // String | 
apiInstance.deleteExecution(executionId, deleteLogs, deleteMetrics, deleteStorage, tenant, (error, data, response) => {
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
 **executionId** | **String**| The execution id | 
 **deleteLogs** | **Boolean**| Whether to delete execution logs | [default to true]
 **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [default to true]
 **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [default to true]
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteExecutionsByIds

> BulkResponse deleteExecutionsByIds(deleteLogs, deleteMetrics, deleteStorage, tenant, requestBody, opts)

Delete a list of executions

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let deleteLogs = true; // Boolean | Whether to delete execution logs
let deleteMetrics = true; // Boolean | Whether to delete execution metrics
let deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The execution id
let opts = {
  'includeNonTerminated': false // Boolean | Whether to delete non-terminated executions
};
apiInstance.deleteExecutionsByIds(deleteLogs, deleteMetrics, deleteStorage, tenant, requestBody, opts, (error, data, response) => {
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
 **deleteLogs** | **Boolean**| Whether to delete execution logs | [default to true]
 **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [default to true]
 **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [default to true]
 **tenant** | **String**|  | 
 **requestBody** | [**[String]**](String.md)| The execution id | 
 **includeNonTerminated** | **Boolean**| Whether to delete non-terminated executions | [optional] [default to false]

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteExecutionsByQuery

> Object deleteExecutionsByQuery(deleteLogs, deleteMetrics, deleteStorage, tenant, deleteExecutionsByQueryRequest, opts)

Delete executions filter by query parameters

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let deleteLogs = true; // Boolean | Whether to delete execution logs
let deleteMetrics = true; // Boolean | Whether to delete execution metrics
let deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter(), // ExecutionRepositoryInterfaceChildFilter | A execution child filter
  'includeNonTerminated': false // Boolean | Whether to delete non-terminated executions
};
apiInstance.deleteExecutionsByQuery(deleteLogs, deleteMetrics, deleteStorage, tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **deleteLogs** | **Boolean**| Whether to delete execution logs | [default to true]
 **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [default to true]
 **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [default to true]
 **tenant** | **String**|  | 
 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **String**| A string filter | [optional] 
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 
 **includeNonTerminated** | **Boolean**| Whether to delete non-terminated executions | [optional] [default to false]

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## downloadFileFromExecution

> File downloadFileFromExecution(executionId, path, tenant)

Download file for an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let path = "path_example"; // String | The internal storage uri
let tenant = "tenant_example"; // String | 
apiInstance.downloadFileFromExecution(executionId, path, tenant, (error, data, response) => {
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


## evalTaskRunExpression

> ExecutionControllerEvalResult evalTaskRunExpression(executionId, taskRunId, tenant, body)

Evaluate a variable expression for this taskrun

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let taskRunId = "taskRunId_example"; // String | The taskrun id
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The Pebble expression that should be evaluated
apiInstance.evalTaskRunExpression(executionId, taskRunId, tenant, body, (error, data, response) => {
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
 **executionId** | **String**| The execution id | 
 **taskRunId** | **String**| The taskrun id | 
 **tenant** | **String**|  | 
 **body** | **String**| The Pebble expression that should be evaluated | 

### Return type

[**ExecutionControllerEvalResult**](ExecutionControllerEvalResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: application/json


## followDependenciesExecutions

> EventExecutionStatusEvent followDependenciesExecutions(executionId, destinationOnly, expandAll, tenant)

Follow all execution dependencies executions

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let destinationOnly = false; // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
let expandAll = false; // Boolean | If true, expand all dependencies recursively
let tenant = "tenant_example"; // String | 
apiInstance.followDependenciesExecutions(executionId, destinationOnly, expandAll, tenant, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.followExecution(executionId, tenant, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.forceRunByIds(tenant, requestBody, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.forceRunExecution(executionId, tenant, (error, data, response) => {
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

> Object forceRunExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Force run executions filter by query parameters

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.forceRunExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## getExecution

> Execution getExecution(executionId, tenant)

Get an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.getExecution(executionId, tenant, (error, data, response) => {
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
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getExecutionFlowGraph

> FlowGraph getExecutionFlowGraph(executionId, tenant, opts)

Generate a graph for an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'subflows': ["null"] // [String] | The subflow tasks to display
};
apiInstance.getExecutionFlowGraph(executionId, tenant, opts, (error, data, response) => {
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


## getFileMetadatasFromExecution

> FileMetas getFileMetadatasFromExecution(executionId, path, tenant)

Get file meta information for an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let path = "path_example"; // String | The internal storage uri
let tenant = "tenant_example"; // String | 
apiInstance.getFileMetadatasFromExecution(executionId, path, tenant, (error, data, response) => {
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


## getFlowFromExecution

> FlowForExecution getFlowFromExecution(namespace, flowId, tenant, opts)

Get flow information&#39;s for an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The namespace of the flow
let flowId = "flowId_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56 // Number | The flow revision
};
apiInstance.getFlowFromExecution(namespace, flowId, tenant, opts, (error, data, response) => {
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


## getFlowFromExecutionById

> FlowForExecution getFlowFromExecutionById(executionId, tenant)

Get flow information&#39;s for an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution that you want flow information's
let tenant = "tenant_example"; // String | 
apiInstance.getFlowFromExecutionById(executionId, tenant, (error, data, response) => {
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
 **executionId** | **String**| The execution that you want flow information&#39;s | 
 **tenant** | **String**|  | 

### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getLatestExecutions

> [ExecutionControllerLastExecutionResponse] getLatestExecutions(tenant, executionRepositoryInterfaceFlowFilter)

Get the latest execution for given flows

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let executionRepositoryInterfaceFlowFilter = [new KestraIoKestraApi.ExecutionRepositoryInterfaceFlowFilter()]; // [ExecutionRepositoryInterfaceFlowFilter] | 
apiInstance.getLatestExecutions(tenant, executionRepositoryInterfaceFlowFilter, (error, data, response) => {
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
 **executionRepositoryInterfaceFlowFilter** | [**[ExecutionRepositoryInterfaceFlowFilter]**](ExecutionRepositoryInterfaceFlowFilter.md)|  | 

### Return type

[**[ExecutionControllerLastExecutionResponse]**](ExecutionControllerLastExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## killExecution

> Object killExecution(executionId, isOnKillCascade, tenant)

Kill an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let isOnKillCascade = true; // Boolean | Specifies whether killing the execution also kill all subflow executions.
let tenant = "tenant_example"; // String | 
apiInstance.killExecution(executionId, isOnKillCascade, tenant, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.killExecutionsByIds(tenant, requestBody, (error, data, response) => {
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
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## killExecutionsByQuery

> Object killExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Kill executions filter by query parameters

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.killExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## listExecutableDistinctNamespaces

> [String] listExecutableDistinctNamespaces(tenant)

Get all namespaces that have executable flows

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
apiInstance.listExecutableDistinctNamespaces(tenant, (error, data, response) => {
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

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listFlowExecutionsByNamespace

> [FlowForExecution] listFlowExecutionsByNamespace(namespace, tenant)

Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The namespace
let tenant = "tenant_example"; // String | 
apiInstance.listFlowExecutionsByNamespace(namespace, tenant, (error, data, response) => {
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
 **namespace** | **String**| The namespace | 
 **tenant** | **String**|  | 

### Return type

[**[FlowForExecution]**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## pauseExecution

> pauseExecution(executionId, tenant)

Pause a running execution.

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.pauseExecution(executionId, tenant, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.pauseExecutionsByIds(tenant, requestBody, (error, data, response) => {
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
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## pauseExecutionsByQuery

> Object pauseExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Pause executions filter by query parameters

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.pauseExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## previewFileFromExecution

> Object previewFileFromExecution(executionId, path, maxRows, encoding, tenant)

Get file preview for an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let path = "path_example"; // String | The internal storage uri
let maxRows = 56; // Number | The max row returns
let encoding = "ISO-8859-1"; // String | The file encoding as Java charset name. Defaults to UTF-8
let tenant = "tenant_example"; // String | 
apiInstance.previewFileFromExecution(executionId, path, maxRows, encoding, tenant, (error, data, response) => {
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
 **executionId** | **String**| The execution id | 
 **path** | **String**| The internal storage uri | 
 **maxRows** | **Number**| The max row returns | 
 **encoding** | **String**| The file encoding as Java charset name. Defaults to UTF-8 | [default to &#39;UTF-8&#39;]
 **tenant** | **String**|  | 

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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | the original execution id to clone
let tenant = "tenant_example"; // String | 
let opts = {
  'taskRunId': "taskRunId_example", // String | The taskrun id
  'revision': 56, // Number | The flow revision to use for new execution
  'breakpoint': "breakpoint_example" // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
};
apiInstance.replayExecution(executionId, tenant, opts, (error, data, response) => {
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
 **executionId** | **String**| the original execution id to clone | 
 **tenant** | **String**|  | 
 **taskRunId** | **String**| The taskrun id | [optional] 
 **revision** | **Number**| The flow revision to use for new execution | [optional] 
 **breakpoint** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## replayExecutionsByIds

> BulkResponse replayExecutionsByIds(tenant, requestBody, opts)

Create new executions from old ones. Keep the flow revision

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
let opts = {
  'latestRevision': false // Boolean | If latest revision should be used
};
apiInstance.replayExecutionsByIds(tenant, requestBody, opts, (error, data, response) => {
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

> Object replayExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Create new executions from old ones filter by query parameters. Keep the flow revision

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter(), // ExecutionRepositoryInterfaceChildFilter | A execution child filter
  'latestRevision': false // Boolean | If latest revision should be used
};
apiInstance.replayExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 
 **latestRevision** | **Boolean**| If latest revision should be used | [optional] [default to false]

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## restartExecution

> Execution restartExecution(executionId, tenant, opts)

Restart a new execution from an old one

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56 // Number | The flow revision to use for new execution
};
apiInstance.restartExecution(executionId, tenant, opts, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.restartExecutionsByIds(tenant, requestBody, (error, data, response) => {
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
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## restartExecutionsByQuery

> Object restartExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Restart executions filter by query parameters

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.restartExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## resumeExecution

> Object resumeExecution(executionId, tenant)

Resume a paused execution.

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.resumeExecution(executionId, tenant, (error, data, response) => {
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
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## resumeExecutionFromBreakpoint

> resumeExecutionFromBreakpoint(executionId, tenant, opts)

Resume an execution from a breakpoint (in the &#39;BREAKPOINT&#39; state).

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'breakpoint': "breakpoint_example" // String | \"Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
};
apiInstance.resumeExecutionFromBreakpoint(executionId, tenant, opts, (error, data, response) => {
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
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 
 **breakpoint** | **String**| \&quot;Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## resumeExecutionsByIds

> BulkResponse resumeExecutionsByIds(tenant, requestBody)

Resume a list of paused executions

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.resumeExecutionsByIds(tenant, requestBody, (error, data, response) => {
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
 **requestBody** | [**[String]**](String.md)| The list of executions id | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## resumeExecutionsByQuery

> Object resumeExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Resume executions filter by query parameters

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.resumeExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## searchExecutions

> PagedResultsExecution searchExecutions(page, size, tenant, opts)

Search for executions

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'filters': [new KestraIoKestraApi.QueryFilter()], // [QueryFilter] | Filters
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.searchExecutions(page, size, tenant, opts, (error, data, response) => {
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
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let flowId = "flowId_example"; // String | The flow id
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
apiInstance.searchExecutionsByFlowId(namespace, flowId, page, size, tenant, (error, data, response) => {
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


## searchTaskRun

> PagedResultsTaskRun searchTaskRun(page, size, tenant, opts)

Search for taskruns, only available with the Elasticsearch repository

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'filters': [new KestraIoKestraApi.QueryFilter()], // [QueryFilter] | Filters
  'q': "q_example", // String | A string filter
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.searchTaskRun(page, size, tenant, opts, (error, data, response) => {
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
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

[**PagedResultsTaskRun**](PagedResultsTaskRun.md)

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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let label = [new KestraIoKestraApi.Label()]; // [Label] | The labels to add to the execution
apiInstance.setLabelsOnTerminatedExecution(executionId, tenant, label, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let executionControllerSetLabelsByIdsRequest = new KestraIoKestraApi.ExecutionControllerSetLabelsByIdsRequest(); // ExecutionControllerSetLabelsByIdsRequest | The request containing a list of labels and a list of executions
apiInstance.setLabelsOnTerminatedExecutionsByIds(tenant, executionControllerSetLabelsByIdsRequest, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let label = new KestraIoKestraApi.Label(); // [Label] | The labels to add to the execution
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.setLabelsOnTerminatedExecutionsByQuery(tenant, label, opts, (error, data, response) => {
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
 **label** | [**[Label]**](Label.md)| The labels to add to the execution | 
 **q** | **String**| A string filter | [optional] 
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## triggerExecution

> [ExecutionControllerExecutionResponse] triggerExecution(namespace, id, wait, tenant, opts)

Trigger a new execution for a flow

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let wait = false; // Boolean | If the server will wait the end of the execution
let tenant = "tenant_example"; // String | 
let opts = {
  'labels': ["null"], // [String] | The labels as a list of 'key:value'
  'revision': 56 // Number | The flow revision or latest if null
};
apiInstance.triggerExecution(namespace, id, wait, tenant, opts, (error, data, response) => {
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
 **wait** | **Boolean**| If the server will wait the end of the execution | [default to false]
 **tenant** | **String**|  | 
 **labels** | [**[String]**](String.md)| The labels as a list of &#39;key:value&#39; | [optional] 
 **revision** | **Number**| The flow revision or latest if null | [optional] 

### Return type

[**[ExecutionControllerExecutionResponse]**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## triggerExecutionByGetWebhook

> ExecutionControllerWebhookResponse triggerExecutionByGetWebhook(namespace, id, key, tenant)

Trigger a new execution by GET webhook trigger

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let key = "key_example"; // String | The webhook trigger uid
let tenant = "tenant_example"; // String | 
apiInstance.triggerExecutionByGetWebhook(namespace, id, key, tenant, (error, data, response) => {
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
 **key** | **String**| The webhook trigger uid | 
 **tenant** | **String**|  | 

### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## triggerExecutionByPostWebhook

> ExecutionControllerWebhookResponse triggerExecutionByPostWebhook(namespace, id, key, tenant)

Trigger a new execution by POST webhook trigger

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let key = "key_example"; // String | The webhook trigger uid
let tenant = "tenant_example"; // String | 
apiInstance.triggerExecutionByPostWebhook(namespace, id, key, tenant, (error, data, response) => {
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
 **key** | **String**| The webhook trigger uid | 
 **tenant** | **String**|  | 

### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## triggerExecutionByPutWebhook

> ExecutionControllerWebhookResponse triggerExecutionByPutWebhook(namespace, id, key, tenant)

Trigger a new execution by PUT webhook trigger

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let key = "key_example"; // String | The webhook trigger uid
let tenant = "tenant_example"; // String | 
apiInstance.triggerExecutionByPutWebhook(namespace, id, key, tenant, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let state = new KestraIoKestraApi.StateType(); // StateType | The new state of the execution
let tenant = "tenant_example"; // String | 
apiInstance.unqueueExecution(executionId, state, tenant, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let state = new KestraIoKestraApi.StateType(); // StateType | The new state of the unqueued executions
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.unqueueExecutionsByIds(state, tenant, requestBody, (error, data, response) => {
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

> Object unqueueExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts)

Unqueue executions filter by query parameters

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter(), // ExecutionRepositoryInterfaceChildFilter | A execution child filter
  'newState': new KestraIoKestraApi.StateType() // StateType | The new state of the unqueued executions
};
apiInstance.unqueueExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 
 **newState** | [**StateType**](.md)| The new state of the unqueued executions | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateExecutionStatus

> Execution updateExecutionStatus(executionId, status, tenant)

Change the state of an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let status = new KestraIoKestraApi.StateType(); // StateType | The new state of the execution
let tenant = "tenant_example"; // String | 
apiInstance.updateExecutionStatus(executionId, status, tenant, (error, data, response) => {
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
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let newStatus = new KestraIoKestraApi.StateType(); // StateType | The new state of the executions
let tenant = "tenant_example"; // String | 
let requestBody = ["null"]; // [String] | The list of executions id
apiInstance.updateExecutionsStatusByIds(newStatus, tenant, requestBody, (error, data, response) => {
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

> BulkResponse updateExecutionsStatusByQuery(newStatus, tenant, deleteExecutionsByQueryRequest, opts)

Change executions state by query parameters

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let newStatus = new KestraIoKestraApi.StateType(); // StateType | The new state of the executions
let tenant = "tenant_example"; // String | 
let deleteExecutionsByQueryRequest = new KestraIoKestraApi.DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
let opts = {
  'q': "q_example", // String | A string filter
  'scope': [new KestraIoKestraApi.FlowScope()], // [FlowScope] | The scope of the executions to include
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'timeRange': "PT5M", // String | A time range filter relative to the current time
  'state': [new KestraIoKestraApi.StateType()], // [StateType] | A state filter
  'labels': ["null"], // [String] | A labels filter as a list of 'key:value'
  'triggerExecutionId': "triggerExecutionId_example", // String | The trigger execution id
  'childFilter': new KestraIoKestraApi.ExecutionRepositoryInterfaceChildFilter() // ExecutionRepositoryInterfaceChildFilter | A execution child filter
};
apiInstance.updateExecutionsStatusByQuery(newStatus, tenant, deleteExecutionsByQueryRequest, opts, (error, data, response) => {
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
 **newStatus** | [**StateType**](.md)| The new state of the executions | 
 **tenant** | **String**|  | 
 **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **String**| A string filter | [optional] 
 **scope** | [**[FlowScope]**](FlowScope.md)| The scope of the executions to include | [optional] 
 **namespace** | **String**| A namespace filter prefix | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **timeRange** | **String**| A time range filter relative to the current time | [optional] 
 **state** | [**[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**[String]**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **triggerExecutionId** | **String**| The trigger execution id | [optional] 
 **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateTaskRunState

> Execution updateTaskRunState(executionId, tenant, executionControllerStateRequest)

Change state for a taskrun in an execution

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let executionControllerStateRequest = new KestraIoKestraApi.ExecutionControllerStateRequest(); // ExecutionControllerStateRequest | the taskRun id and state to apply
apiInstance.updateTaskRunState(executionId, tenant, executionControllerStateRequest, (error, data, response) => {
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
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 
 **executionControllerStateRequest** | [**ExecutionControllerStateRequest**](ExecutionControllerStateRequest.md)| the taskRun id and state to apply | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## validateNewExecutionInputs

> [ExecutionControllerApiValidateExecutionInputsResponse] validateNewExecutionInputs(namespace, id, labels, tenant, opts)

Validate the creation of a new execution for a flow

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let namespace = "namespace_example"; // String | The flow namespace
let id = "id_example"; // String | The flow id
let labels = ["null"]; // [String] | The labels as a list of 'key:value'
let tenant = "tenant_example"; // String | 
let opts = {
  'revision': 56 // Number | The flow revision or latest if null
};
apiInstance.validateNewExecutionInputs(namespace, id, labels, tenant, opts, (error, data, response) => {
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
 **labels** | [**[String]**](String.md)| The labels as a list of &#39;key:value&#39; | 
 **tenant** | **String**|  | 
 **revision** | **Number**| The flow revision or latest if null | [optional] 

### Return type

[**[ExecutionControllerApiValidateExecutionInputsResponse]**](ExecutionControllerApiValidateExecutionInputsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


## validateResumeExecutionInputs

> [ExecutionControllerApiValidateExecutionInputsResponse] validateResumeExecutionInputs(executionId, tenant)

Validate inputs to resume a paused execution.

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

let apiInstance = new KestraIoKestraApi.ExecutionsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
apiInstance.validateResumeExecutionInputs(executionId, tenant, (error, data, response) => {
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
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 

### Return type

[**[ExecutionControllerApiValidateExecutionInputsResponse]**](ExecutionControllerApiValidateExecutionInputsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

