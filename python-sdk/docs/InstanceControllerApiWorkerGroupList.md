# InstanceControllerApiWorkerGroupList

ApiWorkerGroupList.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**worker_groups** | [**List[InstanceControllerApiWorkerGroupItem]**](InstanceControllerApiWorkerGroupItem.md) | The list of worker groups. | 

## Example

```python
from kestrapy.models.instance_controller_api_worker_group_list import InstanceControllerApiWorkerGroupList

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiWorkerGroupList from a JSON string
instance_controller_api_worker_group_list_instance = InstanceControllerApiWorkerGroupList.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiWorkerGroupList.to_json())

# convert the object into a dict
instance_controller_api_worker_group_list_dict = instance_controller_api_worker_group_list_instance.to_dict()
# create an instance of InstanceControllerApiWorkerGroupList from a dict
instance_controller_api_worker_group_list_from_dict = InstanceControllerApiWorkerGroupList.from_dict(instance_controller_api_worker_group_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


