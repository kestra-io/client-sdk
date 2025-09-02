# TriggerControllerTriggers


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**abstract_trigger** | [**AbstractTrigger**](AbstractTrigger.md) |  | 
**trigger_context** | [**Trigger**](Trigger.md) |  | 

## Example

```python
from kestrapy.models.trigger_controller_triggers import TriggerControllerTriggers

# TODO update the JSON string below
json = "{}"
# create an instance of TriggerControllerTriggers from a JSON string
trigger_controller_triggers_instance = TriggerControllerTriggers.from_json(json)
# print the JSON string representation of the object
print(TriggerControllerTriggers.to_json())

# convert the object into a dict
trigger_controller_triggers_dict = trigger_controller_triggers_instance.to_dict()
# create an instance of TriggerControllerTriggers from a dict
trigger_controller_triggers_from_dict = TriggerControllerTriggers.from_dict(trigger_controller_triggers_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


