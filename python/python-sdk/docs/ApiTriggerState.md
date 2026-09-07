# ApiTriggerState


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**trigger_id** | **str** |  | 
**updated_at** | **datetime** |  | 
**evaluated_at** | **datetime** |  | [optional] 
**next_evaluation_date** | **datetime** |  | [optional] 
**backfill** | [**Backfill**](Backfill.md) |  | [optional] 
**stop_after** | [**List[StateType]**](StateType.md) |  | [optional] 
**disabled** | **bool** |  | [optional] 
**locked** | **bool** |  | [optional] 
**worker_id** | **str** |  | [optional] 
**last_triggered_date** | **datetime** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**kind** | [**TriggerType**](TriggerType.md) |  | [optional] 

## Example

```python
from kestrapy.models.api_trigger_state import ApiTriggerState

# TODO update the JSON string below
json = "{}"
# create an instance of ApiTriggerState from a JSON string
api_trigger_state_instance = ApiTriggerState.from_json(json)
# print the JSON string representation of the object
print(ApiTriggerState.to_json())

# convert the object into a dict
api_trigger_state_dict = api_trigger_state_instance.to_dict()
# create an instance of ApiTriggerState from a dict
api_trigger_state_from_dict = ApiTriggerState.from_dict(api_trigger_state_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


