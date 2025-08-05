# AiApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**generateFlow**](AiApi.md#generateFlow) | **POST** /api/v1/{tenant}/ai/generate/flow | Generate or regenerate a flow based on a prompt |



## generateFlow

> String generateFlow(tenant, flowGenerationPrompt)

Generate or regenerate a flow based on a prompt

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.AiApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        AiApi apiInstance = new AiApi(defaultClient);
        String tenant = "tenant_example"; // String | 
        FlowGenerationPrompt flowGenerationPrompt = new FlowGenerationPrompt(); // FlowGenerationPrompt | Prompt and context required for flow generation
        try {
            String result = apiInstance.generateFlow(tenant, flowGenerationPrompt);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AiApi#generateFlow");
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
| **flowGenerationPrompt** | [**FlowGenerationPrompt**](FlowGenerationPrompt.md)| Prompt and context required for flow generation | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/yaml


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | generateFlow 200 response |  -  |

