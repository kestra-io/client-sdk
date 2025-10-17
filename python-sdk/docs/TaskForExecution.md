# TaskForExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**version** | **str** |  | [optional] 
**tasks** | [**List[TaskForExecution]**](TaskForExecution.md) |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | [optional] 
**subflow_id** | [**ExecutableTaskSubflowId**](ExecutableTaskSubflowId.md) |  | [optional] 

## Example

```python
from kestrapy.models.task_for_execution import TaskForExecution

# TODO update the JSON string below
json = "{}"
# create an instance of TaskForExecution from a JSON string
task_for_execution_instance = TaskForExecution.from_json(json)
# print the JSON string representation of the object
print(TaskForExecution.to_json())

# convert the object into a dict
task_for_execution_dict = task_for_execution_instance.to_dict()
# create an instance of TaskForExecution from a dict
task_for_execution_from_dict = TaskForExecution.from_dict(task_for_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


