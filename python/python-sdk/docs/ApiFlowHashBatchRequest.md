# ApiFlowHashBatchRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flows** | [**List[ApiFlowHashBatchRef]**](ApiFlowHashBatchRef.md) | The flows to fetch hashes for (max 100 per request) | 

## Example

```python
from kestrapy.models.api_flow_hash_batch_request import ApiFlowHashBatchRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiFlowHashBatchRequest from a JSON string
api_flow_hash_batch_request_instance = ApiFlowHashBatchRequest.from_json(json)
# print the JSON string representation of the object
print(ApiFlowHashBatchRequest.to_json())

# convert the object into a dict
api_flow_hash_batch_request_dict = api_flow_hash_batch_request_instance.to_dict()
# create an instance of ApiFlowHashBatchRequest from a dict
api_flow_hash_batch_request_from_dict = ApiFlowHashBatchRequest.from_dict(api_flow_hash_batch_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


