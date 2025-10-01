# ExecutionControllerLastExecutionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**start_date** | **datetime** |  | [optional] 
**status** | [**StateType**](StateType.md) |  | [optional] 

## Example

```python
from kestrapy.models.execution_controller_last_execution_response import ExecutionControllerLastExecutionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionControllerLastExecutionResponse from a JSON string
execution_controller_last_execution_response_instance = ExecutionControllerLastExecutionResponse.from_json(json)
# print the JSON string representation of the object
print(ExecutionControllerLastExecutionResponse.to_json())

# convert the object into a dict
execution_controller_last_execution_response_dict = execution_controller_last_execution_response_instance.to_dict()
# create an instance of ExecutionControllerLastExecutionResponse from a dict
execution_controller_last_execution_response_from_dict = ExecutionControllerLastExecutionResponse.from_dict(execution_controller_last_execution_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


