# kestra_api_client.SecurityIntegrationsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_security_integration**](SecurityIntegrationsApi.md#create_security_integration) | **POST** /api/v1/{tenant}/security-integrations | Create a security integration
[**delete_security_integration**](SecurityIntegrationsApi.md#delete_security_integration) | **DELETE** /api/v1/{tenant}/security-integrations/{id} | Delete a security integration
[**disable_security_integration**](SecurityIntegrationsApi.md#disable_security_integration) | **POST** /api/v1/{tenant}/security-integrations/{id}/disable | Disable a security integration
[**enable_security_integration**](SecurityIntegrationsApi.md#enable_security_integration) | **POST** /api/v1/{tenant}/security-integrations/{id}/enable | Enable a security integration
[**get_security_integration**](SecurityIntegrationsApi.md#get_security_integration) | **GET** /api/v1/{tenant}/security-integrations/{id} | Retrieve a security integration
[**list_security_integrations**](SecurityIntegrationsApi.md#list_security_integrations) | **GET** /api/v1/{tenant}/security-integrations | List all security integrations


# **create_security_integration**
> object create_security_integration(tenant, create_security_integration_request)

Create a security integration

Superadmin-only.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.create_security_integration_request import CreateSecurityIntegrationRequest
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
    api_instance = kestra_api_client.SecurityIntegrationsApi(api_client)
    tenant = 'tenant_example' # str | 
    create_security_integration_request = kestra_api_client.CreateSecurityIntegrationRequest() # CreateSecurityIntegrationRequest | The security integration definition

    try:
        # Create a security integration
        api_response = api_instance.create_security_integration(tenant, create_security_integration_request)
        print("The response of SecurityIntegrationsApi->create_security_integration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SecurityIntegrationsApi->create_security_integration: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **create_security_integration_request** | [**CreateSecurityIntegrationRequest**](CreateSecurityIntegrationRequest.md)| The security integration definition | 

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
**200** | createSecurityIntegration 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_security_integration**
> object delete_security_integration(id, tenant)

Delete a security integration

Superadmin-only.

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
    api_instance = kestra_api_client.SecurityIntegrationsApi(api_client)
    id = 'id_example' # str | The ID of security integration
    tenant = 'tenant_example' # str | 

    try:
        # Delete a security integration
        api_response = api_instance.delete_security_integration(id, tenant)
        print("The response of SecurityIntegrationsApi->delete_security_integration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SecurityIntegrationsApi->delete_security_integration: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of security integration | 
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
**200** | deleteSecurityIntegration 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **disable_security_integration**
> object disable_security_integration(id, tenant)

Disable a security integration

Superadmin-only. Disables the specified integration.

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
    api_instance = kestra_api_client.SecurityIntegrationsApi(api_client)
    id = 'id_example' # str | The ID of security integration
    tenant = 'tenant_example' # str | 

    try:
        # Disable a security integration
        api_response = api_instance.disable_security_integration(id, tenant)
        print("The response of SecurityIntegrationsApi->disable_security_integration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SecurityIntegrationsApi->disable_security_integration: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of security integration | 
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
**200** | disableSecurityIntegration 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **enable_security_integration**
> object enable_security_integration(id, tenant)

Enable a security integration

Superadmin-only. Enables the specified integration.

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
    api_instance = kestra_api_client.SecurityIntegrationsApi(api_client)
    id = 'id_example' # str | The ID of security integration
    tenant = 'tenant_example' # str | 

    try:
        # Enable a security integration
        api_response = api_instance.enable_security_integration(id, tenant)
        print("The response of SecurityIntegrationsApi->enable_security_integration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SecurityIntegrationsApi->enable_security_integration: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of security integration | 
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
**200** | enableSecurityIntegration 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_security_integration**
> object get_security_integration(id, tenant)

Retrieve a security integration

Superadmin-only.

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
    api_instance = kestra_api_client.SecurityIntegrationsApi(api_client)
    id = 'id_example' # str | The ID of security integration
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a security integration
        api_response = api_instance.get_security_integration(id, tenant)
        print("The response of SecurityIntegrationsApi->get_security_integration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SecurityIntegrationsApi->get_security_integration: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The ID of security integration | 
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
**200** | getSecurityIntegration 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_security_integrations**
> object list_security_integrations(tenant)

List all security integrations

Superadmin-only.

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
    api_instance = kestra_api_client.SecurityIntegrationsApi(api_client)
    tenant = 'tenant_example' # str | 

    try:
        # List all security integrations
        api_response = api_instance.list_security_integrations(tenant)
        print("The response of SecurityIntegrationsApi->list_security_integrations:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SecurityIntegrationsApi->list_security_integrations: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**200** | listSecurityIntegrations 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

