# kestrapy.TenantAccessApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_tenant_access**](TenantAccessApi.md#create_tenant_access) | **POST** /api/v1/{tenant}/tenant-access | Create tenant access for a user
[**create_tenant_access1**](TenantAccessApi.md#create_tenant_access1) | **PUT** /api/v1/{tenant}/tenant-access/{userId} | Create tenant access for a user
[**delete_tenant_access**](TenantAccessApi.md#delete_tenant_access) | **DELETE** /api/v1/{tenant}/tenant-access/{userId} | Delete tenant access for a user
[**get_tenant_access**](TenantAccessApi.md#get_tenant_access) | **GET** /api/v1/{tenant}/tenant-access/{userId} | Retrieve tenant access for a user
[**list_tenant_access**](TenantAccessApi.md#list_tenant_access) | **GET** /api/v1/{tenant}/tenant-access | Retrieve users belonging to the tenant


# **create_tenant_access**
> create_tenant_access(tenant, iam_tenant_access_controller_api_create_tenant_access_request)

Create tenant access for a user

Grants tenant access permissions to a user identified by email

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.iam_tenant_access_controller_api_create_tenant_access_request import IAMTenantAccessControllerApiCreateTenantAccessRequest
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
    api_instance = kestrapy.TenantAccessApi(api_client)
    tenant = 'tenant_example' # str | 
    iam_tenant_access_controller_api_create_tenant_access_request = kestrapy.IAMTenantAccessControllerApiCreateTenantAccessRequest() # IAMTenantAccessControllerApiCreateTenantAccessRequest | 

    try:
        # Create tenant access for a user
        api_instance.create_tenant_access(tenant, iam_tenant_access_controller_api_create_tenant_access_request)
    except Exception as e:
        print("Exception when calling TenantAccessApi->create_tenant_access: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **iam_tenant_access_controller_api_create_tenant_access_request** | [**IAMTenantAccessControllerApiCreateTenantAccessRequest**](IAMTenantAccessControllerApiCreateTenantAccessRequest.md)|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Access successfully created |  -  |
**404** | User not found |  -  |
**409** | User already has access to the tenant |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_tenant_access1**
> create_tenant_access1(user_id, tenant)

Create tenant access for a user

Grants tenant access permissions to a user identified by userId

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
    api_instance = kestrapy.TenantAccessApi(api_client)
    user_id = 'user_id_example' # str | The user id
    tenant = 'tenant_example' # str | 

    try:
        # Create tenant access for a user
        api_instance.create_tenant_access1(user_id, tenant)
    except Exception as e:
        print("Exception when calling TenantAccessApi->create_tenant_access1: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user_id** | **str**| The user id | 
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
**201** | Access successfully created |  -  |
**404** | User not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_tenant_access**
> delete_tenant_access(user_id, tenant)

Delete tenant access for a user

Removes tenant access permissions for the specified user

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
    api_instance = kestrapy.TenantAccessApi(api_client)
    user_id = 'user_id_example' # str | The user id
    tenant = 'tenant_example' # str | 

    try:
        # Delete tenant access for a user
        api_instance.delete_tenant_access(user_id, tenant)
    except Exception as e:
        print("Exception when calling TenantAccessApi->delete_tenant_access: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user_id** | **str**| The user id | 
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
**204** | Access successfully deleted |  -  |
**404** | User, or tenant access not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_tenant_access**
> IAMTenantAccessControllerApiTenantAccess get_tenant_access(user_id, tenant)

Retrieve tenant access for a user

Fetches the tenant access configuration for a given user

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.iam_tenant_access_controller_api_tenant_access import IAMTenantAccessControllerApiTenantAccess
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
    api_instance = kestrapy.TenantAccessApi(api_client)
    user_id = 'user_id_example' # str | The user id
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve tenant access for a user
        api_response = api_instance.get_tenant_access(user_id, tenant)
        print("The response of TenantAccessApi->get_tenant_access:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TenantAccessApi->get_tenant_access: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user_id** | **str**| The user id | 
 **tenant** | **str**|  | 

### Return type

[**IAMTenantAccessControllerApiTenantAccess**](IAMTenantAccessControllerApiTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Tenant access successfully retrieved |  -  |
**404** | User, or tenant access not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_tenant_access**
> PagedResultsIAMTenantAccessControllerApiUserTenantAccess list_tenant_access(page, size, tenant, q=q, sort=sort, type=type)

Retrieve users belonging to the tenant

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_iam_tenant_access_controller_api_user_tenant_access import PagedResultsIAMTenantAccessControllerApiUserTenantAccess
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
    api_instance = kestrapy.TenantAccessApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    type = kestrapy.UserType() # UserType | The type of user (optional)

    try:
        # Retrieve users belonging to the tenant
        api_response = api_instance.list_tenant_access(page, size, tenant, q=q, sort=sort, type=type)
        print("The response of TenantAccessApi->list_tenant_access:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TenantAccessApi->list_tenant_access: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **type** | [**UserType**](.md)| The type of user | [optional] 

### Return type

[**PagedResultsIAMTenantAccessControllerApiUserTenantAccess**](PagedResultsIAMTenantAccessControllerApiUserTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listTenantAccess 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

