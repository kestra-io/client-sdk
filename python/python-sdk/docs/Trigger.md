# Trigger


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
**execution_id** | **str** |  | [optional] 
**updated_date** | **datetime** |  | [optional] 
**evaluate_running_date** | **datetime** |  | [optional] 
**worker_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.trigger import Trigger

# TODO update the JSON string below
json = "{}"
# create an instance of Trigger from a JSON string
trigger_instance = Trigger.from_json(json)
# print the JSON string representation of the object
print(Trigger.to_json())

# convert the object into a dict
trigger_dict = trigger_instance.to_dict()
# create an instance of Trigger from a dict
trigger_from_dict = Trigger.from_dict(trigger_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


