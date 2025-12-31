# ResourceType1


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
from kestrapy.models.resource_type1 import ResourceType1

# TODO update the JSON string below
json = "{}"
# create an instance of ResourceType1 from a JSON string
resource_type1_instance = ResourceType1.from_json(json)
# print the JSON string representation of the object
print(ResourceType1.to_json())

# convert the object into a dict
resource_type1_dict = resource_type1_instance.to_dict()
# create an instance of ResourceType1 from a dict
resource_type1_from_dict = ResourceType1.from_dict(resource_type1_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


