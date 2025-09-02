# kestra_api_client.MaintenanceApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**enter_maintenance**](MaintenanceApi.md#enter_maintenance) | **POST** /api/v1/instance/maintenance/enter | Enter cluster maintenance mode
[**exit_maintenance**](MaintenanceApi.md#exit_maintenance) | **POST** /api/v1/instance/maintenance/exit | Exit cluster maintenance mode


# **enter_maintenance**
> object enter_maintenance()

Enter cluster maintenance mode

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestra_api_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestra_api_client.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.MaintenanceApi(api_client)

    try:
        # Enter cluster maintenance mode
        api_response = api_instance.enter_maintenance()
        print("The response of MaintenanceApi->enter_maintenance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MaintenanceApi->enter_maintenance: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

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
**200** | enterMaintenance 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **exit_maintenance**
> object exit_maintenance()

Exit cluster maintenance mode

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestra_api_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestra_api_client.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.MaintenanceApi(api_client)

    try:
        # Exit cluster maintenance mode
        api_response = api_instance.exit_maintenance()
        print("The response of MaintenanceApi->exit_maintenance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MaintenanceApi->exit_maintenance: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

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
**200** | exitMaintenance 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

