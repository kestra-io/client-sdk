# FlowGraphCluster


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cluster** | [**AbstractGraph**](AbstractGraph.md) |  | 
**nodes** | **List[str]** |  | 
**parents** | **List[str]** |  | 
**start** | **str** |  | 
**end** | **str** |  | 

## Example

```python
from kestra_api_client.models.flow_graph_cluster import FlowGraphCluster

# TODO update the JSON string below
json = "{}"
# create an instance of FlowGraphCluster from a JSON string
flow_graph_cluster_instance = FlowGraphCluster.from_json(json)
# print the JSON string representation of the object
print(FlowGraphCluster.to_json())

# convert the object into a dict
flow_graph_cluster_dict = flow_graph_cluster_instance.to_dict()
# create an instance of FlowGraphCluster from a dict
flow_graph_cluster_from_dict = FlowGraphCluster.from_dict(flow_graph_cluster_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


