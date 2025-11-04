# FlowWithSource


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**namespace** | **str** |  | 
**revision** | **int** |  | [optional] 
**description** | **str** |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | [optional] 
**disabled** | **bool** |  | 
**labels** | [**List[Label]**](Label.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. | [optional] 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**deleted** | **bool** |  | 
**variables** | **object** |  | [optional] 
**concurrency** | [**Concurrency**](Concurrency.md) |  | [optional] 
**outputs** | [**List[Output]**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. | [optional] 
**sla** | [**List[SLA]**](SLA.md) |  | [optional] 
**var_finally** | [**List[Task]**](Task.md) |  | [optional] 
**tasks** | [**Dict[Task]**](Task.md) |  | 
**errors** | [**List[Task]**](Task.md) |  | [optional] 
**after_execution** | [**List[Task]**](Task.md) |  | [optional] 
**triggers** | [**List[AbstractTrigger]**](AbstractTrigger.md) |  | [optional] 
**plugin_defaults** | [**List[PluginDefault]**](PluginDefault.md) |  | [optional] 
**retry** | **object** |  | [optional] 

## Example

```python
from kestrapy.models.flow_with_source import FlowWithSource

# TODO update the JSON string below
json = "{}"
# create an instance of FlowWithSource from a JSON string
flow_with_source_instance = FlowWithSource.from_json(json)
# print the JSON string representation of the object
print(FlowWithSource.to_json())

# convert the object into a dict
flow_with_source_dict = flow_with_source_instance.to_dict()
# create an instance of FlowWithSource from a dict
flow_with_source_from_dict = FlowWithSource.from_dict(flow_with_source_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


