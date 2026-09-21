# QuotaLimitControllerApiQuotaLimitResetRequest

Request body for resetting a quota limit.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**id** | **str** |  | 

## Example

```python
from kestrapy.models.quota_limit_controller_api_quota_limit_reset_request import QuotaLimitControllerApiQuotaLimitResetRequest

# TODO update the JSON string below
json = "{}"
# create an instance of QuotaLimitControllerApiQuotaLimitResetRequest from a JSON string
quota_limit_controller_api_quota_limit_reset_request_instance = QuotaLimitControllerApiQuotaLimitResetRequest.from_json(json)
# print the JSON string representation of the object
print(QuotaLimitControllerApiQuotaLimitResetRequest.to_json())

# convert the object into a dict
quota_limit_controller_api_quota_limit_reset_request_dict = quota_limit_controller_api_quota_limit_reset_request_instance.to_dict()
# create an instance of QuotaLimitControllerApiQuotaLimitResetRequest from a dict
quota_limit_controller_api_quota_limit_reset_request_from_dict = QuotaLimitControllerApiQuotaLimitResetRequest.from_dict(quota_limit_controller_api_quota_limit_reset_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


