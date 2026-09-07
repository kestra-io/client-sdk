# IAMUserControllerApiGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**tenant_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.iam_user_controller_api_group import IAMUserControllerApiGroup

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserControllerApiGroup from a JSON string
iam_user_controller_api_group_instance = IAMUserControllerApiGroup.from_json(json)
# print the JSON string representation of the object
print(IAMUserControllerApiGroup.to_json())

# convert the object into a dict
iam_user_controller_api_group_dict = iam_user_controller_api_group_instance.to_dict()
# create an instance of IAMUserControllerApiGroup from a dict
iam_user_controller_api_group_from_dict = IAMUserControllerApiGroup.from_dict(iam_user_controller_api_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


