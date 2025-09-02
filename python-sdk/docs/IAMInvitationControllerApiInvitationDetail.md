# IAMInvitationControllerApiInvitationDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**roles** | [**List[ApiRoleSummary]**](ApiRoleSummary.md) |  | 
**groups** | [**List[ApiGroupSummary]**](ApiGroupSummary.md) |  | 
**tenant_id** | **str** |  | 
**email** | **str** |  | 
**status** | [**InvitationInvitationStatus**](InvitationInvitationStatus.md) |  | 
**sent_at** | **datetime** |  | 
**expired_at** | **datetime** |  | 
**accepted_at** | **datetime** |  | 
**super_admin** | **bool** |  | 
**link** | **str** |  | 

## Example

```python
from kestra_api_client.models.iam_invitation_controller_api_invitation_detail import IAMInvitationControllerApiInvitationDetail

# TODO update the JSON string below
json = "{}"
# create an instance of IAMInvitationControllerApiInvitationDetail from a JSON string
iam_invitation_controller_api_invitation_detail_instance = IAMInvitationControllerApiInvitationDetail.from_json(json)
# print the JSON string representation of the object
print(IAMInvitationControllerApiInvitationDetail.to_json())

# convert the object into a dict
iam_invitation_controller_api_invitation_detail_dict = iam_invitation_controller_api_invitation_detail_instance.to_dict()
# create an instance of IAMInvitationControllerApiInvitationDetail from a dict
iam_invitation_controller_api_invitation_detail_from_dict = IAMInvitationControllerApiInvitationDetail.from_dict(iam_invitation_controller_api_invitation_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


