# InstanceControllerApiPluginVersionDetails


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**artifact_id** | **str** |  | 
**group_id** | **str** |  | 
**version** | **str** |  | 
**title** | **str** |  | 
**description** | **str** |  | 
**icon** | **str** |  | 
**classes** | [**List[InstanceControllerApiPluginVersionDetailsApiPluginClasses]**](InstanceControllerApiPluginVersionDetailsApiPluginClasses.md) |  | 

## Example

```python
from kestra_api_client.models.instance_controller_api_plugin_version_details import InstanceControllerApiPluginVersionDetails

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiPluginVersionDetails from a JSON string
instance_controller_api_plugin_version_details_instance = InstanceControllerApiPluginVersionDetails.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiPluginVersionDetails.to_json())

# convert the object into a dict
instance_controller_api_plugin_version_details_dict = instance_controller_api_plugin_version_details_instance.to_dict()
# create an instance of InstanceControllerApiPluginVersionDetails from a dict
instance_controller_api_plugin_version_details_from_dict = InstanceControllerApiPluginVersionDetails.from_dict(instance_controller_api_plugin_version_details_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


