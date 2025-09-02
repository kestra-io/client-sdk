# PagedResultsDashboard


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Dashboard]**](Dashboard.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_dashboard import PagedResultsDashboard

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsDashboard from a JSON string
paged_results_dashboard_instance = PagedResultsDashboard.from_json(json)
# print the JSON string representation of the object
print(PagedResultsDashboard.to_json())

# convert the object into a dict
paged_results_dashboard_dict = paged_results_dashboard_instance.to_dict()
# create an instance of PagedResultsDashboard from a dict
paged_results_dashboard_from_dict = PagedResultsDashboard.from_dict(paged_results_dashboard_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


