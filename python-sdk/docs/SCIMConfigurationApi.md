# kestra_api_client.SCIMConfigurationApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_all_resource_types**](SCIMConfigurationApi.md#get_all_resource_types) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/ResourceTypes | 
[**get_all_schemas**](SCIMConfigurationApi.md#get_all_schemas) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Schemas | 
[**get_resource_type**](SCIMConfigurationApi.md#get_resource_type) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/ResourceTypes/{name} | 
[**get_schema**](SCIMConfigurationApi.md#get_schema) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Schemas/{uri} | 
[**get_service_provider_configuration**](SCIMConfigurationApi.md#get_service_provider_configuration) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/ServiceProviderConfig | 


# **get_all_resource_types**
> List[ResourceType] get_all_resource_types(integration, tenant)

Get All Resource Types

### Example


```python
import kestra_api_client
from kestra_api_client.models.resource_type import ResourceType
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
    api_instance = kestra_api_client.SCIMConfigurationApi(api_client)
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 

    try:
        api_response = api_instance.get_all_resource_types(integration, tenant)
        print("The response of SCIMConfigurationApi->get_all_resource_types:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMConfigurationApi->get_all_resource_types: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **integration** | **str**|  | 
 **tenant** | **str**|  | 

### Return type

[**List[ResourceType]**](ResourceType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_schemas**
> List[ModelSchema] get_all_schemas(integration, tenant)

Get All Schemas

### Example


```python
import kestra_api_client
from kestra_api_client.models.model_schema import ModelSchema
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
    api_instance = kestra_api_client.SCIMConfigurationApi(api_client)
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 

    try:
        api_response = api_instance.get_all_schemas(integration, tenant)
        print("The response of SCIMConfigurationApi->get_all_schemas:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMConfigurationApi->get_all_schemas: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **integration** | **str**|  | 
 **tenant** | **str**|  | 

### Return type

[**List[ModelSchema]**](ModelSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_resource_type**
> ResourceType get_resource_type(name, integration, tenant)

Get Resource Type by URN

### Example


```python
import kestra_api_client
from kestra_api_client.models.resource_type import ResourceType
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
    api_instance = kestra_api_client.SCIMConfigurationApi(api_client)
    name = 'name_example' # str | 
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 

    try:
        api_response = api_instance.get_resource_type(name, integration, tenant)
        print("The response of SCIMConfigurationApi->get_resource_type:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMConfigurationApi->get_resource_type: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **str**|  | 
 **integration** | **str**|  | 
 **tenant** | **str**|  | 

### Return type

[**ResourceType**](ResourceType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_schema**
> ModelSchema get_schema(uri, integration, tenant)

Get Schemas by URN

### Example


```python
import kestra_api_client
from kestra_api_client.models.model_schema import ModelSchema
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
    api_instance = kestra_api_client.SCIMConfigurationApi(api_client)
    uri = 'uri_example' # str | 
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 

    try:
        api_response = api_instance.get_schema(uri, integration, tenant)
        print("The response of SCIMConfigurationApi->get_schema:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMConfigurationApi->get_schema: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uri** | **str**|  | 
 **integration** | **str**|  | 
 **tenant** | **str**|  | 

### Return type

[**ModelSchema**](ModelSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_service_provider_configuration**
> ServiceProviderConfiguration get_service_provider_configuration(integration, tenant)

Get Service Provider Configuration

### Example


```python
import kestra_api_client
from kestra_api_client.models.service_provider_configuration import ServiceProviderConfiguration
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
    api_instance = kestra_api_client.SCIMConfigurationApi(api_client)
    integration = 'integration_example' # str | 
    tenant = 'tenant_example' # str | 

    try:
        api_response = api_instance.get_service_provider_configuration(integration, tenant)
        print("The response of SCIMConfigurationApi->get_service_provider_configuration:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SCIMConfigurationApi->get_service_provider_configuration: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **integration** | **str**|  | 
 **tenant** | **str**|  | 

### Return type

[**ServiceProviderConfiguration**](ServiceProviderConfiguration.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/scim+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

