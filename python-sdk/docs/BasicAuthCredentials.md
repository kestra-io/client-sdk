# BasicAuthCredentials


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**username** | **str** |  | [optional] 
**password** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.basic_auth_credentials import BasicAuthCredentials

# TODO update the JSON string below
json = "{}"
# create an instance of BasicAuthCredentials from a JSON string
basic_auth_credentials_instance = BasicAuthCredentials.from_json(json)
# print the JSON string representation of the object
print(BasicAuthCredentials.to_json())

# convert the object into a dict
basic_auth_credentials_dict = basic_auth_credentials_instance.to_dict()
# create an instance of BasicAuthCredentials from a dict
basic_auth_credentials_from_dict = BasicAuthCredentials.from_dict(basic_auth_credentials_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


