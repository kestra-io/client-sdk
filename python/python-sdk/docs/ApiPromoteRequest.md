# ApiPromoteRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**source_revision** | **int** | The source revision to promote (must be the latest) | 
**targets** | [**List[ApiPromoteTarget]**](ApiPromoteTarget.md) | The targets to promote to | 
**confirmed** | **bool** | Confirmation for gated targets | [optional] 

## Example

```python
from kestrapy.models.api_promote_request import ApiPromoteRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteRequest from a JSON string
api_promote_request_instance = ApiPromoteRequest.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteRequest.to_json())

# convert the object into a dict
api_promote_request_dict = api_promote_request_instance.to_dict()
# create an instance of ApiPromoteRequest from a dict
api_promote_request_from_dict = ApiPromoteRequest.from_dict(api_promote_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


