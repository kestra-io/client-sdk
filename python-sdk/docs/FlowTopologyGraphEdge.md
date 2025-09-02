# FlowTopologyGraphEdge


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**source** | **str** |  | 
**target** | **str** |  | 
**relation** | [**FlowRelation**](FlowRelation.md) |  | 

## Example

```python
from kestrapy.models.flow_topology_graph_edge import FlowTopologyGraphEdge

# TODO update the JSON string below
json = "{}"
# create an instance of FlowTopologyGraphEdge from a JSON string
flow_topology_graph_edge_instance = FlowTopologyGraphEdge.from_json(json)
# print the JSON string representation of the object
print(FlowTopologyGraphEdge.to_json())

# convert the object into a dict
flow_topology_graph_edge_dict = flow_topology_graph_edge_instance.to_dict()
# create an instance of FlowTopologyGraphEdge from a dict
flow_topology_graph_edge_from_dict = FlowTopologyGraphEdge.from_dict(flow_topology_graph_edge_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


