# AssetsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**asset**](AssetsApi.md#asset) | **GET** /api/v1/{tenant}/assets/{id} | Retrieve an asset |
| [**assetDependencies**](AssetsApi.md#assetDependencies) | **GET** /api/v1/{tenant}/assets/{id}/dependencies | Get the relation graph around an asset |
| [**assetRelationSummary**](AssetsApi.md#assetRelationSummary) | **GET** /api/v1/{tenant}/assets/{id}/relations/summary | Summarize the relations of an asset, grouped by kind and direction |
| [**assetRelations**](AssetsApi.md#assetRelations) | **GET** /api/v1/{tenant}/assets/{id}/relations | One page of the relations of an asset for one kind and direction |
| [**clearAssetParent**](AssetsApi.md#clearAssetParent) | **DELETE** /api/v1/{tenant}/assets/{id}/parent | Detach the asset from the one it is part of |
| [**createAsset**](AssetsApi.md#createAsset) | **POST** /api/v1/{tenant}/assets | Create a new asset |
| [**createAssetRelation**](AssetsApi.md#createAssetRelation) | **POST** /api/v1/{tenant}/assets/{id}/relations | Create a relation from an asset by hand |
| [**deleteAsset**](AssetsApi.md#deleteAsset) | **DELETE** /api/v1/{tenant}/assets/{id} | Delete an asset |
| [**deleteAssetRelation**](AssetsApi.md#deleteAssetRelation) | **DELETE** /api/v1/{tenant}/assets/{id}/relations/{uid} | Remove one relation of an asset |
| [**deleteAssetUsagesByQuery**](AssetsApi.md#deleteAssetUsagesByQuery) | **DELETE** /api/v1/{tenant}/assets/usages/by-query | Delete asset usages by query, hard-delete (purge) only |
| [**deleteAssetsByIds**](AssetsApi.md#deleteAssetsByIds) | **DELETE** /api/v1/{tenant}/assets/by-ids | Delete assets by asset ids |
| [**deleteAssetsByQuery**](AssetsApi.md#deleteAssetsByQuery) | **DELETE** /api/v1/{tenant}/assets/by-query | Delete assets by query |
| [**flowAssetDependencies**](AssetsApi.md#flowAssetDependencies) | **GET** /api/v1/{tenant}/flows/{namespace}/{id}/asset-dependencies | Get the relation graph around a flow |
| [**searchAssetUsages**](AssetsApi.md#searchAssetUsages) | **GET** /api/v1/{tenant}/assets/usages/search | Search for asset usages |
| [**searchAssets**](AssetsApi.md#searchAssets) | **GET** /api/v1/{tenant}/assets/search | Search for assets |
| [**setAssetParent**](AssetsApi.md#setAssetParent) | **PUT** /api/v1/{tenant}/assets/{id}/parent | Set the asset this one is part of |



## asset

> AssetsControllerApiAsset asset(id, tenant, allowDeleted)

Retrieve an asset

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The ID of the asset
        String tenant = "tenant_example"; // String | 
        Boolean allowDeleted = false; // Boolean | Get asset even if soft deleted
        try {
            AssetsControllerApiAsset result = kestraClient.assets().asset(id, tenant, allowDeleted);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#asset");
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
| **id** | **String**| The ID of the asset | |
| **tenant** | **String**|  | |
| **allowDeleted** | **Boolean**| Get asset even if soft deleted | [optional] [default to false] |

### Return type

[**AssetsControllerApiAsset**](AssetsControllerApiAsset.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getAsset 200 response |  -  |


## assetDependencies

> AssetRelationGraph assetDependencies(id, tenant, kinds, expandAll, hubCursor)

Get the relation graph around an asset

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;
import io.kestra.sdk.model.*;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The asset id
        String tenant = "tenant_example"; // String | 
        List<RelationKind> kinds = Arrays.asList(RelationKind.UPSTREAM_OF, RelationKind.RELATED); // List<RelationKind> | Relation kinds to include, defaults to every current-state kind
        Boolean expandAll = false; // Boolean | If true, expand transitively through lineage kinds
        String hubCursor = null; // String | When this asset is itself a collapsed hub, the nextCursor of the page already shown; pages a "load more relations" call
        try {
            AssetRelationGraph result = kestraClient.assets().assetDependencies(id, tenant, kinds, expandAll, hubCursor);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#assetDependencies");
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
| **id** | **String**| The asset id | |
| **tenant** | **String**|  | |
| **kinds** | [**List&lt;RelationKind&gt;**](RelationKind.md)| Relation kinds to include, defaults to every current-state kind | [optional] |
| **expandAll** | **Boolean**| If true, expand transitively through lineage kinds | [optional] [default to false] |
| **hubCursor** | **String**| When this asset is itself a collapsed hub, the nextCursor of the page already shown; pages a "load more relations" call | [optional] |

### Return type

[**AssetRelationGraph**](AssetRelationGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getAssetDependencies 200 response |  -  |

## assetRelationSummary

> AssetsControllerApiRelationSummary assetRelationSummary(id, tenant, limit)

Summarize the relations of an asset, grouped by kind and direction

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The asset id
        String tenant = "tenant_example"; // String | 
        Integer limit = 5; // Integer | Items per group
        try {
            AssetsControllerApiRelationSummary result = kestraClient.assets().assetRelationSummary(id, tenant, limit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#assetRelationSummary");
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
| **id** | **String**| The asset id | |
| **tenant** | **String**|  | |
| **limit** | **Integer**| Items per group | [optional] [default to 5] |

### Return type

[**AssetsControllerApiRelationSummary**](AssetsControllerApiRelationSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getAssetRelationSummary 200 response |  -  |

## assetRelations

> AssetsControllerApiRelationPage assetRelations(id, tenant, kind, direction, after, size)

One page of the relations of an asset for one kind and direction

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;
import io.kestra.sdk.model.*;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The asset id
        String tenant = "tenant_example"; // String | 
        RelationKind kind = RelationKind.UPSTREAM_OF; // RelationKind | The relation kind
        RelationDirection direction = RelationDirection.OUTBOUND; // RelationDirection | The side of the asset in the relation, as reported by the summary group being expanded
        String after = null; // String | The nextCursor of the previous page
        Integer size = 20; // Integer | The page size
        try {
            AssetsControllerApiRelationPage result = kestraClient.assets().assetRelations(id, tenant, kind, direction, after, size);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#assetRelations");
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
| **id** | **String**| The asset id | |
| **tenant** | **String**|  | |
| **kind** | [**RelationKind**](RelationKind.md)| The relation kind | |
| **direction** | [**RelationDirection**](RelationDirection.md)| The side of the asset in the relation, as reported by the summary group being expanded | |
| **after** | **String**| The nextCursor of the previous page | [optional] |
| **size** | **Integer**| The page size | [optional] [default to 20] |

### Return type

[**AssetsControllerApiRelationPage**](AssetsControllerApiRelationPage.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getAssetRelations 200 response |  -  |

## clearAssetParent

> AssetsControllerApiAsset clearAssetParent(id, tenant)

Detach the asset from the one it is part of

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The asset id
        String tenant = "tenant_example"; // String | 
        try {
            AssetsControllerApiAsset result = kestraClient.assets().clearAssetParent(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#clearAssetParent");
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
| **id** | **String**| The asset id | |
| **tenant** | **String**|  | |

### Return type

[**AssetsControllerApiAsset**](AssetsControllerApiAsset.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | clearAssetParent 200 response |  -  |

## createAsset

> AssetsControllerApiAsset createAsset(tenant, yamlBody)

Create a new asset

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The asset
        try {
            AssetsControllerApiAsset result = kestraClient.assets().createAsset(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#createAsset");
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
| **tenant** | **String**|  | |
| **yamlBody** | **String**| The asset | |

### Return type

[**AssetsControllerApiAsset**](AssetsControllerApiAsset.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createAsset 200 response |  -  |


## createAssetRelation

> AssetsControllerApiRelation createAssetRelation(id, tenant, request)

Create a relation from an asset by hand

Only current-state kinds can be drawn by hand, and PART_OF goes through the parent endpoint instead (see `setAssetParent`). Creating the same relation twice overwrites the role and marks the relation manual, reviving it if it had been removed.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;
import io.kestra.sdk.model.*;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The asset id
        String tenant = "tenant_example"; // String | 
        AssetsControllerApiRelationRequest request = new AssetsControllerApiRelationRequest().kind(RelationKind.UPSTREAM_OF).direction(RelationDirection.OUTBOUND).targetId("other_asset"); // AssetsControllerApiRelationRequest | 
        try {
            AssetsControllerApiRelation result = kestraClient.assets().createAssetRelation(id, tenant, request);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#createAssetRelation");
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
| **id** | **String**| The asset id | |
| **tenant** | **String**|  | |
| **request** | [**AssetsControllerApiRelationRequest**](AssetsControllerApiRelationRequest.md)|  | |

### Return type

[**AssetsControllerApiRelation**](AssetsControllerApiRelation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | createAssetRelation 201 response |  -  |

## deleteAsset

> deleteAsset(id, tenant)

Delete an asset

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The ID of the asset
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.assets().deleteAsset(id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#deleteAsset");
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
| **id** | **String**| The ID of the asset | |
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
| **200** | deleteAsset 200 response |  -  |


## deleteAssetRelation

> deleteAssetRelation(id, uid, tenant)

Remove one relation of an asset

A derived relation is tombstoned rather than deleted, so the next run that produces it does not bring it back. A declared one is deleted, but comes back if a peer still declares it.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The asset id
        String uid = "uid_example"; // String | The uid of the relation
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.assets().deleteAssetRelation(id, uid, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#deleteAssetRelation");
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
| **id** | **String**| The asset id | |
| **uid** | **String**| The uid of the relation | |
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
| **204** | deleteAssetRelation 204 response |  -  |

## deleteAssetUsagesByQuery

> BulkResponse deleteAssetUsagesByQuery(tenant, filters)

Delete asset usages by query, hard-delete (purge) only

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String tenant = "tenant_example"; // String | 
        try {
            BulkResponse result = kestraClient.assets().deleteAssetUsagesByQuery(tenant, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#deleteAssetUsagesByQuery");
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
| **tenant** | **String**|  | |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteAssetUsagesByQuery 200 response |  -  |


## deleteAssetsByIds

> BulkResponse deleteAssetsByIds(tenant, ids)

Delete assets by asset ids

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        List<String> requestBody = Arrays.asList(); // List<String> | The asset ids
        try {
            BulkResponse result = kestraClient.assets().deleteAssetsByIds(tenant, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#deleteAssetsByIds");
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
| **tenant** | **String**|  | |
| **ids** | [**List&lt;String&gt;**](String.md)| The asset ids | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Number of deleted assets |  -  |
| **400** | If any assetId didn&#39;t match an existing asset |  -  |


## deleteAssetsByQuery

> BulkResponse deleteAssetsByQuery(tenant, filters, purge)

Delete assets by query

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String tenant = "tenant_example"; // String | 
        Boolean purge = false; // Boolean | If true, will purge instead of soft-delete
        try {
            BulkResponse result = kestraClient.assets().deleteAssetsByQuery(tenant, filters, purge);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#deleteAssetsByQuery");
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
| **tenant** | **String**|  | |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | |
| **purge** | **Boolean**| If true, will purge instead of soft-delete | [optional] [default to false] |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Number of deleted assets |  -  |
| **400** | If any assetId didn&#39;t match an existing asset |  -  |


## flowAssetDependencies

> AssetRelationGraph flowAssetDependencies(namespace, id, tenant, kinds, expandAll, hubCursor)

Get the relation graph around a flow

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;
import io.kestra.sdk.model.*;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String namespace = "namespace_example"; // String | The flow namespace
        String id = "id_example"; // String | The flow id
        String tenant = "tenant_example"; // String | 
        List<RelationKind> kinds = Arrays.asList(RelationKind.UPSTREAM_OF, RelationKind.RELATED); // List<RelationKind> | Relation kinds to include, defaults to every current-state kind
        Boolean expandAll = false; // Boolean | If true, expand transitively through lineage kinds
        String hubCursor = null; // String | When this flow is itself a collapsed hub, the nextCursor of the page already shown; pages a "load more relations" call
        try {
            AssetRelationGraph result = kestraClient.assets().flowAssetDependencies(namespace, id, tenant, kinds, expandAll, hubCursor);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#flowAssetDependencies");
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
| **namespace** | **String**| The flow namespace | |
| **id** | **String**| The flow id | |
| **tenant** | **String**|  | |
| **kinds** | [**List&lt;RelationKind&gt;**](RelationKind.md)| Relation kinds to include, defaults to every current-state kind | [optional] |
| **expandAll** | **Boolean**| If true, expand transitively through lineage kinds | [optional] [default to false] |
| **hubCursor** | **String**| When this flow is itself a collapsed hub, the nextCursor of the page already shown; pages a "load more relations" call | [optional] |

### Return type

[**AssetRelationGraph**](AssetRelationGraph.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getFlowAssetDependencies 200 response |  -  |

## searchAssetUsages

> PagedResultsAssetsControllerApiAssetUsage searchAssetUsages(tenant, page, size, sort, filters)

Search for asset usages

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String tenant = "tenant_example"; // String | 
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsAssetsControllerApiAssetUsage result = kestraClient.assets().searchAssetUsages(tenant, page, size, sort, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#searchAssetUsages");
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
| **tenant** | **String**|  | |
| **page** | **Integer**| The current page | [optional] [default to 1] |
| **size** | **Integer**| The current page size | [optional] [default to 10] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | |

### Return type

[**PagedResultsAssetsControllerApiAssetUsage**](PagedResultsAssetsControllerApiAssetUsage.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchAssetUsages 200 response |  -  |


## searchAssets

> PagedResultsAssetsControllerApiAsset searchAssets(tenant, page, size, sort, filters)

Search for assets

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String tenant = "tenant_example"; // String | 
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsAssetsControllerApiAsset result = kestraClient.assets().searchAssets(tenant, page, size, sort, filters);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#searchAssets");
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
| **tenant** | **String**|  | |
| **page** | **Integer**| The current page | [optional] [default to 1] |
| **size** | **Integer**| The current page size | [optional] [default to 10] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | |

### Return type

[**PagedResultsAssetsControllerApiAsset**](PagedResultsAssetsControllerApiAsset.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchAssets 200 response |  -  |

## setAssetParent

> AssetsControllerApiAsset setAssetParent(id, tenant, parent)

Set the asset this one is part of

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AssetsApi;
import io.kestra.sdk.model.*;

public class Example {
    public static void main(String[] args) {
        String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The asset id
        String tenant = "tenant_example"; // String | 
        AssetsControllerApiParentRequest parent = new AssetsControllerApiParentRequest().parentId("parent_asset"); // AssetsControllerApiParentRequest | 
        try {
            AssetsControllerApiAsset result = kestraClient.assets().setAssetParent(id, tenant, parent);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsApi#setAssetParent");
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
| **id** | **String**| The asset id | |
| **tenant** | **String**|  | |
| **parent** | [**AssetsControllerApiParentRequest**](AssetsControllerApiParentRequest.md)|  | |

### Return type

[**AssetsControllerApiAsset**](AssetsControllerApiAsset.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | setAssetParent 200 response |  -  |

