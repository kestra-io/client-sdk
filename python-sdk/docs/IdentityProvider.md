# IdentityProvider


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attributes** | **Dict[str, object]** |  | 
**external_id** | **str** |  | 
**security_integration_id** | **str** |  | 
**security_integration_name** | **str** |  | 

## Example

```python
from kestra_api_client.models.identity_provider import IdentityProvider

# TODO update the JSON string below
json = "{}"
# create an instance of IdentityProvider from a JSON string
identity_provider_instance = IdentityProvider.from_json(json)
# print the JSON string representation of the object
print(IdentityProvider.to_json())

# convert the object into a dict
identity_provider_dict = identity_provider_instance.to_dict()
# create an instance of IdentityProvider from a dict
identity_provider_from_dict = IdentityProvider.from_dict(identity_provider_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


