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

> deleteLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt)

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
        Level minLevel = Level.fromValue("ERROR"); // Level | The min log level filter
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        String taskId = "taskId_example"; // String | The task id
        Integer attempt = 56; // Integer | The attempt number
        try {
            kestraClient.LogsApi().deleteLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt);
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
| **minLevel** | [**Level**](.md)| The min log level filter | [optional] [enum: ERROR, WARN, INFO, DEBUG, TRACE] |
| **taskRunId** | **String**| The taskrun id | [optional] |
| **taskId** | **String**| The task id | [optional] |
| **attempt** | **Integer**| The attempt number | [optional] |

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

> File downloadLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt)

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
        Level minLevel = Level.fromValue("ERROR"); // Level | The min log level filter
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        String taskId = "taskId_example"; // String | The task id
        Integer attempt = 56; // Integer | The attempt number
        try {
            File result = kestraClient.LogsApi().downloadLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt);
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
| **minLevel** | [**Level**](.md)| The min log level filter | [optional] [enum: ERROR, WARN, INFO, DEBUG, TRACE] |
| **taskRunId** | **String**| The taskrun id | [optional] |
| **taskId** | **String**| The task id | [optional] |
| **attempt** | **Integer**| The attempt number | [optional] |

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

> List&lt;LogEntry&gt; listLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt)

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
        Level minLevel = Level.fromValue("ERROR"); // Level | The min log level filter
        String taskRunId = "taskRunId_example"; // String | The taskrun id
        String taskId = "taskId_example"; // String | The task id
        Integer attempt = 56; // Integer | The attempt number
        try {
            List<LogEntry> result = kestraClient.LogsApi().listLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt);
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
| **minLevel** | [**Level**](.md)| The min log level filter | [optional] [enum: ERROR, WARN, INFO, DEBUG, TRACE] |
| **taskRunId** | **String**| The taskrun id | [optional] |
| **taskId** | **String**| The task id | [optional] |
| **attempt** | **Integer**| The attempt number | [optional] |

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

> PagedResultsLogEntry searchLogs(page, size, tenant, sort, filters)

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

        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        try {
            PagedResultsLogEntry result = kestraClient.LogsApi().searchLogs(page, size, tenant, sort, filters);
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
| **page** | **Integer**| The current page | [default to 1] |
| **size** | **Integer**| The current page size | [default to 10] |
| **tenant** | **String**|  | |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | [optional] |

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

