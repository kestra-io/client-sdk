# CasesControllerAutoAttachRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**states** | [**List[StateType]**](StateType.md) |  | 

## Example

```python
from kestrapy.models.cases_controller_auto_attach_request import CasesControllerAutoAttachRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerAutoAttachRequest from a JSON string
cases_controller_auto_attach_request_instance = CasesControllerAutoAttachRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerAutoAttachRequest.to_json())

# convert the object into a dict
cases_controller_auto_attach_request_dict = cases_controller_auto_attach_request_instance.to_dict()
# create an instance of CasesControllerAutoAttachRequest from a dict
cases_controller_auto_attach_request_from_dict = CasesControllerAutoAttachRequest.from_dict(cases_controller_auto_attach_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


