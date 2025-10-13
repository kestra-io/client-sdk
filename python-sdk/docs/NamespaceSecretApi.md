# kestrapy.NamespaceSecretApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_secret**](NamespaceSecretApi.md#delete_secret) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/secrets/{key} | Delete a secret for a namespace
[**get_inherited_secrets**](NamespaceSecretApi.md#get_inherited_secrets) | **GET** /api/v1/{tenant}/namespaces/{namespace}/inherited-secrets | List inherited secrets
[**list_namespace_secrets**](NamespaceSecretApi.md#list_namespace_secrets) | **GET** /api/v1/{tenant}/namespaces/{namespace}/secrets | Get secrets for a namespace
[**patch_secret**](NamespaceSecretApi.md#patch_secret) | **PATCH** /api/v1/{tenant}/namespaces/{namespace}/secrets/{key} | Patch a secret metadata for a namespace
[**put_secrets**](NamespaceSecretApi.md#put_secrets) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/secrets | Update secrets for a namespace


# **delete_secret**
> List[str] delete_secret(namespace, key, tenant)

Delete a secret for a namespace

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
    api_instance = kestrapy.NamespaceSecretApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    key = 'key_example' # str | The secret key
    tenant = 'tenant_example' # str | 

    try:
        # Delete a secret for a namespace
        api_response = api_instance.delete_secret(namespace, key, tenant)
        print("The response of NamespaceSecretApi->delete_secret:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceSecretApi->delete_secret: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **key** | **str**| The secret key | 
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
**200** | deleteSecret 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_inherited_secrets**
> Dict[str, List[str]] get_inherited_secrets(namespace, tenant)

List inherited secrets

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
    api_instance = kestrapy.NamespaceSecretApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List inherited secrets
        api_response = api_instance.get_inherited_secrets(namespace, tenant)
        print("The response of NamespaceSecretApi->get_inherited_secrets:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceSecretApi->get_inherited_secrets: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 

### Return type

**Dict[str, List[str]]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getInheritedSecrets 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_namespace_secrets**
> ApiSecretListResponse list_namespace_secrets(namespace, page, size, filters, tenant, sort=sort)

Get secrets for a namespace

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.api_secret_list_response import ApiSecretListResponse
from kestrapy.models.query_filter import QueryFilter
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
    api_instance = kestrapy.NamespaceSecretApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Get secrets for a namespace
        api_response = api_instance.list_namespace_secrets(namespace, page, size, filters, tenant, sort=sort)
        print("The response of NamespaceSecretApi->list_namespace_secrets:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceSecretApi->list_namespace_secrets: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **filters** | [**List[QueryFilter]**](QueryFilter.md)| Filters | 
 **tenant** | **str**|  | 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

### Return type

[**ApiSecretListResponse**](ApiSecretListResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listNamespaceSecrets 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_secret**
> List[ApiSecretMeta] patch_secret(namespace, tenant, key, api_secret_meta_ee)

Patch a secret metadata for a namespace

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.api_secret_meta import ApiSecretMeta
from kestrapy.models.api_secret_meta_ee import ApiSecretMetaEE
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
    api_instance = kestrapy.NamespaceSecretApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    key = 'key_example' # str | 
    api_secret_meta_ee = kestrapy.ApiSecretMetaEE() # ApiSecretMetaEE | 

    try:
        # Patch a secret metadata for a namespace
        api_response = api_instance.patch_secret(namespace, tenant, key, api_secret_meta_ee)
        print("The response of NamespaceSecretApi->patch_secret:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceSecretApi->patch_secret: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 
 **key** | **str**|  | 
 **api_secret_meta_ee** | [**ApiSecretMetaEE**](ApiSecretMetaEE.md)|  | 

### Return type

[**List[ApiSecretMeta]**](ApiSecretMeta.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | patchSecret 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_secrets**
> List[ApiSecretMeta] put_secrets(namespace, tenant, api_secret_value)

Update secrets for a namespace

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.api_secret_meta import ApiSecretMeta
from kestrapy.models.api_secret_value import ApiSecretValue
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
    api_instance = kestrapy.NamespaceSecretApi(api_client)
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    api_secret_value = kestrapy.ApiSecretValue() # ApiSecretValue | 

    try:
        # Update secrets for a namespace
        api_response = api_instance.put_secrets(namespace, tenant, api_secret_value)
        print("The response of NamespaceSecretApi->put_secrets:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling NamespaceSecretApi->put_secrets: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **tenant** | **str**|  | 
 **api_secret_value** | [**ApiSecretValue**](ApiSecretValue.md)|  | 

### Return type

[**List[ApiSecretMeta]**](ApiSecretMeta.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | putSecrets 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

