# AppGenerationPrompt


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conversation_id** | **str** |  | [optional] 
**user_prompt** | **str** |  | [optional] 
**yaml** | **str** |  | [optional] 
**provider_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.app_generation_prompt import AppGenerationPrompt

# TODO update the JSON string below
json = "{}"
# create an instance of AppGenerationPrompt from a JSON string
app_generation_prompt_instance = AppGenerationPrompt.from_json(json)
# print the JSON string representation of the object
print(AppGenerationPrompt.to_json())

# convert the object into a dict
app_generation_prompt_dict = app_generation_prompt_instance.to_dict()
# create an instance of AppGenerationPrompt from a dict
app_generation_prompt_from_dict = AppGenerationPrompt.from_dict(app_generation_prompt_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


