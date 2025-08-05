# BindingsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**bulkCreateBinding**](BindingsApi.md#bulkCreateBinding) | **POST** /api/v1/{tenant}/bindings/bulk | Create multiple bindings |
| [**createBinding**](BindingsApi.md#createBinding) | **POST** /api/v1/{tenant}/bindings | Create a binding |
| [**deleteBinding**](BindingsApi.md#deleteBinding) | **DELETE** /api/v1/{tenant}/bindings/{id} | Delete a binding |
| [**getBinding**](BindingsApi.md#getBinding) | **GET** /api/v1/{tenant}/bindings/{id} | Retrieve a binding |
| [**searchBindings**](BindingsApi.md#searchBindings) | **GET** /api/v1/{tenant}/bindings/search | Search for bindings |



## bulkCreateBinding

> List&lt;IAMBindingControllerApiBindingDetail&gt; bulkCreateBinding(tenant, iaMBindingControllerApiCreateBindingRequest)

Create multiple bindings

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.BindingsApi;

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

        BindingsApi apiInstance = new BindingsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        List<IAMBindingControllerApiCreateBindingRequest> iaMBindingControllerApiCreateBindingRequest = Arrays.asList(); // List<IAMBindingControllerApiCreateBindingRequest> | The bindings
        try {
            List<IAMBindingControllerApiBindingDetail> result = apiInstance.bulkCreateBinding(tenant, iaMBindingControllerApiCreateBindingRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BindingsApi#bulkCreateBinding");
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
| **iaMBindingControllerApiCreateBindingRequest** | [**List&lt;IAMBindingControllerApiCreateBindingRequest&gt;**](IAMBindingControllerApiCreateBindingRequest.md)| The bindings | |

### Return type

[**List&lt;IAMBindingControllerApiBindingDetail&gt;**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | bulkCreateBinding 200 response |  -  |


## createBinding

> IAMBindingControllerApiBindingDetail createBinding(tenant, iaMBindingControllerApiCreateBindingRequest)

Create a binding

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.BindingsApi;

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

        BindingsApi apiInstance = new BindingsApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        IAMBindingControllerApiCreateBindingRequest iaMBindingControllerApiCreateBindingRequest = new IAMBindingControllerApiCreateBindingRequest(); // IAMBindingControllerApiCreateBindingRequest | The binding
        try {
            IAMBindingControllerApiBindingDetail result = apiInstance.createBinding(tenant, iaMBindingControllerApiCreateBindingRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BindingsApi#createBinding");
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
| **iaMBindingControllerApiCreateBindingRequest** | [**IAMBindingControllerApiCreateBindingRequest**](IAMBindingControllerApiCreateBindingRequest.md)| The binding | |

### Return type

[**IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createBinding 200 response |  -  |


## deleteBinding

> deleteBinding(id, tenant)

Delete a binding

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.BindingsApi;

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

        BindingsApi apiInstance = new BindingsApi(defaultClient);
        String id = "id_example"; // String | The binding id
        String tenant = "tenant_example"; // String | 
        try {
            apiInstance.deleteBinding(id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling BindingsApi#deleteBinding");
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
| **id** | **String**| The binding id | |
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


## getBinding

> IAMBindingControllerApiBindingDetail getBinding(id, tenant)

Retrieve a binding

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.BindingsApi;

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

        BindingsApi apiInstance = new BindingsApi(defaultClient);
        String id = "id_example"; // String | The binding id
        String tenant = "tenant_example"; // String | 
        try {
            IAMBindingControllerApiBindingDetail result = apiInstance.getBinding(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BindingsApi#getBinding");
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
| **id** | **String**| The binding id | |
| **tenant** | **String**|  | |

### Return type

[**IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getBinding 200 response |  -  |


## searchBindings

> PagedResultsIAMBindingControllerApiBindingDetail searchBindings(page, size, tenant, q, sort, type, id, namespace)

Search for bindings

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.BindingsApi;

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

        BindingsApi apiInstance = new BindingsApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | A string filter
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        BindingType type = BindingType.fromValue("USER"); // BindingType | Binding type filter
        String id = "id_example"; // String | External id filter
        String namespace = "namespace_example"; // String | A namespace filter
        try {
            PagedResultsIAMBindingControllerApiBindingDetail result = apiInstance.searchBindings(page, size, tenant, q, sort, type, id, namespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BindingsApi#searchBindings");
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
| **type** | [**BindingType**](.md)| Binding type filter | [optional] [enum: USER, GROUP] |
| **id** | **String**| External id filter | [optional] |
| **namespace** | **String**| A namespace filter | [optional] |

### Return type

[**PagedResultsIAMBindingControllerApiBindingDetail**](PagedResultsIAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchBindings 200 response |  -  |

