# WorkerGroupControllerApiSubscriptionRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**worker_queue_id** | **str** |  | 
**reserved_percent** | **int** |  | [optional] 
**mode** | [**QueueSubscriptionMode**](QueueSubscriptionMode.md) |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_subscription_request import WorkerGroupControllerApiSubscriptionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiSubscriptionRequest from a JSON string
worker_group_controller_api_subscription_request_instance = WorkerGroupControllerApiSubscriptionRequest.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiSubscriptionRequest.to_json())

# convert the object into a dict
worker_group_controller_api_subscription_request_dict = worker_group_controller_api_subscription_request_instance.to_dict()
# create an instance of WorkerGroupControllerApiSubscriptionRequest from a dict
worker_group_controller_api_subscription_request_from_dict = WorkerGroupControllerApiSubscriptionRequest.from_dict(worker_group_controller_api_subscription_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


