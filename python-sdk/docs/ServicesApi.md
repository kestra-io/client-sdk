# kestra_api_client.ServicesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_active_services**](ServicesApi.md#get_active_services) | **GET** /api/v1/instance/services/active | List all active services
[**get_service**](ServicesApi.md#get_service) | **GET** /api/v1/instance/services/{id} | Retrieve details of a specific service
[**search_services**](ServicesApi.md#search_services) | **GET** /api/v1/instance/services/search | Search for a service (e.g. Worker, Executor, etc)


# **get_active_services**
> InstanceControllerApiActiveServiceList get_active_services()

List all active services

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.instance_controller_api_active_service_list import InstanceControllerApiActiveServiceList
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
    api_instance = kestra_api_client.ServicesApi(api_client)

    try:
        # List all active services
        api_response = api_instance.get_active_services()
        print("The response of ServicesApi->get_active_services:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServicesApi->get_active_services: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**InstanceControllerApiActiveServiceList**](InstanceControllerApiActiveServiceList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getActiveServices 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_service**
> ServiceInstance get_service(id)

Retrieve details of a specific service

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.service_instance import ServiceInstance
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
    api_instance = kestra_api_client.ServicesApi(api_client)
    id = 'id_example' # str | 

    try:
        # Retrieve details of a specific service
        api_response = api_instance.get_service(id)
        print("The response of ServicesApi->get_service:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServicesApi->get_service: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 

### Return type

[**ServiceInstance**](ServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getService 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_services**
> PagedResultsInstanceControllerApiServiceInstance search_services(page, size, sort=sort, state=state, type=type)

Search for a service (e.g. Worker, Executor, etc)

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.paged_results_instance_controller_api_service_instance import PagedResultsInstanceControllerApiServiceInstance
from kestra_api_client.models.service_service_state import ServiceServiceState
from kestra_api_client.models.service_type import ServiceType
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
    api_instance = kestra_api_client.ServicesApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    state = [kestra_api_client.ServiceServiceState()] # List[ServiceServiceState] | The state filter (optional)
    type = [kestra_api_client.ServiceType()] # List[ServiceType] | The server type filter (optional)

    try:
        # Search for a service (e.g. Worker, Executor, etc)
        api_response = api_instance.search_services(page, size, sort=sort, state=state, type=type)
        print("The response of ServicesApi->search_services:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServicesApi->search_services: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **state** | [**List[ServiceServiceState]**](ServiceServiceState.md)| The state filter | [optional] 
 **type** | [**List[ServiceType]**](ServiceType.md)| The server type filter | [optional] 

### Return type

[**PagedResultsInstanceControllerApiServiceInstance**](PagedResultsInstanceControllerApiServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchServices 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

