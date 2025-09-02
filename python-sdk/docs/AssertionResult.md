# AssertionResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operator** | **str** |  | 
**expected** | **object** |  | 
**actual** | **object** |  | 
**is_success** | **bool** |  | 
**task_id** | **str** |  | 
**description** | **str** |  | 
**error_message** | **str** |  | 

## Example

```python
from kestra_api_client.models.assertion_result import AssertionResult

# TODO update the JSON string below
json = "{}"
# create an instance of AssertionResult from a JSON string
assertion_result_instance = AssertionResult.from_json(json)
# print the JSON string representation of the object
print(AssertionResult.to_json())

# convert the object into a dict
assertion_result_dict = assertion_result_instance.to_dict()
# create an instance of AssertionResult from a dict
assertion_result_from_dict = AssertionResult.from_dict(assertion_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


