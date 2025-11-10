# ExecutionControllerEvalResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**result** | **str** |  | [optional] 
**error** | **str** |  | [optional] 
**stack_trace** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.execution_controller_eval_result import ExecutionControllerEvalResult

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionControllerEvalResult from a JSON string
execution_controller_eval_result_instance = ExecutionControllerEvalResult.from_json(json)
# print the JSON string representation of the object
print(ExecutionControllerEvalResult.to_json())

# convert the object into a dict
execution_controller_eval_result_dict = execution_controller_eval_result_instance.to_dict()
# create an instance of ExecutionControllerEvalResult from a dict
execution_controller_eval_result_from_dict = ExecutionControllerEvalResult.from_dict(execution_controller_eval_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


