# AbstractMetricEntryObject


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | [optional] 
**value** | **object** |  | [optional] 
**name** | **str** |  | 
**description** | **str** |  | [optional] 
**tags** | **Dict[str, str]** |  | [optional] 
**timestamp** | **datetime** |  | [optional] 

## Example

```python
from kestra_api_client.models.abstract_metric_entry_object import AbstractMetricEntryObject

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractMetricEntryObject from a JSON string
abstract_metric_entry_object_instance = AbstractMetricEntryObject.from_json(json)
# print the JSON string representation of the object
print(AbstractMetricEntryObject.to_json())

# convert the object into a dict
abstract_metric_entry_object_dict = abstract_metric_entry_object_instance.to_dict()
# create an instance of AbstractMetricEntryObject from a dict
abstract_metric_entry_object_from_dict = AbstractMetricEntryObject.from_dict(abstract_metric_entry_object_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


