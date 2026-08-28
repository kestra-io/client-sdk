# SourceSearchReplacePreviewRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**query** | **str** |  | 
**case_sensitive** | **bool** |  | [optional] 
**whole_word** | **bool** |  | [optional] 
**regex** | **bool** |  | [optional] 
**namespace** | **str** |  | [optional] 
**scope** | [**SourceSearchScope**](SourceSearchScope.md) |  | [optional] 
**replacement** | **str** |  | 

## Example

```python
from kestrapy.models.source_search_replace_preview_request import SourceSearchReplacePreviewRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SourceSearchReplacePreviewRequest from a JSON string
source_search_replace_preview_request_instance = SourceSearchReplacePreviewRequest.from_json(json)
# print the JSON string representation of the object
print(SourceSearchReplacePreviewRequest.to_json())

# convert the object into a dict
source_search_replace_preview_request_dict = source_search_replace_preview_request_instance.to_dict()
# create an instance of SourceSearchReplacePreviewRequest from a dict
source_search_replace_preview_request_from_dict = SourceSearchReplacePreviewRequest.from_dict(source_search_replace_preview_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


