# AssetTopologyGraph


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodes** | [**List[AssetTopologyGraphNode]**](AssetTopologyGraphNode.md) |  | [optional] 
**edges** | [**List[AssetTopologyGraphEdge]**](AssetTopologyGraphEdge.md) |  | [optional] 

## Example

```python
from kestrapy.models.asset_topology_graph import AssetTopologyGraph

# TODO update the JSON string below
json = "{}"
# create an instance of AssetTopologyGraph from a JSON string
asset_topology_graph_instance = AssetTopologyGraph.from_json(json)
# print the JSON string representation of the object
print(AssetTopologyGraph.to_json())

# convert the object into a dict
asset_topology_graph_dict = asset_topology_graph_instance.to_dict()
# create an instance of AssetTopologyGraph from a dict
asset_topology_graph_from_dict = AssetTopologyGraph.from_dict(asset_topology_graph_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


