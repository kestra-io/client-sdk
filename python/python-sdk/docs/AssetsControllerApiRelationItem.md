# AssetsControllerApiRelationItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**relation** | [**AssetsControllerApiRelation**](AssetsControllerApiRelation.md) |  | [optional] 
**node** | [**AssetsControllerApiRelationNode**](AssetsControllerApiRelationNode.md) |  | [optional] 
**asset** | [**AssetsControllerApiAsset**](AssetsControllerApiAsset.md) |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.assets_controller_api_relation_item import AssetsControllerApiRelationItem

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiRelationItem from a JSON string
assets_controller_api_relation_item_instance = AssetsControllerApiRelationItem.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiRelationItem.to_json())

# convert the object into a dict
assets_controller_api_relation_item_dict = assets_controller_api_relation_item_instance.to_dict()
# create an instance of AssetsControllerApiRelationItem from a dict
assets_controller_api_relation_item_from_dict = AssetsControllerApiRelationItem.from_dict(assets_controller_api_relation_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


