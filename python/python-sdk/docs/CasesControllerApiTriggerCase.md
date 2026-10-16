# CasesControllerApiTriggerCase


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**severity** | [**CaseSeverity**](CaseSeverity.md) |  | [optional] 
**status** | [**CaseStatus**](CaseStatus.md) |  | [optional] 
**namespace** | **str** |  | [optional] 
**url** | **str** |  | [optional] 
**ticket** | [**CaseTicket**](CaseTicket.md) |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.cases_controller_api_trigger_case import CasesControllerApiTriggerCase

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerApiTriggerCase from a JSON string
cases_controller_api_trigger_case_instance = CasesControllerApiTriggerCase.from_json(json)
# print the JSON string representation of the object
print(CasesControllerApiTriggerCase.to_json())

# convert the object into a dict
cases_controller_api_trigger_case_dict = cases_controller_api_trigger_case_instance.to_dict()
# create an instance of CasesControllerApiTriggerCase from a dict
cases_controller_api_trigger_case_from_dict = CasesControllerApiTriggerCase.from_dict(cases_controller_api_trigger_case_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


