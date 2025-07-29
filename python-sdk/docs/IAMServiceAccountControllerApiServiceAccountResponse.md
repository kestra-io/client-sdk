# IAMServiceAccountControllerApiServiceAccountResponse

A User Service Account.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | the identifier of this service account. | [optional] 
**name** | **str** | the name of this service account. | 
**description** | **str** | the description of this service account. | [optional] 
**groups** | [**List[IAMServiceAccountControllerApiGroup]**](IAMServiceAccountControllerApiGroup.md) |  | [optional] 
**super_admin** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.iam_service_account_controller_api_service_account_response import IAMServiceAccountControllerApiServiceAccountResponse

# TODO update the JSON string below
json = "{}"
# create an instance of IAMServiceAccountControllerApiServiceAccountResponse from a JSON string
iam_service_account_controller_api_service_account_response_instance = IAMServiceAccountControllerApiServiceAccountResponse.from_json(json)
# print the JSON string representation of the object
print(IAMServiceAccountControllerApiServiceAccountResponse.to_json())

# convert the object into a dict
iam_service_account_controller_api_service_account_response_dict = iam_service_account_controller_api_service_account_response_instance.to_dict()
# create an instance of IAMServiceAccountControllerApiServiceAccountResponse from a dict
iam_service_account_controller_api_service_account_response_from_dict = IAMServiceAccountControllerApiServiceAccountResponse.from_dict(iam_service_account_controller_api_service_account_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


