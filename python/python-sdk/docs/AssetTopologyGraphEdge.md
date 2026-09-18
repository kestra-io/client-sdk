# AssetTopologyGraphEdge


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**source** | **str** |  | [optional] 
**target** | **str** |  | [optional] 
**relation** | [**Relation1**](Relation1.md) |  | [optional] 

## Example

```python
from kestrapy.models.asset_topology_graph_edge import AssetTopologyGraphEdge

# TODO update the JSON string below
json = "{}"
# create an instance of AssetTopologyGraphEdge from a JSON string
asset_topology_graph_edge_instance = AssetTopologyGraphEdge.from_json(json)
# print the JSON string representation of the object
print(AssetTopologyGraphEdge.to_json())

# convert the object into a dict
asset_topology_graph_edge_dict = asset_topology_graph_edge_instance.to_dict()
# create an instance of AssetTopologyGraphEdge from a dict
asset_topology_graph_edge_from_dict = AssetTopologyGraphEdge.from_dict(asset_topology_graph_edge_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


