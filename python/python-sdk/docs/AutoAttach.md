# AutoAttach


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**states** | [**List[StateType]**](StateType.md) |  | [optional] 

## Example

```python
from kestrapy.models.auto_attach import AutoAttach

# TODO update the JSON string below
json = "{}"
# create an instance of AutoAttach from a JSON string
auto_attach_instance = AutoAttach.from_json(json)
# print the JSON string representation of the object
print(AutoAttach.to_json())

# convert the object into a dict
auto_attach_dict = auto_attach_instance.to_dict()
# create an instance of AutoAttach from a dict
auto_attach_from_dict = AutoAttach.from_dict(auto_attach_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


