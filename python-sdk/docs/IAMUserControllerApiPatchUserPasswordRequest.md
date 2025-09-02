# IAMUserControllerApiPatchUserPasswordRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**password** | **str** |  | 

## Example

```python
from kestra_api_client.models.iam_user_controller_api_patch_user_password_request import IAMUserControllerApiPatchUserPasswordRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserControllerApiPatchUserPasswordRequest from a JSON string
iam_user_controller_api_patch_user_password_request_instance = IAMUserControllerApiPatchUserPasswordRequest.from_json(json)
# print the JSON string representation of the object
print(IAMUserControllerApiPatchUserPasswordRequest.to_json())

# convert the object into a dict
iam_user_controller_api_patch_user_password_request_dict = iam_user_controller_api_patch_user_password_request_instance.to_dict()
# create an instance of IAMUserControllerApiPatchUserPasswordRequest from a dict
iam_user_controller_api_patch_user_password_request_from_dict = IAMUserControllerApiPatchUserPasswordRequest.from_dict(iam_user_controller_api_patch_user_password_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


