# InstanceControllerApiPluginArtifact


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **str** |  | 
**icon** | **str** |  | 
**group_id** | **str** |  | 
**artifact_id** | **str** |  | 
**versions** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.instance_controller_api_plugin_artifact import InstanceControllerApiPluginArtifact

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiPluginArtifact from a JSON string
instance_controller_api_plugin_artifact_instance = InstanceControllerApiPluginArtifact.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiPluginArtifact.to_json())

# convert the object into a dict
instance_controller_api_plugin_artifact_dict = instance_controller_api_plugin_artifact_instance.to_dict()
# create an instance of InstanceControllerApiPluginArtifact from a dict
instance_controller_api_plugin_artifact_from_dict = InstanceControllerApiPluginArtifact.from_dict(instance_controller_api_plugin_artifact_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


