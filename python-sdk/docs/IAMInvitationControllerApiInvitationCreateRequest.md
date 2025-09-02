# IAMInvitationControllerApiInvitationCreateRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**create_user_if_not_exist** | **bool** |  | 
**super_admin** | **bool** |  | 
**roles** | [**List[IAMInvitationControllerApiInvitationRole]**](IAMInvitationControllerApiInvitationRole.md) |  | 
**groups** | **List[str]** |  | 
**email** | **str** |  | 

## Example

```python
from kestra_api_client.models.iam_invitation_controller_api_invitation_create_request import IAMInvitationControllerApiInvitationCreateRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMInvitationControllerApiInvitationCreateRequest from a JSON string
iam_invitation_controller_api_invitation_create_request_instance = IAMInvitationControllerApiInvitationCreateRequest.from_json(json)
# print the JSON string representation of the object
print(IAMInvitationControllerApiInvitationCreateRequest.to_json())

# convert the object into a dict
iam_invitation_controller_api_invitation_create_request_dict = iam_invitation_controller_api_invitation_create_request_instance.to_dict()
# create an instance of IAMInvitationControllerApiInvitationCreateRequest from a dict
iam_invitation_controller_api_invitation_create_request_from_dict = IAMInvitationControllerApiInvitationCreateRequest.from_dict(iam_invitation_controller_api_invitation_create_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


