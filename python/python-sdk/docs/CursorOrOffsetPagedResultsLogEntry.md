# CursorOrOffsetPagedResultsLogEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[LogEntry]**](LogEntry.md) |  | 
**total** | **int** |  | [optional] 
**type** | [**PaginationType**](PaginationType.md) |  | 
**next_cursor** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.cursor_or_offset_paged_results_log_entry import CursorOrOffsetPagedResultsLogEntry

# TODO update the JSON string below
json = "{}"
# create an instance of CursorOrOffsetPagedResultsLogEntry from a JSON string
cursor_or_offset_paged_results_log_entry_instance = CursorOrOffsetPagedResultsLogEntry.from_json(json)
# print the JSON string representation of the object
print(CursorOrOffsetPagedResultsLogEntry.to_json())

# convert the object into a dict
cursor_or_offset_paged_results_log_entry_dict = cursor_or_offset_paged_results_log_entry_instance.to_dict()
# create an instance of CursorOrOffsetPagedResultsLogEntry from a dict
cursor_or_offset_paged_results_log_entry_from_dict = CursorOrOffsetPagedResultsLogEntry.from_dict(cursor_or_offset_paged_results_log_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


