# IAMTenantAccessControllerApiTenantAccess


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | [optional] 
**user_id** | **str** |  | [optional] 
**username** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**groups** | [**List[IAMTenantAccessControllerApiGroup]**](IAMTenantAccessControllerApiGroup.md) |  | [optional] 
**roles** | [**List[IAMTenantAccessControllerApiRoleAssignment]**](IAMTenantAccessControllerApiRoleAssignment.md) |  | [optional] 
**super_admin** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.iam_tenant_access_controller_api_tenant_access import IAMTenantAccessControllerApiTenantAccess

# TODO update the JSON string below
json = "{}"
# create an instance of IAMTenantAccessControllerApiTenantAccess from a JSON string
iam_tenant_access_controller_api_tenant_access_instance = IAMTenantAccessControllerApiTenantAccess.from_json(json)
# print the JSON string representation of the object
print(IAMTenantAccessControllerApiTenantAccess.to_json())

# convert the object into a dict
iam_tenant_access_controller_api_tenant_access_dict = iam_tenant_access_controller_api_tenant_access_instance.to_dict()
# create an instance of IAMTenantAccessControllerApiTenantAccess from a dict
iam_tenant_access_controller_api_tenant_access_from_dict = IAMTenantAccessControllerApiTenantAccess.from_dict(iam_tenant_access_controller_api_tenant_access_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


