# ApiCreateThreadRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**mode** | [**AgentMode**](AgentMode.md) |  | [optional] 
**title** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.api_create_thread_request import ApiCreateThreadRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiCreateThreadRequest from a JSON string
api_create_thread_request_instance = ApiCreateThreadRequest.from_json(json)
# print the JSON string representation of the object
print(ApiCreateThreadRequest.to_json())

# convert the object into a dict
api_create_thread_request_dict = api_create_thread_request_instance.to_dict()
# create an instance of ApiCreateThreadRequest from a dict
api_create_thread_request_from_dict = ApiCreateThreadRequest.from_dict(api_create_thread_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


