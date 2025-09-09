# TaskRun


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**items** | **str** |  | [optional] 
**id** | **str** |  | 
**execution_id** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**task_id** | **str** |  | 
**parent_task_run_id** | **str** |  | 
**value** | **str** |  | 
**attempts** | [**List[TaskRunAttempt]**](TaskRunAttempt.md) |  | 
**outputs** | **Dict[str, object]** |  | 
**state** | [**State**](State.md) |  | 
**iteration** | **int** |  | 
**dynamic** | **bool** |  | 
**force_execution** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.task_run import TaskRun

# TODO update the JSON string below
json = "{}"
# create an instance of TaskRun from a JSON string
task_run_instance = TaskRun.from_json(json)
# print the JSON string representation of the object
print(TaskRun.to_json())

# convert the object into a dict
task_run_dict = task_run_instance.to_dict()
# create an instance of TaskRun from a dict
task_run_from_dict = TaskRun.from_dict(task_run_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


