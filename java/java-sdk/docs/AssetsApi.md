# AssetsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**asset**](AssetsApi.md#asset) | **GET** /api/v1/{tenant}/assets/{id} | Retrieve an asset |
| [**assetDependencies**](AssetsApi.md#assetDependencies) | **GET** /api/v1/{tenant}/assets/{id}/dependencies | Get an asset dependencies |
| [**createAsset**](AssetsApi.md#createAsset) | **POST** /api/v1/{tenant}/assets | Create a new asset |
| [**deleteAsset**](AssetsApi.md#deleteAsset) | **DELETE** /api/v1/{tenant}/assets/{id} | Delete an asset |
| [**deleteAssetsByIds**](AssetsApi.md#deleteAssetsByIds) | **DELETE** /api/v1/{tenant}/assets/by-ids | Delete assets by asset ids |
| [**deleteAssetsByQuery**](AssetsApi.md#deleteAssetsByQuery) | **DELETE** /api/v1/{tenant}/assets/by-query | Delete assets by query |
| [**searchAssetUsages**](AssetsApi.md#searchAssetUsages) | **GET** /api/v1/{tenant}/assets/usages/search | Search for asset usages |
| [**searchAssets**](AssetsApi.md#searchAssets) | **GET** /api/v1/{tenant}/assets/search | Search for assets |



## asset

> AssetsControllerApiAsset asset(id, tenant)

Retrieve an asset

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The ID of the asset
        String tenant = "tenant_example"; // String | 
        try {
            AssetsControllerApiAsset result = kestraClient.AssetsApi().asset(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#asset");
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
| **id** | **String**| The ID of the asset | |
| **tenant** | **String**|  | |

### Return type

[**AssetsControllerApiAsset**](AssetsControllerApiAsset.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getAsset 200 response |  -  |


## assetDependencies

> AssetTopologyGraph assetDependencies(id, destinationOnly, expandAll, tenant)

Get an asset dependencies

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The asset id
        Boolean destinationOnly = false; // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
        Boolean expandAll = false; // Boolean | If true, expand all dependencies recursively
        String tenant = "tenant_example"; // String | 
        try {
            AssetTopologyGraph result = kestraClient.AssetsApi().assetDependencies(id, destinationOnly, expandAll, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#assetDependencies");
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
| **id** | **String**| The asset id | |
| **destinationOnly** | **Boolean**| If true, list only destination dependencies, otherwise list also source dependencies | [default to false] |
| **expandAll** | **Boolean**| If true, expand all dependencies recursively | [default to false] |
| **tenant** | **String**|  | |

### Return type

[**AssetTopologyGraph**](AssetTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getAssetDependencies 200 response |  -  |


## createAsset

> AssetsControllerApiAsset createAsset(tenant, body)

Create a new asset

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The asset
        try {
            AssetsControllerApiAsset result = kestraClient.AssetsApi().createAsset(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#createAsset");
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
| **body** | **String**| The asset | |

### Return type

[**AssetsControllerApiAsset**](AssetsControllerApiAsset.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createAsset 200 response |  -  |


## deleteAsset

> deleteAsset(id, tenant)

Delete an asset

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The ID of the asset
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.AssetsApi().deleteAsset(id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#deleteAsset");
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
| **id** | **String**| The ID of the asset | |
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
| **200** | deleteAsset 200 response |  -  |


## deleteAssetsByIds

> Object deleteAssetsByIds(tenant, requestBody)

Delete assets by asset ids

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The asset ids
        try {
            Object result = kestraClient.AssetsApi().deleteAssetsByIds(tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#deleteAssetsByIds");
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
| **requestBody** | [**List&lt;String&gt;**](String.md)| The asset ids | |

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
| **200** | deleteAssetsByIds 200 response |  -  |


## deleteAssetsByQuery

> Object deleteAssetsByQuery(filters, tenant)

Delete assets by query

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String tenant = "tenant_example"; // String | 
        try {
            Object result = kestraClient.AssetsApi().deleteAssetsByQuery(filters, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#deleteAssetsByQuery");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | |
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
| **200** | deleteAssetsByQuery 200 response |  -  |


## searchAssetUsages

> PagedResultsAssetsControllerApiAssetUsage searchAssetUsages(page, size, filters, tenant, sort)

Search for asset usages

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String tenant = "tenant_example"; // String | 
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsAssetsControllerApiAssetUsage result = kestraClient.AssetsApi().searchAssetUsages(page, size, filters, tenant, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#searchAssetUsages");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | |
| **tenant** | **String**|  | |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsAssetsControllerApiAssetUsage**](PagedResultsAssetsControllerApiAssetUsage.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchAssetUsages 200 response |  -  |


## searchAssets

> PagedResultsAssetsControllerApiAsset searchAssets(page, size, filters, tenant, sort)

Search for assets

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String tenant = "tenant_example"; // String | 
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsAssetsControllerApiAsset result = kestraClient.AssetsApi().searchAssets(page, size, filters, tenant, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#searchAssets");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | |
| **tenant** | **String**|  | |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsAssetsControllerApiAsset**](PagedResultsAssetsControllerApiAsset.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchAssets 200 response |  -  |

