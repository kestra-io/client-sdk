# WorkerGroupControllerApiWorkerGroupCapacity


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**worker_group_id** | **str** |  | [optional] 
**total_allocated** | **int** |  | [optional] 
**total_used** | **int** |  | [optional] 
**total_inflight** | **int** |  | [optional] 
**subscriptions** | [**List[WorkerGroupControllerApiSubscriptionCapacity]**](WorkerGroupControllerApiSubscriptionCapacity.md) |  | [optional] 
**shared** | [**WorkerGroupControllerApiSharedCapacity**](WorkerGroupControllerApiSharedCapacity.md) |  | [optional] 
**total_ended_rate** | **float** |  | [optional] 
**snapshot_at** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_worker_group_capacity import WorkerGroupControllerApiWorkerGroupCapacity

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiWorkerGroupCapacity from a JSON string
worker_group_controller_api_worker_group_capacity_instance = WorkerGroupControllerApiWorkerGroupCapacity.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiWorkerGroupCapacity.to_json())

# convert the object into a dict
worker_group_controller_api_worker_group_capacity_dict = worker_group_controller_api_worker_group_capacity_instance.to_dict()
# create an instance of WorkerGroupControllerApiWorkerGroupCapacity from a dict
worker_group_controller_api_worker_group_capacity_from_dict = WorkerGroupControllerApiWorkerGroupCapacity.from_dict(worker_group_controller_api_worker_group_capacity_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


