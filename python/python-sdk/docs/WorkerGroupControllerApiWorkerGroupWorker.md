# WorkerGroupControllerApiWorkerGroupWorker


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**worker_id** | **str** |  | [optional] 
**worker_name** | **str** |  | [optional] 
**credential_id** | **str** |  | [optional] 
**token_uid** | **str** |  | [optional] 
**state** | **str** |  | [optional] 
**created_at** | **datetime** |  | [optional] 
**updated_at** | **datetime** |  | [optional] 
**registered_at** | **datetime** |  | [optional] 
**capacity** | [**WorkerGroupControllerApiWorkerCapacity**](WorkerGroupControllerApiWorkerCapacity.md) |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_worker_group_worker import WorkerGroupControllerApiWorkerGroupWorker

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiWorkerGroupWorker from a JSON string
worker_group_controller_api_worker_group_worker_instance = WorkerGroupControllerApiWorkerGroupWorker.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiWorkerGroupWorker.to_json())

# convert the object into a dict
worker_group_controller_api_worker_group_worker_dict = worker_group_controller_api_worker_group_worker_instance.to_dict()
# create an instance of WorkerGroupControllerApiWorkerGroupWorker from a dict
worker_group_controller_api_worker_group_worker_from_dict = WorkerGroupControllerApiWorkerGroupWorker.from_dict(worker_group_controller_api_worker_group_worker_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


