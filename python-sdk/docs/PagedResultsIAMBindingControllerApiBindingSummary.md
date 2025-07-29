# PagedResultsIAMBindingControllerApiBindingSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[IAMBindingControllerApiBindingSummary]**](IAMBindingControllerApiBindingSummary.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_iam_binding_controller_api_binding_summary import PagedResultsIAMBindingControllerApiBindingSummary

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsIAMBindingControllerApiBindingSummary from a JSON string
paged_results_iam_binding_controller_api_binding_summary_instance = PagedResultsIAMBindingControllerApiBindingSummary.from_json(json)
# print the JSON string representation of the object
print(PagedResultsIAMBindingControllerApiBindingSummary.to_json())

# convert the object into a dict
paged_results_iam_binding_controller_api_binding_summary_dict = paged_results_iam_binding_controller_api_binding_summary_instance.to_dict()
# create an instance of PagedResultsIAMBindingControllerApiBindingSummary from a dict
paged_results_iam_binding_controller_api_binding_summary_from_dict = PagedResultsIAMBindingControllerApiBindingSummary.from_dict(paged_results_iam_binding_controller_api_binding_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


