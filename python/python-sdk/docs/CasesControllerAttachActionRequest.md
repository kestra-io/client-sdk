# CasesControllerAttachActionRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**label** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 

## Example

```python
from kestrapy.models.cases_controller_attach_action_request import CasesControllerAttachActionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerAttachActionRequest from a JSON string
cases_controller_attach_action_request_instance = CasesControllerAttachActionRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerAttachActionRequest.to_json())

# convert the object into a dict
cases_controller_attach_action_request_dict = cases_controller_attach_action_request_instance.to_dict()
# create an instance of CasesControllerAttachActionRequest from a dict
cases_controller_attach_action_request_from_dict = CasesControllerAttachActionRequest.from_dict(cases_controller_attach_action_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


