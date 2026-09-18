# PagedResultsConcurrencyLimit


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ConcurrencyLimit]**](ConcurrencyLimit.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_concurrency_limit import PagedResultsConcurrencyLimit

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsConcurrencyLimit from a JSON string
paged_results_concurrency_limit_instance = PagedResultsConcurrencyLimit.from_json(json)
# print the JSON string representation of the object
print(PagedResultsConcurrencyLimit.to_json())

# convert the object into a dict
paged_results_concurrency_limit_dict = paged_results_concurrency_limit_instance.to_dict()
# create an instance of PagedResultsConcurrencyLimit from a dict
paged_results_concurrency_limit_from_dict = PagedResultsConcurrencyLimit.from_dict(paged_results_concurrency_limit_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


