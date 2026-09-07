# ApiFlowHashBatchResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiFlowHashBatchResult]**](ApiFlowHashBatchResult.md) | Per-flow results | [optional] 

## Example

```python
from kestrapy.models.api_flow_hash_batch_response import ApiFlowHashBatchResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiFlowHashBatchResponse from a JSON string
api_flow_hash_batch_response_instance = ApiFlowHashBatchResponse.from_json(json)
# print the JSON string representation of the object
print(ApiFlowHashBatchResponse.to_json())

# convert the object into a dict
api_flow_hash_batch_response_dict = api_flow_hash_batch_response_instance.to_dict()
# create an instance of ApiFlowHashBatchResponse from a dict
api_flow_hash_batch_response_from_dict = ApiFlowHashBatchResponse.from_dict(api_flow_hash_batch_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


