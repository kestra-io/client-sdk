# AssetRelationGraphEdge


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**source** | **str** |  | [optional] 
**target** | **str** |  | [optional] 
**kind** | [**RelationKind**](RelationKind.md) |  | [optional] 
**directed** | **bool** |  | [optional] 
**role** | **str** |  | [optional] 
**origin** | [**RelationOrigin**](RelationOrigin.md) |  | [optional] 
**task_type** | **str** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.asset_relation_graph_edge import AssetRelationGraphEdge

# TODO update the JSON string below
json = "{}"
# create an instance of AssetRelationGraphEdge from a JSON string
asset_relation_graph_edge_instance = AssetRelationGraphEdge.from_json(json)
# print the JSON string representation of the object
print(AssetRelationGraphEdge.to_json())

# convert the object into a dict
asset_relation_graph_edge_dict = asset_relation_graph_edge_instance.to_dict()
# create an instance of AssetRelationGraphEdge from a dict
asset_relation_graph_edge_from_dict = AssetRelationGraphEdge.from_dict(asset_relation_graph_edge_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


