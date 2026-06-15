# FlowsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**bulkUpdateFlows**](FlowsApi.md#bulkUpdateFlows) | **POST** /api/v1/{tenant}/flows/bulk | Update from multiples yaml sources |
| [**createFlow**](FlowsApi.md#createFlow) | **POST** /api/v1/{tenant}/flows | Create a flow from yaml source |
| [**deleteFlow**](FlowsApi.md#deleteFlow) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id} | Delete a flow |
| [**deleteFlowsByIds**](FlowsApi.md#deleteFlowsByIds) | **DELETE** /api/v1/{tenant}/flows/delete/by-ids | Delete flows by their IDs. |
| [**deleteFlowsByQuery**](FlowsApi.md#deleteFlowsByQuery) | **DELETE** /api/v1/{tenant}/flows/delete/by-query | Delete flows returned by the query parameters. |
| [**deleteRevisions**](FlowsApi.md#deleteRevisions) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Delete revisions for a flow |
| [**disableFlowsByIds**](FlowsApi.md#disableFlowsByIds) | **POST** /api/v1/{tenant}/flows/disable/by-ids | Disable flows by their IDs. |
| [**disableFlowsByQuery**](FlowsApi.md#disableFlowsByQuery) | **POST** /api/v1/{tenant}/flows/disable/by-query | Disable flows returned by the query parameters. |
| [**enableFlowsByIds**](FlowsApi.md#enableFlowsByIds) | **POST** /api/v1/{tenant}/flows/enable/by-ids | Enable flows by their IDs. |
| [**enableFlowsByQuery**](FlowsApi.md#enableFlowsByQuery) | **POST** /api/v1/{tenant}/flows/enable/by-query | Enable flows returned by the query parameters. |
| [**exportFlowsByIds**](FlowsApi.md#exportFlowsByIds) | **POST** /api/v1/{tenant}/flows/export/by-ids | Export flows as a ZIP archive of yaml sources. |
| [**exportFlowsByQuery**](FlowsApi.md#exportFlowsByQuery) | **GET** /api/v1/{tenant}/flows/export/by-query | Export flows as a ZIP archive of yaml sources. |
| [**expressions**](FlowsApi.md#expressions) | **POST** /api/v1/{tenant}/flows/expressions | Get available Pebble expressions for a flow |
| [**flow**](FlowsApi.md#flow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id} | Get a flow |
| [**flowDependencies**](FlowsApi.md#flowDependencies) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/dependencies | Get flow dependencies |
| [**flowDependenciesFromNamespace**](FlowsApi.md#flowDependenciesFromNamespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies |
| [**generateFlowGraph**](FlowsApi.md#generateFlowGraph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow |
| [**generateFlowGraphFromSource**](FlowsApi.md#generateFlowGraphFromSource) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source |
| [**importFlows**](FlowsApi.md#importFlows) | **POST** /api/v1/{tenant}/flows/import |     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned.  |
| [**listDeprecated**](FlowsApi.md#listDeprecated) | **GET** /api/v1/{tenant}/flows/deprecated | List flows containing deprecated tasks |
| [**listDistinctNamespaces**](FlowsApi.md#listDistinctNamespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces |
| [**listFlowRevisions**](FlowsApi.md#listFlowRevisions) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Get revisions for a flow |
| [**listFlowsByNamespace**](FlowsApi.md#listFlowsByNamespace) | **GET** /api/v1/{tenant}/flows/{namespace} | Retrieve all flows from a given namespace |
| [**searchConcurrencyLimits**](FlowsApi.md#searchConcurrencyLimits) | **GET** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits |
| [**searchFlows**](FlowsApi.md#searchFlows) | **GET** /api/v1/{tenant}/flows/search | Search for flows |
| [**searchFlowsBySourceCode**](FlowsApi.md#searchFlowsBySourceCode) | **GET** /api/v1/{tenant}/flows/source | Search for flows source code |
| [**taskFromFlow**](FlowsApi.md#taskFromFlow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/tasks/{taskId} | Get a flow task |
| [**updateConcurrencyLimit**](FlowsApi.md#updateConcurrencyLimit) | **PUT** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit |
| [**updateFlow**](FlowsApi.md#updateFlow) | **PUT** /api/v1/{tenant}/flows/{namespace}/{id} | Update a flow |
| [**updateFlowsInNamespace**](FlowsApi.md#updateFlowsInNamespace) | **POST** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from yaml source |
| [**validateFlows**](FlowsApi.md#validateFlows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows |
| [**validateTask**](FlowsApi.md#validateTask) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task |
| [**validateTrigger**](FlowsApi.md#validateTrigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger |



## bulkUpdateFlows

> List&lt;FlowInterface&gt; bulkUpdateFlows(tenant, delete, namespace, allowNamespaceChild, body)

Update from multiples yaml sources

All flow will be created / updated for this namespace. Flow that already created but not in &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Boolean delete = true; // Boolean | If missing flow should be deleted
        String namespace = "namespace_example"; // String | The namespace where to update flows
        Boolean allowNamespaceChild = false; // Boolean | If namespace child should are allowed to be updated
        String body = "body_example"; // String | A list of flows source code split with \"---\"
        try {
            List<FlowInterface> result = kestraClient.FlowsApi().bulkUpdateFlows(tenant, delete, namespace, allowNamespaceChild, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#bulkUpdateFlows");
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
| **delete** | **Boolean**| If missing flow should be deleted | [optional] [default to true] |
| **namespace** | **String**| The namespace where to update flows | [optional] |
| **allowNamespaceChild** | **Boolean**| If namespace child should are allowed to be updated | [optional] [default to false] |
| **body** | **String**| A list of flows source code split with \&quot;---\&quot; | [optional] |

### Return type

[**List&lt;FlowInterface&gt;**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | bulkUpdateFlows 200 response |  -  |


## createFlow

> FlowWithSource createFlow(tenant, body)

Create a flow from yaml source

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The flow source code
        try {
            FlowWithSource result = kestraClient.FlowsApi().createFlow(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#createFlow");
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
| **body** | **String**| The flow source code | |

### Return type

[**FlowWithSource**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createFlow 200 response |  -  |


## deleteFlow

> deleteFlow(namespace, id, tenant)

Delete a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.FlowsApi().deleteFlow(namespace, id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#deleteFlow");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
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
| **200** | deleteFlow 200 response |  -  |
| **204** | On success |  -  |


## deleteFlowsByIds

> BulkResponse deleteFlowsByIds(tenant, idWithNamespace)

Delete flows by their IDs.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<IdWithNamespace> idWithNamespace = Arrays.asList(); // List<IdWithNamespace> | A list of tuple flow ID and namespace as flow identifiers
        try {
            BulkResponse result = kestraClient.FlowsApi().deleteFlowsByIds(tenant, idWithNamespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#deleteFlowsByIds");
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
| **idWithNamespace** | [**List&lt;IdWithNamespace&gt;**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteFlowsByIds 200 response |  -  |


## deleteFlowsByQuery

> BulkResponse deleteFlowsByQuery(tenant, filters)

Delete flows returned by the query parameters.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            BulkResponse result = kestraClient.FlowsApi().deleteFlowsByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#deleteFlowsByQuery");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteFlowsByQuery 200 response |  -  |


## deleteRevisions

> deleteRevisions(namespace, id, revisions, tenant)

Delete revisions for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        List<Integer> revisions = Arrays.asList(); // List<Integer> | 
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.FlowsApi().deleteRevisions(namespace, id, revisions, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#deleteRevisions");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **revisions** | [**List&lt;Integer&gt;**](Integer.md)|  | |
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
| **200** | deleteRevisions 200 response |  -  |


## disableFlowsByIds

> BulkResponse disableFlowsByIds(tenant, idWithNamespace)

Disable flows by their IDs.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<IdWithNamespace> idWithNamespace = Arrays.asList(); // List<IdWithNamespace> | A list of tuple flow ID and namespace as flow identifiers
        try {
            BulkResponse result = kestraClient.FlowsApi().disableFlowsByIds(tenant, idWithNamespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#disableFlowsByIds");
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
| **idWithNamespace** | [**List&lt;IdWithNamespace&gt;**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | disableFlowsByIds 200 response |  -  |


## disableFlowsByQuery

> BulkResponse disableFlowsByQuery(tenant, filters)

Disable flows returned by the query parameters.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            BulkResponse result = kestraClient.FlowsApi().disableFlowsByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#disableFlowsByQuery");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | disableFlowsByQuery 200 response |  -  |


## enableFlowsByIds

> BulkResponse enableFlowsByIds(tenant, idWithNamespace)

Enable flows by their IDs.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<IdWithNamespace> idWithNamespace = Arrays.asList(); // List<IdWithNamespace> | A list of tuple flow ID and namespace as flow identifiers
        try {
            BulkResponse result = kestraClient.FlowsApi().enableFlowsByIds(tenant, idWithNamespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#enableFlowsByIds");
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
| **idWithNamespace** | [**List&lt;IdWithNamespace&gt;**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | enableFlowsByIds 200 response |  -  |


## enableFlowsByQuery

> BulkResponse enableFlowsByQuery(tenant, filters)

Enable flows returned by the query parameters.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            BulkResponse result = kestraClient.FlowsApi().enableFlowsByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#enableFlowsByQuery");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | enableFlowsByQuery 200 response |  -  |


## exportFlowsByIds

> byte[] exportFlowsByIds(tenant, idWithNamespace)

Export flows as a ZIP archive of yaml sources.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<IdWithNamespace> idWithNamespace = Arrays.asList(); // List<IdWithNamespace> | A list of tuple flow ID and namespace as flow identifiers
        try {
            byte[] result = kestraClient.FlowsApi().exportFlowsByIds(tenant, idWithNamespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#exportFlowsByIds");
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
| **idWithNamespace** | [**List&lt;IdWithNamespace&gt;**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | |

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
| **200** | exportFlowsByIds 200 response |  -  |


## exportFlowsByQuery

> byte[] exportFlowsByQuery(tenant, filters)

Export flows as a ZIP archive of yaml sources.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            byte[] result = kestraClient.FlowsApi().exportFlowsByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#exportFlowsByQuery");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | exportFlowsByQuery 200 response |  -  |


## expressions

> ExpressionContext expressions(tenant, body, taskId)

Get available Pebble expressions for a flow

Returns a categorized map of expression strings available for autocompletion in the No-Code editor.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The flow source code
        String taskId = "taskId_example"; // String | Optional task ID to scope outputs to prior tasks
        try {
            ExpressionContext result = kestraClient.FlowsApi().expressions(tenant, body, taskId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#expressions");
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
| **body** | **String**| The flow source code | |
| **taskId** | **String**| Optional task ID to scope outputs to prior tasks | [optional] |

### Return type

[**ExpressionContext**](ExpressionContext.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Categorized expressions map |  -  |


## flow

> FlowWithSource flow(namespace, id, tenant, source, revision, allowDeleted)

Get a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        Boolean source = false; // Boolean | Include the source code
        Integer revision = 56; // Integer | Get latest revision by default
        Boolean allowDeleted = false; // Boolean | Get flow even if deleted
        try {
            FlowWithSource result = kestraClient.FlowsApi().flow(namespace, id, tenant, source, revision, allowDeleted);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#flow");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **tenant** | **String**|  | |
| **source** | **Boolean**| Include the source code | [optional] [default to false] |
| **revision** | **Integer**| Get latest revision by default | [optional] |
| **allowDeleted** | **Boolean**| Get flow even if deleted | [optional] [default to false] |

### Return type

[**FlowWithSource**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |


## flowDependencies

> FlowTopologyGraph flowDependencies(namespace, id, tenant, destinationOnly, expandAll)

Get flow dependencies

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        Boolean destinationOnly = false; // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
        Boolean expandAll = false; // Boolean | If true, expand all dependencies recursively
        try {
            FlowTopologyGraph result = kestraClient.FlowsApi().flowDependencies(namespace, id, tenant, destinationOnly, expandAll);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#flowDependencies");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **tenant** | **String**|  | |
| **destinationOnly** | **Boolean**| If true, list only destination dependencies, otherwise list also source dependencies | [optional] [default to false] |
| **expandAll** | **Boolean**| If true, expand all dependencies recursively | [optional] [default to false] |

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getFlowDependencies 200 response |  -  |


## flowDependenciesFromNamespace

> FlowTopologyGraph flowDependenciesFromNamespace(namespace, tenant, destinationOnly)

Retrieve flow dependencies

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String tenant = "tenant_example"; // String | 
        Boolean destinationOnly = false; // Boolean | if true, list only destination dependencies, otherwise list also source dependencies
        try {
            FlowTopologyGraph result = kestraClient.FlowsApi().flowDependenciesFromNamespace(namespace, tenant, destinationOnly);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#flowDependenciesFromNamespace");
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
| **namespace** | **String**| The flow namespace | |
| **tenant** | **String**|  | |
| **destinationOnly** | **Boolean**| if true, list only destination dependencies, otherwise list also source dependencies | [optional] [default to false] |

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getFlowDependenciesFromNamespace 200 response |  -  |


## generateFlowGraph

> FlowGraph generateFlowGraph(namespace, id, tenant, revision, subflows)

Generate a graph for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | The flow revision
        List<String> subflows = Arrays.asList(); // List<String> | The subflow tasks to display
        try {
            FlowGraph result = kestraClient.FlowsApi().generateFlowGraph(namespace, id, tenant, revision, subflows);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#generateFlowGraph");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **tenant** | **String**|  | |
| **revision** | **Integer**| The flow revision | [optional] |
| **subflows** | [**List&lt;String&gt;**](String.md)| The subflow tasks to display | [optional] |

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return a FlowGraph object |  -  |


## generateFlowGraphFromSource

> FlowGraph generateFlowGraphFromSource(tenant, body, subflows)

Generate a graph for a flow source

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The flow source code
        List<String> subflows = Arrays.asList(); // List<String> | The subflow tasks to display
        try {
            FlowGraph result = kestraClient.FlowsApi().generateFlowGraphFromSource(tenant, body, subflows);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#generateFlowGraphFromSource");
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
| **body** | **String**| The flow source code | |
| **subflows** | [**List&lt;String&gt;**](String.md)| The subflow tasks to display | [optional] |

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | generateFlowGraphFromSource 200 response |  -  |


## importFlows

> List&lt;String&gt; importFlows(tenant, failOnError, fileUpload)

    Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Boolean failOnError = false; // Boolean | If should fail on invalid flows
        File fileUpload = new File("/path/to/file"); // File | The file to import, can be a ZIP archive or a multi-objects YAML file
        try {
            List<String> result = kestraClient.FlowsApi().importFlows(tenant, failOnError, fileUpload);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#importFlows");
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
| **failOnError** | **Boolean**| If should fail on invalid flows | [optional] [default to false] |
| **fileUpload** | **File**| The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] |

### Return type

**List&lt;String&gt;**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |


## listDeprecated

> List&lt;FlowControllerFlowWithDeprecatedTasks&gt; listDeprecated(tenant, namespace)

List flows containing deprecated tasks

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String namespace = "namespace_example"; // String | A namespace filter prefix
        try {
            List<FlowControllerFlowWithDeprecatedTasks> result = kestraClient.FlowsApi().listDeprecated(tenant, namespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#listDeprecated");
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
| **namespace** | **String**| A namespace filter prefix | [optional] |

### Return type

[**List&lt;FlowControllerFlowWithDeprecatedTasks&gt;**](FlowControllerFlowWithDeprecatedTasks.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listDeprecated 200 response |  -  |


## listDistinctNamespaces

> List&lt;String&gt; listDistinctNamespaces(tenant, q)

List all distinct namespaces

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | A string filter
        try {
            List<String> result = kestraClient.FlowsApi().listDistinctNamespaces(tenant, q);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#listDistinctNamespaces");
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

### Return type

**List&lt;String&gt;**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listDistinctNamespaces 200 response |  -  |


## listFlowRevisions

> List&lt;FlowWithSource&gt; listFlowRevisions(namespace, id, tenant, allowDelete)

Get revisions for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        Boolean allowDelete = false; // Boolean | 
        try {
            List<FlowWithSource> result = kestraClient.FlowsApi().listFlowRevisions(namespace, id, tenant, allowDelete);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#listFlowRevisions");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **tenant** | **String**|  | |
| **allowDelete** | **Boolean**|  | [optional] [default to false] |

### Return type

[**List&lt;FlowWithSource&gt;**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listFlowRevisions 200 response |  -  |


## listFlowsByNamespace

> List&lt;Flow&gt; listFlowsByNamespace(namespace, tenant)

Retrieve all flows from a given namespace

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | Namespace to filter flows
        String tenant = "tenant_example"; // String | 
        try {
            List<Flow> result = kestraClient.FlowsApi().listFlowsByNamespace(namespace, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#listFlowsByNamespace");
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
| **namespace** | **String**| Namespace to filter flows | |
| **tenant** | **String**|  | |

### Return type

[**List&lt;Flow&gt;**](Flow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listFlowsByNamespace 200 response |  -  |


## searchConcurrencyLimits

> PagedResultsConcurrencyLimit searchConcurrencyLimits(tenant)

Search for flow concurrency limits

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        try {
            PagedResultsConcurrencyLimit result = kestraClient.FlowsApi().searchConcurrencyLimits(tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#searchConcurrencyLimits");
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

[**PagedResultsConcurrencyLimit**](PagedResultsConcurrencyLimit.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchConcurrencyLimits 200 response |  -  |


## searchFlows

> PagedResultsFlow searchFlows(tenant, page, size, sort, filters)

Search for flows

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test`
        try {
            PagedResultsFlow result = kestraClient.FlowsApi().searchFlows(tenant, page, size, sort, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#searchFlows");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] |

### Return type

[**PagedResultsFlow**](PagedResultsFlow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchFlows 200 response |  -  |


## searchFlowsBySourceCode

> PagedResultsSearchResultFlow searchFlowsBySourceCode(tenant, page, size, sort, q, namespace)

Search for flows source code

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        String q = "q_example"; // String | A string filter
        String namespace = "namespace_example"; // String | A namespace filter prefix
        try {
            PagedResultsSearchResultFlow result = kestraClient.FlowsApi().searchFlowsBySourceCode(tenant, page, size, sort, q, namespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#searchFlowsBySourceCode");
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
| **q** | **String**| A string filter | [optional] |
| **namespace** | **String**| A namespace filter prefix | [optional] |

### Return type

[**PagedResultsSearchResultFlow**](PagedResultsSearchResultFlow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchFlowsBySourceCode 200 response |  -  |


## taskFromFlow

> Task taskFromFlow(namespace, id, taskId, tenant, revision)

Get a flow task

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String taskId = "taskId_example"; // String | The task id
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | The flow revision
        try {
            Task result = kestraClient.FlowsApi().taskFromFlow(namespace, id, taskId, tenant, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#taskFromFlow");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **taskId** | **String**| The task id | |
| **tenant** | **String**|  | |
| **revision** | **Integer**| The flow revision | [optional] |

### Return type

[**Task**](Task.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getTaskFromFlow 200 response |  -  |


## updateConcurrencyLimit

> ConcurrencyLimit updateConcurrencyLimit(namespace, flowId, tenant, concurrencyLimit)

Update a flow concurrency limit

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | 
        String flowId = "flowId_example"; // String | 
        String tenant = "tenant_example"; // String | 
        ConcurrencyLimit concurrencyLimit = new ConcurrencyLimit(); // ConcurrencyLimit | 
        try {
            ConcurrencyLimit result = kestraClient.FlowsApi().updateConcurrencyLimit(namespace, flowId, tenant, concurrencyLimit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#updateConcurrencyLimit");
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
| **namespace** | **String**|  | |
| **flowId** | **String**|  | |
| **tenant** | **String**|  | |
| **concurrencyLimit** | [**ConcurrencyLimit**](ConcurrencyLimit.md)|  | |

### Return type

[**ConcurrencyLimit**](ConcurrencyLimit.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateConcurrencyLimit 200 response |  -  |


## updateFlow

> FlowWithSource updateFlow(namespace, id, tenant, body)

Update a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The flow source code
        try {
            FlowWithSource result = kestraClient.FlowsApi().updateFlow(namespace, id, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#updateFlow");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **tenant** | **String**|  | |
| **body** | **String**| The flow source code | |

### Return type

[**FlowWithSource**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success |  -  |


## updateFlowsInNamespace

> List&lt;FlowInterface&gt; updateFlowsInNamespace(namespace, tenant, body, delete, override)

Update a complete namespace from yaml source

All flow will be created / updated for this namespace. Flow that already created but not in &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | A list of flows source code
        Boolean delete = true; // Boolean | If missing flows should be deleted
        Boolean override = false; // Boolean | If namespace of all provided flows should be overridden
        try {
            List<FlowInterface> result = kestraClient.FlowsApi().updateFlowsInNamespace(namespace, tenant, body, delete, override);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#updateFlowsInNamespace");
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
| **namespace** | **String**| The flow namespace | |
| **tenant** | **String**|  | |
| **body** | **String**| A list of flows source code | |
| **delete** | **Boolean**| If missing flows should be deleted | [optional] [default to true] |
| **override** | **Boolean**| If namespace of all provided flows should be overridden | [optional] [default to false] |

### Return type

[**List&lt;FlowInterface&gt;**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateFlowsInNamespace 200 response |  -  |


## validateFlows

> List&lt;ValidateConstraintViolation&gt; validateFlows(tenant, body)

Validate a list of flows

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | Flows as YAML string or multipart files
        try {
            List<ValidateConstraintViolation> result = kestraClient.FlowsApi().validateFlows(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#validateFlows");
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
| **body** | **String**| Flows as YAML string or multipart files | |

### Return type

[**List&lt;ValidateConstraintViolation&gt;**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml, multipart/form-data
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | validateFlows 200 response |  -  |


## validateTask

> ValidateConstraintViolation validateTask(section, tenant, body)

Validate a task

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        FlowControllerTaskValidationType section = FlowControllerTaskValidationType.fromValue("TASKS"); // FlowControllerTaskValidationType | The type of task
        String tenant = "tenant_example"; // String | 
        Object body = null; // Object | A task definition that can be from tasks or triggers
        try {
            ValidateConstraintViolation result = kestraClient.FlowsApi().validateTask(section, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#validateTask");
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
| **section** | [**FlowControllerTaskValidationType**](.md)| The type of task | [enum: TASKS, TRIGGERS] |
| **tenant** | **String**|  | |
| **body** | **Object**| A task definition that can be from tasks or triggers | |

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml, application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | validateTask 200 response |  -  |


## validateTrigger

> ValidateConstraintViolation validateTrigger(tenant, body)

Validate trigger

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FlowsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        Object body = null; // Object | The trigger
        try {
            ValidateConstraintViolation result = kestraClient.FlowsApi().validateTrigger(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowsApi#validateTrigger");
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
| **body** | **Object**| The trigger | |

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | validateTrigger 200 response |  -  |

