# CasesControllerApiCaseEventSearchResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[CasesControllerApiCaseEventWithCase]**](CasesControllerApiCaseEventWithCase.md) |  | [optional] 
**next_since_created** | **datetime** |  | [optional] 
**next_since_id** | **str** |  | [optional] 
**has_more** | **bool** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.cases_controller_api_case_event_search_result import CasesControllerApiCaseEventSearchResult

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerApiCaseEventSearchResult from a JSON string
cases_controller_api_case_event_search_result_instance = CasesControllerApiCaseEventSearchResult.from_json(json)
# print the JSON string representation of the object
print(CasesControllerApiCaseEventSearchResult.to_json())

# convert the object into a dict
cases_controller_api_case_event_search_result_dict = cases_controller_api_case_event_search_result_instance.to_dict()
# create an instance of CasesControllerApiCaseEventSearchResult from a dict
cases_controller_api_case_event_search_result_from_dict = CasesControllerApiCaseEventSearchResult.from_dict(cases_controller_api_case_event_search_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


