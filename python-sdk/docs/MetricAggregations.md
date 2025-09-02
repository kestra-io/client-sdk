# MetricAggregations


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**group_by** | **str** |  | 
**aggregations** | [**List[MetricAggregation]**](MetricAggregation.md) |  | 

## Example

```python
from kestra_api_client.models.metric_aggregations import MetricAggregations

# TODO update the JSON string below
json = "{}"
# create an instance of MetricAggregations from a JSON string
metric_aggregations_instance = MetricAggregations.from_json(json)
# print the JSON string representation of the object
print(MetricAggregations.to_json())

# convert the object into a dict
metric_aggregations_dict = metric_aggregations_instance.to_dict()
# create an instance of MetricAggregations from a dict
metric_aggregations_from_dict = MetricAggregations.from_dict(metric_aggregations_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


