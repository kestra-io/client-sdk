# KvApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteKeyValue**](KvApi.md#deleteKeyValue) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Delete a key-value pair |
| [**deleteKeyValues**](KvApi.md#deleteKeyValues) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv | Bulk-delete multiple key/value pairs from the given namespace. |
| [**getKeyValue**](KvApi.md#getKeyValue) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Get value for a key |
| [**listKeys**](KvApi.md#listKeys) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv | List all keys for a namespace |
| [**listKeysWithInheritence**](KvApi.md#listKeysWithInheritence) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/inheritance | List all keys for a namespace and parent namespaces |
| [**setKeyValue**](KvApi.md#setKeyValue) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Puts a key-value pair in store |



## deleteKeyValue

> Boolean deleteKeyValue(namespace, key, tenant)

Delete a key-value pair

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.KvApi;

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

        KvApi apiInstance = new KvApi(defaultClient);
        String namespace = "namespace_example"; // String | The namespace id
        String key = "key_example"; // String | The key
        String tenant = "tenant_example"; // String | 
        try {
            Boolean result = apiInstance.deleteKeyValue(namespace, key, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KvApi#deleteKeyValue");
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
| **namespace** | **String**| The namespace id | |
| **key** | **String**| The key | |
| **tenant** | **String**|  | |

### Return type

**Boolean**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteKeyValue 200 response |  -  |


## deleteKeyValues

> KVControllerApiDeleteBulkResponse deleteKeyValues(namespace, tenant, kvControllerApiDeleteBulkRequest)

Bulk-delete multiple key/value pairs from the given namespace.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.KvApi;

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

        KvApi apiInstance = new KvApi(defaultClient);
        String namespace = "namespace_example"; // String | The namespace id
        String tenant = "tenant_example"; // String | 
        KVControllerApiDeleteBulkRequest kvControllerApiDeleteBulkRequest = new KVControllerApiDeleteBulkRequest(); // KVControllerApiDeleteBulkRequest | The keys
        try {
            KVControllerApiDeleteBulkResponse result = apiInstance.deleteKeyValues(namespace, tenant, kvControllerApiDeleteBulkRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KvApi#deleteKeyValues");
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
| **namespace** | **String**| The namespace id | |
| **tenant** | **String**|  | |
| **kvControllerApiDeleteBulkRequest** | [**KVControllerApiDeleteBulkRequest**](KVControllerApiDeleteBulkRequest.md)| The keys | |

### Return type

[**KVControllerApiDeleteBulkResponse**](KVControllerApiDeleteBulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteKeyValues 200 response |  -  |


## getKeyValue

> KVControllerTypedValue getKeyValue(namespace, key, tenant)

Get value for a key

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.KvApi;

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

        KvApi apiInstance = new KvApi(defaultClient);
        String namespace = "namespace_example"; // String | The namespace id
        String key = "key_example"; // String | The key
        String tenant = "tenant_example"; // String | 
        try {
            KVControllerTypedValue result = apiInstance.getKeyValue(namespace, key, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KvApi#getKeyValue");
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
| **namespace** | **String**| The namespace id | |
| **key** | **String**| The key | |
| **tenant** | **String**|  | |

### Return type

[**KVControllerTypedValue**](KVControllerTypedValue.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getKeyValue 200 response |  -  |


## listKeys

> List&lt;KVEntry&gt; listKeys(namespace, tenant)

List all keys for a namespace

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.KvApi;

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

        KvApi apiInstance = new KvApi(defaultClient);
        String namespace = "namespace_example"; // String | The namespace id
        String tenant = "tenant_example"; // String | 
        try {
            List<KVEntry> result = apiInstance.listKeys(namespace, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KvApi#listKeys");
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
| **namespace** | **String**| The namespace id | |
| **tenant** | **String**|  | |

### Return type

[**List&lt;KVEntry&gt;**](KVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listKeys 200 response |  -  |


## listKeysWithInheritence

> List&lt;KVEntry&gt; listKeysWithInheritence(namespace, tenant)

List all keys for a namespace and parent namespaces

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.KvApi;

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

        KvApi apiInstance = new KvApi(defaultClient);
        String namespace = "namespace_example"; // String | The namespace id
        String tenant = "tenant_example"; // String | 
        try {
            List<KVEntry> result = apiInstance.listKeysWithInheritence(namespace, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KvApi#listKeysWithInheritence");
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
| **namespace** | **String**| The namespace id | |
| **tenant** | **String**|  | |

### Return type

[**List&lt;KVEntry&gt;**](KVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listKeysWithInheritence 200 response |  -  |


## setKeyValue

> setKeyValue(namespace, key, tenant, body)

Puts a key-value pair in store

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.KvApi;

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

        KvApi apiInstance = new KvApi(defaultClient);
        String namespace = "namespace_example"; // String | The namespace id
        String key = "key_example"; // String | The key
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The value of the key
        try {
            apiInstance.setKeyValue(namespace, key, tenant, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling KvApi#setKeyValue");
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
| **namespace** | **String**| The namespace id | |
| **key** | **String**| The key | |
| **tenant** | **String**|  | |
| **body** | **String**| The value of the key | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json, text/plain
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | setKeyValue 200 response |  -  |

