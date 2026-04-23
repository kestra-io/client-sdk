# TriggersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteBackfill**](TriggersApi.md#deleteBackfill) | **POST** /api/v1/{tenant}/triggers/backfill/delete | Delete a backfill |
| [**deleteBackfillByIds**](TriggersApi.md#deleteBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-triggers | Delete backfill for given triggers |
| [**deleteBackfillByQuery**](TriggersApi.md#deleteBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-query | Delete backfill for given triggers |
| [**deleteTrigger**](TriggersApi.md#deleteTrigger) | **DELETE** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId} | Delete a trigger |
| [**deleteTriggersByIds**](TriggersApi.md#deleteTriggersByIds) | **DELETE** /api/v1/{tenant}/triggers/delete/by-triggers | Delete given triggers |
| [**deleteTriggersByQuery**](TriggersApi.md#deleteTriggersByQuery) | **DELETE** /api/v1/{tenant}/triggers/delete/by-query | Delete triggers by query parameters |
| [**disabledTriggersByIds**](TriggersApi.md#disabledTriggersByIds) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-triggers | Disable/enable given triggers |
| [**disabledTriggersByQuery**](TriggersApi.md#disabledTriggersByQuery) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-query | Disable/enable triggers by query parameters |
| [**exportTriggers**](TriggersApi.md#exportTriggers) | **GET** /api/v1/{tenant}/triggers/export/by-query/csv | Export all triggers as a streamed CSV file |
| [**pauseBackfill**](TriggersApi.md#pauseBackfill) | **PUT** /api/v1/{tenant}/triggers/backfill/pause | Pause a backfill |
| [**pauseBackfillByIds**](TriggersApi.md#pauseBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-triggers | Pause backfill for given triggers |
| [**pauseBackfillByQuery**](TriggersApi.md#pauseBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-query | Pause backfill for given triggers |
| [**restartTrigger**](TriggersApi.md#restartTrigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/restart | Restart a trigger |
| [**searchTriggers**](TriggersApi.md#searchTriggers) | **GET** /api/v1/{tenant}/triggers/search | Search for triggers |
| [**searchTriggersForFlow**](TriggersApi.md#searchTriggersForFlow) | **GET** /api/v1/{tenant}/triggers/{namespace}/{flowId} | Get all triggers for a flow |
| [**unlockTrigger**](TriggersApi.md#unlockTrigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/unlock | Unlock a trigger |
| [**unlockTriggersByIds**](TriggersApi.md#unlockTriggersByIds) | **POST** /api/v1/{tenant}/triggers/unlock/by-triggers | Unlock given triggers |
| [**unlockTriggersByQuery**](TriggersApi.md#unlockTriggersByQuery) | **POST** /api/v1/{tenant}/triggers/unlock/by-query | Unlock triggers by query parameters |
| [**unpauseBackfill**](TriggersApi.md#unpauseBackfill) | **PUT** /api/v1/{tenant}/triggers/backfill/unpause | Unpause a backfill |
| [**unpauseBackfillByIds**](TriggersApi.md#unpauseBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-triggers | Unpause backfill for given triggers |
| [**unpauseBackfillByQuery**](TriggersApi.md#unpauseBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-query | Unpause backfill for given triggers |
| [**updateTrigger**](TriggersApi.md#updateTrigger) | **PUT** /api/v1/{tenant}/triggers | Update a trigger |



## deleteBackfill

> Trigger deleteBackfill(tenant, trigger)

Delete a backfill

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Trigger trigger = new Trigger(); // Trigger | 
        try {
            Trigger result = kestraClient.TriggersApi().deleteBackfill(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#deleteBackfill");
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
| **trigger** | [**Trigger**](Trigger.md)|  | |

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteBackfill 200 response |  -  |


## deleteBackfillByIds

> Object deleteBackfillByIds(tenant, trigger)

Delete backfill for given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<Trigger> trigger = Arrays.asList(); // List<Trigger> | 
        try {
            Object result = kestraClient.TriggersApi().deleteBackfillByIds(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#deleteBackfillByIds");
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
| **trigger** | [**List&lt;Trigger&gt;**](Trigger.md)|  | |

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
| **200** | deleteBackfillByIds 200 response |  -  |


## deleteBackfillByQuery

> Object deleteBackfillByQuery(tenant, filters)

Delete backfill for given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        try {
            Object result = kestraClient.TriggersApi().deleteBackfillByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#deleteBackfillByQuery");
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
| **200** | deleteBackfillByQuery 200 response |  -  |


## deleteTrigger

> Object deleteTrigger(namespace, triggerId, flowId, tenant)

Delete a trigger

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace
        String triggerId = "triggerId_example"; // String | The trigger id
        String flowId = "flowId_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        try {
            Object result = kestraClient.TriggersApi().deleteTrigger(namespace, triggerId, flowId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#deleteTrigger");
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
| **triggerId** | **String**| The trigger id | |
| **flowId** | **String**| The flow id | |
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
| **200** | deleteTrigger 200 response |  -  |


## deleteTriggersByIds

> Object deleteTriggersByIds(tenant, trigger)

Delete given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<Trigger> trigger = Arrays.asList(); // List<Trigger> | 
        try {
            Object result = kestraClient.TriggersApi().deleteTriggersByIds(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#deleteTriggersByIds");
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
| **trigger** | [**List&lt;Trigger&gt;**](Trigger.md)|  | |

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
| **200** | deleteTriggersByIds 200 response |  -  |


## deleteTriggersByQuery

> Object deleteTriggersByQuery(tenant, deleteTriggersByQueryRequest)

Delete triggers by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        DeleteTriggersByQueryRequest deleteTriggersByQueryRequest = new DeleteTriggersByQueryRequest(); // DeleteTriggersByQueryRequest | 
        try {
            Object result = kestraClient.TriggersApi().deleteTriggersByQuery(tenant, deleteTriggersByQueryRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#deleteTriggersByQuery");
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
| **deleteTriggersByQueryRequest** | [**DeleteTriggersByQueryRequest**](DeleteTriggersByQueryRequest.md)|  | |

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
| **200** | deleteTriggersByQuery 200 response |  -  |


## disabledTriggersByIds

> Object disabledTriggersByIds(tenant, triggerControllerSetDisabledRequest)

Disable/enable given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        TriggerControllerSetDisabledRequest triggerControllerSetDisabledRequest = new TriggerControllerSetDisabledRequest(); // TriggerControllerSetDisabledRequest | 
        try {
            Object result = kestraClient.TriggersApi().disabledTriggersByIds(tenant, triggerControllerSetDisabledRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#disabledTriggersByIds");
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
| **triggerControllerSetDisabledRequest** | [**TriggerControllerSetDisabledRequest**](TriggerControllerSetDisabledRequest.md)|  | |

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
| **200** | disabledTriggersByIds 200 response |  -  |


## disabledTriggersByQuery

> Object disabledTriggersByQuery(tenant, disabled, filters)

Disable/enable triggers by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Boolean disabled = true; // Boolean | The disabled state
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        try {
            Object result = kestraClient.TriggersApi().disabledTriggersByQuery(tenant, disabled, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#disabledTriggersByQuery");
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
| **disabled** | **Boolean**| The disabled state | [optional] [default to true] |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | [optional] |

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
| **200** | disabledTriggersByQuery 200 response |  -  |


## exportTriggers

> List&lt;Object&gt; exportTriggers(filters, tenant)

Export all triggers as a streamed CSV file

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | A list of filters
        String tenant = "tenant_example"; // String | 
        try {
            List<Object> result = kestraClient.TriggersApi().exportTriggers(filters, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#exportTriggers");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| A list of filters | |
| **tenant** | **String**|  | |

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
| **200** | exportTriggers 200 response |  -  |


## pauseBackfill

> Trigger pauseBackfill(tenant, trigger)

Pause a backfill

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Trigger trigger = new Trigger(); // Trigger | 
        try {
            Trigger result = kestraClient.TriggersApi().pauseBackfill(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#pauseBackfill");
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
| **trigger** | [**Trigger**](Trigger.md)|  | |

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | pauseBackfill 200 response |  -  |


## pauseBackfillByIds

> Object pauseBackfillByIds(tenant, trigger)

Pause backfill for given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<Trigger> trigger = Arrays.asList(); // List<Trigger> | 
        try {
            Object result = kestraClient.TriggersApi().pauseBackfillByIds(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#pauseBackfillByIds");
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
| **trigger** | [**List&lt;Trigger&gt;**](Trigger.md)|  | |

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
| **200** | pauseBackfillByIds 200 response |  -  |


## pauseBackfillByQuery

> Object pauseBackfillByQuery(tenant, filters)

Pause backfill for given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        try {
            Object result = kestraClient.TriggersApi().pauseBackfillByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#pauseBackfillByQuery");
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
| **200** | pauseBackfillByQuery 200 response |  -  |


## restartTrigger

> Object restartTrigger(namespace, triggerId, flowId, tenant)

Restart a trigger

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace
        String triggerId = "triggerId_example"; // String | The trigger id
        String flowId = "flowId_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        try {
            Object result = kestraClient.TriggersApi().restartTrigger(namespace, triggerId, flowId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#restartTrigger");
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
| **triggerId** | **String**| The trigger id | |
| **flowId** | **String**| The flow id | |
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
| **200** | restartTrigger 200 response |  -  |


## searchTriggers

> PagedResultsTriggerControllerTriggers searchTriggers(tenant, filters, size, page, sort)

Search for triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

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
            PagedResultsTriggerControllerTriggers result = kestraClient.TriggersApi().searchTriggers(tenant, filters, size, page, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#searchTriggers");
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

[**PagedResultsTriggerControllerTriggers**](PagedResultsTriggerControllerTriggers.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchTriggers 200 response |  -  |


## searchTriggersForFlow

> PagedResultsTrigger searchTriggersForFlow(namespace, flowId, tenant, q, size, page, sort)

Get all triggers for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        ListBlueprintTagsQParameter namespace = new ListBlueprintTagsQParameter(); // ListBlueprintTagsQParameter | The namespace
        String flowId = "flowId_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | A string filter
        Integer size = 10; // Integer | The current page size
        Integer page = 1; // Integer | The current page
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsTrigger result = kestraClient.TriggersApi().searchTriggersForFlow(namespace, flowId, tenant, q, size, page, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#searchTriggersForFlow");
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
| **namespace** | [**ListBlueprintTagsQParameter**](.md)| The namespace | |
| **flowId** | **String**| The flow id | |
| **tenant** | **String**|  | |
| **q** | **String**| A string filter | [optional] |
| **size** | **Integer**| The current page size | [optional] [default to 10] |
| **page** | **Integer**| The current page | [optional] [default to 1] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsTrigger**](PagedResultsTrigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchTriggersForFlow 200 response |  -  |


## unlockTrigger

> Trigger unlockTrigger(namespace, triggerId, flowId, tenant)

Unlock a trigger

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace
        String triggerId = "triggerId_example"; // String | The trigger id
        String flowId = "flowId_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        try {
            Trigger result = kestraClient.TriggersApi().unlockTrigger(namespace, triggerId, flowId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#unlockTrigger");
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
| **triggerId** | **String**| The trigger id | |
| **flowId** | **String**| The flow id | |
| **tenant** | **String**|  | |

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | unlockTrigger 200 response |  -  |


## unlockTriggersByIds

> Object unlockTriggersByIds(tenant, trigger)

Unlock given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<Trigger> trigger = Arrays.asList(); // List<Trigger> | 
        try {
            Object result = kestraClient.TriggersApi().unlockTriggersByIds(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#unlockTriggersByIds");
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
| **trigger** | [**List&lt;Trigger&gt;**](Trigger.md)|  | |

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
| **200** | unlockTriggersByIds 200 response |  -  |


## unlockTriggersByQuery

> Object unlockTriggersByQuery(tenant, filters)

Unlock triggers by query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        try {
            Object result = kestraClient.TriggersApi().unlockTriggersByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#unlockTriggersByQuery");
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
| **200** | unlockTriggersByQuery 200 response |  -  |


## unpauseBackfill

> Trigger unpauseBackfill(tenant, trigger)

Unpause a backfill

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Trigger trigger = new Trigger(); // Trigger | 
        try {
            Trigger result = kestraClient.TriggersApi().unpauseBackfill(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#unpauseBackfill");
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
| **trigger** | [**Trigger**](Trigger.md)|  | |

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | unpauseBackfill 200 response |  -  |


## unpauseBackfillByIds

> Object unpauseBackfillByIds(tenant, trigger)

Unpause backfill for given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<Trigger> trigger = Arrays.asList(); // List<Trigger> | 
        try {
            Object result = kestraClient.TriggersApi().unpauseBackfillByIds(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#unpauseBackfillByIds");
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
| **trigger** | [**List&lt;Trigger&gt;**](Trigger.md)|  | |

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
| **200** | unpauseBackfillByIds 200 response |  -  |


## unpauseBackfillByQuery

> Object unpauseBackfillByQuery(tenant, filters)

Unpause backfill for given triggers

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        try {
            Object result = kestraClient.TriggersApi().unpauseBackfillByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#unpauseBackfillByQuery");
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
| **200** | unpauseBackfillByQuery 200 response |  -  |


## updateTrigger

> Trigger updateTrigger(tenant, trigger)

Update a trigger

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TriggersApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Trigger trigger = new Trigger(); // Trigger | 
        try {
            Trigger result = kestraClient.TriggersApi().updateTrigger(tenant, trigger);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#updateTrigger");
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
| **trigger** | [**Trigger**](Trigger.md)|  | |

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateTrigger 200 response |  -  |

