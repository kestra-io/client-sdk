# kestra_api_client.MiscApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_basic_auth**](MiscApi.md#create_basic_auth) | **POST** /api/v1/{tenant}/basicAuth | Configure basic authentication for the instance.
[**get_basic_auth_config_errors**](MiscApi.md#get_basic_auth_config_errors) | **GET** /api/v1/basicAuthValidationErrors | Retrieve the instance configuration.
[**get_configuration**](MiscApi.md#get_configuration) | **GET** /api/v1/configs | Retrieve the instance configuration.
[**get_usages**](MiscApi.md#get_usages) | **GET** /api/v1/{tenant}/usages/all | Retrieve instance usage information
[**license_info**](MiscApi.md#license_info) | **GET** /api/v1/license-info | Retrieve license information
[**list_actions**](MiscApi.md#list_actions) | **GET** /api/v1/{tenant}/acls/actions | Retrieve list of actions
[**list_permissions**](MiscApi.md#list_permissions) | **GET** /api/v1/{tenant}/acls/permissions | Retrieve list of permissions
[**setup_configuration**](MiscApi.md#setup_configuration) | **GET** /api/v1/setup | Retrieve current setup configuration
[**setup_kestra**](MiscApi.md#setup_kestra) | **POST** /api/v1/setup | Create the first Superadmin user
[**tenant_usage**](MiscApi.md#tenant_usage) | **GET** /api/v1/{tenant}/usages | Retrieve usage information for the current tenant


# **create_basic_auth**
> create_basic_auth(tenant, misc_controller_basic_auth_credentials)

Configure basic authentication for the instance.

Sets up basic authentication credentials.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.misc_controller_basic_auth_credentials import MiscControllerBasicAuthCredentials
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
    api_instance = kestra_api_client.MiscApi(api_client)
    tenant = 'tenant_example' # str | 
    misc_controller_basic_auth_credentials = kestra_api_client.MiscControllerBasicAuthCredentials() # MiscControllerBasicAuthCredentials | 

    try:
        # Configure basic authentication for the instance.
        api_instance.create_basic_auth(tenant, misc_controller_basic_auth_credentials)
    except Exception as e:
        print("Exception when calling MiscApi->create_basic_auth: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **misc_controller_basic_auth_credentials** | [**MiscControllerBasicAuthCredentials**](MiscControllerBasicAuthCredentials.md)|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createBasicAuth 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_basic_auth_config_errors**
> List[str] get_basic_auth_config_errors()

Retrieve the instance configuration.

Global endpoint available to all users.

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
    api_instance = kestra_api_client.MiscApi(api_client)

    try:
        # Retrieve the instance configuration.
        api_response = api_instance.get_basic_auth_config_errors()
        print("The response of MiscApi->get_basic_auth_config_errors:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->get_basic_auth_config_errors: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

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
**200** | getBasicAuthConfigErrors 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_configuration**
> MiscControllerEEConfiguration get_configuration()

Retrieve the instance configuration.

Global endpoint available to all users.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.misc_controller_ee_configuration import MiscControllerEEConfiguration
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
    api_instance = kestra_api_client.MiscApi(api_client)

    try:
        # Retrieve the instance configuration.
        api_response = api_instance.get_configuration()
        print("The response of MiscApi->get_configuration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->get_configuration: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**MiscControllerEEConfiguration**](MiscControllerEEConfiguration.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getConfiguration 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_usages**
> UsageEE get_usages(tenant)

Retrieve instance usage information

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.usage_ee import UsageEE
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
    api_instance = kestra_api_client.MiscApi(api_client)
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve instance usage information
        api_response = api_instance.get_usages(tenant)
        print("The response of MiscApi->get_usages:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->get_usages: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 

### Return type

[**UsageEE**](UsageEE.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getUsages 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **license_info**
> MiscControllerLicenseInfo license_info()

Retrieve license information

Global endpoint, available to any authenticated user.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.misc_controller_license_info import MiscControllerLicenseInfo
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
    api_instance = kestra_api_client.MiscApi(api_client)

    try:
        # Retrieve license information
        api_response = api_instance.license_info()
        print("The response of MiscApi->license_info:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->license_info: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**MiscControllerLicenseInfo**](MiscControllerLicenseInfo.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | licenseInfo 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_actions**
> List[Action] list_actions(tenant)

Retrieve list of actions

Actions are used to restrict possible operations for each permission. Each action must be one of the following: CREATE, READ, UPDATE, DELETE. Using permissions and actions together, you can control access to resources e.g. only allow a user to read a flow, but not update or delete it.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.action import Action
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
    api_instance = kestra_api_client.MiscApi(api_client)
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve list of actions
        api_response = api_instance.list_actions(tenant)
        print("The response of MiscApi->list_actions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->list_actions: %s\n" % e)
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
import kestra_api_client
from kestra_api_client.models.permission import Permission
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
    api_instance = kestra_api_client.MiscApi(api_client)
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve list of permissions
        api_response = api_instance.list_permissions(tenant)
        print("The response of MiscApi->list_permissions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->list_permissions: %s\n" % e)
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

# **setup_configuration**
> SetupConfiguration setup_configuration()

Retrieve current setup configuration

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.setup_configuration import SetupConfiguration
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
    api_instance = kestra_api_client.MiscApi(api_client)

    try:
        # Retrieve current setup configuration
        api_response = api_instance.setup_configuration()
        print("The response of MiscApi->setup_configuration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->setup_configuration: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**SetupConfiguration**](SetupConfiguration.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setupConfiguration 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setup_kestra**
> ApiUser setup_kestra(setup_configuration_setup_data)

Create the first Superadmin user

Only used during initial instance setup.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.api_user import ApiUser
from kestra_api_client.models.setup_configuration_setup_data import SetupConfigurationSetupData
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
    api_instance = kestra_api_client.MiscApi(api_client)
    setup_configuration_setup_data = kestra_api_client.SetupConfigurationSetupData() # SetupConfigurationSetupData | 

    try:
        # Create the first Superadmin user
        api_response = api_instance.setup_kestra(setup_configuration_setup_data)
        print("The response of MiscApi->setup_kestra:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->setup_kestra: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **setup_configuration_setup_data** | [**SetupConfigurationSetupData**](SetupConfigurationSetupData.md)|  | 

### Return type

[**ApiUser**](ApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setupKestra 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **tenant_usage**
> UsageEE tenant_usage(tenant)

Retrieve usage information for the current tenant

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.usage_ee import UsageEE
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
    api_instance = kestra_api_client.MiscApi(api_client)
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve usage information for the current tenant
        api_response = api_instance.tenant_usage(tenant)
        print("The response of MiscApi->tenant_usage:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MiscApi->tenant_usage: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 

### Return type

[**UsageEE**](UsageEE.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | tenantUsage 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

