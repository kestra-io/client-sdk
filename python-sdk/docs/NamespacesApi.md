# kestrapy.namespaces

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocomplete_namespaces**](namespaces.md#autocomplete_namespaces) | **POST** /api/v1/{tenant}/namespaces/autocomplete | List namespaces for autocomplete
[**create_namespace**](namespaces.md#create_namespace) | **POST** /api/v1/{tenant}/namespaces | Create a namespace
[**delete_namespace**](namespaces.md#delete_namespace) | **DELETE** /api/v1/{tenant}/namespaces/{id} | Delete a namespace
[**delete_secret**](namespaces.md#delete_secret) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/secrets/{key} | Delete a secret for a namespace
[**get_inherited_secrets**](namespaces.md#get_inherited_secrets) | **GET** /api/v1/{tenant}/namespaces/{namespace}/inherited-secrets | List inherited secrets
[**get_namespace**](namespaces.md#get_namespace) | **GET** /api/v1/{tenant}/namespaces/{id} | Get a namespace
[**inherited_plugin_defaults**](namespaces.md#inherited_plugin_defaults) | **GET** /api/v1/{tenant}/namespaces/{id}/inherited-plugindefaults | List inherited plugin defaults
[**inherited_variables**](namespaces.md#inherited_variables) | **GET** /api/v1/{tenant}/namespaces/{id}/inherited-variables | List inherited variables
[**list_namespace_secrets**](namespaces.md#list_namespace_secrets) | **GET** /api/v1/{tenant}/namespaces/{namespace}/secrets | Get secrets for a namespace
[**patch_secret**](namespaces.md#patch_secret) | **PATCH** /api/v1/{tenant}/namespaces/{namespace}/secrets/{key} | Patch a secret metadata for a namespace
[**put_secrets**](namespaces.md#put_secrets) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/secrets | Update secrets for a namespace
[**search_namespaces**](namespaces.md#search_namespaces) | **GET** /api/v1/{tenant}/namespaces/search | Search for namespaces
[**update_namespace**](namespaces.md#update_namespace) | **PUT** /api/v1/{tenant}/namespaces/{id} | Update a namespace


# **autocomplete_namespaces**
> List[str] autocomplete_namespaces(tenant, api_autocomplete)

List namespaces for autocomplete

Returns a list of namespaces for use in autocomplete fields, optionally allowing to filter by query and ids. Used especially for binding creation.

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
    tenant = 'tenant_example' # str | 
    api_autocomplete = kestrapy.ApiAutocomplete() # ApiAutocomplete | 

    try:
        # List namespaces for autocomplete
        api_response = kestra_client.namespaces.autocomplete_namespaces(tenant, api_autocomplete)
        print("The response of namespaces->autocomplete_namespaces:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->autocomplete_namespaces: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **api_autocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)|  | 

### Return type

**List[str]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | autocompleteNamespaces 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_namespace**
> Namespace create_namespace(tenant, namespace)

Create a namespace

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
    tenant = 'tenant_example' # str | 
    namespace = kestrapy.Namespace() # Namespace | The namespace

    try:
        # Create a namespace
        api_response = kestra_client.namespaces.create_namespace(tenant, namespace)
        print("The response of namespaces->create_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->create_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **namespace** | [**Namespace**](Namespace.md)| The namespace | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | createNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_namespace**
> delete_namespace(id, tenant)

Delete a namespace

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
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a namespace
        kestra_client.namespaces.delete_namespace(id, tenant)
    except Exception as e:
        print("Exception when calling namespaces->delete_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
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
**204** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_secret**
> delete_secret(namespace, key, tenant)

Delete a secret for a namespace

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
    key = 'key_example' # str | The secret key
    tenant = 'tenant_example' # str | 

    try:
        # Delete a secret for a namespace
        kestra_client.namespaces.delete_secret(namespace, key, tenant)
    except Exception as e:
        print("Exception when calling namespaces->delete_secret: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **key** | **str**| The secret key | 
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
**200** | deleteSecret 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_inherited_secrets**
> Dict[str, List[str]] get_inherited_secrets(namespace, tenant)

List inherited secrets

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
        # List inherited secrets
        api_response = kestra_client.namespaces.get_inherited_secrets(namespace, tenant)
        print("The response of namespaces->get_inherited_secrets:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->get_inherited_secrets: %s\n" % e)
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

# **get_namespace**
> Namespace get_namespace(id, tenant)

Get a namespace

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
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # Get a namespace
        api_response = kestra_client.namespaces.get_namespace(id, tenant)
        print("The response of namespaces->get_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->get_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
 **tenant** | **str**|  | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **inherited_plugin_defaults**
> List[PluginDefault] inherited_plugin_defaults(id, tenant)

List inherited plugin defaults

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
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List inherited plugin defaults
        api_response = kestra_client.namespaces.inherited_plugin_defaults(id, tenant)
        print("The response of namespaces->inherited_plugin_defaults:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->inherited_plugin_defaults: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
 **tenant** | **str**|  | 

### Return type

[**List[PluginDefault]**](PluginDefault.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | inheritedPluginDefaults 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **inherited_variables**
> Dict[str, object] inherited_variables(id, tenant)

List inherited variables

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
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 

    try:
        # List inherited variables
        api_response = kestra_client.namespaces.inherited_variables(id, tenant)
        print("The response of namespaces->inherited_variables:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->inherited_variables: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
 **tenant** | **str**|  | 

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
**200** | inheritedVariables 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_namespace_secrets**
> ApiSecretListResponse list_namespace_secrets(namespace, page, size, filters, tenant, sort=sort)

Get secrets for a namespace

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
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    filters = [kestrapy.QueryFilter()] # List[QueryFilter] | Filters
    tenant = 'tenant_example' # str | 
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Get secrets for a namespace
        api_response = kestra_client.namespaces.list_namespace_secrets(namespace, page, size, filters, tenant, sort=sort)
        print("The response of namespaces->list_namespace_secrets:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->list_namespace_secrets: %s\n" % e)
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
> List[ApiSecretMeta] patch_secret(namespace, key, tenant, api_secret_meta_ee)

Patch a secret metadata for a namespace

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
    key = 'key_example' # str | The secret key
    tenant = 'tenant_example' # str | 
    api_secret_meta_ee = kestrapy.ApiSecretMetaEE() # ApiSecretMetaEE | 

    try:
        # Patch a secret metadata for a namespace
        api_response = kestra_client.namespaces.patch_secret(namespace, key, tenant, api_secret_meta_ee)
        print("The response of namespaces->patch_secret:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->patch_secret: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **str**| The namespace id | 
 **key** | **str**| The secret key | 
 **tenant** | **str**|  | 
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
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    namespace = 'namespace_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    api_secret_value = kestrapy.ApiSecretValue() # ApiSecretValue | 

    try:
        # Update secrets for a namespace
        api_response = kestra_client.namespaces.put_secrets(namespace, tenant, api_secret_value)
        print("The response of namespaces->put_secrets:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->put_secrets: %s\n" % e)
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

# **search_namespaces**
> PagedResultsNamespace search_namespaces(page, size, existing, tenant, q=q, sort=sort)

Search for namespaces

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
    existing = False # bool | Return only existing namespace (default to False)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Search for namespaces
        api_response = kestra_client.namespaces.search_namespaces(page, size, existing, tenant, q=q, sort=sort)
        print("The response of namespaces->search_namespaces:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->search_namespaces: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **existing** | **bool**| Return only existing namespace | [default to False]
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsNamespace**](PagedResultsNamespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | searchNamespaces 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_namespace**
> Namespace update_namespace(id, tenant, namespace)

Update a namespace

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
    id = 'id_example' # str | The namespace id
    tenant = 'tenant_example' # str | 
    namespace = kestrapy.Namespace() # Namespace | The namespace

    try:
        # Update a namespace
        api_response = kestra_client.namespaces.update_namespace(id, tenant, namespace)
        print("The response of namespaces->update_namespace:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling namespaces->update_namespace: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The namespace id | 
 **tenant** | **str**|  | 
 **namespace** | [**Namespace**](Namespace.md)| The namespace | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | updateNamespace 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

