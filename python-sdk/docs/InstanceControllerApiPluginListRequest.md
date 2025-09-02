# InstanceControllerApiPluginListRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**plugins** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.instance_controller_api_plugin_list_request import InstanceControllerApiPluginListRequest

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiPluginListRequest from a JSON string
instance_controller_api_plugin_list_request_instance = InstanceControllerApiPluginListRequest.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiPluginListRequest.to_json())

# convert the object into a dict
instance_controller_api_plugin_list_request_dict = instance_controller_api_plugin_list_request_instance.to_dict()
# create an instance of InstanceControllerApiPluginListRequest from a dict
instance_controller_api_plugin_list_request_from_dict = InstanceControllerApiPluginListRequest.from_dict(instance_controller_api_plugin_list_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


