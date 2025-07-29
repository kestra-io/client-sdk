# InstanceControllerApiActiveServiceList


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total** | **int** |  | [optional] 
**services** | [**List[InstanceControllerApiActiveService]**](InstanceControllerApiActiveService.md) |  | [optional] 

## Example

```python
from kestrapy.models.instance_controller_api_active_service_list import InstanceControllerApiActiveServiceList

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiActiveServiceList from a JSON string
instance_controller_api_active_service_list_instance = InstanceControllerApiActiveServiceList.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiActiveServiceList.to_json())

# convert the object into a dict
instance_controller_api_active_service_list_dict = instance_controller_api_active_service_list_instance.to_dict()
# create an instance of InstanceControllerApiActiveServiceList from a dict
instance_controller_api_active_service_list_from_dict = InstanceControllerApiActiveServiceList.from_dict(instance_controller_api_active_service_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


