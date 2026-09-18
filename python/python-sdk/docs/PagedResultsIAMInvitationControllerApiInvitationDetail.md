# PagedResultsIAMInvitationControllerApiInvitationDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[IAMInvitationControllerApiInvitationDetail]**](IAMInvitationControllerApiInvitationDetail.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_iam_invitation_controller_api_invitation_detail import PagedResultsIAMInvitationControllerApiInvitationDetail

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsIAMInvitationControllerApiInvitationDetail from a JSON string
paged_results_iam_invitation_controller_api_invitation_detail_instance = PagedResultsIAMInvitationControllerApiInvitationDetail.from_json(json)
# print the JSON string representation of the object
print(PagedResultsIAMInvitationControllerApiInvitationDetail.to_json())

# convert the object into a dict
paged_results_iam_invitation_controller_api_invitation_detail_dict = paged_results_iam_invitation_controller_api_invitation_detail_instance.to_dict()
# create an instance of PagedResultsIAMInvitationControllerApiInvitationDetail from a dict
paged_results_iam_invitation_controller_api_invitation_detail_from_dict = PagedResultsIAMInvitationControllerApiInvitationDetail.from_dict(paged_results_iam_invitation_controller_api_invitation_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


