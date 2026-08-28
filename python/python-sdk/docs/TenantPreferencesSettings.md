# TenantPreferencesSettings


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dashboard** | [**DashboardSettings**](DashboardSettings.md) |  | [optional] 

## Example

```python
from kestrapy.models.tenant_preferences_settings import TenantPreferencesSettings

# TODO update the JSON string below
json = "{}"
# create an instance of TenantPreferencesSettings from a JSON string
tenant_preferences_settings_instance = TenantPreferencesSettings.from_json(json)
# print the JSON string representation of the object
print(TenantPreferencesSettings.to_json())

# convert the object into a dict
tenant_preferences_settings_dict = tenant_preferences_settings_instance.to_dict()
# create an instance of TenantPreferencesSettings from a dict
tenant_preferences_settings_from_dict = TenantPreferencesSettings.from_dict(tenant_preferences_settings_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


