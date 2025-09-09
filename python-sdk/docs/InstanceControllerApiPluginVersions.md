# InstanceControllerApiPluginVersions


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**group_id** | **str** |  | 
**artifact_id** | **str** |  | 
**versions** | [**List[InstanceControllerApiPluginVersionsApiPluginVersionAndMetadata]**](InstanceControllerApiPluginVersionsApiPluginVersionAndMetadata.md) |  | 

## Example

```python
from kestrapy.models.instance_controller_api_plugin_versions import InstanceControllerApiPluginVersions

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiPluginVersions from a JSON string
instance_controller_api_plugin_versions_instance = InstanceControllerApiPluginVersions.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiPluginVersions.to_json())

# convert the object into a dict
instance_controller_api_plugin_versions_dict = instance_controller_api_plugin_versions_instance.to_dict()
# create an instance of InstanceControllerApiPluginVersions from a dict
instance_controller_api_plugin_versions_from_dict = InstanceControllerApiPluginVersions.from_dict(instance_controller_api_plugin_versions_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


