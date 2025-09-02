# IAMUserControllerApiPatchRestrictedRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**restricted** | **bool** |  | 

## Example

```python
from kestra_api_client.models.iam_user_controller_api_patch_restricted_request import IAMUserControllerApiPatchRestrictedRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserControllerApiPatchRestrictedRequest from a JSON string
iam_user_controller_api_patch_restricted_request_instance = IAMUserControllerApiPatchRestrictedRequest.from_json(json)
# print the JSON string representation of the object
print(IAMUserControllerApiPatchRestrictedRequest.to_json())

# convert the object into a dict
iam_user_controller_api_patch_restricted_request_dict = iam_user_controller_api_patch_restricted_request_instance.to_dict()
# create an instance of IAMUserControllerApiPatchRestrictedRequest from a dict
iam_user_controller_api_patch_restricted_request_from_dict = IAMUserControllerApiPatchRestrictedRequest.from_dict(iam_user_controller_api_patch_restricted_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


