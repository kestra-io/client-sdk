# CaseAction


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**label** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.case_action import CaseAction

# TODO update the JSON string below
json = "{}"
# create an instance of CaseAction from a JSON string
case_action_instance = CaseAction.from_json(json)
# print the JSON string representation of the object
print(CaseAction.to_json())

# convert the object into a dict
case_action_dict = case_action_instance.to_dict()
# create an instance of CaseAction from a dict
case_action_from_dict = CaseAction.from_dict(case_action_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


