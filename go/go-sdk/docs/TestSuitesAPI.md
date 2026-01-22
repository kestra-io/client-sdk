# \TestSuitesAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateTestSuite**](TestSuitesAPI.md#CreateTestSuite) | **Post** /api/v1/{tenant}/tests | Create a test from YAML source
[**DeleteTestSuite**](TestSuitesAPI.md#DeleteTestSuite) | **Delete** /api/v1/{tenant}/tests/{namespace}/{id} | Delete a test
[**DeleteTestSuitesByIds**](TestSuitesAPI.md#DeleteTestSuitesByIds) | **Delete** /api/v1/{tenant}/tests/by-ids | Delete multiple tests by id
[**DisableTestSuitesByIds**](TestSuitesAPI.md#DisableTestSuitesByIds) | **Post** /api/v1/{tenant}/tests/disable/by-ids | Disable multiple tests by id
[**EnableTestSuitesByIds**](TestSuitesAPI.md#EnableTestSuitesByIds) | **Post** /api/v1/{tenant}/tests/enable/by-ids | Enable multiple tests by id
[**RunTestSuite**](TestSuitesAPI.md#RunTestSuite) | **Post** /api/v1/{tenant}/tests/{namespace}/{id}/run | Run a full test
[**RunTestSuitesByQuery**](TestSuitesAPI.md#RunTestSuitesByQuery) | **Post** /api/v1/{tenant}/tests/run | Run multiple TestSuites by query
[**SearchTestSuites**](TestSuitesAPI.md#SearchTestSuites) | **Get** /api/v1/{tenant}/tests/search | Search for tests
[**SearchTestSuitesResults**](TestSuitesAPI.md#SearchTestSuitesResults) | **Get** /api/v1/{tenant}/tests/results/search | Search for tests results
[**TestResult**](TestSuitesAPI.md#TestResult) | **Get** /api/v1/{tenant}/tests/results/{id} | Get a test result
[**TestSuite**](TestSuitesAPI.md#TestSuite) | **Get** /api/v1/{tenant}/tests/{namespace}/{id} | Retrieve a test
[**TestsLastResult**](TestSuitesAPI.md#TestsLastResult) | **Post** /api/v1/{tenant}/tests/results/search/last | Get tests last result
[**UpdateTestSuite**](TestSuitesAPI.md#UpdateTestSuite) | **Put** /api/v1/{tenant}/tests/{namespace}/{id} | Update a test from YAML source
[**ValidateTestSuite**](TestSuitesAPI.md#ValidateTestSuite) | **Post** /api/v1/{tenant}/tests/validate | Validate a test



## CreateTestSuite

> TestSuite CreateTestSuite(ctx, tenant).Body(body).Execute()

Create a test from YAML source



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

Delete a test



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


## DeleteTestSuitesByIds

> BulkResponse DeleteTestSuitesByIds(ctx, tenant).TestSuiteControllerTestSuiteBulkRequest(testSuiteControllerTestSuiteBulkRequest).Execute()

Delete multiple tests by id



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
	testSuiteControllerTestSuiteBulkRequest := *openapiclient.NewTestSuiteControllerTestSuiteBulkRequest([]openapiclient.TestSuiteControllerTestSuiteApiId{*openapiclient.NewTestSuiteControllerTestSuiteApiId("Namespace_example", "Id_example")}) // TestSuiteControllerTestSuiteBulkRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.DeleteTestSuitesByIds(context.Background(), tenant).TestSuiteControllerTestSuiteBulkRequest(testSuiteControllerTestSuiteBulkRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.DeleteTestSuitesByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DeleteTestSuitesByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.DeleteTestSuitesByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteTestSuitesByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md) |  | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DisableTestSuitesByIds

> BulkResponse DisableTestSuitesByIds(ctx, tenant).TestSuiteControllerTestSuiteBulkRequest(testSuiteControllerTestSuiteBulkRequest).Execute()

Disable multiple tests by id



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
	testSuiteControllerTestSuiteBulkRequest := *openapiclient.NewTestSuiteControllerTestSuiteBulkRequest([]openapiclient.TestSuiteControllerTestSuiteApiId{*openapiclient.NewTestSuiteControllerTestSuiteApiId("Namespace_example", "Id_example")}) // TestSuiteControllerTestSuiteBulkRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.DisableTestSuitesByIds(context.Background(), tenant).TestSuiteControllerTestSuiteBulkRequest(testSuiteControllerTestSuiteBulkRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.DisableTestSuitesByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `DisableTestSuitesByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.DisableTestSuitesByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiDisableTestSuitesByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md) |  | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## EnableTestSuitesByIds

> BulkResponse EnableTestSuitesByIds(ctx, tenant).TestSuiteControllerTestSuiteBulkRequest(testSuiteControllerTestSuiteBulkRequest).Execute()

Enable multiple tests by id



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
	testSuiteControllerTestSuiteBulkRequest := *openapiclient.NewTestSuiteControllerTestSuiteBulkRequest([]openapiclient.TestSuiteControllerTestSuiteApiId{*openapiclient.NewTestSuiteControllerTestSuiteApiId("Namespace_example", "Id_example")}) // TestSuiteControllerTestSuiteBulkRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.EnableTestSuitesByIds(context.Background(), tenant).TestSuiteControllerTestSuiteBulkRequest(testSuiteControllerTestSuiteBulkRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.EnableTestSuitesByIds``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `EnableTestSuitesByIds`: BulkResponse
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.EnableTestSuitesByIds`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiEnableTestSuitesByIdsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md) |  | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## RunTestSuite

> TestSuiteRunResult RunTestSuite(ctx, namespace, id, tenant).TestSuiteControllerRunRequest(testSuiteControllerRunRequest).Execute()

Run a full test



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
	testSuiteControllerRunRequest := *openapiclient.NewTestSuiteControllerRunRequest() // TestSuiteControllerRunRequest |  (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.RunTestSuite(context.Background(), namespace, id, tenant).TestSuiteControllerRunRequest(testSuiteControllerRunRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.RunTestSuite``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `RunTestSuite`: TestSuiteRunResult
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



 **testSuiteControllerRunRequest** | [**TestSuiteControllerRunRequest**](TestSuiteControllerRunRequest.md) |  | 

### Return type

[**TestSuiteRunResult**](TestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## RunTestSuitesByQuery

> TestSuiteServiceTestRunByQueryResult RunTestSuitesByQuery(ctx, tenant).TestSuiteServiceRunByQueryRequest(testSuiteServiceRunByQueryRequest).Execute()

Run multiple TestSuites by query



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
	testSuiteServiceRunByQueryRequest := *openapiclient.NewTestSuiteServiceRunByQueryRequest(false) // TestSuiteServiceRunByQueryRequest | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.RunTestSuitesByQuery(context.Background(), tenant).TestSuiteServiceRunByQueryRequest(testSuiteServiceRunByQueryRequest).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.RunTestSuitesByQuery``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `RunTestSuitesByQuery`: TestSuiteServiceTestRunByQueryResult
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.RunTestSuitesByQuery`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiRunTestSuitesByQueryRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **testSuiteServiceRunByQueryRequest** | [**TestSuiteServiceRunByQueryRequest**](TestSuiteServiceRunByQueryRequest.md) |  | 

### Return type

[**TestSuiteServiceTestRunByQueryResult**](TestSuiteServiceTestRunByQueryResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SearchTestSuites

> PagedResultsTestSuite SearchTestSuites(ctx, tenant).Page(page).Size(size).IncludeChildNamespaces(includeChildNamespaces).Sort(sort).Namespace(namespace).FlowId(flowId).Execute()

Search for tests



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
	includeChildNamespaces := true // bool | Include child namespaces in filter or not (default to true)
	tenant := "tenant_example" // string | 
	sort := []string{"Inner_example"} // []string | The sort of current page (optional)
	namespace := "namespace_example" // string | The namespace to filter on (optional)
	flowId := "flowId_example" // string | The flow id to filter on (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.SearchTestSuites(context.Background(), tenant).Page(page).Size(size).IncludeChildNamespaces(includeChildNamespaces).Sort(sort).Namespace(namespace).FlowId(flowId).Execute()
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
 **includeChildNamespaces** | **bool** | Include child namespaces in filter or not | [default to true]

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


## SearchTestSuitesResults

> PagedResultsTestSuiteRunResult SearchTestSuitesResults(ctx, tenant).Page(page).Size(size).Sort(sort).TestSuiteId(testSuiteId).Namespace(namespace).FlowId(flowId).Execute()

Search for tests results



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
	testSuiteId := "testSuiteId_example" // string | The test suite id to filter on (optional)
	namespace := "namespace_example" // string | The namespace to filter on (optional)
	flowId := "flowId_example" // string | The flow id to filter on (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.SearchTestSuitesResults(context.Background(), tenant).Page(page).Size(size).Sort(sort).TestSuiteId(testSuiteId).Namespace(namespace).FlowId(flowId).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.SearchTestSuitesResults``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `SearchTestSuitesResults`: PagedResultsTestSuiteRunResult
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.SearchTestSuitesResults`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiSearchTestSuitesResultsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int32** | The current page | [default to 1]
 **size** | **int32** | The current page size | [default to 10]

 **sort** | **[]string** | The sort of current page | 
 **testSuiteId** | **string** | The test suite id to filter on | 
 **namespace** | **string** | The namespace to filter on | 
 **flowId** | **string** | The flow id to filter on | 

### Return type

[**PagedResultsTestSuiteRunResult**](PagedResultsTestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## TestResult

> TestSuiteRunResult TestResult(ctx, id, tenant).Execute()

Get a test result



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
	id := "id_example" // string | The test run ID
	tenant := "tenant_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.TestResult(context.Background(), id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.TestResult``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `TestResult`: TestSuiteRunResult
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.TestResult`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**id** | **string** | The test run ID | 
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiTestResultRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**TestSuiteRunResult**](TestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## TestSuite

> TestSuite TestSuite(ctx, namespace, id, tenant).Execute()

Retrieve a test



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
	resp, r, err := apiClient.TestSuitesAPI.TestSuite(context.Background(), namespace, id, tenant).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.TestSuite``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `TestSuite`: TestSuite
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.TestSuite`: %v\n", resp)
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

Other parameters are passed through a pointer to a apiTestSuiteRequest struct via the builder pattern


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


## TestsLastResult

> TestSuiteControllerTestsLastResultResponse TestsLastResult(ctx, tenant).TestSuiteControllerSearchTestsLastResult(testSuiteControllerSearchTestsLastResult).Execute()

Get tests last result



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
	testSuiteControllerSearchTestsLastResult := *openapiclient.NewTestSuiteControllerSearchTestsLastResult() // TestSuiteControllerSearchTestsLastResult | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.TestSuitesAPI.TestsLastResult(context.Background(), tenant).TestSuiteControllerSearchTestsLastResult(testSuiteControllerSearchTestsLastResult).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `TestSuitesAPI.TestsLastResult``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `TestsLastResult`: TestSuiteControllerTestsLastResultResponse
	fmt.Fprintf(os.Stdout, "Response from `TestSuitesAPI.TestsLastResult`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiTestsLastResultRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **testSuiteControllerSearchTestsLastResult** | [**TestSuiteControllerSearchTestsLastResult**](TestSuiteControllerSearchTestsLastResult.md) |  | 

### Return type

[**TestSuiteControllerTestsLastResultResponse**](TestSuiteControllerTestsLastResultResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UpdateTestSuite

> TestSuite UpdateTestSuite(ctx, namespace, id, tenant).Body(body).Execute()

Update a test from YAML source



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

Validate a test



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

