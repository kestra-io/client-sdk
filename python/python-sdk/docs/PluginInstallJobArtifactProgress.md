# PluginInstallJobArtifactProgress


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**resource** | **str** |  | [optional] 
**transferred** | **int** |  | [optional] 
**total** | **int** |  | [optional] 
**state** | [**PluginInstallJobArtifactState**](PluginInstallJobArtifactState.md) |  | [optional] 

## Example

```python
from kestrapy.models.plugin_install_job_artifact_progress import PluginInstallJobArtifactProgress

# TODO update the JSON string below
json = "{}"
# create an instance of PluginInstallJobArtifactProgress from a JSON string
plugin_install_job_artifact_progress_instance = PluginInstallJobArtifactProgress.from_json(json)
# print the JSON string representation of the object
print(PluginInstallJobArtifactProgress.to_json())

# convert the object into a dict
plugin_install_job_artifact_progress_dict = plugin_install_job_artifact_progress_instance.to_dict()
# create an instance of PluginInstallJobArtifactProgress from a dict
plugin_install_job_artifact_progress_from_dict = PluginInstallJobArtifactProgress.from_dict(plugin_install_job_artifact_progress_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


