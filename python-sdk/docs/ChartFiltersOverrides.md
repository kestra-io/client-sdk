# ChartFiltersOverrides


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start_date** | **datetime** |  | [optional] 
**end_date** | **datetime** |  | [optional] 
**page_size** | **int** |  | [optional] 
**page_number** | **int** |  | [optional] 
**namespace** | **str** |  | [optional] 
**labels** | **Dict[str, str]** |  | [optional] 
**filters** | [**List[QueryFilter]**](QueryFilter.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.chart_filters_overrides import ChartFiltersOverrides

# TODO update the JSON string below
json = "{}"
# create an instance of ChartFiltersOverrides from a JSON string
chart_filters_overrides_instance = ChartFiltersOverrides.from_json(json)
# print the JSON string representation of the object
print(ChartFiltersOverrides.to_json())

# convert the object into a dict
chart_filters_overrides_dict = chart_filters_overrides_instance.to_dict()
# create an instance of ChartFiltersOverrides from a dict
chart_filters_overrides_from_dict = ChartFiltersOverrides.from_dict(chart_filters_overrides_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


