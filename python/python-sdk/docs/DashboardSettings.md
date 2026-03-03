# DashboardSettings


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**default_home_dashboard** | **str** |  | [optional] 
**default_flow_overview_dashboard** | **str** |  | [optional] 
**default_namespace_overview_dashboard** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.dashboard_settings import DashboardSettings

# TODO update the JSON string below
json = "{}"
# create an instance of DashboardSettings from a JSON string
dashboard_settings_instance = DashboardSettings.from_json(json)
# print the JSON string representation of the object
print(DashboardSettings.to_json())

# convert the object into a dict
dashboard_settings_dict = dashboard_settings_instance.to_dict()
# create an instance of DashboardSettings from a dict
dashboard_settings_from_dict = DashboardSettings.from_dict(dashboard_settings_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


