# ExecutionControllerWebhookResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | 
**id** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**flow_revision** | **int** |  | 
**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  | 
**outputs** | **Dict[str, object]** |  | 
**labels** | [**List[Label]**](Label.md) |  | 
**state** | [**State**](State.md) |  | 
**url** | **str** |  | 

## Example

```python
from kestrapy.models.execution_controller_webhook_response import ExecutionControllerWebhookResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionControllerWebhookResponse from a JSON string
execution_controller_webhook_response_instance = ExecutionControllerWebhookResponse.from_json(json)
# print the JSON string representation of the object
print(ExecutionControllerWebhookResponse.to_json())

# convert the object into a dict
execution_controller_webhook_response_dict = execution_controller_webhook_response_instance.to_dict()
# create an instance of ExecutionControllerWebhookResponse from a dict
execution_controller_webhook_response_from_dict = ExecutionControllerWebhookResponse.from_dict(execution_controller_webhook_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


