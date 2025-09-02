# \InvitationsAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateInvitation**](InvitationsAPI.md#CreateInvitation) | **Post** /api/v1/{tenant}/invitations | Create an invitation
[**DeleteInvitation**](InvitationsAPI.md#DeleteInvitation) | **Delete** /api/v1/{tenant}/invitations/{id} | Delete an invitation
[**FindAllInvitationsForCurrentUser**](InvitationsAPI.md#FindAllInvitationsForCurrentUser) | **Get** /api/v1/me/invitations | List invitations for the authenticated user
[**GetInvitation**](InvitationsAPI.md#GetInvitation) | **Get** /api/v1/{tenant}/invitations/{id} | Retrieve an invitation
[**ListInvitationsByEmail**](InvitationsAPI.md#ListInvitationsByEmail) | **Get** /api/v1/{tenant}/invitations/email/{email} | Retrieve all invitations for a given email
[**SearchInvitations**](InvitationsAPI.md#SearchInvitations) | **Get** /api/v1/{tenant}/invitations/search | Search for invitations



## CreateInvitation

> CreateInvitation(ctx, tenant).IAMInvitationControllerApiInvitationCreateRequest(iAMInvitationControllerApiInvitationCreateRequest).Execute()

Create an invitation



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
	iAMInvitationControllerApiInvitationCreateRequest := *openapiclient.NewIAMInvitationControllerApiInvitationCreateRequest(false, false, []openapiclient.IAMInvitationControllerApiInvitationRole{*openapiclient.NewIAMInvitationControllerApiInvitationRole("Id_example", []string{"Namespaces_example"})}, []string{"Groups_example"}, "Email_example") // IAMInvitationControllerApiInvitationCreateRequest | Create a new invitation, send an email if the server-mail is enabled

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.InvitationsAPI.CreateInvitation(context.Background(), tenant).IAMInvitationControllerApiInvitationCreateRequest(iAMInvitationControllerApiInvitationCreateRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.CreateInvitation``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
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

 **iAMInvitationControllerApiInvitationCreateRequest** | [**IAMInvitationControllerApiInvitationCreateRequest**](IAMInvitationControllerApiInvitationCreateRequest.md) | Create a new invitation, send an email if the server-mail is enabled | 

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


## GetInvitation

> IAMInvitationControllerApiInvitationDetail GetInvitation(ctx, id, tenant).Execute()

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
	// response from `GetInvitation`: IAMInvitationControllerApiInvitationDetail
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

[**IAMInvitationControllerApiInvitationDetail**](IAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListInvitationsByEmail

> []IAMInvitationControllerApiInvitationDetail ListInvitationsByEmail(ctx, email, tenant).Execute()

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
	resp, r, err := apiClient.InvitationsAPI.ListInvitationsByEmail(context.Background(), email, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `InvitationsAPI.ListInvitationsByEmail``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ListInvitationsByEmail`: []IAMInvitationControllerApiInvitationDetail
	fmt.Fprintf(os.Stdout, "Response from `InvitationsAPI.ListInvitationsByEmail`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**email** | **string** | The email address of the invited | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiListInvitationsByEmailRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**[]IAMInvitationControllerApiInvitationDetail**](IAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchInvitations

> PagedResultsIAMInvitationControllerApiInvitationDetail SearchInvitations(ctx, tenant).Page(page).Size(size).Email(email).Status(status).Sort(sort).Execute()

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
	// response from `SearchInvitations`: PagedResultsIAMInvitationControllerApiInvitationDetail
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

[**PagedResultsIAMInvitationControllerApiInvitationDetail**](PagedResultsIAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

