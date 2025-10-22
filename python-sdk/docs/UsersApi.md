# kestrapy.UsersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocomplete_users**](UsersApi.md#autocomplete_users) | **POST** /api/v1/{tenant}/tenant-access/autocomplete | List users for autocomplete
[**create_api_tokens_for_user**](UsersApi.md#create_api_tokens_for_user) | **POST** /api/v1/users/{id}/api-tokens | Create new API Token for a specific user
[**create_user**](UsersApi.md#create_user) | **POST** /api/v1/users | Create a new user account
[**delete_api_token_for_user**](UsersApi.md#delete_api_token_for_user) | **DELETE** /api/v1/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**delete_refresh_token**](UsersApi.md#delete_refresh_token) | **DELETE** /api/v1/users/{id}/refresh-token | Delete a user refresh token
[**delete_user**](UsersApi.md#delete_user) | **DELETE** /api/v1/users/{id} | Delete a user
[**delete_user_auth_method**](UsersApi.md#delete_user_auth_method) | **DELETE** /api/v1/users/{id}/auths/{auth} | Update user password
[**get_user**](UsersApi.md#get_user) | **GET** /api/v1/users/{id} | Get a user
[**impersonate**](UsersApi.md#impersonate) | **POST** /api/v1/users/{id}/impersonate | Impersonate a user
[**list_api_tokens_for_user**](UsersApi.md#list_api_tokens_for_user) | **GET** /api/v1/users/{id}/api-tokens | List API tokens for a specific user
[**list_users**](UsersApi.md#list_users) | **GET** /api/v1/users | Retrieve users
[**patch_user**](UsersApi.md#patch_user) | **PATCH** /api/v1/users/{id} | Update user details
[**patch_user_demo**](UsersApi.md#patch_user_demo) | **PATCH** /api/v1/users/{id}/restricted | Update user demo
[**patch_user_password**](UsersApi.md#patch_user_password) | **PATCH** /api/v1/users/{id}/password | Update user password
[**patch_user_super_admin**](UsersApi.md#patch_user_super_admin) | **PATCH** /api/v1/users/{id}/superadmin | Update user superadmin privileges
[**update_current_user_password**](UsersApi.md#update_current_user_password) | **PUT** /api/v1/me/password | Update authenticated user password
[**update_user**](UsersApi.md#update_user) | **PUT** /api/v1/users/{id} | Update a user account
[**update_user_groups**](UsersApi.md#update_user_groups) | **PUT** /api/v1/{tenant}/users/{id}/groups | Update the list of groups a user belongs to for the given tenant


# **autocomplete_users**
> List[IAMTenantAccessControllerApiUserTenantAccess] autocomplete_users(tenant, iam_tenant_access_controller_user_api_autocomplete)

List users for autocomplete

### Example


```python
import kestrapy
from kestrapy.models.iam_tenant_access_controller_api_user_tenant_access import IAMTenantAccessControllerApiUserTenantAccess
from kestrapy.models.iam_tenant_access_controller_user_api_autocomplete import IAMTenantAccessControllerUserApiAutocomplete
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    tenant = 'tenant_example' # str | 
    iam_tenant_access_controller_user_api_autocomplete = kestrapy.IAMTenantAccessControllerUserApiAutocomplete() # IAMTenantAccessControllerUserApiAutocomplete | Autocomplete request

    try:
        # List users for autocomplete
        api_response = api_client.autocomplete_users(tenant, iam_tenant_access_controller_user_api_autocomplete)
        print("The response of UsersApi->autocomplete_users:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->autocomplete_users: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **iam_tenant_access_controller_user_api_autocomplete** | [**IAMTenantAccessControllerUserApiAutocomplete**](IAMTenantAccessControllerUserApiAutocomplete.md)| Autocomplete request | 

### Return type

[**List[IAMTenantAccessControllerApiUserTenantAccess]**](IAMTenantAccessControllerApiUserTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | autocompleteUsers 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_api_tokens_for_user**
> CreateApiTokenResponse create_api_tokens_for_user(id, create_api_token_request)

Create new API Token for a specific user

Superadmin-only. Create a new API token for a user.

### Example


```python
import kestrapy
from kestrapy.models.create_api_token_request import CreateApiTokenRequest
from kestrapy.models.create_api_token_response import CreateApiTokenResponse
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    create_api_token_request = kestrapy.CreateApiTokenRequest() # CreateApiTokenRequest | The create api-token request

    try:
        # Create new API Token for a specific user
        api_response = api_client.create_api_tokens_for_user(id, create_api_token_request)
        print("The response of UsersApi->create_api_tokens_for_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->create_api_tokens_for_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **create_api_token_request** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | 

### Return type

[**CreateApiTokenResponse**](CreateApiTokenResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | API token successfully created |  -  |
**404** | User not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_user**
> IAMUserControllerApiUser create_user(iam_user_controller_api_create_or_update_user_request)

Create a new user account

Superadmin-only. Create a new user account with an optional password based authentication method.

### Example


```python
import kestrapy
from kestrapy.models.iam_user_controller_api_create_or_update_user_request import IAMUserControllerApiCreateOrUpdateUserRequest
from kestrapy.models.iam_user_controller_api_user import IAMUserControllerApiUser
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    iam_user_controller_api_create_or_update_user_request = kestrapy.IAMUserControllerApiCreateOrUpdateUserRequest() # IAMUserControllerApiCreateOrUpdateUserRequest | 

    try:
        # Create a new user account
        api_response = api_client.create_user(iam_user_controller_api_create_or_update_user_request)
        print("The response of UsersApi->create_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->create_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **iam_user_controller_api_create_or_update_user_request** | [**IAMUserControllerApiCreateOrUpdateUserRequest**](IAMUserControllerApiCreateOrUpdateUserRequest.md)|  | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | User was successfully created |  -  |
**404** | Tenant, or group not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_api_token_for_user**
> delete_api_token_for_user(id, token_id)

Delete an API Token for specific user and token id

Superadmin-only. Delete an API token for a user.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    token_id = 'token_id_example' # str | The token id

    try:
        # Delete an API Token for specific user and token id
        api_client.delete_api_token_for_user(id, token_id)
    except Exception as e:
        print("Exception when calling UsersApi->delete_api_token_for_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **token_id** | **str**| The token id | 

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
**204** | API token successfully deleted |  -  |
**404** | User, or API Token not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_refresh_token**
> delete_refresh_token(id)

Delete a user refresh token

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id

    try:
        # Delete a user refresh token
        api_client.delete_refresh_token(id)
    except Exception as e:
        print("Exception when calling UsersApi->delete_refresh_token: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 

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
**204** | Refresh token successfully deleted |  -  |
**404** | User not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_user**
> delete_user(id)

Delete a user

Superadmin-only. Delete a user including all its access.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id

    try:
        # Delete a user
        api_client.delete_user(id)
    except Exception as e:
        print("Exception when calling UsersApi->delete_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 

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
**204** | User successfully deleted |  -  |
**404** | User not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_user_auth_method**
> IAMUserControllerApiUser delete_user_auth_method(id, auth)

Update user password

Superadmin-only. Updates whether a user is a superadmin.

### Example


```python
import kestrapy
from kestrapy.models.iam_user_controller_api_user import IAMUserControllerApiUser
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    auth = 'auth_example' # str | The user auth method id

    try:
        # Update user password
        api_response = api_client.delete_user_auth_method(id, auth)
        print("The response of UsersApi->delete_user_auth_method:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->delete_user_auth_method: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **auth** | **str**| The user auth method id | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | User auth method successfully updated |  -  |
**404** | User or auth method not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_user**
> IAMUserControllerApiUser get_user(id)

Get a user

Superadmin-only. Get user account details.

### Example


```python
import kestrapy
from kestrapy.models.iam_user_controller_api_user import IAMUserControllerApiUser
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id

    try:
        # Get a user
        api_response = api_client.get_user(id)
        print("The response of UsersApi->get_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->get_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | User not found |  -  |
**200** | getUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **impersonate**
> object impersonate(id)

Impersonate a user

Superadmin-only. Allows an admin to impersonate another user.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id

    try:
        # Impersonate a user
        api_response = api_client.impersonate(id)
        print("The response of UsersApi->impersonate:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->impersonate: %s\n" % e)
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
**404** | User not found |  -  |
**200** | impersonate 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_api_tokens_for_user**
> object list_api_tokens_for_user(id)

List API tokens for a specific user

Superadmin-only. Get all API token existing for a user.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id

    try:
        # List API tokens for a specific user
        api_response = api_client.list_api_tokens_for_user(id)
        print("The response of UsersApi->list_api_tokens_for_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->list_api_tokens_for_user: %s\n" % e)
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
**404** | User not found |  -  |
**200** | listApiTokensForUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_users**
> PagedResultsIAMUserControllerApiUserSummary list_users(page, size, q=q, sort=sort)

Retrieve users

### Example


```python
import kestrapy
from kestrapy.models.paged_results_iam_user_controller_api_user_summary import PagedResultsIAMUserControllerApiUserSummary
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
        # Retrieve users
        api_response = api_client.list_users(page, size, q=q, sort=sort)
        print("The response of UsersApi->list_users:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->list_users: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsIAMUserControllerApiUserSummary**](PagedResultsIAMUserControllerApiUserSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listUsers 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_user**
> IAMUserControllerApiUser patch_user(id, me_controller_api_user_details_request)

Update user details

Superadmin-only. Updates the the details of a user.

### Example


```python
import kestrapy
from kestrapy.models.iam_user_controller_api_user import IAMUserControllerApiUser
from kestrapy.models.me_controller_api_user_details_request import MeControllerApiUserDetailsRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    me_controller_api_user_details_request = kestrapy.MeControllerApiUserDetailsRequest() # MeControllerApiUserDetailsRequest | The user details

    try:
        # Update user details
        api_response = api_client.patch_user(id, me_controller_api_user_details_request)
        print("The response of UsersApi->patch_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->patch_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **me_controller_api_user_details_request** | [**MeControllerApiUserDetailsRequest**](MeControllerApiUserDetailsRequest.md)| The user details | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | patchUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_user_demo**
> patch_user_demo(id, iam_user_controller_api_patch_restricted_request)

Update user demo

Superadmin-only. Updates whether a user is for demo.

### Example


```python
import kestrapy
from kestrapy.models.iam_user_controller_api_patch_restricted_request import IAMUserControllerApiPatchRestrictedRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    iam_user_controller_api_patch_restricted_request = kestrapy.IAMUserControllerApiPatchRestrictedRequest() # IAMUserControllerApiPatchRestrictedRequest | 

    try:
        # Update user demo
        api_client.patch_user_demo(id, iam_user_controller_api_patch_restricted_request)
    except Exception as e:
        print("Exception when calling UsersApi->patch_user_demo: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **iam_user_controller_api_patch_restricted_request** | [**IAMUserControllerApiPatchRestrictedRequest**](IAMUserControllerApiPatchRestrictedRequest.md)|  | 

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
**200** | User successfully updated |  -  |
**404** | User not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_user_password**
> IAMUserControllerApiUser patch_user_password(id, iam_user_controller_api_patch_user_password_request)

Update user password

Superadmin-only. Updates whether a user is a superadmin.

### Example


```python
import kestrapy
from kestrapy.models.iam_user_controller_api_patch_user_password_request import IAMUserControllerApiPatchUserPasswordRequest
from kestrapy.models.iam_user_controller_api_user import IAMUserControllerApiUser
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    iam_user_controller_api_patch_user_password_request = kestrapy.IAMUserControllerApiPatchUserPasswordRequest() # IAMUserControllerApiPatchUserPasswordRequest | 

    try:
        # Update user password
        api_response = api_client.patch_user_password(id, iam_user_controller_api_patch_user_password_request)
        print("The response of UsersApi->patch_user_password:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->patch_user_password: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **iam_user_controller_api_patch_user_password_request** | [**IAMUserControllerApiPatchUserPasswordRequest**](IAMUserControllerApiPatchUserPasswordRequest.md)|  | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | User successfully updated |  -  |
**404** | User not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_user_super_admin**
> patch_user_super_admin(id, api_patch_super_admin_request)

Update user superadmin privileges

Superadmin-only. Updates whether a user is a superadmin.

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
        # Update user superadmin privileges
        api_client.patch_user_super_admin(id, api_patch_super_admin_request)
    except Exception as e:
        print("Exception when calling UsersApi->patch_user_super_admin: %s\n" % e)
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
**200** | User successfully updated |  -  |
**404** | User not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_current_user_password**
> object update_current_user_password(me_controller_api_update_password_request)

Update authenticated user password

Changes the login password for the authenticated user.

### Example


```python
import kestrapy
from kestrapy.models.me_controller_api_update_password_request import MeControllerApiUpdatePasswordRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    me_controller_api_update_password_request = kestrapy.MeControllerApiUpdatePasswordRequest() # MeControllerApiUpdatePasswordRequest | 

    try:
        # Update authenticated user password
        api_response = api_client.update_current_user_password(me_controller_api_update_password_request)
        print("The response of UsersApi->update_current_user_password:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->update_current_user_password: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **me_controller_api_update_password_request** | [**MeControllerApiUpdatePasswordRequest**](MeControllerApiUpdatePasswordRequest.md)|  | 

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
**200** | updateCurrentUserPassword 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_user**
> IAMUserControllerApiUser update_user(id, iam_user_controller_api_create_or_update_user_request)

Update a user account

Superadmin-only. Update an existing user account with an optional password based authentication method.

### Example


```python
import kestrapy
from kestrapy.models.iam_user_controller_api_create_or_update_user_request import IAMUserControllerApiCreateOrUpdateUserRequest
from kestrapy.models.iam_user_controller_api_user import IAMUserControllerApiUser
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user id
    iam_user_controller_api_create_or_update_user_request = kestrapy.IAMUserControllerApiCreateOrUpdateUserRequest() # IAMUserControllerApiCreateOrUpdateUserRequest | 

    try:
        # Update a user account
        api_response = api_client.update_user(id, iam_user_controller_api_create_or_update_user_request)
        print("The response of UsersApi->update_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling UsersApi->update_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user id | 
 **iam_user_controller_api_create_or_update_user_request** | [**IAMUserControllerApiCreateOrUpdateUserRequest**](IAMUserControllerApiCreateOrUpdateUserRequest.md)|  | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Tenant, or group not found |  -  |
**200** | updateUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_user_groups**
> update_user_groups(id, tenant, iam_user_group_controller_api_update_user_groups_request)

Update the list of groups a user belongs to for the given tenant

### Example


```python
import kestrapy
from kestrapy.models.iam_user_group_controller_api_update_user_groups_request import IAMUserGroupControllerApiUpdateUserGroupsRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    id = 'id_example' # str | The user ID
    tenant = 'tenant_example' # str | 
    iam_user_group_controller_api_update_user_groups_request = kestrapy.IAMUserGroupControllerApiUpdateUserGroupsRequest() # IAMUserGroupControllerApiUpdateUserGroupsRequest | 

    try:
        # Update the list of groups a user belongs to for the given tenant
        api_client.update_user_groups(id, tenant, iam_user_group_controller_api_update_user_groups_request)
    except Exception as e:
        print("Exception when calling UsersApi->update_user_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user ID | 
 **tenant** | **str**|  | 
 **iam_user_group_controller_api_update_user_groups_request** | [**IAMUserGroupControllerApiUpdateUserGroupsRequest**](IAMUserGroupControllerApiUpdateUserGroupsRequest.md)|  | 

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
**204** | User&#39;s groups successfully updated |  -  |
**404** | User or one of the groups not found |  -  |
**400** | Invalid request payload |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

