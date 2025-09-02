# IAMInvitationControllerApiInvitationRole


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**namespaces** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.iam_invitation_controller_api_invitation_role import IAMInvitationControllerApiInvitationRole

# TODO update the JSON string below
json = "{}"
# create an instance of IAMInvitationControllerApiInvitationRole from a JSON string
iam_invitation_controller_api_invitation_role_instance = IAMInvitationControllerApiInvitationRole.from_json(json)
# print the JSON string representation of the object
print(IAMInvitationControllerApiInvitationRole.to_json())

# convert the object into a dict
iam_invitation_controller_api_invitation_role_dict = iam_invitation_controller_api_invitation_role_instance.to_dict()
# create an instance of IAMInvitationControllerApiInvitationRole from a dict
iam_invitation_controller_api_invitation_role_from_dict = IAMInvitationControllerApiInvitationRole.from_dict(iam_invitation_controller_api_invitation_role_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


