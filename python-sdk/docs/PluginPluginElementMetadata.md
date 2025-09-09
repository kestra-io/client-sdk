# PluginPluginElementMetadata


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cls** | **str** |  | 
**deprecated** | **bool** |  | 

## Example

```python
from kestrapy.models.plugin_plugin_element_metadata import PluginPluginElementMetadata

# TODO update the JSON string below
json = "{}"
# create an instance of PluginPluginElementMetadata from a JSON string
plugin_plugin_element_metadata_instance = PluginPluginElementMetadata.from_json(json)
# print the JSON string representation of the object
print(PluginPluginElementMetadata.to_json())

# convert the object into a dict
plugin_plugin_element_metadata_dict = plugin_plugin_element_metadata_instance.to_dict()
# create an instance of PluginPluginElementMetadata from a dict
plugin_plugin_element_metadata_from_dict = PluginPluginElementMetadata.from_dict(plugin_plugin_element_metadata_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


