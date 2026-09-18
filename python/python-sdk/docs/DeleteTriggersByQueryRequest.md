# DeleteTriggersByQueryRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | [**List[QueryFilter]**](QueryFilter.md) | Filters. PHP-style nested query is used - examples: &#x60;filters[flowId][EQUALS]&#x3D;hello-world&#x60;, &#x60;filters[namespace][CONTAINS]&#x3D;test&#x60; | [optional] 

## Example

```python
from kestrapy.models.delete_triggers_by_query_request import DeleteTriggersByQueryRequest

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTriggersByQueryRequest from a JSON string
delete_triggers_by_query_request_instance = DeleteTriggersByQueryRequest.from_json(json)
# print the JSON string representation of the object
print(DeleteTriggersByQueryRequest.to_json())

# convert the object into a dict
delete_triggers_by_query_request_dict = delete_triggers_by_query_request_instance.to_dict()
# create an instance of DeleteTriggersByQueryRequest from a dict
delete_triggers_by_query_request_from_dict = DeleteTriggersByQueryRequest.from_dict(delete_triggers_by_query_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


