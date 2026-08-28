# ApiPromoteBatchRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flows** | [**List[IdWithNamespace]**](IdWithNamespace.md) | The flows to promote (max 100 per request) | 
**target_ids** | **List[str]** | The ids of the targets to promote every flow to | 
**confirmed** | **bool** | Confirmation for gated targets | [optional] 

## Example

```python
from kestrapy.models.api_promote_batch_request import ApiPromoteBatchRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteBatchRequest from a JSON string
api_promote_batch_request_instance = ApiPromoteBatchRequest.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteBatchRequest.to_json())

# convert the object into a dict
api_promote_batch_request_dict = api_promote_batch_request_instance.to_dict()
# create an instance of ApiPromoteBatchRequest from a dict
api_promote_batch_request_from_dict = ApiPromoteBatchRequest.from_dict(api_promote_batch_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


