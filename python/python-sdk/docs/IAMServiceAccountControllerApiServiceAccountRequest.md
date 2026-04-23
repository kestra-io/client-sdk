# IAMServiceAccountControllerApiServiceAccountRequest

A User Service Account.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | [**List[IAMServiceAccountControllerApiGroup]**](IAMServiceAccountControllerApiGroup.md) |  | [optional] 
**name** | **str** |  | 
**description** | **str** |  | [optional] 
**super_admin** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.iam_service_account_controller_api_service_account_request import IAMServiceAccountControllerApiServiceAccountRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMServiceAccountControllerApiServiceAccountRequest from a JSON string
iam_service_account_controller_api_service_account_request_instance = IAMServiceAccountControllerApiServiceAccountRequest.from_json(json)
# print the JSON string representation of the object
print(IAMServiceAccountControllerApiServiceAccountRequest.to_json())

# convert the object into a dict
iam_service_account_controller_api_service_account_request_dict = iam_service_account_controller_api_service_account_request_instance.to_dict()
# create an instance of IAMServiceAccountControllerApiServiceAccountRequest from a dict
iam_service_account_controller_api_service_account_request_from_dict = IAMServiceAccountControllerApiServiceAccountRequest.from_dict(iam_service_account_controller_api_service_account_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


