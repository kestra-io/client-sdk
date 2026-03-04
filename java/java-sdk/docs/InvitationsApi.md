# InvitationsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createInvitation**](InvitationsApi.md#createInvitation) | **POST** /api/v1/{tenant}/invitations | Create an invitation |
| [**deleteInvitation**](InvitationsApi.md#deleteInvitation) | **DELETE** /api/v1/{tenant}/invitations/{id} | Delete an invitation |
| [**findAllInvitationsForCurrentUser**](InvitationsApi.md#findAllInvitationsForCurrentUser) | **GET** /api/v1/me/invitations | List invitations for the authenticated user |
| [**invitation**](InvitationsApi.md#invitation) | **GET** /api/v1/{tenant}/invitations/{id} | Retrieve an invitation |
| [**listInvitationsByEmail**](InvitationsApi.md#listInvitationsByEmail) | **GET** /api/v1/{tenant}/invitations/email/{email} | Retrieve all invitations for a given email |
| [**searchInvitations**](InvitationsApi.md#searchInvitations) | **GET** /api/v1/{tenant}/invitations/search | Search for invitations |



## createInvitation

> createInvitation(tenant, iaMInvitationControllerApiInvitationCreateRequest)

Create an invitation

Creates a new invitation and sends an email if the mail server is enabled.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.InvitationsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        IAMInvitationControllerApiInvitationCreateRequest iaMInvitationControllerApiInvitationCreateRequest = new IAMInvitationControllerApiInvitationCreateRequest(); // IAMInvitationControllerApiInvitationCreateRequest | Create a new invitation, send an email if the server-mail is enabled
        try {
            kestraClient.InvitationsApi().createInvitation(tenant, iaMInvitationControllerApiInvitationCreateRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvitationsApi#createInvitation");
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
| **iaMInvitationControllerApiInvitationCreateRequest** | [**IAMInvitationControllerApiInvitationCreateRequest**](IAMInvitationControllerApiInvitationCreateRequest.md)| Create a new invitation, send an email if the server-mail is enabled | |

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
| **201** | Invitation successfully created |  -  |
| **204** | Tenant access granted to the user |  -  |
| **403** | Insufficient privileges to invite a Superadmin user |  -  |
| **409** | Invitation already exists for the given email, or user already had access to the tenant |  -  |


## deleteInvitation

> deleteInvitation(id, tenant)

Delete an invitation

Deletes the invitation by its ID.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.InvitationsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The id of the invitation
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.InvitationsApi().deleteInvitation(id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvitationsApi#deleteInvitation");
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
| **id** | **String**| The id of the invitation | |
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
| **204** | Invitation successfully deleted |  -  |
| **404** | Invitation not found |  -  |


## findAllInvitationsForCurrentUser

> List&lt;Invitation&gt; findAllInvitationsForCurrentUser()

List invitations for the authenticated user

Returns all invitations for the authenticated user&#39;s email across all tenants.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.InvitationsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        try {
            List<Invitation> result = kestraClient.InvitationsApi().findAllInvitationsForCurrentUser();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvitationsApi#findAllInvitationsForCurrentUser");
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

[**List&lt;Invitation&gt;**](Invitation.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | findAllInvitationsForCurrentUser 200 response |  -  |


## invitation

> IAMInvitationControllerApiInvitationDetail invitation(id, tenant)

Retrieve an invitation

Retrieves the invitation by its ID, including the invitation link.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.InvitationsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The id of the invitation
        String tenant = "tenant_example"; // String | 
        try {
            IAMInvitationControllerApiInvitationDetail result = kestraClient.InvitationsApi().invitation(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvitationsApi#invitation");
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
| **id** | **String**| The id of the invitation | |
| **tenant** | **String**|  | |

### Return type

[**IAMInvitationControllerApiInvitationDetail**](IAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getInvitation 200 response |  -  |
| **404** | Invitation not found |  -  |


## listInvitationsByEmail

> List&lt;IAMInvitationControllerApiInvitationDetail&gt; listInvitationsByEmail(email, tenant)

Retrieve all invitations for a given email

Returns all invitations created for a given email address in the current tenant.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.InvitationsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String email = "email_example"; // String | The email address of the invited
        String tenant = "tenant_example"; // String | 
        try {
            List<IAMInvitationControllerApiInvitationDetail> result = kestraClient.InvitationsApi().listInvitationsByEmail(email, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvitationsApi#listInvitationsByEmail");
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
| **email** | **String**| The email address of the invited | |
| **tenant** | **String**|  | |

### Return type

[**List&lt;IAMInvitationControllerApiInvitationDetail&gt;**](IAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listInvitationsByEmail 200 response |  -  |


## searchInvitations

> PagedResultsIAMInvitationControllerApiInvitationDetail searchInvitations(page, size, filters, tenant, sort)

Search for invitations

Search and filter invitations by email, status, and pagination.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.InvitationsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        List<QueryFilter> filters = Arrays.asList(); // List<QueryFilter> | Filters
        String tenant = "tenant_example"; // String | 
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsIAMInvitationControllerApiInvitationDetail result = kestraClient.InvitationsApi().searchInvitations(page, size, filters, tenant, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvitationsApi#searchInvitations");
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
| **filters** | [**List&lt;QueryFilter&gt;**](QueryFilter.md)| Filters | |
| **tenant** | **String**|  | |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsIAMInvitationControllerApiInvitationDetail**](PagedResultsIAMInvitationControllerApiInvitationDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchInvitations 200 response |  -  |

