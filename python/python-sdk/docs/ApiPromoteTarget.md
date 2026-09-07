# ApiPromoteTarget


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | The promotion target id | 
**expected_target_revision** | **int** | The target revision the diff was reviewed against (null &#x3D; expected absent) | [optional] 

## Example

```python
from kestrapy.models.api_promote_target import ApiPromoteTarget

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteTarget from a JSON string
api_promote_target_instance = ApiPromoteTarget.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteTarget.to_json())

# convert the object into a dict
api_promote_target_dict = api_promote_target_instance.to_dict()
# create an instance of ApiPromoteTarget from a dict
api_promote_target_from_dict = ApiPromoteTarget.from_dict(api_promote_target_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


