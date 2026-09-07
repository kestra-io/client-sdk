# ApiSecretValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tags** | [**List[ApiSecretTag]**](ApiSecretTag.md) |  | [optional] 
**key** | **str** |  | 
**value** | **str** |  | 
**description** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.api_secret_value import ApiSecretValue

# TODO update the JSON string below
json = "{}"
# create an instance of ApiSecretValue from a JSON string
api_secret_value_instance = ApiSecretValue.from_json(json)
# print the JSON string representation of the object
print(ApiSecretValue.to_json())

# convert the object into a dict
api_secret_value_dict = api_secret_value_instance.to_dict()
# create an instance of ApiSecretValue from a dict
api_secret_value_from_dict = ApiSecretValue.from_dict(api_secret_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


