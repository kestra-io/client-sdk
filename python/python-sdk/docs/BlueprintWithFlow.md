# BlueprintWithFlow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**title** | **str** |  | 
**description** | **str** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**included_tasks** | **List[str]** |  | [optional] 
**published_at** | **datetime** |  | [optional] 
**deleted** | **bool** |  | 
**flow** | **str** |  | 

## Example

```python
from kestrapy.models.blueprint_with_flow import BlueprintWithFlow

# TODO update the JSON string below
json = "{}"
# create an instance of BlueprintWithFlow from a JSON string
blueprint_with_flow_instance = BlueprintWithFlow.from_json(json)
# print the JSON string representation of the object
print(BlueprintWithFlow.to_json())

# convert the object into a dict
blueprint_with_flow_dict = blueprint_with_flow_instance.to_dict()
# create an instance of BlueprintWithFlow from a dict
blueprint_with_flow_from_dict = BlueprintWithFlow.from_dict(blueprint_with_flow_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


