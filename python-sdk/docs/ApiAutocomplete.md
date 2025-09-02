# ApiAutocomplete


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**q** | **str** |  | [optional] 
**ids** | **List[str]** |  | [optional] 
**existing_only** | **bool** |  | [optional] 

## Example

```python
from kestra_api_client.models.api_autocomplete import ApiAutocomplete

# TODO update the JSON string below
json = "{}"
# create an instance of ApiAutocomplete from a JSON string
api_autocomplete_instance = ApiAutocomplete.from_json(json)
# print the JSON string representation of the object
print(ApiAutocomplete.to_json())

# convert the object into a dict
api_autocomplete_dict = api_autocomplete_instance.to_dict()
# create an instance of ApiAutocomplete from a dict
api_autocomplete_from_dict = ApiAutocomplete.from_dict(api_autocomplete_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


