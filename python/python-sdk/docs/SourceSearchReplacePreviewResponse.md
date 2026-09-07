# SourceSearchReplacePreviewResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_matches** | **int** |  | [optional] 
**total_flows** | **int** |  | [optional] 
**editable_flow_count** | **int** |  | [optional] 
**flows** | [**List[SourceSearchReplacePreviewResponseFlowMatches]**](SourceSearchReplacePreviewResponseFlowMatches.md) |  | [optional] 

## Example

```python
from kestrapy.models.source_search_replace_preview_response import SourceSearchReplacePreviewResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SourceSearchReplacePreviewResponse from a JSON string
source_search_replace_preview_response_instance = SourceSearchReplacePreviewResponse.from_json(json)
# print the JSON string representation of the object
print(SourceSearchReplacePreviewResponse.to_json())

# convert the object into a dict
source_search_replace_preview_response_dict = source_search_replace_preview_response_instance.to_dict()
# create an instance of SourceSearchReplacePreviewResponse from a dict
source_search_replace_preview_response_from_dict = SourceSearchReplacePreviewResponse.from_dict(source_search_replace_preview_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


