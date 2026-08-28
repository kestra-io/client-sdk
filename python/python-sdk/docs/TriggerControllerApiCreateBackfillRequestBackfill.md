# TriggerControllerApiCreateBackfillRequestBackfill


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start** | **datetime** |  | [optional] 
**end** | **datetime** |  | [optional] 
**inputs** | **Dict[str, object]** |  | [optional] 
**labels** | [**List[Label]**](Label.md) |  | [optional] 

## Example

```python
from kestrapy.models.trigger_controller_api_create_backfill_request_backfill import TriggerControllerApiCreateBackfillRequestBackfill

# TODO update the JSON string below
json = "{}"
# create an instance of TriggerControllerApiCreateBackfillRequestBackfill from a JSON string
trigger_controller_api_create_backfill_request_backfill_instance = TriggerControllerApiCreateBackfillRequestBackfill.from_json(json)
# print the JSON string representation of the object
print(TriggerControllerApiCreateBackfillRequestBackfill.to_json())

# convert the object into a dict
trigger_controller_api_create_backfill_request_backfill_dict = trigger_controller_api_create_backfill_request_backfill_instance.to_dict()
# create an instance of TriggerControllerApiCreateBackfillRequestBackfill from a dict
trigger_controller_api_create_backfill_request_backfill_from_dict = TriggerControllerApiCreateBackfillRequestBackfill.from_dict(trigger_controller_api_create_backfill_request_backfill_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


