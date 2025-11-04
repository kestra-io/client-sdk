# kestrapy.kv

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_key_value**](kv.md#delete_key_value) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Delete a key-value pair
[**delete_key_values**](kv.md#delete_key_values) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv | Bulk-delete multiple key/value pairs from the given namespace.
[**key_value**](kv.md#key_value) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Get value for a key
[**list_keys**](kv.md#list_keys) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv | List all keys for a namespace
[**list_keys_with_inheritence**](kv.md#list_keys_with_inheritence) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/inheritance | List all keys for inherited namespaces
[**set_key_value**](kv.md#set_key_value) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Puts a key-value pair in store


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
        api_response = kestra_client.kv.delete_key_value(namespace, key, tenant)
        print("The response of kv->delete_key_value:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling kv->delete_key_value: %s\n" % e)
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
        api_response = kestra_client.kv.delete_key_values(namespace, tenant, kv_controller_api_delete_bulk_request)
        print("The response of kv->delete_key_values:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling kv->delete_key_values: %s\n" % e)
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
> KVControllerTypedValue key_value(namespace, key, tenant)

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
        api_response = kestra_client.kv.key_value(namespace, key, tenant)
        print("The response of kv->key_value:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling kv->key_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **key** | **str**| The key | 
 **tenant** | **str**|  | 

### Return type

[**KVControllerTypedValue**](KVControllerTypedValue.md)

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
        api_response = kestra_client.kv.list_keys(namespace, tenant)
        print("The response of kv->list_keys:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling kv->list_keys: %s\n" % e)
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
        api_response = kestra_client.kv.list_keys_with_inheritence(namespace, tenant)
        print("The response of kv->list_keys_with_inheritence:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling kv->list_keys_with_inheritence: %s\n" % e)
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
        kestra_client.kv.set_key_value(namespace, key, tenant, body)
    except Exception as e:
        print("Exception when calling kv->set_key_value: %s\n" % e)
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

