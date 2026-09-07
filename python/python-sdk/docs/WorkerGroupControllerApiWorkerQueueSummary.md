# WorkerGroupControllerApiWorkerQueueSummary

Compact WorkerQueue summary embedded in subscription responses. Carries the user-supplied routing identity (id), the optional display name, the canonical tag set, and the tenant scope.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**allowed_tenants** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_worker_queue_summary import WorkerGroupControllerApiWorkerQueueSummary

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiWorkerQueueSummary from a JSON string
worker_group_controller_api_worker_queue_summary_instance = WorkerGroupControllerApiWorkerQueueSummary.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiWorkerQueueSummary.to_json())

# convert the object into a dict
worker_group_controller_api_worker_queue_summary_dict = worker_group_controller_api_worker_queue_summary_instance.to_dict()
# create an instance of WorkerGroupControllerApiWorkerQueueSummary from a dict
worker_group_controller_api_worker_queue_summary_from_dict = WorkerGroupControllerApiWorkerQueueSummary.from_dict(worker_group_controller_api_worker_queue_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


