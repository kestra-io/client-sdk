# TriggerControllerApiDisableTriggerRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**trigger_id** | **str** |  | [optional] 
**disabled** | **bool** |  | [optional] 
**recover_missed_schedules** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.trigger_controller_api_disable_trigger_request import TriggerControllerApiDisableTriggerRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TriggerControllerApiDisableTriggerRequest from a JSON string
trigger_controller_api_disable_trigger_request_instance = TriggerControllerApiDisableTriggerRequest.from_json(json)
# print the JSON string representation of the object
print(TriggerControllerApiDisableTriggerRequest.to_json())

# convert the object into a dict
trigger_controller_api_disable_trigger_request_dict = trigger_controller_api_disable_trigger_request_instance.to_dict()
# create an instance of TriggerControllerApiDisableTriggerRequest from a dict
trigger_controller_api_disable_trigger_request_from_dict = TriggerControllerApiDisableTriggerRequest.from_dict(trigger_controller_api_disable_trigger_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


