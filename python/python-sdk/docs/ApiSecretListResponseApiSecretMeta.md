# ApiSecretListResponseApiSecretMeta


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**read_only** | **bool** |  | 
**results** | [**List[ApiSecretMetaEE]**](ApiSecretMetaEE.md) |  | 
**total** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.api_secret_list_response_api_secret_meta import ApiSecretListResponseApiSecretMeta

# TODO update the JSON string below
json = "{}"
# create an instance of ApiSecretListResponseApiSecretMeta from a JSON string
api_secret_list_response_api_secret_meta_instance = ApiSecretListResponseApiSecretMeta.from_json(json)
# print the JSON string representation of the object
print(ApiSecretListResponseApiSecretMeta.to_json())

# convert the object into a dict
api_secret_list_response_api_secret_meta_dict = api_secret_list_response_api_secret_meta_instance.to_dict()
# create an instance of ApiSecretListResponseApiSecretMeta from a dict
api_secret_list_response_api_secret_meta_from_dict = ApiSecretListResponseApiSecretMeta.from_dict(api_secret_list_response_api_secret_meta_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


