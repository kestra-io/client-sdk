# KestraIoKestraApi.LogsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteLogsFromExecution**](LogsApi.md#deleteLogsFromExecution) | **DELETE** /api/v1/{tenant}/logs/{executionId} | Delete logs for a specific execution, taskrun or task
[**deleteLogsFromFlow**](LogsApi.md#deleteLogsFromFlow) | **DELETE** /api/v1/{tenant}/logs/{namespace}/{flowId} | Delete logs for a specific execution, taskrun or task
[**downloadLogsFromExecution**](LogsApi.md#downloadLogsFromExecution) | **GET** /api/v1/{tenant}/logs/{executionId}/download | Download logs for a specific execution, taskrun or task
[**followLogsFromExecution**](LogsApi.md#followLogsFromExecution) | **GET** /api/v1/{tenant}/logs/{executionId}/follow | Follow logs for a specific execution
[**listLogsFromExecution**](LogsApi.md#listLogsFromExecution) | **GET** /api/v1/{tenant}/logs/{executionId} | Get logs for a specific execution, taskrun or task
[**searchLogs**](LogsApi.md#searchLogs) | **GET** /api/v1/{tenant}/logs/search | Search for logs



## deleteLogsFromExecution

> deleteLogsFromExecution(executionId, tenant, opts)

Delete logs for a specific execution, taskrun or task

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

let apiInstance = new KestraIoKestraApi.LogsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'minLevel': new KestraIoKestraApi.Level(), // Level | The min log level filter
  'taskRunId': "taskRunId_example", // String | The taskrun id
  'taskId': "taskId_example", // String | The task id
  'attempt': 56 // Number | The attempt number
};
apiInstance.deleteLogsFromExecution(executionId, tenant, opts, (error, data, response) => {
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
 **minLevel** | [**Level**](.md)| The min log level filter | [optional] 
 **taskRunId** | **String**| The taskrun id | [optional] 
 **taskId** | **String**| The task id | [optional] 
 **attempt** | **Number**| The attempt number | [optional] 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteLogsFromFlow

> deleteLogsFromFlow(namespace, flowId, triggerId, tenant)

Delete logs for a specific execution, taskrun or task

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

let apiInstance = new KestraIoKestraApi.LogsApi();
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow identifier
let triggerId = "triggerId_example"; // String | The trigger id
let tenant = "tenant_example"; // String | 
apiInstance.deleteLogsFromFlow(namespace, flowId, triggerId, tenant, (error, data, response) => {
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
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow identifier | 
 **triggerId** | **String**| The trigger id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## downloadLogsFromExecution

> File downloadLogsFromExecution(executionId, tenant, opts)

Download logs for a specific execution, taskrun or task

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

let apiInstance = new KestraIoKestraApi.LogsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'minLevel': new KestraIoKestraApi.Level(), // Level | The min log level filter
  'taskRunId': "taskRunId_example", // String | The taskrun id
  'taskId': "taskId_example", // String | The task id
  'attempt': 56 // Number | The attempt number
};
apiInstance.downloadLogsFromExecution(executionId, tenant, opts, (error, data, response) => {
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
 **minLevel** | [**Level**](.md)| The min log level filter | [optional] 
 **taskRunId** | **String**| The taskrun id | [optional] 
 **taskId** | **String**| The task id | [optional] 
 **attempt** | **Number**| The attempt number | [optional] 

### Return type

**File**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain


## followLogsFromExecution

> EventLogEntry followLogsFromExecution(executionId, tenant, opts)

Follow logs for a specific execution

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

let apiInstance = new KestraIoKestraApi.LogsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'minLevel': new KestraIoKestraApi.Level() // Level | The min log level filter
};
apiInstance.followLogsFromExecution(executionId, tenant, opts, (error, data, response) => {
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
 **minLevel** | [**Level**](.md)| The min log level filter | [optional] 

### Return type

[**EventLogEntry**](EventLogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream


## listLogsFromExecution

> [LogEntry] listLogsFromExecution(executionId, tenant, opts)

Get logs for a specific execution, taskrun or task

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

let apiInstance = new KestraIoKestraApi.LogsApi();
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'minLevel': new KestraIoKestraApi.Level(), // Level | The min log level filter
  'taskRunId': "taskRunId_example", // String | The taskrun id
  'taskId': "taskId_example", // String | The task id
  'attempt': 56 // Number | The attempt number
};
apiInstance.listLogsFromExecution(executionId, tenant, opts, (error, data, response) => {
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
 **minLevel** | [**Level**](.md)| The min log level filter | [optional] 
 **taskRunId** | **String**| The taskrun id | [optional] 
 **taskId** | **String**| The task id | [optional] 
 **attempt** | **Number**| The attempt number | [optional] 

### Return type

[**[LogEntry]**](LogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchLogs

> PagedResultsLogEntry searchLogs(page, size, tenant, opts)

Search for logs

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

let apiInstance = new KestraIoKestraApi.LogsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'filters': [new KestraIoKestraApi.QueryFilter()], // [QueryFilter] | Filters
  'q': "q_example", // String | A string filter
  'namespace': "namespace_example", // String | A namespace filter prefix
  'flowId': "flowId_example", // String | A flow id filter
  'triggerId': "triggerId_example", // String | A trigger id filter
  'minLevel': new KestraIoKestraApi.Level(), // Level | The min log level filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00") // Date | The end datetime
};
apiInstance.searchLogs(page, size, tenant, opts, (error, data, response) => {
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
 **triggerId** | **String**| A trigger id filter | [optional] 
 **minLevel** | [**Level**](.md)| The min log level filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 

### Return type

[**PagedResultsLogEntry**](PagedResultsLogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

