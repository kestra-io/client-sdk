# BlueprintWithFlowEntity


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
**template** | [**BlueprintTemplate**](BlueprintTemplate.md) |  | [optional] 
**flow** | **str** |  | 

## Example

```python
from kestrapy.models.blueprint_with_flow_entity import BlueprintWithFlowEntity

# TODO update the JSON string below
json = "{}"
# create an instance of BlueprintWithFlowEntity from a JSON string
blueprint_with_flow_entity_instance = BlueprintWithFlowEntity.from_json(json)
# print the JSON string representation of the object
print(BlueprintWithFlowEntity.to_json())

# convert the object into a dict
blueprint_with_flow_entity_dict = blueprint_with_flow_entity_instance.to_dict()
# create an instance of BlueprintWithFlowEntity from a dict
blueprint_with_flow_entity_from_dict = BlueprintWithFlowEntity.from_dict(blueprint_with_flow_entity_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


