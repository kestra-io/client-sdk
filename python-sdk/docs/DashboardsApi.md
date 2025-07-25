# kestra_api_client.DashboardsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_dashboard**](DashboardsApi.md#create_dashboard) | **POST** /api/v1/{tenant}/dashboards | Create a dashboard from yaml source
[**delete_dashboard**](DashboardsApi.md#delete_dashboard) | **DELETE** /api/v1/{tenant}/dashboards/{id} | Delete a dashboard
[**get_dashboard**](DashboardsApi.md#get_dashboard) | **GET** /api/v1/{tenant}/dashboards/{id} | Get a dashboard
[**get_dashboard_chart_data**](DashboardsApi.md#get_dashboard_chart_data) | **POST** /api/v1/{tenant}/dashboards/{id}/charts/{chartId} | Generate a dashboard chart data
[**preview_chart**](DashboardsApi.md#preview_chart) | **POST** /api/v1/{tenant}/dashboards/charts/preview | Preview a chart data
[**search_dashboards**](DashboardsApi.md#search_dashboards) | **GET** /api/v1/{tenant}/dashboards | Search for dashboards
[**update_dashboard**](DashboardsApi.md#update_dashboard) | **PUT** /api/v1/{tenant}/dashboards/{id} | Update a dashboard
[**validate_chart**](DashboardsApi.md#validate_chart) | **POST** /api/v1/{tenant}/dashboards/validate/chart | Validate a chart from yaml source
[**validate_dashboard**](DashboardsApi.md#validate_dashboard) | **POST** /api/v1/{tenant}/dashboards/validate | Validate dashboard from yaml source


# **create_dashboard**
> Dashboard create_dashboard(tenant, body)

Create a dashboard from yaml source

### Example


```python
import kestra_api_client
from kestra_api_client.models.dashboard import Dashboard
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The dashboard definition as YAML

    try:
        # Create a dashboard from yaml source
        api_response = api_instance.create_dashboard(tenant, body)
        print("The response of DashboardsApi->create_dashboard:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DashboardsApi->create_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The dashboard definition as YAML | 

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-yaml
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createDashboard 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_dashboard**
> delete_dashboard(id, tenant)

Delete a dashboard

### Example


```python
import kestra_api_client
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    id = 'id_example' # str | The dashboard id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a dashboard
        api_instance.delete_dashboard(id, tenant)
    except Exception as e:
        print("Exception when calling DashboardsApi->delete_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The dashboard id | 
 **tenant** | **str**|  | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteDashboard 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_dashboard**
> Dashboard get_dashboard(id, tenant)

Get a dashboard

### Example


```python
import kestra_api_client
from kestra_api_client.models.dashboard import Dashboard
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    id = 'id_example' # str | The dashboard id
    tenant = 'tenant_example' # str | 

    try:
        # Get a dashboard
        api_response = api_instance.get_dashboard(id, tenant)
        print("The response of DashboardsApi->get_dashboard:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DashboardsApi->get_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The dashboard id | 
 **tenant** | **str**|  | 

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getDashboard 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_dashboard_chart_data**
> PagedResultsMapStringObject get_dashboard_chart_data(id, chart_id, tenant, global_filter)

Generate a dashboard chart data

### Example


```python
import kestra_api_client
from kestra_api_client.models.global_filter import GlobalFilter
from kestra_api_client.models.paged_results_map_string_object import PagedResultsMapStringObject
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    id = 'id_example' # str | The dashboard id
    chart_id = 'chart_id_example' # str | The chart id
    tenant = 'tenant_example' # str | 
    global_filter = kestra_api_client.GlobalFilter() # GlobalFilter | The filters to apply, some can override chart definition like labels & namespace

    try:
        # Generate a dashboard chart data
        api_response = api_instance.get_dashboard_chart_data(id, chart_id, tenant, global_filter)
        print("The response of DashboardsApi->get_dashboard_chart_data:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DashboardsApi->get_dashboard_chart_data: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The dashboard id | 
 **chart_id** | **str**| The chart id | 
 **tenant** | **str**|  | 
 **global_filter** | [**GlobalFilter**](GlobalFilter.md)| The filters to apply, some can override chart definition like labels &amp; namespace | 

### Return type

[**PagedResultsMapStringObject**](PagedResultsMapStringObject.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getDashboardChartData 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **preview_chart**
> PagedResultsMapStringObject preview_chart(tenant, dashboard_controller_preview_request)

Preview a chart data

### Example


```python
import kestra_api_client
from kestra_api_client.models.dashboard_controller_preview_request import DashboardControllerPreviewRequest
from kestra_api_client.models.paged_results_map_string_object import PagedResultsMapStringObject
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    tenant = 'tenant_example' # str | 
    dashboard_controller_preview_request = kestra_api_client.DashboardControllerPreviewRequest() # DashboardControllerPreviewRequest | 

    try:
        # Preview a chart data
        api_response = api_instance.preview_chart(tenant, dashboard_controller_preview_request)
        print("The response of DashboardsApi->preview_chart:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DashboardsApi->preview_chart: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **dashboard_controller_preview_request** | [**DashboardControllerPreviewRequest**](DashboardControllerPreviewRequest.md)|  | 

### Return type

[**PagedResultsMapStringObject**](PagedResultsMapStringObject.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | previewChart 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_dashboards**
> PagedResultsDashboard search_dashboards(page, size, tenant, q=q, sort=sort)

Search for dashboards

### Example


```python
import kestra_api_client
from kestra_api_client.models.paged_results_dashboard import PagedResultsDashboard
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | The filter query (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Search for dashboards
        api_response = api_instance.search_dashboards(page, size, tenant, q=q, sort=sort)
        print("The response of DashboardsApi->search_dashboards:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DashboardsApi->search_dashboards: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **q** | **str**| The filter query | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsDashboard**](PagedResultsDashboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchDashboards 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_dashboard**
> Dashboard update_dashboard(id, tenant, body)

Update a dashboard

### Example


```python
import kestra_api_client
from kestra_api_client.models.dashboard import Dashboard
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    id = 'id_example' # str | The dashboard id
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The dashboard definition as YAML

    try:
        # Update a dashboard
        api_response = api_instance.update_dashboard(id, tenant, body)
        print("The response of DashboardsApi->update_dashboard:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DashboardsApi->update_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The dashboard id | 
 **tenant** | **str**|  | 
 **body** | **str**| The dashboard definition as YAML | 

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-yaml
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateDashboard 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_chart**
> ValidateConstraintViolation validate_chart(tenant, body)

Validate a chart from yaml source

### Example


```python
import kestra_api_client
from kestra_api_client.models.validate_constraint_violation import ValidateConstraintViolation
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The chart definition as YAML

    try:
        # Validate a chart from yaml source
        api_response = api_instance.validate_chart(tenant, body)
        print("The response of DashboardsApi->validate_chart:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DashboardsApi->validate_chart: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The chart definition as YAML | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-yaml
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | validateChart 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_dashboard**
> ValidateConstraintViolation validate_dashboard(tenant, body)

Validate dashboard from yaml source

### Example


```python
import kestra_api_client
from kestra_api_client.models.validate_constraint_violation import ValidateConstraintViolation
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.DashboardsApi(api_client)
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The dashboard definition as YAML

    try:
        # Validate dashboard from yaml source
        api_response = api_instance.validate_dashboard(tenant, body)
        print("The response of DashboardsApi->validate_dashboard:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DashboardsApi->validate_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **body** | **str**| The dashboard definition as YAML | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-yaml
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | validateDashboard 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

