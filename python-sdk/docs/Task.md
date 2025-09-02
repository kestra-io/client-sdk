# Task


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**version** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**retry** | **object** |  | [optional] 
**timeout** | [**PropertyDuration**](PropertyDuration.md) |  | [optional] 
**disabled** | **bool** |  | [optional] 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**log_level** | [**Level**](Level.md) |  | [optional] 
**allow_failure** | **bool** |  | [optional] 
**log_to_file** | **bool** |  | [optional] 
**run_if** | **str** |  | [optional] 
**allow_warning** | **bool** |  | [optional] 
**task_cache** | [**Cache**](Cache.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.task import Task

# TODO update the JSON string below
json = "{}"
# create an instance of Task from a JSON string
task_instance = Task.from_json(json)
# print the JSON string representation of the object
print(Task.to_json())

# convert the object into a dict
task_dict = task_instance.to_dict()
# create an instance of Task from a dict
task_from_dict = Task.from_dict(task_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


