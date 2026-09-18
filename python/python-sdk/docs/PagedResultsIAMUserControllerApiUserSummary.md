# PagedResultsIAMUserControllerApiUserSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[IAMUserControllerApiUserSummary]**](IAMUserControllerApiUserSummary.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_iam_user_controller_api_user_summary import PagedResultsIAMUserControllerApiUserSummary

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsIAMUserControllerApiUserSummary from a JSON string
paged_results_iam_user_controller_api_user_summary_instance = PagedResultsIAMUserControllerApiUserSummary.from_json(json)
# print the JSON string representation of the object
print(PagedResultsIAMUserControllerApiUserSummary.to_json())

# convert the object into a dict
paged_results_iam_user_controller_api_user_summary_dict = paged_results_iam_user_controller_api_user_summary_instance.to_dict()
# create an instance of PagedResultsIAMUserControllerApiUserSummary from a dict
paged_results_iam_user_controller_api_user_summary_from_dict = PagedResultsIAMUserControllerApiUserSummary.from_dict(paged_results_iam_user_controller_api_user_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


