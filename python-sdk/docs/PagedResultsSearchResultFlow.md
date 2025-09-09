# PagedResultsSearchResultFlow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[SearchResultFlow]**](SearchResultFlow.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_search_result_flow import PagedResultsSearchResultFlow

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsSearchResultFlow from a JSON string
paged_results_search_result_flow_instance = PagedResultsSearchResultFlow.from_json(json)
# print the JSON string representation of the object
print(PagedResultsSearchResultFlow.to_json())

# convert the object into a dict
paged_results_search_result_flow_dict = paged_results_search_result_flow_instance.to_dict()
# create an instance of PagedResultsSearchResultFlow from a dict
paged_results_search_result_flow_from_dict = PagedResultsSearchResultFlow.from_dict(paged_results_search_result_flow_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


