# FlowsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**flowDependenciesFromNamespace**](FlowsApi.md#flowDependenciesFromNamespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies |
| [**generateFlowGraph**](FlowsApi.md#generateFlowGraph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow |
| [**generateFlowGraphFromSource**](FlowsApi.md#generateFlowGraphFromSource) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source |
| [**listDistinctNamespaces**](FlowsApi.md#listDistinctNamespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces |
| [**searchConcurrencyLimits**](FlowsApi.md#searchConcurrencyLimits) | **GET** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits |
| [**updateConcurrencyLimit**](FlowsApi.md#updateConcurrencyLimit) | **PUT** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit |
| [**updateFlowsInNamespace**](FlowsApi.md#updateFlowsInNamespace) | **POST** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from yaml source |
| [**validateFlows**](FlowsApi.md#validateFlows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows |
| [**validateTask**](FlowsApi.md#validateTask) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task |
| [**validateTrigger**](FlowsApi.md#validateTrigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger |



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
        SchemasFromTypeArrayOfParameter destinationOnly = new SchemasFromTypeArrayOfParameter(); // SchemasFromTypeArrayOfParameter | if true, list only destination dependencies, otherwise list also source dependencies
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
| **destinationOnly** | [**SchemasFromTypeArrayOfParameter**](.md)| if true, list only destination dependencies, otherwise list also source dependencies | [optional] |

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

> FlowGraph generateFlowGraph(id, namespace, tenant, revision, subflows)

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

        String id = "id_example"; // String | The flow id
        String namespace = "namespace_example"; // String | The flow namespace
        String tenant = "tenant_example"; // String | 
        GenerateFlowGraphRevisionParameter revision = new GenerateFlowGraphRevisionParameter(); // GenerateFlowGraphRevisionParameter | The flow revision
        List<String> subflows = Arrays.asList(); // List<String> | The subflow tasks to display
        try {
            FlowGraph result = kestraClient.FlowsApi().generateFlowGraph(id, namespace, tenant, revision, subflows);
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
| **id** | **String**| The flow id | |
| **namespace** | **String**| The flow namespace | |
| **tenant** | **String**|  | |
| **revision** | [**GenerateFlowGraphRevisionParameter**](.md)| The flow revision | [optional] |
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
        GenerateFlowGraphFromSourceSubflowsParameter subflows = new GenerateFlowGraphFromSourceSubflowsParameter(); // GenerateFlowGraphFromSourceSubflowsParameter | The subflow tasks to display
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
| **subflows** | [**GenerateFlowGraphFromSourceSubflowsParameter**](.md)| The subflow tasks to display | [optional] |

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


## searchConcurrencyLimits

> PagedResultsConcurrencyLimit searchConcurrencyLimits(tenant)

Search for flow concurrency limits

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
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

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchConcurrencyLimits 200 response |  -  |


## updateConcurrencyLimit

> ConcurrencyLimit updateConcurrencyLimit(namespace, flowId, tenant, concurrencyLimit)

Update a flow concurrency limit

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
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

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateConcurrencyLimit 200 response |  -  |


## updateFlowsInNamespace

> List&lt;FlowInterface&gt; updateFlowsInNamespace(namespace, tenant, override, delete)

Update a complete namespace from yaml source

All flows will be created / updated for this namespace. Existing flows missing from &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;

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
        UpdateFlowsInNamespaceOverrideParameter override = new UpdateFlowsInNamespaceOverrideParameter(); // UpdateFlowsInNamespaceOverrideParameter | If namespace of all provided flows should be overridden
        Boolean delete = true; // Boolean | If missing flows should be deleted
        try {
            List<FlowInterface> result = kestraClient.FlowsApi().updateFlowsInNamespace(namespace, tenant, override, delete);
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
| **override** | [**UpdateFlowsInNamespaceOverrideParameter**](.md)| If namespace of all provided flows should be overridden | [optional] |
| **delete** | **Boolean**| If missing flows should be deleted | [optional] [default to true] |

### Return type

[**List&lt;FlowInterface&gt;**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
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

