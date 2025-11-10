# ServiceAccountApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createApiTokensForServiceAccount**](ServiceAccountApi.md#createApiTokensForServiceAccount) | **POST** /api/v1/service-accounts/{id}/api-tokens | Create new API Token for a specific service account |
| [**createApiTokensForServiceAccountWithTenant**](ServiceAccountApi.md#createApiTokensForServiceAccountWithTenant) | **POST** /api/v1/{tenant}/service-accounts/{id}/api-tokens | Create new API Token for a specific service account |
| [**createServiceAccount**](ServiceAccountApi.md#createServiceAccount) | **POST** /api/v1/service-accounts | Create a service account |
| [**createServiceAccountForTenant**](ServiceAccountApi.md#createServiceAccountForTenant) | **POST** /api/v1/{tenant}/service-accounts | Create a service account for the given tenant |
| [**deleteApiTokenForServiceAccount**](ServiceAccountApi.md#deleteApiTokenForServiceAccount) | **DELETE** /api/v1/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific service account and token id |
| [**deleteApiTokenForServiceAccountWithTenant**](ServiceAccountApi.md#deleteApiTokenForServiceAccountWithTenant) | **DELETE** /api/v1/{tenant}/service-accounts/{id}/api-tokens/{tokenId} | Delete an API Token for specific service account and token id |
| [**deleteServiceAccount**](ServiceAccountApi.md#deleteServiceAccount) | **DELETE** /api/v1/service-accounts/{id} | Delete a service account |
| [**deleteServiceAccountForTenant**](ServiceAccountApi.md#deleteServiceAccountForTenant) | **DELETE** /api/v1/{tenant}/service-accounts/{id} | Delete a service account |
| [**listApiTokensForServiceAccount**](ServiceAccountApi.md#listApiTokensForServiceAccount) | **GET** /api/v1/service-accounts/{id}/api-tokens | List API tokens for a specific service account |
| [**listApiTokensForServiceAccountWithTenant**](ServiceAccountApi.md#listApiTokensForServiceAccountWithTenant) | **GET** /api/v1/{tenant}/service-accounts/{id}/api-tokens | List API tokens for a specific service account |
| [**listServiceAccounts**](ServiceAccountApi.md#listServiceAccounts) | **GET** /api/v1/service-accounts | List service accounts. Superadmin-only.  |
| [**patchServiceAccountDetails**](ServiceAccountApi.md#patchServiceAccountDetails) | **PATCH** /api/v1/service-accounts/{id} | Update service account details |
| [**patchServiceAccountSuperAdmin**](ServiceAccountApi.md#patchServiceAccountSuperAdmin) | **PATCH** /api/v1/service-accounts/{id}/superadmin | Update service account superadmin privileges |
| [**serviceAccount**](ServiceAccountApi.md#serviceAccount) | **GET** /api/v1/service-accounts/{id} | Get a service account |
| [**serviceAccountForTenant**](ServiceAccountApi.md#serviceAccountForTenant) | **GET** /api/v1/{tenant}/service-accounts/{id} | Retrieve a service account |
| [**updateServiceAccount**](ServiceAccountApi.md#updateServiceAccount) | **PUT** /api/v1/{tenant}/service-accounts/{id} | Update a user service account |



## createApiTokensForServiceAccount

> Object createApiTokensForServiceAccount(id, createApiTokenRequest)

Create new API Token for a specific service account

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        CreateApiTokenRequest createApiTokenRequest = new CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
        try {
            Object result = kestraClient.ServiceAccountApi().createApiTokensForServiceAccount(id, createApiTokenRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#createApiTokensForServiceAccount");
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
| **id** | **String**| The user id | |
| **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createApiTokensForServiceAccount 200 response |  -  |


## createApiTokensForServiceAccountWithTenant

> Object createApiTokensForServiceAccountWithTenant(id, tenant, createApiTokenRequest)

Create new API Token for a specific service account

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        String tenant = "tenant_example"; // String | 
        CreateApiTokenRequest createApiTokenRequest = new CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
        try {
            Object result = kestraClient.ServiceAccountApi().createApiTokensForServiceAccountWithTenant(id, tenant, createApiTokenRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#createApiTokensForServiceAccountWithTenant");
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
| **id** | **String**| The user id | |
| **tenant** | **String**|  | |
| **createApiTokenRequest** | [**CreateApiTokenRequest**](CreateApiTokenRequest.md)| The create api-token request | |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createApiTokensForServiceAccountWithTenant 200 response |  -  |


## createServiceAccount

> IAMServiceAccountControllerApiServiceAccountDetail createServiceAccount(iaMServiceAccountControllerApiCreateServiceAccountRequest)

Create a service account

Superadmin-only. CReate service account with access to multiple tenants.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        IAMServiceAccountControllerApiCreateServiceAccountRequest iaMServiceAccountControllerApiCreateServiceAccountRequest = new IAMServiceAccountControllerApiCreateServiceAccountRequest(); // IAMServiceAccountControllerApiCreateServiceAccountRequest | The service account
        try {
            IAMServiceAccountControllerApiServiceAccountDetail result = kestraClient.ServiceAccountApi().createServiceAccount(iaMServiceAccountControllerApiCreateServiceAccountRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#createServiceAccount");
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
| **iaMServiceAccountControllerApiCreateServiceAccountRequest** | [**IAMServiceAccountControllerApiCreateServiceAccountRequest**](IAMServiceAccountControllerApiCreateServiceAccountRequest.md)| The service account | |

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service account successfully created |  -  |


## createServiceAccountForTenant

> IAMServiceAccountControllerApiServiceAccountResponse createServiceAccountForTenant(tenant, iaMServiceAccountControllerApiServiceAccountRequest)

Create a service account for the given tenant

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        IAMServiceAccountControllerApiServiceAccountRequest iaMServiceAccountControllerApiServiceAccountRequest = new IAMServiceAccountControllerApiServiceAccountRequest(); // IAMServiceAccountControllerApiServiceAccountRequest | The service account
        try {
            IAMServiceAccountControllerApiServiceAccountResponse result = kestraClient.ServiceAccountApi().createServiceAccountForTenant(tenant, iaMServiceAccountControllerApiServiceAccountRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#createServiceAccountForTenant");
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
| **iaMServiceAccountControllerApiServiceAccountRequest** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md)| The service account | |

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service account successfully created |  -  |
| **404** | Group not found |  -  |


## deleteApiTokenForServiceAccount

> Object deleteApiTokenForServiceAccount(id, tokenId)

Delete an API Token for specific service account and token id

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        String tokenId = "tokenId_example"; // String | The token id
        try {
            Object result = kestraClient.ServiceAccountApi().deleteApiTokenForServiceAccount(id, tokenId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#deleteApiTokenForServiceAccount");
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
| **id** | **String**| The user id | |
| **tokenId** | **String**| The token id | |

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
| **200** | deleteApiTokenForServiceAccount 200 response |  -  |


## deleteApiTokenForServiceAccountWithTenant

> Object deleteApiTokenForServiceAccountWithTenant(id, tokenId, tenant)

Delete an API Token for specific service account and token id

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        String tokenId = "tokenId_example"; // String | The token id
        String tenant = "tenant_example"; // String | 
        try {
            Object result = kestraClient.ServiceAccountApi().deleteApiTokenForServiceAccountWithTenant(id, tokenId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#deleteApiTokenForServiceAccountWithTenant");
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
| **id** | **String**| The user id | |
| **tokenId** | **String**| The token id | |
| **tenant** | **String**|  | |

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
| **200** | deleteApiTokenForServiceAccountWithTenant 200 response |  -  |


## deleteServiceAccount

> deleteServiceAccount(id)

Delete a service account

Superadmin-only. Delete a service account including all its access.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The service account id
        try {
            kestraClient.ServiceAccountApi().deleteServiceAccount(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#deleteServiceAccount");
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
| **id** | **String**| The service account id | |

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
| **204** | Service account successfully deleted |  -  |
| **404** | Service account not found |  -  |


## deleteServiceAccountForTenant

> deleteServiceAccountForTenant(id, tenant)

Delete a service account

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The service account id
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.ServiceAccountApi().deleteServiceAccountForTenant(id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#deleteServiceAccountForTenant");
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
| **id** | **String**| The service account id | |
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
| **200** | deleteServiceAccountForTenant 200 response |  -  |
| **404** | Service account |  -  |


## listApiTokensForServiceAccount

> Object listApiTokensForServiceAccount(id)

List API tokens for a specific service account

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        try {
            Object result = kestraClient.ServiceAccountApi().listApiTokensForServiceAccount(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#listApiTokensForServiceAccount");
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
| **id** | **String**| The user id | |

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
| **200** | listApiTokensForServiceAccount 200 response |  -  |


## listApiTokensForServiceAccountWithTenant

> Object listApiTokensForServiceAccountWithTenant(id, tenant)

List API tokens for a specific service account

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        String tenant = "tenant_example"; // String | 
        try {
            Object result = kestraClient.ServiceAccountApi().listApiTokensForServiceAccountWithTenant(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#listApiTokensForServiceAccountWithTenant");
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
| **id** | **String**| The user id | |
| **tenant** | **String**|  | |

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
| **200** | listApiTokensForServiceAccountWithTenant 200 response |  -  |


## listServiceAccounts

> PagedResultsIAMServiceAccountControllerApiServiceAccountDetail listServiceAccounts(page, size, q, sort)

List service accounts. Superadmin-only. 

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String q = "q_example"; // String | A string filter
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsIAMServiceAccountControllerApiServiceAccountDetail result = kestraClient.ServiceAccountApi().listServiceAccounts(page, size, q, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#listServiceAccounts");
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
| **q** | **String**| A string filter | [optional] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsIAMServiceAccountControllerApiServiceAccountDetail**](PagedResultsIAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service account successfully created |  -  |
| **404** | Group not found |  -  |


## patchServiceAccountDetails

> IAMServiceAccountControllerApiServiceAccountDetail patchServiceAccountDetails(id, iaMServiceAccountControllerApiPatchServiceAccountRequest)

Update service account details

Superadmin-only. Updates the details of a service account.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The service account id
        IAMServiceAccountControllerApiPatchServiceAccountRequest iaMServiceAccountControllerApiPatchServiceAccountRequest = new IAMServiceAccountControllerApiPatchServiceAccountRequest(); // IAMServiceAccountControllerApiPatchServiceAccountRequest | The service account details
        try {
            IAMServiceAccountControllerApiServiceAccountDetail result = kestraClient.ServiceAccountApi().patchServiceAccountDetails(id, iaMServiceAccountControllerApiPatchServiceAccountRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#patchServiceAccountDetails");
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
| **id** | **String**| The service account id | |
| **iaMServiceAccountControllerApiPatchServiceAccountRequest** | [**IAMServiceAccountControllerApiPatchServiceAccountRequest**](IAMServiceAccountControllerApiPatchServiceAccountRequest.md)| The service account details | |

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | patchServiceAccountDetails 200 response |  -  |


## patchServiceAccountSuperAdmin

> patchServiceAccountSuperAdmin(id, apiPatchSuperAdminRequest)

Update service account superadmin privileges

Superadmin-only. Updates whether a service account is a superadmin.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        ApiPatchSuperAdminRequest apiPatchSuperAdminRequest = new ApiPatchSuperAdminRequest(); // ApiPatchSuperAdminRequest | 
        try {
            kestraClient.ServiceAccountApi().patchServiceAccountSuperAdmin(id, apiPatchSuperAdminRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#patchServiceAccountSuperAdmin");
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
| **id** | **String**| The user id | |
| **apiPatchSuperAdminRequest** | [**ApiPatchSuperAdminRequest**](ApiPatchSuperAdminRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service account successfully updated |  -  |
| **404** | Service account not found |  -  |


## serviceAccount

> IAMServiceAccountControllerApiServiceAccountDetail serviceAccount(id)

Get a service account

Superadmin-only. Get user account details.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The service account id
        try {
            IAMServiceAccountControllerApiServiceAccountDetail result = kestraClient.ServiceAccountApi().serviceAccount(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#serviceAccount");
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
| **id** | **String**| The service account id | |

### Return type

[**IAMServiceAccountControllerApiServiceAccountDetail**](IAMServiceAccountControllerApiServiceAccountDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getServiceAccount 200 response |  -  |
| **404** | User not found |  -  |


## serviceAccountForTenant

> IAMServiceAccountControllerApiServiceAccountResponse serviceAccountForTenant(id, tenant)

Retrieve a service account

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        String tenant = "tenant_example"; // String | 
        try {
            IAMServiceAccountControllerApiServiceAccountResponse result = kestraClient.ServiceAccountApi().serviceAccountForTenant(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#serviceAccountForTenant");
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
| **id** | **String**| The user id | |
| **tenant** | **String**|  | |

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getServiceAccountForTenant 200 response |  -  |
| **404** | Service account not found |  -  |


## updateServiceAccount

> IAMServiceAccountControllerApiServiceAccountResponse updateServiceAccount(id, tenant, iaMServiceAccountControllerApiServiceAccountRequest)

Update a user service account

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.ServiceAccountApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The user id
        String tenant = "tenant_example"; // String | 
        IAMServiceAccountControllerApiServiceAccountRequest iaMServiceAccountControllerApiServiceAccountRequest = new IAMServiceAccountControllerApiServiceAccountRequest(); // IAMServiceAccountControllerApiServiceAccountRequest | The user
        try {
            IAMServiceAccountControllerApiServiceAccountResponse result = kestraClient.ServiceAccountApi().updateServiceAccount(id, tenant, iaMServiceAccountControllerApiServiceAccountRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServiceAccountApi#updateServiceAccount");
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
| **id** | **String**| The user id | |
| **tenant** | **String**|  | |
| **iaMServiceAccountControllerApiServiceAccountRequest** | [**IAMServiceAccountControllerApiServiceAccountRequest**](IAMServiceAccountControllerApiServiceAccountRequest.md)| The user | |

### Return type

[**IAMServiceAccountControllerApiServiceAccountResponse**](IAMServiceAccountControllerApiServiceAccountResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateServiceAccount 200 response |  -  |
| **404** | Service account, or group not found |  -  |

