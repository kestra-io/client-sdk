# kestrapy.DefaultApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accept_invitation**](DefaultApi.md#accept_invitation) | **POST** /api/v1/invitation/accept/{invitationId} | 
[**create_from_invitation**](DefaultApi.md#create_from_invitation) | **POST** /api/v1/invitation/create/{invitationId} | 
[**forgotten_password**](DefaultApi.md#forgotten_password) | **GET** /api/v1/forgotten-password | Sends an email to reset a password.
[**generate**](DefaultApi.md#generate) | **GET** /api/v1/{tenant}/stats/generate-reports | 
[**login**](DefaultApi.md#login) | **POST** /login | 
[**reset_password**](DefaultApi.md#reset_password) | **POST** /api/v1/reset-password | Change a password for given token.


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
    api_instance = kestrapy.DefaultApi(api_client)
    invitation_id = 'invitation_id_example' # str | 

    try:
        api_response = api_instance.accept_invitation(invitation_id)
        print("The response of DefaultApi->accept_invitation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DefaultApi->accept_invitation: %s\n" % e)
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
    api_instance = kestrapy.DefaultApi(api_client)
    invitation_id = 'invitation_id_example' # str | 
    auth_controller_invitation_user_request = kestrapy.AuthControllerInvitationUserRequest() # AuthControllerInvitationUserRequest | The basic information to create an account from an invitation

    try:
        api_response = api_instance.create_from_invitation(invitation_id, auth_controller_invitation_user_request)
        print("The response of DefaultApi->create_from_invitation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DefaultApi->create_from_invitation: %s\n" % e)
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
    api_instance = kestrapy.DefaultApi(api_client)
    username = 'username_example' # str | User that has forgotten his password

    try:
        # Sends an email to reset a password.
        api_response = api_instance.forgotten_password(username)
        print("The response of DefaultApi->forgotten_password:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DefaultApi->forgotten_password: %s\n" % e)
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

# **generate**
> bytearray generate(tenant, var_from=var_from)

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
    api_instance = kestrapy.DefaultApi(api_client)
    tenant = 'tenant_example' # str | 
    var_from = '2013-10-20' # date | The start date (optional)

    try:
        api_response = api_instance.generate(tenant, var_from=var_from)
        print("The response of DefaultApi->generate:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DefaultApi->generate: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **var_from** | **date**| The start date | [optional] 

### Return type

**bytearray**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | generate 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **login**
> object login(username, password, identity=identity, secret=secret)

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
    api_instance = kestrapy.DefaultApi(api_client)
    username = 'username_example' # str | 
    password = 'password_example' # str | 
    identity = 'identity_example' # str |  (optional)
    secret = 'secret_example' # str |  (optional)

    try:
        api_response = api_instance.login(username, password, identity=identity, secret=secret)
        print("The response of DefaultApi->login:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DefaultApi->login: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **str**|  | 
 **password** | **str**|  | 
 **identity** | **str**|  | [optional] 
 **secret** | **str**|  | [optional] 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | login 200 response |  -  |

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
    api_instance = kestrapy.DefaultApi(api_client)
    auth_controller_reset_password_request = kestrapy.AuthControllerResetPasswordRequest() # AuthControllerResetPasswordRequest | The password

    try:
        # Change a password for given token.
        api_response = api_instance.reset_password(auth_controller_reset_password_request)
        print("The response of DefaultApi->reset_password:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DefaultApi->reset_password: %s\n" % e)
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

