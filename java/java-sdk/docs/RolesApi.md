# RolesApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**autocompleteRoles**](RolesApi.md#autocompleteRoles) | **POST** /api/v1/{tenant}/roles/autocomplete | List roles for autocomplete |
| [**createRole**](RolesApi.md#createRole) | **POST** /api/v1/{tenant}/roles | Create a role |
| [**deleteRole**](RolesApi.md#deleteRole) | **DELETE** /api/v1/{tenant}/roles/{id} | Delete a role |
| [**listRolesFromGivenIds**](RolesApi.md#listRolesFromGivenIds) | **POST** /api/v1/{tenant}/roles/ids | List roles by ids |
| [**role**](RolesApi.md#role) | **GET** /api/v1/{tenant}/roles/{id} | Retrieve a role |
| [**searchRoles**](RolesApi.md#searchRoles) | **GET** /api/v1/{tenant}/roles/search | Search for roles |
| [**updateRole**](RolesApi.md#updateRole) | **PUT** /api/v1/{tenant}/roles/{id} | Update a role |



## autocompleteRoles

> List&lt;ApiRoleSummary&gt; autocompleteRoles(tenant, apiAutocomplete)

List roles for autocomplete

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.RolesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        ApiAutocomplete apiAutocomplete = new ApiAutocomplete(); // ApiAutocomplete | Autocomplete request
        try {
            List<ApiRoleSummary> result = kestraClient.RolesApi().autocompleteRoles(tenant, apiAutocomplete);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RolesApi#autocompleteRoles");
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
| **apiAutocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)| Autocomplete request | |

### Return type

[**List&lt;ApiRoleSummary&gt;**](ApiRoleSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | autocompleteRoles 200 response |  -  |


## createRole

> IAMRoleControllerApiRoleDetail createRole(tenant, iaMRoleControllerApiRoleCreateOrUpdateRequest)

Create a role

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.RolesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        IAMRoleControllerApiRoleCreateOrUpdateRequest iaMRoleControllerApiRoleCreateOrUpdateRequest = new IAMRoleControllerApiRoleCreateOrUpdateRequest(); // IAMRoleControllerApiRoleCreateOrUpdateRequest | 
        try {
            IAMRoleControllerApiRoleDetail result = kestraClient.RolesApi().createRole(tenant, iaMRoleControllerApiRoleCreateOrUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RolesApi#createRole");
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
| **iaMRoleControllerApiRoleCreateOrUpdateRequest** | [**IAMRoleControllerApiRoleCreateOrUpdateRequest**](IAMRoleControllerApiRoleCreateOrUpdateRequest.md)|  | |

### Return type

[**IAMRoleControllerApiRoleDetail**](IAMRoleControllerApiRoleDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Role successfully created |  -  |
| **403** | Insufficient privileges to create the role |  -  |


## deleteRole

> deleteRole(id, tenant)

Delete a role

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.RolesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The role id
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.RolesApi().deleteRole(id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling RolesApi#deleteRole");
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
| **id** | **String**| The role id | |
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
| **204** | On success |  -  |


## listRolesFromGivenIds

> List&lt;Role&gt; listRolesFromGivenIds(tenant, apiIds)

List roles by ids

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.RolesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        ApiIds apiIds = new ApiIds(); // ApiIds | The ids that must be present on results
        try {
            List<Role> result = kestraClient.RolesApi().listRolesFromGivenIds(tenant, apiIds);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RolesApi#listRolesFromGivenIds");
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
| **apiIds** | [**ApiIds**](ApiIds.md)| The ids that must be present on results | |

### Return type

[**List&lt;Role&gt;**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listRolesFromGivenIds 200 response |  -  |


## role

> IAMRoleControllerApiRoleDetail role(id, tenant)

Retrieve a role

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.RolesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The role id
        String tenant = "tenant_example"; // String | 
        try {
            IAMRoleControllerApiRoleDetail result = kestraClient.RolesApi().role(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RolesApi#role");
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
| **id** | **String**| The role id | |
| **tenant** | **String**|  | |

### Return type

[**IAMRoleControllerApiRoleDetail**](IAMRoleControllerApiRoleDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getRole 200 response |  -  |
| **404** | Role not found |  -  |


## searchRoles

> PagedResultsApiRoleSummary searchRoles(page, size, tenant, q, sort)

Search for roles

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.RolesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | A string filter
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsApiRoleSummary result = kestraClient.RolesApi().searchRoles(page, size, tenant, q, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RolesApi#searchRoles");
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
| **tenant** | **String**|  | |
| **q** | **String**| A string filter | [optional] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsApiRoleSummary**](PagedResultsApiRoleSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchRoles 200 response |  -  |


## updateRole

> IAMRoleControllerApiRoleDetail updateRole(id, tenant, iaMRoleControllerApiRoleCreateOrUpdateRequest)

Update a role

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.RolesApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The role id
        String tenant = "tenant_example"; // String | 
        IAMRoleControllerApiRoleCreateOrUpdateRequest iaMRoleControllerApiRoleCreateOrUpdateRequest = new IAMRoleControllerApiRoleCreateOrUpdateRequest(); // IAMRoleControllerApiRoleCreateOrUpdateRequest | 
        try {
            IAMRoleControllerApiRoleDetail result = kestraClient.RolesApi().updateRole(id, tenant, iaMRoleControllerApiRoleCreateOrUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RolesApi#updateRole");
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
| **id** | **String**| The role id | |
| **tenant** | **String**|  | |
| **iaMRoleControllerApiRoleCreateOrUpdateRequest** | [**IAMRoleControllerApiRoleCreateOrUpdateRequest**](IAMRoleControllerApiRoleCreateOrUpdateRequest.md)|  | |

### Return type

[**IAMRoleControllerApiRoleDetail**](IAMRoleControllerApiRoleDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Role successfully updated |  -  |
| **403** | Insufficient privileges to update the role |  -  |
| **404** | Role not found |  -  |

