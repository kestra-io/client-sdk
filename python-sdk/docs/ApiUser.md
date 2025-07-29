# ApiUser


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**UserType**](UserType.md) |  | 
**group_list** | [**List[GroupIdentifier]**](GroupIdentifier.md) |  | [optional] 
**groups** | **List[object]** |  | [optional] 
**username** | **str** |  | 
**email** | **str** |  | 
**super_admin** | **bool** |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**first_name** | **str** |  | [optional] 
**last_name** | **str** |  | [optional] 
**providers** | [**List[AbstractUserTenantIdentityProvider]**](AbstractUserTenantIdentityProvider.md) |  | [optional] 
**auths** | [**List[ApiAuth]**](ApiAuth.md) |  | [optional] 

## Example

```python
from kestrapy.models.api_user import ApiUser

# TODO update the JSON string below
json = "{}"
# create an instance of ApiUser from a JSON string
api_user_instance = ApiUser.from_json(json)
# print the JSON string representation of the object
print(ApiUser.to_json())

# convert the object into a dict
api_user_dict = api_user_instance.to_dict()
# create an instance of ApiUser from a dict
api_user_from_dict = ApiUser.from_dict(api_user_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


