# CasesControllerApiCase


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**tenant_id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**severity** | [**CaseSeverity**](CaseSeverity.md) |  | [optional] 
**status** | [**CaseStatus**](CaseStatus.md) |  | [optional] 
**assignees** | [**CasesControllerApiSubjects**](CasesControllerApiSubjects.md) |  | [optional] 
**watchers** | [**CasesControllerApiSubjects**](CasesControllerApiSubjects.md) |  | [optional] 
**custom_fields** | [**List[CustomField]**](CustomField.md) |  | [optional] 
**sla** | [**SlaConfig**](SlaConfig.md) |  | [optional] 
**acknowledgement_sla** | [**SlaStatus**](SlaStatus.md) |  | [optional] 
**resolution_sla** | [**SlaStatus**](SlaStatus.md) |  | [optional] 
**created** | **datetime** |  | [optional] 
**updated** | **datetime** |  | [optional] 
**acknowledged_at** | **datetime** |  | [optional] 
**resolved_at** | **datetime** |  | [optional] 
**resolution** | [**Resolution**](Resolution.md) |  | [optional] 
**resolved_by** | **str** |  | [optional] 
**resolved_by_name** | **str** |  | [optional] 
**actions** | [**List[CaseAction]**](CaseAction.md) |  | [optional] 
**asset_ids** | **List[str]** |  | [optional] 
**created_by** | **str** |  | [optional] 
**origin** | [**Origin**](Origin.md) |  | [optional] 
**template_id** | **str** |  | [optional] 
**auto_attach** | [**List[AutoAttach]**](AutoAttach.md) |  | [optional] 
**deleted** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_api_case import CasesControllerApiCase

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerApiCase from a JSON string
cases_controller_api_case_instance = CasesControllerApiCase.from_json(json)
# print the JSON string representation of the object
print(CasesControllerApiCase.to_json())

# convert the object into a dict
cases_controller_api_case_dict = cases_controller_api_case_instance.to_dict()
# create an instance of CasesControllerApiCase from a dict
cases_controller_api_case_from_dict = CasesControllerApiCase.from_dict(cases_controller_api_case_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


