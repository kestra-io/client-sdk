# InstanceControllerApiWorkerGroupDetails

ApiWorkerGroupDetails.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | The ID of worker group. | 
**key** | **str** | The key of the worker group. | 
**description** | **str** | The description of the worker group. | 
**allowed_tenants** | **List[str]** |  | 
**workers** | [**List[ServiceInstance]**](ServiceInstance.md) | The list of workers for the group. | 

## Example

```python
from kestra_api_client.models.instance_controller_api_worker_group_details import InstanceControllerApiWorkerGroupDetails

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiWorkerGroupDetails from a JSON string
instance_controller_api_worker_group_details_instance = InstanceControllerApiWorkerGroupDetails.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiWorkerGroupDetails.to_json())

# convert the object into a dict
instance_controller_api_worker_group_details_dict = instance_controller_api_worker_group_details_instance.to_dict()
# create an instance of InstanceControllerApiWorkerGroupDetails from a dict
instance_controller_api_worker_group_details_from_dict = InstanceControllerApiWorkerGroupDetails.from_dict(instance_controller_api_worker_group_details_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


