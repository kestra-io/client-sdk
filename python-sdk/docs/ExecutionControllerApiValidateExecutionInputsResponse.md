# ExecutionControllerApiValidateExecutionInputsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**inputs** | [**List[ExecutionControllerApiValidateExecutionInputsResponseApiInputAndValue]**](ExecutionControllerApiValidateExecutionInputsResponseApiInputAndValue.md) |  | [optional] 

## Example

```python
from kestrapy.models.execution_controller_api_validate_execution_inputs_response import ExecutionControllerApiValidateExecutionInputsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionControllerApiValidateExecutionInputsResponse from a JSON string
execution_controller_api_validate_execution_inputs_response_instance = ExecutionControllerApiValidateExecutionInputsResponse.from_json(json)
# print the JSON string representation of the object
print(ExecutionControllerApiValidateExecutionInputsResponse.to_json())

# convert the object into a dict
execution_controller_api_validate_execution_inputs_response_dict = execution_controller_api_validate_execution_inputs_response_instance.to_dict()
# create an instance of ExecutionControllerApiValidateExecutionInputsResponse from a dict
execution_controller_api_validate_execution_inputs_response_from_dict = ExecutionControllerApiValidateExecutionInputsResponse.from_dict(execution_controller_api_validate_execution_inputs_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


