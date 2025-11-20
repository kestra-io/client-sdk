# kestrapy.ServiceAccountApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_api_tokens_for_service_account**](ServiceAccountApi.md#create_api_tokens_for_service_account) | **POST** /api/v1/service-accounts/{id}/api-tokens | Create new API Token for a specific service account
[**create_api_tokens_for_service_account_with_tenant**](ServiceAccountApi.md#create_api_tokens_for_service_account_with_tenant) | **POST** /api/v1/{tenant}/service-accounts/{id}/api-tokens | Create new API Token for a specific service account
[**create_service_account**](ServiceAccountApi.md#create_service_account) | **POST** /api/v1/service-accounts | Create a service account
[**create_service_account_for_tenant**](ServiceAccountApi.md#create_service_account_for_tenant) | **POST** /api/v1/{tenant}/service-accounts | Create a service account for the given tenant
[**delete_api_token_for_service_account**](ServiceAccountApi.md#delete_api_token_for_service_account) | **DELETE** /api/v1/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific service account and token id
[**delete_api_token_for_service_account_with_tenant**](ServiceAccountApi.md#delete_api_token_for_service_account_with_tenant) | **DELETE** /api/v1/{tenant}/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific service account and token id
[**delete_service_account**](ServiceAccountApi.md#delete_service_account) | **DELETE** /api/v1/service-accounts/{id} | Delete a service account
[**delete_service_account_for_tenant**](ServiceAccountApi.md#delete_service_account_for_tenant) | **DELETE** /api/v1/{tenant}/service-accounts/{id} | Delete a service account
[**list_api_tokens_for_service_account**](ServiceAccountApi.md#list_api_tokens_for_service_account) | **GET** /api/v1/service-accounts/{id}/api-tokens | List API tokens for a specific service account
[**list_api_tokens_for_service_account_with_tenant**](ServiceAccountApi.md#list_api_tokens_for_service_account_with_tenant) | **GET** /api/v1/{tenant}/service-accounts/{id}/api-tokens | List API tokens for a specific service account
[**list_service_accounts**](ServiceAccountApi.md#list_service_accounts) | **GET** /api/v1/service-accounts | List service accounts. Superadmin-only. 
[**patch_service_account_details**](ServiceAccountApi.md#patch_service_account_details) | **PATCH** /api/v1/service-accounts/{id} | Update service account details
[**patch_service_account_super_admin**](ServiceAccountApi.md#patch_service_account_super_admin) | **PATCH** /api/v1/service-accounts/{id}/superadmin | Update service account superadmin privileges
[**service_account**](ServiceAccountApi.md#service_account) | **GET** /api/v1/service-accounts/{id} | Get a service account
[**service_account_for_tenant**](ServiceAccountApi.md#service_account_for_tenant) | **GET** /api/v1/{tenant}/service-accounts/{id} | Retrieve a service account
[**update_service_account**](ServiceAccountApi.md#update_service_account) | **PUT** /api/v1/{tenant}/service-accounts/{id} | Update a user service account


# **create_api_tokens_for_service_account**
> object create_api_tokens_for_service_account(id, create_api_token_request)

Create new API Token for a specific service account

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
    id = 'id_example' # str | The user id
    create_api_token_request = kestrapy.CreateApiTokenRequest() # CreateApiTokenRequest | The create api-token request

    try:
        # Create new API Token for a specific service account
        api_response = kestra_client.ServiceAccountApi.create_api_tokens_for_service_account(id, create_api_token_request)
        print("The response of ServiceAccountApi->create_api_tokens_for_service_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->create_api_tokens_for_service_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **create_api_token_request** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | 

### Return type

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createApiTokensForServiceAccount 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_api_tokens_for_service_account_with_tenant**
> object create_api_tokens_for_service_account_with_tenant(id, tenant, create_api_token_request)

Create new API Token for a specific service account

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
    id = 'id_example' # str | The user id
    tenant = 'tenant_example' # str | 
    create_api_token_request = kestrapy.CreateApiTokenRequest() # CreateApiTokenRequest | The create api-token request

    try:
        # Create new API Token for a specific service account
        api_response = kestra_client.ServiceAccountApi.create_api_tokens_for_service_account_with_tenant(id, tenant, create_api_token_request)
        print("The response of ServiceAccountApi->create_api_tokens_for_service_account_with_tenant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->create_api_tokens_for_service_account_with_tenant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **tenant** | **str**|  | 
 **create_api_token_request** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | 

### Return type

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createApiTokensForServiceAccountWithTenant 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_service_account**
> IAMServiceAccountControllerApiServiceAccountDetail create_service_account(iam_service_account_controller_api_create_service_account_request)

Create a service account

Superadmin-only. CReate service account with access to multiple tenants.

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
    iam_service_account_controller_api_create_service_account_request = kestrapy.IAMServiceAccountControllerApiCreateServiceAccountRequest() # IAMServiceAccountControllerApiCreateServiceAccountRequest | The service account

    try:
        # Create a service account
        api_response = kestra_client.ServiceAccountApi.create_service_account(iam_service_account_controller_api_create_service_account_request)
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
    iam_service_account_controller_api_service_account_request = kestrapy.IAMServiceAccountControllerApiServiceAccountRequest() # IAMServiceAccountControllerApiServiceAccountRequest | The service account

    try:
        # Create a service account for the given tenant
        api_response = kestra_client.ServiceAccountApi.create_service_account_for_tenant(tenant, iam_service_account_controller_api_service_account_request)
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

# **delete_api_token_for_service_account**
> object delete_api_token_for_service_account(id, token_id)

Delete an API Token for specific service account and token id

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
    id = 'id_example' # str | The user id
    token_id = 'token_id_example' # str | The token id

    try:
        # Delete an API Token for specific service account and token id
        api_response = kestra_client.ServiceAccountApi.delete_api_token_for_service_account(id, token_id)
        print("The response of ServiceAccountApi->delete_api_token_for_service_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->delete_api_token_for_service_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **token_id** | **str**| The token id | 

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
**200** | deleteApiTokenForServiceAccount 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_api_token_for_service_account_with_tenant**
> object delete_api_token_for_service_account_with_tenant(id, token_id, tenant)

Delete an API Token for specific service account and token id

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
    id = 'id_example' # str | The user id
    token_id = 'token_id_example' # str | The token id
    tenant = 'tenant_example' # str | 

    try:
        # Delete an API Token for specific service account and token id
        api_response = kestra_client.ServiceAccountApi.delete_api_token_for_service_account_with_tenant(id, token_id, tenant)
        print("The response of ServiceAccountApi->delete_api_token_for_service_account_with_tenant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->delete_api_token_for_service_account_with_tenant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **token_id** | **str**| The token id | 
 **tenant** | **str**|  | 

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
**200** | deleteApiTokenForServiceAccountWithTenant 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_service_account**
> delete_service_account(id)

Delete a service account

Superadmin-only. Delete a service account including all its access.

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
    id = 'id_example' # str | The service account id

    try:
        # Delete a service account
        kestra_client.ServiceAccountApi.delete_service_account(id)
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
    id = 'id_example' # str | The service account id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a service account
        kestra_client.ServiceAccountApi.delete_service_account_for_tenant(id, tenant)
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
**200** | deleteServiceAccountForTenant 200 response |  -  |
**404** | Service account |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_api_tokens_for_service_account**
> object list_api_tokens_for_service_account(id)

List API tokens for a specific service account

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
    id = 'id_example' # str | The user id

    try:
        # List API tokens for a specific service account
        api_response = kestra_client.ServiceAccountApi.list_api_tokens_for_service_account(id)
        print("The response of ServiceAccountApi->list_api_tokens_for_service_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->list_api_tokens_for_service_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 

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
**200** | listApiTokensForServiceAccount 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_api_tokens_for_service_account_with_tenant**
> object list_api_tokens_for_service_account_with_tenant(id, tenant)

List API tokens for a specific service account

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
    id = 'id_example' # str | The user id
    tenant = 'tenant_example' # str | 

    try:
        # List API tokens for a specific service account
        api_response = kestra_client.ServiceAccountApi.list_api_tokens_for_service_account_with_tenant(id, tenant)
        print("The response of ServiceAccountApi->list_api_tokens_for_service_account_with_tenant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->list_api_tokens_for_service_account_with_tenant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **tenant** | **str**|  | 

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
**200** | listApiTokensForServiceAccountWithTenant 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_service_accounts**
> PagedResultsIAMServiceAccountControllerApiServiceAccountDetail list_service_accounts(page, size, q=q, sort=sort)

List service accounts. Superadmin-only. 

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
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # List service accounts. Superadmin-only. 
        api_response = kestra_client.ServiceAccountApi.list_service_accounts(page, size, q=q, sort=sort)
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
    id = 'id_example' # str | The service account id
    iam_service_account_controller_api_patch_service_account_request = kestrapy.IAMServiceAccountControllerApiPatchServiceAccountRequest() # IAMServiceAccountControllerApiPatchServiceAccountRequest | The service account details

    try:
        # Update service account details
        api_response = kestra_client.ServiceAccountApi.patch_service_account_details(id, iam_service_account_controller_api_patch_service_account_request)
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
    id = 'id_example' # str | The user id
    api_patch_super_admin_request = kestrapy.ApiPatchSuperAdminRequest() # ApiPatchSuperAdminRequest | 

    try:
        # Update service account superadmin privileges
        kestra_client.ServiceAccountApi.patch_service_account_super_admin(id, api_patch_super_admin_request)
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

# **service_account**
> IAMServiceAccountControllerApiServiceAccountDetail service_account(id)

Get a service account

Superadmin-only. Get user account details.

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
    id = 'id_example' # str | The service account id

    try:
        # Get a service account
        api_response = kestra_client.ServiceAccountApi.service_account(id)
        print("The response of ServiceAccountApi->service_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->service_account: %s\n" % e)
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
**200** | getServiceAccount 200 response |  -  |
**404** | User not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **service_account_for_tenant**
> IAMServiceAccountControllerApiServiceAccountResponse service_account_for_tenant(id, tenant)

Retrieve a service account

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
    id = 'id_example' # str | The user id
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a service account
        api_response = kestra_client.ServiceAccountApi.service_account_for_tenant(id, tenant)
        print("The response of ServiceAccountApi->service_account_for_tenant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServiceAccountApi->service_account_for_tenant: %s\n" % e)
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
**200** | getServiceAccountForTenant 200 response |  -  |
**404** | Service account not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_service_account**
> IAMServiceAccountControllerApiServiceAccountResponse update_service_account(id, tenant, iam_service_account_controller_api_service_account_request)

Update a user service account

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
    id = 'id_example' # str | The user id
    tenant = 'tenant_example' # str | 
    iam_service_account_controller_api_service_account_request = kestrapy.IAMServiceAccountControllerApiServiceAccountRequest() # IAMServiceAccountControllerApiServiceAccountRequest | The user

    try:
        # Update a user service account
        api_response = kestra_client.ServiceAccountApi.update_service_account(id, tenant, iam_service_account_controller_api_service_account_request)
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
**200** | updateServiceAccount 200 response |  -  |
**404** | Service account, or group not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

