# ExecutionControllerLastExecutionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**flow_id** | **str** |  | 
**namespace** | **str** |  | 
**start_date** | **datetime** |  | 
**status** | [**StateType**](StateType.md) |  | 

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


