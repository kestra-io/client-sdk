# KestraApi.MetricsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**aggregateMetricsFromFlow**](MetricsApi.md#aggregateMetricsFromFlow) | **GET** /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{metric} | Get metrics aggregations for a specific flow
[**aggregateMetricsFromTask**](MetricsApi.md#aggregateMetricsFromTask) | **GET** /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{taskId}/{metric} | Get metrics aggregations for a specific flow
[**listFlowMetrics**](MetricsApi.md#listFlowMetrics) | **GET** /api/v1/{tenant}/metrics/names/{namespace}/{flowId} | Get metrics names for a specific flow
[**listTaskMetrics**](MetricsApi.md#listTaskMetrics) | **GET** /api/v1/{tenant}/metrics/names/{namespace}/{flowId}/{taskId} | Get metrics names for a specific task in a flow
[**listTasksWithMetrics**](MetricsApi.md#listTasksWithMetrics) | **GET** /api/v1/{tenant}/metrics/tasks/{namespace}/{flowId} | Get tasks id that have metrics for a specific flow, include deleted or renamed tasks
[**searchByExecution**](MetricsApi.md#searchByExecution) | **GET** /api/v1/{tenant}/metrics/{executionId} | Get metrics for a specific execution



## aggregateMetricsFromFlow

> MetricAggregations aggregateMetricsFromFlow(namespace, flowId, metric, aggregation, tenant, opts)

Get metrics aggregations for a specific flow

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

let apiInstance = new KestraApi.MetricsApi();
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow Id
let metric = "metric_example"; // String | The metric name
let aggregation = "'sum'"; // String | The type of aggregation: avg, sum, min or max
let tenant = "tenant_example"; // String | 
let opts = {
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime, default to now - 30 days
  'endDate': new Date("2013-10-20T19:20:30+01:00") // Date | The end datetime, default to now
};
apiInstance.aggregateMetricsFromFlow(namespace, flowId, metric, aggregation, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow Id | 
 **metric** | **String**| The metric name | 
 **aggregation** | **String**| The type of aggregation: avg, sum, min or max | [default to &#39;sum&#39;]
 **tenant** | **String**|  | 
 **startDate** | **Date**| The start datetime, default to now - 30 days | [optional] 
 **endDate** | **Date**| The end datetime, default to now | [optional] 

### Return type

[**MetricAggregations**](MetricAggregations.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## aggregateMetricsFromTask

> MetricAggregations aggregateMetricsFromTask(namespace, flowId, taskId, metric, aggregation, tenant, opts)

Get metrics aggregations for a specific flow

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

let apiInstance = new KestraApi.MetricsApi();
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow Id
let taskId = "taskId_example"; // String | The task Id
let metric = "metric_example"; // String | The metric name
let aggregation = "'sum'"; // String | The type of aggregation: avg, sum, min or max
let tenant = "tenant_example"; // String | 
let opts = {
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime, default to now - 30 days
  'endDate': new Date("2013-10-20T19:20:30+01:00") // Date | The end datetime, default to now
};
apiInstance.aggregateMetricsFromTask(namespace, flowId, taskId, metric, aggregation, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow Id | 
 **taskId** | **String**| The task Id | 
 **metric** | **String**| The metric name | 
 **aggregation** | **String**| The type of aggregation: avg, sum, min or max | [default to &#39;sum&#39;]
 **tenant** | **String**|  | 
 **startDate** | **Date**| The start datetime, default to now - 30 days | [optional] 
 **endDate** | **Date**| The end datetime, default to now | [optional] 

### Return type

[**MetricAggregations**](MetricAggregations.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listFlowMetrics

> [String] listFlowMetrics(namespace, flowId, tenant)

Get metrics names for a specific flow

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

let apiInstance = new KestraApi.MetricsApi();
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow Id
let tenant = "tenant_example"; // String | 
apiInstance.listFlowMetrics(namespace, flowId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow Id | 
 **tenant** | **String**|  | 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listTaskMetrics

> [String] listTaskMetrics(namespace, flowId, taskId, tenant)

Get metrics names for a specific task in a flow

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

let apiInstance = new KestraApi.MetricsApi();
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow Id
let taskId = "taskId_example"; // String | The task Id
let tenant = "tenant_example"; // String | 
apiInstance.listTaskMetrics(namespace, flowId, taskId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow Id | 
 **taskId** | **String**| The task Id | 
 **tenant** | **String**|  | 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listTasksWithMetrics

> [String] listTasksWithMetrics(namespace, flowId, tenant)

Get tasks id that have metrics for a specific flow, include deleted or renamed tasks

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

let apiInstance = new KestraApi.MetricsApi();
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow Id
let tenant = "tenant_example"; // String | 
apiInstance.listTasksWithMetrics(namespace, flowId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow Id | 
 **tenant** | **String**|  | 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchByExecution

> PagedResultsMetricEntry searchByExecution(page, size, executionId, tenant, opts)

Get metrics for a specific execution

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

let apiInstance = new KestraApi.MetricsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let executionId = "executionId_example"; // String | The execution id
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'taskRunId': "taskRunId_example", // String | The taskrun id
  'taskId': "taskId_example" // String | The task id
};
apiInstance.searchByExecution(page, size, executionId, tenant, opts).then((data) => {
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
 **executionId** | **String**| The execution id | 
 **tenant** | **String**|  | 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **taskRunId** | **String**| The taskrun id | [optional] 
 **taskId** | **String**| The task id | [optional] 

### Return type

[**PagedResultsMetricEntry**](PagedResultsMetricEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

