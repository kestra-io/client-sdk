# IAMBindingControllerApiBindingDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**binding** | [**Binding**](Binding.md) |  | [optional] 
**role** | [**Role**](Role.md) |  | [optional] 
**user** | [**ApiUser**](ApiUser.md) |  | [optional] 
**group** | [**Group**](Group.md) |  | [optional] 

## Example

```python
from kestrapy.models.iam_binding_controller_api_binding_detail import IAMBindingControllerApiBindingDetail

# TODO update the JSON string below
json = "{}"
# create an instance of IAMBindingControllerApiBindingDetail from a JSON string
iam_binding_controller_api_binding_detail_instance = IAMBindingControllerApiBindingDetail.from_json(json)
# print the JSON string representation of the object
print(IAMBindingControllerApiBindingDetail.to_json())

# convert the object into a dict
iam_binding_controller_api_binding_detail_dict = iam_binding_controller_api_binding_detail_instance.to_dict()
# create an instance of IAMBindingControllerApiBindingDetail from a dict
iam_binding_controller_api_binding_detail_from_dict = IAMBindingControllerApiBindingDetail.from_dict(iam_binding_controller_api_binding_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


