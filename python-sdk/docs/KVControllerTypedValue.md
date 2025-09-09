# KVControllerTypedValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**KVType**](KVType.md) |  | 
**value** | **object** |  | 

## Example

```python
from kestrapy.models.kv_controller_typed_value import KVControllerTypedValue

# TODO update the JSON string below
json = "{}"
# create an instance of KVControllerTypedValue from a JSON string
kv_controller_typed_value_instance = KVControllerTypedValue.from_json(json)
# print the JSON string representation of the object
print(KVControllerTypedValue.to_json())

# convert the object into a dict
kv_controller_typed_value_dict = kv_controller_typed_value_instance.to_dict()
# create an instance of KVControllerTypedValue from a dict
kv_controller_typed_value_from_dict = KVControllerTypedValue.from_dict(kv_controller_typed_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


