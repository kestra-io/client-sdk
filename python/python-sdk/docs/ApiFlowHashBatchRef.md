# ApiFlowHashBatchRef


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** | The flow namespace | [optional] 
**flow_id** | **str** | The flow id | [optional] 

## Example

```python
from kestrapy.models.api_flow_hash_batch_ref import ApiFlowHashBatchRef

# TODO update the JSON string below
json = "{}"
# create an instance of ApiFlowHashBatchRef from a JSON string
api_flow_hash_batch_ref_instance = ApiFlowHashBatchRef.from_json(json)
# print the JSON string representation of the object
print(ApiFlowHashBatchRef.to_json())

# convert the object into a dict
api_flow_hash_batch_ref_dict = api_flow_hash_batch_ref_instance.to_dict()
# create an instance of ApiFlowHashBatchRef from a dict
api_flow_hash_batch_ref_from_dict = ApiFlowHashBatchRef.from_dict(api_flow_hash_batch_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


