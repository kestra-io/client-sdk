# AbstractGraph


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**type** | **str** |  | [optional] 
**branch_type** | [**AbstractGraphBranchType**](AbstractGraphBranchType.md) |  | [optional] 

## Example

```python
from kestrapy.models.abstract_graph import AbstractGraph

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractGraph from a JSON string
abstract_graph_instance = AbstractGraph.from_json(json)
# print the JSON string representation of the object
print(AbstractGraph.to_json())

# convert the object into a dict
abstract_graph_dict = abstract_graph_instance.to_dict()
# create an instance of AbstractGraph from a dict
abstract_graph_from_dict = AbstractGraph.from_dict(abstract_graph_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


