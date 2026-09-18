# ExpressionContextCategories


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**task_outputs** | **List[str]** |  | [optional] 
**execution_context** | **List[str]** |  | [optional] 
**inputs** | **List[str]** |  | [optional] 
**variables** | **List[str]** |  | [optional] 
**secrets** | **List[str]** |  | [optional] 
**kv_pairs** | **List[str]** |  | [optional] 
**namespace_files** | **List[str]** |  | [optional] 
**filters** | **List[str]** |  | [optional] 
**functions** | **List[str]** |  | [optional] 
**app_context** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.expression_context_categories import ExpressionContextCategories

# TODO update the JSON string below
json = "{}"
# create an instance of ExpressionContextCategories from a JSON string
expression_context_categories_instance = ExpressionContextCategories.from_json(json)
# print the JSON string representation of the object
print(ExpressionContextCategories.to_json())

# convert the object into a dict
expression_context_categories_dict = expression_context_categories_instance.to_dict()
# create an instance of ExpressionContextCategories from a dict
expression_context_categories_from_dict = ExpressionContextCategories.from_dict(expression_context_categories_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


