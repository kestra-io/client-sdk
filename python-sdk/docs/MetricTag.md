# MetricTag


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **str** |  | 
**value** | **str** |  | 

## Example

```python
from kestra_api_client.models.metric_tag import MetricTag

# TODO update the JSON string below
json = "{}"
# create an instance of MetricTag from a JSON string
metric_tag_instance = MetricTag.from_json(json)
# print the JSON string representation of the object
print(MetricTag.to_json())

# convert the object into a dict
metric_tag_dict = metric_tag_instance.to_dict()
# create an instance of MetricTag from a dict
metric_tag_from_dict = MetricTag.from_dict(metric_tag_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


