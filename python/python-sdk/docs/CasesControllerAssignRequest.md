# CasesControllerAssignRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**assignees** | [**Subjects**](Subjects.md) |  | [optional] 
**watchers** | [**Subjects**](Subjects.md) |  | [optional] 
**note** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_assign_request import CasesControllerAssignRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerAssignRequest from a JSON string
cases_controller_assign_request_instance = CasesControllerAssignRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerAssignRequest.to_json())

# convert the object into a dict
cases_controller_assign_request_dict = cases_controller_assign_request_instance.to_dict()
# create an instance of CasesControllerAssignRequest from a dict
cases_controller_assign_request_from_dict = CasesControllerAssignRequest.from_dict(cases_controller_assign_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


