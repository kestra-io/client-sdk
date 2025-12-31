# ExecutionControllerApiValidateExecutionInputsResponseApiCheckFailure


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**message** | **str** |  | [optional] 
**style** | [**CheckStyle**](CheckStyle.md) |  | [optional] 
**behavior** | [**CheckBehavior**](CheckBehavior.md) |  | [optional] 

## Example

```python
from kestrapy.models.execution_controller_api_validate_execution_inputs_response_api_check_failure import ExecutionControllerApiValidateExecutionInputsResponseApiCheckFailure

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionControllerApiValidateExecutionInputsResponseApiCheckFailure from a JSON string
execution_controller_api_validate_execution_inputs_response_api_check_failure_instance = ExecutionControllerApiValidateExecutionInputsResponseApiCheckFailure.from_json(json)
# print the JSON string representation of the object
print(ExecutionControllerApiValidateExecutionInputsResponseApiCheckFailure.to_json())

# convert the object into a dict
execution_controller_api_validate_execution_inputs_response_api_check_failure_dict = execution_controller_api_validate_execution_inputs_response_api_check_failure_instance.to_dict()
# create an instance of ExecutionControllerApiValidateExecutionInputsResponseApiCheckFailure from a dict
execution_controller_api_validate_execution_inputs_response_api_check_failure_from_dict = ExecutionControllerApiValidateExecutionInputsResponseApiCheckFailure.from_dict(execution_controller_api_validate_execution_inputs_response_api_check_failure_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


