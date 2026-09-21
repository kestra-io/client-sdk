# PropertyBoolean


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expression** | **str** |  | [optional] 
**value** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.property_boolean import PropertyBoolean

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyBoolean from a JSON string
property_boolean_instance = PropertyBoolean.from_json(json)
# print the JSON string representation of the object
print(PropertyBoolean.to_json())

# convert the object into a dict
property_boolean_dict = property_boolean_instance.to_dict()
# create an instance of PropertyBoolean from a dict
property_boolean_from_dict = PropertyBoolean.from_dict(property_boolean_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


