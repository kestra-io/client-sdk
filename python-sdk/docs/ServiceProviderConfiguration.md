# ServiceProviderConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schemas** | **List[str]** |  | [optional] 
**base_urn** | **str** |  | [optional] 
**extensions** | [**Dict[str, ScimExtension]**](ScimExtension.md) |  | [optional] 
**meta** | [**Meta**](Meta.md) |  | 
**id** | **str** |  | [optional] 
**external_id** | **str** |  | [optional] 
**resource_type** | **str** |  | 
**documentation_url** | **str** |  | [optional] 
**patch** | [**ServiceProviderConfigurationSupportedConfiguration**](ServiceProviderConfigurationSupportedConfiguration.md) |  | [optional] 
**bulk** | [**ServiceProviderConfigurationBulkConfiguration**](ServiceProviderConfigurationBulkConfiguration.md) |  | [optional] 
**filter** | [**ServiceProviderConfigurationFilterConfiguration**](ServiceProviderConfigurationFilterConfiguration.md) |  | [optional] 
**change_password** | [**ServiceProviderConfigurationSupportedConfiguration**](ServiceProviderConfigurationSupportedConfiguration.md) |  | [optional] 
**sort** | [**ServiceProviderConfigurationSupportedConfiguration**](ServiceProviderConfigurationSupportedConfiguration.md) |  | [optional] 
**etag** | [**ServiceProviderConfigurationSupportedConfiguration**](ServiceProviderConfigurationSupportedConfiguration.md) |  | [optional] 
**authentication_schemes** | [**List[ServiceProviderConfigurationAuthenticationSchema]**](ServiceProviderConfigurationAuthenticationSchema.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.service_provider_configuration import ServiceProviderConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceProviderConfiguration from a JSON string
service_provider_configuration_instance = ServiceProviderConfiguration.from_json(json)
# print the JSON string representation of the object
print(ServiceProviderConfiguration.to_json())

# convert the object into a dict
service_provider_configuration_dict = service_provider_configuration_instance.to_dict()
# create an instance of ServiceProviderConfiguration from a dict
service_provider_configuration_from_dict = ServiceProviderConfiguration.from_dict(service_provider_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


