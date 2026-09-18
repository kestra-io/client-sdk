# ApiCreatePromotionTargetRequest

Request to create a new PromotionTarget.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** | The promotion target name | 
**description** | **str** | The promotion target description | [optional] 
**disabled** | **bool** | Whether the target is disabled | [optional] 
**url** | **str** | Base URL of the remote Kestra instance | 
**target_tenant** | **str** | The tenant on the target instance | 
**connection_mode** | [**ConnectionMode**](ConnectionMode.md) | Connection mode (SERVER or CLIENT) | 
**api_token** | **str** | Service-account API token used by the backend (SERVER mode only, encrypted at rest, never returned; CLIENT-mode targets must not carry one) | [optional] 
**gate** | **bool** | Whether promotions to this target require confirmation | [optional] 

## Example

```python
from kestrapy.models.api_create_promotion_target_request import ApiCreatePromotionTargetRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiCreatePromotionTargetRequest from a JSON string
api_create_promotion_target_request_instance = ApiCreatePromotionTargetRequest.from_json(json)
# print the JSON string representation of the object
print(ApiCreatePromotionTargetRequest.to_json())

# convert the object into a dict
api_create_promotion_target_request_dict = api_create_promotion_target_request_instance.to_dict()
# create an instance of ApiCreatePromotionTargetRequest from a dict
api_create_promotion_target_request_from_dict = ApiCreatePromotionTargetRequest.from_dict(api_create_promotion_target_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


