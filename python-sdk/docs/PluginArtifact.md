# PluginArtifact


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**group_id** | **str** |  | 
**artifact_id** | **str** |  | 
**extension** | **str** |  | 
**classifier** | **str** |  | 
**version** | **str** |  | 
**uri** | **str** |  | 

## Example

```python
from kestrapy.models.plugin_artifact import PluginArtifact

# TODO update the JSON string below
json = "{}"
# create an instance of PluginArtifact from a JSON string
plugin_artifact_instance = PluginArtifact.from_json(json)
# print the JSON string representation of the object
print(PluginArtifact.to_json())

# convert the object into a dict
plugin_artifact_dict = plugin_artifact_instance.to_dict()
# create an instance of PluginArtifact from a dict
plugin_artifact_from_dict = PluginArtifact.from_dict(plugin_artifact_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


