# AttributeReference


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**full_attribute_name** | **str** |  | [optional] 
**fully_qualified_attribute_name** | **str** |  | [optional] 
**attribute_base** | **str** |  | [optional] 
**urn** | **str** |  | [optional] 
**attribute_name** | **str** |  | [optional] 
**sub_attribute_name** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.attribute_reference import AttributeReference

# TODO update the JSON string below
json = "{}"
# create an instance of AttributeReference from a JSON string
attribute_reference_instance = AttributeReference.from_json(json)
# print the JSON string representation of the object
print(AttributeReference.to_json())

# convert the object into a dict
attribute_reference_dict = attribute_reference_instance.to_dict()
# create an instance of AttributeReference from a dict
attribute_reference_from_dict = AttributeReference.from_dict(attribute_reference_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


