# ApiThreadSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**mode** | [**AgentMode**](AgentMode.md) |  | [optional] 
**status** | [**AgentThreadStatus**](AgentThreadStatus.md) |  | [optional] 
**created_at** | **datetime** |  | [optional] 
**updated_at** | **datetime** |  | [optional] 
**last_turn_at** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.api_thread_summary import ApiThreadSummary

# TODO update the JSON string below
json = "{}"
# create an instance of ApiThreadSummary from a JSON string
api_thread_summary_instance = ApiThreadSummary.from_json(json)
# print the JSON string representation of the object
print(ApiThreadSummary.to_json())

# convert the object into a dict
api_thread_summary_dict = api_thread_summary_instance.to_dict()
# create an instance of ApiThreadSummary from a dict
api_thread_summary_from_dict = ApiThreadSummary.from_dict(api_thread_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


