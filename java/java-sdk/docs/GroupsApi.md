# GroupsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addUserToGroup**](GroupsApi.md#addUserToGroup) | **PUT** /api/v1/{tenant}/groups/{id}/members/{userId} | Add a user to a group |
| [**autocompleteGroups**](GroupsApi.md#autocompleteGroups) | **POST** /api/v1/{tenant}/groups/autocomplete | List groups for autocomplete |
| [**createGroup**](GroupsApi.md#createGroup) | **POST** /api/v1/{tenant}/groups | Create a group |
| [**deleteGroup**](GroupsApi.md#deleteGroup) | **DELETE** /api/v1/{tenant}/groups/{id} | Delete a group |
| [**deleteUserFromGroup**](GroupsApi.md#deleteUserFromGroup) | **DELETE** /api/v1/{tenant}/groups/{id}/members/{userId} | Remove a user from a group |
| [**group**](GroupsApi.md#group) | **GET** /api/v1/{tenant}/groups/{id} | Retrieve a group |
| [**listGroupIds**](GroupsApi.md#listGroupIds) | **POST** /api/v1/{tenant}/groups/ids | List groups by ids |
| [**searchGroupMembers**](GroupsApi.md#searchGroupMembers) | **GET** /api/v1/{tenant}/groups/{id}/members | Search for users in a group |
| [**searchGroups**](GroupsApi.md#searchGroups) | **GET** /api/v1/{tenant}/groups/search | Search for groups |
| [**setUserMembershipForGroup**](GroupsApi.md#setUserMembershipForGroup) | **PUT** /api/v1/{tenant}/groups/{id}/members/membership/{userId} | Update a user&#39;s membership type in a group |
| [**updateGroup**](GroupsApi.md#updateGroup) | **PUT** /api/v1/{tenant}/groups/{id} | Update a group |



## addUserToGroup

> IAMGroupControllerApiGroupMember addUserToGroup(id, userId, tenant)

Add a user to a group

Adds the specified user to the given group. If the user does not already have access to the tenant, tenant access will be created automatically.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The ID of the group
        String userId = "userId_example"; // String | The ID of the user to add to the group
        String tenant = "tenant_example"; // String | 
        try {
            IAMGroupControllerApiGroupMember result = kestraClient.GroupsApi().addUserToGroup(id, userId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#addUserToGroup");
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
| **id** | **String**| The ID of the group | |
| **userId** | **String**| The ID of the user to add to the group | |
| **tenant** | **String**|  | |

### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User was successfully added to the group |  -  |
| **404** | Group or user not found |  -  |
| **409** | User is already a member of the group |  -  |


## autocompleteGroups

> List&lt;ApiGroupSummary&gt; autocompleteGroups(tenant, apiAutocomplete)

List groups for autocomplete

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

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
            List<ApiGroupSummary> result = kestraClient.GroupsApi().autocompleteGroups(tenant, apiAutocomplete);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#autocompleteGroups");
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

[**List&lt;ApiGroupSummary&gt;**](ApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | autocompleteGroups 200 response |  -  |


## createGroup

> IAMGroupControllerApiGroupDetail createGroup(tenant, iaMGroupControllerApiCreateGroupRequest)

Create a group

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        IAMGroupControllerApiCreateGroupRequest iaMGroupControllerApiCreateGroupRequest = new IAMGroupControllerApiCreateGroupRequest(); // IAMGroupControllerApiCreateGroupRequest | The group
        try {
            IAMGroupControllerApiGroupDetail result = kestraClient.GroupsApi().createGroup(tenant, iaMGroupControllerApiCreateGroupRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#createGroup");
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
| **iaMGroupControllerApiCreateGroupRequest** | [**IAMGroupControllerApiCreateGroupRequest**](IAMGroupControllerApiCreateGroupRequest.md)| The group | |

### Return type

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Group was created successfully |  -  |
| **409** | A group with the given name already exists |  -  |


## deleteGroup

> deleteGroup(id, tenant)

Delete a group

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The group id
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.GroupsApi().deleteGroup(id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#deleteGroup");
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
| **id** | **String**| The group id | |
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
| **200** | Group was deleted successfully |  -  |
| **404** | Group not found |  -  |


## deleteUserFromGroup

> IAMGroupControllerApiGroupMember deleteUserFromGroup(id, userId, tenant)

Remove a user from a group

Removes the specified user from the given group. If the user has no other group bindings within the tenant, their access to the tenant will also be revoked.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The ID of the group
        String userId = "userId_example"; // String | The ID of the user to remove from the group
        String tenant = "tenant_example"; // String | 
        try {
            IAMGroupControllerApiGroupMember result = kestraClient.GroupsApi().deleteUserFromGroup(id, userId, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#deleteUserFromGroup");
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
| **id** | **String**| The ID of the group | |
| **userId** | **String**| The ID of the user to remove from the group | |
| **tenant** | **String**|  | |

### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User was successfully removed from the group |  -  |
| **404** | Group or user not found |  -  |
| **409** | User is not a member of the group |  -  |


## group

> IAMGroupControllerApiGroupDetail group(id, tenant)

Retrieve a group

Retrieves details of a specific group by its ID within the current tenant.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The group id
        String tenant = "tenant_example"; // String | 
        try {
            IAMGroupControllerApiGroupDetail result = kestraClient.GroupsApi().group(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#group");
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
| **id** | **String**| The group id | |
| **tenant** | **String**|  | |

### Return type

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Group details successfully retrieved |  -  |
| **404** | Group not found |  -  |


## listGroupIds

> List&lt;ApiGroupSummary&gt; listGroupIds(tenant, apiIds)

List groups by ids

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

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
            List<ApiGroupSummary> result = kestraClient.GroupsApi().listGroupIds(tenant, apiIds);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#listGroupIds");
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

[**List&lt;ApiGroupSummary&gt;**](ApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listGroupIds 200 response |  -  |


## searchGroupMembers

> PagedResultsIAMGroupControllerApiGroupMember searchGroupMembers(id, page, size, tenant, q, sort)

Search for users in a group

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The group id
        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | A string filter
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsIAMGroupControllerApiGroupMember result = kestraClient.GroupsApi().searchGroupMembers(id, page, size, tenant, q, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#searchGroupMembers");
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
| **id** | **String**| The group id | |
| **page** | **Integer**| The current page | [default to 1] |
| **size** | **Integer**| The current page size | [default to 10] |
| **tenant** | **String**|  | |
| **q** | **String**| A string filter | [optional] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsIAMGroupControllerApiGroupMember**](PagedResultsIAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchGroupMembers 200 response |  -  |


## searchGroups

> PagedResultsApiGroupSummary searchGroups(page, size, tenant, q, sort)

Search for groups

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

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
            PagedResultsApiGroupSummary result = kestraClient.GroupsApi().searchGroups(page, size, tenant, q, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#searchGroups");
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

[**PagedResultsApiGroupSummary**](PagedResultsApiGroupSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchGroups 200 response |  -  |


## setUserMembershipForGroup

> IAMGroupControllerApiGroupMember setUserMembershipForGroup(id, userId, membership, tenant)

Update a user&#39;s membership type in a group

Allows a group owner or an authorized user to change the role of a user within a group to OWNER or MEMBER.

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The ID of the group
        String userId = "userId_example"; // String | The ID of the user whose membership is being updated
        GroupIdentifierMembership membership = GroupIdentifierMembership.fromValue("OWNER"); // GroupIdentifierMembership | The new membership type to assign to the user.
        String tenant = "tenant_example"; // String | 
        try {
            IAMGroupControllerApiGroupMember result = kestraClient.GroupsApi().setUserMembershipForGroup(id, userId, membership, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#setUserMembershipForGroup");
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
| **id** | **String**| The ID of the group | |
| **userId** | **String**| The ID of the user whose membership is being updated | |
| **membership** | [**GroupIdentifierMembership**](.md)| The new membership type to assign to the user. | [enum: OWNER, MEMBER] |
| **tenant** | **String**|  | |

### Return type

[**IAMGroupControllerApiGroupMember**](IAMGroupControllerApiGroupMember.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Membership type successfully updated |  -  |
| **404** | User or group not found |  -  |
| **409** | User is not a member of the group |  -  |


## updateGroup

> IAMGroupControllerApiGroupDetail updateGroup(id, tenant, iaMGroupControllerApiUpdateGroupRequest)

Update a group

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.auth.*;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.GroupsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The group id
        String tenant = "tenant_example"; // String | 
        IAMGroupControllerApiUpdateGroupRequest iaMGroupControllerApiUpdateGroupRequest = new IAMGroupControllerApiUpdateGroupRequest(); // IAMGroupControllerApiUpdateGroupRequest | The group
        try {
            IAMGroupControllerApiGroupDetail result = kestraClient.GroupsApi().updateGroup(id, tenant, iaMGroupControllerApiUpdateGroupRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GroupsApi#updateGroup");
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
| **id** | **String**| The group id | |
| **tenant** | **String**|  | |
| **iaMGroupControllerApiUpdateGroupRequest** | [**IAMGroupControllerApiUpdateGroupRequest**](IAMGroupControllerApiUpdateGroupRequest.md)| The group | |

### Return type

[**IAMGroupControllerApiGroupDetail**](IAMGroupControllerApiGroupDetail.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Group was updated successfully |  -  |
| **404** | Group not found |  -  |
| **409** | A group with the given name already exists |  -  |

