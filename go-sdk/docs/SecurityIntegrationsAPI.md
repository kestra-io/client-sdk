# \SecurityIntegrationsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateSecurityIntegration**](SecurityIntegrationsAPI.md#CreateSecurityIntegration) | **Post** /api/v1/{tenant}/security-integrations | Create a security integration
[**DeleteSecurityIntegration**](SecurityIntegrationsAPI.md#DeleteSecurityIntegration) | **Delete** /api/v1/{tenant}/security-integrations/{id} | Delete a security integration
[**DisableSecurityIntegration**](SecurityIntegrationsAPI.md#DisableSecurityIntegration) | **Post** /api/v1/{tenant}/security-integrations/{id}/disable | Disable a security integration
[**EnableSecurityIntegration**](SecurityIntegrationsAPI.md#EnableSecurityIntegration) | **Post** /api/v1/{tenant}/security-integrations/{id}/enable | Enable a security integration
[**GetSecurityIntegration**](SecurityIntegrationsAPI.md#GetSecurityIntegration) | **Get** /api/v1/{tenant}/security-integrations/{id} | Retrieve a security integration
[**ListSecurityIntegrations**](SecurityIntegrationsAPI.md#ListSecurityIntegrations) | **Get** /api/v1/{tenant}/security-integrations | List all security integrations



## CreateSecurityIntegration

> map[string]interface{} CreateSecurityIntegration(ctx, tenant).CreateSecurityIntegrationRequest(createSecurityIntegrationRequest).Execute()

Create a security integration



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
	createSecurityIntegrationRequest := *openapiclient.NewCreateSecurityIntegrationRequest("Name_example", "Description_example", openapiclient.SecurityIntegration.Type("SCIM")) // CreateSecurityIntegrationRequest | The security integration definition

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SecurityIntegrationsAPI.CreateSecurityIntegration(context.Background(), tenant).CreateSecurityIntegrationRequest(createSecurityIntegrationRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SecurityIntegrationsAPI.CreateSecurityIntegration``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateSecurityIntegration`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SecurityIntegrationsAPI.CreateSecurityIntegration`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateSecurityIntegrationRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **createSecurityIntegrationRequest** | [**CreateSecurityIntegrationRequest**](CreateSecurityIntegrationRequest.md) | The security integration definition | 

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


## DeleteSecurityIntegration

> map[string]interface{} DeleteSecurityIntegration(ctx, id, tenant).Execute()

Delete a security integration



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
	id := "id_example" // string | The ID of security integration
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SecurityIntegrationsAPI.DeleteSecurityIntegration(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SecurityIntegrationsAPI.DeleteSecurityIntegration``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteSecurityIntegration`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SecurityIntegrationsAPI.DeleteSecurityIntegration`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of security integration | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteSecurityIntegrationRequest struct via the builder pattern


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


## DisableSecurityIntegration

> map[string]interface{} DisableSecurityIntegration(ctx, id, tenant).Execute()

Disable a security integration



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
	id := "id_example" // string | The ID of security integration
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SecurityIntegrationsAPI.DisableSecurityIntegration(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SecurityIntegrationsAPI.DisableSecurityIntegration``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DisableSecurityIntegration`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SecurityIntegrationsAPI.DisableSecurityIntegration`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of security integration | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDisableSecurityIntegrationRequest struct via the builder pattern


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


## EnableSecurityIntegration

> map[string]interface{} EnableSecurityIntegration(ctx, id, tenant).Execute()

Enable a security integration



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
	id := "id_example" // string | The ID of security integration
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SecurityIntegrationsAPI.EnableSecurityIntegration(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SecurityIntegrationsAPI.EnableSecurityIntegration``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `EnableSecurityIntegration`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SecurityIntegrationsAPI.EnableSecurityIntegration`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of security integration | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiEnableSecurityIntegrationRequest struct via the builder pattern


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


## GetSecurityIntegration

> map[string]interface{} GetSecurityIntegration(ctx, id, tenant).Execute()

Retrieve a security integration



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
	id := "id_example" // string | The ID of security integration
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SecurityIntegrationsAPI.GetSecurityIntegration(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SecurityIntegrationsAPI.GetSecurityIntegration``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetSecurityIntegration`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SecurityIntegrationsAPI.GetSecurityIntegration`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of security integration | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetSecurityIntegrationRequest struct via the builder pattern


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


## ListSecurityIntegrations

> map[string]interface{} ListSecurityIntegrations(ctx, tenant).Execute()

List all security integrations



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
	resp, r, err := apiClient.SecurityIntegrationsAPI.ListSecurityIntegrations(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SecurityIntegrationsAPI.ListSecurityIntegrations``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListSecurityIntegrations`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `SecurityIntegrationsAPI.ListSecurityIntegrations`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListSecurityIntegrationsRequest struct via the builder pattern


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

