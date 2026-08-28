# ApiPromoteFlowResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** | The flow namespace | [optional] 
**flow_id** | **str** | The flow id | [optional] 
**source_revision** | **int** | The promoted source revision (null when the flow could not be read) | [optional] 
**error** | **str** | Why the flow itself could not be promoted (null when it was attempted) | [optional] 
**results** | [**List[ApiPromoteResult]**](ApiPromoteResult.md) | Per-target results (empty when the flow could not be read) | [optional] 

## Example

```python
from kestrapy.models.api_promote_flow_result import ApiPromoteFlowResult

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteFlowResult from a JSON string
api_promote_flow_result_instance = ApiPromoteFlowResult.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteFlowResult.to_json())

# convert the object into a dict
api_promote_flow_result_dict = api_promote_flow_result_instance.to_dict()
# create an instance of ApiPromoteFlowResult from a dict
api_promote_flow_result_from_dict = ApiPromoteFlowResult.from_dict(api_promote_flow_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


