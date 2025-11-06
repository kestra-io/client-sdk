# IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flow** | **List[str]** |  | [optional] 
**blueprint** | **List[str]** |  | [optional] 
**template** | **List[str]** |  | [optional] 
**namespace** | **List[str]** |  | [optional] 
**execution** | **List[str]** |  | [optional] 
**user** | **List[str]** |  | [optional] 
**group** | **List[str]** |  | [optional] 
**role** | **List[str]** |  | [optional] 
**binding** | **List[str]** |  | [optional] 
**auditlog** | **List[str]** |  | [optional] 
**secret** | **List[str]** |  | [optional] 
**kvstore** | **List[str]** |  | [optional] 
**impersonate** | **List[str]** |  | [optional] 
**setting** | **List[str]** |  | [optional] 
**infrastructure** | **List[str]** |  | [optional] 
**app** | **List[str]** |  | [optional] 
**appexecution** | **List[str]** |  | [optional] 
**test** | **List[str]** |  | [optional] 
**dashboard** | **List[str]** |  | [optional] 
**tenant_access** | **List[str]** |  | [optional] 
**service_account** | **List[str]** |  | [optional] 
**invitation** | **List[str]** |  | [optional] 
**group_membership** | **List[str]** |  | [optional] 
**unknown** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.iam_role_controller_api_role_create_or_update_request_permissions import IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions

# TODO update the JSON string below
json = "{}"
# create an instance of IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions from a JSON string
iam_role_controller_api_role_create_or_update_request_permissions_instance = IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.from_json(json)
# print the JSON string representation of the object
print(IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.to_json())

# convert the object into a dict
iam_role_controller_api_role_create_or_update_request_permissions_dict = iam_role_controller_api_role_create_or_update_request_permissions_instance.to_dict()
# create an instance of IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions from a dict
iam_role_controller_api_role_create_or_update_request_permissions_from_dict = IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.from_dict(iam_role_controller_api_role_create_or_update_request_permissions_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


