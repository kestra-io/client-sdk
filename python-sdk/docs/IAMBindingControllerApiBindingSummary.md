# IAMBindingControllerApiBindingSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**type** | [**BindingType**](BindingType.md) |  | [optional] 
**namespace** | **str** |  | [optional] 
**role** | [**IAMBindingControllerApiRole**](IAMBindingControllerApiRole.md) |  | [optional] 
**group** | [**IAMBindingControllerApiBindingGroup**](IAMBindingControllerApiBindingGroup.md) |  | [optional] 
**user** | [**IAMBindingControllerApiBindingUser**](IAMBindingControllerApiBindingUser.md) |  | [optional] 

## Example

```python
from kestrapy.models.iam_binding_controller_api_binding_summary import IAMBindingControllerApiBindingSummary

# TODO update the JSON string below
json = "{}"
# create an instance of IAMBindingControllerApiBindingSummary from a JSON string
iam_binding_controller_api_binding_summary_instance = IAMBindingControllerApiBindingSummary.from_json(json)
# print the JSON string representation of the object
print(IAMBindingControllerApiBindingSummary.to_json())

# convert the object into a dict
iam_binding_controller_api_binding_summary_dict = iam_binding_controller_api_binding_summary_instance.to_dict()
# create an instance of IAMBindingControllerApiBindingSummary from a dict
iam_binding_controller_api_binding_summary_from_dict = IAMBindingControllerApiBindingSummary.from_dict(iam_binding_controller_api_binding_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


