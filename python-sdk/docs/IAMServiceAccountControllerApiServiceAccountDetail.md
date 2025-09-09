# IAMServiceAccountControllerApiServiceAccountDetail

A User Service Account.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | the identifier of this service account. | 
**name** | **str** | the name of this service account. | 
**description** | **str** | the description of this service account. | 
**tenants** | [**List[ApiTenantSummary]**](ApiTenantSummary.md) |  | 
**super_admin** | **bool** |  | 

## Example

```python
from kestrapy.models.iam_service_account_controller_api_service_account_detail import IAMServiceAccountControllerApiServiceAccountDetail

# TODO update the JSON string below
json = "{}"
# create an instance of IAMServiceAccountControllerApiServiceAccountDetail from a JSON string
iam_service_account_controller_api_service_account_detail_instance = IAMServiceAccountControllerApiServiceAccountDetail.from_json(json)
# print the JSON string representation of the object
print(IAMServiceAccountControllerApiServiceAccountDetail.to_json())

# convert the object into a dict
iam_service_account_controller_api_service_account_detail_dict = iam_service_account_controller_api_service_account_detail_instance.to_dict()
# create an instance of IAMServiceAccountControllerApiServiceAccountDetail from a dict
iam_service_account_controller_api_service_account_detail_from_dict = IAMServiceAccountControllerApiServiceAccountDetail.from_dict(iam_service_account_controller_api_service_account_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


