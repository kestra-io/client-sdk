# AbstractUserTenantIdentityProvider


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attributes** | **Dict[str, object]** |  | 
**external_id** | **str** |  | 
**security_integration_id** | **str** |  | 
**security_integration_name** | **str** |  | 
**tenant_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.abstract_user_tenant_identity_provider import AbstractUserTenantIdentityProvider

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractUserTenantIdentityProvider from a JSON string
abstract_user_tenant_identity_provider_instance = AbstractUserTenantIdentityProvider.from_json(json)
# print the JSON string representation of the object
print(AbstractUserTenantIdentityProvider.to_json())

# convert the object into a dict
abstract_user_tenant_identity_provider_dict = abstract_user_tenant_identity_provider_instance.to_dict()
# create an instance of AbstractUserTenantIdentityProvider from a dict
abstract_user_tenant_identity_provider_from_dict = AbstractUserTenantIdentityProvider.from_dict(abstract_user_tenant_identity_provider_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


