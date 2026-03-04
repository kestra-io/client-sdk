# PasswordConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**password_min_length** | **int** |  | [optional] [default to 8]
**password_require_special** | **bool** |  | [optional] [default to True]
**password_min_digits** | **int** |  | [optional] [default to 1]
**password_min_lower_case** | **int** |  | [optional] [default to 1]
**password_min_upper_case** | **int** |  | [optional] [default to 1]
**password_allowed_special_characters** | **str** |  | [optional] [default to '!@#$%^&*']
**password_reset** | [**PasswordConfigurationPasswordReset**](PasswordConfigurationPasswordReset.md) |  | [optional] 

## Example

```python
from kestrapy.models.password_configuration import PasswordConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of PasswordConfiguration from a JSON string
password_configuration_instance = PasswordConfiguration.from_json(json)
# print the JSON string representation of the object
print(PasswordConfiguration.to_json())

# convert the object into a dict
password_configuration_dict = password_configuration_instance.to_dict()
# create an instance of PasswordConfiguration from a dict
password_configuration_from_dict = PasswordConfiguration.from_dict(password_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


