# DashboardControllerDashboardResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | [optional] 
**id** | **str** |  | 
**title** | **str** |  | 
**description** | **str** |  | [optional] 
**time_window** | [**TimeWindow**](TimeWindow.md) |  | [optional] 
**charts** | [**List[ChartChartOption]**](ChartChartOption.md) |  | [optional] 
**deleted** | **bool** |  | 
**created** | **datetime** |  | [optional] 
**updated** | **datetime** |  | [optional] 
**source_code** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.dashboard_controller_dashboard_response import DashboardControllerDashboardResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DashboardControllerDashboardResponse from a JSON string
dashboard_controller_dashboard_response_instance = DashboardControllerDashboardResponse.from_json(json)
# print the JSON string representation of the object
print(DashboardControllerDashboardResponse.to_json())

# convert the object into a dict
dashboard_controller_dashboard_response_dict = dashboard_controller_dashboard_response_instance.to_dict()
# create an instance of DashboardControllerDashboardResponse from a dict
dashboard_controller_dashboard_response_from_dict = DashboardControllerDashboardResponse.from_dict(dashboard_controller_dashboard_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


