# \PluginsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetAllInputTypes**](PluginsAPI.md#GetAllInputTypes) | **Get** /api/v1/{tenant}/plugins/inputs | Get all types for an inputs
[**GetPluginBySubgroups**](PluginsAPI.md#GetPluginBySubgroups) | **Get** /api/v1/{tenant}/plugins/groups/subgroups | Get plugins group by subgroups
[**GetPluginDocumentation**](PluginsAPI.md#GetPluginDocumentation) | **Get** /api/v1/{tenant}/plugins/{cls} | Get plugin documentation
[**GetPluginDocumentationFromVersion**](PluginsAPI.md#GetPluginDocumentationFromVersion) | **Get** /api/v1/{tenant}/plugins/{cls}/versions/{version} | Get plugin documentation
[**GetPluginGroupIcons**](PluginsAPI.md#GetPluginGroupIcons) | **Get** /api/v1/{tenant}/plugins/icons/groups | Get plugins icons
[**GetPluginIcons**](PluginsAPI.md#GetPluginIcons) | **Get** /api/v1/{tenant}/plugins/icons | Get plugins icons
[**GetPluginVersions**](PluginsAPI.md#GetPluginVersions) | **Get** /api/v1/{tenant}/plugins/{cls}/versions | Get all versions for a plugin
[**GetSchemaFromInputType**](PluginsAPI.md#GetSchemaFromInputType) | **Get** /api/v1/{tenant}/plugins/inputs/{type} | Get json schemas for an input type
[**GetSchemasFromType**](PluginsAPI.md#GetSchemasFromType) | **Get** /api/v1/{tenant}/plugins/schemas/{type} | Get all json schemas for a type
[**GetVersionedPluginDetails**](PluginsAPI.md#GetVersionedPluginDetails) | **Get** /api/v1/cluster/versioned-plugins/{groupId}/{artifactId} | Get details about a Kestra&#39;s plugin artifact.
[**GetVersionedPluginDetailsFromVersion**](PluginsAPI.md#GetVersionedPluginDetailsFromVersion) | **Get** /api/v1/cluster/versioned-plugins/{groupId}/{artifactId}/{version} | Get details about a specific Kestra&#39;s plugin artifact version.
[**InstallVersionedPlugins**](PluginsAPI.md#InstallVersionedPlugins) | **Post** /api/v1/cluster/versioned-plugins/install | Install a specific Kestra&#39;s plugin artifact
[**ListAvailableVersionedPlugins**](PluginsAPI.md#ListAvailableVersionedPlugins) | **Get** /api/v1/cluster/versioned-plugins/available | Get the list of available Kestra&#39;s plugin artifact.
[**ListPlugins**](PluginsAPI.md#ListPlugins) | **Get** /api/v1/{tenant}/plugins | Get list of plugins
[**ListVersionedPlugin**](PluginsAPI.md#ListVersionedPlugin) | **Get** /api/v1/cluster/versioned-plugins | Get the list of installed Kestra&#39;s plugin artifact.
[**ResolveVersionedPlugins**](PluginsAPI.md#ResolveVersionedPlugins) | **Post** /api/v1/cluster/versioned-plugins/resolve | Resolve a specific Kestra&#39;s plugin artifact
[**UninstallVersionedPlugins**](PluginsAPI.md#UninstallVersionedPlugins) | **Delete** /api/v1/cluster/versioned-plugins/uninstall | Uninstall Kestra&#39;s plugin artifacts
[**UploadVersionedPlugins**](PluginsAPI.md#UploadVersionedPlugins) | **Post** /api/v1/cluster/versioned-plugins/upload | Upload a Kestra&#39;s plugin artifact



## GetAllInputTypes

> []InputType GetAllInputTypes(ctx, tenant).Execute()

Get all types for an inputs

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
	resp, r, err := apiClient.PluginsAPI.GetAllInputTypes(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetAllInputTypes``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetAllInputTypes`: []InputType
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetAllInputTypes`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetAllInputTypesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**[]InputType**](InputType.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetPluginBySubgroups

> []Plugin GetPluginBySubgroups(ctx, tenant).IncludeDeprecated(includeDeprecated).Execute()

Get plugins group by subgroups

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
	includeDeprecated := true // bool | Whether to include deprecated plugins (default to true)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.GetPluginBySubgroups(context.Background(), tenant).IncludeDeprecated(includeDeprecated).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetPluginBySubgroups``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetPluginBySubgroups`: []Plugin
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetPluginBySubgroups`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetPluginBySubgroupsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeDeprecated** | **bool** | Whether to include deprecated plugins | [default to true]


### Return type

[**[]Plugin**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetPluginDocumentation

> DocumentationWithSchema GetPluginDocumentation(ctx, cls, tenant).All(all).Execute()

Get plugin documentation

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
	cls := "cls_example" // string | The plugin full class name
	all := true // bool | Include all the properties (default to false)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.GetPluginDocumentation(context.Background(), cls, tenant).All(all).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetPluginDocumentation``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetPluginDocumentation`: DocumentationWithSchema
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetPluginDocumentation`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**cls** | **string** | The plugin full class name | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetPluginDocumentationRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **all** | **bool** | Include all the properties | [default to false]


### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetPluginDocumentationFromVersion

> DocumentationWithSchema GetPluginDocumentationFromVersion(ctx, cls, version, tenant).All(all).Execute()

Get plugin documentation

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
	cls := "cls_example" // string | The plugin type
	version := "version_example" // string | The plugin version
	all := true // bool | Include all the properties (default to false)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.GetPluginDocumentationFromVersion(context.Background(), cls, version, tenant).All(all).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetPluginDocumentationFromVersion``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetPluginDocumentationFromVersion`: DocumentationWithSchema
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetPluginDocumentationFromVersion`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**cls** | **string** | The plugin type | 
**version** | **string** | The plugin version | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetPluginDocumentationFromVersionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **all** | **bool** | Include all the properties | [default to false]


### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetPluginGroupIcons

> map[string]PluginIcon GetPluginGroupIcons(ctx, tenant).Execute()

Get plugins icons

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
	resp, r, err := apiClient.PluginsAPI.GetPluginGroupIcons(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetPluginGroupIcons``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetPluginGroupIcons`: map[string]PluginIcon
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetPluginGroupIcons`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetPluginGroupIconsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**map[string]PluginIcon**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetPluginIcons

> map[string]PluginIcon GetPluginIcons(ctx, tenant).Execute()

Get plugins icons

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
	resp, r, err := apiClient.PluginsAPI.GetPluginIcons(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetPluginIcons``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetPluginIcons`: map[string]PluginIcon
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetPluginIcons`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetPluginIconsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**map[string]PluginIcon**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetPluginVersions

> PluginControllerApiPluginVersions GetPluginVersions(ctx, cls, tenant).Execute()

Get all versions for a plugin

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
	cls := "cls_example" // string | The plugin type
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.GetPluginVersions(context.Background(), cls, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetPluginVersions``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetPluginVersions`: PluginControllerApiPluginVersions
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetPluginVersions`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**cls** | **string** | The plugin type | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetPluginVersionsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**PluginControllerApiPluginVersions**](PluginControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetSchemaFromInputType

> DocumentationWithSchema GetSchemaFromInputType(ctx, type_, tenant).Execute()

Get json schemas for an input type



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
	type_ := openapiclient.Type("STRING") // Type | The schema needed
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.GetSchemaFromInputType(context.Background(), type_, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetSchemaFromInputType``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetSchemaFromInputType`: DocumentationWithSchema
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetSchemaFromInputType`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**type_** | [**Type**](.md) | The schema needed | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetSchemaFromInputTypeRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetSchemasFromType

> map[string]map[string]interface{} GetSchemasFromType(ctx, type_, tenant).ArrayOf(arrayOf).Execute()

Get all json schemas for a type



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
	type_ := openapiclient.SchemaType("FLOW") // SchemaType | The schema needed
	arrayOf := true // bool | If schema should be an array of requested type (default to false)
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.GetSchemasFromType(context.Background(), type_, tenant).ArrayOf(arrayOf).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetSchemasFromType``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetSchemasFromType`: map[string]map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetSchemasFromType`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**type_** | [**SchemaType**](.md) | The schema needed | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetSchemasFromTypeRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **arrayOf** | **bool** | If schema should be an array of requested type | [default to false]


### Return type

**map[string]map[string]interface{}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetVersionedPluginDetails

> ClusterControllerApiPluginVersions GetVersionedPluginDetails(ctx, groupId, artifactId).Execute()

Get details about a Kestra's plugin artifact.

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
	groupId := "groupId_example" // string | 
	artifactId := "artifactId_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.GetVersionedPluginDetails(context.Background(), groupId, artifactId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetVersionedPluginDetails``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetVersionedPluginDetails`: ClusterControllerApiPluginVersions
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetVersionedPluginDetails`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**groupId** | **string** |  | 
**artifactId** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetVersionedPluginDetailsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**ClusterControllerApiPluginVersions**](ClusterControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetVersionedPluginDetailsFromVersion

> ClusterControllerApiPluginVersionDetails GetVersionedPluginDetailsFromVersion(ctx, groupId, artifactId, version).Execute()

Get details about a specific Kestra's plugin artifact version.

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
	groupId := "groupId_example" // string | 
	artifactId := "artifactId_example" // string | 
	version := "version_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.GetVersionedPluginDetailsFromVersion(context.Background(), groupId, artifactId, version).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.GetVersionedPluginDetailsFromVersion``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetVersionedPluginDetailsFromVersion`: ClusterControllerApiPluginVersionDetails
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.GetVersionedPluginDetailsFromVersion`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**groupId** | **string** |  | 
**artifactId** | **string** |  | 
**version** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetVersionedPluginDetailsFromVersionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**ClusterControllerApiPluginVersionDetails**](ClusterControllerApiPluginVersionDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## InstallVersionedPlugins

> ClusterControllerApiPluginArtifactListPluginArtifact InstallVersionedPlugins(ctx).ClusterControllerApiPluginListRequest(clusterControllerApiPluginListRequest).Execute()

Install a specific Kestra's plugin artifact

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
	clusterControllerApiPluginListRequest := *openapiclient.NewClusterControllerApiPluginListRequest() // ClusterControllerApiPluginListRequest | List of plugins

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.InstallVersionedPlugins(context.Background()).ClusterControllerApiPluginListRequest(clusterControllerApiPluginListRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.InstallVersionedPlugins``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `InstallVersionedPlugins`: ClusterControllerApiPluginArtifactListPluginArtifact
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.InstallVersionedPlugins`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiInstallVersionedPluginsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clusterControllerApiPluginListRequest** | [**ClusterControllerApiPluginListRequest**](ClusterControllerApiPluginListRequest.md) | List of plugins | 

### Return type

[**ClusterControllerApiPluginArtifactListPluginArtifact**](ClusterControllerApiPluginArtifactListPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListAvailableVersionedPlugins

> map[string]interface{} ListAvailableVersionedPlugins(ctx).Execute()

Get the list of available Kestra's plugin artifact.

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
	resp, r, err := apiClient.PluginsAPI.ListAvailableVersionedPlugins(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.ListAvailableVersionedPlugins``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListAvailableVersionedPlugins`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.ListAvailableVersionedPlugins`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiListAvailableVersionedPluginsRequest struct via the builder pattern


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


## ListPlugins

> []Plugin ListPlugins(ctx, tenant).Execute()

Get list of plugins

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
	resp, r, err := apiClient.PluginsAPI.ListPlugins(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.ListPlugins``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListPlugins`: []Plugin
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.ListPlugins`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListPluginsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**[]Plugin**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListVersionedPlugin

> PagedResultsClusterControllerApiPluginArtifact ListVersionedPlugin(ctx).Page(page).Size(size).Sort(sort).Q(q).Execute()

Get the list of installed Kestra's plugin artifact.

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
	q := "q_example" // string | The query (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.ListVersionedPlugin(context.Background()).Page(page).Size(size).Sort(sort).Q(q).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.ListVersionedPlugin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListVersionedPlugin`: PagedResultsClusterControllerApiPluginArtifact
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.ListVersionedPlugin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiListVersionedPluginRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **sort** | **[]string** | The sort of current page | 
 **q** | **string** | The query | 

### Return type

[**PagedResultsClusterControllerApiPluginArtifact**](PagedResultsClusterControllerApiPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ResolveVersionedPlugins

> ClusterControllerApiPluginArtifactListPluginResolutionResult ResolveVersionedPlugins(ctx).ClusterControllerApiPluginListRequest(clusterControllerApiPluginListRequest).Execute()

Resolve a specific Kestra's plugin artifact

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
	clusterControllerApiPluginListRequest := *openapiclient.NewClusterControllerApiPluginListRequest() // ClusterControllerApiPluginListRequest | List of plugins

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.ResolveVersionedPlugins(context.Background()).ClusterControllerApiPluginListRequest(clusterControllerApiPluginListRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.ResolveVersionedPlugins``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ResolveVersionedPlugins`: ClusterControllerApiPluginArtifactListPluginResolutionResult
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.ResolveVersionedPlugins`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiResolveVersionedPluginsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clusterControllerApiPluginListRequest** | [**ClusterControllerApiPluginListRequest**](ClusterControllerApiPluginListRequest.md) | List of plugins | 

### Return type

[**ClusterControllerApiPluginArtifactListPluginResolutionResult**](ClusterControllerApiPluginArtifactListPluginResolutionResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UninstallVersionedPlugins

> ClusterControllerApiPluginArtifactListPluginArtifact UninstallVersionedPlugins(ctx).ClusterControllerApiPluginListRequest(clusterControllerApiPluginListRequest).Execute()

Uninstall Kestra's plugin artifacts

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
	clusterControllerApiPluginListRequest := *openapiclient.NewClusterControllerApiPluginListRequest() // ClusterControllerApiPluginListRequest | List of plugins

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.UninstallVersionedPlugins(context.Background()).ClusterControllerApiPluginListRequest(clusterControllerApiPluginListRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.UninstallVersionedPlugins``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UninstallVersionedPlugins`: ClusterControllerApiPluginArtifactListPluginArtifact
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.UninstallVersionedPlugins`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiUninstallVersionedPluginsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clusterControllerApiPluginListRequest** | [**ClusterControllerApiPluginListRequest**](ClusterControllerApiPluginListRequest.md) | List of plugins | 

### Return type

[**ClusterControllerApiPluginArtifactListPluginArtifact**](ClusterControllerApiPluginArtifactListPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UploadVersionedPlugins

> PluginArtifact UploadVersionedPlugins(ctx).File(file).Execute()

Upload a Kestra's plugin artifact

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
	file := os.NewFile(1234, "some_file") // *os.File |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.PluginsAPI.UploadVersionedPlugins(context.Background()).File(file).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `PluginsAPI.UploadVersionedPlugins``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UploadVersionedPlugins`: PluginArtifact
	fmt.Fprintf(os.Stdout, "Response from `PluginsAPI.UploadVersionedPlugins`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiUploadVersionedPluginsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | ***os.File** |  | 

### Return type

[**PluginArtifact**](PluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

