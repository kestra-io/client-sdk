# KestraIoKestraSdk.AIApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**generateFlow**](AIApi.md#generateFlow) | **POST** /api/v1/{tenant}/ai/generate/flow | Generate or regenerate a flow based on a prompt



## generateFlow

> String generateFlow(tenant, flowGenerationPrompt)

Generate or regenerate a flow based on a prompt

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.AIApi();
let tenant = "tenant_example"; // String | 
let flowGenerationPrompt = new KestraIoKestraSdk.FlowGenerationPrompt(); // FlowGenerationPrompt | Prompt and context required for flow generation
apiInstance.generateFlow(tenant, flowGenerationPrompt, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **flowGenerationPrompt** | [**FlowGenerationPrompt**](FlowGenerationPrompt.md)| Prompt and context required for flow generation | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/yaml

