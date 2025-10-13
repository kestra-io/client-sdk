# kestrapy.DependenciesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_flow_dependencies_from_tenant**](DependenciesApi.md#get_flow_dependencies_from_tenant) | **GET** /api/v1/{tenant}/dependencies | Get tenant dependencies


# **get_flow_dependencies_from_tenant**
> FlowTopologyGraph get_flow_dependencies_from_tenant(destination_only, tenant)

Get tenant dependencies

### Example


```python
import kestrapy
from kestrapy.models.flow_topology_graph import FlowTopologyGraph
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
    api_instance = kestrapy.DependenciesApi(api_client)
    destination_only = False # bool | if true, list only destination dependencies, otherwise list also source dependencies (default to False)
    tenant = 'tenant_example' # str | 

    try:
        # Get tenant dependencies
        api_response = api_instance.get_flow_dependencies_from_tenant(destination_only, tenant)
        print("The response of DependenciesApi->get_flow_dependencies_from_tenant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DependenciesApi->get_flow_dependencies_from_tenant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **destination_only** | **bool**| if true, list only destination dependencies, otherwise list also source dependencies | [default to False]
 **tenant** | **str**|  | 

### Return type

[**FlowTopologyGraph**](FlowTopologyGraph.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | getFlowDependenciesFromTenant 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

