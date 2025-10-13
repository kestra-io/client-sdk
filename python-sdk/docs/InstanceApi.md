# kestrapy.InstanceApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_worker_group**](InstanceApi.md#create_worker_group) | **POST** /api/v1/instance/workergroups | Create a worker group
[**delete_worker_group_by_id**](InstanceApi.md#delete_worker_group_by_id) | **DELETE** /api/v1/instance/workergroups/{id} | Delete a worker group
[**enter_maintenance**](InstanceApi.md#enter_maintenance) | **POST** /api/v1/instance/maintenance/enter | Enter cluster maintenance mode
[**exit_maintenance**](InstanceApi.md#exit_maintenance) | **POST** /api/v1/instance/maintenance/exit | Exit cluster maintenance mode
[**get_active_services**](InstanceApi.md#get_active_services) | **GET** /api/v1/instance/services/active | List all active services
[**get_service**](InstanceApi.md#get_service) | **GET** /api/v1/instance/services/{id} | Retrieve details of a specific service
[**get_versioned_plugin_details**](InstanceApi.md#get_versioned_plugin_details) | **GET** /api/v1/instance/versioned-plugins/{groupId}/{artifactId} | Retrieve details of a plugin artifact
[**get_versioned_plugin_details_from_version**](InstanceApi.md#get_versioned_plugin_details_from_version) | **GET** /api/v1/instance/versioned-plugins/{groupId}/{artifactId}/{version} | Retrieve details of a specific plugin artifact version
[**get_worker_group_by_id**](InstanceApi.md#get_worker_group_by_id) | **GET** /api/v1/instance/workergroups/{id} | Retrieve details of a specific worker group
[**install_versioned_plugins**](InstanceApi.md#install_versioned_plugins) | **POST** /api/v1/instance/versioned-plugins/install | Install specified plugin artifacts
[**list_available_versioned_plugins**](InstanceApi.md#list_available_versioned_plugins) | **GET** /api/v1/instance/versioned-plugins/available | List available plugin artifacts
[**list_available_versioned_plugins_for_secret_manager**](InstanceApi.md#list_available_versioned_plugins_for_secret_manager) | **GET** /api/v1/instance/versioned-plugins/available/secrets-managers | List available plugin artifacts for Kestra Secret Manager
[**list_available_versioned_plugins_for_storage**](InstanceApi.md#list_available_versioned_plugins_for_storage) | **GET** /api/v1/instance/versioned-plugins/available/storages | List available plugin artifacts for Kestra Internal Storage
[**list_versioned_plugin**](InstanceApi.md#list_versioned_plugin) | **GET** /api/v1/instance/versioned-plugins | List installed plugin artifacts
[**list_worker_groups**](InstanceApi.md#list_worker_groups) | **GET** /api/v1/instance/workergroups | List all worker groups
[**resolve_versioned_plugins**](InstanceApi.md#resolve_versioned_plugins) | **POST** /api/v1/instance/versioned-plugins/resolve | Resolve versions for specified plugin artifacts
[**search_services**](InstanceApi.md#search_services) | **GET** /api/v1/instance/services/search | Search for a service (e.g. Worker, Executor, etc)
[**uninstall_versioned_plugins**](InstanceApi.md#uninstall_versioned_plugins) | **DELETE** /api/v1/instance/versioned-plugins/uninstall | Uninstall plugin artifacts
[**update_worker_group_by_id**](InstanceApi.md#update_worker_group_by_id) | **PUT** /api/v1/instance/workergroups/{id} | Update a worker group
[**upload_versioned_plugins**](InstanceApi.md#upload_versioned_plugins) | **POST** /api/v1/instance/versioned-plugins/upload | Upload a plugin artifact JAR file


# **create_worker_group**
> InstanceControllerApiWorkerGroup create_worker_group(instance_controller_api_create_or_update_worker_group_request)

Create a worker group

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_create_or_update_worker_group_request import InstanceControllerApiCreateOrUpdateWorkerGroupRequest
from kestrapy.models.instance_controller_api_worker_group import InstanceControllerApiWorkerGroup
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
    api_instance = kestrapy.InstanceApi(api_client)
    instance_controller_api_create_or_update_worker_group_request = kestrapy.InstanceControllerApiCreateOrUpdateWorkerGroupRequest() # InstanceControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition

    try:
        # Create a worker group
        api_response = api_instance.create_worker_group(instance_controller_api_create_or_update_worker_group_request)
        print("The response of InstanceApi->create_worker_group:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->create_worker_group: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instance_controller_api_create_or_update_worker_group_request** | [**InstanceControllerApiCreateOrUpdateWorkerGroupRequest**](InstanceControllerApiCreateOrUpdateWorkerGroupRequest.md)| The worker group definition | 

### Return type

[**InstanceControllerApiWorkerGroup**](InstanceControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createWorkerGroup 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_worker_group_by_id**
> object delete_worker_group_by_id(id)

Delete a worker group

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

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
    api_instance = kestrapy.InstanceApi(api_client)
    id = 'id_example' # str | 

    try:
        # Delete a worker group
        api_response = api_instance.delete_worker_group_by_id(id)
        print("The response of InstanceApi->delete_worker_group_by_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->delete_worker_group_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 

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
**200** | deleteWorkerGroupById 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **enter_maintenance**
> object enter_maintenance()

Enter cluster maintenance mode

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

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
    api_instance = kestrapy.InstanceApi(api_client)

    try:
        # Enter cluster maintenance mode
        api_response = api_instance.enter_maintenance()
        print("The response of InstanceApi->enter_maintenance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->enter_maintenance: %s\n" % e)
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
    api_instance = kestrapy.InstanceApi(api_client)

    try:
        # Exit cluster maintenance mode
        api_response = api_instance.exit_maintenance()
        print("The response of InstanceApi->exit_maintenance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->exit_maintenance: %s\n" % e)
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

# **get_active_services**
> InstanceControllerApiActiveServiceList get_active_services()

List all active services

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_active_service_list import InstanceControllerApiActiveServiceList
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
    api_instance = kestrapy.InstanceApi(api_client)

    try:
        # List all active services
        api_response = api_instance.get_active_services()
        print("The response of InstanceApi->get_active_services:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->get_active_services: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**InstanceControllerApiActiveServiceList**](InstanceControllerApiActiveServiceList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getActiveServices 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_service**
> ServiceInstance get_service(id)

Retrieve details of a specific service

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.service_instance import ServiceInstance
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
    api_instance = kestrapy.InstanceApi(api_client)
    id = 'id_example' # str | 

    try:
        # Retrieve details of a specific service
        api_response = api_instance.get_service(id)
        print("The response of InstanceApi->get_service:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->get_service: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 

### Return type

[**ServiceInstance**](ServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getService 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_versioned_plugin_details**
> InstanceControllerApiPluginVersions get_versioned_plugin_details(group_id, artifact_id)

Retrieve details of a plugin artifact

Superadmin-only. Retrieves metadata and available versions for a given plugin artifact. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_plugin_versions import InstanceControllerApiPluginVersions
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
    api_instance = kestrapy.InstanceApi(api_client)
    group_id = 'group_id_example' # str | 
    artifact_id = 'artifact_id_example' # str | 

    try:
        # Retrieve details of a plugin artifact
        api_response = api_instance.get_versioned_plugin_details(group_id, artifact_id)
        print("The response of InstanceApi->get_versioned_plugin_details:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->get_versioned_plugin_details: %s\n" % e)
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
import kestrapy
from kestrapy.models.instance_controller_api_plugin_version_details import InstanceControllerApiPluginVersionDetails
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
    api_instance = kestrapy.InstanceApi(api_client)
    group_id = 'group_id_example' # str | 
    artifact_id = 'artifact_id_example' # str | 
    version = 'version_example' # str | 

    try:
        # Retrieve details of a specific plugin artifact version
        api_response = api_instance.get_versioned_plugin_details_from_version(group_id, artifact_id, version)
        print("The response of InstanceApi->get_versioned_plugin_details_from_version:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->get_versioned_plugin_details_from_version: %s\n" % e)
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

# **get_worker_group_by_id**
> InstanceControllerApiWorkerGroupDetails get_worker_group_by_id(id)

Retrieve details of a specific worker group

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_worker_group_details import InstanceControllerApiWorkerGroupDetails
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
    api_instance = kestrapy.InstanceApi(api_client)
    id = 'id_example' # str | 

    try:
        # Retrieve details of a specific worker group
        api_response = api_instance.get_worker_group_by_id(id)
        print("The response of InstanceApi->get_worker_group_by_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->get_worker_group_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 

### Return type

[**InstanceControllerApiWorkerGroupDetails**](InstanceControllerApiWorkerGroupDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getWorkerGroupById 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **install_versioned_plugins**
> InstanceControllerApiPluginArtifactListPluginArtifact install_versioned_plugins(instance_controller_api_plugin_list_request)

Install specified plugin artifacts

Superadmin-only. Installs one or more plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_plugin_artifact_list_plugin_artifact import InstanceControllerApiPluginArtifactListPluginArtifact
from kestrapy.models.instance_controller_api_plugin_list_request import InstanceControllerApiPluginListRequest
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
    api_instance = kestrapy.InstanceApi(api_client)
    instance_controller_api_plugin_list_request = kestrapy.InstanceControllerApiPluginListRequest() # InstanceControllerApiPluginListRequest | List of plugins

    try:
        # Install specified plugin artifacts
        api_response = api_instance.install_versioned_plugins(instance_controller_api_plugin_list_request)
        print("The response of InstanceApi->install_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->install_versioned_plugins: %s\n" % e)
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
    api_instance = kestrapy.InstanceApi(api_client)

    try:
        # List available plugin artifacts
        api_response = api_instance.list_available_versioned_plugins()
        print("The response of InstanceApi->list_available_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->list_available_versioned_plugins: %s\n" % e)
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
    api_instance = kestrapy.InstanceApi(api_client)

    try:
        # List available plugin artifacts for Kestra Secret Manager
        api_response = api_instance.list_available_versioned_plugins_for_secret_manager()
        print("The response of InstanceApi->list_available_versioned_plugins_for_secret_manager:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->list_available_versioned_plugins_for_secret_manager: %s\n" % e)
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
    api_instance = kestrapy.InstanceApi(api_client)

    try:
        # List available plugin artifacts for Kestra Internal Storage
        api_response = api_instance.list_available_versioned_plugins_for_storage()
        print("The response of InstanceApi->list_available_versioned_plugins_for_storage:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->list_available_versioned_plugins_for_storage: %s\n" % e)
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

# **list_versioned_plugin**
> PagedResultsInstanceControllerApiPluginArtifact list_versioned_plugin(page, size, sort=sort, q=q)

List installed plugin artifacts

Superadmin-only. Lists all currently installed plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_instance_controller_api_plugin_artifact import PagedResultsInstanceControllerApiPluginArtifact
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
    api_instance = kestrapy.InstanceApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    q = 'q_example' # str | The query (optional)

    try:
        # List installed plugin artifacts
        api_response = api_instance.list_versioned_plugin(page, size, sort=sort, q=q)
        print("The response of InstanceApi->list_versioned_plugin:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->list_versioned_plugin: %s\n" % e)
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

# **list_worker_groups**
> InstanceControllerApiWorkerGroupList list_worker_groups()

List all worker groups

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_worker_group_list import InstanceControllerApiWorkerGroupList
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
    api_instance = kestrapy.InstanceApi(api_client)

    try:
        # List all worker groups
        api_response = api_instance.list_worker_groups()
        print("The response of InstanceApi->list_worker_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->list_worker_groups: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**InstanceControllerApiWorkerGroupList**](InstanceControllerApiWorkerGroupList.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listWorkerGroups 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resolve_versioned_plugins**
> InstanceControllerApiPluginArtifactListPluginResolutionResult resolve_versioned_plugins(instance_controller_api_plugin_list_request)

Resolve versions for specified plugin artifacts

Superadmin-only. Resolves compatible versions for a list of plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_plugin_artifact_list_plugin_resolution_result import InstanceControllerApiPluginArtifactListPluginResolutionResult
from kestrapy.models.instance_controller_api_plugin_list_request import InstanceControllerApiPluginListRequest
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
    api_instance = kestrapy.InstanceApi(api_client)
    instance_controller_api_plugin_list_request = kestrapy.InstanceControllerApiPluginListRequest() # InstanceControllerApiPluginListRequest | List of plugins

    try:
        # Resolve versions for specified plugin artifacts
        api_response = api_instance.resolve_versioned_plugins(instance_controller_api_plugin_list_request)
        print("The response of InstanceApi->resolve_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->resolve_versioned_plugins: %s\n" % e)
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

# **search_services**
> PagedResultsInstanceControllerApiServiceInstance search_services(page, size, sort=sort, state=state, type=type)

Search for a service (e.g. Worker, Executor, etc)

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.paged_results_instance_controller_api_service_instance import PagedResultsInstanceControllerApiServiceInstance
from kestrapy.models.service_service_state import ServiceServiceState
from kestrapy.models.service_type import ServiceType
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
    api_instance = kestrapy.InstanceApi(api_client)
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    state = [kestrapy.ServiceServiceState()] # List[ServiceServiceState] | The state filter (optional)
    type = [kestrapy.ServiceType()] # List[ServiceType] | The server type filter (optional)

    try:
        # Search for a service (e.g. Worker, Executor, etc)
        api_response = api_instance.search_services(page, size, sort=sort, state=state, type=type)
        print("The response of InstanceApi->search_services:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->search_services: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **state** | [**List[ServiceServiceState]**](ServiceServiceState.md)| The state filter | [optional] 
 **type** | [**List[ServiceType]**](ServiceType.md)| The server type filter | [optional] 

### Return type

[**PagedResultsInstanceControllerApiServiceInstance**](PagedResultsInstanceControllerApiServiceInstance.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchServices 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **uninstall_versioned_plugins**
> InstanceControllerApiPluginArtifactListPluginArtifact uninstall_versioned_plugins(instance_controller_api_plugin_list_request)

Uninstall plugin artifacts

Superadmin-only. Uninstalls one or more plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_plugin_artifact_list_plugin_artifact import InstanceControllerApiPluginArtifactListPluginArtifact
from kestrapy.models.instance_controller_api_plugin_list_request import InstanceControllerApiPluginListRequest
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
    api_instance = kestrapy.InstanceApi(api_client)
    instance_controller_api_plugin_list_request = kestrapy.InstanceControllerApiPluginListRequest() # InstanceControllerApiPluginListRequest | List of plugins

    try:
        # Uninstall plugin artifacts
        api_response = api_instance.uninstall_versioned_plugins(instance_controller_api_plugin_list_request)
        print("The response of InstanceApi->uninstall_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->uninstall_versioned_plugins: %s\n" % e)
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

# **update_worker_group_by_id**
> InstanceControllerApiWorkerGroup update_worker_group_by_id(id, instance_controller_api_create_or_update_worker_group_request)

Update a worker group

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.instance_controller_api_create_or_update_worker_group_request import InstanceControllerApiCreateOrUpdateWorkerGroupRequest
from kestrapy.models.instance_controller_api_worker_group import InstanceControllerApiWorkerGroup
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
    api_instance = kestrapy.InstanceApi(api_client)
    id = 'id_example' # str | 
    instance_controller_api_create_or_update_worker_group_request = kestrapy.InstanceControllerApiCreateOrUpdateWorkerGroupRequest() # InstanceControllerApiCreateOrUpdateWorkerGroupRequest | The worker group definition

    try:
        # Update a worker group
        api_response = api_instance.update_worker_group_by_id(id, instance_controller_api_create_or_update_worker_group_request)
        print("The response of InstanceApi->update_worker_group_by_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->update_worker_group_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 
 **instance_controller_api_create_or_update_worker_group_request** | [**InstanceControllerApiCreateOrUpdateWorkerGroupRequest**](InstanceControllerApiCreateOrUpdateWorkerGroupRequest.md)| The worker group definition | 

### Return type

[**InstanceControllerApiWorkerGroup**](InstanceControllerApiWorkerGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateWorkerGroupById 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **upload_versioned_plugins**
> PluginArtifact upload_versioned_plugins(file, force_install_on_existing_versions=force_install_on_existing_versions)

Upload a plugin artifact JAR file

Superadmin-only. Uploads a plugin JAR file for installation. Requires INFRASTRUCTURE permission.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.plugin_artifact import PluginArtifact
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
    api_instance = kestrapy.InstanceApi(api_client)
    file = None # bytearray | 
    force_install_on_existing_versions = True # bool |  (optional)

    try:
        # Upload a plugin artifact JAR file
        api_response = api_instance.upload_versioned_plugins(file, force_install_on_existing_versions=force_install_on_existing_versions)
        print("The response of InstanceApi->upload_versioned_plugins:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling InstanceApi->upload_versioned_plugins: %s\n" % e)
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

