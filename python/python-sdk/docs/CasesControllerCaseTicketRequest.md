# CasesControllerCaseTicketRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**system** | **str** |  | 
**key** | **str** |  | 
**url** | **str** |  | 

## Example

```python
import kestrapy
from kestrapy.models.cases_controller_case_ticket_request import CasesControllerCaseTicketRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerCaseTicketRequest from a JSON string
cases_controller_case_ticket_request_instance = CasesControllerCaseTicketRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerCaseTicketRequest.to_json())

# convert the object into a dict
cases_controller_case_ticket_request_dict = cases_controller_case_ticket_request_instance.to_dict()
# create an instance of CasesControllerCaseTicketRequest from a dict
cases_controller_case_ticket_request_from_dict = CasesControllerCaseTicketRequest.from_dict(cases_controller_case_ticket_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


