# CasesControllerApiCaseEventWithCase


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**event** | [**CasesControllerApiCaseEvent**](CasesControllerApiCaseEvent.md) |  | [optional] 
**case** | [**CasesControllerApiTriggerCase**](CasesControllerApiTriggerCase.md) |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.cases_controller_api_case_event_with_case import CasesControllerApiCaseEventWithCase

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerApiCaseEventWithCase from a JSON string
cases_controller_api_case_event_with_case_instance = CasesControllerApiCaseEventWithCase.from_json(json)
# print the JSON string representation of the object
print(CasesControllerApiCaseEventWithCase.to_json())

# convert the object into a dict
cases_controller_api_case_event_with_case_dict = cases_controller_api_case_event_with_case_instance.to_dict()
# create an instance of CasesControllerApiCaseEventWithCase from a dict
cases_controller_api_case_event_with_case_from_dict = CasesControllerApiCaseEventWithCase.from_dict(cases_controller_api_case_event_with_case_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


