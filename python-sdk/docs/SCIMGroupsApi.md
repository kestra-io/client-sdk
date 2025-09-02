# kestra_api_client.SCIMGroupsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_scim_resource_by_id_groups**](SCIMGroupsApi.md#create_scim_resource_by_id_groups) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | 
[**delete_groups**](SCIMGroupsApi.md#delete_groups) | **DELETE** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**find_groups**](SCIMGroupsApi.md#find_groups) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/.search | 
[**get_scim_resource_by_id_groups**](SCIMGroupsApi.md#get_scim_resource_by_id_groups) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**patch_groups**](SCIMGroupsApi.md#patch_groups) | **PATCH** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**query_groups**](SCIMGroupsApi.md#query_groups) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | 
[**update_groups**](SCIMGroupsApi.md#update_groups) | **PUT** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 


# **create_scim_resource_by_id_groups**
> ScimResource create_scim_resource_by_id_groups(integration, tenant, scim_user, attributes=attributes, excluded_attributes=excluded_attributes)

Create

### Example


```python
import kestra_api_client
from kestra_api_client.models.scim_resource import ScimResource
from kestra_api_client.models.scim_user import ScimUser
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.SCIMGroupsApi(api_client)
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 
    scim_user = kestra_api_client.ScimUser() # ScimUser | 
    attributes = 'attributes_example' # str |  (optional)
    excluded_attributes = 'excluded_attributes_example' # str |  (optional)

    try:
        api_response = api_instance.create_scim_resource_by_id_groups(integration, tenant, scim_user, attributes=attributes, excluded_attributes=excluded_attributes)
        print("The response of SCIMGroupsApi->create_scim_resource_by_id_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMGroupsApi->create_scim_resource_by_id_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **integration** | **str**|  | 
 **tenant** | **str**|  | 
 **scim_user** | [**ScimUser**](ScimUser.md)|  | 
 **attributes** | **str**|  | [optional] 
 **excluded_attributes** | **str**|  | [optional] 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/scim+json
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Bad Request |  -  |
**409** | Conflict |  -  |
**500** | Internal Server Error |  -  |
**501** | Not Implemented |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_groups**
> delete_groups(id, integration, tenant)

Delete from the backing store

### Example


```python
import kestra_api_client
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.SCIMGroupsApi(api_client)
    id = 'id_example' # str | 
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 

    try:
        api_instance.delete_groups(id, integration, tenant)
    except Exception as e:
        print("Exception when calling SCIMGroupsApi->delete_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 
 **integration** | **str**|  | 
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
**204** | No Content |  -  |
**400** | Bad Request |  -  |
**404** | Not found |  -  |
**500** | Internal Server Error |  -  |
**501** | Not Implemented |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **find_groups**
> ScimResource find_groups(integration, tenant, search_request)

Search

### Example


```python
import kestra_api_client
from kestra_api_client.models.scim_resource import ScimResource
from kestra_api_client.models.search_request import SearchRequest
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.SCIMGroupsApi(api_client)
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 
    search_request = kestra_api_client.SearchRequest() # SearchRequest | 

    try:
        api_response = api_instance.find_groups(integration, tenant, search_request)
        print("The response of SCIMGroupsApi->find_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMGroupsApi->find_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **integration** | **str**|  | 
 **tenant** | **str**|  | 
 **search_request** | [**SearchRequest**](SearchRequest.md)|  | 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/scim+json
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |
**501** | Not Implemented |  -  |
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_scim_resource_by_id_groups**
> ScimResource get_scim_resource_by_id_groups(id, integration, tenant, attributes=attributes, excluded_attributes=excluded_attributes)

Find by id

### Example


```python
import kestra_api_client
from kestra_api_client.models.scim_resource import ScimResource
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.SCIMGroupsApi(api_client)
    id = 'id_example' # str | 
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 
    attributes = 'attributes_example' # str |  (optional)
    excluded_attributes = 'excluded_attributes_example' # str |  (optional)

    try:
        api_response = api_instance.get_scim_resource_by_id_groups(id, integration, tenant, attributes=attributes, excluded_attributes=excluded_attributes)
        print("The response of SCIMGroupsApi->get_scim_resource_by_id_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMGroupsApi->get_scim_resource_by_id_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 
 **integration** | **str**|  | 
 **tenant** | **str**|  | 
 **attributes** | **str**|  | [optional] 
 **excluded_attributes** | **str**|  | [optional] 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**400** | Bad Request |  -  |
**404** | Not found |  -  |
**500** | Internal Server Error |  -  |
**501** | Not Implemented |  -  |
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_groups**
> patch_groups(id, integration, tenant, patch_request, attributes=attributes, excluded_attributes=excluded_attributes)

Patch a portion of the backing store

### Example


```python
import kestra_api_client
from kestra_api_client.models.patch_request import PatchRequest
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.SCIMGroupsApi(api_client)
    id = 'id_example' # str | 
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 
    patch_request = kestra_api_client.PatchRequest() # PatchRequest | 
    attributes = 'attributes_example' # str |  (optional)
    excluded_attributes = 'excluded_attributes_example' # str |  (optional)

    try:
        api_instance.patch_groups(id, integration, tenant, patch_request, attributes=attributes, excluded_attributes=excluded_attributes)
    except Exception as e:
        print("Exception when calling SCIMGroupsApi->patch_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 
 **integration** | **str**|  | 
 **tenant** | **str**|  | 
 **patch_request** | [**PatchRequest**](PatchRequest.md)|  | 
 **attributes** | **str**|  | [optional] 
 **excluded_attributes** | **str**|  | [optional] 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/scim+json
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | No Content |  -  |
**400** | Bad Request |  -  |
**404** | Not found |  -  |
**500** | Internal Server Error |  -  |
**501** | Not Implemented |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **query_groups**
> ScimResource query_groups(integration, tenant, attributes=attributes, excluded_attributes=excluded_attributes, filter=filter, sort_by=sort_by, sort_order=sort_order, start_index=start_index, count=count)

Find by a combination of query parameters

### Example


```python
import kestra_api_client
from kestra_api_client.models.scim_resource import ScimResource
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.SCIMGroupsApi(api_client)
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 
    attributes = 'attributes_example' # str |  (optional)
    excluded_attributes = 'excluded_attributes_example' # str |  (optional)
    filter = 'filter_example' # str |  (optional)
    sort_by = 'sort_by_example' # str |  (optional)
    sort_order = kestra_api_client.SortOrder() # SortOrder |  (optional)
    start_index = 56 # int |  (optional)
    count = 56 # int |  (optional)

    try:
        api_response = api_instance.query_groups(integration, tenant, attributes=attributes, excluded_attributes=excluded_attributes, filter=filter, sort_by=sort_by, sort_order=sort_order, start_index=start_index, count=count)
        print("The response of SCIMGroupsApi->query_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMGroupsApi->query_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **integration** | **str**|  | 
 **tenant** | **str**|  | 
 **attributes** | **str**|  | [optional] 
 **excluded_attributes** | **str**|  | [optional] 
 **filter** | **str**|  | [optional] 
 **sort_by** | **str**|  | [optional] 
 **sort_order** | [**SortOrder**](.md)|  | [optional] 
 **start_index** | **int**|  | [optional] 
 **count** | **int**|  | [optional] 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**400** | Bad Request |  -  |
**404** | Not found |  -  |
**500** | Internal Server Error |  -  |
**501** | Not Implemented |  -  |
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_groups**
> ScimResource update_groups(id, integration, tenant, scim_resource, attributes=attributes, excluded_attributes=excluded_attributes)

Update

### Example


```python
import kestra_api_client
from kestra_api_client.models.scim_resource import ScimResource
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.SCIMGroupsApi(api_client)
    id = 'id_example' # str | 
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 
    scim_resource = kestra_api_client.ScimResource() # ScimResource | 
    attributes = 'attributes_example' # str |  (optional)
    excluded_attributes = 'excluded_attributes_example' # str |  (optional)

    try:
        api_response = api_instance.update_groups(id, integration, tenant, scim_resource, attributes=attributes, excluded_attributes=excluded_attributes)
        print("The response of SCIMGroupsApi->update_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMGroupsApi->update_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 
 **integration** | **str**|  | 
 **tenant** | **str**|  | 
 **scim_resource** | [**ScimResource**](ScimResource.md)|  | 
 **attributes** | **str**|  | [optional] 
 **excluded_attributes** | **str**|  | [optional] 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/scim+json
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |
**501** | Not Implemented |  -  |
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

