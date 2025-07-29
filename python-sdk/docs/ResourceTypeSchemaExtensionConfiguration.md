# ResourceTypeSchemaExtensionConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schema_urn** | **str** |  | [optional] 
**required** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.resource_type_schema_extension_configuration import ResourceTypeSchemaExtensionConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of ResourceTypeSchemaExtensionConfiguration from a JSON string
resource_type_schema_extension_configuration_instance = ResourceTypeSchemaExtensionConfiguration.from_json(json)
# print the JSON string representation of the object
print(ResourceTypeSchemaExtensionConfiguration.to_json())

# convert the object into a dict
resource_type_schema_extension_configuration_dict = resource_type_schema_extension_configuration_instance.to_dict()
# create an instance of ResourceTypeSchemaExtensionConfiguration from a dict
resource_type_schema_extension_configuration_from_dict = ResourceTypeSchemaExtensionConfiguration.from_dict(resource_type_schema_extension_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


