# TaskWithVersion


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cls** | **str** |  | [optional] 
**version** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.task_with_version import TaskWithVersion

# TODO update the JSON string below
json = "{}"
# create an instance of TaskWithVersion from a JSON string
task_with_version_instance = TaskWithVersion.from_json(json)
# print the JSON string representation of the object
print(TaskWithVersion.to_json())

# convert the object into a dict
task_with_version_dict = task_with_version_instance.to_dict()
# create an instance of TaskWithVersion from a dict
task_with_version_from_dict = TaskWithVersion.from_dict(task_with_version_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


