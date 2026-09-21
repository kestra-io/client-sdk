# PolicyEvaluationResult

One affected resource with the mutations, violations, and conflicts the policy would produce on it.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**resource** | [**ApiPolicyEvaluationResource**](ApiPolicyEvaluationResource.md) |  | [optional] 
**mutations** | [**List[PolicyMutation]**](PolicyMutation.md) |  | [optional] 
**violations** | [**List[PolicyViolation]**](PolicyViolation.md) |  | [optional] 
**conflicts** | [**List[PolicyConflict]**](PolicyConflict.md) |  | [optional] 

## Example

```python
from kestrapy.models.policy_evaluation_result import PolicyEvaluationResult

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyEvaluationResult from a JSON string
policy_evaluation_result_instance = PolicyEvaluationResult.from_json(json)
# print the JSON string representation of the object
print(PolicyEvaluationResult.to_json())

# convert the object into a dict
policy_evaluation_result_dict = policy_evaluation_result_instance.to_dict()
# create an instance of PolicyEvaluationResult from a dict
policy_evaluation_result_from_dict = PolicyEvaluationResult.from_dict(policy_evaluation_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


