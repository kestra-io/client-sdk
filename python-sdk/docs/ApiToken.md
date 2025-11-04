# ApiToken


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**prefix** | **str** |  | [optional] 
**iat** | **datetime** |  | [optional] 
**exp** | **datetime** |  | [optional] 
**last_used** | **datetime** |  | [optional] 
**extended** | **bool** |  | [optional] 
**expired** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.api_token import ApiToken

# TODO update the JSON string below
json = "{}"
# create an instance of ApiToken from a JSON string
api_token_instance = ApiToken.from_json(json)
# print the JSON string representation of the object
print(ApiToken.to_json())

# convert the object into a dict
api_token_dict = api_token_instance.to_dict()
# create an instance of ApiToken from a dict
api_token_from_dict = ApiToken.from_dict(api_token_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


