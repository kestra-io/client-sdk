# KestraIoKestraApi.PluginsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllInputTypes**](PluginsApi.md#getAllInputTypes) | **GET** /api/v1/plugins/inputs | Get all types for an inputs
[**getPluginBySubgroups**](PluginsApi.md#getPluginBySubgroups) | **GET** /api/v1/plugins/groups/subgroups | Get plugins group by subgroups
[**getPluginDocumentation**](PluginsApi.md#getPluginDocumentation) | **GET** /api/v1/plugins/{cls} | Get plugin documentation
[**getPluginDocumentationFromVersion**](PluginsApi.md#getPluginDocumentationFromVersion) | **GET** /api/v1/plugins/{cls}/versions/{version} | Get plugin documentation
[**getPluginGroupIcons**](PluginsApi.md#getPluginGroupIcons) | **GET** /api/v1/plugins/icons/groups | Get plugins icons
[**getPluginIcons**](PluginsApi.md#getPluginIcons) | **GET** /api/v1/plugins/icons | Get plugins icons
[**getPluginVersions**](PluginsApi.md#getPluginVersions) | **GET** /api/v1/plugins/{cls}/versions | Get all versions for a plugin
[**getPropertiesFromType**](PluginsApi.md#getPropertiesFromType) | **GET** /api/v1/plugins/properties/{type} | Get the properties part of the JSON schema for a type
[**getSchemaFromInputType**](PluginsApi.md#getSchemaFromInputType) | **GET** /api/v1/plugins/inputs/{type} | Get the JSON schema for an input type
[**getSchemasFromType**](PluginsApi.md#getSchemasFromType) | **GET** /api/v1/plugins/schemas/{type} | Get the JSON schema for a type
[**getVersionedPluginDetails**](PluginsApi.md#getVersionedPluginDetails) | **GET** /api/v1/instance/versioned-plugins/{groupId}/{artifactId} | Retrieve details of a plugin artifact
[**getVersionedPluginDetailsFromVersion**](PluginsApi.md#getVersionedPluginDetailsFromVersion) | **GET** /api/v1/instance/versioned-plugins/{groupId}/{artifactId}/{version} | Retrieve details of a specific plugin artifact version
[**installVersionedPlugins**](PluginsApi.md#installVersionedPlugins) | **POST** /api/v1/instance/versioned-plugins/install | Install specified plugin artifacts
[**listAvailableVersionedPlugins**](PluginsApi.md#listAvailableVersionedPlugins) | **GET** /api/v1/instance/versioned-plugins/available | List available plugin artifacts
[**listPlugins**](PluginsApi.md#listPlugins) | **GET** /api/v1/plugins | Get list of plugins
[**listVersionedPlugin**](PluginsApi.md#listVersionedPlugin) | **GET** /api/v1/instance/versioned-plugins | List installed plugin artifacts
[**resolveVersionedPlugins**](PluginsApi.md#resolveVersionedPlugins) | **POST** /api/v1/instance/versioned-plugins/resolve | Resolve versions for specified plugin artifacts
[**uninstallVersionedPlugins**](PluginsApi.md#uninstallVersionedPlugins) | **DELETE** /api/v1/instance/versioned-plugins/uninstall | Uninstall plugin artifacts
[**uploadVersionedPlugins**](PluginsApi.md#uploadVersionedPlugins) | **POST** /api/v1/instance/versioned-plugins/upload | Upload a plugin artifact JAR file



## getAllInputTypes

> [InputType] getAllInputTypes()

Get all types for an inputs

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
apiInstance.getAllInputTypes((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[InputType]**](InputType.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginBySubgroups

> [Plugin] getPluginBySubgroups()

Get plugins group by subgroups

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
apiInstance.getPluginBySubgroups((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[Plugin]**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginDocumentation

> DocumentationWithSchema getPluginDocumentation(cls, all)

Get plugin documentation

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let cls = "cls_example"; // String | The plugin full class name
let all = false; // Boolean | Include all the properties
apiInstance.getPluginDocumentation(cls, all, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **String**| The plugin full class name | 
 **all** | **Boolean**| Include all the properties | [default to false]

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginDocumentationFromVersion

> DocumentationWithSchema getPluginDocumentationFromVersion(cls, version, all)

Get plugin documentation

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let cls = "cls_example"; // String | The plugin type
let version = "version_example"; // String | The plugin version
let all = false; // Boolean | Include all the properties
apiInstance.getPluginDocumentationFromVersion(cls, version, all, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **String**| The plugin type | 
 **version** | **String**| The plugin version | 
 **all** | **Boolean**| Include all the properties | [default to false]

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginGroupIcons

> {String: PluginIcon} getPluginGroupIcons()

Get plugins icons

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
apiInstance.getPluginGroupIcons((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**{String: PluginIcon}**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginIcons

> {String: PluginIcon} getPluginIcons()

Get plugins icons

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
apiInstance.getPluginIcons((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**{String: PluginIcon}**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPluginVersions

> PluginControllerApiPluginVersions getPluginVersions(cls)

Get all versions for a plugin

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let cls = "cls_example"; // String | The plugin type
apiInstance.getPluginVersions(cls, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cls** | **String**| The plugin type | 

### Return type

[**PluginControllerApiPluginVersions**](PluginControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getPropertiesFromType

> {String: Object} getPropertiesFromType(type)

Get the properties part of the JSON schema for a type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let type = new KestraIoKestraApi.SchemaType(); // SchemaType | The schema needed
apiInstance.getPropertiesFromType(type, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**SchemaType**](.md)| The schema needed | 

### Return type

**{String: Object}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getSchemaFromInputType

> DocumentationWithSchema getSchemaFromInputType(type)

Get the JSON schema for an input type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let type = new KestraIoKestraApi.Type(); // Type | The schema needed
apiInstance.getSchemaFromInputType(type, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
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


## getSchemasFromType

> {String: Object} getSchemasFromType(type, arrayOf)

Get the JSON schema for a type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let type = new KestraIoKestraApi.SchemaType(); // SchemaType | The schema needed
let arrayOf = false; // Boolean | If schema should be an array of requested type
apiInstance.getSchemasFromType(type, arrayOf, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**SchemaType**](.md)| The schema needed | 
 **arrayOf** | **Boolean**| If schema should be an array of requested type | [default to false]

### Return type

**{String: Object}**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getVersionedPluginDetails

> InstanceControllerApiPluginVersions getVersionedPluginDetails(groupId, artifactId)

Retrieve details of a plugin artifact

Superadmin-only. Retrieves metadata and available versions for a given plugin artifact. Requires INFRASTRUCTURE permission.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let groupId = "groupId_example"; // String | 
let artifactId = "artifactId_example"; // String | 
apiInstance.getVersionedPluginDetails(groupId, artifactId, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**|  | 
 **artifactId** | **String**|  | 

### Return type

[**InstanceControllerApiPluginVersions**](InstanceControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getVersionedPluginDetailsFromVersion

> InstanceControllerApiPluginVersionDetails getVersionedPluginDetailsFromVersion(groupId, artifactId, version)

Retrieve details of a specific plugin artifact version

Superadmin-only. Retrieves metadata for a specific version of a plugin artifact. Requires INFRASTRUCTURE permission.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let groupId = "groupId_example"; // String | 
let artifactId = "artifactId_example"; // String | 
let version = "version_example"; // String | 
apiInstance.getVersionedPluginDetailsFromVersion(groupId, artifactId, version, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**|  | 
 **artifactId** | **String**|  | 
 **version** | **String**|  | 

### Return type

[**InstanceControllerApiPluginVersionDetails**](InstanceControllerApiPluginVersionDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## installVersionedPlugins

> InstanceControllerApiPluginArtifactListPluginArtifact installVersionedPlugins(instanceControllerApiPluginListRequest)

Install specified plugin artifacts

Superadmin-only. Installs one or more plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let instanceControllerApiPluginListRequest = new KestraIoKestraApi.InstanceControllerApiPluginListRequest(); // InstanceControllerApiPluginListRequest | List of plugins
apiInstance.installVersionedPlugins(instanceControllerApiPluginListRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instanceControllerApiPluginListRequest** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**InstanceControllerApiPluginArtifactListPluginArtifact**](InstanceControllerApiPluginArtifactListPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## listAvailableVersionedPlugins

> Object listAvailableVersionedPlugins()

List available plugin artifacts

Superadmin-only. Lists all plugin artifacts available for installation. Requires INFRASTRUCTURE permission.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
apiInstance.listAvailableVersionedPlugins((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
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

> [Plugin] listPlugins()

Get list of plugins

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
apiInstance.listPlugins((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[Plugin]**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listVersionedPlugin

> PagedResultsInstanceControllerApiPluginArtifact listVersionedPlugin(page, size, opts)

List installed plugin artifacts

Superadmin-only. Lists all currently installed plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'q': "q_example" // String | The query
};
apiInstance.listVersionedPlugin(page, size, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
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

[**PagedResultsInstanceControllerApiPluginArtifact**](PagedResultsInstanceControllerApiPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## resolveVersionedPlugins

> InstanceControllerApiPluginArtifactListPluginResolutionResult resolveVersionedPlugins(instanceControllerApiPluginListRequest)

Resolve versions for specified plugin artifacts

Superadmin-only. Resolves compatible versions for a list of plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let instanceControllerApiPluginListRequest = new KestraIoKestraApi.InstanceControllerApiPluginListRequest(); // InstanceControllerApiPluginListRequest | List of plugins
apiInstance.resolveVersionedPlugins(instanceControllerApiPluginListRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instanceControllerApiPluginListRequest** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**InstanceControllerApiPluginArtifactListPluginResolutionResult**](InstanceControllerApiPluginArtifactListPluginResolutionResult.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## uninstallVersionedPlugins

> InstanceControllerApiPluginArtifactListPluginArtifact uninstallVersionedPlugins(instanceControllerApiPluginListRequest)

Uninstall plugin artifacts

Superadmin-only. Uninstalls one or more plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let instanceControllerApiPluginListRequest = new KestraIoKestraApi.InstanceControllerApiPluginListRequest(); // InstanceControllerApiPluginListRequest | List of plugins
apiInstance.uninstallVersionedPlugins(instanceControllerApiPluginListRequest, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instanceControllerApiPluginListRequest** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | 

### Return type

[**InstanceControllerApiPluginArtifactListPluginArtifact**](InstanceControllerApiPluginArtifactListPluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## uploadVersionedPlugins

> PluginArtifact uploadVersionedPlugins(file, opts)

Upload a plugin artifact JAR file

Superadmin-only. Uploads a plugin JAR file for installation. Requires INFRASTRUCTURE permission.

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.PluginsApi();
let file = "/path/to/file"; // File | 
let opts = {
  'forceInstallOnExistingVersions': true // Boolean | 
};
apiInstance.uploadVersionedPlugins(file, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **File**|  | 
 **forceInstallOnExistingVersions** | **Boolean**|  | [optional] 

### Return type

[**PluginArtifact**](PluginArtifact.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

