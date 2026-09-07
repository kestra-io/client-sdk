# WorkerGroupControllerApiCreateWorkerGroupRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**description** | **str** |  | [optional] 
**subscriptions** | [**List[WorkerGroupControllerApiSubscriptionRequest]**](WorkerGroupControllerApiSubscriptionRequest.md) |  | 

## Example

```python
from kestrapy.models.worker_group_controller_api_create_worker_group_request import WorkerGroupControllerApiCreateWorkerGroupRequest

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiCreateWorkerGroupRequest from a JSON string
worker_group_controller_api_create_worker_group_request_instance = WorkerGroupControllerApiCreateWorkerGroupRequest.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiCreateWorkerGroupRequest.to_json())

# convert the object into a dict
worker_group_controller_api_create_worker_group_request_dict = worker_group_controller_api_create_worker_group_request_instance.to_dict()
# create an instance of WorkerGroupControllerApiCreateWorkerGroupRequest from a dict
worker_group_controller_api_create_worker_group_request_from_dict = WorkerGroupControllerApiCreateWorkerGroupRequest.from_dict(worker_group_controller_api_create_worker_group_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


