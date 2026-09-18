# AuthControllerResetPasswordRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**token** | **str** |  | [optional] 
**password** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.auth_controller_reset_password_request import AuthControllerResetPasswordRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AuthControllerResetPasswordRequest from a JSON string
auth_controller_reset_password_request_instance = AuthControllerResetPasswordRequest.from_json(json)
# print the JSON string representation of the object
print(AuthControllerResetPasswordRequest.to_json())

# convert the object into a dict
auth_controller_reset_password_request_dict = auth_controller_reset_password_request_instance.to_dict()
# create an instance of AuthControllerResetPasswordRequest from a dict
auth_controller_reset_password_request_from_dict = AuthControllerResetPasswordRequest.from_dict(auth_controller_reset_password_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


