# PagedResultsApiRoleSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiRoleSummary]**](ApiRoleSummary.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_api_role_summary import PagedResultsApiRoleSummary

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiRoleSummary from a JSON string
paged_results_api_role_summary_instance = PagedResultsApiRoleSummary.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiRoleSummary.to_json())

# convert the object into a dict
paged_results_api_role_summary_dict = paged_results_api_role_summary_instance.to_dict()
# create an instance of PagedResultsApiRoleSummary from a dict
paged_results_api_role_summary_from_dict = PagedResultsApiRoleSummary.from_dict(paged_results_api_role_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


