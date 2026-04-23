# IAMBindingControllerApiBindingUser


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**username** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**type** | [**UserType**](UserType.md) |  | [optional] 

## Example

```python
from kestrapy.models.iam_binding_controller_api_binding_user import IAMBindingControllerApiBindingUser

# TODO update the JSON string below
json = "{}"
# create an instance of IAMBindingControllerApiBindingUser from a JSON string
iam_binding_controller_api_binding_user_instance = IAMBindingControllerApiBindingUser.from_json(json)
# print the JSON string representation of the object
print(IAMBindingControllerApiBindingUser.to_json())

# convert the object into a dict
iam_binding_controller_api_binding_user_dict = iam_binding_controller_api_binding_user_instance.to_dict()
# create an instance of IAMBindingControllerApiBindingUser from a dict
iam_binding_controller_api_binding_user_from_dict = IAMBindingControllerApiBindingUser.from_dict(iam_binding_controller_api_binding_user_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


