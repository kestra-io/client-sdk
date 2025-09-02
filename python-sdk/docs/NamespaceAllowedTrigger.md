# NamespaceAllowedTrigger


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | 
**flow_id** | **str** |  | 

## Example

```python
from kestra_api_client.models.namespace_allowed_trigger import NamespaceAllowedTrigger

# TODO update the JSON string below
json = "{}"
# create an instance of NamespaceAllowedTrigger from a JSON string
namespace_allowed_trigger_instance = NamespaceAllowedTrigger.from_json(json)
# print the JSON string representation of the object
print(NamespaceAllowedTrigger.to_json())

# convert the object into a dict
namespace_allowed_trigger_dict = namespace_allowed_trigger_instance.to_dict()
# create an instance of NamespaceAllowedTrigger from a dict
namespace_allowed_trigger_from_dict = NamespaceAllowedTrigger.from_dict(namespace_allowed_trigger_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


