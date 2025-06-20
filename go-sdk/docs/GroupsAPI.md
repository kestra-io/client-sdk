# \GroupsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AddUserToGroup**](GroupsAPI.md#AddUserToGroup) | **Put** /api/v1/{tenant}/groups/{id}/members/{userId} | Add a group for a user
[**AddUserToGroupWithResourceTenantasSuperAdmin**](GroupsAPI.md#AddUserToGroupWithResourceTenantasSuperAdmin) | **Put** /api/v1/tenants/{resourceTenant}/groups/{id}/members/{userId} | Add a group for a user
[**AddUserToGroupasSuperAdmin**](GroupsAPI.md#AddUserToGroupasSuperAdmin) | **Put** /api/v1/tenants/groups/{id}/members/{userId} | Add a group for a user
[**AutocompleteGroups**](GroupsAPI.md#AutocompleteGroups) | **Post** /api/v1/{tenant}/groups/autocomplete | List groups for autocomplete
[**AutocompleteGroupsWithResourceTenantasSuperAdmin**](GroupsAPI.md#AutocompleteGroupsWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/groups/autocomplete | List groups for autocomplete
[**AutocompleteGroupsasSuperAdmin**](GroupsAPI.md#AutocompleteGroupsasSuperAdmin) | **Post** /api/v1/tenants/groups/autocomplete | List groups for autocomplete
[**CreateGroup**](GroupsAPI.md#CreateGroup) | **Post** /api/v1/{tenant}/groups | Create a group
[**CreateGroupWithResourceTenantasSuperAdmin**](GroupsAPI.md#CreateGroupWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/groups | Create a group
[**CreateGroupasSuperAdmin**](GroupsAPI.md#CreateGroupasSuperAdmin) | **Post** /api/v1/tenants/groups | Create a group
[**DeleteGroup**](GroupsAPI.md#DeleteGroup) | **Delete** /api/v1/{tenant}/groups/{id} | Delete a group
[**DeleteGroupWithResourceTenantasSuperAdmin**](GroupsAPI.md#DeleteGroupWithResourceTenantasSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/groups/{id} | Delete a group
[**DeleteGroupasSuperAdmin**](GroupsAPI.md#DeleteGroupasSuperAdmin) | **Delete** /api/v1/tenants/groups/{id} | Delete a group
[**DeleteUserFromGroup**](GroupsAPI.md#DeleteUserFromGroup) | **Delete** /api/v1/{tenant}/groups/{id}/members/{userId} | Delete a group for a user
[**DeleteUserFromGroupWithResourceTenantasSuperAdmin**](GroupsAPI.md#DeleteUserFromGroupWithResourceTenantasSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/groups/{id}/members/{userId} | Delete a group for a user
[**DeleteUserFromGroupasSuperAdmin**](GroupsAPI.md#DeleteUserFromGroupasSuperAdmin) | **Delete** /api/v1/tenants/groups/{id}/members/{userId} | Delete a group for a user
[**GetGroup**](GroupsAPI.md#GetGroup) | **Get** /api/v1/{tenant}/groups/{id} | Get a group
[**GetGroupWithResourceTenantasSuperAdmin**](GroupsAPI.md#GetGroupWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/groups/{id} | Get a group
[**GetGroupasSuperAdmin**](GroupsAPI.md#GetGroupasSuperAdmin) | **Get** /api/v1/tenants/groups/{id} | Get a group
[**ListGroupIds**](GroupsAPI.md#ListGroupIds) | **Post** /api/v1/{tenant}/groups/ids | List groups by ids
[**ListGroupIdsWithResourceTenantasSuperAdmin**](GroupsAPI.md#ListGroupIdsWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/groups/ids | List groups by ids
[**ListGroupIdsasSuperAdmin**](GroupsAPI.md#ListGroupIdsasSuperAdmin) | **Post** /api/v1/tenants/groups/ids | List groups by ids
[**SearchGroupMembers**](GroupsAPI.md#SearchGroupMembers) | **Get** /api/v1/{tenant}/groups/{id}/members | Search for users in a group
[**SearchGroupMembersWithResourceTenantasSuperAdmin**](GroupsAPI.md#SearchGroupMembersWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/groups/{id}/members | Search for users in a group
[**SearchGroupMembersasSuperAdmin**](GroupsAPI.md#SearchGroupMembersasSuperAdmin) | **Get** /api/v1/tenants/groups/{id}/members | Search for users in a group
[**SearchGroups**](GroupsAPI.md#SearchGroups) | **Get** /api/v1/{tenant}/groups/search | Search for groups
[**SearchGroupsWithResourceTenantasSuperAdmin**](GroupsAPI.md#SearchGroupsWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/groups/search | Search for groups
[**SearchGroupsasSuperAdmin**](GroupsAPI.md#SearchGroupsasSuperAdmin) | **Get** /api/v1/tenants/groups/search | Search for groups
[**SetUserMembershipForGroup**](GroupsAPI.md#SetUserMembershipForGroup) | **Put** /api/v1/{tenant}/groups/{id}/members/membership/{userId} | Set the membership type of a user in a group
[**SetUserMembershipForGroupWithResourceTenantasSuperAdmin**](GroupsAPI.md#SetUserMembershipForGroupWithResourceTenantasSuperAdmin) | **Put** /api/v1/tenants/{resourceTenant}/groups/{id}/members/membership/{userId} | Set the membership type of a user in a group
[**SetUserMembershipForGroupasSuperAdmin**](GroupsAPI.md#SetUserMembershipForGroupasSuperAdmin) | **Put** /api/v1/tenants/groups/{id}/members/membership/{userId} | Set the membership type of a user in a group
[**UpdateGroup**](GroupsAPI.md#UpdateGroup) | **Put** /api/v1/{tenant}/groups/{id} | Update a group
[**UpdateGroupWithResourceTenantasSuperAdmin**](GroupsAPI.md#UpdateGroupWithResourceTenantasSuperAdmin) | **Put** /api/v1/tenants/{resourceTenant}/groups/{id} | Update a group
[**UpdateGroupasSuperAdmin**](GroupsAPI.md#UpdateGroupasSuperAdmin) | **Put** /api/v1/tenants/groups/{id} | Update a group



## AddUserToGroup

> ApiUser AddUserToGroup(ctx, id, userId, tenant).Execute()

Add a group for a user

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.AddUserToGroup(context.Background(), id, userId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.AddUserToGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AddUserToGroup`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.AddUserToGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAddUserToGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AddUserToGroupWithResourceTenantasSuperAdmin

> ApiUser AddUserToGroupWithResourceTenantasSuperAdmin(ctx, id, userId, resourceTenant).Execute()

Add a group for a user

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.AddUserToGroupWithResourceTenantasSuperAdmin(context.Background(), id, userId, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.AddUserToGroupWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AddUserToGroupWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.AddUserToGroupWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAddUserToGroupWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AddUserToGroupasSuperAdmin

> ApiUser AddUserToGroupasSuperAdmin(ctx, id, userId).Execute()

Add a group for a user

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.AddUserToGroupasSuperAdmin(context.Background(), id, userId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.AddUserToGroupasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AddUserToGroupasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.AddUserToGroupasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiAddUserToGroupasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AutocompleteGroups

> []Group AutocompleteGroups(ctx, tenant).ApiAutocomplete(apiAutocomplete).Execute()

List groups for autocomplete

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	apiAutocomplete := *openapiclient.NewApiAutocomplete() // ApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.AutocompleteGroups(context.Background(), tenant).ApiAutocomplete(apiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.AutocompleteGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteGroups`: []Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.AutocompleteGroups`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteGroupsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AutocompleteGroupsWithResourceTenantasSuperAdmin

> []Group AutocompleteGroupsWithResourceTenantasSuperAdmin(ctx, resourceTenant).ApiAutocomplete(apiAutocomplete).Execute()

List groups for autocomplete

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	resourceTenant := "resourceTenant_example" // string | 
	apiAutocomplete := *openapiclient.NewApiAutocomplete() // ApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.AutocompleteGroupsWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).ApiAutocomplete(apiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.AutocompleteGroupsWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteGroupsWithResourceTenantasSuperAdmin`: []Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.AutocompleteGroupsWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteGroupsWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AutocompleteGroupsasSuperAdmin

> []Group AutocompleteGroupsasSuperAdmin(ctx).ApiAutocomplete(apiAutocomplete).Execute()

List groups for autocomplete

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	apiAutocomplete := *openapiclient.NewApiAutocomplete() // ApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.AutocompleteGroupsasSuperAdmin(context.Background()).ApiAutocomplete(apiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.AutocompleteGroupsasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteGroupsasSuperAdmin`: []Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.AutocompleteGroupsasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteGroupsasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateGroup

> Group CreateGroup(ctx, tenant).AbstractGroupControllerGroupWithMembers(abstractGroupControllerGroupWithMembers).Execute()

Create a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	abstractGroupControllerGroupWithMembers := *openapiclient.NewAbstractGroupControllerGroupWithMembers("Name_example", false) // AbstractGroupControllerGroupWithMembers | The group

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.CreateGroup(context.Background(), tenant).AbstractGroupControllerGroupWithMembers(abstractGroupControllerGroupWithMembers).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.CreateGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateGroup`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.CreateGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **abstractGroupControllerGroupWithMembers** | [**AbstractGroupControllerGroupWithMembers**](AbstractGroupControllerGroupWithMembers.md) | The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateGroupWithResourceTenantasSuperAdmin

> Group CreateGroupWithResourceTenantasSuperAdmin(ctx, resourceTenant).AbstractGroupControllerGroupWithMembers(abstractGroupControllerGroupWithMembers).Execute()

Create a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	resourceTenant := "resourceTenant_example" // string | 
	abstractGroupControllerGroupWithMembers := *openapiclient.NewAbstractGroupControllerGroupWithMembers("Name_example", false) // AbstractGroupControllerGroupWithMembers | The group

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.CreateGroupWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).AbstractGroupControllerGroupWithMembers(abstractGroupControllerGroupWithMembers).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.CreateGroupWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateGroupWithResourceTenantasSuperAdmin`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.CreateGroupWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateGroupWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **abstractGroupControllerGroupWithMembers** | [**AbstractGroupControllerGroupWithMembers**](AbstractGroupControllerGroupWithMembers.md) | The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateGroupasSuperAdmin

> Group CreateGroupasSuperAdmin(ctx).AbstractGroupControllerGroupWithMembers(abstractGroupControllerGroupWithMembers).Execute()

Create a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	abstractGroupControllerGroupWithMembers := *openapiclient.NewAbstractGroupControllerGroupWithMembers("Name_example", false) // AbstractGroupControllerGroupWithMembers | The group

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.CreateGroupasSuperAdmin(context.Background()).AbstractGroupControllerGroupWithMembers(abstractGroupControllerGroupWithMembers).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.CreateGroupasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateGroupasSuperAdmin`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.CreateGroupasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateGroupasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **abstractGroupControllerGroupWithMembers** | [**AbstractGroupControllerGroupWithMembers**](AbstractGroupControllerGroupWithMembers.md) | The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteGroup

> DeleteGroup(ctx, id, tenant).Execute()

Delete a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.GroupsAPI.DeleteGroup(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.DeleteGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteGroupWithResourceTenantasSuperAdmin

> DeleteGroupWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

Delete a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.GroupsAPI.DeleteGroupWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.DeleteGroupWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteGroupWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteGroupasSuperAdmin

> DeleteGroupasSuperAdmin(ctx, id).Execute()

Delete a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.GroupsAPI.DeleteGroupasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.DeleteGroupasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteGroupasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteUserFromGroup

> ApiUser DeleteUserFromGroup(ctx, id, userId, tenant).Execute()

Delete a group for a user

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.DeleteUserFromGroup(context.Background(), id, userId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.DeleteUserFromGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteUserFromGroup`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.DeleteUserFromGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteUserFromGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteUserFromGroupWithResourceTenantasSuperAdmin

> ApiUser DeleteUserFromGroupWithResourceTenantasSuperAdmin(ctx, id, userId, resourceTenant).Execute()

Delete a group for a user

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.DeleteUserFromGroupWithResourceTenantasSuperAdmin(context.Background(), id, userId, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.DeleteUserFromGroupWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteUserFromGroupWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.DeleteUserFromGroupWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteUserFromGroupWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteUserFromGroupasSuperAdmin

> ApiUser DeleteUserFromGroupasSuperAdmin(ctx, id, userId).Execute()

Delete a group for a user

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.DeleteUserFromGroupasSuperAdmin(context.Background(), id, userId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.DeleteUserFromGroupasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteUserFromGroupasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.DeleteUserFromGroupasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteUserFromGroupasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetGroup

> Group GetGroup(ctx, id, tenant).Execute()

Get a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.GetGroup(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.GetGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetGroup`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.GetGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetGroupWithResourceTenantasSuperAdmin

> Group GetGroupWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

Get a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.GetGroupWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.GetGroupWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetGroupWithResourceTenantasSuperAdmin`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.GetGroupWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetGroupWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetGroupasSuperAdmin

> Group GetGroupasSuperAdmin(ctx, id).Execute()

Get a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.GetGroupasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.GetGroupasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetGroupasSuperAdmin`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.GetGroupasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetGroupasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListGroupIds

> []Group ListGroupIds(ctx, tenant).ApiIds(apiIds).Execute()

List groups by ids

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	apiIds := *openapiclient.NewApiIds() // ApiIds | The ids that must be present on results

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.ListGroupIds(context.Background(), tenant).ApiIds(apiIds).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.ListGroupIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListGroupIds`: []Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.ListGroupIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListGroupIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiIds** | [**ApiIds**](ApiIds.md) | The ids that must be present on results | 

### Return type

[**[]Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListGroupIdsWithResourceTenantasSuperAdmin

> []Group ListGroupIdsWithResourceTenantasSuperAdmin(ctx, resourceTenant).ApiIds(apiIds).Execute()

List groups by ids

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	resourceTenant := "resourceTenant_example" // string | 
	apiIds := *openapiclient.NewApiIds() // ApiIds | The ids that must be present on results

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.ListGroupIdsWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).ApiIds(apiIds).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.ListGroupIdsWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListGroupIdsWithResourceTenantasSuperAdmin`: []Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.ListGroupIdsWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListGroupIdsWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiIds** | [**ApiIds**](ApiIds.md) | The ids that must be present on results | 

### Return type

[**[]Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListGroupIdsasSuperAdmin

> []Group ListGroupIdsasSuperAdmin(ctx).ApiIds(apiIds).Execute()

List groups by ids

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	apiIds := *openapiclient.NewApiIds() // ApiIds | The ids that must be present on results

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.ListGroupIdsasSuperAdmin(context.Background()).ApiIds(apiIds).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.ListGroupIdsasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListGroupIdsasSuperAdmin`: []Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.ListGroupIdsasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiListGroupIdsasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiIds** | [**ApiIds**](ApiIds.md) | The ids that must be present on results | 

### Return type

[**[]Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchGroupMembers

> PagedResultsApiUser SearchGroupMembers(ctx, id, tenant).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for users in a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	tenant := "tenant_example" // string | 
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SearchGroupMembers(context.Background(), id, tenant).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SearchGroupMembers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchGroupMembers`: PagedResultsApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SearchGroupMembers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchGroupMembersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchGroupMembersWithResourceTenantasSuperAdmin

> PagedResultsApiUser SearchGroupMembersWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for users in a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	resourceTenant := "resourceTenant_example" // string | 
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SearchGroupMembersWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SearchGroupMembersWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchGroupMembersWithResourceTenantasSuperAdmin`: PagedResultsApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SearchGroupMembersWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchGroupMembersWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchGroupMembersasSuperAdmin

> PagedResultsApiUser SearchGroupMembersasSuperAdmin(ctx, id).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for users in a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SearchGroupMembersasSuperAdmin(context.Background(), id).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SearchGroupMembersasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchGroupMembersasSuperAdmin`: PagedResultsApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SearchGroupMembersasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchGroupMembersasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsApiUser**](PagedResultsApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchGroups

> PagedResultsGroup SearchGroups(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for groups

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	tenant := "tenant_example" // string | 
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SearchGroups(context.Background(), tenant).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SearchGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchGroups`: PagedResultsGroup
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SearchGroups`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchGroupsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsGroup**](PagedResultsGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchGroupsWithResourceTenantasSuperAdmin

> PagedResultsGroup SearchGroupsWithResourceTenantasSuperAdmin(ctx, resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for groups

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	resourceTenant := "resourceTenant_example" // string | 
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SearchGroupsWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SearchGroupsWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchGroupsWithResourceTenantasSuperAdmin`: PagedResultsGroup
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SearchGroupsWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchGroupsWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsGroup**](PagedResultsGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchGroupsasSuperAdmin

> PagedResultsGroup SearchGroupsasSuperAdmin(ctx).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for groups

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SearchGroupsasSuperAdmin(context.Background()).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SearchGroupsasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchGroupsasSuperAdmin`: PagedResultsGroup
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SearchGroupsasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSearchGroupsasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsGroup**](PagedResultsGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetUserMembershipForGroup

> ApiUser SetUserMembershipForGroup(ctx, id, userId, tenant).Membership(membership).Execute()

Set the membership type of a user in a group



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id
	membership := openapiclient.AbstractUser.GroupIdentifier.Membership("OWNER") // AbstractUserGroupIdentifierMembership | The membership type
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SetUserMembershipForGroup(context.Background(), id, userId, tenant).Membership(membership).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SetUserMembershipForGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetUserMembershipForGroup`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SetUserMembershipForGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetUserMembershipForGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **membership** | [**AbstractUserGroupIdentifierMembership**](AbstractUserGroupIdentifierMembership.md) | The membership type | 


### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetUserMembershipForGroupWithResourceTenantasSuperAdmin

> ApiUser SetUserMembershipForGroupWithResourceTenantasSuperAdmin(ctx, id, userId, resourceTenant).Membership(membership).Execute()

Set the membership type of a user in a group



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id
	membership := openapiclient.AbstractUser.GroupIdentifier.Membership("OWNER") // AbstractUserGroupIdentifierMembership | The membership type
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SetUserMembershipForGroupWithResourceTenantasSuperAdmin(context.Background(), id, userId, resourceTenant).Membership(membership).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SetUserMembershipForGroupWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetUserMembershipForGroupWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SetUserMembershipForGroupWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetUserMembershipForGroupWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **membership** | [**AbstractUserGroupIdentifierMembership**](AbstractUserGroupIdentifierMembership.md) | The membership type | 


### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetUserMembershipForGroupasSuperAdmin

> ApiUser SetUserMembershipForGroupasSuperAdmin(ctx, id, userId).Membership(membership).Execute()

Set the membership type of a user in a group



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	userId := "userId_example" // string | The user id
	membership := openapiclient.AbstractUser.GroupIdentifier.Membership("OWNER") // AbstractUserGroupIdentifierMembership | The membership type

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SetUserMembershipForGroupasSuperAdmin(context.Background(), id, userId).Membership(membership).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SetUserMembershipForGroupasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetUserMembershipForGroupasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SetUserMembershipForGroupasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**userId** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetUserMembershipForGroupasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **membership** | [**AbstractUserGroupIdentifierMembership**](AbstractUserGroupIdentifierMembership.md) | The membership type | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateGroup

> Group UpdateGroup(ctx, id, tenant).Group(group).Execute()

Update a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	tenant := "tenant_example" // string | 
	group := *openapiclient.NewGroup("Name_example", false) // Group | The group

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.UpdateGroup(context.Background(), id, tenant).Group(group).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.UpdateGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateGroup`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.UpdateGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **group** | [**Group**](Group.md) | The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateGroupWithResourceTenantasSuperAdmin

> Group UpdateGroupWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Group(group).Execute()

Update a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	resourceTenant := "resourceTenant_example" // string | 
	group := *openapiclient.NewGroup("Name_example", false) // Group | The group

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.UpdateGroupWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Group(group).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.UpdateGroupWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateGroupWithResourceTenantasSuperAdmin`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.UpdateGroupWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateGroupWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **group** | [**Group**](Group.md) | The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateGroupasSuperAdmin

> Group UpdateGroupasSuperAdmin(ctx, id).Group(group).Execute()

Update a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	id := "id_example" // string | The group id
	group := *openapiclient.NewGroup("Name_example", false) // Group | The group

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.UpdateGroupasSuperAdmin(context.Background(), id).Group(group).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.UpdateGroupasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateGroupasSuperAdmin`: Group
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.UpdateGroupasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateGroupasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **group** | [**Group**](Group.md) | The group | 

### Return type

[**Group**](Group.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

