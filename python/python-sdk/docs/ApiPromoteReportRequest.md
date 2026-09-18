# ApiPromoteReportRequest

A CLIENT-mode promote reported by the browser after it performed the upsert directly against the target. `by` and the timestamp are stamped server-side and never taken from this payload.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**promotion_id** | **str** | Client-generated idempotency key for this promote | 
**target_id** | **str** | The promotion target id | 
**source_revision** | **int** | The promoted source revision | [optional] 
**target_revision** | **int** | The target revision before the push (null on first promote) | [optional] 
**resulting_target_revision** | **int** | The revision produced on the target | [optional] 
**gate_outcome** | [**GateOutcome**](GateOutcome.md) | Gate outcome (NONE or CONFIRMED) | 
**state** | [**PromotionState**](PromotionState.md) | Terminal state (SUCCESS or FAILED) | 

## Example

```python
from kestrapy.models.api_promote_report_request import ApiPromoteReportRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteReportRequest from a JSON string
api_promote_report_request_instance = ApiPromoteReportRequest.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteReportRequest.to_json())

# convert the object into a dict
api_promote_report_request_dict = api_promote_report_request_instance.to_dict()
# create an instance of ApiPromoteReportRequest from a dict
api_promote_report_request_from_dict = ApiPromoteReportRequest.from_dict(api_promote_report_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


