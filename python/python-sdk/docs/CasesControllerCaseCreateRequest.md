# CasesControllerCaseCreateRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**title** | **str** |  | 
**description** | **str** |  | [optional] 
**severity** | [**CaseSeverity**](CaseSeverity.md) |  | [optional] 
**status** | [**CaseStatus**](CaseStatus.md) |  | [optional] 
**template_id** | **str** |  | [optional] 
**sla** | [**SlaConfig**](SlaConfig.md) |  | [optional] 
**assignees** | [**Subjects**](Subjects.md) |  | [optional] 
**watchers** | [**Subjects**](Subjects.md) |  | [optional] 
**custom_fields** | [**List[CustomField]**](CustomField.md) |  | [optional] 
**actions** | [**List[CaseAction]**](CaseAction.md) |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_case_create_request import CasesControllerCaseCreateRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerCaseCreateRequest from a JSON string
cases_controller_case_create_request_instance = CasesControllerCaseCreateRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerCaseCreateRequest.to_json())

# convert the object into a dict
cases_controller_case_create_request_dict = cases_controller_case_create_request_instance.to_dict()
# create an instance of CasesControllerCaseCreateRequest from a dict
cases_controller_case_create_request_from_dict = CasesControllerCaseCreateRequest.from_dict(cases_controller_case_create_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


