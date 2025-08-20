# PluginsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllInputTypes**](PluginsApi.md#getAllInputTypes) | **GET** /api/v1/plugins/inputs | Get all types for an inputs |
| [**getPluginBySubgroups**](PluginsApi.md#getPluginBySubgroups) | **GET** /api/v1/plugins/groups/subgroups | Get plugins group by subgroups |
| [**getPluginDocumentation**](PluginsApi.md#getPluginDocumentation) | **GET** /api/v1/plugins/{cls} | Get plugin documentation |
| [**getPluginDocumentationFromVersion**](PluginsApi.md#getPluginDocumentationFromVersion) | **GET** /api/v1/plugins/{cls}/versions/{version} | Get plugin documentation |
| [**getPluginGroupIcons**](PluginsApi.md#getPluginGroupIcons) | **GET** /api/v1/plugins/icons/groups | Get plugins icons |
| [**getPluginIcons**](PluginsApi.md#getPluginIcons) | **GET** /api/v1/plugins/icons | Get plugins icons |
| [**getPluginVersions**](PluginsApi.md#getPluginVersions) | **GET** /api/v1/plugins/{cls}/versions | Get all versions for a plugin |
| [**getPropertiesFromType**](PluginsApi.md#getPropertiesFromType) | **GET** /api/v1/plugins/properties/{type} | Get the properties part of the JSON schema for a type |
| [**getSchemaFromInputType**](PluginsApi.md#getSchemaFromInputType) | **GET** /api/v1/plugins/inputs/{type} | Get the JSON schema for an input type |
| [**getSchemasFromType**](PluginsApi.md#getSchemasFromType) | **GET** /api/v1/plugins/schemas/{type} | Get the JSON schema for a type |
| [**getVersionedPluginDetails**](PluginsApi.md#getVersionedPluginDetails) | **GET** /api/v1/instance/versioned-plugins/{groupId}/{artifactId} | Retrieve details of a plugin artifact |
| [**getVersionedPluginDetailsFromVersion**](PluginsApi.md#getVersionedPluginDetailsFromVersion) | **GET** /api/v1/instance/versioned-plugins/{groupId}/{artifactId}/{version} | Retrieve details of a specific plugin artifact version |
| [**installVersionedPlugins**](PluginsApi.md#installVersionedPlugins) | **POST** /api/v1/instance/versioned-plugins/install | Install specified plugin artifacts |
| [**listAvailableVersionedPlugins**](PluginsApi.md#listAvailableVersionedPlugins) | **GET** /api/v1/instance/versioned-plugins/available | List available plugin artifacts |
| [**listAvailableVersionedPluginsForSecretManager**](PluginsApi.md#listAvailableVersionedPluginsForSecretManager) | **GET** /api/v1/instance/versioned-plugins/available/secrets-managers | List available plugin artifacts for Kestra Secret Manager |
| [**listAvailableVersionedPluginsForStorage**](PluginsApi.md#listAvailableVersionedPluginsForStorage) | **GET** /api/v1/instance/versioned-plugins/available/storages | List available plugin artifacts for Kestra Internal Storage |
| [**listPlugins**](PluginsApi.md#listPlugins) | **GET** /api/v1/plugins | Get list of plugins |
| [**listVersionedPlugin**](PluginsApi.md#listVersionedPlugin) | **GET** /api/v1/instance/versioned-plugins | List installed plugin artifacts |
| [**resolveVersionedPlugins**](PluginsApi.md#resolveVersionedPlugins) | **POST** /api/v1/instance/versioned-plugins/resolve | Resolve versions for specified plugin artifacts |
| [**uninstallVersionedPlugins**](PluginsApi.md#uninstallVersionedPlugins) | **DELETE** /api/v1/instance/versioned-plugins/uninstall | Uninstall plugin artifacts |
| [**uploadVersionedPlugins**](PluginsApi.md#uploadVersionedPlugins) | **POST** /api/v1/instance/versioned-plugins/upload | Upload a plugin artifact JAR file |



## getAllInputTypes

> List&lt;InputType&gt; getAllInputTypes()

Get all types for an inputs

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        try {
            List<InputType> result = apiInstance.getAllInputTypes();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getAllInputTypes");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;InputType&gt;**](InputType.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getAllInputTypes 200 response |  -  |


## getPluginBySubgroups

> List&lt;Plugin&gt; getPluginBySubgroups()

Get plugins group by subgroups

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        try {
            List<Plugin> result = apiInstance.getPluginBySubgroups();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getPluginBySubgroups");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;Plugin&gt;**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getPluginBySubgroups 200 response |  -  |


## getPluginDocumentation

> DocumentationWithSchema getPluginDocumentation(cls, all)

Get plugin documentation

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        String cls = "cls_example"; // String | The plugin full class name
        Boolean all = false; // Boolean | Include all the properties
        try {
            DocumentationWithSchema result = apiInstance.getPluginDocumentation(cls, all);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getPluginDocumentation");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **cls** | **String**| The plugin full class name | |
| **all** | **Boolean**| Include all the properties | [default to false] |

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getPluginDocumentation 200 response |  -  |


## getPluginDocumentationFromVersion

> DocumentationWithSchema getPluginDocumentationFromVersion(cls, version, all)

Get plugin documentation

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        String cls = "cls_example"; // String | The plugin type
        String version = "version_example"; // String | The plugin version
        Boolean all = false; // Boolean | Include all the properties
        try {
            DocumentationWithSchema result = apiInstance.getPluginDocumentationFromVersion(cls, version, all);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getPluginDocumentationFromVersion");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **cls** | **String**| The plugin type | |
| **version** | **String**| The plugin version | |
| **all** | **Boolean**| Include all the properties | [default to false] |

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getPluginDocumentationFromVersion 200 response |  -  |


## getPluginGroupIcons

> Map&lt;String, PluginIcon&gt; getPluginGroupIcons()

Get plugins icons

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        try {
            Map<String, PluginIcon> result = apiInstance.getPluginGroupIcons();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getPluginGroupIcons");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**Map&lt;String, PluginIcon&gt;**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getPluginGroupIcons 200 response |  -  |


## getPluginIcons

> Map&lt;String, PluginIcon&gt; getPluginIcons()

Get plugins icons

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        try {
            Map<String, PluginIcon> result = apiInstance.getPluginIcons();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getPluginIcons");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**Map&lt;String, PluginIcon&gt;**](PluginIcon.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getPluginIcons 200 response |  -  |


## getPluginVersions

> PluginControllerApiPluginVersions getPluginVersions(cls)

Get all versions for a plugin

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        String cls = "cls_example"; // String | The plugin type
        try {
            PluginControllerApiPluginVersions result = apiInstance.getPluginVersions(cls);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getPluginVersions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **cls** | **String**| The plugin type | |

### Return type

[**PluginControllerApiPluginVersions**](PluginControllerApiPluginVersions.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getPluginVersions 200 response |  -  |


## getPropertiesFromType

> Map&lt;String, Object&gt; getPropertiesFromType(type)

Get the properties part of the JSON schema for a type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        SchemaType type = SchemaType.fromValue("FLOW"); // SchemaType | The schema needed
        try {
            Map<String, Object> result = apiInstance.getPropertiesFromType(type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getPropertiesFromType");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | [**SchemaType**](.md)| The schema needed | [enum: FLOW, TEMPLATE, TASK, TRIGGER, PLUGINDEFAULT, APPS, TESTSUITES, DASHBOARD] |

### Return type

**Map&lt;String, Object&gt;**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getPropertiesFromType 200 response |  -  |


## getSchemaFromInputType

> DocumentationWithSchema getSchemaFromInputType(type)

Get the JSON schema for an input type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        Type type = Type.fromValue("STRING"); // Type | The schema needed
        try {
            DocumentationWithSchema result = apiInstance.getSchemaFromInputType(type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getSchemaFromInputType");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | [**Type**](.md)| The schema needed | [enum: STRING, ENUM, SELECT, INT, FLOAT, BOOLEAN, BOOL, DATETIME, DATE, TIME, DURATION, FILE, JSON, URI, SECRET, ARRAY, MULTISELECT, YAML, EMAIL] |

### Return type

[**DocumentationWithSchema**](DocumentationWithSchema.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getSchemaFromInputType 200 response |  -  |


## getSchemasFromType

> Map&lt;String, Object&gt; getSchemasFromType(type, arrayOf)

Get the JSON schema for a type

The schema will be a [JSON Schema Draft 7](http://json-schema.org/draft-07/schema)

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        SchemaType type = SchemaType.fromValue("FLOW"); // SchemaType | The schema needed
        Boolean arrayOf = false; // Boolean | If schema should be an array of requested type
        try {
            Map<String, Object> result = apiInstance.getSchemasFromType(type, arrayOf);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getSchemasFromType");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | [**SchemaType**](.md)| The schema needed | [enum: FLOW, TEMPLATE, TASK, TRIGGER, PLUGINDEFAULT, APPS, TESTSUITES, DASHBOARD] |
| **arrayOf** | **Boolean**| If schema should be an array of requested type | [default to false] |

### Return type

**Map&lt;String, Object&gt;**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getSchemasFromType 200 response |  -  |


## getVersionedPluginDetails

> InstanceControllerApiPluginVersions getVersionedPluginDetails(groupId, artifactId)

Retrieve details of a plugin artifact

Superadmin-only. Retrieves metadata and available versions for a given plugin artifact. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        String groupId = "groupId_example"; // String | 
        String artifactId = "artifactId_example"; // String | 
        try {
            InstanceControllerApiPluginVersions result = apiInstance.getVersionedPluginDetails(groupId, artifactId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getVersionedPluginDetails");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **groupId** | **String**|  | |
| **artifactId** | **String**|  | |

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
| **200** | getVersionedPluginDetails 200 response |  -  |


## getVersionedPluginDetailsFromVersion

> InstanceControllerApiPluginVersionDetails getVersionedPluginDetailsFromVersion(groupId, artifactId, version)

Retrieve details of a specific plugin artifact version

Superadmin-only. Retrieves metadata for a specific version of a plugin artifact. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        String groupId = "groupId_example"; // String | 
        String artifactId = "artifactId_example"; // String | 
        String version = "version_example"; // String | 
        try {
            InstanceControllerApiPluginVersionDetails result = apiInstance.getVersionedPluginDetailsFromVersion(groupId, artifactId, version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#getVersionedPluginDetailsFromVersion");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **groupId** | **String**|  | |
| **artifactId** | **String**|  | |
| **version** | **String**|  | |

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
| **200** | getVersionedPluginDetailsFromVersion 200 response |  -  |


## installVersionedPlugins

> InstanceControllerApiPluginArtifactListPluginArtifact installVersionedPlugins(instanceControllerApiPluginListRequest)

Install specified plugin artifacts

Superadmin-only. Installs one or more plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        InstanceControllerApiPluginListRequest instanceControllerApiPluginListRequest = new InstanceControllerApiPluginListRequest(); // InstanceControllerApiPluginListRequest | List of plugins
        try {
            InstanceControllerApiPluginArtifactListPluginArtifact result = apiInstance.installVersionedPlugins(instanceControllerApiPluginListRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#installVersionedPlugins");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **instanceControllerApiPluginListRequest** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | |

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
| **200** | installVersionedPlugins 200 response |  -  |


## listAvailableVersionedPlugins

> Object listAvailableVersionedPlugins()

List available plugin artifacts

Superadmin-only. Lists all plugin artifacts available for installation. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        try {
            Object result = apiInstance.listAvailableVersionedPlugins();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#listAvailableVersionedPlugins");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
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


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listAvailableVersionedPlugins 200 response |  -  |


## listAvailableVersionedPluginsForSecretManager

> Object listAvailableVersionedPluginsForSecretManager()

List available plugin artifacts for Kestra Secret Manager

Superadmin-only. Lists all secret managers available for installation. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        try {
            Object result = apiInstance.listAvailableVersionedPluginsForSecretManager();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#listAvailableVersionedPluginsForSecretManager");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
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


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listAvailableVersionedPluginsForSecretManager 200 response |  -  |


## listAvailableVersionedPluginsForStorage

> Object listAvailableVersionedPluginsForStorage()

List available plugin artifacts for Kestra Internal Storage

Superadmin-only. Lists all internal storages available for installation. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        try {
            Object result = apiInstance.listAvailableVersionedPluginsForStorage();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#listAvailableVersionedPluginsForStorage");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
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


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listAvailableVersionedPluginsForStorage 200 response |  -  |


## listPlugins

> List&lt;Plugin&gt; listPlugins()

Get list of plugins

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        try {
            List<Plugin> result = apiInstance.listPlugins();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#listPlugins");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;Plugin&gt;**](Plugin.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listPlugins 200 response |  -  |


## listVersionedPlugin

> PagedResultsInstanceControllerApiPluginArtifact listVersionedPlugin(page, size, sort, q)

List installed plugin artifacts

Superadmin-only. Lists all currently installed plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        String q = "q_example"; // String | The query
        try {
            PagedResultsInstanceControllerApiPluginArtifact result = apiInstance.listVersionedPlugin(page, size, sort, q);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#listVersionedPlugin");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| The current page | [default to 1] |
| **size** | **Integer**| The current page size | [default to 10] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **q** | **String**| The query | [optional] |

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
| **200** | listVersionedPlugin 200 response |  -  |


## resolveVersionedPlugins

> InstanceControllerApiPluginArtifactListPluginResolutionResult resolveVersionedPlugins(instanceControllerApiPluginListRequest)

Resolve versions for specified plugin artifacts

Superadmin-only. Resolves compatible versions for a list of plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        InstanceControllerApiPluginListRequest instanceControllerApiPluginListRequest = new InstanceControllerApiPluginListRequest(); // InstanceControllerApiPluginListRequest | List of plugins
        try {
            InstanceControllerApiPluginArtifactListPluginResolutionResult result = apiInstance.resolveVersionedPlugins(instanceControllerApiPluginListRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#resolveVersionedPlugins");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **instanceControllerApiPluginListRequest** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | |

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
| **200** | resolveVersionedPlugins 200 response |  -  |


## uninstallVersionedPlugins

> InstanceControllerApiPluginArtifactListPluginArtifact uninstallVersionedPlugins(instanceControllerApiPluginListRequest)

Uninstall plugin artifacts

Superadmin-only. Uninstalls one or more plugin artifacts. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        InstanceControllerApiPluginListRequest instanceControllerApiPluginListRequest = new InstanceControllerApiPluginListRequest(); // InstanceControllerApiPluginListRequest | List of plugins
        try {
            InstanceControllerApiPluginArtifactListPluginArtifact result = apiInstance.uninstallVersionedPlugins(instanceControllerApiPluginListRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#uninstallVersionedPlugins");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **instanceControllerApiPluginListRequest** | [**InstanceControllerApiPluginListRequest**](InstanceControllerApiPluginListRequest.md)| List of plugins | |

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
| **200** | uninstallVersionedPlugins 200 response |  -  |


## uploadVersionedPlugins

> PluginArtifact uploadVersionedPlugins(_file, forceInstallOnExistingVersions)

Upload a plugin artifact JAR file

Superadmin-only. Uploads a plugin JAR file for installation. Requires INFRASTRUCTURE permission.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.PluginsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PluginsApi apiInstance = new PluginsApi(defaultClient);
        File _file = new File("/path/to/file"); // File | 
        Boolean forceInstallOnExistingVersions = true; // Boolean | 
        try {
            PluginArtifact result = apiInstance.uploadVersionedPlugins(_file, forceInstallOnExistingVersions);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PluginsApi#uploadVersionedPlugins");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **_file** | **File**|  | |
| **forceInstallOnExistingVersions** | **Boolean**|  | [optional] |

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
| **200** | uploadVersionedPlugins 200 response |  -  |

