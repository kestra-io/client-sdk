# \GroupsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AddUserToGroup**](GroupsAPI.md#AddUserToGroup) | **Put** /api/v1/{tenant}/groups/{id}/members/{userId} | Add a user to a group
[**AutocompleteGroups**](GroupsAPI.md#AutocompleteGroups) | **Post** /api/v1/{tenant}/groups/autocomplete | List groups for autocomplete
[**CreateGroup**](GroupsAPI.md#CreateGroup) | **Post** /api/v1/{tenant}/groups | Create a group
[**DeleteGroup**](GroupsAPI.md#DeleteGroup) | **Delete** /api/v1/{tenant}/groups/{id} | Delete a group
[**DeleteUserFromGroup**](GroupsAPI.md#DeleteUserFromGroup) | **Delete** /api/v1/{tenant}/groups/{id}/members/{userId} | Remove a user from a group
[**Group**](GroupsAPI.md#Group) | **Get** /api/v1/{tenant}/groups/{id} | Retrieve a group
[**ListGroupIds**](GroupsAPI.md#ListGroupIds) | **Post** /api/v1/{tenant}/groups/ids | List groups by ids
[**SearchGroupMembers**](GroupsAPI.md#SearchGroupMembers) | **Get** /api/v1/{tenant}/groups/{id}/members | Search for users in a group
[**SearchGroups**](GroupsAPI.md#SearchGroups) | **Get** /api/v1/{tenant}/groups/search | Search for groups
[**SetUserMembershipForGroup**](GroupsAPI.md#SetUserMembershipForGroup) | **Put** /api/v1/{tenant}/groups/{id}/members/membership/{userId} | Update a user&#39;s membership type in a group
[**UpdateGroup**](GroupsAPI.md#UpdateGroup) | **Put** /api/v1/{tenant}/groups/{id} | Update a group



## AddUserToGroup

> IAMGroupControllerApiGroupMember AddUserToGroup(ctx, id, userId, tenant).Execute()

Add a user to a group



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	id := "id_example" // string | The ID of the group
	userId := "userId_example" // string | The ID of the user to add to the group
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.AddUserToGroup(context.Background(), id, userId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.AddUserToGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AddUserToGroup`: IAMGroupControllerApiGroupMember
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.AddUserToGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of the group | 
**userId** | **string** | The ID of the user to add to the group | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAddUserToGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AutocompleteGroups

> []ApiGroupSummary AutocompleteGroups(ctx, tenant).ApiAutocomplete(apiAutocomplete).Execute()

List groups for autocomplete

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	// response from `AutocompleteGroups`: []ApiGroupSummary
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

[**[]ApiGroupSummary**](ApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateGroup

> IAMGroupControllerApiGroupDetail CreateGroup(ctx, tenant).IAMGroupControllerApiCreateGroupRequest(iAMGroupControllerApiCreateGroupRequest).Execute()

Create a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	iAMGroupControllerApiCreateGroupRequest := *openapiclient.NewIAMGroupControllerApiCreateGroupRequest("Name_example") // IAMGroupControllerApiCreateGroupRequest | The group

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.CreateGroup(context.Background(), tenant).IAMGroupControllerApiCreateGroupRequest(iAMGroupControllerApiCreateGroupRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.CreateGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateGroup`: IAMGroupControllerApiGroupDetail
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

 **iAMGroupControllerApiCreateGroupRequest** | [**IAMGroupControllerApiCreateGroupRequest**](IAMGroupControllerApiCreateGroupRequest.md) | The group | 

### Return type

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

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
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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


## DeleteUserFromGroup

> IAMGroupControllerApiGroupMember DeleteUserFromGroup(ctx, id, userId, tenant).Execute()

Remove a user from a group



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	id := "id_example" // string | The ID of the group
	userId := "userId_example" // string | The ID of the user to remove from the group
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.DeleteUserFromGroup(context.Background(), id, userId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.DeleteUserFromGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteUserFromGroup`: IAMGroupControllerApiGroupMember
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.DeleteUserFromGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of the group | 
**userId** | **string** | The ID of the user to remove from the group | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteUserFromGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## Group

> IAMGroupControllerApiGroupDetail Group(ctx, id, tenant).Execute()

Retrieve a group



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	id := "id_example" // string | The group id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.Group(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.Group``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `Group`: IAMGroupControllerApiGroupDetail
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.Group`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The group id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListGroupIds

> []ApiGroupSummary ListGroupIds(ctx, tenant).ApiIds(apiIds).Execute()

List groups by ids

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	// response from `ListGroupIds`: []ApiGroupSummary
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

[**[]ApiGroupSummary**](ApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchGroupMembers

> PagedResultsIAMGroupControllerApiGroupMember SearchGroupMembers(ctx, id, tenant).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for users in a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	// response from `SearchGroupMembers`: PagedResultsIAMGroupControllerApiGroupMember
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

[**PagedResultsIAMGroupControllerApiGroupMember**](PagedResultsIAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchGroups

> PagedResultsApiGroupSummary SearchGroups(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for groups

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
	// response from `SearchGroups`: PagedResultsApiGroupSummary
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

[**PagedResultsApiGroupSummary**](PagedResultsApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetUserMembershipForGroup

> IAMGroupControllerApiGroupMember SetUserMembershipForGroup(ctx, id, userId, tenant).Membership(membership).Execute()

Update a user's membership type in a group



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	id := "id_example" // string | The ID of the group
	userId := "userId_example" // string | The ID of the user whose membership is being updated
	membership := openapiclient.GroupIdentifier.Membership("OWNER") // GroupIdentifierMembership | The new membership type to assign to the user.
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.SetUserMembershipForGroup(context.Background(), id, userId, tenant).Membership(membership).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.SetUserMembershipForGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetUserMembershipForGroup`: IAMGroupControllerApiGroupMember
	fmt.Fprintf(os.Stdout, "Response from `GroupsAPI.SetUserMembershipForGroup`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of the group | 
**userId** | **string** | The ID of the user whose membership is being updated | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetUserMembershipForGroupRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **membership** | [**GroupIdentifierMembership**](GroupIdentifierMembership.md) | The new membership type to assign to the user. | 


### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateGroup

> IAMGroupControllerApiGroupDetail UpdateGroup(ctx, id, tenant).IAMGroupControllerApiUpdateGroupRequest(iAMGroupControllerApiUpdateGroupRequest).Execute()

Update a group

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	id := "id_example" // string | The group id
	tenant := "tenant_example" // string | 
	iAMGroupControllerApiUpdateGroupRequest := *openapiclient.NewIAMGroupControllerApiUpdateGroupRequest("Name_example") // IAMGroupControllerApiUpdateGroupRequest | The group

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.GroupsAPI.UpdateGroup(context.Background(), id, tenant).IAMGroupControllerApiUpdateGroupRequest(iAMGroupControllerApiUpdateGroupRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `GroupsAPI.UpdateGroup``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateGroup`: IAMGroupControllerApiGroupDetail
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


 **iAMGroupControllerApiUpdateGroupRequest** | [**IAMGroupControllerApiUpdateGroupRequest**](IAMGroupControllerApiUpdateGroupRequest.md) | The group | 

### Return type

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

