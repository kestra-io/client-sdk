# ApiPolicyEvaluationResource

The identity of a resource affected by the evaluated policy.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**kind** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.api_policy_evaluation_resource import ApiPolicyEvaluationResource

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPolicyEvaluationResource from a JSON string
api_policy_evaluation_resource_instance = ApiPolicyEvaluationResource.from_json(json)
# print the JSON string representation of the object
print(ApiPolicyEvaluationResource.to_json())

# convert the object into a dict
api_policy_evaluation_resource_dict = api_policy_evaluation_resource_instance.to_dict()
# create an instance of ApiPolicyEvaluationResource from a dict
api_policy_evaluation_resource_from_dict = ApiPolicyEvaluationResource.from_dict(api_policy_evaluation_resource_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


