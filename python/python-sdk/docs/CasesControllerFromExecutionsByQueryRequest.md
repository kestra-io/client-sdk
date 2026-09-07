# CasesControllerFromExecutionsByQueryRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**case** | [**CasesControllerCaseCreateRequest**](CasesControllerCaseCreateRequest.md) |  | 
**filters** | [**List[QueryFilter]**](QueryFilter.md) |  | 

## Example

```python
from kestrapy.models.cases_controller_from_executions_by_query_request import CasesControllerFromExecutionsByQueryRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerFromExecutionsByQueryRequest from a JSON string
cases_controller_from_executions_by_query_request_instance = CasesControllerFromExecutionsByQueryRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerFromExecutionsByQueryRequest.to_json())

# convert the object into a dict
cases_controller_from_executions_by_query_request_dict = cases_controller_from_executions_by_query_request_instance.to_dict()
# create an instance of CasesControllerFromExecutionsByQueryRequest from a dict
cases_controller_from_executions_by_query_request_from_dict = CasesControllerFromExecutionsByQueryRequest.from_dict(cases_controller_from_executions_by_query_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


