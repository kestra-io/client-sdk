# QueryFilterResourceField


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**fields** | [**List[QueryFilterFieldOp]**](QueryFilterFieldOp.md) |  | 

## Example

```python
from kestrapy.models.query_filter_resource_field import QueryFilterResourceField

# TODO update the JSON string below
json = "{}"
# create an instance of QueryFilterResourceField from a JSON string
query_filter_resource_field_instance = QueryFilterResourceField.from_json(json)
# print the JSON string representation of the object
print(QueryFilterResourceField.to_json())

# convert the object into a dict
query_filter_resource_field_dict = query_filter_resource_field_instance.to_dict()
# create an instance of QueryFilterResourceField from a dict
query_filter_resource_field_from_dict = QueryFilterResourceField.from_dict(query_filter_resource_field_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


