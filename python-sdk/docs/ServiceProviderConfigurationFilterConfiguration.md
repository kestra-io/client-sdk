# ServiceProviderConfigurationFilterConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**supported** | **bool** |  | [optional] 
**max_results** | **int** |  | [optional] 

## Example

```python
from kestra_api_client.models.service_provider_configuration_filter_configuration import ServiceProviderConfigurationFilterConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceProviderConfigurationFilterConfiguration from a JSON string
service_provider_configuration_filter_configuration_instance = ServiceProviderConfigurationFilterConfiguration.from_json(json)
# print the JSON string representation of the object
print(ServiceProviderConfigurationFilterConfiguration.to_json())

# convert the object into a dict
service_provider_configuration_filter_configuration_dict = service_provider_configuration_filter_configuration_instance.to_dict()
# create an instance of ServiceProviderConfigurationFilterConfiguration from a dict
service_provider_configuration_filter_configuration_from_dict = ServiceProviderConfigurationFilterConfiguration.from_dict(service_provider_configuration_filter_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


