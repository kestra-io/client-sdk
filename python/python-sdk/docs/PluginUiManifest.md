# PluginUiManifest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**manifest** | **Dict[str, List[PluginUiModuleWithGroup]]** |  | [optional] 

## Example

```python
from kestrapy.models.plugin_ui_manifest import PluginUiManifest

# TODO update the JSON string below
json = "{}"
# create an instance of PluginUiManifest from a JSON string
plugin_ui_manifest_instance = PluginUiManifest.from_json(json)
# print the JSON string representation of the object
print(PluginUiManifest.to_json())

# convert the object into a dict
plugin_ui_manifest_dict = plugin_ui_manifest_instance.to_dict()
# create an instance of PluginUiManifest from a dict
plugin_ui_manifest_from_dict = PluginUiManifest.from_dict(plugin_ui_manifest_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


