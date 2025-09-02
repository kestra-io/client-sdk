# AbstractUser


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

## Example

```python
from kestra_api_client.models.abstract_user import AbstractUser

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractUser from a JSON string
abstract_user_instance = AbstractUser.from_json(json)
# print the JSON string representation of the object
print(AbstractUser.to_json())

# convert the object into a dict
abstract_user_dict = abstract_user_instance.to_dict()
# create an instance of AbstractUser from a dict
abstract_user_from_dict = AbstractUser.from_dict(abstract_user_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


