# KVEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **str** |  | 
**description** | **str** |  | [optional] 
**creation_date** | **datetime** |  | 
**update_date** | **datetime** |  | 
**expiration_date** | **datetime** |  | [optional] 

## Example

```python
from kestra_api_client.models.kv_entry import KVEntry

# TODO update the JSON string below
json = "{}"
# create an instance of KVEntry from a JSON string
kv_entry_instance = KVEntry.from_json(json)
# print the JSON string representation of the object
print(KVEntry.to_json())

# convert the object into a dict
kv_entry_dict = kv_entry_instance.to_dict()
# create an instance of KVEntry from a dict
kv_entry_from_dict = KVEntry.from_dict(kv_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


