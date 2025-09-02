# LogEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**task_id** | **str** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 
**attempt_number** | **int** |  | [optional] 
**trigger_id** | **str** |  | [optional] 
**timestamp** | **datetime** |  | 
**level** | [**Level**](Level.md) |  | 
**thread** | **str** |  | 
**message** | **str** |  | 
**deleted** | **bool** |  | 
**execution_kind** | [**ExecutionKind**](ExecutionKind.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.log_entry import LogEntry

# TODO update the JSON string below
json = "{}"
# create an instance of LogEntry from a JSON string
log_entry_instance = LogEntry.from_json(json)
# print the JSON string representation of the object
print(LogEntry.to_json())

# convert the object into a dict
log_entry_dict = log_entry_instance.to_dict()
# create an instance of LogEntry from a dict
log_entry_from_dict = LogEntry.from_dict(log_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


