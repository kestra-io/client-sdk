# ApiPromotionResponse

A promotion-history item, projected from the underlying `AuditLog` + `PromoteAuditLog`. Target attributes (name/URL) are resolved client-side from `targetId`. `by` always carries the acting user id; `user` carries its display projection when the user can still be resolved (it is null for a deleted user, or when audit logs are not licensed and no user was stamped at all).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**audit_id** | **str** | The audit-log id of this promotion | [optional] 
**var_date** | **datetime** | When the promotion happened | [optional] 
**by** | **str** | Who performed the promotion | [optional] 
**user** | [**ApiUser**](ApiUser.md) | The acting user, when it can still be resolved | [optional] 
**target_id** | **str** | The promotion target id | [optional] 
**source_revision** | **int** | The promoted source revision | [optional] 
**target_revision** | **int** | The target revision before the push | [optional] 
**resulting_target_revision** | **int** | The revision produced on the target | [optional] 
**mode** | [**ConnectionMode**](ConnectionMode.md) | Connection mode (SERVER or CLIENT) | [optional] 
**gate_outcome** | [**GateOutcome**](GateOutcome.md) | Gate outcome | [optional] 
**state** | [**PromotionState**](PromotionState.md) | Terminal state | [optional] 
**error** | **str** | Failure reason, when failed | [optional] 

## Example

```python
from kestrapy.models.api_promotion_response import ApiPromotionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromotionResponse from a JSON string
api_promotion_response_instance = ApiPromotionResponse.from_json(json)
# print the JSON string representation of the object
print(ApiPromotionResponse.to_json())

# convert the object into a dict
api_promotion_response_dict = api_promotion_response_instance.to_dict()
# create an instance of ApiPromotionResponse from a dict
api_promotion_response_from_dict = ApiPromotionResponse.from_dict(api_promotion_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


