# CaseTemplatesControllerApiSubjects


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**users** | [**List[CaseTemplatesControllerApiSubjectRef]**](CaseTemplatesControllerApiSubjectRef.md) |  | [optional] 
**groups** | [**List[CaseTemplatesControllerApiSubjectRef]**](CaseTemplatesControllerApiSubjectRef.md) |  | [optional] 

## Example

```python
from kestrapy.models.case_templates_controller_api_subjects import CaseTemplatesControllerApiSubjects

# TODO update the JSON string below
json = "{}"
# create an instance of CaseTemplatesControllerApiSubjects from a JSON string
case_templates_controller_api_subjects_instance = CaseTemplatesControllerApiSubjects.from_json(json)
# print the JSON string representation of the object
print(CaseTemplatesControllerApiSubjects.to_json())

# convert the object into a dict
case_templates_controller_api_subjects_dict = case_templates_controller_api_subjects_instance.to_dict()
# create an instance of CaseTemplatesControllerApiSubjects from a dict
case_templates_controller_api_subjects_from_dict = CaseTemplatesControllerApiSubjects.from_dict(case_templates_controller_api_subjects_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


