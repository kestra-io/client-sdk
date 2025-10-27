# kestrapy.FlowsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulk_import_apps**](FlowsApi.md#bulk_import_apps) | **POST** /api/v1/{tenant}/apps/import |     Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 
[**bulk_update_flows**](FlowsApi.md#bulk_update_flows) | **POST** /api/v1/{tenant}/flows/bulk | Update from multiples yaml sources
[**create_flow**](FlowsApi.md#create_flow) | **POST** /api/v1/{tenant}/flows | Create a flow from yaml source
[**delete_flow**](FlowsApi.md#delete_flow) | **DELETE** /api/v1/{tenant}/flows/{namespace}/{id} | Delete a flow
[**delete_flows_by_ids**](FlowsApi.md#delete_flows_by_ids) | **DELETE** /api/v1/{tenant}/flows/delete/by-ids | Delete flows by their IDs.
[**delete_flows_by_query**](FlowsApi.md#delete_flows_by_query) | **DELETE** /api/v1/{tenant}/flows/delete/by-query | Delete flows returned by the query parameters.
[**disable_flows_by_ids**](FlowsApi.md#disable_flows_by_ids) | **POST** /api/v1/{tenant}/flows/disable/by-ids | Disable flows by their IDs.
[**disable_flows_by_query**](FlowsApi.md#disable_flows_by_query) | **POST** /api/v1/{tenant}/flows/disable/by-query | Disable flows returned by the query parameters.
[**enable_flows_by_ids**](FlowsApi.md#enable_flows_by_ids) | **POST** /api/v1/{tenant}/flows/enable/by-ids | Enable flows by their IDs.
[**enable_flows_by_query**](FlowsApi.md#enable_flows_by_query) | **POST** /api/v1/{tenant}/flows/enable/by-query | Enable flows returned by the query parameters.
[**export_flows_by_ids**](FlowsApi.md#export_flows_by_ids) | **POST** /api/v1/{tenant}/flows/export/by-ids | Export flows as a ZIP archive of yaml sources.
[**export_flows_by_query**](FlowsApi.md#export_flows_by_query) | **GET** /api/v1/{tenant}/flows/export/by-query | Export flows as a ZIP archive of yaml sources.
[**generate_flow_graph**](FlowsApi.md#generate_flow_graph) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/graph | Generate a graph for a flow
[**generate_flow_graph_from_source**](FlowsApi.md#generate_flow_graph_from_source) | **POST** /api/v1/{tenant}/flows/graph | Generate a graph for a flow source
[**get_flow**](FlowsApi.md#get_flow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id} | Get a flow
[**get_flow_dependencies**](FlowsApi.md#get_flow_dependencies) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/dependencies | Get flow dependencies
[**get_flow_dependencies_from_namespace**](FlowsApi.md#get_flow_dependencies_from_namespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**get_task_from_flow**](FlowsApi.md#get_task_from_flow) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/tasks/{taskId} | Get a flow task
[**import_flows**](FlowsApi.md#import_flows) | **POST** /api/v1/{tenant}/flows/import |     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned. 
[**list_distinct_namespaces**](FlowsApi.md#list_distinct_namespaces) | **GET** /api/v1/{tenant}/flows/distinct-namespaces | List all distinct namespaces
[**list_flow_revisions**](FlowsApi.md#list_flow_revisions) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/revisions | Get revisions for a flow
[**list_flows_by_namespace**](FlowsApi.md#list_flows_by_namespace) | **GET** /api/v1/{tenant}/flows/{namespace} | Retrieve all flows from a given namespace
[**search_flows**](FlowsApi.md#search_flows) | **GET** /api/v1/{tenant}/flows/search | Search for flows
[**search_flows_by_source_code**](FlowsApi.md#search_flows_by_source_code) | **GET** /api/v1/{tenant}/flows/source | Search for flows source code
[**update_flow**](FlowsApi.md#update_flow) | **PUT** /api/v1/{tenant}/flows/{namespace}/{id} | Update a flow
[**validate_flows**](FlowsApi.md#validate_flows) | **POST** /api/v1/{tenant}/flows/validate | Validate a list of flows
[**validate_task**](FlowsApi.md#validate_task) | **POST** /api/v1/{tenant}/flows/validate/task | Validate a task
[**validate_trigger**](FlowsApi.md#validate_trigger) | **POST** /api/v1/{tenant}/flows/validate/trigger | Validate trigger


# **bulk_import_apps**
> AppsControllerApiBulkImportResponse bulk_import_apps(tenant, file_upload=file_upload)

    Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn't be imported is returned. 

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_bulk_import_response import AppsControllerApiBulkImportResponse
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    file_upload = None # bytearray | The file to import, can be a ZIP archive or a multi-objects YAML file (optional)

    try:
        #     Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn't be imported is returned. 
        api_response = api_instance.bulk_import_apps(tenant, file_upload=file_upload)
        print("The response of FlowsApi->bulk_import_apps:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->bulk_import_apps: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **file_upload** | **bytearray**| The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] 

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
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **bulk_update_flows**
> List[FlowInterface] bulk_update_flows(delete, allow_namespace_child, tenant, namespace=namespace, body=body)

Update from multiples yaml sources

All flow will be created / updated for this namespace.
Flow that already created but not in `flows` will be deleted if the query delete is `true`

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.flow_interface import FlowInterface
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    delete = True # bool | If missing flow should be deleted (default to True)
    allow_namespace_child = False # bool | If namespace child should are allowed to be updated (default to False)
    tenant = 'tenant_example' # str | 
    namespace = 'namespace_example' # str | The namespace where to update flows (optional)
    body = 'body_example' # str | A list of flows source code splitted with \"---\" (optional)

    try:
        # Update from multiples yaml sources
        api_response = api_instance.bulk_update_flows(delete, allow_namespace_child, tenant, namespace=namespace, body=body)
        print("The response of FlowsApi->bulk_update_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->bulk_update_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **delete** | **bool**| If missing flow should be deleted | [default to True]
 **allow_namespace_child** | **bool**| If namespace child should are allowed to be updated | [default to False]
 **tenant** | **str**|  | 
 **namespace** | **str**| The namespace where to update flows | [optional] 
 **body** | **str**| A list of flows source code splitted with \&quot;---\&quot; | [optional] 

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
> FlowWithSource create_flow(tenant, body)

Create a flow from yaml source

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.flow_with_source import FlowWithSource
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The flow source code

    try:
        # Create a flow from yaml source
        api_response = api_instance.create_flow(tenant, body)
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
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a flow
        api_instance.delete_flow(namespace, id, tenant)
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
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.id_with_namespace import IdWithNamespace
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers

    try:
        # Delete flows by their IDs.
        api_response = api_instance.delete_flows_by_ids(tenant, id_with_namespace)
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
**200** | deleteFlowsByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_flows_by_query**
> BulkResponse delete_flows_by_query(tenant, filters=filters)

Delete flows returned by the query parameters.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.query_filter import QueryFilter
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Delete flows returned by the query parameters.
        api_response = api_instance.delete_flows_by_query(tenant, filters=filters)
        print("The response of FlowsApi->delete_flows_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->delete_flows_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**200** | deleteFlowsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disable_flows_by_ids**
> BulkResponse disable_flows_by_ids(tenant, id_with_namespace)

Disable flows by their IDs.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.id_with_namespace import IdWithNamespace
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers

    try:
        # Disable flows by their IDs.
        api_response = api_instance.disable_flows_by_ids(tenant, id_with_namespace)
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
**200** | disableFlowsByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disable_flows_by_query**
> BulkResponse disable_flows_by_query(tenant, filters=filters)

Disable flows returned by the query parameters.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.query_filter import QueryFilter
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Disable flows returned by the query parameters.
        api_response = api_instance.disable_flows_by_query(tenant, filters=filters)
        print("The response of FlowsApi->disable_flows_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->disable_flows_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**200** | disableFlowsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **enable_flows_by_ids**
> BulkResponse enable_flows_by_ids(tenant, id_with_namespace)

Enable flows by their IDs.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.id_with_namespace import IdWithNamespace
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers

    try:
        # Enable flows by their IDs.
        api_response = api_instance.enable_flows_by_ids(tenant, id_with_namespace)
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
**200** | enableFlowsByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **enable_flows_by_query**
> BulkResponse enable_flows_by_query(tenant, filters=filters)

Enable flows returned by the query parameters.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.query_filter import QueryFilter
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Enable flows returned by the query parameters.
        api_response = api_instance.enable_flows_by_query(tenant, filters=filters)
        print("The response of FlowsApi->enable_flows_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->enable_flows_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**200** | enableFlowsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export_flows_by_ids**
> bytearray export_flows_by_ids(tenant, id_with_namespace)

Export flows as a ZIP archive of yaml sources.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.id_with_namespace import IdWithNamespace
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    id_with_namespace = [kestrapy.IdWithNamespace()] # List[IdWithNamespace] | A list of tuple flow ID and namespace as flow identifiers

    try:
        # Export flows as a ZIP archive of yaml sources.
        api_response = api_instance.export_flows_by_ids(tenant, id_with_namespace)
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

**bytearray**

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
> bytearray export_flows_by_query(tenant, filters=filters)

Export flows as a ZIP archive of yaml sources.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.query_filter import QueryFilter
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Export flows as a ZIP archive of yaml sources.
        api_response = api_instance.export_flows_by_query(tenant, filters=filters)
        print("The response of FlowsApi->export_flows_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->export_flows_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**bytearray**

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

# **generate_flow_graph**
> FlowGraph generate_flow_graph(namespace, id, tenant, revision=revision, subflows=subflows)

Generate a graph for a flow

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.flow_graph import FlowGraph
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    revision = 56 # int | The flow revision (optional)
    subflows = ['subflows_example'] # List[str] | The subflow tasks to display (optional)

    try:
        # Generate a graph for a flow
        api_response = api_instance.generate_flow_graph(namespace, id, tenant, revision=revision, subflows=subflows)
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
import kestrapy
from kestrapy.models.flow_graph import FlowGraph
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The flow source code
    subflows = ['subflows_example'] # List[str] | The subflow tasks to display (optional)

    try:
        # Generate a graph for a flow source
        api_response = api_instance.generate_flow_graph_from_source(tenant, body, subflows=subflows)
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

# **get_flow**
> object get_flow(namespace, id, source, allow_deleted, tenant, revision=revision)

Get a flow

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    source = False # bool | Include the source code (default to False)
    allow_deleted = False # bool | Get flow even if deleted (default to False)
    tenant = 'tenant_example' # str | 
    revision = 56 # int | Get latest revision by default (optional)

    try:
        # Get a flow
        api_response = api_instance.get_flow(namespace, id, source, allow_deleted, tenant, revision=revision)
        print("The response of FlowsApi->get_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->get_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **source** | **bool**| Include the source code | [default to False]
 **allow_deleted** | **bool**| Get flow even if deleted | [default to False]
 **tenant** | **str**|  | 
 **revision** | **int**| Get latest revision by default | [optional] 

### Return type

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_flow_dependencies**
> FlowTopologyGraph get_flow_dependencies(namespace, id, destination_only, expand_all, tenant)

Get flow dependencies

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.flow_topology_graph import FlowTopologyGraph
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    destination_only = False # bool | If true, list only destination dependencies, otherwise list also source dependencies (default to False)
    expand_all = False # bool | If true, expand all dependencies recursively (default to False)
    tenant = 'tenant_example' # str | 

    try:
        # Get flow dependencies
        api_response = api_instance.get_flow_dependencies(namespace, id, destination_only, expand_all, tenant)
        print("The response of FlowsApi->get_flow_dependencies:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->get_flow_dependencies: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **destination_only** | **bool**| If true, list only destination dependencies, otherwise list also source dependencies | [default to False]
 **expand_all** | **bool**| If true, expand all dependencies recursively | [default to False]
 **tenant** | **str**|  | 

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

# **get_flow_dependencies_from_namespace**
> FlowTopologyGraph get_flow_dependencies_from_namespace(namespace, destination_only, tenant)

Retrieve flow dependencies

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.flow_topology_graph import FlowTopologyGraph
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    namespace = 'namespace_example' # str | The flow namespace
    destination_only = False # bool | if true, list only destination dependencies, otherwise list also source dependencies (default to False)
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve flow dependencies
        api_response = api_instance.get_flow_dependencies_from_namespace(namespace, destination_only, tenant)
        print("The response of FlowsApi->get_flow_dependencies_from_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->get_flow_dependencies_from_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **destination_only** | **bool**| if true, list only destination dependencies, otherwise list also source dependencies | [default to False]
 **tenant** | **str**|  | 

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

# **get_task_from_flow**
> Task get_task_from_flow(namespace, id, task_id, tenant, revision=revision)

Get a flow task

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.task import Task
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    task_id = 'task_id_example' # str | The task id
    tenant = 'tenant_example' # str | 
    revision = 56 # int | The flow revision (optional)

    try:
        # Get a flow task
        api_response = api_instance.get_task_from_flow(namespace, id, task_id, tenant, revision=revision)
        print("The response of FlowsApi->get_task_from_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->get_task_from_flow: %s\n" % e)
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

# **import_flows**
> List[str] import_flows(tenant, file_upload=file_upload)

    Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn't be imported is returned. 

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    file_upload = None # bytearray | The file to import, can be a ZIP archive or a multi-objects YAML file (optional)

    try:
        #     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn't be imported is returned. 
        api_response = api_instance.import_flows(tenant, file_upload=file_upload)
        print("The response of FlowsApi->import_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->import_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **file_upload** | **bytearray**| The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] 

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

# **list_distinct_namespaces**
> List[str] list_distinct_namespaces(tenant, q=q)

List all distinct namespaces

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)

    try:
        # List all distinct namespaces
        api_response = api_instance.list_distinct_namespaces(tenant, q=q)
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
> List[FlowWithSource] list_flow_revisions(namespace, id, tenant)

Get revisions for a flow

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.flow_with_source import FlowWithSource
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 

    try:
        # Get revisions for a flow
        api_response = api_instance.list_flow_revisions(namespace, id, tenant)
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
import kestrapy
from kestrapy.models.flow import Flow
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    namespace = 'namespace_example' # str | Namespace to filter flows
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve all flows from a given namespace
        api_response = api_instance.list_flows_by_namespace(namespace, tenant)
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

# **search_flows**
> PagedResultsFlow search_flows(page, size, tenant, sort=sort, filters=filters)

Search for flows

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_flow import PagedResultsFlow
from kestrapy.models.query_filter import QueryFilter
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Search for flows
        api_response = api_instance.search_flows(page, size, tenant, sort=sort, filters=filters)
        print("The response of FlowsApi->search_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->search_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
> PagedResultsSearchResultFlow search_flows_by_source_code(page, size, tenant, sort=sort, q=q, namespace=namespace)

Search for flows source code

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_search_result_flow import PagedResultsSearchResultFlow
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)

    try:
        # Search for flows source code
        api_response = api_instance.search_flows_by_source_code(page, size, tenant, sort=sort, q=q, namespace=namespace)
        print("The response of FlowsApi->search_flows_by_source_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->search_flows_by_source_code: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 

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
**200** | searchFlowsBySourceCode 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_flow**
> UpdateFlow200Response update_flow(id, namespace, tenant, body)

Update a flow

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.update_flow200_response import UpdateFlow200Response
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    id = 'id_example' # str | The flow id
    namespace = 'namespace_example' # str | The flow namespace
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The flow source code

    try:
        # Update a flow
        api_response = api_instance.update_flow(id, namespace, tenant, body)
        print("The response of FlowsApi->update_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->update_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The flow id | 
 **namespace** | **str**| The flow namespace | 
 **tenant** | **str**|  | 
 **body** | **str**| The flow source code | 

### Return type

[**UpdateFlow200Response**](UpdateFlow200Response.md)

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

# **validate_flows**
> List[ValidateConstraintViolation] validate_flows(tenant, body)

Validate a list of flows

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | A list of flows source code in a single string

    try:
        # Validate a list of flows
        api_response = api_instance.validate_flows(tenant, body)
        print("The response of FlowsApi->validate_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowsApi->validate_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| A list of flows source code in a single string | 

### Return type

[**List[ValidateConstraintViolation]**](ValidateConstraintViolation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/x-yaml
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
import kestrapy
from kestrapy.models.flow_controller_task_validation_type import FlowControllerTaskValidationType
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    section = kestrapy.FlowControllerTaskValidationType() # FlowControllerTaskValidationType | The type of task
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | A task definition that can be from tasks or triggers

    try:
        # Validate a task
        api_response = api_instance.validate_task(section, tenant, body)
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
 **body** | **str**| A task definition that can be from tasks or triggers | 

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
import kestrapy
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.FlowsApi(api_client)
    tenant = 'tenant_example' # str | 
    body = None # object | The trigger

    try:
        # Validate trigger
        api_response = api_instance.validate_trigger(tenant, body)
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

