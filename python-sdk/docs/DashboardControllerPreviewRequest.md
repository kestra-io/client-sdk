# DashboardControllerPreviewRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**chart** | **str** |  | 
**global_filter** | [**ChartFiltersOverrides**](ChartFiltersOverrides.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.dashboard_controller_preview_request import DashboardControllerPreviewRequest

# TODO update the JSON string below
json = "{}"
# create an instance of DashboardControllerPreviewRequest from a JSON string
dashboard_controller_preview_request_instance = DashboardControllerPreviewRequest.from_json(json)
# print the JSON string representation of the object
print(DashboardControllerPreviewRequest.to_json())

# convert the object into a dict
dashboard_controller_preview_request_dict = dashboard_controller_preview_request_instance.to_dict()
# create an instance of DashboardControllerPreviewRequest from a dict
dashboard_controller_preview_request_from_dict = DashboardControllerPreviewRequest.from_dict(dashboard_controller_preview_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


