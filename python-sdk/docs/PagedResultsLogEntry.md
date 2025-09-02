# PagedResultsLogEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[LogEntry]**](LogEntry.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_log_entry import PagedResultsLogEntry

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsLogEntry from a JSON string
paged_results_log_entry_instance = PagedResultsLogEntry.from_json(json)
# print the JSON string representation of the object
print(PagedResultsLogEntry.to_json())

# convert the object into a dict
paged_results_log_entry_dict = paged_results_log_entry_instance.to_dict()
# create an instance of PagedResultsLogEntry from a dict
paged_results_log_entry_from_dict = PagedResultsLogEntry.from_dict(paged_results_log_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


