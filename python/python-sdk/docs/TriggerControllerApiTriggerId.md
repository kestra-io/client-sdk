# TriggerControllerApiTriggerId


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**trigger_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.trigger_controller_api_trigger_id import TriggerControllerApiTriggerId

# TODO update the JSON string below
json = "{}"
# create an instance of TriggerControllerApiTriggerId from a JSON string
trigger_controller_api_trigger_id_instance = TriggerControllerApiTriggerId.from_json(json)
# print the JSON string representation of the object
print(TriggerControllerApiTriggerId.to_json())

# convert the object into a dict
trigger_controller_api_trigger_id_dict = trigger_controller_api_trigger_id_instance.to_dict()
# create an instance of TriggerControllerApiTriggerId from a dict
trigger_controller_api_trigger_id_from_dict = TriggerControllerApiTriggerId.from_dict(trigger_controller_api_trigger_id_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


