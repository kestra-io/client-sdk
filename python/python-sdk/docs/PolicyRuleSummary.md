# PolicyRuleSummary

Rule counts by family.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**mutate** | **int** |  | [optional] 
**validate** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.policy_rule_summary import PolicyRuleSummary

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyRuleSummary from a JSON string
policy_rule_summary_instance = PolicyRuleSummary.from_json(json)
# print the JSON string representation of the object
print(PolicyRuleSummary.to_json())

# convert the object into a dict
policy_rule_summary_dict = policy_rule_summary_instance.to_dict()
# create an instance of PolicyRuleSummary from a dict
policy_rule_summary_from_dict = PolicyRuleSummary.from_dict(policy_rule_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


