# ResourceType


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schemas** | **List[str]** |  | [optional] 
**base_urn** | **str** |  | [optional] 
**extensions** | [**Dict[str, ScimExtension]**](ScimExtension.md) |  | [optional] 
**meta** | [**Meta**](Meta.md) |  | 
**id** | **str** |  | [optional] 
**external_id** | **str** |  | [optional] 
**resource_type** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**endpoint** | **str** |  | [optional] 
**schema_urn** | **str** |  | [optional] 
**schema_extensions** | [**List[ResourceTypeSchemaExtensionConfiguration]**](ResourceTypeSchemaExtensionConfiguration.md) |  | [optional] 

## Example

```python
from kestrapy.models.resource_type import ResourceType

# TODO update the JSON string below
json = "{}"
# create an instance of ResourceType from a JSON string
resource_type_instance = ResourceType.from_json(json)
# print the JSON string representation of the object
print(ResourceType.to_json())

# convert the object into a dict
resource_type_dict = resource_type_instance.to_dict()
# create an instance of ResourceType from a dict
resource_type_from_dict = ResourceType.from_dict(resource_type_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


