# IAMUserControllerApiCreateOrUpdateUserRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenants** | **List[str]** |  | [optional] 
**groups** | **List[str]** |  | [optional] 
**first_name** | **str** |  | [optional] 
**last_name** | **str** |  | [optional] 
**email** | **str** |  | 
**password** | **str** |  | [optional] 
**super_admin** | **bool** |  | [optional] 
**restricted** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.iam_user_controller_api_create_or_update_user_request import IAMUserControllerApiCreateOrUpdateUserRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserControllerApiCreateOrUpdateUserRequest from a JSON string
iam_user_controller_api_create_or_update_user_request_instance = IAMUserControllerApiCreateOrUpdateUserRequest.from_json(json)
# print the JSON string representation of the object
print(IAMUserControllerApiCreateOrUpdateUserRequest.to_json())

# convert the object into a dict
iam_user_controller_api_create_or_update_user_request_dict = iam_user_controller_api_create_or_update_user_request_instance.to_dict()
# create an instance of IAMUserControllerApiCreateOrUpdateUserRequest from a dict
iam_user_controller_api_create_or_update_user_request_from_dict = IAMUserControllerApiCreateOrUpdateUserRequest.from_dict(iam_user_controller_api_create_or_update_user_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


