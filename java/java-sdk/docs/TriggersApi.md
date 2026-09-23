# TriggersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createBackfill**](TriggersApi.md#createBackfill) | **PUT** /api/v1/{tenant}/triggers/backfill/create | Create a backfill |
| [**deleteBackfill**](TriggersApi.md#deleteBackfill) | **POST** /api/v1/{tenant}/triggers/backfill/delete | Delete a backfill |
| [**deleteBackfillByIds**](TriggersApi.md#deleteBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-triggers | Delete backfill for given triggers asynchronously |
| [**deleteBackfillByQuery**](TriggersApi.md#deleteBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-query | Delete backfill for triggers matching query asynchronously |
| [**deleteTrigger**](TriggersApi.md#deleteTrigger) | **DELETE** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId} | Delete a trigger |
| [**deleteTriggersByIds**](TriggersApi.md#deleteTriggersByIds) | **DELETE** /api/v1/{tenant}/triggers/delete/by-triggers | Delete given triggers asynchronously |
| [**deleteTriggersByQuery**](TriggersApi.md#deleteTriggersByQuery) | **DELETE** /api/v1/{tenant}/triggers/delete/by-query | Delete triggers by query parameters asynchronously |
| [**disableTriggerById**](TriggersApi.md#disableTriggerById) | **PUT** /api/v1/{tenant}/triggers/set-disabled | Disable/enable a trigger |
| [**disabledTriggersByIds**](TriggersApi.md#disabledTriggersByIds) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-triggers | Disable/enable given triggers asynchronously |
| [**disabledTriggersByQuery**](TriggersApi.md#disabledTriggersByQuery) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-query | Disable/enable triggers by query parameters asynchronously |
| [**exportTriggers**](TriggersApi.md#exportTriggers) | **GET** /api/v1/{tenant}/triggers/export/by-query/csv | Export all triggers as a streamed CSV file |
| [**pauseBackfill**](TriggersApi.md#pauseBackfill) | **PUT** /api/v1/{tenant}/triggers/backfill/pause | Pause a backfill |
| [**pauseBackfillByIds**](TriggersApi.md#pauseBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-triggers | Pause backfill for given triggers asynchronously |
| [**pauseBackfillByQuery**](TriggersApi.md#pauseBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-query | Pause backfill for triggers matching query asynchronously |
| [**restartTrigger**](TriggersApi.md#restartTrigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/restart | Restart a trigger |
| [**searchTriggers**](TriggersApi.md#searchTriggers) | **GET** /api/v1/{tenant}/triggers/search | Search for triggers |
| [**searchTriggersForFlow**](TriggersApi.md#searchTriggersForFlow) | **GET** /api/v1/{tenant}/triggers/{namespace}/{flowId} | Get all triggers for a flow |
| [**unlockTrigger**](TriggersApi.md#unlockTrigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/unlock | Unlock a trigger |
| [**unlockTriggersByIds**](TriggersApi.md#unlockTriggersByIds) | **POST** /api/v1/{tenant}/triggers/unlock/by-triggers | Unlock given triggers asynchronously |
| [**unlockTriggersByQuery**](TriggersApi.md#unlockTriggersByQuery) | **POST** /api/v1/{tenant}/triggers/unlock/by-query | Unlock triggers by query parameters asynchronously |
| [**unpauseBackfill**](TriggersApi.md#unpauseBackfill) | **PUT** /api/v1/{tenant}/triggers/backfill/unpause | Unpause a backfill |
| [**unpauseBackfillByIds**](TriggersApi.md#unpauseBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-triggers | Unpause backfill for given triggers asynchronously |
| [**unpauseBackfillByQuery**](TriggersApi.md#unpauseBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-query | Unpause backfill for triggers matching query asynchronously |



## createBackfill

> ApiTriggerState createBackfill(tenant, request)

Create a backfill

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        TriggerControllerApiCreateBackfillRequest triggerControllerApiCreateBackfillRequest = new TriggerControllerApiCreateBackfillRequest(); // TriggerControllerApiCreateBackfillRequest | 
        try {
            ApiTriggerState result = kestraClient.triggers().createBackfill(tenant, triggerControllerApiCreateBackfillRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#createBackfill");
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
| **request** | [**TriggerControllerApiCreateBackfillRequest**](TriggerControllerApiCreateBackfillRequest.md)|  | |

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | If the backfill cannot be created |  -  |


## deleteBackfill

> ApiTriggerState deleteBackfill(tenant, triggerId)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        TriggerControllerApiTriggerId triggerControllerApiTriggerId = new TriggerControllerApiTriggerId(); // TriggerControllerApiTriggerId | 
        try {
            ApiTriggerState result = kestraClient.triggers().deleteBackfill(tenant, triggerControllerApiTriggerId);
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
| **triggerId** | [**TriggerControllerApiTriggerId**](TriggerControllerApiTriggerId.md)|  | |

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | If the backfill cannot be deleted |  -  |


## deleteBackfillByIds

> ApiAsyncOperationResponse deleteBackfillByIds(tenant, triggerIds)

Delete backfill for given triggers asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<TriggerControllerApiTriggerId> triggerControllerApiTriggerId = Arrays.asList(); // List<TriggerControllerApiTriggerId> | 
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().deleteBackfillByIds(tenant, triggerControllerApiTriggerId);
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
| **triggerIds** | [**List&lt;TriggerControllerApiTriggerId&gt;**](TriggerControllerApiTriggerId.md)|  | |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteBackfillByIds 200 response |  -  |
| **202** | Accepted |  -  |


## deleteBackfillByQuery

> ApiAsyncOperationResponse deleteBackfillByQuery(tenant, filters)

Delete backfill for triggers matching query asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test`
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().deleteBackfillByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteBackfillByQuery 200 response |  -  |
| **202** | Accepted |  -  |


## deleteTrigger

> deleteTrigger(tenant, namespace, flowId, triggerId)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace
        String flowId = "flowId_example"; // String | The flow id
        String triggerId = "triggerId_example"; // String | The trigger id
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.triggers().deleteTrigger(tenant, namespace, flowId, triggerId);
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
| **tenant** | **String**|  | |
| **namespace** | **String**| The namespace | |
| **flowId** | **String**| The flow id | |
| **triggerId** | **String**| The trigger id | |

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
| **200** | deleteTrigger 200 response |  -  |
| **204** | On success |  -  |
| **409** | If the trigger cannot be deleted |  -  |


## deleteTriggersByIds

> ApiAsyncOperationResponse deleteTriggersByIds(tenant, triggerIds)

Delete given triggers asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<TriggerControllerApiTriggerId> triggerControllerApiTriggerId = Arrays.asList(); // List<TriggerControllerApiTriggerId> | 
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().deleteTriggersByIds(tenant, triggerControllerApiTriggerId);
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
| **triggerIds** | [**List&lt;TriggerControllerApiTriggerId&gt;**](TriggerControllerApiTriggerId.md)|  | |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteTriggersByIds 200 response |  -  |
| **202** | Accepted |  -  |


## deleteTriggersByQuery

> ApiAsyncOperationResponse deleteTriggersByQuery(tenant, request)

Delete triggers by query parameters asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        DeleteTriggersByQueryRequest deleteTriggersByQueryRequest = new DeleteTriggersByQueryRequest(); // DeleteTriggersByQueryRequest | 
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().deleteTriggersByQuery(tenant, deleteTriggersByQueryRequest);
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
| **request** | [**DeleteTriggersByQueryRequest**](DeleteTriggersByQueryRequest.md)|  | |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteTriggersByQuery 200 response |  -  |
| **202** | Accepted |  -  |


## disableTriggerById

> ApiTriggerState disableTriggerById(tenant, request)

Disable/enable a trigger

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        TriggerControllerApiDisableTriggerRequest triggerControllerApiDisableTriggerRequest = new TriggerControllerApiDisableTriggerRequest(); // TriggerControllerApiDisableTriggerRequest | 
        try {
            ApiTriggerState result = kestraClient.triggers().disableTriggerById(tenant, triggerControllerApiDisableTriggerRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TriggersApi#disableTriggerById");
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
| **request** | [**TriggerControllerApiDisableTriggerRequest**](TriggerControllerApiDisableTriggerRequest.md)|  | |

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | If the trigger state cannot be changed |  -  |


## disabledTriggersByIds

> ApiAsyncOperationResponse disabledTriggersByIds(tenant, request)

Disable/enable given triggers asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        TriggerControllerSetDisabledRequest triggerControllerSetDisabledRequest = new TriggerControllerSetDisabledRequest(); // TriggerControllerSetDisabledRequest | 
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().disabledTriggersByIds(tenant, triggerControllerSetDisabledRequest);
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
| **request** | [**TriggerControllerSetDisabledRequest**](TriggerControllerSetDisabledRequest.md)|  | |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | disabledTriggersByIds 200 response |  -  |
| **202** | Accepted |  -  |


## disabledTriggersByQuery

> ApiAsyncOperationResponse disabledTriggersByQuery(tenant, disabled, filters)

Disable/enable triggers by query parameters asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test`
        Boolean disabled = true; // Boolean | The disabled state
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().disabledTriggersByQuery(tenant, disabled, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | disabledTriggersByQuery 200 response |  -  |
| **202** | Accepted |  -  |


## exportTriggers

> List&lt;String&gt; exportTriggers(tenant, filters)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | A list of filters
        String tenant = "tenant_example"; // String | 
        try {
            List<String> result = kestraClient.triggers().exportTriggers(tenant, filters);
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
| **tenant** | **String**|  | |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| A list of filters | |

### Return type

**List&lt;String&gt;**

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

> ApiTriggerState pauseBackfill(tenant, triggerId)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        TriggerControllerApiTriggerId triggerControllerApiTriggerId = new TriggerControllerApiTriggerId(); // TriggerControllerApiTriggerId | 
        try {
            ApiTriggerState result = kestraClient.triggers().pauseBackfill(tenant, triggerControllerApiTriggerId);
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
| **triggerId** | [**TriggerControllerApiTriggerId**](TriggerControllerApiTriggerId.md)|  | |

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | If the backfill cannot be paused |  -  |


## pauseBackfillByIds

> ApiAsyncOperationResponse pauseBackfillByIds(tenant, triggerIds)

Pause backfill for given triggers asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<TriggerControllerApiTriggerId> triggerControllerApiTriggerId = Arrays.asList(); // List<TriggerControllerApiTriggerId> | 
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().pauseBackfillByIds(tenant, triggerControllerApiTriggerId);
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
| **triggerIds** | [**List&lt;TriggerControllerApiTriggerId&gt;**](TriggerControllerApiTriggerId.md)|  | |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | pauseBackfillByIds 200 response |  -  |
| **202** | Accepted |  -  |


## pauseBackfillByQuery

> ApiAsyncOperationResponse pauseBackfillByQuery(tenant, filters)

Pause backfill for triggers matching query asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test`
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().pauseBackfillByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | pauseBackfillByQuery 200 response |  -  |
| **202** | Accepted |  -  |


## restartTrigger

> ApiTriggerState restartTrigger(tenant, namespace, flowId, triggerId)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace
        String flowId = "flowId_example"; // String | The flow id
        String triggerId = "triggerId_example"; // String | The trigger id
        String tenant = "tenant_example"; // String | 
        try {
            ApiTriggerState result = kestraClient.triggers().restartTrigger(tenant, namespace, flowId, triggerId);
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
| **tenant** | **String**|  | |
| **namespace** | **String**| The namespace | |
| **flowId** | **String**| The flow id | |
| **triggerId** | **String**| The trigger id | |

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | If the trigger cannot be restarted |  -  |


## searchTriggers

> PagedResultsApiTriggerAndState searchTriggers(tenant, page, size, sort, filters, dateFilter)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test`
        try {
            PagedResultsApiTriggerAndState result = kestraClient.triggers().searchTriggers(tenant, page, size, sort, filters);
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
| **page** | **Integer**| The current page | [optional] [default to 1] |
| **size** | **Integer**| The current page size | [optional] [default to 10] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |
| **dateFilter** | **.annotation.Nullable String**|  | |

### Return type

[**PagedResultsApiTriggerAndState**](PagedResultsApiTriggerAndState.md)

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

> PagedResultsApiTriggerState searchTriggersForFlow(tenant, namespace, flowId, page, size, q, sort)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace
        String flowId = "flowId_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        String q = "q_example"; // String | A string filter
        try {
            PagedResultsApiTriggerState result = kestraClient.triggers().searchTriggersForFlow(tenant, namespace, flowId, page, size, q, sort);
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
| **tenant** | **String**|  | |
| **namespace** | **String**| The namespace | |
| **flowId** | **String**| The flow id | |
| **page** | **Integer**| The current page | [optional] [default to 1] |
| **size** | **Integer**| The current page size | [optional] [default to 10] |
| **q** | **String**| A string filter | [optional] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsApiTriggerState**](PagedResultsApiTriggerState.md)

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

> ApiTriggerState unlockTrigger(tenant, namespace, flowId, triggerId)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace
        String flowId = "flowId_example"; // String | The flow id
        String triggerId = "triggerId_example"; // String | The trigger id
        String tenant = "tenant_example"; // String | 
        try {
            ApiTriggerState result = kestraClient.triggers().unlockTrigger(tenant, namespace, flowId, triggerId);
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
| **tenant** | **String**|  | |
| **namespace** | **String**| The namespace | |
| **flowId** | **String**| The flow id | |
| **triggerId** | **String**| The trigger id | |

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | If the trigger is already unlocked |  -  |


## unlockTriggersByIds

> ApiAsyncOperationResponse unlockTriggersByIds(tenant, triggerIds)

Unlock given triggers asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<TriggerControllerApiTriggerId> triggerControllerApiTriggerId = Arrays.asList(); // List<TriggerControllerApiTriggerId> | 
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().unlockTriggersByIds(tenant, triggerControllerApiTriggerId);
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
| **triggerIds** | [**List&lt;TriggerControllerApiTriggerId&gt;**](TriggerControllerApiTriggerId.md)|  | |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | unlockTriggersByIds 200 response |  -  |
| **202** | Accepted |  -  |


## unlockTriggersByQuery

> ApiAsyncOperationResponse unlockTriggersByQuery(tenant, filters)

Unlock triggers by query parameters asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test`
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().unlockTriggersByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | unlockTriggersByQuery 200 response |  -  |
| **202** | Accepted |  -  |


## unpauseBackfill

> ApiTriggerState unpauseBackfill(tenant, triggerId)

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        TriggerControllerApiTriggerId triggerControllerApiTriggerId = new TriggerControllerApiTriggerId(); // TriggerControllerApiTriggerId | 
        try {
            ApiTriggerState result = kestraClient.triggers().unpauseBackfill(tenant, triggerControllerApiTriggerId);
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
| **triggerId** | [**TriggerControllerApiTriggerId**](TriggerControllerApiTriggerId.md)|  | |

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |
| **409** | If the backfill cannot be resumed |  -  |


## unpauseBackfillByIds

> ApiAsyncOperationResponse unpauseBackfillByIds(tenant, triggerIds)

Unpause backfill for given triggers asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<TriggerControllerApiTriggerId> triggerControllerApiTriggerId = Arrays.asList(); // List<TriggerControllerApiTriggerId> | 
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().unpauseBackfillByIds(tenant, triggerControllerApiTriggerId);
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
| **triggerIds** | [**List&lt;TriggerControllerApiTriggerId&gt;**](TriggerControllerApiTriggerId.md)|  | |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | unpauseBackfillByIds 200 response |  -  |
| **202** | Accepted |  -  |


## unpauseBackfillByQuery

> ApiAsyncOperationResponse unpauseBackfillByQuery(tenant, filters)

Unpause backfill for triggers matching query asynchronously

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
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test`
        try {
            ApiAsyncOperationResponse result = kestraClient.triggers().unpauseBackfillByQuery(tenant, filters);
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | unpauseBackfillByQuery 200 response |  -  |
| **202** | Accepted |  -  |

