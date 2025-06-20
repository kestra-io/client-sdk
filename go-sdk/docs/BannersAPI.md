# \BannersAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateBanner**](BannersAPI.md#CreateBanner) | **Post** /api/v1/banners | Create a new banner
[**DeleteBanner**](BannersAPI.md#DeleteBanner) | **Delete** /api/v1/banners/{id} | Delete a banner
[**SearchBanners**](BannersAPI.md#SearchBanners) | **Get** /api/v1/banners/search | Get banners
[**UpdateBanner**](BannersAPI.md#UpdateBanner) | **Put** /api/v1/banners/{id} | Update a banner



## CreateBanner

> Banner CreateBanner(ctx).Banner(banner).Execute()

Create a new banner

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
	banner := *openapiclient.NewBanner() // Banner | The banner to create

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BannersAPI.CreateBanner(context.Background()).Banner(banner).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BannersAPI.CreateBanner``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateBanner`: Banner
	fmt.Fprintf(os.Stdout, "Response from `BannersAPI.CreateBanner`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateBannerRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **banner** | [**Banner**](Banner.md) | The banner to create | 

### Return type

[**Banner**](Banner.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteBanner

> DeleteBanner(ctx, id).Execute()

Delete a banner

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
	id := "id_example" // string | The banner id

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	r, err := apiClient.BannersAPI.DeleteBanner(context.Background(), id).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BannersAPI.DeleteBanner``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The banner id | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteBannerRequest struct via the builder pattern


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


## SearchBanners

> []Banner SearchBanners(ctx).Execute()

Get banners

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
	resp, r, err := apiClient.BannersAPI.SearchBanners(context.Background()).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BannersAPI.SearchBanners``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchBanners`: []Banner
	fmt.Fprintf(os.Stdout, "Response from `BannersAPI.SearchBanners`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiSearchBannersRequest struct via the builder pattern


### Return type

[**[]Banner**](Banner.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateBanner

> Banner UpdateBanner(ctx, id).Banner(banner).Execute()

Update a banner

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
	id := "id_example" // string | The banner id
	banner := *openapiclient.NewBanner() // Banner | The banner to update

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.BannersAPI.UpdateBanner(context.Background(), id).Banner(banner).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `BannersAPI.UpdateBanner``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateBanner`: Banner
	fmt.Fprintf(os.Stdout, "Response from `BannersAPI.UpdateBanner`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The banner id | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateBannerRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **banner** | [**Banner**](Banner.md) | The banner to update | 

### Return type

[**Banner**](Banner.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

