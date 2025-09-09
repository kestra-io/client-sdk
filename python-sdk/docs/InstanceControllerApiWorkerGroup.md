# InstanceControllerApiWorkerGroup

ApiWorkerGroup.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | The ID of worker group. | 
**key** | **str** | The key of the worker group. | 
**description** | **str** | The description of the worker group. | 
**allowed_tenants** | **List[str]** |  | 

## Example

```python
from kestrapy.models.instance_controller_api_worker_group import InstanceControllerApiWorkerGroup

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiWorkerGroup from a JSON string
instance_controller_api_worker_group_instance = InstanceControllerApiWorkerGroup.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiWorkerGroup.to_json())

# convert the object into a dict
instance_controller_api_worker_group_dict = instance_controller_api_worker_group_instance.to_dict()
# create an instance of InstanceControllerApiWorkerGroup from a dict
instance_controller_api_worker_group_from_dict = InstanceControllerApiWorkerGroup.from_dict(instance_controller_api_worker_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


