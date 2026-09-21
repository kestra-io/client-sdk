# WorkerGroupControllerApiSubscriptionResponse

The worker-group ↔ WorkerQueue subscription edge as exposed on the API. Embeds the resolved queue's name + tags + tenants so consumers don't need a separate lookup. The default subscription is represented by a queue summary with the reserved io.kestra.core.worker.WorkerQueues#DEFAULT_ID \"default\" id and empty tags.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**queue** | [**WorkerGroupControllerApiWorkerQueueSummary**](WorkerGroupControllerApiWorkerQueueSummary.md) |  | [optional] 
**reserved_percent** | **int** |  | [optional] 
**mode** | [**QueueSubscriptionMode**](QueueSubscriptionMode.md) |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_subscription_response import WorkerGroupControllerApiSubscriptionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiSubscriptionResponse from a JSON string
worker_group_controller_api_subscription_response_instance = WorkerGroupControllerApiSubscriptionResponse.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiSubscriptionResponse.to_json())

# convert the object into a dict
worker_group_controller_api_subscription_response_dict = worker_group_controller_api_subscription_response_instance.to_dict()
# create an instance of WorkerGroupControllerApiSubscriptionResponse from a dict
worker_group_controller_api_subscription_response_from_dict = WorkerGroupControllerApiSubscriptionResponse.from_dict(worker_group_controller_api_subscription_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


