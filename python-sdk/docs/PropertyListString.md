# PropertyListString


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expression** | **str** |  | [optional] 
**value** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.property_list_string import PropertyListString

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyListString from a JSON string
property_list_string_instance = PropertyListString.from_json(json)
# print the JSON string representation of the object
print(PropertyListString.to_json())

# convert the object into a dict
property_list_string_dict = property_list_string_instance.to_dict()
# create an instance of PropertyListString from a dict
property_list_string_from_dict = PropertyListString.from_dict(property_list_string_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


