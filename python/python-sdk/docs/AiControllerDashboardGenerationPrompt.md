# AiControllerDashboardGenerationPrompt


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conversation_id** | **str** |  | 
**user_prompt** | **str** |  | 
**yaml** | **str** |  | [optional] 
**provider_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.ai_controller_dashboard_generation_prompt import AiControllerDashboardGenerationPrompt

# TODO update the JSON string below
json = "{}"
# create an instance of AiControllerDashboardGenerationPrompt from a JSON string
ai_controller_dashboard_generation_prompt_instance = AiControllerDashboardGenerationPrompt.from_json(json)
# print the JSON string representation of the object
print(AiControllerDashboardGenerationPrompt.to_json())

# convert the object into a dict
ai_controller_dashboard_generation_prompt_dict = ai_controller_dashboard_generation_prompt_instance.to_dict()
# create an instance of AiControllerDashboardGenerationPrompt from a dict
ai_controller_dashboard_generation_prompt_from_dict = AiControllerDashboardGenerationPrompt.from_dict(ai_controller_dashboard_generation_prompt_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


