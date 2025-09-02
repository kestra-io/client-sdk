# kestra_api_client.AIApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**generate_flow**](AIApi.md#generate_flow) | **POST** /api/v1/{tenant}/ai/generate/flow | Generate or regenerate a flow based on a prompt


# **generate_flow**
> str generate_flow(tenant, flow_generation_prompt)

Generate or regenerate a flow based on a prompt

### Example


```python
import kestra_api_client
from kestra_api_client.models.flow_generation_prompt import FlowGenerationPrompt
from kestra_api_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestra_api_client.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestra_api_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestra_api_client.AIApi(api_client)
    tenant = 'tenant_example' # str | 
    flow_generation_prompt = kestra_api_client.FlowGenerationPrompt() # FlowGenerationPrompt | Prompt and context required for flow generation

    try:
        # Generate or regenerate a flow based on a prompt
        api_response = api_instance.generate_flow(tenant, flow_generation_prompt)
        print("The response of AIApi->generate_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AIApi->generate_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **str**|  | 
 **flow_generation_prompt** | [**FlowGenerationPrompt**](FlowGenerationPrompt.md)| Prompt and context required for flow generation | 

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/yaml

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | generateFlow 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

