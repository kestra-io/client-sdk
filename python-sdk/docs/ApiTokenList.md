# ApiTokenList


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total** | **int** |  | [optional] 
**results** | [**List[ApiToken]**](ApiToken.md) |  | [optional] 

## Example

```python
from kestrapy.models.api_token_list import ApiTokenList

# TODO update the JSON string below
json = "{}"
# create an instance of ApiTokenList from a JSON string
api_token_list_instance = ApiTokenList.from_json(json)
# print the JSON string representation of the object
print(ApiTokenList.to_json())

# convert the object into a dict
api_token_list_dict = api_token_list_instance.to_dict()
# create an instance of ApiTokenList from a dict
api_token_list_from_dict = ApiTokenList.from_dict(api_token_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


