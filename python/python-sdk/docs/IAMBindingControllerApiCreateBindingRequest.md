# IAMBindingControllerApiCreateBindingRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**BindingType**](BindingType.md) |  | 
**external_id** | **str** |  | 
**role_id** | **str** |  | 
**namespace_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.iam_binding_controller_api_create_binding_request import IAMBindingControllerApiCreateBindingRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMBindingControllerApiCreateBindingRequest from a JSON string
iam_binding_controller_api_create_binding_request_instance = IAMBindingControllerApiCreateBindingRequest.from_json(json)
# print the JSON string representation of the object
print(IAMBindingControllerApiCreateBindingRequest.to_json())

# convert the object into a dict
iam_binding_controller_api_create_binding_request_dict = iam_binding_controller_api_create_binding_request_instance.to_dict()
# create an instance of IAMBindingControllerApiCreateBindingRequest from a dict
iam_binding_controller_api_create_binding_request_from_dict = IAMBindingControllerApiCreateBindingRequest.from_dict(iam_binding_controller_api_create_binding_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


