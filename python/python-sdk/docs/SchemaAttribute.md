# SchemaAttribute


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attributes** | [**List[SchemaAttribute]**](SchemaAttribute.md) |  | [optional] 
**urn** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**type** | [**SchemaAttributeType**](SchemaAttributeType.md) |  | [optional] 
**sub_attributes** | [**List[SchemaAttribute]**](SchemaAttribute.md) |  | [optional] 
**multi_valued** | **bool** |  | [optional] 
**description** | **str** |  | [optional] 
**required** | **bool** |  | [optional] 
**canonical_values** | **List[str]** |  | [optional] 
**case_exact** | **bool** |  | [optional] 
**mutability** | [**SchemaAttributeMutability**](SchemaAttributeMutability.md) |  | [optional] 
**returned** | [**SchemaAttributeReturned**](SchemaAttributeReturned.md) |  | [optional] 
**uniqueness** | [**SchemaAttributeUniqueness**](SchemaAttributeUniqueness.md) |  | [optional] 
**reference_types** | **List[str]** |  | [optional] 
**accessor** | **object** |  | [optional] 
**scim_resource_id_reference** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.schema_attribute import SchemaAttribute

# TODO update the JSON string below
json = "{}"
# create an instance of SchemaAttribute from a JSON string
schema_attribute_instance = SchemaAttribute.from_json(json)
# print the JSON string representation of the object
print(SchemaAttribute.to_json())

# convert the object into a dict
schema_attribute_dict = schema_attribute_instance.to_dict()
# create an instance of SchemaAttribute from a dict
schema_attribute_from_dict = SchemaAttribute.from_dict(schema_attribute_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


