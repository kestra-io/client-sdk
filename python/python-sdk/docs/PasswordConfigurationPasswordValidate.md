# PasswordConfigurationPasswordValidate


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cooldown** | **str** |  | [optional] [default to 'PT5M']
**rate_limit** | [**PasswordConfigurationRateLimit**](PasswordConfigurationRateLimit.md) |  | [optional] 

## Example

```python
from kestrapy.models.password_configuration_password_validate import PasswordConfigurationPasswordValidate

# TODO update the JSON string below
json = "{}"
# create an instance of PasswordConfigurationPasswordValidate from a JSON string
password_configuration_password_validate_instance = PasswordConfigurationPasswordValidate.from_json(json)
# print the JSON string representation of the object
print(PasswordConfigurationPasswordValidate.to_json())

# convert the object into a dict
password_configuration_password_validate_dict = password_configuration_password_validate_instance.to_dict()
# create an instance of PasswordConfigurationPasswordValidate from a dict
password_configuration_password_validate_from_dict = PasswordConfigurationPasswordValidate.from_dict(password_configuration_password_validate_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


