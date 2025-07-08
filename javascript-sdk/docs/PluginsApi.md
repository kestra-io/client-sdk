# KestraApi.PluginsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllInputTypes**](PluginsApi.md#getAllInputTypes) | **GET** /api/v1/{tenant}/plugins/inputs | Get all types for an inputs
[**getPluginBySubgroups**](PluginsApi.md#getPluginBySubgroups) | **GET** /api/v1/{tenant}/plugins/groups/subgroups | Get plugins group by subgroups
[**getPluginDocumentation**](PluginsApi.md#getPluginDocumentation) | **GET** /api/v1/{tenant}/plugins/{cls} | Get plugin documentation
[**getPluginDocumentationFromVersion**](PluginsApi.md#getPluginDocumentationFromVersion) | **GET** /api/v1/{tenant}/plugins/{cls}/versions/{version} | Get plugin documentation
[**getPluginGroupIcons**](PluginsApi.md#getPluginGroupIcons) | **GET** /api/v1/{tenant}/plugins/icons/groups | Get plugins icons
[**getPluginIcons**](PluginsApi.md#getPluginIcons) | **GET** /api/v1/{tenant}/plugins/icons | Get plugins icons
[**getPluginVersions**](PluginsApi.md#getPluginVersions) | **GET** /api/v1/{tenant}/plugins/{cls}/versions | Get all versions for a plugin
[**getSchemaFromInputType**](PluginsApi.md#getSchemaFromInputType) | **GET** /api/v1/{tenant}/plugins/inputs/{type} | Get json schemas for an input type
[**getSchemasFromType**](PluginsApi.md#getSchemasFromType) | **GET** /api/v1/{tenant}/plugins/schemas/{type} | Get all json schemas for a type
[**getVersionedPluginDetails**](PluginsApi.md#getVersionedPluginDetails) | **GET** /api/v1/cluster/versioned-plugins/{groupId}/{artifactId} | Get details about a Kestra&#39;s plugin artifact.
[**getVersionedPluginDetailsFromVersion**](PluginsApi.md#getVersionedPluginDetailsFromVersion) | **GET** /api/v1/cluster/versioned-plugins/{groupId}/{artifactId}/{version} | Get details about a specific Kestra&#39;s plugin artifact version.
[**installVersionedPlugins**](PluginsApi.md#installVersionedPlugins) | **POST** /api/v1/cluster/versioned-plugins/install | Install a specific Kestra&#39;s plugin artifact
[**listAvailableVersionedPlugins**](PluginsApi.md#listAvailableVersionedPlugins) | **GET** /api/v1/cluster/versioned-plugins/available | Get the list of available Kestra&#39;s plugin artifact.
[**listPlugins**](PluginsApi.md#listPlugins) | **GET** /api/v1/{tenant}/plugins | Get list of plugins
[**listVersionedPlugin**](PluginsApi.md#listVersionedPlugin) | **GET** /api/v1/cluster/versioned-plugins | Get the list of installed Kestra&#39;s plugin artifact.
[**resolveVersionedPlugins**](PluginsApi.md#resolveVersionedPlugins) | **POST** /api/v1/cluster/versioned-plugins/resolve | Resolve a specific Kestra&#39;s plugin artifact
[**uninstallVersionedPlugins**](PluginsApi.md#uninstallVersionedPlugins) | **DELETE** /api/v1/cluster/versioned-plugins/uninstall | Uninstall Kestra&#39;s plugin artifacts
[**uploadVersionedPlugins**](PluginsApi.md#uploadVersionedPlugins) | **POST** /api/v1/cluster/versioned-plugins/upload | Upload a Kestra&#39;s plugin artifact



## getAllInputTypes

> [InputType] getAllInputTypes(tenant)

Get all types for an inputs

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let tenant = "tenant_example"; // String | 
apiInstance.getAllInputTypes(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 

### Return type

[**[InputType]**](InputType.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginBySubgroups

> [Plugin] getPluginBySubgroups(includeDeprecated, tenant)

Get plugins group by subgroups

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let includeDeprecated = true; // Boolean | Whether to include deprecated plugins
let tenant = "tenant_example"; // String | 
apiInstance.getPluginBySubgroups(includeDeprecated, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeDeprecated** | **Boolean**| Whether to include deprecated plugins | [default to true]
 **tenant** | **String**|  | 

### Return type

[**[Plugin]**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginDocumentation

> DocumentationWithSchema getPluginDocumentation(cls, all, tenant)

Get plugin documentation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let cls = "cls_example"; // String | The plugin full class name
let all = false; // Boolean | Include all the properties
let tenant = "tenant_example"; // String | 
apiInstance.getPluginDocumentation(cls, all, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **String**| The plugin full class name | 
 **all** | **Boolean**| Include all the properties | [default to false]
 **tenant** | **String**|  | 

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginDocumentationFromVersion

> DocumentationWithSchema getPluginDocumentationFromVersion(cls, version, all, tenant)

Get plugin documentation

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let cls = "cls_example"; // String | The plugin type
let version = "version_example"; // String | The plugin version
let all = false; // Boolean | Include all the properties
let tenant = "tenant_example"; // String | 
apiInstance.getPluginDocumentationFromVersion(cls, version, all, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **String**| The plugin type | 
 **version** | **String**| The plugin version | 
 **all** | **Boolean**| Include all the properties | [default to false]
 **tenant** | **String**|  | 

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginGroupIcons

> {String: PluginIcon} getPluginGroupIcons(tenant)

Get plugins icons

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let tenant = "tenant_example"; // String | 
apiInstance.getPluginGroupIcons(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 

### Return type

[**{String: PluginIcon}**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginIcons

> {String: PluginIcon} getPluginIcons(tenant)

Get plugins icons

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let tenant = "tenant_example"; // String | 
apiInstance.getPluginIcons(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 

### Return type

[**{String: PluginIcon}**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginVersions

> PluginControllerApiPluginVersions getPluginVersions(cls, tenant)

Get all versions for a plugin

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let cls = "cls_example"; // String | The plugin type
let tenant = "tenant_example"; // String | 
apiInstance.getPluginVersions(cls, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **String**| The plugin type | 
 **tenant** | **String**|  | 

### Return type

[**PluginControllerApiPluginVersions**](PluginControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getSchemaFromInputType

> DocumentationWithSchema getSchemaFromInputType(type, tenant)

Get json schemas for an input type

The schema will be output as [http://json-schema.org/draft-07/schema](Json Schema Draft 7)

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let type = new KestraApi.Type(); // Type | The schema needed
let tenant = "tenant_example"; // String | 
apiInstance.getSchemaFromInputType(type, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**Type**](.md)| The schema needed | 
 **tenant** | **String**|  | 

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getSchemasFromType

> {String: Object} getSchemasFromType(type, arrayOf, tenant)

Get all json schemas for a type

The schema will be output as [http://json-schema.org/draft-07/schema](Json Schema Draft 7)

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let type = new KestraApi.SchemaType(); // SchemaType | The schema needed
let arrayOf = false; // Boolean | If schema should be an array of requested type
let tenant = "tenant_example"; // String | 
apiInstance.getSchemasFromType(type, arrayOf, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**SchemaType**](.md)| The schema needed | 
 **arrayOf** | **Boolean**| If schema should be an array of requested type | [default to false]
 **tenant** | **String**|  | 

### Return type

**{String: Object}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getVersionedPluginDetails

> ClusterControllerApiPluginVersions getVersionedPluginDetails(groupId, artifactId)

Get details about a Kestra&#39;s plugin artifact.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let groupId = "groupId_example"; // String | 
let artifactId = "artifactId_example"; // String | 
apiInstance.getVersionedPluginDetails(groupId, artifactId).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**|  | 
 **artifactId** | **String**|  | 

### Return type

[**ClusterControllerApiPluginVersions**](ClusterControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getVersionedPluginDetailsFromVersion

> ClusterControllerApiPluginVersionDetails getVersionedPluginDetailsFromVersion(groupId, artifactId, version)

Get details about a specific Kestra&#39;s plugin artifact version.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let groupId = "groupId_example"; // String | 
let artifactId = "artifactId_example"; // String | 
let version = "version_example"; // String | 
apiInstance.getVersionedPluginDetailsFromVersion(groupId, artifactId, version).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**|  | 
 **artifactId** | **String**|  | 
 **version** | **String**|  | 

### Return type

[**ClusterControllerApiPluginVersionDetails**](ClusterControllerApiPluginVersionDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## installVersionedPlugins

> ClusterControllerApiPluginArtifactListPluginArtifact installVersionedPlugins(clusterControllerApiPluginListRequest)

Install a specific Kestra&#39;s plugin artifact

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let clusterControllerApiPluginListRequest = new KestraApi.ClusterControllerApiPluginListRequest(); // ClusterControllerApiPluginListRequest | List of plugins
apiInstance.installVersionedPlugins(clusterControllerApiPluginListRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clusterControllerApiPluginListRequest** | [**ClusterControllerApiPluginListRequest**](ClusterControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**ClusterControllerApiPluginArtifactListPluginArtifact**](ClusterControllerApiPluginArtifactListPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## listAvailableVersionedPlugins

> Object listAvailableVersionedPlugins()

Get the list of available Kestra&#39;s plugin artifact.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
apiInstance.listAvailableVersionedPlugins().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listPlugins

> [Plugin] listPlugins(tenant)

Get list of plugins

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let tenant = "tenant_example"; // String | 
apiInstance.listPlugins(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 

### Return type

[**[Plugin]**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listVersionedPlugin

> PagedResultsClusterControllerApiPluginArtifact listVersionedPlugin(page, size, opts)

Get the list of installed Kestra&#39;s plugin artifact.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'q': "q_example" // String | The query
};
apiInstance.listVersionedPlugin(page, size, opts).then((data) => {
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
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **q** | **String**| The query | [optional] 

### Return type

[**PagedResultsClusterControllerApiPluginArtifact**](PagedResultsClusterControllerApiPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## resolveVersionedPlugins

> ClusterControllerApiPluginArtifactListPluginResolutionResult resolveVersionedPlugins(clusterControllerApiPluginListRequest)

Resolve a specific Kestra&#39;s plugin artifact

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let clusterControllerApiPluginListRequest = new KestraApi.ClusterControllerApiPluginListRequest(); // ClusterControllerApiPluginListRequest | List of plugins
apiInstance.resolveVersionedPlugins(clusterControllerApiPluginListRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clusterControllerApiPluginListRequest** | [**ClusterControllerApiPluginListRequest**](ClusterControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**ClusterControllerApiPluginArtifactListPluginResolutionResult**](ClusterControllerApiPluginArtifactListPluginResolutionResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## uninstallVersionedPlugins

> ClusterControllerApiPluginArtifactListPluginArtifact uninstallVersionedPlugins(clusterControllerApiPluginListRequest)

Uninstall Kestra&#39;s plugin artifacts

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let clusterControllerApiPluginListRequest = new KestraApi.ClusterControllerApiPluginListRequest(); // ClusterControllerApiPluginListRequest | List of plugins
apiInstance.uninstallVersionedPlugins(clusterControllerApiPluginListRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clusterControllerApiPluginListRequest** | [**ClusterControllerApiPluginListRequest**](ClusterControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**ClusterControllerApiPluginArtifactListPluginArtifact**](ClusterControllerApiPluginArtifactListPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## uploadVersionedPlugins

> PluginArtifact uploadVersionedPlugins(opts)

Upload a Kestra&#39;s plugin artifact

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.PluginsApi();
let opts = {
  'file': "/path/to/file" // File | 
};
apiInstance.uploadVersionedPlugins(opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **File**|  | [optional] 

### Return type

[**PluginArtifact**](PluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

