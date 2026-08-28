# ValuePathExpression


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attribute_path** | [**AttributeReference**](AttributeReference.md) |  | [optional] 
**attribute_expression** | **object** |  | [optional] 

## Example

```python
from kestrapy.models.value_path_expression import ValuePathExpression

# TODO update the JSON string below
json = "{}"
# create an instance of ValuePathExpression from a JSON string
value_path_expression_instance = ValuePathExpression.from_json(json)
# print the JSON string representation of the object
print(ValuePathExpression.to_json())

# convert the object into a dict
value_path_expression_dict = value_path_expression_instance.to_dict()
# create an instance of ValuePathExpression from a dict
value_path_expression_from_dict = ValuePathExpression.from_dict(value_path_expression_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


