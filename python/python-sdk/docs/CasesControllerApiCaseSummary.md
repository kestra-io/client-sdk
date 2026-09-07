# CasesControllerApiCaseSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**severity** | [**CaseSeverity**](CaseSeverity.md) |  | [optional] 
**status** | [**CaseStatus**](CaseStatus.md) |  | [optional] 
**updated** | **datetime** |  | [optional] 
**assignees** | [**CasesControllerApiSubjects**](CasesControllerApiSubjects.md) |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_api_case_summary import CasesControllerApiCaseSummary

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerApiCaseSummary from a JSON string
cases_controller_api_case_summary_instance = CasesControllerApiCaseSummary.from_json(json)
# print the JSON string representation of the object
print(CasesControllerApiCaseSummary.to_json())

# convert the object into a dict
cases_controller_api_case_summary_dict = cases_controller_api_case_summary_instance.to_dict()
# create an instance of CasesControllerApiCaseSummary from a dict
cases_controller_api_case_summary_from_dict = CasesControllerApiCaseSummary.from_dict(cases_controller_api_case_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


