# Metric


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**type** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**base_unit** | **str** |  | [optional] 
**tags** | [**List[MetricTag]**](MetricTag.md) |  | [optional] 
**value** | **object** |  | [optional] 

## Example

```python
from kestrapy.models.metric import Metric

# TODO update the JSON string below
json = "{}"
# create an instance of Metric from a JSON string
metric_instance = Metric.from_json(json)
# print the JSON string representation of the object
print(Metric.to_json())

# convert the object into a dict
metric_dict = metric_instance.to_dict()
# create an instance of Metric from a dict
metric_from_dict = Metric.from_dict(metric_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


