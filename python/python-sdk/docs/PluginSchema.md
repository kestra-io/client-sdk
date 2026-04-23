# PluginSchema


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**properties** | **Dict[str, object]** |  | [optional] 
**outputs** | **Dict[str, object]** |  | [optional] 
**definitions** | **Dict[str, object]** |  | [optional] 

## Example

```python
from kestrapy.models.plugin_schema import PluginSchema

# TODO update the JSON string below
json = "{}"
# create an instance of PluginSchema from a JSON string
plugin_schema_instance = PluginSchema.from_json(json)
# print the JSON string representation of the object
print(PluginSchema.to_json())

# convert the object into a dict
plugin_schema_dict = plugin_schema_instance.to_dict()
# create an instance of PluginSchema from a dict
plugin_schema_from_dict = PluginSchema.from_dict(plugin_schema_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


