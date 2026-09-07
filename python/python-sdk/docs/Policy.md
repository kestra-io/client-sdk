# Policy

A governance policy bundling a scope placement with mutate and validate rules applied to flows.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**display_name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**enforcement** | [**Enforcement**](Enforcement.md) |  | 
**target** | [**PolicyTarget**](PolicyTarget.md) |  | [optional] 
**rules** | [**List[Rule]**](Rule.md) |  | 
**source** | **str** |  | [optional] 
**deleted** | **bool** |  | 

## Example

```python
from kestrapy.models.policy import Policy

# TODO update the JSON string below
json = "{}"
# create an instance of Policy from a JSON string
policy_instance = Policy.from_json(json)
# print the JSON string representation of the object
print(Policy.to_json())

# convert the object into a dict
policy_dict = policy_instance.to_dict()
# create an instance of Policy from a dict
policy_from_dict = Policy.from_dict(policy_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


