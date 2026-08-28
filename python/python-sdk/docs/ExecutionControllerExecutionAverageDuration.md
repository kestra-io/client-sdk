# ExecutionControllerExecutionAverageDuration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**avg_duration_ms** | **int** |  | [optional] 
**count** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.execution_controller_execution_average_duration import ExecutionControllerExecutionAverageDuration

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionControllerExecutionAverageDuration from a JSON string
execution_controller_execution_average_duration_instance = ExecutionControllerExecutionAverageDuration.from_json(json)
# print the JSON string representation of the object
print(ExecutionControllerExecutionAverageDuration.to_json())

# convert the object into a dict
execution_controller_execution_average_duration_dict = execution_controller_execution_average_duration_instance.to_dict()
# create an instance of ExecutionControllerExecutionAverageDuration from a dict
execution_controller_execution_average_duration_from_dict = ExecutionControllerExecutionAverageDuration.from_dict(execution_controller_execution_average_duration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


