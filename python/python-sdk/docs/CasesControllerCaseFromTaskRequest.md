# CasesControllerCaseFromTaskRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**title** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**severity** | [**CaseSeverity**](CaseSeverity.md) |  | [optional] 
**status** | [**CaseStatus**](CaseStatus.md) |  | [optional] 
**sla** | [**SlaConfig**](SlaConfig.md) |  | [optional] 
**assignees** | [**Subjects**](Subjects.md) |  | [optional] 
**watchers** | [**Subjects**](Subjects.md) |  | [optional] 
**labels** | [**List[Label]**](Label.md) |  | [optional] 
**asset_ids** | **List[str]** |  | [optional] 
**actions** | [**List[CaseAction]**](CaseAction.md) |  | [optional] 
**link_matching_executions** | **bool** |  | [optional] 
**flow_namespace** | **str** |  | 
**flow_id** | **str** |  | 
**task_id** | **str** |  | 
**execution_id** | **str** |  | [optional] 
**execution_state** | **str** |  | [optional] 
**case_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_case_from_task_request import CasesControllerCaseFromTaskRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerCaseFromTaskRequest from a JSON string
cases_controller_case_from_task_request_instance = CasesControllerCaseFromTaskRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerCaseFromTaskRequest.to_json())

# convert the object into a dict
cases_controller_case_from_task_request_dict = cases_controller_case_from_task_request_instance.to_dict()
# create an instance of CasesControllerCaseFromTaskRequest from a dict
cases_controller_case_from_task_request_from_dict = CasesControllerCaseFromTaskRequest.from_dict(cases_controller_case_from_task_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


