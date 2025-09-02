# ServiceProviderConfigurationAuthenticationSchema


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**ServiceProviderConfigurationAuthenticationSchemaType**](ServiceProviderConfigurationAuthenticationSchemaType.md) |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**spec_uri** | **str** |  | [optional] 
**documentation_uri** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.service_provider_configuration_authentication_schema import ServiceProviderConfigurationAuthenticationSchema

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceProviderConfigurationAuthenticationSchema from a JSON string
service_provider_configuration_authentication_schema_instance = ServiceProviderConfigurationAuthenticationSchema.from_json(json)
# print the JSON string representation of the object
print(ServiceProviderConfigurationAuthenticationSchema.to_json())

# convert the object into a dict
service_provider_configuration_authentication_schema_dict = service_provider_configuration_authentication_schema_instance.to_dict()
# create an instance of ServiceProviderConfigurationAuthenticationSchema from a dict
service_provider_configuration_authentication_schema_from_dict = ServiceProviderConfigurationAuthenticationSchema.from_dict(service_provider_configuration_authentication_schema_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


