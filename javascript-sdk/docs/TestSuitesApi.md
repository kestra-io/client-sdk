# KestraApi.TestSuitesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTestSuite**](TestSuitesApi.md#createTestSuite) | **POST** /api/v1/{tenant}/tests | Create a TestSuite from yaml source
[**deleteTestSuite**](TestSuitesApi.md#deleteTestSuite) | **DELETE** /api/v1/{tenant}/tests/{namespace}/{id} | 
[**getTestSuite**](TestSuitesApi.md#getTestSuite) | **GET** /api/v1/{tenant}/tests/{namespace}/{id} | 
[**runTestSuite**](TestSuitesApi.md#runTestSuite) | **POST** /api/v1/{tenant}/tests/{namespace}/{id}/run | Run a full TestSuite
[**searchTestSuites**](TestSuitesApi.md#searchTestSuites) | **GET** /api/v1/{tenant}/tests/search | 
[**updateTestSuite**](TestSuitesApi.md#updateTestSuite) | **PUT** /api/v1/{tenant}/tests/{namespace}/{id} | 
[**validateTestSuite**](TestSuitesApi.md#validateTestSuite) | **POST** /api/v1/{tenant}/tests/validate | Validate a TestSuite



## createTestSuite

> TestSuite createTestSuite(tenant, body)

Create a TestSuite from yaml source

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The TestSuite source code
apiInstance.createTestSuite(tenant, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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



### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TestSuitesApi();
let namespace = "namespace_example"; // String | The TestSuite namespace
let id = "id_example"; // String | The TestSuite ID
let tenant = "tenant_example"; // String | 
apiInstance.deleteTestSuite(namespace, id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## getTestSuite

> TestSuite getTestSuite(namespace, id, tenant)



### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TestSuitesApi();
let namespace = "namespace_example"; // String | The TestSuite namespace
let id = "id_example"; // String | The TestSuite ID
let tenant = "tenant_example"; // String | 
apiInstance.getTestSuite(namespace, id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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


## runTestSuite

> [TestSuiteRunResult] runTestSuite(namespace, id, tenant)

Run a full TestSuite

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TestSuitesApi();
let namespace = "namespace_example"; // String | The TestSuite namespace
let id = "id_example"; // String | The TestSuite ID
let tenant = "tenant_example"; // String | 
apiInstance.runTestSuite(namespace, id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The TestSuite namespace | 
 **id** | **String**| The TestSuite ID | 
 **tenant** | **String**|  | 

### Return type

[**[TestSuiteRunResult]**](TestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchTestSuites

> PagedResultsTestSuite searchTestSuites(page, size, tenant, opts)



### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TestSuitesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'namespace': "namespace_example", // String | The namespace to filter on
  'flowId': "flowId_example" // String | The flow id to filter on
};
apiInstance.searchTestSuites(page, size, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
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


## updateTestSuite

> TestSuite updateTestSuite(namespace, id, tenant, body)



### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TestSuitesApi();
let namespace = "namespace_example"; // String | The TestSuite namespace
let id = "id_example"; // String | The TestSuite ID
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The TestSuite source code
apiInstance.updateTestSuite(namespace, id, tenant, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

Validate a TestSuite

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.TestSuitesApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The TestSuite source code
apiInstance.validateTestSuite(tenant, body).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

