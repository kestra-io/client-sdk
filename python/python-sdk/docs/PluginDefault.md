# PluginDefault


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | 
**forced** | **bool** |  | [optional] 
**values** | **object** |  | [optional] 

## Example

```python
from kestrapy.models.plugin_default import PluginDefault

# TODO update the JSON string below
json = "{}"
# create an instance of PluginDefault from a JSON string
plugin_default_instance = PluginDefault.from_json(json)
# print the JSON string representation of the object
print(PluginDefault.to_json())

# convert the object into a dict
plugin_default_dict = plugin_default_instance.to_dict()
# create an instance of PluginDefault from a dict
plugin_default_from_dict = PluginDefault.from_dict(plugin_default_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


