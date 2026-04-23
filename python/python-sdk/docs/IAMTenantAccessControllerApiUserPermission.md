# IAMTenantAccessControllerApiUserPermission


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**permission** | [**Permission**](Permission.md) |  | [optional] 
**actions** | [**List[Action]**](Action.md) |  | [optional] 

## Example

```python
from kestrapy.models.iam_tenant_access_controller_api_user_permission import IAMTenantAccessControllerApiUserPermission

# TODO update the JSON string below
json = "{}"
# create an instance of IAMTenantAccessControllerApiUserPermission from a JSON string
iam_tenant_access_controller_api_user_permission_instance = IAMTenantAccessControllerApiUserPermission.from_json(json)
# print the JSON string representation of the object
print(IAMTenantAccessControllerApiUserPermission.to_json())

# convert the object into a dict
iam_tenant_access_controller_api_user_permission_dict = iam_tenant_access_controller_api_user_permission_instance.to_dict()
# create an instance of IAMTenantAccessControllerApiUserPermission from a dict
iam_tenant_access_controller_api_user_permission_from_dict = IAMTenantAccessControllerApiUserPermission.from_dict(iam_tenant_access_controller_api_user_permission_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


