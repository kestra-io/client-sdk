# PasswordConfigurationRateLimit


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**max_requests** | **int** |  | [optional] [default to 10]
**window** | **str** |  | [optional] [default to 'PT1H']

## Example

```python
from kestrapy.models.password_configuration_rate_limit import PasswordConfigurationRateLimit

# TODO update the JSON string below
json = "{}"
# create an instance of PasswordConfigurationRateLimit from a JSON string
password_configuration_rate_limit_instance = PasswordConfigurationRateLimit.from_json(json)
# print the JSON string representation of the object
print(PasswordConfigurationRateLimit.to_json())

# convert the object into a dict
password_configuration_rate_limit_dict = password_configuration_rate_limit_instance.to_dict()
# create an instance of PasswordConfigurationRateLimit from a dict
password_configuration_rate_limit_from_dict = PasswordConfigurationRateLimit.from_dict(password_configuration_rate_limit_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


