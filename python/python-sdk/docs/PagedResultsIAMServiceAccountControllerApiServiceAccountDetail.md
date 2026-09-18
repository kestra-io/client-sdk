# PagedResultsIAMServiceAccountControllerApiServiceAccountDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[IAMServiceAccountControllerApiServiceAccountDetail]**](IAMServiceAccountControllerApiServiceAccountDetail.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_iam_service_account_controller_api_service_account_detail import PagedResultsIAMServiceAccountControllerApiServiceAccountDetail

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsIAMServiceAccountControllerApiServiceAccountDetail from a JSON string
paged_results_iam_service_account_controller_api_service_account_detail_instance = PagedResultsIAMServiceAccountControllerApiServiceAccountDetail.from_json(json)
# print the JSON string representation of the object
print(PagedResultsIAMServiceAccountControllerApiServiceAccountDetail.to_json())

# convert the object into a dict
paged_results_iam_service_account_controller_api_service_account_detail_dict = paged_results_iam_service_account_controller_api_service_account_detail_instance.to_dict()
# create an instance of PagedResultsIAMServiceAccountControllerApiServiceAccountDetail from a dict
paged_results_iam_service_account_controller_api_service_account_detail_from_dict = PagedResultsIAMServiceAccountControllerApiServiceAccountDetail.from_dict(paged_results_iam_service_account_controller_api_service_account_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


