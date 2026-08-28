# TriggerControllerApiCreateBackfillRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**trigger_id** | **str** |  | [optional] 
**backfill** | [**TriggerControllerApiCreateBackfillRequestBackfill**](TriggerControllerApiCreateBackfillRequestBackfill.md) |  | [optional] 

## Example

```python
from kestrapy.models.trigger_controller_api_create_backfill_request import TriggerControllerApiCreateBackfillRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TriggerControllerApiCreateBackfillRequest from a JSON string
trigger_controller_api_create_backfill_request_instance = TriggerControllerApiCreateBackfillRequest.from_json(json)
# print the JSON string representation of the object
print(TriggerControllerApiCreateBackfillRequest.to_json())

# convert the object into a dict
trigger_controller_api_create_backfill_request_dict = trigger_controller_api_create_backfill_request_instance.to_dict()
# create an instance of TriggerControllerApiCreateBackfillRequest from a dict
trigger_controller_api_create_backfill_request_from_dict = TriggerControllerApiCreateBackfillRequest.from_dict(trigger_controller_api_create_backfill_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


