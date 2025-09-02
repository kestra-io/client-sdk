# MiscControllerTenantConfigurationInfo


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**storage_by_tenant** | **bool** |  | 
**secret_by_tenant** | **bool** |  | 

## Example

```python
from kestrapy.models.misc_controller_tenant_configuration_info import MiscControllerTenantConfigurationInfo

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerTenantConfigurationInfo from a JSON string
misc_controller_tenant_configuration_info_instance = MiscControllerTenantConfigurationInfo.from_json(json)
# print the JSON string representation of the object
print(MiscControllerTenantConfigurationInfo.to_json())

# convert the object into a dict
misc_controller_tenant_configuration_info_dict = misc_controller_tenant_configuration_info_instance.to_dict()
# create an instance of MiscControllerTenantConfigurationInfo from a dict
misc_controller_tenant_configuration_info_from_dict = MiscControllerTenantConfigurationInfo.from_dict(misc_controller_tenant_configuration_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


