# AssetsControllerApiRelationNode


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**type** | [**NodeType**](NodeType.md) |  | [optional] 
**asset_type** | **str** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.assets_controller_api_relation_node import AssetsControllerApiRelationNode

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiRelationNode from a JSON string
assets_controller_api_relation_node_instance = AssetsControllerApiRelationNode.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiRelationNode.to_json())

# convert the object into a dict
assets_controller_api_relation_node_dict = assets_controller_api_relation_node_instance.to_dict()
# create an instance of AssetsControllerApiRelationNode from a dict
assets_controller_api_relation_node_from_dict = AssetsControllerApiRelationNode.from_dict(assets_controller_api_relation_node_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


