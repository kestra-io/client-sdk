# InstanceControllerApiWorkerGroupItem

ApiWorkerGroup.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | The ID of worker group. | 
**key** | **str** | The key of the worker group. | 
**description** | **str** | The description of the worker group. | 
**active_workers** | **int** | The number of active workers for the group. | 

## Example

```python
from kestrapy.models.instance_controller_api_worker_group_item import InstanceControllerApiWorkerGroupItem

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiWorkerGroupItem from a JSON string
instance_controller_api_worker_group_item_instance = InstanceControllerApiWorkerGroupItem.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiWorkerGroupItem.to_json())

# convert the object into a dict
instance_controller_api_worker_group_item_dict = instance_controller_api_worker_group_item_instance.to_dict()
# create an instance of InstanceControllerApiWorkerGroupItem from a dict
instance_controller_api_worker_group_item_from_dict = InstanceControllerApiWorkerGroupItem.from_dict(instance_controller_api_worker_group_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


