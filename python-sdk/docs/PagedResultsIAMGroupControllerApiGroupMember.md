# PagedResultsIAMGroupControllerApiGroupMember


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[IAMGroupControllerApiGroupMember]**](IAMGroupControllerApiGroupMember.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_iam_group_controller_api_group_member import PagedResultsIAMGroupControllerApiGroupMember

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsIAMGroupControllerApiGroupMember from a JSON string
paged_results_iam_group_controller_api_group_member_instance = PagedResultsIAMGroupControllerApiGroupMember.from_json(json)
# print the JSON string representation of the object
print(PagedResultsIAMGroupControllerApiGroupMember.to_json())

# convert the object into a dict
paged_results_iam_group_controller_api_group_member_dict = paged_results_iam_group_controller_api_group_member_instance.to_dict()
# create an instance of PagedResultsIAMGroupControllerApiGroupMember from a dict
paged_results_iam_group_controller_api_group_member_from_dict = PagedResultsIAMGroupControllerApiGroupMember.from_dict(paged_results_iam_group_controller_api_group_member_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


