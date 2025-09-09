# SetupConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**done** | **bool** |  | 
**repository_type** | **str** |  | [optional] 
**queue_type** | **str** |  | [optional] 
**storage_type** | **str** |  | [optional] 
**secret_type** | **str** |  | [optional] 
**password_regexp** | **str** |  | 

## Example

```python
from kestrapy.models.setup_configuration import SetupConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of SetupConfiguration from a JSON string
setup_configuration_instance = SetupConfiguration.from_json(json)
# print the JSON string representation of the object
print(SetupConfiguration.to_json())

# convert the object into a dict
setup_configuration_dict = setup_configuration_instance.to_dict()
# create an instance of SetupConfiguration from a dict
setup_configuration_from_dict = SetupConfiguration.from_dict(setup_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


