# KestraIoKestraSdk.GroupsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUserToGroup**](GroupsApi.md#addUserToGroup) | **PUT** /api/v1/{tenant}/groups/{id}/members/{userId} | Add a user to a group
[**autocompleteGroups**](GroupsApi.md#autocompleteGroups) | **POST** /api/v1/{tenant}/groups/autocomplete | List groups for autocomplete
[**createGroup**](GroupsApi.md#createGroup) | **POST** /api/v1/{tenant}/groups | Create a group
[**deleteGroup**](GroupsApi.md#deleteGroup) | **DELETE** /api/v1/{tenant}/groups/{id} | Delete a group
[**deleteUserFromGroup**](GroupsApi.md#deleteUserFromGroup) | **DELETE** /api/v1/{tenant}/groups/{id}/members/{userId} | Remove a user from a group
[**group**](GroupsApi.md#group) | **GET** /api/v1/{tenant}/groups/{id} | Retrieve a group
[**listGroupIds**](GroupsApi.md#listGroupIds) | **POST** /api/v1/{tenant}/groups/ids | List groups by ids
[**searchGroupMembers**](GroupsApi.md#searchGroupMembers) | **GET** /api/v1/{tenant}/groups/{id}/members | Search for users in a group
[**searchGroups**](GroupsApi.md#searchGroups) | **GET** /api/v1/{tenant}/groups/search | Search for groups
[**setUserMembershipForGroup**](GroupsApi.md#setUserMembershipForGroup) | **PUT** /api/v1/{tenant}/groups/{id}/members/membership/{userId} | Update a user&#39;s membership type in a group
[**updateGroup**](GroupsApi.md#updateGroup) | **PUT** /api/v1/{tenant}/groups/{id} | Update a group



## addUserToGroup

> IAMGroupControllerApiGroupMember addUserToGroup(id, userId, tenant)

Add a user to a group

Adds the specified user to the given group. If the user does not already have access to the tenant, tenant access will be created automatically.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
let id = "id_example"; // String | The ID of the group
let userId = "userId_example"; // String | The ID of the user to add to the group
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
 **id** | **String**| The ID of the group | 
 **userId** | **String**| The ID of the user to add to the group | 
 **tenant** | **String**|  | 

### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## autocompleteGroups

> [ApiGroupSummary] autocompleteGroups(tenant, apiAutocomplete)

List groups for autocomplete

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
let tenant = "tenant_example"; // String | 
let apiAutocomplete = new KestraIoKestraSdk.ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
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

[**[ApiGroupSummary]**](ApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createGroup

> IAMGroupControllerApiGroupDetail createGroup(tenant, iAMGroupControllerApiCreateGroupRequest)

Create a group

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
let tenant = "tenant_example"; // String | 
let iAMGroupControllerApiCreateGroupRequest = new KestraIoKestraSdk.IAMGroupControllerApiCreateGroupRequest(); // IAMGroupControllerApiCreateGroupRequest | The group
apiInstance.createGroup(tenant, iAMGroupControllerApiCreateGroupRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **iAMGroupControllerApiCreateGroupRequest** | [**IAMGroupControllerApiCreateGroupRequest**](IAMGroupControllerApiCreateGroupRequest.md)| The group | 

### Return type

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

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
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
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


## deleteUserFromGroup

> IAMGroupControllerApiGroupMember deleteUserFromGroup(id, userId, tenant)

Remove a user from a group

Removes the specified user from the given group. If the user has no other group bindings within the tenant, their access to the tenant will also be revoked.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
let id = "id_example"; // String | The ID of the group
let userId = "userId_example"; // String | The ID of the user to remove from the group
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
 **id** | **String**| The ID of the group | 
 **userId** | **String**| The ID of the user to remove from the group | 
 **tenant** | **String**|  | 

### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## group

> IAMGroupControllerApiGroupDetail group(id, tenant)

Retrieve a group

Retrieves details of a specific group by its ID within the current tenant.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
let id = "id_example"; // String | The group id
let tenant = "tenant_example"; // String | 
apiInstance.group(id, tenant).then((data) => {
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

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listGroupIds

> [ApiGroupSummary] listGroupIds(tenant, apiIds)

List groups by ids

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
let tenant = "tenant_example"; // String | 
let apiIds = new KestraIoKestraSdk.ApiIds(); // ApiIds | The ids that must be present on results
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

[**[ApiGroupSummary]**](ApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## searchGroupMembers

> PagedResultsIAMGroupControllerApiGroupMember searchGroupMembers(id, page, size, tenant, opts)

Search for users in a group

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
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

[**PagedResultsIAMGroupControllerApiGroupMember**](PagedResultsIAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchGroups

> PagedResultsApiGroupSummary searchGroups(page, size, tenant, opts)

Search for groups

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
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

[**PagedResultsApiGroupSummary**](PagedResultsApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## setUserMembershipForGroup

> IAMGroupControllerApiGroupMember setUserMembershipForGroup(id, userId, membership, tenant)

Update a user&#39;s membership type in a group

Allows a group owner or an authorized user to change the role of a user within a group to OWNER or MEMBER.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
let id = "id_example"; // String | The ID of the group
let userId = "userId_example"; // String | The ID of the user whose membership is being updated
let membership = new KestraIoKestraSdk.GroupIdentifierMembership(); // GroupIdentifierMembership | The new membership type to assign to the user.
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
 **id** | **String**| The ID of the group | 
 **userId** | **String**| The ID of the user whose membership is being updated | 
 **membership** | [**GroupIdentifierMembership**](.md)| The new membership type to assign to the user. | 
 **tenant** | **String**|  | 

### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateGroup

> IAMGroupControllerApiGroupDetail updateGroup(id, tenant, iAMGroupControllerApiUpdateGroupRequest)

Update a group

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.GroupsApi();
let id = "id_example"; // String | The group id
let tenant = "tenant_example"; // String | 
let iAMGroupControllerApiUpdateGroupRequest = new KestraIoKestraSdk.IAMGroupControllerApiUpdateGroupRequest(); // IAMGroupControllerApiUpdateGroupRequest | The group
apiInstance.updateGroup(id, tenant, iAMGroupControllerApiUpdateGroupRequest).then((data) => {
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
 **iAMGroupControllerApiUpdateGroupRequest** | [**IAMGroupControllerApiUpdateGroupRequest**](IAMGroupControllerApiUpdateGroupRequest.md)| The group | 

### Return type

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

