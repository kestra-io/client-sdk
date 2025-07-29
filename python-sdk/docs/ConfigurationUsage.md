# ConfigurationUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**repository_type** | **str** |  | [optional] 
**queue_type** | **str** |  | [optional] 
**storage_type** | **str** |  | [optional] 
**secret_type** | **str** |  | [optional] 
**java_security_enabled** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.configuration_usage import ConfigurationUsage

# TODO update the JSON string below
json = "{}"
# create an instance of ConfigurationUsage from a JSON string
configuration_usage_instance = ConfigurationUsage.from_json(json)
# print the JSON string representation of the object
print(ConfigurationUsage.to_json())

# convert the object into a dict
configuration_usage_dict = configuration_usage_instance.to_dict()
# create an instance of ConfigurationUsage from a dict
configuration_usage_from_dict = ConfigurationUsage.from_dict(configuration_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


