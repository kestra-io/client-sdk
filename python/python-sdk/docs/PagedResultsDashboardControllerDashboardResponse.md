# PagedResultsDashboardControllerDashboardResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[DashboardControllerDashboardResponse]**](DashboardControllerDashboardResponse.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_dashboard_controller_dashboard_response import PagedResultsDashboardControllerDashboardResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsDashboardControllerDashboardResponse from a JSON string
paged_results_dashboard_controller_dashboard_response_instance = PagedResultsDashboardControllerDashboardResponse.from_json(json)
# print the JSON string representation of the object
print(PagedResultsDashboardControllerDashboardResponse.to_json())

# convert the object into a dict
paged_results_dashboard_controller_dashboard_response_dict = paged_results_dashboard_controller_dashboard_response_instance.to_dict()
# create an instance of PagedResultsDashboardControllerDashboardResponse from a dict
paged_results_dashboard_controller_dashboard_response_from_dict = PagedResultsDashboardControllerDashboardResponse.from_dict(paged_results_dashboard_controller_dashboard_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


