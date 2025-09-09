# MiscControllerBasicAuthCredentials


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | 
**username** | **str** |  | 
**password** | **str** |  | 

## Example

```python
from kestrapy.models.misc_controller_basic_auth_credentials import MiscControllerBasicAuthCredentials

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerBasicAuthCredentials from a JSON string
misc_controller_basic_auth_credentials_instance = MiscControllerBasicAuthCredentials.from_json(json)
# print the JSON string representation of the object
print(MiscControllerBasicAuthCredentials.to_json())

# convert the object into a dict
misc_controller_basic_auth_credentials_dict = misc_controller_basic_auth_credentials_instance.to_dict()
# create an instance of MiscControllerBasicAuthCredentials from a dict
misc_controller_basic_auth_credentials_from_dict = MiscControllerBasicAuthCredentials.from_dict(misc_controller_basic_auth_credentials_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


