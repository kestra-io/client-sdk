# PagedResultsIAMBindingControllerApiBindingDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[IAMBindingControllerApiBindingDetail]**](IAMBindingControllerApiBindingDetail.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_iam_binding_controller_api_binding_detail import PagedResultsIAMBindingControllerApiBindingDetail

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsIAMBindingControllerApiBindingDetail from a JSON string
paged_results_iam_binding_controller_api_binding_detail_instance = PagedResultsIAMBindingControllerApiBindingDetail.from_json(json)
# print the JSON string representation of the object
print(PagedResultsIAMBindingControllerApiBindingDetail.to_json())

# convert the object into a dict
paged_results_iam_binding_controller_api_binding_detail_dict = paged_results_iam_binding_controller_api_binding_detail_instance.to_dict()
# create an instance of PagedResultsIAMBindingControllerApiBindingDetail from a dict
paged_results_iam_binding_controller_api_binding_detail_from_dict = PagedResultsIAMBindingControllerApiBindingDetail.from_dict(paged_results_iam_binding_controller_api_binding_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


