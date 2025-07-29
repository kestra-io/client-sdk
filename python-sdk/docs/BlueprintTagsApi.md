# kestrapy.BlueprintTagsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**internal_blueprint_tags**](BlueprintTagsApi.md#internal_blueprint_tags) | **GET** /api/v1/{tenant}/blueprints/custom/tags | List all internal blueprint tags
[**list_blueprint_tags**](BlueprintTagsApi.md#list_blueprint_tags) | **GET** /api/v1/{tenant}/blueprints/community/{kind}/tags | List blueprint tags matching the filter


# **internal_blueprint_tags**
> List[str] internal_blueprint_tags(tenant, q=q)

List all internal blueprint tags

Lists all tags used by internal (custom) blueprints for the current tenant.

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintTagsApi(api_client)
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter to get tags with matching blueprints only (optional)

    try:
        # List all internal blueprint tags
        api_response = api_instance.internal_blueprint_tags(tenant, q=q)
        print("The response of BlueprintTagsApi->internal_blueprint_tags:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintTagsApi->internal_blueprint_tags: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **q** | **str**| A string filter to get tags with matching blueprints only | [optional] 

### Return type

**List[str]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | internalBlueprintTags 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_blueprint_tags**
> List[BlueprintControllerApiBlueprintTagItem] list_blueprint_tags(kind, tenant, q=q)

List blueprint tags matching the filter

Lists tags for community blueprints of the specified kind, optionally filtered by query.

### Example


```python
import kestrapy
from kestrapy.models.blueprint_controller_api_blueprint_tag_item import BlueprintControllerApiBlueprintTagItem
from kestrapy.models.blueprint_controller_kind import BlueprintControllerKind
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.BlueprintTagsApi(api_client)
    kind = kestrapy.BlueprintControllerKind() # BlueprintControllerKind | The blueprint kind
    tenant = 'tenant_example' # str | 
    q = 'q_example' # str | A string filter to get tags with matching blueprints only (optional)

    try:
        # List blueprint tags matching the filter
        api_response = api_instance.list_blueprint_tags(kind, tenant, q=q)
        print("The response of BlueprintTagsApi->list_blueprint_tags:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlueprintTagsApi->list_blueprint_tags: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **str**|  | 
 **q** | **str**| A string filter to get tags with matching blueprints only | [optional] 

### Return type

[**List[BlueprintControllerApiBlueprintTagItem]**](BlueprintControllerApiBlueprintTagItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | listBlueprintTags 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

