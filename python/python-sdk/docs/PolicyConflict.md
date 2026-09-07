# PolicyConflict

An Add-vs-Delete collision on the same property within one scope chain.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**target** | **str** |  | [optional] 
**add_policy_id** | **str** |  | [optional] 
**add_scope** | [**Scope**](Scope.md) |  | [optional] 
**delete_policy_id** | **str** |  | [optional] 
**delete_scope** | [**Scope**](Scope.md) |  | [optional] 

## Example

```python
from kestrapy.models.policy_conflict import PolicyConflict

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyConflict from a JSON string
policy_conflict_instance = PolicyConflict.from_json(json)
# print the JSON string representation of the object
print(PolicyConflict.to_json())

# convert the object into a dict
policy_conflict_dict = policy_conflict_instance.to_dict()
# create an instance of PolicyConflict from a dict
policy_conflict_from_dict = PolicyConflict.from_dict(policy_conflict_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


