# InstanceControllerApiCreateOrUpdateWorkerGroupRequest

ApiCreateWorkerGroupRequest.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **str** | The key of the worker group. | 
**description** | **str** | The description of the worker group. | 
**allowed_tenants** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.instance_controller_api_create_or_update_worker_group_request import InstanceControllerApiCreateOrUpdateWorkerGroupRequest

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiCreateOrUpdateWorkerGroupRequest from a JSON string
instance_controller_api_create_or_update_worker_group_request_instance = InstanceControllerApiCreateOrUpdateWorkerGroupRequest.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiCreateOrUpdateWorkerGroupRequest.to_json())

# convert the object into a dict
instance_controller_api_create_or_update_worker_group_request_dict = instance_controller_api_create_or_update_worker_group_request_instance.to_dict()
# create an instance of InstanceControllerApiCreateOrUpdateWorkerGroupRequest from a dict
instance_controller_api_create_or_update_worker_group_request_from_dict = InstanceControllerApiCreateOrUpdateWorkerGroupRequest.from_dict(instance_controller_api_create_or_update_worker_group_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


