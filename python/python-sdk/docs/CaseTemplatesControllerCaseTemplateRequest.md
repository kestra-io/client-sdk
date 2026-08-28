# CaseTemplatesControllerCaseTemplateRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**namespace** | **str** |  | [optional] 
**default_severity** | [**CaseSeverity**](CaseSeverity.md) |  | [optional] 
**default_assignees** | [**Subjects**](Subjects.md) |  | [optional] 
**default_watchers** | [**Subjects**](Subjects.md) |  | [optional] 
**title_pattern** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**sla** | [**SlaConfig**](SlaConfig.md) |  | [optional] 
**resolution_reasons** | **List[str]** |  | [optional] 
**require_resolution_note** | **bool** |  | [optional] 
**custom_fields** | [**List[CustomField]**](CustomField.md) |  | [optional] 
**default_actions** | [**List[CaseAction]**](CaseAction.md) |  | [optional] 
**is_default** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.case_templates_controller_case_template_request import CaseTemplatesControllerCaseTemplateRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CaseTemplatesControllerCaseTemplateRequest from a JSON string
case_templates_controller_case_template_request_instance = CaseTemplatesControllerCaseTemplateRequest.from_json(json)
# print the JSON string representation of the object
print(CaseTemplatesControllerCaseTemplateRequest.to_json())

# convert the object into a dict
case_templates_controller_case_template_request_dict = case_templates_controller_case_template_request_instance.to_dict()
# create an instance of CaseTemplatesControllerCaseTemplateRequest from a dict
case_templates_controller_case_template_request_from_dict = CaseTemplatesControllerCaseTemplateRequest.from_dict(case_templates_controller_case_template_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


