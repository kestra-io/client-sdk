# ApiSecretTag


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **str** |  | 
**value** | **str** |  | 

## Example

```python
from kestra_api_client.models.api_secret_tag import ApiSecretTag

# TODO update the JSON string below
json = "{}"
# create an instance of ApiSecretTag from a JSON string
api_secret_tag_instance = ApiSecretTag.from_json(json)
# print the JSON string representation of the object
print(ApiSecretTag.to_json())

# convert the object into a dict
api_secret_tag_dict = api_secret_tag_instance.to_dict()
# create an instance of ApiSecretTag from a dict
api_secret_tag_from_dict = ApiSecretTag.from_dict(api_secret_tag_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


