# flows

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**bulkUpdateFlows**](flows.md#bulkUpdateFlows) | **POST** /api/v1/{tenant}/flows/bulk | Update from multiples yaml sources |
| [**createFlow**](flows.md#createFlow) | **POST** /api/v1/{tenant}/flows | Create a flow from yaml source |
| [**deleteFlow**](flows.md#deleteFlow) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id} | Delete a flow |
| [**deleteFlowsByIds**](flows.md#deleteFlowsByIds) | **DELETE** /api/v1/{tenant}/flows/delete/by-ids | Delete flows by their IDs. |
| [**deleteFlowsByQuery**](flows.md#deleteFlowsByQuery) | **DELETE** /api/v1/{tenant}/flows/delete/by-query | Delete flows returned by the query parameters. |
| [**disableFlowsByIds**](flows.md#disableFlowsByIds) | **POST** /api/v1/{tenant}/flows/disable/by-ids | Disable flows by their IDs. |
| [**disableFlowsByQuery**](flows.md#disableFlowsByQuery) | **POST** /api/v1/{tenant}/flows/disable/by-query | Disable flows returned by the query parameters. |
| [**enableFlowsByIds**](flows.md#enableFlowsByIds) | **POST** /api/v1/{tenant}/flows/enable/by-ids | Enable flows by their IDs. |
| [**enableFlowsByQuery**](flows.md#enableFlowsByQuery) | **POST** /api/v1/{tenant}/flows/enable/by-query | Enable flows returned by the query parameters. |
| [**exportFlowsByIds**](flows.md#exportFlowsByIds) | **POST** /api/v1/{tenant}/flows/export/by-ids | Export flows as a ZIP archive of yaml sources. |
| [**exportFlowsByQuery**](flows.md#exportFlowsByQuery) | **GET** /api/v1/{tenant}/flows/export/by-query | Export flows as a ZIP archive of yaml sources. |
| [**flow**](flows.md#flow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id} | Get a flow |
| [**flowDependencies**](flows.md#flowDependencies) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/dependencies | Get flow dependencies |
| [**flowDependenciesFromNamespace**](flows.md#flowDependenciesFromNamespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies |
| [**generateFlowGraph**](flows.md#generateFlowGraph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow |
| [**generateFlowGraphFromSource**](flows.md#generateFlowGraphFromSource) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source |
| [**importFlows**](flows.md#importFlows) | **POST** /api/v1/{tenant}/flows/import |     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned.  |
| [**listDistinctNamespaces**](flows.md#listDistinctNamespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces |
| [**listFlowRevisions**](flows.md#listFlowRevisions) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Get revisions for a flow |
| [**listFlowsByNamespace**](flows.md#listFlowsByNamespace) | **GET** /api/v1/{tenant}/flows/{namespace} | Retrieve all flows from a given namespace |
| [**searchFlows**](flows.md#searchFlows) | **GET** /api/v1/{tenant}/flows/search | Search for flows |
| [**searchFlowsBySourceCode**](flows.md#searchFlowsBySourceCode) | **GET** /api/v1/{tenant}/flows/source | Search for flows source code |
| [**taskFromFlow**](flows.md#taskFromFlow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/tasks/{taskId} | Get a flow task |
| [**updateFlow**](flows.md#updateFlow) | **PUT** /api/v1/{tenant}/flows/{namespace}/{id} | Update a flow |
| [**updateFlowsInNamespace**](flows.md#updateFlowsInNamespace) | **POST** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from yaml source |
| [**validateFlows**](flows.md#validateFlows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows |
| [**validateTask**](flows.md#validateTask) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task |
| [**validateTrigger**](flows.md#validateTrigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger |



## bulkUpdateFlows

> List&lt;FlowInterface&gt; bulkUpdateFlows(delete, allowNamespaceChild, tenant, namespace, body)

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
import io.kestra.sdk.api.flows;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        Boolean delete = true; // Boolean | If missing flow should be deleted
        Boolean allowNamespaceChild = false; // Boolean | If namespace child should are allowed to be updated
        String tenant = "tenant_example"; // String | 
        String namespace = "namespace_example"; // String | The namespace where to update flows
        String body = "body_example"; // String | A list of flows source code splitted with \"---\"
        try {
            List<FlowInterface> result = kestraClient.flows().bulkUpdateFlows(delete, allowNamespaceChild, tenant, namespace, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#bulkUpdateFlows");
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
| **delete** | **Boolean**| If missing flow should be deleted | [default to true] |
| **allowNamespaceChild** | **Boolean**| If namespace child should are allowed to be updated | [default to false] |
| **tenant** | **String**|  | |
| **namespace** | **String**| The namespace where to update flows | [optional] |
| **body** | **String**| A list of flows source code splitted with \&quot;---\&quot; | [optional] |

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
import io.kestra.sdk.api.flows;

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
            FlowWithSource result = kestraClient.flows().createFlow(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#createFlow");
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
import io.kestra.sdk.api.flows;

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
            kestraClient.flows().deleteFlow(namespace, id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#deleteFlow");
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
import io.kestra.sdk.api.flows;

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
            BulkResponse result = kestraClient.flows().deleteFlowsByIds(tenant, idWithNamespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#deleteFlowsByIds");
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
import io.kestra.sdk.api.flows;

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
            BulkResponse result = kestraClient.flows().deleteFlowsByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#deleteFlowsByQuery");
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
import io.kestra.sdk.api.flows;

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
            BulkResponse result = kestraClient.flows().disableFlowsByIds(tenant, idWithNamespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#disableFlowsByIds");
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
import io.kestra.sdk.api.flows;

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
            BulkResponse result = kestraClient.flows().disableFlowsByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#disableFlowsByQuery");
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
import io.kestra.sdk.api.flows;

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
            BulkResponse result = kestraClient.flows().enableFlowsByIds(tenant, idWithNamespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#enableFlowsByIds");
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
import io.kestra.sdk.api.flows;

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
            BulkResponse result = kestraClient.flows().enableFlowsByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#enableFlowsByQuery");
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
import io.kestra.sdk.api.flows;

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
            byte[] result = kestraClient.flows().exportFlowsByIds(tenant, idWithNamespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#exportFlowsByIds");
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
import io.kestra.sdk.api.flows;

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
            byte[] result = kestraClient.flows().exportFlowsByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#exportFlowsByQuery");
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


## flow

> FlowWithSource flow(namespace, id, source, allowDeleted, tenant, revision)

Get a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.flows;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        Boolean source = false; // Boolean | Include the source code
        Boolean allowDeleted = false; // Boolean | Get flow even if deleted
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | Get latest revision by default
        try {
            FlowWithSource result = kestraClient.flows().flow(namespace, id, source, allowDeleted, tenant, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#flow");
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
| **source** | **Boolean**| Include the source code | [default to false] |
| **allowDeleted** | **Boolean**| Get flow even if deleted | [default to false] |
| **tenant** | **String**|  | |
| **revision** | **Integer**| Get latest revision by default | [optional] |

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
| **200** | getFlow 200 response |  -  |


## flowDependencies

> FlowTopologyGraph flowDependencies(namespace, id, destinationOnly, expandAll, tenant)

Get flow dependencies

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.flows;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        Boolean destinationOnly = false; // Boolean | If true, list only destination dependencies, otherwise list also source dependencies
        Boolean expandAll = false; // Boolean | If true, expand all dependencies recursively
        String tenant = "tenant_example"; // String | 
        try {
            FlowTopologyGraph result = kestraClient.flows().flowDependencies(namespace, id, destinationOnly, expandAll, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#flowDependencies");
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
| **destinationOnly** | **Boolean**| If true, list only destination dependencies, otherwise list also source dependencies | [default to false] |
| **expandAll** | **Boolean**| If true, expand all dependencies recursively | [default to false] |
| **tenant** | **String**|  | |

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

> FlowTopologyGraph flowDependenciesFromNamespace(namespace, destinationOnly, tenant)

Retrieve flow dependencies

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.flows;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        Boolean destinationOnly = false; // Boolean | if true, list only destination dependencies, otherwise list also source dependencies
        String tenant = "tenant_example"; // String | 
        try {
            FlowTopologyGraph result = kestraClient.flows().flowDependenciesFromNamespace(namespace, destinationOnly, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#flowDependenciesFromNamespace");
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
| **destinationOnly** | **Boolean**| if true, list only destination dependencies, otherwise list also source dependencies | [default to false] |
| **tenant** | **String**|  | |

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
import io.kestra.sdk.api.flows;

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
            FlowGraph result = kestraClient.flows().generateFlowGraph(namespace, id, tenant, revision, subflows);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#generateFlowGraph");
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
import io.kestra.sdk.api.flows;

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
            FlowGraph result = kestraClient.flows().generateFlowGraphFromSource(tenant, body, subflows);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#generateFlowGraphFromSource");
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

> List&lt;String&gt; importFlows(tenant, fileUpload)

    Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.flows;

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
            List<String> result = kestraClient.flows().importFlows(tenant, fileUpload);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#importFlows");
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
import io.kestra.sdk.api.flows;

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
            List<String> result = kestraClient.flows().listDistinctNamespaces(tenant, q);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#listDistinctNamespaces");
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

> List&lt;FlowWithSource&gt; listFlowRevisions(namespace, id, tenant)

Get revisions for a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.flows;

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
            List<FlowWithSource> result = kestraClient.flows().listFlowRevisions(namespace, id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#listFlowRevisions");
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
import io.kestra.sdk.api.flows;

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
            List<Flow> result = kestraClient.flows().listFlowsByNamespace(namespace, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#listFlowsByNamespace");
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


## searchFlows

> PagedResultsFlow searchFlows(page, size, tenant, sort, filters)

Search for flows

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.flows;

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
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        try {
            PagedResultsFlow result = kestraClient.flows().searchFlows(page, size, tenant, sort, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#searchFlows");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | [optional] |

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

> PagedResultsSearchResultFlow searchFlowsBySourceCode(page, size, tenant, sort, q, namespace)

Search for flows source code

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.flows;

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
        String q = "q_example"; // String | A string filter
        String namespace = "namespace_example"; // String | A namespace filter prefix
        try {
            PagedResultsSearchResultFlow result = kestraClient.flows().searchFlowsBySourceCode(page, size, tenant, sort, q, namespace);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#searchFlowsBySourceCode");
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
import io.kestra.sdk.api.flows;

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
            Task result = kestraClient.flows().taskFromFlow(namespace, id, taskId, tenant, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#taskFromFlow");
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
import io.kestra.sdk.api.flows;

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
            FlowWithSource result = kestraClient.flows().updateFlow(namespace, id, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#updateFlow");
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

> List&lt;FlowInterface&gt; updateFlowsInNamespace(namespace, delete, tenant, body)

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
import io.kestra.sdk.api.flows;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        Boolean delete = true; // Boolean | If missing flow should be deleted
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | A list of flows source code
        try {
            List<FlowInterface> result = kestraClient.flows().updateFlowsInNamespace(namespace, delete, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#updateFlowsInNamespace");
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
| **delete** | **Boolean**| If missing flow should be deleted | [default to true] |
| **tenant** | **String**|  | |
| **body** | **String**| A list of flows source code | |

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
import io.kestra.sdk.api.flows;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | A list of flows source code in a single string
        try {
            List<ValidateConstraintViolation> result = kestraClient.flows().validateFlows(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#validateFlows");
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
| **body** | **String**| A list of flows source code in a single string | |

### Return type

[**List&lt;ValidateConstraintViolation&gt;**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
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
import io.kestra.sdk.api.flows;

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
            ValidateConstraintViolation result = kestraClient.flows().validateTask(section, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#validateTask");
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
import io.kestra.sdk.api.flows;

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
            ValidateConstraintViolation result = kestraClient.flows().validateTrigger(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling flows#validateTrigger");
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

