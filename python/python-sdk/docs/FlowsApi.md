# kestrapy.FlowsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**flow_dependencies_from_namespace**](FlowsApi.md#flow_dependencies_from_namespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**generate_flow_graph**](FlowsApi.md#generate_flow_graph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow
[**generate_flow_graph_from_source**](FlowsApi.md#generate_flow_graph_from_source) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source
[**list_distinct_namespaces**](FlowsApi.md#list_distinct_namespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces
[**search_concurrency_limits**](FlowsApi.md#search_concurrency_limits) | **GET** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits
[**update_concurrency_limit**](FlowsApi.md#update_concurrency_limit) | **PUT** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit
[**update_flows_in_namespace**](FlowsApi.md#update_flows_in_namespace) | **POST** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from yaml source
[**validate_flows**](FlowsApi.md#validate_flows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows
[**validate_task**](FlowsApi.md#validate_task) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task
[**validate_trigger**](FlowsApi.md#validate_trigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger


# **flow_dependencies_from_namespace**
> FlowTopologyGraph flow_dependencies_from_namespace(namespace, tenant, destination_only=destination_only)

Retrieve flow dependencies

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The flow namespace
    tenant = 'tenant_example' # str | 
    destination_only = kestrapy.SchemasFromTypeArrayOfParameter() # SchemasFromTypeArrayOfParameter | if true, list only destination dependencies, otherwise list also source dependencies (optional)

    try:
        # Retrieve flow dependencies
        api_response = kestra_client.FlowsApi.flow_dependencies_from_namespace(namespace, tenant, destination_only=destination_only)
        print("The response of FlowsApi->flow_dependencies_from_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->flow_dependencies_from_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **tenant** | **str**|  | 
 **destination_only** | [**SchemasFromTypeArrayOfParameter**](.md)| if true, list only destination dependencies, otherwise list also source dependencies | [optional] 

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
**200** | getFlowDependenciesFromNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **generate_flow_graph**
> FlowGraph generate_flow_graph(id, namespace, tenant, revision=revision, subflows=subflows)

Generate a graph for a flow

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    id = 'id_example' # str | The flow id
    namespace = 'namespace_example' # str | The flow namespace
    tenant = 'tenant_example' # str | 
    revision = kestrapy.GenerateFlowGraphRevisionParameter() # GenerateFlowGraphRevisionParameter | The flow revision (optional)
    subflows = ['subflows_example'] # List[str] | The subflow tasks to display (optional)

    try:
        # Generate a graph for a flow
        api_response = kestra_client.FlowsApi.generate_flow_graph(id, namespace, tenant, revision=revision, subflows=subflows)
        print("The response of FlowsApi->generate_flow_graph:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->generate_flow_graph: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The flow id | 
 **namespace** | **str**| The flow namespace | 
 **tenant** | **str**|  | 
 **revision** | [**GenerateFlowGraphRevisionParameter**](.md)| The flow revision | [optional] 
 **subflows** | [**List[str]**](str.md)| The subflow tasks to display | [optional] 

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
**200** | Return a FlowGraph object |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **generate_flow_graph_from_source**
> FlowGraph generate_flow_graph_from_source(tenant, body, subflows=subflows)

Generate a graph for a flow source

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The flow source code
    subflows = kestrapy.GenerateFlowGraphFromSourceSubflowsParameter() # GenerateFlowGraphFromSourceSubflowsParameter | The subflow tasks to display (optional)

    try:
        # Generate a graph for a flow source
        api_response = kestra_client.FlowsApi.generate_flow_graph_from_source(tenant, body, subflows=subflows)
        print("The response of FlowsApi->generate_flow_graph_from_source:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->generate_flow_graph_from_source: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The flow source code | 
 **subflows** | [**GenerateFlowGraphFromSourceSubflowsParameter**](.md)| The subflow tasks to display | [optional] 

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
**200** | generateFlowGraphFromSource 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_distinct_namespaces**
> List[str] list_distinct_namespaces(tenant, q=q)

List all distinct namespaces

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)

    try:
        # List all distinct namespaces
        api_response = kestra_client.FlowsApi.list_distinct_namespaces(tenant, q=q)
        print("The response of FlowsApi->list_distinct_namespaces:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->list_distinct_namespaces: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 

### Return type

**List[str]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listDistinctNamespaces 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_concurrency_limits**
> PagedResultsConcurrencyLimit search_concurrency_limits(tenant)

Search for flow concurrency limits

### Example


```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str | 

    try:
        # Search for flow concurrency limits
        api_response = kestra_client.FlowsApi.search_concurrency_limits(tenant)
        print("The response of FlowsApi->search_concurrency_limits:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->search_concurrency_limits: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 

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
**200** | searchConcurrencyLimits 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_concurrency_limit**
> ConcurrencyLimit update_concurrency_limit(namespace, flow_id, tenant, concurrency_limit)

Update a flow concurrency limit

### Example


```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | 
    flow_id = 'flow_id_example' # str | 
    tenant = 'tenant_example' # str | 
    concurrency_limit = kestrapy.ConcurrencyLimit() # ConcurrencyLimit | 

    try:
        # Update a flow concurrency limit
        api_response = kestra_client.FlowsApi.update_concurrency_limit(namespace, flow_id, tenant, concurrency_limit)
        print("The response of FlowsApi->update_concurrency_limit:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->update_concurrency_limit: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**|  | 
 **flow_id** | **str**|  | 
 **tenant** | **str**|  | 
 **concurrency_limit** | [**ConcurrencyLimit**](ConcurrencyLimit.md)|  | 

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
**200** | updateConcurrencyLimit 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_flows_in_namespace**
> List[FlowInterface] update_flows_in_namespace(namespace, tenant, override=override, delete=delete)

Update a complete namespace from yaml source

All flows will be created / updated for this namespace.
Existing flows missing from `flows` will be deleted if the query delete is `true`

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The flow namespace
    tenant = 'tenant_example' # str | 
    override = kestrapy.UpdateFlowsInNamespaceOverrideParameter() # UpdateFlowsInNamespaceOverrideParameter | If namespace of all provided flows should be overridden (optional)
    delete = True # bool | If missing flows should be deleted (optional) (default to True)

    try:
        # Update a complete namespace from yaml source
        api_response = kestra_client.FlowsApi.update_flows_in_namespace(namespace, tenant, override=override, delete=delete)
        print("The response of FlowsApi->update_flows_in_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->update_flows_in_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **tenant** | **str**|  | 
 **override** | [**UpdateFlowsInNamespaceOverrideParameter**](.md)| If namespace of all provided flows should be overridden | [optional] 
 **delete** | **bool**| If missing flows should be deleted | [optional] [default to True]

### Return type

[**List[FlowInterface]**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateFlowsInNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_flows**
> List[ValidateConstraintViolation] validate_flows(tenant, body)

Validate a list of flows

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | Flows as YAML string or multipart files

    try:
        # Validate a list of flows
        api_response = kestra_client.FlowsApi.validate_flows(tenant, body)
        print("The response of FlowsApi->validate_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->validate_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| Flows as YAML string or multipart files | 

### Return type

[**List[ValidateConstraintViolation]**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/x-yaml, multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | validateFlows 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_task**
> ValidateConstraintViolation validate_task(section, tenant, body)

Validate a task

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    section = kestrapy.FlowControllerTaskValidationType() # FlowControllerTaskValidationType | The type of task
    tenant = 'tenant_example' # str | 
    body = None # object | A task definition that can be from tasks or triggers

    try:
        # Validate a task
        api_response = kestra_client.FlowsApi.validate_task(section, tenant, body)
        print("The response of FlowsApi->validate_task:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->validate_task: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **section** | [**FlowControllerTaskValidationType**](.md)| The type of task | 
 **tenant** | **str**|  | 
 **body** | **object**| A task definition that can be from tasks or triggers | 

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
**200** | validateTask 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_trigger**
> ValidateConstraintViolation validate_trigger(tenant, body)

Validate trigger

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str | 
    body = None # object | The trigger

    try:
        # Validate trigger
        api_response = kestra_client.FlowsApi.validate_trigger(tenant, body)
        print("The response of FlowsApi->validate_trigger:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->validate_trigger: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **object**| The trigger | 

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
**200** | validateTrigger 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

