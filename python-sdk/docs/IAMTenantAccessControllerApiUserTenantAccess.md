# IAMTenantAccessControllerApiUserTenantAccess


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**username** | **str** |  | 
**display_name** | **str** |  | 
**description** | **str** |  | 
**groups** | [**List[IAMTenantAccessControllerApiGroup]**](IAMTenantAccessControllerApiGroup.md) |  | 
**auths** | [**List[IAMTenantAccessControllerApiAuthentication]**](IAMTenantAccessControllerApiAuthentication.md) |  | 

## Example

```python
from kestrapy.models.iam_tenant_access_controller_api_user_tenant_access import IAMTenantAccessControllerApiUserTenantAccess

# TODO update the JSON string below
json = "{}"
# create an instance of IAMTenantAccessControllerApiUserTenantAccess from a JSON string
iam_tenant_access_controller_api_user_tenant_access_instance = IAMTenantAccessControllerApiUserTenantAccess.from_json(json)
# print the JSON string representation of the object
print(IAMTenantAccessControllerApiUserTenantAccess.to_json())

# convert the object into a dict
iam_tenant_access_controller_api_user_tenant_access_dict = iam_tenant_access_controller_api_user_tenant_access_instance.to_dict()
# create an instance of IAMTenantAccessControllerApiUserTenantAccess from a dict
iam_tenant_access_controller_api_user_tenant_access_from_dict = IAMTenantAccessControllerApiUserTenantAccess.from_dict(iam_tenant_access_controller_api_user_tenant_access_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


