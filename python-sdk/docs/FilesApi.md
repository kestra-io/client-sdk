# kestrapy.FilesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_namespace_directory**](FilesApi.md#create_namespace_directory) | **POST** /api/v1/{tenant}/namespaces/{namespace}/files/directory | Create a directory
[**create_namespace_file**](FilesApi.md#create_namespace_file) | **POST** /api/v1/{tenant}/namespaces/{namespace}/files | Create a file
[**delete_file_directory**](FilesApi.md#delete_file_directory) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/files | Delete a file or directory
[**export_namespace_files**](FilesApi.md#export_namespace_files) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/export | Export namespace files as a ZIP
[**get_file_content**](FilesApi.md#get_file_content) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files | Get namespace file content
[**get_file_metadatas**](FilesApi.md#get_file_metadatas) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/stats | Get namespace file stats such as size, creation &amp; modification dates and type
[**list_namespace_directory_files**](FilesApi.md#list_namespace_directory_files) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/directory | List directory content
[**move_file_directory**](FilesApi.md#move_file_directory) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/files | Move a file or directory
[**search_namespace_files**](FilesApi.md#search_namespace_files) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/search | Find files which path contain the given string in their URI


# **create_namespace_directory**
> create_namespace_directory(namespace, tenant, path=path)

Create a directory

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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    path = 'path_example' # str | The internal storage uri (optional)

    try:
        # Create a directory
        api_instance.create_namespace_directory(namespace, tenant, path=path)
    except Exception as e:
        print("Exception when calling FilesApi->create_namespace_directory: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 
 **path** | **str**| The internal storage uri | [optional] 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createNamespaceDirectory 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_namespace_file**
> create_namespace_file(namespace, path, tenant, file_content=file_content)

Create a file

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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    path = 'path_example' # str | The internal storage uri
    tenant = 'tenant_example' # str | 
    file_content = None # bytearray | The file to upload (optional)

    try:
        # Create a file
        api_instance.create_namespace_file(namespace, path, tenant, file_content=file_content)
    except Exception as e:
        print("Exception when calling FilesApi->create_namespace_file: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **path** | **str**| The internal storage uri | 
 **tenant** | **str**|  | 
 **file_content** | **bytearray**| The file to upload | [optional] 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createNamespaceFile 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_file_directory**
> delete_file_directory(namespace, path, tenant)

Delete a file or directory

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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    path = 'path_example' # str | The internal storage uri of the file / directory to delete
    tenant = 'tenant_example' # str | 

    try:
        # Delete a file or directory
        api_instance.delete_file_directory(namespace, path, tenant)
    except Exception as e:
        print("Exception when calling FilesApi->delete_file_directory: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **path** | **str**| The internal storage uri of the file / directory to delete | 
 **tenant** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteFileDirectory 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export_namespace_files**
> bytearray export_namespace_files(namespace, tenant)

Export namespace files as a ZIP

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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # Export namespace files as a ZIP
        api_response = api_instance.export_namespace_files(namespace, tenant)
        print("The response of FilesApi->export_namespace_files:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FilesApi->export_namespace_files: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 

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
**200** | exportNamespaceFiles 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_file_content**
> bytearray get_file_content(namespace, path, tenant)

Get namespace file content

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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    path = 'path_example' # str | The internal storage uri
    tenant = 'tenant_example' # str | 

    try:
        # Get namespace file content
        api_response = api_instance.get_file_content(namespace, path, tenant)
        print("The response of FilesApi->get_file_content:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FilesApi->get_file_content: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **path** | **str**| The internal storage uri | 
 **tenant** | **str**|  | 

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
**200** | getFileContent 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_file_metadatas**
> FileAttributes get_file_metadatas(namespace, tenant, path=path)

Get namespace file stats such as size, creation & modification dates and type

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.file_attributes import FileAttributes
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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    path = 'path_example' # str | The internal storage uri (optional)

    try:
        # Get namespace file stats such as size, creation & modification dates and type
        api_response = api_instance.get_file_metadatas(namespace, tenant, path=path)
        print("The response of FilesApi->get_file_metadatas:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FilesApi->get_file_metadatas: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 
 **path** | **str**| The internal storage uri | [optional] 

### Return type

[**FileAttributes**](FileAttributes.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getFileMetadatas 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_namespace_directory_files**
> List[FileAttributes] list_namespace_directory_files(namespace, tenant, path=path)

List directory content

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.file_attributes import FileAttributes
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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    path = 'path_example' # str | The internal storage uri (optional)

    try:
        # List directory content
        api_response = api_instance.list_namespace_directory_files(namespace, tenant, path=path)
        print("The response of FilesApi->list_namespace_directory_files:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FilesApi->list_namespace_directory_files: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 
 **path** | **str**| The internal storage uri | [optional] 

### Return type

[**List[FileAttributes]**](FileAttributes.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listNamespaceDirectoryFiles 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **move_file_directory**
> move_file_directory(namespace, var_from, to, tenant)

Move a file or directory

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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    var_from = 'var_from_example' # str | The internal storage uri to move from
    to = 'to_example' # str | The internal storage uri to move to
    tenant = 'tenant_example' # str | 

    try:
        # Move a file or directory
        api_instance.move_file_directory(namespace, var_from, to, tenant)
    except Exception as e:
        print("Exception when calling FilesApi->move_file_directory: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **var_from** | **str**| The internal storage uri to move from | 
 **to** | **str**| The internal storage uri to move to | 
 **tenant** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | moveFileDirectory 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_namespace_files**
> List[str] search_namespace_files(namespace, q, tenant)

Find files which path contain the given string in their URI

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
    api_instance = kestrapy.FilesApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    q = 'q_example' # str | The string the file path should contain
    tenant = 'tenant_example' # str | 

    try:
        # Find files which path contain the given string in their URI
        api_response = api_instance.search_namespace_files(namespace, q, tenant)
        print("The response of FilesApi->search_namespace_files:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FilesApi->search_namespace_files: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **q** | **str**| The string the file path should contain | 
 **tenant** | **str**|  | 

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
**200** | searchNamespaceFiles 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

