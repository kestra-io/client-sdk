# ApiPolicyEvaluationCounts

Aggregate counters of a policy dry-run.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**scanned** | **int** |  | [optional] 
**mutated** | **int** |  | [optional] 
**violating** | **int** |  | [optional] 
**conflicting** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.api_policy_evaluation_counts import ApiPolicyEvaluationCounts

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPolicyEvaluationCounts from a JSON string
api_policy_evaluation_counts_instance = ApiPolicyEvaluationCounts.from_json(json)
# print the JSON string representation of the object
print(ApiPolicyEvaluationCounts.to_json())

# convert the object into a dict
api_policy_evaluation_counts_dict = api_policy_evaluation_counts_instance.to_dict()
# create an instance of ApiPolicyEvaluationCounts from a dict
api_policy_evaluation_counts_from_dict = ApiPolicyEvaluationCounts.from_dict(api_policy_evaluation_counts_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


