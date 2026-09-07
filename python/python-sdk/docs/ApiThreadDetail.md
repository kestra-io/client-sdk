# ApiThreadDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**mode** | [**AgentMode**](AgentMode.md) |  | [optional] 
**status** | [**AgentThreadStatus**](AgentThreadStatus.md) |  | [optional] 
**pending_confirmation_id** | **str** |  | [optional] 
**messages** | [**List[ApiMessageView]**](ApiMessageView.md) |  | [optional] 

## Example

```python
from kestrapy.models.api_thread_detail import ApiThreadDetail

# TODO update the JSON string below
json = "{}"
# create an instance of ApiThreadDetail from a JSON string
api_thread_detail_instance = ApiThreadDetail.from_json(json)
# print the JSON string representation of the object
print(ApiThreadDetail.to_json())

# convert the object into a dict
api_thread_detail_dict = api_thread_detail_instance.to_dict()
# create an instance of ApiThreadDetail from a dict
api_thread_detail_from_dict = ApiThreadDetail.from_dict(api_thread_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


