# FlowTopologyGraph


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodes** | [**List[FlowNode]**](FlowNode.md) |  | [optional] 
**edges** | [**List[FlowTopologyGraphEdge]**](FlowTopologyGraphEdge.md) |  | [optional] 

## Example

```python
from kestrapy.models.flow_topology_graph import FlowTopologyGraph

# TODO update the JSON string below
json = "{}"
# create an instance of FlowTopologyGraph from a JSON string
flow_topology_graph_instance = FlowTopologyGraph.from_json(json)
# print the JSON string representation of the object
print(FlowTopologyGraph.to_json())

# convert the object into a dict
flow_topology_graph_dict = flow_topology_graph_instance.to_dict()
# create an instance of FlowTopologyGraph from a dict
flow_topology_graph_from_dict = FlowTopologyGraph.from_dict(flow_topology_graph_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


