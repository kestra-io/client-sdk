# \NamespacesAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AutocompleteNamespaces**](NamespacesAPI.md#AutocompleteNamespaces) | **Post** /api/v1/{tenant}/namespaces/autocomplete | List namespaces for autocomplete
[**CreateNamespace**](NamespacesAPI.md#CreateNamespace) | **Post** /api/v1/{tenant}/namespaces | Create a namespace
[**DeleteNamespace**](NamespacesAPI.md#DeleteNamespace) | **Delete** /api/v1/{tenant}/namespaces/{id} | Delete a namespace
[**DeleteSecret**](NamespacesAPI.md#DeleteSecret) | **Delete** /api/v1/{tenant}/namespaces/{namespace}/secrets/{key} | Delete a secret for a namespace
[**InheritedPluginDefaults**](NamespacesAPI.md#InheritedPluginDefaults) | **Get** /api/v1/{tenant}/namespaces/{id}/inherited-plugindefaults | List inherited plugin defaults
[**InheritedSecrets**](NamespacesAPI.md#InheritedSecrets) | **Get** /api/v1/{tenant}/namespaces/{namespace}/inherited-secrets | List inherited secrets
[**InheritedVariables**](NamespacesAPI.md#InheritedVariables) | **Get** /api/v1/{tenant}/namespaces/{id}/inherited-variables | List inherited variables
[**ListNamespaceSecrets**](NamespacesAPI.md#ListNamespaceSecrets) | **Get** /api/v1/{tenant}/namespaces/{namespace}/secrets | Get secrets for a namespace
[**Namespace**](NamespacesAPI.md#Namespace) | **Get** /api/v1/{tenant}/namespaces/{id} | Get a namespace
[**PatchSecret**](NamespacesAPI.md#PatchSecret) | **Patch** /api/v1/{tenant}/namespaces/{namespace}/secrets/{key} | Patch a secret metadata for a namespace
[**PutSecrets**](NamespacesAPI.md#PutSecrets) | **Put** /api/v1/{tenant}/namespaces/{namespace}/secrets | Update secrets for a namespace
[**SearchNamespaces**](NamespacesAPI.md#SearchNamespaces) | **Get** /api/v1/{tenant}/namespaces/search | Search for namespaces
[**UpdateNamespace**](NamespacesAPI.md#UpdateNamespace) | **Put** /api/v1/{tenant}/namespaces/{id} | Update a namespace



## AutocompleteNamespaces

> []string AutocompleteNamespaces(ctx, tenant).ApiAutocomplete(apiAutocomplete).Execute()

List namespaces for autocomplete



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
	apiAutocomplete := *openapiclient.NewApiAutocomplete() // ApiAutocomplete | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.AutocompleteNamespaces(context.Background(), tenant).ApiAutocomplete(apiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.AutocompleteNamespaces``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteNamespaces`: []string
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.AutocompleteNamespaces`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteNamespacesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md) |  | 

### Return type

**[]string**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateNamespace

> Namespace CreateNamespace(ctx, tenant).Namespace(namespace).Execute()

Create a namespace

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
	namespace := *openapiclient.NewNamespace("Id_example", false) // Namespace | The namespace

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.CreateNamespace(context.Background(), tenant).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.CreateNamespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateNamespace`: Namespace
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.CreateNamespace`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateNamespaceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **namespace** | [**Namespace**](Namespace.md) | The namespace | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteNamespace

> DeleteNamespace(ctx, id, tenant).Execute()

Delete a namespace

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
	id := "id_example" // string | The namespace id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.NamespacesAPI.DeleteNamespace(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.DeleteNamespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteNamespaceRequest struct via the builder pattern


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


## DeleteSecret

> DeleteSecret(ctx, namespace, key, tenant).Execute()

Delete a secret for a namespace

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
	namespace := "namespace_example" // string | The namespace id
	key := "key_example" // string | The secret key
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.NamespacesAPI.DeleteSecret(context.Background(), namespace, key, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.DeleteSecret``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**key** | **string** | The secret key | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteSecretRequest struct via the builder pattern


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


## InheritedPluginDefaults

> []PluginDefault InheritedPluginDefaults(ctx, id, tenant).Execute()

List inherited plugin defaults

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
	id := "id_example" // string | The namespace id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.InheritedPluginDefaults(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.InheritedPluginDefaults``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `InheritedPluginDefaults`: []PluginDefault
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.InheritedPluginDefaults`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiInheritedPluginDefaultsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]PluginDefault**](PluginDefault.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## InheritedSecrets

> map[string][]string InheritedSecrets(ctx, namespace, tenant).Execute()

List inherited secrets

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
	namespace := "namespace_example" // string | The namespace id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.InheritedSecrets(context.Background(), namespace, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.InheritedSecrets``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `InheritedSecrets`: map[string][]string
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.InheritedSecrets`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiInheritedSecretsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**map[string][]string**](array.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## InheritedVariables

> map[string]map[string]interface{} InheritedVariables(ctx, id, tenant).Execute()

List inherited variables

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
	id := "id_example" // string | The namespace id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.InheritedVariables(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.InheritedVariables``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `InheritedVariables`: map[string]map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.InheritedVariables`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiInheritedVariablesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



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


## ListNamespaceSecrets

> ApiSecretListResponseApiSecretMeta ListNamespaceSecrets(ctx, namespace, tenant).Page(page).Size(size).Filters(filters).Sort(sort).Execute()

Get secrets for a namespace

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
	namespace := "namespace_example" // string | The namespace id
	page := int32(56) // int32 | The current page (default to 1)
	size := int32(56) // int32 | The current page size (default to 10)
	filters := []openapiclient.QueryFilter{*openapiclient.NewQueryFilter()} // []QueryFilter | Filters
	tenant := "tenant_example" // string | 
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.ListNamespaceSecrets(context.Background(), namespace, tenant).Page(page).Size(size).Filters(filters).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.ListNamespaceSecrets``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListNamespaceSecrets`: ApiSecretListResponseApiSecretMeta
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.ListNamespaceSecrets`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListNamespaceSecretsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **filters** | [**[]QueryFilter**](QueryFilter.md) | Filters | 

 **sort** | **[]string** | The sort of current page | 

### Return type

[**ApiSecretListResponseApiSecretMeta**](ApiSecretListResponseApiSecretMeta.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## Namespace

> Namespace Namespace(ctx, id, tenant).Execute()

Get a namespace

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
	id := "id_example" // string | The namespace id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.Namespace(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.Namespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `Namespace`: Namespace
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.Namespace`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiNamespaceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PatchSecret

> []ApiSecretMetaEE PatchSecret(ctx, namespace, key, tenant).ApiSecretMetaEE(apiSecretMetaEE).Execute()

Patch a secret metadata for a namespace

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
	namespace := "namespace_example" // string | The namespace id
	key := "key_example" // string | The secret key
	tenant := "tenant_example" // string | 
	apiSecretMetaEE := *openapiclient.NewApiSecretMetaEE("Key_example", "Description_example", []openapiclient.ApiSecretTag{*openapiclient.NewApiSecretTag("Key_example", "Value_example")}) // ApiSecretMetaEE | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.PatchSecret(context.Background(), namespace, key, tenant).ApiSecretMetaEE(apiSecretMetaEE).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.PatchSecret``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PatchSecret`: []ApiSecretMetaEE
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.PatchSecret`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**key** | **string** | The secret key | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPatchSecretRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **apiSecretMetaEE** | [**ApiSecretMetaEE**](ApiSecretMetaEE.md) |  | 

### Return type

[**[]ApiSecretMetaEE**](ApiSecretMetaEE.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PutSecrets

> []ApiSecretMetaEE PutSecrets(ctx, namespace, tenant).ApiSecretValue(apiSecretValue).Execute()

Update secrets for a namespace

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
	namespace := "namespace_example" // string | The namespace id
	tenant := "tenant_example" // string | 
	apiSecretValue := *openapiclient.NewApiSecretValue("Key_example", "Value_example") // ApiSecretValue | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.PutSecrets(context.Background(), namespace, tenant).ApiSecretValue(apiSecretValue).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.PutSecrets``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `PutSecrets`: []ApiSecretMetaEE
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.PutSecrets`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiPutSecretsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **apiSecretValue** | [**ApiSecretValue**](ApiSecretValue.md) |  | 

### Return type

[**[]ApiSecretMetaEE**](ApiSecretMetaEE.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchNamespaces

> PagedResultsNamespace SearchNamespaces(ctx, tenant).Page(page).Size(size).Existing(existing).Q(q).Sort(sort).Execute()

Search for namespaces

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
	existing := true // bool | Return only existing namespace (default to false)
	tenant := "tenant_example" // string | 
	q := "q_example" // string | A string filter (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.SearchNamespaces(context.Background(), tenant).Page(page).Size(size).Existing(existing).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.SearchNamespaces``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchNamespaces`: PagedResultsNamespace
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.SearchNamespaces`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchNamespacesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **existing** | **bool** | Return only existing namespace | [default to false]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsNamespace**](PagedResultsNamespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateNamespace

> Namespace UpdateNamespace(ctx, id, tenant).Namespace(namespace).Execute()

Update a namespace

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
	id := "id_example" // string | The namespace id
	tenant := "tenant_example" // string | 
	namespace := *openapiclient.NewNamespace("Id_example", false) // Namespace | The namespace

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.NamespacesAPI.UpdateNamespace(context.Background(), id, tenant).Namespace(namespace).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `NamespacesAPI.UpdateNamespace``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateNamespace`: Namespace
	fmt.Fprintf(os.Stdout, "Response from `NamespacesAPI.UpdateNamespace`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The namespace id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateNamespaceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **namespace** | [**Namespace**](Namespace.md) | The namespace | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

