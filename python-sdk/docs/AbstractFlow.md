# AbstractFlow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**namespace** | **str** |  | 
**revision** | **int** |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | [optional] 
**outputs** | [**List[Output]**](Output.md) |  | [optional] 
**disabled** | **bool** |  | 
**labels** | [**AbstractFlowLabels**](AbstractFlowLabels.md) |  | [optional] 
**variables** | **Dict[str, object]** |  | [optional] 
**deleted** | **bool** |  | 

## Example

```python
from kestra_api_client.models.abstract_flow import AbstractFlow

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractFlow from a JSON string
abstract_flow_instance = AbstractFlow.from_json(json)
# print the JSON string representation of the object
print(AbstractFlow.to_json())

# convert the object into a dict
abstract_flow_dict = abstract_flow_instance.to_dict()
# create an instance of AbstractFlow from a dict
abstract_flow_from_dict = AbstractFlow.from_dict(abstract_flow_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


