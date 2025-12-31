# AssetTopologyGraphNode


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | 
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**type** | [**AssetTopologyGraphNodeNodeType**](AssetTopologyGraphNodeNodeType.md) |  | [optional] 

## Example

```python
from kestrapy.models.asset_topology_graph_node import AssetTopologyGraphNode

# TODO update the JSON string below
json = "{}"
# create an instance of AssetTopologyGraphNode from a JSON string
asset_topology_graph_node_instance = AssetTopologyGraphNode.from_json(json)
# print the JSON string representation of the object
print(AssetTopologyGraphNode.to_json())

# convert the object into a dict
asset_topology_graph_node_dict = asset_topology_graph_node_instance.to_dict()
# create an instance of AssetTopologyGraphNode from a dict
asset_topology_graph_node_from_dict = AssetTopologyGraphNode.from_dict(asset_topology_graph_node_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


