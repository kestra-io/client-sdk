# CasesControllerApiCaseExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**execution_id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**state** | **str** |  | [optional] 
**auto** | **bool** |  | [optional] 
**created** | **datetime** |  | [optional] 
**found** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_api_case_execution import CasesControllerApiCaseExecution

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerApiCaseExecution from a JSON string
cases_controller_api_case_execution_instance = CasesControllerApiCaseExecution.from_json(json)
# print the JSON string representation of the object
print(CasesControllerApiCaseExecution.to_json())

# convert the object into a dict
cases_controller_api_case_execution_dict = cases_controller_api_case_execution_instance.to_dict()
# create an instance of CasesControllerApiCaseExecution from a dict
cases_controller_api_case_execution_from_dict = CasesControllerApiCaseExecution.from_dict(cases_controller_api_case_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


