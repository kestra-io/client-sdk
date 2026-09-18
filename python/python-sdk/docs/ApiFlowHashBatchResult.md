# ApiFlowHashBatchResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** | The flow namespace | [optional] 
**flow_id** | **str** | The flow id | [optional] 
**hash** | **str** | The source hash on the target, or null when the flow is absent | [optional] 
**revision** | **int** | The flow revision on the target when present | [optional] 

## Example

```python
from kestrapy.models.api_flow_hash_batch_result import ApiFlowHashBatchResult

# TODO update the JSON string below
json = "{}"
# create an instance of ApiFlowHashBatchResult from a JSON string
api_flow_hash_batch_result_instance = ApiFlowHashBatchResult.from_json(json)
# print the JSON string representation of the object
print(ApiFlowHashBatchResult.to_json())

# convert the object into a dict
api_flow_hash_batch_result_dict = api_flow_hash_batch_result_instance.to_dict()
# create an instance of ApiFlowHashBatchResult from a dict
api_flow_hash_batch_result_from_dict = ApiFlowHashBatchResult.from_dict(api_flow_hash_batch_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


