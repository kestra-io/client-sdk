# PagedResultsIAMTenantAccessControllerApiUserTenantAccess


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[IAMTenantAccessControllerApiUserTenantAccess]**](IAMTenantAccessControllerApiUserTenantAccess.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_iam_tenant_access_controller_api_user_tenant_access import PagedResultsIAMTenantAccessControllerApiUserTenantAccess

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsIAMTenantAccessControllerApiUserTenantAccess from a JSON string
paged_results_iam_tenant_access_controller_api_user_tenant_access_instance = PagedResultsIAMTenantAccessControllerApiUserTenantAccess.from_json(json)
# print the JSON string representation of the object
print(PagedResultsIAMTenantAccessControllerApiUserTenantAccess.to_json())

# convert the object into a dict
paged_results_iam_tenant_access_controller_api_user_tenant_access_dict = paged_results_iam_tenant_access_controller_api_user_tenant_access_instance.to_dict()
# create an instance of PagedResultsIAMTenantAccessControllerApiUserTenantAccess from a dict
paged_results_iam_tenant_access_controller_api_user_tenant_access_from_dict = PagedResultsIAMTenantAccessControllerApiUserTenantAccess.from_dict(paged_results_iam_tenant_access_controller_api_user_tenant_access_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


