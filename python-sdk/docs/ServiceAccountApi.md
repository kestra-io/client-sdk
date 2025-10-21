# kestrapy.ServiceAccountApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_service_account**](ServiceAccountApi.md#create_service_account) | **POST** /api/v1/service-accounts | Create a service account
[**create_service_account_for_tenant**](ServiceAccountApi.md#create_service_account_for_tenant) | **POST** /api/v1/{tenant}/service-accounts | Create a service account for the given tenant
[**delete_service_account**](ServiceAccountApi.md#delete_service_account) | **DELETE** /api/v1/service-accounts/{id} | Delete a service account
[**delete_service_account_for_tenant**](ServiceAccountApi.md#delete_service_account_for_tenant) | **DELETE** /api/v1/{tenant}/service-accounts/{id} | Delete a service account
[**get_service_account**](ServiceAccountApi.md#get_service_account) | **GET** /api/v1/service-accounts/{id} | Get a service account
[**get_service_account_for_tenant**](ServiceAccountApi.md#get_service_account_for_tenant) | **GET** /api/v1/{tenant}/service-accounts/{id} | Retrieve a service account
[**list_service_accounts**](ServiceAccountApi.md#list_service_accounts) | **GET** /api/v1/service-accounts | List service accounts. Superadmin-only. 
[**patch_service_account_details**](ServiceAccountApi.md#patch_service_account_details) | **PATCH** /api/v1/service-accounts/{id} | Update service account details
[**patch_service_account_super_admin**](ServiceAccountApi.md#patch_service_account_super_admin) | **PATCH** /api/v1/service-accounts/{id}/superadmin | Update service account superadmin privileges
[**update_service_account**](ServiceAccountApi.md#update_service_account) | **PUT** /api/v1/{tenant}/service-accounts/{id} | Update a user service account


# **create_service_account**
> IAMServiceAccountControllerApiServiceAccountDetail create_service_account(iam_service_account_controller_api_create_service_account_request)

Create a service account

Superadmin-only. CReate service account with access to multiple tenants.

### Example


```python
import kestrapy
from kestrapy.models.iam_service_account_controller_api_create_service_account_request import IAMServiceAccountControllerApiCreateServiceAccountRequest
from kestrapy.models.iam_service_account_controller_api_service_account_detail import IAMServiceAccountControllerApiServiceAccountDetail
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    iam_service_account_controller_api_create_service_account_request = kestrapy.IAMServiceAccountControllerApiCreateServiceAccountRequest() # IAMServiceAccountControllerApiCreateServiceAccountRequest | The service account

    try:
        # Create a service account
        api_response = api_client.create_service_account(iam_service_account_controller_api_create_service_account_request)
        print("The response of ServiceAccountApi->create_service_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->create_service_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **iam_service_account_controller_api_create_service_account_request** | [**IAMServiceAccountControllerApiCreateServiceAccountRequest**](IAMServiceAccountControllerApiCreateServiceAccountRequest.md)| The service account | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Service account successfully created |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_service_account_for_tenant**
> IAMServiceAccountControllerApiServiceAccountResponse create_service_account_for_tenant(tenant, iam_service_account_controller_api_service_account_request)

Create a service account for the given tenant

### Example


```python
import kestrapy
from kestrapy.models.iam_service_account_controller_api_service_account_request import IAMServiceAccountControllerApiServiceAccountRequest
from kestrapy.models.iam_service_account_controller_api_service_account_response import IAMServiceAccountControllerApiServiceAccountResponse
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    tenant = 'tenant_example' # str | 
    iam_service_account_controller_api_service_account_request = kestrapy.IAMServiceAccountControllerApiServiceAccountRequest() # IAMServiceAccountControllerApiServiceAccountRequest | The service account

    try:
        # Create a service account for the given tenant
        api_response = api_client.create_service_account_for_tenant(tenant, iam_service_account_controller_api_service_account_request)
        print("The response of ServiceAccountApi->create_service_account_for_tenant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->create_service_account_for_tenant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **iam_service_account_controller_api_service_account_request** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md)| The service account | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Service account successfully created |  -  |
**404** | Group not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_service_account**
> delete_service_account(id)

Delete a service account

Superadmin-only. Delete a service account including all its access.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The service account id

    try:
        # Delete a service account
        api_client.delete_service_account(id)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->delete_service_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The service account id | 

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
**204** | Service account successfully deleted |  -  |
**404** | Service account not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_service_account_for_tenant**
> delete_service_account_for_tenant(id, tenant)

Delete a service account

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The service account id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a service account
        api_client.delete_service_account_for_tenant(id, tenant)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->delete_service_account_for_tenant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The service account id | 
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
**404** | Service account |  -  |
**200** | deleteServiceAccountForTenant 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_service_account**
> IAMServiceAccountControllerApiServiceAccountDetail get_service_account(id)

Get a service account

Superadmin-only. Get user account details.

### Example


```python
import kestrapy
from kestrapy.models.iam_service_account_controller_api_service_account_detail import IAMServiceAccountControllerApiServiceAccountDetail
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The service account id

    try:
        # Get a service account
        api_response = api_client.get_service_account(id)
        print("The response of ServiceAccountApi->get_service_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->get_service_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The service account id | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | User not found |  -  |
**200** | getServiceAccount 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_service_account_for_tenant**
> IAMServiceAccountControllerApiServiceAccountResponse get_service_account_for_tenant(id, tenant)

Retrieve a service account

### Example


```python
import kestrapy
from kestrapy.models.iam_service_account_controller_api_service_account_response import IAMServiceAccountControllerApiServiceAccountResponse
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a service account
        api_response = api_client.get_service_account_for_tenant(id, tenant)
        print("The response of ServiceAccountApi->get_service_account_for_tenant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->get_service_account_for_tenant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **tenant** | **str**|  | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Service account not found |  -  |
**200** | getServiceAccountForTenant 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_service_accounts**
> PagedResultsIAMServiceAccountControllerApiServiceAccountDetail list_service_accounts(page, size, q=q, sort=sort)

List service accounts. Superadmin-only. 

### Example


```python
import kestrapy
from kestrapy.models.paged_results_iam_service_account_controller_api_service_account_detail import PagedResultsIAMServiceAccountControllerApiServiceAccountDetail
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # List service accounts. Superadmin-only. 
        api_response = api_client.list_service_accounts(page, size, q=q, sort=sort)
        print("The response of ServiceAccountApi->list_service_accounts:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->list_service_accounts: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsIAMServiceAccountControllerApiServiceAccountDetail**](PagedResultsIAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Service account successfully created |  -  |
**404** | Group not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_service_account_details**
> IAMServiceAccountControllerApiServiceAccountDetail patch_service_account_details(id, iam_service_account_controller_api_patch_service_account_request)

Update service account details

Superadmin-only. Updates the details of a service account.

### Example


```python
import kestrapy
from kestrapy.models.iam_service_account_controller_api_patch_service_account_request import IAMServiceAccountControllerApiPatchServiceAccountRequest
from kestrapy.models.iam_service_account_controller_api_service_account_detail import IAMServiceAccountControllerApiServiceAccountDetail
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The service account id
    iam_service_account_controller_api_patch_service_account_request = kestrapy.IAMServiceAccountControllerApiPatchServiceAccountRequest() # IAMServiceAccountControllerApiPatchServiceAccountRequest | The service account details

    try:
        # Update service account details
        api_response = api_client.patch_service_account_details(id, iam_service_account_controller_api_patch_service_account_request)
        print("The response of ServiceAccountApi->patch_service_account_details:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->patch_service_account_details: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The service account id | 
 **iam_service_account_controller_api_patch_service_account_request** | [**IAMServiceAccountControllerApiPatchServiceAccountRequest**](IAMServiceAccountControllerApiPatchServiceAccountRequest.md)| The service account details | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | patchServiceAccountDetails 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_service_account_super_admin**
> patch_service_account_super_admin(id, api_patch_super_admin_request)

Update service account superadmin privileges

Superadmin-only. Updates whether a service account is a superadmin.

### Example


```python
import kestrapy
from kestrapy.models.api_patch_super_admin_request import ApiPatchSuperAdminRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    api_patch_super_admin_request = kestrapy.ApiPatchSuperAdminRequest() # ApiPatchSuperAdminRequest | 

    try:
        # Update service account superadmin privileges
        api_client.patch_service_account_super_admin(id, api_patch_super_admin_request)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->patch_service_account_super_admin: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **api_patch_super_admin_request** | [**ApiPatchSuperAdminRequest**](ApiPatchSuperAdminRequest.md)|  | 

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
**200** | Service account successfully updated |  -  |
**404** | Service account not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_service_account**
> IAMServiceAccountControllerApiServiceAccountResponse update_service_account(id, tenant, iam_service_account_controller_api_service_account_request)

Update a user service account

### Example


```python
import kestrapy
from kestrapy.models.iam_service_account_controller_api_service_account_request import IAMServiceAccountControllerApiServiceAccountRequest
from kestrapy.models.iam_service_account_controller_api_service_account_response import IAMServiceAccountControllerApiServiceAccountResponse
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    tenant = 'tenant_example' # str | 
    iam_service_account_controller_api_service_account_request = kestrapy.IAMServiceAccountControllerApiServiceAccountRequest() # IAMServiceAccountControllerApiServiceAccountRequest | The user

    try:
        # Update a user service account
        api_response = api_client.update_service_account(id, tenant, iam_service_account_controller_api_service_account_request)
        print("The response of ServiceAccountApi->update_service_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->update_service_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **tenant** | **str**|  | 
 **iam_service_account_controller_api_service_account_request** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md)| The user | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Service account, or group not found |  -  |
**200** | updateServiceAccount 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

