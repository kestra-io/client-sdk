# FilesApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNamespaceDirectory**](FilesApi.md#createNamespaceDirectory) | **POST** /api/v1/{tenant}/namespaces/{namespace}/files/directory | Create a directory |
| [**createNamespaceFile**](FilesApi.md#createNamespaceFile) | **POST** /api/v1/{tenant}/namespaces/{namespace}/files | Create a file |
| [**deleteFileDirectory**](FilesApi.md#deleteFileDirectory) | **DELETE** /api/v1/{tenant}/namespaces/{namespace}/files | Delete a file or directory |
| [**exportNamespaceFiles**](FilesApi.md#exportNamespaceFiles) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/export | Export namespace files as a ZIP |
| [**fileContent**](FilesApi.md#fileContent) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files | Get namespace file content |
| [**fileMetadatas**](FilesApi.md#fileMetadatas) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/stats | Get namespace file stats such as size, creation &amp; modification dates and type |
| [**fileRevisions**](FilesApi.md#fileRevisions) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/revisions | Get namespace file revisions |
| [**listNamespaceDirectoryFiles**](FilesApi.md#listNamespaceDirectoryFiles) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/directory | List directory content |
| [**moveFileDirectory**](FilesApi.md#moveFileDirectory) | **PUT** /api/v1/{tenant}/namespaces/{namespace}/files | Move a file or directory |
| [**searchNamespaceFiles**](FilesApi.md#searchNamespaceFiles) | **GET** /api/v1/{tenant}/namespaces/{namespace}/files/search | Find files which path contain the given string in their URI |



## createNamespaceDirectory

> createNamespaceDirectory(namespace, tenant, path)

Create a directory

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String tenant = "tenant_example"; // String | 
        String path = "path_example"; // String | The internal storage uri
        try {
            kestraClient.FilesApi().createNamespaceDirectory(namespace, tenant, path);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#createNamespaceDirectory");
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
| **namespace** | **String**| The namespace id | |
| **tenant** | **String**|  | |
| **path** | **String**| The internal storage uri | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createNamespaceDirectory 200 response |  -  |


## createNamespaceFile

> createNamespaceFile(namespace, path, tenant, fileContent)

Create a file

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String path = "path_example"; // String | The internal storage uri
        String tenant = "tenant_example"; // String | 
        File fileContent = new File("/path/to/file"); // File | The file to upload
        try {
            kestraClient.FilesApi().createNamespaceFile(namespace, path, tenant, fileContent);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#createNamespaceFile");
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
| **namespace** | **String**| The namespace id | |
| **path** | **String**| The internal storage uri | |
| **tenant** | **String**|  | |
| **fileContent** | **File**| The file to upload | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createNamespaceFile 200 response |  -  |


## deleteFileDirectory

> deleteFileDirectory(namespace, path, tenant)

Delete a file or directory

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String path = "path_example"; // String | The internal storage uri of the file / directory to delete
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.FilesApi().deleteFileDirectory(namespace, path, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#deleteFileDirectory");
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
| **namespace** | **String**| The namespace id | |
| **path** | **String**| The internal storage uri of the file / directory to delete | |
| **tenant** | **String**|  | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteFileDirectory 200 response |  -  |


## exportNamespaceFiles

> byte[] exportNamespaceFiles(namespace, tenant)

Export namespace files as a ZIP

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String tenant = "tenant_example"; // String | 
        try {
            byte[] result = kestraClient.FilesApi().exportNamespaceFiles(namespace, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#exportNamespaceFiles");
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
| **namespace** | **String**| The namespace id | |
| **tenant** | **String**|  | |

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | exportNamespaceFiles 200 response |  -  |


## fileContent

> File fileContent(namespace, path, tenant, revision)

Get namespace file content

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String path = "path_example"; // String | The internal storage uri
        String tenant = "tenant_example"; // String | 
        Integer revision = 56; // Integer | The revision, if not provided, the latest revision will be returned
        try {
            File result = kestraClient.FilesApi().fileContent(namespace, path, tenant, revision);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#fileContent");
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
| **namespace** | **String**| The namespace id | |
| **path** | **String**| The internal storage uri | |
| **tenant** | **String**|  | |
| **revision** | **Integer**| The revision, if not provided, the latest revision will be returned | [optional] |

### Return type

[**File**](File.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getFileContent 200 response |  -  |


## fileMetadatas

> FileAttributes fileMetadatas(namespace, tenant, path)

Get namespace file stats such as size, creation &amp; modification dates and type

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String tenant = "tenant_example"; // String | 
        String path = "path_example"; // String | The internal storage uri
        try {
            FileAttributes result = kestraClient.FilesApi().fileMetadatas(namespace, tenant, path);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#fileMetadatas");
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
| **namespace** | **String**| The namespace id | |
| **tenant** | **String**|  | |
| **path** | **String**| The internal storage uri | [optional] |

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
| **200** | getFileMetadatas 200 response |  -  |


## fileRevisions

> List&lt;NamespaceFileRevision&gt; fileRevisions(namespace, tenant, path)

Get namespace file revisions

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String tenant = "tenant_example"; // String | 
        String path = "path_example"; // String | The internal storage uri
        try {
            List<NamespaceFileRevision> result = kestraClient.FilesApi().fileRevisions(namespace, tenant, path);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#fileRevisions");
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
| **namespace** | **String**| The namespace id | |
| **tenant** | **String**|  | |
| **path** | **String**| The internal storage uri | [optional] |

### Return type

[**List&lt;NamespaceFileRevision&gt;**](NamespaceFileRevision.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getFileRevisions 200 response |  -  |


## listNamespaceDirectoryFiles

> List&lt;FileAttributes&gt; listNamespaceDirectoryFiles(namespace, tenant, path)

List directory content

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String tenant = "tenant_example"; // String | 
        String path = "path_example"; // String | The internal storage uri
        try {
            List<FileAttributes> result = kestraClient.FilesApi().listNamespaceDirectoryFiles(namespace, tenant, path);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#listNamespaceDirectoryFiles");
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
| **namespace** | **String**| The namespace id | |
| **tenant** | **String**|  | |
| **path** | **String**| The internal storage uri | [optional] |

### Return type

[**List&lt;FileAttributes&gt;**](FileAttributes.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listNamespaceDirectoryFiles 200 response |  -  |


## moveFileDirectory

> moveFileDirectory(namespace, from, to, tenant)

Move a file or directory

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        URI from = new URI(); // URI | The internal storage uri to move from
        URI to = new URI(); // URI | The internal storage uri to move to
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.FilesApi().moveFileDirectory(namespace, from, to, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#moveFileDirectory");
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
| **namespace** | **String**| The namespace id | |
| **from** | **URI**| The internal storage uri to move from | |
| **to** | **URI**| The internal storage uri to move to | |
| **tenant** | **String**|  | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | moveFileDirectory 200 response |  -  |


## searchNamespaceFiles

> List&lt;String&gt; searchNamespaceFiles(namespace, q, tenant)

Find files which path contain the given string in their URI

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.FilesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The namespace id
        String q = "q_example"; // String | The string the file path should contain
        String tenant = "tenant_example"; // String | 
        try {
            List<String> result = kestraClient.FilesApi().searchNamespaceFiles(namespace, q, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilesApi#searchNamespaceFiles");
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
| **namespace** | **String**| The namespace id | |
| **q** | **String**| The string the file path should contain | |
| **tenant** | **String**|  | |

### Return type

**List&lt;String&gt;**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchNamespaceFiles 200 response |  -  |

