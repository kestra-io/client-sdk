# PolicyTarget

Narrows where the policy applies within its scope: tenants for INSTANCE/STATIC policies, namespace subtrees for TENANT policies.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenants** | **List[str]** |  | [optional] 
**namespaces** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.policy_target import PolicyTarget

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyTarget from a JSON string
policy_target_instance = PolicyTarget.from_json(json)
# print the JSON string representation of the object
print(PolicyTarget.to_json())

# convert the object into a dict
policy_target_dict = policy_target_instance.to_dict()
# create an instance of PolicyTarget from a dict
policy_target_from_dict = PolicyTarget.from_dict(policy_target_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


