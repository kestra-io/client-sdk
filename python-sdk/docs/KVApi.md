# kestrapy.KVApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_key_value**](KVApi.md#delete_key_value) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Delete a key-value pair
[**delete_key_values**](KVApi.md#delete_key_values) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/kv | Bulk-delete multiple key/value pairs from the given namespace.
[**get_key_value**](KVApi.md#get_key_value) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Get value for a key
[**list_keys**](KVApi.md#list_keys) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv | List all keys for a namespace
[**list_keys_with_inheritence**](KVApi.md#list_keys_with_inheritence) | **GET** /api/v1/{tenant}/namespaces/{namespace}/kv/inheritance | List all keys for inherited namespaces
[**set_key_value**](KVApi.md#set_key_value) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/kv/{key} | Puts a key-value pair in store


# **delete_key_value**
> bool delete_key_value(namespace, key, tenant)

Delete a key-value pair

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    namespace = 'namespace_example' # str | The namespace id
    key = 'key_example' # str | The key
    tenant = 'tenant_example' # str | 

    try:
        # Delete a key-value pair
        api_response = api_client.delete_key_value(namespace, key, tenant)
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


```python
import kestrapy
from kestrapy.models.kv_controller_api_delete_bulk_request import KVControllerApiDeleteBulkRequest
from kestrapy.models.kv_controller_api_delete_bulk_response import KVControllerApiDeleteBulkResponse
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    kv_controller_api_delete_bulk_request = kestrapy.KVControllerApiDeleteBulkRequest() # KVControllerApiDeleteBulkRequest | The keys

    try:
        # Bulk-delete multiple key/value pairs from the given namespace.
        api_response = api_client.delete_key_values(namespace, tenant, kv_controller_api_delete_bulk_request)
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

# **get_key_value**
> KVControllerTypedValue get_key_value(namespace, key, tenant)

Get value for a key

### Example


```python
import kestrapy
from kestrapy.models.kv_controller_typed_value import KVControllerTypedValue
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    namespace = 'namespace_example' # str | The namespace id
    key = 'key_example' # str | The key
    tenant = 'tenant_example' # str | 

    try:
        # Get value for a key
        api_response = api_client.get_key_value(namespace, key, tenant)
        print("The response of KVApi->get_key_value:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling KVApi->get_key_value: %s\n" % e)
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


```python
import kestrapy
from kestrapy.models.kv_entry import KVEntry
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List all keys for a namespace
        api_response = api_client.list_keys(namespace, tenant)
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


```python
import kestrapy
from kestrapy.models.kv_entry import KVEntry
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List all keys for inherited namespaces
        api_response = api_client.list_keys_with_inheritence(namespace, tenant)
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


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    namespace = 'namespace_example' # str | The namespace id
    key = 'key_example' # str | The key
    tenant = 'tenant_example' # str | 
    body = 'body_example' # str | The value of the key

    try:
        # Puts a key-value pair in store
        api_client.set_key_value(namespace, key, tenant, body)
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

 - **Content-Type**: application/json, text/plain
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | setKeyValue 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

