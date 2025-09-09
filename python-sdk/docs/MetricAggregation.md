# MetricAggregation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**value** | **float** |  | 
**var_date** | **datetime** |  | 

## Example

```python
from kestrapy.models.metric_aggregation import MetricAggregation

# TODO update the JSON string below
json = "{}"
# create an instance of MetricAggregation from a JSON string
metric_aggregation_instance = MetricAggregation.from_json(json)
# print the JSON string representation of the object
print(MetricAggregation.to_json())

# convert the object into a dict
metric_aggregation_dict = metric_aggregation_instance.to_dict()
# create an instance of MetricAggregation from a dict
metric_aggregation_from_dict = MetricAggregation.from_dict(metric_aggregation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


