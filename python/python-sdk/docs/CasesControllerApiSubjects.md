# CasesControllerApiSubjects


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**users** | [**List[CasesControllerApiSubjectRef]**](CasesControllerApiSubjectRef.md) |  | [optional] 
**groups** | [**List[CasesControllerApiSubjectRef]**](CasesControllerApiSubjectRef.md) |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_api_subjects import CasesControllerApiSubjects

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerApiSubjects from a JSON string
cases_controller_api_subjects_instance = CasesControllerApiSubjects.from_json(json)
# print the JSON string representation of the object
print(CasesControllerApiSubjects.to_json())

# convert the object into a dict
cases_controller_api_subjects_dict = cases_controller_api_subjects_instance.to_dict()
# create an instance of CasesControllerApiSubjects from a dict
cases_controller_api_subjects_from_dict = CasesControllerApiSubjects.from_dict(cases_controller_api_subjects_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


