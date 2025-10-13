# kestrapy.LogApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_logs_from_execution**](LogApi.md#delete_logs_from_execution) | **DELETE** /api/v1/{tenant}/logs/{executionId} | Delete logs for a specific execution, taskrun or task
[**delete_logs_from_flow**](LogApi.md#delete_logs_from_flow) | **DELETE** /api/v1/{tenant}/logs/{namespace}/{flowId} | Delete logs for a specific execution, taskrun or task
[**download_logs_from_execution**](LogApi.md#download_logs_from_execution) | **GET** /api/v1/{tenant}/logs/{executionId}/download | Download logs for a specific execution, taskrun or task
[**follow_logs_from_execution**](LogApi.md#follow_logs_from_execution) | **GET** /api/v1/{tenant}/logs/{executionId}/follow | Follow logs for a specific execution
[**list_logs_from_execution**](LogApi.md#list_logs_from_execution) | **GET** /api/v1/{tenant}/logs/{executionId} | Get logs for a specific execution, taskrun or task
[**search_logs**](LogApi.md#search_logs) | **GET** /api/v1/{tenant}/logs/search | Search for logs


# **delete_logs_from_execution**
> delete_logs_from_execution(execution_id, tenant, min_level=min_level, task_run_id=task_run_id, task_id=task_id, attempt=attempt)

Delete logs for a specific execution, taskrun or task

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.LogApi(api_client)
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str | 
    min_level = kestrapy.Level() # Level | The min log level filter (optional)
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    task_id = 'task_id_example' # str | The task id (optional)
    attempt = 56 # int | The attempt number (optional)

    try:
        # Delete logs for a specific execution, taskrun or task
        api_instance.delete_logs_from_execution(execution_id, tenant, min_level=min_level, task_run_id=task_run_id, task_id=task_id, attempt=attempt)
    except Exception as e:
        print("Exception when calling LogApi->delete_logs_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **min_level** | [**Level**](.md)| The min log level filter | [optional] 
 **task_run_id** | **str**| The taskrun id | [optional] 
 **task_id** | **str**| The task id | [optional] 
 **attempt** | **int**| The attempt number | [optional] 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteLogsFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_logs_from_flow**
> delete_logs_from_flow(namespace, flow_id, trigger_id, tenant)

Delete logs for a specific execution, taskrun or task

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.LogApi(api_client)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow identifier
    trigger_id = 'trigger_id_example' # str | The trigger id
    tenant = 'tenant_example' # str | 

    try:
        # Delete logs for a specific execution, taskrun or task
        api_instance.delete_logs_from_flow(namespace, flow_id, trigger_id, tenant)
    except Exception as e:
        print("Exception when calling LogApi->delete_logs_from_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow identifier | 
 **trigger_id** | **str**| The trigger id | 
 **tenant** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteLogsFromFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **download_logs_from_execution**
> bytearray download_logs_from_execution(execution_id, tenant, min_level=min_level, task_run_id=task_run_id, task_id=task_id, attempt=attempt)

Download logs for a specific execution, taskrun or task

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.LogApi(api_client)
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str | 
    min_level = kestrapy.Level() # Level | The min log level filter (optional)
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    task_id = 'task_id_example' # str | The task id (optional)
    attempt = 56 # int | The attempt number (optional)

    try:
        # Download logs for a specific execution, taskrun or task
        api_response = api_instance.download_logs_from_execution(execution_id, tenant, min_level=min_level, task_run_id=task_run_id, task_id=task_id, attempt=attempt)
        print("The response of LogApi->download_logs_from_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling LogApi->download_logs_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **min_level** | [**Level**](.md)| The min log level filter | [optional] 
 **task_run_id** | **str**| The taskrun id | [optional] 
 **task_id** | **str**| The task id | [optional] 
 **attempt** | **int**| The attempt number | [optional] 

### Return type

**bytearray**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | downloadLogsFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **follow_logs_from_execution**
> EventLogEntry follow_logs_from_execution(execution_id, tenant, min_level=min_level)

Follow logs for a specific execution

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.event_log_entry import EventLogEntry
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.LogApi(api_client)
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str | 
    min_level = kestrapy.Level() # Level | The min log level filter (optional)

    try:
        # Follow logs for a specific execution
        api_response = api_instance.follow_logs_from_execution(execution_id, tenant, min_level=min_level)
        print("The response of LogApi->follow_logs_from_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling LogApi->follow_logs_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **min_level** | [**Level**](.md)| The min log level filter | [optional] 

### Return type

[**EventLogEntry**](EventLogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/event-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | followLogsFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_logs_from_execution**
> List[LogEntry] list_logs_from_execution(execution_id, tenant, min_level=min_level, task_run_id=task_run_id, task_id=task_id, attempt=attempt)

Get logs for a specific execution, taskrun or task

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.log_entry import LogEntry
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.LogApi(api_client)
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str | 
    min_level = kestrapy.Level() # Level | The min log level filter (optional)
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    task_id = 'task_id_example' # str | The task id (optional)
    attempt = 56 # int | The attempt number (optional)

    try:
        # Get logs for a specific execution, taskrun or task
        api_response = api_instance.list_logs_from_execution(execution_id, tenant, min_level=min_level, task_run_id=task_run_id, task_id=task_id, attempt=attempt)
        print("The response of LogApi->list_logs_from_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling LogApi->list_logs_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **min_level** | [**Level**](.md)| The min log level filter | [optional] 
 **task_run_id** | **str**| The taskrun id | [optional] 
 **task_id** | **str**| The task id | [optional] 
 **attempt** | **int**| The attempt number | [optional] 

### Return type

[**List[LogEntry]**](LogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listLogsFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_logs**
> PagedResultsLogEntry search_logs(page, size, tenant, sort=sort, filters=filters, q=q, namespace=namespace, flow_id=flow_id, trigger_id=trigger_id, min_level=min_level, start_date=start_date, end_date=end_date)

Search for logs

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_log_entry import PagedResultsLogEntry
from kestrapy.models.query_filter import QueryFilter
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.LogApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)
    flow_id = 'flow_id_example' # str | A flow id filter (optional)
    trigger_id = 'trigger_id_example' # str | A trigger id filter (optional)
    min_level = kestrapy.Level() # Level | The min log level filter (optional)
    start_date = '2013-10-20T19:20:30+01:00' # datetime | The start datetime (optional)
    end_date = '2013-10-20T19:20:30+01:00' # datetime | The end datetime (optional)

    try:
        # Search for logs
        api_response = api_instance.search_logs(page, size, tenant, sort=sort, filters=filters, q=q, namespace=namespace, flow_id=flow_id, trigger_id=trigger_id, min_level=min_level, start_date=start_date, end_date=end_date)
        print("The response of LogApi->search_logs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling LogApi->search_logs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 
 **flow_id** | **str**| A flow id filter | [optional] 
 **trigger_id** | **str**| A trigger id filter | [optional] 
 **min_level** | [**Level**](.md)| The min log level filter | [optional] 
 **start_date** | **datetime**| The start datetime | [optional] 
 **end_date** | **datetime**| The end datetime | [optional] 

### Return type

[**PagedResultsLogEntry**](PagedResultsLogEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchLogs 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

