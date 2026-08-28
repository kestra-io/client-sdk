# WorkerQueueControllerApiWorkerQueueItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**allowed_tenants** | **List[str]** |  | [optional] 
**active_workers** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.worker_queue_controller_api_worker_queue_item import WorkerQueueControllerApiWorkerQueueItem

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerQueueControllerApiWorkerQueueItem from a JSON string
worker_queue_controller_api_worker_queue_item_instance = WorkerQueueControllerApiWorkerQueueItem.from_json(json)
# print the JSON string representation of the object
print(WorkerQueueControllerApiWorkerQueueItem.to_json())

# convert the object into a dict
worker_queue_controller_api_worker_queue_item_dict = worker_queue_controller_api_worker_queue_item_instance.to_dict()
# create an instance of WorkerQueueControllerApiWorkerQueueItem from a dict
worker_queue_controller_api_worker_queue_item_from_dict = WorkerQueueControllerApiWorkerQueueItem.from_dict(worker_queue_controller_api_worker_queue_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


