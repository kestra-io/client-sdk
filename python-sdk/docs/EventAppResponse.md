# EventAppResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**AppResponse**](AppResponse.md) |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**comment** | **str** |  | [optional] 
**retry** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.event_app_response import EventAppResponse

# TODO update the JSON string below
json = "{}"
# create an instance of EventAppResponse from a JSON string
event_app_response_instance = EventAppResponse.from_json(json)
# print the JSON string representation of the object
print(EventAppResponse.to_json())

# convert the object into a dict
event_app_response_dict = event_app_response_instance.to_dict()
# create an instance of EventAppResponse from a dict
event_app_response_from_dict = EventAppResponse.from_dict(event_app_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


