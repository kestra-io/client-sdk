# CasesControllerFromExecutionsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**case** | [**CasesControllerCaseCreateRequest**](CasesControllerCaseCreateRequest.md) |  | 
**execution_ids** | **List[str]** |  | 

## Example

```python
from kestrapy.models.cases_controller_from_executions_request import CasesControllerFromExecutionsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerFromExecutionsRequest from a JSON string
cases_controller_from_executions_request_instance = CasesControllerFromExecutionsRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerFromExecutionsRequest.to_json())

# convert the object into a dict
cases_controller_from_executions_request_dict = cases_controller_from_executions_request_instance.to_dict()
# create an instance of CasesControllerFromExecutionsRequest from a dict
cases_controller_from_executions_request_from_dict = CasesControllerFromExecutionsRequest.from_dict(cases_controller_from_executions_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


