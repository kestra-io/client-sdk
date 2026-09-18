# CasesControllerStatusRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**CaseStatus**](CaseStatus.md) |  | 
**resolution** | [**Resolution**](Resolution.md) |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_status_request import CasesControllerStatusRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerStatusRequest from a JSON string
cases_controller_status_request_instance = CasesControllerStatusRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerStatusRequest.to_json())

# convert the object into a dict
cases_controller_status_request_dict = cases_controller_status_request_instance.to_dict()
# create an instance of CasesControllerStatusRequest from a dict
cases_controller_status_request_from_dict = CasesControllerStatusRequest.from_dict(cases_controller_status_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


