# PagedResultsInstanceControllerApiPluginArtifact


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[InstanceControllerApiPluginArtifact]**](InstanceControllerApiPluginArtifact.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_instance_controller_api_plugin_artifact import PagedResultsInstanceControllerApiPluginArtifact

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsInstanceControllerApiPluginArtifact from a JSON string
paged_results_instance_controller_api_plugin_artifact_instance = PagedResultsInstanceControllerApiPluginArtifact.from_json(json)
# print the JSON string representation of the object
print(PagedResultsInstanceControllerApiPluginArtifact.to_json())

# convert the object into a dict
paged_results_instance_controller_api_plugin_artifact_dict = paged_results_instance_controller_api_plugin_artifact_instance.to_dict()
# create an instance of PagedResultsInstanceControllerApiPluginArtifact from a dict
paged_results_instance_controller_api_plugin_artifact_from_dict = PagedResultsInstanceControllerApiPluginArtifact.from_dict(paged_results_instance_controller_api_plugin_artifact_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


