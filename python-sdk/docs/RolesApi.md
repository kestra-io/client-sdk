# kestrapy.roles

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocomplete_roles**](roles.md#autocomplete_roles) | **POST** /api/v1/{tenant}/roles/autocomplete | List roles for autocomplete
[**create_role**](roles.md#create_role) | **POST** /api/v1/{tenant}/roles | Create a role
[**delete_role**](roles.md#delete_role) | **DELETE** /api/v1/{tenant}/roles/{id} | Delete a role
[**list_roles_from_given_ids**](roles.md#list_roles_from_given_ids) | **POST** /api/v1/{tenant}/roles/ids | List roles by ids
[**role**](roles.md#role) | **GET** /api/v1/{tenant}/roles/{id} | Retrieve a role
[**search_roles**](roles.md#search_roles) | **GET** /api/v1/{tenant}/roles/search | Search for roles
[**update_role**](roles.md#update_role) | **PUT** /api/v1/{tenant}/roles/{id} | Update a role


# **autocomplete_roles**
> List[ApiRoleSummary] autocomplete_roles(tenant, api_autocomplete)

List roles for autocomplete

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str | 
    api_autocomplete = kestrapy.ApiAutocomplete() # ApiAutocomplete | Autocomplete request

    try:
        # List roles for autocomplete
        api_response = kestra_client.roles.autocomplete_roles(tenant, api_autocomplete)
        print("The response of roles->autocomplete_roles:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling roles->autocomplete_roles: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **api_autocomplete** | [**ApiAutocomplete**](ApiAutocomplete.md)| Autocomplete request | 

### Return type

[**List[ApiRoleSummary]**](ApiRoleSummary.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | autocompleteRoles 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_role**
> IAMRoleControllerApiRoleDetail create_role(tenant, iam_role_controller_api_role_create_or_update_request)

Create a role

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str | 
    iam_role_controller_api_role_create_or_update_request = kestrapy.IAMRoleControllerApiRoleCreateOrUpdateRequest() # IAMRoleControllerApiRoleCreateOrUpdateRequest | 

    try:
        # Create a role
        api_response = kestra_client.roles.create_role(tenant, iam_role_controller_api_role_create_or_update_request)
        print("The response of roles->create_role:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling roles->create_role: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **iam_role_controller_api_role_create_or_update_request** | [**IAMRoleControllerApiRoleCreateOrUpdateRequest**](IAMRoleControllerApiRoleCreateOrUpdateRequest.md)|  | 

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
**200** | Role successfully created |  -  |
**403** | Insufficient privileges to create the role |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_role**
> delete_role(id, tenant)

Delete a role

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    id = 'id_example' # str | The role id
    tenant = 'tenant_example' # str | 

    try:
        # Delete a role
        kestra_client.roles.delete_role(id, tenant)
    except Exception as e:
        print("Exception when calling roles->delete_role: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The role id | 
 **tenant** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | On success |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_roles_from_given_ids**
> List[Role] list_roles_from_given_ids(tenant, api_ids)

List roles by ids

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    tenant = 'tenant_example' # str | 
    api_ids = kestrapy.ApiIds() # ApiIds | The ids that must be present on results

    try:
        # List roles by ids
        api_response = kestra_client.roles.list_roles_from_given_ids(tenant, api_ids)
        print("The response of roles->list_roles_from_given_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling roles->list_roles_from_given_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **api_ids** | [**ApiIds**](ApiIds.md)| The ids that must be present on results | 

### Return type

[**List[Role]**](Role.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listRolesFromGivenIds 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **role**
> IAMRoleControllerApiRoleDetail role(id, tenant)

Retrieve a role

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    id = 'id_example' # str | The role id
    tenant = 'tenant_example' # str | 

    try:
        # Retrieve a role
        api_response = kestra_client.roles.role(id, tenant)
        print("The response of roles->role:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling roles->role: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The role id | 
 **tenant** | **str**|  | 

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
**200** | getRole 200 response |  -  |
**404** | Role not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_roles**
> PagedResultsApiRoleSummary search_roles(page, size, tenant, q=q, sort=sort)

Search for roles

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    page = 1 # int | The current page (default to 1)
    size = 10 # int | The current page size (default to 10)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter (optional)
    sort = ['sort_example'] # List[str] | The sort of current page (optional)

    try:
        # Search for roles
        api_response = kestra_client.roles.search_roles(page, size, tenant, q=q, sort=sort)
        print("The response of roles->search_roles:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling roles->search_roles: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| The current page | [default to 1]
 **size** | **int**| The current page size | [default to 10]
 **tenant** | **str**|  | 
 **q** | **str**| A string filter | [optional] 
 **sort** | [**List[str]**](str.md)| The sort of current page | [optional] 

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
**200** | searchRoles 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_role**
> IAMRoleControllerApiRoleDetail update_role(id, tenant, iam_role_controller_api_role_create_or_update_request)

Update a role

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
from kestrapy import KestraClient, Configuration

configuration = Configuration()

configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

# Enter a context with an instance of the API client
with KestraClient(configuration) as kestra_client:
    id = 'id_example' # str | The role id
    tenant = 'tenant_example' # str | 
    iam_role_controller_api_role_create_or_update_request = kestrapy.IAMRoleControllerApiRoleCreateOrUpdateRequest() # IAMRoleControllerApiRoleCreateOrUpdateRequest | 

    try:
        # Update a role
        api_response = kestra_client.roles.update_role(id, tenant, iam_role_controller_api_role_create_or_update_request)
        print("The response of roles->update_role:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling roles->update_role: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The role id | 
 **tenant** | **str**|  | 
 **iam_role_controller_api_role_create_or_update_request** | [**IAMRoleControllerApiRoleCreateOrUpdateRequest**](IAMRoleControllerApiRoleCreateOrUpdateRequest.md)|  | 

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
**200** | Role successfully updated |  -  |
**403** | Insufficient privileges to update the role |  -  |
**404** | Role not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

