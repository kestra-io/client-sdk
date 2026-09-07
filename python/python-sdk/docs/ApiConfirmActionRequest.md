# ApiConfirmActionRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**confirmation_id** | **str** |  | [optional] 
**decision** | [**ApiDecision**](ApiDecision.md) |  | [optional] 
**reason** | **str** |  | [optional] 
**provider_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.api_confirm_action_request import ApiConfirmActionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiConfirmActionRequest from a JSON string
api_confirm_action_request_instance = ApiConfirmActionRequest.from_json(json)
# print the JSON string representation of the object
print(ApiConfirmActionRequest.to_json())

# convert the object into a dict
api_confirm_action_request_dict = api_confirm_action_request_instance.to_dict()
# create an instance of ApiConfirmActionRequest from a dict
api_confirm_action_request_from_dict = ApiConfirmActionRequest.from_dict(api_confirm_action_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


