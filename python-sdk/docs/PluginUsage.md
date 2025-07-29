# PluginUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**manifest** | **Dict[str, str]** |  | [optional] 

## Example

```python
from kestrapy.models.plugin_usage import PluginUsage

# TODO update the JSON string below
json = "{}"
# create an instance of PluginUsage from a JSON string
plugin_usage_instance = PluginUsage.from_json(json)
# print the JSON string representation of the object
print(PluginUsage.to_json())

# convert the object into a dict
plugin_usage_dict = plugin_usage_instance.to_dict()
# create an instance of PluginUsage from a dict
plugin_usage_from_dict = PluginUsage.from_dict(plugin_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


