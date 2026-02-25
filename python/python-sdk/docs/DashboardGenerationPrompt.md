# DashboardGenerationPrompt


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conversation_id** | **str** |  | 
**user_prompt** | **str** |  | 
**yaml** | **str** |  | [optional] 
**provider_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.dashboard_generation_prompt import DashboardGenerationPrompt

# TODO update the JSON string below
json = "{}"
# create an instance of DashboardGenerationPrompt from a JSON string
dashboard_generation_prompt_instance = DashboardGenerationPrompt.from_json(json)
# print the JSON string representation of the object
print(DashboardGenerationPrompt.to_json())

# convert the object into a dict
dashboard_generation_prompt_dict = dashboard_generation_prompt_instance.to_dict()
# create an instance of DashboardGenerationPrompt from a dict
dashboard_generation_prompt_from_dict = DashboardGenerationPrompt.from_dict(dashboard_generation_prompt_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


