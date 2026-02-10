# KVControllerKvDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**KVType**](KVType.md) |  | [optional] 
**value** | **object** |  | [optional] 
**revision** | **int** |  | [optional] 
**updated** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.kv_controller_kv_detail import KVControllerKvDetail

# TODO update the JSON string below
json = "{}"
# create an instance of KVControllerKvDetail from a JSON string
kv_controller_kv_detail_instance = KVControllerKvDetail.from_json(json)
# print the JSON string representation of the object
print(KVControllerKvDetail.to_json())

# convert the object into a dict
kv_controller_kv_detail_dict = kv_controller_kv_detail_instance.to_dict()
# create an instance of KVControllerKvDetail from a dict
kv_controller_kv_detail_from_dict = KVControllerKvDetail.from_dict(kv_controller_kv_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


