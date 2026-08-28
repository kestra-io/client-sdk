# PagedResultsApiGroupSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiGroupSummary]**](ApiGroupSummary.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_group_summary import PagedResultsApiGroupSummary

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiGroupSummary from a JSON string
paged_results_api_group_summary_instance = PagedResultsApiGroupSummary.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiGroupSummary.to_json())

# convert the object into a dict
paged_results_api_group_summary_dict = paged_results_api_group_summary_instance.to_dict()
# create an instance of PagedResultsApiGroupSummary from a dict
paged_results_api_group_summary_from_dict = PagedResultsApiGroupSummary.from_dict(paged_results_api_group_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


