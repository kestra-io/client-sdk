# CasesControllerLinkExecutionsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**execution_ids** | **List[str]** |  | 

## Example

```python
from kestrapy.models.cases_controller_link_executions_request import CasesControllerLinkExecutionsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerLinkExecutionsRequest from a JSON string
cases_controller_link_executions_request_instance = CasesControllerLinkExecutionsRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerLinkExecutionsRequest.to_json())

# convert the object into a dict
cases_controller_link_executions_request_dict = cases_controller_link_executions_request_instance.to_dict()
# create an instance of CasesControllerLinkExecutionsRequest from a dict
cases_controller_link_executions_request_from_dict = CasesControllerLinkExecutionsRequest.from_dict(cases_controller_link_executions_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


