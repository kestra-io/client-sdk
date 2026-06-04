# kestrapy.LogsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_logs_from_execution**](LogsApi.md#delete_logs_from_execution) | **DELETE** /api/v1/{tenant}/logs/{executionId} | Delete logs for a specific execution, taskrun or task
[**delete_logs_from_flow**](LogsApi.md#delete_logs_from_flow) | **DELETE** /api/v1/{tenant}/logs/{namespace}/{flowId} | Delete logs for a specific flow
[**download_logs_from_execution**](LogsApi.md#download_logs_from_execution) | **GET** /api/v1/{tenant}/logs/{executionId}/download | Download logs for a specific execution, taskrun or task
[**follow_logs_from_execution**](LogsApi.md#follow_logs_from_execution) | **GET** /api/v1/{tenant}/logs/{executionId}/follow | Follow logs for a specific execution
[**list_logs_from_execution**](LogsApi.md#list_logs_from_execution) | **GET** /api/v1/{tenant}/logs/{executionId} | Get logs for a specific execution, taskrun or task
[**search_logs**](LogsApi.md#search_logs) | **GET** /api/v1/{tenant}/logs/search | Search for logs


# **delete_logs_from_execution**
> delete_logs_from_execution(execution_id, tenant, min_level=min_level, task_run_id=task_run_id, task_id=task_id, attempt=attempt)

Delete logs for a specific execution, taskrun or task

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str |
    min_level = 'INFO' # str | The min log level filter (optional)
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    task_id = 'task_id_example' # str | The task id (optional)
    attempt = 0 # int | The attempt number (optional)

    try:
        # Delete logs for a specific execution, taskrun or task
        kestra_client.logs.delete_logs_from_execution(execution_id, tenant)
    except Exception as e:
        print("Exception when calling LogsApi->delete_logs_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id |
 **tenant** | **str**|  |
 **min_level** | **str**| The min log level filter | [optional]
 **task_run_id** | **str**| The taskrun id | [optional]
 **task_id** | **str**| The task id | [optional]
 **attempt** | **int**| The attempt number | [optional]

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteLogsFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_logs_from_flow**
> delete_logs_from_flow(namespace, flow_id, trigger_id, tenant)

Delete logs for a specific flow

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow identifier
    trigger_id = 'trigger_id_example' # str | The trigger id
    tenant = 'tenant_example' # str |

    try:
        # Delete logs for a specific flow
        kestra_client.logs.delete_logs_from_flow(namespace, flow_id, trigger_id, tenant)
    except Exception as e:
        print("Exception when calling LogsApi->delete_logs_from_flow: %s\n" % e)
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
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteLogsFromFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **download_logs_from_execution**
> str download_logs_from_execution(execution_id, tenant, min_level=min_level, task_run_id=task_run_id, task_id=task_id, attempt=attempt)

Download logs for a specific execution, taskrun or task

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str |
    min_level = 'INFO' # str | The min log level filter (optional)
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    task_id = 'task_id_example' # str | The task id (optional)
    attempt = 0 # int | The attempt number (optional)

    try:
        # Download logs for a specific execution, taskrun or task
        api_response = kestra_client.logs.download_logs_from_execution(execution_id, tenant)
        print("The response of LogsApi->download_logs_from_execution:\n")
        print(api_response)
    except Exception as e:
        print("Exception when calling LogsApi->download_logs_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id |
 **tenant** | **str**|  |
 **min_level** | **str**| The min log level filter | [optional]
 **task_run_id** | **str**| The taskrun id | [optional]
 **task_id** | **str**| The task id | [optional]
 **attempt** | **int**| The attempt number | [optional]

### Return type

**str**

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
> Generator[LogEntry] follow_logs_from_execution(execution_id, tenant, min_level=min_level)

Follow logs for a specific execution

Streams log entries in real-time using Server-Sent Events (SSE). The returned generator yields `LogEntry` items as they are produced by the execution; iteration ends when the server closes the stream. The server interleaves keepalive frames with real log events, so entries with `execution_id is None` should be skipped.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str |
    min_level = 'INFO' # str | The min log level filter (optional)

    try:
        # Follow logs for a specific execution
        for log_entry in kestra_client.logs.follow_logs_from_execution(execution_id, tenant):
            if log_entry.execution_id is None:
                continue  # keepalive frame
            print(log_entry.message)
    except Exception as e:
        print("Exception when calling LogsApi->follow_logs_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id |
 **tenant** | **str**|  |
 **min_level** | **str**| The min log level filter | [optional]

### Return type

[**Generator[LogEntry]**](LogEntry.md)

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
from pprint import pprint

from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str |
    min_level = 'INFO' # str | The min log level filter (optional)
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    task_id = 'task_id_example' # str | The task id (optional)
    attempt = 0 # int | The attempt number (optional)

    try:
        # Get logs for a specific execution, taskrun or task
        api_response = kestra_client.logs.list_logs_from_execution(execution_id, tenant)
        print("The response of LogsApi->list_logs_from_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling LogsApi->list_logs_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id |
 **tenant** | **str**|  |
 **min_level** | **str**| The min log level filter | [optional]
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
> PagedResultsLogEntry search_logs(tenant, page=page, size=size, sort=sort, filters=filters)

Search for logs

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from pprint import pprint

from kestrapy import KestraClient, Configuration, QueryFilter, QueryFilterField, QueryFilterOp

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str |
    page = 1 # int | The current page (optional)
    size = 10 # int | The current page size (optional)
    sort = ['timestamp:desc'] # List[str] | The sort of current page (optional)
    filters = [
        QueryFilter(var_field=QueryFilterField.NAMESPACE, operation=QueryFilterOp.EQUALS, value={"value": "company.team"}),
    ] # List[QueryFilter] | Filters (optional)

    try:
        # Search for logs
        api_response = kestra_client.logs.search_logs(tenant, page, size, sort=sort, filters=filters)
        print("The response of LogsApi->search_logs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling LogsApi->search_logs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  |
 **page** | **int**| The current page | [optional][default to 1]
 **size** | **int**| The current page size | [optional][default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional]
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional]

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
