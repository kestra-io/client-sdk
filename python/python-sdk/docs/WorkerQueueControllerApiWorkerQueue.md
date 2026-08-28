# WorkerQueueControllerApiWorkerQueue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**allowed_tenants** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.worker_queue_controller_api_worker_queue import WorkerQueueControllerApiWorkerQueue

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerQueueControllerApiWorkerQueue from a JSON string
worker_queue_controller_api_worker_queue_instance = WorkerQueueControllerApiWorkerQueue.from_json(json)
# print the JSON string representation of the object
print(WorkerQueueControllerApiWorkerQueue.to_json())

# convert the object into a dict
worker_queue_controller_api_worker_queue_dict = worker_queue_controller_api_worker_queue_instance.to_dict()
# create an instance of WorkerQueueControllerApiWorkerQueue from a dict
worker_queue_controller_api_worker_queue_from_dict = WorkerQueueControllerApiWorkerQueue.from_dict(worker_queue_controller_api_worker_queue_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


