# QueryFilterOperation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**value** | **str** |  | 

## Example

```python
from kestra_api_client.models.query_filter_operation import QueryFilterOperation

# TODO update the JSON string below
json = "{}"
# create an instance of QueryFilterOperation from a JSON string
query_filter_operation_instance = QueryFilterOperation.from_json(json)
# print the JSON string representation of the object
print(QueryFilterOperation.to_json())

# convert the object into a dict
query_filter_operation_dict = query_filter_operation_instance.to_dict()
# create an instance of QueryFilterOperation from a dict
query_filter_operation_from_dict = QueryFilterOperation.from_dict(query_filter_operation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


