# FlowInterface


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**revision** | **int** |  | [optional] 
**tenant_id** | **str** |  | [optional] 
**deleted** | **bool** |  | [optional] 
**description** | **str** |  | [optional] 
**disabled** | **bool** |  | [optional] 
**labels** | [**List[Label]**](Label.md) |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | [optional] 
**outputs** | [**List[Output]**](Output.md) |  | [optional] 
**variables** | **Dict[str, object]** |  | [optional] 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**concurrency** | [**Concurrency**](Concurrency.md) |  | [optional] 
**sla** | [**List[SLA]**](SLA.md) |  | [optional] 
**source** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.flow_interface import FlowInterface

# TODO update the JSON string below
json = "{}"
# create an instance of FlowInterface from a JSON string
flow_interface_instance = FlowInterface.from_json(json)
# print the JSON string representation of the object
print(FlowInterface.to_json())

# convert the object into a dict
flow_interface_dict = flow_interface_instance.to_dict()
# create an instance of FlowInterface from a dict
flow_interface_from_dict = FlowInterface.from_dict(flow_interface_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


