# ScimUsersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSCIMResourceByIdUsers**](ScimUsersApi.md#createSCIMResourceByIdUsers) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users |  |
| [**deleteUsers**](ScimUsersApi.md#deleteUsers) | **DELETE** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} |  |
| [**findUsers**](ScimUsersApi.md#findUsers) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/.search |  |
| [**getSCIMResourceByIdUsers**](ScimUsersApi.md#getSCIMResourceByIdUsers) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} |  |
| [**patchUsers**](ScimUsersApi.md#patchUsers) | **PATCH** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} |  |
| [**queryUsers**](ScimUsersApi.md#queryUsers) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users |  |
| [**updateUsers**](ScimUsersApi.md#updateUsers) | **PUT** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} |  |



## createSCIMResourceByIdUsers

> ScimResource createSCIMResourceByIdUsers(integration, tenant, scimUser, attributes, excludedAttributes)



Create

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ScimUsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ScimUsersApi apiInstance = new ScimUsersApi(defaultClient);
        String integration = "integration_example"; // String | 
        String tenant = "tenant_example"; // String | 
        ScimUser scimUser = new ScimUser(); // ScimUser | 
        String attributes = "attributes_example"; // String | 
        String excludedAttributes = "excludedAttributes_example"; // String | 
        try {
            ScimResource result = apiInstance.createSCIMResourceByIdUsers(integration, tenant, scimUser, attributes, excludedAttributes);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScimUsersApi#createSCIMResourceByIdUsers");
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
| **integration** | **String**|  | |
| **tenant** | **String**|  | |
| **scimUser** | [**ScimUser**](ScimUser.md)|  | |
| **attributes** | **String**|  | [optional] |
| **excludedAttributes** | **String**|  | [optional] |

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **400** | Bad Request |  -  |
| **409** | Conflict |  -  |
| **500** | Internal Server Error |  -  |
| **501** | Not Implemented |  -  |


## deleteUsers

> deleteUsers(id, integration, tenant)



Delete from the backing store

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ScimUsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ScimUsersApi apiInstance = new ScimUsersApi(defaultClient);
        String id = "id_example"; // String | 
        String integration = "integration_example"; // String | 
        String tenant = "tenant_example"; // String | 
        try {
            apiInstance.deleteUsers(id, integration, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScimUsersApi#deleteUsers");
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
| **id** | **String**|  | |
| **integration** | **String**|  | |
| **tenant** | **String**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **404** | Not found |  -  |
| **500** | Internal Server Error |  -  |
| **501** | Not Implemented |  -  |


## findUsers

> ScimResource findUsers(integration, tenant, searchRequest)



Search

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ScimUsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ScimUsersApi apiInstance = new ScimUsersApi(defaultClient);
        String integration = "integration_example"; // String | 
        String tenant = "tenant_example"; // String | 
        SearchRequest searchRequest = new SearchRequest(); // SearchRequest | 
        try {
            ScimResource result = apiInstance.findUsers(integration, tenant, searchRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScimUsersApi#findUsers");
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
| **integration** | **String**|  | |
| **tenant** | **String**|  | |
| **searchRequest** | [**SearchRequest**](SearchRequest.md)|  | |

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |
| **501** | Not Implemented |  -  |
| **200** | OK response |  -  |


## getSCIMResourceByIdUsers

> ScimResource getSCIMResourceByIdUsers(id, integration, tenant, attributes, excludedAttributes)



Find by id

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ScimUsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ScimUsersApi apiInstance = new ScimUsersApi(defaultClient);
        String id = "id_example"; // String | 
        String integration = "integration_example"; // String | 
        String tenant = "tenant_example"; // String | 
        String attributes = "attributes_example"; // String | 
        String excludedAttributes = "excludedAttributes_example"; // String | 
        try {
            ScimResource result = apiInstance.getSCIMResourceByIdUsers(id, integration, tenant, attributes, excludedAttributes);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScimUsersApi#getSCIMResourceByIdUsers");
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
| **id** | **String**|  | |
| **integration** | **String**|  | |
| **tenant** | **String**|  | |
| **attributes** | **String**|  | [optional] |
| **excludedAttributes** | **String**|  | [optional] |

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | Bad Request |  -  |
| **404** | Not found |  -  |
| **500** | Internal Server Error |  -  |
| **501** | Not Implemented |  -  |
| **200** | OK response |  -  |


## patchUsers

> patchUsers(id, integration, tenant, patchRequest, attributes, excludedAttributes)



Patch a portion of the backing store

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ScimUsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ScimUsersApi apiInstance = new ScimUsersApi(defaultClient);
        String id = "id_example"; // String | 
        String integration = "integration_example"; // String | 
        String tenant = "tenant_example"; // String | 
        PatchRequest patchRequest = new PatchRequest(); // PatchRequest | 
        String attributes = "attributes_example"; // String | 
        String excludedAttributes = "excludedAttributes_example"; // String | 
        try {
            apiInstance.patchUsers(id, integration, tenant, patchRequest, attributes, excludedAttributes);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScimUsersApi#patchUsers");
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
| **id** | **String**|  | |
| **integration** | **String**|  | |
| **tenant** | **String**|  | |
| **patchRequest** | [**PatchRequest**](PatchRequest.md)|  | |
| **attributes** | **String**|  | [optional] |
| **excludedAttributes** | **String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **404** | Not found |  -  |
| **500** | Internal Server Error |  -  |
| **501** | Not Implemented |  -  |


## queryUsers

> ScimResource queryUsers(integration, tenant, attributes, excludedAttributes, filter, sortBy, sortOrder, startIndex, count)



Find by a combination of query parameters

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ScimUsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ScimUsersApi apiInstance = new ScimUsersApi(defaultClient);
        String integration = "integration_example"; // String | 
        String tenant = "tenant_example"; // String | 
        String attributes = "attributes_example"; // String | 
        String excludedAttributes = "excludedAttributes_example"; // String | 
        String filter = "filter_example"; // String | 
        String sortBy = "sortBy_example"; // String | 
        SortOrder sortOrder = SortOrder.fromValue("ASCENDING"); // SortOrder | 
        Integer startIndex = 56; // Integer | 
        Integer count = 56; // Integer | 
        try {
            ScimResource result = apiInstance.queryUsers(integration, tenant, attributes, excludedAttributes, filter, sortBy, sortOrder, startIndex, count);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScimUsersApi#queryUsers");
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
| **integration** | **String**|  | |
| **tenant** | **String**|  | |
| **attributes** | **String**|  | [optional] |
| **excludedAttributes** | **String**|  | [optional] |
| **filter** | **String**|  | [optional] |
| **sortBy** | **String**|  | [optional] |
| **sortOrder** | [**SortOrder**](.md)|  | [optional] [enum: ASCENDING, DESCENDING] |
| **startIndex** | **Integer**|  | [optional] |
| **count** | **Integer**|  | [optional] |

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | Bad Request |  -  |
| **404** | Not found |  -  |
| **500** | Internal Server Error |  -  |
| **501** | Not Implemented |  -  |
| **200** | OK response |  -  |


## updateUsers

> ScimResource updateUsers(id, integration, tenant, scimResource, attributes, excludedAttributes)



Update

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ScimUsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ScimUsersApi apiInstance = new ScimUsersApi(defaultClient);
        String id = "id_example"; // String | 
        String integration = "integration_example"; // String | 
        String tenant = "tenant_example"; // String | 
        ScimResource scimResource = new ScimResource(); // ScimResource | 
        String attributes = "attributes_example"; // String | 
        String excludedAttributes = "excludedAttributes_example"; // String | 
        try {
            ScimResource result = apiInstance.updateUsers(id, integration, tenant, scimResource, attributes, excludedAttributes);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScimUsersApi#updateUsers");
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
| **id** | **String**|  | |
| **integration** | **String**|  | |
| **tenant** | **String**|  | |
| **scimResource** | [**ScimResource**](ScimResource.md)|  | |
| **attributes** | **String**|  | [optional] |
| **excludedAttributes** | **String**|  | [optional] |

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |
| **501** | Not Implemented |  -  |
| **200** | OK response |  -  |

