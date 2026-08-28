# CaseTemplatesControllerApiCaseTemplate


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**tenant_id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**default_severity** | [**CaseSeverity**](CaseSeverity.md) |  | [optional] 
**default_assignees** | [**CaseTemplatesControllerApiSubjects**](CaseTemplatesControllerApiSubjects.md) |  | [optional] 
**default_watchers** | [**CaseTemplatesControllerApiSubjects**](CaseTemplatesControllerApiSubjects.md) |  | [optional] 
**title_pattern** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**sla** | [**SlaConfig**](SlaConfig.md) |  | [optional] 
**resolution_reasons** | **List[str]** |  | [optional] 
**require_resolution_note** | **bool** |  | [optional] 
**custom_fields** | [**List[CustomField]**](CustomField.md) |  | [optional] 
**default_actions** | [**List[CaseAction]**](CaseAction.md) |  | [optional] 
**is_default** | **bool** |  | [optional] 
**created_by** | **str** |  | [optional] 
**created** | **datetime** |  | [optional] 
**updated** | **datetime** |  | [optional] 
**deleted** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.case_templates_controller_api_case_template import CaseTemplatesControllerApiCaseTemplate

# TODO update the JSON string below
json = "{}"
# create an instance of CaseTemplatesControllerApiCaseTemplate from a JSON string
case_templates_controller_api_case_template_instance = CaseTemplatesControllerApiCaseTemplate.from_json(json)
# print the JSON string representation of the object
print(CaseTemplatesControllerApiCaseTemplate.to_json())

# convert the object into a dict
case_templates_controller_api_case_template_dict = case_templates_controller_api_case_template_instance.to_dict()
# create an instance of CaseTemplatesControllerApiCaseTemplate from a dict
case_templates_controller_api_case_template_from_dict = CaseTemplatesControllerApiCaseTemplate.from_dict(case_templates_controller_api_case_template_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


