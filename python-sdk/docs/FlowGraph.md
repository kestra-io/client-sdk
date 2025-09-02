# FlowGraph


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodes** | [**List[AbstractGraph]**](AbstractGraph.md) |  | 
**edges** | [**List[FlowGraphEdge]**](FlowGraphEdge.md) |  | 
**clusters** | [**List[FlowGraphCluster]**](FlowGraphCluster.md) |  | 
**flowables** | **List[str]** |  | 

## Example

```python
from kestrapy.models.flow_graph import FlowGraph

# TODO update the JSON string below
json = "{}"
# create an instance of FlowGraph from a JSON string
flow_graph_instance = FlowGraph.from_json(json)
# print the JSON string representation of the object
print(FlowGraph.to_json())

# convert the object into a dict
flow_graph_dict = flow_graph_instance.to_dict()
# create an instance of FlowGraph from a dict
flow_graph_from_dict = FlowGraph.from_dict(flow_graph_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


