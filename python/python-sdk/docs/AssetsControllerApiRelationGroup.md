# AssetsControllerApiRelationGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**kind** | [**RelationKind**](RelationKind.md) |  | [optional] 
**direction** | [**RelationDirection**](RelationDirection.md) |  | [optional] 
**total** | **int** |  | [optional] 
**results** | [**List[AssetsControllerApiRelationItem]**](AssetsControllerApiRelationItem.md) |  | [optional] 
**next_cursor** | **str** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.assets_controller_api_relation_group import AssetsControllerApiRelationGroup

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiRelationGroup from a JSON string
assets_controller_api_relation_group_instance = AssetsControllerApiRelationGroup.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiRelationGroup.to_json())

# convert the object into a dict
assets_controller_api_relation_group_dict = assets_controller_api_relation_group_instance.to_dict()
# create an instance of AssetsControllerApiRelationGroup from a dict
assets_controller_api_relation_group_from_dict = AssetsControllerApiRelationGroup.from_dict(assets_controller_api_relation_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


