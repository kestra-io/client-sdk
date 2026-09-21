# WorkerGroupControllerApiWorkerGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**subscriptions** | [**List[WorkerGroupControllerApiSubscriptionResponse]**](WorkerGroupControllerApiSubscriptionResponse.md) |  | [optional] 
**tokens** | [**List[WorkerGroupControllerApiWorkerGroupTokenSummary]**](WorkerGroupControllerApiWorkerGroupTokenSummary.md) |  | [optional] 
**deletable** | **bool** |  | [optional] 
**created_at** | **datetime** |  | [optional] 
**updated_at** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_worker_group import WorkerGroupControllerApiWorkerGroup

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiWorkerGroup from a JSON string
worker_group_controller_api_worker_group_instance = WorkerGroupControllerApiWorkerGroup.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiWorkerGroup.to_json())

# convert the object into a dict
worker_group_controller_api_worker_group_dict = worker_group_controller_api_worker_group_instance.to_dict()
# create an instance of WorkerGroupControllerApiWorkerGroup from a dict
worker_group_controller_api_worker_group_from_dict = WorkerGroupControllerApiWorkerGroup.from_dict(worker_group_controller_api_worker_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


