# ApiFlowHashesResponse

Response of the bulk flow-hash endpoint. Wrapped in an object (never a bare array) so the API can evolve backwards-compatibly. One entry per requested flow; `hash`/`revision` are `null` when the flow does not exist on this instance.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**hashes** | [**List[ApiFlowHashesResponseHash]**](ApiFlowHashesResponseHash.md) | Per-flow source hashes | [optional] 

## Example

```python
from kestrapy.models.api_flow_hashes_response import ApiFlowHashesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiFlowHashesResponse from a JSON string
api_flow_hashes_response_instance = ApiFlowHashesResponse.from_json(json)
# print the JSON string representation of the object
print(ApiFlowHashesResponse.to_json())

# convert the object into a dict
api_flow_hashes_response_dict = api_flow_hashes_response_instance.to_dict()
# create an instance of ApiFlowHashesResponse from a dict
api_flow_hashes_response_from_dict = ApiFlowHashesResponse.from_dict(api_flow_hashes_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


