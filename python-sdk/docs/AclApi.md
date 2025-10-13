# kestrapy.AclApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**list_actions**](AclApi.md#list_actions) | **GET** /api/v1/{tenant}/acls/actions | Retrieve list of actions
[**list_permissions**](AclApi.md#list_permissions) | **GET** /api/v1/{tenant}/acls/permissions | Retrieve list of permissions


# **list_actions**
> List[Action] list_actions(tenant)

Retrieve list of actions

Actions are used to restrict possible operations for each permission. Each action must be one of the following: CREATE, READ, UPDATE, DELETE. Using permissions and actions together, you can control access to resources e.g. only allow a user to read a flow, but not update or delete it.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.action import Action
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
    api_instance = kestrapy.AclApi(api_client)
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve list of actions
        api_response = api_instance.list_actions(tenant)
        print("The response of AclApi->list_actions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AclApi->list_actions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 

### Return type

[**List[Action]**](Action.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listActions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_permissions**
> List[Permission] list_permissions(tenant)

Retrieve list of permissions

Permissions are used to control access to resources within the Kestra platform. Example of permissions are: FLOW, EXECUTION, NAMESPACE, APP, TEST, etc.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.permission import Permission
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
    api_instance = kestrapy.AclApi(api_client)
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve list of permissions
        api_response = api_instance.list_permissions(tenant)
        print("The response of AclApi->list_permissions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AclApi->list_permissions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 

### Return type

[**List[Permission]**](Permission.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listPermissions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

