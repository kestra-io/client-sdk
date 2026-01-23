# \ServiceAccountAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateApiTokensForServiceAccount**](ServiceAccountAPI.md#CreateApiTokensForServiceAccount) | **Post** /api/v1/service-accounts/{id}/api-tokens | Create new API Token for a specific service account
[**CreateApiTokensForServiceAccountWithTenant**](ServiceAccountAPI.md#CreateApiTokensForServiceAccountWithTenant) | **Post** /api/v1/{tenant}/service-accounts/{id}/api-tokens | Create new API Token for a specific service account
[**CreateServiceAccount**](ServiceAccountAPI.md#CreateServiceAccount) | **Post** /api/v1/service-accounts | Create a service account
[**CreateServiceAccountForTenant**](ServiceAccountAPI.md#CreateServiceAccountForTenant) | **Post** /api/v1/{tenant}/service-accounts | Create a service account for the given tenant
[**DeleteApiTokenForServiceAccount**](ServiceAccountAPI.md#DeleteApiTokenForServiceAccount) | **Delete** /api/v1/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific service account and token id
[**DeleteApiTokenForServiceAccountWithTenant**](ServiceAccountAPI.md#DeleteApiTokenForServiceAccountWithTenant) | **Delete** /api/v1/{tenant}/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific service account and token id
[**DeleteServiceAccount**](ServiceAccountAPI.md#DeleteServiceAccount) | **Delete** /api/v1/service-accounts/{id} | Delete a service account
[**DeleteServiceAccountForTenant**](ServiceAccountAPI.md#DeleteServiceAccountForTenant) | **Delete** /api/v1/{tenant}/service-accounts/{id} | Delete a service account
[**ListApiTokensForServiceAccount**](ServiceAccountAPI.md#ListApiTokensForServiceAccount) | **Get** /api/v1/service-accounts/{id}/api-tokens | List API tokens for a specific service account
[**ListApiTokensForServiceAccountWithTenant**](ServiceAccountAPI.md#ListApiTokensForServiceAccountWithTenant) | **Get** /api/v1/{tenant}/service-accounts/{id}/api-tokens | List API tokens for a specific service account
[**ListServiceAccounts**](ServiceAccountAPI.md#ListServiceAccounts) | **Get** /api/v1/service-accounts | List service accounts. Superadmin-only. 
[**PatchServiceAccountDetails**](ServiceAccountAPI.md#PatchServiceAccountDetails) | **Patch** /api/v1/service-accounts/{id} | Update service account details
[**PatchServiceAccountSuperAdmin**](ServiceAccountAPI.md#PatchServiceAccountSuperAdmin) | **Patch** /api/v1/service-accounts/{id}/superadmin | Update service account superadmin privileges
[**ServiceAccount**](ServiceAccountAPI.md#ServiceAccount) | **Get** /api/v1/service-accounts/{id} | Get a service account
[**ServiceAccountForTenant**](ServiceAccountAPI.md#ServiceAccountForTenant) | **Get** /api/v1/{tenant}/service-accounts/{id} | Retrieve a service account
[**UpdateServiceAccount**](ServiceAccountAPI.md#UpdateServiceAccount) | **Put** /api/v1/{tenant}/service-accounts/{id} | Update a user service account



## CreateApiTokensForServiceAccount

> map[string]interface{} CreateApiTokensForServiceAccount(ctx, id).CreateApiTokenRequest(createApiTokenRequest).Execute()

Create new API Token for a specific service account

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
	id := "id_example" // string | The user id
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example") // CreateApiTokenRequest | The create api-token request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.CreateApiTokensForServiceAccount(context.Background(), id).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.CreateApiTokensForServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokensForServiceAccount`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.CreateApiTokensForServiceAccount`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokensForServiceAccountRequest struct via the builder pattern


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


## CreateApiTokensForServiceAccountWithTenant

> map[string]interface{} CreateApiTokensForServiceAccountWithTenant(ctx, id, tenant).CreateApiTokenRequest(createApiTokenRequest).Execute()

Create new API Token for a specific service account

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
	id := "id_example" // string | The user id
	tenant := "tenant_example" // string | 
	createApiTokenRequest := *openapiclient.NewCreateApiTokenRequest("Name_example") // CreateApiTokenRequest | The create api-token request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.CreateApiTokensForServiceAccountWithTenant(context.Background(), id, tenant).CreateApiTokenRequest(createApiTokenRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.CreateApiTokensForServiceAccountWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApiTokensForServiceAccountWithTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.CreateApiTokensForServiceAccountWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateApiTokensForServiceAccountWithTenantRequest struct via the builder pattern


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

> IAMServiceAccountControllerApiServiceAccountDetail CreateServiceAccount(ctx).IAMServiceAccountControllerApiCreateServiceAccountRequest(iAMServiceAccountControllerApiCreateServiceAccountRequest).Execute()

Create a service account



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
	iAMServiceAccountControllerApiCreateServiceAccountRequest := *openapiclient.NewIAMServiceAccountControllerApiCreateServiceAccountRequest("Name_example") // IAMServiceAccountControllerApiCreateServiceAccountRequest | The service account

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.CreateServiceAccount(context.Background()).IAMServiceAccountControllerApiCreateServiceAccountRequest(iAMServiceAccountControllerApiCreateServiceAccountRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.CreateServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateServiceAccount`: IAMServiceAccountControllerApiServiceAccountDetail
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.CreateServiceAccount`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateServiceAccountRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **iAMServiceAccountControllerApiCreateServiceAccountRequest** | [**IAMServiceAccountControllerApiCreateServiceAccountRequest**](IAMServiceAccountControllerApiCreateServiceAccountRequest.md) | The service account | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateServiceAccountForTenant

> IAMServiceAccountControllerApiServiceAccountResponse CreateServiceAccountForTenant(ctx, tenant).IAMServiceAccountControllerApiServiceAccountRequest(iAMServiceAccountControllerApiServiceAccountRequest).Execute()

Create a service account for the given tenant

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
	iAMServiceAccountControllerApiServiceAccountRequest := *openapiclient.NewIAMServiceAccountControllerApiServiceAccountRequest("Name_example") // IAMServiceAccountControllerApiServiceAccountRequest | The service account

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.CreateServiceAccountForTenant(context.Background(), tenant).IAMServiceAccountControllerApiServiceAccountRequest(iAMServiceAccountControllerApiServiceAccountRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.CreateServiceAccountForTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateServiceAccountForTenant`: IAMServiceAccountControllerApiServiceAccountResponse
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.CreateServiceAccountForTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateServiceAccountForTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMServiceAccountControllerApiServiceAccountRequest** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md) | The service account | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteApiTokenForServiceAccount

> map[string]interface{} DeleteApiTokenForServiceAccount(ctx, id, tokenId).Execute()

Delete an API Token for specific service account and token id

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
	id := "id_example" // string | The user id
	tokenId := "tokenId_example" // string | The token id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.DeleteApiTokenForServiceAccount(context.Background(), id, tokenId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.DeleteApiTokenForServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApiTokenForServiceAccount`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.DeleteApiTokenForServiceAccount`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tokenId** | **string** | The token id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteApiTokenForServiceAccountRequest struct via the builder pattern


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


## DeleteApiTokenForServiceAccountWithTenant

> map[string]interface{} DeleteApiTokenForServiceAccountWithTenant(ctx, id, tokenId, tenant).Execute()

Delete an API Token for specific service account and token id

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
	id := "id_example" // string | The user id
	tokenId := "tokenId_example" // string | The token id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.DeleteApiTokenForServiceAccountWithTenant(context.Background(), id, tokenId, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.DeleteApiTokenForServiceAccountWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApiTokenForServiceAccountWithTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.DeleteApiTokenForServiceAccountWithTenant`: %v\n", resp)
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

Other parameters are passed through a pointer to a apiDeleteApiTokenForServiceAccountWithTenantRequest struct via the builder pattern


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


## DeleteServiceAccount

> DeleteServiceAccount(ctx, id).Execute()

Delete a service account



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
	id := "id_example" // string | The service account id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.ServiceAccountAPI.DeleteServiceAccount(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.DeleteServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The service account id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteServiceAccountRequest struct via the builder pattern


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


## DeleteServiceAccountForTenant

> DeleteServiceAccountForTenant(ctx, id, tenant).Execute()

Delete a service account

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
	id := "id_example" // string | The service account id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.ServiceAccountAPI.DeleteServiceAccountForTenant(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.DeleteServiceAccountForTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The service account id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteServiceAccountForTenantRequest struct via the builder pattern


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


## ListApiTokensForServiceAccount

> map[string]interface{} ListApiTokensForServiceAccount(ctx, id).Execute()

List API tokens for a specific service account

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
	id := "id_example" // string | The user id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.ListApiTokensForServiceAccount(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.ListApiTokensForServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListApiTokensForServiceAccount`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.ListApiTokensForServiceAccount`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 

### Other Parameters

Other parameters are passed through a pointer to a apiListApiTokensForServiceAccountRequest struct via the builder pattern


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


## ListApiTokensForServiceAccountWithTenant

> map[string]interface{} ListApiTokensForServiceAccountWithTenant(ctx, id, tenant).Execute()

List API tokens for a specific service account

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
	id := "id_example" // string | The user id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.ListApiTokensForServiceAccountWithTenant(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.ListApiTokensForServiceAccountWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListApiTokensForServiceAccountWithTenant`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.ListApiTokensForServiceAccountWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListApiTokensForServiceAccountWithTenantRequest struct via the builder pattern


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


## ListServiceAccounts

> PagedResultsIAMServiceAccountControllerApiServiceAccountDetail ListServiceAccounts(ctx).Page(page).Size(size).Q(q).Sort(sort).Execute()

List service accounts. Superadmin-only. 

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
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.ListServiceAccounts(context.Background()).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.ListServiceAccounts``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListServiceAccounts`: PagedResultsIAMServiceAccountControllerApiServiceAccountDetail
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.ListServiceAccounts`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiListServiceAccountsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsIAMServiceAccountControllerApiServiceAccountDetail**](PagedResultsIAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchServiceAccountDetails

> IAMServiceAccountControllerApiServiceAccountDetail PatchServiceAccountDetails(ctx, id).IAMServiceAccountControllerApiPatchServiceAccountRequest(iAMServiceAccountControllerApiPatchServiceAccountRequest).Execute()

Update service account details



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
	id := "id_example" // string | The service account id
	iAMServiceAccountControllerApiPatchServiceAccountRequest := *openapiclient.NewIAMServiceAccountControllerApiPatchServiceAccountRequest("Name_example") // IAMServiceAccountControllerApiPatchServiceAccountRequest | The service account details

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.PatchServiceAccountDetails(context.Background(), id).IAMServiceAccountControllerApiPatchServiceAccountRequest(iAMServiceAccountControllerApiPatchServiceAccountRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.PatchServiceAccountDetails``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PatchServiceAccountDetails`: IAMServiceAccountControllerApiServiceAccountDetail
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.PatchServiceAccountDetails`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The service account id | 

### Other Parameters

Other parameters are passed through a pointer to a apiPatchServiceAccountDetailsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **iAMServiceAccountControllerApiPatchServiceAccountRequest** | [**IAMServiceAccountControllerApiPatchServiceAccountRequest**](IAMServiceAccountControllerApiPatchServiceAccountRequest.md) | The service account details | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchServiceAccountSuperAdmin

> PatchServiceAccountSuperAdmin(ctx, id).ApiPatchSuperAdminRequest(apiPatchSuperAdminRequest).Execute()

Update service account superadmin privileges



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
	id := "id_example" // string | The user id
	apiPatchSuperAdminRequest := *openapiclient.NewApiPatchSuperAdminRequest(false) // ApiPatchSuperAdminRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.ServiceAccountAPI.PatchServiceAccountSuperAdmin(context.Background(), id).ApiPatchSuperAdminRequest(apiPatchSuperAdminRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.PatchServiceAccountSuperAdmin``: %v\n", err)
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

Other parameters are passed through a pointer to a apiPatchServiceAccountSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiPatchSuperAdminRequest** | [**ApiPatchSuperAdminRequest**](ApiPatchSuperAdminRequest.md) |  | 

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


## ServiceAccount

> IAMServiceAccountControllerApiServiceAccountDetail ServiceAccount(ctx, id).Execute()

Get a service account



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
	id := "id_example" // string | The service account id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.ServiceAccount(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.ServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ServiceAccount`: IAMServiceAccountControllerApiServiceAccountDetail
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.ServiceAccount`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The service account id | 

### Other Parameters

Other parameters are passed through a pointer to a apiServiceAccountRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ServiceAccountForTenant

> IAMServiceAccountControllerApiServiceAccountResponse ServiceAccountForTenant(ctx, id, tenant).Execute()

Retrieve a service account

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
	id := "id_example" // string | The user id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.ServiceAccountForTenant(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.ServiceAccountForTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ServiceAccountForTenant`: IAMServiceAccountControllerApiServiceAccountResponse
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.ServiceAccountForTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The user id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiServiceAccountForTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateServiceAccount

> IAMServiceAccountControllerApiServiceAccountResponse UpdateServiceAccount(ctx, id, tenant).IAMServiceAccountControllerApiServiceAccountRequest(iAMServiceAccountControllerApiServiceAccountRequest).Execute()

Update a user service account

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
	id := "id_example" // string | The user id
	tenant := "tenant_example" // string | 
	iAMServiceAccountControllerApiServiceAccountRequest := *openapiclient.NewIAMServiceAccountControllerApiServiceAccountRequest("Name_example") // IAMServiceAccountControllerApiServiceAccountRequest | The user

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.ServiceAccountAPI.UpdateServiceAccount(context.Background(), id, tenant).IAMServiceAccountControllerApiServiceAccountRequest(iAMServiceAccountControllerApiServiceAccountRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `ServiceAccountAPI.UpdateServiceAccount``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateServiceAccount`: IAMServiceAccountControllerApiServiceAccountResponse
	fmt.Fprintf(os.Stdout, "Response from `ServiceAccountAPI.UpdateServiceAccount`: %v\n", resp)
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


 **iAMServiceAccountControllerApiServiceAccountRequest** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md) | The user | 

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

