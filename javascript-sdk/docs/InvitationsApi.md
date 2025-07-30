# KestraIoKestraApi.InvitationsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInvitation**](InvitationsApi.md#createInvitation) | **POST** /api/v1/{tenant}/invitations | Create an invitation
[**deleteInvitation**](InvitationsApi.md#deleteInvitation) | **DELETE** /api/v1/{tenant}/invitations/{id} | Delete an invitation
[**findAllInvitationsForCurrentUser**](InvitationsApi.md#findAllInvitationsForCurrentUser) | **GET** /api/v1/me/invitations | List invitations for the authenticated user
[**getInvitation**](InvitationsApi.md#getInvitation) | **GET** /api/v1/{tenant}/invitations/{id} | Retrieve an invitation
[**listInvitationsByEmail**](InvitationsApi.md#listInvitationsByEmail) | **GET** /api/v1/{tenant}/invitations/email/{email} | Retrieve all invitations for a given email
[**searchInvitations**](InvitationsApi.md#searchInvitations) | **GET** /api/v1/{tenant}/invitations/search | Search for invitations



## createInvitation

> createInvitation(tenant, iAMInvitationControllerApiInvitationCreateRequest)

Create an invitation

Creates a new invitation and sends an email if the mail server is enabled.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.InvitationsApi();
let tenant = "tenant_example"; // String | 
let iAMInvitationControllerApiInvitationCreateRequest = new KestraIoKestraApi.IAMInvitationControllerApiInvitationCreateRequest(); // IAMInvitationControllerApiInvitationCreateRequest | Create a new invitation, send an email if the server-mail is enabled
apiInstance.createInvitation(tenant, iAMInvitationControllerApiInvitationCreateRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **iAMInvitationControllerApiInvitationCreateRequest** | [**IAMInvitationControllerApiInvitationCreateRequest**](IAMInvitationControllerApiInvitationCreateRequest.md)| Create a new invitation, send an email if the server-mail is enabled | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## deleteInvitation

> deleteInvitation(id, tenant)

Delete an invitation

Deletes the invitation by its ID.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.InvitationsApi();
let id = "id_example"; // String | The id of the invitation
let tenant = "tenant_example"; // String | 
apiInstance.deleteInvitation(id, tenant, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the invitation | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## findAllInvitationsForCurrentUser

> [Invitation] findAllInvitationsForCurrentUser()

List invitations for the authenticated user

Returns all invitations for the authenticated user&#39;s email across all tenants.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.InvitationsApi();
apiInstance.findAllInvitationsForCurrentUser((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[Invitation]**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getInvitation

> IAMInvitationControllerApiInvitationDetail getInvitation(id, tenant)

Retrieve an invitation

Retrieves the invitation by its ID, including the invitation link.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.InvitationsApi();
let id = "id_example"; // String | The id of the invitation
let tenant = "tenant_example"; // String | 
apiInstance.getInvitation(id, tenant, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the invitation | 
 **tenant** | **String**|  | 

### Return type

[**IAMInvitationControllerApiInvitationDetail**](IAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listInvitationsByEmail

> [IAMInvitationControllerApiInvitationDetail] listInvitationsByEmail(email, tenant)

Retrieve all invitations for a given email

Returns all invitations created for a given email address in the current tenant.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.InvitationsApi();
let email = "email_example"; // String | The email address of the invited
let tenant = "tenant_example"; // String | 
apiInstance.listInvitationsByEmail(email, tenant, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| The email address of the invited | 
 **tenant** | **String**|  | 

### Return type

[**[IAMInvitationControllerApiInvitationDetail]**](IAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchInvitations

> PagedResultsIAMInvitationControllerApiInvitationDetail searchInvitations(page, size, tenant, opts)

Search for invitations

Search and filter invitations by email, status, and pagination.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.InvitationsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'email': "email_example", // String | The email address of the invited
  'status': new KestraIoKestraApi.InvitationInvitationStatus(), // InvitationInvitationStatus | The current status of the invitations
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchInvitations(page, size, tenant, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **tenant** | **String**|  | 
 **email** | **String**| The email address of the invited | [optional] 
 **status** | [**InvitationInvitationStatus**](.md)| The current status of the invitations | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsIAMInvitationControllerApiInvitationDetail**](PagedResultsIAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

