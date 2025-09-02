# PluginControllerApiPluginVersions


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | 
**versions** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.plugin_controller_api_plugin_versions import PluginControllerApiPluginVersions

# TODO update the JSON string below
json = "{}"
# create an instance of PluginControllerApiPluginVersions from a JSON string
plugin_controller_api_plugin_versions_instance = PluginControllerApiPluginVersions.from_json(json)
# print the JSON string representation of the object
print(PluginControllerApiPluginVersions.to_json())

# convert the object into a dict
plugin_controller_api_plugin_versions_dict = plugin_controller_api_plugin_versions_instance.to_dict()
# create an instance of PluginControllerApiPluginVersions from a dict
plugin_controller_api_plugin_versions_from_dict = PluginControllerApiPluginVersions.from_dict(plugin_controller_api_plugin_versions_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


