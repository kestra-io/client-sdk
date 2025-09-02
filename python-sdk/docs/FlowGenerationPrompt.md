# FlowGenerationPrompt


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**user_prompt** | **str** |  | 
**flow_yaml** | **str** |  | 

## Example

```python
from kestra_api_client.models.flow_generation_prompt import FlowGenerationPrompt

# TODO update the JSON string below
json = "{}"
# create an instance of FlowGenerationPrompt from a JSON string
flow_generation_prompt_instance = FlowGenerationPrompt.from_json(json)
# print the JSON string representation of the object
print(FlowGenerationPrompt.to_json())

# convert the object into a dict
flow_generation_prompt_dict = flow_generation_prompt_instance.to_dict()
# create an instance of FlowGenerationPrompt from a dict
flow_generation_prompt_from_dict = FlowGenerationPrompt.from_dict(flow_generation_prompt_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


