# WorkerGroupControllerApiWorkerGroupList


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**worker_groups** | [**List[WorkerGroupControllerApiWorkerGroup]**](WorkerGroupControllerApiWorkerGroup.md) |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_worker_group_list import WorkerGroupControllerApiWorkerGroupList

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiWorkerGroupList from a JSON string
worker_group_controller_api_worker_group_list_instance = WorkerGroupControllerApiWorkerGroupList.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiWorkerGroupList.to_json())

# convert the object into a dict
worker_group_controller_api_worker_group_list_dict = worker_group_controller_api_worker_group_list_instance.to_dict()
# create an instance of WorkerGroupControllerApiWorkerGroupList from a dict
worker_group_controller_api_worker_group_list_from_dict = WorkerGroupControllerApiWorkerGroupList.from_dict(worker_group_controller_api_worker_group_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


