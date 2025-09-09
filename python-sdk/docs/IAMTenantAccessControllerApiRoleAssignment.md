# IAMTenantAccessControllerApiRoleAssignment


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**namespace** | **str** |  | 
**origin** | [**RBACServiceRoleAssignmentRoleOrigin**](RBACServiceRoleAssignmentRoleOrigin.md) |  | 
**source_id** | **str** |  | 
**permissions** | [**List[IAMTenantAccessControllerApiUserPermission]**](IAMTenantAccessControllerApiUserPermission.md) |  | 

## Example

```python
from kestrapy.models.iam_tenant_access_controller_api_role_assignment import IAMTenantAccessControllerApiRoleAssignment

# TODO update the JSON string below
json = "{}"
# create an instance of IAMTenantAccessControllerApiRoleAssignment from a JSON string
iam_tenant_access_controller_api_role_assignment_instance = IAMTenantAccessControllerApiRoleAssignment.from_json(json)
# print the JSON string representation of the object
print(IAMTenantAccessControllerApiRoleAssignment.to_json())

# convert the object into a dict
iam_tenant_access_controller_api_role_assignment_dict = iam_tenant_access_controller_api_role_assignment_instance.to_dict()
# create an instance of IAMTenantAccessControllerApiRoleAssignment from a dict
iam_tenant_access_controller_api_role_assignment_from_dict = IAMTenantAccessControllerApiRoleAssignment.from_dict(iam_tenant_access_controller_api_role_assignment_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


