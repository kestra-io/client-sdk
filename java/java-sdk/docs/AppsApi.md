# AppsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**app**](AppsApi.md#app) | **GET** /api/v1/{tenant}/apps/{uid} | Retrieve an app |
| [**bulkDeleteApps**](AppsApi.md#bulkDeleteApps) | **DELETE** /api/v1/{tenant}/apps | Delete existing apps |
| [**bulkDisableApps**](AppsApi.md#bulkDisableApps) | **POST** /api/v1/{tenant}/apps/disable | Disable existing apps |
| [**bulkEnableApps**](AppsApi.md#bulkEnableApps) | **POST** /api/v1/{tenant}/apps/enable | Enable existing apps |
| [**bulkExportApps**](AppsApi.md#bulkExportApps) | **POST** /api/v1/{tenant}/apps/export | Export apps as a ZIP archive of YAML sources. |
| [**bulkImportApps**](AppsApi.md#bulkImportApps) | **POST** /api/v1/{tenant}/apps/import |     Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned.  |
| [**createApp**](AppsApi.md#createApp) | **POST** /api/v1/{tenant}/apps | Create a new app |
| [**deleteApp**](AppsApi.md#deleteApp) | **DELETE** /api/v1/{tenant}/apps/{uid} | Delete an existing app |
| [**disableApp**](AppsApi.md#disableApp) | **POST** /api/v1/{tenant}/apps/{uid}/disable | Disable the app. |
| [**enableApp**](AppsApi.md#enableApp) | **POST** /api/v1/{tenant}/apps/{uid}/enable | Enable the app. |
| [**listTags**](AppsApi.md#listTags) | **GET** /api/v1/{tenant}/apps/tags | Get all the app tags |
| [**searchApps**](AppsApi.md#searchApps) | **GET** /api/v1/{tenant}/apps/search | Search for apps |
| [**searchAppsFromCatalog**](AppsApi.md#searchAppsFromCatalog) | **GET** /api/v1/{tenant}/apps/catalog | Search for apps from catalog |
| [**updateApp**](AppsApi.md#updateApp) | **PUT** /api/v1/{tenant}/apps/{uid} | Update an existing app |



## app

> AppsControllerApiAppSource app(uid, tenant)

Retrieve an app

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String uid = "uid_example"; // String | The ID of the app
        String tenant = "tenant_example"; // String | 
        try {
            AppsControllerApiAppSource result = kestraClient.AppsApi().app(uid, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#app");
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
| **uid** | **String**| The ID of the app | |
| **tenant** | **String**|  | |

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getApp 200 response |  -  |


## bulkDeleteApps

> Object bulkDeleteApps(tenant, appsControllerApiBulkOperationRequest)

Delete existing apps

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        AppsControllerApiBulkOperationRequest appsControllerApiBulkOperationRequest = new AppsControllerApiBulkOperationRequest(); // AppsControllerApiBulkOperationRequest | The list of Apps UID
        try {
            Object result = kestraClient.AppsApi().bulkDeleteApps(tenant, appsControllerApiBulkOperationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#bulkDeleteApps");
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
| **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | |

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
| **200** | bulkDeleteApps 200 response |  -  |


## bulkDisableApps

> Object bulkDisableApps(tenant, appsControllerApiBulkOperationRequest)

Disable existing apps

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        AppsControllerApiBulkOperationRequest appsControllerApiBulkOperationRequest = new AppsControllerApiBulkOperationRequest(); // AppsControllerApiBulkOperationRequest | The list of Apps UID
        try {
            Object result = kestraClient.AppsApi().bulkDisableApps(tenant, appsControllerApiBulkOperationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#bulkDisableApps");
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
| **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | |

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
| **200** | bulkDisableApps 200 response |  -  |


## bulkEnableApps

> Object bulkEnableApps(tenant, appsControllerApiBulkOperationRequest)

Enable existing apps

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        AppsControllerApiBulkOperationRequest appsControllerApiBulkOperationRequest = new AppsControllerApiBulkOperationRequest(); // AppsControllerApiBulkOperationRequest | The list of Apps UID
        try {
            Object result = kestraClient.AppsApi().bulkEnableApps(tenant, appsControllerApiBulkOperationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#bulkEnableApps");
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
| **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | |

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
| **200** | bulkEnableApps 200 response |  -  |


## bulkExportApps

> byte[] bulkExportApps(tenant, appsControllerApiBulkOperationRequest)

Export apps as a ZIP archive of YAML sources.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        AppsControllerApiBulkOperationRequest appsControllerApiBulkOperationRequest = new AppsControllerApiBulkOperationRequest(); // AppsControllerApiBulkOperationRequest | The list of Apps UID
        try {
            byte[] result = kestraClient.AppsApi().bulkExportApps(tenant, appsControllerApiBulkOperationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#bulkExportApps");
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
| **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | |

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | bulkExportApps 200 response |  -  |


## bulkImportApps

> AppsControllerApiBulkImportResponse bulkImportApps(tenant, fileUpload)

    Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        File fileUpload = new File("/path/to/file"); // File | The file to import, can be a ZIP archive or a multi-objects YAML file
        try {
            AppsControllerApiBulkImportResponse result = kestraClient.AppsApi().bulkImportApps(tenant, fileUpload);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#bulkImportApps");
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
| **fileUpload** | **File**| The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] |

### Return type

[**AppsControllerApiBulkImportResponse**](AppsControllerApiBulkImportResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |


## createApp

> AppsControllerApiAppSource createApp(tenant, body)

Create a new app

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The app
        try {
            AppsControllerApiAppSource result = kestraClient.AppsApi().createApp(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#createApp");
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
| **body** | **String**| The app | |

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createApp 200 response |  -  |


## deleteApp

> Object deleteApp(uid, tenant)

Delete an existing app

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String uid = "uid_example"; // String | The ID of the app
        String tenant = "tenant_example"; // String | 
        try {
            Object result = kestraClient.AppsApi().deleteApp(uid, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#deleteApp");
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
| **uid** | **String**| The ID of the app | |
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
| **200** | deleteApp 200 response |  -  |


## disableApp

> AppsControllerApiApp disableApp(uid, tenant)

Disable the app.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String uid = "uid_example"; // String | The ID of app
        String tenant = "tenant_example"; // String | 
        try {
            AppsControllerApiApp result = kestraClient.AppsApi().disableApp(uid, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#disableApp");
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
| **uid** | **String**| The ID of app | |
| **tenant** | **String**|  | |

### Return type

[**AppsControllerApiApp**](AppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | disableApp 200 response |  -  |


## enableApp

> AppsControllerApiApp enableApp(uid, tenant)

Enable the app.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String uid = "uid_example"; // String | The ID of app
        String tenant = "tenant_example"; // String | 
        try {
            AppsControllerApiApp result = kestraClient.AppsApi().enableApp(uid, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#enableApp");
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
| **uid** | **String**| The ID of app | |
| **tenant** | **String**|  | |

### Return type

[**AppsControllerApiApp**](AppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | enableApp 200 response |  -  |


## listTags

> AppsControllerApiAppTags listTags(tenant)

Get all the app tags

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        try {
            AppsControllerApiAppTags result = kestraClient.AppsApi().listTags(tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#listTags");
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

[**AppsControllerApiAppTags**](AppsControllerApiAppTags.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listTags 200 response |  -  |


## searchApps

> PagedResultsAppsControllerApiApp searchApps(page, size, tenant, sort, tags, q, namespace, flowId)

Search for apps

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

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
        List<String> tags = Arrays.asList(); // List<String> | A tags filter
        String q = "q_example"; // String | A string filter
        String namespace = "namespace_example"; // String | A namespace filter prefix
        String flowId = "flowId_example"; // String | A flow id filter
        try {
            PagedResultsAppsControllerApiApp result = kestraClient.AppsApi().searchApps(page, size, tenant, sort, tags, q, namespace, flowId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#searchApps");
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
| **tags** | [**List&lt;String&gt;**](String.md)| A tags filter | [optional] |
| **q** | **String**| A string filter | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |
| **flowId** | **String**| A flow id filter | [optional] |

### Return type

[**PagedResultsAppsControllerApiApp**](PagedResultsAppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchApps 200 response |  -  |


## searchAppsFromCatalog

> PagedResultsAppsControllerApiAppCatalogItem searchAppsFromCatalog(page, size, tenant, tags, q)

Search for apps from catalog

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

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
        List<String> tags = Arrays.asList(); // List<String> | Tags filter
        String q = "q_example"; // String | String filter
        try {
            PagedResultsAppsControllerApiAppCatalogItem result = kestraClient.AppsApi().searchAppsFromCatalog(page, size, tenant, tags, q);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#searchAppsFromCatalog");
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
| **tags** | [**List&lt;String&gt;**](String.md)| Tags filter | [optional] |
| **q** | **String**| String filter | [optional] |

### Return type

[**PagedResultsAppsControllerApiAppCatalogItem**](PagedResultsAppsControllerApiAppCatalogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchAppsFromCatalog 200 response |  -  |


## updateApp

> AppsControllerApiAppSource updateApp(uid, tenant, body)

Update an existing app

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AppsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String uid = "uid_example"; // String | The ID of the app
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The app
        try {
            AppsControllerApiAppSource result = kestraClient.AppsApi().updateApp(uid, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#updateApp");
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
| **uid** | **String**| The ID of the app | |
| **tenant** | **String**|  | |
| **body** | **String**| The app | |

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateApp 200 response |  -  |

