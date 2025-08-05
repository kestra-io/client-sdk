# AuditLogsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**findAuditLog**](AuditLogsApi.md#findAuditLog) | **POST** /api/v1/{tenant}/auditlogs/find | Find a specific audit log |
| [**getResourceDiffFromAuditLog**](AuditLogsApi.md#getResourceDiffFromAuditLog) | **GET** /api/v1/{tenant}/auditlogs/{id}/diff | Retrieve the diff between audit logs |
| [**listAuditLogFromResourceId**](AuditLogsApi.md#listAuditLogFromResourceId) | **GET** /api/v1/{tenant}/auditlogs/history/{detailId} | Find all audit logs about a specific resource. |
| [**searchAuditLogs**](AuditLogsApi.md#searchAuditLogs) | **GET** /api/v1/{tenant}/auditlogs/search | Search for audit logs |



## findAuditLog

> AuditLogControllerAuditLogWithUser findAuditLog(tenant, auditLogControllerFindRequest)

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
            AuditLogControllerAuditLogWithUser result = apiInstance.findAuditLog(tenant, auditLogControllerFindRequest);
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

[**AuditLogControllerAuditLogWithUser**](AuditLogControllerAuditLogWithUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | findAuditLog 200 response |  -  |


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

> PagedResultsAuditLogControllerAuditLogWithUser searchAuditLogs(page, size, tenant, q, sort, namespace, flowId, executionId, userId, id, permission, startDate, endDate, details, type)

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
        Permission permission = Permission.fromValue("FLOW"); // Permission | A permission filter
        OffsetDateTime startDate = OffsetDateTime.now(); // OffsetDateTime | The start datetime
        OffsetDateTime endDate = OffsetDateTime.now(); // OffsetDateTime | The end datetime
        Map<String, String> details = new HashMap(); // Map<String, String> | A list of auditLog details
        CrudEventType type = CrudEventType.fromValue("READ"); // CrudEventType | The event that create the audit log
        try {
            PagedResultsAuditLogControllerAuditLogWithUser result = apiInstance.searchAuditLogs(page, size, tenant, q, sort, namespace, flowId, executionId, userId, id, permission, startDate, endDate, details, type);
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
| **permission** | [**Permission**](.md)| A permission filter | [optional] [enum: FLOW, BLUEPRINT, TEMPLATE, NAMESPACE, EXECUTION, USER, GROUP, ROLE, BINDING, AUDITLOG, SECRET, KVSTORE, IMPERSONATE, SETTING, INFRASTRUCTURE, APP, APPEXECUTION, TEST, DASHBOARD, TENANT_ACCESS, SERVICE_ACCOUNT, INVITATION, GROUP_MEMBERSHIP, UNKNOWN] |
| **startDate** | **OffsetDateTime**| The start datetime | [optional] |
| **endDate** | **OffsetDateTime**| The end datetime | [optional] |
| **details** | [**Map&lt;String, String&gt;**](String.md)| A list of auditLog details | [optional] |
| **type** | [**CrudEventType**](.md)| The event that create the audit log | [optional] [enum: READ, CREATE, UPDATE, DELETE, LOGIN, LOGOUT, IMPERSONATE, LOGIN_FAILURE, ACCOUNT_LOCKED] |

### Return type

[**PagedResultsAuditLogControllerAuditLogWithUser**](PagedResultsAuditLogControllerAuditLogWithUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchAuditLogs 200 response |  -  |

