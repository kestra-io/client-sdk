# CasesControllerLinkExecutionsByQueryRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | [**List[QueryFilter]**](QueryFilter.md) |  | 

## Example

```python
from kestrapy.models.cases_controller_link_executions_by_query_request import CasesControllerLinkExecutionsByQueryRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerLinkExecutionsByQueryRequest from a JSON string
cases_controller_link_executions_by_query_request_instance = CasesControllerLinkExecutionsByQueryRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerLinkExecutionsByQueryRequest.to_json())

# convert the object into a dict
cases_controller_link_executions_by_query_request_dict = cases_controller_link_executions_by_query_request_instance.to_dict()
# create an instance of CasesControllerLinkExecutionsByQueryRequest from a dict
cases_controller_link_executions_by_query_request_from_dict = CasesControllerLinkExecutionsByQueryRequest.from_dict(cases_controller_link_executions_by_query_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


