# KestraIoKestraSdk.NamespacesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocompleteNamespaces**](NamespacesApi.md#autocompleteNamespaces) | **POST** /api/v1/{tenant}/namespaces/autocomplete | List namespaces for autocomplete
[**createNamespace**](NamespacesApi.md#createNamespace) | **POST** /api/v1/{tenant}/namespaces | Create a namespace
[**deleteNamespace**](NamespacesApi.md#deleteNamespace) | **DELETE** /api/v1/{tenant}/namespaces/{id} | Delete a namespace
[**deleteSecret**](NamespacesApi.md#deleteSecret) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/secrets/{key} | Delete a secret for a namespace
[**getInheritedSecrets**](NamespacesApi.md#getInheritedSecrets) | **GET** /api/v1/{tenant}/namespaces/{namespace}/inherited-secrets | List inherited secrets
[**getNamespace**](NamespacesApi.md#getNamespace) | **GET** /api/v1/{tenant}/namespaces/{id} | Get a namespace
[**inheritedPluginDefaults**](NamespacesApi.md#inheritedPluginDefaults) | **GET** /api/v1/{tenant}/namespaces/{id}/inherited-plugindefaults | List inherited plugin defaults
[**inheritedVariables**](NamespacesApi.md#inheritedVariables) | **GET** /api/v1/{tenant}/namespaces/{id}/inherited-variables | List inherited variables
[**listNamespaceSecrets**](NamespacesApi.md#listNamespaceSecrets) | **GET** /api/v1/{tenant}/namespaces/{namespace}/secrets | Get secrets for a namespace
[**patchSecret**](NamespacesApi.md#patchSecret) | **PATCH** /api/v1/{tenant}/namespaces/{namespace}/secrets/{key} | Patch a secret metadata for a namespace
[**putSecrets**](NamespacesApi.md#putSecrets) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/secrets | Update secrets for a namespace
[**searchNamespaces**](NamespacesApi.md#searchNamespaces) | **GET** /api/v1/{tenant}/namespaces/search | Search for namespaces
[**updateNamespace**](NamespacesApi.md#updateNamespace) | **PUT** /api/v1/{tenant}/namespaces/{id} | Update a namespace



## autocompleteNamespaces

> [String] autocompleteNamespaces(tenant, apiAutocomplete)

List namespaces for autocomplete

Returns a list of namespaces for use in autocomplete fields, optionally allowing to filter by query and ids. Used especially for binding creation.

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let tenant = "tenant_example"; // String | 
let apiAutocomplete = new KestraIoKestraSdk.ApiAutocomplete(); // ApiAutocomplete | 
apiInstance.autocompleteNamespaces(tenant, apiAutocomplete).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)|  | 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createNamespace

> Namespace createNamespace(tenant, namespace)

Create a namespace

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let tenant = "tenant_example"; // String | 
let namespace = new KestraIoKestraSdk.Namespace(); // Namespace | The namespace
apiInstance.createNamespace(tenant, namespace).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **namespace** | [**Namespace**](Namespace.md)| The namespace | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteNamespace

> deleteNamespace(id, tenant)

Delete a namespace

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let id = "id_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
apiInstance.deleteNamespace(id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The namespace id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deleteSecret

> [String] deleteSecret(namespace, key, tenant)

Delete a secret for a namespace

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let namespace = "namespace_example"; // String | The namespace id
let key = "key_example"; // String | The secret key
let tenant = "tenant_example"; // String | 
apiInstance.deleteSecret(namespace, key, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **key** | **String**| The secret key | 
 **tenant** | **String**|  | 

### Return type

**[String]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getInheritedSecrets

> {String: [String]} getInheritedSecrets(namespace, tenant)

List inherited secrets

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
apiInstance.getInheritedSecrets(namespace, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 

### Return type

**{String: [String]}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getNamespace

> Namespace getNamespace(id, tenant)

Get a namespace

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let id = "id_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
apiInstance.getNamespace(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The namespace id | 
 **tenant** | **String**|  | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## inheritedPluginDefaults

> [PluginDefault] inheritedPluginDefaults(id, tenant)

List inherited plugin defaults

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let id = "id_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
apiInstance.inheritedPluginDefaults(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The namespace id | 
 **tenant** | **String**|  | 

### Return type

[**[PluginDefault]**](PluginDefault.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## inheritedVariables

> {String: Object} inheritedVariables(id, tenant)

List inherited variables

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let id = "id_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
apiInstance.inheritedVariables(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The namespace id | 
 **tenant** | **String**|  | 

### Return type

**{String: Object}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listNamespaceSecrets

> ApiSecretListResponse listNamespaceSecrets(namespace, page, size, filters, tenant, opts)

Get secrets for a namespace

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let namespace = "namespace_example"; // String | The namespace id
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let filters = [new KestraIoKestraSdk.QueryFilter()]; // [QueryFilter] | Filters
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.listNamespaceSecrets(namespace, page, size, filters, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | 
 **tenant** | **String**|  | 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**ApiSecretListResponse**](ApiSecretListResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## patchSecret

> [ApiSecretMeta] patchSecret(namespace, tenant, key, apiSecretMetaEE)

Patch a secret metadata for a namespace

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
let key = "key_example"; // String | 
let apiSecretMetaEE = new KestraIoKestraSdk.ApiSecretMetaEE(); // ApiSecretMetaEE | 
apiInstance.patchSecret(namespace, tenant, key, apiSecretMetaEE).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 
 **key** | **String**|  | 
 **apiSecretMetaEE** | [**ApiSecretMetaEE**](ApiSecretMetaEE.md)|  | 

### Return type

[**[ApiSecretMeta]**](ApiSecretMeta.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## putSecrets

> [ApiSecretMeta] putSecrets(namespace, tenant, apiSecretValue)

Update secrets for a namespace

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let namespace = "namespace_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
let apiSecretValue = new KestraIoKestraSdk.ApiSecretValue(); // ApiSecretValue | 
apiInstance.putSecrets(namespace, tenant, apiSecretValue).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace id | 
 **tenant** | **String**|  | 
 **apiSecretValue** | [**ApiSecretValue**](ApiSecretValue.md)|  | 

### Return type

[**[ApiSecretMeta]**](ApiSecretMeta.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## searchNamespaces

> PagedResultsNamespace searchNamespaces(page, size, existing, tenant, opts)

Search for namespaces

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let existing = false; // Boolean | Return only existing namespace
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchNamespaces(page, size, existing, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **existing** | **Boolean**| Return only existing namespace | [default to false]
 **tenant** | **String**|  | 
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsNamespace**](PagedResultsNamespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateNamespace

> Namespace updateNamespace(id, tenant, namespace)

Update a namespace

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.NamespacesApi();
let id = "id_example"; // String | The namespace id
let tenant = "tenant_example"; // String | 
let namespace = new KestraIoKestraSdk.Namespace(); // Namespace | The namespace
apiInstance.updateNamespace(id, tenant, namespace).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The namespace id | 
 **tenant** | **String**|  | 
 **namespace** | [**Namespace**](Namespace.md)| The namespace | 

### Return type

[**Namespace**](Namespace.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

