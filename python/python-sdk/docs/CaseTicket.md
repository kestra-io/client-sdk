# CaseTicket


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**system** | **str** |  | [optional] 
**key** | **str** |  | [optional] 
**url** | **str** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.case_ticket import CaseTicket

# TODO update the JSON string below
json = "{}"
# create an instance of CaseTicket from a JSON string
case_ticket_instance = CaseTicket.from_json(json)
# print the JSON string representation of the object
print(CaseTicket.to_json())

# convert the object into a dict
case_ticket_dict = case_ticket_instance.to_dict()
# create an instance of CaseTicket from a dict
case_ticket_from_dict = CaseTicket.from_dict(case_ticket_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


