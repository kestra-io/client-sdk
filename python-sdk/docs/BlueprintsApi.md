# kestrapy.BlueprintsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_internal_blueprints**](BlueprintsApi.md#create_internal_blueprints) | **POST** /api/v1/{tenant}/blueprints/custom | Create a new internal blueprint
[**delete_internal_blueprints**](BlueprintsApi.md#delete_internal_blueprints) | **DELETE** /api/v1/{tenant}/blueprints/custom/{id} | Delete an internal blueprint
[**get_blueprint**](BlueprintsApi.md#get_blueprint) | **GET** /api/v1/{tenant}/blueprints/community/{kind}/{id} | Retrieve a blueprint
[**get_blueprint_graph**](BlueprintsApi.md#get_blueprint_graph) | **GET** /api/v1/{tenant}/blueprints/community/{kind}/{id}/graph | Retrieve a blueprint graph
[**get_blueprint_source**](BlueprintsApi.md#get_blueprint_source) | **GET** /api/v1/{tenant}/blueprints/community/{kind}/{id}/source | Retrieve a blueprint source code
[**internal_blueprint**](BlueprintsApi.md#internal_blueprint) | **GET** /api/v1/{tenant}/blueprints/custom/{id} | Retrieve an internal blueprint
[**internal_blueprint_flow**](BlueprintsApi.md#internal_blueprint_flow) | **GET** /api/v1/{tenant}/blueprints/custom/{id}/source | Retrieve an internal blueprint source code
[**search_blueprints**](BlueprintsApi.md#search_blueprints) | **GET** /api/v1/{tenant}/blueprints/community/{kind} | List all blueprints
[**search_internal_blueprints**](BlueprintsApi.md#search_internal_blueprints) | **GET** /api/v1/{tenant}/blueprints/custom | List all internal blueprints
[**update_internal_blueprints**](BlueprintsApi.md#update_internal_blueprints) | **PUT** /api/v1/{tenant}/blueprints/custom/{id} | Update an internal blueprint


# **create_internal_blueprints**
> BlueprintControllerApiBlueprintItemWithSource create_internal_blueprints(tenant, blueprint_controller_api_blueprint_item_with_source)

Create a new internal blueprint

Creates a new internal (custom) blueprint for the current tenant. Requires BLUEPRINT permission.

### Example


```python
import kestrapy
from kestrapy.models.blueprint_controller_api_blueprint_item_with_source import BlueprintControllerApiBlueprintItemWithSource
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    tenant = 'tenant_example' # str | 
    blueprint_controller_api_blueprint_item_with_source = kestrapy.BlueprintControllerApiBlueprintItemWithSource() # BlueprintControllerApiBlueprintItemWithSource | The internal blueprint to create

    try:
        # Create a new internal blueprint
        api_response = api_instance.create_internal_blueprints(tenant, blueprint_controller_api_blueprint_item_with_source)
        print("The response of BlueprintsApi->create_internal_blueprints:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->create_internal_blueprints: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **blueprint_controller_api_blueprint_item_with_source** | [**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)| The internal blueprint to create | 

### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createInternalBlueprints 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_internal_blueprints**
> delete_internal_blueprints(id, tenant)

Delete an internal blueprint

Deletes an internal (custom) blueprint for the current tenant. Requires BLUEPRINT permission.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    id = 'id_example' # str | The internal blueprint id to delete
    tenant = 'tenant_example' # str | 

    try:
        # Delete an internal blueprint
        api_instance.delete_internal_blueprints(id, tenant)
    except Exception as e:
        print("Exception when calling BlueprintsApi->delete_internal_blueprints: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The internal blueprint id to delete | 
 **tenant** | **str**|  | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteInternalBlueprints 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_blueprint**
> BlueprintControllerApiBlueprintItemWithSource get_blueprint(id, kind, tenant)

Retrieve a blueprint

Retrieves details of a specific community blueprint.

### Example


```python
import kestrapy
from kestrapy.models.blueprint_controller_api_blueprint_item_with_source import BlueprintControllerApiBlueprintItemWithSource
from kestrapy.models.blueprint_controller_kind import BlueprintControllerKind
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    id = 'id_example' # str | The blueprint id
    kind = kestrapy.BlueprintControllerKind() # BlueprintControllerKind | The blueprint kind
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a blueprint
        api_response = api_instance.get_blueprint(id, kind, tenant)
        print("The response of BlueprintsApi->get_blueprint:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->get_blueprint: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The blueprint id | 
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **str**|  | 

### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getBlueprint 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_blueprint_graph**
> Dict[str, object] get_blueprint_graph(id, kind, tenant)

Retrieve a blueprint graph

Retrieves the topology graph representation of a specific community blueprint.

### Example


```python
import kestrapy
from kestrapy.models.blueprint_controller_kind import BlueprintControllerKind
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    id = 'id_example' # str | The blueprint id
    kind = kestrapy.BlueprintControllerKind() # BlueprintControllerKind | The blueprint kind
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a blueprint graph
        api_response = api_instance.get_blueprint_graph(id, kind, tenant)
        print("The response of BlueprintsApi->get_blueprint_graph:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->get_blueprint_graph: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The blueprint id | 
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **str**|  | 

### Return type

**Dict[str, object]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getBlueprintGraph 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_blueprint_source**
> str get_blueprint_source(id, kind, tenant)

Retrieve a blueprint source code

Retrieves the YAML source code for a specific community blueprint.

### Example


```python
import kestrapy
from kestrapy.models.blueprint_controller_kind import BlueprintControllerKind
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    id = 'id_example' # str | The blueprint id
    kind = kestrapy.BlueprintControllerKind() # BlueprintControllerKind | The blueprint kind
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a blueprint source code
        api_response = api_instance.get_blueprint_source(id, kind, tenant)
        print("The response of BlueprintsApi->get_blueprint_source:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->get_blueprint_source: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The blueprint id | 
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **str**|  | 

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/yaml

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getBlueprintSource 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **internal_blueprint**
> BlueprintControllerApiBlueprintItemWithSource internal_blueprint(id, tenant)

Retrieve an internal blueprint

Retrieves details of a specific internal (custom) blueprint. Requires BLUEPRINT permission.

### Example


```python
import kestrapy
from kestrapy.models.blueprint_controller_api_blueprint_item_with_source import BlueprintControllerApiBlueprintItemWithSource
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    id = 'id_example' # str | The blueprint id
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve an internal blueprint
        api_response = api_instance.internal_blueprint(id, tenant)
        print("The response of BlueprintsApi->internal_blueprint:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->internal_blueprint: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The blueprint id | 
 **tenant** | **str**|  | 

### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | internalBlueprint 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **internal_blueprint_flow**
> str internal_blueprint_flow(id, tenant)

Retrieve an internal blueprint source code

Retrieves the YAML source code for a specific internal (custom) blueprint. Requires BLUEPRINT permission.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    id = 'id_example' # str | The blueprint id
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve an internal blueprint source code
        api_response = api_instance.internal_blueprint_flow(id, tenant)
        print("The response of BlueprintsApi->internal_blueprint_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->internal_blueprint_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The blueprint id | 
 **tenant** | **str**|  | 

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/yaml

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | internalBlueprintFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_blueprints**
> PagedResultsBlueprintControllerApiBlueprintItem search_blueprints(page, size, kind, tenant, q=q, sort=sort, tags=tags)

List all blueprints

Lists all community blueprints of the specified kind. Community blueprints are shared and versioned.

### Example


```python
import kestrapy
from kestrapy.models.blueprint_controller_kind import BlueprintControllerKind
from kestrapy.models.paged_results_blueprint_controller_api_blueprint_item import PagedResultsBlueprintControllerApiBlueprintItem
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 1 # int | The current page size (default to 1)
    kind = kestrapy.BlueprintControllerKind() # BlueprintControllerKind | The blueprint kind
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    sort = 'sort_example' # str | The sort of current page (optional)
    tags = ['tags_example'] # List[str] | A tags filter (optional)

    try:
        # List all blueprints
        api_response = api_instance.search_blueprints(page, size, kind, tenant, q=q, sort=sort, tags=tags)
        print("The response of BlueprintsApi->search_blueprints:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->search_blueprints: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 1]
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **sort** | **str**| The sort of current page | [optional] 
 **tags** | [**List[str]**](str.md)| A tags filter | [optional] 

### Return type

[**PagedResultsBlueprintControllerApiBlueprintItem**](PagedResultsBlueprintControllerApiBlueprintItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchBlueprints 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_internal_blueprints**
> PagedResultsBlueprint search_internal_blueprints(page, size, tenant, q=q, sort=sort, tags=tags)

List all internal blueprints

Lists all internal (custom) blueprints for the current tenant. Requires BLUEPRINT permission.

### Example


```python
import kestrapy
from kestrapy.models.paged_results_blueprint import PagedResultsBlueprint
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 1 # int | The current page size (default to 1)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    sort = 'sort_example' # str | The sort of current page (optional)
    tags = ['tags_example'] # List[str] | A tags filter (optional)

    try:
        # List all internal blueprints
        api_response = api_instance.search_internal_blueprints(page, size, tenant, q=q, sort=sort, tags=tags)
        print("The response of BlueprintsApi->search_internal_blueprints:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->search_internal_blueprints: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 1]
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **sort** | **str**| The sort of current page | [optional] 
 **tags** | [**List[str]**](str.md)| A tags filter | [optional] 

### Return type

[**PagedResultsBlueprint**](PagedResultsBlueprint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchInternalBlueprints 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_internal_blueprints**
> BlueprintWithFlow update_internal_blueprints(id, tenant, blueprint_controller_api_blueprint_item_with_source)

Update an internal blueprint

Updates an existing internal (custom) blueprint for the current tenant. Requires BLUEPRINT permission.

### Example


```python
import kestrapy
from kestrapy.models.blueprint_controller_api_blueprint_item_with_source import BlueprintControllerApiBlueprintItemWithSource
from kestrapy.models.blueprint_with_flow import BlueprintWithFlow
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintsApi(api_client)
    id = 'id_example' # str | The id of the internal blueprint to update
    tenant = 'tenant_example' # str | 
    blueprint_controller_api_blueprint_item_with_source = kestrapy.BlueprintControllerApiBlueprintItemWithSource() # BlueprintControllerApiBlueprintItemWithSource | The new internal blueprint for update

    try:
        # Update an internal blueprint
        api_response = api_instance.update_internal_blueprints(id, tenant, blueprint_controller_api_blueprint_item_with_source)
        print("The response of BlueprintsApi->update_internal_blueprints:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintsApi->update_internal_blueprints: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The id of the internal blueprint to update | 
 **tenant** | **str**|  | 
 **blueprint_controller_api_blueprint_item_with_source** | [**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)| The new internal blueprint for update | 

### Return type

[**BlueprintWithFlow**](BlueprintWithFlow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateInternalBlueprints 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

