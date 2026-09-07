# AuthControllerForgottenPasswordRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**username** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.auth_controller_forgotten_password_request import AuthControllerForgottenPasswordRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AuthControllerForgottenPasswordRequest from a JSON string
auth_controller_forgotten_password_request_instance = AuthControllerForgottenPasswordRequest.from_json(json)
# print the JSON string representation of the object
print(AuthControllerForgottenPasswordRequest.to_json())

# convert the object into a dict
auth_controller_forgotten_password_request_dict = auth_controller_forgotten_password_request_instance.to_dict()
# create an instance of AuthControllerForgottenPasswordRequest from a dict
auth_controller_forgotten_password_request_from_dict = AuthControllerForgottenPasswordRequest.from_dict(auth_controller_forgotten_password_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


