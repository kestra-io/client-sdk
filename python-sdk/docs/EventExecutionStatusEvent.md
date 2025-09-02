# EventExecutionStatusEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ExecutionStatusEvent**](ExecutionStatusEvent.md) |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**comment** | **str** |  | [optional] 
**retry** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.event_execution_status_event import EventExecutionStatusEvent

# TODO update the JSON string below
json = "{}"
# create an instance of EventExecutionStatusEvent from a JSON string
event_execution_status_event_instance = EventExecutionStatusEvent.from_json(json)
# print the JSON string representation of the object
print(EventExecutionStatusEvent.to_json())

# convert the object into a dict
event_execution_status_event_dict = event_execution_status_event_instance.to_dict()
# create an instance of EventExecutionStatusEvent from a dict
event_execution_status_event_from_dict = EventExecutionStatusEvent.from_dict(event_execution_status_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


