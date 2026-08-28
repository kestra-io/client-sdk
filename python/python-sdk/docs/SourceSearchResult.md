# SourceSearchResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**editable** | **bool** |  | [optional] 
**matches** | [**List[SourceMatch]**](SourceMatch.md) |  | [optional] 

## Example

```python
from kestrapy.models.source_search_result import SourceSearchResult

# TODO update the JSON string below
json = "{}"
# create an instance of SourceSearchResult from a JSON string
source_search_result_instance = SourceSearchResult.from_json(json)
# print the JSON string representation of the object
print(SourceSearchResult.to_json())

# convert the object into a dict
source_search_result_dict = source_search_result_instance.to_dict()
# create an instance of SourceSearchResult from a dict
source_search_result_from_dict = SourceSearchResult.from_dict(source_search_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


