# TenantAccessApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTenantAccess**](TenantAccessApi.md#createTenantAccess) | **POST** /api/v1/{tenant}/tenant-access | Create tenant access for a user |
| [**createTenantAccess1**](TenantAccessApi.md#createTenantAccess1) | **PUT** /api/v1/{tenant}/tenant-access/{userId} | Create tenant access for a user |
| [**deleteTenantAccess**](TenantAccessApi.md#deleteTenantAccess) | **DELETE** /api/v1/{tenant}/tenant-access/{userId} | Delete tenant access for a user |
| [**getTenantAccess**](TenantAccessApi.md#getTenantAccess) | **GET** /api/v1/{tenant}/tenant-access/{userId} | Retrieve tenant access for a user |
| [**listTenantAccess**](TenantAccessApi.md#listTenantAccess) | **GET** /api/v1/{tenant}/tenant-access | Retrieve users belonging to the tenant |



## createTenantAccess

> createTenantAccess(tenant, iaMTenantAccessControllerApiCreateTenantAccessRequest)

Create tenant access for a user

Grants tenant access permissions to a user identified by email

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TenantAccessApi;

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

        TenantAccessApi apiInstance = new TenantAccessApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        IAMTenantAccessControllerApiCreateTenantAccessRequest iaMTenantAccessControllerApiCreateTenantAccessRequest = new IAMTenantAccessControllerApiCreateTenantAccessRequest(); // IAMTenantAccessControllerApiCreateTenantAccessRequest | 
        try {
            apiInstance.createTenantAccess(tenant, iaMTenantAccessControllerApiCreateTenantAccessRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling TenantAccessApi#createTenantAccess");
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
| **iaMTenantAccessControllerApiCreateTenantAccessRequest** | [**IAMTenantAccessControllerApiCreateTenantAccessRequest**](IAMTenantAccessControllerApiCreateTenantAccessRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Access successfully created |  -  |
| **404** | User not found |  -  |
| **409** | User already has access to the tenant |  -  |


## createTenantAccess1

> createTenantAccess1(userId, tenant)

Create tenant access for a user

Grants tenant access permissions to a user identified by userId

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TenantAccessApi;

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

        TenantAccessApi apiInstance = new TenantAccessApi(defaultClient);
        String userId = "userId_example"; // String | The user id
        String tenant = "tenant_example"; // String | 
        try {
            apiInstance.createTenantAccess1(userId, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling TenantAccessApi#createTenantAccess1");
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
| **userId** | **String**| The user id | |
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
| **201** | Access successfully created |  -  |
| **404** | User not found |  -  |


## deleteTenantAccess

> deleteTenantAccess(userId, tenant)

Delete tenant access for a user

Removes tenant access permissions for the specified user

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TenantAccessApi;

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

        TenantAccessApi apiInstance = new TenantAccessApi(defaultClient);
        String userId = "userId_example"; // String | The user id
        String tenant = "tenant_example"; // String | 
        try {
            apiInstance.deleteTenantAccess(userId, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling TenantAccessApi#deleteTenantAccess");
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
| **userId** | **String**| The user id | |
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
| **204** | Access successfully deleted |  -  |
| **404** | User, or tenant access not found |  -  |


## getTenantAccess

> IAMTenantAccessControllerApiTenantAccess getTenantAccess(userId, tenant)

Retrieve tenant access for a user

Fetches the tenant access configuration for a given user

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TenantAccessApi;

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

        TenantAccessApi apiInstance = new TenantAccessApi(defaultClient);
        String userId = "userId_example"; // String | The user id
        String tenant = "tenant_example"; // String | 
        try {
            IAMTenantAccessControllerApiTenantAccess result = apiInstance.getTenantAccess(userId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TenantAccessApi#getTenantAccess");
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
| **userId** | **String**| The user id | |
| **tenant** | **String**|  | |

### Return type

[**IAMTenantAccessControllerApiTenantAccess**](IAMTenantAccessControllerApiTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tenant access successfully retrieved |  -  |
| **404** | User, or tenant access not found |  -  |


## listTenantAccess

> PagedResultsIAMTenantAccessControllerApiUserTenantAccess listTenantAccess(page, size, tenant, q, sort, type)

Retrieve users belonging to the tenant

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TenantAccessApi;

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

        TenantAccessApi apiInstance = new TenantAccessApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | A string filter
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        UserType type = UserType.fromValue("STANDARD"); // UserType | The type of user
        try {
            PagedResultsIAMTenantAccessControllerApiUserTenantAccess result = apiInstance.listTenantAccess(page, size, tenant, q, sort, type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TenantAccessApi#listTenantAccess");
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
| **type** | [**UserType**](.md)| The type of user | [optional] [enum: STANDARD, SERVICE_ACCOUNT] |

### Return type

[**PagedResultsIAMTenantAccessControllerApiUserTenantAccess**](PagedResultsIAMTenantAccessControllerApiUserTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listTenantAccess 200 response |  -  |

