# WorkerQueueControllerApiWorkerQueueList


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**worker_queues** | [**List[WorkerQueueControllerApiWorkerQueueItem]**](WorkerQueueControllerApiWorkerQueueItem.md) | The list of Worker Queues. | [optional] 

## Example

```python
from kestrapy.models.worker_queue_controller_api_worker_queue_list import WorkerQueueControllerApiWorkerQueueList

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerQueueControllerApiWorkerQueueList from a JSON string
worker_queue_controller_api_worker_queue_list_instance = WorkerQueueControllerApiWorkerQueueList.from_json(json)
# print the JSON string representation of the object
print(WorkerQueueControllerApiWorkerQueueList.to_json())

# convert the object into a dict
worker_queue_controller_api_worker_queue_list_dict = worker_queue_controller_api_worker_queue_list_instance.to_dict()
# create an instance of WorkerQueueControllerApiWorkerQueueList from a dict
worker_queue_controller_api_worker_queue_list_from_dict = WorkerQueueControllerApiWorkerQueueList.from_dict(worker_queue_controller_api_worker_queue_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


