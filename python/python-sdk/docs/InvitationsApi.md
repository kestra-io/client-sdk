# kestrapy.InvitationsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_invitation**](InvitationsApi.md#create_invitation) | **POST** /api/v1/{tenant}/invitations | Create an invitation
[**delete_invitation**](InvitationsApi.md#delete_invitation) | **DELETE** /api/v1/{tenant}/invitations/{id} | Delete an invitation
[**find_all_invitations_for_current_user**](InvitationsApi.md#find_all_invitations_for_current_user) | **GET** /api/v1/me/invitations | List invitations for the authenticated user
[**invitation**](InvitationsApi.md#invitation) | **GET** /api/v1/{tenant}/invitations/{id} | Retrieve an invitation
[**list_invitations_by_email**](InvitationsApi.md#list_invitations_by_email) | **GET** /api/v1/{tenant}/invitations/email/{email} | Retrieve all invitations for a given email
[**search_invitations**](InvitationsApi.md#search_invitations) | **GET** /api/v1/{tenant}/invitations/search | Search for invitations


# **create_invitation**
> create_invitation(tenant, iam_invitation_controller_api_invitation_create_request)

Create an invitation

Creates a new invitation and sends an email if the mail server is enabled.

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
    iam_invitation_controller_api_invitation_create_request = kestrapy.IAMInvitationControllerApiInvitationCreateRequest() # IAMInvitationControllerApiInvitationCreateRequest | Create a new invitation, send an email if the server-mail is enabled

    try:
        # Create an invitation
        kestra_client.InvitationsApi.create_invitation(tenant, iam_invitation_controller_api_invitation_create_request)
    except Exception as e:
        print("Exception when calling InvitationsApi->create_invitation: %s\n" % e)
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
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    id = 'id_example' # str | The id of the invitation
    tenant = 'tenant_example' # str | 

    try:
        # Delete an invitation
        kestra_client.InvitationsApi.delete_invitation(id, tenant)
    except Exception as e:
        print("Exception when calling InvitationsApi->delete_invitation: %s\n" % e)
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

# **find_all_invitations_for_current_user**
> List[Invitation] find_all_invitations_for_current_user()

List invitations for the authenticated user

Returns all invitations for the authenticated user's email across all tenants.

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

    try:
        # List invitations for the authenticated user
        api_response = kestra_client.InvitationsApi.find_all_invitations_for_current_user()
        print("The response of InvitationsApi->find_all_invitations_for_current_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InvitationsApi->find_all_invitations_for_current_user: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**List[Invitation]**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | findAllInvitationsForCurrentUser 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invitation**
> IAMInvitationControllerApiInvitationDetail invitation(id, tenant)

Retrieve an invitation

Retrieves the invitation by its ID, including the invitation link.

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
    id = 'id_example' # str | The id of the invitation
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve an invitation
        api_response = kestra_client.InvitationsApi.invitation(id, tenant)
        print("The response of InvitationsApi->invitation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InvitationsApi->invitation: %s\n" % e)
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
**200** | getInvitation 200 response |  -  |
**404** | Invitation not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_invitations_by_email**
> List[IAMInvitationControllerApiInvitationDetail] list_invitations_by_email(email, tenant)

Retrieve all invitations for a given email

Returns all invitations created for a given email address in the current tenant.

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
    email = 'email_example' # str | The email address of the invited
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve all invitations for a given email
        api_response = kestra_client.InvitationsApi.list_invitations_by_email(email, tenant)
        print("The response of InvitationsApi->list_invitations_by_email:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InvitationsApi->list_invitations_by_email: %s\n" % e)
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
> PagedResultsIAMInvitationControllerApiInvitationDetail search_invitations(page, size, filters, tenant, sort=sort)

Search for invitations

Search and filter invitations by email, status, and pagination.

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Search for invitations
        api_response = kestra_client.InvitationsApi.search_invitations(page, size, filters, tenant, sort=sort)
        print("The response of InvitationsApi->search_invitations:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InvitationsApi->search_invitations: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | 
 **tenant** | **str**|  | 
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

