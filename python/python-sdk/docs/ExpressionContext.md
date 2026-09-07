# ExpressionContext


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**categories** | [**ExpressionContextCategories**](ExpressionContextCategories.md) |  | [optional] 

## Example

```python
from kestrapy.models.expression_context import ExpressionContext

# TODO update the JSON string below
json = "{}"
# create an instance of ExpressionContext from a JSON string
expression_context_instance = ExpressionContext.from_json(json)
# print the JSON string representation of the object
print(ExpressionContext.to_json())

# convert the object into a dict
expression_context_dict = expression_context_instance.to_dict()
# create an instance of ExpressionContext from a dict
expression_context_from_dict = ExpressionContext.from_dict(expression_context_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


