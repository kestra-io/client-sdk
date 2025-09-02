# ExecutionStatusEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**execution_id** | **str** |  | 
**tenant_id** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**state** | [**State**](State.md) |  | 

## Example

```python
from kestrapy.models.execution_status_event import ExecutionStatusEvent

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionStatusEvent from a JSON string
execution_status_event_instance = ExecutionStatusEvent.from_json(json)
# print the JSON string representation of the object
print(ExecutionStatusEvent.to_json())

# convert the object into a dict
execution_status_event_dict = execution_status_event_instance.to_dict()
# create an instance of ExecutionStatusEvent from a dict
execution_status_event_from_dict = ExecutionStatusEvent.from_dict(execution_status_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


