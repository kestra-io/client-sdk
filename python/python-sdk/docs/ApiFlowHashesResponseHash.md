# ApiFlowHashesResponseHash


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** | The flow namespace | [optional] 
**id** | **str** | The flow id | [optional] 
**hash** | **str** | The source hash, or null when the flow is absent | [optional] 
**revision** | **int** | The flow revision when present | [optional] 

## Example

```python
from kestrapy.models.api_flow_hashes_response_hash import ApiFlowHashesResponseHash

# TODO update the JSON string below
json = "{}"
# create an instance of ApiFlowHashesResponseHash from a JSON string
api_flow_hashes_response_hash_instance = ApiFlowHashesResponseHash.from_json(json)
# print the JSON string representation of the object
print(ApiFlowHashesResponseHash.to_json())

# convert the object into a dict
api_flow_hashes_response_hash_dict = api_flow_hashes_response_hash_instance.to_dict()
# create an instance of ApiFlowHashesResponseHash from a dict
api_flow_hashes_response_hash_from_dict = ApiFlowHashesResponseHash.from_dict(api_flow_hashes_response_hash_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


