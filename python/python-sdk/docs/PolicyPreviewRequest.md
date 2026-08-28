# PolicyPreviewRequest

Request body for the merged policy preview: a flow source to resolve policies against, plus the namespace it targets.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**source** | **str** |  | 

## Example

```python
from kestrapy.models.policy_preview_request import PolicyPreviewRequest

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyPreviewRequest from a JSON string
policy_preview_request_instance = PolicyPreviewRequest.from_json(json)
# print the JSON string representation of the object
print(PolicyPreviewRequest.to_json())

# convert the object into a dict
policy_preview_request_dict = policy_preview_request_instance.to_dict()
# create an instance of PolicyPreviewRequest from a dict
policy_preview_request_from_dict = PolicyPreviewRequest.from_dict(policy_preview_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


