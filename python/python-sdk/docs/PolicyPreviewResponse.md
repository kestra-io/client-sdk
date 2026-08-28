# PolicyPreviewResponse

Result of dry-running the applicable policy chain against a flow source.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**resolved_source** | **str** |  | [optional] 
**mutations** | [**List[PolicyMutation]**](PolicyMutation.md) |  | [optional] 
**violations** | [**List[PolicyViolation]**](PolicyViolation.md) |  | [optional] 
**conflicts** | [**List[PolicyConflict]**](PolicyConflict.md) |  | [optional] 

## Example

```python
from kestrapy.models.policy_preview_response import PolicyPreviewResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyPreviewResponse from a JSON string
policy_preview_response_instance = PolicyPreviewResponse.from_json(json)
# print the JSON string representation of the object
print(PolicyPreviewResponse.to_json())

# convert the object into a dict
policy_preview_response_dict = policy_preview_response_instance.to_dict()
# create an instance of PolicyPreviewResponse from a dict
policy_preview_response_from_dict = PolicyPreviewResponse.from_dict(policy_preview_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


