# ApiPromoteResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**target_id** | **str** | The promotion target id | [optional] 
**success** | **bool** | Whether the promote succeeded | [optional] 
**needs_confirmation** | **bool** | The gated target requires confirmation; no promote was attempted or recorded | [optional] 
**state** | [**PromotionState**](PromotionState.md) | The terminal state (null when confirmation is required) | [optional] 
**promotion_id** | **str** | The promote id (null when confirmation is required) | [optional] 
**resulting_target_revision** | **int** | The revision produced on the target (when successful) | [optional] 
**error** | **str** | The failure reason (when failed) | [optional] 

## Example

```python
from kestrapy.models.api_promote_result import ApiPromoteResult

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteResult from a JSON string
api_promote_result_instance = ApiPromoteResult.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteResult.to_json())

# convert the object into a dict
api_promote_result_dict = api_promote_result_instance.to_dict()
# create an instance of ApiPromoteResult from a dict
api_promote_result_from_dict = ApiPromoteResult.from_dict(api_promote_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


