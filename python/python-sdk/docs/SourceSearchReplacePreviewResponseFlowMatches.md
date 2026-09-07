# SourceSearchReplacePreviewResponseFlowMatches


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**editable** | **bool** |  | [optional] 
**matches** | [**List[SourceSearchReplacePreviewResponseMatch]**](SourceSearchReplacePreviewResponseMatch.md) |  | [optional] 

## Example

```python
from kestrapy.models.source_search_replace_preview_response_flow_matches import SourceSearchReplacePreviewResponseFlowMatches

# TODO update the JSON string below
json = "{}"
# create an instance of SourceSearchReplacePreviewResponseFlowMatches from a JSON string
source_search_replace_preview_response_flow_matches_instance = SourceSearchReplacePreviewResponseFlowMatches.from_json(json)
# print the JSON string representation of the object
print(SourceSearchReplacePreviewResponseFlowMatches.to_json())

# convert the object into a dict
source_search_replace_preview_response_flow_matches_dict = source_search_replace_preview_response_flow_matches_instance.to_dict()
# create an instance of SourceSearchReplacePreviewResponseFlowMatches from a dict
source_search_replace_preview_response_flow_matches_from_dict = SourceSearchReplacePreviewResponseFlowMatches.from_dict(source_search_replace_preview_response_flow_matches_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


