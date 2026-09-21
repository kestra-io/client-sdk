# MiscControllerLoginConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**is_basic_auth_initialized** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.misc_controller_login_configuration import MiscControllerLoginConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerLoginConfiguration from a JSON string
misc_controller_login_configuration_instance = MiscControllerLoginConfiguration.from_json(json)
# print the JSON string representation of the object
print(MiscControllerLoginConfiguration.to_json())

# convert the object into a dict
misc_controller_login_configuration_dict = misc_controller_login_configuration_instance.to_dict()
# create an instance of MiscControllerLoginConfiguration from a dict
misc_controller_login_configuration_from_dict = MiscControllerLoginConfiguration.from_dict(misc_controller_login_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


