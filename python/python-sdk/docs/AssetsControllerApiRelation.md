# AssetsControllerApiRelation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**kind** | [**RelationKind**](RelationKind.md) |  | [optional] 
**role** | **str** |  | [optional] 
**origin** | [**RelationOrigin**](RelationOrigin.md) |  | [optional] 
**state** | [**RelationState**](RelationState.md) |  | [optional] 
**source** | [**AssetsControllerApiRelationNode**](AssetsControllerApiRelationNode.md) |  | [optional] 
**target** | [**AssetsControllerApiRelationNode**](AssetsControllerApiRelationNode.md) |  | [optional] 
**provenance** | [**RelationProvenance**](RelationProvenance.md) |  | [optional] 
**created** | **datetime** |  | [optional] 
**updated** | **datetime** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.assets_controller_api_relation import AssetsControllerApiRelation

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiRelation from a JSON string
assets_controller_api_relation_instance = AssetsControllerApiRelation.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiRelation.to_json())

# convert the object into a dict
assets_controller_api_relation_dict = assets_controller_api_relation_instance.to_dict()
# create an instance of AssetsControllerApiRelation from a dict
assets_controller_api_relation_from_dict = AssetsControllerApiRelation.from_dict(assets_controller_api_relation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


