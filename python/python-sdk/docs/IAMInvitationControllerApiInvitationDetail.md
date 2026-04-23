# IAMInvitationControllerApiInvitationDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**roles** | [**List[ApiRoleSummary]**](ApiRoleSummary.md) |  | [optional] 
**groups** | [**List[ApiGroupSummary]**](ApiGroupSummary.md) |  | [optional] 
**tenant_id** | **str** |  | [optional] 
**email** | **str** |  | [optional] 
**status** | [**InvitationInvitationStatus**](InvitationInvitationStatus.md) |  | [optional] 
**sent_at** | **datetime** |  | [optional] 
**expired_at** | **datetime** |  | [optional] 
**accepted_at** | **datetime** |  | [optional] 
**super_admin** | **bool** |  | [optional] 
**link** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.iam_invitation_controller_api_invitation_detail import IAMInvitationControllerApiInvitationDetail

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


