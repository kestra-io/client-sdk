# WorkerGroupControllerApiUpdateSubscriptionRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reserved_percent** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_update_subscription_request import WorkerGroupControllerApiUpdateSubscriptionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiUpdateSubscriptionRequest from a JSON string
worker_group_controller_api_update_subscription_request_instance = WorkerGroupControllerApiUpdateSubscriptionRequest.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiUpdateSubscriptionRequest.to_json())

# convert the object into a dict
worker_group_controller_api_update_subscription_request_dict = worker_group_controller_api_update_subscription_request_instance.to_dict()
# create an instance of WorkerGroupControllerApiUpdateSubscriptionRequest from a dict
worker_group_controller_api_update_subscription_request_from_dict = WorkerGroupControllerApiUpdateSubscriptionRequest.from_dict(worker_group_controller_api_update_subscription_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


