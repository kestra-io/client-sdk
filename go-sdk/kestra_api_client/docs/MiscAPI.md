# \MiscAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Configuration**](MiscAPI.md#Configuration) | **Get** /api/v1/configs | Retrieve the instance configuration.
[**Generate**](MiscAPI.md#Generate) | **Get** /api/v1/{tenant}/stats/generate-reports | 
[**LicenseInfo**](MiscAPI.md#LicenseInfo) | **Get** /api/v1/license-info | Retrieve license information
[**ListActions**](MiscAPI.md#ListActions) | **Get** /api/v1/{tenant}/acls/actions | Retrieve list of actions
[**MainTenantFlows**](MiscAPI.md#MainTenantFlows) | **Get** /api/v1/main-tenant-flows | Check if flows are present on the main tenant.
[**SetupConfiguration**](MiscAPI.md#SetupConfiguration) | **Get** /api/v1/setup | Retrieve current setup configuration



## Configuration

> MiscControllerEEConfiguration Configuration(ctx).Execute()

Retrieve the instance configuration.



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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MiscAPI.Configuration(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MiscAPI.Configuration``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `Configuration`: MiscControllerEEConfiguration
	fmt.Fprintf(os.Stdout, "Response from `MiscAPI.Configuration`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiConfigurationRequest struct via the builder pattern


### Return type

[**MiscControllerEEConfiguration**](MiscControllerEEConfiguration.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## Generate

> string Generate(ctx, tenant).From(from).Execute()



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	tenant := "tenant_example" // string | 
	from := time.Now() // string | The start date (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MiscAPI.Generate(context.Background(), tenant).From(from).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MiscAPI.Generate``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `Generate`: string
	fmt.Fprintf(os.Stdout, "Response from `MiscAPI.Generate`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGenerateRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **from** | **string** | The start date | 

### Return type

**string**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## LicenseInfo

> MiscControllerLicenseInfo LicenseInfo(ctx).Execute()

Retrieve license information



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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MiscAPI.LicenseInfo(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MiscAPI.LicenseInfo``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `LicenseInfo`: MiscControllerLicenseInfo
	fmt.Fprintf(os.Stdout, "Response from `MiscAPI.LicenseInfo`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiLicenseInfoRequest struct via the builder pattern


### Return type

[**MiscControllerLicenseInfo**](MiscControllerLicenseInfo.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListActions

> []Action ListActions(ctx, tenant).Execute()

Retrieve list of actions



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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MiscAPI.ListActions(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MiscAPI.ListActions``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListActions`: []Action
	fmt.Fprintf(os.Stdout, "Response from `MiscAPI.ListActions`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListActionsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**[]Action**](Action.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## MainTenantFlows

> bool MainTenantFlows(ctx).Execute()

Check if flows are present on the main tenant.

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MiscAPI.MainTenantFlows(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MiscAPI.MainTenantFlows``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `MainTenantFlows`: bool
	fmt.Fprintf(os.Stdout, "Response from `MiscAPI.MainTenantFlows`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiMainTenantFlowsRequest struct via the builder pattern


### Return type

**bool**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetupConfiguration

> SetupConfiguration SetupConfiguration(ctx).Execute()

Retrieve current setup configuration

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.MiscAPI.SetupConfiguration(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `MiscAPI.SetupConfiguration``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SetupConfiguration`: SetupConfiguration
	fmt.Fprintf(os.Stdout, "Response from `MiscAPI.SetupConfiguration`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiSetupConfigurationRequest struct via the builder pattern


### Return type

[**SetupConfiguration**](SetupConfiguration.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

