# \SCIMConfigurationAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetAllResourceTypes**](SCIMConfigurationAPI.md#GetAllResourceTypes) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/ResourceTypes | 
[**GetAllSchemas**](SCIMConfigurationAPI.md#GetAllSchemas) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Schemas | 
[**GetResourceType**](SCIMConfigurationAPI.md#GetResourceType) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/ResourceTypes/{name} | 
[**GetSchema**](SCIMConfigurationAPI.md#GetSchema) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/Schemas/{uri} | 
[**GetServiceProviderConfiguration**](SCIMConfigurationAPI.md#GetServiceProviderConfiguration) | **Get** /api/v1/{tenant}/integrations/{integration}/scim/v2/ServiceProviderConfig | 



## GetAllResourceTypes

> []ResourceType GetAllResourceTypes(ctx, integration, tenant).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMConfigurationAPI.GetAllResourceTypes(context.Background(), integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMConfigurationAPI.GetAllResourceTypes``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetAllResourceTypes`: []ResourceType
	fmt.Fprintf(os.Stdout, "Response from `SCIMConfigurationAPI.GetAllResourceTypes`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetAllResourceTypesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]ResourceType**](ResourceType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetAllSchemas

> []Schema GetAllSchemas(ctx, integration, tenant).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMConfigurationAPI.GetAllSchemas(context.Background(), integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMConfigurationAPI.GetAllSchemas``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetAllSchemas`: []Schema
	fmt.Fprintf(os.Stdout, "Response from `SCIMConfigurationAPI.GetAllSchemas`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetAllSchemasRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]Schema**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetResourceType

> ResourceType GetResourceType(ctx, name, integration, tenant).Execute()





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
	name := "name_example" // string | 
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMConfigurationAPI.GetResourceType(context.Background(), name, integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMConfigurationAPI.GetResourceType``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetResourceType`: ResourceType
	fmt.Fprintf(os.Stdout, "Response from `SCIMConfigurationAPI.GetResourceType`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**name** | **string** |  | 
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetResourceTypeRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**ResourceType**](ResourceType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetSchema

> Schema GetSchema(ctx, uri, integration, tenant).Execute()





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
	uri := "uri_example" // string | 
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMConfigurationAPI.GetSchema(context.Background(), uri, integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMConfigurationAPI.GetSchema``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetSchema`: Schema
	fmt.Fprintf(os.Stdout, "Response from `SCIMConfigurationAPI.GetSchema`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**uri** | **string** |  | 
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetSchemaRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**Schema**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetServiceProviderConfiguration

> ServiceProviderConfiguration GetServiceProviderConfiguration(ctx, integration, tenant).Execute()





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
	integration := "integration_example" // string | 
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SCIMConfigurationAPI.GetServiceProviderConfiguration(context.Background(), integration, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SCIMConfigurationAPI.GetServiceProviderConfiguration``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetServiceProviderConfiguration`: ServiceProviderConfiguration
	fmt.Fprintf(os.Stdout, "Response from `SCIMConfigurationAPI.GetServiceProviderConfiguration`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**integration** | **string** |  | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetServiceProviderConfigurationRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**ServiceProviderConfiguration**](ServiceProviderConfiguration.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

