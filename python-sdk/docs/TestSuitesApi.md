# kestrapy.TestSuitesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_test_suite**](TestSuitesApi.md#create_test_suite) | **POST** /api/v1/{tenant}/tests | Create a test from YAML source
[**delete_test_suite**](TestSuitesApi.md#delete_test_suite) | **DELETE** /api/v1/{tenant}/tests/{namespace}/{id} | Delete a test
[**delete_test_suites_by_ids**](TestSuitesApi.md#delete_test_suites_by_ids) | **DELETE** /api/v1/{tenant}/tests/by-ids | Delete multiple tests by id
[**disable_test_suites_by_ids**](TestSuitesApi.md#disable_test_suites_by_ids) | **POST** /api/v1/{tenant}/tests/disable/by-ids | Disable multiple tests by id
[**enable_test_suites_by_ids**](TestSuitesApi.md#enable_test_suites_by_ids) | **POST** /api/v1/{tenant}/tests/enable/by-ids | Enable multiple tests by id
[**get_test_result**](TestSuitesApi.md#get_test_result) | **GET** /api/v1/{tenant}/tests/results/{id} | Get a test result
[**get_test_suite**](TestSuitesApi.md#get_test_suite) | **GET** /api/v1/{tenant}/tests/{namespace}/{id} | Retrieve a test
[**get_tests_last_result**](TestSuitesApi.md#get_tests_last_result) | **POST** /api/v1/{tenant}/tests/results/search/last | Get tests last result
[**run_test_suite**](TestSuitesApi.md#run_test_suite) | **POST** /api/v1/{tenant}/tests/{namespace}/{id}/run | Run a full test
[**run_test_suites_by_query**](TestSuitesApi.md#run_test_suites_by_query) | **POST** /api/v1/{tenant}/tests/run | Run multiple TestSuites by query
[**search_test_suites**](TestSuitesApi.md#search_test_suites) | **GET** /api/v1/{tenant}/tests/search | Search for tests
[**search_test_suites_results**](TestSuitesApi.md#search_test_suites_results) | **GET** /api/v1/{tenant}/tests/results/search | Search for tests results
[**update_test_suite**](TestSuitesApi.md#update_test_suite) | **PUT** /api/v1/{tenant}/tests/{namespace}/{id} | Update a test from YAML source
[**validate_test_suite**](TestSuitesApi.md#validate_test_suite) | **POST** /api/v1/{tenant}/tests/validate | Validate a test


# **create_test_suite**
> TestSuite create_test_suite(tenant, body)

Create a test from YAML source

Creates a new test from a YAML definition. Requires TEST permission with the CREATE action.

### Example


```python
import kestrapy
from kestrapy.models.test_suite import TestSuite
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The TestSuite source code

    try:
        # Create a test from YAML source
        api_response = api_instance.create_test_suite(tenant, body)
        print("The response of TestSuitesApi->create_test_suite:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->create_test_suite: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The TestSuite source code | 

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
**200** | createTestSuite 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_test_suite**
> object delete_test_suite(namespace, id, tenant)

Delete a test

Deletes a test by namespace and ID. Requires TEST permission with the DELETE action.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    namespace = 'namespace_example' # str | The TestSuite namespace
    id = 'id_example' # str | The TestSuite ID
    tenant = 'tenant_example' # str | 

    try:
        # Delete a test
        api_response = api_instance.delete_test_suite(namespace, id, tenant)
        print("The response of TestSuitesApi->delete_test_suite:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->delete_test_suite: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The TestSuite namespace | 
 **id** | **str**| The TestSuite ID | 
 **tenant** | **str**|  | 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteTestSuite 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_test_suites_by_ids**
> BulkResponse delete_test_suites_by_ids(tenant, test_suite_controller_test_suite_bulk_request)

Delete multiple tests by id

Deletes a test by namespace and ID. Requires TEST permission with the DELETE action.

### Example


```python
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.test_suite_controller_test_suite_bulk_request import TestSuiteControllerTestSuiteBulkRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    tenant = 'tenant_example' # str | 
    test_suite_controller_test_suite_bulk_request = kestrapy.TestSuiteControllerTestSuiteBulkRequest() # TestSuiteControllerTestSuiteBulkRequest | 

    try:
        # Delete multiple tests by id
        api_response = api_instance.delete_test_suites_by_ids(tenant, test_suite_controller_test_suite_bulk_request)
        print("The response of TestSuitesApi->delete_test_suites_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->delete_test_suites_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **test_suite_controller_test_suite_bulk_request** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | 

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
**200** | deleteTestSuitesByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disable_test_suites_by_ids**
> BulkResponse disable_test_suites_by_ids(tenant, test_suite_controller_test_suite_bulk_request)

Disable multiple tests by id

Disable a test by namespace and ID. Requires TEST permission with the UPDATE action.

### Example


```python
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.test_suite_controller_test_suite_bulk_request import TestSuiteControllerTestSuiteBulkRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    tenant = 'tenant_example' # str | 
    test_suite_controller_test_suite_bulk_request = kestrapy.TestSuiteControllerTestSuiteBulkRequest() # TestSuiteControllerTestSuiteBulkRequest | 

    try:
        # Disable multiple tests by id
        api_response = api_instance.disable_test_suites_by_ids(tenant, test_suite_controller_test_suite_bulk_request)
        print("The response of TestSuitesApi->disable_test_suites_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->disable_test_suites_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **test_suite_controller_test_suite_bulk_request** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | 

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
**200** | disableTestSuitesByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **enable_test_suites_by_ids**
> BulkResponse enable_test_suites_by_ids(tenant, test_suite_controller_test_suite_bulk_request)

Enable multiple tests by id

Enable a test by namespace and ID. Requires TEST permission with the UPDATE action.

### Example


```python
import kestrapy
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.test_suite_controller_test_suite_bulk_request import TestSuiteControllerTestSuiteBulkRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    tenant = 'tenant_example' # str | 
    test_suite_controller_test_suite_bulk_request = kestrapy.TestSuiteControllerTestSuiteBulkRequest() # TestSuiteControllerTestSuiteBulkRequest | 

    try:
        # Enable multiple tests by id
        api_response = api_instance.enable_test_suites_by_ids(tenant, test_suite_controller_test_suite_bulk_request)
        print("The response of TestSuitesApi->enable_test_suites_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->enable_test_suites_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **test_suite_controller_test_suite_bulk_request** | [**TestSuiteControllerTestSuiteBulkRequest**](TestSuiteControllerTestSuiteBulkRequest.md)|  | 

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
**200** | enableTestSuitesByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_test_result**
> TestSuiteRunResult get_test_result(id, tenant)

Get a test result

Get a test result once it was run.

### Example


```python
import kestrapy
from kestrapy.models.test_suite_run_result import TestSuiteRunResult
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    id = 'id_example' # str | The test run ID
    tenant = 'tenant_example' # str | 

    try:
        # Get a test result
        api_response = api_instance.get_test_result(id, tenant)
        print("The response of TestSuitesApi->get_test_result:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->get_test_result: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The test run ID | 
 **tenant** | **str**|  | 

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
**200** | getTestResult 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_test_suite**
> TestSuite get_test_suite(namespace, id, tenant)

Retrieve a test

Retrieves a test by namespace and ID. Requires TEST permission with the READ action.

### Example


```python
import kestrapy
from kestrapy.models.test_suite import TestSuite
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    namespace = 'namespace_example' # str | The TestSuite namespace
    id = 'id_example' # str | The TestSuite ID
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a test
        api_response = api_instance.get_test_suite(namespace, id, tenant)
        print("The response of TestSuitesApi->get_test_suite:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->get_test_suite: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The TestSuite namespace | 
 **id** | **str**| The TestSuite ID | 
 **tenant** | **str**|  | 

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
**200** | getTestSuite 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_tests_last_result**
> TestSuiteControllerTestsLastResultResponse get_tests_last_result(tenant, test_suite_controller_search_tests_last_result)

Get tests last result

Get multiple tests last result for a query.

### Example


```python
import kestrapy
from kestrapy.models.test_suite_controller_search_tests_last_result import TestSuiteControllerSearchTestsLastResult
from kestrapy.models.test_suite_controller_tests_last_result_response import TestSuiteControllerTestsLastResultResponse
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    tenant = 'tenant_example' # str | 
    test_suite_controller_search_tests_last_result = kestrapy.TestSuiteControllerSearchTestsLastResult() # TestSuiteControllerSearchTestsLastResult | 

    try:
        # Get tests last result
        api_response = api_instance.get_tests_last_result(tenant, test_suite_controller_search_tests_last_result)
        print("The response of TestSuitesApi->get_tests_last_result:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->get_tests_last_result: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **test_suite_controller_search_tests_last_result** | [**TestSuiteControllerSearchTestsLastResult**](TestSuiteControllerSearchTestsLastResult.md)|  | 

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
**200** | getTestsLastResult 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **run_test_suite**
> TestSuiteRunResult run_test_suite(namespace, id, tenant, test_suite_controller_run_request=test_suite_controller_run_request)

Run a full test

Executes all test cases in the specified test. Requires TEST permission with the CREATE action.

### Example


```python
import kestrapy
from kestrapy.models.test_suite_controller_run_request import TestSuiteControllerRunRequest
from kestrapy.models.test_suite_run_result import TestSuiteRunResult
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    namespace = 'namespace_example' # str | The TestSuite namespace
    id = 'id_example' # str | The TestSuite ID
    tenant = 'tenant_example' # str | 
    test_suite_controller_run_request = kestrapy.TestSuiteControllerRunRequest() # TestSuiteControllerRunRequest |  (optional)

    try:
        # Run a full test
        api_response = api_instance.run_test_suite(namespace, id, tenant, test_suite_controller_run_request=test_suite_controller_run_request)
        print("The response of TestSuitesApi->run_test_suite:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->run_test_suite: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The TestSuite namespace | 
 **id** | **str**| The TestSuite ID | 
 **tenant** | **str**|  | 
 **test_suite_controller_run_request** | [**TestSuiteControllerRunRequest**](TestSuiteControllerRunRequest.md)|  | [optional] 

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
**200** | runTestSuite 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **run_test_suites_by_query**
> TestSuiteServiceTestRunByQueryResult run_test_suites_by_query(tenant, test_suite_service_run_by_query_request)

Run multiple TestSuites by query

Executes all TestSuites impacted by the specified filter. Requires TEST permission with the CREATE action.

### Example


```python
import kestrapy
from kestrapy.models.test_suite_service_run_by_query_request import TestSuiteServiceRunByQueryRequest
from kestrapy.models.test_suite_service_test_run_by_query_result import TestSuiteServiceTestRunByQueryResult
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    tenant = 'tenant_example' # str | 
    test_suite_service_run_by_query_request = kestrapy.TestSuiteServiceRunByQueryRequest() # TestSuiteServiceRunByQueryRequest | 

    try:
        # Run multiple TestSuites by query
        api_response = api_instance.run_test_suites_by_query(tenant, test_suite_service_run_by_query_request)
        print("The response of TestSuitesApi->run_test_suites_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->run_test_suites_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **test_suite_service_run_by_query_request** | [**TestSuiteServiceRunByQueryRequest**](TestSuiteServiceRunByQueryRequest.md)|  | 

### Return type

[**TestSuiteServiceTestRunByQueryResult**](TestSuiteServiceTestRunByQueryResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | runTestSuitesByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_test_suites**
> PagedResultsTestSuite search_test_suites(page, size, include_child_namespaces, tenant, sort=sort, namespace=namespace, flow_id=flow_id)

Search for tests

Searches for tests with optional filtering by namespace and flow ID. Requires TEST permission with the READ action.

### Example


```python
import kestrapy
from kestrapy.models.paged_results_test_suite import PagedResultsTestSuite
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    include_child_namespaces = True # bool | Include child namespaces in filter or not (default to True)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    namespace = 'namespace_example' # str | The namespace to filter on (optional)
    flow_id = 'flow_id_example' # str | The flow id to filter on (optional)

    try:
        # Search for tests
        api_response = api_instance.search_test_suites(page, size, include_child_namespaces, tenant, sort=sort, namespace=namespace, flow_id=flow_id)
        print("The response of TestSuitesApi->search_test_suites:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->search_test_suites: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **include_child_namespaces** | **bool**| Include child namespaces in filter or not | [default to True]
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **namespace** | **str**| The namespace to filter on | [optional] 
 **flow_id** | **str**| The flow id to filter on | [optional] 

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
**200** | searchTestSuites 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_test_suites_results**
> PagedResultsTestSuiteRunResult search_test_suites_results(page, size, test_suite_id, tenant, sort=sort, namespace=namespace, flow_id=flow_id)

Search for tests results

with optional filtering by namespace, test suite ID and flow ID. Requires TEST permission with the READ action.

### Example


```python
import kestrapy
from kestrapy.models.paged_results_test_suite_run_result import PagedResultsTestSuiteRunResult
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    test_suite_id = 'test_suite_id_example' # str | The test suite id to filter on
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    namespace = 'namespace_example' # str | The namespace to filter on (optional)
    flow_id = 'flow_id_example' # str | The flow id to filter on (optional)

    try:
        # Search for tests results
        api_response = api_instance.search_test_suites_results(page, size, test_suite_id, tenant, sort=sort, namespace=namespace, flow_id=flow_id)
        print("The response of TestSuitesApi->search_test_suites_results:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->search_test_suites_results: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **test_suite_id** | **str**| The test suite id to filter on | 
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **namespace** | **str**| The namespace to filter on | [optional] 
 **flow_id** | **str**| The flow id to filter on | [optional] 

### Return type

[**PagedResultsTestSuiteRunResult**](PagedResultsTestSuiteRunResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchTestSuitesResults 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_test_suite**
> TestSuite update_test_suite(namespace, id, tenant, body)

Update a test from YAML source

Updates an existing test with a new YAML definition. Requires TEST permission with the UPDATE action.

### Example


```python
import kestrapy
from kestrapy.models.test_suite import TestSuite
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    namespace = 'namespace_example' # str | The TestSuite namespace
    id = 'id_example' # str | The TestSuite ID
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The TestSuite source code

    try:
        # Update a test from YAML source
        api_response = api_instance.update_test_suite(namespace, id, tenant, body)
        print("The response of TestSuitesApi->update_test_suite:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->update_test_suite: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The TestSuite namespace | 
 **id** | **str**| The TestSuite ID | 
 **tenant** | **str**|  | 
 **body** | **str**| The TestSuite source code | 

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
**200** | updateTestSuite 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_test_suite**
> ValidateConstraintViolation validate_test_suite(tenant, body)

Validate a test

Validates a test YAML definition without persisting it. Returns constraint violations if any. Requires TEST permission with the READ action.

### Example


```python
import kestrapy
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.TestSuitesApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The TestSuite source code

    try:
        # Validate a test
        api_response = api_instance.validate_test_suite(tenant, body)
        print("The response of TestSuitesApi->validate_test_suite:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TestSuitesApi->validate_test_suite: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The TestSuite source code | 

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
**200** | validateTestSuite 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

