# kestrapy.TriggersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_backfill**](TriggersApi.md#delete_backfill) | **POST** /api/v1/{tenant}/triggers/backfill/delete | Delete a backfill
[**delete_backfill_by_ids**](TriggersApi.md#delete_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-triggers | Delete backfill for given triggers
[**delete_backfill_by_query**](TriggersApi.md#delete_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-query | Delete backfill for given triggers
[**delete_trigger**](TriggersApi.md#delete_trigger) | **DELETE** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId} | Delete a trigger
[**delete_triggers_by_ids**](TriggersApi.md#delete_triggers_by_ids) | **DELETE** /api/v1/{tenant}/triggers/delete/by-triggers | Delete given triggers
[**delete_triggers_by_query**](TriggersApi.md#delete_triggers_by_query) | **DELETE** /api/v1/{tenant}/triggers/delete/by-query | Delete triggers by query parameters
[**disabled_triggers_by_ids**](TriggersApi.md#disabled_triggers_by_ids) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-triggers | Disable/enable given triggers
[**disabled_triggers_by_query**](TriggersApi.md#disabled_triggers_by_query) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-query | Disable/enable triggers by query parameters
[**export_triggers**](TriggersApi.md#export_triggers) | **GET** /api/v1/{tenant}/triggers/export/by-query/csv | Export all triggers as a streamed CSV file
[**pause_backfill**](TriggersApi.md#pause_backfill) | **PUT** /api/v1/{tenant}/triggers/backfill/pause | Pause a backfill
[**pause_backfill_by_ids**](TriggersApi.md#pause_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-triggers | Pause backfill for given triggers
[**pause_backfill_by_query**](TriggersApi.md#pause_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-query | Pause backfill for given triggers
[**restart_trigger**](TriggersApi.md#restart_trigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/restart | Restart a trigger
[**search_triggers**](TriggersApi.md#search_triggers) | **GET** /api/v1/{tenant}/triggers/search | Search for triggers
[**search_triggers_for_flow**](TriggersApi.md#search_triggers_for_flow) | **GET** /api/v1/{tenant}/triggers/{namespace}/{flowId} | Get all triggers for a flow
[**unlock_trigger**](TriggersApi.md#unlock_trigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/unlock | Unlock a trigger
[**unlock_triggers_by_ids**](TriggersApi.md#unlock_triggers_by_ids) | **POST** /api/v1/{tenant}/triggers/unlock/by-triggers | Unlock given triggers
[**unlock_triggers_by_query**](TriggersApi.md#unlock_triggers_by_query) | **POST** /api/v1/{tenant}/triggers/unlock/by-query | Unlock triggers by query parameters
[**unpause_backfill**](TriggersApi.md#unpause_backfill) | **PUT** /api/v1/{tenant}/triggers/backfill/unpause | Unpause a backfill
[**unpause_backfill_by_ids**](TriggersApi.md#unpause_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-triggers | Unpause backfill for given triggers
[**unpause_backfill_by_query**](TriggersApi.md#unpause_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-query | Unpause backfill for given triggers
[**update_trigger**](TriggersApi.md#update_trigger) | **PUT** /api/v1/{tenant}/triggers | Update a trigger


# **delete_backfill**
> Trigger delete_backfill(tenant, trigger)

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
    trigger = kestrapy.Trigger() # Trigger | 

    try:
        # Delete a backfill
        api_response = kestra_client.TriggersApi.delete_backfill(tenant, trigger)
        print("The response of TriggersApi->delete_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_backfill: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**Trigger**](Trigger.md)|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteBackfill 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_backfill_by_ids**
> object delete_backfill_by_ids(tenant, trigger)

Delete backfill for given triggers

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
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Delete backfill for given triggers
        api_response = kestra_client.TriggersApi.delete_backfill_by_ids(tenant, trigger)
        print("The response of TriggersApi->delete_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_backfill_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**List[Trigger]**](Trigger.md)|  | 

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
**200** | deleteBackfillByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_backfill_by_query**
> object delete_backfill_by_query(tenant, filters=filters)

Delete backfill for given triggers

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
        # Delete backfill for given triggers
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
**200** | deleteBackfillByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_trigger**
> object delete_trigger(namespace, flow_id, trigger_id, tenant)

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
        api_response = kestra_client.TriggersApi.delete_trigger(namespace, flow_id, trigger_id, tenant)
        print("The response of TriggersApi->delete_trigger:\n")
        pprint(api_response)
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

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteTrigger 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_triggers_by_ids**
> object delete_triggers_by_ids(tenant, trigger)

Delete given triggers

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
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Delete given triggers
        api_response = kestra_client.TriggersApi.delete_triggers_by_ids(tenant, trigger)
        print("The response of TriggersApi->delete_triggers_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->delete_triggers_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**List[Trigger]**](Trigger.md)|  | 

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
**200** | deleteTriggersByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_triggers_by_query**
> object delete_triggers_by_query(tenant, delete_triggers_by_query_request)

Delete triggers by query parameters

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
        # Delete triggers by query parameters
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

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteTriggersByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disabled_triggers_by_ids**
> object disabled_triggers_by_ids(tenant, trigger_controller_set_disabled_request)

Disable/enable given triggers

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
        # Disable/enable given triggers
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

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | disabledTriggersByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disabled_triggers_by_query**
> object disabled_triggers_by_query(disabled, tenant, filters=filters)

Disable/enable triggers by query parameters

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
    disabled = True # bool | The disabled state (default to True)
    tenant = 'tenant_example' # str | 
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Disable/enable triggers by query parameters
        api_response = kestra_client.TriggersApi.disabled_triggers_by_query(disabled, tenant, filters=filters)
        print("The response of TriggersApi->disabled_triggers_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->disabled_triggers_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **disabled** | **bool**| The disabled state | [default to True]
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
**200** | disabledTriggersByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export_triggers**
> List[object] export_triggers(filters, tenant)

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
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | A list of filters
    tenant = 'tenant_example' # str | 

    try:
        # Export all triggers as a streamed CSV file
        api_response = kestra_client.TriggersApi.export_triggers(filters, tenant)
        print("The response of TriggersApi->export_triggers:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->export_triggers: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| A list of filters | 
 **tenant** | **str**|  | 

### Return type

**List[object]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/csv

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | exportTriggers 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_backfill**
> Trigger pause_backfill(tenant, trigger)

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
    trigger = kestrapy.Trigger() # Trigger | 

    try:
        # Pause a backfill
        api_response = kestra_client.TriggersApi.pause_backfill(tenant, trigger)
        print("The response of TriggersApi->pause_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->pause_backfill: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**Trigger**](Trigger.md)|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | pauseBackfill 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_backfill_by_ids**
> object pause_backfill_by_ids(tenant, trigger)

Pause backfill for given triggers

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
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Pause backfill for given triggers
        api_response = kestra_client.TriggersApi.pause_backfill_by_ids(tenant, trigger)
        print("The response of TriggersApi->pause_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->pause_backfill_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**List[Trigger]**](Trigger.md)|  | 

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
**200** | pauseBackfillByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_backfill_by_query**
> object pause_backfill_by_query(tenant, filters=filters)

Pause backfill for given triggers

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
        # Pause backfill for given triggers
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
**200** | pauseBackfillByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **restart_trigger**
> object restart_trigger(namespace, flow_id, trigger_id, tenant)

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

**object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | restartTrigger 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_triggers**
> PagedResultsTriggerControllerTriggers search_triggers(page, size, tenant, sort=sort, filters=filters)

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
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # Search for triggers
        api_response = kestra_client.TriggersApi.search_triggers(page, size, tenant, sort=sort, filters=filters)
        print("The response of TriggersApi->search_triggers:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->search_triggers: %s\n" % e)
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

[**PagedResultsTriggerControllerTriggers**](PagedResultsTriggerControllerTriggers.md)

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
> PagedResultsTrigger search_triggers_for_flow(page, size, namespace, flow_id, tenant, sort=sort, q=q)

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
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    q = 'q_example' # str | A string filter (optional)

    try:
        # Get all triggers for a flow
        api_response = kestra_client.TriggersApi.search_triggers_for_flow(page, size, namespace, flow_id, tenant, sort=sort, q=q)
        print("The response of TriggersApi->search_triggers_for_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->search_triggers_for_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **namespace** | **str**| The namespace | 
 **flow_id** | **str**| The flow id | 
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **q** | **str**| A string filter | [optional] 

### Return type

[**PagedResultsTrigger**](PagedResultsTrigger.md)

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
> Trigger unlock_trigger(namespace, flow_id, trigger_id, tenant)

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

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | unlockTrigger 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unlock_triggers_by_ids**
> object unlock_triggers_by_ids(tenant, trigger)

Unlock given triggers

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
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Unlock given triggers
        api_response = kestra_client.TriggersApi.unlock_triggers_by_ids(tenant, trigger)
        print("The response of TriggersApi->unlock_triggers_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unlock_triggers_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**List[Trigger]**](Trigger.md)|  | 

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
**200** | unlockTriggersByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unlock_triggers_by_query**
> object unlock_triggers_by_query(tenant, filters=filters)

Unlock triggers by query parameters

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
        # Unlock triggers by query parameters
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
**200** | unlockTriggersByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unpause_backfill**
> Trigger unpause_backfill(tenant, trigger)

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
    trigger = kestrapy.Trigger() # Trigger | 

    try:
        # Unpause a backfill
        api_response = kestra_client.TriggersApi.unpause_backfill(tenant, trigger)
        print("The response of TriggersApi->unpause_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unpause_backfill: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**Trigger**](Trigger.md)|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | unpauseBackfill 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unpause_backfill_by_ids**
> object unpause_backfill_by_ids(tenant, trigger)

Unpause backfill for given triggers

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
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Unpause backfill for given triggers
        api_response = kestra_client.TriggersApi.unpause_backfill_by_ids(tenant, trigger)
        print("The response of TriggersApi->unpause_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->unpause_backfill_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**List[Trigger]**](Trigger.md)|  | 

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
**200** | unpauseBackfillByIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unpause_backfill_by_query**
> object unpause_backfill_by_query(tenant, filters=filters)

Unpause backfill for given triggers

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
        # Unpause backfill for given triggers
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
**200** | unpauseBackfillByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_trigger**
> Trigger update_trigger(tenant, trigger)

Update a trigger

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
    trigger = kestrapy.Trigger() # Trigger | 

    try:
        # Update a trigger
        api_response = kestra_client.TriggersApi.update_trigger(tenant, trigger)
        print("The response of TriggersApi->update_trigger:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggersApi->update_trigger: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **trigger** | [**Trigger**](Trigger.md)|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateTrigger 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

