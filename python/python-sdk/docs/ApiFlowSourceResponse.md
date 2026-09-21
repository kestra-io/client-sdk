# ApiFlowSourceResponse

A flow's raw source and revision fetched from a target.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** | The flow namespace | [optional] 
**flow_id** | **str** | The flow id | [optional] 
**source** | **str** | The raw flow source (YAML) | [optional] 
**revision** | **int** | The flow revision on the target | [optional] 

## Example

```python
from kestrapy.models.api_flow_source_response import ApiFlowSourceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiFlowSourceResponse from a JSON string
api_flow_source_response_instance = ApiFlowSourceResponse.from_json(json)
# print the JSON string representation of the object
print(ApiFlowSourceResponse.to_json())

# convert the object into a dict
api_flow_source_response_dict = api_flow_source_response_instance.to_dict()
# create an instance of ApiFlowSourceResponse from a dict
api_flow_source_response_from_dict = ApiFlowSourceResponse.from_dict(api_flow_source_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


