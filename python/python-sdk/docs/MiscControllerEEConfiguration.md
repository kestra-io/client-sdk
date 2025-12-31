# MiscControllerEEConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **str** |  | [optional] 
**version** | **str** |  | [optional] 
**edition** | [**EditionProviderEdition**](EditionProviderEdition.md) |  | [optional] 
**commit_id** | **str** |  | [optional] 
**chart_default_duration** | **str** |  | [optional] 
**commit_date** | **datetime** |  | [optional] 
**is_custom_dashboards_enabled** | **bool** |  | [optional] 
**is_anonymous_usage_enabled** | **bool** |  | [optional] 
**is_ui_anonymous_usage_enabled** | **bool** |  | [optional] 
**is_template_enabled** | **bool** |  | [optional] 
**environment** | [**MiscControllerEnvironment**](MiscControllerEnvironment.md) |  | [optional] 
**url** | **str** |  | [optional] 
**preview** | [**MiscControllerPreview**](MiscControllerPreview.md) |  | [optional] 
**system_namespace** | **str** |  | [optional] 
**hidden_labels_prefixes** | **List[str]** |  | [optional] 
**is_ai_enabled** | **bool** |  | [optional] 
**is_basic_auth_initialized** | **bool** |  | [optional] 
**plugins_hash** | **int** |  | [optional] 
**is_concurrency_view_enabled** | **bool** |  | [optional] 
**tenants** | [**MiscControllerTenantConfigurationInfo**](MiscControllerTenantConfigurationInfo.md) |  | [optional] 
**secrets_enabled** | **bool** |  | [optional] 
**supported_storages** | [**List[MiscControllerPluginIdAndVersion]**](MiscControllerPluginIdAndVersion.md) |  | [optional] 
**supported_secrets** | [**List[MiscControllerPluginIdAndVersion]**](MiscControllerPluginIdAndVersion.md) |  | [optional] 
**plugin_management_enabled** | **bool** |  | [optional] 
**plugin_custom_enabled** | **bool** |  | [optional] 
**banner** | [**Banner**](Banner.md) |  | [optional] 
**mail_service_enabled** | **bool** |  | [optional] 
**outputs_in_internal_storage_enabled** | **bool** |  | [optional] 
**left_sidebar** | [**LeftSidebarConfiguration**](LeftSidebarConfiguration.md) |  | [optional] 
**right_sidebar** | [**RightSidebarConfiguration**](RightSidebarConfiguration.md) |  | [optional] 
**in_maintenance** | **bool** |  | [optional] 
**password_regexp** | **str** |  | [optional] 
**passwordless_enabled** | **bool** |  | [optional] 
**airgapped** | **bool** |  | [optional] 
**feature_gating** | **bool** |  | [optional] 
**features** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.misc_controller_ee_configuration import MiscControllerEEConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerEEConfiguration from a JSON string
misc_controller_ee_configuration_instance = MiscControllerEEConfiguration.from_json(json)
# print the JSON string representation of the object
print(MiscControllerEEConfiguration.to_json())

# convert the object into a dict
misc_controller_ee_configuration_dict = misc_controller_ee_configuration_instance.to_dict()
# create an instance of MiscControllerEEConfiguration from a dict
misc_controller_ee_configuration_from_dict = MiscControllerEEConfiguration.from_dict(misc_controller_ee_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


