# ApiPromoteDiffResponse

The two source sides of a past promote, for recomputing its diff on demand. For CLIENT-mode targets `targetSource` is null and `clientFetchRequired` is true --- the browser must fetch the target side itself (the backend cannot reach the target).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** | The flow namespace | [optional] 
**flow_id** | **str** | The flow id | [optional] 
**source_revision** | **int** | The promoted source revision | [optional] 
**source_source** | **str** | The source-side flow source at sourceRevision | [optional] 
**target_id** | **str** | The promotion target id | [optional] 
**mode** | [**ConnectionMode**](ConnectionMode.md) | The connection mode of the target | [optional] 
**target_revision** | **int** | The target revision the promote diffed against | [optional] 
**target_source** | **str** | The target-side source (SERVER mode only; null for CLIENT) | [optional] 
**client_fetch_required** | **bool** | True when the browser must fetch the target side itself (CLIENT mode) | [optional] 

## Example

```python
from kestrapy.models.api_promote_diff_response import ApiPromoteDiffResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteDiffResponse from a JSON string
api_promote_diff_response_instance = ApiPromoteDiffResponse.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteDiffResponse.to_json())

# convert the object into a dict
api_promote_diff_response_dict = api_promote_diff_response_instance.to_dict()
# create an instance of ApiPromoteDiffResponse from a dict
api_promote_diff_response_from_dict = ApiPromoteDiffResponse.from_dict(api_promote_diff_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


