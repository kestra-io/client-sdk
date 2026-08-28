# PluginInstallJob


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **UUID** |  | [optional] 
**status** | [**PluginInstallJobStatus**](PluginInstallJobStatus.md) |  | [optional] 
**artifacts** | [**List[PluginArtifact]**](PluginArtifact.md) |  | [optional] 
**progress** | [**Dict[str, PluginInstallJobArtifactProgress]**](PluginInstallJobArtifactProgress.md) |  | [optional] 
**started_at** | **datetime** |  | [optional] 
**finished_at** | **datetime** |  | [optional] 
**error** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.plugin_install_job import PluginInstallJob

# TODO update the JSON string below
json = "{}"
# create an instance of PluginInstallJob from a JSON string
plugin_install_job_instance = PluginInstallJob.from_json(json)
# print the JSON string representation of the object
print(PluginInstallJob.to_json())

# convert the object into a dict
plugin_install_job_dict = plugin_install_job_instance.to_dict()
# create an instance of PluginInstallJob from a dict
plugin_install_job_from_dict = PluginInstallJob.from_dict(plugin_install_job_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


