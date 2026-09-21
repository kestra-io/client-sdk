# CasesControllerCancelRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reason** | **str** |  | [optional] 
**note** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_cancel_request import CasesControllerCancelRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerCancelRequest from a JSON string
cases_controller_cancel_request_instance = CasesControllerCancelRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerCancelRequest.to_json())

# convert the object into a dict
cases_controller_cancel_request_dict = cases_controller_cancel_request_instance.to_dict()
# create an instance of CasesControllerCancelRequest from a dict
cases_controller_cancel_request_from_dict = CasesControllerCancelRequest.from_dict(cases_controller_cancel_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


