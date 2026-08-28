# PagedResultsSourceSearchResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[SourceSearchResult]**](SourceSearchResult.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_source_search_result import PagedResultsSourceSearchResult

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsSourceSearchResult from a JSON string
paged_results_source_search_result_instance = PagedResultsSourceSearchResult.from_json(json)
# print the JSON string representation of the object
print(PagedResultsSourceSearchResult.to_json())

# convert the object into a dict
paged_results_source_search_result_dict = paged_results_source_search_result_instance.to_dict()
# create an instance of PagedResultsSourceSearchResult from a dict
paged_results_source_search_result_from_dict = PagedResultsSourceSearchResult.from_dict(paged_results_source_search_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


