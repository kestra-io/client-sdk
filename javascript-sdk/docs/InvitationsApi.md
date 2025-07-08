# KestraApi.InvitationsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInvitation**](InvitationsApi.md#createInvitation) | **POST** /api/v1/{tenant}/invitations | Create an invitation
[**createInvitationWithResourceTenantasSuperAdmin**](InvitationsApi.md#createInvitationWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/invitations | Create an invitation
[**createInvitationasSuperAdmin**](InvitationsApi.md#createInvitationasSuperAdmin) | **POST** /api/v1/tenants/invitations | Create an invitation
[**deleteInvitation**](InvitationsApi.md#deleteInvitation) | **DELETE** /api/v1/{tenant}/invitations/{id} | Delete an invitation
[**deleteInvitationWithResourceTenantasSuperAdmin**](InvitationsApi.md#deleteInvitationWithResourceTenantasSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/invitations/{id} | Delete an invitation
[**deleteInvitationasSuperAdmin**](InvitationsApi.md#deleteInvitationasSuperAdmin) | **DELETE** /api/v1/tenants/invitations/{id} | Delete an invitation
[**findAllInvitationsForCurrentUser**](InvitationsApi.md#findAllInvitationsForCurrentUser) | **GET** /api/v1/me/invitations | Get all invitations for a given email
[**findAllInvitationsForCurrentUserWithTenant**](InvitationsApi.md#findAllInvitationsForCurrentUserWithTenant) | **GET** /api/v1/{tenant}/me/invitations | Get all invitations for a given email
[**getInvitation**](InvitationsApi.md#getInvitation) | **GET** /api/v1/{tenant}/invitations/{id} | Get an invitation
[**getInvitationWithResourceTenantasSuperAdmin**](InvitationsApi.md#getInvitationWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/invitations/{id} | Get an invitation
[**getInvitationasSuperAdmin**](InvitationsApi.md#getInvitationasSuperAdmin) | **GET** /api/v1/tenants/invitations/{id} | Get an invitation
[**listByEmail**](InvitationsApi.md#listByEmail) | **GET** /api/v1/{tenant}/invitations/email/{email} | Get all invitations for a given email
[**listByEmailWithResourceTenantasSuperAdmin**](InvitationsApi.md#listByEmailWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/invitations/email/{email} | Get all invitations for a given email
[**listByEmailasSuperAdmin**](InvitationsApi.md#listByEmailasSuperAdmin) | **GET** /api/v1/tenants/invitations/email/{email} | Get all invitations for a given email
[**searchInvitations**](InvitationsApi.md#searchInvitations) | **GET** /api/v1/{tenant}/invitations/search | Search for invitations
[**searchInvitationsWithResourceTenantasSuperAdmin**](InvitationsApi.md#searchInvitationsWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/invitations/search | Search for invitations
[**searchInvitationsasSuperAdmin**](InvitationsApi.md#searchInvitationsasSuperAdmin) | **GET** /api/v1/tenants/invitations/search | Search for invitations



## createInvitation

> Invitation createInvitation(tenant, invitation)

Create an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let tenant = "tenant_example"; // String | 
let invitation = new KestraApi.Invitation(); // Invitation | Create a new invitation, send an email if the server-mail is enabled
apiInstance.createInvitation(tenant, invitation).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **invitation** | [**Invitation**](Invitation.md)| Create a new invitation, send an email if the server-mail is enabled | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createInvitationWithResourceTenantasSuperAdmin

> Invitation createInvitationWithResourceTenantasSuperAdmin(resourceTenant, invitation)

Create an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let resourceTenant = "resourceTenant_example"; // String | 
let invitation = new KestraApi.Invitation(); // Invitation | Create a new invitation, send an email if the server-mail is enabled
apiInstance.createInvitationWithResourceTenantasSuperAdmin(resourceTenant, invitation).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **invitation** | [**Invitation**](Invitation.md)| Create a new invitation, send an email if the server-mail is enabled | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createInvitationasSuperAdmin

> Invitation createInvitationasSuperAdmin(invitation)

Create an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let invitation = new KestraApi.Invitation(); // Invitation | Create a new invitation, send an email if the server-mail is enabled
apiInstance.createInvitationasSuperAdmin(invitation).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invitation** | [**Invitation**](Invitation.md)| Create a new invitation, send an email if the server-mail is enabled | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteInvitation

> deleteInvitation(id, tenant)

Delete an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let id = "id_example"; // String | The id of the invitation
let tenant = "tenant_example"; // String | 
apiInstance.deleteInvitation(id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
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


## deleteInvitationWithResourceTenantasSuperAdmin

> deleteInvitationWithResourceTenantasSuperAdmin(id, resourceTenant)

Delete an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let id = "id_example"; // String | The id of the invitation
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteInvitationWithResourceTenantasSuperAdmin(id, resourceTenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the invitation | 
 **resourceTenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteInvitationasSuperAdmin

> deleteInvitationasSuperAdmin(id)

Delete an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let id = "id_example"; // String | The id of the invitation
apiInstance.deleteInvitationasSuperAdmin(id).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the invitation | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## findAllInvitationsForCurrentUser

> [Invitation] findAllInvitationsForCurrentUser()

Get all invitations for a given email

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
apiInstance.findAllInvitationsForCurrentUser().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## findAllInvitationsForCurrentUserWithTenant

> [Invitation] findAllInvitationsForCurrentUserWithTenant(tenant)

Get all invitations for a given email

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let tenant = "tenant_example"; // String | 
apiInstance.findAllInvitationsForCurrentUserWithTenant(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 

### Return type

[**[Invitation]**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getInvitation

> Invitation getInvitation(id, tenant)

Get an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let id = "id_example"; // String | The id of the invitation
let tenant = "tenant_example"; // String | 
apiInstance.getInvitation(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the invitation | 
 **tenant** | **String**|  | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getInvitationWithResourceTenantasSuperAdmin

> Invitation getInvitationWithResourceTenantasSuperAdmin(id, resourceTenant)

Get an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let id = "id_example"; // String | The id of the invitation
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.getInvitationWithResourceTenantasSuperAdmin(id, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the invitation | 
 **resourceTenant** | **String**|  | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getInvitationasSuperAdmin

> Invitation getInvitationasSuperAdmin(id)

Get an invitation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let id = "id_example"; // String | The id of the invitation
apiInstance.getInvitationasSuperAdmin(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the invitation | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listByEmail

> [Invitation] listByEmail(email, tenant)

Get all invitations for a given email

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let email = "email_example"; // String | The email address of the invited
let tenant = "tenant_example"; // String | 
apiInstance.listByEmail(email, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| The email address of the invited | 
 **tenant** | **String**|  | 

### Return type

[**[Invitation]**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listByEmailWithResourceTenantasSuperAdmin

> [Invitation] listByEmailWithResourceTenantasSuperAdmin(email, resourceTenant)

Get all invitations for a given email

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let email = "email_example"; // String | The email address of the invited
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.listByEmailWithResourceTenantasSuperAdmin(email, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| The email address of the invited | 
 **resourceTenant** | **String**|  | 

### Return type

[**[Invitation]**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listByEmailasSuperAdmin

> [Invitation] listByEmailasSuperAdmin(email)

Get all invitations for a given email

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let email = "email_example"; // String | The email address of the invited
apiInstance.listByEmailasSuperAdmin(email).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| The email address of the invited | 

### Return type

[**[Invitation]**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchInvitations

> PagedResultsInvitation searchInvitations(page, size, tenant, opts)

Search for invitations

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'email': "email_example", // String | The email address of the invited
  'status': new KestraApi.InvitationInvitationStatus(), // InvitationInvitationStatus | The current status of the invitations
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchInvitations(page, size, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

[**PagedResultsInvitation**](PagedResultsInvitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchInvitationsWithResourceTenantasSuperAdmin

> PagedResultsInvitation searchInvitationsWithResourceTenantasSuperAdmin(page, size, resourceTenant, opts)

Search for invitations

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let resourceTenant = "resourceTenant_example"; // String | 
let opts = {
  'email': "email_example", // String | The email address of the invited
  'status': new KestraApi.InvitationInvitationStatus(), // InvitationInvitationStatus | The current status of the invitations
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchInvitationsWithResourceTenantasSuperAdmin(page, size, resourceTenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **resourceTenant** | **String**|  | 
 **email** | **String**| The email address of the invited | [optional] 
 **status** | [**InvitationInvitationStatus**](.md)| The current status of the invitations | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsInvitation**](PagedResultsInvitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchInvitationsasSuperAdmin

> PagedResultsInvitation searchInvitationsasSuperAdmin(page, size, opts)

Search for invitations

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.InvitationsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'email': "email_example", // String | The email address of the invited
  'status': new KestraApi.InvitationInvitationStatus(), // InvitationInvitationStatus | The current status of the invitations
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchInvitationsasSuperAdmin(page, size, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **email** | **String**| The email address of the invited | [optional] 
 **status** | [**InvitationInvitationStatus**](.md)| The current status of the invitations | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsInvitation**](PagedResultsInvitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

