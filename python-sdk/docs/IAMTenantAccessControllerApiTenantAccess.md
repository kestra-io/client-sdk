# IAMTenantAccessControllerApiTenantAccess


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | 
**user_id** | **str** |  | 
**username** | **str** |  | 
**display_name** | **str** |  | 
**groups** | [**List[IAMTenantAccessControllerApiGroup]**](IAMTenantAccessControllerApiGroup.md) |  | 
**roles** | [**List[IAMTenantAccessControllerApiRoleAssignment]**](IAMTenantAccessControllerApiRoleAssignment.md) |  | 
**super_admin** | **bool** |  | 

## Example

```python
from kestra_api_client.models.iam_tenant_access_controller_api_tenant_access import IAMTenantAccessControllerApiTenantAccess

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


