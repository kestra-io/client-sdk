# IAMServiceAccountControllerApiPatchServiceAccountRequest

Request payload for updating service account details

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**description** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.iam_service_account_controller_api_patch_service_account_request import IAMServiceAccountControllerApiPatchServiceAccountRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMServiceAccountControllerApiPatchServiceAccountRequest from a JSON string
iam_service_account_controller_api_patch_service_account_request_instance = IAMServiceAccountControllerApiPatchServiceAccountRequest.from_json(json)
# print the JSON string representation of the object
print(IAMServiceAccountControllerApiPatchServiceAccountRequest.to_json())

# convert the object into a dict
iam_service_account_controller_api_patch_service_account_request_dict = iam_service_account_controller_api_patch_service_account_request_instance.to_dict()
# create an instance of IAMServiceAccountControllerApiPatchServiceAccountRequest from a dict
iam_service_account_controller_api_patch_service_account_request_from_dict = IAMServiceAccountControllerApiPatchServiceAccountRequest.from_dict(iam_service_account_controller_api_patch_service_account_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


