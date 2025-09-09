# MeControllerApiTenant


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**logo** | **str** |  | 

## Example

```python
from kestrapy.models.me_controller_api_tenant import MeControllerApiTenant

# TODO update the JSON string below
json = "{}"
# create an instance of MeControllerApiTenant from a JSON string
me_controller_api_tenant_instance = MeControllerApiTenant.from_json(json)
# print the JSON string representation of the object
print(MeControllerApiTenant.to_json())

# convert the object into a dict
me_controller_api_tenant_dict = me_controller_api_tenant_instance.to_dict()
# create an instance of MeControllerApiTenant from a dict
me_controller_api_tenant_from_dict = MeControllerApiTenant.from_dict(me_controller_api_tenant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


