# SetupConfigurationSetupData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**username** | **str** |  | 
**password** | **str** |  | 
**tenant** | [**Tenant**](Tenant.md) |  | 

## Example

```python
from kestrapy.models.setup_configuration_setup_data import SetupConfigurationSetupData

# TODO update the JSON string below
json = "{}"
# create an instance of SetupConfigurationSetupData from a JSON string
setup_configuration_setup_data_instance = SetupConfigurationSetupData.from_json(json)
# print the JSON string representation of the object
print(SetupConfigurationSetupData.to_json())

# convert the object into a dict
setup_configuration_setup_data_dict = setup_configuration_setup_data_instance.to_dict()
# create an instance of SetupConfigurationSetupData from a dict
setup_configuration_setup_data_from_dict = SetupConfigurationSetupData.from_dict(setup_configuration_setup_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


