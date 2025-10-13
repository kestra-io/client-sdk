# kestrapy.IAMInvitationApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_invitation**](IAMInvitationApi.md#create_invitation) | **POST** /api/v1/{tenant}/invitations | Create an invitation
[**delete_invitation**](IAMInvitationApi.md#delete_invitation) | **DELETE** /api/v1/{tenant}/invitations/{id} | Delete an invitation
[**get_invitation**](IAMInvitationApi.md#get_invitation) | **GET** /api/v1/{tenant}/invitations/{id} | Retrieve an invitation
[**list_invitations_by_email**](IAMInvitationApi.md#list_invitations_by_email) | **GET** /api/v1/{tenant}/invitations/email/{email} | Retrieve all invitations for a given email
[**search_invitations**](IAMInvitationApi.md#search_invitations) | **GET** /api/v1/{tenant}/invitations/search | Search for invitations


# **create_invitation**
> create_invitation(tenant, iam_invitation_controller_api_invitation_create_request)

Create an invitation

Creates a new invitation and sends an email if the mail server is enabled.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.iam_invitation_controller_api_invitation_create_request import IAMInvitationControllerApiInvitationCreateRequest
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
    api_instance = kestrapy.IAMInvitationApi(api_client)
    tenant = 'tenant_example' # str | 
    iam_invitation_controller_api_invitation_create_request = kestrapy.IAMInvitationControllerApiInvitationCreateRequest() # IAMInvitationControllerApiInvitationCreateRequest | Create a new invitation, send an email if the server-mail is enabled

    try:
        # Create an invitation
        api_instance.create_invitation(tenant, iam_invitation_controller_api_invitation_create_request)
    except Exception as e:
        print("Exception when calling IAMInvitationApi->create_invitation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **iam_invitation_controller_api_invitation_create_request** | [**IAMInvitationControllerApiInvitationCreateRequest**](IAMInvitationControllerApiInvitationCreateRequest.md)| Create a new invitation, send an email if the server-mail is enabled | 

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
**201** | Invitation successfully created |  -  |
**204** | Tenant access granted to the user |  -  |
**403** | Insufficient privileges to invite a Superadmin user |  -  |
**409** | Invitation already exists for the given email, or user already had access to the tenant |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_invitation**
> delete_invitation(id, tenant)

Delete an invitation

Deletes the invitation by its ID.

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
    api_instance = kestrapy.IAMInvitationApi(api_client)
    id = 'id_example' # str | The id of the invitation
    tenant = 'tenant_example' # str | 

    try:
        # Delete an invitation
        api_instance.delete_invitation(id, tenant)
    except Exception as e:
        print("Exception when calling IAMInvitationApi->delete_invitation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The id of the invitation | 
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
**204** | Invitation successfully deleted |  -  |
**404** | Invitation not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_invitation**
> IAMInvitationControllerApiInvitationDetail get_invitation(id, tenant)

Retrieve an invitation

Retrieves the invitation by its ID, including the invitation link.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.iam_invitation_controller_api_invitation_detail import IAMInvitationControllerApiInvitationDetail
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
    api_instance = kestrapy.IAMInvitationApi(api_client)
    id = 'id_example' # str | The id of the invitation
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve an invitation
        api_response = api_instance.get_invitation(id, tenant)
        print("The response of IAMInvitationApi->get_invitation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling IAMInvitationApi->get_invitation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The id of the invitation | 
 **tenant** | **str**|  | 

### Return type

[**IAMInvitationControllerApiInvitationDetail**](IAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Invitation not found |  -  |
**200** | getInvitation 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_invitations_by_email**
> List[IAMInvitationControllerApiInvitationDetail] list_invitations_by_email(email, tenant)

Retrieve all invitations for a given email

Returns all invitations created for a given email address in the current tenant.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.iam_invitation_controller_api_invitation_detail import IAMInvitationControllerApiInvitationDetail
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
    api_instance = kestrapy.IAMInvitationApi(api_client)
    email = 'email_example' # str | The email address of the invited
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve all invitations for a given email
        api_response = api_instance.list_invitations_by_email(email, tenant)
        print("The response of IAMInvitationApi->list_invitations_by_email:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling IAMInvitationApi->list_invitations_by_email: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **str**| The email address of the invited | 
 **tenant** | **str**|  | 

### Return type

[**List[IAMInvitationControllerApiInvitationDetail]**](IAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listInvitationsByEmail 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_invitations**
> PagedResultsIAMInvitationControllerApiInvitationDetail search_invitations(page, size, tenant, email=email, status=status, sort=sort)

Search for invitations

Search and filter invitations by email, status, and pagination.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_iam_invitation_controller_api_invitation_detail import PagedResultsIAMInvitationControllerApiInvitationDetail
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
    api_instance = kestrapy.IAMInvitationApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    email = 'email_example' # str | The email address of the invited (optional)
    status = kestrapy.InvitationInvitationStatus() # InvitationInvitationStatus | The current status of the invitations (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Search for invitations
        api_response = api_instance.search_invitations(page, size, tenant, email=email, status=status, sort=sort)
        print("The response of IAMInvitationApi->search_invitations:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling IAMInvitationApi->search_invitations: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **email** | **str**| The email address of the invited | [optional] 
 **status** | [**InvitationInvitationStatus**](.md)| The current status of the invitations | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsIAMInvitationControllerApiInvitationDetail**](PagedResultsIAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchInvitations 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

