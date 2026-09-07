# ForwardSupportTicketRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**payload** | **str** |  | [optional] 
**files** | **List[bytes]** |  | [optional] 

## Example

```python
from kestrapy.models.forward_support_ticket_request import ForwardSupportTicketRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ForwardSupportTicketRequest from a JSON string
forward_support_ticket_request_instance = ForwardSupportTicketRequest.from_json(json)
# print the JSON string representation of the object
print(ForwardSupportTicketRequest.to_json())

# convert the object into a dict
forward_support_ticket_request_dict = forward_support_ticket_request_instance.to_dict()
# create an instance of ForwardSupportTicketRequest from a dict
forward_support_ticket_request_from_dict = ForwardSupportTicketRequest.from_dict(forward_support_ticket_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


