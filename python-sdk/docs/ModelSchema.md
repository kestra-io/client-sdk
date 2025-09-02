# ModelSchema


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attributes** | [**List[SchemaAttribute]**](SchemaAttribute.md) |  | [optional] 
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**meta** | [**Meta**](Meta.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.model_schema import ModelSchema

# TODO update the JSON string below
json = "{}"
# create an instance of ModelSchema from a JSON string
model_schema_instance = ModelSchema.from_json(json)
# print the JSON string representation of the object
print(ModelSchema.to_json())

# convert the object into a dict
model_schema_dict = model_schema_instance.to_dict()
# create an instance of ModelSchema from a dict
model_schema_from_dict = ModelSchema.from_dict(model_schema_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


