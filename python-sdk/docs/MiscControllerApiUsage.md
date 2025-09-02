# MiscControllerApiUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flows** | [**FlowUsage**](FlowUsage.md) |  | [optional] 
**executions** | [**ExecutionUsage**](ExecutionUsage.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.misc_controller_api_usage import MiscControllerApiUsage

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerApiUsage from a JSON string
misc_controller_api_usage_instance = MiscControllerApiUsage.from_json(json)
# print the JSON string representation of the object
print(MiscControllerApiUsage.to_json())

# convert the object into a dict
misc_controller_api_usage_dict = misc_controller_api_usage_instance.to_dict()
# create an instance of MiscControllerApiUsage from a dict
misc_controller_api_usage_from_dict = MiscControllerApiUsage.from_dict(misc_controller_api_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


