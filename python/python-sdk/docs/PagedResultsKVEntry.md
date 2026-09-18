# PagedResultsKVEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[KVEntry]**](KVEntry.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_kv_entry import PagedResultsKVEntry

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsKVEntry from a JSON string
paged_results_kv_entry_instance = PagedResultsKVEntry.from_json(json)
# print the JSON string representation of the object
print(PagedResultsKVEntry.to_json())

# convert the object into a dict
paged_results_kv_entry_dict = paged_results_kv_entry_instance.to_dict()
# create an instance of PagedResultsKVEntry from a dict
paged_results_kv_entry_from_dict = PagedResultsKVEntry.from_dict(paged_results_kv_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


