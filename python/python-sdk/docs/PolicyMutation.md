# PolicyMutation

A single change a policy made to a property, attributed to the policy that last wrote it.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**action** | [**ApiPolicyMutationAction**](ApiPolicyMutationAction.md) |  | [optional] 
**target** | **str** |  | [optional] 
**value** | **object** |  | [optional] 
**previous_value** | **object** |  | [optional] 
**policy_id** | **str** |  | [optional] 
**scope** | [**Scope**](Scope.md) |  | [optional] 

## Example

```python
from kestrapy.models.policy_mutation import PolicyMutation

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyMutation from a JSON string
policy_mutation_instance = PolicyMutation.from_json(json)
# print the JSON string representation of the object
print(PolicyMutation.to_json())

# convert the object into a dict
policy_mutation_dict = policy_mutation_instance.to_dict()
# create an instance of PolicyMutation from a dict
policy_mutation_from_dict = PolicyMutation.from_dict(policy_mutation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


