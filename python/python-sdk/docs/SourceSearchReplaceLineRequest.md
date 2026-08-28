# SourceSearchReplaceLineRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**query** | **str** |  | 
**case_sensitive** | **bool** |  | [optional] 
**whole_word** | **bool** |  | [optional] 
**regex** | **bool** |  | [optional] 
**replacement** | **str** |  | 
**namespace** | **str** |  | 
**id** | **str** |  | 
**line** | **int** |  | [optional] 
**column** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.source_search_replace_line_request import SourceSearchReplaceLineRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SourceSearchReplaceLineRequest from a JSON string
source_search_replace_line_request_instance = SourceSearchReplaceLineRequest.from_json(json)
# print the JSON string representation of the object
print(SourceSearchReplaceLineRequest.to_json())

# convert the object into a dict
source_search_replace_line_request_dict = source_search_replace_line_request_instance.to_dict()
# create an instance of SourceSearchReplaceLineRequest from a dict
source_search_replace_line_request_from_dict = SourceSearchReplaceLineRequest.from_dict(source_search_replace_line_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


