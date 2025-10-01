# kestrapy.AuditLogsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**export_audit_logs**](AuditLogsApi.md#export_audit_logs) | **GET** /api/v1/{tenant}/auditlogs/export | Export all audit logs as a streamed CSV file
[**find_audit_log**](AuditLogsApi.md#find_audit_log) | **POST** /api/v1/{tenant}/auditlogs/find | Find a specific audit log
[**get_global_resource_diff_from_audit_log**](AuditLogsApi.md#get_global_resource_diff_from_audit_log) | **GET** /api/v1/auditlogs/{id}/diff | Retrieve the diff between audit logs from global resource like users
[**get_resource_diff_from_audit_log**](AuditLogsApi.md#get_resource_diff_from_audit_log) | **GET** /api/v1/{tenant}/auditlogs/{id}/diff | Retrieve the diff between audit logs
[**list_audit_log_from_resource_id**](AuditLogsApi.md#list_audit_log_from_resource_id) | **GET** /api/v1/{tenant}/auditlogs/history/{detailId} | Find all audit logs about a specific resource.
[**search_audit_logs**](AuditLogsApi.md#search_audit_logs) | **GET** /api/v1/{tenant}/auditlogs/search | Search for audit logs
[**search_audit_logs_for_all_tenants**](AuditLogsApi.md#search_audit_logs_for_all_tenants) | **GET** /api/v1/auditlogs/search | Search for audit logs across all tenants, required to be SuperAdmin


# **export_audit_logs**
> List[object] export_audit_logs(tenant, q=q, namespace=namespace, flow_id=flow_id, execution_id=execution_id, user_id=user_id, id=id, resources=resources, start_date=start_date, end_date=end_date, details=details, type=type)

Export all audit logs as a streamed CSV file

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.resource_type1 import ResourceType1
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
    api_instance = kestrapy.AuditLogsApi(api_client)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    namespace = 'namespace_example' # str | A namespace filter (optional)
    flow_id = 'flow_id_example' # str | A flow id filter (optional)
    execution_id = 'execution_id_example' # str | An execution filter (optional)
    user_id = 'user_id_example' # str | A user id filter (optional)
    id = 'id_example' # str | A id filter (optional)
    resources = [kestrapy.ResourceType1()] # List[ResourceType1] | A resource filter (optional)
    start_date = '2013-10-20T19:20:30+01:00' # datetime | The start datetime (optional)
    end_date = '2013-10-20T19:20:30+01:00' # datetime | The end datetime (optional)
    details = {'key': 'details_example'} # Dict[str, str] | A list of auditLog details (optional)
    type = kestrapy.CrudEventType() # CrudEventType | The event that create the audit log (optional)

    try:
        # Export all audit logs as a streamed CSV file
        api_response = api_instance.export_audit_logs(tenant, q=q, namespace=namespace, flow_id=flow_id, execution_id=execution_id, user_id=user_id, id=id, resources=resources, start_date=start_date, end_date=end_date, details=details, type=type)
        print("The response of AuditLogsApi->export_audit_logs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuditLogsApi->export_audit_logs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **namespace** | **str**| A namespace filter | [optional] 
 **flow_id** | **str**| A flow id filter | [optional] 
 **execution_id** | **str**| An execution filter | [optional] 
 **user_id** | **str**| A user id filter | [optional] 
 **id** | **str**| A id filter | [optional] 
 **resources** | [**List[ResourceType1]**](ResourceType1.md)| A resource filter | [optional] 
 **start_date** | **datetime**| The start datetime | [optional] 
 **end_date** | **datetime**| The end datetime | [optional] 
 **details** | [**Dict[str, str]**](str.md)| A list of auditLog details | [optional] 
 **type** | [**CrudEventType**](.md)| The event that create the audit log | [optional] 

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
**200** | exportAuditLogs 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **find_audit_log**
> AuditLogControllerApiAuditLogItem find_audit_log(tenant, audit_log_controller_find_request)

Find a specific audit log

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.audit_log_controller_api_audit_log_item import AuditLogControllerApiAuditLogItem
from kestrapy.models.audit_log_controller_find_request import AuditLogControllerFindRequest
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
    api_instance = kestrapy.AuditLogsApi(api_client)
    tenant = 'tenant_example' # str | 
    audit_log_controller_find_request = kestrapy.AuditLogControllerFindRequest() # AuditLogControllerFindRequest | The find request

    try:
        # Find a specific audit log
        api_response = api_instance.find_audit_log(tenant, audit_log_controller_find_request)
        print("The response of AuditLogsApi->find_audit_log:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuditLogsApi->find_audit_log: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **audit_log_controller_find_request** | [**AuditLogControllerFindRequest**](AuditLogControllerFindRequest.md)| The find request | 

### Return type

[**AuditLogControllerApiAuditLogItem**](AuditLogControllerApiAuditLogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | findAuditLog 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_global_resource_diff_from_audit_log**
> AuditLogControllerAuditLogDiff get_global_resource_diff_from_audit_log(id, previous_id=previous_id)

Retrieve the diff between audit logs from global resource like users

Retrieves the diff between the current version and a selected previous version of a given resource based on audit logs.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.audit_log_controller_audit_log_diff import AuditLogControllerAuditLogDiff
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
    api_instance = kestrapy.AuditLogsApi(api_client)
    id = 'id_example' # str | The id of the audit log
    previous_id = 'previous_id_example' # str | The id of a previous audit log to compare with (optional)

    try:
        # Retrieve the diff between audit logs from global resource like users
        api_response = api_instance.get_global_resource_diff_from_audit_log(id, previous_id=previous_id)
        print("The response of AuditLogsApi->get_global_resource_diff_from_audit_log:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuditLogsApi->get_global_resource_diff_from_audit_log: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The id of the audit log | 
 **previous_id** | **str**| The id of a previous audit log to compare with | [optional] 

### Return type

[**AuditLogControllerAuditLogDiff**](AuditLogControllerAuditLogDiff.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getGlobalResourceDiffFromAuditLog 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_resource_diff_from_audit_log**
> AuditLogControllerAuditLogDiff get_resource_diff_from_audit_log(id, tenant, previous_id=previous_id)

Retrieve the diff between audit logs

Retrieves the diff between the current version and a selected previous version of a given resource based on audit logs.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.audit_log_controller_audit_log_diff import AuditLogControllerAuditLogDiff
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
    api_instance = kestrapy.AuditLogsApi(api_client)
    id = 'id_example' # str | The id of the audit log
    tenant = 'tenant_example' # str | 
    previous_id = 'previous_id_example' # str | The id of a previous audit log to compare with (optional)

    try:
        # Retrieve the diff between audit logs
        api_response = api_instance.get_resource_diff_from_audit_log(id, tenant, previous_id=previous_id)
        print("The response of AuditLogsApi->get_resource_diff_from_audit_log:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuditLogsApi->get_resource_diff_from_audit_log: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The id of the audit log | 
 **tenant** | **str**|  | 
 **previous_id** | **str**| The id of a previous audit log to compare with | [optional] 

### Return type

[**AuditLogControllerAuditLogDiff**](AuditLogControllerAuditLogDiff.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getResourceDiffFromAuditLog 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_audit_log_from_resource_id**
> List[AuditLogControllerAuditLogOption] list_audit_log_from_resource_id(detail_id, tenant)

Find all audit logs about a specific resource.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.audit_log_controller_audit_log_option import AuditLogControllerAuditLogOption
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
    api_instance = kestrapy.AuditLogsApi(api_client)
    detail_id = 'detail_id_example' # str | The resource Id
    tenant = 'tenant_example' # str | 

    try:
        # Find all audit logs about a specific resource.
        api_response = api_instance.list_audit_log_from_resource_id(detail_id, tenant)
        print("The response of AuditLogsApi->list_audit_log_from_resource_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuditLogsApi->list_audit_log_from_resource_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **detail_id** | **str**| The resource Id | 
 **tenant** | **str**|  | 

### Return type

[**List[AuditLogControllerAuditLogOption]**](AuditLogControllerAuditLogOption.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listAuditLogFromResourceId 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_audit_logs**
> PagedResultsAuditLogControllerApiAuditLogItem search_audit_logs(page, size, tenant, q=q, sort=sort, namespace=namespace, flow_id=flow_id, execution_id=execution_id, user_id=user_id, id=id, resources=resources, start_date=start_date, end_date=end_date, details=details, type=type)

Search for audit logs

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_audit_log_controller_api_audit_log_item import PagedResultsAuditLogControllerApiAuditLogItem
from kestrapy.models.resource_type1 import ResourceType1
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
    api_instance = kestrapy.AuditLogsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    namespace = 'namespace_example' # str | A namespace filter (optional)
    flow_id = 'flow_id_example' # str | A flow id filter (optional)
    execution_id = 'execution_id_example' # str | An execution filter (optional)
    user_id = 'user_id_example' # str | A user id filter (optional)
    id = 'id_example' # str | A id filter (optional)
    resources = [kestrapy.ResourceType1()] # List[ResourceType1] | A resource filter (optional)
    start_date = '2013-10-20T19:20:30+01:00' # datetime | The start datetime (optional)
    end_date = '2013-10-20T19:20:30+01:00' # datetime | The end datetime (optional)
    details = {'key': 'details_example'} # Dict[str, str] | A list of auditLog details (optional)
    type = kestrapy.CrudEventType() # CrudEventType | The event that create the audit log (optional)

    try:
        # Search for audit logs
        api_response = api_instance.search_audit_logs(page, size, tenant, q=q, sort=sort, namespace=namespace, flow_id=flow_id, execution_id=execution_id, user_id=user_id, id=id, resources=resources, start_date=start_date, end_date=end_date, details=details, type=type)
        print("The response of AuditLogsApi->search_audit_logs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuditLogsApi->search_audit_logs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **namespace** | **str**| A namespace filter | [optional] 
 **flow_id** | **str**| A flow id filter | [optional] 
 **execution_id** | **str**| An execution filter | [optional] 
 **user_id** | **str**| A user id filter | [optional] 
 **id** | **str**| A id filter | [optional] 
 **resources** | [**List[ResourceType1]**](ResourceType1.md)| A resource filter | [optional] 
 **start_date** | **datetime**| The start datetime | [optional] 
 **end_date** | **datetime**| The end datetime | [optional] 
 **details** | [**Dict[str, str]**](str.md)| A list of auditLog details | [optional] 
 **type** | [**CrudEventType**](.md)| The event that create the audit log | [optional] 

### Return type

[**PagedResultsAuditLogControllerApiAuditLogItem**](PagedResultsAuditLogControllerApiAuditLogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchAuditLogs 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_audit_logs_for_all_tenants**
> PagedResultsAuditLogControllerApiAuditLogItem search_audit_logs_for_all_tenants(page, size, q=q, sort=sort, namespace=namespace, flow_id=flow_id, execution_id=execution_id, user_id=user_id, id=id, resources=resources, start_date=start_date, end_date=end_date, details=details, type=type)

Search for audit logs across all tenants, required to be SuperAdmin

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_audit_log_controller_api_audit_log_item import PagedResultsAuditLogControllerApiAuditLogItem
from kestrapy.models.resource_type1 import ResourceType1
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
    api_instance = kestrapy.AuditLogsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    namespace = 'namespace_example' # str | A namespace filter (optional)
    flow_id = 'flow_id_example' # str | A flow id filter (optional)
    execution_id = 'execution_id_example' # str | An execution filter (optional)
    user_id = 'user_id_example' # str | A user id filter (optional)
    id = 'id_example' # str | A id filter (optional)
    resources = [kestrapy.ResourceType1()] # List[ResourceType1] | A resource filter (optional)
    start_date = '2013-10-20T19:20:30+01:00' # datetime | The start datetime (optional)
    end_date = '2013-10-20T19:20:30+01:00' # datetime | The end datetime (optional)
    details = {'key': 'details_example'} # Dict[str, str] | A list of auditLog details (optional)
    type = kestrapy.CrudEventType() # CrudEventType | The event that create the audit log (optional)

    try:
        # Search for audit logs across all tenants, required to be SuperAdmin
        api_response = api_instance.search_audit_logs_for_all_tenants(page, size, q=q, sort=sort, namespace=namespace, flow_id=flow_id, execution_id=execution_id, user_id=user_id, id=id, resources=resources, start_date=start_date, end_date=end_date, details=details, type=type)
        print("The response of AuditLogsApi->search_audit_logs_for_all_tenants:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuditLogsApi->search_audit_logs_for_all_tenants: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **namespace** | **str**| A namespace filter | [optional] 
 **flow_id** | **str**| A flow id filter | [optional] 
 **execution_id** | **str**| An execution filter | [optional] 
 **user_id** | **str**| A user id filter | [optional] 
 **id** | **str**| A id filter | [optional] 
 **resources** | [**List[ResourceType1]**](ResourceType1.md)| A resource filter | [optional] 
 **start_date** | **datetime**| The start datetime | [optional] 
 **end_date** | **datetime**| The end datetime | [optional] 
 **details** | [**Dict[str, str]**](str.md)| A list of auditLog details | [optional] 
 **type** | [**CrudEventType**](.md)| The event that create the audit log | [optional] 

### Return type

[**PagedResultsAuditLogControllerApiAuditLogItem**](PagedResultsAuditLogControllerApiAuditLogItem.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchAuditLogsForAllTenants 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

