# AssetRelationGraph


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodes** | [**List[AssetRelationGraphNode]**](AssetRelationGraphNode.md) |  | [optional] 
**edges** | [**List[AssetRelationGraphEdge]**](AssetRelationGraphEdge.md) |  | [optional] 
**truncated** | **bool** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.asset_relation_graph import AssetRelationGraph

# TODO update the JSON string below
json = "{}"
# create an instance of AssetRelationGraph from a JSON string
asset_relation_graph_instance = AssetRelationGraph.from_json(json)
# print the JSON string representation of the object
print(AssetRelationGraph.to_json())

# convert the object into a dict
asset_relation_graph_dict = asset_relation_graph_instance.to_dict()
# create an instance of AssetRelationGraph from a dict
asset_relation_graph_from_dict = AssetRelationGraph.from_dict(asset_relation_graph_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


