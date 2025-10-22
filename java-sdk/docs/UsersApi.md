# UsersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**autocompleteUsers**](UsersApi.md#autocompleteUsers) | **POST** /api/v1/{tenant}/tenant-access/autocomplete | List users for autocomplete |
| [**createApiTokensForUser**](UsersApi.md#createApiTokensForUser) | **POST** /api/v1/users/{id}/api-tokens | Create new API Token for a specific user |
| [**createUser**](UsersApi.md#createUser) | **POST** /api/v1/users | Create a new user account |
| [**deleteApiTokenForUser**](UsersApi.md#deleteApiTokenForUser) | **DELETE** /api/v1/users/{id}/api-tokens/{tokenId} | Delete an API Token for specific user and token id |
| [**deleteRefreshToken**](UsersApi.md#deleteRefreshToken) | **DELETE** /api/v1/users/{id}/refresh-token | Delete a user refresh token |
| [**deleteUser**](UsersApi.md#deleteUser) | **DELETE** /api/v1/users/{id} | Delete a user |
| [**deleteUserAuthMethod**](UsersApi.md#deleteUserAuthMethod) | **DELETE** /api/v1/users/{id}/auths/{auth} | Update user password |
| [**getUser**](UsersApi.md#getUser) | **GET** /api/v1/users/{id} | Get a user |
| [**impersonate**](UsersApi.md#impersonate) | **POST** /api/v1/users/{id}/impersonate | Impersonate a user |
| [**listApiTokensForUser**](UsersApi.md#listApiTokensForUser) | **GET** /api/v1/users/{id}/api-tokens | List API tokens for a specific user |
| [**listUsers**](UsersApi.md#listUsers) | **GET** /api/v1/users | Retrieve users |
| [**patchUser**](UsersApi.md#patchUser) | **PATCH** /api/v1/users/{id} | Update user details |
| [**patchUserDemo**](UsersApi.md#patchUserDemo) | **PATCH** /api/v1/users/{id}/restricted | Update user demo |
| [**patchUserPassword**](UsersApi.md#patchUserPassword) | **PATCH** /api/v1/users/{id}/password | Update user password |
| [**patchUserSuperAdmin**](UsersApi.md#patchUserSuperAdmin) | **PATCH** /api/v1/users/{id}/superadmin | Update user superadmin privileges |
| [**updateCurrentUserPassword**](UsersApi.md#updateCurrentUserPassword) | **PUT** /api/v1/me/password | Update authenticated user password |
| [**updateUser**](UsersApi.md#updateUser) | **PUT** /api/v1/users/{id} | Update a user account |
| [**updateUserGroups**](UsersApi.md#updateUserGroups) | **PUT** /api/v1/{tenant}/users/{id}/groups | Update the list of groups a user belongs to for the given tenant |



## autocompleteUsers

> List&lt;IAMTenantAccessControllerApiUserTenantAccess&gt; autocompleteUsers(tenant, iaMTenantAccessControllerUserApiAutocomplete)

List users for autocomplete

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        IAMTenantAccessControllerUserApiAutocomplete iaMTenantAccessControllerUserApiAutocomplete = new IAMTenantAccessControllerUserApiAutocomplete(); // IAMTenantAccessControllerUserApiAutocomplete | Autocomplete request
        try {
            List<IAMTenantAccessControllerApiUserTenantAccess> result = apiInstance.autocompleteUsers(tenant, iaMTenantAccessControllerUserApiAutocomplete);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#autocompleteUsers");
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
| **iaMTenantAccessControllerUserApiAutocomplete** | [**IAMTenantAccessControllerUserApiAutocomplete**](IAMTenantAccessControllerUserApiAutocomplete.md)| Autocomplete request | |

### Return type

[**List&lt;IAMTenantAccessControllerApiUserTenantAccess&gt;**](IAMTenantAccessControllerApiUserTenantAccess.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | autocompleteUsers 200 response |  -  |


## createApiTokensForUser

> CreateApiTokenResponse createApiTokensForUser(id, createApiTokenRequest)

Create new API Token for a specific user

Superadmin-only. Create a new API token for a user.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        CreateApiTokenRequest createApiTokenRequest = new CreateApiTokenRequest(); // CreateApiTokenRequest | The create api-token request
        try {
            CreateApiTokenResponse result = apiInstance.createApiTokensForUser(id, createApiTokenRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#createApiTokensForUser");
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

[**CreateApiTokenResponse**](CreateApiTokenResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | API token successfully created |  -  |
| **404** | User not found |  -  |


## createUser

> IAMUserControllerApiUser createUser(iaMUserControllerApiCreateOrUpdateUserRequest)

Create a new user account

Superadmin-only. Create a new user account with an optional password based authentication method.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        IAMUserControllerApiCreateOrUpdateUserRequest iaMUserControllerApiCreateOrUpdateUserRequest = new IAMUserControllerApiCreateOrUpdateUserRequest(); // IAMUserControllerApiCreateOrUpdateUserRequest | 
        try {
            IAMUserControllerApiUser result = apiInstance.createUser(iaMUserControllerApiCreateOrUpdateUserRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#createUser");
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
| **iaMUserControllerApiCreateOrUpdateUserRequest** | [**IAMUserControllerApiCreateOrUpdateUserRequest**](IAMUserControllerApiCreateOrUpdateUserRequest.md)|  | |

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | User was successfully created |  -  |
| **404** | Tenant, or group not found |  -  |


## deleteApiTokenForUser

> deleteApiTokenForUser(id, tokenId)

Delete an API Token for specific user and token id

Superadmin-only. Delete an API token for a user.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        String tokenId = "tokenId_example"; // String | The token id
        try {
            apiInstance.deleteApiTokenForUser(id, tokenId);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#deleteApiTokenForUser");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | API token successfully deleted |  -  |
| **404** | User, or API Token not found |  -  |


## deleteRefreshToken

> deleteRefreshToken(id)

Delete a user refresh token

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        try {
            apiInstance.deleteRefreshToken(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#deleteRefreshToken");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Refresh token successfully deleted |  -  |
| **404** | User not found |  -  |


## deleteUser

> deleteUser(id)

Delete a user

Superadmin-only. Delete a user including all its access.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        try {
            apiInstance.deleteUser(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#deleteUser");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | User successfully deleted |  -  |
| **404** | User not found |  -  |


## deleteUserAuthMethod

> IAMUserControllerApiUser deleteUserAuthMethod(id, auth)

Update user password

Superadmin-only. Updates whether a user is a superadmin.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        String auth = "auth_example"; // String | The user auth method id
        try {
            IAMUserControllerApiUser result = apiInstance.deleteUserAuthMethod(id, auth);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#deleteUserAuthMethod");
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
| **auth** | **String**| The user auth method id | |

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User auth method successfully updated |  -  |
| **404** | User or auth method not found |  -  |


## getUser

> IAMUserControllerApiUser getUser(id)

Get a user

Superadmin-only. Get user account details.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        try {
            IAMUserControllerApiUser result = apiInstance.getUser(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#getUser");
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

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | User not found |  -  |
| **200** | getUser 200 response |  -  |


## impersonate

> Object impersonate(id)

Impersonate a user

Superadmin-only. Allows an admin to impersonate another user.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        try {
            Object result = apiInstance.impersonate(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#impersonate");
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
| **404** | User not found |  -  |
| **200** | impersonate 200 response |  -  |


## listApiTokensForUser

> Object listApiTokensForUser(id)

List API tokens for a specific user

Superadmin-only. Get all API token existing for a user.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        try {
            Object result = apiInstance.listApiTokensForUser(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#listApiTokensForUser");
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
| **404** | User not found |  -  |
| **200** | listApiTokensForUser 200 response |  -  |


## listUsers

> PagedResultsIAMUserControllerApiUserSummary listUsers(page, size, q, sort)

Retrieve users

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String q = "q_example"; // String | A string filter
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsIAMUserControllerApiUserSummary result = apiInstance.listUsers(page, size, q, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#listUsers");
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

[**PagedResultsIAMUserControllerApiUserSummary**](PagedResultsIAMUserControllerApiUserSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listUsers 200 response |  -  |


## patchUser

> IAMUserControllerApiUser patchUser(id, meControllerApiUserDetailsRequest)

Update user details

Superadmin-only. Updates the the details of a user.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        MeControllerApiUserDetailsRequest meControllerApiUserDetailsRequest = new MeControllerApiUserDetailsRequest(); // MeControllerApiUserDetailsRequest | The user details
        try {
            IAMUserControllerApiUser result = apiInstance.patchUser(id, meControllerApiUserDetailsRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#patchUser");
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
| **meControllerApiUserDetailsRequest** | [**MeControllerApiUserDetailsRequest**](MeControllerApiUserDetailsRequest.md)| The user details | |

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | patchUser 200 response |  -  |


## patchUserDemo

> patchUserDemo(id, iaMUserControllerApiPatchRestrictedRequest)

Update user demo

Superadmin-only. Updates whether a user is for demo.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        IAMUserControllerApiPatchRestrictedRequest iaMUserControllerApiPatchRestrictedRequest = new IAMUserControllerApiPatchRestrictedRequest(); // IAMUserControllerApiPatchRestrictedRequest | 
        try {
            apiInstance.patchUserDemo(id, iaMUserControllerApiPatchRestrictedRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#patchUserDemo");
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
| **iaMUserControllerApiPatchRestrictedRequest** | [**IAMUserControllerApiPatchRestrictedRequest**](IAMUserControllerApiPatchRestrictedRequest.md)|  | |

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
| **200** | User successfully updated |  -  |
| **404** | User not found |  -  |


## patchUserPassword

> IAMUserControllerApiUser patchUserPassword(id, iaMUserControllerApiPatchUserPasswordRequest)

Update user password

Superadmin-only. Updates whether a user is a superadmin.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        IAMUserControllerApiPatchUserPasswordRequest iaMUserControllerApiPatchUserPasswordRequest = new IAMUserControllerApiPatchUserPasswordRequest(); // IAMUserControllerApiPatchUserPasswordRequest | 
        try {
            IAMUserControllerApiUser result = apiInstance.patchUserPassword(id, iaMUserControllerApiPatchUserPasswordRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#patchUserPassword");
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
| **iaMUserControllerApiPatchUserPasswordRequest** | [**IAMUserControllerApiPatchUserPasswordRequest**](IAMUserControllerApiPatchUserPasswordRequest.md)|  | |

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User successfully updated |  -  |
| **404** | User not found |  -  |


## patchUserSuperAdmin

> patchUserSuperAdmin(id, apiPatchSuperAdminRequest)

Update user superadmin privileges

Superadmin-only. Updates whether a user is a superadmin.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        ApiPatchSuperAdminRequest apiPatchSuperAdminRequest = new ApiPatchSuperAdminRequest(); // ApiPatchSuperAdminRequest | 
        try {
            apiInstance.patchUserSuperAdmin(id, apiPatchSuperAdminRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#patchUserSuperAdmin");
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
| **200** | User successfully updated |  -  |
| **404** | User not found |  -  |


## updateCurrentUserPassword

> Object updateCurrentUserPassword(meControllerApiUpdatePasswordRequest)

Update authenticated user password

Changes the login password for the authenticated user.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        MeControllerApiUpdatePasswordRequest meControllerApiUpdatePasswordRequest = new MeControllerApiUpdatePasswordRequest(); // MeControllerApiUpdatePasswordRequest | 
        try {
            Object result = apiInstance.updateCurrentUserPassword(meControllerApiUpdatePasswordRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#updateCurrentUserPassword");
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
| **meControllerApiUpdatePasswordRequest** | [**MeControllerApiUpdatePasswordRequest**](MeControllerApiUpdatePasswordRequest.md)|  | |

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
| **200** | updateCurrentUserPassword 200 response |  -  |


## updateUser

> IAMUserControllerApiUser updateUser(id, iaMUserControllerApiCreateOrUpdateUserRequest)

Update a user account

Superadmin-only. Update an existing user account with an optional password based authentication method.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user id
        IAMUserControllerApiCreateOrUpdateUserRequest iaMUserControllerApiCreateOrUpdateUserRequest = new IAMUserControllerApiCreateOrUpdateUserRequest(); // IAMUserControllerApiCreateOrUpdateUserRequest | 
        try {
            IAMUserControllerApiUser result = apiInstance.updateUser(id, iaMUserControllerApiCreateOrUpdateUserRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#updateUser");
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
| **iaMUserControllerApiCreateOrUpdateUserRequest** | [**IAMUserControllerApiCreateOrUpdateUserRequest**](IAMUserControllerApiCreateOrUpdateUserRequest.md)|  | |

### Return type

[**IAMUserControllerApiUser**](IAMUserControllerApiUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | Tenant, or group not found |  -  |
| **200** | updateUser 200 response |  -  |


## updateUserGroups

> updateUserGroups(id, tenant, iaMUserGroupControllerApiUpdateUserGroupsRequest)

Update the list of groups a user belongs to for the given tenant

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.UsersApi;

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

        UsersApi apiInstance = new UsersApi(defaultClient);
        String id = "id_example"; // String | The user ID
        String tenant = "tenant_example"; // String | 
        IAMUserGroupControllerApiUpdateUserGroupsRequest iaMUserGroupControllerApiUpdateUserGroupsRequest = new IAMUserGroupControllerApiUpdateUserGroupsRequest(); // IAMUserGroupControllerApiUpdateUserGroupsRequest | 
        try {
            apiInstance.updateUserGroups(id, tenant, iaMUserGroupControllerApiUpdateUserGroupsRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#updateUserGroups");
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
| **id** | **String**| The user ID | |
| **tenant** | **String**|  | |
| **iaMUserGroupControllerApiUpdateUserGroupsRequest** | [**IAMUserGroupControllerApiUpdateUserGroupsRequest**](IAMUserGroupControllerApiUpdateUserGroupsRequest.md)|  | |

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
| **204** | User&#39;s groups successfully updated |  -  |
| **404** | User or one of the groups not found |  -  |
| **400** | Invalid request payload |  -  |

