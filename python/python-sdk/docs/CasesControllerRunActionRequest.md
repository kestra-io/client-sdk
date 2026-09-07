# CasesControllerRunActionRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**inputs** | **Dict[str, object]** |  | [optional] 
**labels** | [**List[Label]**](Label.md) |  | [optional] 

## Example

```python
from kestrapy.models.cases_controller_run_action_request import CasesControllerRunActionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CasesControllerRunActionRequest from a JSON string
cases_controller_run_action_request_instance = CasesControllerRunActionRequest.from_json(json)
# print the JSON string representation of the object
print(CasesControllerRunActionRequest.to_json())

# convert the object into a dict
cases_controller_run_action_request_dict = cases_controller_run_action_request_instance.to_dict()
# create an instance of CasesControllerRunActionRequest from a dict
cases_controller_run_action_request_from_dict = CasesControllerRunActionRequest.from_dict(cases_controller_run_action_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


