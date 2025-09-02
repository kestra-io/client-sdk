# CreateApiTokenRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**description** | **str** |  | 
**max_age** | **str** |  | 
**extended** | **bool** |  | 

## Example

```python
from kestra_api_client.models.create_api_token_request import CreateApiTokenRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateApiTokenRequest from a JSON string
create_api_token_request_instance = CreateApiTokenRequest.from_json(json)
# print the JSON string representation of the object
print(CreateApiTokenRequest.to_json())

# convert the object into a dict
create_api_token_request_dict = create_api_token_request_instance.to_dict()
# create an instance of CreateApiTokenRequest from a dict
create_api_token_request_from_dict = CreateApiTokenRequest.from_dict(create_api_token_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


