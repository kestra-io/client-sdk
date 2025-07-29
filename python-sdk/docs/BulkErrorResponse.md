# BulkErrorResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**message** | **str** |  | [optional] 
**invalids** | **object** |  | [optional] 

## Example

```python
from kestrapy.models.bulk_error_response import BulkErrorResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BulkErrorResponse from a JSON string
bulk_error_response_instance = BulkErrorResponse.from_json(json)
# print the JSON string representation of the object
print(BulkErrorResponse.to_json())

# convert the object into a dict
bulk_error_response_dict = bulk_error_response_instance.to_dict()
# create an instance of BulkErrorResponse from a dict
bulk_error_response_from_dict = BulkErrorResponse.from_dict(bulk_error_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


