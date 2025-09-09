# kestrapy.AppsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulk_delete_apps**](AppsApi.md#bulk_delete_apps) | **DELETE** /api/v1/{tenant}/apps | Delete existing apps
[**bulk_disable_apps**](AppsApi.md#bulk_disable_apps) | **POST** /api/v1/{tenant}/apps/disable | Disable existing apps
[**bulk_enable_apps**](AppsApi.md#bulk_enable_apps) | **POST** /api/v1/{tenant}/apps/enable | Enable existing apps
[**bulk_export_apps**](AppsApi.md#bulk_export_apps) | **POST** /api/v1/{tenant}/apps/export | Export apps as a ZIP archive of YAML sources.
[**create_app**](AppsApi.md#create_app) | **POST** /api/v1/{tenant}/apps | Create a new app
[**delete_app**](AppsApi.md#delete_app) | **DELETE** /api/v1/{tenant}/apps/{uid} | Delete an existing app
[**disable_app**](AppsApi.md#disable_app) | **POST** /api/v1/{tenant}/apps/{uid}/disable | Disable the app.
[**dispatch_app**](AppsApi.md#dispatch_app) | **POST** /api/v1/{tenant}/apps/view/{id}/dispatch/{dispatch} | Dispatch for a given app.
[**download_file_from_app_execution**](AppsApi.md#download_file_from_app_execution) | **GET** /api/v1/{tenant}/apps/view/{id}/file/download | Download file from an app execution
[**enable_app**](AppsApi.md#enable_app) | **POST** /api/v1/{tenant}/apps/{uid}/enable | Enable the app.
[**get_app**](AppsApi.md#get_app) | **GET** /api/v1/{tenant}/apps/{uid} | Retrieve an app
[**get_file_meta_from_app_execution**](AppsApi.md#get_file_meta_from_app_execution) | **GET** /api/v1/{tenant}/apps/view/{id}/file/meta | Get file meta information from an app execution
[**get_file_preview_from_app_execution**](AppsApi.md#get_file_preview_from_app_execution) | **GET** /api/v1/{tenant}/apps/view/{id}/file/preview | Get file preview from an app execution
[**get_logs_from_app_execution**](AppsApi.md#get_logs_from_app_execution) | **GET** /api/v1/{tenant}/apps/view/{uid}/logs/download | Download logs for an app execution
[**get_stream_events_from_app**](AppsApi.md#get_stream_events_from_app) | **GET** /api/v1/{tenant}/apps/view/{id}/streams/{stream} | Get an event stream from a given app.
[**list_tags**](AppsApi.md#list_tags) | **GET** /api/v1/{tenant}/apps/tags | Get all the app tags
[**open_app**](AppsApi.md#open_app) | **GET** /api/v1/{tenant}/apps/view/{uid} | Open an app
[**preview_app**](AppsApi.md#preview_app) | **POST** /api/v1/{tenant}/apps/preview | Open the app for the given source
[**search_apps**](AppsApi.md#search_apps) | **GET** /api/v1/{tenant}/apps/search | Search for apps
[**search_apps_from_catalog**](AppsApi.md#search_apps_from_catalog) | **GET** /api/v1/{tenant}/apps/catalog | Search for apps from catalog
[**update_app**](AppsApi.md#update_app) | **PUT** /api/v1/{tenant}/apps/{uid} | Update an existing app


# **bulk_delete_apps**
> object bulk_delete_apps(tenant, apps_controller_api_bulk_operation_request)

Delete existing apps

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_bulk_operation_request import AppsControllerApiBulkOperationRequest
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
    api_instance = kestrapy.AppsApi(api_client)
    tenant = 'tenant_example' # str | 
    apps_controller_api_bulk_operation_request = kestrapy.AppsControllerApiBulkOperationRequest() # AppsControllerApiBulkOperationRequest | The list of Apps UID

    try:
        # Delete existing apps
        api_response = api_instance.bulk_delete_apps(tenant, apps_controller_api_bulk_operation_request)
        print("The response of AppsApi->bulk_delete_apps:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->bulk_delete_apps: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **apps_controller_api_bulk_operation_request** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | 

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
**200** | bulkDeleteApps 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **bulk_disable_apps**
> object bulk_disable_apps(tenant, apps_controller_api_bulk_operation_request)

Disable existing apps

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_bulk_operation_request import AppsControllerApiBulkOperationRequest
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
    api_instance = kestrapy.AppsApi(api_client)
    tenant = 'tenant_example' # str | 
    apps_controller_api_bulk_operation_request = kestrapy.AppsControllerApiBulkOperationRequest() # AppsControllerApiBulkOperationRequest | The list of Apps UID

    try:
        # Disable existing apps
        api_response = api_instance.bulk_disable_apps(tenant, apps_controller_api_bulk_operation_request)
        print("The response of AppsApi->bulk_disable_apps:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->bulk_disable_apps: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **apps_controller_api_bulk_operation_request** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | 

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
**200** | bulkDisableApps 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **bulk_enable_apps**
> object bulk_enable_apps(tenant, apps_controller_api_bulk_operation_request)

Enable existing apps

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_bulk_operation_request import AppsControllerApiBulkOperationRequest
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
    api_instance = kestrapy.AppsApi(api_client)
    tenant = 'tenant_example' # str | 
    apps_controller_api_bulk_operation_request = kestrapy.AppsControllerApiBulkOperationRequest() # AppsControllerApiBulkOperationRequest | The list of Apps UID

    try:
        # Enable existing apps
        api_response = api_instance.bulk_enable_apps(tenant, apps_controller_api_bulk_operation_request)
        print("The response of AppsApi->bulk_enable_apps:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->bulk_enable_apps: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **apps_controller_api_bulk_operation_request** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | 

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
**200** | bulkEnableApps 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **bulk_export_apps**
> bytearray bulk_export_apps(tenant, apps_controller_api_bulk_operation_request)

Export apps as a ZIP archive of YAML sources.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_bulk_operation_request import AppsControllerApiBulkOperationRequest
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
    api_instance = kestrapy.AppsApi(api_client)
    tenant = 'tenant_example' # str | 
    apps_controller_api_bulk_operation_request = kestrapy.AppsControllerApiBulkOperationRequest() # AppsControllerApiBulkOperationRequest | The list of Apps UID

    try:
        # Export apps as a ZIP archive of YAML sources.
        api_response = api_instance.bulk_export_apps(tenant, apps_controller_api_bulk_operation_request)
        print("The response of AppsApi->bulk_export_apps:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->bulk_export_apps: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **apps_controller_api_bulk_operation_request** | [**AppsControllerApiBulkOperationRequest**](AppsControllerApiBulkOperationRequest.md)| The list of Apps UID | 

### Return type

**bytearray**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | bulkExportApps 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_app**
> AppsControllerApiAppSource create_app(tenant, body)

Create a new app

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_app_source import AppsControllerApiAppSource
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
    api_instance = kestrapy.AppsApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The app

    try:
        # Create a new app
        api_response = api_instance.create_app(tenant, body)
        print("The response of AppsApi->create_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->create_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The app | 

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/x-yaml
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_app**
> object delete_app(uid, tenant)

Delete an existing app

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
    api_instance = kestrapy.AppsApi(api_client)
    uid = 'uid_example' # str | The ID of the app
    tenant = 'tenant_example' # str | 

    try:
        # Delete an existing app
        api_response = api_instance.delete_app(uid, tenant)
        print("The response of AppsApi->delete_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->delete_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uid** | **str**| The ID of the app | 
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
**200** | deleteApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disable_app**
> AppsControllerApiApp disable_app(uid, tenant)

Disable the app.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_app import AppsControllerApiApp
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
    api_instance = kestrapy.AppsApi(api_client)
    uid = 'uid_example' # str | The ID of app
    tenant = 'tenant_example' # str | 

    try:
        # Disable the app.
        api_response = api_instance.disable_app(uid, tenant)
        print("The response of AppsApi->disable_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->disable_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uid** | **str**| The ID of app | 
 **tenant** | **str**|  | 

### Return type

[**AppsControllerApiApp**](AppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | disableApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **dispatch_app**
> AppResponse dispatch_app(id, dispatch, tenant, parameters=parameters)

Dispatch for a given app.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.app_response import AppResponse
from kestrapy.models.http_parameters import HttpParameters
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
    api_instance = kestrapy.AppsApi(api_client)
    id = 'id_example' # str | The ID of the app.
    dispatch = 'dispatch_example' # str | The ID to dispatch
    tenant = 'tenant_example' # str | 
    parameters = kestrapy.HttpParameters() # HttpParameters |  (optional)

    try:
        # Dispatch for a given app.
        api_response = api_instance.dispatch_app(id, dispatch, tenant, parameters=parameters)
        print("The response of AppsApi->dispatch_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->dispatch_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of the app. | 
 **dispatch** | **str**| The ID to dispatch | 
 **tenant** | **str**|  | 
 **parameters** | [**HttpParameters**](HttpParameters.md)|  | [optional] 

### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | dispatchApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **download_file_from_app_execution**
> bytearray download_file_from_app_execution(id, path, tenant)

Download file from an app execution

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
    api_instance = kestrapy.AppsApi(api_client)
    id = 'id_example' # str | The ID of the app.
    path = 'path_example' # str | The internal storage uri
    tenant = 'tenant_example' # str | 

    try:
        # Download file from an app execution
        api_response = api_instance.download_file_from_app_execution(id, path, tenant)
        print("The response of AppsApi->download_file_from_app_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->download_file_from_app_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of the app. | 
 **path** | **str**| The internal storage uri | 
 **tenant** | **str**|  | 

### Return type

**bytearray**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | downloadFileFromAppExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **enable_app**
> AppsControllerApiApp enable_app(uid, tenant)

Enable the app.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_app import AppsControllerApiApp
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
    api_instance = kestrapy.AppsApi(api_client)
    uid = 'uid_example' # str | The ID of app
    tenant = 'tenant_example' # str | 

    try:
        # Enable the app.
        api_response = api_instance.enable_app(uid, tenant)
        print("The response of AppsApi->enable_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->enable_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uid** | **str**| The ID of app | 
 **tenant** | **str**|  | 

### Return type

[**AppsControllerApiApp**](AppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | enableApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_app**
> AppsControllerApiAppSource get_app(uid, tenant)

Retrieve an app

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_app_source import AppsControllerApiAppSource
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
    api_instance = kestrapy.AppsApi(api_client)
    uid = 'uid_example' # str | The ID of the app
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve an app
        api_response = api_instance.get_app(uid, tenant)
        print("The response of AppsApi->get_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->get_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uid** | **str**| The ID of the app | 
 **tenant** | **str**|  | 

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_file_meta_from_app_execution**
> FileMetas get_file_meta_from_app_execution(id, path, tenant)

Get file meta information from an app execution

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.file_metas import FileMetas
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
    api_instance = kestrapy.AppsApi(api_client)
    id = 'id_example' # str | The ID of the app.
    path = 'path_example' # str | The internal storage uri
    tenant = 'tenant_example' # str | 

    try:
        # Get file meta information from an app execution
        api_response = api_instance.get_file_meta_from_app_execution(id, path, tenant)
        print("The response of AppsApi->get_file_meta_from_app_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->get_file_meta_from_app_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of the app. | 
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
**200** | getFileMetaFromAppExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_file_preview_from_app_execution**
> object get_file_preview_from_app_execution(id, path, encoding, tenant, max_rows=max_rows)

Get file preview from an app execution

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
    api_instance = kestrapy.AppsApi(api_client)
    id = 'id_example' # str | The ID of the app.
    path = 'path_example' # str | The internal storage uri
    encoding = 'UTF-8' # str | The file encoding as Java charset name. Defaults to UTF-8 (default to 'UTF-8')
    tenant = 'tenant_example' # str | 
    max_rows = 56 # int | The max row returns (optional)

    try:
        # Get file preview from an app execution
        api_response = api_instance.get_file_preview_from_app_execution(id, path, encoding, tenant, max_rows=max_rows)
        print("The response of AppsApi->get_file_preview_from_app_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->get_file_preview_from_app_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of the app. | 
 **path** | **str**| The internal storage uri | 
 **encoding** | **str**| The file encoding as Java charset name. Defaults to UTF-8 | [default to &#39;UTF-8&#39;]
 **tenant** | **str**|  | 
 **max_rows** | **int**| The max row returns | [optional] 

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
**200** | getFilePreviewFromAppExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_logs_from_app_execution**
> bytearray get_logs_from_app_execution(uid, execution_id, tenant, min_level=min_level, task_ids=task_ids)

Download logs for an app execution

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
    api_instance = kestrapy.AppsApi(api_client)
    uid = 'uid_example' # str | The ID of the app.
    execution_id = 'execution_id_example' # str | The ID of the execution.
    tenant = 'tenant_example' # str | 
    min_level = kestrapy.Level() # Level | The min log level filter (optional)
    task_ids = ['task_ids_example'] # List[str] | The tasks' IDs (optional)

    try:
        # Download logs for an app execution
        api_response = api_instance.get_logs_from_app_execution(uid, execution_id, tenant, min_level=min_level, task_ids=task_ids)
        print("The response of AppsApi->get_logs_from_app_execution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->get_logs_from_app_execution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uid** | **str**| The ID of the app. | 
 **execution_id** | **str**| The ID of the execution. | 
 **tenant** | **str**|  | 
 **min_level** | [**Level**](.md)| The min log level filter | [optional] 
 **task_ids** | [**List[str]**](str.md)| The tasks&#39; IDs | [optional] 

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
**200** | getLogsFromAppExecution 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_stream_events_from_app**
> EventAppResponse get_stream_events_from_app(id, stream, parameters, tenant)

Get an event stream from a given app.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.event_app_response import EventAppResponse
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
    api_instance = kestrapy.AppsApi(api_client)
    id = 'id_example' # str | The ID of the app.
    stream = 'stream_example' # str | The ID of the stream to get
    parameters = {'key': kestrapy.HttpParameters()} # HttpParameters | 
    tenant = 'tenant_example' # str | 

    try:
        # Get an event stream from a given app.
        api_response = api_instance.get_stream_events_from_app(id, stream, parameters, tenant)
        print("The response of AppsApi->get_stream_events_from_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->get_stream_events_from_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of the app. | 
 **stream** | **str**| The ID of the stream to get | 
 **parameters** | [**HttpParameters**](.md)|  | 
 **tenant** | **str**|  | 

### Return type

[**EventAppResponse**](EventAppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/event-stream

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getStreamEventsFromApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_tags**
> AppsControllerApiAppTags list_tags(tenant)

Get all the app tags

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_app_tags import AppsControllerApiAppTags
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
    api_instance = kestrapy.AppsApi(api_client)
    tenant = 'tenant_example' # str | 

    try:
        # Get all the app tags
        api_response = api_instance.list_tags(tenant)
        print("The response of AppsApi->list_tags:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->list_tags: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 

### Return type

[**AppsControllerApiAppTags**](AppsControllerApiAppTags.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listTags 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **open_app**
> AppResponse open_app(uid, parameters, tenant)

Open an app

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.app_response import AppResponse
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
    api_instance = kestrapy.AppsApi(api_client)
    uid = 'uid_example' # str | The ID of the app
    parameters = {'key': kestrapy.HttpParameters()} # HttpParameters | 
    tenant = 'tenant_example' # str | 

    try:
        # Open an app
        api_response = api_instance.open_app(uid, parameters, tenant)
        print("The response of AppsApi->open_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->open_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uid** | **str**| The ID of the app | 
 **parameters** | [**HttpParameters**](.md)|  | 
 **tenant** | **str**|  | 

### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | openApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **preview_app**
> AppResponse preview_app(tenant, preview_app_request)

Open the app for the given source

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.app_response import AppResponse
from kestrapy.models.preview_app_request import PreviewAppRequest
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
    api_instance = kestrapy.AppsApi(api_client)
    tenant = 'tenant_example' # str | 
    preview_app_request = kestrapy.PreviewAppRequest() # PreviewAppRequest | The app

    try:
        # Open the app for the given source
        api_response = api_instance.preview_app(tenant, preview_app_request)
        print("The response of AppsApi->preview_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->preview_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **preview_app_request** | [**PreviewAppRequest**](PreviewAppRequest.md)| The app | 

### Return type

[**AppResponse**](AppResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/x-yaml
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | previewApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_apps**
> PagedResultsAppsControllerApiApp search_apps(page, size, tenant, sort=sort, tags=tags, q=q, namespace=namespace, flow_id=flow_id)

Search for apps

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_apps_controller_api_app import PagedResultsAppsControllerApiApp
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
    api_instance = kestrapy.AppsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    tags = ['tags_example'] # List[str] | A tags filter (optional)
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter prefix (optional)
    flow_id = 'flow_id_example' # str | A flow id filter (optional)

    try:
        # Search for apps
        api_response = api_instance.search_apps(page, size, tenant, sort=sort, tags=tags, q=q, namespace=namespace, flow_id=flow_id)
        print("The response of AppsApi->search_apps:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->search_apps: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **tags** | [**List[str]**](str.md)| A tags filter | [optional] 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter prefix | [optional] 
 **flow_id** | **str**| A flow id filter | [optional] 

### Return type

[**PagedResultsAppsControllerApiApp**](PagedResultsAppsControllerApiApp.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchApps 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_apps_from_catalog**
> PagedResultsAppsControllerApiAppCatalogItem search_apps_from_catalog(page, size, tenant, tags=tags, q=q)

Search for apps from catalog

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_apps_controller_api_app_catalog_item import PagedResultsAppsControllerApiAppCatalogItem
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
    api_instance = kestrapy.AppsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    tags = ['tags_example'] # List[str] | Tags filter (optional)
    q = 'q_example' # str | String filter (optional)

    try:
        # Search for apps from catalog
        api_response = api_instance.search_apps_from_catalog(page, size, tenant, tags=tags, q=q)
        print("The response of AppsApi->search_apps_from_catalog:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->search_apps_from_catalog: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **tags** | [**List[str]**](str.md)| Tags filter | [optional] 
 **q** | **str**| String filter | [optional] 

### Return type

[**PagedResultsAppsControllerApiAppCatalogItem**](PagedResultsAppsControllerApiAppCatalogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchAppsFromCatalog 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_app**
> AppsControllerApiAppSource update_app(uid, tenant, body)

Update an existing app

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.apps_controller_api_app_source import AppsControllerApiAppSource
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
    api_instance = kestrapy.AppsApi(api_client)
    uid = 'uid_example' # str | The ID of the app
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The app

    try:
        # Update an existing app
        api_response = api_instance.update_app(uid, tenant, body)
        print("The response of AppsApi->update_app:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AppsApi->update_app: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uid** | **str**| The ID of the app | 
 **tenant** | **str**|  | 
 **body** | **str**| The app | 

### Return type

[**AppsControllerApiAppSource**](AppsControllerApiAppSource.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/x-yaml
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateApp 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

