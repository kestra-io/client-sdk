# ChartChartOption


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**chart_options** | **object** |  | [optional] 

## Example

```python
from kestra_api_client.models.chart_chart_option import ChartChartOption

# TODO update the JSON string below
json = "{}"
# create an instance of ChartChartOption from a JSON string
chart_chart_option_instance = ChartChartOption.from_json(json)
# print the JSON string representation of the object
print(ChartChartOption.to_json())

# convert the object into a dict
chart_chart_option_dict = chart_chart_option_instance.to_dict()
# create an instance of ChartChartOption from a dict
chart_chart_option_from_dict = ChartChartOption.from_dict(chart_chart_option_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


