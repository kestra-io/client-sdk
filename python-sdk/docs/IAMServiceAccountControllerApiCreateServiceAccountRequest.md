# IAMServiceAccountControllerApiCreateServiceAccountRequest

Request payload for updating service account details

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**description** | **str** |  | 
**super_admin** | **bool** |  | 
**tenants** | **List[str]** |  | 

## Example

```python
from kestrapy.models.iam_service_account_controller_api_create_service_account_request import IAMServiceAccountControllerApiCreateServiceAccountRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMServiceAccountControllerApiCreateServiceAccountRequest from a JSON string
iam_service_account_controller_api_create_service_account_request_instance = IAMServiceAccountControllerApiCreateServiceAccountRequest.from_json(json)
# print the JSON string representation of the object
print(IAMServiceAccountControllerApiCreateServiceAccountRequest.to_json())

# convert the object into a dict
iam_service_account_controller_api_create_service_account_request_dict = iam_service_account_controller_api_create_service_account_request_instance.to_dict()
# create an instance of IAMServiceAccountControllerApiCreateServiceAccountRequest from a dict
iam_service_account_controller_api_create_service_account_request_from_dict = IAMServiceAccountControllerApiCreateServiceAccountRequest.from_dict(iam_service_account_controller_api_create_service_account_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


