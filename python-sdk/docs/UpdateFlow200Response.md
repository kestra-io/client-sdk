# UpdateFlow200Response


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**namespace** | **str** |  | 
**revision** | **int** |  | [optional] 
**description** | **str** |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | [optional] 
**outputs** | [**List[Output]**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. | [optional] 
**disabled** | **bool** |  | 
**labels** | [**List[Label]**](Label.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. | [optional] 
**variables** | **Dict[str, object]** |  | [optional] 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**deleted** | **bool** |  | 
**var_finally** | [**List[Task]**](Task.md) |  | [optional] 
**task_defaults** | [**List[PluginDefault]**](PluginDefault.md) |  | [optional] 
**tasks** | [**Dict[Task]**](Task.md) |  | 
**errors** | [**List[Task]**](Task.md) |  | [optional] 
**listeners** | [**List[Listener]**](Listener.md) |  | [optional] 
**after_execution** | [**List[Task]**](Task.md) |  | [optional] 
**triggers** | [**List[AbstractTrigger]**](AbstractTrigger.md) |  | [optional] 
**plugin_defaults** | [**List[PluginDefault]**](PluginDefault.md) |  | [optional] 
**concurrency** | [**Concurrency**](Concurrency.md) |  | [optional] 
**retry** | **object** |  | [optional] 
**sla** | [**List[SLA]**](SLA.md) |  | [optional] 

## Example

```python
from kestrapy.models.update_flow200_response import UpdateFlow200Response

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateFlow200Response from a JSON string
update_flow200_response_instance = UpdateFlow200Response.from_json(json)
# print the JSON string representation of the object
print(UpdateFlow200Response.to_json())

# convert the object into a dict
update_flow200_response_dict = update_flow200_response_instance.to_dict()
# create an instance of UpdateFlow200Response from a dict
update_flow200_response_from_dict = UpdateFlow200Response.from_dict(update_flow200_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


