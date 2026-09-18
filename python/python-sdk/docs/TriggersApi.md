# kestrapy.TriggersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_backfill**](TriggersApi.md#create_backfill) | **PUT** /api/v1/{tenant}/triggers/backfill/create | Create a backfill
[**delete_backfill**](TriggersApi.md#delete_backfill) | **POST** /api/v1/{tenant}/triggers/backfill/delete | Delete a backfill
[**delete_backfill_by_ids**](TriggersApi.md#delete_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-triggers | Delete backfill for given triggers asynchronously
[**delete_backfill_by_query**](TriggersApi.md#delete_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-query | Delete backfill for triggers matching query asynchronously
[**delete_trigger**](TriggersApi.md#delete_trigger) | **DELETE** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId} | Delete a trigger
[**delete_triggers_by_ids**](TriggersApi.md#delete_triggers_by_ids) | **DELETE** /api/v1/{tenant}/triggers/delete/by-triggers | Delete given triggers asynchronously
[**delete_triggers_by_query**](TriggersApi.md#delete_triggers_by_query) | **DELETE** /api/v1/{tenant}/triggers/delete/by-query | Delete triggers by query parameters asynchronously
[**disable_trigger_by_id**](TriggersApi.md#disable_trigger_by_id) | **PUT** /api/v1/{tenant}/triggers/set-disabled | Disable/enable a trigger
[**disabled_triggers_by_ids**](TriggersApi.md#disabled_triggers_by_ids) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-triggers | Disable/enable given triggers asynchronously
[**disabled_triggers_by_query**](TriggersApi.md#disabled_triggers_by_query) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-query | Disable/enable triggers by query parameters asynchronously
[**export_triggers**](TriggersApi.md#export_triggers) | **GET** /api/v1/{tenant}/triggers/export/by-query/csv | Export all triggers as a streamed CSV file
[**pause_backfill**](TriggersApi.md#pause_backfill) | **PUT** /api/v1/{tenant}/triggers/backfill/pause | Pause a backfill
[**pause_backfill_by_ids**](TriggersApi.md#pause_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-triggers | Pause backfill for given triggers asynchronously
[**pause_backfill_by_query**](TriggersApi.md#pause_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-query | Pause backfill for triggers matching query asynchronously
[**restart_trigger**](TriggersApi.md#restart_trigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/restart | Restart a trigger
[**search_triggers**](TriggersApi.md#search_triggers) | **GET** /api/v1/{tenant}/triggers/search | Search for triggers
[**search_triggers_for_flow**](TriggersApi.md#search_triggers_for_flow) | **GET** /api/v1/{tenant}/triggers/{namespace}/{flowId} | Get all triggers for a flow
[**unlock_trigger**](TriggersApi.md#unlock_trigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/unlock | Unlock a trigger
[**unlock_triggers_by_ids**](TriggersApi.md#unlock_triggers_by_ids) | **POST** /api/v1/{tenant}/triggers/unlock/by-triggers | Unlock given triggers asynchronously
[**unlock_triggers_by_query**](TriggersApi.md#unlock_triggers_by_query) | **POST** /api/v1/{tenant}/triggers/unlock/by-query | Unlock triggers by query parameters asynchronously
[**unpause_backfill**](TriggersApi.md#unpause_backfill) | **PUT** /api/v1/{tenant}/triggers/backfill/unpause | Unpause a backfill
[**unpause_backfill_by_ids**](TriggersApi.md#unpause_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-triggers | Unpause backfill for given triggers asynchronously
[**unpause_backfill_by_query**](TriggersApi.md#unpause_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-query | Unpause backfill for triggers matching query asynchronously


# **create_backfill**
> ApiTriggerState create_backfill(tenant, trigger_controller_api_create_backfill_request)

Create a backfill

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
    trigger_controller_api_create_backfill_request = kestrapy.TriggerControllerApiCreateBackfillRequest() # TriggerControllerApiCreateBackfillRequest | 

    try:
        # Create a backfill
        api_response = kestra_client.TriggersApi.create_backfill(tenant, trigger_controller_api_create_backfill_request)
        print("The response of TriggersApi->create_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->create_backfill: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_create_backfill_request** | [**TriggerControllerApiCreateBackfillRequest**](TriggerControllerApiCreateBackfillRequest.md)|  | 

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | If the backfill cannot be created |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_backfill**
> ApiTriggerState delete_backfill(tenant, trigger_controller_api_trigger_id)

Delete a backfill

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
    trigger_controller_api_trigger_id = kestrapy.TriggerControllerApiTriggerId() # TriggerControllerApiTriggerId | 

    try:
        # Delete a backfill
        api_response = kestra_client.TriggersApi.delete_backfill(tenant, trigger_controller_api_trigger_id)
        print("The response of TriggersApi->delete_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_backfill: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_trigger_id** | [**TriggerControllerApiTriggerId**](TriggerControllerApiTriggerId.md)|  | 

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | If the backfill cannot be deleted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_backfill_by_ids**
> ApiAsyncOperationResponse delete_backfill_by_ids(tenant, trigger_controller_api_trigger_id)

Delete backfill for given triggers asynchronously

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
    trigger_controller_api_trigger_id = [kestrapy.TriggerControllerApiTriggerId()] # List[TriggerControllerApiTriggerId] | 

    try:
        # Delete backfill for given triggers asynchronously
        api_response = kestra_client.TriggersApi.delete_backfill_by_ids(tenant, trigger_controller_api_trigger_id)
        print("The response of TriggersApi->delete_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_backfill_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_trigger_id** | [**List[TriggerControllerApiTriggerId]**](TriggerControllerApiTriggerId.md)|  | 

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
**200** | deleteBackfillByIds 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_backfill_by_query**
> ApiAsyncOperationResponse delete_backfill_by_query(tenant, filters=filters)

Delete backfill for triggers matching query asynchronously

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Delete backfill for triggers matching query asynchronously
        api_response = kestra_client.TriggersApi.delete_backfill_by_query(tenant, filters=filters)
        print("The response of TriggersApi->delete_backfill_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_backfill_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

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
**200** | deleteBackfillByQuery 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_trigger**
> delete_trigger(namespace, flow_id, trigger_id, tenant)

Delete a trigger

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
    flow_id = 'flow_id_example' # str | The flow id
    trigger_id = 'trigger_id_example' # str | The trigger id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a trigger
        kestra_client.TriggersApi.delete_trigger(namespace, flow_id, trigger_id, tenant)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_trigger: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow id | 
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
**200** | deleteTrigger 200 response |  -  |
**204** | On success |  -  |
**409** | If the trigger cannot be deleted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_triggers_by_ids**
> ApiAsyncOperationResponse delete_triggers_by_ids(tenant, trigger_controller_api_trigger_id)

Delete given triggers asynchronously

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
    trigger_controller_api_trigger_id = [kestrapy.TriggerControllerApiTriggerId()] # List[TriggerControllerApiTriggerId] | 

    try:
        # Delete given triggers asynchronously
        api_response = kestra_client.TriggersApi.delete_triggers_by_ids(tenant, trigger_controller_api_trigger_id)
        print("The response of TriggersApi->delete_triggers_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_triggers_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_trigger_id** | [**List[TriggerControllerApiTriggerId]**](TriggerControllerApiTriggerId.md)|  | 

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
**200** | deleteTriggersByIds 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_triggers_by_query**
> ApiAsyncOperationResponse delete_triggers_by_query(tenant, delete_triggers_by_query_request)

Delete triggers by query parameters asynchronously

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
    delete_triggers_by_query_request = kestrapy.DeleteTriggersByQueryRequest() # DeleteTriggersByQueryRequest | 

    try:
        # Delete triggers by query parameters asynchronously
        api_response = kestra_client.TriggersApi.delete_triggers_by_query(tenant, delete_triggers_by_query_request)
        print("The response of TriggersApi->delete_triggers_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_triggers_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **delete_triggers_by_query_request** | [**DeleteTriggersByQueryRequest**](DeleteTriggersByQueryRequest.md)|  | 

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
**200** | deleteTriggersByQuery 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disable_trigger_by_id**
> ApiTriggerState disable_trigger_by_id(tenant, trigger_controller_api_disable_trigger_request)

Disable/enable a trigger

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
    trigger_controller_api_disable_trigger_request = kestrapy.TriggerControllerApiDisableTriggerRequest() # TriggerControllerApiDisableTriggerRequest | 

    try:
        # Disable/enable a trigger
        api_response = kestra_client.TriggersApi.disable_trigger_by_id(tenant, trigger_controller_api_disable_trigger_request)
        print("The response of TriggersApi->disable_trigger_by_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->disable_trigger_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_disable_trigger_request** | [**TriggerControllerApiDisableTriggerRequest**](TriggerControllerApiDisableTriggerRequest.md)|  | 

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | If the trigger state cannot be changed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disabled_triggers_by_ids**
> ApiAsyncOperationResponse disabled_triggers_by_ids(tenant, trigger_controller_set_disabled_request)

Disable/enable given triggers asynchronously

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
    trigger_controller_set_disabled_request = kestrapy.TriggerControllerSetDisabledRequest() # TriggerControllerSetDisabledRequest | 

    try:
        # Disable/enable given triggers asynchronously
        api_response = kestra_client.TriggersApi.disabled_triggers_by_ids(tenant, trigger_controller_set_disabled_request)
        print("The response of TriggersApi->disabled_triggers_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->disabled_triggers_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_set_disabled_request** | [**TriggerControllerSetDisabledRequest**](TriggerControllerSetDisabledRequest.md)|  | 

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
**200** | disabledTriggersByIds 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disabled_triggers_by_query**
> ApiAsyncOperationResponse disabled_triggers_by_query(tenant, filters=filters, disabled=disabled, recover_missed_schedules=recover_missed_schedules)

Disable/enable triggers by query parameters asynchronously

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test` (optional)
    disabled = True # bool | The disabled state (optional) (default to True)
    recover_missed_schedules = True # bool | When true, missed schedules are recovered on enable according to the trigger's recoverMissedSchedules configuration; omitted or false, missed schedules are skipped (optional)

    try:
        # Disable/enable triggers by query parameters asynchronously
        api_response = kestra_client.TriggersApi.disabled_triggers_by_query(tenant, filters=filters, disabled=disabled, recover_missed_schedules=recover_missed_schedules)
        print("The response of TriggersApi->disabled_triggers_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->disabled_triggers_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 
 **disabled** | **bool**| The disabled state | [optional] [default to True]
 **recover_missed_schedules** | **bool**| When true, missed schedules are recovered on enable according to the trigger&#39;s recoverMissedSchedules configuration; omitted or false, missed schedules are skipped | [optional] 

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
**200** | disabledTriggersByQuery 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export_triggers**
> str export_triggers(tenant, filters=filters)

Export all triggers as a streamed CSV file

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
        # Export all triggers as a streamed CSV file
        api_response = kestra_client.TriggersApi.export_triggers(tenant, filters=filters)
        print("The response of TriggersApi->export_triggers:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->export_triggers: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| A list of filters | [optional] 

### Return type

**str**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/csv

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Ok |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_backfill**
> ApiTriggerState pause_backfill(tenant, trigger_controller_api_trigger_id)

Pause a backfill

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
    trigger_controller_api_trigger_id = kestrapy.TriggerControllerApiTriggerId() # TriggerControllerApiTriggerId | 

    try:
        # Pause a backfill
        api_response = kestra_client.TriggersApi.pause_backfill(tenant, trigger_controller_api_trigger_id)
        print("The response of TriggersApi->pause_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->pause_backfill: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_trigger_id** | [**TriggerControllerApiTriggerId**](TriggerControllerApiTriggerId.md)|  | 

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | If the backfill cannot be paused |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_backfill_by_ids**
> ApiAsyncOperationResponse pause_backfill_by_ids(tenant, trigger_controller_api_trigger_id)

Pause backfill for given triggers asynchronously

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
    trigger_controller_api_trigger_id = [kestrapy.TriggerControllerApiTriggerId()] # List[TriggerControllerApiTriggerId] | 

    try:
        # Pause backfill for given triggers asynchronously
        api_response = kestra_client.TriggersApi.pause_backfill_by_ids(tenant, trigger_controller_api_trigger_id)
        print("The response of TriggersApi->pause_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->pause_backfill_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_trigger_id** | [**List[TriggerControllerApiTriggerId]**](TriggerControllerApiTriggerId.md)|  | 

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
**200** | pauseBackfillByIds 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_backfill_by_query**
> ApiAsyncOperationResponse pause_backfill_by_query(tenant, filters=filters)

Pause backfill for triggers matching query asynchronously

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Pause backfill for triggers matching query asynchronously
        api_response = kestra_client.TriggersApi.pause_backfill_by_query(tenant, filters=filters)
        print("The response of TriggersApi->pause_backfill_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->pause_backfill_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

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
**200** | pauseBackfillByQuery 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **restart_trigger**
> ApiTriggerState restart_trigger(namespace, flow_id, trigger_id, tenant)

Restart a trigger

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
    flow_id = 'flow_id_example' # str | The flow id
    trigger_id = 'trigger_id_example' # str | The trigger id
    tenant = 'tenant_example' # str | 

    try:
        # Restart a trigger
        api_response = kestra_client.TriggersApi.restart_trigger(namespace, flow_id, trigger_id, tenant)
        print("The response of TriggersApi->restart_trigger:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->restart_trigger: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow id | 
 **trigger_id** | **str**| The trigger id | 
 **tenant** | **str**|  | 

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | If the trigger cannot be restarted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_triggers**
> PagedResultsApiTriggerAndState search_triggers(tenant, page=page, size=size, sort=sort, filters=filters, date_filter=date_filter)

Search for triggers

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
    sort = ['nextEvaluationDate:asc'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test` (optional)
    date_filter = 'date_filter_example' # str | Which trigger date field the time interval is applied to (optional)

    try:
        # Search for triggers
        api_response = kestra_client.TriggersApi.search_triggers(tenant, page=page, size=size, sort=sort, filters=filters, date_filter=date_filter)
        print("The response of TriggersApi->search_triggers:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->search_triggers: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **page** | **int**| The current page | [optional] [default to 1]
 **size** | **int**| The current page size | [optional] [default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 
 **date_filter** | **str**| Which trigger date field the time interval is applied to | [optional] 

### Return type

[**PagedResultsApiTriggerAndState**](PagedResultsApiTriggerAndState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchTriggers 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_triggers_for_flow**
> PagedResultsApiTriggerState search_triggers_for_flow(namespace, flow_id, tenant, page=page, size=size, sort=sort, q=q)

Get all triggers for a flow

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
    flow_id = 'flow_id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    page = 1 # int | The current page (optional) (default to 1)
    size = 10 # int | The current page size (optional) (default to 10)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    q = 'q_example' # str | A string filter (optional)

    try:
        # Get all triggers for a flow
        api_response = kestra_client.TriggersApi.search_triggers_for_flow(namespace, flow_id, tenant, page=page, size=size, sort=sort, q=q)
        print("The response of TriggersApi->search_triggers_for_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->search_triggers_for_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **page** | **int**| The current page | [optional] [default to 1]
 **size** | **int**| The current page size | [optional] [default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **q** | **str**| A string filter | [optional] 

### Return type

[**PagedResultsApiTriggerState**](PagedResultsApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchTriggersForFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unlock_trigger**
> ApiTriggerState unlock_trigger(namespace, flow_id, trigger_id, tenant)

Unlock a trigger

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
    flow_id = 'flow_id_example' # str | The flow id
    trigger_id = 'trigger_id_example' # str | The trigger id
    tenant = 'tenant_example' # str | 

    try:
        # Unlock a trigger
        api_response = kestra_client.TriggersApi.unlock_trigger(namespace, flow_id, trigger_id, tenant)
        print("The response of TriggersApi->unlock_trigger:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unlock_trigger: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow id | 
 **trigger_id** | **str**| The trigger id | 
 **tenant** | **str**|  | 

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | If the trigger is already unlocked or is a realtime trigger |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unlock_triggers_by_ids**
> ApiAsyncOperationResponse unlock_triggers_by_ids(tenant, trigger_controller_api_trigger_id)

Unlock given triggers asynchronously

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
    trigger_controller_api_trigger_id = [kestrapy.TriggerControllerApiTriggerId()] # List[TriggerControllerApiTriggerId] | 

    try:
        # Unlock given triggers asynchronously
        api_response = kestra_client.TriggersApi.unlock_triggers_by_ids(tenant, trigger_controller_api_trigger_id)
        print("The response of TriggersApi->unlock_triggers_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unlock_triggers_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_trigger_id** | [**List[TriggerControllerApiTriggerId]**](TriggerControllerApiTriggerId.md)|  | 

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
**200** | unlockTriggersByIds 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unlock_triggers_by_query**
> ApiAsyncOperationResponse unlock_triggers_by_query(tenant, filters=filters)

Unlock triggers by query parameters asynchronously

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Unlock triggers by query parameters asynchronously
        api_response = kestra_client.TriggersApi.unlock_triggers_by_query(tenant, filters=filters)
        print("The response of TriggersApi->unlock_triggers_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unlock_triggers_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

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
**200** | unlockTriggersByQuery 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unpause_backfill**
> ApiTriggerState unpause_backfill(tenant, trigger_controller_api_trigger_id)

Unpause a backfill

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
    trigger_controller_api_trigger_id = kestrapy.TriggerControllerApiTriggerId() # TriggerControllerApiTriggerId | 

    try:
        # Unpause a backfill
        api_response = kestra_client.TriggersApi.unpause_backfill(tenant, trigger_controller_api_trigger_id)
        print("The response of TriggersApi->unpause_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unpause_backfill: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_trigger_id** | [**TriggerControllerApiTriggerId**](TriggerControllerApiTriggerId.md)|  | 

### Return type

[**ApiTriggerState**](ApiTriggerState.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | On success |  -  |
**409** | If the backfill cannot be resumed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unpause_backfill_by_ids**
> ApiAsyncOperationResponse unpause_backfill_by_ids(tenant, trigger_controller_api_trigger_id)

Unpause backfill for given triggers asynchronously

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
    trigger_controller_api_trigger_id = [kestrapy.TriggerControllerApiTriggerId()] # List[TriggerControllerApiTriggerId] | 

    try:
        # Unpause backfill for given triggers asynchronously
        api_response = kestra_client.TriggersApi.unpause_backfill_by_ids(tenant, trigger_controller_api_trigger_id)
        print("The response of TriggersApi->unpause_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unpause_backfill_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger_controller_api_trigger_id** | [**List[TriggerControllerApiTriggerId]**](TriggerControllerApiTriggerId.md)|  | 

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
**200** | unpauseBackfillByIds 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unpause_backfill_by_query**
> ApiAsyncOperationResponse unpause_backfill_by_query(tenant, filters=filters)

Unpause backfill for triggers matching query asynchronously

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters. PHP-style nested query is used - examples: `filters[flowId][EQUALS]=hello-world`, `filters[namespace][CONTAINS]=test` (optional)

    try:
        # Unpause backfill for triggers matching query asynchronously
        api_response = kestra_client.TriggersApi.unpause_backfill_by_query(tenant, filters=filters)
        print("The response of TriggersApi->unpause_backfill_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unpause_backfill_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

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
**200** | unpauseBackfillByQuery 200 response |  -  |
**202** | Accepted |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

