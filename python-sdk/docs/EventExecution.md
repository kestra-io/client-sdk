# EventExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**Execution**](Execution.md) |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**comment** | **str** |  | [optional] 
**retry** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.event_execution import EventExecution

# TODO update the JSON string below
json = "{}"
# create an instance of EventExecution from a JSON string
event_execution_instance = EventExecution.from_json(json)
# print the JSON string representation of the object
print(EventExecution.to_json())

# convert the object into a dict
event_execution_dict = event_execution_instance.to_dict()
# create an instance of EventExecution from a dict
event_execution_from_dict = EventExecution.from_dict(event_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


