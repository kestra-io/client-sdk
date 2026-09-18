# TestSuiteGenerationPrompt


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conversation_id** | **str** |  | 
**user_prompt** | **str** |  | 
**yaml** | **str** |  | [optional] 
**provider_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.test_suite_generation_prompt import TestSuiteGenerationPrompt

# TODO update the JSON string below
json = "{}"
# create an instance of TestSuiteGenerationPrompt from a JSON string
test_suite_generation_prompt_instance = TestSuiteGenerationPrompt.from_json(json)
# print the JSON string representation of the object
print(TestSuiteGenerationPrompt.to_json())

# convert the object into a dict
test_suite_generation_prompt_dict = test_suite_generation_prompt_instance.to_dict()
# create an instance of TestSuiteGenerationPrompt from a dict
test_suite_generation_prompt_from_dict = TestSuiteGenerationPrompt.from_dict(test_suite_generation_prompt_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


