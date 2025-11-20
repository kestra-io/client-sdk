# MiscControllerConfiguration


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

## Example

```python
from kestrapy.models.misc_controller_configuration import MiscControllerConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerConfiguration from a JSON string
misc_controller_configuration_instance = MiscControllerConfiguration.from_json(json)
# print the JSON string representation of the object
print(MiscControllerConfiguration.to_json())

# convert the object into a dict
misc_controller_configuration_dict = misc_controller_configuration_instance.to_dict()
# create an instance of MiscControllerConfiguration from a dict
misc_controller_configuration_from_dict = MiscControllerConfiguration.from_dict(misc_controller_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


