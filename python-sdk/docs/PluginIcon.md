# PluginIcon


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 
**flowable** | **bool** |  | [optional] 

## Example

```python
from kestra_api_client.models.plugin_icon import PluginIcon

# TODO update the JSON string below
json = "{}"
# create an instance of PluginIcon from a JSON string
plugin_icon_instance = PluginIcon.from_json(json)
# print the JSON string representation of the object
print(PluginIcon.to_json())

# convert the object into a dict
plugin_icon_dict = plugin_icon_instance.to_dict()
# create an instance of PluginIcon from a dict
plugin_icon_from_dict = PluginIcon.from_dict(plugin_icon_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


