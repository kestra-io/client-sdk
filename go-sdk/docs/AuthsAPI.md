# \AuthsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateApiTokenForCurrentUser**](AuthsAPI.md#CreateApiTokenForCurrentUser) | **Post** /api/v1/me/api-tokens | Create API token for the authenticated user
[**DeleteApiTokenForCurrentUser**](AuthsAPI.md#DeleteApiTokenForCurrentUser) | **Delete** /api/v1/me/api-tokens/{tokenId} | Delete API token for the authenticated user
[**GetCurrentUser**](AuthsAPI.md#GetCurrentUser) | **Get** /api/v1/me | Get details about the authenticated user
[**Index**](AuthsAPI.md#Index) | **Get** /api/v1/auths | Retrieve list of authentication methods
[**ListApiTokensForCurrentUser**](AuthsAPI.md#ListApiTokensForCurrentUser) | **Get** /api/v1/me/api-tokens | List API tokens for authenticated user
[**PatchCurrentUser**](AuthsAPI.md#PatchCurrentUser) | **Patch** /api/v1/me | Update authenticated user details



## CreateApiTokenForCurrentUser

> map[string]interface{} CreateApiTokenForCurrentUser(ctx).CreateApiTokenRequest(createApiTokenRequest).Execute()

Create API token for the authenticated user

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
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example", "Description_example", "MaxAge_example", false) // CreateApiTokenRequest | 

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


## DeleteApiTokenForCurrentUser

> map[string]interface{} DeleteApiTokenForCurrentUser(ctx, tokenId).Execute()

Delete API token for the authenticated user

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


## GetCurrentUser

> MeControllerApiMe GetCurrentUser(ctx).Execute()

Get details about the authenticated user



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
	// response from `GetCurrentUser`: MeControllerApiMe
	fmt.Fprintf(os.Stdout, "Response from `AuthsAPI.GetCurrentUser`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiGetCurrentUserRequest struct via the builder pattern


### Return type

[**MeControllerApiMe**](MeControllerApiMe.md)

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

Retrieve list of authentication methods

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

List API tokens for authenticated user



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


## PatchCurrentUser

> map[string]interface{} PatchCurrentUser(ctx).MeControllerApiUserDetailsRequest(meControllerApiUserDetailsRequest).Execute()

Update authenticated user details



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
	meControllerApiUserDetailsRequest := *openapiclient.NewMeControllerApiUserDetailsRequest("FirstName_example", "LastName_example", "Email_example") // MeControllerApiUserDetailsRequest | The user details

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AuthsAPI.PatchCurrentUser(context.Background()).MeControllerApiUserDetailsRequest(meControllerApiUserDetailsRequest).Execute()
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
 **meControllerApiUserDetailsRequest** | [**MeControllerApiUserDetailsRequest**](MeControllerApiUserDetailsRequest.md) | The user details | 

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

