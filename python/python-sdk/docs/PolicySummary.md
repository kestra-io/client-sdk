# PolicySummary

A governance policy listing entry, without the rule payloads.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**scope** | [**Scope**](Scope.md) |  | [optional] 
**namespace** | **str** |  | [optional] 
**target** | [**PolicyTarget**](PolicyTarget.md) |  | [optional] 
**enforcement** | [**Enforcement**](Enforcement.md) |  | [optional] 
**rules** | [**PolicyRuleSummary**](PolicyRuleSummary.md) |  | [optional] 

## Example

```python
from kestrapy.models.policy_summary import PolicySummary

# TODO update the JSON string below
json = "{}"
# create an instance of PolicySummary from a JSON string
policy_summary_instance = PolicySummary.from_json(json)
# print the JSON string representation of the object
print(PolicySummary.to_json())

# convert the object into a dict
policy_summary_dict = policy_summary_instance.to_dict()
# create an instance of PolicySummary from a dict
policy_summary_from_dict = PolicySummary.from_dict(policy_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


