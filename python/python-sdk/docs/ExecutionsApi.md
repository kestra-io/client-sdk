# kestrapy.ExecutionsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_execution**](ExecutionsApi.md#create_execution) | **POST** /api/v1/{tenant}/executions/{namespace}/{id} | Create a new execution for a flow
[**delete_execution**](ExecutionsApi.md#delete_execution) | **DELETE** /api/v1/{tenant}/executions/{executionId} | Delete an execution
[**delete_executions_by_ids**](ExecutionsApi.md#delete_executions_by_ids) | **DELETE** /api/v1/{tenant}/executions/by-ids | Delete a list of executions
[**delete_executions_by_query**](ExecutionsApi.md#delete_executions_by_query) | **DELETE** /api/v1/{tenant}/executions/by-query | Delete executions filter by query parameters
[**download_file_from_execution**](ExecutionsApi.md#download_file_from_execution) | **GET** /api/v1/{tenant}/executions/{executionId}/file | Download file for an execution
[**eval_expression**](ExecutionsApi.md#eval_expression) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/eval | Evaluate a variable expression for this execution
[**eval_task_run_expression**](ExecutionsApi.md#eval_task_run_expression) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/eval/{taskRunId} | Evaluate a variable expression for this taskrun
[**execution**](ExecutionsApi.md#execution) | **GET** /api/v1/{tenant}/executions/{executionId} | Get an execution
[**execution_average_duration**](ExecutionsApi.md#execution_average_duration) | **GET** /api/v1/{tenant}/executions/namespaces/{namespace}/flows/{flowId}/average-duration | Get the average duration of the recent executions of a flow, used to estimate the progress of a running execution.
[**execution_flow_graph**](ExecutionsApi.md#execution_flow_graph) | **GET** /api/v1/{tenant}/executions/{executionId}/graph | Generate a graph for an execution
[**export_executions**](ExecutionsApi.md#export_executions) | **GET** /api/v1/{tenant}/executions/export/by-query/csv | Export all executions as a streamed CSV file
[**file_metadatas_from_execution**](ExecutionsApi.md#file_metadatas_from_execution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/metas | Get file meta information for an execution
[**find_distinct_field_values**](ExecutionsApi.md#find_distinct_field_values) | **GET** /api/v1/{tenant}/executions/distinct-field-values | List distinct values for one of the executions filter fields, optionally narrowed by additional query filters
[**flow_from_execution**](ExecutionsApi.md#flow_from_execution) | **GET** /api/v1/{tenant}/executions/flows/{namespace}/{flowId} | Get flow information&#39;s for an execution
[**flow_from_execution_by_id**](ExecutionsApi.md#flow_from_execution_by_id) | **GET** /api/v1/{tenant}/executions/{executionId}/flow | Get flow information&#39;s for an execution
[**follow_dependencies_executions**](ExecutionsApi.md#follow_dependencies_executions) | **GET** /api/v1/{tenant}/executions/{executionId}/follow-dependencies | Follow all execution dependencies executions
[**follow_execution**](ExecutionsApi.md#follow_execution) | **GET** /api/v1/{tenant}/executions/{executionId}/follow | Follow an execution
[**force_run_by_ids**](ExecutionsApi.md#force_run_by_ids) | **POST** /api/v1/{tenant}/executions/force-run/by-ids | Force run a list of executions asynchronously
[**force_run_execution**](ExecutionsApi.md#force_run_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/force-run | Force run an execution
[**force_run_executions_by_query**](ExecutionsApi.md#force_run_executions_by_query) | **POST** /api/v1/{tenant}/executions/force-run/by-query | Force run executions filter by query parameters asynchronously
[**kill_execution**](ExecutionsApi.md#kill_execution) | **DELETE** /api/v1/{tenant}/executions/{executionId}/actions/kill | Kill an execution
[**kill_executions_by_ids**](ExecutionsApi.md#kill_executions_by_ids) | **DELETE** /api/v1/{tenant}/executions/kill/by-ids | Kill a list of executions asynchronously
[**kill_executions_by_query**](ExecutionsApi.md#kill_executions_by_query) | **DELETE** /api/v1/{tenant}/executions/kill/by-query | Kill executions filter by query parameters
[**latest_executions**](ExecutionsApi.md#latest_executions) | **POST** /api/v1/{tenant}/executions/latest | Get the latest execution for given flows
[**list_executable_distinct_namespaces**](ExecutionsApi.md#list_executable_distinct_namespaces) | **GET** /api/v1/{tenant}/executions/namespaces | Get all namespaces that have executable flows
[**list_flow_executions_by_namespace**](ExecutionsApi.md#list_flow_executions_by_namespace) | **GET** /api/v1/{tenant}/executions/namespaces/{namespace}/flows | Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.
[**pause_execution**](ExecutionsApi.md#pause_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/pause | Pause a running execution.
[**pause_executions_by_ids**](ExecutionsApi.md#pause_executions_by_ids) | **POST** /api/v1/{tenant}/executions/pause/by-ids | Pause a list of running executions asynchronously
[**pause_executions_by_query**](ExecutionsApi.md#pause_executions_by_query) | **POST** /api/v1/{tenant}/executions/pause/by-query | Pause executions filter by query parameters asynchronously
[**preview_file_from_execution**](ExecutionsApi.md#preview_file_from_execution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/preview | Get file preview for an execution
[**replay_execution**](ExecutionsApi.md#replay_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/replay | Create a new execution from an old one and start it from a specified task run id
[**replay_execution_withinputs**](ExecutionsApi.md#replay_execution_withinputs) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/replay-with-inputs | Create a new execution from an old one and start it from a specified task run id
[**replay_executions_by_ids**](ExecutionsApi.md#replay_executions_by_ids) | **POST** /api/v1/{tenant}/executions/replay/by-ids | Create new executions from old ones asynchronously. Keep the flow revision
[**replay_executions_by_query**](ExecutionsApi.md#replay_executions_by_query) | **POST** /api/v1/{tenant}/executions/replay/by-query | Create new executions from old ones filter by query parameters asynchronously. Keep the flow revision
[**restart_execution**](ExecutionsApi.md#restart_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/restart | Restart a new execution from an old one
[**restart_executions_by_ids**](ExecutionsApi.md#restart_executions_by_ids) | **POST** /api/v1/{tenant}/executions/restart/by-ids | Restart a list of executions asynchronously
[**restart_executions_by_query**](ExecutionsApi.md#restart_executions_by_query) | **POST** /api/v1/{tenant}/executions/restart/by-query | Restart executions filter by query parameters asynchronously
[**resume_execution**](ExecutionsApi.md#resume_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/resume | Resume a paused execution.
[**resume_execution_from_breakpoint**](ExecutionsApi.md#resume_execution_from_breakpoint) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/resume-from-breakpoint | Resume an execution from a breakpoint (in the &#39;BREAKPOINT&#39; state).
[**resume_executions_by_ids**](ExecutionsApi.md#resume_executions_by_ids) | **POST** /api/v1/{tenant}/executions/resume/by-ids | Resume a list of paused executions asynchronously
[**resume_executions_by_query**](ExecutionsApi.md#resume_executions_by_query) | **POST** /api/v1/{tenant}/executions/resume/by-query | Resume executions filter by query parameters asynchronously
[**search_executions**](ExecutionsApi.md#search_executions) | **GET** /api/v1/{tenant}/executions/search | Search for executions
[**search_executions_by_flow_id**](ExecutionsApi.md#search_executions_by_flow_id) | **GET** /api/v1/{tenant}/executions | Search for executions for a flow
[**set_labels_on_terminated_execution**](ExecutionsApi.md#set_labels_on_terminated_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/labels | Add or update labels of a terminated execution
[**set_labels_on_terminated_executions_by_ids**](ExecutionsApi.md#set_labels_on_terminated_executions_by_ids) | **POST** /api/v1/{tenant}/executions/labels/by-ids | Set labels on a list of executions asynchronously
[**set_labels_on_terminated_executions_by_query**](ExecutionsApi.md#set_labels_on_terminated_executions_by_query) | **POST** /api/v1/{tenant}/executions/labels/by-query | Set label on executions filter by query parameters asynchronously
[**trigger_execution_by_get_webhook**](ExecutionsApi.md#trigger_execution_by_get_webhook) | **GET** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by GET webhook trigger
[**trigger_execution_by_get_webhook_with_path**](ExecutionsApi.md#trigger_execution_by_get_webhook_with_path) | **GET** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key}/{path} | Trigger a new execution by GET webhook trigger
[**trigger_execution_by_post_webhook**](ExecutionsApi.md#trigger_execution_by_post_webhook) | **POST** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by POST webhook trigger
[**trigger_execution_by_post_webhook_with_path**](ExecutionsApi.md#trigger_execution_by_post_webhook_with_path) | **POST** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key}/{path} | Trigger a new execution by POST webhook trigger
[**trigger_execution_by_put_webhook**](ExecutionsApi.md#trigger_execution_by_put_webhook) | **PUT** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by PUT webhook trigger
[**trigger_execution_by_put_webhook_with_path**](ExecutionsApi.md#trigger_execution_by_put_webhook_with_path) | **PUT** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key}/{path} | Trigger a new execution by PUT webhook trigger
[**unqueue_execution**](ExecutionsApi.md#unqueue_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/unqueue | Unqueue an execution
[**unqueue_executions_by_ids**](ExecutionsApi.md#unqueue_executions_by_ids) | **POST** /api/v1/{tenant}/executions/unqueue/by-ids | Unqueue a list of executions asynchronously
[**unqueue_executions_by_query**](ExecutionsApi.md#unqueue_executions_by_query) | **POST** /api/v1/{tenant}/executions/unqueue/by-query | Unqueue executions filter by query parameters asynchronously
[**update_execution_status**](ExecutionsApi.md#update_execution_status) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/change-status | Change the state of an execution
[**update_executions_status_by_ids**](ExecutionsApi.md#update_executions_status_by_ids) | **POST** /api/v1/{tenant}/executions/change-status/by-ids | Change executions state by id asynchronously
[**update_executions_status_by_query**](ExecutionsApi.md#update_executions_status_by_query) | **POST** /api/v1/{tenant}/executions/change-status/by-query | Change executions state by query parameters asynchronously
[**update_task_run_state**](ExecutionsApi.md#update_task_run_state) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/state | Change state for a taskrun in an execution
[**validate_new_execution_inputs**](ExecutionsApi.md#validate_new_execution_inputs) | **POST** /api/v1/{tenant}/executions/{namespace}/{id}/validate | Validate the creation of a new execution for a flow
[**validate_resume_execution_inputs**](ExecutionsApi.md#validate_resume_execution_inputs) | **POST** /api/v1/{tenant}/executions/{executionId}/actions/resume/validate | Validate inputs to resume a paused execution.


# **create_execution**
> ExecutionControllerExecutionResponse create_execution(namespace, id, tenant, labels=labels, wait=wait, revision=revision, schedule_date=schedule_date, breakpoints=breakpoints, kind=kind)

Create a new execution for a flow

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    labels = ['labels_example'] # List[str] | The labels as a list of 'key:value' (optional)
    wait = False # bool | If the server will wait the end of the execution (optional) (default to False)
    revision = 56 # int | The flow revision or latest if null (optional)
    schedule_date = '2013-10-20T19:20:30+01:00' # datetime | Schedule the flow on a specific date (optional)
    breakpoints = 'breakpoints_example' # str | Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)
    kind = kestrapy.ExecutionKind() # ExecutionKind | Specific execution kind (optional)

    try:
        # Create a new execution for a flow
        api_response = kestra_client.ExecutionsApi.create_execution(namespace, id, tenant, labels=labels, wait=wait, revision=revision, schedule_date=schedule_date, breakpoints=breakpoints, kind=kind)
        print("The response of ExecutionsApi->create_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->create_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **labels** | [**List[str]**](str.md)| The labels as a list of &#39;key:value&#39; | [optional] 
 **wait** | **bool**| If the server will wait the end of the execution | [optional] [default to False]
 **revision** | **int**| The flow revision or latest if null | [optional] 
 **schedule_date** | **datetime**| Schedule the flow on a specific date | [optional] 
 **breakpoints** | **str**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 
 **kind** | [**ExecutionKind**](.md)| Specific execution kind | [optional] 

### Return type

[**ExecutionControllerExecutionResponse**](ExecutionControllerExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On execution created |  -  |
**409** | if the flow is disabled |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_execution**
> delete_execution(execution_id, tenant, delete_logs=delete_logs, delete_metrics=delete_metrics, delete_storage=delete_storage)

Delete an execution

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
    delete_logs = True # bool | Whether to delete execution logs (optional) (default to True)
    delete_metrics = True # bool | Whether to delete execution metrics (optional) (default to True)
    delete_storage = True # bool | Whether to delete execution files in the internal storage (optional) (default to True)

    try:
        # Delete an execution
        kestra_client.ExecutionsApi.delete_execution(execution_id, tenant, delete_logs=delete_logs, delete_metrics=delete_metrics, delete_storage=delete_storage)
    except Exception as e:
        print("Exception when calling ExecutionsApi->delete_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **delete_logs** | **bool**| Whether to delete execution logs | [optional] [default to True]
 **delete_metrics** | **bool**| Whether to delete execution metrics | [optional] [default to True]
 **delete_storage** | **bool**| Whether to delete execution files in the internal storage | [optional] [default to True]

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
**200** | deleteExecution 200 response |  -  |
**204** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_executions_by_ids**
> BulkResponse delete_executions_by_ids(tenant, request_body, include_non_terminated=include_non_terminated, delete_logs=delete_logs, delete_metrics=delete_metrics, delete_storage=delete_storage)

Delete a list of executions

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
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The execution id
    include_non_terminated = False # bool | Whether to delete non-terminated executions (optional) (default to False)
    delete_logs = True # bool | Whether to delete execution logs (optional) (default to True)
    delete_metrics = True # bool | Whether to delete execution metrics (optional) (default to True)
    delete_storage = True # bool | Whether to delete execution files in the internal storage (optional) (default to True)

    try:
        # Delete a list of executions
        api_response = kestra_client.ExecutionsApi.delete_executions_by_ids(tenant, request_body, include_non_terminated=include_non_terminated, delete_logs=delete_logs, delete_metrics=delete_metrics, delete_storage=delete_storage)
        print("The response of ExecutionsApi->delete_executions_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->delete_executions_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The execution id | 
 **include_non_terminated** | **bool**| Whether to delete non-terminated executions | [optional] [default to False]
 **delete_logs** | **bool**| Whether to delete execution logs | [optional] [default to True]
 **delete_metrics** | **bool**| Whether to delete execution metrics | [optional] [default to True]
 **delete_storage** | **bool**| Whether to delete execution files in the internal storage | [optional] [default to True]

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**422** | Deleted with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_executions_by_query**
> BulkResponse delete_executions_by_query(tenant, filters=filters, include_non_terminated=include_non_terminated, delete_logs=delete_logs, delete_metrics=delete_metrics, delete_storage=delete_storage)

Delete executions filter by query parameters

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)
    include_non_terminated = False # bool | Whether to delete non-terminated executions (optional) (default to False)
    delete_logs = True # bool | Whether to delete execution logs (optional) (default to True)
    delete_metrics = True # bool | Whether to delete execution metrics (optional) (default to True)
    delete_storage = True # bool | Whether to delete execution files in the internal storage (optional) (default to True)

    try:
        # Delete executions filter by query parameters
        api_response = kestra_client.ExecutionsApi.delete_executions_by_query(tenant, filters=filters, include_non_terminated=include_non_terminated, delete_logs=delete_logs, delete_metrics=delete_metrics, delete_storage=delete_storage)
        print("The response of ExecutionsApi->delete_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->delete_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 
 **include_non_terminated** | **bool**| Whether to delete non-terminated executions | [optional] [default to False]
 **delete_logs** | **bool**| Whether to delete execution logs | [optional] [default to True]
 **delete_metrics** | **bool**| Whether to delete execution metrics | [optional] [default to True]
 **delete_storage** | **bool**| Whether to delete execution files in the internal storage | [optional] [default to True]

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**422** | Deleted with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **download_file_from_execution**
> bytes download_file_from_execution(execution_id, path, tenant, format=format)

Download file for an execution

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
    path = 'path_example' # str | The internal storage uri
    tenant = 'tenant_example' # str | 
    format = kestrapy.FileFormat() # FileFormat | The requested file format; RAW returns the raw bytes (default), JSONL converts Ion records to JSON Lines (optional)

    try:
        # Download file for an execution
        api_response = kestra_client.ExecutionsApi.download_file_from_execution(execution_id, path, tenant, format=format)
        print("The response of ExecutionsApi->download_file_from_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->download_file_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **path** | **str**| The internal storage uri | 
 **tenant** | **str**|  | 
 **format** | [**FileFormat**](.md)| The requested file format; RAW returns the raw bytes (default), JSONL converts Ion records to JSON Lines | [optional] 

### Return type

**bytes**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, application/x-ndjson

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | downloadFileFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **eval_expression**
> ExecutionControllerEvalResult eval_expression(execution_id, tenant, body)

Evaluate a variable expression for this execution

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
    body = 'body_example' # str | The Pebble expression that should be evaluated

    try:
        # Evaluate a variable expression for this execution
        api_response = kestra_client.ExecutionsApi.eval_expression(execution_id, tenant, body)
        print("The response of ExecutionsApi->eval_expression:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->eval_expression: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **body** | **str**| The Pebble expression that should be evaluated | 

### Return type

[**ExecutionControllerEvalResult**](ExecutionControllerEvalResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | evalExpression 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **eval_task_run_expression**
> ExecutionControllerEvalResult eval_task_run_expression(execution_id, task_run_id, tenant, body)

Evaluate a variable expression for this taskrun

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
    task_run_id = 'task_run_id_example' # str | The taskrun id
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The Pebble expression that should be evaluated

    try:
        # Evaluate a variable expression for this taskrun
        api_response = kestra_client.ExecutionsApi.eval_task_run_expression(execution_id, task_run_id, tenant, body)
        print("The response of ExecutionsApi->eval_task_run_expression:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->eval_task_run_expression: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **task_run_id** | **str**| The taskrun id | 
 **tenant** | **str**|  | 
 **body** | **str**| The Pebble expression that should be evaluated | 

### Return type

[**ExecutionControllerEvalResult**](ExecutionControllerEvalResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | evalTaskRunExpression 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **execution**
> ApiExecution execution(execution_id, tenant)

Get an execution

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

    try:
        # Get an execution
        api_response = kestra_client.ExecutionsApi.execution(execution_id, tenant)
        print("The response of ExecutionsApi->execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 

### Return type

[**ApiExecution**](ApiExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **execution_average_duration**
> ExecutionControllerExecutionAverageDuration execution_average_duration(namespace, flow_id, tenant)

Get the average duration of the recent executions of a flow, used to estimate the progress of a running execution.

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
    namespace = 'namespace_example' # str | The flow namespace
    flow_id = 'flow_id_example' # str | The flow id
    tenant = 'tenant_example' # str | 

    try:
        # Get the average duration of the recent executions of a flow, used to estimate the progress of a running execution.
        api_response = kestra_client.ExecutionsApi.execution_average_duration(namespace, flow_id, tenant)
        print("The response of ExecutionsApi->execution_average_duration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->execution_average_duration: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **flow_id** | **str**| The flow id | 
 **tenant** | **str**|  | 

### Return type

[**ExecutionControllerExecutionAverageDuration**](ExecutionControllerExecutionAverageDuration.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getExecutionAverageDuration 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **execution_flow_graph**
> FlowGraph execution_flow_graph(execution_id, tenant, subflows=subflows)

Generate a graph for an execution

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
    subflows = ['subflows_example'] # List[str] | The subflow tasks to display (optional)

    try:
        # Generate a graph for an execution
        api_response = kestra_client.ExecutionsApi.execution_flow_graph(execution_id, tenant, subflows=subflows)
        print("The response of ExecutionsApi->execution_flow_graph:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->execution_flow_graph: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **subflows** | [**List[str]**](str.md)| The subflow tasks to display | [optional] 

### Return type

[**FlowGraph**](FlowGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getExecutionFlowGraph 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export_executions**
> List[str] export_executions(tenant, filters=filters)

Export all executions as a streamed CSV file

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | A list of filters (optional)

    try:
        # Export all executions as a streamed CSV file
        api_response = kestra_client.ExecutionsApi.export_executions(tenant, filters=filters)
        print("The response of ExecutionsApi->export_executions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->export_executions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| A list of filters | [optional] 

### Return type

**List[str]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/csv

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | exportExecutions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **file_metadatas_from_execution**
> FileMetas file_metadatas_from_execution(execution_id, path, tenant)

Get file meta information for an execution

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
    path = 'path_example' # str | The internal storage uri
    tenant = 'tenant_example' # str | 

    try:
        # Get file meta information for an execution
        api_response = kestra_client.ExecutionsApi.file_metadatas_from_execution(execution_id, path, tenant)
        print("The response of ExecutionsApi->file_metadatas_from_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->file_metadatas_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **path** | **str**| The internal storage uri | 
 **tenant** | **str**|  | 

### Return type

[**FileMetas**](FileMetas.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getFileMetadatasFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **find_distinct_field_values**
> List[str] find_distinct_field_values(var_field, tenant, filters=filters, size=size)

List distinct values for one of the executions filter fields, optionally narrowed by additional query filters

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
    var_field = kestrapy.QueryFilterField() # QueryFilterField | The field whose distinct values to return. Must be a field supported by the EXECUTION resource.
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Additional filters to narrow the distinct values. PHP-style nested query is used - examples: `filters[flowId][CONTAINS]=test`, `filters[state][IN]=FAILED,WARNING` (optional)
    size = 100 # int | Maximum number of distinct values to return. (optional) (default to 100)

    try:
        # List distinct values for one of the executions filter fields, optionally narrowed by additional query filters
        api_response = kestra_client.ExecutionsApi.find_distinct_field_values(var_field, tenant, filters=filters, size=size)
        print("The response of ExecutionsApi->find_distinct_field_values:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->find_distinct_field_values: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **var_field** | [**QueryFilterField**](.md)| The field whose distinct values to return. Must be a field supported by the EXECUTION resource. | 
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Additional filters to narrow the distinct values. PHP-style nested query is used - examples: &#x60;filters[flowId][CONTAINS]&#x3D;test&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,WARNING&#x60; | [optional] 
 **size** | **int**| Maximum number of distinct values to return. | [optional] [default to 100]

### Return type

**List[str]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | findDistinctFieldValues 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **flow_from_execution**
> FlowForExecution flow_from_execution(namespace, flow_id, tenant, revision=revision)

Get flow information's for an execution

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
    namespace = 'namespace_example' # str | The namespace of the flow
    flow_id = 'flow_id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    revision = 56 # int | The flow revision (optional)

    try:
        # Get flow information's for an execution
        api_response = kestra_client.ExecutionsApi.flow_from_execution(namespace, flow_id, tenant, revision=revision)
        print("The response of ExecutionsApi->flow_from_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->flow_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace of the flow | 
 **flow_id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **revision** | **int**| The flow revision | [optional] 

### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getFlowFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **flow_from_execution_by_id**
> FlowForExecution flow_from_execution_by_id(execution_id, tenant)

Get flow information's for an execution

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
    execution_id = 'execution_id_example' # str | The execution that you want flow information
    tenant = 'tenant_example' # str | 

    try:
        # Get flow information's for an execution
        api_response = kestra_client.ExecutionsApi.flow_from_execution_by_id(execution_id, tenant)
        print("The response of ExecutionsApi->flow_from_execution_by_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->flow_from_execution_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution that you want flow information | 
 **tenant** | **str**|  | 

### Return type

[**FlowForExecution**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getFlowFromExecutionById 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **follow_dependencies_executions**
> ExecutionStatusEvent follow_dependencies_executions(execution_id, tenant, destination_only=destination_only, expand_all=expand_all)

Follow all execution dependencies executions

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
    destination_only = False # bool | If true, list only destination dependencies, otherwise list also source dependencies (optional) (default to False)
    expand_all = False # bool | If true, expand all dependencies recursively (optional) (default to False)

    try:
        # Follow all execution dependencies executions
        api_response = kestra_client.ExecutionsApi.follow_dependencies_executions(execution_id, tenant, destination_only=destination_only, expand_all=expand_all)
        print("The response of ExecutionsApi->follow_dependencies_executions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->follow_dependencies_executions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **destination_only** | **bool**| If true, list only destination dependencies, otherwise list also source dependencies | [optional] [default to False]
 **expand_all** | **bool**| If true, expand all dependencies recursively | [optional] [default to False]

### Return type

[**ExecutionStatusEvent**](ExecutionStatusEvent.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/event-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | followDependenciesExecutions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **follow_execution**
> Execution follow_execution(execution_id, tenant)

Follow an execution

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

    try:
        # Follow an execution
        api_response = kestra_client.ExecutionsApi.follow_execution(execution_id, tenant)
        print("The response of ExecutionsApi->follow_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->follow_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/event-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | followExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **force_run_by_ids**
> ApiAsyncOperationResponse force_run_by_ids(tenant, request_body)

Force run a list of executions asynchronously

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
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The list of executions id

    try:
        # Force run a list of executions asynchronously
        api_response = kestra_client.ExecutionsApi.force_run_by_ids(tenant, request_body)
        print("The response of ExecutionsApi->force_run_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->force_run_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The list of executions id | 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | forceRunByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **force_run_execution**
> Execution force_run_execution(execution_id, tenant)

Force run an execution

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

    try:
        # Force run an execution
        api_response = kestra_client.ExecutionsApi.force_run_execution(execution_id, tenant)
        print("The response of ExecutionsApi->force_run_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->force_run_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the execution cannot be force-run |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **force_run_executions_by_query**
> ApiAsyncOperationResponse force_run_executions_by_query(tenant, filters=filters)

Force run executions filter by query parameters asynchronously

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Force run executions filter by query parameters asynchronously
        api_response = kestra_client.ExecutionsApi.force_run_executions_by_query(tenant, filters=filters)
        print("The response of ExecutionsApi->force_run_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->force_run_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | forceRunExecutionsByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **kill_execution**
> Execution kill_execution(execution_id, tenant, is_on_kill_cascade=is_on_kill_cascade)

Kill an execution

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
    is_on_kill_cascade = True # bool | Specifies whether killing the execution also kill all subflow executions. (optional) (default to True)

    try:
        # Kill an execution
        api_response = kestra_client.ExecutionsApi.kill_execution(execution_id, tenant, is_on_kill_cascade=is_on_kill_cascade)
        print("The response of ExecutionsApi->kill_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->kill_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **is_on_kill_cascade** | **bool**| Specifies whether killing the execution also kill all subflow executions. | [optional] [default to True]

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**404** | if the executions is not found |  -  |
**409** | if the executions is already finished |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **kill_executions_by_ids**
> ApiAsyncOperationResponse kill_executions_by_ids(tenant, request_body)

Kill a list of executions asynchronously

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
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The list of executions id

    try:
        # Kill a list of executions asynchronously
        api_response = kestra_client.ExecutionsApi.kill_executions_by_ids(tenant, request_body)
        print("The response of ExecutionsApi->kill_executions_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->kill_executions_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The list of executions id | 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | killExecutionsByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **kill_executions_by_query**
> ApiAsyncOperationResponse kill_executions_by_query(tenant, filters=filters)

Kill executions filter by query parameters

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Kill executions filter by query parameters
        api_response = kestra_client.ExecutionsApi.kill_executions_by_query(tenant, filters=filters)
        print("The response of ExecutionsApi->kill_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->kill_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | killExecutionsByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **latest_executions**
> List[ExecutionControllerLastExecutionResponse] latest_executions(tenant, execution_repository_interface_flow_filter)

Get the latest execution for given flows

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
    tenant = 'tenant_example' # str | 
    execution_repository_interface_flow_filter = [kestrapy.ExecutionRepositoryInterfaceFlowFilter()] # List[ExecutionRepositoryInterfaceFlowFilter] | 

    try:
        # Get the latest execution for given flows
        api_response = kestra_client.ExecutionsApi.latest_executions(tenant, execution_repository_interface_flow_filter)
        print("The response of ExecutionsApi->latest_executions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->latest_executions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **execution_repository_interface_flow_filter** | [**List[ExecutionRepositoryInterfaceFlowFilter]**](ExecutionRepositoryInterfaceFlowFilter.md)|  | 

### Return type

[**List[ExecutionControllerLastExecutionResponse]**](ExecutionControllerLastExecutionResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getLatestExecutions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_executable_distinct_namespaces**
> List[str] list_executable_distinct_namespaces(tenant)

Get all namespaces that have executable flows

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
    tenant = 'tenant_example' # str | 

    try:
        # Get all namespaces that have executable flows
        api_response = kestra_client.ExecutionsApi.list_executable_distinct_namespaces(tenant)
        print("The response of ExecutionsApi->list_executable_distinct_namespaces:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->list_executable_distinct_namespaces: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 

### Return type

**List[str]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listExecutableDistinctNamespaces 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_flow_executions_by_namespace**
> List[FlowForExecution] list_flow_executions_by_namespace(namespace, tenant)

Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.

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
    tenant = 'tenant_example' # str | 

    try:
        # Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.
        api_response = kestra_client.ExecutionsApi.list_flow_executions_by_namespace(namespace, tenant)
        print("The response of ExecutionsApi->list_flow_executions_by_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->list_flow_executions_by_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **tenant** | **str**|  | 

### Return type

[**List[FlowForExecution]**](FlowForExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listFlowExecutionsByNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_execution**
> Execution pause_execution(execution_id, tenant)

Pause a running execution.

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

    try:
        # Pause a running execution.
        api_response = kestra_client.ExecutionsApi.pause_execution(execution_id, tenant)
        print("The response of ExecutionsApi->pause_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->pause_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the executions is not running |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_executions_by_ids**
> ApiAsyncOperationResponse pause_executions_by_ids(tenant, request_body)

Pause a list of running executions asynchronously

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
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The list of executions id

    try:
        # Pause a list of running executions asynchronously
        api_response = kestra_client.ExecutionsApi.pause_executions_by_ids(tenant, request_body)
        print("The response of ExecutionsApi->pause_executions_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->pause_executions_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The list of executions id | 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | pauseExecutionsByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_executions_by_query**
> ApiAsyncOperationResponse pause_executions_by_query(tenant, filters=filters)

Pause executions filter by query parameters asynchronously

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Pause executions filter by query parameters asynchronously
        api_response = kestra_client.ExecutionsApi.pause_executions_by_query(tenant, filters=filters)
        print("The response of ExecutionsApi->pause_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->pause_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | pauseExecutionsByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **preview_file_from_execution**
> object preview_file_from_execution(execution_id, path, max_rows, tenant, encoding=encoding)

Get file preview for an execution

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
    path = 'path_example' # str | The internal storage uri
    max_rows = 56 # int | The max row returns
    tenant = 'tenant_example' # str | 
    encoding = 'UTF-8' # str | The file encoding as Java charset name. Defaults to UTF-8 (optional) (default to 'UTF-8')

    try:
        # Get file preview for an execution
        api_response = kestra_client.ExecutionsApi.preview_file_from_execution(execution_id, path, max_rows, tenant, encoding=encoding)
        print("The response of ExecutionsApi->preview_file_from_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->preview_file_from_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **path** | **str**| The internal storage uri | 
 **max_rows** | **int**| The max row returns | 
 **tenant** | **str**|  | 
 **encoding** | **str**| The file encoding as Java charset name. Defaults to UTF-8 | [optional] [default to &#39;UTF-8&#39;]

### Return type

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | previewFileFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **replay_execution**
> Execution replay_execution(execution_id, tenant, task_run_id=task_run_id, revision=revision, breakpoints=breakpoints)

Create a new execution from an old one and start it from a specified task run id

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
    execution_id = 'execution_id_example' # str | the original execution id to clone
    tenant = 'tenant_example' # str | 
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    revision = 56 # int | The flow revision to use for new execution (optional)
    breakpoints = 'breakpoints_example' # str | Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)

    try:
        # Create a new execution from an old one and start it from a specified task run id
        api_response = kestra_client.ExecutionsApi.replay_execution(execution_id, tenant, task_run_id=task_run_id, revision=revision, breakpoints=breakpoints)
        print("The response of ExecutionsApi->replay_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->replay_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| the original execution id to clone | 
 **tenant** | **str**|  | 
 **task_run_id** | **str**| The taskrun id | [optional] 
 **revision** | **int**| The flow revision to use for new execution | [optional] 
 **breakpoints** | **str**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the execution cannot be replayed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **replay_execution_withinputs**
> Execution replay_execution_withinputs(execution_id, tenant, task_run_id=task_run_id, revision=revision, breakpoints=breakpoints)

Create a new execution from an old one and start it from a specified task run id

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
    execution_id = 'execution_id_example' # str | the original execution id to clone
    tenant = 'tenant_example' # str | 
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    revision = 56 # int | The flow revision to use for new execution (optional)
    breakpoints = 'breakpoints_example' # str | Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)

    try:
        # Create a new execution from an old one and start it from a specified task run id
        api_response = kestra_client.ExecutionsApi.replay_execution_withinputs(execution_id, tenant, task_run_id=task_run_id, revision=revision, breakpoints=breakpoints)
        print("The response of ExecutionsApi->replay_execution_withinputs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->replay_execution_withinputs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| the original execution id to clone | 
 **tenant** | **str**|  | 
 **task_run_id** | **str**| The taskrun id | [optional] 
 **revision** | **int**| The flow revision to use for new execution | [optional] 
 **breakpoints** | **str**| Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the execution cannot be replayed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **replay_executions_by_ids**
> ApiAsyncOperationResponse replay_executions_by_ids(tenant, request_body, latest_revision=latest_revision)

Create new executions from old ones asynchronously. Keep the flow revision

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
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The list of executions id
    latest_revision = False # bool | If latest revision should be used (optional) (default to False)

    try:
        # Create new executions from old ones asynchronously. Keep the flow revision
        api_response = kestra_client.ExecutionsApi.replay_executions_by_ids(tenant, request_body, latest_revision=latest_revision)
        print("The response of ExecutionsApi->replay_executions_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->replay_executions_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The list of executions id | 
 **latest_revision** | **bool**| If latest revision should be used | [optional] [default to False]

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | replayExecutionsByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **replay_executions_by_query**
> ApiAsyncOperationResponse replay_executions_by_query(tenant, filters=filters, latest_revision=latest_revision)

Create new executions from old ones filter by query parameters asynchronously. Keep the flow revision

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)
    latest_revision = False # bool | If latest revision should be used (optional) (default to False)

    try:
        # Create new executions from old ones filter by query parameters asynchronously. Keep the flow revision
        api_response = kestra_client.ExecutionsApi.replay_executions_by_query(tenant, filters=filters, latest_revision=latest_revision)
        print("The response of ExecutionsApi->replay_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->replay_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 
 **latest_revision** | **bool**| If latest revision should be used | [optional] [default to False]

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | replayExecutionsByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **restart_execution**
> Execution restart_execution(execution_id, tenant, revision=revision)

Restart a new execution from an old one

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
    revision = 56 # int | The flow revision to use for new execution (optional)

    try:
        # Restart a new execution from an old one
        api_response = kestra_client.ExecutionsApi.restart_execution(execution_id, tenant, revision=revision)
        print("The response of ExecutionsApi->restart_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->restart_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **revision** | **int**| The flow revision to use for new execution | [optional] 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the execution cannot be restarted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **restart_executions_by_ids**
> ApiAsyncOperationResponse restart_executions_by_ids(tenant, request_body, latest_revision=latest_revision)

Restart a list of executions asynchronously

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
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The list of executions id
    latest_revision = False # bool | If latest revision should be used (optional) (default to False)

    try:
        # Restart a list of executions asynchronously
        api_response = kestra_client.ExecutionsApi.restart_executions_by_ids(tenant, request_body, latest_revision=latest_revision)
        print("The response of ExecutionsApi->restart_executions_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->restart_executions_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The list of executions id | 
 **latest_revision** | **bool**| If latest revision should be used | [optional] [default to False]

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | restartExecutionsByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **restart_executions_by_query**
> ApiAsyncOperationResponse restart_executions_by_query(tenant, filters=filters, latest_revision=latest_revision)

Restart executions filter by query parameters asynchronously

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)
    latest_revision = False # bool | If latest revision should be used (optional) (default to False)

    try:
        # Restart executions filter by query parameters asynchronously
        api_response = kestra_client.ExecutionsApi.restart_executions_by_query(tenant, filters=filters, latest_revision=latest_revision)
        print("The response of ExecutionsApi->restart_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->restart_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 
 **latest_revision** | **bool**| If latest revision should be used | [optional] [default to False]

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | restartExecutionsByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resume_execution**
> Execution resume_execution(execution_id, tenant)

Resume a paused execution.

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

    try:
        # Resume a paused execution.
        api_response = kestra_client.ExecutionsApi.resume_execution(execution_id, tenant)
        print("The response of ExecutionsApi->resume_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->resume_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the executions is not paused |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resume_execution_from_breakpoint**
> Execution resume_execution_from_breakpoint(execution_id, tenant, breakpoints=breakpoints)

Resume an execution from a breakpoint (in the 'BREAKPOINT' state).

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
    breakpoints = 'breakpoints_example' # str | \"Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)

    try:
        # Resume an execution from a breakpoint (in the 'BREAKPOINT' state).
        api_response = kestra_client.ExecutionsApi.resume_execution_from_breakpoint(execution_id, tenant, breakpoints=breakpoints)
        print("The response of ExecutionsApi->resume_execution_from_breakpoint:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->resume_execution_from_breakpoint: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **breakpoints** | **str**| \&quot;Set a list of breakpoints at specific tasks &#39;id.value&#39;, separated by a coma. | [optional] 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | If the executions is not in the &#39;BREAKPOINT&#39; state or has no breakpoint |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resume_executions_by_ids**
> ApiAsyncOperationResponse resume_executions_by_ids(tenant, request_body)

Resume a list of paused executions asynchronously

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
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The list of executions id

    try:
        # Resume a list of paused executions asynchronously
        api_response = kestra_client.ExecutionsApi.resume_executions_by_ids(tenant, request_body)
        print("The response of ExecutionsApi->resume_executions_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->resume_executions_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The list of executions id | 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | resumeExecutionsByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resume_executions_by_query**
> ApiAsyncOperationResponse resume_executions_by_query(tenant, filters=filters)

Resume executions filter by query parameters asynchronously

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Resume executions filter by query parameters asynchronously
        api_response = kestra_client.ExecutionsApi.resume_executions_by_query(tenant, filters=filters)
        print("The response of ExecutionsApi->resume_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->resume_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | resumeExecutionsByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_executions**
> PagedResultsApiLightExecution search_executions(tenant, page=page, size=size, sort=sort, filters=filters, date_filter=date_filter)

Search for executions

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
    tenant = 'tenant_example' # str | 
    page = 1 # int | The current page (optional) (default to 1)
    size = 10 # int | The current page size (optional) (default to 10)
    sort = ['state.startDate:asc'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)
    date_filter = kestrapy.ExecutionRepositoryInterfaceDateFilter() # ExecutionRepositoryInterfaceDateFilter | Which execution date field the time interval is applied to (optional)

    try:
        # Search for executions
        api_response = kestra_client.ExecutionsApi.search_executions(tenant, page=page, size=size, sort=sort, filters=filters, date_filter=date_filter)
        print("The response of ExecutionsApi->search_executions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->search_executions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **page** | **int**| The current page | [optional] [default to 1]
 **size** | **int**| The current page size | [optional] [default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 
 **date_filter** | [**ExecutionRepositoryInterfaceDateFilter**](.md)| Which execution date field the time interval is applied to | [optional] 

### Return type

[**PagedResultsApiLightExecution**](PagedResultsApiLightExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchExecutions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_executions_by_flow_id**
> PagedResultsApiLightExecution search_executions_by_flow_id(namespace, flow_id, tenant, page=page, size=size)

Search for executions for a flow

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
    namespace = 'namespace_example' # str | The flow namespace
    flow_id = 'flow_id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    page = 1 # int | The current page (optional) (default to 1)
    size = 10 # int | The current page size (optional) (default to 10)

    try:
        # Search for executions for a flow
        api_response = kestra_client.ExecutionsApi.search_executions_by_flow_id(namespace, flow_id, tenant, page=page, size=size)
        print("The response of ExecutionsApi->search_executions_by_flow_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->search_executions_by_flow_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **flow_id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **page** | **int**| The current page | [optional] [default to 1]
 **size** | **int**| The current page size | [optional] [default to 10]

### Return type

[**PagedResultsApiLightExecution**](PagedResultsApiLightExecution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchExecutionsByFlowId 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_labels_on_terminated_execution**
> Execution set_labels_on_terminated_execution(execution_id, tenant, label)

Add or update labels of a terminated execution

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
    label = [kestrapy.Label()] # List[Label] | The labels to add to the execution

    try:
        # Add or update labels of a terminated execution
        api_response = kestra_client.ExecutionsApi.set_labels_on_terminated_execution(execution_id, tenant, label)
        print("The response of ExecutionsApi->set_labels_on_terminated_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->set_labels_on_terminated_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **label** | [**List[Label]**](Label.md)| The labels to add to the execution | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**400** | If the execution is not terminated |  -  |
**404** | If the execution cannot be found |  -  |
**409** | If labels cannot be applied |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_labels_on_terminated_executions_by_ids**
> ApiAsyncOperationResponse set_labels_on_terminated_executions_by_ids(tenant, execution_controller_set_labels_by_ids_request)

Set labels on a list of executions asynchronously

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
    tenant = 'tenant_example' # str | 
    execution_controller_set_labels_by_ids_request = kestrapy.ExecutionControllerSetLabelsByIdsRequest() # ExecutionControllerSetLabelsByIdsRequest | The request containing a list of labels and a list of executions

    try:
        # Set labels on a list of executions asynchronously
        api_response = kestra_client.ExecutionsApi.set_labels_on_terminated_executions_by_ids(tenant, execution_controller_set_labels_by_ids_request)
        print("The response of ExecutionsApi->set_labels_on_terminated_executions_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->set_labels_on_terminated_executions_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **execution_controller_set_labels_by_ids_request** | [**ExecutionControllerSetLabelsByIdsRequest**](ExecutionControllerSetLabelsByIdsRequest.md)| The request containing a list of labels and a list of executions | 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setLabelsOnTerminatedExecutionsByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_labels_on_terminated_executions_by_query**
> ApiAsyncOperationResponse set_labels_on_terminated_executions_by_query(tenant, label, filters=filters)

Set label on executions filter by query parameters asynchronously

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
    tenant = 'tenant_example' # str | 
    label = [kestrapy.Label()] # List[Label] | The labels to add to the execution
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Set label on executions filter by query parameters asynchronously
        api_response = kestra_client.ExecutionsApi.set_labels_on_terminated_executions_by_query(tenant, label, filters=filters)
        print("The response of ExecutionsApi->set_labels_on_terminated_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->set_labels_on_terminated_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **label** | [**List[Label]**](Label.md)| The labels to add to the execution | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setLabelsOnTerminatedExecutionsByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **trigger_execution_by_get_webhook**
> WebhookResponse trigger_execution_by_get_webhook(namespace, id, key, tenant)

Trigger a new execution by GET webhook trigger

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    key = 'key_example' # str | The webhook trigger uid
    tenant = 'tenant_example' # str | 

    try:
        # Trigger a new execution by GET webhook trigger
        api_response = kestra_client.ExecutionsApi.trigger_execution_by_get_webhook(namespace, id, key, tenant)
        print("The response of ExecutionsApi->trigger_execution_by_get_webhook:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->trigger_execution_by_get_webhook: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **key** | **str**| The webhook trigger uid | 
 **tenant** | **str**|  | 

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **trigger_execution_by_get_webhook_with_path**
> WebhookResponse trigger_execution_by_get_webhook_with_path(namespace, id, key, path, tenant)

Trigger a new execution by GET webhook trigger

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    key = 'key_example' # str | The webhook trigger uid
    path = 'path_example' # str | Optional additional path segments
    tenant = 'tenant_example' # str | 

    try:
        # Trigger a new execution by GET webhook trigger
        api_response = kestra_client.ExecutionsApi.trigger_execution_by_get_webhook_with_path(namespace, id, key, path, tenant)
        print("The response of ExecutionsApi->trigger_execution_by_get_webhook_with_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->trigger_execution_by_get_webhook_with_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **key** | **str**| The webhook trigger uid | 
 **path** | **str**| Optional additional path segments | 
 **tenant** | **str**|  | 

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **trigger_execution_by_post_webhook**
> WebhookResponse trigger_execution_by_post_webhook(namespace, id, key, tenant, body=body)

Trigger a new execution by POST webhook trigger

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    key = 'key_example' # str | The webhook trigger uid
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The webhook payload, of any content type. What the flow sees of it depends on the `fetchType` of the trigger: `trigger.body` by default, `trigger.uri` when the trigger stores it. A `multipart/form-data` payload is handled by a dedicated route: its file parts are stored in Kestra's internal storage and reach the flow as `trigger.parts`, its other parts as `trigger.formFields`. (optional)

    try:
        # Trigger a new execution by POST webhook trigger
        api_response = kestra_client.ExecutionsApi.trigger_execution_by_post_webhook(namespace, id, key, tenant, body=body)
        print("The response of ExecutionsApi->trigger_execution_by_post_webhook:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->trigger_execution_by_post_webhook: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **key** | **str**| The webhook trigger uid | 
 **tenant** | **str**|  | 
 **body** | **str**| The webhook payload, of any content type. What the flow sees of it depends on the &#x60;fetchType&#x60; of the trigger: &#x60;trigger.body&#x60; by default, &#x60;trigger.uri&#x60; when the trigger stores it. A &#x60;multipart/form-data&#x60; payload is handled by a dedicated route: its file parts are stored in Kestra&#39;s internal storage and reach the flow as &#x60;trigger.parts&#x60;, its other parts as &#x60;trigger.formFields&#x60;. | [optional] 

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **trigger_execution_by_post_webhook_with_path**
> WebhookResponse trigger_execution_by_post_webhook_with_path(namespace, id, key, path, tenant, body=body)

Trigger a new execution by POST webhook trigger

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    key = 'key_example' # str | The webhook trigger uid
    path = 'path_example' # str | Optional additional path segments
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The webhook payload, of any content type. What the flow sees of it depends on the `fetchType` of the trigger: `trigger.body` by default, `trigger.uri` when the trigger stores it. A `multipart/form-data` payload is handled by a dedicated route: its file parts are stored in Kestra's internal storage and reach the flow as `trigger.parts`, its other parts as `trigger.formFields`. (optional)

    try:
        # Trigger a new execution by POST webhook trigger
        api_response = kestra_client.ExecutionsApi.trigger_execution_by_post_webhook_with_path(namespace, id, key, path, tenant, body=body)
        print("The response of ExecutionsApi->trigger_execution_by_post_webhook_with_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->trigger_execution_by_post_webhook_with_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **key** | **str**| The webhook trigger uid | 
 **path** | **str**| Optional additional path segments | 
 **tenant** | **str**|  | 
 **body** | **str**| The webhook payload, of any content type. What the flow sees of it depends on the &#x60;fetchType&#x60; of the trigger: &#x60;trigger.body&#x60; by default, &#x60;trigger.uri&#x60; when the trigger stores it. A &#x60;multipart/form-data&#x60; payload is handled by a dedicated route: its file parts are stored in Kestra&#39;s internal storage and reach the flow as &#x60;trigger.parts&#x60;, its other parts as &#x60;trigger.formFields&#x60;. | [optional] 

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **trigger_execution_by_put_webhook**
> WebhookResponse trigger_execution_by_put_webhook(namespace, id, key, tenant, body=body)

Trigger a new execution by PUT webhook trigger

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    key = 'key_example' # str | The webhook trigger uid
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The webhook payload, of any content type. What the flow sees of it depends on the `fetchType` of the trigger: `trigger.body` by default, `trigger.uri` when the trigger stores it. A `multipart/form-data` payload is handled by a dedicated route: its file parts are stored in Kestra's internal storage and reach the flow as `trigger.parts`, its other parts as `trigger.formFields`. (optional)

    try:
        # Trigger a new execution by PUT webhook trigger
        api_response = kestra_client.ExecutionsApi.trigger_execution_by_put_webhook(namespace, id, key, tenant, body=body)
        print("The response of ExecutionsApi->trigger_execution_by_put_webhook:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->trigger_execution_by_put_webhook: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **key** | **str**| The webhook trigger uid | 
 **tenant** | **str**|  | 
 **body** | **str**| The webhook payload, of any content type. What the flow sees of it depends on the &#x60;fetchType&#x60; of the trigger: &#x60;trigger.body&#x60; by default, &#x60;trigger.uri&#x60; when the trigger stores it. A &#x60;multipart/form-data&#x60; payload is handled by a dedicated route: its file parts are stored in Kestra&#39;s internal storage and reach the flow as &#x60;trigger.parts&#x60;, its other parts as &#x60;trigger.formFields&#x60;. | [optional] 

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **trigger_execution_by_put_webhook_with_path**
> WebhookResponse trigger_execution_by_put_webhook_with_path(namespace, id, key, path, tenant, body=body)

Trigger a new execution by PUT webhook trigger

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    key = 'key_example' # str | The webhook trigger uid
    path = 'path_example' # str | Optional additional path segments
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The webhook payload, of any content type. What the flow sees of it depends on the `fetchType` of the trigger: `trigger.body` by default, `trigger.uri` when the trigger stores it. A `multipart/form-data` payload is handled by a dedicated route: its file parts are stored in Kestra's internal storage and reach the flow as `trigger.parts`, its other parts as `trigger.formFields`. (optional)

    try:
        # Trigger a new execution by PUT webhook trigger
        api_response = kestra_client.ExecutionsApi.trigger_execution_by_put_webhook_with_path(namespace, id, key, path, tenant, body=body)
        print("The response of ExecutionsApi->trigger_execution_by_put_webhook_with_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->trigger_execution_by_put_webhook_with_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **key** | **str**| The webhook trigger uid | 
 **path** | **str**| Optional additional path segments | 
 **tenant** | **str**|  | 
 **body** | **str**| The webhook payload, of any content type. What the flow sees of it depends on the &#x60;fetchType&#x60; of the trigger: &#x60;trigger.body&#x60; by default, &#x60;trigger.uri&#x60; when the trigger stores it. A &#x60;multipart/form-data&#x60; payload is handled by a dedicated route: its file parts are stored in Kestra&#39;s internal storage and reach the flow as &#x60;trigger.parts&#x60;, its other parts as &#x60;trigger.formFields&#x60;. | [optional] 

### Return type

[**WebhookResponse**](WebhookResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unqueue_execution**
> Execution unqueue_execution(execution_id, state, tenant)

Unqueue an execution

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
    state = kestrapy.StateType() # StateType | The new state of the execution
    tenant = 'tenant_example' # str | 

    try:
        # Unqueue an execution
        api_response = kestra_client.ExecutionsApi.unqueue_execution(execution_id, state, tenant)
        print("The response of ExecutionsApi->unqueue_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->unqueue_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **state** | [**StateType**](.md)| The new state of the execution | 
 **tenant** | **str**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the execution cannot be unqueued |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unqueue_executions_by_ids**
> ApiAsyncOperationResponse unqueue_executions_by_ids(state, tenant, request_body)

Unqueue a list of executions asynchronously

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
    state = kestrapy.StateType() # StateType | The new state of the unqueued executions
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The list of executions id

    try:
        # Unqueue a list of executions asynchronously
        api_response = kestra_client.ExecutionsApi.unqueue_executions_by_ids(state, tenant, request_body)
        print("The response of ExecutionsApi->unqueue_executions_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->unqueue_executions_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **state** | [**StateType**](.md)| The new state of the unqueued executions | 
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The list of executions id | 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | unqueueExecutionsByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unqueue_executions_by_query**
> ApiAsyncOperationResponse unqueue_executions_by_query(tenant, filters=filters, new_state=new_state)

Unqueue executions filter by query parameters asynchronously

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
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)
    new_state = kestrapy.StateType() # StateType | The new state of the unqueued executions (optional)

    try:
        # Unqueue executions filter by query parameters asynchronously
        api_response = kestra_client.ExecutionsApi.unqueue_executions_by_query(tenant, filters=filters, new_state=new_state)
        print("The response of ExecutionsApi->unqueue_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->unqueue_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 
 **new_state** | [**StateType**](.md)| The new state of the unqueued executions | [optional] 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | unqueueExecutionsByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_execution_status**
> Execution update_execution_status(execution_id, status, tenant)

Change the state of an execution

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
    status = kestrapy.StateType() # StateType | The new state of the execution
    tenant = 'tenant_example' # str | 

    try:
        # Change the state of an execution
        api_response = kestra_client.ExecutionsApi.update_execution_status(execution_id, status, tenant)
        print("The response of ExecutionsApi->update_execution_status:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->update_execution_status: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **status** | [**StateType**](.md)| The new state of the execution | 
 **tenant** | **str**|  | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the execution state cannot be changed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_executions_status_by_ids**
> ApiAsyncOperationResponse update_executions_status_by_ids(new_status, tenant, request_body)

Change executions state by id asynchronously

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
    new_status = kestrapy.StateType() # StateType | The new state of the executions
    tenant = 'tenant_example' # str | 
    request_body = ['request_body_example'] # List[str] | The list of executions id

    try:
        # Change executions state by id asynchronously
        api_response = kestra_client.ExecutionsApi.update_executions_status_by_ids(new_status, tenant, request_body)
        print("The response of ExecutionsApi->update_executions_status_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->update_executions_status_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **new_status** | [**StateType**](.md)| The new state of the executions | 
 **tenant** | **str**|  | 
 **request_body** | [**List[str]**](str.md)| The list of executions id | 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateExecutionsStatusByIds 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_executions_status_by_query**
> ApiAsyncOperationResponse update_executions_status_by_query(new_status, tenant, filters=filters)

Change executions state by query parameters asynchronously

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
    new_status = kestrapy.StateType() # StateType | The new state of the executions
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[timeRange][EQUALS]=PT168H`, `filters[scope][EQUALS]=USER`, `filters[state][IN]=FAILED,CANCELLED`, `filters[labels][NOT_EQUALS][foo]=bar`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Change executions state by query parameters asynchronously
        api_response = kestra_client.ExecutionsApi.update_executions_status_by_query(new_status, tenant, filters=filters)
        print("The response of ExecutionsApi->update_executions_status_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->update_executions_status_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **new_status** | [**StateType**](.md)| The new state of the executions | 
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[timeRange][EQUALS]&#x3D;PT168H&#x60;, &#x60;filters[scope][EQUALS]&#x3D;USER&#x60;, &#x60;filters[state][IN]&#x3D;FAILED,CANCELLED&#x60;, &#x60;filters[labels][NOT_EQUALS][foo]&#x3D;bar&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

### Return type

[**ApiAsyncOperationResponse**](ApiAsyncOperationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateExecutionsStatusByQuery 200 response |  -  |
**202** | Accepted |  -  |
**400** | Validation errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_task_run_state**
> Execution update_task_run_state(execution_id, tenant, execution_controller_state_request)

Change state for a taskrun in an execution

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
    execution_controller_state_request = kestrapy.ExecutionControllerStateRequest() # ExecutionControllerStateRequest | the taskRun id and state to apply

    try:
        # Change state for a taskrun in an execution
        api_response = kestra_client.ExecutionsApi.update_task_run_state(execution_id, tenant, execution_controller_state_request)
        print("The response of ExecutionsApi->update_task_run_state:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->update_task_run_state: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **execution_controller_state_request** | [**ExecutionControllerStateRequest**](ExecutionControllerStateRequest.md)| the taskRun id and state to apply | 

### Return type

[**Execution**](Execution.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | if the task run state cannot be changed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_new_execution_inputs**
> List[ExecutionControllerApiValidateExecutionInputsResponse] validate_new_execution_inputs(namespace, id, labels, tenant, revision=revision)

Validate the creation of a new execution for a flow

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
    namespace = 'namespace_example' # str | The flow namespace
    id = 'id_example' # str | The flow id
    labels = ['labels_example'] # List[str] | The labels as a list of 'key:value'
    tenant = 'tenant_example' # str | 
    revision = 56 # int | The flow revision or latest if null (optional)

    try:
        # Validate the creation of a new execution for a flow
        api_response = kestra_client.ExecutionsApi.validate_new_execution_inputs(namespace, id, labels, tenant, revision=revision)
        print("The response of ExecutionsApi->validate_new_execution_inputs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->validate_new_execution_inputs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **labels** | [**List[str]**](str.md)| The labels as a list of &#39;key:value&#39; | 
 **tenant** | **str**|  | 
 **revision** | **int**| The flow revision or latest if null | [optional] 

### Return type

[**List[ExecutionControllerApiValidateExecutionInputsResponse]**](ExecutionControllerApiValidateExecutionInputsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | validateNewExecutionInputs 200 response |  -  |
**409** | if the flow is disabled |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_resume_execution_inputs**
> List[ExecutionControllerApiValidateExecutionInputsResponse] validate_resume_execution_inputs(execution_id, tenant)

Validate inputs to resume a paused execution.

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

    try:
        # Validate inputs to resume a paused execution.
        api_response = kestra_client.ExecutionsApi.validate_resume_execution_inputs(execution_id, tenant)
        print("The response of ExecutionsApi->validate_resume_execution_inputs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->validate_resume_execution_inputs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 

### Return type

[**List[ExecutionControllerApiValidateExecutionInputsResponse]**](ExecutionControllerApiValidateExecutionInputsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | validateResumeExecutionInputs 200 response |  -  |
**204** | On success |  -  |
**409** | if the executions is not paused |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

