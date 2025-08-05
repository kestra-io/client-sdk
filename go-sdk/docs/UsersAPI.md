# \UsersAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AutocompleteUsers**](UsersAPI.md#AutocompleteUsers) | **Post** /api/v1/{tenant}/tenant-access/autocomplete | List users for autocomplete
[**CreateApiTokensForUser**](UsersAPI.md#CreateApiTokensForUser) | **Post** /api/v1/users/{id}/api-tokens | Create new API Token for a specific user
[**CreateApiTokensForUser1**](UsersAPI.md#CreateApiTokensForUser1) | **Post** /api/v1/{tenant}/service-accounts/{id}/api-tokens | Create new API Token for a specific user
[**CreateUser**](UsersAPI.md#CreateUser) | **Post** /api/v1/users | Create a new user account
[**DeleteApiToken**](UsersAPI.md#DeleteApiToken) | **Delete** /api/v1/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**DeleteApiToken1**](UsersAPI.md#DeleteApiToken1) | **Delete** /api/v1/{tenant}/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**DeleteRefreshToken**](UsersAPI.md#DeleteRefreshToken) | **Delete** /api/v1/users/{id}/refresh-token | Delete a user refresh token
[**DeleteUser**](UsersAPI.md#DeleteUser) | **Delete** /api/v1/users/{id} | Delete a user
[**DeleteUserAuthMethod**](UsersAPI.md#DeleteUserAuthMethod) | **Delete** /api/v1/users/{id}/auths/{auth} | Update user password
[**GetUser**](UsersAPI.md#GetUser) | **Get** /api/v1/users/{id} | Get a user
[**Impersonate**](UsersAPI.md#Impersonate) | **Post** /api/v1/users/{id}/impersonate | Impersonate a user
[**ListApiTokens**](UsersAPI.md#ListApiTokens) | **Get** /api/v1/users/{id}/api-tokens | List API tokens for a specific user
[**ListApiTokens1**](UsersAPI.md#ListApiTokens1) | **Get** /api/v1/{tenant}/service-accounts/{id}/api-tokens | List API tokens for a specific user
[**ListUsers**](UsersAPI.md#ListUsers) | **Get** /api/v1/users | Retrieve users
[**PatchUser**](UsersAPI.md#PatchUser) | **Patch** /api/v1/users/{id} | Update user details
[**PatchUserDemo**](UsersAPI.md#PatchUserDemo) | **Patch** /api/v1/users/{id}/restricted | Update user demo
[**PatchUserPassword**](UsersAPI.md#PatchUserPassword) | **Patch** /api/v1/users/{id}/password | Update user password
[**PatchUserSuperAdmin**](UsersAPI.md#PatchUserSuperAdmin) | **Patch** /api/v1/users/{id}/superadmin | Update user superadmin privileges
[**UpdateCurrentUserPassword**](UsersAPI.md#UpdateCurrentUserPassword) | **Put** /api/v1/me/password | Update authenticated user password
[**UpdateUser**](UsersAPI.md#UpdateUser) | **Put** /api/v1/users/{id} | Update a user account
[**UpdateUserGroups**](UsersAPI.md#UpdateUserGroups) | **Put** /api/v1/{tenant}/users/{id}/groups | Update the list of groups a user belongs to for the given tenant



## AutocompleteUsers

> []IAMTenantAccessControllerApiUserTenantAccess AutocompleteUsers(ctx, tenant).IAMTenantAccessControllerUserApiAutocomplete(iAMTenantAccessControllerUserApiAutocomplete).Execute()

List users for autocomplete

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
	iAMTenantAccessControllerUserApiAutocomplete := *openapiclient.NewIAMTenantAccessControllerUserApiAutocomplete() // IAMTenantAccessControllerUserApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.AutocompleteUsers(context.Background(), tenant).IAMTenantAccessControllerUserApiAutocomplete(iAMTenantAccessControllerUserApiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.AutocompleteUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteUsers`: []IAMTenantAccessControllerApiUserTenantAccess
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.AutocompleteUsers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMTenantAccessControllerUserApiAutocomplete** | [**IAMTenantAccessControllerUserApiAutocomplete**](IAMTenantAccessControllerUserApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]IAMTenantAccessControllerApiUserTenantAccess**](IAMTenantAccessControllerApiUserTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateApiTokensForUser

> CreateApiTokenResponse CreateApiTokensForUser(ctx, id).CreateApiTokenRequest(createApiTokenRequest).Execute()

Create new API Token for a specific user



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
	id := "id_example" // string | The user id
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example") // CreateApiTokenRequest | The create api-token request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateApiTokensForUser(context.Background(), id).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateApiTokensForUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokensForUser`: CreateApiTokenResponse
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateApiTokensForUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokensForUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md) | The create api-token request | 

### Return type

[**CreateApiTokenResponse**](CreateApiTokenResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateApiTokensForUser1

> map[string]interface{} CreateApiTokensForUser1(ctx, id, tenant).CreateApiTokenRequest(createApiTokenRequest).Execute()

Create new API Token for a specific user

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
	id := "id_example" // string | The user id
	tenant := "tenant_example" // string | 
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example") // CreateApiTokenRequest | The create api-token request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateApiTokensForUser1(context.Background(), id, tenant).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateApiTokensForUser1``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokensForUser1`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateApiTokensForUser1`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokensForUser1Request struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md) | The create api-token request | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateUser

> CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(iAMUserControllerApiCreateOrUpdateUserRequest).Execute()

Create a new user account



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
	iAMUserControllerApiCreateOrUpdateUserRequest := *openapiclient.NewIAMUserControllerApiCreateOrUpdateUserRequest("Email_example") // IAMUserControllerApiCreateOrUpdateUserRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.CreateUser(context.Background()).IAMUserControllerApiCreateOrUpdateUserRequest(iAMUserControllerApiCreateOrUpdateUserRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **iAMUserControllerApiCreateOrUpdateUserRequest** | [**IAMUserControllerApiCreateOrUpdateUserRequest**](IAMUserControllerApiCreateOrUpdateUserRequest.md) |  | 

### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteApiToken

> DeleteApiToken(ctx, id, tokenId).Execute()

Delete an API Token for specific user and token id



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
	id := "id_example" // string | The user id
	tokenId := "tokenId_example" // string | The token id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.DeleteApiToken(context.Background(), id, tokenId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteApiToken``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tokenId** | **string** | The token id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteApiTokenRequest struct via the builder pattern


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


## DeleteApiToken1

> map[string]interface{} DeleteApiToken1(ctx, id, tokenId, tenant).Execute()

Delete an API Token for specific user and token id

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
	id := "id_example" // string | The user id
	tokenId := "tokenId_example" // string | The token id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.DeleteApiToken1(context.Background(), id, tokenId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteApiToken1``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApiToken1`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteApiToken1`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tokenId** | **string** | The token id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteApiToken1Request struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteRefreshToken

> DeleteRefreshToken(ctx, id).Execute()

Delete a user refresh token

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
	id := "id_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.DeleteRefreshToken(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteRefreshToken``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteRefreshTokenRequest struct via the builder pattern


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


## DeleteUser

> DeleteUser(ctx, id).Execute()

Delete a user



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
	id := "id_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.DeleteUser(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteUserRequest struct via the builder pattern


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


## DeleteUserAuthMethod

> IAMUserControllerApiUser DeleteUserAuthMethod(ctx, id, auth).Execute()

Update user password



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
	id := "id_example" // string | The user id
	auth := "auth_example" // string | The user auth method id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.DeleteUserAuthMethod(context.Background(), id, auth).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteUserAuthMethod``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteUserAuthMethod`: IAMUserControllerApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteUserAuthMethod`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**auth** | **string** | The user auth method id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteUserAuthMethodRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetUser

> IAMUserControllerApiUser GetUser(ctx, id).Execute()

Get a user



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
	id := "id_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.GetUser(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.GetUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetUser`: IAMUserControllerApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.GetUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## Impersonate

> map[string]interface{} Impersonate(ctx, id).Execute()

Impersonate a user



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
	id := "id_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.Impersonate(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.Impersonate``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `Impersonate`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.Impersonate`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiImpersonateRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListApiTokens

> map[string]interface{} ListApiTokens(ctx, id).Execute()

List API tokens for a specific user



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
	id := "id_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.ListApiTokens(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.ListApiTokens``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListApiTokens`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.ListApiTokens`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiListApiTokensRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListApiTokens1

> map[string]interface{} ListApiTokens1(ctx, id, tenant).Execute()

List API tokens for a specific user

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
	id := "id_example" // string | The user id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.ListApiTokens1(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.ListApiTokens1``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListApiTokens1`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.ListApiTokens1`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListApiTokens1Request struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListUsers

> PagedResultsIAMUserControllerApiUserSummary ListUsers(ctx).Page(page).Size(size).Q(q).Sort(sort).Execute()

Retrieve users

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
	resp, r, err := apiClient.UsersAPI.ListUsers(context.Background()).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.ListUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListUsers`: PagedResultsIAMUserControllerApiUserSummary
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.ListUsers`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiListUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsIAMUserControllerApiUserSummary**](PagedResultsIAMUserControllerApiUserSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchUser

> IAMUserControllerApiUser PatchUser(ctx, id).MeControllerApiUserDetailsRequest(meControllerApiUserDetailsRequest).Execute()

Update user details



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
	id := "id_example" // string | The user id
	meControllerApiUserDetailsRequest := *openapiclient.NewMeControllerApiUserDetailsRequest() // MeControllerApiUserDetailsRequest | The user details

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.PatchUser(context.Background(), id).MeControllerApiUserDetailsRequest(meControllerApiUserDetailsRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.PatchUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PatchUser`: IAMUserControllerApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.PatchUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiPatchUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **meControllerApiUserDetailsRequest** | [**MeControllerApiUserDetailsRequest**](MeControllerApiUserDetailsRequest.md) | The user details | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchUserDemo

> PatchUserDemo(ctx, id).IAMUserControllerApiPatchRestrictedRequest(iAMUserControllerApiPatchRestrictedRequest).Execute()

Update user demo



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
	id := "id_example" // string | The user id
	iAMUserControllerApiPatchRestrictedRequest := *openapiclient.NewIAMUserControllerApiPatchRestrictedRequest(false) // IAMUserControllerApiPatchRestrictedRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.PatchUserDemo(context.Background(), id).IAMUserControllerApiPatchRestrictedRequest(iAMUserControllerApiPatchRestrictedRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.PatchUserDemo``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiPatchUserDemoRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMUserControllerApiPatchRestrictedRequest** | [**IAMUserControllerApiPatchRestrictedRequest**](IAMUserControllerApiPatchRestrictedRequest.md) |  | 

### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchUserPassword

> map[string]interface{} PatchUserPassword(ctx, id).IAMUserControllerApiPatchUserPasswordRequest(iAMUserControllerApiPatchUserPasswordRequest).Execute()

Update user password



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
	id := "id_example" // string | The user id
	iAMUserControllerApiPatchUserPasswordRequest := *openapiclient.NewIAMUserControllerApiPatchUserPasswordRequest("Password_example") // IAMUserControllerApiPatchUserPasswordRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.PatchUserPassword(context.Background(), id).IAMUserControllerApiPatchUserPasswordRequest(iAMUserControllerApiPatchUserPasswordRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.PatchUserPassword``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PatchUserPassword`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.PatchUserPassword`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiPatchUserPasswordRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMUserControllerApiPatchUserPasswordRequest** | [**IAMUserControllerApiPatchUserPasswordRequest**](IAMUserControllerApiPatchUserPasswordRequest.md) |  | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchUserSuperAdmin

> PatchUserSuperAdmin(ctx, id).IAMUserControllerApiPatchSuperAdminRequest(iAMUserControllerApiPatchSuperAdminRequest).Execute()

Update user superadmin privileges



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
	id := "id_example" // string | The user id
	iAMUserControllerApiPatchSuperAdminRequest := *openapiclient.NewIAMUserControllerApiPatchSuperAdminRequest(false) // IAMUserControllerApiPatchSuperAdminRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.PatchUserSuperAdmin(context.Background(), id).IAMUserControllerApiPatchSuperAdminRequest(iAMUserControllerApiPatchSuperAdminRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.PatchUserSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiPatchUserSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMUserControllerApiPatchSuperAdminRequest** | [**IAMUserControllerApiPatchSuperAdminRequest**](IAMUserControllerApiPatchSuperAdminRequest.md) |  | 

### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateCurrentUserPassword

> map[string]interface{} UpdateCurrentUserPassword(ctx).MeControllerApiUpdatePasswordRequest(meControllerApiUpdatePasswordRequest).Execute()

Update authenticated user password



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
	meControllerApiUpdatePasswordRequest := *openapiclient.NewMeControllerApiUpdatePasswordRequest() // MeControllerApiUpdatePasswordRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateCurrentUserPassword(context.Background()).MeControllerApiUpdatePasswordRequest(meControllerApiUpdatePasswordRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateCurrentUserPassword``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateCurrentUserPassword`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateCurrentUserPassword`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiUpdateCurrentUserPasswordRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **meControllerApiUpdatePasswordRequest** | [**MeControllerApiUpdatePasswordRequest**](MeControllerApiUpdatePasswordRequest.md) |  | 

### Return type

**map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateUser

> IAMUserControllerApiUser UpdateUser(ctx, id).IAMUserControllerApiCreateOrUpdateUserRequest(iAMUserControllerApiCreateOrUpdateUserRequest).Execute()

Update a user account



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
	id := "id_example" // string | The user id
	iAMUserControllerApiCreateOrUpdateUserRequest := *openapiclient.NewIAMUserControllerApiCreateOrUpdateUserRequest("Email_example") // IAMUserControllerApiCreateOrUpdateUserRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateUser(context.Background(), id).IAMUserControllerApiCreateOrUpdateUserRequest(iAMUserControllerApiCreateOrUpdateUserRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateUser`: IAMUserControllerApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMUserControllerApiCreateOrUpdateUserRequest** | [**IAMUserControllerApiCreateOrUpdateUserRequest**](IAMUserControllerApiCreateOrUpdateUserRequest.md) |  | 

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateUserGroups

> UpdateUserGroups(ctx, id, tenant).IAMUserGroupControllerApiUpdateUserGroupsRequest(iAMUserGroupControllerApiUpdateUserGroupsRequest).Execute()

Update the list of groups a user belongs to for the given tenant

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
	id := "id_example" // string | The user ID
	tenant := "tenant_example" // string | 
	iAMUserGroupControllerApiUpdateUserGroupsRequest := *openapiclient.NewIAMUserGroupControllerApiUpdateUserGroupsRequest() // IAMUserGroupControllerApiUpdateUserGroupsRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.UpdateUserGroups(context.Background(), id, tenant).IAMUserGroupControllerApiUpdateUserGroupsRequest(iAMUserGroupControllerApiUpdateUserGroupsRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateUserGroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user ID | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateUserGroupsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **iAMUserGroupControllerApiUpdateUserGroupsRequest** | [**IAMUserGroupControllerApiUpdateUserGroupsRequest**](IAMUserGroupControllerApiUpdateUserGroupsRequest.md) |  | 

### Return type

 (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

