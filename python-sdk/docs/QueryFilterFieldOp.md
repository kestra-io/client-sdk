# QueryFilterFieldOp


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**value** | **str** |  | 
**operations** | [**List[QueryFilterOperation]**](QueryFilterOperation.md) |  | 

## Example

```python
from kestrapy.models.query_filter_field_op import QueryFilterFieldOp

# TODO update the JSON string below
json = "{}"
# create an instance of QueryFilterFieldOp from a JSON string
query_filter_field_op_instance = QueryFilterFieldOp.from_json(json)
# print the JSON string representation of the object
print(QueryFilterFieldOp.to_json())

# convert the object into a dict
query_filter_field_op_dict = query_filter_field_op_instance.to_dict()
# create an instance of QueryFilterFieldOp from a dict
query_filter_field_op_from_dict = QueryFilterFieldOp.from_dict(query_filter_field_op_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


