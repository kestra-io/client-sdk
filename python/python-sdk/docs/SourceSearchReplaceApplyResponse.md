# SourceSearchReplaceApplyResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**updated** | [**List[FlowWithSource]**](FlowWithSource.md) | The flows that were rewritten, with their new revision. | [optional] 
**skipped** | [**List[SourceSearchReplaceApplyResponseSkippedFlow]**](SourceSearchReplaceApplyResponseSkippedFlow.md) | The flows that were left untouched, each with the reason it was skipped. | [optional] 

## Example

```python
from kestrapy.models.source_search_replace_apply_response import SourceSearchReplaceApplyResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SourceSearchReplaceApplyResponse from a JSON string
source_search_replace_apply_response_instance = SourceSearchReplaceApplyResponse.from_json(json)
# print the JSON string representation of the object
print(SourceSearchReplaceApplyResponse.to_json())

# convert the object into a dict
source_search_replace_apply_response_dict = source_search_replace_apply_response_instance.to_dict()
# create an instance of SourceSearchReplaceApplyResponse from a dict
source_search_replace_apply_response_from_dict = SourceSearchReplaceApplyResponse.from_dict(source_search_replace_apply_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


