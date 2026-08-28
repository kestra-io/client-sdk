# PagedResultsApiPolicySummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[PolicySummary]**](PolicySummary.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_policy_summary import PagedResultsApiPolicySummary

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiPolicySummary from a JSON string
paged_results_api_policy_summary_instance = PagedResultsApiPolicySummary.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiPolicySummary.to_json())

# convert the object into a dict
paged_results_api_policy_summary_dict = paged_results_api_policy_summary_instance.to_dict()
# create an instance of PagedResultsApiPolicySummary from a dict
paged_results_api_policy_summary_from_dict = PagedResultsApiPolicySummary.from_dict(paged_results_api_policy_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


