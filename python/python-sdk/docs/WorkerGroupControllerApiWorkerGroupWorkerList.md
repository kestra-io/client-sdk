# WorkerGroupControllerApiWorkerGroupWorkerList


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**workers** | [**List[WorkerGroupControllerApiWorkerGroupWorker]**](WorkerGroupControllerApiWorkerGroupWorker.md) |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_worker_group_worker_list import WorkerGroupControllerApiWorkerGroupWorkerList

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiWorkerGroupWorkerList from a JSON string
worker_group_controller_api_worker_group_worker_list_instance = WorkerGroupControllerApiWorkerGroupWorkerList.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiWorkerGroupWorkerList.to_json())

# convert the object into a dict
worker_group_controller_api_worker_group_worker_list_dict = worker_group_controller_api_worker_group_worker_list_instance.to_dict()
# create an instance of WorkerGroupControllerApiWorkerGroupWorkerList from a dict
worker_group_controller_api_worker_group_worker_list_from_dict = WorkerGroupControllerApiWorkerGroupWorkerList.from_dict(worker_group_controller_api_worker_group_worker_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


