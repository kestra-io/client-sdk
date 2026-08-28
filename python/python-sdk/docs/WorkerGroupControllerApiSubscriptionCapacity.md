# WorkerGroupControllerApiSubscriptionCapacity


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**worker_queue_id** | **str** |  | [optional] 
**allocated** | **int** |  | [optional] 
**used** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_subscription_capacity import WorkerGroupControllerApiSubscriptionCapacity

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiSubscriptionCapacity from a JSON string
worker_group_controller_api_subscription_capacity_instance = WorkerGroupControllerApiSubscriptionCapacity.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiSubscriptionCapacity.to_json())

# convert the object into a dict
worker_group_controller_api_subscription_capacity_dict = worker_group_controller_api_subscription_capacity_instance.to_dict()
# create an instance of WorkerGroupControllerApiSubscriptionCapacity from a dict
worker_group_controller_api_subscription_capacity_from_dict = WorkerGroupControllerApiSubscriptionCapacity.from_dict(worker_group_controller_api_subscription_capacity_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


