# PropertyString


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expression** | **str** |  | 
**value** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.property_string import PropertyString

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyString from a JSON string
property_string_instance = PropertyString.from_json(json)
# print the JSON string representation of the object
print(PropertyString.to_json())

# convert the object into a dict
property_string_dict = property_string_instance.to_dict()
# create an instance of PropertyString from a dict
property_string_from_dict = PropertyString.from_dict(property_string_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


