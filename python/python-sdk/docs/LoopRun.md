# LoopRun


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**parent** | [**Execution**](Execution.md) |  | [optional] 
**task_id** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 
**index** | **int** |  | [optional] 
**key** | **str** |  | [optional] 
**value** | **str** |  | [optional] 
**parents** | [**List[LoopRunParent]**](LoopRunParent.md) |  | [optional] 

## Example

```python
from kestrapy.models.loop_run import LoopRun

# TODO update the JSON string below
json = "{}"
# create an instance of LoopRun from a JSON string
loop_run_instance = LoopRun.from_json(json)
# print the JSON string representation of the object
print(LoopRun.to_json())

# convert the object into a dict
loop_run_dict = loop_run_instance.to_dict()
# create an instance of LoopRun from a dict
loop_run_from_dict = LoopRun.from_dict(loop_run_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


