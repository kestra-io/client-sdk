# InstanceControllerApiPluginArtifact


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 
**group_id** | **str** |  | [optional] 
**artifact_id** | **str** |  | [optional] 
**versions** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.instance_controller_api_plugin_artifact import InstanceControllerApiPluginArtifact

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


