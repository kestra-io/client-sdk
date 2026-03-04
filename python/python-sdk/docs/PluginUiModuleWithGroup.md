# PluginUiModuleWithGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ui_module** | **str** |  | [optional] 
**group** | **str** |  | [optional] 
**static_info** | **Dict[str, object]** |  | [optional] 
**styles** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.plugin_ui_module_with_group import PluginUiModuleWithGroup

# TODO update the JSON string below
json = "{}"
# create an instance of PluginUiModuleWithGroup from a JSON string
plugin_ui_module_with_group_instance = PluginUiModuleWithGroup.from_json(json)
# print the JSON string representation of the object
print(PluginUiModuleWithGroup.to_json())

# convert the object into a dict
plugin_ui_module_with_group_dict = plugin_ui_module_with_group_instance.to_dict()
# create an instance of PluginUiModuleWithGroup from a dict
plugin_ui_module_with_group_from_dict = PluginUiModuleWithGroup.from_dict(plugin_ui_module_with_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


