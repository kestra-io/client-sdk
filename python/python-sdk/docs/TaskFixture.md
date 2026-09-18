# TaskFixture


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**value** | **str** |  | [optional] 
**state** | [**StateType**](StateType.md) |  | [optional] 
**outputs** | **Dict[str, object]** |  | [optional] 
**assets** | [**List[Asset]**](Asset.md) |  | [optional] 
**description** | [**PropertyString**](PropertyString.md) |  | [optional] 

## Example

```python
from kestrapy.models.task_fixture import TaskFixture

# TODO update the JSON string below
json = "{}"
# create an instance of TaskFixture from a JSON string
task_fixture_instance = TaskFixture.from_json(json)
# print the JSON string representation of the object
print(TaskFixture.to_json())

# convert the object into a dict
task_fixture_dict = task_fixture_instance.to_dict()
# create an instance of TaskFixture from a dict
task_fixture_from_dict = TaskFixture.from_dict(task_fixture_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


