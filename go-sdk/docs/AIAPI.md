# \AIAPI

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GenerateFlow**](AIAPI.md#GenerateFlow) | **Post** /api/v1/{tenant}/ai/generate/flow | Generate or regenerate a flow based on a prompt



## GenerateFlow

> string GenerateFlow(ctx, tenant).FlowGenerationPrompt(flowGenerationPrompt).Execute()

Generate or regenerate a flow based on a prompt

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
)

func main() {
	tenant := "tenant_example" // string | 
	flowGenerationPrompt := *openapiclient.NewFlowGenerationPrompt("UserPrompt_example", "FlowYaml_example") // FlowGenerationPrompt | Prompt and context required for flow generation

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.AIAPI.GenerateFlow(context.Background(), tenant).FlowGenerationPrompt(flowGenerationPrompt).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `AIAPI.GenerateFlow``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `GenerateFlow`: string
	fmt.Fprintf(os.Stdout, "Response from `AIAPI.GenerateFlow`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**tenant** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGenerateFlowRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **flowGenerationPrompt** | [**FlowGenerationPrompt**](FlowGenerationPrompt.md) | Prompt and context required for flow generation | 

### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/yaml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

