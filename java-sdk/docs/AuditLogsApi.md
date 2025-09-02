# AuditLogsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**exportAuditLogs**](AuditLogsApi.md#exportAuditLogs) | **GET** /api/v1/{tenant}/auditlogs/export | Export all audit logs as a streamed CSV file |
| [**findAuditLog**](AuditLogsApi.md#findAuditLog) | **POST** /api/v1/{tenant}/auditlogs/find | Find a specific audit log |
| [**getGlobalResourceDiffFromAuditLog**](AuditLogsApi.md#getGlobalResourceDiffFromAuditLog) | **GET** /api/v1/auditlogs/{id}/diff | Retrieve the diff between audit logs from global resource like users |
| [**getResourceDiffFromAuditLog**](AuditLogsApi.md#getResourceDiffFromAuditLog) | **GET** /api/v1/{tenant}/auditlogs/{id}/diff | Retrieve the diff between audit logs |
| [**listAuditLogFromResourceId**](AuditLogsApi.md#listAuditLogFromResourceId) | **GET** /api/v1/{tenant}/auditlogs/history/{detailId} | Find all audit logs about a specific resource. |
| [**searchAuditLogs**](AuditLogsApi.md#searchAuditLogs) | **GET** /api/v1/{tenant}/auditlogs/search | Search for audit logs |
| [**searchAuditLogsForAllTenants**](AuditLogsApi.md#searchAuditLogsForAllTenants) | **GET** /api/v1/auditlogs/search | Search for audit logs across all tenants, required to be SuperAdmin |



## exportAuditLogs

> List&lt;Object&gt; exportAuditLogs(tenant, q, namespace, flowId, executionId, userId, id, resources, startDate, endDate, details, type)

Export all audit logs as a streamed CSV file

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AuditLogsApi;

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

        AuditLogsApi apiInstance = new AuditLogsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | A string filter
        String namespace = "namespace_example"; // String | A namespace filter
        String flowId = "flowId_example"; // String | A flow id filter
        String executionId = "executionId_example"; // String | An execution filter
        String userId = "userId_example"; // String | A user id filter
        String id = "id_example"; // String | A id filter
        List<ResourceType1> resources = Arrays.asList(); // List<ResourceType1> | A resource filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        Map<String, String> details = new HashMap(); // Map<String, String> | A list of auditLog details
        CrudEventType type = CrudEventType.fromValue("READ"); // CrudEventType | The event that create the audit log
        try {
            List<Object> result = apiInstance.exportAuditLogs(tenant, q, namespace, flowId, executionId, userId, id, resources, startDate, endDate, details, type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuditLogsApi#exportAuditLogs");
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
| **q** | **String**| A string filter | [optional] |
| **namespace** | **String**| A namespace filter | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **executionId** | **String**| An execution filter | [optional] |
| **userId** | **String**| A user id filter | [optional] |
| **id** | **String**| A id filter | [optional] |
| **resources** | [**List&lt;ResourceType1&gt;**](ResourceType1.md)| A resource filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **details** | [**Map&lt;String, String&gt;**](String.md)| A list of auditLog details | [optional] |
| **type** | [**CrudEventType**](.md)| The event that create the audit log | [optional] [enum: READ, CREATE, UPDATE, DELETE, LOGIN, LOGOUT, IMPERSONATE, LOGIN_FAILURE, ACCOUNT_LOCKED] |

### Return type

**List&lt;Object&gt;**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/csv


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | exportAuditLogs 200 response |  -  |


## findAuditLog

> AuditLogControllerApiAuditLogItem findAuditLog(tenant, auditLogControllerFindRequest)

Find a specific audit log

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AuditLogsApi;

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

        AuditLogsApi apiInstance = new AuditLogsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        AuditLogControllerFindRequest auditLogControllerFindRequest = new AuditLogControllerFindRequest(); // AuditLogControllerFindRequest | The find request
        try {
            AuditLogControllerApiAuditLogItem result = apiInstance.findAuditLog(tenant, auditLogControllerFindRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuditLogsApi#findAuditLog");
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
| **auditLogControllerFindRequest** | [**AuditLogControllerFindRequest**](AuditLogControllerFindRequest.md)| The find request | |

### Return type

[**AuditLogControllerApiAuditLogItem**](AuditLogControllerApiAuditLogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | findAuditLog 200 response |  -  |


## getGlobalResourceDiffFromAuditLog

> AuditLogControllerAuditLogDiff getGlobalResourceDiffFromAuditLog(id, previousId)

Retrieve the diff between audit logs from global resource like users

Retrieves the diff between the current version and a selected previous version of a given resource based on audit logs.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AuditLogsApi;

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

        AuditLogsApi apiInstance = new AuditLogsApi(defaultClient);
        String id = "id_example"; // String | The id of the audit log
        String previousId = "previousId_example"; // String | The id of a previous audit log to compare with
        try {
            AuditLogControllerAuditLogDiff result = apiInstance.getGlobalResourceDiffFromAuditLog(id, previousId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuditLogsApi#getGlobalResourceDiffFromAuditLog");
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
| **id** | **String**| The id of the audit log | |
| **previousId** | **String**| The id of a previous audit log to compare with | [optional] |

### Return type

[**AuditLogControllerAuditLogDiff**](AuditLogControllerAuditLogDiff.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getGlobalResourceDiffFromAuditLog 200 response |  -  |


## getResourceDiffFromAuditLog

> AuditLogControllerAuditLogDiff getResourceDiffFromAuditLog(id, tenant, previousId)

Retrieve the diff between audit logs

Retrieves the diff between the current version and a selected previous version of a given resource based on audit logs.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AuditLogsApi;

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

        AuditLogsApi apiInstance = new AuditLogsApi(defaultClient);
        String id = "id_example"; // String | The id of the audit log
        String tenant = "tenant_example"; // String | 
        String previousId = "previousId_example"; // String | The id of a previous audit log to compare with
        try {
            AuditLogControllerAuditLogDiff result = apiInstance.getResourceDiffFromAuditLog(id, tenant, previousId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuditLogsApi#getResourceDiffFromAuditLog");
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
| **id** | **String**| The id of the audit log | |
| **tenant** | **String**|  | |
| **previousId** | **String**| The id of a previous audit log to compare with | [optional] |

### Return type

[**AuditLogControllerAuditLogDiff**](AuditLogControllerAuditLogDiff.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getResourceDiffFromAuditLog 200 response |  -  |


## listAuditLogFromResourceId

> List&lt;AuditLogControllerAuditLogOption&gt; listAuditLogFromResourceId(detailId, tenant)

Find all audit logs about a specific resource.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AuditLogsApi;

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

        AuditLogsApi apiInstance = new AuditLogsApi(defaultClient);
        String detailId = "detailId_example"; // String | The resource Id
        String tenant = "tenant_example"; // String | 
        try {
            List<AuditLogControllerAuditLogOption> result = apiInstance.listAuditLogFromResourceId(detailId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuditLogsApi#listAuditLogFromResourceId");
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
| **detailId** | **String**| The resource Id | |
| **tenant** | **String**|  | |

### Return type

[**List&lt;AuditLogControllerAuditLogOption&gt;**](AuditLogControllerAuditLogOption.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listAuditLogFromResourceId 200 response |  -  |


## searchAuditLogs

> PagedResultsAuditLogControllerApiAuditLogItem searchAuditLogs(page, size, tenant, q, sort, namespace, flowId, executionId, userId, id, resources, startDate, endDate, details, type)

Search for audit logs

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AuditLogsApi;

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

        AuditLogsApi apiInstance = new AuditLogsApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | A string filter
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        String namespace = "namespace_example"; // String | A namespace filter
        String flowId = "flowId_example"; // String | A flow id filter
        String executionId = "executionId_example"; // String | An execution filter
        String userId = "userId_example"; // String | A user id filter
        String id = "id_example"; // String | A id filter
        List<ResourceType1> resources = Arrays.asList(); // List<ResourceType1> | A resource filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        Map<String, String> details = new HashMap(); // Map<String, String> | A list of auditLog details
        CrudEventType type = CrudEventType.fromValue("READ"); // CrudEventType | The event that create the audit log
        try {
            PagedResultsAuditLogControllerApiAuditLogItem result = apiInstance.searchAuditLogs(page, size, tenant, q, sort, namespace, flowId, executionId, userId, id, resources, startDate, endDate, details, type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuditLogsApi#searchAuditLogs");
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
| **q** | **String**| A string filter | [optional] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **namespace** | **String**| A namespace filter | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **executionId** | **String**| An execution filter | [optional] |
| **userId** | **String**| A user id filter | [optional] |
| **id** | **String**| A id filter | [optional] |
| **resources** | [**List&lt;ResourceType1&gt;**](ResourceType1.md)| A resource filter | [optional] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **details** | [**Map&lt;String, String&gt;**](String.md)| A list of auditLog details | [optional] |
| **type** | [**CrudEventType**](.md)| The event that create the audit log | [optional] [enum: READ, CREATE, UPDATE, DELETE, LOGIN, LOGOUT, IMPERSONATE, LOGIN_FAILURE, ACCOUNT_LOCKED] |

### Return type

[**PagedResultsAuditLogControllerApiAuditLogItem**](PagedResultsAuditLogControllerApiAuditLogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchAuditLogs 200 response |  -  |


## searchAuditLogsForAllTenants

> PagedResultsAuditLogControllerApiAuditLogItem searchAuditLogsForAllTenants(page, size, q, sort, namespace, flowId, executionId, userId, id, resource, startDate, endDate, details, type)

Search for audit logs across all tenants, required to be SuperAdmin

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AuditLogsApi;

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

        AuditLogsApi apiInstance = new AuditLogsApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String q = "q_example"; // String | A string filter
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        String namespace = "namespace_example"; // String | A namespace filter
        String flowId = "flowId_example"; // String | A flow id filter
        String executionId = "executionId_example"; // String | An execution filter
        String userId = "userId_example"; // String | A user id filter
        String id = "id_example"; // String | A id filter
        ResourceType1 resource = ResourceType1.fromValue("AUDITLOG"); // ResourceType1 | A resource filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        Map<String, String> details = new HashMap(); // Map<String, String> | A list of auditLog details
        CrudEventType type = CrudEventType.fromValue("READ"); // CrudEventType | The event that create the audit log
        try {
            PagedResultsAuditLogControllerApiAuditLogItem result = apiInstance.searchAuditLogsForAllTenants(page, size, q, sort, namespace, flowId, executionId, userId, id, resource, startDate, endDate, details, type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuditLogsApi#searchAuditLogsForAllTenants");
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
| **q** | **String**| A string filter | [optional] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **namespace** | **String**| A namespace filter | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |
| **executionId** | **String**| An execution filter | [optional] |
| **userId** | **String**| A user id filter | [optional] |
| **id** | **String**| A id filter | [optional] |
| **resource** | [**ResourceType1**](.md)| A resource filter | [optional] [enum: AUDITLOG, APP, APP_EXECUTION, BINDING, DASHBOARD, EXECUTION, FLOW, GROUP, INVITATION, NAMESPACE, ROLE, SECURITY_INTEGRATION, SECRET, SETTING, TEMPLATE, TENANT, TENANT_ACCESS, TESTSUITE, TESTSUITE_RUN, VERSIONED_PLUGIN, USER, WORKER_GROUP, INSTANCE, UNKNOWN] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **details** | [**Map&lt;String, String&gt;**](String.md)| A list of auditLog details | [optional] |
| **type** | [**CrudEventType**](.md)| The event that create the audit log | [optional] [enum: READ, CREATE, UPDATE, DELETE, LOGIN, LOGOUT, IMPERSONATE, LOGIN_FAILURE, ACCOUNT_LOCKED] |

### Return type

[**PagedResultsAuditLogControllerApiAuditLogItem**](PagedResultsAuditLogControllerApiAuditLogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchAuditLogsForAllTenants 200 response |  -  |

