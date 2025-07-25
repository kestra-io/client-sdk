# kestra_api_client.TenantsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](TenantsApi.md#create) | **POST** /api/v1/tenants | Create a tenant
[**delete**](TenantsApi.md#delete) | **DELETE** /api/v1/tenants/{id} | Delete a tenant and all its resources (flows, namespaces, apps, ...
[**find**](TenantsApi.md#find) | **GET** /api/v1/tenants/search | Search for tenants
[**get**](TenantsApi.md#get) | **GET** /api/v1/tenants/{id} | Get a tenant
[**set_logo**](TenantsApi.md#set_logo) | **POST** /api/v1/tenants/{id}/logo | Set a tenant logo
[**update**](TenantsApi.md#update) | **PUT** /api/v1/tenants/{id} | Update a tenant


# **create**
> Tenant create(tenant)

Create a tenant

### Example


```python
import kestra_api_client
from kestra_api_client.models.tenant import Tenant
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
    api_instance = kestra_api_client.TenantsApi(api_client)
    tenant = kestra_api_client.Tenant() # Tenant | 

    try:
        # Create a tenant
        api_response = api_instance.create(tenant)
        print("The response of TenantsApi->create:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TenantsApi->create: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | [**Tenant**](Tenant.md)|  | 

### Return type

[**Tenant**](Tenant.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | create 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete**
> delete(id)

Delete a tenant and all its resources (flows, namespaces, apps, ...

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
    api_instance = kestra_api_client.TenantsApi(api_client)
    id = 'id_example' # str | The tenant id

    try:
        # Delete a tenant and all its resources (flows, namespaces, apps, ...
        api_instance.delete(id)
    except Exception as e:
        print("Exception when calling TenantsApi->delete: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The tenant id | 

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
**204** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **find**
> PagedResultsTenant find(page, size, q=q, sort=sort)

Search for tenants

### Example


```python
import kestra_api_client
from kestra_api_client.models.paged_results_tenant import PagedResultsTenant
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
    api_instance = kestra_api_client.TenantsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Search for tenants
        api_response = api_instance.find(page, size, q=q, sort=sort)
        print("The response of TenantsApi->find:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TenantsApi->find: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsTenant**](PagedResultsTenant.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | find 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get**
> Tenant get(id)

Get a tenant

### Example


```python
import kestra_api_client
from kestra_api_client.models.tenant import Tenant
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
    api_instance = kestra_api_client.TenantsApi(api_client)
    id = 'id_example' # str | The tenant id

    try:
        # Get a tenant
        api_response = api_instance.get(id)
        print("The response of TenantsApi->get:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TenantsApi->get: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The tenant id | 

### Return type

[**Tenant**](Tenant.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | get 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_logo**
> ApiTenant set_logo(id, logo=logo)

Set a tenant logo

### Example


```python
import kestra_api_client
from kestra_api_client.models.api_tenant import ApiTenant
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
    api_instance = kestra_api_client.TenantsApi(api_client)
    id = 'id_example' # str | The tenant id
    logo = None # bytearray | The logo file (optional)

    try:
        # Set a tenant logo
        api_response = api_instance.set_logo(id, logo=logo)
        print("The response of TenantsApi->set_logo:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TenantsApi->set_logo: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The tenant id | 
 **logo** | **bytearray**| The logo file | [optional] 

### Return type

[**ApiTenant**](ApiTenant.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setLogo 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update**
> Tenant update(id, tenant)

Update a tenant

### Example


```python
import kestra_api_client
from kestra_api_client.models.tenant import Tenant
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
    api_instance = kestra_api_client.TenantsApi(api_client)
    id = 'id_example' # str | The tenant id
    tenant = kestra_api_client.Tenant() # Tenant | 

    try:
        # Update a tenant
        api_response = api_instance.update(id, tenant)
        print("The response of TenantsApi->update:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TenantsApi->update: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The tenant id | 
 **tenant** | [**Tenant**](Tenant.md)|  | 

### Return type

[**Tenant**](Tenant.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | update 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

