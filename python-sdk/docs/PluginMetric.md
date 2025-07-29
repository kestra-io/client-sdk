# PluginMetric


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | [optional] 
**count** | **float** |  | [optional] 
**total_time** | **float** |  | [optional] 
**mean_time** | **float** |  | [optional] 

## Example

```python
from kestrapy.models.plugin_metric import PluginMetric

# TODO update the JSON string below
json = "{}"
# create an instance of PluginMetric from a JSON string
plugin_metric_instance = PluginMetric.from_json(json)
# print the JSON string representation of the object
print(PluginMetric.to_json())

# convert the object into a dict
plugin_metric_dict = plugin_metric_instance.to_dict()
# create an instance of PluginMetric from a dict
plugin_metric_from_dict = PluginMetric.from_dict(plugin_metric_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


