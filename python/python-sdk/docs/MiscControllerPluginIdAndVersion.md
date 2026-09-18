# MiscControllerPluginIdAndVersion


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**version** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.misc_controller_plugin_id_and_version import MiscControllerPluginIdAndVersion

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerPluginIdAndVersion from a JSON string
misc_controller_plugin_id_and_version_instance = MiscControllerPluginIdAndVersion.from_json(json)
# print the JSON string representation of the object
print(MiscControllerPluginIdAndVersion.to_json())

# convert the object into a dict
misc_controller_plugin_id_and_version_dict = misc_controller_plugin_id_and_version_instance.to_dict()
# create an instance of MiscControllerPluginIdAndVersion from a dict
misc_controller_plugin_id_and_version_from_dict = MiscControllerPluginIdAndVersion.from_dict(misc_controller_plugin_id_and_version_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


