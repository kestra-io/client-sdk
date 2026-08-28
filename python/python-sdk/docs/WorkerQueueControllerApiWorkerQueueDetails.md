# WorkerQueueControllerApiWorkerQueueDetails


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**allowed_tenants** | **List[str]** |  | [optional] 
**workers** | [**List[ServiceInstance]**](ServiceInstance.md) |  | [optional] 

## Example

```python
from kestrapy.models.worker_queue_controller_api_worker_queue_details import WorkerQueueControllerApiWorkerQueueDetails

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerQueueControllerApiWorkerQueueDetails from a JSON string
worker_queue_controller_api_worker_queue_details_instance = WorkerQueueControllerApiWorkerQueueDetails.from_json(json)
# print the JSON string representation of the object
print(WorkerQueueControllerApiWorkerQueueDetails.to_json())

# convert the object into a dict
worker_queue_controller_api_worker_queue_details_dict = worker_queue_controller_api_worker_queue_details_instance.to_dict()
# create an instance of WorkerQueueControllerApiWorkerQueueDetails from a dict
worker_queue_controller_api_worker_queue_details_from_dict = WorkerQueueControllerApiWorkerQueueDetails.from_dict(worker_queue_controller_api_worker_queue_details_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


