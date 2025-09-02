# kestra_api_client.PluginsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_all_input_types**](PluginsApi.md#get_all_input_types) | **GET** /api/v1/plugins/inputs | Get all types for an inputs
[**get_plugin_by_subgroups**](PluginsApi.md#get_plugin_by_subgroups) | **GET** /api/v1/plugins/groups/subgroups | Get plugins group by subgroups
[**get_plugin_documentation**](PluginsApi.md#get_plugin_documentation) | **GET** /api/v1/plugins/{cls} | Get plugin documentation
[**get_plugin_documentation_from_version**](PluginsApi.md#get_plugin_documentation_from_version) | **GET** /api/v1/plugins/{cls}/versions/{version} | Get plugin documentation
[**get_plugin_group_icons**](PluginsApi.md#get_plugin_group_icons) | **GET** /api/v1/plugins/icons/groups | Get plugins icons
[**get_plugin_icons**](PluginsApi.md#get_plugin_icons) | **GET** /api/v1/plugins/icons | Get plugins icons
[**get_plugin_versions**](PluginsApi.md#get_plugin_versions) | **GET** /api/v1/plugins/{cls}/versions | Get all versions for a plugin
[**get_properties_from_type**](PluginsApi.md#get_properties_from_type) | **GET** /api/v1/plugins/properties/{type} | Get the properties part of the JSON schema for a type
[**get_schema_from_input_type**](PluginsApi.md#get_schema_from_input_type) | **GET** /api/v1/plugins/inputs/{type} | Get the JSON schema for an input type
[**get_schemas_from_type**](PluginsApi.md#get_schemas_from_type) | **GET** /api/v1/plugins/schemas/{type} | Get the JSON schema for a type
[**get_versioned_plugin_details**](PluginsApi.md#get_versioned_plugin_details) | **GET** /api/v1/instance/versioned-plugins/{groupId}/{artifactId} | Retrieve details of a plugin artifact
[**get_versioned_plugin_details_from_version**](PluginsApi.md#get_versioned_plugin_details_from_version) | **GET** /api/v1/instance/versioned-plugins/{groupId}/{artifactId}/{version} | Retrieve details of a specific plugin artifact version
[**install_versioned_plugins**](PluginsApi.md#install_versioned_plugins) | **POST** /api/v1/instance/versioned-plugins/install | Install specified plugin artifacts
[**list_available_versioned_plugins**](PluginsApi.md#list_available_versioned_plugins) | **GET** /api/v1/instance/versioned-plugins/available | List available plugin artifacts
[**list_available_versioned_plugins_for_secret_manager**](PluginsApi.md#list_available_versioned_plugins_for_secret_manager) | **GET** /api/v1/instance/versioned-plugins/available/secrets-managers | List available plugin artifacts for Kestra Secret Manager
[**list_available_versioned_plugins_for_storage**](PluginsApi.md#list_available_versioned_plugins_for_storage) | **GET** /api/v1/instance/versioned-plugins/available/storages | List available plugin artifacts for Kestra Internal Storage
[**list_plugins**](PluginsApi.md#list_plugins) | **GET** /api/v1/plugins | Get list of plugins
[**list_versioned_plugin**](PluginsApi.md#list_versioned_plugin) | **GET** /api/v1/instance/versioned-plugins | List installed plugin artifacts
[**resolve_versioned_plugins**](PluginsApi.md#resolve_versioned_plugins) | **POST** /api/v1/instance/versioned-plugins/resolve | Resolve versions for specified plugin artifacts
[**uninstall_versioned_plugins**](PluginsApi.md#uninstall_versioned_plugins) | **DELETE** /api/v1/instance/versioned-plugins/uninstall | Uninstall plugin artifacts
[**upload_versioned_plugins**](PluginsApi.md#upload_versioned_plugins) | **POST** /api/v1/instance/versioned-plugins/upload | Upload a plugin artifact JAR file


# **get_all_input_types**
> List[InputType] get_all_input_types()

Get all types for an inputs

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.input_type import InputType
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
    api_instance = kestra_api_client.PluginsApi(api_client)

    try:
        # Get all types for an inputs
        api_response = api_instance.get_all_input_types()
        print("The response of PluginsApi->get_all_input_types:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_all_input_types: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**List[InputType]**](InputType.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getAllInputTypes 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_plugin_by_subgroups**
> List[Plugin] get_plugin_by_subgroups()

Get plugins group by subgroups

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.plugin import Plugin
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
    api_instance = kestra_api_client.PluginsApi(api_client)

    try:
        # Get plugins group by subgroups
        api_response = api_instance.get_plugin_by_subgroups()
        print("The response of PluginsApi->get_plugin_by_subgroups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_plugin_by_subgroups: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**List[Plugin]**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getPluginBySubgroups 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_plugin_documentation**
> DocumentationWithSchema get_plugin_documentation(cls, all)

Get plugin documentation

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.documentation_with_schema import DocumentationWithSchema
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    cls = 'cls_example' # str | The plugin full class name
    all = False # bool | Include all the properties (default to False)

    try:
        # Get plugin documentation
        api_response = api_instance.get_plugin_documentation(cls, all)
        print("The response of PluginsApi->get_plugin_documentation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_plugin_documentation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **str**| The plugin full class name | 
 **all** | **bool**| Include all the properties | [default to False]

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getPluginDocumentation 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_plugin_documentation_from_version**
> DocumentationWithSchema get_plugin_documentation_from_version(cls, version, all)

Get plugin documentation

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.documentation_with_schema import DocumentationWithSchema
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    cls = 'cls_example' # str | The plugin type
    version = 'version_example' # str | The plugin version
    all = False # bool | Include all the properties (default to False)

    try:
        # Get plugin documentation
        api_response = api_instance.get_plugin_documentation_from_version(cls, version, all)
        print("The response of PluginsApi->get_plugin_documentation_from_version:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_plugin_documentation_from_version: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **str**| The plugin type | 
 **version** | **str**| The plugin version | 
 **all** | **bool**| Include all the properties | [default to False]

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getPluginDocumentationFromVersion 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_plugin_group_icons**
> Dict[str, PluginIcon] get_plugin_group_icons()

Get plugins icons

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.plugin_icon import PluginIcon
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
    api_instance = kestra_api_client.PluginsApi(api_client)

    try:
        # Get plugins icons
        api_response = api_instance.get_plugin_group_icons()
        print("The response of PluginsApi->get_plugin_group_icons:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_plugin_group_icons: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**Dict[str, PluginIcon]**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getPluginGroupIcons 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_plugin_icons**
> Dict[str, PluginIcon] get_plugin_icons()

Get plugins icons

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.plugin_icon import PluginIcon
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
    api_instance = kestra_api_client.PluginsApi(api_client)

    try:
        # Get plugins icons
        api_response = api_instance.get_plugin_icons()
        print("The response of PluginsApi->get_plugin_icons:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_plugin_icons: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**Dict[str, PluginIcon]**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getPluginIcons 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_plugin_versions**
> PluginControllerApiPluginVersions get_plugin_versions(cls)

Get all versions for a plugin

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.plugin_controller_api_plugin_versions import PluginControllerApiPluginVersions
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    cls = 'cls_example' # str | The plugin type

    try:
        # Get all versions for a plugin
        api_response = api_instance.get_plugin_versions(cls)
        print("The response of PluginsApi->get_plugin_versions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_plugin_versions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **str**| The plugin type | 

### Return type

[**PluginControllerApiPluginVersions**](PluginControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getPluginVersions 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_properties_from_type**
> Dict[str, object] get_properties_from_type(type)

Get the properties part of the JSON schema for a type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.schema_type import SchemaType
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    type = kestra_api_client.SchemaType() # SchemaType | The schema needed

    try:
        # Get the properties part of the JSON schema for a type
        api_response = api_instance.get_properties_from_type(type)
        print("The response of PluginsApi->get_properties_from_type:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_properties_from_type: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**SchemaType**](.md)| The schema needed | 

### Return type

**Dict[str, object]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getPropertiesFromType 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_schema_from_input_type**
> DocumentationWithSchema get_schema_from_input_type(type)

Get the JSON schema for an input type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.documentation_with_schema import DocumentationWithSchema
from kestra_api_client.models.type import Type
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    type = kestra_api_client.Type() # Type | The schema needed

    try:
        # Get the JSON schema for an input type
        api_response = api_instance.get_schema_from_input_type(type)
        print("The response of PluginsApi->get_schema_from_input_type:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_schema_from_input_type: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**Type**](.md)| The schema needed | 

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getSchemaFromInputType 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_schemas_from_type**
> Dict[str, object] get_schemas_from_type(type, array_of)

Get the JSON schema for a type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.schema_type import SchemaType
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    type = kestra_api_client.SchemaType() # SchemaType | The schema needed
    array_of = False # bool | If schema should be an array of requested type (default to False)

    try:
        # Get the JSON schema for a type
        api_response = api_instance.get_schemas_from_type(type, array_of)
        print("The response of PluginsApi->get_schemas_from_type:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_schemas_from_type: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**SchemaType**](.md)| The schema needed | 
 **array_of** | **bool**| If schema should be an array of requested type | [default to False]

### Return type

**Dict[str, object]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getSchemasFromType 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_versioned_plugin_details**
> InstanceControllerApiPluginVersions get_versioned_plugin_details(group_id, artifact_id)

Retrieve details of a plugin artifact

Superadmin-only. Retrieves metadata and available versions for a given plugin artifact. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.instance_controller_api_plugin_versions import InstanceControllerApiPluginVersions
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    group_id = 'group_id_example' # str | 
    artifact_id = 'artifact_id_example' # str | 

    try:
        # Retrieve details of a plugin artifact
        api_response = api_instance.get_versioned_plugin_details(group_id, artifact_id)
        print("The response of PluginsApi->get_versioned_plugin_details:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_versioned_plugin_details: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **group_id** | **str**|  | 
 **artifact_id** | **str**|  | 

### Return type

[**InstanceControllerApiPluginVersions**](InstanceControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getVersionedPluginDetails 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_versioned_plugin_details_from_version**
> InstanceControllerApiPluginVersionDetails get_versioned_plugin_details_from_version(group_id, artifact_id, version)

Retrieve details of a specific plugin artifact version

Superadmin-only. Retrieves metadata for a specific version of a plugin artifact. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.instance_controller_api_plugin_version_details import InstanceControllerApiPluginVersionDetails
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    group_id = 'group_id_example' # str | 
    artifact_id = 'artifact_id_example' # str | 
    version = 'version_example' # str | 

    try:
        # Retrieve details of a specific plugin artifact version
        api_response = api_instance.get_versioned_plugin_details_from_version(group_id, artifact_id, version)
        print("The response of PluginsApi->get_versioned_plugin_details_from_version:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->get_versioned_plugin_details_from_version: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **group_id** | **str**|  | 
 **artifact_id** | **str**|  | 
 **version** | **str**|  | 

### Return type

[**InstanceControllerApiPluginVersionDetails**](InstanceControllerApiPluginVersionDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getVersionedPluginDetailsFromVersion 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **install_versioned_plugins**
> InstanceControllerApiPluginArtifactListPluginArtifact install_versioned_plugins(instance_controller_api_plugin_list_request)

Install specified plugin artifacts

Superadmin-only. Installs one or more plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.instance_controller_api_plugin_artifact_list_plugin_artifact import InstanceControllerApiPluginArtifactListPluginArtifact
from kestra_api_client.models.instance_controller_api_plugin_list_request import InstanceControllerApiPluginListRequest
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    instance_controller_api_plugin_list_request = kestra_api_client.InstanceControllerApiPluginListRequest() # InstanceControllerApiPluginListRequest | List of plugins

    try:
        # Install specified plugin artifacts
        api_response = api_instance.install_versioned_plugins(instance_controller_api_plugin_list_request)
        print("The response of PluginsApi->install_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->install_versioned_plugins: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instance_controller_api_plugin_list_request** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**InstanceControllerApiPluginArtifactListPluginArtifact**](InstanceControllerApiPluginArtifactListPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | installVersionedPlugins 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_available_versioned_plugins**
> object list_available_versioned_plugins()

List available plugin artifacts

Superadmin-only. Lists all plugin artifacts available for installation. Requires INFRASTRUCTURE permission.

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
    api_instance = kestra_api_client.PluginsApi(api_client)

    try:
        # List available plugin artifacts
        api_response = api_instance.list_available_versioned_plugins()
        print("The response of PluginsApi->list_available_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->list_available_versioned_plugins: %s\n" % e)
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
**200** | listAvailableVersionedPlugins 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_available_versioned_plugins_for_secret_manager**
> object list_available_versioned_plugins_for_secret_manager()

List available plugin artifacts for Kestra Secret Manager

Superadmin-only. Lists all secret managers available for installation. Requires INFRASTRUCTURE permission.

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
    api_instance = kestra_api_client.PluginsApi(api_client)

    try:
        # List available plugin artifacts for Kestra Secret Manager
        api_response = api_instance.list_available_versioned_plugins_for_secret_manager()
        print("The response of PluginsApi->list_available_versioned_plugins_for_secret_manager:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->list_available_versioned_plugins_for_secret_manager: %s\n" % e)
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
**200** | listAvailableVersionedPluginsForSecretManager 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_available_versioned_plugins_for_storage**
> object list_available_versioned_plugins_for_storage()

List available plugin artifacts for Kestra Internal Storage

Superadmin-only. Lists all internal storages available for installation. Requires INFRASTRUCTURE permission.

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
    api_instance = kestra_api_client.PluginsApi(api_client)

    try:
        # List available plugin artifacts for Kestra Internal Storage
        api_response = api_instance.list_available_versioned_plugins_for_storage()
        print("The response of PluginsApi->list_available_versioned_plugins_for_storage:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->list_available_versioned_plugins_for_storage: %s\n" % e)
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
**200** | listAvailableVersionedPluginsForStorage 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_plugins**
> List[Plugin] list_plugins()

Get list of plugins

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.plugin import Plugin
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
    api_instance = kestra_api_client.PluginsApi(api_client)

    try:
        # Get list of plugins
        api_response = api_instance.list_plugins()
        print("The response of PluginsApi->list_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->list_plugins: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**List[Plugin]**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listPlugins 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_versioned_plugin**
> PagedResultsInstanceControllerApiPluginArtifact list_versioned_plugin(page, size, sort=sort, q=q)

List installed plugin artifacts

Superadmin-only. Lists all currently installed plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.paged_results_instance_controller_api_plugin_artifact import PagedResultsInstanceControllerApiPluginArtifact
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    q = 'q_example' # str | The query (optional)

    try:
        # List installed plugin artifacts
        api_response = api_instance.list_versioned_plugin(page, size, sort=sort, q=q)
        print("The response of PluginsApi->list_versioned_plugin:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->list_versioned_plugin: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **q** | **str**| The query | [optional] 

### Return type

[**PagedResultsInstanceControllerApiPluginArtifact**](PagedResultsInstanceControllerApiPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listVersionedPlugin 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resolve_versioned_plugins**
> InstanceControllerApiPluginArtifactListPluginResolutionResult resolve_versioned_plugins(instance_controller_api_plugin_list_request)

Resolve versions for specified plugin artifacts

Superadmin-only. Resolves compatible versions for a list of plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.instance_controller_api_plugin_artifact_list_plugin_resolution_result import InstanceControllerApiPluginArtifactListPluginResolutionResult
from kestra_api_client.models.instance_controller_api_plugin_list_request import InstanceControllerApiPluginListRequest
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    instance_controller_api_plugin_list_request = kestra_api_client.InstanceControllerApiPluginListRequest() # InstanceControllerApiPluginListRequest | List of plugins

    try:
        # Resolve versions for specified plugin artifacts
        api_response = api_instance.resolve_versioned_plugins(instance_controller_api_plugin_list_request)
        print("The response of PluginsApi->resolve_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->resolve_versioned_plugins: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instance_controller_api_plugin_list_request** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**InstanceControllerApiPluginArtifactListPluginResolutionResult**](InstanceControllerApiPluginArtifactListPluginResolutionResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | resolveVersionedPlugins 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **uninstall_versioned_plugins**
> InstanceControllerApiPluginArtifactListPluginArtifact uninstall_versioned_plugins(instance_controller_api_plugin_list_request)

Uninstall plugin artifacts

Superadmin-only. Uninstalls one or more plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.instance_controller_api_plugin_artifact_list_plugin_artifact import InstanceControllerApiPluginArtifactListPluginArtifact
from kestra_api_client.models.instance_controller_api_plugin_list_request import InstanceControllerApiPluginListRequest
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    instance_controller_api_plugin_list_request = kestra_api_client.InstanceControllerApiPluginListRequest() # InstanceControllerApiPluginListRequest | List of plugins

    try:
        # Uninstall plugin artifacts
        api_response = api_instance.uninstall_versioned_plugins(instance_controller_api_plugin_list_request)
        print("The response of PluginsApi->uninstall_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->uninstall_versioned_plugins: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instance_controller_api_plugin_list_request** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**InstanceControllerApiPluginArtifactListPluginArtifact**](InstanceControllerApiPluginArtifactListPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | uninstallVersionedPlugins 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **upload_versioned_plugins**
> PluginArtifact upload_versioned_plugins(file, force_install_on_existing_versions=force_install_on_existing_versions)

Upload a plugin artifact JAR file

Superadmin-only. Uploads a plugin JAR file for installation. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestra_api_client
from kestra_api_client.models.plugin_artifact import PluginArtifact
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
    api_instance = kestra_api_client.PluginsApi(api_client)
    file = None # bytearray | 
    force_install_on_existing_versions = True # bool |  (optional)

    try:
        # Upload a plugin artifact JAR file
        api_response = api_instance.upload_versioned_plugins(file, force_install_on_existing_versions=force_install_on_existing_versions)
        print("The response of PluginsApi->upload_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PluginsApi->upload_versioned_plugins: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **bytearray**|  | 
 **force_install_on_existing_versions** | **bool**|  | [optional] 

### Return type

[**PluginArtifact**](PluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | uploadVersionedPlugins 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

