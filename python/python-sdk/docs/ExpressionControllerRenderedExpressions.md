# ExpressionControllerRenderedExpressions


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rendered** | **Dict[str, str]** | Rendered values keyed by their raw expression | [optional] 

## Example

```python
from kestrapy.models.expression_controller_rendered_expressions import ExpressionControllerRenderedExpressions

# TODO update the JSON string below
json = "{}"
# create an instance of ExpressionControllerRenderedExpressions from a JSON string
expression_controller_rendered_expressions_instance = ExpressionControllerRenderedExpressions.from_json(json)
# print the JSON string representation of the object
print(ExpressionControllerRenderedExpressions.to_json())

# convert the object into a dict
expression_controller_rendered_expressions_dict = expression_controller_rendered_expressions_instance.to_dict()
# create an instance of ExpressionControllerRenderedExpressions from a dict
expression_controller_rendered_expressions_from_dict = ExpressionControllerRenderedExpressions.from_dict(expression_controller_rendered_expressions_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


