# CreateApiTokenResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**full_token** | **str** |  | 

## Example

```python
from kestrapy.models.create_api_token_response import CreateApiTokenResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateApiTokenResponse from a JSON string
create_api_token_response_instance = CreateApiTokenResponse.from_json(json)
# print the JSON string representation of the object
print(CreateApiTokenResponse.to_json())

# convert the object into a dict
create_api_token_response_dict = create_api_token_response_instance.to_dict()
# create an instance of CreateApiTokenResponse from a dict
create_api_token_response_from_dict = CreateApiTokenResponse.from_dict(create_api_token_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


