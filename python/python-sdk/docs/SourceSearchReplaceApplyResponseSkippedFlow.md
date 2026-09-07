# SourceSearchReplaceApplyResponseSkippedFlow

A flow that the replace operation did not modify, and why.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**reason** | [**SourceSearchReplaceApplyResponseSkipReason**](SourceSearchReplaceApplyResponseSkipReason.md) |  | [optional] 
**message** | **str** | The underlying validation error, when the reason is INVALID_FLOW. | [optional] 

## Example

```python
from kestrapy.models.source_search_replace_apply_response_skipped_flow import SourceSearchReplaceApplyResponseSkippedFlow

# TODO update the JSON string below
json = "{}"
# create an instance of SourceSearchReplaceApplyResponseSkippedFlow from a JSON string
source_search_replace_apply_response_skipped_flow_instance = SourceSearchReplaceApplyResponseSkippedFlow.from_json(json)
# print the JSON string representation of the object
print(SourceSearchReplaceApplyResponseSkippedFlow.to_json())

# convert the object into a dict
source_search_replace_apply_response_skipped_flow_dict = source_search_replace_apply_response_skipped_flow_instance.to_dict()
# create an instance of SourceSearchReplaceApplyResponseSkippedFlow from a dict
source_search_replace_apply_response_skipped_flow_from_dict = SourceSearchReplaceApplyResponseSkippedFlow.from_dict(source_search_replace_apply_response_skipped_flow_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


