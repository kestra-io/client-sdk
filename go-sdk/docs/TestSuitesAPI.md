# \TestSuitesAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateTestSuite**](TestSuitesAPI.md#CreateTestSuite) | **Post** /api/v1/{tenant}/tests | Create a TestSuite from yaml source
[**DeleteTestSuite**](TestSuitesAPI.md#DeleteTestSuite) | **Delete** /api/v1/{tenant}/tests/{namespace}/{id} | 
[**GetTestSuite**](TestSuitesAPI.md#GetTestSuite) | **Get** /api/v1/{tenant}/tests/{namespace}/{id} | 
[**RunTestSuite**](TestSuitesAPI.md#RunTestSuite) | **Post** /api/v1/{tenant}/tests/{namespace}/{id}/run | Run a full TestSuite
[**SearchTestSuites**](TestSuitesAPI.md#SearchTestSuites) | **Get** /api/v1/{tenant}/tests/search | 
[**UpdateTestSuite**](TestSuitesAPI.md#UpdateTestSuite) | **Put** /api/v1/{tenant}/tests/{namespace}/{id} | 
[**ValidateTestSuite**](TestSuitesAPI.md#ValidateTestSuite) | **Post** /api/v1/{tenant}/tests/validate | Validate a TestSuite



## CreateTestSuite

> TestSuite CreateTestSuite(ctx, tenant).Body(body).Execute()

Create a TestSuite from yaml source

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
	body := "body_example" // string | The TestSuite source code

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.CreateTestSuite(context.Background(), tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.CreateTestSuite``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `CreateTestSuite`: TestSuite
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.CreateTestSuite`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiCreateTestSuiteRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | **string** | The TestSuite source code | 

### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteTestSuite

> map[string]interface{} DeleteTestSuite(ctx, namespace, id, tenant).Execute()



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
	namespace := "namespace_example" // string | The TestSuite namespace
	id := "id_example" // string | The TestSuite ID
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.DeleteTestSuite(context.Background(), namespace, id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.DeleteTestSuite``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteTestSuite`: map[string]interface{}
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.DeleteTestSuite`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The TestSuite namespace | 
**id** | **string** | The TestSuite ID | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteTestSuiteRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

**map[string]interface{}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetTestSuite

> TestSuite GetTestSuite(ctx, namespace, id, tenant).Execute()



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
	namespace := "namespace_example" // string | The TestSuite namespace
	id := "id_example" // string | The TestSuite ID
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.GetTestSuite(context.Background(), namespace, id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.GetTestSuite``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GetTestSuite`: TestSuite
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.GetTestSuite`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The TestSuite namespace | 
**id** | **string** | The TestSuite ID | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetTestSuiteRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## RunTestSuite

> []TestSuiteRunResult RunTestSuite(ctx, namespace, id, tenant).Execute()

Run a full TestSuite

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
	namespace := "namespace_example" // string | The TestSuite namespace
	id := "id_example" // string | The TestSuite ID
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.RunTestSuite(context.Background(), namespace, id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.RunTestSuite``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `RunTestSuite`: []TestSuiteRunResult
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.RunTestSuite`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The TestSuite namespace | 
**id** | **string** | The TestSuite ID | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiRunTestSuiteRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------




### Return type

[**[]TestSuiteRunResult**](TestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchTestSuites

> PagedResultsTestSuite SearchTestSuites(ctx, tenant).Page(page).Size(size).Sort(sort).Namespace(namespace).FlowId(flowId).Execute()



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
	namespace := "namespace_example" // string | The namespace to filter on (optional)
	flowId := "flowId_example" // string | The flow id to filter on (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.SearchTestSuites(context.Background(), tenant).Page(page).Size(size).Sort(sort).Namespace(namespace).FlowId(flowId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.SearchTestSuites``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchTestSuites`: PagedResultsTestSuite
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.SearchTestSuites`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchTestSuitesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **namespace** | **string** | The namespace to filter on | 
 **flowId** | **string** | The flow id to filter on | 

### Return type

[**PagedResultsTestSuite**](PagedResultsTestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateTestSuite

> TestSuite UpdateTestSuite(ctx, namespace, id, tenant).Body(body).Execute()



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
	namespace := "namespace_example" // string | The TestSuite namespace
	id := "id_example" // string | The TestSuite ID
	tenant := "tenant_example" // string | 
	body := "body_example" // string | The TestSuite source code

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.UpdateTestSuite(context.Background(), namespace, id, tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.UpdateTestSuite``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `UpdateTestSuite`: TestSuite
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.UpdateTestSuite`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**namespace** | **string** | The TestSuite namespace | 
**id** | **string** | The TestSuite ID | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUpdateTestSuiteRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



 **body** | **string** | The TestSuite source code | 

### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ValidateTestSuite

> ValidateConstraintViolation ValidateTestSuite(ctx, tenant).Body(body).Execute()

Validate a TestSuite

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
	body := "body_example" // string | The TestSuite source code

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.ValidateTestSuite(context.Background(), tenant).Body(body).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.ValidateTestSuite``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `ValidateTestSuite`: ValidateConstraintViolation
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.ValidateTestSuite`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiValidateTestSuiteRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | **string** | The TestSuite source code | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

