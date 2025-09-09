# PropertyObject


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expression** | **str** |  | 
**value** | **object** |  | [optional] 

## Example

```python
from kestrapy.models.property_object import PropertyObject

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyObject from a JSON string
property_object_instance = PropertyObject.from_json(json)
# print the JSON string representation of the object
print(PropertyObject.to_json())

# convert the object into a dict
property_object_dict = property_object_instance.to_dict()
# create an instance of PropertyObject from a dict
property_object_from_dict = PropertyObject.from_dict(property_object_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


