# kestrapy.AuthsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_api_token_for_current_user**](AuthsApi.md#create_api_token_for_current_user) | **POST** /api/v1/me/api-tokens | Create API token for the authenticated user
[**delete_api_token_for_current_user**](AuthsApi.md#delete_api_token_for_current_user) | **DELETE** /api/v1/me/api-tokens/{tokenId} | Delete API token for the authenticated user
[**get_current_user**](AuthsApi.md#get_current_user) | **GET** /api/v1/me | Get details about the authenticated user
[**index**](AuthsApi.md#index) | **GET** /api/v1/auths | Retrieve list of authentication methods
[**list_api_tokens_for_current_user**](AuthsApi.md#list_api_tokens_for_current_user) | **GET** /api/v1/me/api-tokens | List API tokens for authenticated user
[**patch_current_user**](AuthsApi.md#patch_current_user) | **PATCH** /api/v1/me | Update authenticated user details


# **create_api_token_for_current_user**
> object create_api_token_for_current_user(create_api_token_request)

Create API token for the authenticated user

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.create_api_token_request import CreateApiTokenRequest
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
    api_instance = kestrapy.AuthsApi(api_client)
    create_api_token_request = kestrapy.CreateApiTokenRequest() # CreateApiTokenRequest | 

    try:
        # Create API token for the authenticated user
        api_response = api_instance.create_api_token_for_current_user(create_api_token_request)
        print("The response of AuthsApi->create_api_token_for_current_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthsApi->create_api_token_for_current_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_api_token_request** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)|  | 

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
**200** | createApiTokenForCurrentUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_api_token_for_current_user**
> object delete_api_token_for_current_user(token_id)

Delete API token for the authenticated user

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
    api_instance = kestrapy.AuthsApi(api_client)
    token_id = 'token_id_example' # str | The token id

    try:
        # Delete API token for the authenticated user
        api_response = api_instance.delete_api_token_for_current_user(token_id)
        print("The response of AuthsApi->delete_api_token_for_current_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthsApi->delete_api_token_for_current_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**200** | deleteApiTokenForCurrentUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_current_user**
> MeControllerApiMe get_current_user()

Get details about the authenticated user

Requires the ME permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.me_controller_api_me import MeControllerApiMe
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
    api_instance = kestrapy.AuthsApi(api_client)

    try:
        # Get details about the authenticated user
        api_response = api_instance.get_current_user()
        print("The response of AuthsApi->get_current_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthsApi->get_current_user: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**MeControllerApiMe**](MeControllerApiMe.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getCurrentUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **index**
> AuthControllerAuth index()

Retrieve list of authentication methods

### Example


```python
import kestrapy
from kestrapy.models.auth_controller_auth import AuthControllerAuth
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
    api_instance = kestrapy.AuthsApi(api_client)

    try:
        # Retrieve list of authentication methods
        api_response = api_instance.index()
        print("The response of AuthsApi->index:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthsApi->index: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**AuthControllerAuth**](AuthControllerAuth.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | index 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_api_tokens_for_current_user**
> object list_api_tokens_for_current_user()

List API tokens for authenticated user

Returns all API tokens belonging to the authenticated user.

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
    api_instance = kestrapy.AuthsApi(api_client)

    try:
        # List API tokens for authenticated user
        api_response = api_instance.list_api_tokens_for_current_user()
        print("The response of AuthsApi->list_api_tokens_for_current_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthsApi->list_api_tokens_for_current_user: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

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
**200** | listApiTokensForCurrentUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_current_user**
> object patch_current_user(me_controller_api_user_details_request)

Update authenticated user details

Updates the authenticated user's profile information and returns the updated user.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.me_controller_api_user_details_request import MeControllerApiUserDetailsRequest
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
    api_instance = kestrapy.AuthsApi(api_client)
    me_controller_api_user_details_request = kestrapy.MeControllerApiUserDetailsRequest() # MeControllerApiUserDetailsRequest | The user details

    try:
        # Update authenticated user details
        api_response = api_instance.patch_current_user(me_controller_api_user_details_request)
        print("The response of AuthsApi->patch_current_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthsApi->patch_current_user: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **me_controller_api_user_details_request** | [**MeControllerApiUserDetailsRequest**](MeControllerApiUserDetailsRequest.md)| The user details | 

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
**200** | patchCurrentUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

