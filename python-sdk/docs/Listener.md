# Listener


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **str** |  | 
**conditions** | [**List[Condition]**](Condition.md) |  | 
**tasks** | [**List[Task]**](Task.md) |  | 

## Example

```python
from kestrapy.models.listener import Listener

# TODO update the JSON string below
json = "{}"
# create an instance of Listener from a JSON string
listener_instance = Listener.from_json(json)
# print the JSON string representation of the object
print(Listener.to_json())

# convert the object into a dict
listener_dict = listener_instance.to_dict()
# create an instance of Listener from a dict
listener_from_dict = Listener.from_dict(listener_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


