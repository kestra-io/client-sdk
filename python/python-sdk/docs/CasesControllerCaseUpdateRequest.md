# CasesControllerCaseUpdateRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**severity** | [**CaseSeverity**](CaseSeverity.md) |  | [optional] 
**custom_fields** | [**List[CustomField]**](CustomField.md) |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_case_update_request import CasesControllerCaseUpdateRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerCaseUpdateRequest from a JSON string
cases_controller_case_update_request_instance = CasesControllerCaseUpdateRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerCaseUpdateRequest.to_json())

# convert the object into a dict
cases_controller_case_update_request_dict = cases_controller_case_update_request_instance.to_dict()
# create an instance of CasesControllerCaseUpdateRequest from a dict
cases_controller_case_update_request_from_dict = CasesControllerCaseUpdateRequest.from_dict(cases_controller_case_update_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


