# ExpressionControllerRenderExpressionRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expressions** | **List[str]** | The raw Pebble expressions to render | 
**execution_id** | **str** | Resolve against this execution&#39;s context | [optional] 
**namespace** | **str** | Resolve against this flow&#39;s context (with flowId) | [optional] 
**flow_id** | **str** | Resolve against this flow&#39;s context (with namespace) | [optional] 
**flow** | **str** | Resolve against this flow source&#39;s context (YAML) | [optional] 

## Example

```python
from kestrapy.models.expression_controller_render_expression_request import ExpressionControllerRenderExpressionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ExpressionControllerRenderExpressionRequest from a JSON string
expression_controller_render_expression_request_instance = ExpressionControllerRenderExpressionRequest.from_json(json)
# print the JSON string representation of the object
print(ExpressionControllerRenderExpressionRequest.to_json())

# convert the object into a dict
expression_controller_render_expression_request_dict = expression_controller_render_expression_request_instance.to_dict()
# create an instance of ExpressionControllerRenderExpressionRequest from a dict
expression_controller_render_expression_request_from_dict = ExpressionControllerRenderExpressionRequest.from_dict(expression_controller_render_expression_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


