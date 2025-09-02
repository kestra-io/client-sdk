# Plugin


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**license** | **str** |  | [optional] 
**long_description** | **str** |  | [optional] 
**group** | **str** |  | [optional] 
**version** | **str** |  | [optional] 
**manifest** | **Dict[str, str]** |  | [optional] 
**guides** | **List[str]** |  | [optional] 
**aliases** | **List[str]** |  | [optional] 
**tasks** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**triggers** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**conditions** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**controllers** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**storages** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**secrets** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**task_runners** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**apps** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**app_blocks** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**charts** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**data_filters** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**data_filters_kpi** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**log_exporters** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**additional_plugins** | [**List[PluginPluginElementMetadata]**](PluginPluginElementMetadata.md) |  | [optional] 
**categories** | [**List[PluginSubGroupPluginCategory]**](PluginSubGroupPluginCategory.md) |  | [optional] 
**sub_group** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.plugin import Plugin

# TODO update the JSON string below
json = "{}"
# create an instance of Plugin from a JSON string
plugin_instance = Plugin.from_json(json)
# print the JSON string representation of the object
print(Plugin.to_json())

# convert the object into a dict
plugin_dict = plugin_instance.to_dict()
# create an instance of Plugin from a dict
plugin_from_dict = Plugin.from_dict(plugin_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


