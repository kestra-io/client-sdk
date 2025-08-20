# TestSuitesApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTestSuite**](TestSuitesApi.md#createTestSuite) | **POST** /api/v1/{tenant}/tests | Create a test from YAML source |
| [**deleteTestSuite**](TestSuitesApi.md#deleteTestSuite) | **DELETE** /api/v1/{tenant}/tests/{namespace}/{id} | Delete a test |
| [**deleteTestSuitesByIds**](TestSuitesApi.md#deleteTestSuitesByIds) | **DELETE** /api/v1/{tenant}/tests/by-ids | Delete multiple tests by id |
| [**disableTestSuitesByIds**](TestSuitesApi.md#disableTestSuitesByIds) | **POST** /api/v1/{tenant}/tests/disable/by-ids | Disable multiple tests by id |
| [**enableTestSuitesByIds**](TestSuitesApi.md#enableTestSuitesByIds) | **POST** /api/v1/{tenant}/tests/enable/by-ids | Enable multiple tests by id |
| [**getTestResult**](TestSuitesApi.md#getTestResult) | **GET** /api/v1/{tenant}/tests/results/{id} | Get a test result |
| [**getTestSuite**](TestSuitesApi.md#getTestSuite) | **GET** /api/v1/{tenant}/tests/{namespace}/{id} | Retrieve a test |
| [**getTestsLastResult**](TestSuitesApi.md#getTestsLastResult) | **POST** /api/v1/{tenant}/tests/results/search/last | Get tests last result |
| [**runTestSuite**](TestSuitesApi.md#runTestSuite) | **POST** /api/v1/{tenant}/tests/{namespace}/{id}/run | Run a full test |
| [**searchTestSuites**](TestSuitesApi.md#searchTestSuites) | **GET** /api/v1/{tenant}/tests/search | Search for tests |
| [**updateTestSuite**](TestSuitesApi.md#updateTestSuite) | **PUT** /api/v1/{tenant}/tests/{namespace}/{id} | Update a test from YAML source |
| [**validateTestSuite**](TestSuitesApi.md#validateTestSuite) | **POST** /api/v1/{tenant}/tests/validate | Validate a test |



## createTestSuite

> TestSuite createTestSuite(tenant, body)

Create a test from YAML source

Creates a new test from a YAML definition. Requires TEST permission with the CREATE action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The TestSuite source code
        try {
            TestSuite result = apiInstance.createTestSuite(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#createTestSuite");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **body** | **String**| The TestSuite source code | |

### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createTestSuite 200 response |  -  |


## deleteTestSuite

> Object deleteTestSuite(namespace, id, tenant)

Delete a test

Deletes a test by namespace and ID. Requires TEST permission with the DELETE action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String namespace = "namespace_example"; // String | The TestSuite namespace
        String id = "id_example"; // String | The TestSuite ID
        String tenant = "tenant_example"; // String | 
        try {
            Object result = apiInstance.deleteTestSuite(namespace, id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#deleteTestSuite");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The TestSuite namespace | |
| **id** | **String**| The TestSuite ID | |
| **tenant** | **String**|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteTestSuite 200 response |  -  |


## deleteTestSuitesByIds

> BulkResponse deleteTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest)

Delete multiple tests by id

Deletes a test by namespace and ID. Requires TEST permission with the DELETE action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        TestSuiteControllerTestSuiteBulkRequest testSuiteControllerTestSuiteBulkRequest = new TestSuiteControllerTestSuiteBulkRequest(); // TestSuiteControllerTestSuiteBulkRequest | 
        try {
            BulkResponse result = apiInstance.deleteTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#deleteTestSuitesByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteTestSuitesByIds 200 response |  -  |


## disableTestSuitesByIds

> BulkResponse disableTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest)

Disable multiple tests by id

Disable a test by namespace and ID. Requires TEST permission with the UPDATE action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        TestSuiteControllerTestSuiteBulkRequest testSuiteControllerTestSuiteBulkRequest = new TestSuiteControllerTestSuiteBulkRequest(); // TestSuiteControllerTestSuiteBulkRequest | 
        try {
            BulkResponse result = apiInstance.disableTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#disableTestSuitesByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | disableTestSuitesByIds 200 response |  -  |


## enableTestSuitesByIds

> BulkResponse enableTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest)

Enable multiple tests by id

Enable a test by namespace and ID. Requires TEST permission with the UPDATE action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        TestSuiteControllerTestSuiteBulkRequest testSuiteControllerTestSuiteBulkRequest = new TestSuiteControllerTestSuiteBulkRequest(); // TestSuiteControllerTestSuiteBulkRequest | 
        try {
            BulkResponse result = apiInstance.enableTestSuitesByIds(tenant, testSuiteControllerTestSuiteBulkRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#enableTestSuitesByIds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **testSuiteControllerTestSuiteBulkRequest** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | enableTestSuitesByIds 200 response |  -  |


## getTestResult

> TestSuiteRunResult getTestResult(id, tenant)

Get a test result

Get a test result once it was run.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String id = "id_example"; // String | The test run ID
        String tenant = "tenant_example"; // String | 
        try {
            TestSuiteRunResult result = apiInstance.getTestResult(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#getTestResult");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The test run ID | |
| **tenant** | **String**|  | |

### Return type

[**TestSuiteRunResult**](TestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getTestResult 200 response |  -  |


## getTestSuite

> TestSuite getTestSuite(namespace, id, tenant)

Retrieve a test

Retrieves a test by namespace and ID. Requires TEST permission with the READ action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String namespace = "namespace_example"; // String | The TestSuite namespace
        String id = "id_example"; // String | The TestSuite ID
        String tenant = "tenant_example"; // String | 
        try {
            TestSuite result = apiInstance.getTestSuite(namespace, id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#getTestSuite");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The TestSuite namespace | |
| **id** | **String**| The TestSuite ID | |
| **tenant** | **String**|  | |

### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getTestSuite 200 response |  -  |


## getTestsLastResult

> TestSuiteControllerTestsLastResultResponse getTestsLastResult(tenant, testSuiteControllerSearchTestsLastResult)

Get tests last result

Get multiple tests last result for a query.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        TestSuiteControllerSearchTestsLastResult testSuiteControllerSearchTestsLastResult = new TestSuiteControllerSearchTestsLastResult(); // TestSuiteControllerSearchTestsLastResult | 
        try {
            TestSuiteControllerTestsLastResultResponse result = apiInstance.getTestsLastResult(tenant, testSuiteControllerSearchTestsLastResult);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#getTestsLastResult");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **testSuiteControllerSearchTestsLastResult** | [**TestSuiteControllerSearchTestsLastResult**](TestSuiteControllerSearchTestsLastResult.md)|  | |

### Return type

[**TestSuiteControllerTestsLastResultResponse**](TestSuiteControllerTestsLastResultResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getTestsLastResult 200 response |  -  |


## runTestSuite

> TestSuiteRunResult runTestSuite(namespace, id, tenant, testSuiteControllerRunRequest)

Run a full test

Executes all test cases in the specified test. Requires TEST permission with the CREATE action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String namespace = "namespace_example"; // String | The TestSuite namespace
        String id = "id_example"; // String | The TestSuite ID
        String tenant = "tenant_example"; // String | 
        TestSuiteControllerRunRequest testSuiteControllerRunRequest = new TestSuiteControllerRunRequest(); // TestSuiteControllerRunRequest | 
        try {
            TestSuiteRunResult result = apiInstance.runTestSuite(namespace, id, tenant, testSuiteControllerRunRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#runTestSuite");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The TestSuite namespace | |
| **id** | **String**| The TestSuite ID | |
| **tenant** | **String**|  | |
| **testSuiteControllerRunRequest** | [**TestSuiteControllerRunRequest**](TestSuiteControllerRunRequest.md)|  | [optional] |

### Return type

[**TestSuiteRunResult**](TestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | runTestSuite 200 response |  -  |


## searchTestSuites

> PagedResultsTestSuite searchTestSuites(page, size, tenant, sort, namespace, flowId)

Search for tests

Searches for tests with optional filtering by namespace and flow ID. Requires TEST permission with the READ action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        String namespace = "namespace_example"; // String | The namespace to filter on
        String flowId = "flowId_example"; // String | The flow id to filter on
        try {
            PagedResultsTestSuite result = apiInstance.searchTestSuites(page, size, tenant, sort, namespace, flowId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#searchTestSuites");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| The current page | [default to 1] |
| **size** | **Integer**| The current page size | [default to 10] |
| **tenant** | **String**|  | |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **namespace** | **String**| The namespace to filter on | [optional] |
| **flowId** | **String**| The flow id to filter on | [optional] |

### Return type

[**PagedResultsTestSuite**](PagedResultsTestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchTestSuites 200 response |  -  |


## updateTestSuite

> TestSuite updateTestSuite(namespace, id, tenant, body)

Update a test from YAML source

Updates an existing test with a new YAML definition. Requires TEST permission with the UPDATE action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String namespace = "namespace_example"; // String | The TestSuite namespace
        String id = "id_example"; // String | The TestSuite ID
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The TestSuite source code
        try {
            TestSuite result = apiInstance.updateTestSuite(namespace, id, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#updateTestSuite");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **namespace** | **String**| The TestSuite namespace | |
| **id** | **String**| The TestSuite ID | |
| **tenant** | **String**|  | |
| **body** | **String**| The TestSuite source code | |

### Return type

[**TestSuite**](TestSuite.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateTestSuite 200 response |  -  |


## validateTestSuite

> ValidateConstraintViolation validateTestSuite(tenant, body)

Validate a test

Validates a test YAML definition without persisting it. Returns constraint violations if any. Requires TEST permission with the READ action.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.TestSuitesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        TestSuitesApi apiInstance = new TestSuitesApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The TestSuite source code
        try {
            ValidateConstraintViolation result = apiInstance.validateTestSuite(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TestSuitesApi#validateTestSuite");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **body** | **String**| The TestSuite source code | |

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | validateTestSuite 200 response |  -  |

