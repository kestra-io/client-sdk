# CasesControllerApiCaseEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**case_id** | **str** |  | [optional] 
**type** | [**CaseEventType**](CaseEventType.md) |  | [optional] 
**author_id** | **str** |  | [optional] 
**author_name** | **str** |  | [optional] 
**body** | **str** |  | [optional] 
**payload** | **Dict[str, object]** |  | [optional] 
**attachments** | [**List[CaseAttachment]**](CaseAttachment.md) |  | [optional] 
**created** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_api_case_event import CasesControllerApiCaseEvent

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerApiCaseEvent from a JSON string
cases_controller_api_case_event_instance = CasesControllerApiCaseEvent.from_json(json)
# print the JSON string representation of the object
print(CasesControllerApiCaseEvent.to_json())

# convert the object into a dict
cases_controller_api_case_event_dict = cases_controller_api_case_event_instance.to_dict()
# create an instance of CasesControllerApiCaseEvent from a dict
cases_controller_api_case_event_from_dict = CasesControllerApiCaseEvent.from_dict(cases_controller_api_case_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


