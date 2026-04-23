# TriggerContext


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**disabled** | **bool** |  | [optional] [default to False]
**tenant_id** | **str** |  | [optional] 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**trigger_id** | **str** |  | 
**var_date** | **datetime** |  | 
**next_execution_date** | **datetime** |  | [optional] 
**backfill** | [**Backfill**](Backfill.md) |  | [optional] 
**stop_after** | [**List[StateType]**](StateType.md) |  | [optional] 

## Example

```python
from kestrapy.models.trigger_context import TriggerContext

# TODO update the JSON string below
json = "{}"
# create an instance of TriggerContext from a JSON string
trigger_context_instance = TriggerContext.from_json(json)
# print the JSON string representation of the object
print(TriggerContext.to_json())

# convert the object into a dict
trigger_context_dict = trigger_context_instance.to_dict()
# create an instance of TriggerContext from a dict
trigger_context_from_dict = TriggerContext.from_dict(trigger_context_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


