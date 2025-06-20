# \UsersAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AutocompleteUsers**](UsersAPI.md#AutocompleteUsers) | **Post** /api/v1/{tenant}/users/autocomplete | List users for autocomplete
[**AutocompleteUsersWithResourceTenantasSuperAdmin**](UsersAPI.md#AutocompleteUsersWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/users/autocomplete | List users for autocomplete
[**AutocompleteUsersasSuperAdmin**](UsersAPI.md#AutocompleteUsersasSuperAdmin) | **Post** /api/v1/tenants/users/autocomplete | List users for autocomplete
[**CreateApiTokensForUser**](UsersAPI.md#CreateApiTokensForUser) | **Post** /api/v1/{tenant}/users/{id}/api-tokens | Create new API Token for a specific user
[**CreateApiTokensForUserWithResourceTenantasSuperAdmin**](UsersAPI.md#CreateApiTokensForUserWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/users/{id}/api-tokens | Create new API Token for a specific user
[**CreateApiTokensForUserasSuperAdmin**](UsersAPI.md#CreateApiTokensForUserasSuperAdmin) | **Post** /api/v1/tenants/users/{id}/api-tokens | Create new API Token for a specific user
[**CreateServiceAccount**](UsersAPI.md#CreateServiceAccount) | **Post** /api/v1/{tenant}/users/service-accounts | Create a user service account
[**CreateServiceAccountWithResourceTenantasSuperAdmin**](UsersAPI.md#CreateServiceAccountWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/users/service-accounts | Create a user service account
[**CreateServiceAccountasSuperAdmin**](UsersAPI.md#CreateServiceAccountasSuperAdmin) | **Post** /api/v1/tenants/users/service-accounts | Create a user service account
[**CreateUser**](UsersAPI.md#CreateUser) | **Post** /api/v1/{tenant}/users | Create a standard user
[**CreateUserBasicAuth**](UsersAPI.md#CreateUserBasicAuth) | **Put** /api/v1/{tenant}/users/{id}/password | Create a basic auth password for a standard user
[**CreateUserBasicAuthWithResourceTenantasSuperAdmin**](UsersAPI.md#CreateUserBasicAuthWithResourceTenantasSuperAdmin) | **Put** /api/v1/tenants/{resourceTenant}/users/{id}/password | Create a basic auth password for a standard user
[**CreateUserBasicAuthasSuperAdmin**](UsersAPI.md#CreateUserBasicAuthasSuperAdmin) | **Put** /api/v1/tenants/users/{id}/password | Create a basic auth password for a standard user
[**CreateUserWithResourceTenantasSuperAdmin**](UsersAPI.md#CreateUserWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/users | Create a standard user
[**CreateUserasSuperAdmin**](UsersAPI.md#CreateUserasSuperAdmin) | **Post** /api/v1/tenants/users | Create a standard user
[**DeleteApiToken**](UsersAPI.md#DeleteApiToken) | **Delete** /api/v1/{tenant}/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**DeleteApiTokenWithResourceTenantasSuperAdmin**](UsersAPI.md#DeleteApiTokenWithResourceTenantasSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**DeleteApiTokenasSuperAdmin**](UsersAPI.md#DeleteApiTokenasSuperAdmin) | **Delete** /api/v1/tenants/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id
[**DeleteAuth**](UsersAPI.md#DeleteAuth) | **Delete** /api/v1/{tenant}/users/{id}/auths/{uid} | Delete an Auth for a user
[**DeleteAuthWithResourceTenantasSuperAdmin**](UsersAPI.md#DeleteAuthWithResourceTenantasSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/users/{id}/auths/{uid} | Delete an Auth for a user
[**DeleteAuthasSuperAdmin**](UsersAPI.md#DeleteAuthasSuperAdmin) | **Delete** /api/v1/tenants/users/{id}/auths/{uid} | Delete an Auth for a user
[**DeleteRefreshToken**](UsersAPI.md#DeleteRefreshToken) | **Delete** /api/v1/{tenant}/users/{id}/refresh-token | Delete a user refresh token
[**DeleteRefreshTokenWithResourceTenantasSuperAdmin**](UsersAPI.md#DeleteRefreshTokenWithResourceTenantasSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/users/{id}/refresh-token | Delete a user refresh token
[**DeleteRefreshTokenasSuperAdmin**](UsersAPI.md#DeleteRefreshTokenasSuperAdmin) | **Delete** /api/v1/tenants/users/{id}/refresh-token | Delete a user refresh token
[**DeleteUser**](UsersAPI.md#DeleteUser) | **Delete** /api/v1/{tenant}/users/{id} | Delete a user
[**DeleteUserWithResourceTenantasSuperAdmin**](UsersAPI.md#DeleteUserWithResourceTenantasSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/users/{id} | Delete a user
[**DeleteUserasSuperAdmin**](UsersAPI.md#DeleteUserasSuperAdmin) | **Delete** /api/v1/tenants/users/{id} | Delete a user
[**FindAllForAllTenants**](UsersAPI.md#FindAllForAllTenants) | **Get** /api/v1/tenants/users/instance | Get all users in the instance across all tenantd
[**FindAllForAllTenantsWithResourceTenant**](UsersAPI.md#FindAllForAllTenantsWithResourceTenant) | **Get** /api/v1/tenants/{resourceTenant}/users/instance | Get all users in the instance across all tenantd
[**GetUser**](UsersAPI.md#GetUser) | **Get** /api/v1/{tenant}/users/{id} | Get a user
[**GetUserWithResourceTenantasSuperAdmin**](UsersAPI.md#GetUserWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/users/{id} | Get a user
[**GetUserasSuperAdmin**](UsersAPI.md#GetUserasSuperAdmin) | **Get** /api/v1/tenants/users/{id} | Get a user
[**Impersonate**](UsersAPI.md#Impersonate) | **Post** /api/v1/tenants/users/{id}/impersonate | Impersonate a user
[**ImpersonateWithResourceTenant**](UsersAPI.md#ImpersonateWithResourceTenant) | **Post** /api/v1/tenants/{resourceTenant}/users/{id}/impersonate | Impersonate a user
[**ListApiTokens**](UsersAPI.md#ListApiTokens) | **Get** /api/v1/{tenant}/users/{id}/api-tokens | List all API Tokens for specific user
[**ListApiTokensWithResourceTenantasSuperAdmin**](UsersAPI.md#ListApiTokensWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/users/{id}/api-tokens | List all API Tokens for specific user
[**ListApiTokensasSuperAdmin**](UsersAPI.md#ListApiTokensasSuperAdmin) | **Get** /api/v1/tenants/users/{id}/api-tokens | List all API Tokens for specific user
[**SearchUsers**](UsersAPI.md#SearchUsers) | **Get** /api/v1/{tenant}/users/search | Search for users
[**SearchUsersWithResourceTenantasSuperAdmin**](UsersAPI.md#SearchUsersWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/users/search | Search for users
[**SearchUsersasSuperAdmin**](UsersAPI.md#SearchUsersasSuperAdmin) | **Get** /api/v1/tenants/users/search | Search for users
[**SetSuperAdmin**](UsersAPI.md#SetSuperAdmin) | **Put** /api/v1/tenants/users/{id}/set-superadmin | Update a user service account
[**SetSuperAdminWithResourceTenant**](UsersAPI.md#SetSuperAdminWithResourceTenant) | **Put** /api/v1/tenants/{resourceTenant}/users/{id}/set-superadmin | Update a user service account
[**UpdateCurrentUserPassword**](UsersAPI.md#UpdateCurrentUserPassword) | **Put** /api/v1/me/password | Update login password for the current user.
[**UpdateCurrentUserPasswordWithTenant**](UsersAPI.md#UpdateCurrentUserPasswordWithTenant) | **Put** /api/v1/{tenant}/me/password | Update login password for the current user.
[**UpdateServiceAccount**](UsersAPI.md#UpdateServiceAccount) | **Put** /api/v1/{tenant}/users/service-accounts/{id} | Update a user service account
[**UpdateServiceAccountWithResourceTenantasSuperAdmin**](UsersAPI.md#UpdateServiceAccountWithResourceTenantasSuperAdmin) | **Put** /api/v1/tenants/{resourceTenant}/users/service-accounts/{id} | Update a user service account
[**UpdateServiceAccountasSuperAdmin**](UsersAPI.md#UpdateServiceAccountasSuperAdmin) | **Put** /api/v1/tenants/users/service-accounts/{id} | Update a user service account
[**UpdateUser**](UsersAPI.md#UpdateUser) | **Put** /api/v1/{tenant}/users/{id} | Update a standard user
[**UpdateUserWithResourceTenantasSuperAdmin**](UsersAPI.md#UpdateUserWithResourceTenantasSuperAdmin) | **Put** /api/v1/tenants/{resourceTenant}/users/{id} | Update a standard user
[**UpdateUserasSuperAdmin**](UsersAPI.md#UpdateUserasSuperAdmin) | **Put** /api/v1/tenants/users/{id} | Update a standard user



## AutocompleteUsers

> []ApiUser AutocompleteUsers(ctx, tenant).AbstractUserControllerUserApiAutocomplete(abstractUserControllerUserApiAutocomplete).Execute()

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
	abstractUserControllerUserApiAutocomplete := *openapiclient.NewAbstractUserControllerUserApiAutocomplete() // AbstractUserControllerUserApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.AutocompleteUsers(context.Background(), tenant).AbstractUserControllerUserApiAutocomplete(abstractUserControllerUserApiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.AutocompleteUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteUsers`: []ApiUser
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

 **abstractUserControllerUserApiAutocomplete** | [**AbstractUserControllerUserApiAutocomplete**](AbstractUserControllerUserApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AutocompleteUsersWithResourceTenantasSuperAdmin

> []ApiUser AutocompleteUsersWithResourceTenantasSuperAdmin(ctx, resourceTenant).AbstractUserControllerUserApiAutocomplete(abstractUserControllerUserApiAutocomplete).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 
	abstractUserControllerUserApiAutocomplete := *openapiclient.NewAbstractUserControllerUserApiAutocomplete() // AbstractUserControllerUserApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.AutocompleteUsersWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).AbstractUserControllerUserApiAutocomplete(abstractUserControllerUserApiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.AutocompleteUsersWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteUsersWithResourceTenantasSuperAdmin`: []ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.AutocompleteUsersWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteUsersWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **abstractUserControllerUserApiAutocomplete** | [**AbstractUserControllerUserApiAutocomplete**](AbstractUserControllerUserApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AutocompleteUsersasSuperAdmin

> []ApiUser AutocompleteUsersasSuperAdmin(ctx).AbstractUserControllerUserApiAutocomplete(abstractUserControllerUserApiAutocomplete).Execute()

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
	abstractUserControllerUserApiAutocomplete := *openapiclient.NewAbstractUserControllerUserApiAutocomplete() // AbstractUserControllerUserApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.AutocompleteUsersasSuperAdmin(context.Background()).AbstractUserControllerUserApiAutocomplete(abstractUserControllerUserApiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.AutocompleteUsersasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteUsersasSuperAdmin`: []ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.AutocompleteUsersasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteUsersasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **abstractUserControllerUserApiAutocomplete** | [**AbstractUserControllerUserApiAutocomplete**](AbstractUserControllerUserApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateApiTokensForUser

> map[string]interface{} CreateApiTokensForUser(ctx, id, tenant).CreateApiTokenRequest(createApiTokenRequest).Execute()

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
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example", "MaxAge_example") // CreateApiTokenRequest | The create api-token request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateApiTokensForUser(context.Background(), id, tenant).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateApiTokensForUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokensForUser`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateApiTokensForUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokensForUserRequest struct via the builder pattern


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


## CreateApiTokensForUserWithResourceTenantasSuperAdmin

> map[string]interface{} CreateApiTokensForUserWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).CreateApiTokenRequest(createApiTokenRequest).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example", "MaxAge_example") // CreateApiTokenRequest | The create api-token request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateApiTokensForUserWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateApiTokensForUserWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokensForUserWithResourceTenantasSuperAdmin`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateApiTokensForUserWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokensForUserWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## CreateApiTokensForUserasSuperAdmin

> map[string]interface{} CreateApiTokensForUserasSuperAdmin(ctx, id).CreateApiTokenRequest(createApiTokenRequest).Execute()

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
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example", "MaxAge_example") // CreateApiTokenRequest | The create api-token request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateApiTokensForUserasSuperAdmin(context.Background(), id).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateApiTokensForUserasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokensForUserasSuperAdmin`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateApiTokensForUserasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokensForUserasSuperAdminRequest struct via the builder pattern


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


## CreateServiceAccount

> ApiServiceAccount CreateServiceAccount(ctx, tenant).ApiServiceAccount(apiServiceAccount).Execute()

Create a user service account

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
	apiServiceAccount := *openapiclient.NewApiServiceAccount("Name_example") // ApiServiceAccount | The service account

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateServiceAccount(context.Background(), tenant).ApiServiceAccount(apiServiceAccount).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateServiceAccount`: ApiServiceAccount
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateServiceAccount`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateServiceAccountRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md) | The service account | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateServiceAccountWithResourceTenantasSuperAdmin

> ApiServiceAccount CreateServiceAccountWithResourceTenantasSuperAdmin(ctx, resourceTenant).ApiServiceAccount(apiServiceAccount).Execute()

Create a user service account

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
	apiServiceAccount := *openapiclient.NewApiServiceAccount("Name_example") // ApiServiceAccount | The service account

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateServiceAccountWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).ApiServiceAccount(apiServiceAccount).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateServiceAccountWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateServiceAccountWithResourceTenantasSuperAdmin`: ApiServiceAccount
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateServiceAccountWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateServiceAccountWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md) | The service account | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateServiceAccountasSuperAdmin

> ApiServiceAccount CreateServiceAccountasSuperAdmin(ctx).ApiServiceAccount(apiServiceAccount).Execute()

Create a user service account

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
	apiServiceAccount := *openapiclient.NewApiServiceAccount("Name_example") // ApiServiceAccount | The service account

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateServiceAccountasSuperAdmin(context.Background()).ApiServiceAccount(apiServiceAccount).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateServiceAccountasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateServiceAccountasSuperAdmin`: ApiServiceAccount
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateServiceAccountasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateServiceAccountasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md) | The service account | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateUser

> ApiUser CreateUser(ctx, tenant).ApiUser(apiUser).Execute()

Create a standard user

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
	apiUser := *openapiclient.NewApiUser(openapiclient.UserType("STANDARD"), "Username_example", "Email_example") // ApiUser | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateUser(context.Background(), tenant).ApiUser(apiUser).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateUser`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiUser** | [**ApiUser**](ApiUser.md) | The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateUserBasicAuth

> ApiUser CreateUserBasicAuth(ctx, id, tenant).AbstractUserControllerPasswordRequest(abstractUserControllerPasswordRequest).Execute()

Create a basic auth password for a standard user

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
	abstractUserControllerPasswordRequest := *openapiclient.NewAbstractUserControllerPasswordRequest() // AbstractUserControllerPasswordRequest | The password

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateUserBasicAuth(context.Background(), id, tenant).AbstractUserControllerPasswordRequest(abstractUserControllerPasswordRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateUserBasicAuth``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateUserBasicAuth`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateUserBasicAuth`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateUserBasicAuthRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **abstractUserControllerPasswordRequest** | [**AbstractUserControllerPasswordRequest**](AbstractUserControllerPasswordRequest.md) | The password | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateUserBasicAuthWithResourceTenantasSuperAdmin

> ApiUser CreateUserBasicAuthWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).AbstractUserControllerPasswordRequest(abstractUserControllerPasswordRequest).Execute()

Create a basic auth password for a standard user

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
	resourceTenant := "resourceTenant_example" // string | 
	abstractUserControllerPasswordRequest := *openapiclient.NewAbstractUserControllerPasswordRequest() // AbstractUserControllerPasswordRequest | The password

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateUserBasicAuthWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).AbstractUserControllerPasswordRequest(abstractUserControllerPasswordRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateUserBasicAuthWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateUserBasicAuthWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateUserBasicAuthWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateUserBasicAuthWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **abstractUserControllerPasswordRequest** | [**AbstractUserControllerPasswordRequest**](AbstractUserControllerPasswordRequest.md) | The password | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateUserBasicAuthasSuperAdmin

> ApiUser CreateUserBasicAuthasSuperAdmin(ctx, id).AbstractUserControllerPasswordRequest(abstractUserControllerPasswordRequest).Execute()

Create a basic auth password for a standard user

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
	abstractUserControllerPasswordRequest := *openapiclient.NewAbstractUserControllerPasswordRequest() // AbstractUserControllerPasswordRequest | The password

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateUserBasicAuthasSuperAdmin(context.Background(), id).AbstractUserControllerPasswordRequest(abstractUserControllerPasswordRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateUserBasicAuthasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateUserBasicAuthasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateUserBasicAuthasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateUserBasicAuthasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **abstractUserControllerPasswordRequest** | [**AbstractUserControllerPasswordRequest**](AbstractUserControllerPasswordRequest.md) | The password | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateUserWithResourceTenantasSuperAdmin

> ApiUser CreateUserWithResourceTenantasSuperAdmin(ctx, resourceTenant).ApiUser(apiUser).Execute()

Create a standard user

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
	apiUser := *openapiclient.NewApiUser(openapiclient.UserType("STANDARD"), "Username_example", "Email_example") // ApiUser | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateUserWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).ApiUser(apiUser).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateUserWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateUserWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateUserWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateUserWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiUser** | [**ApiUser**](ApiUser.md) | The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateUserasSuperAdmin

> ApiUser CreateUserasSuperAdmin(ctx).ApiUser(apiUser).Execute()

Create a standard user

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
	apiUser := *openapiclient.NewApiUser(openapiclient.UserType("STANDARD"), "Username_example", "Email_example") // ApiUser | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.CreateUserasSuperAdmin(context.Background()).ApiUser(apiUser).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.CreateUserasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateUserasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.CreateUserasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateUserasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiUser** | [**ApiUser**](ApiUser.md) | The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteApiToken

> map[string]interface{} DeleteApiToken(ctx, id, tokenId, tenant).Execute()

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
	resp, r, err := apiClient.UsersAPI.DeleteApiToken(context.Background(), id, tokenId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteApiToken``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApiToken`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteApiToken`: %v\n", resp)
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

Other parameters are passed through a pointer to a apiDeleteApiTokenRequest struct via the builder pattern


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


## DeleteApiTokenWithResourceTenantasSuperAdmin

> map[string]interface{} DeleteApiTokenWithResourceTenantasSuperAdmin(ctx, id, tokenId, resourceTenant).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.DeleteApiTokenWithResourceTenantasSuperAdmin(context.Background(), id, tokenId, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteApiTokenWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApiTokenWithResourceTenantasSuperAdmin`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteApiTokenWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tokenId** | **string** | The token id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteApiTokenWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## DeleteApiTokenasSuperAdmin

> map[string]interface{} DeleteApiTokenasSuperAdmin(ctx, id, tokenId).Execute()

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
	resp, r, err := apiClient.UsersAPI.DeleteApiTokenasSuperAdmin(context.Background(), id, tokenId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteApiTokenasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApiTokenasSuperAdmin`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteApiTokenasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tokenId** | **string** | The token id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteApiTokenasSuperAdminRequest struct via the builder pattern


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


## DeleteAuth

> ApiUser DeleteAuth(ctx, id, uid, tenant).Execute()

Delete an Auth for a user

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
	uid := "uid_example" // string | The auth id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.DeleteAuth(context.Background(), id, uid, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteAuth``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteAuth`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteAuth`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**uid** | **string** | The auth id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteAuthRequest struct via the builder pattern


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


## DeleteAuthWithResourceTenantasSuperAdmin

> ApiUser DeleteAuthWithResourceTenantasSuperAdmin(ctx, id, uid, resourceTenant).Execute()

Delete an Auth for a user

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
	uid := "uid_example" // string | The auth id
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.DeleteAuthWithResourceTenantasSuperAdmin(context.Background(), id, uid, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteAuthWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteAuthWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteAuthWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**uid** | **string** | The auth id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteAuthWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## DeleteAuthasSuperAdmin

> ApiUser DeleteAuthasSuperAdmin(ctx, id, uid).Execute()

Delete an Auth for a user

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
	uid := "uid_example" // string | The auth id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.DeleteAuthasSuperAdmin(context.Background(), id, uid).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteAuthasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteAuthasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteAuthasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**uid** | **string** | The auth id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteAuthasSuperAdminRequest struct via the builder pattern


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


## DeleteRefreshToken

> ApiUser DeleteRefreshToken(ctx, id, tenant).Execute()

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
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.DeleteRefreshToken(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteRefreshToken``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteRefreshToken`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteRefreshToken`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteRefreshTokenRequest struct via the builder pattern


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


## DeleteRefreshTokenWithResourceTenantasSuperAdmin

> ApiUser DeleteRefreshTokenWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.DeleteRefreshTokenWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteRefreshTokenWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteRefreshTokenWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteRefreshTokenWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteRefreshTokenWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## DeleteRefreshTokenasSuperAdmin

> ApiUser DeleteRefreshTokenasSuperAdmin(ctx, id).Execute()

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
	resp, r, err := apiClient.UsersAPI.DeleteRefreshTokenasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteRefreshTokenasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteRefreshTokenasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.DeleteRefreshTokenasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteRefreshTokenasSuperAdminRequest struct via the builder pattern


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


## DeleteUser

> DeleteUser(ctx, id, tenant).Execute()

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
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.DeleteUser(context.Background(), id, tenant).Execute()
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
**tenant** | **string** |  | 

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


## DeleteUserWithResourceTenantasSuperAdmin

> DeleteUserWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.UsersAPI.DeleteUserWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteUserWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteUserWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## DeleteUserasSuperAdmin

> DeleteUserasSuperAdmin(ctx, id).Execute()

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
	r, err := apiClient.UsersAPI.DeleteUserasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.DeleteUserasSuperAdmin``: %v\n", err)
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

Other parameters are passed through a pointer to a apiDeleteUserasSuperAdminRequest struct via the builder pattern


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


## FindAllForAllTenants

> PagedResultsApiUser FindAllForAllTenants(ctx).Page(page).Size(size).Sort(sort).Q(q).Type_(type_).Execute()

Get all users in the instance across all tenantd

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
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	q := "q_example" // string | A string filter (optional)
	type_ := openapiclient.UserType("STANDARD") // UserType | The type of user (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.FindAllForAllTenants(context.Background()).Page(page).Size(size).Sort(sort).Q(q).Type_(type_).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.FindAllForAllTenants``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindAllForAllTenants`: PagedResultsApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.FindAllForAllTenants`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiFindAllForAllTenantsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **sort** | **[]string** | The sort of current page | 
 **q** | **string** | A string filter | 
 **type_** | [**UserType**](UserType.md) | The type of user | 

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


## FindAllForAllTenantsWithResourceTenant

> PagedResultsApiUser FindAllForAllTenantsWithResourceTenant(ctx, resourceTenant).Page(page).Size(size).Sort(sort).Q(q).Type_(type_).Execute()

Get all users in the instance across all tenantd

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
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	q := "q_example" // string | A string filter (optional)
	type_ := openapiclient.UserType("STANDARD") // UserType | The type of user (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.FindAllForAllTenantsWithResourceTenant(context.Background(), resourceTenant).Page(page).Size(size).Sort(sort).Q(q).Type_(type_).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.FindAllForAllTenantsWithResourceTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindAllForAllTenantsWithResourceTenant`: PagedResultsApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.FindAllForAllTenantsWithResourceTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFindAllForAllTenantsWithResourceTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **q** | **string** | A string filter | 
 **type_** | [**UserType**](UserType.md) | The type of user | 

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


## GetUser

> ApiUser GetUser(ctx, id, tenant).Execute()

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
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.GetUser(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.GetUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetUser`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.GetUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetUserRequest struct via the builder pattern


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


## GetUserWithResourceTenantasSuperAdmin

> ApiUser GetUserWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.GetUserWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.GetUserWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetUserWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.GetUserWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetUserWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## GetUserasSuperAdmin

> ApiUser GetUserasSuperAdmin(ctx, id).Execute()

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
	resp, r, err := apiClient.UsersAPI.GetUserasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.GetUserasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetUserasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.GetUserasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetUserasSuperAdminRequest struct via the builder pattern


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


## ImpersonateWithResourceTenant

> map[string]interface{} ImpersonateWithResourceTenant(ctx, resourceTenant, id).Execute()

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
	resourceTenant := "resourceTenant_example" // string | 
	id := "id_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.ImpersonateWithResourceTenant(context.Background(), resourceTenant, id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.ImpersonateWithResourceTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ImpersonateWithResourceTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.ImpersonateWithResourceTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiImpersonateWithResourceTenantRequest struct via the builder pattern


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

> map[string]interface{} ListApiTokens(ctx, id, tenant).Execute()

List all API Tokens for specific user

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
	resp, r, err := apiClient.UsersAPI.ListApiTokens(context.Background(), id, tenant).Execute()
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
**tenant** | **string** |  | 

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


## ListApiTokensWithResourceTenantasSuperAdmin

> map[string]interface{} ListApiTokensWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

List all API Tokens for specific user

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
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.ListApiTokensWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.ListApiTokensWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListApiTokensWithResourceTenantasSuperAdmin`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.ListApiTokensWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListApiTokensWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## ListApiTokensasSuperAdmin

> map[string]interface{} ListApiTokensasSuperAdmin(ctx, id).Execute()

List all API Tokens for specific user

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
	resp, r, err := apiClient.UsersAPI.ListApiTokensasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.ListApiTokensasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListApiTokensasSuperAdmin`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.ListApiTokensasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiListApiTokensasSuperAdminRequest struct via the builder pattern


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


## SearchUsers

> PagedResultsApiUser SearchUsers(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Execute()

Search for users

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
	type_ := openapiclient.UserType("STANDARD") // UserType | The type of user (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.SearchUsers(context.Background(), tenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.SearchUsers``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchUsers`: PagedResultsApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.SearchUsers`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchUsersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 
 **type_** | [**UserType**](UserType.md) | The type of user | 

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


## SearchUsersWithResourceTenantasSuperAdmin

> PagedResultsApiUser SearchUsersWithResourceTenantasSuperAdmin(ctx, resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Execute()

Search for users

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
	type_ := openapiclient.UserType("STANDARD") // UserType | The type of user (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.SearchUsersWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.SearchUsersWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchUsersWithResourceTenantasSuperAdmin`: PagedResultsApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.SearchUsersWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchUsersWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 
 **type_** | [**UserType**](UserType.md) | The type of user | 

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


## SearchUsersasSuperAdmin

> PagedResultsApiUser SearchUsersasSuperAdmin(ctx).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Execute()

Search for users

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
	type_ := openapiclient.UserType("STANDARD") // UserType | The type of user (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.SearchUsersasSuperAdmin(context.Background()).Page(page).Size(size).Q(q).Sort(sort).Type_(type_).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.SearchUsersasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchUsersasSuperAdmin`: PagedResultsApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.SearchUsersasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSearchUsersasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 
 **type_** | [**UserType**](UserType.md) | The type of user | 

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


## SetSuperAdmin

> ApiUser SetSuperAdmin(ctx, id).Body(body).Execute()

Update a user service account

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
	body := true // bool | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.SetSuperAdmin(context.Background(), id).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.SetSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.SetSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | **bool** |  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetSuperAdminWithResourceTenant

> ApiUser SetSuperAdminWithResourceTenant(ctx, resourceTenant, id).Body(body).Execute()

Update a user service account

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
	id := "id_example" // string | The user id
	body := true // bool | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.SetSuperAdminWithResourceTenant(context.Background(), resourceTenant, id).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.SetSuperAdminWithResourceTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetSuperAdminWithResourceTenant`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.SetSuperAdminWithResourceTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetSuperAdminWithResourceTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **body** | **bool** |  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateCurrentUserPassword

> map[string]interface{} UpdateCurrentUserPassword(ctx).MeControllerUpdatePasswordRequest(meControllerUpdatePasswordRequest).Execute()

Update login password for the current user.

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
	meControllerUpdatePasswordRequest := *openapiclient.NewMeControllerUpdatePasswordRequest() // MeControllerUpdatePasswordRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateCurrentUserPassword(context.Background()).MeControllerUpdatePasswordRequest(meControllerUpdatePasswordRequest).Execute()
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
 **meControllerUpdatePasswordRequest** | [**MeControllerUpdatePasswordRequest**](MeControllerUpdatePasswordRequest.md) |  | 

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


## UpdateCurrentUserPasswordWithTenant

> map[string]interface{} UpdateCurrentUserPasswordWithTenant(ctx, tenant).MeControllerUpdatePasswordRequest(meControllerUpdatePasswordRequest).Execute()

Update login password for the current user.

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
	meControllerUpdatePasswordRequest := *openapiclient.NewMeControllerUpdatePasswordRequest() // MeControllerUpdatePasswordRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateCurrentUserPasswordWithTenant(context.Background(), tenant).MeControllerUpdatePasswordRequest(meControllerUpdatePasswordRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateCurrentUserPasswordWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateCurrentUserPasswordWithTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateCurrentUserPasswordWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateCurrentUserPasswordWithTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **meControllerUpdatePasswordRequest** | [**MeControllerUpdatePasswordRequest**](MeControllerUpdatePasswordRequest.md) |  | 

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


## UpdateServiceAccount

> ApiServiceAccount UpdateServiceAccount(ctx, id, tenant).ApiServiceAccount(apiServiceAccount).Execute()

Update a user service account

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
	apiServiceAccount := *openapiclient.NewApiServiceAccount("Name_example") // ApiServiceAccount | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateServiceAccount(context.Background(), id, tenant).ApiServiceAccount(apiServiceAccount).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateServiceAccount`: ApiServiceAccount
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateServiceAccount`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateServiceAccountRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md) | The user | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateServiceAccountWithResourceTenantasSuperAdmin

> ApiServiceAccount UpdateServiceAccountWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).ApiServiceAccount(apiServiceAccount).Execute()

Update a user service account

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
	resourceTenant := "resourceTenant_example" // string | 
	apiServiceAccount := *openapiclient.NewApiServiceAccount("Name_example") // ApiServiceAccount | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateServiceAccountWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).ApiServiceAccount(apiServiceAccount).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateServiceAccountWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateServiceAccountWithResourceTenantasSuperAdmin`: ApiServiceAccount
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateServiceAccountWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateServiceAccountWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md) | The user | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateServiceAccountasSuperAdmin

> ApiServiceAccount UpdateServiceAccountasSuperAdmin(ctx, id).ApiServiceAccount(apiServiceAccount).Execute()

Update a user service account

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
	apiServiceAccount := *openapiclient.NewApiServiceAccount("Name_example") // ApiServiceAccount | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateServiceAccountasSuperAdmin(context.Background(), id).ApiServiceAccount(apiServiceAccount).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateServiceAccountasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateServiceAccountasSuperAdmin`: ApiServiceAccount
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateServiceAccountasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateServiceAccountasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiServiceAccount** | [**ApiServiceAccount**](ApiServiceAccount.md) | The user | 

### Return type

[**ApiServiceAccount**](ApiServiceAccount.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateUser

> ApiUser UpdateUser(ctx, id, tenant).ApiUser(apiUser).Execute()

Update a standard user

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
	apiUser := *openapiclient.NewApiUser(openapiclient.UserType("STANDARD"), "Username_example", "Email_example") // ApiUser | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateUser(context.Background(), id, tenant).ApiUser(apiUser).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateUser`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **apiUser** | [**ApiUser**](ApiUser.md) | The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateUserWithResourceTenantasSuperAdmin

> ApiUser UpdateUserWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).ApiUser(apiUser).Execute()

Update a standard user

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
	resourceTenant := "resourceTenant_example" // string | 
	apiUser := *openapiclient.NewApiUser(openapiclient.UserType("STANDARD"), "Username_example", "Email_example") // ApiUser | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateUserWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).ApiUser(apiUser).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateUserWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateUserWithResourceTenantasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateUserWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateUserWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **apiUser** | [**ApiUser**](ApiUser.md) | The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateUserasSuperAdmin

> ApiUser UpdateUserasSuperAdmin(ctx, id).ApiUser(apiUser).Execute()

Update a standard user

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
	apiUser := *openapiclient.NewApiUser(openapiclient.UserType("STANDARD"), "Username_example", "Email_example") // ApiUser | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.UsersAPI.UpdateUserasSuperAdmin(context.Background(), id).ApiUser(apiUser).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `UsersAPI.UpdateUserasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateUserasSuperAdmin`: ApiUser
	fmt.Fprintf(os.Stdout, "Response from `UsersAPI.UpdateUserasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateUserasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiUser** | [**ApiUser**](ApiUser.md) | The user | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

