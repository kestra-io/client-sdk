# CasesControllerResolveRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reason** | **str** |  | 
**note** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_resolve_request import CasesControllerResolveRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerResolveRequest from a JSON string
cases_controller_resolve_request_instance = CasesControllerResolveRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerResolveRequest.to_json())

# convert the object into a dict
cases_controller_resolve_request_dict = cases_controller_resolve_request_instance.to_dict()
# create an instance of CasesControllerResolveRequest from a dict
cases_controller_resolve_request_from_dict = CasesControllerResolveRequest.from_dict(cases_controller_resolve_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


