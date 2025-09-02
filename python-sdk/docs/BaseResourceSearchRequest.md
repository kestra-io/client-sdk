# BaseResourceSearchRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schemas** | **List[str]** |  | [optional] 

## Example

```python
from kestra_api_client.models.base_resource_search_request import BaseResourceSearchRequest

# TODO update the JSON string below
json = "{}"
# create an instance of BaseResourceSearchRequest from a JSON string
base_resource_search_request_instance = BaseResourceSearchRequest.from_json(json)
# print the JSON string representation of the object
print(BaseResourceSearchRequest.to_json())

# convert the object into a dict
base_resource_search_request_dict = base_resource_search_request_instance.to_dict()
# create an instance of BaseResourceSearchRequest from a dict
base_resource_search_request_from_dict = BaseResourceSearchRequest.from_dict(base_resource_search_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


