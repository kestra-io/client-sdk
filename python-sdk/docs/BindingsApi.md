# kestra_api_client.BindingsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulk_create_binding**](BindingsApi.md#bulk_create_binding) | **POST** /api/v1/{tenant}/bindings/bulk | Create multiple bindings
[**create_binding**](BindingsApi.md#create_binding) | **POST** /api/v1/{tenant}/bindings | Create a binding
[**delete_binding**](BindingsApi.md#delete_binding) | **DELETE** /api/v1/{tenant}/bindings/{id} | Delete a binding
[**get_binding**](BindingsApi.md#get_binding) | **GET** /api/v1/{tenant}/bindings/{id} | Retrieve a binding
[**search_bindings**](BindingsApi.md#search_bindings) | **GET** /api/v1/{tenant}/bindings/search | Search for bindings


# **bulk_create_binding**
> List[IAMBindingControllerApiBindingDetail] bulk_create_binding(tenant, iam_binding_controller_api_create_binding_request)

Create multiple bindings

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.iam_binding_controller_api_binding_detail import IAMBindingControllerApiBindingDetail
from kestra_api_client.models.iam_binding_controller_api_create_binding_request import IAMBindingControllerApiCreateBindingRequest
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestra_api_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestra_api_client.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.BindingsApi(api_client)
    tenant = 'tenant_example' # str | 
    iam_binding_controller_api_create_binding_request = [kestra_api_client.IAMBindingControllerApiCreateBindingRequest()] # List[IAMBindingControllerApiCreateBindingRequest] | The bindings

    try:
        # Create multiple bindings
        api_response = api_instance.bulk_create_binding(tenant, iam_binding_controller_api_create_binding_request)
        print("The response of BindingsApi->bulk_create_binding:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BindingsApi->bulk_create_binding: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **iam_binding_controller_api_create_binding_request** | [**List[IAMBindingControllerApiCreateBindingRequest]**](IAMBindingControllerApiCreateBindingRequest.md)| The bindings | 

### Return type

[**List[IAMBindingControllerApiBindingDetail]**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | bulkCreateBinding 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_binding**
> IAMBindingControllerApiBindingDetail create_binding(tenant, iam_binding_controller_api_create_binding_request)

Create a binding

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.iam_binding_controller_api_binding_detail import IAMBindingControllerApiBindingDetail
from kestra_api_client.models.iam_binding_controller_api_create_binding_request import IAMBindingControllerApiCreateBindingRequest
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestra_api_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestra_api_client.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.BindingsApi(api_client)
    tenant = 'tenant_example' # str | 
    iam_binding_controller_api_create_binding_request = kestra_api_client.IAMBindingControllerApiCreateBindingRequest() # IAMBindingControllerApiCreateBindingRequest | The binding

    try:
        # Create a binding
        api_response = api_instance.create_binding(tenant, iam_binding_controller_api_create_binding_request)
        print("The response of BindingsApi->create_binding:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BindingsApi->create_binding: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **iam_binding_controller_api_create_binding_request** | [**IAMBindingControllerApiCreateBindingRequest**](IAMBindingControllerApiCreateBindingRequest.md)| The binding | 

### Return type

[**IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createBinding 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_binding**
> delete_binding(id, tenant)

Delete a binding

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestra_api_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestra_api_client.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.BindingsApi(api_client)
    id = 'id_example' # str | The binding id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a binding
        api_instance.delete_binding(id, tenant)
    except Exception as e:
        print("Exception when calling BindingsApi->delete_binding: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The binding id | 
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

# **get_binding**
> IAMBindingControllerApiBindingDetail get_binding(id, tenant)

Retrieve a binding

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.iam_binding_controller_api_binding_detail import IAMBindingControllerApiBindingDetail
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestra_api_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestra_api_client.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.BindingsApi(api_client)
    id = 'id_example' # str | The binding id
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a binding
        api_response = api_instance.get_binding(id, tenant)
        print("The response of BindingsApi->get_binding:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BindingsApi->get_binding: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The binding id | 
 **tenant** | **str**|  | 

### Return type

[**IAMBindingControllerApiBindingDetail**](IAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getBinding 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_bindings**
> PagedResultsIAMBindingControllerApiBindingDetail search_bindings(page, size, tenant, q=q, sort=sort, type=type, id=id, namespace=namespace)

Search for bindings

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.paged_results_iam_binding_controller_api_binding_detail import PagedResultsIAMBindingControllerApiBindingDetail
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestra_api_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestra_api_client.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.BindingsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    type = kestra_api_client.BindingType() # BindingType | Binding type filter (optional)
    id = 'id_example' # str | External id filter (optional)
    namespace = 'namespace_example' # str | A namespace filter (optional)

    try:
        # Search for bindings
        api_response = api_instance.search_bindings(page, size, tenant, q=q, sort=sort, type=type, id=id, namespace=namespace)
        print("The response of BindingsApi->search_bindings:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BindingsApi->search_bindings: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **type** | [**BindingType**](.md)| Binding type filter | [optional] 
 **id** | **str**| External id filter | [optional] 
 **namespace** | **str**| A namespace filter | [optional] 

### Return type

[**PagedResultsIAMBindingControllerApiBindingDetail**](PagedResultsIAMBindingControllerApiBindingDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchBindings 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

