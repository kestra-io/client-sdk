# ApiSecretMetaEE


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **str** |  | 
**tags** | [**List[ApiSecretTag]**](ApiSecretTag.md) |  | 
**key** | **str** |  | 

## Example

```python
from kestra_api_client.models.api_secret_meta_ee import ApiSecretMetaEE

# TODO update the JSON string below
json = "{}"
# create an instance of ApiSecretMetaEE from a JSON string
api_secret_meta_ee_instance = ApiSecretMetaEE.from_json(json)
# print the JSON string representation of the object
print(ApiSecretMetaEE.to_json())

# convert the object into a dict
api_secret_meta_ee_dict = api_secret_meta_ee_instance.to_dict()
# create an instance of ApiSecretMetaEE from a dict
api_secret_meta_ee_from_dict = ApiSecretMetaEE.from_dict(api_secret_meta_ee_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


