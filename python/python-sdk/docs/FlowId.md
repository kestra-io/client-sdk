# FlowId


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**revision** | **int** |  | [optional] 
**tenant_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.flow_id import FlowId

# TODO update the JSON string below
json = "{}"
# create an instance of FlowId from a JSON string
flow_id_instance = FlowId.from_json(json)
# print the JSON string representation of the object
print(FlowId.to_json())

# convert the object into a dict
flow_id_dict = flow_id_instance.to_dict()
# create an instance of FlowId from a dict
flow_id_from_dict = FlowId.from_dict(flow_id_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


