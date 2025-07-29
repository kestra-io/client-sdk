# ConvertibleMultiValuesString


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conversion_service** | **object** |  | 
**empty** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.convertible_multi_values_string import ConvertibleMultiValuesString

# TODO update the JSON string below
json = "{}"
# create an instance of ConvertibleMultiValuesString from a JSON string
convertible_multi_values_string_instance = ConvertibleMultiValuesString.from_json(json)
# print the JSON string representation of the object
print(ConvertibleMultiValuesString.to_json())

# convert the object into a dict
convertible_multi_values_string_dict = convertible_multi_values_string_instance.to_dict()
# create an instance of ConvertibleMultiValuesString from a dict
convertible_multi_values_string_from_dict = ConvertibleMultiValuesString.from_dict(convertible_multi_values_string_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


