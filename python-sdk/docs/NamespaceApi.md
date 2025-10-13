# kestrapy.NamespaceApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocomplete_namespaces**](NamespaceApi.md#autocomplete_namespaces) | **POST** /api/v1/{tenant}/namespaces/autocomplete | List namespaces for autocomplete
[**create_namespace**](NamespaceApi.md#create_namespace) | **POST** /api/v1/{tenant}/namespaces | Create a namespace
[**delete_namespace**](NamespaceApi.md#delete_namespace) | **DELETE** /api/v1/{tenant}/namespaces/{id} | Delete a namespace
[**get_flow_dependencies_from_namespace**](NamespaceApi.md#get_flow_dependencies_from_namespace) | **GET** /api/v1/{tenant}/namespaces/{namespace}/dependencies | Retrieve flow dependencies
[**get_namespace**](NamespaceApi.md#get_namespace) | **GET** /api/v1/{tenant}/namespaces/{id} | Get a namespace
[**inherited_plugin_defaults**](NamespaceApi.md#inherited_plugin_defaults) | **GET** /api/v1/{tenant}/namespaces/{id}/inherited-plugindefaults | List inherited plugin defaults
[**inherited_variables**](NamespaceApi.md#inherited_variables) | **GET** /api/v1/{tenant}/namespaces/{id}/inherited-variables | List inherited variables
[**search_namespaces**](NamespaceApi.md#search_namespaces) | **GET** /api/v1/{tenant}/namespaces/search | Search for namespaces
[**update_namespace**](NamespaceApi.md#update_namespace) | **PUT** /api/v1/{tenant}/namespaces/{id} | Update a namespace


# **autocomplete_namespaces**
> List[str] autocomplete_namespaces(tenant, api_autocomplete)

List namespaces for autocomplete

Returns a list of namespaces for use in autocomplete fields, optionally allowing to filter by query and ids. Used especially for binding creation.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.api_autocomplete import ApiAutocomplete
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
    api_instance = kestrapy.NamespaceApi(api_client)
    tenant = 'tenant_example' # str | 
    api_autocomplete = kestrapy.ApiAutocomplete() # ApiAutocomplete | 

    try:
        # List namespaces for autocomplete
        api_response = api_instance.autocomplete_namespaces(tenant, api_autocomplete)
        print("The response of NamespaceApi->autocomplete_namespaces:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceApi->autocomplete_namespaces: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **api_autocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)|  | 

### Return type

**List[str]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | autocompleteNamespaces 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_namespace**
> Namespace create_namespace(tenant, namespace)

Create a namespace

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.namespace import Namespace
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
    api_instance = kestrapy.NamespaceApi(api_client)
    tenant = 'tenant_example' # str | 
    namespace = kestrapy.Namespace() # Namespace | The namespace

    try:
        # Create a namespace
        api_response = api_instance.create_namespace(tenant, namespace)
        print("The response of NamespaceApi->create_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceApi->create_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **namespace** | [**Namespace**](Namespace.md)| The namespace | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_namespace**
> delete_namespace(id, tenant)

Delete a namespace

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
    api_instance = kestrapy.NamespaceApi(api_client)
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a namespace
        api_instance.delete_namespace(id, tenant)
    except Exception as e:
        print("Exception when calling NamespaceApi->delete_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
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
**204** | On success |  -  |

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
    api_instance = kestrapy.NamespaceApi(api_client)
    namespace = 'namespace_example' # str | The flow namespace
    destination_only = False # bool | if true, list only destination dependencies, otherwise list also source dependencies (default to False)
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve flow dependencies
        api_response = api_instance.get_flow_dependencies_from_namespace(namespace, destination_only, tenant)
        print("The response of NamespaceApi->get_flow_dependencies_from_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceApi->get_flow_dependencies_from_namespace: %s\n" % e)
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

# **get_namespace**
> Namespace get_namespace(id, tenant)

Get a namespace

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.namespace import Namespace
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
    api_instance = kestrapy.NamespaceApi(api_client)
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # Get a namespace
        api_response = api_instance.get_namespace(id, tenant)
        print("The response of NamespaceApi->get_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceApi->get_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
 **tenant** | **str**|  | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **inherited_plugin_defaults**
> List[PluginDefault] inherited_plugin_defaults(id, tenant)

List inherited plugin defaults

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.plugin_default import PluginDefault
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
    api_instance = kestrapy.NamespaceApi(api_client)
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List inherited plugin defaults
        api_response = api_instance.inherited_plugin_defaults(id, tenant)
        print("The response of NamespaceApi->inherited_plugin_defaults:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceApi->inherited_plugin_defaults: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
 **tenant** | **str**|  | 

### Return type

[**List[PluginDefault]**](PluginDefault.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | inheritedPluginDefaults 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **inherited_variables**
> Dict[str, object] inherited_variables(id, tenant)

List inherited variables

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
    api_instance = kestrapy.NamespaceApi(api_client)
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List inherited variables
        api_response = api_instance.inherited_variables(id, tenant)
        print("The response of NamespaceApi->inherited_variables:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceApi->inherited_variables: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
 **tenant** | **str**|  | 

### Return type

**Dict[str, object]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | inheritedVariables 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_namespaces**
> PagedResultsNamespace search_namespaces(page, size, existing, tenant, q=q, sort=sort)

Search for namespaces

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_namespace import PagedResultsNamespace
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
    api_instance = kestrapy.NamespaceApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    existing = False # bool | Return only existing namespace (default to False)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Search for namespaces
        api_response = api_instance.search_namespaces(page, size, existing, tenant, q=q, sort=sort)
        print("The response of NamespaceApi->search_namespaces:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceApi->search_namespaces: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **existing** | **bool**| Return only existing namespace | [default to False]
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsNamespace**](PagedResultsNamespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchNamespaces 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_namespace**
> Namespace update_namespace(id, tenant, namespace)

Update a namespace

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.namespace import Namespace
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
    api_instance = kestrapy.NamespaceApi(api_client)
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    namespace = kestrapy.Namespace() # Namespace | The namespace

    try:
        # Update a namespace
        api_response = api_instance.update_namespace(id, tenant, namespace)
        print("The response of NamespaceApi->update_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceApi->update_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
 **tenant** | **str**|  | 
 **namespace** | [**Namespace**](Namespace.md)| The namespace | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

