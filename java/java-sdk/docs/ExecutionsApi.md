# ExecutionsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createExecution**](ExecutionsApi.md#createExecution) | **POST** /api/v1/{tenant}/executions/{namespace}/{id} | Create a new execution for a flow |
| [**deleteExecution**](ExecutionsApi.md#deleteExecution) | **DELETE** /api/v1/{tenant}/executions/{executionId} | Delete an execution |
| [**deleteExecutionsByIds**](ExecutionsApi.md#deleteExecutionsByIds) | **DELETE** /api/v1/{tenant}/executions/by-ids | Delete a list of executions |
| [**deleteExecutionsByQuery**](ExecutionsApi.md#deleteExecutionsByQuery) | **DELETE** /api/v1/{tenant}/executions/by-query | Delete executions filter by query parameters |
| [**downloadFileFromExecution**](ExecutionsApi.md#downloadFileFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file | Download file for an execution |
| [**evalExpression**](ExecutionsApi.md#evalExpression) | **POST** /api/v1/{tenant}/executions/{executionId}/eval | Evaluate a variable expression for this execution |
| [**execution**](ExecutionsApi.md#execution) | **GET** /api/v1/{tenant}/executions/{executionId} | Get an execution |
| [**executionFlowGraph**](ExecutionsApi.md#executionFlowGraph) | **GET** /api/v1/{tenant}/executions/{executionId}/graph | Generate a graph for an execution |
| [**fileMetadatasFromExecution**](ExecutionsApi.md#fileMetadatasFromExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/metas | Get file meta information for an execution |
| [**flowFromExecution**](ExecutionsApi.md#flowFromExecution) | **GET** /api/v1/{tenant}/executions/flows/{namespace}/{flowId} | Get flow information&#39;s for an execution |
| [**flowFromExecutionById**](ExecutionsApi.md#flowFromExecutionById) | **GET** /api/v1/{tenant}/executions/{executionId}/flow | Get flow information&#39;s for an execution |
| [**followDependenciesExecutions**](ExecutionsApi.md#followDependenciesExecutions) | **GET** /api/v1/{tenant}/executions/{executionId}/follow-dependencies | Follow all execution dependencies executions |
| [**followExecution**](ExecutionsApi.md#followExecution) | **GET** /api/v1/{tenant}/executions/{executionId}/follow | Follow an execution |
| [**forceRunByIds**](ExecutionsApi.md#forceRunByIds) | **POST** /api/v1/{tenant}/executions/force-run/by-ids | Force run a list of executions asynchronously |
| [**forceRunExecution**](ExecutionsApi.md#forceRunExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/force-run | Force run an execution |
| [**forceRunExecutionsByQuery**](ExecutionsApi.md#forceRunExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/force-run/by-query | Force run executions filter by query parameters asynchronously |
| [**killExecution**](ExecutionsApi.md#killExecution) | **DELETE** /api/v1/{tenant}/executions/{executionId}/kill | Kill an execution |
| [**killExecutionsByIds**](ExecutionsApi.md#killExecutionsByIds) | **DELETE** /api/v1/{tenant}/executions/kill/by-ids | Kill a list of executions asynchronously |
| [**killExecutionsByQuery**](ExecutionsApi.md#killExecutionsByQuery) | **DELETE** /api/v1/{tenant}/executions/kill/by-query | Kill executions filter by query parameters |
| [**latestExecutions**](ExecutionsApi.md#latestExecutions) | **POST** /api/v1/{tenant}/executions/latest | Get the latest execution for given flows |
| [**pauseExecution**](ExecutionsApi.md#pauseExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/pause | Pause a running execution. |
| [**pauseExecutionsByIds**](ExecutionsApi.md#pauseExecutionsByIds) | **POST** /api/v1/{tenant}/executions/pause/by-ids | Pause a list of running executions asynchronously |
| [**pauseExecutionsByQuery**](ExecutionsApi.md#pauseExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/pause/by-query | Pause executions filter by query parameters asynchronously |
| [**replayExecution**](ExecutionsApi.md#replayExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/replay | Create a new execution from an old one and start it from a specified task run id |
| [**replayExecutionWithinputs**](ExecutionsApi.md#replayExecutionWithinputs) | **POST** /api/v1/{tenant}/executions/{executionId}/replay-with-inputs | Create a new execution from an old one and start it from a specified task run id |
| [**replayExecutionsByIds**](ExecutionsApi.md#replayExecutionsByIds) | **POST** /api/v1/{tenant}/executions/replay/by-ids | Create new executions from old ones asynchronously. Keep the flow revision |
| [**replayExecutionsByQuery**](ExecutionsApi.md#replayExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/replay/by-query | Create new executions from old ones filter by query parameters asynchronously. Keep the flow revision |
| [**restartExecution**](ExecutionsApi.md#restartExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/restart | Restart a new execution from an old one |
| [**restartExecutionsByIds**](ExecutionsApi.md#restartExecutionsByIds) | **POST** /api/v1/{tenant}/executions/restart/by-ids | Restart a list of executions asynchronously |
| [**restartExecutionsByQuery**](ExecutionsApi.md#restartExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/restart/by-query | Restart executions filter by query parameters asynchronously |
| [**resumeExecution**](ExecutionsApi.md#resumeExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/resume | Resume a paused execution. |
| [**resumeExecutionsByIds**](ExecutionsApi.md#resumeExecutionsByIds) | **POST** /api/v1/{tenant}/executions/resume/by-ids | Resume a list of paused executions asynchronously |
| [**resumeExecutionsByQuery**](ExecutionsApi.md#resumeExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/resume/by-query | Resume executions filter by query parameters asynchronously |
| [**searchExecutions**](ExecutionsApi.md#searchExecutions) | **GET** /api/v1/{tenant}/executions/search | Search for executions |
| [**searchExecutionsByFlowId**](ExecutionsApi.md#searchExecutionsByFlowId) | **GET** /api/v1/{tenant}/executions | Search for executions for a flow |
| [**setLabelsOnTerminatedExecution**](ExecutionsApi.md#setLabelsOnTerminatedExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/labels | Add or update labels of a terminated execution |
| [**setLabelsOnTerminatedExecutionsByIds**](ExecutionsApi.md#setLabelsOnTerminatedExecutionsByIds) | **POST** /api/v1/{tenant}/executions/labels/by-ids | Set labels on a list of executions asynchronously |
| [**setLabelsOnTerminatedExecutionsByQuery**](ExecutionsApi.md#setLabelsOnTerminatedExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/labels/by-query | Set label on executions filter by query parameters asynchronously |
| [**triggerExecutionByGetWebhook**](ExecutionsApi.md#triggerExecutionByGetWebhook) | **GET** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by GET webhook trigger |
| [**triggerExecutionByGetWebhookWithPath**](ExecutionsApi.md#triggerExecutionByGetWebhookWithPath) | **GET** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key}/{path} | Trigger a new execution by GET webhook trigger |
| [**triggerExecutionByPostWebhookWithPath**](ExecutionsApi.md#triggerExecutionByPostWebhookWithPath) | **POST** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key}/{path} | Trigger a new execution by POST webhook trigger |
| [**triggerExecutionByPutWebhookWithPath**](ExecutionsApi.md#triggerExecutionByPutWebhookWithPath) | **PUT** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key}/{path} | Trigger a new execution by PUT webhook trigger |
| [**unqueueExecution**](ExecutionsApi.md#unqueueExecution) | **POST** /api/v1/{tenant}/executions/{executionId}/unqueue | Unqueue an execution |
| [**unqueueExecutionsByIds**](ExecutionsApi.md#unqueueExecutionsByIds) | **POST** /api/v1/{tenant}/executions/unqueue/by-ids | Unqueue a list of executions asynchronously |
| [**unqueueExecutionsByQuery**](ExecutionsApi.md#unqueueExecutionsByQuery) | **POST** /api/v1/{tenant}/executions/unqueue/by-query | Unqueue executions filter by query parameters asynchronously |
| [**updateExecutionStatus**](ExecutionsApi.md#updateExecutionStatus) | **POST** /api/v1/{tenant}/executions/{executionId}/change-status | Change the state of an execution |
| [**updateExecutionsStatusByIds**](ExecutionsApi.md#updateExecutionsStatusByIds) | **POST** /api/v1/{tenant}/executions/change-status/by-ids | Change executions state by id asynchronously |
| [**updateExecutionsStatusByQuery**](ExecutionsApi.md#updateExecutionsStatusByQuery) | **POST** /api/v1/{tenant}/executions/change-status/by-query | Change executions state by query parameters asynchronously |
| [**updateTaskRunState**](ExecutionsApi.md#updateTaskRunState) | **POST** /api/v1/{tenant}/executions/{executionId}/state | Change state for a taskrun in an execution |



## createExecution

> ExecutionControllerExecutionResponse createExecution(namespace, id, tenant, labels, wait, revision, scheduleDate, breakpoints, kind)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        List<String> labels = Arrays.asList(); // List<String> | The labels as a list of 'key:value'
        Boolean wait = false; // Boolean | If the server will wait the end of the execution
        Integer revision = 56; // Integer | The flow revision or latest if null
        OffsetDateTime scheduleDate = OffsetDateTime.now(); // OffsetDateTime | Schedule the flow on a specific date
        String breakpoints = "breakpoints_example"; // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
        ExecutionKind kind = ExecutionKind.fromValue("NORMAL"); // ExecutionKind | Specific execution kind
        try {
            ExecutionControllerExecutionResponse result = kestraClient.ExecutionsApi().createExecution(namespace, id, tenant, labels, wait, revision, scheduleDate, breakpoints, kind);
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
| **tenant** | **String**|  | |
| **labels** | [**List&lt;String&gt;**](String.md)| The labels as a list of &#39;key:value&#39; | [optional] |
| **wait** | **Boolean**| If the server will wait the end of the execution | [optional] [default to false] |
| **revision** | **Integer**| The flow revision or latest if null | [optional] |
| **scheduleDate** | **OffsetDateTime**| Schedule the flow on a specific date | [optional] |
| **breakpoints** | **String**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] |
| **kind** | [**ExecutionKind**](.md)| Specific execution kind | [optional] [enum: NORMAL, TEST, PLAYGROUND, LOOP] |

### Return type

[**ExecutionControllerExecutionResponse**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On execution created |  -  |
| **409** | if the flow is disabled |  -  |


## deleteExecution

> deleteExecution(executionId, tenant, deleteLogs, deleteMetrics, deleteStorage)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        Boolean deleteLogs = true; // Boolean | Whether to delete execution logs
        Boolean deleteMetrics = true; // Boolean | Whether to delete execution metrics
        Boolean deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
        try {
            kestraClient.ExecutionsApi().deleteExecution(executionId, tenant, deleteLogs, deleteMetrics, deleteStorage);
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
| **tenant** | **String**|  | |
| **deleteLogs** | **Boolean**| Whether to delete execution logs | [optional] [default to true] |
| **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [optional] [default to true] |
| **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [optional] [default to true] |

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
| **200** | deleteExecution 200 response |  -  |
| **204** | On success |  -  |


## deleteExecutionsByIds

> BulkResponse deleteExecutionsByIds(tenant, requestBody, includeNonTerminated, deleteLogs, deleteMetrics, deleteStorage)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The execution id
        Boolean includeNonTerminated = false; // Boolean | Whether to delete non-terminated executions
        Boolean deleteLogs = true; // Boolean | Whether to delete execution logs
        Boolean deleteMetrics = true; // Boolean | Whether to delete execution metrics
        Boolean deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
        try {
            BulkResponse result = kestraClient.ExecutionsApi().deleteExecutionsByIds(tenant, requestBody, includeNonTerminated, deleteLogs, deleteMetrics, deleteStorage);
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
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The execution id | |
| **includeNonTerminated** | **Boolean**| Whether to delete non-terminated executions | [optional] [default to false] |
| **deleteLogs** | **Boolean**| Whether to delete execution logs | [optional] [default to true] |
| **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [optional] [default to true] |
| **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [optional] [default to true] |

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

> Object deleteExecutionsByQuery(tenant, filters, includeNonTerminated, deleteLogs, deleteMetrics, deleteStorage)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        Boolean includeNonTerminated = false; // Boolean | Whether to delete non-terminated executions
        Boolean deleteLogs = true; // Boolean | Whether to delete execution logs
        Boolean deleteMetrics = true; // Boolean | Whether to delete execution metrics
        Boolean deleteStorage = true; // Boolean | Whether to delete execution files in the internal storage
        try {
            Object result = kestraClient.ExecutionsApi().deleteExecutionsByQuery(tenant, filters, includeNonTerminated, deleteLogs, deleteMetrics, deleteStorage);
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
| **tenant** | **String**|  | |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |
| **includeNonTerminated** | **Boolean**| Whether to delete non-terminated executions | [optional] [default to false] |
| **deleteLogs** | **Boolean**| Whether to delete execution logs | [optional] [default to true] |
| **deleteMetrics** | **Boolean**| Whether to delete execution metrics | [optional] [default to true] |
| **deleteStorage** | **Boolean**| Whether to delete execution files in the internal storage | [optional] [default to true] |

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        URI path = new URI(); // URI | The internal storage uri
        String tenant = "tenant_example"; // String | 
        try {
            File result = kestraClient.ExecutionsApi().downloadFileFromExecution(executionId, path, tenant);
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


## evalExpression

> ExecutionControllerEvalResult evalExpression(executionId, tenant, body)

Evaluate a variable expression for this execution

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The Pebble expression that should be evaluated
        try {
            ExecutionControllerEvalResult result = kestraClient.ExecutionsApi().evalExpression(executionId, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#evalExpression");
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
| **200** | evalExpression 200 response |  -  |


## execution

> ApiExecution execution(executionId, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            ApiExecution result = kestraClient.ExecutionsApi().execution(executionId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#execution");
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

[**ApiExecution**](ApiExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getExecution 200 response |  -  |


## executionFlowGraph

> FlowGraph executionFlowGraph(executionId, tenant, subflows)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        List<String> subflows = Arrays.asList(); // List<String> | The subflow tasks to display
        try {
            FlowGraph result = kestraClient.ExecutionsApi().executionFlowGraph(executionId, tenant, subflows);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#executionFlowGraph");
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


## fileMetadatasFromExecution

> FileMetas fileMetadatasFromExecution(executionId, path, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        URI path = new URI(); // URI | The internal storage uri
        String tenant = "tenant_example"; // String | 
        try {
            FileMetas result = kestraClient.ExecutionsApi().fileMetadatasFromExecution(executionId, path, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#fileMetadatasFromExecution");
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


## flowFromExecution

> FlowForExecution flowFromExecution(namespace, flowId, tenant, revision)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace of the flow
        String flowId = "flowId_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | The flow revision
        try {
            FlowForExecution result = kestraClient.ExecutionsApi().flowFromExecution(namespace, flowId, tenant, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#flowFromExecution");
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


## flowFromExecutionById

> FlowForExecution flowFromExecutionById(executionId, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution that you want flow information
        String tenant = "tenant_example"; // String | 
        try {
            FlowForExecution result = kestraClient.ExecutionsApi().flowFromExecutionById(executionId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#flowFromExecutionById");
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
| **executionId** | **String**| The execution that you want flow information | |
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


## followDependenciesExecutions

> EventExecutionStatusEvent followDependenciesExecutions(executionId, tenant, destinationOnly, expandAll)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        Boolean destinationOnly = false; // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
        Boolean expandAll = false; // Boolean | If true, expand all dependencies recursively
        try {
            EventExecutionStatusEvent result = kestraClient.ExecutionsApi().followDependenciesExecutions(executionId, tenant, destinationOnly, expandAll);
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
| **tenant** | **String**|  | |
| **destinationOnly** | **Boolean**| If true, list only destination dependencies, otherwise list also source dependencies | [optional] [default to false] |
| **expandAll** | **Boolean**| If true, expand all dependencies recursively | [optional] [default to false] |

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            EventExecution result = kestraClient.ExecutionsApi().followExecution(executionId, tenant);
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

> Object forceRunByIds(tenant, requestBody)

Force run a list of executions asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            Object result = kestraClient.ExecutionsApi().forceRunByIds(tenant, requestBody);
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | forceRunByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            Execution result = kestraClient.ExecutionsApi().forceRunExecution(executionId, tenant);
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
| **200** | On success |  -  |
| **409** | if the execution cannot be force-run |  -  |


## forceRunExecutionsByQuery

> Object forceRunExecutionsByQuery(tenant, filters)

Force run executions filter by query parameters asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            Object result = kestraClient.ExecutionsApi().forceRunExecutionsByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

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
| **200** | forceRunExecutionsByQuery 200 response |  -  |
| **202** | Accepted |  -  |


## killExecution

> Execution killExecution(executionId, tenant, isOnKillCascade)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        Boolean isOnKillCascade = true; // Boolean | Specifies whether killing the execution also kill all subflow executions.
        try {
            Execution result = kestraClient.ExecutionsApi().killExecution(executionId, tenant, isOnKillCascade);
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
| **tenant** | **String**|  | |
| **isOnKillCascade** | **Boolean**| Specifies whether killing the execution also kill all subflow executions. | [optional] [default to true] |

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **404** | if the executions is not found |  -  |
| **409** | if the executions is already finished |  -  |


## killExecutionsByIds

> Object killExecutionsByIds(tenant, requestBody)

Kill a list of executions asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            Object result = kestraClient.ExecutionsApi().killExecutionsByIds(tenant, requestBody);
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | killExecutionsByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


## killExecutionsByQuery

> Object killExecutionsByQuery(tenant, filters)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            Object result = kestraClient.ExecutionsApi().killExecutionsByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

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
| **200** | killExecutionsByQuery 200 response |  -  |


## latestExecutions

> List&lt;ExecutionControllerLastExecutionResponse&gt; latestExecutions(tenant, executionRepositoryInterfaceFlowFilter)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<ExecutionRepositoryInterfaceFlowFilter> executionRepositoryInterfaceFlowFilter = Arrays.asList(); // List<ExecutionRepositoryInterfaceFlowFilter> | 
        try {
            List<ExecutionControllerLastExecutionResponse> result = kestraClient.ExecutionsApi().latestExecutions(tenant, executionRepositoryInterfaceFlowFilter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#latestExecutions");
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


## pauseExecution

> Execution pauseExecution(executionId, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            Execution result = kestraClient.ExecutionsApi().pauseExecution(executionId, tenant);
            System.out.println(result);
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

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | if the executions is not running |  -  |


## pauseExecutionsByIds

> Object pauseExecutionsByIds(tenant, requestBody)

Pause a list of running executions asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            Object result = kestraClient.ExecutionsApi().pauseExecutionsByIds(tenant, requestBody);
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | pauseExecutionsByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


## pauseExecutionsByQuery

> Object pauseExecutionsByQuery(tenant, filters)

Pause executions filter by query parameters asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            Object result = kestraClient.ExecutionsApi().pauseExecutionsByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

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
| **200** | pauseExecutionsByQuery 200 response |  -  |
| **202** | Accepted |  -  |


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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | the original execution id to clone
        String tenant = "tenant_example"; // String | 
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        Integer revision = 56; // Integer | The flow revision to use for new execution
        String breakpoints = "breakpoints_example"; // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
        try {
            Execution result = kestraClient.ExecutionsApi().replayExecution(executionId, tenant, taskRunId, revision, breakpoints);
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
| **200** | On success |  -  |
| **409** | if the execution cannot be replayed |  -  |


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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | the original execution id to clone
        String tenant = "tenant_example"; // String | 
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        Integer revision = 56; // Integer | The flow revision to use for new execution
        String breakpoints = "breakpoints_example"; // String | Set a list of breakpoints at specific tasks 'id.value', separated by a coma.
        try {
            Execution result = kestraClient.ExecutionsApi().replayExecutionWithinputs(executionId, tenant, taskRunId, revision, breakpoints);
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
| **200** | On success |  -  |
| **409** | if the execution cannot be replayed |  -  |


## replayExecutionsByIds

> Object replayExecutionsByIds(tenant, requestBody, latestRevision)

Create new executions from old ones asynchronously. Keep the flow revision

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        Boolean latestRevision = false; // Boolean | If latest revision should be used
        try {
            Object result = kestraClient.ExecutionsApi().replayExecutionsByIds(tenant, requestBody, latestRevision);
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | replayExecutionsByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


## replayExecutionsByQuery

> Object replayExecutionsByQuery(tenant, filters, latestRevision)

Create new executions from old ones filter by query parameters asynchronously. Keep the flow revision

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        Boolean latestRevision = false; // Boolean | If latest revision should be used
        try {
            Object result = kestraClient.ExecutionsApi().replayExecutionsByQuery(tenant, filters, latestRevision);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |
| **latestRevision** | **Boolean**| If latest revision should be used | [optional] [default to false] |

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
| **200** | replayExecutionsByQuery 200 response |  -  |
| **202** | Accepted |  -  |


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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | The flow revision to use for new execution
        try {
            Execution result = kestraClient.ExecutionsApi().restartExecution(executionId, tenant, revision);
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
| **200** | On success |  -  |
| **409** | if the execution cannot be restarted |  -  |


## restartExecutionsByIds

> Object restartExecutionsByIds(tenant, requestBody)

Restart a list of executions asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            Object result = kestraClient.ExecutionsApi().restartExecutionsByIds(tenant, requestBody);
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | restartExecutionsByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


## restartExecutionsByQuery

> Object restartExecutionsByQuery(tenant, filters)

Restart executions filter by query parameters asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            Object result = kestraClient.ExecutionsApi().restartExecutionsByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

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
| **200** | restartExecutionsByQuery 200 response |  -  |
| **202** | Accepted |  -  |


## resumeExecution

> Execution resumeExecution(executionId, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        try {
            Execution result = kestraClient.ExecutionsApi().resumeExecution(executionId, tenant);
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

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | if the executions is not paused |  -  |


## resumeExecutionsByIds

> Object resumeExecutionsByIds(tenant, requestBody)

Resume a list of paused executions asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            Object result = kestraClient.ExecutionsApi().resumeExecutionsByIds(tenant, requestBody);
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | resumeExecutionsByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


## resumeExecutionsByQuery

> Object resumeExecutionsByQuery(tenant, filters)

Resume executions filter by query parameters asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            Object result = kestraClient.ExecutionsApi().resumeExecutionsByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

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
| **200** | resumeExecutionsByQuery 200 response |  -  |
| **202** | Accepted |  -  |


## searchExecutions

> PagedResultsApiLightExecution searchExecutions(tenant, page, size, sort, filters)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            PagedResultsApiLightExecution result = kestraClient.ExecutionsApi().searchExecutions(tenant, page, size, sort, filters);
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
| **tenant** | **String**|  | |
| **page** | **Integer**| The current page | [optional] [default to 1] |
| **size** | **Integer**| The current page size | [optional] [default to 10] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**PagedResultsApiLightExecution**](PagedResultsApiLightExecution.md)

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

> PagedResultsApiLightExecution searchExecutionsByFlowId(namespace, flowId, tenant, page, size)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String flowId = "flowId_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        try {
            PagedResultsApiLightExecution result = kestraClient.ExecutionsApi().searchExecutionsByFlowId(namespace, flowId, tenant, page, size);
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
| **tenant** | **String**|  | |
| **page** | **Integer**| The current page | [optional] [default to 1] |
| **size** | **Integer**| The current page size | [optional] [default to 10] |

### Return type

[**PagedResultsApiLightExecution**](PagedResultsApiLightExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchExecutionsByFlowId 200 response |  -  |


## setLabelsOnTerminatedExecution

> Execution setLabelsOnTerminatedExecution(executionId, tenant, label)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        List<Label> label = Arrays.asList(); // List<Label> | The labels to add to the execution
        try {
            Execution result = kestraClient.ExecutionsApi().setLabelsOnTerminatedExecution(executionId, tenant, label);
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

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **400** | If the execution is not terminated |  -  |
| **404** | If the execution cannot be found |  -  |
| **409** | If labels cannot be applied |  -  |


## setLabelsOnTerminatedExecutionsByIds

> Object setLabelsOnTerminatedExecutionsByIds(tenant, executionControllerSetLabelsByIdsRequest)

Set labels on a list of executions asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        ExecutionControllerSetLabelsByIdsRequest executionControllerSetLabelsByIdsRequest = new ExecutionControllerSetLabelsByIdsRequest(); // ExecutionControllerSetLabelsByIdsRequest | The request containing a list of labels and a list of executions
        try {
            Object result = kestraClient.ExecutionsApi().setLabelsOnTerminatedExecutionsByIds(tenant, executionControllerSetLabelsByIdsRequest);
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | setLabelsOnTerminatedExecutionsByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


## setLabelsOnTerminatedExecutionsByQuery

> Object setLabelsOnTerminatedExecutionsByQuery(tenant, label, filters)

Set label on executions filter by query parameters asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<Label> label = Arrays.asList(); // List<Label> | The labels to add to the execution
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            Object result = kestraClient.ExecutionsApi().setLabelsOnTerminatedExecutionsByQuery(tenant, label, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

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
| **202** | Accepted |  -  |


## triggerExecutionByGetWebhook

> WebhookResponse triggerExecutionByGetWebhook(namespace, id, key, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String key = "key_example"; // String | The webhook trigger uid
        String tenant = "tenant_example"; // String | 
        try {
            WebhookResponse result = kestraClient.ExecutionsApi().triggerExecutionByGetWebhook(namespace, id, key, tenant);
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

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |


## triggerExecutionByGetWebhookWithPath

> WebhookResponse triggerExecutionByGetWebhookWithPath(namespace, id, key, path, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String key = "key_example"; // String | The webhook trigger uid
        String path = "path_example"; // String | Optional additional path segments
        String tenant = "tenant_example"; // String | 
        try {
            WebhookResponse result = kestraClient.ExecutionsApi().triggerExecutionByGetWebhookWithPath(namespace, id, key, path, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#triggerExecutionByGetWebhookWithPath");
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
| **path** | **String**| Optional additional path segments | |
| **tenant** | **String**|  | |

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |


## triggerExecutionByPostWebhookWithPath

> WebhookResponse triggerExecutionByPostWebhookWithPath(namespace, id, key, path, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String key = "key_example"; // String | The webhook trigger uid
        String path = "path_example"; // String | Optional additional path segments
        String tenant = "tenant_example"; // String | 
        try {
            WebhookResponse result = kestraClient.ExecutionsApi().triggerExecutionByPostWebhookWithPath(namespace, id, key, path, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#triggerExecutionByPostWebhookWithPath");
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
| **path** | **String**| Optional additional path segments | |
| **tenant** | **String**|  | |

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |


## triggerExecutionByPutWebhookWithPath

> WebhookResponse triggerExecutionByPutWebhookWithPath(namespace, id, key, path, tenant)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String key = "key_example"; // String | The webhook trigger uid
        String path = "path_example"; // String | Optional additional path segments
        String tenant = "tenant_example"; // String | 
        try {
            WebhookResponse result = kestraClient.ExecutionsApi().triggerExecutionByPutWebhookWithPath(namespace, id, key, path, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionsApi#triggerExecutionByPutWebhookWithPath");
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
| **path** | **String**| Optional additional path segments | |
| **tenant** | **String**|  | |

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |


## unqueueExecution

> Execution unqueueExecution(executionId, tenant, state)

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        StateType state = StateType.fromValue("CREATED"); // StateType | The new state of the execution
        try {
            Execution result = kestraClient.ExecutionsApi().unqueueExecution(executionId, tenant, state);
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
| **tenant** | **String**|  | |
| **state** | [**StateType**](.md)| The new state of the execution | [optional] [enum: CREATED, SUBMITTED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT, RESUBMITTED] |

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
| **200** | On success |  -  |
| **409** | if the execution cannot be unqueued |  -  |


## unqueueExecutionsByIds

> Object unqueueExecutionsByIds(state, tenant, requestBody)

Unqueue a list of executions asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        StateType state = StateType.fromValue("CREATED"); // StateType | The new state of the unqueued executions
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            Object result = kestraClient.ExecutionsApi().unqueueExecutionsByIds(state, tenant, requestBody);
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
| **state** | [**StateType**](.md)| The new state of the unqueued executions | [enum: CREATED, SUBMITTED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT, RESUBMITTED] |
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

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
| **200** | unqueueExecutionsByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


## unqueueExecutionsByQuery

> Object unqueueExecutionsByQuery(tenant, filters, newState)

Unqueue executions filter by query parameters asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        StateType newState = StateType.fromValue("CREATED"); // StateType | The new state of the unqueued executions
        try {
            Object result = kestraClient.ExecutionsApi().unqueueExecutionsByQuery(tenant, filters, newState);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |
| **newState** | [**StateType**](.md)| The new state of the unqueued executions | [optional] [enum: CREATED, SUBMITTED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT, RESUBMITTED] |

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
| **200** | unqueueExecutionsByQuery 200 response |  -  |
| **202** | Accepted |  -  |


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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        StateType status = StateType.fromValue("CREATED"); // StateType | The new state of the execution
        String tenant = "tenant_example"; // String | 
        try {
            Execution result = kestraClient.ExecutionsApi().updateExecutionStatus(executionId, status, tenant);
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
| **status** | [**StateType**](.md)| The new state of the execution | [enum: CREATED, SUBMITTED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT, RESUBMITTED] |
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
| **200** | On success |  -  |
| **409** | if the execution state cannot be changed |  -  |


## updateExecutionsStatusByIds

> Object updateExecutionsStatusByIds(newStatus, tenant, requestBody)

Change executions state by id asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        StateType newStatus = StateType.fromValue("CREATED"); // StateType | The new state of the executions
        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The list of executions id
        try {
            Object result = kestraClient.ExecutionsApi().updateExecutionsStatusByIds(newStatus, tenant, requestBody);
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
| **newStatus** | [**StateType**](.md)| The new state of the executions | [enum: CREATED, SUBMITTED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT, RESUBMITTED] |
| **tenant** | **String**|  | |
| **requestBody** | [**List&lt;String&gt;**](String.md)| The list of executions id | |

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
| **200** | updateExecutionsStatusByIds 200 response |  -  |
| **202** | Accepted |  -  |
| **400** | Validation errors |  -  |


## updateExecutionsStatusByQuery

> Object updateExecutionsStatusByQuery(newStatus, tenant, filters)

Change executions state by query parameters asynchronously

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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        StateType newStatus = StateType.fromValue("CREATED"); // StateType | The new state of the executions
        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            Object result = kestraClient.ExecutionsApi().updateExecutionsStatusByQuery(newStatus, tenant, filters);
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
| **newStatus** | [**StateType**](.md)| The new state of the executions | [enum: CREATED, SUBMITTED, RUNNING, PAUSED, RESTARTED, KILLING, SUCCESS, WARNING, FAILED, KILLED, CANCELLED, QUEUED, RETRYING, RETRIED, SKIPPED, BREAKPOINT, RESUBMITTED] |
| **tenant** | **String**|  | |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

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
| **200** | updateExecutionsStatusByQuery 200 response |  -  |
| **202** | Accepted |  -  |


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
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        ExecutionControllerStateRequest executionControllerStateRequest = new ExecutionControllerStateRequest(); // ExecutionControllerStateRequest | the taskRun id and state to apply
        try {
            Execution result = kestraClient.ExecutionsApi().updateTaskRunState(executionId, tenant, executionControllerStateRequest);
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
| **200** | On success |  -  |
| **409** | if the task run state cannot be changed |  -  |

