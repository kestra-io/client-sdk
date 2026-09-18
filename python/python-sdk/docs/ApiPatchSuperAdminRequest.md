# ApiPatchSuperAdminRequest

Request body for the deprecated `/superadmin` endpoints, kept for backward-compatibility. It accepts both the current `instanceOwner` field and the legacy `superAdmin` field.   The legacy field cannot be expressed as a `@JsonAlias` on ApiPatchInstanceOwnerRequest because Micronaut's `BeanIntrospectionModule` does not honor Jackson aliases when binding an HTTP request body, so it must be bound as its own property and merged in #resolveInstanceOwner().

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instance_owner** | **bool** |  | [optional] 
**super_admin** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.api_patch_super_admin_request import ApiPatchSuperAdminRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPatchSuperAdminRequest from a JSON string
api_patch_super_admin_request_instance = ApiPatchSuperAdminRequest.from_json(json)
# print the JSON string representation of the object
print(ApiPatchSuperAdminRequest.to_json())

# convert the object into a dict
api_patch_super_admin_request_dict = api_patch_super_admin_request_instance.to_dict()
# create an instance of ApiPatchSuperAdminRequest from a dict
api_patch_super_admin_request_from_dict = ApiPatchSuperAdminRequest.from_dict(api_patch_super_admin_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


