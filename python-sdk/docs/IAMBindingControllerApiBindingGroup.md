# IAMBindingControllerApiBindingGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.iam_binding_controller_api_binding_group import IAMBindingControllerApiBindingGroup

# TODO update the JSON string below
json = "{}"
# create an instance of IAMBindingControllerApiBindingGroup from a JSON string
iam_binding_controller_api_binding_group_instance = IAMBindingControllerApiBindingGroup.from_json(json)
# print the JSON string representation of the object
print(IAMBindingControllerApiBindingGroup.to_json())

# convert the object into a dict
iam_binding_controller_api_binding_group_dict = iam_binding_controller_api_binding_group_instance.to_dict()
# create an instance of IAMBindingControllerApiBindingGroup from a dict
iam_binding_controller_api_binding_group_from_dict = IAMBindingControllerApiBindingGroup.from_dict(iam_binding_controller_api_binding_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


