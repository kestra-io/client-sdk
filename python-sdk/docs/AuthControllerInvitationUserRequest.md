# AuthControllerInvitationUserRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**first_name** | **str** |  | 
**last_name** | **str** |  | 
**password** | **str** |  | 

## Example

```python
from kestra_api_client.models.auth_controller_invitation_user_request import AuthControllerInvitationUserRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AuthControllerInvitationUserRequest from a JSON string
auth_controller_invitation_user_request_instance = AuthControllerInvitationUserRequest.from_json(json)
# print the JSON string representation of the object
print(AuthControllerInvitationUserRequest.to_json())

# convert the object into a dict
auth_controller_invitation_user_request_dict = auth_controller_invitation_user_request_instance.to_dict()
# create an instance of AuthControllerInvitationUserRequest from a dict
auth_controller_invitation_user_request_from_dict = AuthControllerInvitationUserRequest.from_dict(auth_controller_invitation_user_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


