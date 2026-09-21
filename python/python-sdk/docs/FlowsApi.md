# kestrapy.FlowsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apply_replace_by_source_code**](FlowsApi.md#apply_replace_by_source_code) | **POST** /api/v1/{tenant}/flows/source/replace/apply | Apply a Source Search replace-all operation
[**bulk_update_flows**](FlowsApi.md#bulk_update_flows) | **POST** /api/v1/{tenant}/flows/bulk | Update from multiples yaml sources
[**create_flow**](FlowsApi.md#create_flow) | **POST** /api/v1/{tenant}/flows | Create a flow from yaml source
[**delete_flow**](FlowsApi.md#delete_flow) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id} | Delete a flow
[**delete_flows_by_ids**](FlowsApi.md#delete_flows_by_ids) | **DELETE** /api/v1/{tenant}/flows/delete/by-ids | Delete flows by their IDs.
[**delete_flows_by_query**](FlowsApi.md#delete_flows_by_query) | **DELETE** /api/v1/{tenant}/flows/delete/by-query | Delete flows returned by the query parameters.
[**delete_revisions**](FlowsApi.md#delete_revisions) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Delete revisions for a flow
[**disable_flows_by_ids**](FlowsApi.md#disable_flows_by_ids) | **POST** /api/v1/{tenant}/flows/disable/by-ids | Disable flows by their IDs.
[**disable_flows_by_query**](FlowsApi.md#disable_flows_by_query) | **POST** /api/v1/{tenant}/flows/disable/by-query | Disable flows returned by the query parameters.
[**enable_flows_by_ids**](FlowsApi.md#enable_flows_by_ids) | **POST** /api/v1/{tenant}/flows/enable/by-ids | Enable flows by their IDs.
[**enable_flows_by_query**](FlowsApi.md#enable_flows_by_query) | **POST** /api/v1/{tenant}/flows/enable/by-query | Enable flows returned by the query parameters.
[**export_flows**](FlowsApi.md#export_flows) | **GET** /api/v1/{tenant}/flows/export/by-query/csv | Export all flows as a streamed CSV file
[**export_flows_by_ids**](FlowsApi.md#export_flows_by_ids) | **POST** /api/v1/{tenant}/flows/export/by-ids | Export flows as a ZIP archive of yaml sources.
[**export_flows_by_query**](FlowsApi.md#export_flows_by_query) | **GET** /api/v1/{tenant}/flows/export/by-query | Export flows as a ZIP archive of yaml sources.
[**expressions**](FlowsApi.md#expressions) | **POST** /api/v1/{tenant}/flows/expressions | Get available Pebble expressions for a flow
[**flow**](FlowsApi.md#flow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id} | Get a flow
[**flow_dependencies**](FlowsApi.md#flow_dependencies) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/dependencies | Get flow dependencies
[**flow_dependencies_from_namespace**](FlowsApi.md#flow_dependencies_from_namespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**flow_hashes_by_ids**](FlowsApi.md#flow_hashes_by_ids) | **POST** /api/v1/{tenant}/flows/hashes/by-ids | Batch-compute source hashes for flows by id (drift detection)
[**generate_flow_graph**](FlowsApi.md#generate_flow_graph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow
[**generate_flow_graph_from_source**](FlowsApi.md#generate_flow_graph_from_source) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source
[**import_flows**](FlowsApi.md#import_flows) | **POST** /api/v1/{tenant}/flows/import |     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 
[**list_deprecated**](FlowsApi.md#list_deprecated) | **GET** /api/v1/{tenant}/flows/deprecated | List flows containing deprecated tasks
[**list_distinct_namespaces**](FlowsApi.md#list_distinct_namespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces
[**list_flow_revisions**](FlowsApi.md#list_flow_revisions) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Get revisions for a flow
[**list_flows_by_namespace**](FlowsApi.md#list_flows_by_namespace) | **GET** /api/v1/{tenant}/flows/{namespace} | Retrieve all flows from a given namespace
[**preview_policies**](FlowsApi.md#preview_policies) | **POST** /api/v1/{tenant}/flows/policies/preview | Preview the governance policy effects (mutations + violations) on a flow source
[**preview_replace_by_source_code**](FlowsApi.md#preview_replace_by_source_code) | **POST** /api/v1/{tenant}/flows/source/replace/preview | Preview a Source Search replace-all operation
[**replace_line_by_source_code**](FlowsApi.md#replace_line_by_source_code) | **POST** /api/v1/{tenant}/flows/source/replace/line | Apply a Source Search replace on a single match line
[**search_concurrency_limits**](FlowsApi.md#search_concurrency_limits) | **GET** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits
[**search_flows**](FlowsApi.md#search_flows) | **GET** /api/v1/{tenant}/flows/search | Search for flows
[**search_flows_by_source_code**](FlowsApi.md#search_flows_by_source_code) | **GET** /api/v1/{tenant}/flows/source | Search for flows source code
[**task_from_flow**](FlowsApi.md#task_from_flow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/tasks/{taskId} | Get a flow task
[**update_concurrency_limit**](FlowsApi.md#update_concurrency_limit) | **PUT** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit
[**update_flow**](FlowsApi.md#update_flow) | **PUT** /api/v1/{tenant}/flows/{namespace}/{id} | Update a flow
[**update_flows_in_namespace**](FlowsApi.md#update_flows_in_namespace) | **POST** /api/v1/{tenant}/flows/{namespace} | Update a complete namespace from yaml source
[**validate_flows**](FlowsApi.md#validate_flows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows
[**validate_task**](FlowsApi.md#validate_task) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task
[**validate_trigger**](FlowsApi.md#validate_trigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger


# **apply_replace_by_source_code**
> SourceSearchReplaceApplyResponse apply_replace_by_source_code(tenant, source_search_replace_apply_request)

Apply a Source Search replace-all operation

Replaces every match in the given flows and persists the new revisions. Flows the caller is not allowed to edit are skipped.

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
    source_search_replace_apply_request = kestrapy.SourceSearchReplaceApplyRequest() # SourceSearchReplaceApplyRequest | The search query, replacement and target flows

    try:
        # Apply a Source Search replace-all operation
        api_response = kestra_client.FlowsApi.apply_replace_by_source_code(tenant, source_search_replace_apply_request)
        print("The response of FlowsApi->apply_replace_by_source_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->apply_replace_by_source_code: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **source_search_replace_apply_request** | [**SourceSearchReplaceApplyRequest**](SourceSearchReplaceApplyRequest.md)| The search query, replacement and target flows | 

### Return type

[**SourceSearchReplaceApplyResponse**](SourceSearchReplaceApplyResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | applyReplaceBySourceCode 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **bulk_update_flows**
> List[FlowInterface] bulk_update_flows(tenant, delete=delete, namespace=namespace, allow_namespace_child=allow_namespace_child, body=body)

Update from multiples yaml sources

All flow will be created / updated for this namespace.
Flow that already created but not in `flows` will be deleted if the query delete is `true`

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
    delete = True # bool | If missing flow should be deleted (optional) (default to True)
    namespace = 'namespace_example' # str | The namespace where to update flows (optional)
    allow_namespace_child = False # bool | If namespace child should are allowed to be updated (optional) (default to False)
    body = 'body_example' # str | A list of flows source code split with \"---\" (optional)

    try:
        # Update from multiples yaml sources
        api_response = kestra_client.FlowsApi.bulk_update_flows(tenant, delete=delete, namespace=namespace, allow_namespace_child=allow_namespace_child, body=body)
        print("The response of FlowsApi->bulk_update_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->bulk_update_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **delete** | **bool**| If missing flow should be deleted | [optional] [default to True]
 **namespace** | **str**| The namespace where to update flows | [optional] 
 **allow_namespace_child** | **bool**| If namespace child should are allowed to be updated | [optional] [default to False]
 **body** | **str**| A list of flows source code split with \&quot;---\&quot; | [optional] 

### Return type

[**List[FlowInterface]**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/x-yaml
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | bulkUpdateFlows 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_flow**
> FlowWithSource create_flow(tenant, body, draft=draft)

Create a flow from yaml source

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
    draft = False # bool | Save the flow as a draft. Drafts are not picked up by webhooks, schedules or subflows and are not validated for constraint violations. (optional) (default to False)

    try:
        # Create a flow from yaml source
        api_response = kestra_client.FlowsApi.create_flow(tenant, body, draft=draft)
        print("The response of FlowsApi->create_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->create_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The flow source code | 
 **draft** | **bool**| Save the flow as a draft. Drafts are not picked up by webhooks, schedules or subflows and are not validated for constraint violations. | [optional] [default to False]

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
**200** | createFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_flow**
> delete_flow(namespace, id, tenant)

Delete a flow

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
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a flow
        kestra_client.FlowsApi.delete_flow(namespace, id, tenant)
    except Exception as e:
        print("Exception when calling FlowsApi->delete_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **tenant** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteFlow 200 response |  -  |
**204** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_flows_by_ids**
> BulkResponse delete_flows_by_ids(tenant, id_with_namespace)

Delete flows by their IDs.

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
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers

    try:
        # Delete flows by their IDs.
        api_response = kestra_client.FlowsApi.delete_flows_by_ids(tenant, id_with_namespace)
        print("The response of FlowsApi->delete_flows_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->delete_flows_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **id_with_namespace** | [**List[IdWithNamespace]**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | 

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_flows_by_query**
> BulkResponse delete_flows_by_query(tenant, filters=filters)

Delete flows returned by the query parameters.

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Delete flows returned by the query parameters.
        api_response = kestra_client.FlowsApi.delete_flows_by_query(tenant, filters=filters)
        print("The response of FlowsApi->delete_flows_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->delete_flows_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_revisions**
> delete_revisions(namespace, id, revisions, tenant)

Delete revisions for a flow

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
    id = 'id_example' # str | The flow id
    revisions = [56] # List[int] | 
    tenant = 'tenant_example' # str | 

    try:
        # Delete revisions for a flow
        kestra_client.FlowsApi.delete_revisions(namespace, id, revisions, tenant)
    except Exception as e:
        print("Exception when calling FlowsApi->delete_revisions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **revisions** | [**List[int]**](int.md)|  | 
 **tenant** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteRevisions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disable_flows_by_ids**
> BulkResponse disable_flows_by_ids(tenant, id_with_namespace)

Disable flows by their IDs.

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
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers

    try:
        # Disable flows by their IDs.
        api_response = kestra_client.FlowsApi.disable_flows_by_ids(tenant, id_with_namespace)
        print("The response of FlowsApi->disable_flows_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->disable_flows_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **id_with_namespace** | [**List[IdWithNamespace]**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | 

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disable_flows_by_query**
> BulkResponse disable_flows_by_query(tenant, filters=filters)

Disable flows returned by the query parameters.

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Disable flows returned by the query parameters.
        api_response = kestra_client.FlowsApi.disable_flows_by_query(tenant, filters=filters)
        print("The response of FlowsApi->disable_flows_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->disable_flows_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **enable_flows_by_ids**
> BulkResponse enable_flows_by_ids(tenant, id_with_namespace)

Enable flows by their IDs.

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
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers

    try:
        # Enable flows by their IDs.
        api_response = kestra_client.FlowsApi.enable_flows_by_ids(tenant, id_with_namespace)
        print("The response of FlowsApi->enable_flows_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->enable_flows_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **id_with_namespace** | [**List[IdWithNamespace]**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | 

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **enable_flows_by_query**
> BulkResponse enable_flows_by_query(tenant, filters=filters)

Enable flows returned by the query parameters.

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Enable flows returned by the query parameters.
        api_response = kestra_client.FlowsApi.enable_flows_by_query(tenant, filters=filters)
        print("The response of FlowsApi->enable_flows_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->enable_flows_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export_flows**
> List[str] export_flows(tenant, filters=filters)

Export all flows as a streamed CSV file

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | A list of filters (optional)

    try:
        # Export all flows as a streamed CSV file
        api_response = kestra_client.FlowsApi.export_flows(tenant, filters=filters)
        print("The response of FlowsApi->export_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->export_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| A list of filters | [optional] 

### Return type

**List[str]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/csv

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | exportFlows 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export_flows_by_ids**
> bytes export_flows_by_ids(tenant, id_with_namespace)

Export flows as a ZIP archive of yaml sources.

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
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers

    try:
        # Export flows as a ZIP archive of yaml sources.
        api_response = kestra_client.FlowsApi.export_flows_by_ids(tenant, id_with_namespace)
        print("The response of FlowsApi->export_flows_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->export_flows_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **id_with_namespace** | [**List[IdWithNamespace]**](IdWithNamespace.md)| A list of tuple flow ID and namespace as flow identifiers | 

### Return type

**bytes**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | exportFlowsByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export_flows_by_query**
> bytes export_flows_by_query(tenant, filters=filters)

Export flows as a ZIP archive of yaml sources.

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Export flows as a ZIP archive of yaml sources.
        api_response = kestra_client.FlowsApi.export_flows_by_query(tenant, filters=filters)
        print("The response of FlowsApi->export_flows_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->export_flows_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

### Return type

**bytes**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | exportFlowsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **expressions**
> ExpressionContext expressions(tenant, body, task_id=task_id)

Get available Pebble expressions for a flow

Returns a categorized map of expression strings available for autocompletion in the No-Code editor.

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
    task_id = 'task_id_example' # str | Optional task ID to scope outputs to prior tasks (optional)

    try:
        # Get available Pebble expressions for a flow
        api_response = kestra_client.FlowsApi.expressions(tenant, body, task_id=task_id)
        print("The response of FlowsApi->expressions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->expressions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The flow source code | 
 **task_id** | **str**| Optional task ID to scope outputs to prior tasks | [optional] 

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
**200** | Categorized expressions map |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **flow**
> FlowWithSource flow(namespace, id, tenant, source=source, revision=revision, allow_deleted=allow_deleted)

Get a flow

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
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    source = False # bool | Include the source code (optional) (default to False)
    revision = 56 # int | Get latest revision by default (optional)
    allow_deleted = False # bool | Get flow even if deleted (optional) (default to False)

    try:
        # Get a flow
        api_response = kestra_client.FlowsApi.flow(namespace, id, tenant, source=source, revision=revision, allow_deleted=allow_deleted)
        print("The response of FlowsApi->flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **source** | **bool**| Include the source code | [optional] [default to False]
 **revision** | **int**| Get latest revision by default | [optional] 
 **allow_deleted** | **bool**| Get flow even if deleted | [optional] [default to False]

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **flow_dependencies**
> FlowTopologyGraph flow_dependencies(namespace, id, tenant, destination_only=destination_only, expand_all=expand_all)

Get flow dependencies

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
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    destination_only = False # bool | If true, list only destination dependencies, otherwise list also source dependencies (optional) (default to False)
    expand_all = False # bool | If true, expand all dependencies recursively (optional) (default to False)

    try:
        # Get flow dependencies
        api_response = kestra_client.FlowsApi.flow_dependencies(namespace, id, tenant, destination_only=destination_only, expand_all=expand_all)
        print("The response of FlowsApi->flow_dependencies:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->flow_dependencies: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **destination_only** | **bool**| If true, list only destination dependencies, otherwise list also source dependencies | [optional] [default to False]
 **expand_all** | **bool**| If true, expand all dependencies recursively | [optional] [default to False]

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
**200** | getFlowDependencies 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

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
    destination_only = False # bool | if true, list only destination dependencies, otherwise list also source dependencies (optional) (default to False)

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
 **destination_only** | **bool**| if true, list only destination dependencies, otherwise list also source dependencies | [optional] [default to False]

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

# **flow_hashes_by_ids**
> ApiFlowHashesResponse flow_hashes_by_ids(tenant, id_with_namespace)

Batch-compute source hashes for flows by id (drift detection)

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
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | 

    try:
        # Batch-compute source hashes for flows by id (drift detection)
        api_response = kestra_client.FlowsApi.flow_hashes_by_ids(tenant, id_with_namespace)
        print("The response of FlowsApi->flow_hashes_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->flow_hashes_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **id_with_namespace** | [**List[IdWithNamespace]**](IdWithNamespace.md)|  | 

### Return type

[**ApiFlowHashesResponse**](ApiFlowHashesResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | flowHashesByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **generate_flow_graph**
> FlowGraph generate_flow_graph(namespace, id, tenant, revision=revision, subflows=subflows)

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    revision = 56 # int | The flow revision (optional)
    subflows = ['subflows_example'] # List[str] | The subflow tasks to display (optional)

    try:
        # Generate a graph for a flow
        api_response = kestra_client.FlowsApi.generate_flow_graph(namespace, id, tenant, revision=revision, subflows=subflows)
        print("The response of FlowsApi->generate_flow_graph:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->generate_flow_graph: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **revision** | **int**| The flow revision | [optional] 
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
    subflows = ['subflows_example'] # List[str] | The subflow tasks to display (optional)

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
 **subflows** | [**List[str]**](str.md)| The subflow tasks to display | [optional] 

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

# **import_flows**
> List[str] import_flows(tenant, fail_on_error=fail_on_error, file_upload=file_upload)

    Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn't be imported is returned. 

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
    fail_on_error = False # bool | If should fail on invalid flows (optional) (default to False)
    file_upload = None # bytes | The file to import, can be a ZIP archive or a multi-objects YAML file (optional)

    try:
        #     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn't be imported is returned. 
        api_response = kestra_client.FlowsApi.import_flows(tenant, fail_on_error=fail_on_error, file_upload=file_upload)
        print("The response of FlowsApi->import_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->import_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **fail_on_error** | **bool**| If should fail on invalid flows | [optional] [default to False]
 **file_upload** | **bytes**| The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] 

### Return type

**List[str]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_deprecated**
> List[FlowControllerFlowWithDeprecatedTasks] list_deprecated(tenant, namespace=namespace)

List flows containing deprecated tasks

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
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)

    try:
        # List flows containing deprecated tasks
        api_response = kestra_client.FlowsApi.list_deprecated(tenant, namespace=namespace)
        print("The response of FlowsApi->list_deprecated:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->list_deprecated: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **namespace** | **str**| A namespace filter prefix | [optional] 

### Return type

[**List[FlowControllerFlowWithDeprecatedTasks]**](FlowControllerFlowWithDeprecatedTasks.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listDeprecated 200 response |  -  |

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

# **list_flow_revisions**
> List[FlowWithSource] list_flow_revisions(namespace, id, tenant, allow_delete=allow_delete)

Get revisions for a flow

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
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    allow_delete = False # bool |  (optional) (default to False)

    try:
        # Get revisions for a flow
        api_response = kestra_client.FlowsApi.list_flow_revisions(namespace, id, tenant, allow_delete=allow_delete)
        print("The response of FlowsApi->list_flow_revisions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->list_flow_revisions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **allow_delete** | **bool**|  | [optional] [default to False]

### Return type

[**List[FlowWithSource]**](FlowWithSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listFlowRevisions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_flows_by_namespace**
> List[Flow] list_flows_by_namespace(namespace, tenant)

Retrieve all flows from a given namespace

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
    namespace = 'namespace_example' # str | Namespace to filter flows
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve all flows from a given namespace
        api_response = kestra_client.FlowsApi.list_flows_by_namespace(namespace, tenant)
        print("The response of FlowsApi->list_flows_by_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->list_flows_by_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| Namespace to filter flows | 
 **tenant** | **str**|  | 

### Return type

[**List[Flow]**](Flow.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listFlowsByNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **preview_policies**
> PolicyPreviewResponse preview_policies(tenant, policy_preview_request)

Preview the governance policy effects (mutations + violations) on a flow source

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
    policy_preview_request = kestrapy.PolicyPreviewRequest() # PolicyPreviewRequest | 

    try:
        # Preview the governance policy effects (mutations + violations) on a flow source
        api_response = kestra_client.FlowsApi.preview_policies(tenant, policy_preview_request)
        print("The response of FlowsApi->preview_policies:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->preview_policies: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **policy_preview_request** | [**PolicyPreviewRequest**](PolicyPreviewRequest.md)|  | 

### Return type

[**PolicyPreviewResponse**](PolicyPreviewResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | previewPolicies 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **preview_replace_by_source_code**
> SourceSearchReplacePreviewResponse preview_replace_by_source_code(tenant, source_search_replace_preview_request)

Preview a Source Search replace-all operation

Computes the matched lines and their proposed replacement for every matching flow, without persisting anything.

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
    source_search_replace_preview_request = kestrapy.SourceSearchReplacePreviewRequest() # SourceSearchReplacePreviewRequest | The search query and replacement

    try:
        # Preview a Source Search replace-all operation
        api_response = kestra_client.FlowsApi.preview_replace_by_source_code(tenant, source_search_replace_preview_request)
        print("The response of FlowsApi->preview_replace_by_source_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->preview_replace_by_source_code: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **source_search_replace_preview_request** | [**SourceSearchReplacePreviewRequest**](SourceSearchReplacePreviewRequest.md)| The search query and replacement | 

### Return type

[**SourceSearchReplacePreviewResponse**](SourceSearchReplacePreviewResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | previewReplaceBySourceCode 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **replace_line_by_source_code**
> SourceSearchReplaceApplyResponse replace_line_by_source_code(tenant, source_search_replace_line_request)

Apply a Source Search replace on a single match line

Replaces the matches on one line of one flow and persists the new revision. Returns the flow as skipped if it is not editable or fails validation.

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
    source_search_replace_line_request = kestrapy.SourceSearchReplaceLineRequest() # SourceSearchReplaceLineRequest | The search query, replacement and target match line

    try:
        # Apply a Source Search replace on a single match line
        api_response = kestra_client.FlowsApi.replace_line_by_source_code(tenant, source_search_replace_line_request)
        print("The response of FlowsApi->replace_line_by_source_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->replace_line_by_source_code: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **source_search_replace_line_request** | [**SourceSearchReplaceLineRequest**](SourceSearchReplaceLineRequest.md)| The search query, replacement and target match line | 

### Return type

[**SourceSearchReplaceApplyResponse**](SourceSearchReplaceApplyResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | replaceLineBySourceCode 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_concurrency_limits**
> PagedResultsConcurrencyLimit search_concurrency_limits(tenant)

Search for flow concurrency limits

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

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchConcurrencyLimits 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_flows**
> PagedResultsFlow search_flows(tenant, page=page, size=size, sort=sort, filters=filters)

Search for flows

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
    page = 1 # int | The current page (optional) (default to 1)
    size = 10 # int | The current page size (optional) (default to 10)
    sort = ['namespace:asc'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Search for flows
        api_response = kestra_client.FlowsApi.search_flows(tenant, page=page, size=size, sort=sort, filters=filters)
        print("The response of FlowsApi->search_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->search_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **page** | **int**| The current page | [optional] [default to 1]
 **size** | **int**| The current page size | [optional] [default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

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
**200** | searchFlows 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_flows_by_source_code**
> PagedResultsSourceSearchResult search_flows_by_source_code(tenant, page=page, size=size, sort=sort, q=q, namespace=namespace, case_sensitive=case_sensitive, whole_word=whole_word, regex=regex, scope=scope)

Search for flows source code

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
    page = 1 # int | The current page (optional) (default to 1)
    size = 10 # int | The current page size (optional) (default to 10)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)
    case_sensitive = False # bool | Whether the query must match with exact case (optional) (default to False)
    whole_word = False # bool | Whether the query must match on word boundaries only (optional) (default to False)
    regex = False # bool | Whether the query is a regular expression rather than a literal string (optional) (default to False)
    scope = kestrapy.SourceSearchScope() # SourceSearchScope | Restricts matches to a top-level section of the flow YAML (optional)

    try:
        # Search for flows source code
        api_response = kestra_client.FlowsApi.search_flows_by_source_code(tenant, page=page, size=size, sort=sort, q=q, namespace=namespace, case_sensitive=case_sensitive, whole_word=whole_word, regex=regex, scope=scope)
        print("The response of FlowsApi->search_flows_by_source_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->search_flows_by_source_code: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **page** | **int**| The current page | [optional] [default to 1]
 **size** | **int**| The current page size | [optional] [default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 
 **case_sensitive** | **bool**| Whether the query must match with exact case | [optional] [default to False]
 **whole_word** | **bool**| Whether the query must match on word boundaries only | [optional] [default to False]
 **regex** | **bool**| Whether the query is a regular expression rather than a literal string | [optional] [default to False]
 **scope** | [**SourceSearchScope**](.md)| Restricts matches to a top-level section of the flow YAML | [optional] 

### Return type

[**PagedResultsSourceSearchResult**](PagedResultsSourceSearchResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchFlowsBySourceCode 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **task_from_flow**
> Task task_from_flow(namespace, id, task_id, tenant, revision=revision)

Get a flow task

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
    id = 'id_example' # str | The flow id
    task_id = 'task_id_example' # str | The task id
    tenant = 'tenant_example' # str | 
    revision = 56 # int | The flow revision (optional)

    try:
        # Get a flow task
        api_response = kestra_client.FlowsApi.task_from_flow(namespace, id, task_id, tenant, revision=revision)
        print("The response of FlowsApi->task_from_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->task_from_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **task_id** | **str**| The task id | 
 **tenant** | **str**|  | 
 **revision** | **int**| The flow revision | [optional] 

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
**200** | getTaskFromFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_concurrency_limit**
> ConcurrencyLimit update_concurrency_limit(namespace, flow_id, tenant, concurrency_limit)

Update a flow concurrency limit

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

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateConcurrencyLimit 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_flow**
> FlowWithSource update_flow(namespace, id, tenant, body, draft=draft)

Update a flow

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
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The flow source code
    draft = False # bool | Save the flow as a draft. Drafts are not picked up by webhooks, schedules or subflows and are not validated for constraint violations. (optional) (default to False)

    try:
        # Update a flow
        api_response = kestra_client.FlowsApi.update_flow(namespace, id, tenant, body, draft=draft)
        print("The response of FlowsApi->update_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->update_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **body** | **str**| The flow source code | 
 **draft** | **bool**| Save the flow as a draft. Drafts are not picked up by webhooks, schedules or subflows and are not validated for constraint violations. | [optional] [default to False]

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_flows_in_namespace**
> List[FlowInterface] update_flows_in_namespace(namespace, tenant, body, delete=delete, override=override)

Update a complete namespace from yaml source

All flow will be created / updated for this namespace.
Flow that already created but not in `flows` will be deleted if the query delete is `true`

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
    body = 'body_example' # str | A list of flows source code
    delete = True # bool | If missing flows should be deleted (optional) (default to True)
    override = False # bool | If namespace of all provided flows should be overridden (optional) (default to False)

    try:
        # Update a complete namespace from yaml source
        api_response = kestra_client.FlowsApi.update_flows_in_namespace(namespace, tenant, body, delete=delete, override=override)
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
 **body** | **str**| A list of flows source code | 
 **delete** | **bool**| If missing flows should be deleted | [optional] [default to True]
 **override** | **bool**| If namespace of all provided flows should be overridden | [optional] [default to False]

### Return type

[**List[FlowInterface]**](FlowInterface.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/x-yaml
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
    section = 'section_example' # str | The flow section the definition belongs to (triggers, or any task-holding section: tasks, errors, finally, afterExecution)
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
 **section** | **str**| The flow section the definition belongs to (triggers, or any task-holding section: tasks, errors, finally, afterExecution) | 
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

