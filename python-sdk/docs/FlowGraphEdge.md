# FlowGraphEdge


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**source** | **str** |  | 
**target** | **str** |  | 
**relation** | [**Relation**](Relation.md) |  | 

## Example

```python
from kestra_api_client.models.flow_graph_edge import FlowGraphEdge

# TODO update the JSON string below
json = "{}"
# create an instance of FlowGraphEdge from a JSON string
flow_graph_edge_instance = FlowGraphEdge.from_json(json)
# print the JSON string representation of the object
print(FlowGraphEdge.to_json())

# convert the object into a dict
flow_graph_edge_dict = flow_graph_edge_instance.to_dict()
# create an instance of FlowGraphEdge from a dict
flow_graph_edge_from_dict = FlowGraphEdge.from_dict(flow_graph_edge_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


