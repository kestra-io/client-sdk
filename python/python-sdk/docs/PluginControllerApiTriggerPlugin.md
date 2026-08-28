# PluginControllerApiTriggerPlugin


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**plugin_title** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**group** | [**TriggerPluginCategory**](TriggerPluginCategory.md) |  | [optional] 
**ee** | **bool** |  | [optional] 
**icon** | **str** |  | [optional] 
**deprecated** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.plugin_controller_api_trigger_plugin import PluginControllerApiTriggerPlugin

# TODO update the JSON string below
json = "{}"
# create an instance of PluginControllerApiTriggerPlugin from a JSON string
plugin_controller_api_trigger_plugin_instance = PluginControllerApiTriggerPlugin.from_json(json)
# print the JSON string representation of the object
print(PluginControllerApiTriggerPlugin.to_json())

# convert the object into a dict
plugin_controller_api_trigger_plugin_dict = plugin_controller_api_trigger_plugin_instance.to_dict()
# create an instance of PluginControllerApiTriggerPlugin from a dict
plugin_controller_api_trigger_plugin_from_dict = PluginControllerApiTriggerPlugin.from_dict(plugin_controller_api_trigger_plugin_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


