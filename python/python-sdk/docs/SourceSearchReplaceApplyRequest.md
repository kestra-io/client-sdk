# SourceSearchReplaceApplyRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**query** | **str** |  | 
**case_sensitive** | **bool** |  | [optional] 
**whole_word** | **bool** |  | [optional] 
**regex** | **bool** |  | [optional] 
**scope** | [**SourceSearchScope**](SourceSearchScope.md) |  | [optional] 
**replacement** | **str** |  | 
**flows** | [**List[IdWithNamespace]**](IdWithNamespace.md) |  | 

## Example

```python
from kestrapy.models.source_search_replace_apply_request import SourceSearchReplaceApplyRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SourceSearchReplaceApplyRequest from a JSON string
source_search_replace_apply_request_instance = SourceSearchReplaceApplyRequest.from_json(json)
# print the JSON string representation of the object
print(SourceSearchReplaceApplyRequest.to_json())

# convert the object into a dict
source_search_replace_apply_request_dict = source_search_replace_apply_request_instance.to_dict()
# create an instance of SourceSearchReplaceApplyRequest from a dict
source_search_replace_apply_request_from_dict = SourceSearchReplaceApplyRequest.from_dict(source_search_replace_apply_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


