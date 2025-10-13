# kestrapy.TriggerApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_backfill**](TriggerApi.md#delete_backfill) | **POST** /api/v1/{tenant}/triggers/backfill/delete | Delete a backfill
[**delete_backfill_by_ids**](TriggerApi.md#delete_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-triggers | Delete backfill for given triggers
[**delete_backfill_by_query**](TriggerApi.md#delete_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-query | Delete backfill for given triggers
[**disabled_triggers_by_ids**](TriggerApi.md#disabled_triggers_by_ids) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-triggers | Disable/enable given triggers
[**disabled_triggers_by_query**](TriggerApi.md#disabled_triggers_by_query) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-query | Disable/enable triggers by query parameters
[**pause_backfill**](TriggerApi.md#pause_backfill) | **PUT** /api/v1/{tenant}/triggers/backfill/pause | Pause a backfill
[**pause_backfill_by_ids**](TriggerApi.md#pause_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-triggers | Pause backfill for given triggers
[**pause_backfill_by_query**](TriggerApi.md#pause_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-query | Pause backfill for given triggers
[**restart_trigger**](TriggerApi.md#restart_trigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/restart | Restart a trigger
[**search_triggers**](TriggerApi.md#search_triggers) | **GET** /api/v1/{tenant}/triggers/search | Search for triggers
[**search_triggers_for_flow**](TriggerApi.md#search_triggers_for_flow) | **GET** /api/v1/{tenant}/triggers/{namespace}/{flowId} | Get all triggers for a flow
[**unlock_trigger**](TriggerApi.md#unlock_trigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/unlock | Unlock a trigger
[**unlock_triggers_by_ids**](TriggerApi.md#unlock_triggers_by_ids) | **POST** /api/v1/{tenant}/triggers/unlock/by-triggers | Unlock given triggers
[**unlock_triggers_by_query**](TriggerApi.md#unlock_triggers_by_query) | **POST** /api/v1/{tenant}/triggers/unlock/by-query | Unlock triggers by query parameters
[**unpause_backfill**](TriggerApi.md#unpause_backfill) | **PUT** /api/v1/{tenant}/triggers/backfill/unpause | Unpause a backfill
[**unpause_backfill_by_ids**](TriggerApi.md#unpause_backfill_by_ids) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-triggers | Unpause backfill for given triggers
[**unpause_backfill_by_query**](TriggerApi.md#unpause_backfill_by_query) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-query | Unpause backfill for given triggers
[**update_trigger**](TriggerApi.md#update_trigger) | **PUT** /api/v1/{tenant}/triggers | Update a trigger


# **delete_backfill**
> Trigger delete_backfill(tenant, trigger)

Delete a backfill

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger = kestrapy.Trigger() # Trigger | 

    try:
        # Delete a backfill
        api_response = api_instance.delete_backfill(tenant, trigger)
        print("The response of TriggerApi->delete_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->delete_backfill: %s\n" % e)
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
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Delete backfill for given triggers
        api_response = api_instance.delete_backfill_by_ids(tenant, trigger)
        print("The response of TriggerApi->delete_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->delete_backfill_by_ids: %s\n" % e)
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
> object delete_backfill_by_query(tenant, delete_executions_by_query_request, q=q, namespace=namespace)

Delete backfill for given triggers

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.delete_executions_by_query_request import DeleteExecutionsByQueryRequest
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    delete_executions_by_query_request = kestrapy.DeleteExecutionsByQueryRequest() # DeleteExecutionsByQueryRequest | 
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)

    try:
        # Delete backfill for given triggers
        api_response = api_instance.delete_backfill_by_query(tenant, delete_executions_by_query_request, q=q, namespace=namespace)
        print("The response of TriggerApi->delete_backfill_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->delete_backfill_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **delete_executions_by_query_request** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 

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
**200** | deleteBackfillByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disabled_triggers_by_ids**
> object disabled_triggers_by_ids(tenant, trigger_controller_set_disabled_request)

Disable/enable given triggers

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.trigger_controller_set_disabled_request import TriggerControllerSetDisabledRequest
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger_controller_set_disabled_request = kestrapy.TriggerControllerSetDisabledRequest() # TriggerControllerSetDisabledRequest | 

    try:
        # Disable/enable given triggers
        api_response = api_instance.disabled_triggers_by_ids(tenant, trigger_controller_set_disabled_request)
        print("The response of TriggerApi->disabled_triggers_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->disabled_triggers_by_ids: %s\n" % e)
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
> object disabled_triggers_by_query(disabled, tenant, delete_executions_by_query_request, q=q, namespace=namespace)

Disable/enable triggers by query parameters

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.delete_executions_by_query_request import DeleteExecutionsByQueryRequest
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
    api_instance = kestrapy.TriggerApi(api_client)
    disabled = True # bool | The disabled state (default to True)
    tenant = 'tenant_example' # str | 
    delete_executions_by_query_request = kestrapy.DeleteExecutionsByQueryRequest() # DeleteExecutionsByQueryRequest | 
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)

    try:
        # Disable/enable triggers by query parameters
        api_response = api_instance.disabled_triggers_by_query(disabled, tenant, delete_executions_by_query_request, q=q, namespace=namespace)
        print("The response of TriggerApi->disabled_triggers_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->disabled_triggers_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **disabled** | **bool**| The disabled state | [default to True]
 **tenant** | **str**|  | 
 **delete_executions_by_query_request** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 

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
**200** | disabledTriggersByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_backfill**
> Trigger pause_backfill(tenant, trigger)

Pause a backfill

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger = kestrapy.Trigger() # Trigger | 

    try:
        # Pause a backfill
        api_response = api_instance.pause_backfill(tenant, trigger)
        print("The response of TriggerApi->pause_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->pause_backfill: %s\n" % e)
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
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Pause backfill for given triggers
        api_response = api_instance.pause_backfill_by_ids(tenant, trigger)
        print("The response of TriggerApi->pause_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->pause_backfill_by_ids: %s\n" % e)
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
> object pause_backfill_by_query(tenant, delete_executions_by_query_request, q=q, namespace=namespace)

Pause backfill for given triggers

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.delete_executions_by_query_request import DeleteExecutionsByQueryRequest
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    delete_executions_by_query_request = kestrapy.DeleteExecutionsByQueryRequest() # DeleteExecutionsByQueryRequest | 
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)

    try:
        # Pause backfill for given triggers
        api_response = api_instance.pause_backfill_by_query(tenant, delete_executions_by_query_request, q=q, namespace=namespace)
        print("The response of TriggerApi->pause_backfill_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->pause_backfill_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **delete_executions_by_query_request** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 

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
**200** | pauseBackfillByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **restart_trigger**
> object restart_trigger(namespace, flow_id, trigger_id, tenant)

Restart a trigger

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
    api_instance = kestrapy.TriggerApi(api_client)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow id
    trigger_id = 'trigger_id_example' # str | The trigger id
    tenant = 'tenant_example' # str | 

    try:
        # Restart a trigger
        api_response = api_instance.restart_trigger(namespace, flow_id, trigger_id, tenant)
        print("The response of TriggerApi->restart_trigger:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->restart_trigger: %s\n" % e)
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
> PagedResultsTriggerControllerTriggers search_triggers(page, size, tenant, sort=sort, filters=filters, q=q, namespace=namespace, worker_id=worker_id, flow_id=flow_id)

Search for triggers

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_trigger_controller_triggers import PagedResultsTriggerControllerTriggers
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
    api_instance = kestrapy.TriggerApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)
    worker_id = 'worker_id_example' # str | The identifier of the worker currently evaluating the trigger (optional)
    flow_id = 'flow_id_example' # str | The flow identifier (optional)

    try:
        # Search for triggers
        api_response = api_instance.search_triggers(page, size, tenant, sort=sort, filters=filters, q=q, namespace=namespace, worker_id=worker_id, flow_id=flow_id)
        print("The response of TriggerApi->search_triggers:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->search_triggers: %s\n" % e)
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
 **worker_id** | **str**| The identifier of the worker currently evaluating the trigger | [optional] 
 **flow_id** | **str**| The flow identifier | [optional] 

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
import kestrapy
from kestrapy.models.paged_results_trigger import PagedResultsTrigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow id
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    q = 'q_example' # str | A string filter (optional)

    try:
        # Get all triggers for a flow
        api_response = api_instance.search_triggers_for_flow(page, size, namespace, flow_id, tenant, sort=sort, q=q)
        print("The response of TriggerApi->search_triggers_for_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->search_triggers_for_flow: %s\n" % e)
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
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    namespace = 'namespace_example' # str | The namespace
    flow_id = 'flow_id_example' # str | The flow id
    trigger_id = 'trigger_id_example' # str | The trigger id
    tenant = 'tenant_example' # str | 

    try:
        # Unlock a trigger
        api_response = api_instance.unlock_trigger(namespace, flow_id, trigger_id, tenant)
        print("The response of TriggerApi->unlock_trigger:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->unlock_trigger: %s\n" % e)
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
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Unlock given triggers
        api_response = api_instance.unlock_triggers_by_ids(tenant, trigger)
        print("The response of TriggerApi->unlock_triggers_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->unlock_triggers_by_ids: %s\n" % e)
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
> object unlock_triggers_by_query(tenant, delete_executions_by_query_request, q=q, namespace=namespace)

Unlock triggers by query parameters

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.delete_executions_by_query_request import DeleteExecutionsByQueryRequest
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    delete_executions_by_query_request = kestrapy.DeleteExecutionsByQueryRequest() # DeleteExecutionsByQueryRequest | 
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)

    try:
        # Unlock triggers by query parameters
        api_response = api_instance.unlock_triggers_by_query(tenant, delete_executions_by_query_request, q=q, namespace=namespace)
        print("The response of TriggerApi->unlock_triggers_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->unlock_triggers_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **delete_executions_by_query_request** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 

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
**200** | unlockTriggersByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unpause_backfill**
> Trigger unpause_backfill(tenant, trigger)

Unpause a backfill

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger = kestrapy.Trigger() # Trigger | 

    try:
        # Unpause a backfill
        api_response = api_instance.unpause_backfill(tenant, trigger)
        print("The response of TriggerApi->unpause_backfill:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->unpause_backfill: %s\n" % e)
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
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger = [kestrapy.Trigger()] # List[Trigger] | 

    try:
        # Unpause backfill for given triggers
        api_response = api_instance.unpause_backfill_by_ids(tenant, trigger)
        print("The response of TriggerApi->unpause_backfill_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->unpause_backfill_by_ids: %s\n" % e)
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
> object unpause_backfill_by_query(tenant, delete_executions_by_query_request, q=q, namespace=namespace)

Unpause backfill for given triggers

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.delete_executions_by_query_request import DeleteExecutionsByQueryRequest
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    delete_executions_by_query_request = kestrapy.DeleteExecutionsByQueryRequest() # DeleteExecutionsByQueryRequest | 
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)

    try:
        # Unpause backfill for given triggers
        api_response = api_instance.unpause_backfill_by_query(tenant, delete_executions_by_query_request, q=q, namespace=namespace)
        print("The response of TriggerApi->unpause_backfill_by_query:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->unpause_backfill_by_query: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **delete_executions_by_query_request** | [**DeleteExecutionsByQueryRequest**](DeleteExecutionsByQueryRequest.md)|  | 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 

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
**200** | unpauseBackfillByQuery 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_trigger**
> Trigger update_trigger(tenant, trigger)

Update a trigger

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.trigger import Trigger
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
    api_instance = kestrapy.TriggerApi(api_client)
    tenant = 'tenant_example' # str | 
    trigger = kestrapy.Trigger() # Trigger | 

    try:
        # Update a trigger
        api_response = api_instance.update_trigger(tenant, trigger)
        print("The response of TriggerApi->update_trigger:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TriggerApi->update_trigger: %s\n" % e)
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

