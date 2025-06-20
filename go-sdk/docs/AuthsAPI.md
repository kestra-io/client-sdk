# \AuthsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateApiTokenForCurrentUser**](AuthsAPI.md#CreateApiTokenForCurrentUser) | **Post** /api/v1/me/api-tokens | Create new API Token for authenticated user
[**CreateApiTokenForCurrentUserWithTenant**](AuthsAPI.md#CreateApiTokenForCurrentUserWithTenant) | **Post** /api/v1/{tenant}/me/api-tokens | Create new API Token for authenticated user
[**DeleteApiTokenForCurrentUser**](AuthsAPI.md#DeleteApiTokenForCurrentUser) | **Delete** /api/v1/me/api-tokens/{tokenId} | Delete an API Token for authenticated user
[**DeleteApiTokenForCurrentUserWithTenant**](AuthsAPI.md#DeleteApiTokenForCurrentUserWithTenant) | **Delete** /api/v1/{tenant}/me/api-tokens/{tokenId} | Delete an API Token for authenticated user
[**GetCurrentUser**](AuthsAPI.md#GetCurrentUser) | **Get** /api/v1/me | Get current user
[**GetCurrentUserWithTenant**](AuthsAPI.md#GetCurrentUserWithTenant) | **Get** /api/v1/{tenant}/me | Get current user
[**Index**](AuthsAPI.md#Index) | **Get** /api/v1/auths | Get list of authentication methods
[**ListApiTokensForCurrentUser**](AuthsAPI.md#ListApiTokensForCurrentUser) | **Get** /api/v1/me/api-tokens | List all API Tokens for the authenticated user
[**ListApiTokensForCurrentUserWithTenant**](AuthsAPI.md#ListApiTokensForCurrentUserWithTenant) | **Get** /api/v1/{tenant}/me/api-tokens | List all API Tokens for the authenticated user
[**PatchCurrentUser**](AuthsAPI.md#PatchCurrentUser) | **Patch** /api/v1/me | Updates details for the current user. Returns user&#39;s updated information upon success.
[**PatchCurrentUserWithTenant**](AuthsAPI.md#PatchCurrentUserWithTenant) | **Patch** /api/v1/{tenant}/me | Updates details for the current user. Returns user&#39;s updated information upon success.



## CreateApiTokenForCurrentUser

> map[string]interface{} CreateApiTokenForCurrentUser(ctx).CreateApiTokenRequest(createApiTokenRequest).Execute()

Create new API Token for authenticated user

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
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example", "MaxAge_example") // CreateApiTokenRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.CreateApiTokenForCurrentUser(context.Background()).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.CreateApiTokenForCurrentUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokenForCurrentUser`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.CreateApiTokenForCurrentUser`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokenForCurrentUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md) |  | 

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


## CreateApiTokenForCurrentUserWithTenant

> map[string]interface{} CreateApiTokenForCurrentUserWithTenant(ctx, tenant).CreateApiTokenRequest(createApiTokenRequest).Execute()

Create new API Token for authenticated user

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
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example", "MaxAge_example") // CreateApiTokenRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.CreateApiTokenForCurrentUserWithTenant(context.Background(), tenant).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.CreateApiTokenForCurrentUserWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokenForCurrentUserWithTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.CreateApiTokenForCurrentUserWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokenForCurrentUserWithTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md) |  | 

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


## DeleteApiTokenForCurrentUser

> map[string]interface{} DeleteApiTokenForCurrentUser(ctx, tokenId).Execute()

Delete an API Token for authenticated user

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
	tokenId := "tokenId_example" // string | The token id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.DeleteApiTokenForCurrentUser(context.Background(), tokenId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.DeleteApiTokenForCurrentUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApiTokenForCurrentUser`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.DeleteApiTokenForCurrentUser`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tokenId** | **string** | The token id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteApiTokenForCurrentUserRequest struct via the builder pattern


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


## DeleteApiTokenForCurrentUserWithTenant

> map[string]interface{} DeleteApiTokenForCurrentUserWithTenant(ctx, tokenId, tenant).Execute()

Delete an API Token for authenticated user

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
	tokenId := "tokenId_example" // string | The token id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.DeleteApiTokenForCurrentUserWithTenant(context.Background(), tokenId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.DeleteApiTokenForCurrentUserWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApiTokenForCurrentUserWithTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.DeleteApiTokenForCurrentUserWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tokenId** | **string** | The token id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteApiTokenForCurrentUserWithTenantRequest struct via the builder pattern


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


## GetCurrentUser

> MeControllerMe GetCurrentUser(ctx).Execute()

Get current user

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.GetCurrentUser(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.GetCurrentUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetCurrentUser`: MeControllerMe
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.GetCurrentUser`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiGetCurrentUserRequest struct via the builder pattern


### Return type

[**MeControllerMe**](MeControllerMe.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetCurrentUserWithTenant

> MeControllerMe GetCurrentUserWithTenant(ctx, tenant).Execute()

Get current user

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.GetCurrentUserWithTenant(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.GetCurrentUserWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetCurrentUserWithTenant`: MeControllerMe
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.GetCurrentUserWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetCurrentUserWithTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**MeControllerMe**](MeControllerMe.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## Index

> AuthControllerAuth Index(ctx).Execute()

Get list of authentication methods

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.Index(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.Index``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `Index`: AuthControllerAuth
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.Index`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiIndexRequest struct via the builder pattern


### Return type

[**AuthControllerAuth**](AuthControllerAuth.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListApiTokensForCurrentUser

> map[string]interface{} ListApiTokensForCurrentUser(ctx).Execute()

List all API Tokens for the authenticated user

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.ListApiTokensForCurrentUser(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.ListApiTokensForCurrentUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListApiTokensForCurrentUser`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.ListApiTokensForCurrentUser`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiListApiTokensForCurrentUserRequest struct via the builder pattern


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


## ListApiTokensForCurrentUserWithTenant

> map[string]interface{} ListApiTokensForCurrentUserWithTenant(ctx, tenant).Execute()

List all API Tokens for the authenticated user

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.ListApiTokensForCurrentUserWithTenant(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.ListApiTokensForCurrentUserWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListApiTokensForCurrentUserWithTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.ListApiTokensForCurrentUserWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListApiTokensForCurrentUserWithTenantRequest struct via the builder pattern


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


## PatchCurrentUser

> map[string]interface{} PatchCurrentUser(ctx).MeControllerUserDetailsRequest(meControllerUserDetailsRequest).Execute()

Updates details for the current user. Returns user's updated information upon success.

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
	meControllerUserDetailsRequest := *openapiclient.NewMeControllerUserDetailsRequest() // MeControllerUserDetailsRequest | The user details

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.PatchCurrentUser(context.Background()).MeControllerUserDetailsRequest(meControllerUserDetailsRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.PatchCurrentUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PatchCurrentUser`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.PatchCurrentUser`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiPatchCurrentUserRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **meControllerUserDetailsRequest** | [**MeControllerUserDetailsRequest**](MeControllerUserDetailsRequest.md) | The user details | 

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


## PatchCurrentUserWithTenant

> map[string]interface{} PatchCurrentUserWithTenant(ctx, tenant).MeControllerUserDetailsRequest(meControllerUserDetailsRequest).Execute()

Updates details for the current user. Returns user's updated information upon success.

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
	meControllerUserDetailsRequest := *openapiclient.NewMeControllerUserDetailsRequest() // MeControllerUserDetailsRequest | The user details

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.PatchCurrentUserWithTenant(context.Background(), tenant).MeControllerUserDetailsRequest(meControllerUserDetailsRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AuthsAPI.PatchCurrentUserWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PatchCurrentUserWithTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.PatchCurrentUserWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPatchCurrentUserWithTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **meControllerUserDetailsRequest** | [**MeControllerUserDetailsRequest**](MeControllerUserDetailsRequest.md) | The user details | 

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

