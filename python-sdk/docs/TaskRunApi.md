# kestrapy.TaskRunApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**search_task_run**](TaskRunApi.md#search_task_run) | **GET** /api/v1/{tenant}/taskruns/search | Search for taskruns, only available with the Elasticsearch repository


# **search_task_run**
> PagedResultsTaskRun search_task_run(page, size, tenant, sort=sort, filters=filters, q=q, namespace=namespace, flow_id=flow_id, start_date=start_date, end_date=end_date, time_range=time_range, state=state, labels=labels, trigger_execution_id=trigger_execution_id, child_filter=child_filter)

Search for taskruns, only available with the Elasticsearch repository

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_task_run import PagedResultsTaskRun
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.state_type import StateType
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
    api_instance = kestrapy.TaskRunApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)
    flow_id = 'flow_id_example' # str | A flow id filter (optional)
    start_date = '2013-10-20T19:20:30+01:00' # datetime | The start datetime (optional)
    end_date = '2013-10-20T19:20:30+01:00' # datetime | The end datetime (optional)
    time_range = 'PT5M' # str | A time range filter relative to the current time (optional)
    state = [kestrapy.StateType()] # List[StateType] | A state filter (optional)
    labels = ['labels_example'] # List[str] | A labels filter as a list of 'key:value' (optional)
    trigger_execution_id = 'trigger_execution_id_example' # str | The trigger execution id (optional)
    child_filter = kestrapy.ExecutionRepositoryInterfaceChildFilter() # ExecutionRepositoryInterfaceChildFilter | A execution child filter (optional)

    try:
        # Search for taskruns, only available with the Elasticsearch repository
        api_response = api_instance.search_task_run(page, size, tenant, sort=sort, filters=filters, q=q, namespace=namespace, flow_id=flow_id, start_date=start_date, end_date=end_date, time_range=time_range, state=state, labels=labels, trigger_execution_id=trigger_execution_id, child_filter=child_filter)
        print("The response of TaskRunApi->search_task_run:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaskRunApi->search_task_run: %s\n" % e)
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
 **start_date** | **datetime**| The start datetime | [optional] 
 **end_date** | **datetime**| The end datetime | [optional] 
 **time_range** | **str**| A time range filter relative to the current time | [optional] 
 **state** | [**List[StateType]**](StateType.md)| A state filter | [optional] 
 **labels** | [**List[str]**](str.md)| A labels filter as a list of &#39;key:value&#39; | [optional] 
 **trigger_execution_id** | **str**| The trigger execution id | [optional] 
 **child_filter** | [**ExecutionRepositoryInterfaceChildFilter**](.md)| A execution child filter | [optional] 

### Return type

[**PagedResultsTaskRun**](PagedResultsTaskRun.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchTaskRun 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

