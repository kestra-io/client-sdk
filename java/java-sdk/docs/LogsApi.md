# LogsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteLogsFromExecution**](LogsApi.md#deleteLogsFromExecution) | **DELETE** /api/v1/{tenant}/logs/{executionId} | Delete logs for a specific execution, taskrun or task |
| [**deleteLogsFromFlow**](LogsApi.md#deleteLogsFromFlow) | **DELETE** /api/v1/{tenant}/logs/{namespace}/{flowId} | Delete logs for a specific execution, taskrun or task |
| [**downloadLogsFromExecution**](LogsApi.md#downloadLogsFromExecution) | **GET** /api/v1/{tenant}/logs/{executionId}/download | Download logs for a specific execution, taskrun or task |
| [**listLogsFromExecution**](LogsApi.md#listLogsFromExecution) | **GET** /api/v1/{tenant}/logs/{executionId} | Get logs for a specific execution, taskrun or task |
| [**searchLogs**](LogsApi.md#searchLogs) | **GET** /api/v1/{tenant}/logs/search | Search for logs |



## deleteLogsFromExecution

> deleteLogsFromExecution(executionId, tenant, taskRunId, attempt, minLevel, taskId)

Delete logs for a specific execution, taskrun or task

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.LogsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        Integer attempt = 56; // Integer | The attempt number
        Level minLevel = Level.fromValue("ERROR"); // Level | The min log level filter
        String taskId = "taskId_example"; // String | The task id
        try {
            kestraClient.LogsApi().deleteLogsFromExecution(executionId, tenant, taskRunId, attempt, minLevel, taskId);
        } catch (ApiException e) {
            System.err.println("Exception when calling LogsApi#deleteLogsFromExecution");
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
| **taskRunId** | **String**| The taskrun id | [optional] |
| **attempt** | **Integer**| The attempt number | [optional] |
| **minLevel** | [**Level**](.md)| The min log level filter | [optional] [enum: ERROR, WARN, INFO, DEBUG, TRACE] |
| **taskId** | **String**| The task id | [optional] |

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
| **200** | deleteLogsFromExecution 200 response |  -  |


## deleteLogsFromFlow

> deleteLogsFromFlow(namespace, flowId, triggerId, tenant)

Delete logs for a specific execution, taskrun or task

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.LogsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace
        String flowId = "flowId_example"; // String | The flow identifier
        String triggerId = "triggerId_example"; // String | The trigger id
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.LogsApi().deleteLogsFromFlow(namespace, flowId, triggerId, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling LogsApi#deleteLogsFromFlow");
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
| **flowId** | **String**| The flow identifier | |
| **triggerId** | **String**| The trigger id | |
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
| **200** | deleteLogsFromFlow 200 response |  -  |


## downloadLogsFromExecution

> File downloadLogsFromExecution(executionId, tenant, taskRunId, attempt, minLevel, taskId)

Download logs for a specific execution, taskrun or task

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.LogsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        Integer attempt = 56; // Integer | The attempt number
        Level minLevel = Level.fromValue("ERROR"); // Level | The min log level filter
        String taskId = "taskId_example"; // String | The task id
        try {
            File result = kestraClient.LogsApi().downloadLogsFromExecution(executionId, tenant, taskRunId, attempt, minLevel, taskId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LogsApi#downloadLogsFromExecution");
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
| **taskRunId** | **String**| The taskrun id | [optional] |
| **attempt** | **Integer**| The attempt number | [optional] |
| **minLevel** | [**Level**](.md)| The min log level filter | [optional] [enum: ERROR, WARN, INFO, DEBUG, TRACE] |
| **taskId** | **String**| The task id | [optional] |

### Return type

[**File**](File.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | downloadLogsFromExecution 200 response |  -  |


## listLogsFromExecution

> List&lt;LogEntry&gt; listLogsFromExecution(executionId, tenant, taskRunId, attempt, minLevel, taskId)

Get logs for a specific execution, taskrun or task

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.LogsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String executionId = "executionId_example"; // String | The execution id
        String tenant = "tenant_example"; // String | 
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        Integer attempt = 56; // Integer | The attempt number
        Level minLevel = Level.fromValue("ERROR"); // Level | The min log level filter
        String taskId = "taskId_example"; // String | The task id
        try {
            List<LogEntry> result = kestraClient.LogsApi().listLogsFromExecution(executionId, tenant, taskRunId, attempt, minLevel, taskId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LogsApi#listLogsFromExecution");
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
| **taskRunId** | **String**| The taskrun id | [optional] |
| **attempt** | **Integer**| The attempt number | [optional] |
| **minLevel** | [**Level**](.md)| The min log level filter | [optional] [enum: ERROR, WARN, INFO, DEBUG, TRACE] |
| **taskId** | **String**| The task id | [optional] |

### Return type

[**List&lt;LogEntry&gt;**](LogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listLogsFromExecution 200 response |  -  |


## searchLogs

> PagedResultsLogEntry searchLogs(tenant, filters, size, page, sort)

Search for logs

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.LogsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        Integer size = 10; // Integer | The current page size
        Integer page = 1; // Integer | The current page
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsLogEntry result = kestraClient.LogsApi().searchLogs(tenant, filters, size, page, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LogsApi#searchLogs");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | [optional] |
| **size** | **Integer**| The current page size | [optional] [default to 10] |
| **page** | **Integer**| The current page | [optional] [default to 1] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsLogEntry**](PagedResultsLogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchLogs 200 response |  -  |

