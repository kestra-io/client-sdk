# MetricEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**task_id** | **str** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 
**type** | **str** |  | 
**name** | **str** |  | 
**value** | **float** |  | 
**timestamp** | **datetime** |  | 
**tags** | **Dict[str, str]** |  | [optional] 
**deleted** | **bool** |  | 
**execution_kind** | [**ExecutionKind**](ExecutionKind.md) |  | [optional] 

## Example

```python
from kestrapy.models.metric_entry import MetricEntry

# TODO update the JSON string below
json = "{}"
# create an instance of MetricEntry from a JSON string
metric_entry_instance = MetricEntry.from_json(json)
# print the JSON string representation of the object
print(MetricEntry.to_json())

# convert the object into a dict
metric_entry_dict = metric_entry_instance.to_dict()
# create an instance of MetricEntry from a dict
metric_entry_from_dict = MetricEntry.from_dict(metric_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


