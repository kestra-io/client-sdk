# KestraIoKestraSdk.TestSuitesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTestSuite**](TestSuitesApi.md#createTestSuite) | **POST** /api/v1/{tenant}/tests | Create a test from YAML source
[**deleteTestSuite**](TestSuitesApi.md#deleteTestSuite) | **DELETE** /api/v1/{tenant}/tests/{namespace}/{id} | Delete a test
[**deleteTestSuitesByIds**](TestSuitesApi.md#deleteTestSuitesByIds) | **DELETE** /api/v1/{tenant}/tests/by-ids | Delete multiple tests by id
[**disableTestSuitesByIds**](TestSuitesApi.md#disableTestSuitesByIds) | **POST** /api/v1/{tenant}/tests/disable/by-ids | Disable multiple tests by id
[**enableTestSuitesByIds**](TestSuitesApi.md#enableTestSuitesByIds) | **POST** /api/v1/{tenant}/tests/enable/by-ids | Enable multiple tests by id
[**getTestResult**](TestSuitesApi.md#getTestResult) | **GET** /api/v1/{tenant}/tests/results/{id} | Get a test result
[**getTestSuite**](TestSuitesApi.md#getTestSuite) | **GET** /api/v1/{tenant}/tests/{namespace}/{id} | Retrieve a test
[**getTestsLastResult**](TestSuitesApi.md#getTestsLastResult) | **POST** /api/v1/{tenant}/tests/results/search/last | Get tests last result
[**runTestSuite**](TestSuitesApi.md#runTestSuite) | **POST** /api/v1/{tenant}/tests/{namespace}/{id}/run | Run a full test
[**runTestSuitesByQuery**](TestSuitesApi.md#runTestSuitesByQuery) | **POST** /api/v1/{tenant}/tests/run | Run multiple TestSuites by query
[**searchTestSuites**](TestSuitesApi.md#searchTestSuites) | **GET** /api/v1/{tenant}/tests/search | Search for tests
[**searchTestSuitesResults**](TestSuitesApi.md#searchTestSuitesResults) | **GET** /api/v1/{tenant}/tests/results/search | Search for tests results
[**updateTestSuite**](TestSuitesApi.md#updateTestSuite) | **PUT** /api/v1/{tenant}/tests/{namespace}/{id} | Update a test from YAML source
[**validateTestSuite**](TestSuitesApi.md#validateTestSuite) | **POST** /api/v1/{tenant}/tests/validate | Validate a test



## createTestSuite

> TestSuite createTestSuite(tenant, body)

Create a test from YAML source

Creates a new test from a YAML definition. Requires TEST permission with the CREATE action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The TestSuite source code
apiInstance.createTestSuite(tenant, body, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **body** | **String**| The TestSuite source code | 

### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## deleteTestSuite

> Object deleteTestSuite(namespace, id, tenant)

Delete a test

Deletes a test by namespace and ID. Requires TEST permission with the DELETE action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let namespace = "namespace_example"; // String | The TestSuite namespace
let id = "id_example"; // String | The TestSuite ID
let tenant = "tenant_example"; // String | 
apiInstance.deleteTestSuite(namespace, id, tenant, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The TestSuite namespace | 
 **id** | **String**| The TestSuite ID | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## deleteTestSuitesByIds

> BulkResponse deleteTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest)

Delete multiple tests by id

Deletes a test by namespace and ID. Requires TEST permission with the DELETE action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let testSuiteControllerTestSuiteBulkRequest = new KestraIoKestraSdk.TestSuiteControllerTestSuiteBulkRequest(); // TestSuiteControllerTestSuiteBulkRequest | 
apiInstance.deleteTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## disableTestSuitesByIds

> BulkResponse disableTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest)

Disable multiple tests by id

Disable a test by namespace and ID. Requires TEST permission with the UPDATE action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let testSuiteControllerTestSuiteBulkRequest = new KestraIoKestraSdk.TestSuiteControllerTestSuiteBulkRequest(); // TestSuiteControllerTestSuiteBulkRequest | 
apiInstance.disableTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## enableTestSuitesByIds

> BulkResponse enableTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest)

Enable multiple tests by id

Enable a test by namespace and ID. Requires TEST permission with the UPDATE action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let testSuiteControllerTestSuiteBulkRequest = new KestraIoKestraSdk.TestSuiteControllerTestSuiteBulkRequest(); // TestSuiteControllerTestSuiteBulkRequest | 
apiInstance.enableTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | 

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## getTestResult

> TestSuiteRunResult getTestResult(id, tenant)

Get a test result

Get a test result once it was run.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let id = "id_example"; // String | The test run ID
let tenant = "tenant_example"; // String | 
apiInstance.getTestResult(id, tenant, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The test run ID | 
 **tenant** | **String**|  | 

### Return type

[**TestSuiteRunResult**](TestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getTestSuite

> TestSuite getTestSuite(namespace, id, tenant)

Retrieve a test

Retrieves a test by namespace and ID. Requires TEST permission with the READ action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let namespace = "namespace_example"; // String | The TestSuite namespace
let id = "id_example"; // String | The TestSuite ID
let tenant = "tenant_example"; // String | 
apiInstance.getTestSuite(namespace, id, tenant, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The TestSuite namespace | 
 **id** | **String**| The TestSuite ID | 
 **tenant** | **String**|  | 

### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getTestsLastResult

> TestSuiteControllerTestsLastResultResponse getTestsLastResult(tenant, testSuiteControllerSearchTestsLastResult)

Get tests last result

Get multiple tests last result for a query.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let testSuiteControllerSearchTestsLastResult = new KestraIoKestraSdk.TestSuiteControllerSearchTestsLastResult(); // TestSuiteControllerSearchTestsLastResult | 
apiInstance.getTestsLastResult(tenant, testSuiteControllerSearchTestsLastResult, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **testSuiteControllerSearchTestsLastResult** | [**TestSuiteControllerSearchTestsLastResult**](TestSuiteControllerSearchTestsLastResult.md)|  | 

### Return type

[**TestSuiteControllerTestsLastResultResponse**](TestSuiteControllerTestsLastResultResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## runTestSuite

> TestSuiteRunResult runTestSuite(namespace, id, tenant, opts)

Run a full test

Executes all test cases in the specified test. Requires TEST permission with the CREATE action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let namespace = "namespace_example"; // String | The TestSuite namespace
let id = "id_example"; // String | The TestSuite ID
let tenant = "tenant_example"; // String | 
let opts = {
  'testSuiteControllerRunRequest': new KestraIoKestraSdk.TestSuiteControllerRunRequest() // TestSuiteControllerRunRequest | 
};
apiInstance.runTestSuite(namespace, id, tenant, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The TestSuite namespace | 
 **id** | **String**| The TestSuite ID | 
 **tenant** | **String**|  | 
 **testSuiteControllerRunRequest** | [**TestSuiteControllerRunRequest**](TestSuiteControllerRunRequest.md)|  | [optional] 

### Return type

[**TestSuiteRunResult**](TestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## runTestSuitesByQuery

> TestSuiteServiceTestRunByQueryResult runTestSuitesByQuery(tenant, testSuiteServiceRunByQueryRequest)

Run multiple TestSuites by query

Executes all TestSuites impacted by the specified filter. Requires TEST permission with the CREATE action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let testSuiteServiceRunByQueryRequest = new KestraIoKestraSdk.TestSuiteServiceRunByQueryRequest(); // TestSuiteServiceRunByQueryRequest | 
apiInstance.runTestSuitesByQuery(tenant, testSuiteServiceRunByQueryRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **testSuiteServiceRunByQueryRequest** | [**TestSuiteServiceRunByQueryRequest**](TestSuiteServiceRunByQueryRequest.md)|  | 

### Return type

[**TestSuiteServiceTestRunByQueryResult**](TestSuiteServiceTestRunByQueryResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## searchTestSuites

> PagedResultsTestSuite searchTestSuites(page, size, includeChildNamespaces, tenant, opts)

Search for tests

Searches for tests with optional filtering by namespace and flow ID. Requires TEST permission with the READ action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let includeChildNamespaces = true; // Boolean | Include child namespaces in filter or not
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'namespace': "namespace_example", // String | The namespace to filter on
  'flowId': "flowId_example" // String | The flow id to filter on
};
apiInstance.searchTestSuites(page, size, includeChildNamespaces, tenant, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **includeChildNamespaces** | **Boolean**| Include child namespaces in filter or not | [default to true]
 **tenant** | **String**|  | 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **namespace** | **String**| The namespace to filter on | [optional] 
 **flowId** | **String**| The flow id to filter on | [optional] 

### Return type

[**PagedResultsTestSuite**](PagedResultsTestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchTestSuitesResults

> PagedResultsTestSuiteRunResult searchTestSuitesResults(page, size, testSuiteId, tenant, opts)

Search for tests results

with optional filtering by namespace, test suite ID and flow ID. Requires TEST permission with the READ action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let testSuiteId = "testSuiteId_example"; // String | The test suite id to filter on
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'namespace': "namespace_example", // String | The namespace to filter on
  'flowId': "flowId_example" // String | The flow id to filter on
};
apiInstance.searchTestSuitesResults(page, size, testSuiteId, tenant, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **testSuiteId** | **String**| The test suite id to filter on | 
 **tenant** | **String**|  | 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **namespace** | **String**| The namespace to filter on | [optional] 
 **flowId** | **String**| The flow id to filter on | [optional] 

### Return type

[**PagedResultsTestSuiteRunResult**](PagedResultsTestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateTestSuite

> TestSuite updateTestSuite(namespace, id, tenant, body)

Update a test from YAML source

Updates an existing test with a new YAML definition. Requires TEST permission with the UPDATE action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let namespace = "namespace_example"; // String | The TestSuite namespace
let id = "id_example"; // String | The TestSuite ID
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The TestSuite source code
apiInstance.updateTestSuite(namespace, id, tenant, body, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The TestSuite namespace | 
 **id** | **String**| The TestSuite ID | 
 **tenant** | **String**|  | 
 **body** | **String**| The TestSuite source code | 

### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## validateTestSuite

> ValidateConstraintViolation validateTestSuite(tenant, body)

Validate a test

Validates a test YAML definition without persisting it. Returns constraint violations if any. Requires TEST permission with the READ action.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The TestSuite source code
apiInstance.validateTestSuite(tenant, body, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **body** | **String**| The TestSuite source code | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

