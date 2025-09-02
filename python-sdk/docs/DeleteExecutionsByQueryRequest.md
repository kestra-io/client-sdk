# DeleteExecutionsByQueryRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | [**List[QueryFilter]**](QueryFilter.md) | Filters | [optional] 

## Example

```python
from kestra_api_client.models.delete_executions_by_query_request import DeleteExecutionsByQueryRequest

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteExecutionsByQueryRequest from a JSON string
delete_executions_by_query_request_instance = DeleteExecutionsByQueryRequest.from_json(json)
# print the JSON string representation of the object
print(DeleteExecutionsByQueryRequest.to_json())

# convert the object into a dict
delete_executions_by_query_request_dict = delete_executions_by_query_request_instance.to_dict()
# create an instance of DeleteExecutionsByQueryRequest from a dict
delete_executions_by_query_request_from_dict = DeleteExecutionsByQueryRequest.from_dict(delete_executions_by_query_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


