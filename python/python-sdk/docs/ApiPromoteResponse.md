# ApiPromoteResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiPromoteResult]**](ApiPromoteResult.md) | Per-target results | [optional] 

## Example

```python
from kestrapy.models.api_promote_response import ApiPromoteResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPromoteResponse from a JSON string
api_promote_response_instance = ApiPromoteResponse.from_json(json)
# print the JSON string representation of the object
print(ApiPromoteResponse.to_json())

# convert the object into a dict
api_promote_response_dict = api_promote_response_instance.to_dict()
# create an instance of ApiPromoteResponse from a dict
api_promote_response_from_dict = ApiPromoteResponse.from_dict(api_promote_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


