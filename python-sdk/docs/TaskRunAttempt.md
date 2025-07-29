# TaskRunAttempt


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**metrics** | [**List[AbstractMetricEntryObject]**](AbstractMetricEntryObject.md) |  | [optional] 
**state** | [**State**](State.md) |  | 
**worker_id** | **str** |  | [optional] 
**log_file** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.task_run_attempt import TaskRunAttempt

# TODO update the JSON string below
json = "{}"
# create an instance of TaskRunAttempt from a JSON string
task_run_attempt_instance = TaskRunAttempt.from_json(json)
# print the JSON string representation of the object
print(TaskRunAttempt.to_json())

# convert the object into a dict
task_run_attempt_dict = task_run_attempt_instance.to_dict()
# create an instance of TaskRunAttempt from a dict
task_run_attempt_from_dict = TaskRunAttempt.from_dict(task_run_attempt_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


