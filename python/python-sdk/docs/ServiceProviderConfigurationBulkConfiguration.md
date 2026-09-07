# ServiceProviderConfigurationBulkConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**supported** | **bool** |  | [optional] 
**max_operations** | **int** |  | [optional] 
**max_payload_size** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.service_provider_configuration_bulk_configuration import ServiceProviderConfigurationBulkConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceProviderConfigurationBulkConfiguration from a JSON string
service_provider_configuration_bulk_configuration_instance = ServiceProviderConfigurationBulkConfiguration.from_json(json)
# print the JSON string representation of the object
print(ServiceProviderConfigurationBulkConfiguration.to_json())

# convert the object into a dict
service_provider_configuration_bulk_configuration_dict = service_provider_configuration_bulk_configuration_instance.to_dict()
# create an instance of ServiceProviderConfigurationBulkConfiguration from a dict
service_provider_configuration_bulk_configuration_from_dict = ServiceProviderConfigurationBulkConfiguration.from_dict(service_provider_configuration_bulk_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


