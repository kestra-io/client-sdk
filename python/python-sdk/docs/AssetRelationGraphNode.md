# AssetRelationGraphNode


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**type** | [**NodeType**](NodeType.md) |  | [optional] 
**asset_type** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**producer** | [**AssetWriteSummary**](AssetWriteSummary.md) |  | [optional] 
**runs** | [**List[AssetWriteSummary]**](AssetWriteSummary.md) |  | [optional] 
**collapsed** | **bool** |  | [optional] 
**total_degree** | **int** |  | [optional] 
**next_cursor** | **str** |  | [optional] 
**exhausted** | **bool** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.asset_relation_graph_node import AssetRelationGraphNode

# TODO update the JSON string below
json = "{}"
# create an instance of AssetRelationGraphNode from a JSON string
asset_relation_graph_node_instance = AssetRelationGraphNode.from_json(json)
# print the JSON string representation of the object
print(AssetRelationGraphNode.to_json())

# convert the object into a dict
asset_relation_graph_node_dict = asset_relation_graph_node_instance.to_dict()
# create an instance of AssetRelationGraphNode from a dict
asset_relation_graph_node_from_dict = AssetRelationGraphNode.from_dict(asset_relation_graph_node_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


