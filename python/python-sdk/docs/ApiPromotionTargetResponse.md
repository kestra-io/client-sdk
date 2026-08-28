# ApiPromotionTargetResponse

API response for a PromotionTarget. The stored API token is never returned (a SERVER-mode target always has one, so its presence is implied by the connection mode).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | The promotion target id | [optional] 
**tenant_id** | **str** | The tenant id | [optional] 
**name** | **str** | The promotion target name | [optional] 
**description** | **str** | The promotion target description | [optional] 
**disabled** | **bool** | Whether the target is disabled | [optional] 
**url** | **str** | Base URL of the remote Kestra instance | [optional] 
**target_tenant** | **str** | The tenant on the target instance | [optional] 
**connection_mode** | [**ConnectionMode**](ConnectionMode.md) | Connection mode (SERVER or CLIENT) | [optional] 
**gate** | **bool** | Whether promotions to this target require confirmation | [optional] 
**created_at** | **datetime** | Created timestamp | [optional] 
**updated_at** | **datetime** | Updated timestamp | [optional] 

## Example

```python
from kestrapy.models.api_promotion_target_response import ApiPromotionTargetResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromotionTargetResponse from a JSON string
api_promotion_target_response_instance = ApiPromotionTargetResponse.from_json(json)
# print the JSON string representation of the object
print(ApiPromotionTargetResponse.to_json())

# convert the object into a dict
api_promotion_target_response_dict = api_promotion_target_response_instance.to_dict()
# create an instance of ApiPromotionTargetResponse from a dict
api_promotion_target_response_from_dict = ApiPromotionTargetResponse.from_dict(api_promotion_target_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


