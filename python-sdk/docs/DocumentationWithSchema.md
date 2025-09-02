# DocumentationWithSchema


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**markdown** | **str** |  | [optional] 
**var_schema** | [**PluginSchema**](PluginSchema.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.documentation_with_schema import DocumentationWithSchema

# TODO update the JSON string below
json = "{}"
# create an instance of DocumentationWithSchema from a JSON string
documentation_with_schema_instance = DocumentationWithSchema.from_json(json)
# print the JSON string representation of the object
print(DocumentationWithSchema.to_json())

# convert the object into a dict
documentation_with_schema_dict = documentation_with_schema_instance.to_dict()
# create an instance of DocumentationWithSchema from a dict
documentation_with_schema_from_dict = DocumentationWithSchema.from_dict(documentation_with_schema_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


