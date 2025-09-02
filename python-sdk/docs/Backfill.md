# Backfill


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start** | **datetime** |  | 
**end** | **datetime** |  | [optional] 
**current_date** | **datetime** |  | [optional] 
**paused** | **bool** |  | [optional] 
**inputs** | **Dict[str, object]** |  | [optional] 
**labels** | [**List[Label]**](Label.md) |  | [optional] 
**previous_next_execution_date** | **datetime** |  | [optional] 

## Example

```python
from kestra_api_client.models.backfill import Backfill

# TODO update the JSON string below
json = "{}"
# create an instance of Backfill from a JSON string
backfill_instance = Backfill.from_json(json)
# print the JSON string representation of the object
print(Backfill.to_json())

# convert the object into a dict
backfill_dict = backfill_instance.to_dict()
# create an instance of Backfill from a dict
backfill_from_dict = Backfill.from_dict(backfill_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


