# InputObject


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**id** | **str** |  | 
**type** | [**Type**](Type.md) |  | 
**description** | **str** |  | [optional] 
**depends_on** | [**DependsOn**](DependsOn.md) |  | [optional] 
**required** | **bool** |  | [optional] 
**defaults** | **object** |  | [optional] 
**display_name** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.input_object import InputObject

# TODO update the JSON string below
json = "{}"
# create an instance of InputObject from a JSON string
input_object_instance = InputObject.from_json(json)
# print the JSON string representation of the object
print(InputObject.to_json())

# convert the object into a dict
input_object_dict = input_object_instance.to_dict()
# create an instance of InputObject from a dict
input_object_from_dict = InputObject.from_dict(input_object_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


