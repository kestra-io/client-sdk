# TriggerControllerSetDisabledRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**triggers** | [**List[Trigger]**](Trigger.md) |  | [optional] 
**disabled** | **bool** |  | [optional] 

## Example

```python
from kestra_api_client.models.trigger_controller_set_disabled_request import TriggerControllerSetDisabledRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TriggerControllerSetDisabledRequest from a JSON string
trigger_controller_set_disabled_request_instance = TriggerControllerSetDisabledRequest.from_json(json)
# print the JSON string representation of the object
print(TriggerControllerSetDisabledRequest.to_json())

# convert the object into a dict
trigger_controller_set_disabled_request_dict = trigger_controller_set_disabled_request_instance.to_dict()
# create an instance of TriggerControllerSetDisabledRequest from a dict
trigger_controller_set_disabled_request_from_dict = TriggerControllerSetDisabledRequest.from_dict(trigger_controller_set_disabled_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


