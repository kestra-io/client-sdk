# \AppsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**BulkDeleteApps**](AppsAPI.md#BulkDeleteApps) | **Delete** /api/v1/{tenant}/apps | Delete existing apps
[**BulkDisableApps**](AppsAPI.md#BulkDisableApps) | **Post** /api/v1/{tenant}/apps/disable | Disable existing apps
[**BulkEnableApps**](AppsAPI.md#BulkEnableApps) | **Post** /api/v1/{tenant}/apps/enable | Enable existing apps
[**BulkExportApps**](AppsAPI.md#BulkExportApps) | **Post** /api/v1/{tenant}/apps/export | Export apps as a ZIP archive of yaml sources.
[**CreateApp**](AppsAPI.md#CreateApp) | **Post** /api/v1/{tenant}/apps | Create a new app
[**DeleteApp**](AppsAPI.md#DeleteApp) | **Delete** /api/v1/{tenant}/apps/{uid} | Delete an existing app
[**DisableApp**](AppsAPI.md#DisableApp) | **Post** /api/v1/{tenant}/apps/{uid}/disable | Disable the app.
[**DispatchApp**](AppsAPI.md#DispatchApp) | **Post** /api/v1/{tenant}/apps/view/{id}/dispatch/{dispatch} | Dispatch for a given app.
[**DownloadFileFromAppExecution**](AppsAPI.md#DownloadFileFromAppExecution) | **Get** /api/v1/{tenant}/apps/view/{id}/file/download | Download file from an app execution
[**EnableApp**](AppsAPI.md#EnableApp) | **Post** /api/v1/{tenant}/apps/{uid}/enable | Enable the app.
[**GetApp**](AppsAPI.md#GetApp) | **Get** /api/v1/{tenant}/apps/{uid} | Get a app
[**GetFileMetaFromAppExecution**](AppsAPI.md#GetFileMetaFromAppExecution) | **Get** /api/v1/{tenant}/apps/view/{id}/file/meta | Get file meta information from an app execution
[**GetFilePreviewFromAppExecution**](AppsAPI.md#GetFilePreviewFromAppExecution) | **Get** /api/v1/{tenant}/apps/view/{id}/file/preview | Get file preview from an app execution
[**GetLogsFromAppExecution**](AppsAPI.md#GetLogsFromAppExecution) | **Get** /api/v1/{tenant}/apps/view/{uid}/logs/download | Download logs for an app execution
[**GetStreamEventsFromApp**](AppsAPI.md#GetStreamEventsFromApp) | **Get** /api/v1/{tenant}/apps/view/{id}/streams/{stream} | Get an event stream from a given app.
[**ListTags**](AppsAPI.md#ListTags) | **Get** /api/v1/{tenant}/apps/tags | Get all the app tags
[**OpenApp**](AppsAPI.md#OpenApp) | **Get** /api/v1/{tenant}/apps/view/{uid} | Open an app
[**PreviewApp**](AppsAPI.md#PreviewApp) | **Post** /api/v1/{tenant}/apps/preview | Open the app for the given source
[**SearchApps**](AppsAPI.md#SearchApps) | **Get** /api/v1/{tenant}/apps/search | Search for apps
[**SearchAppsFromCatalog**](AppsAPI.md#SearchAppsFromCatalog) | **Get** /api/v1/{tenant}/apps/catalog | Search for apps from catalog
[**UpdateApp**](AppsAPI.md#UpdateApp) | **Put** /api/v1/{tenant}/apps/{uid} | Update an existing app



## BulkDeleteApps

> map[string]interface{} BulkDeleteApps(ctx, tenant).AppsControllerApiBulkOperationRequest(appsControllerApiBulkOperationRequest).Execute()

Delete existing apps

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
	appsControllerApiBulkOperationRequest := *openapiclient.NewAppsControllerApiBulkOperationRequest() // AppsControllerApiBulkOperationRequest | The list of Apps UID

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.BulkDeleteApps(context.Background(), tenant).AppsControllerApiBulkOperationRequest(appsControllerApiBulkOperationRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.BulkDeleteApps``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkDeleteApps`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.BulkDeleteApps`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiBulkDeleteAppsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md) | The list of Apps UID | 

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


## BulkDisableApps

> map[string]interface{} BulkDisableApps(ctx, tenant).AppsControllerApiBulkOperationRequest(appsControllerApiBulkOperationRequest).Execute()

Disable existing apps

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
	appsControllerApiBulkOperationRequest := *openapiclient.NewAppsControllerApiBulkOperationRequest() // AppsControllerApiBulkOperationRequest | The list of Apps UID

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.BulkDisableApps(context.Background(), tenant).AppsControllerApiBulkOperationRequest(appsControllerApiBulkOperationRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.BulkDisableApps``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkDisableApps`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.BulkDisableApps`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiBulkDisableAppsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md) | The list of Apps UID | 

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


## BulkEnableApps

> map[string]interface{} BulkEnableApps(ctx, tenant).AppsControllerApiBulkOperationRequest(appsControllerApiBulkOperationRequest).Execute()

Enable existing apps

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
	appsControllerApiBulkOperationRequest := *openapiclient.NewAppsControllerApiBulkOperationRequest() // AppsControllerApiBulkOperationRequest | The list of Apps UID

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.BulkEnableApps(context.Background(), tenant).AppsControllerApiBulkOperationRequest(appsControllerApiBulkOperationRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.BulkEnableApps``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkEnableApps`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.BulkEnableApps`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiBulkEnableAppsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md) | The list of Apps UID | 

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


## BulkExportApps

> string BulkExportApps(ctx, tenant).AppsControllerApiBulkOperationRequest(appsControllerApiBulkOperationRequest).Execute()

Export apps as a ZIP archive of yaml sources.

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
	appsControllerApiBulkOperationRequest := *openapiclient.NewAppsControllerApiBulkOperationRequest() // AppsControllerApiBulkOperationRequest | The list of Apps UID

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.BulkExportApps(context.Background(), tenant).AppsControllerApiBulkOperationRequest(appsControllerApiBulkOperationRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.BulkExportApps``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `BulkExportApps`: string
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.BulkExportApps`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiBulkExportAppsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **appsControllerApiBulkOperationRequest** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md) | The list of Apps UID | 

### Return type

**string**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateApp

> AppsControllerApiAppSource CreateApp(ctx, tenant).Body(body).Execute()

Create a new app

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
	body := "body_example" // string | The app

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.CreateApp(context.Background(), tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.CreateApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateApp`: AppsControllerApiAppSource
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.CreateApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | **string** | The app | 

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteApp

> map[string]interface{} DeleteApp(ctx, uid, tenant).Execute()

Delete an existing app

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
	uid := "uid_example" // string | The ID of the app
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.DeleteApp(context.Background(), uid, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.DeleteApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteApp`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.DeleteApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**uid** | **string** | The ID of the app | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteAppRequest struct via the builder pattern


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


## DisableApp

> AppsControllerApiApp DisableApp(ctx, uid, tenant).Execute()

Disable the app.

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
	uid := "uid_example" // string | The ID of app
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.DisableApp(context.Background(), uid, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.DisableApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DisableApp`: AppsControllerApiApp
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.DisableApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**uid** | **string** | The ID of app | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDisableAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**AppsControllerApiApp**](AppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DispatchApp

> AppResponse DispatchApp(ctx, id, dispatch, tenant).Parameters(parameters).Execute()

Dispatch for a given app.

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
	id := "id_example" // string | The ID of the app.
	dispatch := "dispatch_example" // string | The ID to dispatch
	tenant := "tenant_example" // string | 
	parameters := *openapiclient.NewHttpParameters(map[string]interface{}(123)) // HttpParameters |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.DispatchApp(context.Background(), id, dispatch, tenant).Parameters(parameters).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.DispatchApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DispatchApp`: AppResponse
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.DispatchApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of the app. | 
**dispatch** | **string** | The ID to dispatch | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDispatchAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **parameters** | [**HttpParameters**](HttpParameters.md) |  | 

### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DownloadFileFromAppExecution

> *os.File DownloadFileFromAppExecution(ctx, id, tenant).Path(path).Execute()

Download file from an app execution

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
	id := "id_example" // string | The ID of the app.
	path := "path_example" // string | The internal storage uri
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.DownloadFileFromAppExecution(context.Background(), id, tenant).Path(path).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.DownloadFileFromAppExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DownloadFileFromAppExecution`: *os.File
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.DownloadFileFromAppExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of the app. | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDownloadFileFromAppExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **path** | **string** | The internal storage uri | 


### Return type

[***os.File**](*os.File.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## EnableApp

> AppsControllerApiApp EnableApp(ctx, uid, tenant).Execute()

Enable the app.

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
	uid := "uid_example" // string | The ID of app
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.EnableApp(context.Background(), uid, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.EnableApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `EnableApp`: AppsControllerApiApp
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.EnableApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**uid** | **string** | The ID of app | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiEnableAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**AppsControllerApiApp**](AppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetApp

> AppsControllerApiAppSource GetApp(ctx, uid, tenant).Execute()

Get a app

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
	uid := "uid_example" // string | The ID of the app
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.GetApp(context.Background(), uid, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.GetApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetApp`: AppsControllerApiAppSource
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.GetApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**uid** | **string** | The ID of the app | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetFileMetaFromAppExecution

> FileMetas GetFileMetaFromAppExecution(ctx, id, tenant).Path(path).Execute()

Get file meta information from an app execution

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
	id := "id_example" // string | The ID of the app.
	path := "path_example" // string | The internal storage uri
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.GetFileMetaFromAppExecution(context.Background(), id, tenant).Path(path).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.GetFileMetaFromAppExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetFileMetaFromAppExecution`: FileMetas
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.GetFileMetaFromAppExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of the app. | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetFileMetaFromAppExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **path** | **string** | The internal storage uri | 


### Return type

[**FileMetas**](FileMetas.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetFilePreviewFromAppExecution

> map[string]interface{} GetFilePreviewFromAppExecution(ctx, id, tenant).Path(path).Encoding(encoding).MaxRows(maxRows).Execute()

Get file preview from an app execution

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
	id := "id_example" // string | The ID of the app.
	path := "path_example" // string | The internal storage uri
	encoding := "ISO-8859-1" // string | The file encoding as Java charset name. Defaults to UTF-8 (default to "UTF-8")
	tenant := "tenant_example" // string | 
	maxRows := int32(56) // int32 | The max row returns (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.GetFilePreviewFromAppExecution(context.Background(), id, tenant).Path(path).Encoding(encoding).MaxRows(maxRows).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.GetFilePreviewFromAppExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetFilePreviewFromAppExecution`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.GetFilePreviewFromAppExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of the app. | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetFilePreviewFromAppExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **path** | **string** | The internal storage uri | 
 **encoding** | **string** | The file encoding as Java charset name. Defaults to UTF-8 | [default to &quot;UTF-8&quot;]

 **maxRows** | **int32** | The max row returns | 

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


## GetLogsFromAppExecution

> *os.File GetLogsFromAppExecution(ctx, uid, tenant).ExecutionId(executionId).MinLevel(minLevel).TaskIds(taskIds).Execute()

Download logs for an app execution

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
	uid := "uid_example" // string | The ID of the app.
	executionId := "executionId_example" // string | The ID of the execution.
	tenant := "tenant_example" // string | 
	minLevel := openapiclient.Level("ERROR") // Level | The min log level filter (optional)
	taskIds := []string{"Inner_example"} // []string | The tasks' IDs (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.GetLogsFromAppExecution(context.Background(), uid, tenant).ExecutionId(executionId).MinLevel(minLevel).TaskIds(taskIds).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.GetLogsFromAppExecution``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetLogsFromAppExecution`: *os.File
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.GetLogsFromAppExecution`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**uid** | **string** | The ID of the app. | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetLogsFromAppExecutionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **executionId** | **string** | The ID of the execution. | 

 **minLevel** | [**Level**](Level.md) | The min log level filter | 
 **taskIds** | **[]string** | The tasks&#39; IDs | 

### Return type

[***os.File**](*os.File.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetStreamEventsFromApp

> EventAppResponse GetStreamEventsFromApp(ctx, id, stream, tenant).Parameters(parameters).Execute()

Get an event stream from a given app.

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
	id := "id_example" // string | The ID of the app.
	stream := "stream_example" // string | The ID of the stream to get
	parameters := map[string][]openapiclient.HttpParameters{ ... } // HttpParameters | 
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.GetStreamEventsFromApp(context.Background(), id, stream, tenant).Parameters(parameters).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.GetStreamEventsFromApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetStreamEventsFromApp`: EventAppResponse
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.GetStreamEventsFromApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The ID of the app. | 
**stream** | **string** | The ID of the stream to get | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetStreamEventsFromAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **parameters** | [**HttpParameters**](HttpParameters.md) |  | 


### Return type

[**EventAppResponse**](EventAppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/event-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListTags

> AppsControllerApiAppTags ListTags(ctx, tenant).Execute()

Get all the app tags

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
	resp, r, err := apiClient.AppsAPI.ListTags(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.ListTags``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListTags`: AppsControllerApiAppTags
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.ListTags`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListTagsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**AppsControllerApiAppTags**](AppsControllerApiAppTags.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## OpenApp

> AppResponse OpenApp(ctx, uid, tenant).Parameters(parameters).Execute()

Open an app

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
	uid := "uid_example" // string | The ID of the app
	parameters := map[string][]openapiclient.HttpParameters{ ... } // HttpParameters | 
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.OpenApp(context.Background(), uid, tenant).Parameters(parameters).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.OpenApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `OpenApp`: AppResponse
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.OpenApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**uid** | **string** | The ID of the app | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiOpenAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **parameters** | [**HttpParameters**](HttpParameters.md) |  | 


### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PreviewApp

> AppResponse PreviewApp(ctx, tenant).PreviewAppRequest(previewAppRequest).Execute()

Open the app for the given source

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
	previewAppRequest := *openapiclient.NewPreviewAppRequest() // PreviewAppRequest | The app

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.PreviewApp(context.Background(), tenant).PreviewAppRequest(previewAppRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.PreviewApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PreviewApp`: AppResponse
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.PreviewApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPreviewAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **previewAppRequest** | [**PreviewAppRequest**](PreviewAppRequest.md) | The app | 

### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchApps

> PagedResultsAppsControllerApiApp SearchApps(ctx, tenant).Page(page).Size(size).Sort(sort).Tags(tags).Q(q).Namespace(namespace).FlowId(flowId).Execute()

Search for apps

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
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	tags := []string{"Inner_example"} // []string | A tags filter (optional)
	q := "q_example" // string | A string filter (optional)
	namespace := "namespace_example" // string | A namespace filter prefix (optional)
	flowId := "flowId_example" // string | A flow id filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.SearchApps(context.Background(), tenant).Page(page).Size(size).Sort(sort).Tags(tags).Q(q).Namespace(namespace).FlowId(flowId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.SearchApps``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchApps`: PagedResultsAppsControllerApiApp
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.SearchApps`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchAppsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **tags** | **[]string** | A tags filter | 
 **q** | **string** | A string filter | 
 **namespace** | **string** | A namespace filter prefix | 
 **flowId** | **string** | A flow id filter | 

### Return type

[**PagedResultsAppsControllerApiApp**](PagedResultsAppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchAppsFromCatalog

> PagedResultsAppsControllerApiAppCatalogItem SearchAppsFromCatalog(ctx, tenant).Page(page).Size(size).Tags(tags).Q(q).Execute()

Search for apps from catalog

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
	tags := []string{"Inner_example"} // []string | Tags filter (optional)
	q := "q_example" // string | String filter (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.SearchAppsFromCatalog(context.Background(), tenant).Page(page).Size(size).Tags(tags).Q(q).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.SearchAppsFromCatalog``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchAppsFromCatalog`: PagedResultsAppsControllerApiAppCatalogItem
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.SearchAppsFromCatalog`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchAppsFromCatalogRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **tags** | **[]string** | Tags filter | 
 **q** | **string** | String filter | 

### Return type

[**PagedResultsAppsControllerApiAppCatalogItem**](PagedResultsAppsControllerApiAppCatalogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateApp

> AppsControllerApiAppSource UpdateApp(ctx, uid, tenant).Body(body).Execute()

Update an existing app

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
	uid := "uid_example" // string | The ID of the app
	tenant := "tenant_example" // string | 
	body := "body_example" // string | The app

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AppsAPI.UpdateApp(context.Background(), uid, tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AppsAPI.UpdateApp``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateApp`: AppsControllerApiAppSource
	fmt.Fprintf(os.Stdout, "Response from `AppsAPI.UpdateApp`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**uid** | **string** | The ID of the app | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateAppRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **body** | **string** | The app | 

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

