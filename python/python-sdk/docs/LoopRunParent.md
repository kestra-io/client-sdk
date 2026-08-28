# LoopRunParent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**index** | **int** |  | [optional] 
**key** | **str** |  | [optional] 
**value** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.loop_run_parent import LoopRunParent

# TODO update the JSON string below
json = "{}"
# create an instance of LoopRunParent from a JSON string
loop_run_parent_instance = LoopRunParent.from_json(json)
# print the JSON string representation of the object
print(LoopRunParent.to_json())

# convert the object into a dict
loop_run_parent_dict = loop_run_parent_instance.to_dict()
# create an instance of LoopRunParent from a dict
loop_run_parent_from_dict = LoopRunParent.from_dict(loop_run_parent_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


