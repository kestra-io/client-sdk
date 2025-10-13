# kestrapy.IAMUserGroupApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**update_user_groups**](IAMUserGroupApi.md#update_user_groups) | **PUT** /api/v1/{tenant}/users/{id}/groups | Update the list of groups a user belongs to for the given tenant


# **update_user_groups**
> update_user_groups(id, tenant, iam_user_group_controller_api_update_user_groups_request)

Update the list of groups a user belongs to for the given tenant

### Example

* Basic Authentication (basicAuth):
* Bearer (Bearer) Authentication (bearerAuth):

```python
import kestrapy
from kestrapy.models.iam_user_group_controller_api_update_user_groups_request import IAMUserGroupControllerApiUpdateUserGroupsRequest
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = kestrapy.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Configure Bearer authorization (Bearer): bearerAuth
configuration = kestrapy.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.IAMUserGroupApi(api_client)
    id = 'id_example' # str | The user ID
    tenant = 'tenant_example' # str | 
    iam_user_group_controller_api_update_user_groups_request = kestrapy.IAMUserGroupControllerApiUpdateUserGroupsRequest() # IAMUserGroupControllerApiUpdateUserGroupsRequest | 

    try:
        # Update the list of groups a user belongs to for the given tenant
        api_instance.update_user_groups(id, tenant, iam_user_group_controller_api_update_user_groups_request)
    except Exception as e:
        print("Exception when calling IAMUserGroupApi->update_user_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The user ID | 
 **tenant** | **str**|  | 
 **iam_user_group_controller_api_update_user_groups_request** | [**IAMUserGroupControllerApiUpdateUserGroupsRequest**](IAMUserGroupControllerApiUpdateUserGroupsRequest.md)|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | User&#39;s groups successfully updated |  -  |
**404** | User or one of the groups not found |  -  |
**400** | Invalid request payload |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

