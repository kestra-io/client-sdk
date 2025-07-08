# KestraApi.GroupsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUserToGroup**](GroupsApi.md#addUserToGroup) | **PUT** /api/v1/{tenant}/groups/{id}/members/{userId} | Add a group for a user
[**addUserToGroupWithResourceTenantasSuperAdmin**](GroupsApi.md#addUserToGroupWithResourceTenantasSuperAdmin) | **PUT** /api/v1/tenants/{resourceTenant}/groups/{id}/members/{userId} | Add a group for a user
[**addUserToGroupasSuperAdmin**](GroupsApi.md#addUserToGroupasSuperAdmin) | **PUT** /api/v1/tenants/groups/{id}/members/{userId} | Add a group for a user
[**autocompleteGroups**](GroupsApi.md#autocompleteGroups) | **POST** /api/v1/{tenant}/groups/autocomplete | List groups for autocomplete
[**autocompleteGroupsWithResourceTenantasSuperAdmin**](GroupsApi.md#autocompleteGroupsWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/groups/autocomplete | List groups for autocomplete
[**autocompleteGroupsasSuperAdmin**](GroupsApi.md#autocompleteGroupsasSuperAdmin) | **POST** /api/v1/tenants/groups/autocomplete | List groups for autocomplete
[**createGroup**](GroupsApi.md#createGroup) | **POST** /api/v1/{tenant}/groups | Create a group
[**createGroupWithResourceTenantasSuperAdmin**](GroupsApi.md#createGroupWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/groups | Create a group
[**createGroupasSuperAdmin**](GroupsApi.md#createGroupasSuperAdmin) | **POST** /api/v1/tenants/groups | Create a group
[**deleteGroup**](GroupsApi.md#deleteGroup) | **DELETE** /api/v1/{tenant}/groups/{id} | Delete a group
[**deleteGroupWithResourceTenantasSuperAdmin**](GroupsApi.md#deleteGroupWithResourceTenantasSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/groups/{id} | Delete a group
[**deleteGroupasSuperAdmin**](GroupsApi.md#deleteGroupasSuperAdmin) | **DELETE** /api/v1/tenants/groups/{id} | Delete a group
[**deleteUserFromGroup**](GroupsApi.md#deleteUserFromGroup) | **DELETE** /api/v1/{tenant}/groups/{id}/members/{userId} | Delete a group for a user
[**deleteUserFromGroupWithResourceTenantasSuperAdmin**](GroupsApi.md#deleteUserFromGroupWithResourceTenantasSuperAdmin) | **DELETE** /api/v1/tenants/{resourceTenant}/groups/{id}/members/{userId} | Delete a group for a user
[**deleteUserFromGroupasSuperAdmin**](GroupsApi.md#deleteUserFromGroupasSuperAdmin) | **DELETE** /api/v1/tenants/groups/{id}/members/{userId} | Delete a group for a user
[**getGroup**](GroupsApi.md#getGroup) | **GET** /api/v1/{tenant}/groups/{id} | Get a group
[**getGroupWithResourceTenantasSuperAdmin**](GroupsApi.md#getGroupWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/groups/{id} | Get a group
[**getGroupasSuperAdmin**](GroupsApi.md#getGroupasSuperAdmin) | **GET** /api/v1/tenants/groups/{id} | Get a group
[**listGroupIds**](GroupsApi.md#listGroupIds) | **POST** /api/v1/{tenant}/groups/ids | List groups by ids
[**listGroupIdsWithResourceTenantasSuperAdmin**](GroupsApi.md#listGroupIdsWithResourceTenantasSuperAdmin) | **POST** /api/v1/tenants/{resourceTenant}/groups/ids | List groups by ids
[**listGroupIdsasSuperAdmin**](GroupsApi.md#listGroupIdsasSuperAdmin) | **POST** /api/v1/tenants/groups/ids | List groups by ids
[**searchGroupMembers**](GroupsApi.md#searchGroupMembers) | **GET** /api/v1/{tenant}/groups/{id}/members | Search for users in a group
[**searchGroupMembersWithResourceTenantasSuperAdmin**](GroupsApi.md#searchGroupMembersWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/groups/{id}/members | Search for users in a group
[**searchGroupMembersasSuperAdmin**](GroupsApi.md#searchGroupMembersasSuperAdmin) | **GET** /api/v1/tenants/groups/{id}/members | Search for users in a group
[**searchGroups**](GroupsApi.md#searchGroups) | **GET** /api/v1/{tenant}/groups/search | Search for groups
[**searchGroupsWithResourceTenantasSuperAdmin**](GroupsApi.md#searchGroupsWithResourceTenantasSuperAdmin) | **GET** /api/v1/tenants/{resourceTenant}/groups/search | Search for groups
[**searchGroupsasSuperAdmin**](GroupsApi.md#searchGroupsasSuperAdmin) | **GET** /api/v1/tenants/groups/search | Search for groups
[**setUserMembershipForGroup**](GroupsApi.md#setUserMembershipForGroup) | **PUT** /api/v1/{tenant}/groups/{id}/members/membership/{userId} | Set the membership type of a user in a group
[**setUserMembershipForGroupWithResourceTenantasSuperAdmin**](GroupsApi.md#setUserMembershipForGroupWithResourceTenantasSuperAdmin) | **PUT** /api/v1/tenants/{resourceTenant}/groups/{id}/members/membership/{userId} | Set the membership type of a user in a group
[**setUserMembershipForGroupasSuperAdmin**](GroupsApi.md#setUserMembershipForGroupasSuperAdmin) | **PUT** /api/v1/tenants/groups/{id}/members/membership/{userId} | Set the membership type of a user in a group
[**updateGroup**](GroupsApi.md#updateGroup) | **PUT** /api/v1/{tenant}/groups/{id} | Update a group
[**updateGroupWithResourceTenantasSuperAdmin**](GroupsApi.md#updateGroupWithResourceTenantasSuperAdmin) | **PUT** /api/v1/tenants/{resourceTenant}/groups/{id} | Update a group
[**updateGroupasSuperAdmin**](GroupsApi.md#updateGroupasSuperAdmin) | **PUT** /api/v1/tenants/groups/{id} | Update a group



## addUserToGroup

> ApiUser addUserToGroup(id, userId, tenant)

Add a group for a user

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.addUserToGroup(id, userId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## addUserToGroupWithResourceTenantasSuperAdmin

> ApiUser addUserToGroupWithResourceTenantasSuperAdmin(id, userId, resourceTenant)

Add a group for a user

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.addUserToGroupWithResourceTenantasSuperAdmin(id, userId, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 
 **resourceTenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## addUserToGroupasSuperAdmin

> ApiUser addUserToGroupasSuperAdmin(id, userId)

Add a group for a user

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
apiInstance.addUserToGroupasSuperAdmin(id, userId).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## autocompleteGroups

> [Group] autocompleteGroups(tenant, apiAutocomplete)

List groups for autocomplete

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

let apiInstance = new KestraApi.GroupsApi();
let tenant = "tenant_example"; // String | 
let apiAutocomplete = new KestraApi.ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
apiInstance.autocompleteGroups(tenant, apiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[Group]**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## autocompleteGroupsWithResourceTenantasSuperAdmin

> [Group] autocompleteGroupsWithResourceTenantasSuperAdmin(resourceTenant, apiAutocomplete)

List groups for autocomplete

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

let apiInstance = new KestraApi.GroupsApi();
let resourceTenant = "resourceTenant_example"; // String | 
let apiAutocomplete = new KestraApi.ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
apiInstance.autocompleteGroupsWithResourceTenantasSuperAdmin(resourceTenant, apiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[Group]**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## autocompleteGroupsasSuperAdmin

> [Group] autocompleteGroupsasSuperAdmin(apiAutocomplete)

List groups for autocomplete

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

let apiInstance = new KestraApi.GroupsApi();
let apiAutocomplete = new KestraApi.ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
apiInstance.autocompleteGroupsasSuperAdmin(apiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)| Autocomplete request | 

### Return type

[**[Group]**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createGroup

> Group createGroup(tenant, abstractGroupControllerGroupWithMembers)

Create a group

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

let apiInstance = new KestraApi.GroupsApi();
let tenant = "tenant_example"; // String | 
let abstractGroupControllerGroupWithMembers = new KestraApi.AbstractGroupControllerGroupWithMembers(); // AbstractGroupControllerGroupWithMembers | The group
apiInstance.createGroup(tenant, abstractGroupControllerGroupWithMembers).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **abstractGroupControllerGroupWithMembers** | [**AbstractGroupControllerGroupWithMembers**](AbstractGroupControllerGroupWithMembers.md)| The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createGroupWithResourceTenantasSuperAdmin

> Group createGroupWithResourceTenantasSuperAdmin(resourceTenant, abstractGroupControllerGroupWithMembers)

Create a group

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

let apiInstance = new KestraApi.GroupsApi();
let resourceTenant = "resourceTenant_example"; // String | 
let abstractGroupControllerGroupWithMembers = new KestraApi.AbstractGroupControllerGroupWithMembers(); // AbstractGroupControllerGroupWithMembers | The group
apiInstance.createGroupWithResourceTenantasSuperAdmin(resourceTenant, abstractGroupControllerGroupWithMembers).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **abstractGroupControllerGroupWithMembers** | [**AbstractGroupControllerGroupWithMembers**](AbstractGroupControllerGroupWithMembers.md)| The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createGroupasSuperAdmin

> Group createGroupasSuperAdmin(abstractGroupControllerGroupWithMembers)

Create a group

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

let apiInstance = new KestraApi.GroupsApi();
let abstractGroupControllerGroupWithMembers = new KestraApi.AbstractGroupControllerGroupWithMembers(); // AbstractGroupControllerGroupWithMembers | The group
apiInstance.createGroupasSuperAdmin(abstractGroupControllerGroupWithMembers).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **abstractGroupControllerGroupWithMembers** | [**AbstractGroupControllerGroupWithMembers**](AbstractGroupControllerGroupWithMembers.md)| The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteGroup

> deleteGroup(id, tenant)

Delete a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let tenant = "tenant_example"; // String | 
apiInstance.deleteGroup(id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteGroupWithResourceTenantasSuperAdmin

> deleteGroupWithResourceTenantasSuperAdmin(id, resourceTenant)

Delete a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteGroupWithResourceTenantasSuperAdmin(id, resourceTenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **resourceTenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteGroupasSuperAdmin

> deleteGroupasSuperAdmin(id)

Delete a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
apiInstance.deleteGroupasSuperAdmin(id).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteUserFromGroup

> ApiUser deleteUserFromGroup(id, userId, tenant)

Delete a group for a user

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
let tenant = "tenant_example"; // String | 
apiInstance.deleteUserFromGroup(id, userId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 
 **tenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteUserFromGroupWithResourceTenantasSuperAdmin

> ApiUser deleteUserFromGroupWithResourceTenantasSuperAdmin(id, userId, resourceTenant)

Delete a group for a user

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.deleteUserFromGroupWithResourceTenantasSuperAdmin(id, userId, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 
 **resourceTenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteUserFromGroupasSuperAdmin

> ApiUser deleteUserFromGroupasSuperAdmin(id, userId)

Delete a group for a user

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
apiInstance.deleteUserFromGroupasSuperAdmin(id, userId).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getGroup

> Group getGroup(id, tenant)

Get a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let tenant = "tenant_example"; // String | 
apiInstance.getGroup(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **tenant** | **String**|  | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getGroupWithResourceTenantasSuperAdmin

> Group getGroupWithResourceTenantasSuperAdmin(id, resourceTenant)

Get a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.getGroupWithResourceTenantasSuperAdmin(id, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **resourceTenant** | **String**|  | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getGroupasSuperAdmin

> Group getGroupasSuperAdmin(id)

Get a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
apiInstance.getGroupasSuperAdmin(id).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listGroupIds

> [Group] listGroupIds(tenant, apiIds)

List groups by ids

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

let apiInstance = new KestraApi.GroupsApi();
let tenant = "tenant_example"; // String | 
let apiIds = new KestraApi.ApiIds(); // ApiIds | The ids that must be present on results
apiInstance.listGroupIds(tenant, apiIds).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **apiIds** | [**ApiIds**](ApiIds.md)| The ids that must be present on results | 

### Return type

[**[Group]**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## listGroupIdsWithResourceTenantasSuperAdmin

> [Group] listGroupIdsWithResourceTenantasSuperAdmin(resourceTenant, apiIds)

List groups by ids

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

let apiInstance = new KestraApi.GroupsApi();
let resourceTenant = "resourceTenant_example"; // String | 
let apiIds = new KestraApi.ApiIds(); // ApiIds | The ids that must be present on results
apiInstance.listGroupIdsWithResourceTenantasSuperAdmin(resourceTenant, apiIds).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resourceTenant** | **String**|  | 
 **apiIds** | [**ApiIds**](ApiIds.md)| The ids that must be present on results | 

### Return type

[**[Group]**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## listGroupIdsasSuperAdmin

> [Group] listGroupIdsasSuperAdmin(apiIds)

List groups by ids

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

let apiInstance = new KestraApi.GroupsApi();
let apiIds = new KestraApi.ApiIds(); // ApiIds | The ids that must be present on results
apiInstance.listGroupIdsasSuperAdmin(apiIds).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiIds** | [**ApiIds**](ApiIds.md)| The ids that must be present on results | 

### Return type

[**[Group]**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## searchGroupMembers

> PagedResultsApiUser searchGroupMembers(id, page, size, tenant, opts)

Search for users in a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchGroupMembers(id, page, size, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **tenant** | **String**|  | 
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchGroupMembersWithResourceTenantasSuperAdmin

> PagedResultsApiUser searchGroupMembersWithResourceTenantasSuperAdmin(id, page, size, resourceTenant, opts)

Search for users in a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let resourceTenant = "resourceTenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchGroupMembersWithResourceTenantasSuperAdmin(id, page, size, resourceTenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **resourceTenant** | **String**|  | 
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchGroupMembersasSuperAdmin

> PagedResultsApiUser searchGroupMembersasSuperAdmin(id, page, size, opts)

Search for users in a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchGroupMembersasSuperAdmin(id, page, size, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchGroups

> PagedResultsGroup searchGroups(page, size, tenant, opts)

Search for groups

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

let apiInstance = new KestraApi.GroupsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchGroups(page, size, tenant, opts).then((data) => {
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
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsGroup**](PagedResultsGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchGroupsWithResourceTenantasSuperAdmin

> PagedResultsGroup searchGroupsWithResourceTenantasSuperAdmin(page, size, resourceTenant, opts)

Search for groups

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

let apiInstance = new KestraApi.GroupsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let resourceTenant = "resourceTenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchGroupsWithResourceTenantasSuperAdmin(page, size, resourceTenant, opts).then((data) => {
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
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsGroup**](PagedResultsGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchGroupsasSuperAdmin

> PagedResultsGroup searchGroupsasSuperAdmin(page, size, opts)

Search for groups

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

let apiInstance = new KestraApi.GroupsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchGroupsasSuperAdmin(page, size, opts).then((data) => {
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
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsGroup**](PagedResultsGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## setUserMembershipForGroup

> ApiUser setUserMembershipForGroup(id, userId, membership, tenant)

Set the membership type of a user in a group

Sets the membership type of a user in a group. This method allows a group owner or a user with UPDATE permission to modify the membership of a user in a specific group.

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
let membership = new KestraApi.AbstractUserGroupIdentifierMembership(); // AbstractUserGroupIdentifierMembership | The membership type
let tenant = "tenant_example"; // String | 
apiInstance.setUserMembershipForGroup(id, userId, membership, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 
 **membership** | [**AbstractUserGroupIdentifierMembership**](.md)| The membership type | 
 **tenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## setUserMembershipForGroupWithResourceTenantasSuperAdmin

> ApiUser setUserMembershipForGroupWithResourceTenantasSuperAdmin(id, userId, membership, resourceTenant)

Set the membership type of a user in a group

Sets the membership type of a user in a group. This method allows a group owner or a user with UPDATE permission to modify the membership of a user in a specific group.

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
let membership = new KestraApi.AbstractUserGroupIdentifierMembership(); // AbstractUserGroupIdentifierMembership | The membership type
let resourceTenant = "resourceTenant_example"; // String | 
apiInstance.setUserMembershipForGroupWithResourceTenantasSuperAdmin(id, userId, membership, resourceTenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 
 **membership** | [**AbstractUserGroupIdentifierMembership**](.md)| The membership type | 
 **resourceTenant** | **String**|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## setUserMembershipForGroupasSuperAdmin

> ApiUser setUserMembershipForGroupasSuperAdmin(id, userId, membership)

Set the membership type of a user in a group

Sets the membership type of a user in a group. This method allows a group owner or a user with UPDATE permission to modify the membership of a user in a specific group.

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let userId = "userId_example"; // String | The user id
let membership = new KestraApi.AbstractUserGroupIdentifierMembership(); // AbstractUserGroupIdentifierMembership | The membership type
apiInstance.setUserMembershipForGroupasSuperAdmin(id, userId, membership).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **userId** | **String**| The user id | 
 **membership** | [**AbstractUserGroupIdentifierMembership**](.md)| The membership type | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateGroup

> Group updateGroup(id, tenant, group)

Update a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let tenant = "tenant_example"; // String | 
let group = new KestraApi.Group(); // Group | The group
apiInstance.updateGroup(id, tenant, group).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **tenant** | **String**|  | 
 **group** | [**Group**](Group.md)| The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateGroupWithResourceTenantasSuperAdmin

> Group updateGroupWithResourceTenantasSuperAdmin(id, resourceTenant, group)

Update a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let resourceTenant = "resourceTenant_example"; // String | 
let group = new KestraApi.Group(); // Group | The group
apiInstance.updateGroupWithResourceTenantasSuperAdmin(id, resourceTenant, group).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **resourceTenant** | **String**|  | 
 **group** | [**Group**](Group.md)| The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## updateGroupasSuperAdmin

> Group updateGroupasSuperAdmin(id, group)

Update a group

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

let apiInstance = new KestraApi.GroupsApi();
let id = "id_example"; // String | The group id
let group = new KestraApi.Group(); // Group | The group
apiInstance.updateGroupasSuperAdmin(id, group).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The group id | 
 **group** | [**Group**](Group.md)| The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

