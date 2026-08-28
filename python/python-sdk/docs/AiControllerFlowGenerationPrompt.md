# AiControllerFlowGenerationPrompt


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conversation_id** | **str** |  | 
**user_prompt** | **str** |  | 
**yaml** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**provider_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.ai_controller_flow_generation_prompt import AiControllerFlowGenerationPrompt

# TODO update the JSON string below
json = "{}"
# create an instance of AiControllerFlowGenerationPrompt from a JSON string
ai_controller_flow_generation_prompt_instance = AiControllerFlowGenerationPrompt.from_json(json)
# print the JSON string representation of the object
print(AiControllerFlowGenerationPrompt.to_json())

# convert the object into a dict
ai_controller_flow_generation_prompt_dict = ai_controller_flow_generation_prompt_instance.to_dict()
# create an instance of AiControllerFlowGenerationPrompt from a dict
ai_controller_flow_generation_prompt_from_dict = AiControllerFlowGenerationPrompt.from_dict(ai_controller_flow_generation_prompt_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


