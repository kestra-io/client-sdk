# ExecutionsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createExecution**](ExecutionsApi.md#createExecution) | **POST** /api/v1/{tenant}/executions/{namespace}/{id} | Create a new execution for a flow |
| [**deleteExecution**](ExecutionsApi.md#deleteExecution) | **DELETE** /api/v1/{tenant}/executions/{executionId} | Delete an execution |
| [**deleteExecutionsByIds**](ExecutionsApi.md#deleteExecutionsByIds) | **DELETE** /api/v1/{tenant}/executions/by-ids | Delete a list of executions |
| [**deleteExecutionsByQuery**](ExecutionsApi.md#deleteExecutionsByQuery) | **DELETE** /api/v1/{tenant}/executions/by-query | Delete executions filter by query parameters |
| [**downloadFileFromExecution**](ExecutionsApi.md#downloadFileFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file | Download file for an execution |
| [**evalTaskRunExpression**](ExecutionsApi.md#evalTaskRunExpression) | **POST** /api/v1/{tenant}/executions/{executionId}/eval/{taskRunId} | Evaluate a variable expression for this taskrun |
| [**followDependenciesExecutions**](ExecutionsApi.md#followDependenciesExecutions) | **GET** /api/v1/{tenant}/executions/{executionId}/follow-dependencies | Follow all execution dependencies executions |
| [**followExecution**](ExecutionsApi.md#followExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/follow | Follow an execution |
| [**forceRunByIds**](ExecutionsApi.md#forceRunByIds) | **POST** /api/v1/{tenant}/executions/force-run/by-ids | Force run a list of executions |
| [**forceRunExecution**](ExecutionsApi.md#forceRunExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/force-run | Force run an execution |
| [**forceRunExecutionsByQuery**](ExecutionsApi.md#forceRunExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/force-run/by-query | Force run executions filter by query parameters |
| [**getExecution**](ExecutionsApi.md#getExecution) | **GET** /api/v1/{tenant}/executions/{executionId} | Get an execution |
| [**getExecutionFlowGraph**](ExecutionsApi.md#getExecutionFlowGraph) | **GET** /api/v1/{tenant}/executions/{executionId}/graph | Generate a graph for an execution |
| [**getFileMetadatasFromExecution**](ExecutionsApi.md#getFileMetadatasFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/metas | Get file meta information for an execution |
| [**getFlowFromExecution**](ExecutionsApi.md#getFlowFromExecution) | **GET** /api/v1/{tenant}/executions/flows/{namespace}/{flowId} | Get flow information&#39;s for an execution |
| [**getFlowFromExecutionById**](ExecutionsApi.md#getFlowFromExecutionById) | **GET** /api/v1/{tenant}/executions/{executionId}/flow | Get flow information&#39;s for an execution |
| [**getLatestExecutions**](ExecutionsApi.md#getLatestExecutions) | **POST** /api/v1/{tenant}/executions/latest | Get the latest execution for given flows |
| [**killExecution**](ExecutionsApi.md#killExecution) | **DELETE** /api/v1/{tenant}/executions/{executionId}/kill | Kill an execution |
| [**killExecutionsByIds**](ExecutionsApi.md#killExecutionsByIds) | **DELETE** /api/v1/{tenant}/executions/kill/by-ids | Kill a list of executions |
| [**killExecutionsByQuery**](ExecutionsApi.md#killExecutionsByQuery) | **DELETE** /api/v1/{tenant}/executions/kill/by-query | Kill executions filter by query parameters |
| [**listExecutableDistinctNamespaces**](ExecutionsApi.md#listExecutableDistinctNamespaces) | **GET** /api/v1/{tenant}/executions/namespaces | Get all namespaces that have executable flows |
| [**listFlowExecutionsByNamespace**](ExecutionsApi.md#listFlowExecutionsByNamespace) | **GET** /api/v1/{tenant}/executions/namespaces/{namespace}/flows | Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading. |
| [**pauseExecution**](ExecutionsApi.md#pauseExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/pause | Pause a running execution. |
| [**pauseExecutionsByIds**](ExecutionsApi.md#pauseExecutionsByIds) | **POST** /api/v1/{tenant}/executions/pause/by-ids | Pause a list of running executions |
| [**pauseExecutionsByQuery**](ExecutionsApi.md#pauseExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/pause/by-query | Pause executions filter by query parameters |
| [**previewFileFromExecution**](ExecutionsApi.md#previewFileFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/preview | Get file preview for an execution |
| [**replayExecution**](ExecutionsApi.md#replayExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/replay | Create a new execution from an old one and start it from a specified task run id |
| [**replayExecutionWithinputs**](ExecutionsApi.md#replayExecutionWithinputs) | **POST** /api/v1/{tenant}/executions/{executionId}/replay-with-inputs | Create a new execution from an old one and start it from a specified task run id |
| [**replayExecutionsByIds**](ExecutionsApi.md#replayExecutionsByIds) | **POST** /api/v1/{tenant}/executions/replay/by-ids | Create new executions from old ones. Keep the flow revision |
| [**replayExecutionsByQuery**](ExecutionsApi.md#replayExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/replay/by-query | Create new executions from old ones filter by query parameters. Keep the flow revision |
| [**restartExecution**](ExecutionsApi.md#restartExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/restart | Restart a new execution from an old one |
| [**restartExecutionsByIds**](ExecutionsApi.md#restartExecutionsByIds) | **POST** /api/v1/{tenant}/executions/restart/by-ids | Restart a list of executions |
| [**restartExecutionsByQuery**](ExecutionsApi.md#restartExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/restart/by-query | Restart executions filter by query parameters |
| [**resumeExecution**](ExecutionsApi.md#resumeExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/resume | Resume a paused execution. |
| [**resumeExecutionFromBreakpoint**](ExecutionsApi.md#resumeExecutionFromBreakpoint) | **POST** /api/v1/{tenant}/executions/{executionId}/resume-from-breakpoint | Resume an execution from a breakpoint (in the &#39;BREAKPOINT&#39; state). |
| [**resumeExecutionsByIds**](ExecutionsApi.md#resumeExecutionsByIds) | **POST** /api/v1/{tenant}/executions/resume/by-ids | Resume a list of paused executions |
| [**resumeExecutionsByQuery**](ExecutionsApi.md#resumeExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/resume/by-query | Resume executions filter by query parameters |
| [**searchExecutions**](ExecutionsApi.md#searchExecutions) | **GET** /api/v1/{tenant}/executions/search | Search for executions |
| [**searchExecutionsByFlowId**](ExecutionsApi.md#searchExecutionsByFlowId) | **GET** /api/v1/{tenant}/executions | Search for executions for a flow |
| [**searchTaskRun**](ExecutionsApi.md#searchTaskRun) | **GET** /api/v1/{tenant}/taskruns/search | Search for taskruns, only available with the Elasticsearch repository |
| [**setLabelsOnTerminatedExecution**](ExecutionsApi.md#setLabelsOnTerminatedExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/labels | Add or update labels of a terminated execution |
| [**setLabelsOnTerminatedExecutionsByIds**](ExecutionsApi.md#setLabelsOnTerminatedExecutionsByIds) | **POST** /api/v1/{tenant}/executions/labels/by-ids | Set labels on a list of executions |
| [**setLabelsOnTerminatedExecutionsByQuery**](ExecutionsApi.md#setLabelsOnTerminatedExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/labels/by-query | Set label on executions filter by query parameters |
| [**triggerExecution**](ExecutionsApi.md#triggerExecution) | **POST** /api/v1/{tenant}/executions/trigger/{namespace}/{id} | Trigger a new execution for a flow |
| [**triggerExecutionByGetWebhook**](ExecutionsApi.md#triggerExecutionByGetWebhook) | **GET** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by GET webhook trigger |
| [**triggerExecutionByPostWebhook**](ExecutionsApi.md#triggerExecutionByPostWebhook) | **POST** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by POST webhook trigger |
| [**triggerExecutionByPutWebhook**](ExecutionsApi.md#triggerExecutionByPutWebhook) | **PUT** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by PUT webhook trigger |
| [**unqueueExecution**](ExecutionsApi.md#unqueueExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/unqueue | Unqueue an execution |
| [**unqueueExecutionsByIds**](ExecutionsApi.md#unqueueExecutionsByIds) | **POST** /api/v1/{tenant}/executions/unqueue/by-ids | Unqueue a list of executions |
| [**unqueueExecutionsByQuery**](ExecutionsApi.md#unqueueExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/unqueue/by-query | Unqueue executions filter by query parameters |
| [**updateExecutionStatus**](ExecutionsApi.md#updateExecutionStatus) | **POST** /api/v1/{tenant}/executions/{executionId}/change-status | Change the state of an execution |
| [**updateExecutionsStatusByIds**](ExecutionsApi.md#updateExecutionsStatusByIds) | **POST** /api/v1/{tenant}/executions/change-status/by-ids | Change executions state by id |
| [**updateExecutionsStatusByQuery**](ExecutionsApi.md#updateExecutionsStatusByQuery) | **POST** /api/v1/{tenant}/executions/change-status/by-query | Change executions state by query parameters |
| [**updateTaskRunState**](ExecutionsApi.md#updateTaskRunState) | **POST** /api/v1/{tenant}/executions/{executionId}/state | Change state for a taskrun in an execution |
| [**validateNewExecutionInputs**](ExecutionsApi.md#validateNewExecutionInputs) | **POST** /api/v1/{tenant}/executions/{namespace}/{id}/validate | Validate the creation of a new execution for a flow |
| [**validateResumeExecutionInputs**](ExecutionsApi.md#validateResumeExecutionInputs) | **POST** /api/v1/{tenant}/executions/{executionId}/resume/validate | Validate inputs to resume a paused execution. |



## createExecution

> List&lt;ExecutionControllerExecutionResponse&gt; createExecution(namespace, id, wait, tenant, labels, revision, scheduleDate, breakpoints, kind)

Create a new execution for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        Boolean wait = false; // Boolean | If the server will wait the end of the execution
        String tenant = "tenant_example"; // String | 
        List<String> labels = Arrays.asList(); // List<String> | The labels as a list of 'key:value'
        Integer revision = 56; // Integer | The flow revision or latest if null
        OffsetDateTime scheduleDate = OffsetDateTime.now(); // OffsetDateTime | Schedule the flow on a specific date
        String breakpoints = "breakpoints_example"; // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
        ExecutionKind kind = ExecutionKind.fromValue("NORMAL"); // ExecutionKind | Specific execution kind
        try {
            List<ExecutionControllerExecutionResponse> result = apiInstance.createExecution(namespace, id, wait, tenant, labels, revision, scheduleDate, breakpoints, kind);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#createExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **wait** | **Boolean**| If the server will wait the end of the execution | [default to false] |
| **tenant** | **String**|  | |
| **labels** | [**List&lt;String&gt;**](String.md)| The labels as a list of &#39;key:value&#39; | [optional] |
| **revision** | **Integer**| The flow revision or latest if null | [optional] |
| **scheduleDate** | **OffsetDateTime**| Schedule the flow on a specific date | [optional] |
| **breakpoints** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] |
| **kind** | [**ExecutionKind**](.md)| Specific execution kind | [optional] [enum: NORMAL, TEST, PLAYGROUND] |

### Return type

[**List&lt;ExecutionControllerExecutionResponse&gt;**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **409** | if the flow is disabled |  -  |
| **200** | createExecution 200 response |  -  |


## deleteExecution

> deleteExecution(executionId, deleteLogs, deleteMetrics, deleteStorage, tenant)

Delete an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        Boolean deleteLogs = true; // Boolean | Whether to delete execution logs
        Boolean deleteMetrics = true; // Boolean | Whether to delete execution metrics
        Boolean deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
        String tenant = "tenant_example"; // String | 
        try {
            apiInstance.deleteExecution(executionId, deleteLogs, deleteMetrics, deleteStorage, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#deleteExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **deleteLogs** | **Boolean**| Whether to delete execution logs | [default to true] |
| **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [default to true] |
| **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [default to true] |
| **tenant** | **String**|  | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | On success |  -  |
| **200** | deleteExecution 200 response |  -  |


## deleteExecutionsByIds

> BulkResponse deleteExecutionsByIds(deleteLogs, deleteMetrics, deleteStorage, tenant, requestBody, includeNonTerminated)

Delete a list of executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        Boolean deleteLogs = true; // Boolean | Whether to delete execution logs
        Boolean deleteMetrics = true; // Boolean | Whether to delete execution metrics
        Boolean deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The execution id
        Boolean includeNonTerminated = false; // Boolean | Whether to delete non-terminated executions
        try {
            BulkResponse result = apiInstance.deleteExecutionsByIds(deleteLogs, deleteMetrics, deleteStorage, tenant, requestBody, includeNonTerminated);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#deleteExecutionsByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **deleteLogs** | **Boolean**| Whether to delete execution logs | [default to true] |
| **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [default to true] |
| **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [default to true] |
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The execution id | |
| **includeNonTerminated** | **Boolean**| Whether to delete non-terminated executions | [optional] [default to false] |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Deleted with errors |  -  |


## deleteExecutionsByQuery

> Object deleteExecutionsByQuery(deleteLogs, deleteMetrics, deleteStorage, tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, includeNonTerminated)

Delete executions filter by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        Boolean deleteLogs = true; // Boolean | Whether to delete execution logs
        Boolean deleteMetrics = true; // Boolean | Whether to delete execution metrics
        Boolean deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        Boolean includeNonTerminated = false; // Boolean | Whether to delete non-terminated executions
        try {
            Object result = apiInstance.deleteExecutionsByQuery(deleteLogs, deleteMetrics, deleteStorage, tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, includeNonTerminated);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#deleteExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **deleteLogs** | **Boolean**| Whether to delete execution logs | [default to true] |
| **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [default to true] |
| **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [default to true] |
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |
| **includeNonTerminated** | **Boolean**| Whether to delete non-terminated executions | [optional] [default to false] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteExecutionsByQuery 200 response |  -  |


## downloadFileFromExecution

> File downloadFileFromExecution(executionId, path, tenant)

Download file for an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        URI path = new URI(); // URI | The internal storage uri
        String tenant = "tenant_example"; // String | 
        try {
            File result = apiInstance.downloadFileFromExecution(executionId, path, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#downloadFileFromExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **path** | **URI**| The internal storage uri | |
| **tenant** | **String**|  | |

### Return type

[**File**](File.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | downloadFileFromExecution 200 response |  -  |


## evalTaskRunExpression

> ExecutionControllerEvalResult evalTaskRunExpression(executionId, taskRunId, tenant, body)

Evaluate a variable expression for this taskrun

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The Pebble expression that should be evaluated
        try {
            ExecutionControllerEvalResult result = apiInstance.evalTaskRunExpression(executionId, taskRunId, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#evalTaskRunExpression");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **taskRunId** | **String**| The taskrun id | |
| **tenant** | **String**|  | |
| **body** | **String**| The Pebble expression that should be evaluated | |

### Return type

[**ExecutionControllerEvalResult**](ExecutionControllerEvalResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | evalTaskRunExpression 200 response |  -  |


## followDependenciesExecutions

> EventExecutionStatusEvent followDependenciesExecutions(executionId, destinationOnly, expandAll, tenant)

Follow all execution dependencies executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        Boolean destinationOnly = false; // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
        Boolean expandAll = false; // Boolean | If true, expand all dependencies recursively
        String tenant = "tenant_example"; // String | 
        try {
            EventExecutionStatusEvent result = apiInstance.followDependenciesExecutions(executionId, destinationOnly, expandAll, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#followDependenciesExecutions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **destinationOnly** | **Boolean**| If true, list only destination dependencies, otherwise list also source dependencies | [default to false] |
| **expandAll** | **Boolean**| If true, expand all dependencies recursively | [default to false] |
| **tenant** | **String**|  | |

### Return type

[**EventExecutionStatusEvent**](EventExecutionStatusEvent.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | followDependenciesExecutions 200 response |  -  |


## followExecution

> EventExecution followExecution(executionId, tenant)

Follow an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            EventExecution result = apiInstance.followExecution(executionId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#followExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |

### Return type

[**EventExecution**](EventExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | followExecution 200 response |  -  |


## forceRunByIds

> BulkResponse forceRunByIds(tenant, requestBody)

Force run a list of executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            BulkResponse result = apiInstance.forceRunByIds(tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#forceRunByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Force run with errors |  -  |


## forceRunExecution

> Execution forceRunExecution(executionId, tenant)

Force run an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            Execution result = apiInstance.forceRunExecution(executionId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#forceRunExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | forceRunExecution 200 response |  -  |


## forceRunExecutionsByQuery

> Object forceRunExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Force run executions filter by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            Object result = apiInstance.forceRunExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#forceRunExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | forceRunExecutionsByQuery 200 response |  -  |


## getExecution

> Execution getExecution(executionId, tenant)

Get an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            Execution result = apiInstance.getExecution(executionId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#getExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getExecution 200 response |  -  |


## getExecutionFlowGraph

> FlowGraph getExecutionFlowGraph(executionId, tenant, subflows)

Generate a graph for an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        List<String> subflows = Arrays.asList(); // List<String> | The subflow tasks to display
        try {
            FlowGraph result = apiInstance.getExecutionFlowGraph(executionId, tenant, subflows);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#getExecutionFlowGraph");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |
| **subflows** | [**List&lt;String&gt;**](String.md)| The subflow tasks to display | [optional] |

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getExecutionFlowGraph 200 response |  -  |


## getFileMetadatasFromExecution

> FileMetas getFileMetadatasFromExecution(executionId, path, tenant)

Get file meta information for an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        URI path = new URI(); // URI | The internal storage uri
        String tenant = "tenant_example"; // String | 
        try {
            FileMetas result = apiInstance.getFileMetadatasFromExecution(executionId, path, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#getFileMetadatasFromExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **path** | **URI**| The internal storage uri | |
| **tenant** | **String**|  | |

### Return type

[**FileMetas**](FileMetas.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getFileMetadatasFromExecution 200 response |  -  |


## getFlowFromExecution

> FlowForExecution getFlowFromExecution(namespace, flowId, tenant, revision)

Get flow information&#39;s for an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The namespace of the flow
        String flowId = "flowId_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | The flow revision
        try {
            FlowForExecution result = apiInstance.getFlowFromExecution(namespace, flowId, tenant, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#getFlowFromExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The namespace of the flow | |
| **flowId** | **String**| The flow id | |
| **tenant** | **String**|  | |
| **revision** | **Integer**| The flow revision | [optional] |

### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getFlowFromExecution 200 response |  -  |


## getFlowFromExecutionById

> FlowForExecution getFlowFromExecutionById(executionId, tenant)

Get flow information&#39;s for an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution that you want flow information's
        String tenant = "tenant_example"; // String | 
        try {
            FlowForExecution result = apiInstance.getFlowFromExecutionById(executionId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#getFlowFromExecutionById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution that you want flow information&#39;s | |
| **tenant** | **String**|  | |

### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getFlowFromExecutionById 200 response |  -  |


## getLatestExecutions

> List&lt;ExecutionControllerLastExecutionResponse&gt; getLatestExecutions(tenant, executionRepositoryInterfaceFlowFilter)

Get the latest execution for given flows

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<ExecutionRepositoryInterfaceFlowFilter> executionRepositoryInterfaceFlowFilter = Arrays.asList(); // List<ExecutionRepositoryInterfaceFlowFilter> | 
        try {
            List<ExecutionControllerLastExecutionResponse> result = apiInstance.getLatestExecutions(tenant, executionRepositoryInterfaceFlowFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#getLatestExecutions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **executionRepositoryInterfaceFlowFilter** | [**List&lt;ExecutionRepositoryInterfaceFlowFilter&gt;**](ExecutionRepositoryInterfaceFlowFilter.md)|  | |

### Return type

[**List&lt;ExecutionControllerLastExecutionResponse&gt;**](ExecutionControllerLastExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getLatestExecutions 200 response |  -  |


## killExecution

> Object killExecution(executionId, isOnKillCascade, tenant)

Kill an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        Boolean isOnKillCascade = true; // Boolean | Specifies whether killing the execution also kill all subflow executions.
        String tenant = "tenant_example"; // String | 
        try {
            Object result = apiInstance.killExecution(executionId, isOnKillCascade, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#killExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **isOnKillCascade** | **Boolean**| Specifies whether killing the execution also kill all subflow executions. | [default to true] |
| **tenant** | **String**|  | |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Execution kill was requested successfully |  -  |
| **409** | if the executions is already finished |  -  |
| **404** | if the executions is not found |  -  |
| **200** | killExecution 200 response |  -  |


## killExecutionsByIds

> BulkResponse killExecutionsByIds(tenant, requestBody)

Kill a list of executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            BulkResponse result = apiInstance.killExecutionsByIds(tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#killExecutionsByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Killed with errors |  -  |


## killExecutionsByQuery

> Object killExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Kill executions filter by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            Object result = apiInstance.killExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#killExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | killExecutionsByQuery 200 response |  -  |


## listExecutableDistinctNamespaces

> List&lt;String&gt; listExecutableDistinctNamespaces(tenant)

Get all namespaces that have executable flows

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        try {
            List<String> result = apiInstance.listExecutableDistinctNamespaces(tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#listExecutableDistinctNamespaces");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |

### Return type

**List&lt;String&gt;**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listExecutableDistinctNamespaces 200 response |  -  |


## listFlowExecutionsByNamespace

> List&lt;FlowForExecution&gt; listFlowExecutionsByNamespace(namespace, tenant)

Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The namespace
        String tenant = "tenant_example"; // String | 
        try {
            List<FlowForExecution> result = apiInstance.listFlowExecutionsByNamespace(namespace, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#listFlowExecutionsByNamespace");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The namespace | |
| **tenant** | **String**|  | |

### Return type

[**List&lt;FlowForExecution&gt;**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listFlowExecutionsByNamespace 200 response |  -  |


## pauseExecution

> pauseExecution(executionId, tenant)

Pause a running execution.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            apiInstance.pauseExecution(executionId, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#pauseExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | On success |  -  |
| **409** | if the executions is not running |  -  |
| **200** | pauseExecution 200 response |  -  |


## pauseExecutionsByIds

> BulkResponse pauseExecutionsByIds(tenant, requestBody)

Pause a list of running executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            BulkResponse result = apiInstance.pauseExecutionsByIds(tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#pauseExecutionsByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Paused with errors |  -  |


## pauseExecutionsByQuery

> Object pauseExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Pause executions filter by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            Object result = apiInstance.pauseExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#pauseExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | pauseExecutionsByQuery 200 response |  -  |


## previewFileFromExecution

> Object previewFileFromExecution(executionId, path, maxRows, encoding, tenant)

Get file preview for an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        URI path = new URI(); // URI | The internal storage uri
        Integer maxRows = 56; // Integer | The max row returns
        String encoding = "UTF-8"; // String | The file encoding as Java charset name. Defaults to UTF-8
        String tenant = "tenant_example"; // String | 
        try {
            Object result = apiInstance.previewFileFromExecution(executionId, path, maxRows, encoding, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#previewFileFromExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **path** | **URI**| The internal storage uri | |
| **maxRows** | **Integer**| The max row returns | |
| **encoding** | **String**| The file encoding as Java charset name. Defaults to UTF-8 | [default to UTF-8] |
| **tenant** | **String**|  | |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | previewFileFromExecution 200 response |  -  |


## replayExecution

> Execution replayExecution(executionId, tenant, taskRunId, revision, breakpoints)

Create a new execution from an old one and start it from a specified task run id

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | the original execution id to clone
        String tenant = "tenant_example"; // String | 
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        Integer revision = 56; // Integer | The flow revision to use for new execution
        String breakpoints = "breakpoints_example"; // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
        try {
            Execution result = apiInstance.replayExecution(executionId, tenant, taskRunId, revision, breakpoints);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#replayExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| the original execution id to clone | |
| **tenant** | **String**|  | |
| **taskRunId** | **String**| The taskrun id | [optional] |
| **revision** | **Integer**| The flow revision to use for new execution | [optional] |
| **breakpoints** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | replayExecution 200 response |  -  |


## replayExecutionWithinputs

> Execution replayExecutionWithinputs(executionId, tenant, taskRunId, revision, breakpoints)

Create a new execution from an old one and start it from a specified task run id

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | the original execution id to clone
        String tenant = "tenant_example"; // String | 
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        Integer revision = 56; // Integer | The flow revision to use for new execution
        String breakpoints = "breakpoints_example"; // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
        try {
            Execution result = apiInstance.replayExecutionWithinputs(executionId, tenant, taskRunId, revision, breakpoints);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#replayExecutionWithinputs");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| the original execution id to clone | |
| **tenant** | **String**|  | |
| **taskRunId** | **String**| The taskrun id | [optional] |
| **revision** | **Integer**| The flow revision to use for new execution | [optional] |
| **breakpoints** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | replayExecutionWithinputs 200 response |  -  |


## replayExecutionsByIds

> BulkResponse replayExecutionsByIds(tenant, requestBody, latestRevision)

Create new executions from old ones. Keep the flow revision

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        Boolean latestRevision = false; // Boolean | If latest revision should be used
        try {
            BulkResponse result = apiInstance.replayExecutionsByIds(tenant, requestBody, latestRevision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#replayExecutionsByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |
| **latestRevision** | **Boolean**| If latest revision should be used | [optional] [default to false] |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Replayed with errors |  -  |


## replayExecutionsByQuery

> Object replayExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, latestRevision)

Create new executions from old ones filter by query parameters. Keep the flow revision

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        Boolean latestRevision = false; // Boolean | If latest revision should be used
        try {
            Object result = apiInstance.replayExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, latestRevision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#replayExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |
| **latestRevision** | **Boolean**| If latest revision should be used | [optional] [default to false] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | replayExecutionsByQuery 200 response |  -  |


## restartExecution

> Execution restartExecution(executionId, tenant, revision)

Restart a new execution from an old one

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | The flow revision to use for new execution
        try {
            Execution result = apiInstance.restartExecution(executionId, tenant, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#restartExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |
| **revision** | **Integer**| The flow revision to use for new execution | [optional] |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | restartExecution 200 response |  -  |


## restartExecutionsByIds

> BulkResponse restartExecutionsByIds(tenant, requestBody)

Restart a list of executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            BulkResponse result = apiInstance.restartExecutionsByIds(tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#restartExecutionsByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Restarted with errors |  -  |


## restartExecutionsByQuery

> Object restartExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Restart executions filter by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            Object result = apiInstance.restartExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#restartExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | restartExecutionsByQuery 200 response |  -  |


## resumeExecution

> Object resumeExecution(executionId, tenant)

Resume a paused execution.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            Object result = apiInstance.resumeExecution(executionId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#resumeExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | On success |  -  |
| **409** | if the executions is not paused |  -  |
| **200** | resumeExecution 200 response |  -  |


## resumeExecutionFromBreakpoint

> resumeExecutionFromBreakpoint(executionId, tenant, breakpoints)

Resume an execution from a breakpoint (in the &#39;BREAKPOINT&#39; state).

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        String breakpoints = "breakpoints_example"; // String | \"Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
        try {
            apiInstance.resumeExecutionFromBreakpoint(executionId, tenant, breakpoints);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#resumeExecutionFromBreakpoint");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |
| **breakpoints** | **String**| \&quot;Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | On success |  -  |
| **409** | If the executions is not in the &#39;BREAKPOINT&#39; state or has no breakpoint |  -  |
| **200** | resumeExecutionFromBreakpoint 200 response |  -  |


## resumeExecutionsByIds

> BulkResponse resumeExecutionsByIds(tenant, requestBody)

Resume a list of paused executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            BulkResponse result = apiInstance.resumeExecutionsByIds(tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#resumeExecutionsByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Resumed with errors |  -  |


## resumeExecutionsByQuery

> Object resumeExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Resume executions filter by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            Object result = apiInstance.resumeExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#resumeExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | resumeExecutionsByQuery 200 response |  -  |


## searchExecutions

> PagedResultsExecution searchExecutions(page, size, tenant, sort, filters, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Search for executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            PagedResultsExecution result = apiInstance.searchExecutions(page, size, tenant, sort, filters, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#searchExecutions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| The current page | [default to 1] |
| **size** | **Integer**| The current page size | [default to 10] |
| **tenant** | **String**|  | |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | [optional] |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

[**PagedResultsExecution**](PagedResultsExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchExecutions 200 response |  -  |


## searchExecutionsByFlowId

> PagedResultsExecution searchExecutionsByFlowId(namespace, flowId, page, size, tenant)

Search for executions for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The flow namespace
        String flowId = "flowId_example"; // String | The flow id
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        try {
            PagedResultsExecution result = apiInstance.searchExecutionsByFlowId(namespace, flowId, page, size, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#searchExecutionsByFlowId");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The flow namespace | |
| **flowId** | **String**| The flow id | |
| **page** | **Integer**| The current page | [default to 1] |
| **size** | **Integer**| The current page size | [default to 10] |
| **tenant** | **String**|  | |

### Return type

[**PagedResultsExecution**](PagedResultsExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchExecutionsByFlowId 200 response |  -  |


## searchTaskRun

> PagedResultsTaskRun searchTaskRun(page, size, tenant, sort, filters, q, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Search for taskruns, only available with the Elasticsearch repository

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String q = "q_example"; // String | A string filter
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            PagedResultsTaskRun result = apiInstance.searchTaskRun(page, size, tenant, sort, filters, q, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#searchTaskRun");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| The current page | [default to 1] |
| **size** | **Integer**| The current page size | [default to 10] |
| **tenant** | **String**|  | |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | [optional] |
| **q** | **String**| A string filter | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

[**PagedResultsTaskRun**](PagedResultsTaskRun.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchTaskRun 200 response |  -  |


## setLabelsOnTerminatedExecution

> Object setLabelsOnTerminatedExecution(executionId, tenant, label)

Add or update labels of a terminated execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        List<Label> label = Arrays.asList(); // List<Label> | The labels to add to the execution
        try {
            Object result = apiInstance.setLabelsOnTerminatedExecution(executionId, tenant, label);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#setLabelsOnTerminatedExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |
| **label** | [**List&lt;Label&gt;**](Label.md)| The labels to add to the execution | |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | If the execution cannot be found |  -  |
| **400** | If the execution is not terminated |  -  |
| **200** | setLabelsOnTerminatedExecution 200 response |  -  |


## setLabelsOnTerminatedExecutionsByIds

> BulkResponse setLabelsOnTerminatedExecutionsByIds(tenant, executionControllerSetLabelsByIdsRequest)

Set labels on a list of executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        ExecutionControllerSetLabelsByIdsRequest executionControllerSetLabelsByIdsRequest = new ExecutionControllerSetLabelsByIdsRequest(); // ExecutionControllerSetLabelsByIdsRequest | The request containing a list of labels and a list of executions
        try {
            BulkResponse result = apiInstance.setLabelsOnTerminatedExecutionsByIds(tenant, executionControllerSetLabelsByIdsRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#setLabelsOnTerminatedExecutionsByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **executionControllerSetLabelsByIdsRequest** | [**ExecutionControllerSetLabelsByIdsRequest**](ExecutionControllerSetLabelsByIdsRequest.md)| The request containing a list of labels and a list of executions | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Killed with errors |  -  |


## setLabelsOnTerminatedExecutionsByQuery

> Object setLabelsOnTerminatedExecutionsByQuery(tenant, label, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Set label on executions filter by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<Label> label = new Label(); // List<Label> | The labels to add to the execution
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            Object result = apiInstance.setLabelsOnTerminatedExecutionsByQuery(tenant, label, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#setLabelsOnTerminatedExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **label** | [**List&lt;Label&gt;**](Label.md)| The labels to add to the execution | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | setLabelsOnTerminatedExecutionsByQuery 200 response |  -  |


## triggerExecution

> List&lt;ExecutionControllerExecutionResponse&gt; triggerExecution(namespace, id, wait, tenant, labels, revision)

Trigger a new execution for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        Boolean wait = false; // Boolean | If the server will wait the end of the execution
        String tenant = "tenant_example"; // String | 
        List<String> labels = Arrays.asList(); // List<String> | The labels as a list of 'key:value'
        Integer revision = 56; // Integer | The flow revision or latest if null
        try {
            List<ExecutionControllerExecutionResponse> result = apiInstance.triggerExecution(namespace, id, wait, tenant, labels, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#triggerExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **wait** | **Boolean**| If the server will wait the end of the execution | [default to false] |
| **tenant** | **String**|  | |
| **labels** | [**List&lt;String&gt;**](String.md)| The labels as a list of &#39;key:value&#39; | [optional] |
| **revision** | **Integer**| The flow revision or latest if null | [optional] |

### Return type

[**List&lt;ExecutionControllerExecutionResponse&gt;**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **409** | if the flow is disabled |  -  |
| **200** | triggerExecution 200 response |  -  |


## triggerExecutionByGetWebhook

> ExecutionControllerWebhookResponse triggerExecutionByGetWebhook(namespace, id, key, tenant)

Trigger a new execution by GET webhook trigger

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String key = "key_example"; // String | The webhook trigger uid
        String tenant = "tenant_example"; // String | 
        try {
            ExecutionControllerWebhookResponse result = apiInstance.triggerExecutionByGetWebhook(namespace, id, key, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#triggerExecutionByGetWebhook");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **key** | **String**| The webhook trigger uid | |
| **tenant** | **String**|  | |

### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | triggerExecutionByGetWebhook 200 response |  -  |


## triggerExecutionByPostWebhook

> ExecutionControllerWebhookResponse triggerExecutionByPostWebhook(namespace, id, key, tenant)

Trigger a new execution by POST webhook trigger

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String key = "key_example"; // String | The webhook trigger uid
        String tenant = "tenant_example"; // String | 
        try {
            ExecutionControllerWebhookResponse result = apiInstance.triggerExecutionByPostWebhook(namespace, id, key, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#triggerExecutionByPostWebhook");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **key** | **String**| The webhook trigger uid | |
| **tenant** | **String**|  | |

### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | triggerExecutionByPostWebhook 200 response |  -  |


## triggerExecutionByPutWebhook

> ExecutionControllerWebhookResponse triggerExecutionByPutWebhook(namespace, id, key, tenant)

Trigger a new execution by PUT webhook trigger

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String key = "key_example"; // String | The webhook trigger uid
        String tenant = "tenant_example"; // String | 
        try {
            ExecutionControllerWebhookResponse result = apiInstance.triggerExecutionByPutWebhook(namespace, id, key, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#triggerExecutionByPutWebhook");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **key** | **String**| The webhook trigger uid | |
| **tenant** | **String**|  | |

### Return type

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | triggerExecutionByPutWebhook 200 response |  -  |


## unqueueExecution

> Execution unqueueExecution(executionId, state, tenant)

Unqueue an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        StateType state = StateType.fromValue("CREATED"); // StateType | The new state of the execution
        String tenant = "tenant_example"; // String | 
        try {
            Execution result = apiInstance.unqueueExecution(executionId, state, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#unqueueExecution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **state** | [**StateType**](.md)| The new state of the execution | [enum: CREATED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT] |
| **tenant** | **String**|  | |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | unqueueExecution 200 response |  -  |


## unqueueExecutionsByIds

> BulkResponse unqueueExecutionsByIds(state, tenant, requestBody)

Unqueue a list of executions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        StateType state = StateType.fromValue("CREATED"); // StateType | The new state of the unqueued executions
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            BulkResponse result = apiInstance.unqueueExecutionsByIds(state, tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#unqueueExecutionsByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **state** | [**StateType**](.md)| The new state of the unqueued executions | [enum: CREATED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT] |
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Unqueued with errors |  -  |


## unqueueExecutionsByQuery

> Object unqueueExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, newState)

Unqueue executions filter by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        StateType newState = StateType.fromValue("CREATED"); // StateType | The new state of the unqueued executions
        try {
            Object result = apiInstance.unqueueExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, newState);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#unqueueExecutionsByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |
| **newState** | [**StateType**](.md)| The new state of the unqueued executions | [optional] [enum: CREATED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | unqueueExecutionsByQuery 200 response |  -  |


## updateExecutionStatus

> Execution updateExecutionStatus(executionId, status, tenant)

Change the state of an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        StateType status = StateType.fromValue("CREATED"); // StateType | The new state of the execution
        String tenant = "tenant_example"; // String | 
        try {
            Execution result = apiInstance.updateExecutionStatus(executionId, status, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#updateExecutionStatus");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **status** | [**StateType**](.md)| The new state of the execution | [enum: CREATED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT] |
| **tenant** | **String**|  | |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateExecutionStatus 200 response |  -  |


## updateExecutionsStatusByIds

> BulkResponse updateExecutionsStatusByIds(newStatus, tenant, requestBody)

Change executions state by id

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        StateType newStatus = StateType.fromValue("CREATED"); // StateType | The new state of the executions
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            BulkResponse result = apiInstance.updateExecutionsStatusByIds(newStatus, tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#updateExecutionsStatusByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **newStatus** | [**StateType**](.md)| The new state of the executions | [enum: CREATED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT] |
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Changed state with errors |  -  |


## updateExecutionsStatusByQuery

> BulkResponse updateExecutionsStatusByQuery(newStatus, tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter)

Change executions state by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        StateType newStatus = StateType.fromValue("CREATED"); // StateType | The new state of the executions
        String tenant = "tenant_example"; // String | 
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = new DeleteExecutionsByQueryRequest(); // DeleteExecutionsByQueryRequest | 
        String q = "q_example"; // String | A string filter
        List<FlowScope> scope = Arrays.asList(); // List<FlowScope> | The scope of the executions to include
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        String timeRange = "PT5M"; // String | A time range filter relative to the current time
        List<StateType> state = Arrays.asList(); // List<StateType> | A state filter
        List<String> labels = Arrays.asList(); // List<String> | A labels filter as a list of 'key:value'
        String triggerExecutionId = "triggerExecutionId_example"; // String | The trigger execution id
        ExecutionRepositoryInterfaceChildFilter childFilter = ExecutionRepositoryInterfaceChildFilter.fromValue("CHILD"); // ExecutionRepositoryInterfaceChildFilter | A execution child filter
        try {
            BulkResponse result = apiInstance.updateExecutionsStatusByQuery(newStatus, tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#updateExecutionsStatusByQuery");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **newStatus** | [**StateType**](.md)| The new state of the executions | [enum: CREATED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT] |
| **tenant** | **String**|  | |
| **deleteExecutionsByQueryRequest** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | |
| **q** | **String**| A string filter | [optional] |
| **scope** | [**List&lt;FlowScope&gt;**](FlowScope.md)| The scope of the executions to include | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **timeRange** | **String**| A time range filter relative to the current time | [optional] |
| **state** | [**List&lt;StateType&gt;**](StateType.md)| A state filter | [optional] |
| **labels** | [**List&lt;String&gt;**](String.md)| A labels filter as a list of &#39;key:value&#39; | [optional] |
| **triggerExecutionId** | **String**| The trigger execution id | [optional] |
| **childFilter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] [enum: CHILD, MAIN] |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **422** | Changed state with errors |  -  |


## updateTaskRunState

> Execution updateTaskRunState(executionId, tenant, executionControllerStateRequest)

Change state for a taskrun in an execution

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        ExecutionControllerStateRequest executionControllerStateRequest = new ExecutionControllerStateRequest(); // ExecutionControllerStateRequest | the taskRun id and state to apply
        try {
            Execution result = apiInstance.updateTaskRunState(executionId, tenant, executionControllerStateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#updateTaskRunState");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |
| **executionControllerStateRequest** | [**ExecutionControllerStateRequest**](ExecutionControllerStateRequest.md)| the taskRun id and state to apply | |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateTaskRunState 200 response |  -  |


## validateNewExecutionInputs

> List&lt;ExecutionControllerApiValidateExecutionInputsResponse&gt; validateNewExecutionInputs(namespace, id, labels, tenant, revision)

Validate the creation of a new execution for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        List<String> labels = Arrays.asList(); // List<String> | The labels as a list of 'key:value'
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | The flow revision or latest if null
        try {
            List<ExecutionControllerApiValidateExecutionInputsResponse> result = apiInstance.validateNewExecutionInputs(namespace, id, labels, tenant, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#validateNewExecutionInputs");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **labels** | [**List&lt;String&gt;**](String.md)| The labels as a list of &#39;key:value&#39; | |
| **tenant** | **String**|  | |
| **revision** | **Integer**| The flow revision or latest if null | [optional] |

### Return type

[**List&lt;ExecutionControllerApiValidateExecutionInputsResponse&gt;**](ExecutionControllerApiValidateExecutionInputsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **409** | if the flow is disabled |  -  |
| **200** | validateNewExecutionInputs 200 response |  -  |


## validateResumeExecutionInputs

> List&lt;ExecutionControllerApiValidateExecutionInputsResponse&gt; validateResumeExecutionInputs(executionId, tenant)

Validate inputs to resume a paused execution.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ExecutionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ExecutionsApi apiInstance = new ExecutionsApi(defaultClient);
        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            List<ExecutionControllerApiValidateExecutionInputsResponse> result = apiInstance.validateResumeExecutionInputs(executionId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#validateResumeExecutionInputs");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**|  | |

### Return type

[**List&lt;ExecutionControllerApiValidateExecutionInputsResponse&gt;**](ExecutionControllerApiValidateExecutionInputsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | On success |  -  |
| **409** | if the executions is not paused |  -  |
| **200** | validateResumeExecutionInputs 200 response |  -  |

