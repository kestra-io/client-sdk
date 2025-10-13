# kestrapy.AuthApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accept_invitation**](AuthApi.md#accept_invitation) | **POST** /api/v1/invitation/accept/{invitationId} | 
[**create_from_invitation**](AuthApi.md#create_from_invitation) | **POST** /api/v1/invitation/create/{invitationId} | 
[**forgotten_password**](AuthApi.md#forgotten_password) | **GET** /api/v1/forgotten-password | Sends an email to reset a password.
[**index**](AuthApi.md#index) | **GET** /api/v1/auths | Retrieve list of authentication methods
[**request_code**](AuthApi.md#request_code) | **GET** /api/v1/request-code/{email} | Request an authentication code for login verification
[**reset_password**](AuthApi.md#reset_password) | **POST** /api/v1/reset-password | Change a password for given token.


# **accept_invitation**
> object accept_invitation(invitation_id)

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
    api_instance = kestrapy.AuthApi(api_client)
    invitation_id = 'invitation_id_example' # str | 

    try:
        api_response = api_instance.accept_invitation(invitation_id)
        print("The response of AuthApi->accept_invitation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthApi->accept_invitation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invitation_id** | **str**|  | 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | acceptInvitation 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_from_invitation**
> object create_from_invitation(invitation_id, auth_controller_invitation_user_request)

### Example


```python
import kestrapy
from kestrapy.models.auth_controller_invitation_user_request import AuthControllerInvitationUserRequest
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
    api_instance = kestrapy.AuthApi(api_client)
    invitation_id = 'invitation_id_example' # str | 
    auth_controller_invitation_user_request = kestrapy.AuthControllerInvitationUserRequest() # AuthControllerInvitationUserRequest | The basic information to create an account from an invitation

    try:
        api_response = api_instance.create_from_invitation(invitation_id, auth_controller_invitation_user_request)
        print("The response of AuthApi->create_from_invitation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthApi->create_from_invitation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invitation_id** | **str**|  | 
 **auth_controller_invitation_user_request** | [**AuthControllerInvitationUserRequest**](AuthControllerInvitationUserRequest.md)| The basic information to create an account from an invitation | 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createFromInvitation 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **forgotten_password**
> object forgotten_password(username)

Sends an email to reset a password.

Sends an email to reset a password. Note that whatever the username is found or not, the response will always be 200 to avoid leaking information.

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
    api_instance = kestrapy.AuthApi(api_client)
    username = 'username_example' # str | User that has forgotten his password

    try:
        # Sends an email to reset a password.
        api_response = api_instance.forgotten_password(username)
        print("The response of AuthApi->forgotten_password:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthApi->forgotten_password: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **str**| User that has forgotten his password | 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | forgottenPassword 200 response |  -  |

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
    api_instance = kestrapy.AuthApi(api_client)

    try:
        # Retrieve list of authentication methods
        api_response = api_instance.index()
        print("The response of AuthApi->index:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthApi->index: %s\n" % e)
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

# **request_code**
> object request_code(email)

Request an authentication code for login verification

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
    api_instance = kestrapy.AuthApi(api_client)
    email = 'email_example' # str | 

    try:
        # Request an authentication code for login verification
        api_response = api_instance.request_code(email)
        print("The response of AuthApi->request_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthApi->request_code: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **str**|  | 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | requestCode 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **reset_password**
> object reset_password(auth_controller_reset_password_request)

Change a password for given token.

Change a password for given token. If password does not match password policy, use can still retry.

### Example


```python
import kestrapy
from kestrapy.models.auth_controller_reset_password_request import AuthControllerResetPasswordRequest
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
    api_instance = kestrapy.AuthApi(api_client)
    auth_controller_reset_password_request = kestrapy.AuthControllerResetPasswordRequest() # AuthControllerResetPasswordRequest | The password

    try:
        # Change a password for given token.
        api_response = api_instance.reset_password(auth_controller_reset_password_request)
        print("The response of AuthApi->reset_password:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthApi->reset_password: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **auth_controller_reset_password_request** | [**AuthControllerResetPasswordRequest**](AuthControllerResetPasswordRequest.md)| The password | 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | resetPassword 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

