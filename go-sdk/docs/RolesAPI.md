# \RolesAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AutocompleteRoles**](RolesAPI.md#AutocompleteRoles) | **Post** /api/v1/{tenant}/roles/autocomplete | List roles for autocomplete
[**AutocompleteRolesWithResourceTenantasSuperAdmin**](RolesAPI.md#AutocompleteRolesWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/roles/autocomplete | List roles for autocomplete
[**AutocompleteRolesasSuperAdmin**](RolesAPI.md#AutocompleteRolesasSuperAdmin) | **Post** /api/v1/tenants/roles/autocomplete | List roles for autocomplete
[**CreateRole**](RolesAPI.md#CreateRole) | **Post** /api/v1/{tenant}/roles | Create a role
[**CreateRoleWithResourceTenantasSuperAdmin**](RolesAPI.md#CreateRoleWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/roles | Create a role
[**CreateRoleasSuperAdmin**](RolesAPI.md#CreateRoleasSuperAdmin) | **Post** /api/v1/tenants/roles | Create a role
[**DeleteRole**](RolesAPI.md#DeleteRole) | **Delete** /api/v1/{tenant}/roles/{id} | Delete a role
[**DeleteRoleWithResourceTenantasSuperAdmin**](RolesAPI.md#DeleteRoleWithResourceTenantasSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/roles/{id} | Delete a role
[**DeleteRoleasSuperAdmin**](RolesAPI.md#DeleteRoleasSuperAdmin) | **Delete** /api/v1/tenants/roles/{id} | Delete a role
[**GetRole**](RolesAPI.md#GetRole) | **Get** /api/v1/{tenant}/roles/{id} | Retrieve a role
[**GetRoleWithResourceTenantasSuperAdmin**](RolesAPI.md#GetRoleWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/roles/{id} | Retrieve a role
[**GetRoleasSuperAdmin**](RolesAPI.md#GetRoleasSuperAdmin) | **Get** /api/v1/tenants/roles/{id} | Retrieve a role
[**ListRolesFromGivenIds**](RolesAPI.md#ListRolesFromGivenIds) | **Post** /api/v1/{tenant}/roles/ids | List roles by ids
[**ListRolesFromGivenIdsWithResourceTenantasSuperAdmin**](RolesAPI.md#ListRolesFromGivenIdsWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/roles/ids | List roles by ids
[**ListRolesFromGivenIdsasSuperAdmin**](RolesAPI.md#ListRolesFromGivenIdsasSuperAdmin) | **Post** /api/v1/tenants/roles/ids | List roles by ids
[**SearchRoles**](RolesAPI.md#SearchRoles) | **Get** /api/v1/{tenant}/roles/search | Search for roles
[**SearchRolesWithResourceTenantasSuperAdmin**](RolesAPI.md#SearchRolesWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/roles/search | Search for roles
[**SearchRolesasSuperAdmin**](RolesAPI.md#SearchRolesasSuperAdmin) | **Get** /api/v1/tenants/roles/search | Search for roles
[**UpdateRole**](RolesAPI.md#UpdateRole) | **Put** /api/v1/{tenant}/roles/{id} | Update a role
[**UpdateRoleWithResourceTenantasSuperAdmin**](RolesAPI.md#UpdateRoleWithResourceTenantasSuperAdmin) | **Put** /api/v1/tenants/{resourceTenant}/roles/{id} | Update a role
[**UpdateRoleasSuperAdmin**](RolesAPI.md#UpdateRoleasSuperAdmin) | **Put** /api/v1/tenants/roles/{id} | Update a role



## AutocompleteRoles

> []Role AutocompleteRoles(ctx, tenant).ApiAutocomplete(apiAutocomplete).Execute()

List roles for autocomplete

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
	apiAutocomplete := *openapiclient.NewApiAutocomplete() // ApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.AutocompleteRoles(context.Background(), tenant).ApiAutocomplete(apiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.AutocompleteRoles``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteRoles`: []Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.AutocompleteRoles`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteRolesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AutocompleteRolesWithResourceTenantasSuperAdmin

> []Role AutocompleteRolesWithResourceTenantasSuperAdmin(ctx, resourceTenant).ApiAutocomplete(apiAutocomplete).Execute()

List roles for autocomplete

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
	apiAutocomplete := *openapiclient.NewApiAutocomplete() // ApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.AutocompleteRolesWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).ApiAutocomplete(apiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.AutocompleteRolesWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteRolesWithResourceTenantasSuperAdmin`: []Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.AutocompleteRolesWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteRolesWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## AutocompleteRolesasSuperAdmin

> []Role AutocompleteRolesasSuperAdmin(ctx).ApiAutocomplete(apiAutocomplete).Execute()

List roles for autocomplete

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
	apiAutocomplete := *openapiclient.NewApiAutocomplete() // ApiAutocomplete | Autocomplete request

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.AutocompleteRolesasSuperAdmin(context.Background()).ApiAutocomplete(apiAutocomplete).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.AutocompleteRolesasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `AutocompleteRolesasSuperAdmin`: []Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.AutocompleteRolesasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiAutocompleteRolesasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md) | Autocomplete request | 

### Return type

[**[]Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateRole

> Role CreateRole(ctx, tenant).Role(role).Execute()

Create a role

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
	role := *openapiclient.NewRole(false, "Id_example", "Name_example", "Description_example", *openapiclient.NewRolePermissions(), false, false) // Role | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.CreateRole(context.Background(), tenant).Role(role).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.CreateRole``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateRole`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.CreateRole`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateRoleRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **role** | [**Role**](Role.md) |  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateRoleWithResourceTenantasSuperAdmin

> Role CreateRoleWithResourceTenantasSuperAdmin(ctx, resourceTenant).Role(role).Execute()

Create a role

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
	role := *openapiclient.NewRole(false, "Id_example", "Name_example", "Description_example", *openapiclient.NewRolePermissions(), false, false) // Role | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.CreateRoleWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).Role(role).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.CreateRoleWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateRoleWithResourceTenantasSuperAdmin`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.CreateRoleWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateRoleWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **role** | [**Role**](Role.md) |  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateRoleasSuperAdmin

> Role CreateRoleasSuperAdmin(ctx).Role(role).Execute()

Create a role

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
	role := *openapiclient.NewRole(false, "Id_example", "Name_example", "Description_example", *openapiclient.NewRolePermissions(), false, false) // Role | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.CreateRoleasSuperAdmin(context.Background()).Role(role).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.CreateRoleasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateRoleasSuperAdmin`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.CreateRoleasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateRoleasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **role** | [**Role**](Role.md) |  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteRole

> DeleteRole(ctx, id, tenant).Execute()

Delete a role

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
	id := "id_example" // string | The role id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.RolesAPI.DeleteRole(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.DeleteRole``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteRoleRequest struct via the builder pattern


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


## DeleteRoleWithResourceTenantasSuperAdmin

> DeleteRoleWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

Delete a role

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
	id := "id_example" // string | The role id
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.RolesAPI.DeleteRoleWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.DeleteRoleWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteRoleWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## DeleteRoleasSuperAdmin

> DeleteRoleasSuperAdmin(ctx, id).Execute()

Delete a role

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
	id := "id_example" // string | The role id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.RolesAPI.DeleteRoleasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.DeleteRoleasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteRoleasSuperAdminRequest struct via the builder pattern


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


## GetRole

> Role GetRole(ctx, id, tenant).Execute()

Retrieve a role

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
	id := "id_example" // string | The role id
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.GetRole(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.GetRole``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetRole`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.GetRole`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetRoleRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetRoleWithResourceTenantasSuperAdmin

> Role GetRoleWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

Retrieve a role

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
	id := "id_example" // string | The role id
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.GetRoleWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.GetRoleWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetRoleWithResourceTenantasSuperAdmin`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.GetRoleWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetRoleWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetRoleasSuperAdmin

> Role GetRoleasSuperAdmin(ctx, id).Execute()

Retrieve a role

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
	id := "id_example" // string | The role id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.GetRoleasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.GetRoleasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetRoleasSuperAdmin`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.GetRoleasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetRoleasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListRolesFromGivenIds

> []Role ListRolesFromGivenIds(ctx, tenant).ApiIds(apiIds).Execute()

List roles by ids

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
	apiIds := *openapiclient.NewApiIds([]string{"Ids_example"}) // ApiIds | The ids that must be present on results

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.ListRolesFromGivenIds(context.Background(), tenant).ApiIds(apiIds).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.ListRolesFromGivenIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListRolesFromGivenIds`: []Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.ListRolesFromGivenIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListRolesFromGivenIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiIds** | [**ApiIds**](ApiIds.md) | The ids that must be present on results | 

### Return type

[**[]Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListRolesFromGivenIdsWithResourceTenantasSuperAdmin

> []Role ListRolesFromGivenIdsWithResourceTenantasSuperAdmin(ctx, resourceTenant).ApiIds(apiIds).Execute()

List roles by ids

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
	apiIds := *openapiclient.NewApiIds([]string{"Ids_example"}) // ApiIds | The ids that must be present on results

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.ListRolesFromGivenIdsWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).ApiIds(apiIds).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.ListRolesFromGivenIdsWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListRolesFromGivenIdsWithResourceTenantasSuperAdmin`: []Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.ListRolesFromGivenIdsWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListRolesFromGivenIdsWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **apiIds** | [**ApiIds**](ApiIds.md) | The ids that must be present on results | 

### Return type

[**[]Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListRolesFromGivenIdsasSuperAdmin

> []Role ListRolesFromGivenIdsasSuperAdmin(ctx).ApiIds(apiIds).Execute()

List roles by ids

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
	apiIds := *openapiclient.NewApiIds([]string{"Ids_example"}) // ApiIds | The ids that must be present on results

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.ListRolesFromGivenIdsasSuperAdmin(context.Background()).ApiIds(apiIds).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.ListRolesFromGivenIdsasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListRolesFromGivenIdsasSuperAdmin`: []Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.ListRolesFromGivenIdsasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiListRolesFromGivenIdsasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiIds** | [**ApiIds**](ApiIds.md) | The ids that must be present on results | 

### Return type

[**[]Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchRoles

> PagedResultsRole SearchRoles(ctx, tenant).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for roles

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.SearchRoles(context.Background(), tenant).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.SearchRoles``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchRoles`: PagedResultsRole
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.SearchRoles`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchRolesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsRole**](PagedResultsRole.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchRolesWithResourceTenantasSuperAdmin

> PagedResultsRole SearchRolesWithResourceTenantasSuperAdmin(ctx, resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for roles

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.SearchRolesWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.SearchRolesWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchRolesWithResourceTenantasSuperAdmin`: PagedResultsRole
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.SearchRolesWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchRolesWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsRole**](PagedResultsRole.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchRolesasSuperAdmin

> PagedResultsRole SearchRolesasSuperAdmin(ctx).Page(page).Size(size).Q(q).Sort(sort).Execute()

Search for roles

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

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.SearchRolesasSuperAdmin(context.Background()).Page(page).Size(size).Q(q).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.SearchRolesasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchRolesasSuperAdmin`: PagedResultsRole
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.SearchRolesasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSearchRolesasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **q** | **string** | A string filter | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsRole**](PagedResultsRole.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateRole

> Role UpdateRole(ctx, id, tenant).Role(role).Execute()

Update a role

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
	id := "id_example" // string | The role id
	tenant := "tenant_example" // string | 
	role := *openapiclient.NewRole(false, "Id_example", "Name_example", "Description_example", *openapiclient.NewRolePermissions(), false, false) // Role | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.UpdateRole(context.Background(), id, tenant).Role(role).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.UpdateRole``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateRole`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.UpdateRole`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateRoleRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **role** | [**Role**](Role.md) |  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateRoleWithResourceTenantasSuperAdmin

> Role UpdateRoleWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Role(role).Execute()

Update a role

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
	id := "id_example" // string | The role id
	resourceTenant := "resourceTenant_example" // string | 
	role := *openapiclient.NewRole(false, "Id_example", "Name_example", "Description_example", *openapiclient.NewRolePermissions(), false, false) // Role | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.UpdateRoleWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Role(role).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.UpdateRoleWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateRoleWithResourceTenantasSuperAdmin`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.UpdateRoleWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateRoleWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **role** | [**Role**](Role.md) |  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateRoleasSuperAdmin

> Role UpdateRoleasSuperAdmin(ctx, id).Role(role).Execute()

Update a role

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
	id := "id_example" // string | The role id
	role := *openapiclient.NewRole(false, "Id_example", "Name_example", "Description_example", *openapiclient.NewRolePermissions(), false, false) // Role | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.RolesAPI.UpdateRoleasSuperAdmin(context.Background(), id).Role(role).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `RolesAPI.UpdateRoleasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateRoleasSuperAdmin`: Role
	fmt.Fprintf(os.Stdout, "Response from `RolesAPI.UpdateRoleasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The role id | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateRoleasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **role** | [**Role**](Role.md) |  | 

### Return type

[**Role**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

