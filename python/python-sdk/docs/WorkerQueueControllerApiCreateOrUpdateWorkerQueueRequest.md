# WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | User-supplied RFC 1123 label, used as the routing identity, the Prometheus tag value, and in log output. Immutable. | 
**name** | **str** | Optional human-readable name. | [optional] 
**tags** | **List[str]** | The canonical tag set of the Worker Queue (non-empty). | 
**description** | **str** | The description of the Worker Queue. | [optional] 
**allowed_tenants** | **List[str]** | The tenant scope; empty means unrestricted. | [optional] 

## Example

```python
from kestrapy.models.worker_queue_controller_api_create_or_update_worker_queue_request import WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest from a JSON string
worker_queue_controller_api_create_or_update_worker_queue_request_instance = WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest.from_json(json)
# print the JSON string representation of the object
print(WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest.to_json())

# convert the object into a dict
worker_queue_controller_api_create_or_update_worker_queue_request_dict = worker_queue_controller_api_create_or_update_worker_queue_request_instance.to_dict()
# create an instance of WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest from a dict
worker_queue_controller_api_create_or_update_worker_queue_request_from_dict = WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest.from_dict(worker_queue_controller_api_create_or_update_worker_queue_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


