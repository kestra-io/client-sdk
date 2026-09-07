# ApiPromoteBatchResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiPromoteFlowResult]**](ApiPromoteFlowResult.md) | Per-flow results, in request order | [optional] 

## Example

```python
from kestrapy.models.api_promote_batch_response import ApiPromoteBatchResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteBatchResponse from a JSON string
api_promote_batch_response_instance = ApiPromoteBatchResponse.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteBatchResponse.to_json())

# convert the object into a dict
api_promote_batch_response_dict = api_promote_batch_response_instance.to_dict()
# create an instance of ApiPromoteBatchResponse from a dict
api_promote_batch_response_from_dict = ApiPromoteBatchResponse.from_dict(api_promote_batch_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


