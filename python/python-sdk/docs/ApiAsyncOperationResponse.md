# ApiAsyncOperationResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operation_id** | **str** | The operation identifier used to correlate logs and progress indicators | [optional] 
**total_items** | **int** | The number of domain events submitted for asynchronous processing | [optional] 

## Example

```python
from kestrapy.models.api_async_operation_response import ApiAsyncOperationResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiAsyncOperationResponse from a JSON string
api_async_operation_response_instance = ApiAsyncOperationResponse.from_json(json)
# print the JSON string representation of the object
print(ApiAsyncOperationResponse.to_json())

# convert the object into a dict
api_async_operation_response_dict = api_async_operation_response_instance.to_dict()
# create an instance of ApiAsyncOperationResponse from a dict
api_async_operation_response_from_dict = ApiAsyncOperationResponse.from_dict(api_async_operation_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


