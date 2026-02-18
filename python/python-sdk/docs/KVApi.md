# kestrapy.KVApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_key_value**](KVApi.md#delete_key_value) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Delete a key-value pair
[**delete_key_values**](KVApi.md#delete_key_values) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv | Bulk-delete multiple key/value pairs from the given namespace.
[**key_value**](KVApi.md#key_value) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Get value for a key
[**list_all_keys**](KVApi.md#list_all_keys) | **GET** /api/v1/{tenant}/kv | List all keys
[**list_keys**](KVApi.md#list_keys) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv | List all keys for a namespace
[**list_keys_with_inheritence**](KVApi.md#list_keys_with_inheritence) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/inheritance | List all keys for inherited namespaces
[**set_key_value**](KVApi.md#set_key_value) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Puts a key-value pair in store


# **delete_key_value**
> bool delete_key_value(namespace, key, tenant)

Delete a key-value pair

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The namespace id
    key = 'key_example' # str | The key
    tenant = 'tenant_example' # str | 

    try:
        # Delete a key-value pair
        api_response = kestra_client.KVApi.delete_key_value(namespace, key, tenant)
        print("The response of KVApi->delete_key_value:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling KVApi->delete_key_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **key** | **str**| The key | 
 **tenant** | **str**|  | 

### Return type

**bool**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteKeyValue 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_key_values**
> KVControllerApiDeleteBulkResponse delete_key_values(namespace, tenant, kv_controller_api_delete_bulk_request)

Bulk-delete multiple key/value pairs from the given namespace.

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    kv_controller_api_delete_bulk_request = kestrapy.KVControllerApiDeleteBulkRequest() # KVControllerApiDeleteBulkRequest | The keys

    try:
        # Bulk-delete multiple key/value pairs from the given namespace.
        api_response = kestra_client.KVApi.delete_key_values(namespace, tenant, kv_controller_api_delete_bulk_request)
        print("The response of KVApi->delete_key_values:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling KVApi->delete_key_values: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 
 **kv_controller_api_delete_bulk_request** | [**KVControllerApiDeleteBulkRequest**](KVControllerApiDeleteBulkRequest.md)| The keys | 

### Return type

[**KVControllerApiDeleteBulkResponse**](KVControllerApiDeleteBulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | deleteKeyValues 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **key_value**
> KVControllerKvDetail key_value(namespace, key, tenant)

Get value for a key

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The namespace id
    key = 'key_example' # str | The key
    tenant = 'tenant_example' # str | 

    try:
        # Get value for a key
        api_response = kestra_client.KVApi.key_value(namespace, key, tenant)
        print("The response of KVApi->key_value:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling KVApi->key_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **key** | **str**| The key | 
 **tenant** | **str**|  | 

### Return type

[**KVControllerKvDetail**](KVControllerKvDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getKeyValue 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_all_keys**
> PagedResultsKVEntry list_all_keys(page, size, tenant, sort=sort, filters=filters)

List all keys

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters (optional)

    try:
        # List all keys
        api_response = kestra_client.KVApi.list_all_keys(page, size, tenant, sort=sort, filters=filters)
        print("The response of KVApi->list_all_keys:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling KVApi->list_all_keys: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**PagedResultsKVEntry**](PagedResultsKVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listAllKeys 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_keys**
> List[KVEntry] list_keys(namespace, tenant)

List all keys for a namespace

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List all keys for a namespace
        api_response = kestra_client.KVApi.list_keys(namespace, tenant)
        print("The response of KVApi->list_keys:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling KVApi->list_keys: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 

### Return type

[**List[KVEntry]**](KVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listKeys 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_keys_with_inheritence**
> List[KVEntry] list_keys_with_inheritence(namespace, tenant)

List all keys for inherited namespaces

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List all keys for inherited namespaces
        api_response = kestra_client.KVApi.list_keys_with_inheritence(namespace, tenant)
        print("The response of KVApi->list_keys_with_inheritence:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling KVApi->list_keys_with_inheritence: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 

### Return type

[**List[KVEntry]**](KVEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listKeysWithInheritence 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_key_value**
> set_key_value(namespace, key, tenant, body)

Puts a key-value pair in store

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The namespace id
    key = 'key_example' # str | The key
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The value of the key

    try:
        # Puts a key-value pair in store
        kestra_client.KVApi.set_key_value(namespace, key, tenant, body)
    except Exception as e:
        print("Exception when calling KVApi->set_key_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **key** | **str**| The key | 
 **tenant** | **str**|  | 
 **body** | **str**| The value of the key | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setKeyValue 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

