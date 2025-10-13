# kestrapy.MetricApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**aggregate_metrics_from_flow**](MetricApi.md#aggregate_metrics_from_flow) | **GET** /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{metric} | Get metrics aggregations for a specific flow
[**aggregate_metrics_from_task**](MetricApi.md#aggregate_metrics_from_task) | **GET** /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{taskId}/{metric} | Get metrics aggregations for a specific flow
[**list_flow_metrics**](MetricApi.md#list_flow_metrics) | **GET** /api/v1/{tenant}/metrics/names/{namespace}/{flowId} | Get metrics names for a specific flow
[**list_task_metrics**](MetricApi.md#list_task_metrics) | **GET** /api/v1/{tenant}/metrics/names/{namespace}/{flowId}/{taskId} | Get metrics names for a specific task in a flow
[**list_tasks_with_metrics**](MetricApi.md#list_tasks_with_metrics) | **GET** /api/v1/{tenant}/metrics/tasks/{namespace}/{flowId} | Get tasks id that have metrics for a specific flow, include deleted or renamed tasks
[**search_by_execution**](MetricApi.md#search_by_execution) | **GET** /api/v1/{tenant}/metrics/{executionId} | Get metrics for a specific execution


# **aggregate_metrics_from_flow**
> MetricAggregations aggregate_metrics_from_flow(namespace, flow_id, metric, aggregation, tenant, start_date=start_date, end_date=end_date)

Get metrics aggregations for a specific flow

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.metric_aggregations import MetricAggregations
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
    api_instance = kestrapy.MetricApi(api_client)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow Id
    metric = 'metric_example' # str | The metric name
    aggregation = 'sum' # str | The type of aggregation: avg, sum, min or max (default to 'sum')
    tenant = 'tenant_example' # str | 
    start_date = '2013-10-20T19:20:30+01:00' # datetime | The start datetime, default to now - 30 days (optional)
    end_date = '2013-10-20T19:20:30+01:00' # datetime | The end datetime, default to now (optional)

    try:
        # Get metrics aggregations for a specific flow
        api_response = api_instance.aggregate_metrics_from_flow(namespace, flow_id, metric, aggregation, tenant, start_date=start_date, end_date=end_date)
        print("The response of MetricApi->aggregate_metrics_from_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MetricApi->aggregate_metrics_from_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow Id | 
 **metric** | **str**| The metric name | 
 **aggregation** | **str**| The type of aggregation: avg, sum, min or max | [default to &#39;sum&#39;]
 **tenant** | **str**|  | 
 **start_date** | **datetime**| The start datetime, default to now - 30 days | [optional] 
 **end_date** | **datetime**| The end datetime, default to now | [optional] 

### Return type

[**MetricAggregations**](MetricAggregations.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | aggregateMetricsFromFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **aggregate_metrics_from_task**
> MetricAggregations aggregate_metrics_from_task(namespace, flow_id, task_id, metric, aggregation, tenant, start_date=start_date, end_date=end_date)

Get metrics aggregations for a specific flow

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.metric_aggregations import MetricAggregations
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
    api_instance = kestrapy.MetricApi(api_client)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow Id
    task_id = 'task_id_example' # str | The task Id
    metric = 'metric_example' # str | The metric name
    aggregation = 'sum' # str | The type of aggregation: avg, sum, min or max (default to 'sum')
    tenant = 'tenant_example' # str | 
    start_date = '2013-10-20T19:20:30+01:00' # datetime | The start datetime, default to now - 30 days (optional)
    end_date = '2013-10-20T19:20:30+01:00' # datetime | The end datetime, default to now (optional)

    try:
        # Get metrics aggregations for a specific flow
        api_response = api_instance.aggregate_metrics_from_task(namespace, flow_id, task_id, metric, aggregation, tenant, start_date=start_date, end_date=end_date)
        print("The response of MetricApi->aggregate_metrics_from_task:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MetricApi->aggregate_metrics_from_task: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow Id | 
 **task_id** | **str**| The task Id | 
 **metric** | **str**| The metric name | 
 **aggregation** | **str**| The type of aggregation: avg, sum, min or max | [default to &#39;sum&#39;]
 **tenant** | **str**|  | 
 **start_date** | **datetime**| The start datetime, default to now - 30 days | [optional] 
 **end_date** | **datetime**| The end datetime, default to now | [optional] 

### Return type

[**MetricAggregations**](MetricAggregations.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | aggregateMetricsFromTask 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_flow_metrics**
> List[str] list_flow_metrics(namespace, flow_id, tenant)

Get metrics names for a specific flow

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
    api_instance = kestrapy.MetricApi(api_client)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow Id
    tenant = 'tenant_example' # str | 

    try:
        # Get metrics names for a specific flow
        api_response = api_instance.list_flow_metrics(namespace, flow_id, tenant)
        print("The response of MetricApi->list_flow_metrics:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MetricApi->list_flow_metrics: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow Id | 
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
**200** | listFlowMetrics 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_task_metrics**
> List[str] list_task_metrics(namespace, flow_id, task_id, tenant)

Get metrics names for a specific task in a flow

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
    api_instance = kestrapy.MetricApi(api_client)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow Id
    task_id = 'task_id_example' # str | The task Id
    tenant = 'tenant_example' # str | 

    try:
        # Get metrics names for a specific task in a flow
        api_response = api_instance.list_task_metrics(namespace, flow_id, task_id, tenant)
        print("The response of MetricApi->list_task_metrics:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MetricApi->list_task_metrics: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow Id | 
 **task_id** | **str**| The task Id | 
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
**200** | listTaskMetrics 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_tasks_with_metrics**
> List[str] list_tasks_with_metrics(namespace, flow_id, tenant)

Get tasks id that have metrics for a specific flow, include deleted or renamed tasks

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
    api_instance = kestrapy.MetricApi(api_client)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow Id
    tenant = 'tenant_example' # str | 

    try:
        # Get tasks id that have metrics for a specific flow, include deleted or renamed tasks
        api_response = api_instance.list_tasks_with_metrics(namespace, flow_id, tenant)
        print("The response of MetricApi->list_tasks_with_metrics:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MetricApi->list_tasks_with_metrics: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow Id | 
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
**200** | listTasksWithMetrics 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_by_execution**
> PagedResultsMetricEntry search_by_execution(page, size, execution_id, tenant, sort=sort, task_run_id=task_run_id, task_id=task_id)

Get metrics for a specific execution

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_metric_entry import PagedResultsMetricEntry
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
    api_instance = kestrapy.MetricApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    execution_id = 'execution_id_example' # str | The execution id
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    task_run_id = 'task_run_id_example' # str | The taskrun id (optional)
    task_id = 'task_id_example' # str | The task id (optional)

    try:
        # Get metrics for a specific execution
        api_response = api_instance.search_by_execution(page, size, execution_id, tenant, sort=sort, task_run_id=task_run_id, task_id=task_id)
        print("The response of MetricApi->search_by_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MetricApi->search_by_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **execution_id** | **str**| The execution id | 
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **task_run_id** | **str**| The taskrun id | [optional] 
 **task_id** | **str**| The task id | [optional] 

### Return type

[**PagedResultsMetricEntry**](PagedResultsMetricEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchByExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

