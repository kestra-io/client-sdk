# ApiSecretListResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**read_only** | **bool** |  | 
**results** | [**List[ApiSecretMeta]**](ApiSecretMeta.md) |  | 
**total** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.api_secret_list_response import ApiSecretListResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiSecretListResponse from a JSON string
api_secret_list_response_instance = ApiSecretListResponse.from_json(json)
# print the JSON string representation of the object
print(ApiSecretListResponse.to_json())

# convert the object into a dict
api_secret_list_response_dict = api_secret_list_response_instance.to_dict()
# create an instance of ApiSecretListResponse from a dict
api_secret_list_response_from_dict = ApiSecretListResponse.from_dict(api_secret_list_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


