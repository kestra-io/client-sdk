# PolicyEvaluation

Stateless dry-run of a single policy against every resource in its scope.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**counts** | [**ApiPolicyEvaluationCounts**](ApiPolicyEvaluationCounts.md) |  | [optional] 
**total** | **int** |  | [optional] 
**results** | [**List[PolicyEvaluationResult]**](PolicyEvaluationResult.md) |  | [optional] 

## Example

```python
from kestrapy.models.policy_evaluation import PolicyEvaluation

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyEvaluation from a JSON string
policy_evaluation_instance = PolicyEvaluation.from_json(json)
# print the JSON string representation of the object
print(PolicyEvaluation.to_json())

# convert the object into a dict
policy_evaluation_dict = policy_evaluation_instance.to_dict()
# create an instance of PolicyEvaluation from a dict
policy_evaluation_from_dict = PolicyEvaluation.from_dict(policy_evaluation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


