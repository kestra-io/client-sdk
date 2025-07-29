# Binding


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**type** | [**BindingType**](BindingType.md) |  | 
**external_id** | **str** |  | 
**role_id** | **str** |  | 
**namespace_id** | **str** |  | [optional] 
**deleted** | **bool** |  | 

## Example

```python
from kestrapy.models.binding import Binding

# TODO update the JSON string below
json = "{}"
# create an instance of Binding from a JSON string
binding_instance = Binding.from_json(json)
# print the JSON string representation of the object
print(Binding.to_json())

# convert the object into a dict
binding_dict = binding_instance.to_dict()
# create an instance of Binding from a dict
binding_from_dict = Binding.from_dict(binding_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


