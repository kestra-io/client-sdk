# kestrapy.ExecutionsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_execution**](ExecutionsApi.md#create_execution) | **POST** /api/v1/{tenant}/executions/{namespace}/{id} | Create a new execution for a flow
[**delete_execution**](ExecutionsApi.md#delete_execution) | **DELETE** /api/v1/{tenant}/executions/{executionId} | Delete an execution
[**delete_executions_by_ids**](ExecutionsApi.md#delete_executions_by_ids) | **DELETE** /api/v1/{tenant}/executions/by-ids | Delete a list of executions
[**delete_executions_by_query**](ExecutionsApi.md#delete_executions_by_query) | **DELETE** /api/v1/{tenant}/executions/by-query | Delete executions filter by query parameters
[**download_file_from_execution**](ExecutionsApi.md#download_file_from_execution) | **GET** /api/v1/{tenant}/executions/{executionId}/file | Download file for an execution
[**execution**](ExecutionsApi.md#execution) | **GET** /api/v1/{tenant}/executions/{executionId} | Get an execution
[**execution_flow_graph**](ExecutionsApi.md#execution_flow_graph) | **GET** /api/v1/{tenant}/executions/{executionId}/graph | Generate a graph for an execution
[**file_metadatas_from_execution**](ExecutionsApi.md#file_metadatas_from_execution) | **GET** /api/v1/{tenant}/executions/{executionId}/file/metas | Get file meta information for an execution
[**flow_from_execution**](ExecutionsApi.md#flow_from_execution) | **GET** /api/v1/{tenant}/executions/flows/{namespace}/{flowId} | Get flow information&#39;s for an execution
[**flow_from_execution_by_id**](ExecutionsApi.md#flow_from_execution_by_id) | **GET** /api/v1/{tenant}/executions/{executionId}/flow | Get flow information&#39;s for an execution
[**follow_dependencies_executions**](ExecutionsApi.md#follow_dependencies_executions) | **GET** /api/v1/{tenant}/executions/{executionId}/follow-dependencies | Follow all execution dependencies executions
[**follow_execution**](ExecutionsApi.md#follow_execution) | **GET** /api/v1/{tenant}/executions/{executionId}/follow | Follow an execution
[**force_run_by_ids**](ExecutionsApi.md#force_run_by_ids) | **POST** /api/v1/{tenant}/executions/force-run/by-ids | Force run a list of executions
[**force_run_execution**](ExecutionsApi.md#force_run_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/force-run | Force run an execution
[**force_run_executions_by_query**](ExecutionsApi.md#force_run_executions_by_query) | **POST** /api/v1/{tenant}/executions/force-run/by-query | Force run executions filter by query parameters
[**kill_execution**](ExecutionsApi.md#kill_execution) | **DELETE** /api/v1/{tenant}/executions/{executionId}/kill | Kill an execution
[**kill_executions_by_ids**](ExecutionsApi.md#kill_executions_by_ids) | **DELETE** /api/v1/{tenant}/executions/kill/by-ids | Kill a list of executions
[**kill_executions_by_query**](ExecutionsApi.md#kill_executions_by_query) | **DELETE** /api/v1/{tenant}/executions/kill/by-query | Kill executions filter by query parameters
[**latest_executions**](ExecutionsApi.md#latest_executions) | **POST** /api/v1/{tenant}/executions/latest | Get the latest execution for given flows
[**pause_execution**](ExecutionsApi.md#pause_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/pause | Pause a running execution.
[**pause_executions_by_ids**](ExecutionsApi.md#pause_executions_by_ids) | **POST** /api/v1/{tenant}/executions/pause/by-ids | Pause a list of running executions
[**pause_executions_by_query**](ExecutionsApi.md#pause_executions_by_query) | **POST** /api/v1/{tenant}/executions/pause/by-query | Pause executions filter by query parameters
[**replay_execution**](ExecutionsApi.md#replay_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/replay | Create a new execution from an old one and start it from a specified task run id
[**replay_execution_withinputs**](ExecutionsApi.md#replay_execution_withinputs) | **POST** /api/v1/{tenant}/executions/{executionId}/replay-with-inputs | Create a new execution from an old one and start it from a specified task run id
[**replay_executions_by_ids**](ExecutionsApi.md#replay_executions_by_ids) | **POST** /api/v1/{tenant}/executions/replay/by-ids | Create new executions from old ones. Keep the flow revision
[**replay_executions_by_query**](ExecutionsApi.md#replay_executions_by_query) | **POST** /api/v1/{tenant}/executions/replay/by-query | Create new executions from old ones filter by query parameters. Keep the flow revision
[**restart_execution**](ExecutionsApi.md#restart_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/restart | Restart a new execution from an old one
[**restart_executions_by_ids**](ExecutionsApi.md#restart_executions_by_ids) | **POST** /api/v1/{tenant}/executions/restart/by-ids | Restart a list of executions
[**restart_executions_by_query**](ExecutionsApi.md#restart_executions_by_query) | **POST** /api/v1/{tenant}/executions/restart/by-query | Restart executions filter by query parameters
[**resume_execution**](ExecutionsApi.md#resume_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/resume | Resume a paused execution.
[**resume_executions_by_ids**](ExecutionsApi.md#resume_executions_by_ids) | **POST** /api/v1/{tenant}/executions/resume/by-ids | Resume a list of paused executions
[**resume_executions_by_query**](ExecutionsApi.md#resume_executions_by_query) | **POST** /api/v1/{tenant}/executions/resume/by-query | Resume executions filter by query parameters
[**search_concurrency_limits**](ExecutionsApi.md#search_concurrency_limits) | **GET** /api/v1/{tenant}/concurrency-limit/search | Search for flow concurrency limits
[**search_executions**](ExecutionsApi.md#search_executions) | **GET** /api/v1/{tenant}/executions/search | Search for executions
[**search_executions_by_flow_id**](ExecutionsApi.md#search_executions_by_flow_id) | **GET** /api/v1/{tenant}/executions | Search for executions for a flow
[**set_labels_on_terminated_execution**](ExecutionsApi.md#set_labels_on_terminated_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/labels | Add or update labels of a terminated execution
[**set_labels_on_terminated_executions_by_ids**](ExecutionsApi.md#set_labels_on_terminated_executions_by_ids) | **POST** /api/v1/{tenant}/executions/labels/by-ids | Set labels on a list of executions
[**set_labels_on_terminated_executions_by_query**](ExecutionsApi.md#set_labels_on_terminated_executions_by_query) | **POST** /api/v1/{tenant}/executions/labels/by-query | Set label on executions filter by query parameters
[**trigger_execution_by_get_webhook**](ExecutionsApi.md#trigger_execution_by_get_webhook) | **GET** /api/v1/{tenant}/executions/webhook/{namespace}/{id}/{key} | Trigger a new execution by GET webhook trigger
[**unqueue_execution**](ExecutionsApi.md#unqueue_execution) | **POST** /api/v1/{tenant}/executions/{executionId}/unqueue | Unqueue an execution
[**unqueue_executions_by_ids**](ExecutionsApi.md#unqueue_executions_by_ids) | **POST** /api/v1/{tenant}/executions/unqueue/by-ids | Unqueue a list of executions
[**unqueue_executions_by_query**](ExecutionsApi.md#unqueue_executions_by_query) | **POST** /api/v1/{tenant}/executions/unqueue/by-query | Unqueue executions filter by query parameters
[**update_concurrency_limit**](ExecutionsApi.md#update_concurrency_limit) | **PUT** /api/v1/{tenant}/concurrency-limit/{namespace}/{flowId} | Update a flow concurrency limit
[**update_execution_status**](ExecutionsApi.md#update_execution_status) | **POST** /api/v1/{tenant}/executions/{executionId}/change-status | Change the state of an execution
[**update_executions_status_by_ids**](ExecutionsApi.md#update_executions_status_by_ids) | **POST** /api/v1/{tenant}/executions/change-status/by-ids | Change executions state by id
[**update_executions_status_by_query**](ExecutionsApi.md#update_executions_status_by_query) | **POST** /api/v1/{tenant}/executions/change-status/by-query | Change executions state by query parameters


# **create_execution**
> ExecutionControllerExecutionResponse create_execution(namespace, id, wait, tenant, labels=labels, revision=revision, schedule_date=schedule_date, breakpoints=breakpoints, kind=kind)

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
    wait = False # bool | If the server will wait the end of the execution (default to False)
    tenant = 'tenant_example' # str | 
    labels = ['labels_example'] # List[str] | The labels as a list of 'key:value' (optional)
    revision = 56 # int | The flow revision or latest if null (optional)
    schedule_date = '2013-10-20T19:20:30+01:00' # datetime | Schedule the flow on a specific date (optional)
    breakpoints = 'breakpoints_example' # str | Set a list of breakpoints at specific tasks 'id.value', separated by a coma. (optional)
    kind = kestrapy.ExecutionKind() # ExecutionKind | Specific execution kind (optional)

    try:
        # Create a new execution for a flow
        api_response = kestra_client.ExecutionsApi.create_execution(namespace, id, wait, tenant, labels=labels, revision=revision, schedule_date=schedule_date, breakpoints=breakpoints, kind=kind)
        print("The response of ExecutionsApi->create_execution:\n")
        print(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->create_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The flow namespace | 
 **id** | **str**| The flow id | 
 **wait** | **bool**| If the server will wait the end of the execution | [default to False]
 **tenant** | **str**|  | 
 **labels** | [**List[str]**](str.md)| The labels as a list of &#39;key:value&#39; | [optional] 
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
> object delete_executions_by_query(tenant, filters=filters, include_non_terminated=include_non_terminated, delete_logs=delete_logs, delete_metrics=delete_metrics, delete_storage=delete_storage)

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)
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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 
 **include_non_terminated** | **bool**| Whether to delete non-terminated executions | [optional] [default to False]
 **delete_logs** | **bool**| Whether to delete execution logs | [optional] [default to True]
 **delete_metrics** | **bool**| Whether to delete execution metrics | [optional] [default to True]
 **delete_storage** | **bool**| Whether to delete execution files in the internal storage | [optional] [default to True]

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
**200** | deleteExecutionsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **download_file_from_execution**
> bytearray download_file_from_execution(execution_id, path, tenant)

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

    try:
        # Download file for an execution
        api_response = kestra_client.ExecutionsApi.download_file_from_execution(execution_id, path, tenant)
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

### Return type

**bytearray**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | downloadFileFromExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **execution**
> Execution execution(execution_id, tenant)

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

[**Execution**](Execution.md)

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
    execution_id = 'execution_id_example' # str | The execution that you want flow informations
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
 **execution_id** | **str**| The execution that you want flow informations | 
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
> EventExecutionStatusEvent follow_dependencies_executions(execution_id, destination_only, expand_all, tenant)

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
    destination_only = False # bool | If true, list only destination dependencies, otherwise list also source dependencies (default to False)
    expand_all = False # bool | If true, expand all dependencies recursively (default to False)
    tenant = 'tenant_example' # str | 

    try:
        # Follow all execution dependencies executions
        api_response = kestra_client.ExecutionsApi.follow_dependencies_executions(execution_id, destination_only, expand_all, tenant)
        print("The response of ExecutionsApi->follow_dependencies_executions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->follow_dependencies_executions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **destination_only** | **bool**| If true, list only destination dependencies, otherwise list also source dependencies | [default to False]
 **expand_all** | **bool**| If true, expand all dependencies recursively | [default to False]
 **tenant** | **str**|  | 

### Return type

[**EventExecutionStatusEvent**](EventExecutionStatusEvent.md)

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
> EventExecution follow_execution(execution_id, tenant)

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

[**EventExecution**](EventExecution.md)

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
> BulkResponse force_run_by_ids(tenant, request_body)

Force run a list of executions

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
        # Force run a list of executions
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
**422** | Force run with errors |  -  |

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
**200** | forceRunExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **force_run_executions_by_query**
> object force_run_executions_by_query(tenant, filters=filters)

Force run executions filter by query parameters

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Force run executions filter by query parameters
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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**200** | forceRunExecutionsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **kill_execution**
> object kill_execution(execution_id, is_on_kill_cascade, tenant)

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
    is_on_kill_cascade = True # bool | Specifies whether killing the execution also kill all subflow executions. (default to True)
    tenant = 'tenant_example' # str | 

    try:
        # Kill an execution
        api_response = kestra_client.ExecutionsApi.kill_execution(execution_id, is_on_kill_cascade, tenant)
        print("The response of ExecutionsApi->kill_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->kill_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
 **is_on_kill_cascade** | **bool**| Specifies whether killing the execution also kill all subflow executions. | [default to True]
 **tenant** | **str**|  | 

### Return type

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | killExecution 200 response |  -  |
**202** | Execution kill was requested successfully |  -  |
**404** | if the executions is not found |  -  |
**409** | if the executions is already finished |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **kill_executions_by_ids**
> BulkResponse kill_executions_by_ids(tenant, request_body)

Kill a list of executions

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
        # Kill a list of executions
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
**422** | Killed with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **kill_executions_by_query**
> object kill_executions_by_query(tenant, filters=filters)

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**200** | killExecutionsByQuery 200 response |  -  |

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

# **pause_execution**
> pause_execution(execution_id, tenant)

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
        kestra_client.ExecutionsApi.pause_execution(execution_id, tenant)
    except Exception as e:
        print("Exception when calling ExecutionsApi->pause_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execution_id** | **str**| The execution id | 
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
**200** | pauseExecution 200 response |  -  |
**204** | On success |  -  |
**409** | if the executions is not running |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_executions_by_ids**
> BulkResponse pause_executions_by_ids(tenant, request_body)

Pause a list of running executions

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
        # Pause a list of running executions
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
**422** | Paused with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_executions_by_query**
> object pause_executions_by_query(tenant, filters=filters)

Pause executions filter by query parameters

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Pause executions filter by query parameters
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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**200** | pauseExecutionsByQuery 200 response |  -  |

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
**200** | replayExecution 200 response |  -  |

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
**200** | replayExecutionWithinputs 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **replay_executions_by_ids**
> BulkResponse replay_executions_by_ids(tenant, request_body, latest_revision=latest_revision)

Create new executions from old ones. Keep the flow revision

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
        # Create new executions from old ones. Keep the flow revision
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
**422** | Replayed with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **replay_executions_by_query**
> object replay_executions_by_query(tenant, filters=filters, latest_revision=latest_revision)

Create new executions from old ones filter by query parameters. Keep the flow revision

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)
    latest_revision = False # bool | If latest revision should be used (optional) (default to False)

    try:
        # Create new executions from old ones filter by query parameters. Keep the flow revision
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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 
 **latest_revision** | **bool**| If latest revision should be used | [optional] [default to False]

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
**200** | replayExecutionsByQuery 200 response |  -  |

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
**200** | restartExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **restart_executions_by_ids**
> BulkResponse restart_executions_by_ids(tenant, request_body)

Restart a list of executions

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
        # Restart a list of executions
        api_response = kestra_client.ExecutionsApi.restart_executions_by_ids(tenant, request_body)
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
**422** | Restarted with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **restart_executions_by_query**
> object restart_executions_by_query(tenant, filters=filters)

Restart executions filter by query parameters

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Restart executions filter by query parameters
        api_response = kestra_client.ExecutionsApi.restart_executions_by_query(tenant, filters=filters)
        print("The response of ExecutionsApi->restart_executions_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->restart_executions_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**200** | restartExecutionsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resume_execution**
> object resume_execution(execution_id, tenant)

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

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | resumeExecution 200 response |  -  |
**204** | On success |  -  |
**409** | if the executions is not paused |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resume_executions_by_ids**
> BulkResponse resume_executions_by_ids(tenant, request_body)

Resume a list of paused executions

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
        # Resume a list of paused executions
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
**422** | Resumed with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resume_executions_by_query**
> object resume_executions_by_query(tenant, filters=filters)

Resume executions filter by query parameters

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Resume executions filter by query parameters
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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**200** | resumeExecutionsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_concurrency_limits**
> PagedResultsConcurrencyLimit search_concurrency_limits(tenant)

Search for flow concurrency limits

### Example


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
        # Search for flow concurrency limits
        api_response = kestra_client.ExecutionsApi.search_concurrency_limits(tenant)
        print("The response of ExecutionsApi->search_concurrency_limits:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->search_concurrency_limits: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 

### Return type

[**PagedResultsConcurrencyLimit**](PagedResultsConcurrencyLimit.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchConcurrencyLimits 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_executions**
> PagedResultsExecution search_executions(page, size, tenant, sort=sort, filters=filters)

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
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Search for executions
        api_response = kestra_client.ExecutionsApi.search_executions(page, size, tenant, sort=sort, filters=filters)
        print("The response of ExecutionsApi->search_executions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->search_executions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**PagedResultsExecution**](PagedResultsExecution.md)

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
> PagedResultsExecution search_executions_by_flow_id(namespace, flow_id, page, size, tenant)

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
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 

    try:
        # Search for executions for a flow
        api_response = kestra_client.ExecutionsApi.search_executions_by_flow_id(namespace, flow_id, page, size, tenant)
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
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 

### Return type

[**PagedResultsExecution**](PagedResultsExecution.md)

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
> object set_labels_on_terminated_execution(execution_id, tenant, label)

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

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setLabelsOnTerminatedExecution 200 response |  -  |
**400** | If the execution is not terminated |  -  |
**404** | If the execution cannot be found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_labels_on_terminated_executions_by_ids**
> BulkResponse set_labels_on_terminated_executions_by_ids(tenant, execution_controller_set_labels_by_ids_request)

Set labels on a list of executions

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
        # Set labels on a list of executions
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
**422** | Killed with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_labels_on_terminated_executions_by_query**
> object set_labels_on_terminated_executions_by_query(tenant, label, filters=filters)

Set label on executions filter by query parameters

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Set label on executions filter by query parameters
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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setLabelsOnTerminatedExecutionsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **trigger_execution_by_get_webhook**
> ExecutionControllerWebhookResponse trigger_execution_by_get_webhook(namespace, id, key, tenant)

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

[**ExecutionControllerWebhookResponse**](ExecutionControllerWebhookResponse.md)

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
**200** | unqueueExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unqueue_executions_by_ids**
> BulkResponse unqueue_executions_by_ids(state, tenant, request_body)

Unqueue a list of executions

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
        # Unqueue a list of executions
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
**422** | Unqueued with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unqueue_executions_by_query**
> object unqueue_executions_by_query(tenant, filters=filters, new_state=new_state)

Unqueue executions filter by query parameters

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)
    new_state = kestrapy.StateType() # StateType | The new state of the unqueued executions (optional)

    try:
        # Unqueue executions filter by query parameters
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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 
 **new_state** | [**StateType**](.md)| The new state of the unqueued executions | [optional] 

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
**200** | unqueueExecutionsByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_concurrency_limit**
> ConcurrencyLimit update_concurrency_limit(flow_id, namespace, tenant, concurrency_limit)

Update a flow concurrency limit

### Example


```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    flow_id = 'flow_id_example' # str | 
    namespace = 'namespace_example' # str | 
    tenant = 'tenant_example' # str | 
    concurrency_limit = kestrapy.ConcurrencyLimit() # ConcurrencyLimit | 

    try:
        # Update a flow concurrency limit
        api_response = kestra_client.ExecutionsApi.update_concurrency_limit(flow_id, namespace, tenant, concurrency_limit)
        print("The response of ExecutionsApi->update_concurrency_limit:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ExecutionsApi->update_concurrency_limit: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **flow_id** | **str**|  | 
 **namespace** | **str**|  | 
 **tenant** | **str**|  | 
 **concurrency_limit** | [**ConcurrencyLimit**](ConcurrencyLimit.md)|  | 

### Return type

[**ConcurrencyLimit**](ConcurrencyLimit.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateConcurrencyLimit 200 response |  -  |

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
**200** | updateExecutionStatus 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_executions_status_by_ids**
> BulkResponse update_executions_status_by_ids(new_status, tenant, request_body)

Change executions state by id

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
        # Change executions state by id
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
**422** | Changed state with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_executions_status_by_query**
> BulkResponse update_executions_status_by_query(new_status, tenant, filters=filters)

Change executions state by query parameters

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Change executions state by query parameters
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
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

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
**422** | Changed state with errors |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

