# IAMGroupControllerApiGroupDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**description** | **str** |  | 

## Example

```python
from kestrapy.models.iam_group_controller_api_group_detail import IAMGroupControllerApiGroupDetail

# TODO update the JSON string below
json = "{}"
# create an instance of IAMGroupControllerApiGroupDetail from a JSON string
iam_group_controller_api_group_detail_instance = IAMGroupControllerApiGroupDetail.from_json(json)
# print the JSON string representation of the object
print(IAMGroupControllerApiGroupDetail.to_json())

# convert the object into a dict
iam_group_controller_api_group_detail_dict = iam_group_controller_api_group_detail_instance.to_dict()
# create an instance of IAMGroupControllerApiGroupDetail from a dict
iam_group_controller_api_group_detail_from_dict = IAMGroupControllerApiGroupDetail.from_dict(iam_group_controller_api_group_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


