# \InvitationsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateInvitation**](InvitationsAPI.md#CreateInvitation) | **Post** /api/v1/{tenant}/invitations | Create an invitation
[**CreateInvitationWithResourceTenantasSuperAdmin**](InvitationsAPI.md#CreateInvitationWithResourceTenantasSuperAdmin) | **Post** /api/v1/tenants/{resourceTenant}/invitations | Create an invitation
[**CreateInvitationasSuperAdmin**](InvitationsAPI.md#CreateInvitationasSuperAdmin) | **Post** /api/v1/tenants/invitations | Create an invitation
[**DeleteInvitation**](InvitationsAPI.md#DeleteInvitation) | **Delete** /api/v1/{tenant}/invitations/{id} | Delete an invitation
[**DeleteInvitationWithResourceTenantasSuperAdmin**](InvitationsAPI.md#DeleteInvitationWithResourceTenantasSuperAdmin) | **Delete** /api/v1/tenants/{resourceTenant}/invitations/{id} | Delete an invitation
[**DeleteInvitationasSuperAdmin**](InvitationsAPI.md#DeleteInvitationasSuperAdmin) | **Delete** /api/v1/tenants/invitations/{id} | Delete an invitation
[**FindAllInvitationsForCurrentUser**](InvitationsAPI.md#FindAllInvitationsForCurrentUser) | **Get** /api/v1/me/invitations | List invitations for the authenticated user
[**FindAllInvitationsForCurrentUserWithTenant**](InvitationsAPI.md#FindAllInvitationsForCurrentUserWithTenant) | **Get** /api/v1/{tenant}/me/invitations | List invitations for the authenticated user
[**GetInvitation**](InvitationsAPI.md#GetInvitation) | **Get** /api/v1/{tenant}/invitations/{id} | Retrieve an invitation
[**GetInvitationWithResourceTenantasSuperAdmin**](InvitationsAPI.md#GetInvitationWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/invitations/{id} | Retrieve an invitation
[**GetInvitationasSuperAdmin**](InvitationsAPI.md#GetInvitationasSuperAdmin) | **Get** /api/v1/tenants/invitations/{id} | Retrieve an invitation
[**ListByEmail**](InvitationsAPI.md#ListByEmail) | **Get** /api/v1/{tenant}/invitations/email/{email} | Retrieve all invitations for a given email
[**ListByEmailWithResourceTenantasSuperAdmin**](InvitationsAPI.md#ListByEmailWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/invitations/email/{email} | Retrieve all invitations for a given email
[**ListByEmailasSuperAdmin**](InvitationsAPI.md#ListByEmailasSuperAdmin) | **Get** /api/v1/tenants/invitations/email/{email} | Retrieve all invitations for a given email
[**SearchInvitations**](InvitationsAPI.md#SearchInvitations) | **Get** /api/v1/{tenant}/invitations/search | Search for invitations
[**SearchInvitationsWithResourceTenantasSuperAdmin**](InvitationsAPI.md#SearchInvitationsWithResourceTenantasSuperAdmin) | **Get** /api/v1/tenants/{resourceTenant}/invitations/search | Search for invitations
[**SearchInvitationsasSuperAdmin**](InvitationsAPI.md#SearchInvitationsasSuperAdmin) | **Get** /api/v1/tenants/invitations/search | Search for invitations



## CreateInvitation

> Invitation CreateInvitation(ctx, tenant).Invitation(invitation).Execute()

Create an invitation



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	invitation := *openapiclient.NewInvitation(false, "Email_example", "Id_example", []openapiclient.Binding{*openapiclient.NewBinding("Id_example", openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example", "NamespaceId_example", false)}, []string{"GroupIds_example"}, "TenantId_example", openapiclient.Invitation.InvitationStatus("PENDING"), time.Now(), time.Now(), time.Now(), false, openapiclient.UserType("STANDARD"), false, "Link_example") // Invitation | Create a new invitation, send an email if the server-mail is enabled

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.CreateInvitation(context.Background(), tenant).Invitation(invitation).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.CreateInvitation``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateInvitation`: Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.CreateInvitation`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateInvitationRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **invitation** | [**Invitation**](Invitation.md) | Create a new invitation, send an email if the server-mail is enabled | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateInvitationWithResourceTenantasSuperAdmin

> Invitation CreateInvitationWithResourceTenantasSuperAdmin(ctx, resourceTenant).Invitation(invitation).Execute()

Create an invitation



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	resourceTenant := "resourceTenant_example" // string | 
	invitation := *openapiclient.NewInvitation(false, "Email_example", "Id_example", []openapiclient.Binding{*openapiclient.NewBinding("Id_example", openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example", "NamespaceId_example", false)}, []string{"GroupIds_example"}, "TenantId_example", openapiclient.Invitation.InvitationStatus("PENDING"), time.Now(), time.Now(), time.Now(), false, openapiclient.UserType("STANDARD"), false, "Link_example") // Invitation | Create a new invitation, send an email if the server-mail is enabled

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.CreateInvitationWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).Invitation(invitation).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.CreateInvitationWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateInvitationWithResourceTenantasSuperAdmin`: Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.CreateInvitationWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateInvitationWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **invitation** | [**Invitation**](Invitation.md) | Create a new invitation, send an email if the server-mail is enabled | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## CreateInvitationasSuperAdmin

> Invitation CreateInvitationasSuperAdmin(ctx).Invitation(invitation).Execute()

Create an invitation



### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
    "time"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	invitation := *openapiclient.NewInvitation(false, "Email_example", "Id_example", []openapiclient.Binding{*openapiclient.NewBinding("Id_example", openapiclient.Binding.Type("USER"), "ExternalId_example", "RoleId_example", "NamespaceId_example", false)}, []string{"GroupIds_example"}, "TenantId_example", openapiclient.Invitation.InvitationStatus("PENDING"), time.Now(), time.Now(), time.Now(), false, openapiclient.UserType("STANDARD"), false, "Link_example") // Invitation | Create a new invitation, send an email if the server-mail is enabled

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.CreateInvitationasSuperAdmin(context.Background()).Invitation(invitation).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.CreateInvitationasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateInvitationasSuperAdmin`: Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.CreateInvitationasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateInvitationasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invitation** | [**Invitation**](Invitation.md) | Create a new invitation, send an email if the server-mail is enabled | 

### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteInvitation

> DeleteInvitation(ctx, id, tenant).Execute()

Delete an invitation



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
	id := "id_example" // string | The id of the invitation
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.InvitationsAPI.DeleteInvitation(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.DeleteInvitation``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The id of the invitation | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteInvitationRequest struct via the builder pattern


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


## DeleteInvitationWithResourceTenantasSuperAdmin

> DeleteInvitationWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

Delete an invitation



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
	id := "id_example" // string | The id of the invitation
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.InvitationsAPI.DeleteInvitationWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.DeleteInvitationWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The id of the invitation | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteInvitationWithResourceTenantasSuperAdminRequest struct via the builder pattern


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


## DeleteInvitationasSuperAdmin

> DeleteInvitationasSuperAdmin(ctx, id).Execute()

Delete an invitation



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
	id := "id_example" // string | The id of the invitation

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.InvitationsAPI.DeleteInvitationasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.DeleteInvitationasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The id of the invitation | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteInvitationasSuperAdminRequest struct via the builder pattern


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


## FindAllInvitationsForCurrentUser

> []Invitation FindAllInvitationsForCurrentUser(ctx).Execute()

List invitations for the authenticated user



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
	resp, r, err := apiClient.InvitationsAPI.FindAllInvitationsForCurrentUser(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.FindAllInvitationsForCurrentUser``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindAllInvitationsForCurrentUser`: []Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.FindAllInvitationsForCurrentUser`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiFindAllInvitationsForCurrentUserRequest struct via the builder pattern


### Return type

[**[]Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## FindAllInvitationsForCurrentUserWithTenant

> []Invitation FindAllInvitationsForCurrentUserWithTenant(ctx, tenant).Execute()

List invitations for the authenticated user



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
	resp, r, err := apiClient.InvitationsAPI.FindAllInvitationsForCurrentUserWithTenant(context.Background(), tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.FindAllInvitationsForCurrentUserWithTenant``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `FindAllInvitationsForCurrentUserWithTenant`: []Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.FindAllInvitationsForCurrentUserWithTenant`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiFindAllInvitationsForCurrentUserWithTenantRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**[]Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetInvitation

> Invitation GetInvitation(ctx, id, tenant).Execute()

Retrieve an invitation



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
	id := "id_example" // string | The id of the invitation
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.GetInvitation(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.GetInvitation``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetInvitation`: Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.GetInvitation`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The id of the invitation | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetInvitationRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetInvitationWithResourceTenantasSuperAdmin

> Invitation GetInvitationWithResourceTenantasSuperAdmin(ctx, id, resourceTenant).Execute()

Retrieve an invitation



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
	id := "id_example" // string | The id of the invitation
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.GetInvitationWithResourceTenantasSuperAdmin(context.Background(), id, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.GetInvitationWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetInvitationWithResourceTenantasSuperAdmin`: Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.GetInvitationWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The id of the invitation | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetInvitationWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetInvitationasSuperAdmin

> Invitation GetInvitationasSuperAdmin(ctx, id).Execute()

Retrieve an invitation



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
	id := "id_example" // string | The id of the invitation

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.GetInvitationasSuperAdmin(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.GetInvitationasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetInvitationasSuperAdmin`: Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.GetInvitationasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The id of the invitation | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetInvitationasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListByEmail

> []Invitation ListByEmail(ctx, email, tenant).Execute()

Retrieve all invitations for a given email



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
	email := "email_example" // string | The email address of the invited
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.ListByEmail(context.Background(), email, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.ListByEmail``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListByEmail`: []Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.ListByEmail`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**email** | **string** | The email address of the invited | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListByEmailRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListByEmailWithResourceTenantasSuperAdmin

> []Invitation ListByEmailWithResourceTenantasSuperAdmin(ctx, email, resourceTenant).Execute()

Retrieve all invitations for a given email



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
	email := "email_example" // string | The email address of the invited
	resourceTenant := "resourceTenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.ListByEmailWithResourceTenantasSuperAdmin(context.Background(), email, resourceTenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.ListByEmailWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListByEmailWithResourceTenantasSuperAdmin`: []Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.ListByEmailWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**email** | **string** | The email address of the invited | 
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListByEmailWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListByEmailasSuperAdmin

> []Invitation ListByEmailasSuperAdmin(ctx, email).Execute()

Retrieve all invitations for a given email



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
	email := "email_example" // string | The email address of the invited

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.ListByEmailasSuperAdmin(context.Background(), email).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.ListByEmailasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListByEmailasSuperAdmin`: []Invitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.ListByEmailasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**email** | **string** | The email address of the invited | 

### Other Parameters

Other parameters are passed through a pointer to a apiListByEmailasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**[]Invitation**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchInvitations

> PagedResultsInvitation SearchInvitations(ctx, tenant).Page(page).Size(size).Email(email).Status(status).Sort(sort).Execute()

Search for invitations



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
	email := "email_example" // string | The email address of the invited (optional)
	status := openapiclient.Invitation.InvitationStatus("PENDING") // InvitationInvitationStatus | The current status of the invitations (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.SearchInvitations(context.Background(), tenant).Page(page).Size(size).Email(email).Status(status).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.SearchInvitations``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchInvitations`: PagedResultsInvitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.SearchInvitations`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchInvitationsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **email** | **string** | The email address of the invited | 
 **status** | [**InvitationInvitationStatus**](InvitationInvitationStatus.md) | The current status of the invitations | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsInvitation**](PagedResultsInvitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchInvitationsWithResourceTenantasSuperAdmin

> PagedResultsInvitation SearchInvitationsWithResourceTenantasSuperAdmin(ctx, resourceTenant).Page(page).Size(size).Email(email).Status(status).Sort(sort).Execute()

Search for invitations



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
	email := "email_example" // string | The email address of the invited (optional)
	status := openapiclient.Invitation.InvitationStatus("PENDING") // InvitationInvitationStatus | The current status of the invitations (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.SearchInvitationsWithResourceTenantasSuperAdmin(context.Background(), resourceTenant).Page(page).Size(size).Email(email).Status(status).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.SearchInvitationsWithResourceTenantasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchInvitationsWithResourceTenantasSuperAdmin`: PagedResultsInvitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.SearchInvitationsWithResourceTenantasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**resourceTenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchInvitationsWithResourceTenantasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **email** | **string** | The email address of the invited | 
 **status** | [**InvitationInvitationStatus**](InvitationInvitationStatus.md) | The current status of the invitations | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsInvitation**](PagedResultsInvitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchInvitationsasSuperAdmin

> PagedResultsInvitation SearchInvitationsasSuperAdmin(ctx).Page(page).Size(size).Email(email).Status(status).Sort(sort).Execute()

Search for invitations



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
	email := "email_example" // string | The email address of the invited (optional)
	status := openapiclient.Invitation.InvitationStatus("PENDING") // InvitationInvitationStatus | The current status of the invitations (optional)
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.InvitationsAPI.SearchInvitationsasSuperAdmin(context.Background()).Page(page).Size(size).Email(email).Status(status).Sort(sort).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.SearchInvitationsasSuperAdmin``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchInvitationsasSuperAdmin`: PagedResultsInvitation
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.SearchInvitationsasSuperAdmin`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSearchInvitationsasSuperAdminRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]
 **email** | **string** | The email address of the invited | 
 **status** | [**InvitationInvitationStatus**](InvitationInvitationStatus.md) | The current status of the invitations | 
 **sort** | **[]string** | The sort of current page | 

### Return type

[**PagedResultsInvitation**](PagedResultsInvitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

