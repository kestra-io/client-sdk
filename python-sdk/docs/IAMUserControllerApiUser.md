# IAMUserControllerApiUser


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**username** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**first_name** | **str** |  | [optional] 
**last_name** | **str** |  | [optional] 
**email** | **str** |  | [optional] 
**tenants** | [**List[ApiTenantSummary]**](ApiTenantSummary.md) |  | [optional] 
**auths** | [**List[IAMUserControllerApiUserAuth]**](IAMUserControllerApiUserAuth.md) |  | [optional] 
**groups** | [**List[IAMUserControllerApiGroup]**](IAMUserControllerApiGroup.md) |  | [optional] 
**super_admin** | **bool** |  | [optional] 
**restricted** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.iam_user_controller_api_user import IAMUserControllerApiUser

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserControllerApiUser from a JSON string
iam_user_controller_api_user_instance = IAMUserControllerApiUser.from_json(json)
# print the JSON string representation of the object
print(IAMUserControllerApiUser.to_json())

# convert the object into a dict
iam_user_controller_api_user_dict = iam_user_controller_api_user_instance.to_dict()
# create an instance of IAMUserControllerApiUser from a dict
iam_user_controller_api_user_from_dict = IAMUserControllerApiUser.from_dict(iam_user_controller_api_user_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


