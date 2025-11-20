# TenantAppCatalogConfig


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **str** |  | [optional] 
**title_color** | **str** |  | [optional] 
**primary_color** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.tenant_app_catalog_config import TenantAppCatalogConfig

# TODO update the JSON string below
json = "{}"
# create an instance of TenantAppCatalogConfig from a JSON string
tenant_app_catalog_config_instance = TenantAppCatalogConfig.from_json(json)
# print the JSON string representation of the object
print(TenantAppCatalogConfig.to_json())

# convert the object into a dict
tenant_app_catalog_config_dict = tenant_app_catalog_config_instance.to_dict()
# create an instance of TenantAppCatalogConfig from a dict
tenant_app_catalog_config_from_dict = TenantAppCatalogConfig.from_dict(tenant_app_catalog_config_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


