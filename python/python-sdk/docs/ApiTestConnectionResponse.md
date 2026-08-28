# ApiTestConnectionResponse

Response from testing a credential connection.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | **bool** | Whether the connection test succeeded | [optional] 
**message** | **str** | Result message | [optional] 

## Example

```python
from kestrapy.models.api_test_connection_response import ApiTestConnectionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ApiTestConnectionResponse from a JSON string
api_test_connection_response_instance = ApiTestConnectionResponse.from_json(json)
# print the JSON string representation of the object
print(ApiTestConnectionResponse.to_json())

# convert the object into a dict
api_test_connection_response_dict = api_test_connection_response_instance.to_dict()
# create an instance of ApiTestConnectionResponse from a dict
api_test_connection_response_from_dict = ApiTestConnectionResponse.from_dict(api_test_connection_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


