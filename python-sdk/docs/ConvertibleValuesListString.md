# ConvertibleValuesListString


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conversion_service** | **object** |  | 
**empty** | **bool** |  | [optional] 

## Example

```python
from kestra_api_client.models.convertible_values_list_string import ConvertibleValuesListString

# TODO update the JSON string below
json = "{}"
# create an instance of ConvertibleValuesListString from a JSON string
convertible_values_list_string_instance = ConvertibleValuesListString.from_json(json)
# print the JSON string representation of the object
print(ConvertibleValuesListString.to_json())

# convert the object into a dict
convertible_values_list_string_dict = convertible_values_list_string_instance.to_dict()
# create an instance of ConvertibleValuesListString from a dict
convertible_values_list_string_from_dict = ConvertibleValuesListString.from_dict(convertible_values_list_string_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


