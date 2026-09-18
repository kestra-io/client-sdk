# AiControllerAiProviderResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**is_default** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.ai_controller_ai_provider_response import AiControllerAiProviderResponse

# TODO update the JSON string below
json = "{}"
# create an instance of AiControllerAiProviderResponse from a JSON string
ai_controller_ai_provider_response_instance = AiControllerAiProviderResponse.from_json(json)
# print the JSON string representation of the object
print(AiControllerAiProviderResponse.to_json())

# convert the object into a dict
ai_controller_ai_provider_response_dict = ai_controller_ai_provider_response_instance.to_dict()
# create an instance of AiControllerAiProviderResponse from a dict
ai_controller_ai_provider_response_from_dict = AiControllerAiProviderResponse.from_dict(ai_controller_ai_provider_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


